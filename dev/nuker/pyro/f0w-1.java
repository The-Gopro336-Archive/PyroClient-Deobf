/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0w {
   // $FF: renamed from: c dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2210;
   // $FF: renamed from: c java.util.List
   public List field_2211;
   // $FF: renamed from: 0 java.lang.String
   @NotNull
   public String field_2212;
   // $FF: renamed from: 1 java.lang.String
   @Nullable
   public String field_2213;
   // $FF: renamed from: c java.lang.Object
   public Object field_2214;

   // $FF: renamed from: 1 () java.lang.Object
   public Object method_3304() {
      return this.field_2214;
   }

   // $FF: renamed from: 4 () java.lang.String
   @Nullable
   public String method_3305() {
      return this.field_2213;
   }

   // $FF: renamed from: 1 (java.lang.String) void
   public void method_3306(@NotNull String var1) {
      this.field_2212 = var1;
   }

   // $FF: renamed from: 0 (java.lang.String) void
   public void method_3307(@Nullable String var1) {
      this.field_2213 = var1;
   }

   public f0w(@NotNull String var1, Object var2) {
      this(var1, (String)null, var2);
   }

   // $FF: renamed from: 0 (java.lang.Object) void
   public void method_3308(Object var1) {
      this.field_2214 = var1;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w, java.util.List) void
   public static void method_3311(f0w var0, List var1) {
      var0.field_2211 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) java.util.List
   public static List method_3312(f0w var0) {
      return var0.field_2211;
   }

   // $FF: renamed from: 0 (java.util.function.Consumer) void
   public void method_3313(@NotNull Consumer var1) {
      this.field_2211.add(var1);
   }

   // $FF: renamed from: c (java.lang.Object) void
   public void method_3314(Object var1) {
      this.field_2210.method_3033(var1);
   }

   @NotNull
   public class_6 getValue() {
      return this.field_2210;
   }

   // $FF: renamed from: 3 () java.lang.String
   @NotNull
   public String method_3315() {
      return this.field_2212;
   }

   // $FF: renamed from: 0 () com.google.gson.JsonElement
   @NotNull
   public JsonElement method_3316() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   public f0w(@NotNull String var1, @Nullable String var2, Object var3) {
      this.field_2212 = var1;
      this.field_2213 = var2;
      this.field_2214 = var3;
      this.field_2211 = (List)(new ArrayList());
      this.field_2210 = (class_6)(new class_7(this.method_3304(), (Consumer)(new f0v(this))));
   }

   // $FF: renamed from: c (dev.nuker.pyro.fw) void
   public void method_3317(@NotNull class_6 var1) {
      this.field_2210 = var1;
   }

   // $FF: renamed from: c () java.lang.Object
   public Object method_3318() {
      return this.field_2210.method_3034();
   }

   // $FF: renamed from: c (java.util.function.Consumer) void
   public void method_3319(@NotNull Consumer var1) {
      this.field_2211.add(var1);
   }
}
