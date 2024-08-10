package coolgame.Scenes;

import coolgame.GUI.Fields.Button;
import coolgame.GUI.Window.Window;

import javax.swing.*;

public class HomeScene extends Scene {
    private static HomeScene instance;

    private HomeScene() {};

    public static HomeScene getInstance() {
        if (instance == null) {
            instance = new HomeScene();
        }

        return instance;
    }

    @Override
    public void setup() {
        JPanel homePanel = new JPanel(null);

        Button settingsButton = new Button("Settings");
        settingsButton.setBounds(50, 50, 100, 50);
        settingsButton.addActionListener(e -> Scene.setScene(SettingsScene.getInstance()));
        homePanel.add(settingsButton.getComponent());

        Button quitButton = new Button("Exit");
        quitButton.setBounds(100, 100, 100, 50);
        quitButton.addActionListener(e -> System.exit(0)); //TODO shutdown process, for now just quit
        homePanel.add(quitButton.getComponent());

        JLabel homeLabel = new JLabel("Home Screen");
        homeLabel.setBounds(600, 20, 200, 50);
        homePanel.add(homeLabel);

        Window.setContentPane(homePanel);
    }
}
