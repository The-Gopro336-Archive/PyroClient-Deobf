/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.RenderManagerAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class fdY extends fdZ {
   // $FF: renamed from: c (double, double, float) double
   public static double method_1814(double var0, double var2, float var4) {
      return var2 + (var0 - var2) * (double)c.getRenderPartialTicks();
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.Vec3d, net.minecraft.util.math.Vec3d) net.minecraft.util.math.Vec3d
   public static Vec3d method_1815(Vec3d var0, Vec3d var1) {
      return new Vec3d(var0.x * var1.x, var0.y * var1.y, var0.z * var1.z);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, float) net.minecraft.util.math.Vec3d
   public static Vec3d method_1816(Entity var0, float var1) {
      return new Vec3d(method_1814(var0.posX, var0.lastTickPosX, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosX(), method_1814(var0.posY, var0.lastTickPosY, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosY(), method_1814(var0.posZ, var0.lastTickPosZ, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosZ());
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.Vec3d, float) net.minecraft.util.math.Vec3d
   public static Vec3d method_1817(Vec3d var0, float var1) {
      return new Vec3d(method_1814(var0.x, var0.x, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosX(), method_1814(var0.y, var0.y, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosY(), method_1814(var0.z, var0.z, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosZ());
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.util.math.Vec3d) net.minecraft.util.math.Vec3d
   public static Vec3d method_1818(Vec3d var0, Vec3d var1) {
      return new Vec3d(var0.x / var1.x, var0.y / var1.y, var0.z / var1.z);
   }

   // $FF: renamed from: 1 (net.minecraft.util.math.Vec3d, float) net.minecraft.util.math.Vec3d
   public static Vec3d method_1819(Vec3d var0, float var1) {
      return new Vec3d(method_1814(var0.x, var0.x, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosX(), method_1814(var0.y, var0.y - 0.021D, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosY(), method_1814(var0.z, var0.z, var1) - ((RenderManagerAccessor)c.getRenderManager()).getRenderPosZ());
   }

   // $FF: renamed from: 2 (net.minecraft.util.math.Vec3d, float) net.minecraft.util.math.Vec3d
   public static Vec3d method_1820(Vec3d var0, float var1) {
      return new Vec3d(var0.x / (double)var1, var0.y / (double)var1, var0.z / (double)var1);
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) net.minecraft.util.math.Vec3d
   public static Vec3d method_1821(Vec3d var0, float var1) {
      return new Vec3d(var0.x * (double)var1, var0.y * (double)var1, var0.z * (double)var1);
   }
}
