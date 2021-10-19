/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f81 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_515 = (BooleanSetting)this.register((f0w)(new BooleanSetting("openinv", "OpenInventory", "Replenishes rods", true)));
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_516 = (IntegerSetting)this.register((f0w)(new IntegerSetting("castingDelay", "CastingDelay", (String)null, 15, 10, 25, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_517 = (DoubleSetting)this.register((f0w)(new DoubleSetting("maxSoundDist", "MaxSoundDist", (String)null, 5.0D, 0.0D, 5.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c boolean
   public boolean field_518;
   // $FF: renamed from: 0 boolean
   public boolean field_519 = true;
   // $FF: renamed from: 1 int
   public int field_520;

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_720(@NotNull f4t var1) {
      this.field_519 = this.method_722();
      if (this.field_519) {
         if (this.field_518) {
            this.field_518 = false;
            if (this.c.player.fishEntity != null) {
               this.field_520 = ((Number)this.field_516.c()).intValue();
               this.method_726();
            }
         } else if (this.field_520 > 0) {
            this.field_520 += -1;
            if (this.field_520 == 0) {
               this.method_726();
            }
         }

      }
   }

   // $FF: renamed from: c (boolean) void
   public void method_721(boolean var1) {
      this.field_519 = var1;
   }

   // $FF: renamed from: 3 () boolean
   public boolean method_722() {
      if (Intrinsics.areEqual((Object)this.c.player.getHeldItemMainhand().getItem(), (Object)Items.FISHING_ROD) ^ true) {
         int var1 = fdX.field_1227.method_1839((Item)Items.FISHING_ROD);
         if (var1 != -1) {
            this.c.player.inventory.currentItem = var1;
            this.c.playerController.updateController();
            return true;
         } else {
            if ((Boolean)this.field_515.c()) {
               int var2 = fdX.field_1227.method_1838((Item)Items.FISHING_ROD);
               if (var2 != -1) {
                  fdX.field_1227.method_1841(0, var2, 0, ClickType.PICKUP, (Consumer)(new f80(this)));
                  return false;
               }
            }

            return false;
         }
      } else {
         return true;
      }
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_723(boolean var1) {
      this.field_518 = var1;
   }

   public f81() {
      super("autofish", "AutoFish", "Automatically fishes for you");
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_724() {
      return this.field_516;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_725() {
      return this.field_515;
   }

   // $FF: renamed from: 6 () void
   public void method_726() {
      NetHandlerPlayClient var10000;
      if (Intrinsics.areEqual((Object)this.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem(), (Object)Items.FISHING_ROD)) {
         var10000 = this.c.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND)));
         var10000 = this.c.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketAnimation(EnumHand.MAIN_HAND)));
      } else if (Intrinsics.areEqual((Object)this.c.player.getHeldItem(EnumHand.OFF_HAND).getItem(), (Object)Items.FISHING_ROD)) {
         var10000 = this.c.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketPlayerTryUseItem(EnumHand.OFF_HAND)));
         var10000 = this.c.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketAnimation(EnumHand.OFF_HAND)));
      }

   }

   // $FF: renamed from: 1 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_727() {
      return this.field_517;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_728(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketSoundEffect) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSoundEffect");
         }

         SPacketSoundEffect var2 = (SPacketSoundEffect)var10000;
         if (var2.getSound().equals(SoundEvents.ENTITY_BOBBER_SPLASH) && this.c.player.fishEntity != null) {
            EntityFishHook var3 = this.c.player.fishEntity;
            if (var3 == null) {
               Intrinsics.throwNpe();
            }

            if (var3.getAngler().equals(this.c.player) && (((Number)this.field_517.c()).doubleValue() == 0.0D || this.c.player.getPositionVector().distanceTo(new Vec3d(var2.getX(), var2.getY(), var2.getZ())) <= ((Number)this.field_517.c()).doubleValue())) {
               this.field_518 = true;
            }
         }
      }

   }

   // $FF: renamed from: 5 () boolean
   public boolean method_729() {
      return this.field_519;
   }

   // $FF: renamed from: 4 () int
   public int method_730() {
      return this.field_520;
   }

   // $FF: renamed from: 3 (int) void
   public void method_731(int var1) {
      this.field_520 = var1;
   }

   // $FF: renamed from: c () boolean
   public boolean method_732() {
      return this.field_518;
   }
}
