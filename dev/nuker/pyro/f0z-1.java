/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0z extends Setting {
   // $FF: renamed from: 0 dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2220;
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_2221;

   // $FF: renamed from: 0 (dev.nuker.pyro.fw) void
   public void method_3331(@NotNull class_6 var1) {
      this.field_2220 = var1;
   }

   public f0z(@NotNull f0o var1, @NotNull List[] var2) {
      String var10001 = var1.3();
      String var10002 = var1.c();
      String var10003 = var1.4();
      int var3 = var2.length;
      String var12 = var10003;
      String var11 = var10002;
      String var10 = var10001;
      List[] var4 = new List[var3];

      for(int var5 = 0; var5 < var3; ++var5) {
         boolean var7 = false;
         List var15 = CollectionsKt.toMutableList((Collection)var2[var5]);
         var4[var5] = var15;
      }

      super(var10, var11, var12, var4);
      this.field_2221 = var1;
      this.field_2221.c((Consumer)(new f0x(this)));
      List[] var18 = (List[])this.getValue().method_3034();
      int var6 = var18.length;

      for(int var17 = 0; var17 < var6; ++var17) {
         List var16 = var18[var17];
         Iterator var8 = var16.iterator();

         while(var8.hasNext()) {
            f0w var19 = (f0w)var8.next();
            if (var19 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.setting.Setting<kotlin.Any>");
            }

            var19.method_3319((Consumer)(new f0y(this)));
         }
      }

      this.field_2220 = (class_6)(new class_7(false));
   }

   public f0z(@NotNull String var1, @NotNull String var2, @Nullable String var3, @NotNull Enum var4, @NotNull List[] var5) {
      this(new f0o(var1, var2, var3, var4), var5);
   }

   // $FF: renamed from: c () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_3332() {
      return this.field_2220;
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
      JsonObject var2 = (JsonObject)var1;
      this.field_2220.method_3033(var2.get("expanded").getAsBoolean());
      this.field_2221.method_3310(var2.get("selection"));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0o) void
   public void method_3333(@NotNull f0o var1) {
      this.field_2221 = var1;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_3334() {
      return this.field_2221;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      List[] var1 = new List[((Object[])this.getValue().method_3034()).length];
      int var2 = 0;
      Object var10000 = this.getValue().method_3034();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      for(int var3 = ((List[])var10000).length; var2 < var3; ++var2) {
         var10000 = this.getValue().method_3034();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         List var4 = ((List[])var10000)[var2];
         List var5 = (List)(new ArrayList());
         int var6 = 0;

         for(int var7 = ((Collection)var4).size(); var6 < var7; ++var6) {
            var5.add(((f0w)var4.get(var6)).method_3309());
         }

         var1[var2] = var5;
      }

      return (f13)(new f11(this.field_2221, var1, this.field_2220));
   }

   // $FF: renamed from: 0 () com.google.gson.JsonElement
   @NotNull
   public JsonElement method_3316() {
      JsonObject var1 = new JsonObject();
      var1.add("expanded", (JsonElement)(new JsonPrimitive((Boolean)this.field_2220.method_3034())));
      var1.add("selection", this.field_2221.method_3316());
      return (JsonElement)var1;
   }
}
