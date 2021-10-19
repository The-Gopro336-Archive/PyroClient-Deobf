/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class f6k implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f6m
   public f6m field_1787;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_1788;
   // $FF: renamed from: 0 kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_1789;
   // $FF: renamed from: 1 kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_1790;

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_3003(EntityPlayerSP var1) {
      NetHandlerPlayClient var10000 = f6m.method_738(this.field_1787).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock((BlockPos)this.field_1788.element, (EnumFacing)this.field_1789.element, EnumHand.OFF_HAND, (float)((fex)this.field_1790.element).method_2077().x, (float)((fex)this.field_1790.element).method_2077().y, (float)((fex)this.field_1790.element).method_2077().z)));
      var10000 = f6m.method_738(this.field_1787).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketAnimation(EnumHand.MAIN_HAND)));
   }

   public f6k(f6m var1, Ref.ObjectRef var2, Ref.ObjectRef var3, Ref.ObjectRef var4) {
      this.field_1787 = var1;
      this.field_1788 = var2;
      this.field_1789 = var3;
      this.field_1790 = var4;
      super();
   }

   public void accept(Object var1) {
      this.method_3003((EntityPlayerSP)var1);
   }
}
