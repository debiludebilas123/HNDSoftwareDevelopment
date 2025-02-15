package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteEditBookingPanel extends JPanel {
    private JTable deleteEditBookingTable;
    private JButton backToMenuButton;
    private JLabel deleteEditBookingMenuLabel;
    private JScrollPane deleteEditBookingScrollPane;
    private JPanel deleteEditBookingPanel;
    private JButton saveChangesButton;
    private JFrame frame;

    public DeleteEditBookingPanel(JFrame frame) {
        this.frame = frame;

        setupTableModel();
        loadCSVData();

        backToMenuButton.addActionListener(e -> PanelSwitcher.switchPanel(deleteEditBookingPanel, "SelectUserMenuPanel", frame, 500, 320));
        saveChangesButton.addActionListener(e -> saveChangesToCSV());
    }

    private void setupTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Booking ID");
        tableModel.addColumn("Booking Date");
        tableModel.addColumn("Flight ID");
        tableModel.addColumn("Flight Number");
        tableModel.addColumn("Departure Airport");
        tableModel.addColumn("Arrival Airport");
        tableModel.addColumn("Departure Date");
        tableModel.addColumn("Departure Time");
        tableModel.addColumn("Arrival Date");
        tableModel.addColumn("Arrival Time");
        tableModel.addColumn("Route ID");
        tableModel.addColumn("Route Name");
        tableModel.addColumn("Actions");

        deleteEditBookingTable.setModel(tableModel);
        addActionButtons(tableModel);
    }

    private void addActionButtons(DefaultTableModel tableModel) {
        deleteEditBookingTable.getColumn("Actions").setCellRenderer(new TableUtil.ButtonRenderer());
        deleteEditBookingTable.getColumn("Actions").setCellEditor(new TableUtil.ButtonEditor(new JCheckBox(), tableModel, "Edit/Delete"));
    }

    private void loadCSVData() {
        DefaultTableModel tableModel = (DefaultTableModel) deleteEditBookingTable.getModel();
        tableModel.setRowCount(0); // Clear the table before loading new data

        // Step 1: Read all three files into lists
        List<String[]> bookingData = readCSV("booking.csv");
        List<String[]> flightData = readCSV("flight.csv");
        List<String[]> routeData = readCSV("route.csv");

        // Step 2: Ensure all files have the same number of rows
        int rowCount = Math.min(bookingData.size(), Math.min(flightData.size(), routeData.size()));
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "One or more CSV files are empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Step 3: Combine data and add rows to the table
        for (int i = 0; i < rowCount; i++) {
            String[] bookingRow = bookingData.get(i);
            String[] flightRow = flightData.get(i);
            String[] routeRow = routeData.get(i);

            // Ensure each row has the expected number of columns
            if (bookingRow.length >= 2 && flightRow.length >= 8 && routeRow.length >= 2) {
                // Combine data into a single row
                Object[] row = new Object[12];
                row[0] = bookingRow[0]; // Booking ID
                row[1] = bookingRow[1]; // Booking Date
                row[2] = flightRow[0];  // Flight ID
                row[3] = flightRow[1];  // Flight Number
                row[4] = flightRow[2];  // Departure Airport
                row[5] = flightRow[3];  // Arrival Airport
                row[6] = flightRow[4];  // Departure Date
                row[7] = flightRow[5];  // Departure Time
                row[8] = flightRow[6];  // Arrival Date
                row[9] = flightRow[7];  // Arrival Time
                row[10] = routeRow[0];  // Route ID
                row[11] = routeRow[1];  // Route Name

                // Add the row to the table
                tableModel.addRow(row);
            } else {
                System.err.println("Skipping invalid row at index " + i);
            }
        }
    }

    // Helper method to read a CSV file into a list of String arrays
    private List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while reading " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }

    private void saveChangesToCSV() {
        DefaultTableModel tableModel = (DefaultTableModel) deleteEditBookingTable.getModel();

        String[][] filesAndRanges = {
                {"booking.csv", "0-2"},
                {"flight.csv", "2-10"},
                {"route.csv", "10-12"},
        };

        for (String[] fileData : filesAndRanges) {
            String fileName = fileData[0];
            String[] range = fileData[1].split("-");
            int startCol = Integer.parseInt(range[0]);
            int endCol = Integer.parseInt(range[1]);

            if (!writeToCSV(fileName, tableModel, startCol, endCol)) {
                JOptionPane.showMessageDialog(this, "Error while saving to " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Changes saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean writeToCSV(String filePath, DefaultTableModel tableModel, int startCol, int endCol) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                StringBuilder sb = new StringBuilder();
                for (int col = startCol; col < endCol; col++) {
                    sb.append(tableModel.getValueAt(row, col));
                    if (col < endCol - 1) {
                        sb.append(",");
                    }
                }
                bw.write(sb.toString());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public JPanel getDeleteEditBookingPanel() {
        return deleteEditBookingPanel;
    }

    public JTable getDeleteEditBookingTable() {
        return deleteEditBookingTable;
    }
}
