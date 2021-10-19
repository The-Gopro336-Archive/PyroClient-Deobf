/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.launcher.LoaderGui;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public class ThirdLayer {
   @JvmField
   @NotNull
   public static Map sdb;
   @JvmField
   @NotNull
   public static Map idb;
   public static ThirdLayer INSTANCE;

   static {
      ThirdLayer var0 = new ThirdLayer();
      INSTANCE = var0;
      boolean var1 = false;
      sdb = (Map)(new LinkedHashMap());
      var1 = false;
      idb = (Map)(new LinkedHashMap());
   }

   @JvmStatic
   public static void run(@NotNull LoaderGui param0, @NotNull DataInputStream param1, @NotNull DataOutputStream param2) {
      // $FF: Couldn't be decompiled
   }
}
