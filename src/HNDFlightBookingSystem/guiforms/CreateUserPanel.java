package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import java.awt.*;

public class CreateUserPanel {
    private JLabel createUserMenuLabel;
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JTextField emailInput;
    private JTextField phoneInput;
    private JTextField addressInput;
    private JButton createUserButton;
    private JButton backButton;
    private JPanel createUserPanel;

    public CreateUserPanel(JPanel mainPanel, CardLayout cardLayout) {
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
    }

    public JPanel getCreateUserPanel() {
        return createUserPanel;
    }
}
