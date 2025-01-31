package HNDFlightBookingSystem.guiforms;

import javax.swing.*;

public class MainMenuPanel {
    private JLabel SystemLabel;
    private JPanel mainMenuPanel;
    private JButton createNewUserButton;
    private JButton editUserButton;
    private JButton deleteEditUserButton;
    private JButton exitSystemButton;
    private JFrame frame;

    public MainMenuPanel(JFrame frame) {
        this.frame = frame;
        //Lambda expressions for switching panels
        createNewUserButton.addActionListener(e -> PanelSwitcher.switchPanel(mainMenuPanel, "CreateUserPanel", frame, 400, 370));
        deleteEditUserButton.addActionListener(e -> PanelSwitcher.switchPanel(mainMenuPanel, "DeleteEditUserPanel", frame, 850, 800));
        exitSystemButton.addActionListener(e -> System.exit(0));
    }

    public JPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

}
