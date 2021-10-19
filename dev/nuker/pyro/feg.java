/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockNote;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class feg extends fdZ {
   // $FF: renamed from: c java.util.List
   @NotNull
   public static List field_1215;
   // $FF: renamed from: c dev.nuker.pyro.feg
   public static feg field_1216;

   // $FF: renamed from: c (int) java.lang.String
   @NotNull
   public String method_1777(int var1) {
      return Block.getBlockById(var1).getLocalizedName();
   }

   // $FF: renamed from: 3 (net.minecraft.util.math.BlockPos) boolean
   @JvmStatic
   public static boolean method_1778(@NotNull BlockPos var0) {
      double var1 = fdZ.field_976.player.posX - ((double)var0.getX() + 0.5D);
      double var3 = fdZ.field_976.player.posY - ((double)var0.getY() + 0.5D) + 1.5D;
      double var5 = fdZ.field_976.player.posZ - ((double)var0.getZ() + 0.5D);
      double var7 = var1 * var1 + var3 * var3 + var5 * var5;
      return var7 <= 36.0D;
   }

   // $FF: renamed from: 5 (net.minecraft.util.math.BlockPos) net.minecraft.block.Block
   @JvmStatic
   @NotNull
   public static Block method_1779(@Nullable BlockPos var0) {
      return fdZ.field_976.world.getBlockState(var0).getBlock();
   }

   // $FF: renamed from: 6 (net.minecraft.util.math.BlockPos) boolean
   @JvmStatic
   public static boolean method_1780(@Nullable BlockPos var0) {
      return method_1779(var0).canCollideCheck(method_1791(var0), false);
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) boolean
   public boolean method_1781(@Nullable BlockPos var1) {
      AxisAlignedBB var2 = method_1791(var1).getCollisionBoundingBox((IBlockAccess)fdZ.field_976.world, var1);
      return var2 != null && var2.maxX - var2.minX == 1.0D && var2.maxY - var2.minY == 1.0D && var2.maxZ - var2.minZ == 1.0D;
   }

   // $FF: renamed from: c () java.util.List
   @NotNull
   public List method_1782() {
      return field_1215;
   }

   // $FF: renamed from: 4 (net.minecraft.util.math.BlockPos) net.minecraft.block.material.Material
   @NotNull
   public Material method_1783(@Nullable BlockPos var1) {
      return method_1791(var1).getMaterial();
   }

   // $FF: renamed from: 0 (int) java.util.Map
   @NotNull
   public Map method_1784(int var1) {
      Map var2 = (Map)(new HashMap());
      int var3 = var1;
      int var4 = -var1 + 1;
      if (var1 >= var4) {
         while(true) {
            int var5 = var1;
            int var6 = -var1 + 1;
            if (var1 >= var6) {
               while(true) {
                  int var7 = var1;
                  int var8 = -var1 + 1;
                  if (var1 >= var8) {
                     while(true) {
                        BlockPos var9 = new BlockPos((int)fdZ.field_976.player.posX + var3, (int)fdZ.field_976.player.posY + var5, (int)fdZ.field_976.player.posZ + var7);
                        Block var10 = method_1779(var9);
                        var2.put(var9, var10);
                        if (var7 == var8) {
                           break;
                        }

                        --var7;
                     }
                  }

                  if (var5 == var6) {
                     break;
                  }

                  --var5;
               }
            }

            if (var3 == var4) {
               break;
            }

            --var3;
         }
      }

      return var2;
   }

   static {
      feg var0 = new feg();
      field_1216 = var0;
      field_1215 = CollectionsKt.listOf(new Block[]{Blocks.AIR, (Block)Blocks.LAVA, (Block)Blocks.WATER, (Block)Blocks.FLOWING_LAVA, (Block)Blocks.FLOWING_WATER});
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.AxisAlignedBB, dev.nuker.pyro.fef) boolean
   @JvmStatic
   public static boolean method_1785(@NotNull AxisAlignedBB var0, @NotNull fef var1) {
      int var2 = MathHelper.floor(fdZ.field_976.player.getEntityBoundingBox().minX);

      for(int var3 = MathHelper.floor(fdZ.field_976.player.getEntityBoundingBox().maxX) + 1; var2 < var3; ++var2) {
         int var4 = MathHelper.floor(fdZ.field_976.player.getEntityBoundingBox().minZ);

         for(int var5 = MathHelper.floor(fdZ.field_976.player.getEntityBoundingBox().maxZ) + 1; var4 < var5; ++var4) {
            Block var6 = method_1779(new BlockPos((double)var2, var0.minY, (double)var4));
            if (var6 != null && !var1.method_0(var6)) {
               return false;
            }
         }
      }

      return true;
   }

   // $FF: renamed from: 2 (net.minecraft.util.math.BlockPos) boolean
   public boolean method_1786(@NotNull BlockPos var1) {
      Block var2 = method_1779(var1);
      boolean var3 = false;
      Iterator var5 = fdZ.field_976.world.loadedTileEntityList.iterator();

      while(var5.hasNext()) {
         TileEntity var4 = (TileEntity)var5.next();
         if (Intrinsics.areEqual((Object)var4.getPos(), (Object)var1)) {
            var3 = true;
            break;
         }
      }

      return !var3 && !(var2 instanceof BlockBed) && !(var2 instanceof BlockNote) && !(var2 instanceof BlockDoor) && !(var2 instanceof BlockTrapDoor) && !(var2 instanceof BlockFenceGate) && !(var2 instanceof BlockButton) && !(var2 instanceof BlockAnvil) && !(var2 instanceof BlockWorkbench) && !(var2 instanceof BlockCake) && !(var2 instanceof BlockRedstoneDiode);
   }

   // $FF: renamed from: 8 (net.minecraft.util.math.BlockPos) dev.nuker.pyro.fee
   @Nullable
   public fee method_1787(@NotNull BlockPos var1) {
      WorldClient var3 = fdZ.field_976.world;
      byte var5 = -1;
      byte var6 = 0;
      if (!field_1215.contains(var3.getBlockState(var1.add(var6, var5, var6)).getBlock())) {
         byte var10 = -1;
         byte var11 = 0;
         return new fee(var1.add(var11, var10, var11), EnumFacing.UP);
      } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var1.add(-1, 0, 0)).getBlock())) {
         return new fee(var1.add(-1, 0, 0), EnumFacing.EAST);
      } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var1.add(1, 0, 0)).getBlock())) {
         return new fee(var1.add(1, 0, 0), EnumFacing.WEST);
      } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var1.add(0, 0, -1)).getBlock())) {
         return new fee(var1.add(0, 0, -1), EnumFacing.SOUTH);
      } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var1.add(0, 0, 1)).getBlock())) {
         return new fee(var1.add(0, 0, 1), EnumFacing.NORTH);
      } else {
         BlockPos var7 = var1.add(-1, 0, 0);
         if (!field_1215.contains(fdZ.field_976.world.getBlockState(var7.add(-1, 0, 0)).getBlock())) {
            return new fee(var7.add(-1, 0, 0), EnumFacing.EAST);
         } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var7.add(1, 0, 0)).getBlock())) {
            return new fee(var7.add(1, 0, 0), EnumFacing.WEST);
         } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var7.add(0, 0, -1)).getBlock())) {
            return new fee(var7.add(0, 0, -1), EnumFacing.SOUTH);
         } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var7.add(0, 0, 1)).getBlock())) {
            return new fee(var7.add(0, 0, 1), EnumFacing.NORTH);
         } else {
            BlockPos var8 = var1.add(1, 0, 0);
            if (!field_1215.contains(fdZ.field_976.world.getBlockState(var8.add(-1, 0, 0)).getBlock())) {
               return new fee(var8.add(-1, 0, 0), EnumFacing.EAST);
            } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var8.add(1, 0, 0)).getBlock())) {
               return new fee(var8.add(1, 0, 0), EnumFacing.WEST);
            } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var8.add(0, 0, -1)).getBlock())) {
               return new fee(var8.add(0, 0, -1), EnumFacing.SOUTH);
            } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var8.add(0, 0, 1)).getBlock())) {
               return new fee(var8.add(0, 0, 1), EnumFacing.NORTH);
            } else {
               BlockPos var9 = var1.add(0, 0, -1);
               if (!field_1215.contains(fdZ.field_976.world.getBlockState(var9.add(-1, 0, 0)).getBlock())) {
                  return new fee(var9.add(-1, 0, 0), EnumFacing.EAST);
               } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var9.add(1, 0, 0)).getBlock())) {
                  return new fee(var9.add(1, 0, 0), EnumFacing.WEST);
               } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var9.add(0, 0, -1)).getBlock())) {
                  return new fee(var9.add(0, 0, -1), EnumFacing.SOUTH);
               } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var9.add(0, 0, 1)).getBlock())) {
                  return new fee(var9.add(0, 0, 1), EnumFacing.NORTH);
               } else {
                  BlockPos var2 = var1.add(0, 0, 1);
                  if (!field_1215.contains(fdZ.field_976.world.getBlockState(var2.add(-1, 0, 0)).getBlock())) {
                     return new fee(var2.add(-1, 0, 0), EnumFacing.EAST);
                  } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var2.add(1, 0, 0)).getBlock())) {
                     return new fee(var2.add(1, 0, 0), EnumFacing.WEST);
                  } else if (!field_1215.contains(fdZ.field_976.world.getBlockState(var2.add(0, 0, -1)).getBlock())) {
                     return new fee(var2.add(0, 0, -1), EnumFacing.SOUTH);
                  } else {
                     return !field_1215.contains(fdZ.field_976.world.getBlockState(var2.add(0, 0, 1)).getBlock()) ? new fee(var2.add(0, 0, 1), EnumFacing.NORTH) : null;
                  }
               }
            }
         }
      }
   }

   // $FF: renamed from: 7 (net.minecraft.util.math.BlockPos) double
   public double method_1788(@NotNull BlockPos var1) {
      return fdZ.field_976.player.getDistance((double)var1.getX() + 0.5D, (double)var1.getY() + 0.5D, (double)var1.getZ() + 0.5D);
   }

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB, dev.nuker.pyro.fef) boolean
   public boolean method_1789(@NotNull AxisAlignedBB var1, @NotNull fef var2) {
      int var3 = MathHelper.floor(fdZ.field_976.player.getEntityBoundingBox().minX);

      for(int var4 = MathHelper.floor(fdZ.field_976.player.getEntityBoundingBox().maxX) + 1; var3 < var4; ++var3) {
         int var5 = MathHelper.floor(fdZ.field_976.player.getEntityBoundingBox().minZ);

         for(int var6 = MathHelper.floor(fdZ.field_976.player.getEntityBoundingBox().maxZ) + 1; var5 < var6; ++var5) {
            BlockPos var7 = new BlockPos((double)var3, var1.minY, (double)var5);
            Block var8 = method_1779(var7);
            if (var8 != null && var2.method_0(var8)) {
               AxisAlignedBB var9 = method_1791(var7).getCollisionBoundingBox((IBlockAccess)fdZ.field_976.world, var7);
               if (var9 != null && fdZ.field_976.player.getEntityBoundingBox().intersects(var9)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   // $FF: renamed from: 1 (net.minecraft.util.math.BlockPos) boolean
   @JvmStatic
   public static boolean method_1790(@Nullable BlockPos var0) {
      return field_1216.method_1783(var0).isReplaceable();
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) net.minecraft.block.state.IBlockState
   @JvmStatic
   @NotNull
   public static IBlockState method_1791(@Nullable BlockPos var0) {
      return fdZ.field_976.world.getBlockState(var0);
   }
}
