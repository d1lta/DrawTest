package org.example.window.debug;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import org.example.window.components.Label;

public class Coordinates implements MouseMotionListener {

    Label xy;

    public Coordinates(Window window) {
        xy = new Label("x/y","X/Y: 0/0", 1, 0, 125, 20, "Times New Roman", 0, 18, 2, Color.BLACK, null);
        xy.setBorder(null);
        window.addMouseMotionListener(this);
        xy.addMouseMotionListener(this);
    }

    public Label get() {
        return xy;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.xy.setText("X/Y: " + (e.getX()) + "/" + (e.getY()));
        System.out.println("X/Y: " + (e.getX()) + "/" + (e.getY()));

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.xy.setText("X/Y: " + (e.getX()) + "/" + (e.getY()));
    }

}
