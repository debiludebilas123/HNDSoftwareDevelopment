package HNDFlightBookingSystem.classes;

public class Route {
    private String routeID;
    private String routeName;

    public Route(String routeID, String routeName) {
        this.routeID = routeID;
        this.routeName = routeName;
    }

    public String getRouteID() {
        return routeID;
    }

    public String getRouteName() {
        return routeName;
    }
}
