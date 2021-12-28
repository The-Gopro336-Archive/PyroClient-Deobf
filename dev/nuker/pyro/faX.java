/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityWolf
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityWolf;
import org.jetbrains.annotations.Nullable;

public class faX
implements Predicate {
    public static faX Field1734 = new faX();

    public boolean Method2427(@Nullable Entity entity) {
        return entity instanceof EntityWolf || entity instanceof AbstractHorse;
    }

    public boolean test(Object object) {
        return this.Method2427((Entity)object);
    }
}

