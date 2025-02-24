package HNDHospitalSystemAssessment.GUI;

import javax.swing.*;

public class PatientManagement {
    private JTextField patientIDInput;
    private JCheckBox insuredPatientCheckBox;
    private JButton addPatientButton;
    private JPanel patientManagementPanel;
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
    private JButton deletePatientButton;
    private JScrollPane patientManagementScrollPane;
    private JFrame frame;

    public PatientManagement(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPatientManagementPanel() {
        return patientManagementPanel;
    }
}
