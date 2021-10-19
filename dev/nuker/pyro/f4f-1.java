/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.inventory.ClickType;
import org.jetbrains.annotations.Nullable;

public class f4f extends f42 {
   // $FF: renamed from: c int
   public int field_2079;
   // $FF: renamed from: 0 int
   public int field_2080;
   // $FF: renamed from: 1 int
   public int field_2081;
   // $FF: renamed from: c net.minecraft.inventory.ClickType
   @Nullable
   public ClickType field_2082;

   // $FF: renamed from: 0 () int
   public int method_3151() {
      return this.field_2079;
   }

   public f4f(int var1, int var2, int var3, @Nullable ClickType var4) {
      this.field_2079 = var1;
      this.field_2080 = var2;
      this.field_2081 = var3;
      this.field_2082 = var4;
   }

   // $FF: renamed from: 1 () net.minecraft.inventory.ClickType
   @Nullable
   public ClickType method_3152() {
      return this.field_2082;
   }

   // $FF: renamed from: 2 () int
   public int method_3153() {
      return this.field_2080;
   }

   // $FF: renamed from: c () int
   public int method_3154() {
      return this.field_2081;
   }

   // $FF: renamed from: c (int) void
   public void method_3155(int var1) {
      this.field_2080 = var1;
   }
}
