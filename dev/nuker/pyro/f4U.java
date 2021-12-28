/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f41;
import dev.nuker.pyro.f42;
import java.util.function.Consumer;
import net.minecraft.client.entity.EntityPlayerSP;

public class f4u
extends f42 {
    public float Field4184;
    public float Field4185;
    public double Field4186;
    public boolean Field4187;
    public Consumer<EntityPlayerSP> Field4188 = null;
    public boolean Field4189;

    public void Method5814() {
        this.Field4189 = true;
    }

    public double Method5815() {
        return this.Field4186;
    }

    public float Method5651() {
        return this.Field4184;
    }

    public boolean Method5594() {
        return this.Field4187;
    }

    public void Method5816(Consumer consumer) {
        this.Field4188 = consumer;
    }

    public float Method5817() {
        return this.Field4185;
    }

    public void Method5597(boolean bl) {
        this.Field4187 = bl;
    }

    public boolean Method5818() {
        return this.Field4189;
    }

    public Consumer Method5819() {
        return this.Field4188;
    }

    public void Method5820(double d) {
        this.Field4186 = d;
    }

    public f4u(f41 f412, float f, float f2, double d, boolean bl) {
        super(f412);
        this.Field4184 = f;
        this.Field4185 = f2;
        this.Field4186 = d;
        this.Field4187 = bl;
    }

    public void Method5653(float f) {
        this.Field4185 = f;
    }

    public void Method5647(float f) {
        this.Field4184 = f;
    }
}

