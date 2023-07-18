package org.example.window.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.soap.Text;
import org.example.Config;
import org.example.Main;
import org.example.utils.LineUtils;
import org.example.window.components.Button;
import org.example.window.components.Label;
import org.example.window.components.Panel;
import org.example.window.components.TextField;
import org.example.window.components.misc.PanelContent;
import org.example.window.primary.Window;
import org.example.window.primary.WindowEnum;

public class GraphicsSettings extends Window implements ActionListener {

    public GraphicsSettings(WindowEnum e) {
        super(e);
    }

    static List<PanelContent> contentList = new ArrayList<>();

    @Override
    protected void placeComponents() {
        init(new Label("title", this.getWindowEnum().getDefaultName(),170,20,200,30,"Times New Roman", 0,24,0,null,null));

        PanelContent hint = new PanelContent();
        hint.add(new Label("hint_1", "X",0,0,0,0,"Times New Roman", 0,14,0,null,null));
        hint.add(new Label("hint_3", "SIDE (1-4)",0,0,0,0,"Times New Roman", 0,14,0,null,null));
        hint.add(new Label("hint_2", "Line lenght",0,0,0,0,"Times New Roman", 0,14,0,null,null));
        init(new Panel("hint",218,70,0,0,100,50, Color.LIGHT_GRAY,0,3,1,hint));
        Panel panel = new Panel("Test",25,135,0,0,488,400, Color.LIGHT_GRAY, 0,4,10, null);
        init(new Button("back", "<center>Back<center>", 25,590,120,30,null,true,false,Collections.singletonList(this),null,0,true));
        init(new Button("save_all", "<center>Save<center>", 208,590,120,30,null,true,false,Collections.singletonList(this),null,0,true));
        init(new Button("show_settings", "<center>Show Settings<center>", 394,550,120,30,null,true,false,Collections.singletonList(this),null,0,true));
        init(new Button("connections", "<center>Connections<center>", 394,590,120,30,null,true,false,Collections.singletonList(this),null,0,true));

        for(int i = 1; i <= 40; i++) {
            PanelContent innerContent = new PanelContent();
            innerContent.add(new Label("in_" + i, "dot_" + i,0,0,0,0,"Times New Roman", 0,14,0,null,null));
            innerContent.add(new TextField("in_P_" + i, Main.config.read("dot_" + i + ".p"),0,0,0,0,0));
            innerContent.add(new TextField("in_S_" + i, Main.config.read("dot_" + i + ".s"),0,0,0,0,0));
            innerContent.add(new Label("in_line_lenght_" + i, "" + LineUtils.getLenght(i),0,0,0,0,"Times New Roman", 0,14,0,null,null));
            innerContent.add(new Button("in_SAVE_" + i,"ok",0,0,0,0,null,true,false, Collections.singletonList(this),null,0,false));
            contentList.add(innerContent);
            panel.add(new Panel("in_P",0,0,0,0,0,0, Color.LIGHT_GRAY,0,5,1,innerContent));
        }
        init(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (((Button) e.getSource()).getName().startsWith("button_in_SAVE")) {
                contentList.forEach(it -> {
                    if (it.getContents().get(0).getName().substring(9).equals(((Button) e.getSource()).getName().substring(15))) {
                        it.getContents().forEach(its -> {
                            if (its.getName().equals("textfield_in_P_" + (((Button) e.getSource()).getName().substring(15)))) {
                                if (((TextField) its).getText().equals("")) {
                                    Main.config.write("dot_" + it.getContents().get(0).getName().substring(9) + ".p", "0");
                                    ((TextField) its).setText("0");
                                } else {
                                    Main.config.write("dot_" + it.getContents().get(0).getName().substring(9) + ".p", ((TextField) its).getText());
                                }
                            } else if (its.getName().equals("textfield_in_S_" + (((Button) e.getSource()).getName().substring(15)))) {
                                if (((TextField) its).getText().equals("")) {
                                    Main.config.write("dot_" + it.getContents().get(0).getName().substring(9) + ".s", "0");
                                    ((TextField) its).setText("0");
                                } else {
                                    Main.config.write("dot_" + it.getContents().get(0).getName().substring(9) + ".s", ((TextField) its).getText());
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
                                Main.config.write("dot_" + its.getName().substring(15) + "." + its.getName().toLowerCase().charAt(13), "0");
                                ((TextField) its).setText("0");
                            } else {
                                Main.config.write("dot_" + its.getName().substring(15) + "." + its.getName().toLowerCase().charAt(13), ((TextField) its).getText());
                            }
                        }
                    });
                });
            }
            if (((Button) e.getSource()).getName().startsWith("button_back")) {
                Main.app.changeWindow(WindowEnum.G_MENU);
            }
            if (((Button) e.getSource()).getName().startsWith("button_connections")) {
                Main.app.changeWindow(WindowEnum.G_CONNECTIONS);
            }
            if (((Button) e.getSource()).getName().startsWith("button_show_settings")) {
                Main.app.changeWindow(WindowEnum.G_WINDOW_SETTINGS);
            }
        }
    }
}
