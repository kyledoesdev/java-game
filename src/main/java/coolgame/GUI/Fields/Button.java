package coolgame.GUI.Fields;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button extends Field {
    public Button(String text) {
        component = new JButton(text);
    }

    public void addActionListener(ActionListener listener) {
        ((JButton) component).addActionListener(listener);
    }
}
