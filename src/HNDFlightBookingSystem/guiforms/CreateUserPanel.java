package HNDFlightBookingSystem.guiforms;

import HNDFlightBookingSystem.classes.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateUserPanel {

    private JLabel createUserMenuLabel;
    private JTextField forenameInput;
    private JTextField surnameInput;
    private JTextField emailInput;
    private JTextField phoneInput;
    private JTextField addressInput;
    private JButton createUserButton;
    private JButton backToMenuButton;
    private JPanel createUserPanel;
    private JTable customerTable;
    private JFrame frame;

    // Getting the edit/delete table and action listeners for the buttons to switch between panels and to add the customer into storage
    public CreateUserPanel(JFrame frame, JTable customerTable) {
        this.customerTable = customerTable;
        this.frame = frame;
        backToMenuButton.addActionListener(e -> PanelSwitcher.switchPanel(createUserPanel, "MainMenuPanel", frame, 540, 140));
        createUserButton.addActionListener(e -> {
            Customer customer = createCustomer();
            JOptionPane.showMessageDialog(this.getCreateUserPanel(), "You have successfully made a user.", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Adding/saving the customer into table and csv file
            assert customer != null;
            addCustomerToTable(customer);
            saveCustomerToCSV(customer);
            clearInputFields();
        });
    }

    public JPanel getCreateUserPanel() {
        return createUserPanel;
    }

    // Creates a customer object using the entered data
    private Customer createCustomer() {
        String customerID = generateCustomerID();
        String forename = forenameInput.getText();
        String surname = surnameInput.getText();
        String email = emailInput.getText();
        String phone = phoneInput.getText();
        String address = addressInput.getText();

        // Input validation for if it's empty
        if (forename.isEmpty() || surname.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!isEmailValid(email)) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!isPhoneValidUK(phone)) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new Customer(customerID, forename, surname, email, phone, address);
    }

    private boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isPhoneValidUK(String number) {
        String phoneRegex = "^(\\+44|0)\\d{10}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    // Generates a customerID automatically by making sure it's not duplicate using the edit/delete table data
    private String generateCustomerID() {
        String prefix = "CUST-";
        int nextNumber = 1;

        DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String existingID = (String) tableModel.getValueAt(row, 0);
            if (existingID.startsWith(prefix)) {
                try {
                    int existingNumber = Integer.parseInt(existingID.substring(prefix.length()));
                    if (existingNumber >= nextNumber) {
                        nextNumber = existingNumber + 1;
                    }
                } catch (NumberFormatException _) {
                }
            }
        }

        return prefix + String.format("%05d", nextNumber);
    }

    // Adds entries into my edit/delete table
    private void addCustomerToTable(Customer customer) {
        DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
        tableModel.addRow(new Object[]{
                customer.getCustomerID(),
                customer.getForename(),
                customer.getSurname(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress()
        });
    }

    // Saves the customer data which was inputted into the create user panel by appending it into customers.csv
    private void saveCustomerToCSV(Customer customer) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("customers.csv", true))) {
            bw.write(String.join(",",
                    customer.getCustomerID(),
                    customer.getForename(),
                    customer.getSurname(),
                    customer.getEmail(),
                    customer.getPhone(),
                    customer.getAddress(),
                    "\n"
            ));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.getCreateUserPanel(), "Error while saving customer to CSV file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clears all the fields by setting them to blank
    private void clearInputFields() {
        forenameInput.setText("");
        surnameInput.setText("");
        emailInput.setText("");
        phoneInput.setText("");
        addressInput.setText("");
    }


}
