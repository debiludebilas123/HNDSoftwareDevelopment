package HNDFlightBookingSystem.classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private String flightID;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDate departureDate;
    private LocalTime departureTime;

    public Flight(String flightID, String flightNumber, String departureAirport, String arrivalAirport, LocalDate departureDate, LocalTime departureTime) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.departureTime = departureTime;

    }

    public String getFlightID() {
        return flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

}
