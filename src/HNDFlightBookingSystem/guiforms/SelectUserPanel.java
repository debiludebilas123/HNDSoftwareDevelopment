package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SelectUserPanel extends JPanel {
    private JPanel selectUserPanel;
    private JButton backToMenuButton;
    private JTable selectUserTable;
    private JFrame frame;
    private SelectUserMenuPanel selectUserMenuPanel;

    public SelectUserPanel(JFrame frame, SelectUserMenuPanel selectUserMenuPanel) {
        this.frame = frame;
        this.selectUserMenuPanel = selectUserMenuPanel;

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Customer ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Actions");

        selectUserTable.setModel(tableModel);

        loadDataIntoTable();
        addSelectButtonColumn(tableModel);
        backToMenuButton.addActionListener(e -> PanelSwitcher.switchPanel(selectUserPanel, "MainMenuPanel", frame, 570, 160));
    }

    private void loadDataIntoTable() {
        // gets the selectUserTable to use
        DefaultTableModel tableModel = (DefaultTableModel) selectUserTable.getModel();
        // clears data in table
        tableModel.setRowCount(0);
        // loads data from csv
        try (BufferedReader br = new BufferedReader(new FileReader("customers.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel.addRow(new Object[]{data[0], data[1], data[2], "Select"});
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(selectUserPanel, "Error reading CSV file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addSelectButtonColumn(DefaultTableModel tableModel) {
        if (selectUserTable.getColumn("Actions") == null) {
            throw new IllegalArgumentException("The 'Actions' column does not exist in the table.");
        }

        selectUserTable.getColumn("Actions").setCellRenderer(new TableUtil.ButtonRenderer());
        selectUserTable.getColumn("Actions").setCellEditor(new TableUtil.ButtonEditor(new JCheckBox(), tableModel, "Select", selectUserMenuPanel));
    }

    public JPanel getSelectUserPanel() {
        return selectUserPanel;
    }
}
