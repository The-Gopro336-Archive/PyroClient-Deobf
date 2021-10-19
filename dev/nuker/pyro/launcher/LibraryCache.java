/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.commons.io.IOUtils;

public class LibraryCache {
   public static Field field = null;

   public static Map getResourceCache() {
      if (field == null) {
         try {
            field = LaunchClassLoader.class.getDeclaredField("resourceCache");
            field.setAccessible(true);
         } catch (NoSuchFieldException var2) {
            var2.printStackTrace();
         }
      }

      try {
         return (Map)field.get(Launch.classLoader);
      } catch (IllegalAccessException var1) {
         var1.printStackTrace();
         return null;
      }
   }

   public static void initLibrary(File file) {
      try {
         Map resourceCache = getResourceCache();
         ZipFile zipFile = new ZipFile(file);
         Enumeration entries = zipFile.entries();

         while(entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry)entries.nextElement();
            String name = entry.getName();
            if (name.endsWith(".class")) {
               name = name.substring(0, ~(6 + ~name.length())).replace('/', '.');
               InputStream in = zipFile.getInputStream(entry);
               resourceCache.put(name, IOUtils.toByteArray(in));
            }
         }
      } catch (IOException var7) {
         var7.printStackTrace();
      }

   }
}
