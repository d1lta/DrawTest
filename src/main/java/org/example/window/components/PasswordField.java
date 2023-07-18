package org.example.window.components;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import org.example.Main;
import org.example.utils.TextUtil;

public class PasswordField extends JPasswordField {

    TextUtil textUtil = new TextUtil();

    public PasswordField(
            String name,
            String text,
            double x, double y,
            int w, int h,
            int alignment,
            char echo
    ) {
        setName("passwordfield_" + name);
        setText(textUtil.textNoHTML(text));
        setLocation((int) x, (int) y);
        setSize(w,h);
        setHorizontalAlignment(alignment);
        setEchoChar(echo);
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
