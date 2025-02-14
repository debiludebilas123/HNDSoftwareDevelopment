package HNDFlightBookingSystem;

import HNDFlightBookingSystem.guiforms.*;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Flight Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(570, 160);  // Set initial size
        frame.setLocationRelativeTo(null);

        // Create a JPanel with CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Create instances of your GUI forms
        MainMenuPanel mainMenuPanel = new MainMenuPanel(frame);
        DeleteEditUserPanel deleteEditUserPanel = new DeleteEditUserPanel(frame);
        CreateUserPanel createUserPanel = new CreateUserPanel(frame, deleteEditUserPanel.getDeleteEditUserTable());
        SelectUserMenuPanel selectUserMenuPanel = new SelectUserMenuPanel(frame);
        SelectUserPanel selectUserPanel = new SelectUserPanel(frame, selectUserMenuPanel);
        DeleteEditBookingPanel deleteEditBookingPanel = new DeleteEditBookingPanel(frame);
        CreateBookingPanel createBookingPanel = new CreateBookingPanel(frame, deleteEditBookingPanel.getDeleteEditBookingTable());

        // Add panels to CardLayout container
        mainPanel.add(mainMenuPanel.getMainMenuPanel(), "MainMenuPanel");
        mainPanel.add(createUserPanel.getCreateUserPanel(), "CreateUserPanel");
        mainPanel.add(deleteEditUserPanel.getDeleteEditUserPanel(), "DeleteEditUserPanel");
        mainPanel.add(selectUserPanel.getSelectUserPanel(), "SelectUserPanel");
        mainPanel.add(selectUserMenuPanel.getSelectUserMenuPanel(), "SelectUserMenuPanel");
        mainPanel.add(createBookingPanel.getCreateBookingPanel(), "CreateBookingPanel");
        mainPanel.add(deleteEditBookingPanel.getDeleteEditBookingPanel(), "DeleteEditBookingPanel");

        // Add mainPanel to frame
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}
