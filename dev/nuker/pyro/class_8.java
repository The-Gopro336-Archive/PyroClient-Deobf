/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.arikia.dev.drpc.callbacks.DisconnectedCallback;

// $FF: renamed from: dev.nuker.pyro.f3
public class class_8 implements DisconnectedCallback {
   // $FF: renamed from: c dev.nuker.pyro.f3
   public static class_8 field_2268 = new class_8();

   // $FF: renamed from: c (int, java.lang.String) void
   public void method_3392(int var1, String var2) {
      PyroClientLoadingPlugin.LOG.error("Discord disconnected: " + var2 + " (Error code " + var1 + ')');
   }
}
