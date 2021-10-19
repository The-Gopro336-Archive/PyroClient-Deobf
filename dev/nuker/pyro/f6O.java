/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f6O extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_622 = (DoubleSetting)this.register((f0w)(new DoubleSetting("range", "Range", (String)null, 6.0D, 1.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_623 = (List)(new ArrayList());

   // $FF: renamed from: c (dev.nuker.pyro.f6O) net.minecraft.client.Minecraft
   public static Minecraft method_931(f6O var0) {
      return var0.c;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f6O, net.minecraft.client.Minecraft) void
   public static void method_932(f6O var0, Minecraft var1) {
      var0.c = var1;
   }

   public f6O() {
      super("holefiller", "HoleFiller", (String)null);
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      this.field_623.forEach((Consumer)f6N.field_1692);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_623.clear();
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_933() {
      return this.field_622;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_934(@NotNull List var1) {
      this.field_623 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) boolean
   public boolean method_935(@NotNull BlockPos var1) {
      Block var2 = feg.method_1779(var1);
      if (!Intrinsics.areEqual((Object)var2, (Object)Blocks.AIR)) {
         return false;
      } else {
         BlockPos[] var5 = new BlockPos[]{var1.north(), var1.south(), var1.east(), var1.west(), var1.down()};
         int var6 = var5.length;

         for(int var4 = 0; var4 < var6; ++var4) {
            BlockPos var3 = var5[var4];
            Block var7 = feg.method_1779(var3);
            if (var7 instanceof BlockLiquid || Intrinsics.areEqual((Object)var7, (Object)Blocks.AIR)) {
               return false;
            }
         }

         return Intrinsics.areEqual((Object)feg.method_1779(var1.up()), (Object)Blocks.AIR) && Intrinsics.areEqual((Object)feg.method_1779(var1.up().up()), (Object)Blocks.AIR);
      }
   }

   // $FF: renamed from: 0 () java.util.List
   @NotNull
   public List method_936() {
      return this.field_623;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_937(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120 && !var1.c()) {
         this.field_623.clear();
         int var2 = -1;
         int var3 = 0;

         for(byte var4 = 8; var3 <= var4; ++var3) {
            if (this.c.player.inventory.getStackInSlot(var3).getItem() instanceof ItemBlock) {
               Item var10000 = this.c.player.inventory.getStackInSlot(var3).getItem();
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
               }

               ItemBlock var5 = (ItemBlock)var10000;
               if (Intrinsics.areEqual((Object)var5.getBlock(), (Object)Blocks.OBSIDIAN)) {
                  var2 = var3;
                  break;
               }
            }
         }

         if (var2 == -1) {
            this.5("No block");
            return;
         }

         var3 = this.c.player.inventory.currentItem;
         int var26 = (int)(this.c.player.posX - (double)10);
         int var27 = (int)(this.c.player.posX + (double)10);
         int var6 = (int)(this.c.player.posY - (double)10);
         int var7 = (int)(this.c.player.posY + (double)10);
         int var8 = (int)(this.c.player.posZ - (double)10);
         int var9 = (int)(this.c.player.posZ + (double)10);
         Vec3d var10 = new Vec3d(this.c.player.posX, this.c.player.getEntityBoundingBox().minY + (double)this.c.player.getEyeHeight(), this.c.player.posZ);
         int var11 = var26;

         int var14;
         int var16;
         BlockPos var17;
         for(int var12 = var27; var11 < var12; ++var11) {
            int var13 = var6;

            for(var14 = var7; var13 < var14; ++var13) {
               int var15 = var8;

               for(var16 = var9; var15 < var16; ++var15) {
                  var17 = new BlockPos(var11, var13, var15);
                  double var18 = this.c.player.posX - ((double)var17.getX() + 0.5D);
                  double var20 = this.c.player.posY - ((double)var17.getY() + 0.5D) + 1.5D;
                  double var22 = this.c.player.posZ - ((double)var17.getZ() + 0.5D);
                  double var24 = var18 * var18 + var20 * var20 + var22 * var22;
                  if (!(var24 > 36.0D) && !(var24 > ((Number)this.field_622.c()).doubleValue() * ((Number)this.field_622.c()).doubleValue()) && this.method_935(var17) && !this.field_623.contains(var17) && feg.method_1790(var17) && this.c.world.checkNoEntityCollision(new AxisAlignedBB(var17))) {
                     this.field_623.add(var17);
                  }
               }
            }
         }

         if (this.field_623.isEmpty()) {
            Pyro.INSTANCE.sendMessage("Done filling");
            this.c.method_3033(false);
            return;
         }

         this.5("Filling");
         Iterator var29 = this.field_623.iterator();

         while(var29.hasNext()) {
            BlockPos var28 = (BlockPos)var29.next();
            EnumFacing[] var31 = EnumFacing.values();
            var16 = var31.length;

            for(var14 = 0; var14 < var16; ++var14) {
               EnumFacing var30 = var31[var14];
               var17 = var28.offset(var30);
               EnumFacing var33 = var30.getOpposite();
               if (this.c.world.getBlockState(var17).getBlock().canCollideCheck(this.c.world.getBlockState(var17), false)) {
                  Vec3d var32 = new Vec3d;
                  if (var17 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.math.Vec3i");
                  }

                  var32.<init>((Vec3i)var17);
                  Vec3d var19 = var32.addVector(0.5D, 0.5D, 0.5D).add((new Vec3d(var33.getDirectionVec())).scale(0.5D));
                  if (var10.distanceTo(var19) <= 6.0D) {
                     Block var34 = this.c.world.getBlockState(var17).getBlock();
                     boolean var21 = var34.onBlockActivated((World)this.c.world, var28, this.c.world.getBlockState(var28), (EntityPlayer)this.c.player, EnumHand.MAIN_HAND, var30, 0.0F, 0.0F, 0.0F);
                     float[] var35 = few.method_1716().method_1736(var17, var30.getOpposite());
                     var1.0();
                     var1.method_3139(var35[0]);
                     var1.method_3140(var35[1]);
                     var1.method_3133((Consumer)(new f6M(this, var21, var34, var2, var17, var33, var19, var3)));
                     break;
                  }
               }
            }

            if (var1.c()) {
               return;
            }
         }
      }

   }
}
