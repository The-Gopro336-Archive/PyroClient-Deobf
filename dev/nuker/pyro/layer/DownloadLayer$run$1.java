/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

public class DownloadLayer$run$1 extends Lambda implements Function0 {
   public Ref.BooleanRef $shouldStop;
   public Ref.ObjectRef $currentChannel;
   public Ref.ObjectRef $currentVersion;

   public void invoke() {
      this.$shouldStop.element = true;
      this.$currentChannel.element = (String)null;
      this.$currentVersion.element = (String)null;
   }

   public Object invoke() {
      this.invoke();
      return Unit.INSTANCE;
   }

   public DownloadLayer$run$1(Ref.BooleanRef var1, Ref.ObjectRef var2, Ref.ObjectRef var3) {
      this.$shouldStop = var1;
      this.$currentChannel = var2;
      this.$currentVersion = var3;
      super(0);
   }
}
