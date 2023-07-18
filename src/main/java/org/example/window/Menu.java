package org.example.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import org.example.Main;
import org.example.window.components.Button;
import org.example.window.primary.Window;
import org.example.window.primary.WindowEnum;

public class Menu extends Window implements ActionListener {

    public Menu(WindowEnum e) {
        super(e);
    }

    @Override
    protected void placeComponents() {
        init(new Button("Graphics","<center>Graphics<center>", 190,77,100,35,null,true,false,
                Collections.singletonList(this),null,0,true)); //216 103
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (((Button) e.getSource()).getName().equals("button_Graphics")) {
                Main.app.changeWindow(WindowEnum.G_MENU);
            }
        }
    }
}
