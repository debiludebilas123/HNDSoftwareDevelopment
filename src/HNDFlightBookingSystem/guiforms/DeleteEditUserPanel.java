package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class DeleteEditUserPanel extends JPanel {
    private JLabel deleteEditUserLabel;
    private JPanel deleteEditUserPanel;
    private JButton backToMenuButton;
    private JTable deleteEditUserTable;
    private JScrollPane deleteEditUserScrollPane;
    private JButton saveChangesButton;
    private JFrame frame;

    public DeleteEditUserPanel(JFrame frame) {
        this.frame = frame;
        setupTableModel();

        backToMenuButton.addActionListener(e -> PanelSwitcher.switchPanel(deleteEditUserPanel, "MainMenuPanel", frame, 540, 140));
        saveChangesButton.addActionListener(e -> saveChangesToCSV());

        loadCSVData();
    }

    private void setupTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Customer ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Address");
        tableModel.addColumn("Actions");

        deleteEditUserTable.setModel(tableModel);
        addActionButtons(tableModel);
    }

    private void addActionButtons(DefaultTableModel tableModel) {
        deleteEditUserTable.getColumn("Actions").setCellRenderer(new TableUtil.ButtonRenderer());
        deleteEditUserTable.getColumn("Actions").setCellEditor(new TableUtil.ButtonEditor(new JCheckBox(), tableModel));
    }

    private void loadCSVData() {
        DefaultTableModel tableModel = (DefaultTableModel) deleteEditUserTable.getModel();
        tableModel.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader("customers.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], "Edit/Delete"});
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while reading CSV file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveChangesToCSV() {
        DefaultTableModel tableModel = (DefaultTableModel) deleteEditUserTable.getModel();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("customers.csv"))) {
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                StringBuilder sb = new StringBuilder();
                for (int col = 1; col < tableModel.getColumnCount() - 1; col++) {
                    sb.append(tableModel.getValueAt(row, col));
                    if (col < tableModel.getColumnCount() - 2) {
                        sb.append(",");
                    }
                }
                bw.write(sb.toString());
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Changes saved successfully.",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while saving to CSV file",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getDeleteEditUserPanel() {
        return deleteEditUserPanel;
    }

    public JTable getDeleteEditUserTable() {
        return deleteEditUserTable;
    }
}
