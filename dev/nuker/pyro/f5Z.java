/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f5T;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.feo;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5Z
extends f5T {
    @NotNull
    public String Field4245 = "";
    public int Field4246 = 0xAAAAAA;

    public int Method2376() {
        return this.Field4246;
    }

    @Override
    @NotNull
    public String Method4969() {
        return this.Field4245;
    }

    public void Method2377(int n) {
        this.Field4246 = n;
    }

    @f0g
    @LauncherEventHide
    public void Method840(@NotNull f43 f432) {
        if (f432.Method5619() == f41.Pre) {
            if (fdZ.Field313.player != null) {
                if (fdZ.Field313.player.inventory.getCurrentItem().isItemStackDamageable()) {
                    String string;
                    int n = fdZ.Field313.player.inventory.getCurrentItem().getMaxDamage();
                    int n2 = fdZ.Field313.player.inventory.getCurrentItem().getItemDamage();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
                    String string2 = "\u00a77Durability \u00a7r%s";
                    Object[] arrobject = new Object[]{n - n2};
                    f5Z f5Z2 = this;
                    boolean bl = false;
                    f5Z2.Field4245 = string = String.format(string2, Arrays.copyOf(arrobject, arrobject.length));
                    this.Field4246 = new feo((float)(n - n2) / (float)n * 120.0f, 100.0f, 50.0f, 1.0f).Method773().getRGB();
                } else {
                    this.Field4245 = "\u00a77Durability \u00a7rInf";
                }
            }
        }
    }

    public f5Z() {
        super("ping");
    }

    @Override
    public int Method4968(@Nullable ScaledResolution scaledResolution, float f, float f2) {
        return this.Field4246;
    }
}

