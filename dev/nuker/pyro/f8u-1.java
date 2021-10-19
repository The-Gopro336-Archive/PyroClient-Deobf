/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerAbilities;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import org.jetbrains.annotations.NotNull;

public class f8u extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_213 = (BooleanSetting)this.register((f0w)(new BooleanSetting("input", "Input", "CPacketInput", true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_214 = (BooleanSetting)this.register((f0w)(new BooleanSetting("player", "Player", "CPacketPlayer", true)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_215 = (BooleanSetting)this.register((f0w)(new BooleanSetting("abilities", "Abilities", "CPacketPlayerAbilities", true)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_216 = (BooleanSetting)this.register((f0w)(new BooleanSetting("digging", "Digging", "CPacketPlayerDigging", true)));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_217 = (BooleanSetting)this.register((f0w)(new BooleanSetting("useItem", "TryUseItem", "CPacketPlayerTryUseItem", true)));
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_218 = (BooleanSetting)this.register((f0w)(new BooleanSetting("useItemOnBlock", "TryUseItemOnBlock", "CPacketPlayerTryUseItemOnBlock", true)));
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_219 = (BooleanSetting)this.register((f0w)(new BooleanSetting("entityAction", "EntityAction", "CPacketEntityAction", true)));
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_220 = (BooleanSetting)this.register((f0w)(new BooleanSetting("useEntity", "UseEntity", "CPacketUseEntity", true)));
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_221 = (BooleanSetting)this.register((f0w)(new BooleanSetting("vehicleMove", "VehicleMove", "CPacketVehicleMove", true)));

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_306() {
      return this.field_213;
   }

   // $FF: renamed from: 7 (dev.nuker.pyro.BooleanSetting) void
   public void method_307(@NotNull BooleanSetting var1) {
      this.field_219 = var1;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_308() {
      return this.field_219;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_309() {
      return this.field_218;
   }

   public f8u() {
      super("packet_cancel", "PacketCancel", "Cancels packets to the server");
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_310() {
      return this.field_221;
   }

   // $FF: renamed from: 5 (dev.nuker.pyro.BooleanSetting) void
   public void method_311(@NotNull BooleanSetting var1) {
      this.field_220 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_312(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120 && (var1.c() instanceof CPacketInput && (Boolean)this.field_213.c() || var1.c() instanceof CPacketPlayer && (Boolean)this.field_214.c() || var1.c() instanceof CPacketPlayerAbilities && (Boolean)this.field_215.c() || var1.c() instanceof CPacketPlayerDigging && (Boolean)this.field_216.c() || var1.c() instanceof CPacketPlayerTryUseItem && (Boolean)this.field_217.c() || var1.c() instanceof CPacketPlayerTryUseItemOnBlock && (Boolean)this.field_218.c() || var1.c() instanceof CPacketEntityAction && (Boolean)this.field_219.c() || var1.c() instanceof CPacketUseEntity && (Boolean)this.field_220.c() || var1.c() instanceof CPacketVehicleMove && (Boolean)this.field_221.c())) {
         var1.0();
      }

   }

   // $FF: renamed from: 1 (dev.nuker.pyro.BooleanSetting) void
   public void method_313(@NotNull BooleanSetting var1) {
      this.field_213 = var1;
   }

   // $FF: renamed from: 4 (dev.nuker.pyro.BooleanSetting) void
   public void method_314(@NotNull BooleanSetting var1) {
      this.field_221 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_315() {
      return this.field_217;
   }

   // $FF: renamed from: c (dev.nuker.pyro.BooleanSetting) void
   public void method_316(@NotNull BooleanSetting var1) {
      this.field_218 = var1;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_317() {
      return this.field_216;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_318() {
      return this.field_215;
   }

   // $FF: renamed from: 2 (dev.nuker.pyro.BooleanSetting) void
   public void method_319(@NotNull BooleanSetting var1) {
      this.field_214 = var1;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_320() {
      return this.field_214;
   }

   // $FF: renamed from: 3 (dev.nuker.pyro.BooleanSetting) void
   public void method_321(@NotNull BooleanSetting var1) {
      this.field_215 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.BooleanSetting) void
   public void method_322(@NotNull BooleanSetting var1) {
      this.field_217 = var1;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_323() {
      return this.field_220;
   }

   // $FF: renamed from: 6 (dev.nuker.pyro.BooleanSetting) void
   public void method_324(@NotNull BooleanSetting var1) {
      this.field_216 = var1;
   }
}
