package HND_Software_Distinct_Project_Flight_Booking_System;

import java.io.FileWriter;

public class CSVWriter {
    public static void writeCustomerToCSV(Customer customer) {
        try (FileWriter writer = new FileWriter("customers.csv", true)) {
            writer.append(customer.getCustomerID()).append(",");
            writer.append(customer.getForename()).append(",");
            writer.append(customer.getSurname()).append(",");
            writer.append(customer.getStreet()).append(",");
            writer.append(customer.getTown()).append(",");
            writer.append(customer.getPostcode()).append("\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeBookingToCSV(Booking booking) {
        try (FileWriter writer = new FileWriter("bookings.csv", true)) {
            writer.append(booking.getBookingNo()).append(",");
            writer.append(booking.getCustomerID()).append(",");
            writer.append(String.valueOf(booking.getAdultTicket())).append(",");
            writer.append(String.valueOf(booking.getChildTicket())).append(",");
            writer.append(String.valueOf(booking.getConcessionTicket())).append(",");
            writer.append(booking.getFlightID()).append("\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFlightToCSV(Flight flight) {
        try (FileWriter writer = new FileWriter("flights.csv", true)) {
            writer.append(flight.getFlightID()).append(",");
            writer.append(flight.getDepartureDate()).append(",");
            writer.append(flight.getDepartureTime()).append(",");
            writer.append(flight.getRouteID()).append(",");
            writer.append(flight.getArrivalDate()).append(",");
            writer.append(flight.getArrivalTime()).append(",");
            writer.append(String.valueOf(flight.getCapacity())).append("\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeRouteToCSV(Route route) {
        try (FileWriter writer = new FileWriter("routes.csv", true)) {
            writer.append(route.getRouteID()).append(",");
            writer.append(route.getDepartFrom()).append(",");
            writer.append(route.getArriveAt()).append(",");
            writer.append(route.getMidStopOne()).append(",");
            writer.append(route.getMidStopTwo()).append("\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
