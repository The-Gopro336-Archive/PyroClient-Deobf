/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.PotionEffect
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f5M;
import dev.nuker.pyro.f5N;
import dev.nuker.pyro.f5k;
import dev.nuker.pyro.f5o;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Collection;
import kotlin.TypeCastException;
import net.minecraft.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

public class f5O
extends f5o {
    public f5O(int n) {
        super("", n);
    }

    @f0g
    @LauncherEventHide
    public void Method840(@NotNull f43 f432) {
        block9: {
            block8: {
                if (f432.Method5619() != f41.Pre) break block8;
                if (fdZ.Field313.world == null) break block8;
                if (fdZ.Field313.player != null) break block9;
            }
            return;
        }
        Collection collection = fdZ.Field313.player.getActivePotionEffects();
        for (f5k f5k2 : this.Field2980.Field2944) {
            if (collection.stream().anyMatch(new f5N(f5k2))) continue;
            f5k2.Method731();
        }
        for (f5k f5k2 : collection) {
            boolean bl = false;
            for (f5k f5k3 : this.Field2980.Field2944) {
                f5q f5q2 = f5k3.Field3010;
                if (f5q2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.PotionEffectElement");
                }
                if (((f5M)f5q2).Method5790().getPotion() != f5k2.getPotion()) continue;
                f5q f5q3 = f5k3.Field3010;
                if (f5q3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.PotionEffectElement");
                }
                ((f5M)f5q3).Method5791((PotionEffect)f5k2);
                bl = true;
                break;
            }
            if (bl) continue;
            this.Field2980.Method4826(new f5k("potion", "General", new f5M((PotionEffect)f5k2), null, false, 24, null));
        }
    }
}

