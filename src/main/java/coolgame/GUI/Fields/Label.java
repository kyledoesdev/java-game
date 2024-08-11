package coolgame.GUI.Fields;

import coolgame.Utils.Managers.SettingsManager;

import javax.swing.*;

public class Label extends Field {
    public Label (String label) { component = new JLabel(label); }
}
