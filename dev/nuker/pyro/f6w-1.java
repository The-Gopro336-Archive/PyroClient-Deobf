/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f6w extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_479 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delay", "Delay", (String)null, 0.0D, 0.0D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c boolean
   public boolean field_480;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_481 = new fe8();

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_696(@Nullable f43 var1) {
      if (this.c.player != null && this.c.world != null) {
         this.5(String.valueOf(this.method_701()));
         if (!(Boolean)PyroStatic.field_2554.c.method_3034() || !PyroStatic.field_2554.method_882()) {
            if (!(this.c.currentScreen instanceof GuiContainer) || this.c.currentScreen instanceof GuiInventory) {
               if (!this.field_480) {
                  this.field_481.method_1979();
               }

               if (this.c.player.getHeldItem(EnumHand.OFF_HAND).getItem() != Items.TOTEM_OF_UNDYING) {
                  if (!this.c.player.isCreative()) {
                     boolean var2 = false;
                     int var4 = 44;

                     for(int var3 = var4; var3 >= 9; var3 = var4) {
                        if (this.c.player.inventoryContainer.getSlot(var4).getStack().getItem() == Items.TOTEM_OF_UNDYING) {
                           this.field_480 = true;
                           if (this.field_481.method_1980(((Number)this.field_479.c()).doubleValue() * (double)1000.0F) && this.c.player.inventory.getItemStack().getItem() != Items.TOTEM_OF_UNDYING) {
                              this.c.playerController.windowClick(0, var4, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
                           }

                           if (this.field_481.method_1980(((Number)this.field_479.c()).doubleValue() * (double)2000.0F) && this.c.player.inventory.getItemStack().getItem() == Items.TOTEM_OF_UNDYING) {
                              this.c.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
                              if (this.c.player.inventory.getItemStack().isEmpty()) {
                                 this.field_480 = false;
                                 return;
                              }
                           }

                           if (this.field_481.method_1980(((Number)this.field_479.c()).doubleValue() * (double)3000.0F) && !this.c.player.inventory.getItemStack().isEmpty() && this.c.player.getHeldItem(EnumHand.OFF_HAND).getItem() == Items.TOTEM_OF_UNDYING) {
                              this.c.playerController.windowClick(0, var4, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
                              this.field_480 = false;
                              return;
                           }
                        }

                        --var4;
                     }

                  }
               }
            }
         }
      }
   }

   public f6w() {
      super("autototem", "AutoTotem", "Automatically swaps your offhand to a totem if one is currently not present");
   }

   // $FF: renamed from: c () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_697() {
      return this.field_481;
   }

   // $FF: renamed from: c (boolean) void
   public void method_698(boolean var1) {
      this.field_480 = var1;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_699() {
      return this.field_479;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_480 = false;
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_700() {
      return this.field_480;
   }

   // $FF: renamed from: 1 () int
   public int method_701() {
      int var1 = 0;
      int var2 = 1;

      for(byte var3 = 44; var2 <= var3; ++var2) {
         if (this.c.player.inventoryContainer.getSlot(var2).getHasStack()) {
            ItemStack var4 = this.c.player.inventoryContainer.getSlot(var2).getStack();
            if (!var4.isEmpty() && Intrinsics.areEqual((Object)var4.getItem(), (Object)Items.TOTEM_OF_UNDYING)) {
               ++var1;
            }
         }
      }

      if (this.c.player.getHeldItem(EnumHand.OFF_HAND).getItem() == Items.TOTEM_OF_UNDYING) {
         ++var1;
      }

      return var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe8) void
   public void method_702(@NotNull fe8 var1) {
      this.field_481 = var1;
   }
}
