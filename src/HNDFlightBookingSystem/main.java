package HNDFlightBookingSystem;

import HNDFlightBookingSystem.guiforms.CreateUserPanel;
import HNDFlightBookingSystem.guiforms.DeleteEditUserPanel;
import HNDFlightBookingSystem.guiforms.MainMenuPanel;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Flight Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  // Set initial size

        // Create a JPanel with CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Create instances of your GUI forms
        MainMenuPanel mainMenuPanel = new MainMenuPanel();
        CreateUserPanel createUserPanel = new CreateUserPanel();
        DeleteEditUserPanel deleteEditUserPanel = new DeleteEditUserPanel();

        // Add panels to CardLayout container
        mainPanel.add(mainMenuPanel.getMainMenuPanel(), "MainMenuPanel");
        mainPanel.add(createUserPanel.getCreateUserPanel(), "CreateUserPanel");
        mainPanel.add(deleteEditUserPanel.getDeleteEditUserPanel(), "DeleteEditUserPanel");

        // Add mainPanel to frame
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}
