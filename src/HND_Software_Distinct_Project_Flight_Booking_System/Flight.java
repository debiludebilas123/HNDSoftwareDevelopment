package HND_Software_Distinct_Project_Flight_Booking_System;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private String flightID;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String routeID;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private int capacity;

    public Flight(String flightID, LocalDate departureDate, LocalTime departureTime, String routeID, LocalDate arrivalDate, LocalTime arrivalTime, int capacity) {
        this.flightID = flightID;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.routeID = routeID;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
    }

    public String getFlightID() {
        return flightID;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getRouteID() {
        return routeID;
    }
}
