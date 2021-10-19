/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
   public static transient Config INSTANCE = new Config();
   public String username = null;
   public String password = null;
   public String channel = null;

   public static void load() {
      try {
         if ((new File("pyro/launcher.json")).exists()) {
            Gson gson = new Gson();
            FileReader reader = new FileReader("pyro/launcher.json");
            INSTANCE = (Config)gson.fromJson(reader, Config.class);
            reader.close();
         } else {
            INSTANCE = new Config();
         }
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   public static void save() {
      try {
         Gson gson = new Gson();
         FileWriter writer = new FileWriter("pyro/launcher.json");
         gson.toJson(INSTANCE, writer);
         writer.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }
}
