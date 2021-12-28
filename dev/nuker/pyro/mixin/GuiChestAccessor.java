/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiChest
 *  net.minecraft.inventory.IInventory
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.IInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiChest.class})
public interface GuiChestAccessor {
    @Accessor(value="lowerChestInventory")
    public IInventory Method787();

    @Accessor(value="upperChestInventory")
    public IInventory Method788();
}

