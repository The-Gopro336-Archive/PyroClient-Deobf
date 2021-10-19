/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class f0t extends f0w {
   // $FF: renamed from: c dev.nuker.pyro.fz
   @NotNull
   public class_7 field_2215 = new class_7(false);

   // $FF: renamed from: c () com.google.gson.JsonPrimitive
   @NotNull
   public JsonPrimitive method_3320() {
      return new JsonPrimitive((Boolean)this.field_2215.method_3034());
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
      this.field_2215.method_3033(var1.getAsBoolean());
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      List var1 = (List)(new ArrayList());
      int var2 = 1;
      Object var10000 = this.getValue().method_3034();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      for(int var3 = ((List)var10000).size(); var2 < var3; ++var2) {
         Object var10001 = this.getValue().method_3034();
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var1.add(((f0w)((List)var10001).get(var2)).method_3309());
      }

      f0V var4 = new f0V;
      Object var10002 = this.getValue().method_3034();
      if (var10002 == null) {
         Intrinsics.throwNpe();
      }

      var4.<init>(((f0w)((List)var10002).get(0)).method_3309(), var1, (class_6)this.field_2215);
      return (f13)var4;
   }

   // $FF: renamed from: 0 () com.google.gson.JsonElement
   public JsonElement method_3316() {
      return (JsonElement)this.method_3320();
   }

   // $FF: renamed from: c (dev.nuker.pyro.fz) void
   public void method_3321(@NotNull class_7 var1) {
      this.field_2215 = var1;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.fz
   @NotNull
   public class_7 method_3322() {
      return this.field_2215;
   }

   public f0t(@NotNull f0w var1, @NotNull f0w... var2) {
      super(var1.method_3315(), CollectionsKt.mutableListOf((f0w[])Arrays.copyOf(var2, var2.length)));
      ((List)this.getValue().method_3034()).add(0, var1);
      var1.method_3319((Consumer)(new f0r(this)));
      Iterator var4 = ((List)this.getValue().method_3034()).iterator();

      while(var4.hasNext()) {
         f0w var3 = (f0w)var4.next();
         if (var3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.setting.Setting<kotlin.Any>");
         }

         var3.method_3319((Consumer)(new f0s(this)));
      }

      this.field_2215 = new class_7(false);
   }
}
