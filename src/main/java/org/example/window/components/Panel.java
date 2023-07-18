package org.example.window.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javafx.scene.layout.Pane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import lombok.Getter;
import org.example.Main;
import org.example.window.components.misc.PanelContent;

public class Panel extends JPanel {

    public Panel(
            String name,
            double x, double y,
            int Bw, int Bh,
            int w, int h,
            Color bgColor,
            int layout,
            int g1, int g2,
            PanelContent content
    ) {
        setName("panel_" + name);
        setBounds(new Rectangle(Bw,Bh));
        setLocation((int) x, (int) y);
        setSize(w,h);
        setBackground(bgColor);
        if (g1 != 0 || g2 != 0) {
            setLayout(new GridLayout(g1,g2));
        } else {
            setLayout(new BoxLayout(this, layout));
        }
        if (content != null) {
            content.getContents().forEach(this::add);
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

    public void clear() {
        for(Component a: this.getComponents()) {
            this.remove(a);
        }
    }

    public void apply(PanelContent content, int g1, int g2) {
        content.getContents().forEach(it -> {
            if (it instanceof PanelContent) {
                add(new Panel("apply_auto_panel",0,0,0,0,0,0,Color.LIGHT_GRAY,2,g1,g2,(PanelContent) it));
            } else {
                add(it);
            }
        });
    }
}
