package coolgame.GUI.Settings.Graphics;

import coolgame.Enums.ScreenSizesEnum;
import coolgame.GUI.Window.Window;
import coolgame.Scenes.SettingsScene;
import coolgame.Utils.Managers.SettingsManager;

import javax.swing.*;
import java.awt.*;

public class GraphicsSettings {
    public static void applyDimension(int dimensionIndex) {
        ScreenSizesEnum screenSizesEnum = ScreenSizesEnum.fromIndex(dimensionIndex);
        Dimension dimension = screenSizesEnum.getDimension();

        // Save settings
        SettingsManager.getInstance().setSetting("width", dimension.width);
        SettingsManager.getInstance().setSetting("height", dimension.height);

        // Apply settings
        JFrame mainFrame = Window.getInstance().getMainFrame();
        mainFrame.setSize(dimension);
        mainFrame.setLocationRelativeTo(null); // Center the window
        mainFrame.validate(); // Refresh the layout
    }

    public static void applyFullscreen(boolean isFullscreen) {
        JFrame mainFrame = Window.getInstance().getMainFrame();

        // Update settings
        SettingsManager.getInstance().setSetting("is_fullscreen", isFullscreen);

        // Apply fullscreen settings
        mainFrame.dispose(); // Dispose current frame

        mainFrame.setUndecorated(isFullscreen);

        if (! isFullscreen) {
            mainFrame.setExtendedState(JFrame.NORMAL);
            ScreenSizesEnum screenSizesEnum = ScreenSizesEnum.fromDimension(
                new Dimension(
                    SettingsManager.getInstance().getSetting("width") != null
                        ? SettingsManager.getInstance().getSetting("width").getAsInt()
                        : 1280,
                    SettingsManager.getInstance().getSetting("height") != null
                        ? SettingsManager.getInstance().getSetting("height").getAsInt()
                        : 720
                )
            );

            Dimension size = screenSizesEnum != null
                ? screenSizesEnum.getDimension()
                : new Dimension(1280, 720);
            mainFrame.setSize(size);
        } else {
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            //update text in dropdown box to the max resolution because we are not full screen.
            SettingsScene.getInstance()
                .getResolutionDropdown()
                .setSelectedIndex(ScreenSizesEnum.getMax().ordinal());
        }

        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.validate();
    }
}
