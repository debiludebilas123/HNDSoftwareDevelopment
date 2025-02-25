package HNDHospitalSystemAssessment.GUI;

import javax.swing.*;

public class DoctorManagement {
    private JTextField doctorIDInput;
    private JButton addDoctorButton;
    private JPanel doctorManagementPanel;
    private JTable doctorManagementTable;
    private JTextField firstNameInput;
    private JTextField surnameInput;
    private JTextField addressInput;
    private JTextField emailInput;
    private JButton editDoctorButton;
    private JButton deleteDoctorButton;
    private JScrollPane doctorManagementScrollPane;
    private JCheckBox specialistCheckBox;
    private JTextField specializationInput;
    private JTextField experienceInput;
    private JFrame frame;

    public DoctorManagement(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getDoctorManagementPanel() {
        return doctorManagementPanel;
    }
}
