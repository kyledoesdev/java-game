package coolgame.GUI.Window;

import coolgame.Utils.Managers.SettingsManager;

import javax.swing.*;
import java.awt.*;

public class Window {
    private static Window instance;
    private static JFrame window;

    private Window() {}

    public static Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }

        return instance;
    }

    public static void boot() {
        window = new JFrame("Capyblappy Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setUndecorated(false);
        window.setResizable(false);

        window.setSize(
            SettingsManager.getInstance().getSetting("width").getAsInt(),
            SettingsManager.getInstance().getSetting("height").getAsInt()
        );

        //TODO - color picker setting
        window.getContentPane().setBackground(new Color(173, 216, 230)); // Light blue background

        window.setVisible(true);
    }

    public static void changeScene(Container contentPane) {
        window.setContentPane(contentPane);
        window.revalidate();
        window.repaint();
    }

    public JFrame getWindow() {
        return window;
    }
}
