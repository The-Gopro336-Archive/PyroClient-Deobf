/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

// $FF: renamed from: dev.nuker.pyro.f1
public class class_10 implements ReadyCallback {
   // $FF: renamed from: c dev.nuker.pyro.f1
   public static class_10 field_2272 = new class_10();

   // $FF: renamed from: c (net.arikia.dev.drpc.DiscordUser) void
   public void method_3401(DiscordUser var1) {
      PyroClientLoadingPlugin.LOG.info("Connected discord: " + var1.username + '#' + var1.discriminator);
   }
}
