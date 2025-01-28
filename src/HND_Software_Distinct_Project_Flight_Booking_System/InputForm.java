package HND_Software_Distinct_Project_Flight_Booking_System;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                String bookingNo = bookingNoInput.getText();
                int adultTicketNo = parseNumber(adultNoInput, "Adult ticket number");
                int childTicketNo = parseNumber(childNoInput, "Child ticket number");
                int concessionTicketNo = parseNumber(concessionNoInput, "Concession ticket number");

                String customerIDBooking = customerIDInputBooking.getText();
                String flightIDBooking = flightIDInputBooking.getText();

                Booking booking = new Booking(bookingNo, customerIDBooking, adultTicketNo, childTicketNo, concessionTicketNo, flightIDBooking);

                String customerID = customerIDInput.getText();
                String forename = forenameInput.getText();
                String surname = surnameInput.getText();
                String street = streetInput.getText();
                String town = townInput.getText();
                String postcode = postcodeInput.getText();

                Customer customer = new Customer(customerID, forename, surname, street, town, postcode);

                String flightID = flightIDInput.getText();
                String departureDate = departureDateInput.getText();
                String departureTime = departureTimeInput.getText();
                String routeIDFlight = routeIDInputFlight.getText();
                String arrivalDate = arrivalDateInput.getText();
                String arrivalTime = arrivalTimeInput.getText();
                int capacity = parseNumber(capacityInput, "Capacity");

                Flight flight = new Flight(flightID, departureDate, departureTime, routeIDFlight, arrivalDate, arrivalTime, capacity);

                String routeID = routeIDInput.getText();
                String departFrom = departingFromInput.getText();
                String arriveAt = arrivingAtInput.getText();
                String midStopOne = middleStopOneInput.getText();
                String midStopTwo = middleStopTwoInput.getText();

                Route route = new Route(routeID, departFrom, arriveAt, midStopOne, midStopTwo);

                if (customerIsValid(customer.getCustomerID()) || bookingIsValid(booking.getBookingNo(), booking.getCustomerID(),
                        booking.getFlightID()) || routeIsValid(route.getRouteID()) || flightIsValid(flight.getFlightID())) {
                    try {
                        CSVWriter.writeBookingToCsv(booking);
                        CSVWriter.writeCustomerToCsv(customer);
                        CSVWriter.writeFlightToCsv(flight);
                        CSVWriter.writeRouteToCsv(route);
                        JOptionPane.showMessageDialog(flightInputPanel, "Booking saved successfully!");
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(getPanel1(), "Booking failed");
                    }
                }
            }
        });
    }

    private boolean customerIsValid(String customerID) {
        return !customerID.isBlank();
    }

    private boolean bookingIsValid(String bookingNo, String customerID, String flightID) {
        return !bookingNo.isBlank() && !customerID.isBlank() && !flightID.isBlank();
    }

    private boolean routeIsValid(String routeID) {
        return !routeID.isBlank();
    }

    private boolean flightIsValid(String flightID) {
        return !flightID.isBlank();
    }

    private int parseNumber(JTextField textField, String fieldName) {
        String input = textField.getText();
        if (input.isBlank()) {
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


    public JPanel getPanel1() {
        return flightInputPanel;
    }
}

