package HNDHospitalSystemAssessment.Models;

public class Drug {
    private String drugID;
    private String drugName;
    private String sideEffects;
    private String benefits;

    public Drug(String drugID, String drugName, String sideEffects, String benefits) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.sideEffects = sideEffects;
        this.benefits = benefits;
    }

    public String getDrugID() {
        return drugID;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public String getBenefits() {
        return benefits;
    }
}
