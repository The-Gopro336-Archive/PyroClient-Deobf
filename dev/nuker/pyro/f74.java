/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import org.jetbrains.annotations.NotNull;

public class f74 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_560 = (BooleanSetting)this.register((f0w)(new BooleanSetting("ground", "Ground", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_561 = (BooleanSetting)this.register((f0w)(new BooleanSetting("sprint", "Sprint", (String)null, true)));
   // $FF: renamed from: c boolean
   public boolean field_562;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_563 = new fe8();

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_839() {
      return this.field_561;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_840() {
      return this.field_560;
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_841() {
      return this.field_562;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_842(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120) {
         if (this.c.player != null) {
            Packet var10000;
            if (var1.c() instanceof CPacketPlayer && (Boolean)this.field_560.c()) {
               if (this.field_563.method_1980(5000.0D) && !this.c.player.isElytraFlying() && this.field_562) {
                  this.field_562 = false;
               }

               if (!this.c.player.isElytraFlying() && !this.field_562) {
                  var10000 = var1.c();
                  if (var10000 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.CPacketPlayerAccessor");
                  }

                  CPacketPlayerAccessor var2 = (CPacketPlayerAccessor)var10000;
                  if (!(this.c.player.fallDistance > (float)0) && !this.c.playerController.getIsHittingBlock()) {
                     var2.setOnGround(false);
                  } else {
                     var2.setOnGround(true);
                  }
               }
            }

            if (var1.c() instanceof CPacketEntityAction && (Boolean)this.field_561.c()) {
               var10000 = var1.c();
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketEntityAction");
               }

               CPacketEntityAction var3 = (CPacketEntityAction)var10000;
               if (var3.getAction() == Action.START_SPRINTING || var3.getAction() == Action.STOP_SPRINTING) {
                  var1.0();
               }

               if (var3.getAction() == Action.START_FALL_FLYING) {
                  this.field_562 = true;
                  this.field_563.method_1979();
               }
            }

         }
      }
   }

   // $FF: renamed from: c (boolean) void
   public void method_843(boolean var1) {
      this.field_562 = var1;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_844() {
      return this.field_563;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe8) void
   public void method_845(@NotNull fe8 var1) {
      this.field_563 = var1;
   }

   public f74() {
      super("antihunger", "AntiHunger", "Allows you greatly reduce hunger loss by modifying packets you send");
   }
}
