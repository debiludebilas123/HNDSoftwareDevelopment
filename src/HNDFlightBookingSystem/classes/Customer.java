package HNDFlightBookingSystem.classes;

public class Customer {
    private String customerID;
    private String forename;
    private String surname;
    private String email;
    private String phone;
    private String address;

    public Customer(String customerID, String forename, String surname, String email, String phone, String address) {
        this.customerID = customerID;
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getForename() {
        return forename;
    }

    public String getAddress() {
        return address;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
