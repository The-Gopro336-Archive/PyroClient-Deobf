/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.ConcurrentLinkedQueue;

public class f03 {
   // $FF: renamed from: c java.util.concurrent.ConcurrentLinkedQueue
   public ConcurrentLinkedQueue field_2310 = new ConcurrentLinkedQueue();
   // $FF: renamed from: 0 java.util.concurrent.ConcurrentLinkedQueue
   public ConcurrentLinkedQueue field_2311 = new ConcurrentLinkedQueue();
   // $FF: renamed from: c dev.nuker.pyro.f03
   public static f03 field_2312 = new f03();

   // $FF: renamed from: c (dev.nuker.pyro.f5q) void
   public void method_3474(f5q var1) {
      if (!this.field_2311.contains(var1)) {
         this.field_2311.add(var1);
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.Module) void
   public void method_3475(Module var1) {
      if (!this.field_2310.contains(var1)) {
         this.field_2310.add(var1);
      }

   }

   // $FF: renamed from: c () void
   public void method_3476() {
      Pyro.FOLDER.mkdirs();
      f67.field_2201.method_3282().mkdirs();
      Pyro.HUDMODULESFOLDER.mkdirs();
      Gson var1;
      JsonObject var3;
      FileWriter var4;
      if (!this.field_2310.isEmpty()) {
         var1 = (new GsonBuilder()).setPrettyPrinting().create();

         while(!this.field_2310.isEmpty()) {
            Module var2 = (Module)this.field_2310.poll();
            var3 = new JsonObject();
            var3.add(var2.method_141(), var2.method_117());

            try {
               var4 = new FileWriter(new File(f67.field_2201.method_3282(), var2.method_127() + ".json"), false);
               var1.toJson(var3, var4);
               var4.close();
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }
      }

      if (!this.field_2311.isEmpty()) {
         var1 = (new GsonBuilder()).setPrettyPrinting().create();

         while(!this.field_2311.isEmpty()) {
            f5q var7 = (f5q)this.field_2311.poll();
            var3 = var7.method_1532();

            try {
               var4 = new FileWriter(new File(Pyro.HUDMODULESFOLDER, var7.method_1525() + ".json"), false);
               var1.toJson(var3, var4);
               var4.close();
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }
      }

   }
}
