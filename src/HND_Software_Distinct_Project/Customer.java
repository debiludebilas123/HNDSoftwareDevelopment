package HND_Software_Distinct_Project;

public class Customer {
    private String customerID;
    private String forename;
    private String surname;
    private String street;
    private String town;
    private String postcode;

    public Customer(String customerID, String forename, String surname, String street, String town, String postcode) {
        this.customerID = customerID;
        this.forename = forename;
        this.surname = surname;
        this.street = street;
        this.town = town;
        this.postcode = postcode;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getForename() {
        return forename;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStreet() {
        return street;
    }

    public String getSurname() {
        return surname;
    }

    public String getTown() {
        return town;
    }
}
