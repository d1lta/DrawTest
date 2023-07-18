package org.example.window.components;

import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import org.example.Main;
import org.example.utils.TextUtil;

public class CheckBox extends JCheckBox {

    TextUtil textUtil = new TextUtil();

    public CheckBox(
            String name,
            String text,
            double x, double y,
            int w, int h,
            boolean focusable,
            ItemListener listener
    ) {
        setName("checkbox_" + name);
        setText(textUtil.text(text));
        setLocation((int) x, (int) y);
        setSize(w,h);
        setFocusable(focusable);
        if (Main.bordered) {
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
        }
        if (listener != null) {
            addItemListener(listener);
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
