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

public class fdt
extends Lambda
implements Function1 {
    public static fdt Field395 = new fdt();

    public fdt() {
        super(1);
    }

    public boolean Method297(@NotNull ItemStack itemStack) {
        return itemStack.isEmpty();
    }

    public Object Method41(Object object) {
        return this.Method297((ItemStack)object);
    }
}

