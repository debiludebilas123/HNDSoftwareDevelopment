package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        deleteEditUserTable.getColumn("Actions").setCellRenderer(new ButtonRenderer());
        deleteEditUserTable.getColumn("Actions").setCellEditor(new ButtonEditor(new JCheckBox(), tableModel));
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

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;
        private DefaultTableModel tableModel;

        public ButtonEditor(JCheckBox checkBox, DefaultTableModel tableModel) {
            super(checkBox);
            this.tableModel = tableModel;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                int row = deleteEditUserTable.getEditingRow();
                int confirm = JOptionPane.showConfirmDialog(DeleteEditUserPanel.this, "Do you want to delete this row?",
                        "Edit/Delete", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    String forename = tableModel.getValueAt(row, 1).toString();
                    String surname = tableModel.getValueAt(row, 2).toString();
                    String email = tableModel.getValueAt(row, 3).toString();
                    String phone = tableModel.getValueAt(row, 4).toString();
                    String address = tableModel.getValueAt(row, 5).toString();

                    String newForename = JOptionPane.showInputDialog(DeleteEditUserPanel.this, "Edit First Name:", forename);
                    String newSurname = JOptionPane.showInputDialog(DeleteEditUserPanel.this, "Edit Last Name:", surname);
                    String newEmail = JOptionPane.showInputDialog(DeleteEditUserPanel.this, "Edit Email:", email);
                    String newPhone = JOptionPane.showInputDialog(DeleteEditUserPanel.this, "Edit Phone:", phone);
                    String newAddress = JOptionPane.showInputDialog(DeleteEditUserPanel.this, "Edit Address:", address);

                    if (newForename != null && newSurname != null && newEmail != null && newPhone != null && newAddress != null) {
                        if (newForename.trim().isEmpty() || newSurname.trim().isEmpty() || newEmail.trim().isEmpty() || newPhone.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(DeleteEditUserPanel.this, "None of the inputs can be empty.",
                                    "Validation Error", JOptionPane.ERROR_MESSAGE);
                        } else if (!newEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                            JOptionPane.showMessageDialog(DeleteEditUserPanel.this,
                                    "Invalid Email Address", "Validation Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            tableModel.setValueAt(newForename, row, 1);
                            tableModel.setValueAt(newSurname, row, 2);
                            tableModel.setValueAt(newEmail, row, 3);
                            tableModel.setValueAt(newPhone, row, 4);
                            tableModel.setValueAt(newAddress, row, 5);
                        }
                    }
                } else {
                    tableModel.removeRow(row);
                }
            }
            isPushed = false;
            return label;
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
