package HNDFlightBookingSystem.guiforms;

import javax.swing.*;

public class CreateUserPanel {

    private JLabel createUserMenuLabel;
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JTextField emailInput;
    private JTextField phoneInput;
    private JTextField addressInput;
    private JButton createUserButton;
    private JButton backToMenuButton;
    private JPanel createUserPanel;

    public CreateUserPanel() {
        backToMenuButton.addActionListener(e -> PanelSwitcher.switchPanel(createUserPanel, "MainMenuPanel"));
    }

    public JPanel getCreateUserPanel() {
        return createUserPanel;
    }
}
