/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import java.awt.Color;
import java.util.Random;

public class fdK {
    public static int[] Field230 = new int[]{0xFF0000, 0xFF4000, 0xFF7F00, 0xFFFF00, 0x80FF00, 65280, 65535, 33023, 255};
    public static Random Field231 = new Random();

    public static double[] Method327(int n) {
        return new double[]{(double)(n >> 16 & 0xFF) / 255.0, (double)(n >> 8 & 0xFF) / 255.0, (double)(n & 0xFF) / 255.0, (double)(n >> 24 & 0xFF) / 255.0, (double)(n >> 24 & 0xFF) / 255.0};
    }

    public static Color Method328(Color color, Color color2, float f) {
        if (f < 0.0f) {
            return color2;
        }
        if (f > 1.0f) {
            return color;
        }
        float f2 = 1.0f - f;
        float[] arrf = new float[3];
        float[] arrf2 = new float[3];
        color.getColorComponents(arrf);
        color2.getColorComponents(arrf2);
        return new Color(arrf[0] * f + arrf2[0] * f2, arrf[1] * f + arrf2[1] * f2, arrf[2] * f + arrf2[2] * f2);
    }

    public static int Method329() {
        return Color.HSBtoRGB((float)Math.random(), (float)Math.random() / 4.0f + 0.75f, (float)Math.random() / 2.0f + 0.25f);
    }

    public static int Method330() {
        float f = Field231.nextFloat();
        float f2 = (float)Field231.nextInt(5000) / 10000.0f + 0.5f;
        float f3 = (float)Field231.nextInt(5000) / 10000.0f + 0.5f;
        return Color.HSBtoRGB(f, f2, f3);
    }

    public static int Method331(String string) {
        if (string.startsWith("#")) {
            string = string.substring(1);
        }
        if (string.toLowerCase().startsWith("0x")) {
            string = string.substring(2);
        }
        try {
            return (int)Long.parseLong(string, 16);
        }
        catch (Exception exception) {
            return -1;
        }
    }
}

