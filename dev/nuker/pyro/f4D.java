/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

public class f4D extends f4G {
   // $FF: renamed from: c float
   public float field_2091;
   // $FF: renamed from: 0 float
   public float field_2092;
   // $FF: renamed from: 1 float
   public float field_2093;
   // $FF: renamed from: 2 float
   public float field_2094;
   // $FF: renamed from: 3 float
   public float field_2095;
   // $FF: renamed from: 4 float
   public float field_2096;

   // $FF: renamed from: 1 () float
   public float method_3168() {
      return this.field_2096;
   }

   // $FF: renamed from: 2 (float) void
   public void method_3169(float var1) {
      this.field_2092 = var1;
   }

   // $FF: renamed from: 4 (float) void
   public void method_3170(float var1) {
      this.field_2096 = var1;
   }

   // $FF: renamed from: 3 () float
   public float method_3171() {
      return this.field_2092;
   }

   // $FF: renamed from: c () float
   public float method_3172() {
      return this.field_2094;
   }

   // $FF: renamed from: c (float) void
   public void method_3173(float var1) {
      this.field_2093 = var1;
   }

   public f4D(@NotNull RenderLivingBase var1, @NotNull EntityLivingBase var2, @NotNull ModelBase var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      super(var1, var3, var2);
      this.field_2091 = var4;
      this.field_2092 = var5;
      this.field_2093 = var6;
      this.field_2094 = var7;
      this.field_2095 = var8;
      this.field_2096 = var9;
   }

   // $FF: renamed from: 4 () float
   public float method_3174() {
      return this.field_2091;
   }

   // $FF: renamed from: 0 () float
   public float method_3175() {
      return this.field_2093;
   }

   // $FF: renamed from: 3 (float) void
   public void method_3176(float var1) {
      this.field_2094 = var1;
   }

   // $FF: renamed from: 2 () float
   public float method_3177() {
      return this.field_2095;
   }

   // $FF: renamed from: 1 (float) void
   public void method_3178(float var1) {
      this.field_2091 = var1;
   }

   // $FF: renamed from: 0 (float) void
   public void method_3179(float var1) {
      this.field_2095 = var1;
   }
}
