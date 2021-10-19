/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.util.NonNullList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({InventoryBasic.class})
public interface InventoryBasicAccessor {
   @Accessor("inventoryContents")
   NonNullList getInventoryContents();
}
