/*package HND_Software_Distinct_Project_Flight_Booking_System;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    public static void writeToCsv(String filePath, String[] data) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(String.join(",", data));
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBookingToCsv(Booking booking) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("booking.csv", true))) {
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

    public static void writeRouteToCsv(Route route) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("route.csv", true))) {
            writer.write(route.getRouteID() + "," +
                    route.getDepartFrom() + "," +
                    route.getArriveAt() + "," +
                    route.getMidStopOne() + "," +
                    route.getMidStopTwo());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCustomerToCsv(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.csv", true))) {
            writer.write(customer.getCustomerID() + "," +
                    customer.getForename() + "," +
                    customer.getSurname() + "," +
                    customer.getStreet() + "," +
                    customer.getTown() + "," +
                    customer.getPostcode());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFlightToCsv(Flight flight) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("flight.csv", true))) {
            writer.write(flight.getFlightID() + "," +
                    flight.getDepartureDate() + "," +
                    flight.getDepartureTime() + "," +
                    flight.getRouteID() + "," +
                    flight.getArrivalDate() + "," +
                    flight.getArrivalTime() + "," +
                    flight.getCapacity());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
*/