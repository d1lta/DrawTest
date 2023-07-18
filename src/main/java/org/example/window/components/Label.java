package org.example.window.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import org.example.Main;
import org.example.utils.TextUtil;

public class Label extends JLabel {

    TextUtil textUtil = new TextUtil();

    public Label(
            String name,
            String text,
            double x, double y,
            int w, int h,
            String font, int fontStyle, int fontSize,
            int alignment,
            Color foreground,
            Cursor cursor
    ) {
        setName("label_" + name);
        setText(textUtil.text(text));
        setLocation((int) x, (int) y);
        setSize(w,h);
        setFont(new Font(font, fontStyle, fontSize));
        setHorizontalAlignment(alignment);
        if (foreground != null) {
            setForeground(foreground);
        }
        if (cursor != null) {
            setCursor(cursor);
        }
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
