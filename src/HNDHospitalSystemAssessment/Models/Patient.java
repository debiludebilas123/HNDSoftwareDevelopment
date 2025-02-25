package HNDHospitalSystemAssessment.Models;

public class Patient {
    private String patientID;
    private String firstName;
    private String surname;
    private String postcode;
    private String address;
    private String phone;
    private String email;

    public Patient(String patientID, String firstName, String surname, String postcode, String address, String phone, String email) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.surname = surname;
        this.postcode = postcode;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
