/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

public class f67 {
   // $FF: renamed from: c dev.nuker.pyro.f66
   @NotNull
   public static f66 field_2200;
   // $FF: renamed from: c dev.nuker.pyro.f67
   public static f67 field_2201;

   // $FF: renamed from: 3 () void
   public void method_3274() {
      f66 var10001;
      if (Config.INSTANCE.profile != null) {
         var10001 = new f66;
         File var10003 = new File(Pyro.FOLDER, "profiles/" + Config.INSTANCE.profile);
         String var10004 = Config.INSTANCE.profile;
         if (var10004 == null) {
            Intrinsics.throwNpe();
         }

         var10001.<init>(var10003, var10004);
      } else {
         f66 var1 = this.method_3281();
         if (!var1.method_3272().exists() || !var1.method_3272().isDirectory()) {
            File var2 = new File(Pyro.FOLDER, "modules");
            if (var2.exists() && var2.isDirectory()) {
               this.method_3275();
            }
         }

         var10001 = var1;
      }

      this.method_3276(var10001);
   }

   // $FF: renamed from: 4 () void
   public void method_3275() {
      PyroClientLoadingPlugin.LOG.info("Migrating to profiles system");
      File var1 = this.method_3281().method_3272();
      FileUtils.copyDirectory(new File(Pyro.FOLDER, "modules"), new File(var1, "modules"));
      if ((new File(Pyro.FOLDER, "hud.json")).exists()) {
         FilesKt.copyTo$default(new File(Pyro.FOLDER, "hud.json"), new File(var1, "hud.json"), false, 0, 6, (Object)null);
      }

      if ((new File(Pyro.FOLDER, "hud")).exists()) {
         FileUtils.copyDirectory(new File(Pyro.FOLDER, "hud"), new File(var1, "hud"));
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f66) void
   public void method_3276(@NotNull f66 var1) {
      field_2200 = var1;
      class_5.method_1479();
      class_37.field_2633.method_3983();
      class_3.field_990.method_3406().method_1452();
      this.method_3280();
   }

   // $FF: renamed from: c () dev.nuker.pyro.f66
   @NotNull
   public f66 method_3277() {
      return field_2200;
   }

   // $FF: renamed from: 5 () java.util.List
   @NotNull
   public List method_3278() {
      boolean var2 = false;
      List var1 = (List)(new ArrayList());
      var1.add(this.method_3281());
      File var11 = new File(Pyro.FOLDER, "profiles");
      if (var11.exists() && var11.isDirectory()) {
         File[] var3 = var11.listFiles();
         boolean var4 = false;
         File[] var5 = var3;
         int var6 = var3.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            File var8 = var5[var7];
            boolean var10 = false;
            if (var8.exists() && var8.isDirectory()) {
               var1.add(new f66(var8, var8.getName()));
            }
         }
      }

      return var1;
   }

   // $FF: renamed from: 6 () java.io.File
   @NotNull
   public File method_3279() {
      return new File(field_2200.method_3272(), "hud");
   }

   static {
      f67 var0 = new f67();
      field_2201 = var0;
      field_2200 = var0.method_3281();
   }

   // $FF: renamed from: 1 () void
   public void method_3280() {
      Config.INSTANCE.profile = Intrinsics.areEqual((Object)field_2200.method_3273(), (Object)"default") ? null : field_2200.method_3273();
      Config.Companion.save();
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f66
   @NotNull
   public f66 method_3281() {
      return new f66(new File(Pyro.FOLDER, "profiles/default"), "default");
   }

   // $FF: renamed from: 2 () java.io.File
   @NotNull
   public File method_3282() {
      return new File(field_2200.method_3272(), "modules");
   }
}
