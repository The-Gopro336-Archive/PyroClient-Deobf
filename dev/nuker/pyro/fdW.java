/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

public class fdW {
   // $FF: renamed from: c int
   public int field_1287;
   // $FF: renamed from: 0 int
   public int field_1288;
   // $FF: renamed from: 1 int
   public int field_1289;
   // $FF: renamed from: 2 int
   public int field_1290;
   // $FF: renamed from: 3 int
   public int field_1291;
   // $FF: renamed from: c net.minecraft.inventory.ClickType
   @NotNull
   public ClickType field_1292;
   // $FF: renamed from: c java.util.function.Consumer
   @NotNull
   public Consumer field_1293;
   // $FF: renamed from: c dev.nuker.pyro.fdX
   public fdX field_1294;

   // $FF: renamed from: 4 () net.minecraft.inventory.ClickType
   @NotNull
   public ClickType method_1963() {
      return this.field_1292;
   }

   // $FF: renamed from: 1 () int
   public int method_1964() {
      return this.field_1288;
   }

   // $FF: renamed from: 2 () int
   public int method_1965() {
      return this.field_1287;
   }

   // $FF: renamed from: c () java.util.function.Consumer
   @NotNull
   public Consumer method_1966() {
      return this.field_1293;
   }

   // $FF: renamed from: c (java.util.function.Consumer) void
   public void method_1967(@NotNull Consumer var1) {
      this.field_1293 = var1;
   }

   // $FF: renamed from: 0 () int
   public int method_1968() {
      return this.field_1290;
   }

   // $FF: renamed from: 0 (int) void
   public void method_1969(int var1) {
      this.field_1288 = var1;
   }

   // $FF: renamed from: c (int) void
   public void method_1970(int var1) {
      this.field_1290 = var1;
   }

   // $FF: renamed from: 5 () int
   public int method_1971() {
      return this.field_1291;
   }

   // $FF: renamed from: 2 (int) void
   public void method_1972(int var1) {
      this.field_1291 = var1;
   }

   // $FF: renamed from: c (net.minecraft.inventory.ClickType) void
   public void method_1973(@NotNull ClickType var1) {
      this.field_1292 = var1;
   }

   // $FF: renamed from: 1 (int) void
   public void method_1974(int var1) {
      this.field_1287 = var1;
   }

   public fdW(fdX var1, int var2, int var3, @NotNull int var4, ClickType var5, @NotNull int var6, Consumer var7) {
      this.field_1294 = var1;
      super();
      this.field_1289 = var2;
      this.field_1290 = var3;
      this.field_1291 = var4;
      this.field_1292 = var5;
      this.field_1293 = var7;
      this.field_1288 = var6;
   }

   // $FF: renamed from: 3 () int
   public int method_1975() {
      return this.field_1289;
   }

   // $FF: renamed from: 3 (int) void
   public void method_1976(int var1) {
      this.field_1289 = var1;
   }
}
