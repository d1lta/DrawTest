package org.example.window.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import lombok.SneakyThrows;
import org.example.Main;
import org.example.utils.TextUtil;
import org.imgscalr.Scalr;

public class Button extends JButton {

    TextUtil textUtil = new TextUtil();

    public Button(
            String name,
            String text,
            double x, double y,
            int w, int h,
            LayoutManager layout,
            Boolean visible,
            Boolean focusable,
            List<ActionListener> actionListeners,
            ImageIcon imageicon,
            float alignment,
            boolean toHTML
    ) {
        setName("button_" + name);
        if (imageicon != null) { setIcon(new ImageIcon(simpleResizeImage(imageicon.getImage(), w, h))); }
        if (toHTML) {
            setText(textUtil.text(text));
        } else {
            setText(textUtil.textNoHTML(text));
        }
        setLocation((int) x, (int) y);
        setSize(w,h);
        setLayout(layout);
        setVisible(visible);
        setFocusable(focusable);
        setAlignmentX(alignment);
        if (actionListeners != null) {
            actionListeners.forEach(this::addActionListener);
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

    @SneakyThrows
    static BufferedImage simpleResizeImage(Image image, int w, int h) {
        BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        bGr.dispose();
        return Scalr.resize(bimage, w, h);
    }

}
