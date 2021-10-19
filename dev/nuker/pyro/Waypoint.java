/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006'"},
   d2 = {"Ldev/nuker/pyro/Waypoint;", "", "name", "", "x", "", "y", "z", "dimensions", "", "", "(Ljava/lang/String;DDDLjava/util/List;)V", "getDimensions", "()Ljava/util/List;", "setDimensions", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getX", "()D", "setX", "(D)V", "getY", "setY", "getZ", "setZ", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "pyroclient"}
)
public final class Waypoint {
   @NotNull
   private String name;
   // $FF: renamed from: x double
   private double field_2618;
   // $FF: renamed from: y double
   private double field_2619;
   // $FF: renamed from: z double
   private double field_2620;
   @NotNull
   private List dimensions;

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final void setName(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.name = var1;
   }

   public final double getX() {
      return this.field_2618;
   }

   public final void setX(double var1) {
      this.field_2618 = var1;
   }

   public final double getY() {
      return this.field_2619;
   }

   public final void setY(double var1) {
      this.field_2619 = var1;
   }

   public final double getZ() {
      return this.field_2620;
   }

   public final void setZ(double var1) {
      this.field_2620 = var1;
   }

   @NotNull
   public final List getDimensions() {
      return this.dimensions;
   }

   public final void setDimensions(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.dimensions = var1;
   }

   public Waypoint(@NotNull String name, double x, double y, double z, @NotNull List dimensions) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(dimensions, "dimensions");
      super();
      this.name = name;
      this.field_2618 = x;
      this.field_2619 = y;
      this.field_2620 = z;
      this.dimensions = dimensions;
   }

   @NotNull
   public final String component1() {
      return this.name;
   }

   public final double component2() {
      return this.field_2618;
   }

   public final double component3() {
      return this.field_2619;
   }

   public final double component4() {
      return this.field_2620;
   }

   @NotNull
   public final List component5() {
      return this.dimensions;
   }

   @NotNull
   public final Waypoint copy(@NotNull String name, double x, double y, double z, @NotNull List dimensions) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(dimensions, "dimensions");
      return new Waypoint(name, x, y, z, dimensions);
   }

   // $FF: synthetic method
   public static Waypoint copy$default(Waypoint var0, String var1, double var2, double var4, double var6, List var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.name;
      }

      if ((var9 & 2) != 0) {
         var2 = var0.field_2618;
      }

      if ((var9 & 4) != 0) {
         var4 = var0.field_2619;
      }

      if ((var9 & 8) != 0) {
         var6 = var0.field_2620;
      }

      if ((var9 & 16) != 0) {
         var8 = var0.dimensions;
      }

      return var0.copy(var1, var2, var4, var6, var8);
   }

   @NotNull
   public String toString() {
      return "Waypoint(name=" + this.name + ", x=" + this.field_2618 + ", y=" + this.field_2619 + ", z=" + this.field_2620 + ", dimensions=" + this.dimensions + ")";
   }

   public int hashCode() {
      String var10000 = this.name;
      int var1 = ((((var10000 != null ? var10000.hashCode() : 0) * 31 + Double.hashCode(this.field_2618)) * 31 + Double.hashCode(this.field_2619)) * 31 + Double.hashCode(this.field_2620)) * 31;
      List var10001 = this.dimensions;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof Waypoint) {
            Waypoint var2 = (Waypoint)var1;
            if (Intrinsics.areEqual((Object)this.name, (Object)var2.name) && Double.compare(this.field_2618, var2.field_2618) == 0 && Double.compare(this.field_2619, var2.field_2619) == 0 && Double.compare(this.field_2620, var2.field_2620) == 0 && Intrinsics.areEqual((Object)this.dimensions, (Object)var2.dimensions)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
