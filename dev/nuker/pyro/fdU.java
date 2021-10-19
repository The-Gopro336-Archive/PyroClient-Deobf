/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockDaylightDetector;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockNote;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Tuple;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdU {
   // $FF: renamed from: c net.minecraft.client.Minecraft
   public Minecraft field_1246;
   // $FF: renamed from: c dev.nuker.pyro.fdU
   @NotNull
   public static fdU field_1247 = new fdU(Minecraft.getMinecraft());
   // $FF: renamed from: c dev.nuker.pyro.fdR
   public static fdR field_1248 = new fdR((DefaultConstructorMarker)null);

   // $FF: renamed from: c () net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_1926() {
      return new Vec3d(this.field_1246.player.posX, this.field_1246.player.posY + (double)this.field_1246.player.getEyeHeight(), this.field_1246.player.posZ);
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.fdU
   public static fdU method_1927() {
      return field_1247;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.util.math.Vec3d) net.minecraft.util.math.Vec2f
   @NotNull
   public Vec2f method_1928(@NotNull Vec3d var1, @NotNull Vec3d var2) {
      double var3 = var2.x - var1.x;
      double var5 = var2.y - var1.y;
      double var7 = var2.z - var1.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F;
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      return new Vec2f(this.field_1246.player.rotationYaw + MathHelper.wrapDegrees(var11 - this.field_1246.player.rotationYaw), this.field_1246.player.rotationPitch + MathHelper.wrapDegrees(var12 - this.field_1246.player.rotationPitch));
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d) net.minecraft.util.math.Vec2f
   @NotNull
   public Vec2f method_1929(@NotNull Vec3d var1) {
      Vec3d var2 = this.method_1926();
      double var3 = var1.x - var2.x;
      double var5 = var1.y - var2.y;
      double var7 = var1.z - var2.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F;
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      return new Vec2f(this.field_1246.player.rotationYaw + MathHelper.wrapDegrees(var11 - this.field_1246.player.rotationYaw), this.field_1246.player.rotationPitch + MathHelper.wrapDegrees(var12 - this.field_1246.player.rotationPitch));
   }

   public fdU(@NotNull Minecraft var1) {
      this.field_1246 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) net.minecraft.block.state.IBlockState
   @NotNull
   public IBlockState method_1930(@Nullable BlockPos var1) {
      return this.field_1246.world.getBlockState(var1);
   }

   // $FF: renamed from: 1 (net.minecraft.util.math.BlockPos) net.minecraft.util.EnumFacing
   @Nullable
   public EnumFacing method_1931(@Nullable BlockPos var1) {
      EnumFacing[] var4 = EnumFacing.VALUES;
      int var5 = var4.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         EnumFacing var2 = var4[var3];
         if (this.field_1246.world.rayTraceBlocks(new Vec3d(this.field_1246.player.posX, this.field_1246.player.posY + (double)this.field_1246.player.getEyeHeight(), this.field_1246.player.posZ), this.method_1938(var1, (World)this.field_1246.world, var2), false, true, false) == null) {
            return var2;
         }
      }

      return null;
   }

   // $FF: renamed from: 3 (net.minecraft.util.math.BlockPos) net.minecraft.util.Tuple
   @Nullable
   public Tuple method_1932(@NotNull BlockPos var1) {
      EnumFacing[] var4 = EnumFacing.values();
      int var5 = var4.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         EnumFacing var2 = var4[var3];
         BlockPos var6 = var1.offset(var2);
         EnumFacing var7 = var2.getOpposite();
         if (this.method_1947(var6)) {
            return new Tuple(var6, var7);
         }
      }

      return null;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.Vec3d, boolean) void
   public void method_1933(@NotNull Vec3d var1, boolean var2) {
      this.method_1941(this.method_1929(var1), var2);
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) net.minecraft.block.Block
   @NotNull
   public Block method_1934(@Nullable BlockPos var1) {
      return this.method_1930(var1).getBlock();
   }

   // $FF: renamed from: c (net.minecraft.block.Block) boolean
   public boolean method_1935(@Nullable Block var1) {
      return var1 instanceof BlockChest || var1 instanceof BlockEnderChest || var1 instanceof BlockAnvil || var1 instanceof BlockDoor || var1 instanceof BlockTrapDoor || var1 instanceof BlockDispenser || var1 instanceof BlockEnchantmentTable || var1 instanceof BlockHopper || var1 instanceof BlockBrewingStand || var1 instanceof BlockWorkbench || var1 instanceof BlockFurnace || var1 instanceof BlockShulkerBox || var1 instanceof BlockBeacon || var1 instanceof BlockDragonEgg || var1 instanceof BlockCommandBlock || var1 instanceof BlockDaylightDetector || var1 instanceof BlockNote || var1 instanceof BlockJukebox || var1 instanceof BlockLever || var1 instanceof BlockButton || var1 instanceof BlockFenceGate;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.util.EnumFacing, boolean) void
   public void method_1936(@NotNull Vec3d var1, @Nullable EnumFacing var2, boolean var3) {
      this.method_1941(this.method_1945(var1, var2), var3);
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, boolean) void
   public void method_1937(@NotNull Vec3d var1, boolean var2) {
      this.method_1939(this.method_1929(var1), var2);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.world.World, net.minecraft.util.EnumFacing) net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_1938(@Nullable BlockPos var1, @NotNull World var2, @NotNull EnumFacing var3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.Vec2f, boolean) void
   public void method_1939(@NotNull Vec2f var1, boolean var2) {
      this.field_1246.player.connection.sendPacket((Packet)(new net.minecraft.network.play.client.CPacketPlayer.Rotation(var1.x, var1.y, this.field_1246.player.onGround)));
      if (var2) {
         this.field_1246.player.rotationPitch = var1.y;
         this.field_1246.player.rotationYaw = var1.x;
      }

   }

   // $FF: renamed from: 0 (net.minecraft.util.math.Vec3d) net.minecraft.util.math.Vec2f
   @NotNull
   public Vec2f method_1940(@NotNull Vec3d var1) {
      double var2 = var1.x;
      double var4 = var1.y;
      double var6 = var1.z;
      double var8 = Math.sqrt(var2 * var2 + var6 * var6);
      float var10 = (float)Math.toDegrees(Math.atan2(var6, var2)) - 90.0F;
      float var11 = (float)(-Math.toDegrees(Math.atan2(var4, var8)));
      return new Vec2f(MathHelper.wrapDegrees(var10), MathHelper.wrapDegrees(var11));
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec2f, boolean) void
   public void method_1941(@NotNull Vec2f var1, boolean var2) {
      this.field_1246.player.connection.sendPacket((Packet)(new net.minecraft.network.play.client.CPacketPlayer.Rotation(var1.x, var1.y, this.field_1246.player.onGround)));
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdU) void
   public static void method_1942(fdU var0) {
      field_1247 = var0;
   }

   // $FF: renamed from: c (net.minecraft.util.EnumFacing) net.minecraft.util.math.Vec2f
   @NotNull
   public Vec2f method_1943(@NotNull EnumFacing var1) {
      return new Vec2f(var1.getHorizontalAngle(), (float)(var1.getFrontOffsetY() * 90));
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, dev.nuker.pyro.fdS, boolean) boolean
   public boolean method_1944(@NotNull BlockPos var1, @NotNull fdS var2, boolean var3) {
      Tuple var4 = this.method_1932(var1);
      if (var4 != null) {
         Vec3d var5 = this.method_1938((BlockPos)var4.getFirst(), (World)this.field_1246.world, (EnumFacing)var4.getSecond());
         Vec2f var6 = this.method_1948();
         if (var2 != fdS.field_1236) {
            this.method_1933(var5, var2 == fdS.field_1237);
         }

         boolean var7 = false;
         Block var8 = this.field_1246.world.getBlockState((BlockPos)var4.getFirst()).getBlock();
         if (this.method_1935(var8)) {
            var7 = true;
         }

         if (var7) {
            this.field_1246.player.connection.sendPacket((Packet)(new CPacketEntityAction((Entity)this.field_1246.player, Action.START_SNEAKING)));
         }

         if (var3) {
            float var9 = (float)(var5.x - (double)((BlockPos)var4.getFirst()).getX());
            float var10 = (float)(var5.y - (double)((BlockPos)var4.getFirst()).getY());
            float var11 = (float)(var5.z - (double)((BlockPos)var4.getFirst()).getZ());
            this.field_1246.player.connection.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock((BlockPos)var4.getFirst(), (EnumFacing)var4.getSecond(), EnumHand.MAIN_HAND, var9, var10, var11)));
         } else {
            this.field_1246.playerController.processRightClickBlock(this.field_1246.player, this.field_1246.world, (BlockPos)var4.getFirst(), (EnumFacing)var4.getSecond(), var5, EnumHand.MAIN_HAND);
         }

         this.field_1246.player.swingArm(EnumHand.MAIN_HAND);
         if (var7) {
            this.field_1246.player.connection.sendPacket((Packet)(new CPacketEntityAction((Entity)this.field_1246.player, Action.STOP_SNEAKING)));
         }

         if (var2 == fdS.field_1239) {
            this.method_1941(var6, false);
         }

         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.util.EnumFacing) net.minecraft.util.math.Vec2f
   @NotNull
   public Vec2f method_1945(@NotNull Vec3d var1, @Nullable EnumFacing var2) {
      Vec3d var3 = this.method_1926();
      double var4 = var1.x - var3.x;
      double var6 = var1.y - var3.y;
      double var8 = var1.z - var3.z;
      double var10 = Math.sqrt(var4 * var4 + var8 * var8);
      float var12 = (float)Math.toDegrees(Math.atan2(var8, var4)) - 90.0F;
      float var13 = (float)(-Math.toDegrees(Math.atan2(var6, var10)));
      return new Vec2f(this.field_1246.player.rotationYaw + MathHelper.wrapDegrees(var12 - this.field_1246.player.rotationYaw), this.field_1246.player.rotationPitch + MathHelper.wrapDegrees(var13 - this.field_1246.player.rotationPitch));
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.util.EnumFacing, net.minecraft.util.math.Vec3d, net.minecraft.util.EnumHand) void
   public void method_1946(@Nullable BlockPos var1, @Nullable EnumFacing var2, @Nullable Vec3d var3, @Nullable EnumHand var4) {
      this.field_1246.playerController.processRightClickBlock(this.field_1246.player, this.field_1246.world, var1, var2, var3, var4);
      this.field_1246.player.swingArm(var4);
   }

   // $FF: renamed from: 2 (net.minecraft.util.math.BlockPos) boolean
   public boolean method_1947(@Nullable BlockPos var1) {
      return this.method_1934(var1).canCollideCheck(this.method_1930(var1), false);
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.Vec2f
   @NotNull
   public Vec2f method_1948() {
      return new Vec2f(this.field_1246.player.rotationYaw, this.field_1246.player.rotationPitch);
   }
}
