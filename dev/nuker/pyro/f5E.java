/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

public class f5E {
   // $FF: renamed from: c int
   public int field_2185;
   // $FF: renamed from: c net.minecraft.client.settings.KeyBinding
   @NotNull
   public KeyBinding field_2186;
   // $FF: renamed from: c float
   public float field_2187;
   // $FF: renamed from: 0 float
   public float field_2188;
   // $FF: renamed from: 1 float
   public float field_2189;
   // $FF: renamed from: 2 float
   public float field_2190;

   // $FF: renamed from: 2 () float
   public float method_3255() {
      return this.field_2189;
   }

   public f5E(@NotNull KeyBinding var1, float var2, float var3, float var4, float var5) {
      this.field_2186 = var1;
      this.field_2187 = var2;
      this.field_2188 = var3;
      this.field_2189 = var4;
      this.field_2190 = var5;
   }

   // $FF: renamed from: 5 () void
   public void method_3256() {
      GlStateManager.pushMatrix();
      GlStateManager.translate((double)this.field_2189, (double)this.field_2190, 0.0D);
      if (this.field_2186.isKeyDown()) {
         this.field_2185 = 20;
      } else if (this.field_2185 > 0) {
         this.field_2185 += -1;
         int var10000 = this.field_2185;
      }

      if (this.field_2185 > 0) {
         float var1 = (float)21 + -((float)this.field_2185);
         GlStateManager.viewport(0, 0, (int)this.field_2187, (int)this.field_2188);
         PyroRenderUtil.meth0(0.0F, 0.0F, this.field_2187, this.field_2188, 1878982656);
      }

      PyroRenderUtil.meth0(0.0F, 0.0F, this.field_2187, this.field_2188, 1593835520);
      PyroRenderUtil.meth0(this.field_2186.getDisplayName(), this.field_2187 / (float)2, this.field_2188 / (float)2, -1);
      GlStateManager.popMatrix();
   }

   // $FF: renamed from: 4 () float
   public float method_3257() {
      return this.field_2187;
   }

   // $FF: renamed from: 2 (float) void
   public void method_3258(float var1) {
      this.field_2187 = var1;
   }

   // $FF: renamed from: 1 () float
   public float method_3259() {
      return this.field_2190;
   }

   // $FF: renamed from: 0 () int
   public int method_3260() {
      return this.field_2185;
   }

   // $FF: renamed from: 1 (float) void
   public void method_3261(float var1) {
      this.field_2190 = var1;
   }

   // $FF: renamed from: c (net.minecraft.client.settings.KeyBinding) void
   public void method_3262(@NotNull KeyBinding var1) {
      this.field_2186 = var1;
   }

   // $FF: renamed from: c (int) void
   public void method_3263(int var1) {
      this.field_2185 = var1;
   }

   // $FF: renamed from: c () net.minecraft.client.settings.KeyBinding
   @NotNull
   public KeyBinding method_3264() {
      return this.field_2186;
   }

   // $FF: renamed from: c (float) void
   public void method_3265(float var1) {
      this.field_2189 = var1;
   }

   // $FF: renamed from: 0 (float) void
   public void method_3266(float var1) {
      this.field_2188 = var1;
   }

   // $FF: renamed from: 3 () float
   public float method_3267() {
      return this.field_2188;
   }
}
