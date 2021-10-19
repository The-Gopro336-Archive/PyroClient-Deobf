/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IceSpeed extends Module {
   @NotNull
   public DoubleSetting speed = (DoubleSetting)this.register((f0w)(new DoubleSetting("speed", "Speed", (String)null, 0.4D, 0.1D, 0.98D, 0.0D, 64, (DefaultConstructorMarker)null)));

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_946() {
      return this.speed;
   }

   public IceSpeed() {
      super("icespeed", "IceSpeed", "Allows you to walk faster on ice, packed ice, and frosted ice");
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (!var1) {
         Blocks.ICE.setDefaultSlipperiness(0.98F);
         Blocks.PACKED_ICE.setDefaultSlipperiness(0.98F);
         Blocks.FROSTED_ICE.setDefaultSlipperiness(0.98F);
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_947(@Nullable f4t var1) {
      Blocks.ICE.setDefaultSlipperiness((float)((Number)this.speed.c()).doubleValue());
      Blocks.PACKED_ICE.setDefaultSlipperiness((float)((Number)this.speed.c()).doubleValue());
      Blocks.FROSTED_ICE.setDefaultSlipperiness((float)((Number)this.speed.c()).doubleValue());
   }
}
