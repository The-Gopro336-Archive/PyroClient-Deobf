/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class f8c extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_294;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_295;
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_296;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_297;
   // $FF: renamed from: 1 int
   public int field_298;

   // $FF: renamed from: c (dev.nuker.pyro.f4q) void
   @f0g
   public void method_431(@NotNull f4q var1) {
      var1.0();
   }

   public f8c() {
      super("autoeat", "AutoEat", "Automatically eats food when requirements are met");
      this.field_294 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f7Z.field_1830)));
      this.field_295 = (DoubleSetting)this.register((f0w)(new DoubleSetting("hungerStart", "Hunger", (String)null, 19.0D, 0.0D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_296 = (DoubleSetting)this.register((f0w)(new DoubleSetting("healthStart", "Health", (String)null, 20.0D, 0.0D, 36.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_297 = (BooleanSetting)this.register((f0w)(new BooleanSetting("switchBack", "SwitchBack", "Switches back to previously held item", true)));
      this.field_298 = -1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   public void method_432(@NotNull f4t var1) {
      this.5(((f7Z)this.field_294.c()).toString());
      if ((f7Z)this.field_294.c() == f7Z.field_1830 && !this.c.player.isHandActive()) {
         float var2 = this.c.player.getHealth() + this.c.player.getAbsorptionAmount();
         int var3 = this.c.player.getFoodStats().getFoodLevel();
         boolean var4 = false;
         boolean var5 = false;
         if ((double)var2 <= ((Number)this.field_296.c()).doubleValue()) {
            var4 = true;
         }

         if ((double)var3 <= ((Number)this.field_295.c()).doubleValue()) {
            var5 = true;
         }

         if (!var4 && !var5) {
            if ((Boolean)this.field_297.c() && this.field_298 != -1) {
               this.c.player.inventory.currentItem = this.field_298;
               this.c.playerController.updateController();
               this.field_298 = -1;
            }

            return;
         }

         int var6 = -1;
         float var7 = 0.0F;
         int var8 = -1;
         float var9 = 0.0F;
         ItemStack var10 = this.c.player.getHeldItem(EnumHand.OFF_HAND);
         int var11;
         Item var10000;
         if (var10.getItem() instanceof ItemFood) {
            var10000 = var10.getItem();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemFood");
            }

            var11 = ((ItemFood)var10000).getHealAmount(var10);
            if ((float)var11 >= var7) {
               this.c.playerController.processRightClick((EntityPlayer)this.c.player, (World)this.c.world, EnumHand.OFF_HAND);
               return;
            }
         }

         var11 = 0;

         for(byte var12 = 9; var11 <= var12; ++var11) {
            ItemStack var13 = this.c.player.inventory.getStackInSlot(var11);
            if (!var13.isEmpty() && var13.getItem() instanceof ItemFood) {
               var10000 = var13.getItem();
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemFood");
               }

               ItemFood var14 = (ItemFood)var10000;
               int var15 = var14.getHealAmount(var13);
               float var16 = var14.getSaturationModifier(var13);
               if ((float)var15 >= var7) {
                  var6 = var11;
                  var7 = (float)var15;
               }

               if (var16 >= var9) {
                  var8 = var11;
                  var9 = var16;
               }
            }
         }

         if (var6 != -1 && var4) {
            this.field_298 = (Boolean)this.field_297.c() ? this.c.player.inventory.currentItem : -1;
            this.c.player.inventory.currentItem = var6;
            this.c.playerController.processRightClick((EntityPlayer)this.c.player, (World)this.c.world, EnumHand.MAIN_HAND);
         } else if (var8 != -1 && var5) {
            this.field_298 = (Boolean)this.field_297.c() ? this.c.player.inventory.currentItem : -1;
            this.c.player.inventory.currentItem = var8;
            this.c.playerController.processRightClick((EntityPlayer)this.c.player, (World)this.c.world, EnumHand.MAIN_HAND);
         }
      }

   }

   // $FF: renamed from: 3 (int) void
   public void method_433(int var1) {
      this.field_298 = var1;
   }

   // $FF: renamed from: 0 () int
   public int method_434() {
      return this.field_298;
   }
}
