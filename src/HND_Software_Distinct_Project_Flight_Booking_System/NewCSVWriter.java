package HND_Software_Distinct_Project_Flight_Booking_System;

import java.io.FileWriter;
import java.io.IOException;

public class NewCSVWriter {
    public static void writeToCsv(String filePath, String[] data) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // Write data to CSV (each entry separated by a comma)
            writer.append(String.join(",", data));
            writer.append("\n");  // New line after each row
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
