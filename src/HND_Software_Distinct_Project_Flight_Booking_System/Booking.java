package HND_Software_Distinct_Project_Flight_Booking_System;

public class Booking {
    private String bookingNo;
    private String customerID;
    private int adultTicket;
    private int childTicket;
    private int concessionTicket;
    private String flightID;

    public Booking(String bookingNo, String customerID, int adultTicket, int childTicket, int concessionTicket, String flightID) {
        this.bookingNo = bookingNo;
        this.customerID = customerID;
        this.adultTicket = adultTicket;
        this.childTicket = childTicket;
        this.concessionTicket = concessionTicket;
        this.flightID = flightID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public int getAdultTicket() {
        return adultTicket;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public int getChildTicket() {
        return childTicket;
    }

    public int getConcessionTicket() {
        return concessionTicket;
    }

    public String getFlightID() {
        return flightID;
    }

}
