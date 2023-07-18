package org.example.window.primary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import lombok.Getter;
import lombok.SneakyThrows;
import org.example.Main;
import org.example.utils.TextUtil;
import org.example.window.debug.Borders;
import org.example.window.debug.Coordinates;
import org.example.window.debug.WindowInfo;

public abstract class Window extends JFrame implements IWindow {

    @Getter
    WindowEnum windowEnum;

    TextUtil textUtil = new TextUtil();

    @Getter
    List<Object> componentList = new ArrayList<>();

    public Window(WindowEnum e) {

        addWindowListener(new WindowListener(this));
        this.windowEnum = e;
        setName(e.defaultName);
        Main.windows.add(this);
        pack();
        if (e == WindowEnum.G_SHOW) {
            showUnique();
        } else {
            setSize(e.defaultWindowX, e.defaultWindowY);
        }
        setLocationRelativeTo(null);
        setTitle(textUtil.textNoHTML(e.defaultName));
        placeComponents();
        if (Main.isDebug()) {
            init(new Coordinates(this).get());
            //init(new Borders().get());
            //init(new WindowInfo(this).get());
        }
        setResizable(e.isDefaultResizable);
        setLayout(null);
        setDefaultCloseOperation(e.defaultCloseOperation);
        setVisible(true);
    }

    void showUnique() {
        if (Integer.parseInt(Main.config.read("window_width")) < 100 || Integer.parseInt(Main.config.read("window_height")) < 100) {
            setSize(WindowEnum.G_SHOW.defaultWindowX, WindowEnum.G_SHOW.defaultWindowY);
        } else {
            setSize(Integer.parseInt(Main.config.read("window_width")), Integer.parseInt(Main.config.read("window_height")));
        }
    }

    public void init(Component c) {
        componentList.add(c);
        add(c);
    }

    protected abstract void placeComponents();

}
