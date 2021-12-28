/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fbg;
import dev.nuker.pyro.fbh;
import dev.nuker.pyro.fe8;
import net.minecraft.util.math.Vec3d;

public class fbf {
    public String Field2121;
    public Vec3d Field2122;
    public boolean Field2123;
    public int Field2124;
    public fe8 Field2125;
    public double Field2126;
    public fbg Field2127;
    public fbh Field2128;

    public int Method2753() {
        return this.Field2124;
    }

    public Vec3d Method2754() {
        return this.Field2122;
    }

    public void Method2755() {
        this.Field2122 = this.Field2122.addVector(0.0, this.Field2126, 0.0);
        if (this.Field2125.Method491(1000.0)) {
            this.Field2123 = true;
        }
    }

    public fbg Method2756() {
        return this.Field2127;
    }

    public String Method2757() {
        return this.Field2121;
    }

    public boolean Method2758() {
        return this.Field2123;
    }

    public fbf(fbh fbh2, String string, Vec3d vec3d, int n, fbg fbg2) {
        this.Field2128 = fbh2;
        this.Field2125 = new fe8();
        this.Field2126 = 0.0;
        this.Field2121 = string;
        this.Field2122 = vec3d;
        this.Field2124 = n;
        this.Field2125.Method490();
        this.Field2126 = Math.random();
        this.Field2127 = fbg2;
        while (this.Field2126 > 0.025 || this.Field2126 < 0.011) {
            this.Field2126 = Math.random();
        }
    }
}

