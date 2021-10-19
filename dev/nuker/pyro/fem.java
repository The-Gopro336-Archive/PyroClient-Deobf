/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class fem extends fdZ {
   // $FF: renamed from: c (net.minecraft.block.Block) int
   public static int method_1747(Block var0) {
      for(int var1 = 0; var1 < 9; ++var1) {
         if (c.player.inventory.getStackInSlot(var1).getItem() instanceof ItemBlock && ((ItemBlock)c.player.inventory.getStackInSlot(var1).getItem()).getBlock().equals(var0)) {
            return var1;
         }
      }

      return -1;
   }

   // $FF: renamed from: c (net.minecraft.item.Item) int
   public static int method_1748(Item var0) {
      for(int var1 = 0; var1 < 9; ++var1) {
         if (c.player.inventory.getStackInSlot(var1).getItem().equals(var0)) {
            return var1;
         }
      }

      return -1;
   }
}
