/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.block.Block;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

public class fbz {
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d field_970;
   // $FF: renamed from: c net.minecraft.block.Block
   @NotNull
   public Block field_971;

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d) void
   public void method_1408(@NotNull Vec3d var1) {
      this.field_970 = var1;
   }

   // $FF: renamed from: c () net.minecraft.block.Block
   @NotNull
   public Block method_1409() {
      return this.field_971;
   }

   public fbz(@NotNull Vec3d var1, @NotNull Block var2) {
      this.field_970 = var1;
      this.field_971 = var2;
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_1410() {
      return this.field_970;
   }

   // $FF: renamed from: c (net.minecraft.block.Block) void
   public void method_1411(@NotNull Block var1) {
      this.field_971 = var1;
   }
}
