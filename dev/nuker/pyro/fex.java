/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fex {
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d field_1394;
   // $FF: renamed from: c dev.nuker.pyro.Rotation
   @NotNull
   public Rotation field_1395;
   // $FF: renamed from: c net.minecraft.util.EnumFacing
   @Nullable
   public EnumFacing field_1396;

   // $FF: renamed from: 3 () net.minecraft.util.EnumFacing
   @Nullable
   public EnumFacing method_2074() {
      return this.field_1396;
   }

   // $FF: renamed from: 2 () net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_2075() {
      return this.field_1394;
   }

   public fex(Vec3d var1, Rotation var2, EnumFacing var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = (EnumFacing)null;
      }

      this(var1, var2, var3);
   }

   public fex(@NotNull Vec3d var1, @NotNull Rotation var2) {
      this(var1, var2, (EnumFacing)null);
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.Rotation
   @NotNull
   public Rotation method_2076() {
      return this.field_1395;
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_2077() {
      return this.field_1394;
   }

   public int hashCode() {
      Vec3d var10000 = this.field_1394;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      Rotation var10001 = this.field_1395;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      EnumFacing var2 = this.field_1396;
      return var1 + (var2 != null ? var2.hashCode() : 0);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof fex) {
            fex var2 = (fex)var1;
            if (Intrinsics.areEqual((Object)this.field_1394, (Object)var2.field_1394) && Intrinsics.areEqual((Object)this.field_1395, (Object)var2.field_1395) && Intrinsics.areEqual((Object)this.field_1396, (Object)var2.field_1396)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   // $FF: renamed from: c () net.minecraft.util.EnumFacing
   @Nullable
   public EnumFacing method_2078() {
      return this.field_1396;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.Rotation
   @NotNull
   public Rotation method_2079() {
      return this.field_1395;
   }

   @NotNull
   public String toString() {
      return "VecRotation(vec=" + this.field_1394 + ", rotation=" + this.field_1395 + ", sideHit=" + this.field_1396 + ")";
   }

   // $FF: renamed from: c (dev.nuker.pyro.fex, net.minecraft.util.math.Vec3d, dev.nuker.pyro.Rotation, net.minecraft.util.EnumFacing, int, java.lang.Object) dev.nuker.pyro.fex
   public static fex method_2080(fex var0, Vec3d var1, Rotation var2, EnumFacing var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.field_1394;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.field_1395;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.field_1396;
      }

      return var0.method_2081(var1, var2, var3);
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, dev.nuker.pyro.Rotation, net.minecraft.util.EnumFacing) dev.nuker.pyro.fex
   @NotNull
   public fex method_2081(@NotNull Vec3d var1, @NotNull Rotation var2, @Nullable EnumFacing var3) {
      return new fex(var1, var2, var3);
   }

   public fex(@NotNull Vec3d var1, @NotNull Rotation var2, @Nullable EnumFacing var3) {
      super();
      this.field_1394 = var1;
      this.field_1395 = var2;
      this.field_1396 = var3;
   }
}
