package coolgame.GUI.Settings.Graphics;

import coolgame.Enums.ScreenSizesEnum;
import coolgame.GUI.Window.Window;
import coolgame.Scenes.SettingsScene;
import coolgame.Utils.Managers.SettingsManager;

import javax.swing.*;
import java.awt.*;

public class GraphicsSettings {
    public static void changeScreenSize(int dimensionIndex) {
        ScreenSizesEnum screenSizesEnum = ScreenSizesEnum.fromIndex(dimensionIndex);
        Dimension dimension = screenSizesEnum.getDimension();

        // Save settings
        SettingsManager.getInstance().setSetting("width", dimension.width);
        SettingsManager.getInstance().setSetting("height", dimension.height);

        //Perform update
        Window.getInstance().getWindow().setSize(dimension);

        applyChangedSettings();
    }

    public static void toggleFullScreen(boolean isFullscreen) {
        // Save Change & purge window.
        SettingsManager.getInstance().setSetting("is_fullscreen", isFullscreen);
        Window.getInstance().getWindow().dispose();
        Window.getInstance().getWindow().setUndecorated(isFullscreen);

        if (! isFullscreen) {
            Window.getInstance().getWindow().setExtendedState(JFrame.NORMAL);
            ScreenSizesEnum newSize = ScreenSizesEnum.fromDimension(
                new Dimension(
                    SettingsManager.getInstance().getSetting("width") != null
                        ? SettingsManager.getInstance().getSetting("width").getAsInt()
                        : 1280,
                    SettingsManager.getInstance().getSetting("height") != null
                        ? SettingsManager.getInstance().getSetting("height").getAsInt()
                        : 720
                )
            );

            Window.getInstance().getWindow()
                .setSize(newSize != null ? newSize.getDimension() : new Dimension(1280, 720));
        } else {
            Window.getInstance().getWindow().setExtendedState(JFrame.MAXIMIZED_BOTH);

            //update text in dropdown box to the max resolution because we are not full screen.
            SettingsScene.getInstance()
                .getResolutionDropdown()
                .setSelectedIndex(ScreenSizesEnum.getMax().ordinal());
        }

        applyChangedSettings();
    }

    private static void applyChangedSettings() {
        Window.getInstance().getWindow().setVisible(true);
        Window.getInstance().getWindow().setLocationRelativeTo(null);
        Window.getInstance().getWindow().validate();
    }
}
