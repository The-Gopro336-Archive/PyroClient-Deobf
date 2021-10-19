/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class keypearl extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting field_156 = new BindSetting("pearlKey", "PearlKey", "The key or mouse button to set", -1);
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_157 = new BooleanSetting("inventory", "Inventory", (String)null, false);

   // $FF: renamed from: 0 () dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting method_237() {
      return this.field_156;
   }

   // $FF: renamed from: c (dev.nuker.pyro.keypearl, net.minecraft.client.Minecraft) void
   public static void method_238(keypearl var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.keypearl) net.minecraft.client.Minecraft
   public static Minecraft method_239(keypearl var0) {
      return var0.c;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_240(@Nullable f4t var1) {
      if (this.field_156.method_3330()) {
         int var2 = 0;

         for(byte var3 = 8; var2 <= var3; ++var2) {
            ItemStack var4 = this.c.player.inventory.getStackInSlot(var2);
            if (!var4.isEmpty() && Intrinsics.areEqual((Object)var4.getItem(), (Object)Items.ENDER_PEARL)) {
               if (this.c.player.inventory.currentItem != var2) {
                  this.c.player.connection.sendPacket((Packet)(new CPacketHeldItemChange(var2)));
               }

               this.c.player.connection.sendPacket((Packet)(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND)));
               if (this.c.player.inventory.currentItem != var2) {
                  this.c.player.connection.sendPacket((Packet)(new CPacketHeldItemChange(this.c.player.inventory.currentItem)));
               }

               return;
            }
         }

         if ((Boolean)this.field_157.c()) {
            var2 = fdX.field_1227.method_1838(Items.ENDER_PEARL);
            if (var2 != -1) {
               this.c.playerController.windowClick(0, var2, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
               this.c.playerController.windowClick(0, 44, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
               int var5 = this.c.player.inventory.currentItem;
               if (var5 != 8) {
                  this.c.player.inventory.currentItem = 8;
               }

               this.c.playerController.processRightClick((EntityPlayer)this.c.player, (World)this.c.world, EnumHand.MAIN_HAND);
               if (var5 != 8) {
                  this.c.player.inventory.currentItem = var5;
               }

               this.c.addScheduledTask((Runnable)(new f6P(this, var2)));
            }
         }
      }

   }

   public keypearl() {
      super("keyPearl", "KeyPearl", "Allows you to automatically throw a pearl from anywhere in your inventory when the key setting is hit");
      this.register((f0w)this.field_156);
      this.register((f0w)this.field_157);
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_241() {
      return this.field_157;
   }
}
