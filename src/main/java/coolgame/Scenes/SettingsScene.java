package coolgame.Scenes;

import coolgame.Enums.ScreenSizesEnum;
import coolgame.GUI.Fields.Button;
import coolgame.GUI.Fields.Dropdown;
import coolgame.GUI.Settings.Graphics.GraphicsSettings;
import coolgame.GUI.Window.Window;
import coolgame.Utils.Managers.SettingsManager;

import javax.swing.*;
import java.awt.*;

public class SettingsScene extends Scene {
    private Dropdown resolutionDropdown;

    private static SettingsScene instance;

    private SettingsScene() {};

    public static SettingsScene getInstance() {
        if (instance == null) {
            instance = new SettingsScene();
        }

        return instance;
    }

    @Override
    public void setup() {
        JPanel settingsScene = new JPanel(null);

        resolutionDropdown = new Dropdown(new String[] {
            "640x480","800x600","1280x720", "1600x900", "1920x1080"
        });

        resolutionDropdown.setBounds(50, 90, 150, 30);
        settingsScene.add(resolutionDropdown.getComponent());
        this.setDropdownSelection();

        JCheckBox fullscreenCheckBox = new JCheckBox("Fullscreen");
        fullscreenCheckBox.setBounds(50, 50, 150, 30);
        settingsScene.add(fullscreenCheckBox);

        Button applyButton = new Button("Apply");
        applyButton.setBounds(250, 90, 100, 30);
        applyButton.addActionListener(e -> {
            GraphicsSettings.changeScreenSize(resolutionDropdown.getSelectedIndex());
            GraphicsSettings.toggleFullScreen(fullscreenCheckBox.isSelected());
        });
        settingsScene.add(applyButton.getComponent());

        Button backButton = new Button("Back");
        backButton.setBounds(50, 150, 100, 30);
        backButton.addActionListener(e -> Scene.setScene(HomeScene.getInstance()));
        settingsScene.add(backButton.getComponent());

        Window.changeScene(settingsScene);
    }

    private void setDropdownSelection() {
        Dimension currentDimension = new Dimension(
            SettingsManager.getInstance().getSetting("width") != null
                ? SettingsManager.getInstance().getSetting("width").getAsInt()
                : 1280,
            SettingsManager.getInstance().getSetting("height") != null
                ? SettingsManager.getInstance().getSetting("height").getAsInt()
                : 720
        );

        ScreenSizesEnum selectedEnum = ScreenSizesEnum.fromDimension(currentDimension);

        if (selectedEnum != null) {
            resolutionDropdown.setSelectedIndex(selectedEnum.ordinal());
        }
    }

    public Dropdown getResolutionDropdown() {
        return resolutionDropdown;
    }
}
