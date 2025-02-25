package HNDHospitalSystemAssessment.Models;

public class InsuredPatient extends Patient{
    private String insuranceType;
    private String insuranceCompanyName;
    private int insuranceDuration;

    public InsuredPatient(String patientID, String firstName, String surname, String postcode, String address, String phone, String email, String insuranceType, String insuranceCompanyName, int insuranceDuration) {
        super(patientID, firstName, surname, postcode, address, phone, email);
        this.insuranceType = insuranceType;
        this.insuranceCompanyName = insuranceCompanyName;
        this.insuranceDuration = insuranceDuration;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public int getInsuranceDuration() {
        return insuranceDuration;
    }
}
