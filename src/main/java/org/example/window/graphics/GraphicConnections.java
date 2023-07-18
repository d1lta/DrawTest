package org.example.window.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.Main;
import org.example.window.components.Button;
import org.example.window.components.Label;
import org.example.window.components.Panel;
import org.example.window.components.TextField;
import org.example.window.components.misc.PanelContent;
import org.example.window.primary.Window;
import org.example.window.primary.WindowEnum;

public class GraphicConnections extends Window implements ActionListener {

    static List<PanelContent> contentList = new ArrayList<>();

    public GraphicConnections(WindowEnum e) {
        super(e);
    }

    @Override
    protected void placeComponents() {
        Panel panel = new Panel("Test",25,40,0,0,488,520, Color.LIGHT_GRAY, 0,10,2, null);
        init(new Button("back", "<center>Back<center>", 25,590,120,30,null,true,false, Collections.singletonList(this),null,0,true));
        init(new Button("save_all", "<center>Save<center>", 208,590,120,30,null,true,false,Collections.singletonList(this),null,0,true));

        for (int i = 1; i <= 40; i++) {
            PanelContent content = new PanelContent();
            content.add(new Label("connect_" + i + "_to", "Dot " + i + " connected to " ,0,0,0,0,"Times New Roman", 0,14,0,null,null));
            content.add(new TextField("connect_" + i + "_to", Main.config.read("connect_" + i + "_to"),0,0,0,0,0));
            content.add(new Button("in_SAVE_" + i,"save",0,0,0,0,null,true,false, Collections.singletonList(this),null,0,false));
            contentList.add(content);
            panel.add(new Panel("in_P",0,0,0,0,0,0, Color.LIGHT_GRAY,0,3,1,content));
        }
        init(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (((Button) e.getSource()).getName().startsWith("button_in_SAVE")) {
                contentList.forEach(it -> {
                    if (it.getContents().get(0).getName().replaceAll("[^\\d.]", "").equals(((Button) e.getSource()).getName().substring(15))) {
                        it.getContents().forEach(its -> {
                            if (its.getName().equals("textfield_connect_" + ((Button) e.getSource()).getName().substring(15) + "_to")) {
                                if (((TextField) its).getText().equals("")) {
                                    Main.config.write("connect_" + ((Button) e.getSource()).getName().substring(15) + "_to", "0");
                                    ((TextField) its).setText("0");
                                } else {
                                    Main.config.write("connect_" + ((Button) e.getSource()).getName().substring(15) + "_to", ((TextField) its).getText());
                                }
                            }
                        });
                    }
                });
            }
            if (((Button) e.getSource()).getName().startsWith("button_save_all")) {
                contentList.forEach(it -> {
                    it.getContents().forEach(its -> {
                        if (its instanceof TextField) {
                            if (((TextField) its).getText().equals("")) {
                                Main.config.write("connect_" + its.getName().replaceAll("[^\\d.]", "") + "_to", "0");
                                ((TextField) its).setText("0");
                            } else {
                                Main.config.write("connect_" + its.getName().replaceAll("[^\\d.]", "") + "_to", ((TextField) its).getText());
                            }
                        }
                    });
                });
            }
            if (((Button) e.getSource()).getName().startsWith("button_back")) {
                Main.app.changeWindow(WindowEnum.G_SETTINGS);
            }
        }
    }
}
