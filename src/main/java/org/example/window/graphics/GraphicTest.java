package org.example.window.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Timer;
import lombok.SneakyThrows;
import org.example.window.primary.Window;
import org.example.window.primary.WindowEnum;

public class GraphicTest extends Window implements ActionListener {

    //Dot d1 = new Dot(270,30,1);
    //Dot d2 = new Dot(530,320,2);
    //Dot d3 = new Dot(10,320,4);
    Dot d1 = new Dot(10,240,4);
    Dot d2 = new Dot(260,30,1);
    Dot d3 = new Dot(530,240,2);
    Dot d4 = new Dot(390,670,3);
    Dot d5 = new Dot(130,670,3);

    Timer timer;

    public GraphicTest(WindowEnum e) {
        super(e);
        getContentPane().setBackground(Color.WHITE);
        timer = new Timer(5,this);
        timer.restart();
    }

    @Override
    protected void placeComponents() {
    }

    @SneakyThrows
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g2d.fillRect(10,30,520,640);
        updateAll(d1,d2,d3,d4,d5);
        g2d.setColor(Color.CYAN);
        g2d.drawLine(d1.x,d1.y,d3.x,d3.y);
        g2d.drawLine(d2.x,d2.y,d4.x,d4.y);
        g2d.drawLine(d3.x,d3.y,d5.x,d5.y);
        g2d.drawLine(d4.x,d4.y,d1.x,d1.y);
        g2d.drawLine(d5.x,d5.y,d2.x,d2.y);
        g2d.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update(getGraphics());
        getGraphics().dispose();

    }

    public void updateAll(Dot... dots) {
        Arrays.stream(dots).forEach(Dot::update);
    }

    private static class Dot {

        int x;
        int y;
        int side;

        Dot(int x, int y, int side) {
            this.x = x;
            this.y = y;
            this.side = side;
        }

        void update() {
            if (side == 1 && x == 530) {
                side = 2;
            } else if (side == 2 && y == 670) {
                side = 3;
            } else if (side == 3 && x == 10) {
                side = 4;
            } else if (side == 4 && y == 30) {
                side = 1;
            }
            if (side == 1) {
                x+=10;
            } else if (side == 2) {
                y+=10;
            } else if (side == 3) {
                x-=10;
            } else if(side == 4) {
                y-=10;
            }
        }
    }
}
