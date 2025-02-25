package HNDHospitalSystemAssessment.GUI;

import javax.swing.*;

public class VisitManagement {
    private JTextField dovInput;
    private JButton addVisitButton;
    private JPanel visitManagementPanel;
    private JTable visitManagementTable;
    private JTextField symptomsInput;
    private JTextField diagnosisInput;
    private JButton editVisitButton;
    private JButton deleteVisitButton;
    private JScrollPane visitManagementScrollPane;
    private JFrame frame;

    public VisitManagement(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getVisitManagementPanel() {
        return visitManagementPanel;
    }
}
