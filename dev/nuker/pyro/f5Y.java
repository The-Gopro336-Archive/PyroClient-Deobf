/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f5T;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.feo;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5Y
extends f5T {
    public int Field4240;
    public boolean Field4241;
    @NotNull
    public String Field4242;
    public int Field4243;

    public void Method2680(int n) {
        this.Field4243 = n;
    }

    public void Method5736(@NotNull String string) {
        this.Field4242 = string;
    }

    public void Method2377(int n) {
        this.Field4240 = n;
    }

    public void Method4824(boolean bl) {
        this.Field4241 = bl;
    }

    public int Method5742() {
        return this.Field4240;
    }

    public void Method456() {
        Entity entity = fdZ.Field313.world.getEntityByID(this.Field4243);
        if (entity != null) {
            String string;
            StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
            String string2 = "%s [%.1f]";
            Object[] arrobject = new Object[]{entity.getName(), Float.valueOf(fdZ.Field313.player.getDistance(entity))};
            f5Y f5Y2 = this;
            boolean bl = false;
            f5Y2.Field4242 = string = String.format(string2, Arrays.copyOf(arrobject, arrobject.length));
            float f = entity.getDistance((Entity)fdZ.Field313.player);
            float f2 = f >= 60.0f ? 120.0f : f + f;
            this.Field4240 = new feo(f2, 100.0f, 50.0f, 1.0f).Method773().getRGB();
        }
    }

    @Override
    public int Method4968(@Nullable ScaledResolution scaledResolution, float f, float f2) {
        if (this.Field4241) {
            return 1831126;
        }
        return this.Field4240;
    }

    public f5Y(@NotNull String string, boolean bl, @NotNull String string2, int n) {
        super(string);
        this.Field4241 = bl;
        this.Field4242 = string2;
        this.Field4243 = n;
        this.Field4240 = -1;
    }

    public boolean Method5743() {
        return this.Field4241;
    }

    public int Method2376() {
        return this.Field4243;
    }

    @Override
    @NotNull
    public String Method4969() {
        return this.Field4242;
    }

    @NotNull
    public String Method4911() {
        return this.Field4242;
    }
}

