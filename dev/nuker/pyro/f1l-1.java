/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class f1l {
   // $FF: renamed from: c dev.nuker.pyro.f1l
   public static f1l field_2008;

   // $FF: renamed from: c (dev.nuker.pyro.f1l, net.minecraft.entity.passive.EntityAnimal) boolean
   public static boolean method_3085(f1l var0, EntityAnimal var1) {
      return var0.method_3089(var1);
   }

   // $FF: renamed from: c (net.minecraft.entity.passive.EntityAnimal, net.minecraft.item.ItemStack) boolean
   public boolean method_3086(EntityAnimal var1, ItemStack var2) {
      return var1 instanceof AbstractHorse ? var2.getItem() instanceof ItemAppleGold : var1.isBreedingItem(var2);
   }

   static {
      f1l var0 = new f1l();
      field_2008 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3087(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("breed").executes((Command)f1k.field_1986));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f1l, net.minecraft.entity.passive.EntityAnimal, net.minecraft.item.ItemStack) boolean
   public static boolean method_3088(f1l var0, EntityAnimal var1, ItemStack var2) {
      return var0.method_3086(var1, var2);
   }

   // $FF: renamed from: c (net.minecraft.entity.passive.EntityAnimal) boolean
   public boolean method_3089(EntityAnimal var1) {
      return !var1.isChild() && !var1.isInLove() && fdZ.field_976.player.getDistance((Entity)var1) < (float)(fdZ.field_976.player.canEntityBeSeen((Entity)var1) ? 6 : 3);
   }
}
