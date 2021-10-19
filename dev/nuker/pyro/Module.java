/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.gui.ClickGui$Window;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Module {
   // $FF: renamed from: c net.minecraft.client.Minecraft
   @JvmField
   public Minecraft field_86;
   // $FF: renamed from: c java.util.Map
   @JvmField
   @NotNull
   public Map field_87;
   // $FF: renamed from: 0 java.util.Map
   @JvmField
   @NotNull
   public Map field_88;
   // $FF: renamed from: c dev.nuker.pyro.fw
   @JvmField
   @NotNull
   public class_6 field_89;
   // $FF: renamed from: 0 dev.nuker.pyro.fw
   @JvmField
   @NotNull
   public class_6 field_90;
   // $FF: renamed from: 1 dev.nuker.pyro.fw
   @JvmField
   @NotNull
   public class_6 field_91;
   // $FF: renamed from: c int
   public int field_92;
   // $FF: renamed from: c java.lang.String
   @Nullable
   public String field_93;
   // $FF: renamed from: 0 int
   public int field_94;
   // $FF: renamed from: 0 java.lang.String
   @Nullable
   public String field_95;
   // $FF: renamed from: 2 dev.nuker.pyro.fw
   @NotNull
   public class_6 field_96;
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_97;
   // $FF: renamed from: 2 java.lang.String
   @NotNull
   public String field_98;
   // $FF: renamed from: 3 java.lang.String
   @Nullable
   public String field_99;

   // $FF: renamed from: 0 (int) void
   public void method_114(int var1) {
      if (var1 == this.method_133()) {
         this.field_89.method_3033(!(Boolean)this.field_89.method_3034());
      }

      this.method_143(Minecraft.getMinecraft().player, (Boolean)this.field_89.method_3034(), var1);
   }

   // $FF: renamed from: 1 (int) void
   public void method_115(int var1) {
      this.field_92 = var1;
      class_37.field_2633.method_3978(this);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      if (var1) {
         Pyro.getEventManager().method_31(this);
      } else {
         Pyro.getEventManager().method_33(this);
      }

   }

   // $FF: renamed from: 2 () com.google.gson.JsonObject
   @NotNull
   public JsonObject method_117() {
      JsonObject var1 = new JsonObject();
      var1.add("enabled", (JsonElement)(new JsonPrimitive((Boolean)this.field_89.method_3034())));
      var1.add("expanded", (JsonElement)(new JsonPrimitive((Boolean)this.field_90.method_3034())));
      var1.add("keybind", (JsonElement)(new JsonPrimitive((Number)this.method_133())));
      var1.add("hidden", (JsonElement)(new JsonPrimitive((Boolean)this.field_96.method_3034())));
      JsonObject var2 = new JsonObject();
      Map var5 = this.field_87;
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

   // $FF: renamed from: c (dev.nuker.pyro.fw) void
   public void method_118(@NotNull class_6 var1) {
      this.field_96 = var1;
   }

   // $FF: renamed from: c (com.google.gson.JsonObject) void
   public void method_119(@Nullable JsonObject var1) {
      Iterator var4;
      f0w var6;
      if (var1 == null) {
         this.field_89.method_3033(false);
         this.field_90.method_3033(false);
         this.method_115(-1);
         Iterable var2 = (Iterable)this.field_87.values();
         boolean var3 = false;
         var4 = var2.iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            var6 = (f0w)var5;
            boolean var7 = false;
            var6.getValue().method_3033(var6.method_3304());
         }
      } else {
         this.field_89.method_3033(var1.get("enabled").getAsBoolean());
         this.field_90.method_3033(var1.get("expanded").getAsBoolean());
         this.method_115(var1.get("keybind").getAsInt());

         try {
            this.field_96.method_3033(var1.get("hidden").getAsBoolean());
         } catch (Exception var10) {
         }

         JsonObject var11 = var1.getAsJsonObject("settings");
         Map var13 = this.field_87;
         boolean var15 = false;
         var4 = var13.entrySet().iterator();

         while(var4.hasNext()) {
            Entry var12 = (Entry)var4.next();
            boolean var8 = false;
            String var14 = (String)var12.getKey();
            var8 = false;
            var6 = (f0w)var12.getValue();
            if (var11.has(var14)) {
               try {
                  var6.method_3310(var11.get(var14));
               } catch (Exception var9) {
               }
            }
         }
      }

   }

   // $FF: renamed from: 1 (java.lang.String) dev.nuker.pyro.f0w
   @Nullable
   public f0w method_120(@Nullable String var1) {
      return var1 != null ? (f0w)this.field_87.get(var1) : null;
   }

   // $FF: renamed from: 1 () java.lang.String
   @Nullable
   public String method_121() {
      return this.field_93;
   }

   // $FF: renamed from: 8 () java.lang.String
   @Nullable
   public String method_122() {
      return this.field_93;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
   }

   // $FF: renamed from: c (dev.nuker.pyro.gui.ClickGui$Window) void
   public void method_124(@NotNull ClickGui$Window var1) {
      List var2 = (List)(new ArrayList());
      Iterator var4 = this.field_87.values().iterator();

      while(var4.hasNext()) {
         f0w var3 = (f0w)var4.next();
         var2.add(var3.method_3309());
      }

      var1.addModule(this.field_98, (Boolean)this.field_89.method_3034(), var2, (Consumer)(new class_25(this)), (class_6)(new class_7(this.method_133(), (Consumer)(new class_22(this)))), this.field_90, this.field_91);
   }

   // $FF: renamed from: c (int) void
   public void method_125(int var1) {
      this.field_94 = var1;
   }

   // $FF: renamed from: 2 (java.lang.String) void
   public void method_126(@Nullable String var1) {
      this.field_93 = var1;
   }

   public f0w register(f0w var1) {
      if (var1 instanceof f0t) {
         Ref.BooleanRef var3 = new Ref.BooleanRef();
         var3.element = true;
         Iterable var4 = (Iterable)this.method_140((List)((f0t)var1).getValue().method_3034(), var1.method_3315());
         boolean var5 = false;
         Iterator var6 = var4.iterator();

         while(var6.hasNext()) {
            Object var7 = var6.next();
            f0w var8 = (f0w)var7;
            boolean var9 = false;
            if (var3.element) {
               var8.method_3306(var1.method_3315());
            }

            var3.element = false;
            this.field_87.put(var8.method_3315(), var8);
            var8.method_3313((Consumer)(new class_29(this, var3, var1)));
         }
      } else if (var1 instanceof f0z) {
         int var17 = 0;

         for(int var18 = ((List[])((f0z)var1).getValue().method_3034()).length; var17 < var18; ++var17) {
            List var19 = ((List[])((f0z)var1).getValue().method_3034())[var17];
            StringBuilder var10002 = (new StringBuilder()).append(var1.method_3315()).append('[');
            String var21 = ((Enum[])((Enum)((f0z)var1).method_3334().c()).getClass().getEnumConstants())[var17].name();
            StringBuilder var15 = var10002;
            boolean var23 = false;
            if (var21 == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            String var16 = var21.toUpperCase();
            List var20 = this.method_140(var19, var15.append(var16).append(']').toString());
            Iterable var22 = (Iterable)var20;
            var23 = false;
            Iterator var24 = var22.iterator();

            while(var24.hasNext()) {
               Object var10 = var24.next();
               f0w var11 = (f0w)var10;
               boolean var12 = false;
               this.field_87.put(var11.method_3315(), var11);
               var11.method_3313((Consumer)(new class_26(this)));
            }
         }

         this.field_87.put(var1.method_3315(), ((f0z)var1).method_3334());
         ((f0z)var1).method_3334().0((Consumer)(new class_27(this)));
      } else {
         Map var10000 = this.field_87;
         if (var1 == null) {
            Intrinsics.throwNpe();
         }

         var10000.put(var1.method_3315(), var1);
         var1.method_3313((Consumer)(new class_24(this)));
      }

      return var1;
   }

   // $FF: renamed from: 3 () java.lang.String
   @NotNull
   public String method_127() {
      return this.field_98;
   }

   // $FF: renamed from: 3 (java.lang.String) void
   public void method_128(@NotNull String var1) {
      this.field_98 = var1;
   }

   // $FF: renamed from: 0 () java.lang.String
   @Nullable
   public String method_129() {
      return this.field_95;
   }

   // $FF: renamed from: 2 (int) void
   public void method_130(int var1) {
      if (this.method_133() != -1 && this.method_133() != 0 && var1 != 0 && var1 != 1) {
         if (-var1 == this.method_133()) {
            this.field_89.method_3033(!(Boolean)this.field_89.method_3034());
         }

         this.method_143(Minecraft.getMinecraft().player, (Boolean)this.field_89.method_3034(), -var1);
      }
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_131() {
      return this.field_96;
   }

   // $FF: renamed from: c (java.util.Collection) java.util.List
   @NotNull
   public List method_132(@NotNull Collection var1) {
      Iterable var3 = (Iterable)var1;
      boolean var4 = false;
      boolean var6 = false;
      Comparator var7 = (Comparator)(new class_23());
      List var2 = CollectionsKt.sortedWith(var3, var7);
      var4 = false;
      Map var36 = (Map)(new LinkedHashMap());
      boolean var5 = false;
      List var37 = (List)(new ArrayList());
      Iterator var39 = var2.iterator();

      while(true) {
         while(true) {
            while(true) {
               String var9;
               f0w var38;
               String var40;
               do {
                  if (!var39.hasNext()) {
                     return var37;
                  }

                  var38 = (f0w)var39.next();
                  var40 = var38.method_3315();
                  String var8 = StringsKt.substringBeforeLast$default(StringsKt.substringAfterLast$default(var40, '.', (String)null, 2, (Object)null), '[', (String)null, 2, (Object)null);
                  var9 = StringsKt.contains$default((CharSequence)var40, '.', false, 2, (Object)null) ? StringsKt.substringBeforeLast$default(var40, '.', (String)null, 2, (Object)null) + '.' + var8 : var8;
               } while(var36.get(var9) != null);

               Iterable var11 = (Iterable)var2;
               boolean var12 = false;
               boolean var10000;
               boolean var16;
               if (var11 instanceof Collection && ((Collection)var11).isEmpty()) {
                  var10000 = false;
               } else {
                  Iterator var13 = var11.iterator();

                  while(true) {
                     if (!var13.hasNext()) {
                        var10000 = false;
                        break;
                     }

                     Object var14 = var13.next();
                     f0w var15 = (f0w)var14;
                     var16 = false;
                     if (StringsKt.startsWith$default(var15.method_3315(), var40 + '[', false, 2, (Object)null)) {
                        var10000 = true;
                        break;
                     }
                  }
               }

               f0w var55;
               label781: {
                  boolean var10 = var10000;
                  boolean var17;
                  if (!var10) {
                     Iterable var42 = (Iterable)var2;
                     boolean var45 = false;
                     if (var42 instanceof Collection && ((Collection)var42).isEmpty()) {
                        var10000 = true;
                     } else {
                        Iterator var47 = var42.iterator();

                        while(true) {
                           if (!var47.hasNext()) {
                              var10000 = true;
                              break;
                           }

                           Object var49 = var47.next();
                           f0w var51 = (f0w)var49;
                           var17 = false;
                           if (StringsKt.startsWith$default(var51.method_3315(), var40 + '.', false, 2, (Object)null)) {
                              var10000 = false;
                              break;
                           }
                        }
                     }

                     if (var10000) {
                        var55 = var38;
                        break label781;
                     }
                  }

                  if (!var10) {
                     var55 = (f0w)(new f0t(var38, new f0w[0]));
                  } else {
                     if (!(var38 instanceof f0o)) {
                        throw (Throwable)(new IllegalStateException(this.field_98 + " has incorrect setting reference - " + var40 + " should be an enum setting"));
                     }

                     f0o var54 = (f0o)var38;
                     Object var10001 = ((f0o)var38).1();
                     if (var10001 == null) {
                        Intrinsics.throwNpe();
                     }

                     int var43 = ((Enum)var10001).getClass().getEnumConstants().length;
                     f0o var30 = var54;
                     List[] var46 = new List[var43];

                     for(int var48 = 0; var48 < var43; ++var48) {
                        var16 = false;
                        var17 = false;
                        List var33 = CollectionsKt.emptyList();
                        var46[var48] = var33;
                     }

                     var55 = (f0w)(new f0z(var30, var46));
                  }
               }

               f0w var41 = var55;
               var36.put(var9, var41);
               if (StringsKt.contains$default((CharSequence)var38.method_3315(), '.', false, 2, (Object)null)) {
                  String var44 = StringsKt.substringBeforeLast$default(var38.method_3315(), '.', (String)null, 2, (Object)null);
                  if (StringsKt.endsWith$default((CharSequence)var44, ']', false, 2, (Object)null)) {
                     var44 = StringsKt.substringBeforeLast$default(var44, '[', (String)null, 2, (Object)null);
                  }

                  f0w var50 = (f0w)var36.get(var44);
                  if (var50 instanceof f0z) {
                     String var52 = StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(var40, '[', (String)null, 2, (Object)null), ']', (String)null, 2, (Object)null);
                     Object[] var18 = ((Enum)((f0z)var50).method_3334().1()).getClass().getEnumConstants();
                     boolean var19 = false;
                     Object[] var20 = var18;
                     int var21 = var18.length;

                     Object var58;
                     label771: {
                        for(int var22 = 0; var22 < var21; ++var22) {
                           Object var23 = var20[var22];
                           Enum var24 = (Enum)var23;
                           boolean var25 = false;
                           String var26 = var24.name();
                           boolean var27 = false;
                           if (var26 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           if (Intrinsics.areEqual((Object)var26.toUpperCase(), (Object)var52)) {
                              var58 = var23;
                              break label771;
                           }
                        }

                        var58 = null;
                     }

                     Enum var59 = (Enum)var58;
                     if ((Enum)var58 == null) {
                        throw (Throwable)(new IllegalStateException(var44 + " has incorrect setting reference - " + StringsKt.substringBeforeLast$default(var40, '[', (String)null, 2, (Object)null) + " is missing constant " + StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(var40, '[', (String)null, 2, (Object)null), ']', (String)null, 2, (Object)null)));
                     }

                     Enum var53 = var59;
                     ((List[])((f0z)var50).c())[var53.ordinal()].add(var41);
                  } else {
                     if (!(var50 instanceof f0t)) {
                        if (var50 == null) {
                           throw (Throwable)(new IllegalStateException(var44 + " has incorrect setting parent - " + var44 + ": Expected Swappable or List but got null"));
                        }

                        IllegalStateException var57 = new IllegalStateException;
                        StringBuilder var10002 = (new StringBuilder()).append(var44).append(" has incorrect setting parent - ");
                        if (var50 == null) {
                           Intrinsics.throwNpe();
                        }

                        var57.<init>(var10002.append(var50.method_3315()).append(": Expected Swappable or List but got ").append(var50.getClass()).toString());
                        throw (Throwable)var57;
                     }

                     List var56 = (List)((f0t)var50).getValue().method_3034();
                     if (var41 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.setting.Setting<*>");
                     }

                     var56.add(var41);
                  }
               } else {
                  var37.add(var41);
               }
            }
         }
      }
   }

   // $FF: renamed from: c () int
   public int method_133() {
      return this.field_92;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_134(@Nullable String var1) {
      this.field_99 = var1;
   }

   // $FF: renamed from: 4 (java.lang.String) void
   public void method_135(@NotNull String var1) {
      this.field_97 = var1;
   }

   // $FF: renamed from: 5 (java.lang.String) void
   public void method_136(@Nullable String var1) {
      if (Intrinsics.areEqual((Object)this.field_93, (Object)var1) ^ true) {
         if (this.field_93 == null) {
            this.field_93 = var1;
            class_5.field_1004.method_1474(this);
         } else {
            this.field_93 = var1;
            class_5.field_1004.method_1470(this);
         }
      }

   }

   // $FF: renamed from: 0 (java.lang.String) void
   public void method_137(@Nullable String var1) {
      this.field_95 = var1;
   }

   // $FF: renamed from: 6 () java.lang.String
   @NotNull
   public String method_138() {
      return this.field_93 == null ? this.field_98 : this.field_98 + " " + ChatFormatting.GRAY + this.field_93;
   }

   // $FF: renamed from: 9 () int
   public int method_139() {
      return this.field_94;
   }

   public Module(@NotNull String var1, @NotNull String var2, @Nullable String var3) {
      this(var1, var2, var3, false);
   }

   // $FF: renamed from: c (java.util.List, java.lang.String) java.util.List
   @NotNull
   public List method_140(@NotNull List var1, @NotNull String var2) {
      boolean var4 = false;
      List var3 = (List)(new ArrayList());
      Iterable var27 = (Iterable)var1;
      boolean var5 = false;
      Iterator var6 = var27.iterator();

      while(var6.hasNext()) {
         Object var7 = var6.next();
         f0w var8 = (f0w)var7;
         boolean var9 = false;
         boolean var14;
         boolean var18;
         if (var8 instanceof f0t) {
            boolean var28 = true;
            f0w var29 = var8;
            Iterable var30 = (Iterable)this.method_140((List)((f0t)var8).getValue().method_3034(), var2 + '.' + var8.method_3315());
            var14 = false;
            Iterator var15 = var30.iterator();

            while(var15.hasNext()) {
               Object var31 = var15.next();
               f0w var33 = (f0w)var31;
               var18 = false;
               if (var28) {
                  var33.method_3306(var2 + '.' + var29.method_3315());
               }

               var28 = false;
               var3.add(var33);
            }
         } else if (!(var8 instanceof f0z)) {
            var8.method_3306(var2 + '.' + var8.method_3315());
            var3.add(var8);
         } else {
            int var11 = 0;

            for(int var12 = ((List[])((f0z)var8).getValue().method_3034()).length; var11 < var12; ++var11) {
               List var13 = ((List[])((f0z)var8).getValue().method_3034())[var11];
               var14 = true;
               StringBuilder var10002 = (new StringBuilder()).append(var2).append('.').append(var8.method_3315()).append('[');
               String var17 = ((Enum[])((Enum)((f0z)var8).method_3334().c()).getClass().getEnumConstants())[var11].name();
               StringBuilder var19 = var10002;
               var18 = false;
               if (var17 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
               }

               String var22 = var17.toUpperCase();
               List var16 = this.method_140(var13, var19.append(var22).append(']').toString());
               Iterable var32 = (Iterable)var16;
               var18 = false;
               Iterator var23 = var32.iterator();

               while(var23.hasNext()) {
                  Object var24 = var23.next();
                  f0w var25 = (f0w)var24;
                  boolean var26 = false;
                  var3.add(var25);
               }
            }

            ((f0z)var8).method_3334().1(var2 + '.' + var8.method_3315());
            var3.add(((f0z)var8).method_3334());
         }
      }

      return var3;
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_141() {
      return this.field_97;
   }

   public Module(@NotNull String var1, @NotNull String var2, @Nullable String var3, boolean var4) {
      this.field_97 = var1;
      this.field_98 = var2;
      this.field_99 = var3;
      this.field_86 = Minecraft.getMinecraft();
      this.field_87 = (Map)(new LinkedHashMap());
      this.field_88 = (Map)(new LinkedHashMap());
      this.field_92 = -1;
      this.field_94 = -1;
      this.field_89 = (class_6)(new class_7(false, (Consumer)(new class_30(this))));
      this.field_96 = (class_6)(new class_7(var4, (Consumer)(new class_31(this))));
      this.field_90 = (class_6)(new class_7(false, (Consumer)(new class_28(this))));
      this.field_91 = (class_6)(new class_7(0));
   }

   // $FF: renamed from: 7 () java.lang.String
   @Nullable
   public String method_142() {
      return this.field_99;
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP, boolean, int) void
   public void method_143(@Nullable EntityPlayerSP var1, boolean var2, int var3) {
   }
}
