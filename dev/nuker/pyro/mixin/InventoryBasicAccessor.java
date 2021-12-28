/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.util.NonNullList
 */
package dev.nuker.pyro.mixin;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.util.NonNullList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={InventoryBasic.class})
public interface InventoryBasicAccessor {
    @Accessor(value="inventoryContents")
    public NonNullList Method919();
}

