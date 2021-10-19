/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.MinecraftAccessor;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class fdj implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fdk
   public fdk field_1320;
   // $FF: renamed from: c boolean
   public boolean field_1321;

   public fdj(fdk var1, boolean var2) {
      this.field_1320 = var1;
      this.field_1321 = var2;
      super();
   }

   public void accept(Object var1) {
      this.method_1990((EntityPlayerSP)var1);
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_1990(EntityPlayerSP var1) {
      if (this.field_1320.method_1254() != null && this.field_1320.method_1268().method_1980(((Number)this.field_1320.method_1278().c()).doubleValue()) && this.field_1320.method_1257() != -1) {
         RayTraceResult var2 = few.method_1716().method_1734(this.field_1320.method_1251(), this.field_1320.method_1264());
         Vec3d var3 = var2 != null ? var2.hitVec : new Vec3d(0.5D, 0.5D, 0.5D);
         if ((fdi)this.field_1320.method_1261().c() != fdi.field_1318 && (Boolean)this.field_1320.method_1272().c() && this.field_1320.method_1271()) {
            Minecraft var10000 = fdk.method_1252(this.field_1320);
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.MinecraftAccessor");
            }

            MinecraftAccessor var4 = (MinecraftAccessor)var10000;
            var4.setRightClickDelayTimer(3);
            if (fdk.method_1252(this.field_1320).player.movementInput.jump && !fec.method_1758()) {
               var4.setRightClickDelayTimer(0);
               fdk.method_1252(this.field_1320).player.motionY = this.field_1320.method_1276(this.field_1321);
            }
         }

         boolean var9 = fdk.method_1252(this.field_1320).player.inventory.currentItem != this.field_1320.method_1257();
         if (this.field_1320.method_1257() == -420) {
            var9 = false;
         }

         boolean var5 = fdk.method_1252(this.field_1320).player.isSprinting();
         int var6 = fdk.method_1252(this.field_1320).player.inventory.currentItem;
         feg var10 = feg.field_1216;
         fee var10001 = this.field_1320.method_1254();
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         boolean var7 = !var10.method_1786(var10001.method_2010());
         NetHandlerPlayClient var11;
         if (var9) {
            fdk.method_1252(this.field_1320).player.inventory.currentItem = this.field_1320.method_1257();
            var11 = fdk.method_1252(this.field_1320).getConnection();
            if (var11 == null) {
               Intrinsics.throwNpe();
            }

            var11.sendPacket((Packet)(new CPacketHeldItemChange(this.field_1320.method_1257())));
         }

         if (var5) {
            var11 = fdk.method_1252(this.field_1320).getConnection();
            if (var11 == null) {
               Intrinsics.throwNpe();
            }

            var11.sendPacket((Packet)(new CPacketEntityAction((Entity)fdk.method_1252(this.field_1320).player, Action.STOP_SPRINTING)));
         }

         if (var7) {
            var11 = fdk.method_1252(this.field_1320).getConnection();
            if (var11 == null) {
               Intrinsics.throwNpe();
            }

            var11.sendPacket((Packet)(new CPacketEntityAction((Entity)fdk.method_1252(this.field_1320).player, Action.START_SNEAKING)));
         }

         EnumHand var8 = this.field_1320.method_1257() == -420 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
         PlayerControllerMP var13 = fdk.method_1252(this.field_1320).playerController;
         EntityPlayerSP var12 = fdk.method_1252(this.field_1320).player;
         WorldClient var10002 = fdk.method_1252(this.field_1320).world;
         fee var10003 = this.field_1320.method_1254();
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         BlockPos var14 = var10003.method_2010();
         fee var10004 = this.field_1320.method_1254();
         if (var10004 == null) {
            Intrinsics.throwNpe();
         }

         var13.processRightClickBlock(var12, var10002, var14, var10004.method_2009(), var3, var8);
         var11 = fdk.method_1252(this.field_1320).getConnection();
         if (var11 == null) {
            Intrinsics.throwNpe();
         }

         var11.sendPacket((Packet)(new CPacketAnimation(var8)));
         if (var7) {
            var11 = fdk.method_1252(this.field_1320).getConnection();
            if (var11 == null) {
               Intrinsics.throwNpe();
            }

            var11.sendPacket((Packet)(new CPacketEntityAction((Entity)fdk.method_1252(this.field_1320).player, Action.STOP_SNEAKING)));
         }

         if (var5) {
            var11 = fdk.method_1252(this.field_1320).getConnection();
            if (var11 == null) {
               Intrinsics.throwNpe();
            }

            var11.sendPacket((Packet)(new CPacketEntityAction((Entity)fdk.method_1252(this.field_1320).player, Action.START_SPRINTING)));
         }

         if (var9) {
            fdk.method_1252(this.field_1320).player.inventory.currentItem = var6;
            var11 = fdk.method_1252(this.field_1320).getConnection();
            if (var11 == null) {
               Intrinsics.throwNpe();
            }

            var11.sendPacket((Packet)(new CPacketHeldItemChange(var6)));
         }
      }

   }
}
