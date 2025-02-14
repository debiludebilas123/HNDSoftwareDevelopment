package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableUtil {
    public static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public static class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;
        private JTable table;
        private DefaultTableModel tableModel;
        private String mode;
        private SelectUserMenuPanel selectUserMenuPanel;

        public ButtonEditor(JCheckBox checkBox, DefaultTableModel tableModel, String mode, SelectUserMenuPanel selectUserMenuPanel) {
            super(checkBox);
            this.tableModel = tableModel;
            this.mode = mode;
            this.selectUserMenuPanel = selectUserMenuPanel;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public ButtonEditor(JCheckBox checkBox, DefaultTableModel tableModel, String mode) {
            super(checkBox);
            this.tableModel = tableModel;
            this.mode = mode;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.table = table;
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                // Handle button click action here
                int selectedRow = table.getEditingRow();
                if ("Select".equals(mode)) {
                    String customerId = (String) tableModel.getValueAt(selectedRow, 0);
                    String forename = (String) tableModel.getValueAt(selectedRow, 1);
                    String surname = (String) tableModel.getValueAt(selectedRow, 2);

                    selectUserMenuPanel.getSelectUserMenuSpecifiedUserLabel().setText("<html>↓ Managing bookings of user ↓<br>Customer ID: " + customerId +
                                                                                      "<br>Forename: " + forename + "<br>Surname: " + surname + "</html>");
                    // Find the parent JPanel with CardLayout
                    Container parent = table.getParent();
                    while (parent != null && !(parent instanceof JPanel)) {
                        parent = parent.getParent();
                    }

                    if (parent != null) {
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(table);
                        PanelSwitcher.switchPanel((JPanel) parent, "SelectUserMenuPanel", frame, 500, 320);
                    } else {
                        System.err.println("Parent JPanel not found!");
                    }
                } else if ("Edit/Delete".equals(mode)) {
                    String[] options = {"Edit", "Delete", "Cancel"};
                    int choice = JOptionPane.showOptionDialog(button, "Choose an action:",
                            "Edit/Delete Customer", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (choice == 0) {
                        String forename = (String) tableModel.getValueAt(selectedRow, 1);
                        String surname = (String) tableModel.getValueAt(selectedRow, 2);
                        String email = (String) tableModel.getValueAt(selectedRow, 3);
                        String phone = (String) tableModel.getValueAt(selectedRow, 4);
                        String address = (String) tableModel.getValueAt(selectedRow, 5);

                        // Create a dialog for editing
                        JPanel editPanel = new JPanel(new GridLayout(6, 2));
                        JTextField forenameField = new JTextField(forename);
                        JTextField surnameField = new JTextField(surname);
                        JTextField emailField = new JTextField(email);
                        JTextField phoneField = new JTextField(phone);
                        JTextField addressField = new JTextField(address);

                        editPanel.add(new JLabel("First Name:"));
                        editPanel.add(forenameField);
                        editPanel.add(new JLabel("Last Name:"));
                        editPanel.add(surnameField);
                        editPanel.add(new JLabel("Email:"));
                        editPanel.add(emailField);
                        editPanel.add(new JLabel("Phone:"));
                        editPanel.add(phoneField);
                        editPanel.add(new JLabel("Address:"));
                        editPanel.add(addressField);

                        int result = JOptionPane.showConfirmDialog(button, editPanel, "Edit Customer",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            // Update the table model with new values
                            tableModel.setValueAt(forenameField.getText(), selectedRow, 1);
                            tableModel.setValueAt(surnameField.getText(), selectedRow, 2);
                            tableModel.setValueAt(emailField.getText(), selectedRow, 3);
                            tableModel.setValueAt(phoneField.getText(), selectedRow, 4);
                            tableModel.setValueAt(addressField.getText(), selectedRow, 5);
                        }
                    } else if (choice == 1) { // Delete
                        int confirm = JOptionPane.showConfirmDialog(button, "Are you sure you want to delete this customer?",
                                "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            // Remove the row from the table model
                            tableModel.removeRow(selectedRow);
                        }
                    }
                }
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();

        }
    }
}

