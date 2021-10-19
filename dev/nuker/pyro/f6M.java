/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class f6M implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f6O
   public f6O field_1684;
   // $FF: renamed from: c boolean
   public boolean field_1685;
   // $FF: renamed from: c net.minecraft.block.Block
   public Block field_1686;
   // $FF: renamed from: c int
   public int field_1687;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   public BlockPos field_1688;
   // $FF: renamed from: c net.minecraft.util.EnumFacing
   public EnumFacing field_1689;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   public Vec3d field_1690;
   // $FF: renamed from: 0 int
   public int field_1691;

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_2946(@Nullable EntityPlayerSP var1) {
      boolean var2 = false;
      if (fed.field_1217.contains(this.field_1686) || fed.field_1218.contains(this.field_1686) || this.field_1685) {
         f6O.method_931(this.field_1684).player.connection.sendPacket((Packet)(new CPacketEntityAction((Entity)f6O.method_931(this.field_1684).player, Action.START_SNEAKING)));
         var2 = true;
      }

      f6O.method_931(this.field_1684).player.inventory.currentItem = this.field_1687;
      f6O.method_931(this.field_1684).player.connection.sendPacket((Packet)(new CPacketHeldItemChange(this.field_1687)));
      f6O.method_931(this.field_1684).player.connection.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock(this.field_1688, this.field_1689, EnumHand.MAIN_HAND, (float)this.field_1690.x, (float)this.field_1690.y, (float)this.field_1690.z)));
      f6O.method_931(this.field_1684).player.connection.sendPacket((Packet)(new CPacketAnimation(EnumHand.MAIN_HAND)));
      f6O.method_931(this.field_1684).player.inventory.currentItem = this.field_1691;
      f6O.method_931(this.field_1684).player.connection.sendPacket((Packet)(new CPacketHeldItemChange(this.field_1691)));
      if (var2) {
         f6O.method_931(this.field_1684).player.connection.sendPacket((Packet)(new CPacketEntityAction((Entity)f6O.method_931(this.field_1684).player, Action.STOP_SNEAKING)));
      }

   }

   public f6M(f6O var1, boolean var2, Block var3, int var4, BlockPos var5, EnumFacing var6, Vec3d var7, int var8) {
      this.field_1684 = var1;
      this.field_1685 = var2;
      this.field_1686 = var3;
      this.field_1687 = var4;
      this.field_1688 = var5;
      this.field_1689 = var6;
      this.field_1690 = var7;
      this.field_1691 = var8;
      super();
   }

   public void accept(Object var1) {
      this.method_2946((EntityPlayerSP)var1);
   }
}
