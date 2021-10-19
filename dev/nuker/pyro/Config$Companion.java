/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"},
   d2 = {"Ldev/nuker/pyro/Config$Companion;", "", "()V", "INSTANCE", "Ldev/nuker/pyro/Config;", "load", "", "save", "pyroclient"}
)
public final class Config$Companion {
   public final void save() {
      try {
         FileWriter writer = new FileWriter("pyro/config.json");
         Pyro.GSON.toJson(Config.INSTANCE, (Appendable)writer);
         writer.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   @JvmStatic
   public final void load() {
      if ((new File("pyro/config.json")).exists()) {
         try {
            FileReader reader = new FileReader("pyro/config.json");
            Object var10000 = Pyro.GSON.fromJson((Reader)reader, Config.class);
            Intrinsics.checkExpressionValueIsNotNull(var10000, "Pyro.GSON.fromJson(reader, Config::class.java)");
            Config.INSTANCE = (Config)var10000;
            reader.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   private Config$Companion() {
   }

   // $FF: synthetic method
   public Config$Companion(DefaultConstructorMarker $constructor_marker) {
      this();
   }
}
