/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Ref;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class f6x implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f6y
   public f6y field_1808;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$BooleanRef
   public Ref.BooleanRef field_1809;
   // $FF: renamed from: c boolean
   public boolean field_1810;
   // $FF: renamed from: c net.minecraft.block.Block
   public Block field_1811;
   // $FF: renamed from: 0 boolean
   public boolean field_1812;
   // $FF: renamed from: c int
   public int field_1813;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   public BlockPos field_1814;
   // $FF: renamed from: c net.minecraft.util.EnumFacing
   public EnumFacing field_1815;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   public Vec3d field_1816;
   // $FF: renamed from: 0 int
   public int field_1817;

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_3006(EntityPlayerSP var1) {
      this.field_1809.element = false;
      if (fed.field_1217.contains(this.field_1811) || fed.field_1218.contains(this.field_1811) || this.field_1810) {
         f6y.method_658(this.field_1808).player.connection.sendPacket((Packet)(new CPacketEntityAction((Entity)f6y.method_658(this.field_1808).player, Action.START_SNEAKING)));
         this.field_1809.element = true;
      }

      if (this.field_1812) {
         f6y.method_658(this.field_1808).player.inventory.currentItem = this.field_1813;
         f6y.method_658(this.field_1808).player.connection.sendPacket((Packet)(new CPacketHeldItemChange(this.field_1813)));
      }

      f6y.method_658(this.field_1808).playerController.processRightClickBlock(f6y.method_658(this.field_1808).player, f6y.method_658(this.field_1808).world, this.field_1814, this.field_1815, this.field_1816, EnumHand.MAIN_HAND);
      f6y.method_658(this.field_1808).player.connection.sendPacket((Packet)(new CPacketAnimation(EnumHand.MAIN_HAND)));
      if (this.field_1812) {
         f6y.method_658(this.field_1808).player.inventory.currentItem = this.field_1817;
         f6y.method_658(this.field_1808).player.connection.sendPacket((Packet)(new CPacketHeldItemChange(this.field_1817)));
      }

      if (this.field_1809.element) {
         f6y.method_658(this.field_1808).player.connection.sendPacket((Packet)(new CPacketEntityAction((Entity)f6y.method_658(this.field_1808).player, Action.STOP_SNEAKING)));
      }

   }

   public f6x(f6y var1, Ref.BooleanRef var2, boolean var3, Block var4, boolean var5, int var6, BlockPos var7, EnumFacing var8, Vec3d var9, int var10) {
      this.field_1808 = var1;
      this.field_1809 = var2;
      this.field_1810 = var3;
      this.field_1811 = var4;
      this.field_1812 = var5;
      this.field_1813 = var6;
      this.field_1814 = var7;
      this.field_1815 = var8;
      this.field_1816 = var9;
      this.field_1817 = var10;
      super();
   }

   public void accept(Object var1) {
      this.method_3006((EntityPlayerSP)var1);
   }
}
