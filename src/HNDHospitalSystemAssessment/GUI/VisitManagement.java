package HNDHospitalSystemAssessment.GUI;

import javax.swing.*;

public class VisitManagement {
    private JTextField patientIDInput;
    private JCheckBox insuredPatientCheckBox;
    private JButton addPatientButton;
    private JPanel visitManagementPanel;
    private JTable patientManagementTable;
    private JTextField firstNameInput;
    private JTextField surnameInput;
    private JTextField addressInput;
    private JTextField postcodeInput;
    private JTextField phoneInput;
    private JTextField emailInput;
    private JTextField insuranceCompanyInput;
    private JTextField insuranceTypeInput;
    private JTextField durationInput;
    private JButton editPatientButton;
    private JButton emailButton;
    private JScrollPane patientManagementScrollPane;
    private JFrame frame;

    public VisitManagement(JFrame frame) {
        this.frame = frame;
    }
}
