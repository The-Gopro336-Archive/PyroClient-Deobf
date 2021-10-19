/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.function.Consumer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

// $FF: renamed from: dev.nuker.pyro.fx
public class class_2 extends fdZ {
   // $FF: renamed from: c dev.nuker.pyro.Module
   public Module field_977 = null;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   public BlockPos field_978;
   // $FF: renamed from: c boolean
   public boolean field_979;
   // $FF: renamed from: c java.util.function.Consumer
   public Consumer field_980;
   // $FF: renamed from: 0 boolean
   public boolean field_981;
   // $FF: renamed from: c dev.nuker.pyro.fx
   public static class_2 field_982 = new class_2();

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1422(f4t var1) {
      if (this.field_977 != null && this.field_978 != BlockPos.ORIGIN) {
         Block var2 = feg.method_1779(this.field_978);
         if (var2 instanceof BlockLiquid || var2 instanceof BlockAir || !c.playerController.isInCreativeMode() && (var2.equals(Blocks.BEDROCK) || var2.equals(Blocks.BARRIER))) {
            this.method_1423(true);
         } else {
            double var3 = c.player.posX - ((double)this.field_978.getX() + 0.5D);
            double var5 = c.player.posY - ((double)this.field_978.getY() + 0.5D) + 1.5D;
            double var7 = c.player.posZ - ((double)this.field_978.getZ() + 0.5D);
            double var9 = var3 * var3 + var5 * var5 + var7 * var7;
            if (var9 > 36.0D) {
               this.method_1423(false);
            } else {
               c.player.swingArm(EnumHand.MAIN_HAND);
               EnumFacing var11 = EnumFacing.UP;
               if (this.field_981) {
                  var11 = few.method_1732(this.field_978, true);
               }

               if (!this.field_979) {
                  this.field_979 = true;
                  c.player.connection.sendPacket(new CPacketPlayerDigging(Action.START_DESTROY_BLOCK, this.field_978, var11));
               } else {
                  c.playerController.onPlayerDamageBlock(this.field_978, var11);
               }
            }
         }
      }
   }

   // $FF: renamed from: c (boolean) void
   public void method_1423(boolean var1) {
      if (this.field_980 != null) {
         this.field_980.accept(var1);
         this.field_980 = null;
      }

      this.field_977 = null;
      this.field_978 = BlockPos.ORIGIN;
      this.field_979 = false;
   }

   // $FF: renamed from: c () dev.nuker.pyro.Module
   public Module method_1424() {
      return this.field_977;
   }

   public class_2() {
      this.field_978 = BlockPos.ORIGIN;
      this.field_979 = false;
      this.field_980 = null;
      Pyro.getEventManager().method_31(this);
   }

   // $FF: renamed from: c (dev.nuker.pyro.Module, net.minecraft.util.math.BlockPos, boolean, java.util.function.Consumer) void
   public void method_1425(Module var1, BlockPos var2, boolean var3, Consumer var4) {
      this.field_977 = var1;
      this.field_978 = var2;
      this.field_979 = false;
      this.field_981 = var3;
      this.field_980 = var4;
   }
}
