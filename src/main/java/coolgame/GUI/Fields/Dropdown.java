package coolgame.GUI.Fields;

import javax.swing.*;

public class Dropdown extends Field {
    public Dropdown(String[] options) {
        component = new JComboBox<>(options);
    }

    public int getSelectedIndex() {
        return ((JComboBox<String>) component).getSelectedIndex();
    }

    public void setSelectedIndex(int index) {
        ((JComboBox<String>) component).setSelectedIndex(index);
    }
}
