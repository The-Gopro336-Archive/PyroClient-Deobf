/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.item.ItemStack;

public class f4F extends f42 {
   // $FF: renamed from: c net.minecraft.item.ItemStack
   public ItemStack field_2085;
   // $FF: renamed from: c int
   public int field_2086;
   // $FF: renamed from: 0 int
   public int field_2087;

   // $FF: renamed from: 0 () int
   public int method_3159() {
      return this.field_2087;
   }

   // $FF: renamed from: c (int) void
   public void method_3160(int var1) {
      this.field_2086 = var1;
   }

   // $FF: renamed from: 1 () net.minecraft.item.ItemStack
   public ItemStack method_3161() {
      return this.field_2085;
   }

   // $FF: renamed from: 0 (int) void
   public void method_3162(int var1) {
      this.field_2087 = var1;
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) void
   public void method_3163(ItemStack var1) {
      this.field_2085 = var1;
   }

   // $FF: renamed from: c () int
   public int method_3164() {
      return this.field_2086;
   }

   public f4F(ItemStack var1, int var2, int var3) {
      this.field_2085 = var1;
      this.field_2086 = var2;
      this.field_2087 = var3;
   }
}
