package org.example.window.primary;

import javax.swing.WindowConstants;
import lombok.Getter;

public enum WindowEnum {

    TEST(
            "Test Window",
            480,
            540,
            false,
            WindowConstants.EXIT_ON_CLOSE),
    G_MENU(
            "Graphics menu",
            540,
            680,
            false,
            WindowConstants.EXIT_ON_CLOSE),
    G_SETTINGS(
            "Graphic settings",
            540,
            680,
            false,
            WindowConstants.EXIT_ON_CLOSE),
    G_WINDOW_SETTINGS(
            "Graphic window settings",
            540,
            680,
            false,
            WindowConstants.EXIT_ON_CLOSE),
    G_CONNECTIONS(
            "Graphic connections",
            540,
            680,
            false,
            WindowConstants.EXIT_ON_CLOSE),
    G_SHOW(
            "Graphic Show",
            540,
            540,
            true,
            WindowConstants.DISPOSE_ON_CLOSE),
    G_TEST(
            "Graphic Tests",
            540,
            680,
            false,
            WindowConstants.DISPOSE_ON_CLOSE);

    @Getter
    final String defaultName;
    @Getter
    final int defaultWindowX;
    @Getter
    final int defaultWindowY;
    @Getter
    final boolean isDefaultResizable;
    @Getter
    final int defaultCloseOperation;

    WindowEnum(String defaultName, int defaultWindowX, int defaultWindowY, boolean isDefaultResizable, int defaultCloseOperation) {
        this.defaultName = defaultName;
        this.defaultWindowX = defaultWindowX;
        this.defaultWindowY = defaultWindowY;
        this.isDefaultResizable = isDefaultResizable;
        this.defaultCloseOperation = defaultCloseOperation;
    }

}
