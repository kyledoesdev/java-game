package coolgame.GUI.Fields;

import javax.swing.*;
import java.awt.*;

public abstract class Field {
    protected JComponent component;

    public void setBounds(int x, int y, int width, int height) {
        component.setBounds(x, y, width, height);
    }

    public void setFont(Font font) {
        component.setFont(font);
    }

    public JComponent getComponent() {
        return component;
    }
}
