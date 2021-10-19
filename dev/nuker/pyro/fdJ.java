/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class fdJ extends PriorityQueue {
   // $FF: renamed from: c boolean
   public boolean field_1233;
   // $FF: renamed from: c java.util.Map
   public Map field_1234;
   // $FF: renamed from: c java.util.function.Function
   public Function field_1235;

   public int size() {
      return this.method_1889();
   }

   public fdJ(@NotNull fdJ var1) {
      super((PriorityQueue)var1);
      this.field_1234 = (Map)(new HashMap());
      this.field_1234 = (Map)(new HashMap(var1.field_1234));
   }

   public boolean offer(Object var1) {
      double var2 = this.method_1891(var1);
      boolean var10000;
      if (var2 == DoubleCompanionObject.INSTANCE.getPOSITIVE_INFINITY()) {
         this.field_1234.remove(var1);
         var10000 = true;
      } else {
         var10000 = super.offer(var1);
      }

      return var10000;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdJ, java.util.Map) void
   public static void method_1887(fdJ var0, Map var1) {
      var0.field_1234 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fdJ) java.util.Map
   public static Map method_1888(fdJ var0) {
      return var0.field_1234;
   }

   public fdJ(@NotNull Function var1, boolean var2) {
      super((Comparator)(new fdI()));
      this.field_1234 = (Map)(new HashMap());
      Comparator var10000 = this.comparator();
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.util.CachedPriorityQueue.CacheComparator<T>");
      } else {
         ((fdI)var10000).method_1886((fdJ)this);
         this.field_1235 = var1;
         this.field_1233 = var2;
      }
   }

   // $FF: renamed from: c () int
   public int method_1889() {
      return super.size();
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdJ) boolean
   public static boolean method_1890(fdJ var0) {
      return var0.field_1233;
   }

   // $FF: renamed from: c (java.lang.Object) double
   public double method_1891(Object var1) {
      Function var10000 = this.field_1235;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("priorityGetter");
      }

      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      double var2 = ((Number)var10000.apply(var1)).doubleValue();
      this.field_1234.put(var1, var2);
      return var2;
   }

   public fdJ(Function var1, boolean var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      this(var1, var2);
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdJ, boolean) void
   public static void method_1892(fdJ var0, boolean var1) {
      var0.field_1233 = var1;
   }
}
