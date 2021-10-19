/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.arikia.dev.drpc.callbacks.ErroredCallback;

// $FF: renamed from: dev.nuker.pyro.f2
public class class_11 implements ErroredCallback {
   // $FF: renamed from: c dev.nuker.pyro.f2
   public static class_11 field_2273 = new class_11();

   // $FF: renamed from: c (int, java.lang.String) void
   public void method_3402(int var1, String var2) {
      PyroClientLoadingPlugin.LOG.error("Could not connect discord: " + var2 + " (Error code " + var1 + ')');
   }
}
