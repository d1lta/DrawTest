package org.example.window.graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.example.Main;
import org.example.window.components.Button;
import org.example.window.components.Label;
import org.example.window.components.Panel;
import org.example.window.components.TextField;
import org.example.window.components.misc.ContentList;
import org.example.window.components.misc.PanelContent;
import org.example.window.primary.Window;
import org.example.window.primary.WindowEnum;

public class GraphicWindowSetting extends Window implements ActionListener {

    static ContentList contentList = new ContentList();

    public GraphicWindowSetting(WindowEnum e) {
        super(e);
    }

    @Override
    protected void placeComponents() {
        contentList.clear();
        init(new Label("window_settings","<center>Window Settings<center>",108,55,325,25,"Times New Roman", 0,18,0,null,null));
        Panel windowSettings = new Panel("window_settings",108,85,0,0,325,100, Color.LIGHT_GRAY, 0,1,4, null);
        PanelContent panelContent = new PanelContent();
        Arrays.asList("Width", "Height", "Background Color", "Line Color").forEach(it -> {
            PanelContent innerContent = new PanelContent();
            innerContent.add(new Label("in_" + it.toLowerCase().replaceAll(" ","_"), "<center>"+it+"<center>",0,0,0,0,"Times New Roman", 0,14,0,null,null));
            innerContent.add(new TextField("in_" + it.toLowerCase().replaceAll(" ","_"), Main.config.read("window_" + it.toLowerCase().replaceAll(" ", "_")),0,0,0,0,0));
            innerContent.add(new Button("in_save_window_" + it.toLowerCase().replaceAll(" ","_"),"save",0,0,0,0,null,true,false, Collections.singletonList(this),null,0,false));
            panelContent.add(innerContent);
            contentList.add(innerContent);
        });
        windowSettings.apply(panelContent,3, 1);
        init(windowSettings);
        panelContent.clear();
        init(new Label("border_settings","<center>Borders Settings<center>",108,200,325,25,"Times New Roman", 0,18,0,null,null));
        Panel borderSettings = new Panel("Test",108,230,0,0,325,300, Color.LIGHT_GRAY, 0,4,4, null);
        for (int i = 1; i <= 16; i++) {
            PanelContent innerContent = new PanelContent();
            innerContent.add(new Label("in_" + i, "dot_" + i,0,0,0,0,"Times New Roman", 0,14,0,null,null));
            innerContent.add(new TextField("in_x_" + i, Main.config.read("border_x_" + i),0,0,0,0,0));
            innerContent.add(new TextField("in_y_" + i, Main.config.read("border_y_" + i),0,0,0,0,0));
            innerContent.add(new Button("in_save_border_" + i,"save",0,0,0,0,null,true,false, Collections.singletonList(this),null,0,false));
            panelContent.add(innerContent);
            contentList.add(innerContent);
        }
        borderSettings.apply(panelContent,4,1);
        init(borderSettings);
        panelContent.clear();
        init(new Button("back", "<center>Back<center>", 25,590,100,30,null,true,false, Collections.singletonList(this),null,0,true));
        init(new Button("save_all", "<center>Save<center>", 218,590,100,30,null,true,false,Collections.singletonList(this),null,0,true));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            if (((Button) e.getSource()).getName().equals("button_back")) {
                Main.app.changeWindow(WindowEnum.G_SETTINGS);
            }
            if (((Button) e.getSource()).getName().startsWith("button_in_save")) {
                if (((Button) e.getSource()).getName().startsWith("button_in_save_border")) {
                    if (((TextField) contentList.get("textfield_in_x_" + ((Button) e.getSource()).getName().substring(22))).getText().equals("")) {
                        ((TextField) contentList.get("textfield_in_x_" + ((Button) e.getSource()).getName().substring(22))).setText("0");
                    }
                    if (((TextField) contentList.get("textfield_in_y_" + ((Button) e.getSource()).getName().substring(22))).getText().equals("")) {
                        ((TextField) contentList.get("textfield_in_y_" + ((Button) e.getSource()).getName().substring(22))).setText("0");
                    }
                    String keyX = "border_x_" + ((Button) e.getSource()).getName().substring(22);
                    String keyY = "border_y_" + ((Button) e.getSource()).getName().substring(22);
                    String valueX = ((TextField) contentList.get("textfield_in_x_" + ((Button) e.getSource()).getName().substring(22))).getText();
                    String valueY = ((TextField) contentList.get("textfield_in_y_" + ((Button) e.getSource()).getName().substring(22))).getText();
                    System.out.println(keyX + " : " + valueX);
                    System.out.println(keyY + " : " + valueY);
                    Main.config.write(keyX, valueX);
                    Main.config.write(keyY, valueY);
                }
                if (((Button) e.getSource()).getName().startsWith("button_in_save_window_")) {
                    String key = "window_" + ((Button) e.getSource()).getName().substring(22);
                    String value = ((TextField) contentList.get("textfield_in_" + ((Button) e.getSource()).getName().substring(22))).getText();
                    Main.config.write(key,value);
                }
            }
            if (((Button) e.getSource()).getName().startsWith("button_save_all")) {
                contentList.get(TextField.class).forEach(it -> {
                    assert it instanceof TextField;
                    if (((TextField) it).getText().equals("")) {
                        ((TextField) it).setText("0");
                    }
                    if (Character.isDigit(it.getName().substring(15).charAt(0))) {
                        Main.config.write("border_" + it.getName().substring(13), ((TextField) it).getText());
                    } else if (Character.isDigit(it.getName().substring(13).charAt(0))) {
                        Main.config.write("window_" + it.getName().substring(13), ((TextField) it).getText());
                    }
                });
            }
        }
    }
}
