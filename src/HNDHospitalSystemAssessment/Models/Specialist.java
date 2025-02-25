package HNDHospitalSystemAssessment.Models;

public class Specialist extends Doctor {
    private String specialization;
    private int experience;

    public Specialist(String doctorID, String firstName, String surname, String address, String email, String specialization, int experience) {
        super(doctorID, firstName, surname, address, email);
        this.specialization = specialization;
        this.experience = experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }
}
