package HNDFlightBookingSystem.guiforms;

import javax.swing.*;

public class MainMenuPanel {
    private JLabel SystemLabel;
    private JPanel mainMenuPanel;
    private JButton createNewUserButton;
    private JButton editUserButton;
    private JButton deleteEditUserButton;
    private JButton exitSystemButton;

    public MainMenuPanel() {
        //Lambda expressions for switching panels
        createNewUserButton.addActionListener(e -> PanelSwitcher.switchPanel(mainMenuPanel, "CreateUserPanel"));
        deleteEditUserButton.addActionListener(e -> PanelSwitcher.switchPanel(mainMenuPanel, "DeleteEditUserPanel"));
        exitSystemButton.addActionListener(e -> System.exit(0));
    }

    public JPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

}
