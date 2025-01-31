package HNDFlightBookingSystem.guiforms;

import javax.swing.*;

public class SelectUserPanel {
    private JPanel selectUserPanel;
    private JButton backToMenuButton;
    private JTable selectUserTable;
    private JFrame frame;

    public SelectUserPanel(JFrame frame) {
        this.frame = frame;

        backToMenuButton.addActionListener(e -> PanelSwitcher.switchPanel(selectUserPanel, "MainMenuPanel", frame, 540, 140));

    }

    public JPanel getSelectUserPanel() {
        return selectUserPanel;
    }
}
