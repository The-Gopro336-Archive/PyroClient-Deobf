/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NestedClassloader extends ClassLoader {
   public Map repositiory;
   public Map resources;

   @NotNull
   public Class loadClass(@NotNull String name, @NotNull byte[] bytes) {
      this.loadResource(name, bytes);
      return this.loadClass(name);
   }

   @Nullable
   public InputStream getResourceAsStream(@NotNull String name) {
      return this.resources.containsKey(name) ? (InputStream)(new ByteArrayInputStream((byte[])this.resources.get(name))) : this.getParent().getResourceAsStream(name);
   }

   @NotNull
   public Class loadClass(@NotNull String name) {
      Class var4;
      if (this.resources.containsKey(name)) {
         if (this.repositiory.containsKey(name)) {
            Object var10000 = this.repositiory.get(name);
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var4 = (Class)var10000;
         } else {
            byte[] bytes = (byte[])this.resources.get(name);
            if (bytes == null) {
               Intrinsics.throwNpe();
            }

            Class clazz = this.defineClass(bytes, 0, bytes.length);
            this.resolveClass(clazz);
            this.repositiory.put(name, clazz);
            var4 = clazz;
         }
      } else {
         var4 = this.getParent().loadClass(name);
      }

      return var4;
   }

   public void loadResource(@NotNull String name, @NotNull byte[] bytes) {
      this.resources.put(name, bytes);
      if (StringsKt.endsWith$default(name, ".class", false, 2, (Object)null)) {
         this.resources.put(StringsKt.substringBeforeLast$default(StringsKt.replace$default(name, '/', '.', false, 4, (Object)null), ".class", (String)null, 2, (Object)null), bytes);
      } else {
         this.resources.put(StringsKt.replace$default(name, '.', '/', false, 4, (Object)null) + ".class", bytes);
      }

   }

   public NestedClassloader(@Nullable ClassLoader parentLoader) {
      super(parentLoader);
      boolean var2 = false;
      Map var4 = (Map)(new LinkedHashMap());
      this.repositiory = var4;
      var2 = false;
      var4 = (Map)(new LinkedHashMap());
      this.resources = var4;
   }
}
