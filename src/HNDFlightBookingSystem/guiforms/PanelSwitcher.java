package HNDFlightBookingSystem.guiforms;

import javax.swing.*;
import java.awt.*;

public class PanelSwitcher {
    public static void switchPanel(JPanel currentPanel, String targetPanelName) {
        Container parent = currentPanel.getParent();
        if (parent instanceof JPanel) {
            CardLayout layout = (CardLayout) parent.getLayout();
            layout.show(parent, targetPanelName);
        }
    }
}
