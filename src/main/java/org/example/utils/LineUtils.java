package org.example.utils;

import org.example.Main;
import org.example.window.graphics.misc.Dot;

public class LineUtils {

    public static int getLenght(int b1) {
        int b2 = Integer.parseInt(Main.config.read("connect_" + b1 + "_to"));
        if (b2 == 0) {
            return 0;
        }
        if ((Integer.parseInt(Main.config.read("border_x_" + b1)) == 0) && (Integer.parseInt(Main.config.read("border_y_" + b1)) == 0)) {
            return 0;
        }
        if ((Integer.parseInt(Main.config.read("border_x_" + b2)) == 0) && (Integer.parseInt(Main.config.read("border_y_" + b2)) == 0)) {
            return 0;
        }
        Dot d1 = new Dot(Integer.parseInt(Main.config.read("border_x_" + b1)), Integer.parseInt(Main.config.read("border_y_" + b1)));
        Dot d2 = new Dot(Integer.parseInt(Main.config.read("border_x_" + b2)), Integer.parseInt(Main.config.read("border_y_" + b2)));
        double x = d1.x - d2.x;
        double y = d1.y - d2.y;
        return (int) Math.sqrt(x * x + y * y);
    }
}
