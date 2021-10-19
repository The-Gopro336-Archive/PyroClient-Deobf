/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class f3Z {
   // $FF: renamed from: c dev.nuker.pyro.f3Z
   public static f3Z field_2126;

   // $FF: renamed from: c (java.lang.Object, java.io.DataOutputStream) void
   public void method_3202(@NotNull Object var1, @NotNull DataOutputStream var2) {
      List var4 = f3X.field_0.method_3192();
      boolean var5 = false;
      int var6 = 0;
      Iterator var7 = var4.iterator();

      int var10000;
      while(true) {
         if (!var7.hasNext()) {
            var10000 = -1;
            break;
         }

         Object var8 = var7.next();
         Pair var9 = (Pair)var8;
         boolean var10 = false;
         if (Intrinsics.areEqual((Object)((Class)var9.getFirst()), (Object)var1.getClass())) {
            var10000 = var6;
            break;
         }

         ++var6;
      }

      int var3 = var10000;
      if (var3 == -1) {
         throw (Throwable)(new IllegalArgumentException("Invalid data type"));
      } else {
         var2.writeInt(var3);
         Pair var11 = (Pair)f3X.field_0.method_3192().get(var3);
         ((f3X)var11.getSecond()).method_18(var1, var2);
      }
   }

   // $FF: renamed from: c (java.io.DataInputStream) java.lang.Object
   @NotNull
   public Object method_3203(@NotNull DataInputStream var1) {
      int var2 = var1.readInt();
      return ((f3X)((Pair)f3X.field_0.method_3192().get(var2)).getSecond()).method_17(var1);
   }

   // $FF: renamed from: c (java.io.DataInputStream, dev.nuker.pyro.f4c) dev.nuker.pyro.f3Y
   @NotNull
   public f3Y method_3204(@NotNull DataInputStream var1, @NotNull f4c var2) {
      int var3 = var1.readInt();
      f3Y var4 = var2.method_3254(var3);
      int var5 = var1.readInt();
      boolean var7 = false;
      List var6 = (List)(new ArrayList());
      int var9 = 0;

      for(int var8 = var5; var9 < var8; ++var9) {
         var6.add(this.method_3203(var1));
      }

      var4.method_2977(var6);
      return var4;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f3Y, dev.nuker.pyro.f4c, java.io.DataOutputStream) void
   public void method_3205(@NotNull f3Y var1, @NotNull f4c var2, @NotNull DataOutputStream var3) {
      int var4 = var2.method_3253().indexOf(var1.getClass());
      if (var4 == -1) {
         throw (Throwable)(new IllegalArgumentException("Invalid packet"));
      } else {
         var3.writeInt(var4);
         List var5 = var1.method_2976();
         var3.writeInt(var5.size());
         Iterable var6 = (Iterable)var5;
         boolean var7 = false;
         Iterator var8 = var6.iterator();

         while(var8.hasNext()) {
            Object var9 = var8.next();
            boolean var11 = false;
            field_2126.method_3202(var9, var3);
         }

      }
   }

   static {
      f3Z var0 = new f3Z();
      field_2126 = var0;
   }
}
