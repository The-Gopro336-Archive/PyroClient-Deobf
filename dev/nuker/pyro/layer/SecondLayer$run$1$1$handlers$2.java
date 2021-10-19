/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import net.arikia.dev.drpc.callbacks.ErroredCallback;
import org.jetbrains.annotations.NotNull;

public class SecondLayer$run$1$1$handlers$2 implements ErroredCallback {
   public static SecondLayer$run$1$1$handlers$2 INSTANCE = new SecondLayer$run$1$1$handlers$2();

   public void apply(int code, @NotNull String msg) {
      String var3 = code + " : " + msg;
      boolean var4 = false;
      System.out.println(var3);
   }
}
