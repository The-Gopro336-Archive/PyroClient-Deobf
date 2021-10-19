/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// $FF: renamed from: dev.nuker.pyro.fa
public class class_34 {
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_2627 = (List)(new ArrayList());
   // $FF: renamed from: c java.lang.String[]
   @Nullable
   public String[] field_2628;
   // $FF: renamed from: c dev.nuker.pyro.f9
   public static class_15 field_2629 = new class_15((DefaultConstructorMarker)null);

   @NotNull
   public String toString() {
      String[] var10000 = this.field_2628;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      String var1 = var10000.length + this.field_2627.size() > 1 ? "┬" : "─";
      int var2 = 0;
      var10000 = this.field_2628;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      int var3;
      StringBuilder var12;
      for(var3 = var10000.length; var2 < var3; ++var2) {
         var10000 = this.field_2628;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         String var4 = var10000[var2];
         var12 = (new StringBuilder()).append(var1).append(var2 == 0 ? "" : "│").append(var4);
         String[] var10002 = this.field_2628;
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         var1 = var12.append(var2 == var10002.length + this.field_2627.size() - 1 ? "" : "\n").toString();
      }

      var2 = 0;

      for(var3 = ((Collection)this.field_2627).size(); var2 < var3; ++var2) {
         class_34 var9;
         String var13;
         label308: {
            var9 = (class_34)this.field_2627.get(var2);
            var12 = (new StringBuilder()).append(var1);
            if (var2 == 0) {
               String[] var10001 = this.field_2628;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               if (var10001.length == 0) {
                  var13 = "";
                  break label308;
               }
            }

            var13 = var2 == this.field_2627.size() - 1 ? "└" : "├";
         }

         var1 = var12.append(var13).toString();
         Collection var6 = (Collection)StringsKt.split$default((CharSequence)var9.toString(), new String[]{"\n"}, false, 0, 6, (Object)null);
         boolean var7 = false;
         Object[] var14 = var6.toArray(new String[0]);
         if (var14 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
         }

         String[] var5 = (String[])var14;
         int var10 = 0;

         for(int var11 = var5.length; var10 < var11; ++var10) {
            String var8 = var5[var10];
            var1 = var1 + StringsKt.trimIndent("\n                    " + (var10 == 0 ? "" : (var2 == this.field_2627.size() - 1 ? " " : "│")) + var8 + "\n                    \n                    ");
         }
      }

      return var1;
   }

   // $FF: renamed from: c () java.lang.String[]
   @Nullable
   public String[] method_3961() {
      return this.field_2628;
   }

   // $FF: renamed from: 1 () int
   public int method_3962() {
      return this.field_2627.size();
   }

   // $FF: renamed from: 0 () java.util.List
   @NotNull
   public List method_3963() {
      return this.field_2627;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fa) void
   public void method_3964(@NotNull class_34 var1) {
      this.field_2627.add(var1);
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_3965(@NotNull List var1) {
      this.field_2627 = var1;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3966(@NotNull String var1) {
      this.method_3964(field_2629.method_3407(var1));
   }

   // $FF: renamed from: c (java.lang.String[]) void
   public void method_3967(@Nullable String[] var1) {
      this.field_2628 = var1;
   }
}
