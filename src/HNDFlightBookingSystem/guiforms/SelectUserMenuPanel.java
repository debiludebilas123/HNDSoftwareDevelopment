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
    }

    public JPanel getSelectUserMenuPanel() {
        return selectUserMenuPanel;
    }

    public JLabel getSelectUserMenuSpecifiedUserLabel() {
        return selectUserMenuSpecifiedUserLabel;
    }
}
