/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdE
extends Lambda
implements Function1 {
    public static fdE Field213 = new fdE();

    public Object Method41(Object object) {
        return this.Method297((ItemStack)object);
    }

    public boolean Method297(@NotNull ItemStack itemStack) {
        return itemStack.isEmpty();
    }

    public fdE() {
        super(1);
    }
}

