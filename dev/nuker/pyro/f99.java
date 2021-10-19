/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import baritone.api.BaritoneAPI;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f99 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_358 = (BooleanSetting)this.register((f0w)(new BooleanSetting("allowSprint", "Allow Sprint", "Let Baritone sprint", true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_359 = (BooleanSetting)this.register((f0w)(new BooleanSetting("allowPlace", "Allow Place", "Let Baritone place blocks", true)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_360 = (BooleanSetting)this.register((f0w)(new BooleanSetting("allowBreak", "Allow Break", "Let Baritone break blocks", true)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_361 = (BooleanSetting)this.register((f0w)(new BooleanSetting("allowParkour", "Allow Parkour", "Let Baritone do parkour", false)));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_362 = (BooleanSetting)this.register((f0w)(new BooleanSetting("allowParkourPlace", "Allow Parkour Place", "Let Baritone place blocks while doing parkour", false)));
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_363 = (BooleanSetting)this.register((f0w)(new BooleanSetting("allowInventory", "Allow Inventory Use", "Let Baritone use things in your inventory", false)));
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_364 = (BooleanSetting)this.register((f0w)(new BooleanSetting("mapartMode", "Map Art Mode", "Enable Map art mode - tbh not totally sure what this does", false)));
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_365 = (BooleanSetting)this.register((f0w)(new BooleanSetting("sneakCancel", "Sneak2Stop", "Stops Baritone when you sneak", true)));
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_366 = (BooleanSetting)this.register((f0w)(new BooleanSetting("antiElytra", "Anti Elytra", "Stops Baritone from accidentally triggering elytra", true)));
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_367;
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_368;
   // $FF: renamed from: 1 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_369;
   // $FF: renamed from: 2 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_370;
   // $FF: renamed from: 3 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_371;
   // $FF: renamed from: c boolean
   public boolean field_372;

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_527() {
      return this.field_365;
   }

   // $FF: renamed from: b () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_528() {
      return this.field_363;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_529() {
      return this.field_362;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_530(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof CPacketEntityAction && ((Boolean)PyroStatic.field_2467.c.method_3034() && !PyroStatic.field_2467.method_1192() || (Boolean)PyroStatic.field_2489.field_366.c() && BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing())) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketEntityAction");
         }

         CPacketEntityAction var2 = (CPacketEntityAction)var10000;
         if (var2.getAction() == Action.START_FALL_FLYING) {
            var1.0();
         }
      }

   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_531() {
      return this.field_364;
   }

   // $FF: renamed from: c (baritone.api.Settings.Setting, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1) dev.nuker.pyro.fw
   public class_6 method_532(baritone.api.Settings.Setting var1, Function1 var2, Function1 var3) {
      return (class_6)(new f98(var1, var2, var3));
   }

   // $FF: renamed from: f () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_533() {
      return this.field_369;
   }

   // $FF: renamed from: 9 () void
   public void method_534() {
      if (this.field_372) {
         this.field_358.c(this.method_532(BaritoneAPI.getSettings().allowSprint, (Function1)f8L.field_36, (Function1)f8W.field_33));
         this.field_359.c(this.method_532(BaritoneAPI.getSettings().allowPlace, (Function1)f91.field_41, (Function1)f92.field_39));
         this.field_360.c(this.method_532(BaritoneAPI.getSettings().allowBreak, (Function1)f93.field_37, (Function1)f94.field_28));
         this.field_361.c(this.method_532(BaritoneAPI.getSettings().allowParkour, (Function1)f95.field_26, (Function1)f96.field_24));
         this.field_362.c(this.method_532(BaritoneAPI.getSettings().allowParkourPlace, (Function1)f97.field_22, (Function1)f8M.field_35));
         this.field_363.c(this.method_532(BaritoneAPI.getSettings().allowInventory, (Function1)f8N.field_34, (Function1)f8O.field_44));
         this.field_364.c(this.method_532(BaritoneAPI.getSettings().mapArtMode, (Function1)f8P.field_42, (Function1)f8Q.field_40));
         this.field_367.c(this.method_532(BaritoneAPI.getSettings().colorCurrentPath, (Function1)f8R.field_38, (Function1)f8S.field_29));
         this.field_368.c(this.method_532(BaritoneAPI.getSettings().colorNextPath, (Function1)f8T.field_27, (Function1)f8U.field_25));
         this.field_369.c(this.method_532(BaritoneAPI.getSettings().colorBestPathSoFar, (Function1)f8V.field_23, (Function1)f8X.field_32));
         this.field_370.c(this.method_532(BaritoneAPI.getSettings().colorMostRecentConsidered, (Function1)f8Y.field_31, (Function1)f8Z.field_30));
         this.field_371.c(this.method_532(BaritoneAPI.getSettings().colorGoalBox, (Function1)f9c.field_21, (Function1)f90.field_43));
      }

   }

   // $FF: renamed from: c (boolean) void
   public void method_535(boolean var1) {
      this.field_372 = var1;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_536() {
      return this.field_367;
   }

   // $FF: renamed from: c () boolean
   public boolean method_537() {
      return this.field_372;
   }

   // $FF: renamed from: e () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_538() {
      return this.field_361;
   }

   // $FF: renamed from: d () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_539() {
      return this.field_358;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_540() {
      return this.field_370;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_541() {
      return this.field_366;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_542() {
      return this.field_371;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      if (var1) {
         this.c.method_3033(false);
      }

   }

   public f99() {
      super("baritone", "Baritone", "Settings for baritone");
      this.field_367 = (f0l)this.register((f0w)(new f0l("pathColor", "Path Color", "Finalized path color", f00.field_2296.method_3693(Color.RED))));
      this.field_368 = (f0l)this.register((f0w)(new f0l("nextColor", "Next Path Color", "Color for next path segment", f00.field_2296.method_3693(Color.MAGENTA))));
      this.field_369 = (f0l)this.register((f0w)(new f0l("bestColor", "Best Path Color", "Color for next best path segment", f00.field_2296.method_3693(Color.BLUE))));
      this.field_370 = (f0l)this.register((f0w)(new f0l("consideringColor", "Considering Path Color", "Last checked path color", f00.field_2296.method_3693(Color.CYAN))));
      this.field_371 = (f0l)this.register((f0w)(new f0l("goalColor", "Goal Color", "Goal box color", f00.field_2296.method_3693(Color.GREEN))));

      try {
         this.field_372 = Pyro.class.getClassLoader().loadClass("baritone.api.BaritoneAPI") != null;
         Pyro.getEventManager().method_31(this);
      } catch (ClassNotFoundException var2) {
      }

   }

   // $FF: renamed from: a () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_543() {
      return this.field_360;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_544() {
      return this.field_368;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_545() {
      return this.field_359;
   }
}
