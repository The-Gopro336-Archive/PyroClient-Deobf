/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class fe9 extends fdZ {
   // $FF: renamed from: c (net.minecraft.entity.Entity, boolean) boolean
   public boolean method_1822(Entity var1, boolean var2) {
      BlockPos var3 = new BlockPos(MathHelper.floor(var1.posX), MathHelper.floor(var1.posY), MathHelper.floor(var1.posZ));
      BlockPos[] var4 = new BlockPos[]{var3.north(), var3.south(), var3.west(), var3.east(), var3.north().up(), var3.south().up(), var3.west().up(), var3.east().up(), var3.up().up().east(), var3.up().up()};
      BlockPos[] var5 = new BlockPos[]{var3.north(), var3.south(), var3.west(), var3.east(), var3.up().up()};
      BlockPos[] var6 = var2 ? var4 : var5;
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         BlockPos var9 = var6[var8];
         IBlockState var10 = c.world.getBlockState(var9);
         if (c.world.isAirBlock(var9) || var10.getBlock() instanceof BlockLiquid || var10.getBlock().isReplaceable(c.world, var9)) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, net.minecraft.block.Block) boolean
   public static boolean method_1823(Entity var0, Block var1) {
      BlockPos var2 = new BlockPos(Math.floor(var0.posX), Math.floor(var0.posY), Math.floor(var0.posZ));
      BlockPos[] var3 = new BlockPos[]{var2.north(), var2.south(), var2.east(), var2.west()};
      int var4 = 0;
      BlockPos[] var5 = var3;
      int var6 = var3.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         BlockPos var8 = var5[var7];
         IBlockState var9 = c.world.getBlockState(var8);
         if (var9.getBlock() != Blocks.AIR && var9.isFullBlock()) {
            if (var1.equals(Blocks.OBSIDIAN)) {
               if (var9.getBlock().equals(Blocks.OBSIDIAN) || var9.getBlock().equals(Blocks.BEDROCK)) {
                  ++var4;
               }
            } else if (var9.getBlock().equals(var1)) {
               ++var4;
            }
         }
      }

      return var4 >= 4;
   }

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer) boolean
   public static boolean method_1824(EntityPlayer var0) {
      return var0 != null && var0.getHeldItemMainhand().getItem() instanceof ItemFood && var0.isHandActive();
   }

   // $FF: renamed from: c (int) float
   public static float method_1825(int var0) {
      float var1 = 100.0F;
      Iterator var2 = c.player.getArmorInventoryList().iterator();

      while(true) {
         ItemStack var3;
         do {
            do {
               do {
                  do {
                     do {
                        if (!var2.hasNext()) {
                           return var1;
                        }

                        var3 = (ItemStack)var2.next();
                     } while(var0 == 0 && var3.getItem() != Items.DIAMOND_HELMET);
                  } while(var0 == 1 && var3.getItem() != Items.DIAMOND_CHESTPLATE);
               } while(var0 == 2 && var3.getItem() != Items.DIAMOND_LEGGINGS);
            } while(var0 == 3 && var3.getItem() != Items.DIAMOND_BOOTS);
         } while(var0 == 5 && (!(var3.getItem() instanceof ItemArmor) || var3.isEmpty()));

         var1 = (float)(var3.getMaxDamage() - var3.getItemDamage()) / (float)var3.getMaxDamage() * 100.0F;
      }
   }

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer, net.minecraft.item.Item) boolean
   public static boolean method_1826(EntityPlayer var0, Item var1) {
      return var0 != null && var0.getHeldItemMainhand().getItem() instanceof ItemFood && var0.isHandActive() && var0.getHeldItemMainhand().getItem().equals(var1);
   }

   // $FF: renamed from: 1 (net.minecraft.item.Item) int
   public static int method_1827(Item var0) {
      for(int var1 = 0; var1 < 9; ++var1) {
         ItemStack var2 = c.player.inventory.getStackInSlot(var1);
         if (var2 != ItemStack.EMPTY && var2.getItem() == var0) {
            return var1;
         }
      }

      return -1;
   }

   // $FF: renamed from: 2 (net.minecraft.item.Item) int
   public static int method_1828(Item var0) {
      for(int var1 = 0; var1 < c.player.inventoryContainer.getInventory().size(); ++var1) {
         if (var1 != 0 && var1 != 5 && var1 != 6 && var1 != 7 && var1 != 8) {
            ItemStack var2 = (ItemStack)c.player.inventoryContainer.getInventory().get(var1);
            if (!var2.isEmpty() && var2.getItem().equals(var0)) {
               return var1;
            }
         }
      }

      return -1;
   }

   // $FF: renamed from: 0 (net.minecraft.item.Item) int
   public static int method_1829(Item var0) {
      if (c.player == null) {
         return 0;
      } else {
         for(int var1 = 9; var1 < 36; ++var1) {
            Item var2 = c.player.inventory.getStackInSlot(var1).getItem();
            if (var2 == var0) {
               return var1;
            }
         }

         return -1;
      }
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) net.minecraft.util.math.BlockPos
   public static BlockPos method_1830(Entity var0) {
      return var0 == null ? BlockPos.ORIGIN : new BlockPos(Math.floor(var0.posX), Math.floor(var0.posY), Math.floor(var0.posZ));
   }

   // $FF: renamed from: 0 (net.minecraft.entity.player.EntityPlayer) float
   public static float method_1831(EntityPlayer var0) {
      return var0.getHealth() + var0.getAbsorptionAmount();
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) float
   public static float method_1832(ItemStack var0) {
      return (float)(var0.getMaxDamage() - var0.getItemDamage()) / (float)var0.getMaxDamage() * 100.0F;
   }

   // $FF: renamed from: c (net.minecraft.item.Item) void
   public static void method_1833(Item var0) {
      if (c.player.getHeldItemMainhand().getItem() != var0) {
         for(int var1 = 0; var1 < 9; ++var1) {
            ItemStack var2 = c.player.inventory.getStackInSlot(var1);
            if (!var2.isEmpty() && var2.getItem() == var0) {
               c.player.inventory.currentItem = var1;
               c.playerController.updateController();
               break;
            }
         }

      }
   }
}
