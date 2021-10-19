/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.math.BlockPos;

public class f6r implements Predicate {
   // $FF: renamed from: c net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
   public CPacketPlayerTryUseItemOnBlock field_1819;

   // $FF: renamed from: c (dev.nuker.pyro.fe3) boolean
   public boolean method_3007(fe3 var1) {
      return Intrinsics.areEqual((Object)((BlockPos)var1.method_1959()), (Object)this.field_1819.getPos());
   }

   public f6r(CPacketPlayerTryUseItemOnBlock var1) {
      this.field_1819 = var1;
      super();
   }

   public boolean test(Object var1) {
      return this.method_3007((fe3)var1);
   }
}
