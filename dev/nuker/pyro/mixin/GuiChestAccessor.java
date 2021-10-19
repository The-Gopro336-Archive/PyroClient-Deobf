/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.IInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({GuiChest.class})
public interface GuiChestAccessor {
   @Accessor("lowerChestInventory")
   IInventory getLowerChestInventory();

   @Accessor("upperChestInventory")
   IInventory getUpperChestInventory();
}
