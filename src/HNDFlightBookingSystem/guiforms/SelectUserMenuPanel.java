package HNDFlightBookingSystem.guiforms;

import javax.swing.*;

public class SelectUserMenuPanel {
    private JButton createBookingButton;
    private JButton deleteEditBookingButton;
    private JLabel SystemLabel;
    private JPanel selectUserMenuPanel;
    private JButton backToMenuButton;
    private JLabel selectUserMenuSpecifiedUserLabel;
    private JFrame frame;

    public SelectUserMenuPanel(JFrame frame) {
        this.frame = frame;

        createBookingButton.addActionListener(e -> PanelSwitcher.switchPanel(selectUserMenuPanel, "CreateBookingPanel", frame, 400, 570));
        deleteEditBookingButton.addActionListener(e -> PanelSwitcher.switchPanel(selectUserMenuPanel, "DeleteEditBookingPanel", frame, 1500, 800));
        backToMenuButton.addActionListener(e -> PanelSwitcher.switchPanel(selectUserMenuPanel, "MainMenuPanel", frame, 540, 140));
    }

    public JPanel getSelectUserMenuPanel() {
        return selectUserMenuPanel;
    }

    public JLabel getSelectUserMenuSpecifiedUserLabel() {
        return selectUserMenuSpecifiedUserLabel;
    }
}
