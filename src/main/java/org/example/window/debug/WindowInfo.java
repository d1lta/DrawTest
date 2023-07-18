package org.example.window.debug;

import java.awt.Color;
import java.awt.Window;
import org.example.window.components.Label;

public class WindowInfo {

    Label info;

    public WindowInfo(Window window) {
        info = new Label("info","W/H: " + window.getWidth() + "/" + window.getHeight(), 1, 50, 125, 20, "Times New Roman", 0, 18, 2, Color.BLACK, null);
    }

    public Label get() {
        return info;
    }

}
