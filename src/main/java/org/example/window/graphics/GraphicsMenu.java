package org.example.window.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import org.example.Main;
import org.example.window.components.Button;
import org.example.window.components.Label;
import org.example.window.components.Panel;
import org.example.window.components.misc.PanelContent;
import org.example.window.primary.Window;
import org.example.window.primary.WindowEnum;

public class GraphicsMenu extends Window implements ActionListener {

    public GraphicsMenu(WindowEnum e) {
        super(e);
    }

    @Override
    protected void placeComponents() {
        init(new Button("show","<center>Look<center>", 218,200,100,35,null,true,false, Collections.singletonList(this),null,0,true));
        init(new Button("old_show","<center>Old Show<center>", 218,510,100,35,null,true,false, Collections.singletonList(this),null,0,true));
        init(new Button("graphic_settings","<center>Settings<center>", 218,550,100,35,null,true,false, Collections.singletonList(this),null,0,true));
        init(new Button("back", "<center>Back<center>", 218,590,100,35,null,true,false, Collections.singletonList(this),null,0,true));
        init(new Button("debug", "<center>debug<center>", 218,470,100,35,null,true,false, Collections.singletonList(this),null,0,true));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (((Button) e.getSource()).getName().equals("button_show")) {
                Main.app.createWindow(WindowEnum.G_SHOW);
            }
            if (((Button) e.getSource()).getName().equals("button_old_show")) {
                Main.app.createWindow(WindowEnum.G_TEST);
            }
            if (((Button) e.getSource()).getName().equals("button_graphic_settings")) {
                Main.app.changeWindow(WindowEnum.G_SETTINGS);
            }
            if (((Button) e.getSource()).getName().equals("button_back")) {
                Main.app.changeWindow(WindowEnum.TEST);
            }
            if (((Button) e.getSource()).getName().equals("button_debug")) {
                System.out.println("---");
                System.out.println(Main.app.mainWindow.getName() + " MAIN");
                Main.windows.forEach(it -> {
                    System.out.println(it.getName());
                });
                System.out.println("---");
            }
        }
    }
}
