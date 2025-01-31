/*
package HND_Software_Distinct_Project_Flight_Booking_System;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputForm {
    private JPanel flightInputPanel;
    private JTextField flightIDInputBooking;
    private JTextField customerIDInputBooking;
    private JTextField childNoInput;
    private JTextField bookingNoInput;
    private JTextField adultNoInput;
    private JTextField concessionNoInput;
    private JLabel flightIDLabel;
    private JLabel customerIDLabel;
    private JLabel concessionNoLabel;
    private JLabel childNoLabel;
    private JLabel adultNoLabel;
    private JLabel bookingNoLabel;
    private JLabel systemLabel;
    private JButton submitButton;
    private JLabel bookingLabel;
    private JTextField customerIDInput;
    private JTextField forenameInput;
    private JTextField surnameInput;
    private JTextField streetInput;
    private JTextField townInput;
    private JTextField postcodeInput;
    private JTextField arrivalDateInput;
    private JTextField flightIDInput;
    private JTextField departureDateInput;
    private JTextField departureTimeInput;
    private JTextField arrivalTimeInput;
    private JTextField capacityInput;
    private JTextField routeIDInputFlight;
    private JTextField routeIDInput;
    private JTextField departingFromInput;
    private JTextField arrivingAtInput;
    private JTextField middleStopOneInput;
    private JTextField middleStopTwoInput;
    private JLabel flightLabel;
    private JLabel flightIdLabel;
    private JLabel departureDateLabel;
    private JLabel departureTimeLabel;

    public InputForm() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Booking booking = createBooking();
                Customer customer = createCustomer();
                Flight flight = createFlight();
                Route route = createRoute();

                if (customerIsValid(customer.getCustomerID()) && bookingIsValid(booking.getBookingNo(), booking.getCustomerID(),
                        booking.getFlightID()) && routeIsValid(route.getRouteID()) && flightIsValid(flight.getFlightID())) {
                    try {
                        CSVWriter.writeBookingToCsv(booking);
                        CSVWriter.writeCustomerToCsv(customer);
                        CSVWriter.writeFlightToCsv(flight);
                        CSVWriter.writeRouteToCsv(route);
                        JOptionPane.showMessageDialog(flightInputPanel, "Booking saved successfully!");
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(getPanel1(), "Booking failed");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Primary/Foreign keys cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean customerIsValid(String customerID) {
        return !customerID.isEmpty();
    }

    private boolean bookingIsValid(String bookingNo, String customerID, String flightID) {
        return !bookingNo.isEmpty() && !customerID.isEmpty() && !flightID.isEmpty();
    }

    private boolean routeIsValid(String routeID) {
        return !routeID.isEmpty();
    }

    private boolean flightIsValid(String flightID) {
        return !flightID.isEmpty();
    }

    private int parseNumber(JTextField textField, String fieldName) {
        String input = textField.getText();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(fieldName + " is required");
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number for " + fieldName, "Input Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    private LocalDate parseDate(JTextField textField, String fieldName) {
        String input = textField.getText();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(fieldName + " is required");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            return LocalDate.parse(input, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid date format for " + fieldName + ". Please use yyyy-MM-dd.", "Input Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }


    private LocalTime parseTime(JTextField textField, String fieldName) {
        String input = textField.getText();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(fieldName + " is required");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            return LocalTime.parse(input, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid time for " + fieldName, "Input Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }
    }

    private Booking createBooking() {
        String bookingNo = bookingNoInput.getText();
        int adultTicketNo = parseNumber(adultNoInput, "Adult ticket number");
        int childTicketNo = parseNumber(childNoInput, "Child ticket number");
        int concessionTicketNo = parseNumber(concessionNoInput, "Concession ticket number");
        String customerIDBooking = customerIDInputBooking.getText();
        String flightIDBooking = flightIDInputBooking.getText();

        return new Booking(bookingNo, customerIDBooking, adultTicketNo, childTicketNo, concessionTicketNo, flightIDBooking);
    }

    private Flight createFlight() {
        String flightID = flightIDInput.getText();
        LocalDate departureDate = parseDate(departureDateInput, "Departure Date");
        LocalTime departureTime = parseTime(departureTimeInput, "Departure Time");
        String routeIDFlight = routeIDInputFlight.getText();
        LocalDate arrivalDate = parseDate(arrivalDateInput, "Arrival Date");
        LocalTime arrivalTime = parseTime(arrivalTimeInput, "Arrival Time");
        int capacity = parseNumber(capacityInput, "Capacity");

        return new Flight(flightID, departureDate, departureTime, routeIDFlight, arrivalDate, arrivalTime, capacity);
    }

    private Route createRoute() {
        String routeID = routeIDInput.getText();
        String routeName = routeNameInput.getText();

        return new Route(routeID, routeName);
    }


    public JPanel getPanel1() {
        return flightInputPanel;
    }
}
*/