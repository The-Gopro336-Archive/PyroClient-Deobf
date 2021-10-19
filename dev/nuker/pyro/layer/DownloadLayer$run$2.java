/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

public class DownloadLayer$run$2 extends Lambda implements Function2 {
   public Ref.BooleanRef $shouldStop;
   public Ref.ObjectRef $currentChannel;
   public Ref.ObjectRef $currentVersion;

   public DownloadLayer$run$2(Ref.BooleanRef var1, Ref.ObjectRef var2, Ref.ObjectRef var3) {
      this.$shouldStop = var1;
      this.$currentChannel = var2;
      this.$currentVersion = var3;
      super(2);
   }

   public void invoke(@NotNull String channel, @NotNull String version) {
      this.$shouldStop.element = false;
      this.$currentChannel.element = channel;
      this.$currentVersion.element = version;
   }

   public Object invoke(Object var1, Object var2) {
      this.invoke((String)var1, (String)var2);
      return Unit.INSTANCE;
   }
}
