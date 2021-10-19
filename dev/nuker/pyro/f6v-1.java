/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSplashPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayer.Position;
import net.minecraft.network.play.client.CPacketPlayer.PositionRotation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f6v extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_487 = new BooleanSetting("onGroundOnly", "OnGroundOnly", (String)null, false);
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_488 = new DoubleSetting("health", "Health", (String)null, 10.0D, 0.0D, 20.0D);
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_489 = new DoubleSetting("delay", "Delay", (String)null, 0.7D, 0.0D, 0.9D);
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   public IntegerSetting field_490 = new IntegerSetting("slot", "Slot", (String)null, 6, 1, 9);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_491 = new BooleanSetting("oldFix", "1.9Fix", (String)null, true);
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_492 = new fe8();
   // $FF: renamed from: 1 int
   public int field_493;
   // $FF: renamed from: c boolean
   public boolean field_494;
   // $FF: renamed from: 0 boolean
   public boolean field_495;
   // $FF: renamed from: c double
   public double field_496;
   // $FF: renamed from: 0 double
   public double field_497;
   // $FF: renamed from: 1 double
   public double field_498;

   public f6v() {
      super("autopot", "AutoPot", "Throws a potion of health at your feet if requirements are met");
      this.register(this.field_487);
      this.register(this.field_488);
      this.register(this.field_489);
      this.register(this.field_490);
      this.register(this.field_491);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(3)
   @LauncherEventHide
   public void method_705(f4u var1) {
      if (!var1.c()) {
         if (var1.c() == f41.field_2120) {
            boolean var2 = this.field_492.method_1980((Double)this.field_489.c() * 1000.0D);
            if ((Boolean)this.field_487.c() && !this.c.player.onGround) {
               var2 = false;
            }

            int var3 = this.method_706();
            if (var3 != -1 && (double)this.c.player.getHealth() <= (Double)this.field_488.c() && var2) {
               if (this.c.player.collidedVertically && !(Boolean)PyroStatic.field_2494.c.method_3034()) {
                  this.field_495 = true;
                  this.field_492.method_1979();
                  this.c.player.connection.sendPacket(new PositionRotation(this.c.player.posX, this.c.player.posY, this.c.player.posZ, this.c.player.rotationYaw, -90.0F, true));
                  this.method_707(var3, (Integer)this.field_490.c());
                  this.c.player.connection.sendPacket(new CPacketHeldItemChange((Integer)this.field_490.c()));
                  if ((Boolean)this.field_491.c()) {
                     this.c.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                  } else {
                     this.c.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
                  }

                  this.c.player.connection.sendPacket(new CPacketHeldItemChange(this.c.player.inventory.currentItem));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.42D, this.c.player.posZ, true));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.75D, this.c.player.posZ, true));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.0D, this.c.player.posZ, true));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.16D, this.c.player.posZ, true));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.24D, this.c.player.posZ, true));
                  this.field_496 = this.c.player.posX;
                  this.field_497 = this.c.player.posY + 1.24D;
                  this.field_498 = this.c.player.posZ;
                  this.field_493 = 5;
               } else {
                  var1.0();
                  var1.method_3140(90.0F);
                  this.field_494 = true;
                  this.field_495 = true;
                  this.field_492.method_1979();
               }
            }

            if (this.field_493 >= 0) {
               var1.method_3129();
            }

            if (this.field_493 == 0) {
               this.c.player.motionX = 0.0D;
               this.c.player.motionZ = 0.0D;
               this.c.player.setPositionAndUpdate(this.field_496, this.field_497, this.field_498);
               this.c.player.motionY = -0.08D;
            }

            --this.field_493;
         } else if (this.field_494) {
            this.method_707(this.method_706(), (Integer)this.field_490.c());
            this.c.player.connection.sendPacket(new CPacketHeldItemChange((Integer)this.field_490.c()));
            if ((Boolean)this.field_491.c()) {
               this.c.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            } else {
               this.c.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
            }

            this.c.player.connection.sendPacket(new CPacketHeldItemChange(this.c.player.inventory.currentItem));
            this.field_492.method_1979();
            this.field_494 = false;
         }

      }
   }

   // $FF: renamed from: 0 () int
   public int method_706() {
      int var1 = -1;
      int var2 = 0;

      for(int var3 = 1; var3 < 45; ++var3) {
         if (this.c.player.inventoryContainer.getSlot(var3).getHasStack()) {
            ItemStack var4 = this.c.player.inventoryContainer.getSlot(var3).getStack();
            Item var5 = var4.getItem();
            if (var5 instanceof ItemSplashPotion) {
               PotionType var6 = PotionUtils.getPotionFromItem(var4);
               Iterator var7 = var6.getEffects().iterator();

               while(var7.hasNext()) {
                  PotionEffect var8 = (PotionEffect)var7.next();
                  if (var8.getPotion() == MobEffects.INSTANT_HEALTH) {
                     ++var2;
                     var1 = var3;
                  }
               }
            }
         }
      }

      this.5(String.valueOf(var2));
      return var1;
   }

   // $FF: renamed from: c (int, int) void
   public void method_707(int var1, int var2) {
      this.c.playerController.windowClick(this.c.player.inventoryContainer.windowId, var1, var2, ClickType.SWAP, this.c.player);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (var1) {
         this.field_493 = -1;
      } else {
         this.field_494 = false;
      }

   }
}
