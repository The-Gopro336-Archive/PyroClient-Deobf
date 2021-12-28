/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fe8;
import dev.nuker.pyro.feo;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;

public class feq {
    public ArrayList<Integer> Field519;
    public ArrayList<Integer> Field520;
    public fe8 Field521;
    public int Field522;
    public float Field523;
    public float Field524;
    public float Field525;

    public void Method868(float f) {
        this.Field525 = f;
    }

    public int Method869(int n) {
        int n2 = n;
        if (n2 > this.Field519.size() - 1) {
            n2 = this.Field519.size() - 1;
        }
        return ((Number)this.Field520.get(((Number)this.Field519.get(n2)).intValue())).intValue();
    }

    public feq(int n, float f, float f2, float f3) {
        this.Field522 = n;
        this.Field523 = f;
        this.Field524 = f2;
        this.Field525 = f3;
        this.Field519 = new ArrayList();
        this.Field520 = new ArrayList();
        this.Field521 = new fe8();
        int n2 = 359;
        for (int i = 0; i <= n2; ++i) {
            this.Field520.add(feo.Method775(i, this.Field523, this.Field524, this.Field525).getRGB());
            this.Field519.add(i);
        }
    }

    public void Method870() {
        if (this.Field521.Method491(this.Field522)) {
            this.Field521.Method490();
            this.Method875();
        }
    }

    public void Method871(float f) {
        this.Field524 = f;
    }

    public float Method872() {
        return this.Field523;
    }

    public float Method873() {
        return this.Field524;
    }

    public void Method874(int n) {
        this.Field522 = n;
    }

    public void Method875() {
        if (this.Field519.isEmpty()) {
            return;
        }
        this.Field519.remove(this.Field519.get(0));
        int n = ((Number)this.Field519.get(this.Field519.size() - 1)).intValue() + 1;
        if (n >= this.Field520.size() - 1) {
            n = 0;
        }
        this.Field519.add(n);
    }

    public feq(int n, float f, float f2, float f3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            f3 = 1.0f;
        }
        this(n, f, f2, f3);
    }

    public void Method876(float f) {
        this.Field523 = f;
    }

    public float Method877() {
        return this.Field525;
    }
}

