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
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class f6l implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f6m
   public f6m field_1791;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$IntRef
   public Ref.IntRef field_1792;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_1793;
   // $FF: renamed from: 0 kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_1794;

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_3004(EntityPlayerSP var1) {
      if (this.field_1792.element != f6m.method_738(this.field_1791).player.inventory.currentItem) {
         f6m.method_738(this.field_1791).player.connection.sendPacket((Packet)(new CPacketHeldItemChange(this.field_1792.element)));
      }

      NetHandlerPlayClient var10000 = f6m.method_738(this.field_1791).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock((BlockPos)this.field_1793.element, EnumFacing.UP, EnumHand.MAIN_HAND, (float)((fex)this.field_1794.element).method_2077().x, (float)((fex)this.field_1794.element).method_2077().y, (float)((fex)this.field_1794.element).method_2077().z)));
      var10000 = f6m.method_738(this.field_1791).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketAnimation(EnumHand.MAIN_HAND)));
      if (this.field_1792.element != f6m.method_738(this.field_1791).player.inventory.currentItem) {
         f6m.method_738(this.field_1791).player.connection.sendPacket((Packet)(new CPacketHeldItemChange(f6m.method_738(this.field_1791).player.inventory.currentItem)));
      }

   }

   public void accept(Object var1) {
      this.method_3004((EntityPlayerSP)var1);
   }

   public f6l(f6m var1, Ref.IntRef var2, Ref.ObjectRef var3, Ref.ObjectRef var4) {
      this.field_1791 = var1;
      this.field_1792 = var2;
      this.field_1793 = var3;
      this.field_1794 = var4;
      super();
   }
}
