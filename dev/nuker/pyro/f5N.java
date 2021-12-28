/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.PotionEffect
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f5M;
import dev.nuker.pyro.f5k;
import dev.nuker.pyro.f5q;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import net.minecraft.potion.PotionEffect;

public class f5N
implements Predicate {
    public f5k Field4156;

    public boolean test(Object object) {
        return this.Method5792((PotionEffect)object);
    }

    public boolean Method5792(PotionEffect potionEffect) {
        f5q f5q2 = this.Field4156.Field3010;
        if (f5q2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.PotionEffectElement");
        }
        return potionEffect.getPotion() == ((f5M)f5q2).Method5790().getPotion();
    }

    public f5N(f5k f5k2) {
        this.Field4156 = f5k2;
    }
}

