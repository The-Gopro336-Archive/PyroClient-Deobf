/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.mixin.TimerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.Timer;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdH extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_862 = (DoubleSetting)this.register((f0w)(new DoubleSetting("multiplier", "Multiplier", (String)null, 2.0D, 0.1D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_863 = (BooleanSetting)this.register((f0w)(new BooleanSetting("tpsSync", "TPSSync", (String)null, false)));

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      f0b.field_2415.method_3669("timer");
      if (var1) {
         f0b.field_2415.method_3667("timer", f07.field_2303, (float)((Number)this.field_862.c()).doubleValue());
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1282(@NotNull f4t var1) {
      StringCompanionObject var2 = StringCompanionObject.INSTANCE;
      String var3 = "%.2f";
      Object[] var10001 = new Object[1];
      float var10004 = (float)50;
      Minecraft var10005 = fdZ.field_976;
      if (var10005 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.MinecraftAccessor");
      } else {
         Timer var8 = ((MinecraftAccessor)var10005).getTimer();
         if (var8 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.TimerAccessor");
         } else {
            var10001[0] = var10004 / ((TimerAccessor)var8).getTickLength();
            Object[] var4 = var10001;
            boolean var5 = false;
            String var7 = String.format(var3, Arrays.copyOf(var4, var4.length));
            this.5(var7);
            if ((Boolean)this.field_863.c()) {
               f0b.field_2415.method_3667("timer", f07.field_2303, (float)50 / RangesKt.coerceAtMost(500.0F, 50.0F * ((float)20 / f04.field_2316.method_3478())));
            } else {
               f0b.field_2415.method_3667("timer", f07.field_2303, (float)((Number)this.field_862.c()).doubleValue());
            }

         }
      }
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1283() {
      return this.field_863;
   }

   public fdH() {
      super("timer", "Timer", "Change the clientside tick speed");
      this.field_862.c((Consumer)(new fdG(this)));
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1284() {
      return this.field_862;
   }
}
