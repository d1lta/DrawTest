package org.example.application;

import java.awt.event.WindowEvent;
import javax.swing.WindowConstants;
import org.example.Main;
import org.example.window.graphics.GraphicConnections;
import org.example.window.graphics.GraphicShow;
import org.example.window.graphics.GraphicWindowSetting;
import org.example.window.graphics.GraphicsMenu;
import org.example.window.graphics.GraphicTest;
import org.example.window.graphics.GraphicsSettings;
import org.example.window.primary.Window;
import org.example.window.primary.WindowEnum;
import org.example.window.Menu;

public class Application implements IApplication {

    public Application() {
        this.setup();
    }

    public Window mainWindow;

    @Override
    public void setup() {
        createWindow(WindowEnum.TEST);
    }

    public void changeWindow(WindowEnum to) {
        this.mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.mainWindow.dispatchEvent(new WindowEvent(this.mainWindow, WindowEvent.WINDOW_CLOSING));
        createWindow(to);
    }

    @Override
    public void createWindow(WindowEnum e) {
        switch (e) {
            case TEST:
                this.mainWindow = new Menu(e);
                break;
            case G_MENU:
                this.mainWindow = new GraphicsMenu(e);
                break;
            case G_TEST:
                new GraphicTest(e);
                break;
            case G_SETTINGS:
                this.mainWindow = new GraphicsSettings(e);
                break;
            case G_WINDOW_SETTINGS:
                this.mainWindow = new GraphicWindowSetting(e);
                break;
            case G_CONNECTIONS:
                this.mainWindow = new GraphicConnections(e);
                break;
            case G_SHOW:
                new GraphicShow(e);
                break;
        }
    }
}
