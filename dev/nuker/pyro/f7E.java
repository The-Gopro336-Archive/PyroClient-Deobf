/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;

public class f7E implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f7G
   public f7G field_1771;

   // $FF: renamed from: c (java.lang.Boolean) void
   public void method_2993(Boolean var1) {
      f7G var10000 = this.field_1771;
      BlockPos var10001 = this.field_1771.method_822();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000.method_751(var10001);
      this.field_1771.method_758((Consumer)(new f7D(this)));
   }

   public f7E(f7G var1) {
      this.field_1771 = var1;
      super();
   }

   // $FF: renamed from: c (java.lang.Object) void
   public void method_2994(Object var1) {
      this.method_2993((Boolean)var1);
   }
}
