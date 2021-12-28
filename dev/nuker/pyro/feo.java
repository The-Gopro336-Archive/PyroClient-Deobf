/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import java.awt.Color;

public class feo {
    public float Field468;
    public float[] Field469;
    public Color Field470;

    public static Color Method760(float[] arrf, float f) {
        return feo.Method775(arrf[0], arrf[1], arrf[2], f);
    }

    public feo(Color color) {
        this.Field470 = color;
        this.Field469 = feo.Method764(color);
        this.Field468 = (float)color.getAlpha() / 255.0f;
    }

    public float Method761() {
        return this.Field469[0];
    }

    public float Method762() {
        return this.Field469[1];
    }

    public Color Method763() {
        return feo.Method772((this.Field469[0] + 180.0f) % 360.0f, this.Field469[1], this.Field469[2]);
    }

    public static float[] Method764(Color color) {
        float f;
        float f2;
        float[] arrf = color.getRGBColorComponents(null);
        float f3 = arrf[0];
        float f4 = arrf[1];
        float f5 = arrf[2];
        float f6 = Math.min(f3, Math.min(f4, f5));
        float f7 = Math.max(f3, Math.max(f4, f5));
        float f8 = 0.0f;
        if (f7 == f6) {
            f8 = 0.0f;
            f2 = f7;
        } else if (f7 == f3) {
            f8 = (60.0f * (f4 - f5) / (f7 - f6) + 360.0f) % 360.0f;
            f2 = f7;
        } else if (f7 == f4) {
            f8 = 60.0f * (f5 - f3) / (f7 - f6) + 120.0f;
            f2 = f7;
        } else {
            if (f7 == f5) {
                f8 = 60.0f * (f3 - f4) / (f7 - f6) + 240.0f;
            }
            f2 = f7;
        }
        float f9 = (f2 + f6) / 2.0f;
        if (f7 == f6) {
            f = 0.0f;
        } else {
            float f64 = feo.Method770(f9, 0.5f);
            float f100 = f7;
            f = f64 <= 0.0f ? (f100 - f6) / (f7 + f6) : (f100 - f6) / (2.0f - f7 - f6);
        }
        return new float[]{f8, f * 100.0f, f9 * 100.0f};
    }

    public float[] Method765() {
        return this.Field469;
    }

    public feo(float f, float f2, float f3, float f4) {
        int n = 3;
        float[] arrf = new float[]{f, f2, f3};
        this.Field469 = arrf;
        this.Field468 = f4;
        this.Field470 = feo.Method760(this.Field469, f4);
    }

    public feo(float[] arrf, float f) {
        this.Field469 = arrf;
        this.Field468 = f;
        this.Field470 = feo.Method760(arrf, f);
    }

    public static Color Method766(float[] arrf) {
        return feo.Method760(arrf, 1.0f);
    }

    public feo(float f, float f2, float f3) {
        this(f, f2, f3, 1.0f);
    }

    public Color Method767(float f) {
        return feo.Method775(this.Field469[0], f, this.Field469[2], this.Field468);
    }

    public Color Method768(float f) {
        f = (100.0f + f) / 100.0f;
        f = Math.min(100.0f, this.Field469[2] * f);
        return feo.Method775(this.Field469[0], this.Field469[1], f, this.Field468);
    }

    public feo(float[] arrf) {
        this(arrf, 1.0f);
    }

    public float Method769() {
        return this.Field469[2];
    }

    public static float Method770(float f, float f2) {
        if (f == f2) {
            return 0.0f;
        }
        if (f2 > f) {
            return 2.0f;
        }
        return -1.0f;
    }

    public Color Method771(float f) {
        return feo.Method775(f, this.Field469[1], this.Field469[2], this.Field468);
    }

    public static Color Method772(float f, float f2, float f3) {
        return feo.Method775(f, f2, f3, 1.0f);
    }

    public Color Method773() {
        return this.Field470;
    }

    public Color Method774(float f) {
        f = (100.0f - f) / 100.0f;
        f = Math.max(0.0f, this.Field469[2] * f);
        return feo.Method775(this.Field469[0], this.Field469[1], f, this.Field468);
    }

    public static Color Method775(float f, float f2, float f3, float f4) {
        block6: {
            block5: {
                if (f2 < 0.0f) break block5;
                if (!(f2 > 100.0f)) break block6;
            }
            throw new IllegalArgumentException("Color parameter outside of expected range - Saturation");
        }
        if (f3 < 0.0f || f3 > 100.0f) {
            throw new IllegalArgumentException("Color parameter outside of expected range - Lightness");
        }
        if (f4 < 0.0f || f4 > 1.0f) {
            throw new IllegalArgumentException("Color parameter outside of expected range - Alpha");
        }
        f %= 360.0f;
        float f5 = (double)(f3 /= 100.0f) < 0.0 ? f3 * (1.0f + f2) : f3 + (f2 /= 100.0f) - f2 * f3;
        f2 = 2.0f * f3 - f5;
        f3 = Math.max(0.0f, feo.Method776(f2, f5, (f /= 360.0f) + 0.33333334f));
        float f6 = Math.max(0.0f, feo.Method776(f2, f5, f));
        f2 = Math.max(0.0f, feo.Method776(f2, f5, f - 0.33333334f));
        f3 = Math.min(f3, 1.0f);
        float f7 = Math.min(f6, 1.0f);
        f2 = Math.min(f2, 1.0f);
        return new Color(f3, f7, f2, f4);
    }

    public static float Method776(float f, float f2, float f3) {
        if (f3 < 0.0f) {
            f3 += 1.0f;
        }
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        if (6.0f * f3 < 1.0f) {
            return f + (f2 - f) * 6.0f * f3;
        }
        if (2.0f * f3 < 1.0f) {
            return f2;
        }
        if (3.0f * f3 < 2.0f) {
            return f + (f2 - f) * 6.0f * (0.6666667f - f3);
        }
        return f;
    }

    public float Method777() {
        return this.Field468;
    }

    public Color Method778(float f) {
        return feo.Method775(this.Field469[0], this.Field469[1], f, this.Field468);
    }

    public String toString() {
        return new StringBuilder().insert(0, "HSLColor[h=").append(this.Field469[0]).append(",s=").append(this.Field469[1]).append(",l=").append(this.Field469[2]).append(",alpha=").append(this.Field468).append("]").toString();
    }
}

