/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class f8r implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f8s
   public f8s field_1927;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_1928;

   public f8r(f8s var1, Ref.ObjectRef var2) {
      this.field_1927 = var1;
      this.field_1928 = var2;
      super();
   }

   public void accept(Object var1) {
      this.method_3054((EntityPlayerSP)var1);
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_3054(EntityPlayerSP var1) {
      NetHandlerPlayClient var3;
      if (this.field_1927.method_348() == 0 && this.field_1927.method_359() != null) {
         var3 = f8s.method_351(this.field_1927).getConnection();
         if (var3 == null) {
            Intrinsics.throwNpe();
         }

         var3.sendPacket((Packet)(new CPacketPlayerDigging(Action.START_DESTROY_BLOCK, this.field_1927.method_359(), (EnumFacing)this.field_1928.element)));
         var3 = f8s.method_351(this.field_1927).getConnection();
         if (var3 == null) {
            Intrinsics.throwNpe();
         }

         var3.sendPacket((Packet)(new CPacketPlayerDigging(Action.STOP_DESTROY_BLOCK, this.field_1927.method_359(), (EnumFacing)this.field_1928.element)));
      } else {
         if (this.field_1927.method_359() != null) {
            LinkedHashMap var10000 = this.field_1927.method_360();
            BlockPos var10001 = this.field_1927.method_359();
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            Object var2 = var10000.get(var10001);
            if (var2 == null) {
               Intrinsics.throwNpe();
            }

            ((AtomicInteger)var2).decrementAndGet();
            var3 = f8s.method_351(this.field_1927).getConnection();
            if (var3 == null) {
               Intrinsics.throwNpe();
            }

            var3.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock(this.field_1927.method_359(), (EnumFacing)this.field_1928.element, EnumHand.MAIN_HAND, 0.0F, 0.0F, 0.0F)));
         }

      }
   }
}
