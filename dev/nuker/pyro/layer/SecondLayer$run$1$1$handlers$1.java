/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import org.jetbrains.annotations.NotNull;

public class SecondLayer$run$1$1$handlers$1 implements ReadyCallback {
   public SecondLayer$run$1$1 this$0;

   public void apply(@NotNull DiscordUser user) {
      this.this$0.$discord.element = user.userId + "|" + user.username + "#" + user.discriminator;
   }

   public SecondLayer$run$1$1$handlers$1(SecondLayer$run$1$1 var1) {
      this.this$0 = var1;
      super();
   }
}
