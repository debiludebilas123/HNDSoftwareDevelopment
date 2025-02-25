package HNDHospitalSystemAssessment.Models;

public class Doctor {
    private String doctorID;
    private String firstName;
    private String surname;
    private String address;
    private String email;

    public Doctor(String doctorID, String firstName, String surname, String address, String email) {
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
