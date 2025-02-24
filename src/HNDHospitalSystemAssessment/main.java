package HNDHospitalSystemAssessment;

import HNDHospitalSystemAssessment.GUI.PatientManagement;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hospital System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        CardLayout cardLayout = new CardLayout();
        JPanel panel = new JPanel(cardLayout);

        PatientManagement patientManagement = new PatientManagement(frame);

        panel.add(patientManagement.getPatientManagementPanel(), "PatientManagement");

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
