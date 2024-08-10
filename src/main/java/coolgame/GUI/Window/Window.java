package coolgame.GUI.Window;

import coolgame.Utils.Managers.SettingsManager;

import javax.swing.*;
import java.awt.*;

public class Window {
    private static Window instance;
    private static JFrame mainFrame;

    private Window() {}

    public static Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }

        return instance;
    }

    public static void boot() {
        mainFrame = new JFrame("Capyblappy Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setUndecorated(false);

        mainFrame.setSize(
            SettingsManager.getInstance().getSetting("width").getAsInt(),
            SettingsManager.getInstance().getSetting("height").getAsInt()
        );

        mainFrame.getContentPane().setBackground(new Color(173, 216, 230)); // Light blue background

        mainFrame.setVisible(true);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public static void setContentPane(Container contentPane) {
        mainFrame.setContentPane(contentPane);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
