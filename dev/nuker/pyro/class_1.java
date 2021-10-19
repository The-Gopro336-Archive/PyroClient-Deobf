/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.arikia.dev.drpc.DiscordRPC;

// $FF: renamed from: dev.nuker.pyro.f0
public class class_1 extends Lambda implements Function0 {
   // $FF: renamed from: c dev.nuker.pyro.f0
   public static class_1 field_15 = new class_1();

   public Object invoke() {
      this.method_58();
      return Unit.INSTANCE;
   }

   public class_1() {
      super(0);
   }

   // $FF: renamed from: c () void
   public void method_58() {
      while(true) {
         DiscordRPC.discordRunCallbacks();
         class_9.field_2271.method_3395();
         Thread.sleep(1000L);
      }
   }
}
