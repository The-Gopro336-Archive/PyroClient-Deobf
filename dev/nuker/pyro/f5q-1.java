/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5q extends fdZ {
   // $FF: renamed from: c java.util.Map
   @JvmField
   @NotNull
   public Map field_1031;
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_1032;
   // $FF: renamed from: 0 java.lang.String
   @Nullable
   public String field_1033;

   // $FF: renamed from: 3 () java.lang.String
   @NotNull
   public String method_1525() {
      return this.field_1032;
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: c (com.google.gson.JsonObject) void
   public void method_1527(@NotNull JsonObject var1) {
      JsonObject var2 = var1.getAsJsonObject("settings");
      Map var5 = this.field_1031;
      boolean var6 = false;
      Iterator var4 = var5.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         boolean var8 = false;
         String var10 = (String)var3.getKey();
         var8 = false;
         f0w var11 = (f0w)var3.getValue();
         if (var2.has(var10)) {
            try {
               var11.method_3310(var2.get(var10));
            } catch (Exception var9) {
            }
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f0w
   public f0w method_1529(@NotNull String var1) {
      return (f0w)this.field_1031.get(var1);
   }

   // $FF: renamed from: c (int, int, int) boolean
   public boolean method_1530(int var1, int var2, int var3) {
      return false;
   }

   public f5q(@NotNull String var1, @Nullable String var2) {
      this.field_1032 = var1;
      this.field_1033 = var2;
      this.field_1031 = (Map)(new LinkedHashMap());
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: 4 () com.google.gson.JsonObject
   @NotNull
   public JsonObject method_1532() {
      JsonObject var1 = new JsonObject();
      JsonObject var2 = new JsonObject();
      Map var5 = this.field_1031;
      boolean var6 = false;
      Iterator var4 = var5.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var3 = (Entry)var4.next();
         boolean var8 = false;
         String var9 = (String)var3.getKey();
         var8 = false;
         f0w var10 = (f0w)var3.getValue();
         var2.add(var9, var10.method_3316());
      }

      var1.add("settings", (JsonElement)var2);
      return var1;
   }

   public f5q(String var1, String var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = (String)null;
      }

      this(var1, var2);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) dev.nuker.pyro.f0w
   public f0w method_1533(f0w var1) {
      Map var10000 = this.field_1031;
      if (var1 == null) {
         Intrinsics.throwNpe();
      }

      var10000.put(var1.method_3315(), var1);
      var1.method_3319((Consumer)(new f5p(this)));
      return var1;
   }

   // $FF: renamed from: c () java.lang.String
   @Nullable
   public String method_1534() {
      return this.field_1033;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return true;
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_1536() {
      return false;
   }
}
