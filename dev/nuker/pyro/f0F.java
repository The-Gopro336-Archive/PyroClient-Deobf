/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;

public class f0F {
   // $FF: renamed from: c java.util.function.Supplier
   @NotNull
   public Supplier field_2345;
   // $FF: renamed from: c java.lang.Runnable
   @NotNull
   public Runnable field_2346;
   // $FF: renamed from: c int
   public int field_2347;
   // $FF: renamed from: c java.util.function.BiFunction
   @NotNull
   public BiFunction field_2348;
   // $FF: renamed from: c net.minecraft.client.gui.FontRenderer
   @NotNull
   public FontRenderer field_2349;
   // $FF: renamed from: c dev.nuker.pyro.f0E
   public static f0E field_2350 = new f0E((DefaultConstructorMarker)null);

   // $FF: renamed from: 5 () java.util.function.BiFunction
   @NotNull
   public BiFunction method_3571() {
      return this.field_2348;
   }

   // $FF: renamed from: 0 (double, double) boolean
   public boolean method_3572(double var1, double var3) {
      return var1 >= (double)0 && var1 <= (double)this.method_3581() && var3 >= (double)0 && var3 <= (double)this.field_2347;
   }

   // $FF: renamed from: 4 () java.lang.Runnable
   @NotNull
   public Runnable method_3573() {
      return this.field_2346;
   }

   // $FF: renamed from: c (double, double) boolean
   public boolean method_3574(double var1, double var3) {
      return this.method_3572(var1, var3) && (Boolean)this.field_2348.apply(var1, var3);
   }

   // $FF: renamed from: 2 () java.util.function.Supplier
   @NotNull
   public Supplier method_3575() {
      return this.field_2345;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.FontRenderer) void
   public void method_3576(@NotNull FontRenderer var1) {
      this.field_2349 = var1;
   }

   public f0F(@NotNull Supplier var1, @NotNull Runnable var2, int var3, @NotNull BiFunction var4, @NotNull FontRenderer var5) {
      this.field_2345 = var1;
      this.field_2346 = var2;
      this.field_2347 = var3;
      this.field_2348 = var4;
      this.field_2349 = var5;
   }

   // $FF: renamed from: c (java.util.function.BiFunction) void
   public void method_3577(@NotNull BiFunction var1) {
      this.field_2348 = var1;
   }

   // $FF: renamed from: c (int) void
   public void method_3578(int var1) {
      this.field_2347 = var1;
   }

   // $FF: renamed from: c () void
   public void method_3579() {
      this.field_2346.run();
   }

   // $FF: renamed from: c (java.lang.Runnable) void
   public void method_3580(@NotNull Runnable var1) {
      this.field_2346 = var1;
   }

   // $FF: renamed from: 1 () int
   public int method_3581() {
      return ((Number)this.field_2345.get()).intValue();
   }

   // $FF: renamed from: 0 () net.minecraft.client.gui.FontRenderer
   @NotNull
   public FontRenderer method_3582() {
      return this.field_2349;
   }

   // $FF: renamed from: 3 () int
   public int method_3583() {
      return this.field_2347;
   }

   // $FF: renamed from: c (java.util.function.Supplier) void
   public void method_3584(@NotNull Supplier var1) {
      this.field_2345 = var1;
   }
}
