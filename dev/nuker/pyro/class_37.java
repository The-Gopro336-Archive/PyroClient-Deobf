/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.nuker.pyro.gui.ClickGui;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.function.Function;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

// $FF: renamed from: dev.nuker.pyro.fZ
public class class_37 {
   // $FF: renamed from: c java.util.Map
   @JvmField
   @NotNull
   public Map field_2631 = (Map)(new HashMap());
   // $FF: renamed from: c boolean
   public boolean field_2632;
   // $FF: renamed from: c dev.nuker.pyro.fZ
   @JvmField
   @NotNull
   public static class_37 field_2633 = new class_37();
   // $FF: renamed from: c dev.nuker.pyro.fR
   public static class_21 field_2634 = new class_21((DefaultConstructorMarker)null);

   // $FF: renamed from: 2 () java.util.List
   @NotNull
   public List method_3973() {
      List var1 = (List)(new ArrayList());
      Iterator var3 = this.field_2631.values().iterator();

      while(var3.hasNext()) {
         class_39 var2 = (class_39)var3.next();
         var1.addAll((Collection)var2.method_3986());
      }

      var1.remove(PyroStatic.field_2485);
      return var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.gui.ClickGui) void
   public void method_3974(@NotNull ClickGui var1) {
      Iterator var3 = this.field_2631.values().iterator();

      while(var3.hasNext()) {
         class_39 var2 = (class_39)var3.next();
         var2.method_3995(var1);
      }

      var1.reloadWindowList();
   }

   // $FF: renamed from: c (float) void
   public void method_3975(float var1) {
      Vec3d var2 = fdN.method_1861((Entity)Objects.requireNonNull(Minecraft.getMinecraft().getRenderViewEntity()), var1);
      Iterator var4 = this.field_2631.values().iterator();

      while(var4.hasNext()) {
         class_39 var3 = (class_39)var4.next();
         Iterator var6 = var3.method_3989().iterator();

         while(var6.hasNext()) {
            Module var5 = (Module)var6.next();
            if ((Boolean)var5.field_89.method_3034()) {
               fe5.field_1245.getBuffer().setTranslation(-var2.x, -var2.y, -var2.z);
               GlStateManager.pushMatrix();
               var5.method_123(var2, var1);
               GlStateManager.popMatrix();
            }
         }
      }

      fe5.field_1245.getBuffer().setTranslation(0.0D, 0.0D, 0.0D);
      fe5.field_1245.method_1908();
   }

   // $FF: renamed from: c () void
   public void method_3976() {
      Pyro.getEventManager().method_31(this);
   }

   // $FF: renamed from: c (int) void
   public void method_3977(int var1) {
      Iterator var3 = this.field_2631.values().iterator();

      while(var3.hasNext()) {
         class_39 var2 = (class_39)var3.next();
         Iterator var5 = var2.method_3989().iterator();

         while(var5.hasNext()) {
            Module var4 = (Module)var5.next();
            var4.method_130(var1);
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.Module) void
   public void method_3978(@NotNull Module var1) {
      f03.field_2312.method_3475(var1);
   }

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fX
   @NotNull
   public class_39 method_3979(@NotNull String var1) {
      return (class_39)this.field_2631.computeIfAbsent(var1, (Function)class_36.field_2630);
   }

   // $FF: renamed from: 3 () void
   public void method_3980() {
      if (!this.field_2632) {
         Gson var1 = (new GsonBuilder()).setPrettyPrinting().create();
         Map var4 = this.field_2631;
         boolean var5 = false;
         Iterator var3 = var4.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var2 = (Entry)var3.next();
            boolean var7 = false;
            String var11 = (String)var2.getKey();
            var7 = false;
            class_39 var12 = (class_39)var2.getValue();
            Iterator var13 = var12.method_3989().iterator();

            while(var13.hasNext()) {
               Module var6 = (Module)var13.next();
               JsonObject var8 = new JsonObject();
               var8.add(var6.method_141(), (JsonElement)var6.method_117());

               try {
                  Pyro.FOLDER.mkdirs();
                  f67.field_2201.method_3282().mkdirs();
                  FileWriter var9 = new FileWriter(new File(f67.field_2201.method_3282(), var6.method_127() + ".json"), false);
                  var1.toJson((JsonElement)var8, (Appendable)var9);
                  var9.close();
               } catch (IOException var10) {
                  var10.printStackTrace();
               }
            }
         }

      }
   }

   // $FF: renamed from: 1 () java.util.List
   @NotNull
   public List method_3981() {
      List var1 = (List)(new ArrayList());
      Iterator var3 = this.field_2631.values().iterator();

      while(var3.hasNext()) {
         class_39 var2 = (class_39)var3.next();
         var1.addAll((Collection)var2.method_3989());
      }

      return var1;
   }

   // $FF: renamed from: 0 (int) void
   public void method_3982(int var1) {
      Iterator var3 = this.field_2631.values().iterator();

      while(var3.hasNext()) {
         class_39 var2 = (class_39)var3.next();
         Iterator var5 = var2.method_3989().iterator();

         while(var5.hasNext()) {
            Module var4 = (Module)var5.next();
            var4.method_114(var1);
         }
      }

   }

   // $FF: renamed from: 0 () void
   public void method_3983() {
      this.field_2632 = true;
      Gson var1 = (new GsonBuilder()).setPrettyPrinting().create();
      Map var4 = this.field_2631;
      boolean var5 = false;
      Iterator var3 = var4.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var2 = (Entry)var3.next();
         boolean var7 = false;
         String var13 = (String)var2.getKey();
         var7 = false;
         class_39 var14 = (class_39)var2.getValue();
         Iterator var15 = var14.method_3989().iterator();

         while(var15.hasNext()) {
            Module var6 = (Module)var15.next();

            try {
               File var8 = new File(f67.field_2201.method_3282(), var6.method_127() + ".json");
               if (var8.exists()) {
                  try {
                     FileReader var16 = new FileReader(var8);
                     Object var10000 = var1.fromJson((Reader)var16, JsonObject.class);
                     if (var10000 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                     }

                     JsonObject var17 = (JsonObject)var10000;
                     var16.close();
                     var6.method_119(var17.getAsJsonObject(var6.method_141()));
                  } catch (Exception var11) {
                     var11.printStackTrace();
                  }
               } else {
                  var6.method_119((JsonObject)null);
               }
            } catch (Throwable var12) {
               String var9 = "Could not read module configs for " + var6.method_127();
               boolean var10 = false;
               System.out.println(var9);
               throw var12;
            }
         }
      }

      this.field_2632 = false;
      class_4.field_993.method_1464((f4O)null);
      this.method_3980();
   }
}
