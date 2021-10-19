/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonObject;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;

// $FF: renamed from: dev.nuker.pyro.fA
public class class_5 extends fdZ {
   // $FF: renamed from: c java.util.List
   public List field_995 = new ArrayList();
   // $FF: renamed from: c dev.nuker.pyro.f5m[]
   public f5m[] field_996 = new f5m[4];
   // $FF: renamed from: c java.util.Map
   public Map field_997 = new HashMap();
   // $FF: renamed from: 0 java.util.List
   public List field_998 = new CopyOnWriteArrayList();
   // $FF: renamed from: c int
   public int field_999 = 0;
   // $FF: renamed from: c dev.nuker.pyro.f5w
   public f5w field_1000;
   // $FF: renamed from: c boolean
   public boolean field_1001 = false;
   // $FF: renamed from: 0 int
   public int field_1002 = 0;
   // $FF: renamed from: c java.util.Timer
   public Timer field_1003 = new Timer();
   // $FF: renamed from: c dev.nuker.pyro.fA
   public static class_5 field_1004 = new class_5();

   public class_5() {
      this.field_1003.schedule(new class_14(), 0L, 16L);
   }

   // $FF: renamed from: c (dev.nuker.pyro.Module) void
   public void method_1466(@NotNull Module var1) {
      if ((Boolean)var1.field_89.method_3034() && !this.field_997.containsKey(var1)) {
         f5r var3 = new f5r(var1);
         this.field_997.put(var1, var3);
         this.field_1000.c.method_1606(var3);
      } else {
         f5k var2 = null;
         if (this.field_997.containsKey(var1)) {
            var2 = (f5k)this.field_997.get(var1);
         }

         if (var2 != null) {
            var2.field_1017 = this::2;
            var2.method_1513();
         }
      }

      this.field_1000.c.method_1610();
   }

   // $FF: renamed from: 1 () void
   public void method_1467() {
      f5m[] var1 = this.field_996;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         f5m var4 = var1[var3];
         var4.method_1605();
      }

