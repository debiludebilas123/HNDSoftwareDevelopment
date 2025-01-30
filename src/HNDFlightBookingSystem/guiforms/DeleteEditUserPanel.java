package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DeleteEditUserPanel extends JPanel {
    private JLabel deleteEditUserLabel;
    private JPanel deleteEditUserPanel;
    private JButton backToMenuButton;
    private JTable deleteEditUserTable;
    private JScrollPane deleteEditUserScrollPane;

    public DeleteEditUserPanel() {
        setupTableModel();

        backToMenuButton.addActionListener(e -> PanelSwitcher.switchPanel(deleteEditUserPanel, "MainMenuPanel"));

        loadCSVData("customers.csv");
    }

    private void setupTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
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

    private void loadCSVData(String filePath) {
        DefaultTableModel tableModel = (DefaultTableModel) deleteEditUserTable.getModel();
        tableModel.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], "Edit/Delete"});
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
                    String forename = tableModel.getValueAt(row, 0).toString();
                    String surname = tableModel.getValueAt(row, 1).toString();
                    String email = tableModel.getValueAt(row, 2).toString();
                    String phone = tableModel.getValueAt(row, 3).toString();
                    String address = tableModel.getValueAt(row, 4).toString();

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
                            tableModel.setValueAt(newForename, row, 0);
                            tableModel.setValueAt(newSurname, row, 1);
                            tableModel.setValueAt(newEmail, row, 2);
                            tableModel.setValueAt(newPhone, row, 3);
                            tableModel.setValueAt(newAddress, row, 4);
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

    public JPanel getDeleteEditUserPanel() {
        return deleteEditUserPanel;
    }
}
