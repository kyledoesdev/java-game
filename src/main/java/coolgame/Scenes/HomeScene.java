package coolgame.Scenes;

import coolgame.GUI.Fields.Button;
import coolgame.GUI.Fields.Label;
import coolgame.GUI.Window.Window;
import coolgame.Utils.Managers.SettingsManager;

import javax.swing.*;

public class HomeScene extends Scene {
    private static HomeScene instance;
    private final JPanel scene;

    private HomeScene() {
        scene = new JPanel(null);
    };

    public static HomeScene getInstance() {
        if (instance == null) {
            instance = new HomeScene();
        }

        return instance;
    }

    @Override
    public void setup() {
        Label homeLabel = new Label("Home Screen");
        homeLabel.setBounds(200, 50, (int)homeLabel.getComponent().getPreferredSize().getWidth(), (int)homeLabel.getComponent().getPreferredSize().getHeight());
        scene.add(homeLabel.getComponent());

        this.addExitButton();
        this.addSettingsButton();

        Window.changeScene(scene);
    }

    private void addSettingsButton() {
        Button settingsButton = new Button("Settings");
        settingsButton.setBounds(50, 50, 100, 25);
        settingsButton.addActionListener(e -> Scene.setScene(SettingsScene.getInstance()));
        scene.add(settingsButton.getComponent());
    }

    private void addExitButton() {
        Button quitButton = new Button("Exit");
        quitButton.setBounds(50, 150, 100, 25);
        quitButton.addActionListener(e -> System.exit(0)); //TODO shutdown process, for now just quit
        scene.add(quitButton.getComponent());
    }
}
