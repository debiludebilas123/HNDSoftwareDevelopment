package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import java.awt.*;

public class PanelSwitcher {
    public static void switchPanel(JPanel currentPanel, String targetPanelName, JFrame frame, int width, int height) {
        Container parent = currentPanel.getParent();
        if (parent instanceof JPanel) {
            CardLayout layout = (CardLayout) parent.getLayout();
            layout.show(parent, targetPanelName);

            resizeFrame(frame, width, height);
        }
    }

    public static void resizeFrame(JFrame frame, int width, int height) {
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
    }
}
