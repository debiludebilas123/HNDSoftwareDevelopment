package HNDHospitalSystemAssessment.Models;

public class Insurance {
    private String InsuranceID;
    private String company;
    private String address;
    private String phone;

    public Insurance(String insuranceID, String company, String address, String phone) {
        this.InsuranceID = insuranceID;
        this.company = company;
        this.address = address;
        this.phone = phone;
    }

    public String getInsuranceID() {
        return InsuranceID;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
