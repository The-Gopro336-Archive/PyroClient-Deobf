/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f8J;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class f8H
implements Predicate {
    public f8J Field3361;

    public boolean Method2427(@NotNull Entity entity) {
        return this.Field3361.Method2425(entity);
    }

    public f8H(f8J f8J2) {
        this.Field3361 = f8J2;
    }

    public boolean test(Object object) {
        return this.Method2427((Entity)object);
    }
}

