package HNDHospitalSystemAssessment.GUI;

import javax.swing.*;

public class InsuranceManagement {
    private JTextField insuranceIDInput;
    private JButton addInsuranceButton;
    private JPanel insuranceManagementPanel;
    private JTable insuranceManagementTable;
    private JTextField companyInput;
    private JTextField addressInput;
    private JTextField phoneInput;
    private JButton editPatientButton;
    private JButton deleteInsuranceButton;
    private JScrollPane insuranceManagementScrollPane;
    private JFrame frame;

    public InsuranceManagement(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getInsuranceManagementPanel() {
        return insuranceManagementPanel;
    }
}
