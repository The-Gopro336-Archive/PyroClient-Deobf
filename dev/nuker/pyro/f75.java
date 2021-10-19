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
import net.minecraft.network.play.client.CPacketPlayer.Position;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;

public class f75 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f76
   public f76 field_1733;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$IntRef
   public Ref.IntRef field_1734;

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_2972(EntityPlayerSP var1) {
      if (!f76.method_877(this.field_1733).world.collidesWithAnyBlock(f76.method_877(this.field_1733).player.getEntityBoundingBox().expand(0.0D, -1.1D, 0.0D))) {
         RayTraceResult var2 = few.method_1716().method_1734(f76.method_877(this.field_1733).player.rotationYaw, 90.0F);
         float var3 = (float)(var2.hitVec.x - (double)var2.getBlockPos().getX());
         float var4 = (float)(var2.hitVec.y - (double)var2.getBlockPos().getY());
         float var5 = (float)(var2.hitVec.z - (double)var2.getBlockPos().getZ());
         Pyro.INSTANCE.sendMessage("Glitching down");
         NetHandlerPlayClient var10000;
         if (this.field_1734.element != -1) {
            var10000 = f76.method_877(this.field_1733).getConnection();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000.sendPacket((Packet)(new CPacketHeldItemChange(this.field_1734.element)));
         }

         var10000 = f76.method_877(this.field_1733).getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock(var2.getBlockPos(), var2.sideHit, EnumHand.MAIN_HAND, var3, var4, var5)));
         var10000 = f76.method_877(this.field_1733).getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketAnimation(EnumHand.MAIN_HAND)));
         var10000 = f76.method_877(this.field_1733).getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new Position(f76.method_877(this.field_1733).player.posX, f76.method_877(this.field_1733).player.posY + ((Number)this.field_1733.method_875().c()).doubleValue(), f76.method_877(this.field_1733).player.posZ, false)));
         if (this.field_1734.element != -1) {
            var10000 = f76.method_877(this.field_1733).getConnection();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var10000.sendPacket((Packet)(new CPacketHeldItemChange(f76.method_877(this.field_1733).player.inventory.currentItem)));
         }
      }

   }

   public f75(f76 var1, Ref.IntRef var2) {
      this.field_1733 = var1;
      this.field_1734 = var2;
      super();
   }

   public void accept(Object var1) {
      this.method_2972((EntityPlayerSP)var1);
   }
}
