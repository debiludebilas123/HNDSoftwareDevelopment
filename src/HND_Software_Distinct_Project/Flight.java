package HND_Software_Distinct_Project;

public class Flight {
    private String flightID;
    private String departureDate;
    private String departureTime;
    private String routeID;
    private String arrivalDate;
    private String arrivalTime;
    private int capacity;

    public Flight(String flightID, String departureDate, String departureTime, String routeID, String arrivalDate, String arrivalTime, int capacity) {
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

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getRouteID() {
        return routeID;
    }
}
