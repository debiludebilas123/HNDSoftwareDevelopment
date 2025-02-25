package HNDHospitalSystemAssessment;

import HNDHospitalSystemAssessment.GUI.*;

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

        MainMenu mainMenu = new MainMenu(frame);
        DoctorManagement doctorManagement = new DoctorManagement(frame);
        DrugManagement drugManagement = new DrugManagement(frame);
        InsuranceManagement insuranceManagement = new InsuranceManagement(frame);
        PatientManagement patientManagement = new PatientManagement(frame);
        PrescriptionManagement prescriptionManagement = new PrescriptionManagement(frame);
        VisitManagement visitManagement = new VisitManagement(frame);

        panel.add(mainMenu.getMainMenuPanel(), "MainMenu");
        panel.add(doctorManagement.getDoctorManagementPanel(), "DoctorManagement");
        panel.add(drugManagement.getDrugManagementPanel(), "DrugManagement");
        panel.add(insuranceManagement.getInsuranceManagementPanel(), "InsuranceManagement");
        panel.add(patientManagement.getPatientManagementPanel(), "PatientManagement");
        panel.add(prescriptionManagement.getPrescriptionManagementPanel(), "PrescriptionManagement");
        panel.add(visitManagement.getVisitManagementPanel(), "VisitManagement");

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
