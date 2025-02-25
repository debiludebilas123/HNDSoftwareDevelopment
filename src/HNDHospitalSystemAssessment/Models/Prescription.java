package HNDHospitalSystemAssessment.Models;

import java.time.LocalDate;

public class Prescription {
    private String prescriptionID;
    private LocalDate dateOfPrescription;
    private String dosage;
    private String duration;
    private String comment;

    public Prescription(String prescriptionID, LocalDate dateOfPrescription, String dosage, String duration, String comment) {
        this.prescriptionID = prescriptionID;
        this.dateOfPrescription = dateOfPrescription;
        this.dosage = dosage;
        this.duration = duration;
        this.comment = comment;
    }

    public String getPrescriptionID() {
        return prescriptionID;
    }

    public LocalDate getDateOfPrescription() {
        return dateOfPrescription;
    }

    public String getDosage() {
        return dosage;
    }

    public String getDuration() {
        return duration;
    }

    public String getComment() {
        return comment;
    }
}
