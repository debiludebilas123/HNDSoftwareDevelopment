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
                int adultTicketNo = Integer.parseInt(adultNoInput.getText());
                int childTicketNo = Integer.parseInt(childNoInput.getText());
                int concessionTicketNo = Integer.parseInt(concessionNoInput.getText());
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
                int capacity = Integer.parseInt(capacityInput.getText());

                Flight flight = new Flight(flightID, departureDate, departureTime, routeIDFlight, arrivalDate, arrivalTime, capacity);

                String routeID = routeIDInput.getText();
                String departFrom = departingFromInput.getText();
                String arriveAt = arrivingAtInput.getText();
                String midStopOne = middleStopOneInput.getText();
                String midStopTwo = middleStopTwoInput.getText();

                Route route = new Route(routeID, departFrom, arriveAt, midStopOne, midStopTwo);


                /*if (isValid(bookingNo, adultTicketNo, childTicketNo, concessionTicketNo, customerID, flightID)) {
                    String[] bookingData = {bookingNo, Integer.toString(adultTicketNo), Integer.toString(childTicketNo),
                            Integer.toString(concessionTicketNo), customerID, flightID};
                    NewCSVWriter.writeToCsv("booking.csv", bookingData);
                    JOptionPane.showMessageDialog(getPanel1(), "Booking successful");
                } else {
                    JOptionPane.showMessageDialog(getPanel1(), "Booking failed");
                }*/
                try {
                    NewCSVWriter.writeBookingToCsv(booking);
                    NewCSVWriter.writeCustomerToCsv(customer);
                    NewCSVWriter.writeFlightToCsv(flight);
                    NewCSVWriter.writeRouteToCsv(route);
                    JOptionPane.showMessageDialog(flightInputPanel, "Booking saved successfully!");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(getPanel1(), "Booking failed");
                }
            }
        });
    }

    private boolean isValid(String bookingNo, int adultTicketNo, int childTicketNo, int concessionTicketNo, String customerID, String flightID) {
        return true;
    }

    public JPanel getPanel1() {
        return flightInputPanel;
    }
}

