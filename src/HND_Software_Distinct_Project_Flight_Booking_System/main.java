package HND_Software_Distinct_Project_Flight_Booking_System;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            JFrame frame = new JFrame("Input Form");
            InputForm inputForm = new InputForm();
            frame.setContentPane(inputForm.getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