      ScaledResolution var5 = new ScaledResolution(c);
      this.field_998.forEach(fA::c);
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, int, int, boolean) void
   public void method_1468(ScaledResolution var1, int var2, int var3, boolean var4) {
      if (c.world != null && c.player != null) {
         f5m[] var5 = this.field_996;
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            f5m var8 = var5[var7];
            var8.method_1616(var1, var2, var3, var4);
         }

         this.field_998.forEach(fA::c);
      }
   }

   // $FF: renamed from: 9 () java.util.List
   public List method_1469() {
      return this.field_995;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.Module) void
   public void method_1470(@NotNull Module var1) {
      if (this.field_997.containsKey(var1)) {
         ((f5G)((f5k)this.field_997.get(var1)).field_1005).method_1587(var1.method_122());
         this.field_1000.c.method_1610();
      }

   }

   // $FF: renamed from: 7 () void
   public void method_1471() {
      f5m[] var1 = this.field_996;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         f5m var4 = var1[var3];
         var4.method_1604();
      }

      if (c.currentScreen instanceof GuiChat) {
         if (this.field_1002 < 14) {
            ++this.field_1002;
         }
      } else if (this.field_1002 > 0) {
         --this.field_1002;
      }

   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f44) void
   @f0g
   @LauncherEventHide
   public void method_1472(f44 var1) {
      if (var1.method_3186() && !this.field_997.containsKey(var1.method_3187())) {
         f5r var3 = new f5r(var1.method_3187());
         this.field_997.put(var1.method_3187(), var3);
         this.field_1000.c.method_1606(var3);
      } else {
         f5k var2 = null;
         if (this.field_997.containsKey(var1.method_3187())) {
            var2 = (f5k)this.field_997.get(var1.method_3187());
         }

         if (var2 != null) {
            var2.field_1017 = this::c;
            var2.method_1513();
         }
      }

   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, int, int, dev.nuker.pyro.f5u) void
   public static void method_1473(ScaledResolution var0, int var1, int var2, f5u var3) {
      if (var3.6() == null && var3.e()) {
         var3.method_1505(var0, var1, var2);
      }

   }

   // $FF: renamed from: 1 (dev.nuker.pyro.Module) void
   public void method_1474(@NotNull Module var1) {
      if (this.field_997.containsKey(var1)) {
         ((f5G)((f5k)this.field_997.get(var1)).field_1005).method_1587(var1.method_122());
         this.field_1000.c.method_1610();
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f5u, int) void
   public void method_1475(f5u var1, int var2) {
      this.field_998.remove(var1);
      this.method_1494(var2).method_1614(var1, false);
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f5k) dev.nuker.pyro.f5k
   public f5k method_1476(f5k var1) {
      f5q var2 = var1.field_1005;
      File var3 = new File(Pyro.HUDMODULESFOLDER, var2.method_1525() + ".json");
      if (var3.exists()) {
         try {
            var2.method_1527((JsonObject)Pyro.GSON.fromJson(new FileReader(var3), JsonObject.class));
         } catch (FileNotFoundException var5) {
            var5.printStackTrace();
         }
      }

      this.field_995.add(var1);
      return var1;
   }

   // $FF: renamed from: 8 () void
   public void method_1477() {
      Pyro.getEventManager().method_31(this);
   }

   // $FF: renamed from: a () void
   public void method_1478() {
      HashMap var1 = new HashMap();
      Iterator var2 = this.field_995.iterator();

      while(var2.hasNext()) {
         f5k var3 = (f5k)var2.next();
         var1.put(var3.method_1515(), new Pair(var3, var3.method_1519()));
      }

      if ((new File(f67.field_2201.method_3277().method_3272(), "hud.json")).exists()) {
         try {
            FileReader var12 = new FileReader(new File(f67.field_2201.method_3277().method_3272(), "hud.json"));
            Map[] var13 = (Map[])Pyro.GSON.fromJson(var12, Map[].class);
            Map[] var4 = var13;
            int var5 = var13.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               Map var7 = var4[var6];
               if (var1.containsKey(var7.get("name"))) {
                  Pair var8 = (Pair)var1.get(var7.get("name"));
                  boolean var9 = var7.containsKey("corner");
                  if (var8.getSecond() != null) {
                     ((f5m)var8.getSecond()).method_1612((f5k)var8.getFirst());
                  }

                  ((f5k)var8.getFirst()).method_1500((Boolean)var7.get("visible"));
                  if (var9) {
                     f5m var10 = this.field_996[(int)(Double)var7.get("corner")];
                     var10.method_1614((f5k)var8.getFirst(), false);
                  } else {
                     ((f5k)var8.getFirst()).method_1504((float)((int)(Double)var7.get("x")));
                     ((f5k)var8.getFirst()).method_1514((float)((int)(Double)var7.get("y")));
                     ((f5k)var8.getFirst()).method_1503((f5m)null);
                     this.field_998.add((f5u)var8.getFirst());
                  }
               }
            }
         } catch (FileNotFoundException var11) {
            var11.printStackTrace();
         }
      }

   }

   // $FF: renamed from: 5 () void
   public static void method_1479() {
      field_1004.field_1001 = false;
      field_1004.field_995.clear();
      field_1004.field_998.clear();
      field_1004.method_1486();
      field_1004.field_1001 = false;
      field_1004.method_1478();
      field_1004.meth0();
      field_1004.method_1487();
      field_1004.field_1001 = true;
   }

   public void meth3() {
      if (!c.gameSettings.showDebugInfo && !(c.currentScreen instanceof f5j)) {
         ScaledResolution var1 = new ScaledResolution(c);
         this.method_1468(var1, -420, -420, false);
      }
   }

   // $FF: renamed from: 2 (dev.nuker.pyro.Module) void
   public void method_1480(Module var1) {
      f5k var10000 = (f5k)this.field_997.remove(var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5u) void
   public void method_1481(f5u var1) {
      if (var1.6() != null) {
         var1.6().method_1612(var1);
         var1.c((f5m)null);
         this.field_998.add(var1);
      }

   }

   // $FF: renamed from: c (java.util.Map, dev.nuker.pyro.f5k) java.util.Map
   public Map method_1482(Map var1, f5k var2) {
      var1.put("visible", var2.method_1509());
      var1.put("name", var2.method_1515());
      return var1;
   }

   public void meth0() {
      this.method_1492().forEach(fA::c);
   }

   // $FF: renamed from: 3 (dev.nuker.pyro.Module) void
   public void method_1483(Module var1) {
      f5r var2 = new f5r(var1);
      this.field_997.put(var1, var2);
      this.field_1000.c.method_1606(var2);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f44) void
   public void method_1484(f44 var1) {
      f5k var10000 = (f5k)this.field_997.remove(var1.method_3187());
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1485(f4t var1) {
      f5m[] var2 = this.field_996;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         f5m var5 = var2[var4];
         Iterator var6 = var5.method_1617().iterator();

         while(var6.hasNext()) {
            f5k var7 = (f5k)var6.next();
            if (var7 instanceof f5u) {
               ((f5u)var7).method_1522();
            }
         }
      }

      Iterator var8 = this.field_998.iterator();

      while(var8.hasNext()) {
         f5k var9 = (f5k)var8.next();
         if (var9 instanceof f5u) {
            ((f5u)var9).method_1522();
         }
      }

   }

   // $FF: renamed from: c () void
   public void method_1486() {
      this.field_996 = new f5m[4];
      this.field_996[0] = new f5m(0);
      this.field_996[1] = new f5m(1);
      this.field_996[2] = new f5m(2);
      this.field_996[3] = new f5m(3);
      this.field_1000 = new f5w(this.field_999);
      this.field_996[0].method_1614(this.method_1476(new f5u("ArrayList", "General", this.field_1000)), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("FPS", "General", new f5C())), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("Speed", "Misc", new f5S())), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("Chests", "Misc", new f5y())), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("TPS", "General", new f5U())), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("ServerBrand", "Misc", new f5Q())), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("Elytras", "Misc", new f5B())), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("Ping", "General", new f5J())), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("TargetInfo", "Combat", new f5V())), false);
      this.field_996[1].method_1614(this.method_1476(new f5u("Notifications", "General", new f5H())), false);
      this.field_996[2].method_1614(this.method_1476(new f5u("Direction", "General", new f5A())), false);
      this.field_996[2].method_1614(this.method_1476(new f5u("Coords", "General", new f5z())), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("Watermark", "Misc", new f6c())), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("Armor", "Combat", new f5v())), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("PlayerInfo", "General", new f5K())), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("Inventory", "General", new f5D())), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("PotionEffects", "General", new f5O(3))), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("PVPInfo", "Combat", new f5I())), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("ServerNotResponding", "General", new f5R())), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("TextRadar", "General", new f5X(3), true)), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("PlayerModel", "General", new f5L(), true)), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("PvPResources", "Combat", new f5P(), true)), false);
      this.field_996[3].method_1614(this.method_1476(new f5u("TrueDurability", "General", new f5Z(), true)), false);
      this.field_1001 = true;
   }

   // $FF: renamed from: 6 () void
   public void method_1487() {
      this.field_997.clear();
      this.field_1000.c.meth0();
      class_37.field_2633.method_3973().forEach(this::3);
   }

   // $FF: renamed from: c (int, int, int) void
   public void method_1488(int var1, int var2, int var3) {
      this.field_998.forEach(fA::c);
      f5m[] var4 = this.field_996;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         f5m var7 = var4[var6];
         var7.method_1607(var1, var2, var3);
      }

   }

   // $FF: renamed from: c (int, int, int, dev.nuker.pyro.f5u) void
   public static void method_1489(int var0, int var1, int var2, f5u var3) {
      var3.method_1512(var0, var1, var2);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5k) void
   public static void method_1490(f5k var0) {
      Pyro.eventManager.method_33(var0.field_1005);
      Pyro.eventManager.method_31(var0.field_1005);
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, dev.nuker.pyro.f5u) void
   public static void method_1491(ScaledResolution var0, f5u var1) {
      var1.method_1499(var0);
   }

   // $FF: renamed from: 2 () java.util.List
   public List method_1492() {
      return this.field_995;
   }

   // $FF: renamed from: 4 () void
   public void method_1493() {
      if (this.field_1001) {
         ArrayList var1 = new ArrayList();
         ArrayList var2 = new ArrayList();
         int var3 = 0;

         for(int var4 = this.field_996.length; var3 < var4; ++var3) {
            f5m var5 = this.field_996[var3];
            CopyOnWriteArrayList var6 = var5.field_1084;

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               f5k var8 = (f5k)var6.get(var7);
               var2.add(var8);
               HashMap var9 = new HashMap();
               this.method_1482(var9, var8);
               var9.put("corner", var3);
               var1.add(var9);
            }
         }

         Iterator var11 = this.field_998.iterator();

         while(var11.hasNext()) {
            f5u var13 = (f5u)var11.next();
            if (!var2.contains(var13)) {
               var2.add(var13);
               HashMap var14 = new HashMap();
               this.method_1482(var14, var13);
               var14.put("x", var13.7());
               var14.put("y", var13.8());
               var1.add(var14);
            }
         }

         try {
            FileWriter var12 = new FileWriter(new File(f67.field_2201.method_3277().method_3272(), "hud.json"));
            Pyro.GSON.toJson(var1, var12);
            var12.close();
         } catch (IOException var10) {
            var10.printStackTrace();
         }

      }
   }

   // $FF: renamed from: c (int) dev.nuker.pyro.f5m
   public f5m method_1494(int var1) {
      return this.field_996[var1];
   }
}
