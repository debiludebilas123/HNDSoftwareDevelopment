package HNDFlightBookingSystem.guiforms;

import javax.swing.*;

public class DeleteEditBookingPanel {
    private JTable deleteEditBookingTable;
    private JButton backToMenuButton;
    private JLabel deleteEditBookingMenuLabel;
    private JScrollPane deleteEditBookingScrollPane;
    private JPanel deleteEditBookingPanel;
    private JButton saveChangesButton;
    private JFrame frame;

    public DeleteEditBookingPanel(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getDeleteEditBookingPanel() {
        return deleteEditBookingPanel;
    }
}
