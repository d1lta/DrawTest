package org.example.utils;

import lombok.Getter;

public class CMath {

    public static class Pol {

        @Getter
        double p;
        @Getter
        double o;

        public Pol(double x, double y) {
            this.p = java.lang.Math.sqrt(x*x + y*x);
            if (this.p < 0) {
                this.o = java.lang.Math.atan(y) + java.lang.Math.PI;
            } else {
                this.o = java.lang.Math.atan(y / x);
            }
        }
    }

    public static class Rec {

        @Getter
        double x;
        @Getter
        double y;

        public Rec(double x, double y) {
            this.x = x * java.lang.Math.cos(y);
            this.y = x * java.lang.Math.sin(y);
        }
    }

}
