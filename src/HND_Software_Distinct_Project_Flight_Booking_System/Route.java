package HND_Software_Distinct_Project_Flight_Booking_System;

public class Route {
    private String routeID;
    private String departFrom;
    private String arriveAt;
    private String midStopOne;
    private String midStopTwo;

    public Route(String routeID, String departFrom, String arriveAt, String midStopOne, String midStopTwo) {
        this.routeID = routeID;
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.midStopOne = midStopOne;
        this.midStopTwo = midStopTwo;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public String getRouteID() {
        return routeID;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public String getMidStopOne() {
        return midStopOne;
    }

    public String getMidStopTwo() {
        return midStopTwo;
    }
}
