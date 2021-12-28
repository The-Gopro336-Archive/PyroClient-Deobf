/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdF;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdA
extends Lambda
implements Function1 {
    public fdF Field228;

    public Object Method41(Object object) {
        return this.Method297((ItemStack)object);
    }

    public fdA(fdF fdF2) {
        this.Field228 = fdF2;
        super(1);
    }

    public boolean Method297(@NotNull ItemStack itemStack) {
        ItemStack itemStack2 = fdF.Method306(this.Field228);
        if (itemStack2 == null) {
            Intrinsics.Method6551();
        }
        return this.Field228.Method312(itemStack2, itemStack);
    }
}

