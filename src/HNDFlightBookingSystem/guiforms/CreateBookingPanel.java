package HNDFlightBookingSystem.guiforms;

import javax.swing.*;

public class CreateBookingPanel {
    private JButton backToMenuButton;
    private JTextField createBookingRouteInput;
    private JPanel createBookingPanel;
    private JLabel createBookingRouteLabel;
    private JLabel createBookingDepartureAirportLabel;
    private JLabel createBookingArrivalAirportLabel;
    private JLabel createBookingDepartureDateLabel;
    private JLabel createBookingDepartureTimeLabel;
    private JTextField createBookingDepartureTimeInput;
    private JTextField createBookingDepartureDateInput;
    private JTextField createBookingArrivalAirportInput;
    private JTextField createBookingDepartureAirportInput;
    private JLabel createBookingMenuLabel;
    private JFrame frame;

    public CreateBookingPanel(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getCreateBookingPanel() {
        return createBookingPanel;
    }
}
