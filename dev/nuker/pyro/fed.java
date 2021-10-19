/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.GameType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class fed extends fdZ {
   // $FF: renamed from: c java.util.List
   public static List field_1217;
   // $FF: renamed from: 0 java.util.List
   public static List field_1218;
   // $FF: renamed from: c double[]
   public static double[] field_1219;
   // $FF: renamed from: 0 double[]
   public static double[] field_1220;
   // $FF: renamed from: 1 double[]
   public static double[] field_1221;

   // $FF: renamed from: c (int, int, int, net.minecraft.util.EnumFacing) float[]
   public static float[] method_1792(int var0, int var1, int var2, EnumFacing var3) {
      return method_1811(var0, var1, var2, var3, 1.0D);
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP, net.minecraft.client.multiplayer.WorldClient, net.minecraft.util.math.BlockPos, net.minecraft.util.EnumFacing, net.minecraft.util.math.Vec3d, net.minecraft.util.EnumHand) net.minecraft.util.EnumActionResult
   public static EnumActionResult method_1793(EntityPlayerSP var0, WorldClient var1, BlockPos var2, EnumFacing var3, Vec3d var4, EnumHand var5) {
      c.playerController.updateController();
      ItemStack var6 = var0.getHeldItem(var5);
      float var7 = (float)(var4.x - (double)var2.getX());
      float var8 = (float)(var4.y - (double)var2.getY());
      float var9 = (float)(var4.z - (double)var2.getZ());
      boolean var10 = false;
      if (!c.world.getWorldBorder().contains(var2)) {
         return EnumActionResult.FAIL;
      } else {
         RightClickBlock var11 = ForgeHooks.onRightClickBlock(var0, var5, var2, var3, ForgeHooks.rayTraceEyeHitVec(var0, (double)(c.playerController.getBlockReachDistance() + 1.0F)));
         if (var11.isCanceled()) {
            c.getConnection().sendPacket(new CPacketPlayerTryUseItemOnBlock(var2, var3, var5, var7, var8, var9));
            return var11.getCancellationResult();
         } else {
            EnumActionResult var12 = EnumActionResult.PASS;
            if (c.playerController.getCurrentGameType() != GameType.SPECTATOR) {
               EnumActionResult var13 = var6.onItemUseFirst(var0, var1, var2, var5, var3, var7, var8, var9);
               if (var13 != EnumActionResult.PASS) {
                  c.getConnection().sendPacket(new CPacketPlayerTryUseItemOnBlock(var2, var3, var5, var7, var8, var9));
                  return var13;
               }

               IBlockState var14 = var1.getBlockState(var2);
               boolean var15 = var0.getHeldItemMainhand().doesSneakBypassUse(var1, var2, var0) && var0.getHeldItemOffhand().doesSneakBypassUse(var1, var2, var0);
               if (!var0.isSneaking() || var15 || var11.getUseBlock() == Result.ALLOW) {
                  if (var11.getUseBlock() != Result.DENY) {
                     var10 = var14.getBlock().onBlockActivated(var1, var2, var14, var0, var5, var3, var7, var8, var9);
                  }

                  if (var10) {
                     var12 = EnumActionResult.SUCCESS;
                  }
               }

               if (!var10 && var6.getItem() instanceof ItemBlock) {
                  ItemBlock var16 = (ItemBlock)var6.getItem();
                  if (!var16.canPlaceBlockOnSide(var1, var2, var3, var0, var6)) {
                     return EnumActionResult.FAIL;
                  }
               }
            }

            c.getConnection().sendPacket(new CPacketPlayerTryUseItemOnBlock(var2, var3, var5, var7, var8, var9));
            if ((var10 || c.playerController.getCurrentGameType() == GameType.SPECTATOR) && var11.getUseItem() != Result.ALLOW) {
               return EnumActionResult.SUCCESS;
            } else if (var6.isEmpty()) {
               return EnumActionResult.PASS;
            } else if (var0.getCooldownTracker().hasCooldown(var6.getItem())) {
               return EnumActionResult.PASS;
            } else {
               if (var6.getItem() instanceof ItemBlock && !var0.canUseCommandBlock()) {
                  Block var17 = ((ItemBlock)var6.getItem()).getBlock();
                  if (var17 instanceof BlockCommandBlock || var17 instanceof BlockStructure) {
                     return EnumActionResult.FAIL;
                  }
               }

               if (c.playerController.getCurrentGameType().isCreative()) {
                  int var19 = var6.getMetadata();
                  int var20 = var6.getCount();
                  if (var11.getUseItem() != Result.DENY) {
                     EnumActionResult var21 = var6.onItemUse(var0, var1, var2, var5, var3, var7, var8, var9);
                     var6.setItemDamage(var19);
                     var6.setCount(var20);
                     return var21;
                  } else {
                     return var12;
                  }
               } else {
                  ItemStack var18 = var6.copy();
                  if (var11.getUseItem() != Result.DENY) {
                     var12 = var6.onItemUse(var0, var1, var2, var5, var3, var7, var8, var9);
                  }

                  if (var6.isEmpty()) {
                     ForgeEventFactory.onPlayerDestroyItem(var0, var18, var5);
                  }

                  return var12;
               }
            }
         }
      }
   }

   // $FF: renamed from: c (double, double, double, double, double, double) float[]
   public static float[] method_1794(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = var0 - var6;
      double var14 = var2 - var8;
      double var16 = var4 - var10;
      double var18;
      if (var16 < 0.0D && var12 < 0.0D) {
         var18 = 90.0D + Math.toDegrees(Math.atan(var16 / var12));
      } else if (var16 < 0.0D && var12 > 0.0D) {
         var18 = -90.0D + Math.toDegrees(Math.atan(var16 / var12));
      } else {
         var18 = Math.toDegrees(-Math.atan(var12 / var16));
      }

      double var20 = Math.sqrt(var12 * var12 + var16 * var16);
      double var22 = -Math.toDegrees(Math.atan(var14 / var20));
      var18 = (double)method_1798((float)var18);
      var22 = (double)method_1798((float)var22);
      var18 = Double.isNaN(var18) ? 0.0D : var18;
      var22 = Double.isNaN(var22) ? 0.0D : var22;
      return new float[]{(float)var18, (float)var22};
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) boolean
   public static boolean method_1795(BlockPos var0) {
      IBlockState var1 = feg.method_1791(var0);
      return var1.getBlock() == Blocks.WATER || var1.getBlock() == Blocks.LAVA || var1.getBlock() == Blocks.AIR;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, float, boolean, boolean) dev.nuker.pyro.fea
   public static fea method_1796(BlockPos var0, float var1, boolean var2, boolean var3) {
      return method_1799(var0, var1, var2, false, false, var3);
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos, double) dev.nuker.pyro.feh
   public static feh method_1797(BlockPos var0, double var1) {
      feh var3 = null;
      Vec3d var4 = new Vec3d(c.player.posX, c.player.getEntityBoundingBox().minY + (double)c.player.getEyeHeight(), c.player.posZ);
      EnumFacing[] var5 = EnumFacing.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         EnumFacing var8 = var5[var7];
         BlockPos var9 = var0.offset(var8);
         if (feg.method_1780(var9)) {
            Vec3d var10 = new Vec3d(var8.getDirectionVec());

            for(double var11 = 0.1D; var11 < 0.9D; var11 += 0.1D) {
               for(double var13 = 0.1D; var13 < 0.9D; var13 += 0.1D) {
                  for(double var15 = 0.1D; var15 < 0.9D; var15 += 0.1D) {
                     Vec3d var17 = (new Vec3d(var0)).addVector(var11, var13, var15);
                     double var18 = var4.squareDistanceTo(var17);
                     Vec3d var20 = var17.add(new Vec3d(var10.x * 0.5D, var10.y * 0.5D, var10.z * 0.5D));
                     if (!(var4.squareDistanceTo(var20) > 18.0D) && !(var18 > var4.squareDistanceTo(var17.add(var10))) && c.world.rayTraceBlocks(var4, var20, false, true, false) == null) {
                        double var21 = var20.x - var4.x;
                        double var23 = var20.y - var4.y;
                        double var25 = var20.z - var4.z;
                        double var27 = (double)MathHelper.sqrt(var21 * var21 + var25 * var25);
                        Rotation var29 = new Rotation(MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(var25, var21)) - 90.0F), MathHelper.wrapDegrees((float)(-Math.toDegrees(Math.atan2(var23, var27)))));
                        Vec3d var30 = few.method_1716().method_1714(var29);
                        Vec3d var31 = var4.addVector(var30.x * 4.0D, var30.y * 4.0D, var30.z * 4.0D);
                        RayTraceResult var32 = c.world.rayTraceBlocks(var4, var31, false, false, true);
                        if (var32.typeOfHit == Type.BLOCK && var32.getBlockPos().equals(var9) && (var3 == null || few.method_1716().method_1739(var29) < few.method_1716().method_1739(var3.method_2042().method_2076()))) {
                           var3 = new feh(var9, var8.getOpposite(), var20, new fex(var17, var29, var8.getOpposite()));
                        }
                     }
                  }
               }
            }
         }
      }

      return var3;
   }

   // $FF: renamed from: c (float) float
   public static float method_1798(float var0) {
      for(var0 %= 360.0F; var0 >= 180.0F; var0 -= 360.0F) {
      }

      while(var0 < -180.0F) {
         var0 += 360.0F;
      }

      return var0;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, float, boolean, boolean, boolean, boolean) dev.nuker.pyro.fea
   public static fea method_1799(BlockPos var0, float var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      IBlockState var6 = feg.method_1791(var0);
      if (!var6.getMaterial().isReplaceable()) {
         return fea.field_1335;
      } else if (!method_1806(var0)) {
         return fea.field_1336;
      } else {
         Vec3d var7 = new Vec3d(c.player.posX, c.player.posY + (double)c.player.getEyeHeight(), c.player.posZ);
         EnumFacing[] var8 = EnumFacing.values();
         int var9 = var8.length;

         for(int var10 = 0; var10 < var9; ++var10) {
            EnumFacing var11 = var8[var10];
            BlockPos var12 = var0.offset(var11);
            EnumFacing var13 = var11.getOpposite();
            if (feg.method_1791(var12).getBlock().canCollideCheck(feg.method_1791(var12), false)) {
               Vec3d var14 = (new Vec3d(var12)).addVector(0.5D, 0.5D, 0.5D).add((new Vec3d(var13.getDirectionVec())).scale(0.5D));
               if (var7.distanceTo(var14) <= (double)var1) {
                  Block var15 = feg.method_1791(var12).getBlock();
                  boolean var16 = var15.onBlockActivated(c.world, var0, feg.method_1791(var0), c.player, EnumHand.MAIN_HAND, var11, 0.0F, 0.0F, 0.0F);
                  if (field_1217.contains(var15) || field_1218.contains(var15) || var16) {
                     c.player.connection.sendPacket(new CPacketEntityAction(c.player, Action.START_SNEAKING));
                  }

                  EnumActionResult var17 = null;
                  if (var5) {
                     float[] var18 = few.method_1716().method_1736(var12, var11.getOpposite());
                     c.player.connection.sendPacket(new net.minecraft.network.play.client.CPacketPlayer.Rotation(var18[0], var18[1], c.player.onGround));
                     Pyro.rotationManager.method_3454(var18[0]);
                     Pyro.rotationManager.method_3457(var18[1]);
                  }

                  if (var4) {
                     var17 = method_1793(c.player, c.world, var12, var13, var14, var3 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
                  } else {
                     var17 = c.playerController.processRightClickBlock(c.player, c.world, var12, var13, var14, var3 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
                  }

                  if (var17 != EnumActionResult.FAIL) {
                     if (var2) {
                        c.player.connection.sendPacket(new CPacketAnimation(EnumHand.MAIN_HAND));
                     } else {
                        c.player.swingArm(EnumHand.MAIN_HAND);
                     }

                     if (var16) {
                        c.player.connection.sendPacket(new CPacketEntityAction(c.player, Action.STOP_SNEAKING));
                     }

                     return fea.field_1338;
                  }
               }
            }
         }

         return fea.field_1337;
      }
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, float, boolean) dev.nuker.pyro.fea
   public static fea method_1800(BlockPos var0, float var1, boolean var2) {
      return method_1799(var0, var1, var2, false, false, false);
   }

   // $FF: renamed from: c (int, int, int) dev.nuker.pyro.feh
   public static feh method_1801(int var0, int var1, int var2) {
      return method_1810(new BlockPos(var0, var1, var2));
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.util.EnumFacing, net.minecraft.item.ItemStack) dev.nuker.pyro.feb
   public static feb method_1802(BlockPos var0, EnumFacing var1, ItemStack var2) {
      return method_1805(var0, false, false, var1, var2);
   }

   // $FF: renamed from: c (double, double, double) float[]
   public static float[] method_1803(double var0, double var2, double var4) {
      return method_1794(var0, var2, var4, c.player.posX, c.player.posY + (double)c.player.getEyeHeight(), c.player.posZ);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, float, boolean, boolean, boolean) dev.nuker.pyro.fea
   public static fea method_1804(BlockPos var0, float var1, boolean var2, boolean var3, boolean var4) {
      return method_1799(var0, var1, var2, var3, var4, false);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, boolean, boolean, net.minecraft.util.EnumFacing, net.minecraft.item.ItemStack) dev.nuker.pyro.feb
   public static feb method_1805(BlockPos var0, boolean var1, boolean var2, EnumFacing var3, ItemStack var4) {
      if (c.world == null) {
         return feb.field_1340;
      } else if (!c.world.checkNoEntityCollision(new AxisAlignedBB(var0)) && !var1) {
         return feb.field_1340;
      } else if (!method_1812(var0)) {
         return feb.field_1342;
      } else if (var4.getItem() instanceof ItemBlock) {
         ItemBlock var5 = (ItemBlock)var4.getItem();
         return !var5.canPlaceBlockOnSide(c.world, var0, var3, c.player, var4) ? feb.field_1341 : feb.field_1343;
      } else {
         return feb.field_1341;
      }
   }

   // $FF: renamed from: 4 (net.minecraft.util.math.BlockPos) boolean
   public static boolean method_1806(BlockPos var0) {
      if (!method_1812(var0)) {
         EnumFacing[] var1 = EnumFacing.values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            EnumFacing var4 = var1[var3];
            BlockPos var5 = var0.offset(var4);
            if (method_1812(var5)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   static {
      field_1217 = Arrays.asList(Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE);
      field_1218 = Arrays.asList(Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX);
      field_1219 = new double[]{0.05D, 0.95D};
      field_1220 = new double[]{0.05D, 0.95D};
      field_1221 = new double[]{0.05D, 0.95D};
   }

   // $FF: renamed from: 1 (net.minecraft.util.math.BlockPos) dev.nuker.pyro.feh
   public static feh method_1807(BlockPos var0) {
      return method_1813(var0, 1.0D);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) dev.nuker.pyro.feh
   public static feh method_1808(BlockPos var0) {
      return method_1810(var0);
   }

   // $FF: renamed from: 2 (net.minecraft.util.math.BlockPos) dev.nuker.pyro.feh
   public static feh method_1809(BlockPos var0) {
      return method_1807(var0);
   }

   // $FF: renamed from: 3 (net.minecraft.util.math.BlockPos) dev.nuker.pyro.feh
   public static feh method_1810(BlockPos var0) {
      return method_1797(var0, 1.0D);
   }

   // $FF: renamed from: c (int, int, int, net.minecraft.util.EnumFacing, double) float[]
   public static float[] method_1811(int var0, int var1, int var2, EnumFacing var3, double var4) {
      return method_1803((double)var0 + 0.5D + (double)var3.getDirectionVec().getX() * var4 / 2.0D, (double)var1 + 0.5D + (double)var3.getDirectionVec().getY() * var4 / 2.0D, (double)var2 + 0.5D + (double)var3.getDirectionVec().getZ() * var4 / 2.0D);
   }

   // $FF: renamed from: 5 (net.minecraft.util.math.BlockPos) boolean
   public static boolean method_1812(BlockPos var0) {
      EnumFacing[] var1 = EnumFacing.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumFacing var4 = var1[var3];
         BlockPos var5 = var0.offset(var4);
         if (!feg.method_1791(var5).getMaterial().isReplaceable()) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, double) dev.nuker.pyro.feh
   public static feh method_1813(BlockPos var0, double var1) {
      Vec3d var3 = new Vec3d(c.player.posX, c.player.getEntityBoundingBox().minY + (double)c.player.getEyeHeight(), c.player.posZ);
      EnumFacing[] var4 = EnumFacing.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         EnumFacing var7 = var4[var6];
         BlockPos var8 = var0.offset(var7);
         if (feg.method_1780(var8)) {
            Vec3d var9 = new Vec3d(var7.getDirectionVec());
            double[] var10 = field_1219;
            int var11 = var10.length;

            for(int var12 = 0; var12 < var11; ++var12) {
               double var13 = var10[var12];
               double[] var15 = field_1220;
               int var16 = var15.length;

               for(int var17 = 0; var17 < var16; ++var17) {
                  double var18 = var15[var17];
                  double[] var20 = field_1221;
                  int var21 = var20.length;

                  for(int var22 = 0; var22 < var21; ++var22) {
                     double var23 = var20[var22];
                     Vec3d var25 = (new Vec3d(var0)).addVector(var13, var18, var23);
                     double var26 = var3.squareDistanceTo(var25);
                     Vec3d var28 = var25.add(new Vec3d(var9.x * 0.5D, var9.y * 0.5D, var9.z * 0.5D));
                     if (!(var3.squareDistanceTo(var28) > 18.0D) && !(var26 > var3.squareDistanceTo(var25.add(var9))) && c.world.rayTraceBlocks(var3, var28, false, true, false) == null) {
                        double var29 = var28.x - var3.x;
                        double var31 = var28.y - var3.y;
                        double var33 = var28.z - var3.z;
                        double var35 = (double)MathHelper.sqrt(var29 * var29 + var33 * var33);
                        Rotation var37 = new Rotation(MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(var33, var29)) - 90.0F), MathHelper.wrapDegrees((float)(-Math.toDegrees(Math.atan2(var31, var35)))));
                        Vec3d var38 = few.method_1716().method_1714(var37);
                        Vec3d var39 = var3.addVector(var38.x * 4.0D, var38.y * 4.0D, var38.z * 4.0D);
                        RayTraceResult var40 = c.world.rayTraceBlocks(var3, var39, false, false, true);
                        if (var40.typeOfHit == Type.BLOCK && var40.getBlockPos().equals(var8)) {
                           return new feh(var8, var7.getOpposite(), var28, new fex(var25, var37, var7.getOpposite()));
                        }
                     }
                  }
               }
            }
         }
      }

      return null;
   }
}
