package org.example;

import java.util.Arrays;
import java.util.Objects;

public class ConfigInitialization {

    public static void configHandle() {
        Arrays.asList("Width", "Height", "Background Color", "Line Color").forEach(it -> {
            if (Main.config.read("window_" + it.toLowerCase().replaceAll(" ", "_")) == null) {
                Main.config.write("window_" + it.toLowerCase().replaceAll(" ", "_"), "0");
            }
        });
        for (int i = 1; i <= 16; i++) {
            if (Main.config.read("border_x_" + i) == null) {
                Main.config.write("border_x_" + i, "0");
            }
            if (Main.config.read("border_y_" + i) == null) {
                Main.config.write("border_y_" + i, "0");
            }
        }
        for (int i = 1; i <= 40; i++) {
            if (Main.config.read("dot_" + i + ".p") == null || Objects.equals(
                    Main.config.read("dot_" + i + ".p"), "null")) {
                Main.config.write("dot_" + i + ".p", "0");
            }
            if (Main.config.read("dot_" + i + ".s") == null) {
                Main.config.write("dot_" + i + ".s", "0");
            }
            if (Main.config.read("connect_" + i + "_to") == null) {
                Main.config.write("connect_" + i + "_to", "0");
            }
        }
    }

}
