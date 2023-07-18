package org.example.window.components;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import org.example.Main;
import org.example.utils.TextUtil;

public class TextField extends JTextField {

    TextUtil textUtil = new TextUtil();

    public TextField(
            String name,
            String text,
            double x, double y,
            int w, int h,
            int alignment
    ) {
        setName("textfield_" + name);
        setText(textUtil.textNoHTML(text));
        setLocation((int) x, (int) y);
        setSize(w, h);
        setHorizontalAlignment(alignment);
        if (Main.bordered) {
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
        }
    }
    public void updateBorders() {
        if (Main.bordered) {
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
        } else {
            setBorder(null);
        }
    }
}
