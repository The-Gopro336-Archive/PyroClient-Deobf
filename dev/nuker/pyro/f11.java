/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class f11 extends f0V {
   // $FF: renamed from: c java.util.List[]
   public List[] field_2390;
   // $FF: renamed from: 0 java.util.List[]
   public List[] field_2391;
   // $FF: renamed from: c java.lang.Enum
   public Enum field_2392;

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      if (this.field_2392 != null) {
         List[] var10001 = this.field_2391;
         Enum var10002 = this.field_2392;
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         List var7 = var10001[var10002.ordinal()];
         if (var7 == null) {
            Intrinsics.throwNpe();
         }

         this.c = var7;
         var10001 = this.field_2390;
         var10002 = this.field_2392;
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         this.c(var10001[var10002.ordinal()]);
         this.method_3627(var1);
         var1.method_3579();
         this.field_2392 = (Enum)null;
      }

      super.method_28(var1, var2, var4, var6);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f11, java.lang.Enum) void
   public static void method_3633(f11 var0, Enum var1) {
      var0.method_3634(var1);
   }

   public f11(@NotNull f0o var1, @NotNull List[] var2, @NotNull class_6 var3) {
      super((f13)null, var2[((Enum)var1.c()).ordinal()], var3);
      this.c((f13)(new f0O(var1)));
      f13 var10000 = this.0();
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.ui.control.EnumControl<T>");
      } else {
         class_7 var6 = ((f0O)var10000).c();
         if (var6 == null) {
            Intrinsics.throwNpe();
         }

         var6.field_1872 = (Consumer)(new f0Z(this));
         var10000 = this.0();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.ui.control.EnumControl<T>");
         } else {
            ((f0O)var10000).field_2376 = (class_6)(new class_7(var1.c(), (Consumer)(new f1c(this, var1))));
            this.field_2390 = var2;
            this.field_2391 = new List[var2.length];
            int var4 = 0;

            for(int var5 = this.field_2391.length; var4 < var5; ++var4) {
               this.field_2391[var4] = (List)(new ArrayList());
            }

         }
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_29(@NotNull f0F var1, @NotNull f0H var2) {
      this.0(var1);
      f13 var10000 = this.0();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      f0F var10001 = this.c;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      int var3 = var10000.method_29(var10001, var2);
      int var4 = 0;

      for(int var5 = this.field_2390.length; var4 < var5; ++var4) {
         List var6 = this.field_2390[var4];
         List var13 = this.field_2391[var4];
         if (var13 == null) {
            Intrinsics.throwNpe();
         }

         List var7 = var13;
         int var8 = 0;

         for(int var9 = ((Collection)var6).size(); var8 < var9; ++var8) {
            f13 var10 = (f13)var6.get(var8);
            f0F var11 = (f0F)var7.get(var8);
            if (var11 == null) {
               Intrinsics.throwNpe();
            }

            var11.method_3578(var10.method_26(var1, var2));
            int var12 = var10.method_29(var11, var2) + 1;
            if (var12 > var3) {
               var3 = var12;
            }
         }
      }

      return var3;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F) void
   public void method_3627(@NotNull f0F var1) {
      int var2 = 0;

      for(int var3 = this.field_2390.length; var2 < var3; ++var2) {
         List var4 = this.field_2390[var2];
         List var5 = this.field_2391[var2];
         if (var5 == null) {
            Intrinsics.throwNpe();
         }

         var5.clear();
         int var6 = 0;

         for(int var7 = ((Collection)var4).size(); var6 < var7; ++var6) {
            var5.add(new f0F((Supplier)(new f10(var1)), var1.method_3573(), 0, var1.method_3571(), var1.method_3582()));
         }
      }

      List[] var10001 = this.field_2391;
      f13 var10002 = this.0();
      if (var10002 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.ui.control.EnumControl<T>");
      } else {
         Object var9 = ((f0O)var10002).field_2376.method_3034();
         if (var9 == null) {
            Intrinsics.throwNpe();
         }

         List var8 = var10001[((Enum)var9).ordinal()];
         if (var8 == null) {
            Intrinsics.throwNpe();
         }

         this.c = var8;
      }
   }

   // $FF: renamed from: c (java.lang.Enum) void
   public void method_3634(Enum var1) {
      this.field_2392 = var1;
   }
}
