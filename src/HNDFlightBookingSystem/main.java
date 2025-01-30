package HNDFlightBookingSystem;

import HNDFlightBookingSystem.guiforms.MainMenu;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        /*SwingUtilities.invokeLater(() ->{
            JFrame frame = new JFrame("Input Form");
            InputForm inputForm = new InputForm();
            frame.setContentPane(inputForm.getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });*/

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Main Menu Form");
            MainMenu mainMenu = new MainMenu();
            frame.setContentPane((mainMenu.getMainMenuPanel()));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
