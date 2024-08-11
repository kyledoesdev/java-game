package coolgame.Utils.Managers;

import coolgame.GUI.Window.Window;
import com.google.gson.*;

import java.io.*;

public class SettingsManager {
    private static final String SETTINGS_FILE = "./player_data/settings.json"; // Path for resources
    private static SettingsManager instance; // Singleton instance
    private JsonObject settings;
    private final Gson gson;

    // Private constructor for Singleton pattern
    private SettingsManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.loadInSettings();
    }

    // Get the singleton instance
    public static SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
        }

        return instance;
    }

    public void loadInSettings() {
        try (InputStream inputStream = new FileInputStream(SETTINGS_FILE)) {
            this.settings = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();
        } catch (Exception e) {
            Window.getInstance().getWindow().dispose();
            System.exit(404);
        }
    }

    public JsonElement getSetting(String setting) {
        return settings.getAsJsonObject("settings").has(setting)
            ? settings.getAsJsonObject("settings").get(setting)
            : null;
    }

    public void setSetting(String setting, int value) {
        JsonObject settingsObj = settings.getAsJsonObject("settings");
        settingsObj.addProperty(setting, value);
        settings.add("settings", settingsObj);

        this.writeUpdates();
    }

    public void setSetting(String setting, boolean value) {
        JsonObject settingsObj = settings.getAsJsonObject("settings");
        settingsObj.addProperty(setting, value);
        settings.add("settings", settingsObj);

        this.writeUpdates();
    }

    // Write updates to the file
    private void writeUpdates() {
        try (FileWriter writer = new FileWriter(SETTINGS_FILE)) {
            gson.toJson(settings, writer);
        } catch (IOException e) {
            System.out.println("Error writing to settings file: " + e.getMessage());
        }
    }
}
