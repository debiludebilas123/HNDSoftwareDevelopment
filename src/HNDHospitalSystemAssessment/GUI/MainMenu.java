package HNDHospitalSystemAssessment.GUI;

import javax.swing.*;

public class MainMenu {

    private JButton prescriptionManagementButton;
    private JButton patientManagementButton;
    private JButton visitManagementButton;
    private JButton doctorManagementButton;
    private JButton drugManagementButton;
    private JButton insuranceManagementButton;
    private JPanel mainMenuPanel;
    private JFrame frame;

    public MainMenu(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainMenuPanel() {
        return mainMenuPanel;
    }
}
