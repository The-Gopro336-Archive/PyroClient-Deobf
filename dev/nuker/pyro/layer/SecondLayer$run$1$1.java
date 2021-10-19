/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.callbacks.DisconnectedCallback;
import net.arikia.dev.drpc.callbacks.ErroredCallback;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class SecondLayer$run$1$1 extends Lambda implements Function0 {
   public Ref.ObjectRef $discord;
   // $FF: renamed from: $t java.lang.Thread
   public Thread field_3;

   public void invoke() {
      DiscordEventHandlers var1 = (new DiscordEventHandlers.Builder()).setReadyEventHandler((ReadyCallback)(new SecondLayer$run$1$1$handlers$1(this))).setErroredEventHandler((ErroredCallback)SecondLayer$run$1$1$handlers$2.INSTANCE).setDisconnectedEventHandler((DisconnectedCallback)SecondLayer$run$1$1$handlers$3.INSTANCE).build();
      DiscordRPC.discordInitialize("740056531286098001", var1, true);
      int var2 = 0;

      for(byte var3 = 30; var2 <= var3; ++var2) {
         Thread.sleep((long)595741596 ^ 595741688L);
         DiscordRPC.discordRunCallbacks();
         if ((String)this.$discord.element != null) {
            break;
         }
      }

      DiscordRPC.discordShutdown();
      this.field_3.resume();
   }

   public Object invoke() {
      this.invoke();
      return Unit.INSTANCE;
   }

   public SecondLayer$run$1$1(Ref.ObjectRef var1, Thread var2) {
      this.$discord = var1;
      this.field_3 = var2;
      super(0);
   }
}
