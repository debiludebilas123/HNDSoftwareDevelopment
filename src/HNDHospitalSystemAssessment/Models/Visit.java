package HNDHospitalSystemAssessment.Models;

public class Visit {
    private String DOV;
    private String symptoms;
    private String diagnosis;

    public Visit(String DOV, String symptoms, String diagnosis) {
        this.DOV = DOV;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
    }

    public String getDOV() {
        return DOV;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
