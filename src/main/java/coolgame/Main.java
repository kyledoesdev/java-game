package coolgame;

import coolgame.GUI.Window.Window;
import coolgame.Scenes.HomeScene;
import coolgame.Scenes.Scene;

public class Main {
    public static void main(String[] args) {
        // Initialize the window
        Window.boot();

        // Display the home screen
        Scene.setScene(HomeScene.getInstance());
    }
}
