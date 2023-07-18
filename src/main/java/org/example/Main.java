package org.example;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.example.application.Application;
import org.example.window.primary.Window;

public class Main  {

    @Getter
    public static boolean debug = false;

    @Getter
    @Setter
    public static boolean bordered = false;

    @Getter
    public static Window mainWindow;

    @Getter
    public static List<Window> windows = new ArrayList<>();

    @Getter
    public static Application app;

    @Getter
    public static Config config;

    public static void main(String[] args) {
        config = new Config();
        ConfigInitialization.configHandle();
        app = new Application();
    }
}