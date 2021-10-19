/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.lwjgl.opengl.GL11;

public class fel {
   // $FF: renamed from: c int
   public int field_1349;
   // $FF: renamed from: c long
   public long field_1350;
   // $FF: renamed from: c boolean
   public boolean field_1351 = false;

   public void finalize() {
      if (!this.field_1351) {
         GL11.glDeleteLists(this.field_1349, 1);
      }

   }

   // $FF: renamed from: c (boolean) void
   public void method_2013(boolean var1) {
      this.field_1351 = var1;
   }

   // $FF: renamed from: c (long) void
   public void method_2014(long var1) {
      this.field_1350 = var1;
   }

   public fel(int var1, long var2, boolean var4) {
      this.field_1349 = var1;
      this.field_1350 = var2;
      this.field_1351 = var4;
   }

   // $FF: renamed from: c () int
   public int method_2015() {
      return this.field_1349;
   }

   public fel(int var1, long var2) {
      this.field_1349 = var1;
      this.field_1350 = var2;
   }

   // $FF: renamed from: 0 () boolean
   public boolean method_2016() {
      return this.field_1351;
   }

   // $FF: renamed from: 1 () long
   public long method_2017() {
      return this.field_1350;
   }
}
