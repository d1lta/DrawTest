package org.example.window.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import org.example.Main;
import org.example.utils.CMath.Pol;
import org.example.utils.CMath.Rec;
import org.example.window.graphics.misc.Dot;
import org.example.window.graphics.misc.Dots;
import org.example.window.primary.Window;
import org.example.window.primary.WindowEnum;

public class GraphicShow extends Window implements ActionListener, WindowListener {

    Timer timer;
    static Dots dots = new Dots();
    static Dots borders = new Dots();
    final static Color bgColor = Color.decode(Main.config.read("window_background_color"));
    final static Color lineColor = Color.decode(Main.config.read("window_line_color"));
    static int radian = 0;

    public GraphicShow(WindowEnum e) {
        super(e);
        generateDots();
        addWindowListener(this);
        timer = new Timer(1000,this);
        timer.restart();
    }

    @Override
    protected void placeComponents() {
    }

    @Override
    public void paint(Graphics g) {
        try {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(bgColor);
            g2d.fillRect(0,0, getWidth(), getHeight());
            g2d.setColor(lineColor);
            g2d.setStroke(new BasicStroke(2));
            drawBorders(g2d);
            drawLines(g2d);
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }

    void drawBorders(Graphics2D g2d) {
        for (int i = 1; i <= borders.size(); i++) {
            g2d.drawLine(borders.getDot(i).x,borders.getDot(i).y,borders.getDot(borders.getDot(i).id_connect).x, borders.getDot(borders.getDot(i).id_connect).y);
        }
    }

    void test(Graphics2D g2d) { // 50
        Line2D line = new Double();
        Dot d1 = new Dot(30,480);
        Dot d2 = new Dot(470,480); // 200, 250
        line.setLine(d1.x,d1.y,d2.x,d2.y);
        g2d.draw(line);
        g2d.setColor(Color.black);

        System.out.println(getLineLenght(d1,d2));
        for (int i = 0; i <= getLineLenght(d1,d2); i+=getLineLenght(d1,d2) / 4) {

        }
        g2d.draw(line);
    }

    int getLineLenght(Dot d1, Dot d2) {
        double x = d1.x - d2.x;
        double y = d1.y - d2.y;
        return (int) Math.sqrt(x * x + y * y);
    }

    Dot getDotFrom(Dot startLine, Dot endLine, double distance) {
        System.out.println(startLine._toString() + "\n" + endLine._toString() + "\n");
        Pol pol = new Pol(
                endLine.x - startLine.x, // -
                endLine.y - startLine.y); // -
        Rec f = new Rec(distance, pol.getO());
        return new Dot((int) (startLine.x + f.getX()), (int) (startLine.y + f.getY()));
    }

    int i = 10;

    void drawLines(Graphics2D g2d) {

        dots.forEach(dot -> {
            Dot a;
            a = getDotFrom(borders.getDot(dot.side), borders.getDot(dot.id_connect), i);
            dot.x = a.x;
            dot.y = a.y;

        });
        i+=10;

        dots.forEach(dot -> {
            //System.out.println("{\n" + dot._toString() + "\n" + dots.getDot(dot.id_connect)._toString() + "\n}");
        });

        dots.forEach(dot -> {
            g2d.setColor(Color.BLACK);
            g2d.drawLine(dot.x,dot.y, dots.getDot(dot.id_connect).x, dots.getDot(dot.id_connect).y);
            g2d.setColor(Color.WHITE);
        });
    }

    void generateDots() {
        for (int i = 1; i <= 16; i++) { // <borders>
            if ((Integer.parseInt(Main.config.read("border_x_" + i)) != 0) && (Integer.parseInt(Main.config.read("border_y_" + i)) != 0)) {
                borders.add(new Dot(i,(Integer.parseInt(Main.config.read("border_x_" + i))), (Integer.parseInt(Main.config.read("border_y_" + i)))));
            }
        }
        for (int i = 1; i <= borders.size()-1; i++) {
            borders.getDot(i).id_connect = i+1;
        }
        borders.getDot(borders.size()).id_connect = 1;// </borders>

        for (int i = 1; i <= 40; i++) {
            if ((Integer.parseInt(Main.config.read("dot_" + i + ".p")) != 0) && (Integer.parseInt(Main.config.read("dot_" + i + ".s")) != 0)) {
                dots.add(new Dot(i,0, 0, Integer.parseInt(Main.config.read("dot_" + i + ".p")), Integer.parseInt(Main.config.read("dot_" + i + ".s")), Integer.parseInt(Main.config.read("connect_" + i + "_to"))));
            }
        }
        if (dots.size() == 0) {
            dots.clear();
        }
        dots.forEach(dot -> {
            Dot d = getDotFrom(borders.getDot(dot.id), borders.getDot(dot.id_connect), dot.p);
            dot.x = d.x;
            dot.y = d.y;
        });
        dots.forEach(it -> {
            //System.out.println(it._toString());
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            update(getGraphics());
            getGraphics().dispose();
        } catch (NullPointerException ex) {
            ex.fillInStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        timer.stop();
        borders.clear();
        dots.clear();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
