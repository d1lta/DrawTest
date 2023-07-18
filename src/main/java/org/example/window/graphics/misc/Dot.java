package org.example.window.graphics.misc;

import javafx.geometry.Side;
import lombok.Getter;

public class Dot {

    public int id;
    public int x;
    public int y;
    public int p;
    public int side;
    public int id_connect;
    public boolean d = false;

    public Dot(int id, int x, int y, int p, int side, int id_connect) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.p = p;
        this.side = side;
        this.id_connect = id_connect;
    }

    public Dot(int x, int y) {
        this.id = 0;
        this.x = x;
        this.y = y;
        this.side = -1;
        this.id_connect = -1;
    }

    public Dot(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.side = -1;
        this.id_connect = -1;
    }

    public void setConnect(int id_connect) {
        this.id_connect = id_connect;
    }

    public String _toString() {
        String s = "[";
        s += "id: " + this.id + ", ";
        s += "x: " + this.x + ", ";
        s += "y: " + this.y + ", ";
        s += "p: " + this.p + ", ";
        s += "side: " + this.side + ", ";
        s += "id_connect: " + this.id_connect;
        s += "]";
        return s;
    }

    public void update() {

        if (side == 1) {
            x+=5;
        } else if (side == 2) {
            y+=5;
        } else if (side == 3) {
            x-=5;
        } else if(side == 4) {
            y-=5;
        }
        if (side == 1 && x > 525) {
            x = 525;
        } else if (side == 2 && y > 523) {
            y = 523;
        } else if (side == 3 && x < 15) {
            x = 15;
        } else if (side == 4 && y < 38) {
            y = 38;
        }
        if (side == 1 && x == 525) {
            side = 2;
        } else if (side == 2 && y == 523) {
            side = 3;
        } else if (side == 3 && x == 15) {
            side = 4;
        } else if (side == 4 && y == 38) {
            side = 1;
        }
    }
}
