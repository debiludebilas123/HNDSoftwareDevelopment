package HNDHospitalSystemAssessment.GUI;

import javax.swing.*;

public class PrescriptionManagement {
    private JPanel prescriptionManagementPanel;
    private JButton addPrescriptionButton;
    private JTable prescriptionManagementTable;
    private JTextField datePrescriptionInput;
    private JTextField dosageInput;
    private JTextField durationInput;
    private JTextField commentInput;
    private JButton editPatientButton;
    private JButton deletePrescriptionButton;
    private JScrollPane patientManagementScrollPane;
    private JFrame frame;
    private JTextField prescriptionIDInput;

    public PrescriptionManagement(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPrescriptionManagementPanel() {
        return prescriptionManagementPanel;
    }
}
