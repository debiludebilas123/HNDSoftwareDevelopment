package HNDFlightBookingSystem.guiforms;

import HNDFlightBookingSystem.classes.Booking;
import HNDFlightBookingSystem.classes.Flight;
import HNDFlightBookingSystem.classes.Route;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateBookingPanel {
    private JButton menuButton;
    private JPanel createBookingPanel;
    private JTextField cBDepartureTimeInput;
    private JTextField cBDepartureDateInput;
    private JButton cBButton;
    private JTextField cBDateInput;
    private JTextField cBFlightNumInput;
    private JTextField cBArrivalDateInput;
    private JTextField cBArrivalTimeInput;
    private JComboBox<String> cBDepartureComboBox;
    private JComboBox<String> cBArrivalComboBox;
    private JLabel cBRouteLabel;
    private JFrame frame;
    private JTable bookingTable;

    public CreateBookingPanel(JFrame frame, JTable bookingTable) {
        this.frame = frame;
        this.bookingTable = bookingTable;
        fillComboBox();

        menuButton.addActionListener(e -> PanelSwitcher.switchPanel(createBookingPanel, "SelectUserMenuPanel", frame, 500, 320));
        cBButton.addActionListener(e -> {
            Booking booking = createBooking();
            Route route = createRoute();
            Flight flight = createFlight();

            addAllToTable(booking, flight, route);
            saveBookingToCSV(booking);
            saveRouteToCSV(route);
            saveFlightToCSV(flight);
            JOptionPane.showMessageDialog(this.getCreateBookingPanel(), "You have successfully made a booking.", "Success", JOptionPane.INFORMATION_MESSAGE);

            clearInputFields();
        });
    }

    private void fillComboBox() {
        String[] arriving = {"IBZ","LHR","EDI","CHQ","MAN","ARN","LAX","GLA","LIS","DUB"};
        String[] departing = {"ATH","MNX","VNO","SAW","NAP","STN","HEL","BRS","BFS","LGW"};

        for (String option : arriving) {
            cBArrivalComboBox.addItem(option);
        }

        for (String option : departing) {
            cBDepartureComboBox.addItem(option);
        }

        cBArrivalComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    updateLabel();
                }
            }
        });

        cBDepartureComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    updateLabel();
                }
            }
        });
    }

    public void updateLabel() {
        String value1 = (String) cBDepartureComboBox.getSelectedItem();
        String value2 = (String) cBArrivalComboBox.getSelectedItem();

        cBRouteLabel.setText("Selected Route: " + value1 + " - " + value2);
    }

    private void addAllToTable(Booking booking, Flight flight, Route route) {
        DefaultTableModel tableModel = (DefaultTableModel) bookingTable.getModel();
        tableModel.addRow(new Object[]{
                booking.getBookingID(),
                booking.getBookingDate(),
                flight.getFlightID(),
                flight.getFlightNumber(),
                flight.getDepartureAirport(),
                flight.getArrivalAirport(),
                flight.getDepartureDate(),
                flight.getDepartureTime(),
                flight.getArrivalDate(),
                flight.getArrivalTime(),
                route.getRouteID(),
                route.getRouteName()
        });
    }

    private Booking createBooking() {
        String bookingID = generateIDs("booking");
        LocalDate bookingDate = LocalDate.parse(cBDateInput.getText());

        if (cBDateInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new Booking(bookingID, bookingDate);
    }

    private Route createRoute() {
        String routeID = generateIDs("route");
        String routeName = cBDepartureComboBox.getSelectedItem() + " - " + cBArrivalComboBox.getSelectedItem();

        return new Route(routeID, routeName);
    }

    private Flight createFlight() {
        String flightID = generateIDs("flight");
        String flightNum = cBFlightNumInput.getText();
        String departureAirport = (String) cBDepartureComboBox.getSelectedItem();
        String arrivalAirport = (String) cBArrivalComboBox.getSelectedItem();
        LocalDate departureDate = LocalDate.parse(cBDepartureDateInput.getText());
        LocalTime departureTime = LocalTime.parse(cBDepartureTimeInput.getText());
        LocalDate arrivalDate = LocalDate.parse(cBArrivalDateInput.getText());
        LocalTime arrivalTime = LocalTime.parse(cBArrivalTimeInput.getText());

        if  (flightNum.isEmpty() || cBDepartureDateInput.getText().isEmpty() || cBDepartureTimeInput.getText().isEmpty() ||
             cBArrivalDateInput.getText().isEmpty() || cBArrivalTimeInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new Flight(flightID, flightNum, departureAirport, arrivalAirport, departureDate, departureTime, arrivalDate, arrivalTime);
    }

    private String generateID(String prefix, int columnIndex) {
        int nextNumber = 1;

        DefaultTableModel tableModel = (DefaultTableModel) bookingTable.getModel();
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String existingID1 = (String) tableModel.getValueAt(row, columnIndex);

            if (existingID1.startsWith(prefix)) {
                try {
                    int existingNumber = Integer.parseInt(existingID1.substring(prefix.length()));
                    if (existingNumber >= nextNumber) {
                        nextNumber = existingNumber + 1;
                    }
                } catch (NumberFormatException _) {

                }
            }
        }

        return prefix + String.format("%05d", nextNumber);
    }

    private String generateIDs(String type) {
        switch (type) {
            case "booking" -> {
                return generateID("BK-",0);
            }
            case "route" -> {
                return generateID("RT-",10);
            }
            case "flight" -> {
                return generateID("FL-",2);
            }
        }
        return null;
    }

    private void saveBookingToCSV(Booking booking) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("booking.csv", true))) {
            bw.write(String.join(",",
                    booking.getBookingID(),
                    booking.getBookingDate().format(dateFormatter),
                    "\n"
            ));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.getCreateBookingPanel(), "Error while saving booking to CSV file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveRouteToCSV(Route route) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("route.csv", true))) {
            bw.write(String.join(",",
                    route.getRouteID(),
                    route.getRouteName(),
                    "\n"
            ));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.getCreateBookingPanel(), "Error while saving route to CSV file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFlightToCSV(Flight flight) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("flight.csv", true))) {
            bw.write(String.join(",",
                    flight.getFlightID(),
                    flight.getFlightNumber(),
                    flight.getDepartureAirport(),
                    flight.getArrivalAirport(),
                    flight.getDepartureDate().format(dateFormatter),
                    flight.getDepartureTime().format(timeFormatter),
                    flight.getArrivalDate().format(dateFormatter),
                    flight.getArrivalTime().format(timeFormatter),
                    "\n"
            ));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.getCreateBookingPanel(), "Error while saving flight to CSV file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearInputFields() {
        cBDepartureDateInput.setText("");
        cBDepartureTimeInput.setText("");
        cBArrivalDateInput.setText("");
        cBArrivalTimeInput.setText("");
        cBFlightNumInput.setText("");
        cBDateInput.setText("");
    }

    public JPanel getCreateBookingPanel() {
        return createBookingPanel;
    }

}
