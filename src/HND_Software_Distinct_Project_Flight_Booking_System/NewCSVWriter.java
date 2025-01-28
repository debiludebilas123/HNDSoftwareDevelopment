package HND_Software_Distinct_Project_Flight_Booking_System;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NewCSVWriter {
    public static void writeToCsv(String filePath, String[] data) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(String.join(",", data));
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBookingToCsv(Booking booking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.csv", true))) {
            writer.write(booking.getBookingNo() + "," +
                         booking.getAdultTicket() + "," +
                         booking.getChildTicket() + "," +
                         booking.getConcessionTicket() + "," +
                         booking.getCustomerID() + "," +
                         booking.getFlightID());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
