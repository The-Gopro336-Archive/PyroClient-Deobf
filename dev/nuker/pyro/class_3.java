/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// $FF: renamed from: dev.nuker.pyro.fF
public class class_3 extends fdZ {
   // $FF: renamed from: c java.util.concurrent.ConcurrentHashMap
   public ConcurrentHashMap field_988 = new ConcurrentHashMap();
   // $FF: renamed from: c dev.nuker.pyro.fF
   @NotNull
   public static class_3 field_989 = new class_3();
   // $FF: renamed from: c dev.nuker.pyro.fD
   public static class_13 field_990 = new class_13((DefaultConstructorMarker)null);

   // $FF: renamed from: 0 (int) void
   public void method_1450(int var1) {
      if (this.field_988.containsKey(var1)) {
         class_12 var2 = (class_12)this.field_988.get(var1);
         if (var2 == null) {
            Intrinsics.throwNpe();
         }

         var2.method_3403().forEach((Consumer)class_32.field_2292);
      }

   }

   // $FF: renamed from: 0 (int, java.lang.String) void
   public void method_1451(int var1, @NotNull String var2) {
      if (this.field_988.containsKey(var1)) {
         class_12 var3 = (class_12)this.field_988.get(var1);
         if (var3 == null) {
            Intrinsics.throwNpe();
         }

         var3.method_3403().add(var2);
      } else {
         List var5 = (List)(new ArrayList());
         var5.add(var2);
         class_12 var4 = new class_12(var1, var5);
         ((Map)this.field_988).put(var1, var4);
      }

      this.method_1455();
   }

   // $FF: renamed from: c () void
   public void method_1452() {
      this.field_988.clear();
      if (this.method_1457().exists()) {
         Iterable var1 = (Iterable)((JsonObject)Pyro.GSON.fromJson(FilesKt.readText(this.method_1457(), Charsets.UTF_8), JsonObject.class)).entrySet();
         boolean var2 = false;
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            Entry var5 = (Entry)var4;
            boolean var6 = false;
            boolean var8 = false;
            String var9 = (String)var5.getKey();
            var8 = false;
            JsonElement var10 = (JsonElement)var5.getValue();
            Map var11 = (Map)this.field_988;
            var8 = false;
            int var12 = Integer.parseInt(var9);
            Integer var27 = var12;
            var8 = false;
            int var15 = Integer.parseInt(var9);
            Iterable var7 = (Iterable)var10.getAsJsonArray();
            var8 = false;
            Collection var17 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));
            boolean var18 = false;
            Iterator var19 = var7.iterator();

            while(var19.hasNext()) {
               Object var20 = var19.next();
               JsonElement var21 = (JsonElement)var20;
               boolean var23 = false;
               String var24 = var21.getAsString();
               var17.add(var24);
            }

            List var22 = (List)var17;
            List var25 = CollectionsKt.toMutableList((Collection)var22);
            var11.put(var27, new class_12(var15, var25));
         }
      }

   }

   // $FF: renamed from: 1 (int) dev.nuker.pyro.fC
   @Nullable
   public class_12 method_1453(int var1) {
      return (class_12)this.field_988.get(var1);
   }

   // $FF: renamed from: c (int, java.lang.String) void
   public void method_1454(int var1, @Nullable String var2) {
      if (this.field_988.containsKey(var1)) {
         class_12 var3 = (class_12)this.field_988.get(var1);
         if (var3 == null) {
            Intrinsics.throwNpe();
         }

         if (var3.method_3403().isEmpty()) {
            this.field_988.remove(var1);
         } else {
            Collection var4 = (Collection)var3.method_3403();
            boolean var5 = false;
            if (var4 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            }

            TypeIntrinsics.asMutableCollection(var4).remove(var2);
            if (var3.method_3403().isEmpty()) {
               this.field_988.remove(var1);
            }
         }
      }

      this.method_1455();
   }

   // $FF: renamed from: 1 () void
   public void method_1455() {
      File var10000 = this.method_1457();
      Map var1 = (Map)this.field_988;
      Gson var17 = Pyro.GSON;
      File var16 = var10000;
      boolean var2 = false;
      Collection var4 = (Collection)(new ArrayList(var1.size()));
      boolean var5 = false;
      boolean var7 = false;
      Iterator var8 = var1.entrySet().iterator();

      while(var8.hasNext()) {
         Entry var9 = (Entry)var8.next();
         boolean var11 = false;
         boolean var13 = false;
         int var14 = ((Number)var9.getKey()).intValue();
         var13 = false;
         class_12 var15 = (class_12)var9.getValue();
         Integer var20 = var14;
         if (var15 == null) {
            Intrinsics.throwNpe();
         }

         Pair var19 = TuplesKt.method_2843(var20, var15.method_3403());
         var4.add(var19);
      }

      List var18 = (List)var4;
      FilesKt.writeText(var16, var17.toJson(MapsKt.toMap((Iterable)var18)), Charsets.UTF_8);
   }

   // $FF: renamed from: c (int) void
   public void method_1456(int var1) {
      if (this.field_988.containsKey(var1)) {
         class_12 var10000 = (class_12)this.field_988.get(var1);
         this.field_988.remove(var1);
      }

      this.method_1455();
   }

   // $FF: renamed from: 2 () java.io.File
   @NotNull
   public File method_1457() {
      return new File(f67.field_2201.method_3277().method_3272(), "macros.json");
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.fF
   public static class_3 method_1458() {
      return field_989;
   }
}
