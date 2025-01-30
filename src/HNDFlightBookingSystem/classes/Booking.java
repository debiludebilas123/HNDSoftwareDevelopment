package HNDFlightBookingSystem.classes;

import java.time.LocalDate;

public class Booking {
    private String bookingID;
    private LocalDate  bookingDate;

    public Booking(String bookingID, LocalDate bookingDate) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
    }

    public String getBookingID() {
        return bookingID;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }
}
