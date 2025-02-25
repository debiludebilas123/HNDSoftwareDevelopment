package HNDHospitalSystemAssessment.GUI;

import javax.swing.*;

public class DrugManagement {
    private JTextField drugIDInput;
    private JButton addDrugButton;
    private JPanel drugManagementPanel;
    private JTable drugManagementTable;
    private JTextField drugNameInput;
    private JTextField sideEffectsInput;
    private JTextField benefitsInput;
    private JButton editDrugButton;
    private JButton deleteDrugButton;
    private JScrollPane drugManagementScrollPane;
    private JFrame frame;

    public DrugManagement(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getDrugManagementPanel() {
        return drugManagementPanel;
    }
}
