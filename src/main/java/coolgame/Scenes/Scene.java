package coolgame.Scenes;

public abstract class Scene {
    public abstract void setup();

    public static void setScene(Scene scene) {
        scene.setup();
    }
}
