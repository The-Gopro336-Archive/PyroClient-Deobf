/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f42;
import net.minecraft.item.ItemStack;

public class f4F
extends f42 {
    public ItemStack Field4002;
    public int Field4003;
    public int Field4004;

    public int Method5661() {
        return this.Field4004;
    }

    public void Method5662(int n) {
        this.Field4003 = n;
    }

    public ItemStack Method5663() {
        return this.Field4002;
    }

    public void Method5664(int n) {
        this.Field4004 = n;
    }

    public void Method5665(ItemStack itemStack) {
        this.Field4002 = itemStack;
    }

    public int Method5666() {
        return this.Field4003;
    }

    public f4F(ItemStack itemStack, int n, int n2) {
        this.Field4002 = itemStack;
        this.Field4003 = n;
        this.Field4004 = n2;
    }
}

