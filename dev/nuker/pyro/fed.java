/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockCommandBlock
 *  net.minecraft.block.BlockStructure
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.GameType
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.ForgeHooks
 *  net.minecraftforge.event.ForgeEventFactory
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$RightClickBlock
 *  net.minecraftforge.fml.common.eventhandler.Event$Result
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.Rotation;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.fea;
import dev.nuker.pyro.feb;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.feh;
import dev.nuker.pyro.few;
import dev.nuker.pyro.fex;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.GameType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class fed
extends fdZ {
    public static List<Block> Field441 = Arrays.asList(new Block[]{Blocks.ENDER_CHEST, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.CRAFTING_TABLE, Blocks.ANVIL, Blocks.BREWING_STAND, Blocks.HOPPER, Blocks.DROPPER, Blocks.DISPENSER, Blocks.TRAPDOOR, Blocks.ENCHANTING_TABLE});
    public static List<Block> Field442 = Arrays.asList(new Block[]{Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX});
    public static double[] Field443 = new double[]{0.05, 0.95};
    public static double[] Field444 = new double[]{0.05, 0.95};
    public static double[] Field445 = new double[]{0.05, 0.95};

    public static float[] Method654(int n, int n2, int n3, EnumFacing enumFacing) {
        return fed.Method672(n, n2, n3, enumFacing, 1.0);
    }

    public static EnumActionResult Method655(EntityPlayerSP entityPlayerSP, WorldClient worldClient, BlockPos blockPos, EnumFacing enumFacing, Vec3d vec3d, EnumHand enumHand) {
        block20: {
            EnumActionResult enumActionResult;
            EnumActionResult enumActionResult2;
            PlayerInteractEvent.RightClickBlock rightClickBlock;
            float f;
            float f2;
            float f3;
            ItemStack itemStack;
            block19: {
                block18: {
                    fed.Field313.playerController.updateController();
                    itemStack = entityPlayerSP.getHeldItem(enumHand);
                    f3 = (float)(vec3d.x - (double)blockPos.getX());
                    f2 = (float)(vec3d.y - (double)blockPos.getY());
                    f = (float)(vec3d.z - (double)blockPos.getZ());
                    boolean bl = false;
                    if (!fed.Field313.world.getWorldBorder().contains(blockPos)) {
                        return EnumActionResult.FAIL;
                    }
                    rightClickBlock = ForgeHooks.onRightClickBlock((EntityPlayer)entityPlayerSP, (EnumHand)enumHand, (BlockPos)blockPos, (EnumFacing)enumFacing, (Vec3d)ForgeHooks.rayTraceEyeHitVec((EntityLivingBase)entityPlayerSP, (double)(fed.Field313.playerController.getBlockReachDistance() + 1.0f)));
                    if (rightClickBlock.isCanceled()) {
                        Field313.getConnection().sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f3, f2, f));
                        return rightClickBlock.getCancellationResult();
                    }
                    enumActionResult2 = EnumActionResult.PASS;
                    if (fed.Field313.playerController.getCurrentGameType() != GameType.SPECTATOR) {
                        ItemBlock itemBlock;
                        boolean bl2;
                        enumActionResult = itemStack.onItemUseFirst((EntityPlayer)entityPlayerSP, (World)worldClient, blockPos, enumHand, enumFacing, f3, f2, f);
                        if (enumActionResult != EnumActionResult.PASS) {
                            Field313.getConnection().sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f3, f2, f));
                            return enumActionResult;
                        }
                        IBlockState iBlockState = worldClient.getBlockState(blockPos);
                        boolean bl3 = bl2 = entityPlayerSP.getHeldItemMainhand().doesSneakBypassUse((IBlockAccess)worldClient, blockPos, (EntityPlayer)entityPlayerSP) && entityPlayerSP.getHeldItemOffhand().doesSneakBypassUse((IBlockAccess)worldClient, blockPos, (EntityPlayer)entityPlayerSP);
                        if (!entityPlayerSP.isSneaking() || bl2 || rightClickBlock.getUseBlock() == Event.Result.ALLOW) {
                            if (rightClickBlock.getUseBlock() != Event.Result.DENY) {
                                bl = iBlockState.getBlock().onBlockActivated((World)worldClient, blockPos, iBlockState, (EntityPlayer)entityPlayerSP, enumHand, enumFacing, f3, f2, f);
                            }
                            if (bl) {
                                enumActionResult2 = EnumActionResult.SUCCESS;
                            }
                        }
                        if (!bl && itemStack.getItem() instanceof ItemBlock && !(itemBlock = (ItemBlock)itemStack.getItem()).canPlaceBlockOnSide((World)worldClient, blockPos, enumFacing, (EntityPlayer)entityPlayerSP, itemStack)) {
                            return EnumActionResult.FAIL;
                        }
                    }
                    Field313.getConnection().sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, enumFacing, enumHand, f3, f2, f));
                    if (bl) break block18;
                    if (fed.Field313.playerController.getCurrentGameType() != GameType.SPECTATOR) break block19;
                }
                if (rightClickBlock.getUseItem() != Event.Result.ALLOW) break block20;
            }
            if (itemStack.isEmpty()) {
                return EnumActionResult.PASS;
            }
            if (entityPlayerSP.getCooldownTracker().hasCooldown(itemStack.getItem())) {
                return EnumActionResult.PASS;
            }
            if (itemStack.getItem() instanceof ItemBlock && !entityPlayerSP.canUseCommandBlock() && ((enumActionResult = ((ItemBlock)itemStack.getItem()).getBlock()) instanceof BlockCommandBlock || enumActionResult instanceof BlockStructure)) {
                return EnumActionResult.FAIL;
            }
            if (fed.Field313.playerController.getCurrentGameType().isCreative()) {
                int n = itemStack.getMetadata();
                int n2 = itemStack.getCount();
                if (rightClickBlock.getUseItem() != Event.Result.DENY) {
                    EnumActionResult enumActionResult3 = itemStack.onItemUse((EntityPlayer)entityPlayerSP, (World)worldClient, blockPos, enumHand, enumFacing, f3, f2, f);
                    itemStack.setItemDamage(n);
                    itemStack.setCount(n2);
                    return enumActionResult3;
                }
                return enumActionResult2;
            }
            enumActionResult = itemStack.copy();
            if (rightClickBlock.getUseItem() != Event.Result.DENY) {
                enumActionResult2 = itemStack.onItemUse((EntityPlayer)entityPlayerSP, (World)worldClient, blockPos, enumHand, enumFacing, f3, f2, f);
            }
            if (itemStack.isEmpty()) {
                ForgeEventFactory.onPlayerDestroyItem((EntityPlayer)entityPlayerSP, (ItemStack)enumActionResult, (EnumHand)enumHand);
            }
            return enumActionResult2;
        }
        return EnumActionResult.SUCCESS;
    }

    public static float[] Method656(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d - d4;
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        double d10 = d9 < 0.0 && d7 < 0.0 ? 90.0 + Math.toDegrees(Math.atan(d9 / d7)) : (d9 < 0.0 && d7 > 0.0 ? -90.0 + Math.toDegrees(Math.atan(d9 / d7)) : Math.toDegrees(-Math.atan(d7 / d9)));
        double d11 = Math.sqrt(d7 * d7 + d9 * d9);
        double d12 = -Math.toDegrees(Math.atan(d8 / d11));
        d10 = fed.Method336((float)d10);
        d12 = fed.Method336((float)d12);
        d10 = Double.isNaN(d10) ? 0.0 : d10;
        d12 = Double.isNaN(d12) ? 0.0 : d12;
        return new float[]{(float)d10, (float)d12};
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean Method657(BlockPos blockPos) {
        IBlockState iBlockState = feg.Method701(blockPos);
        if (iBlockState.getBlock() == Blocks.WATER) return true;
        if (iBlockState.getBlock() == Blocks.LAVA) return true;
        if (iBlockState.getBlock() != Blocks.AIR) return false;
        return true;
    }

    public static fea Method658(BlockPos blockPos, float f, boolean bl, boolean bl2) {
        return fed.Method660(blockPos, f, bl, false, false, bl2);
    }

    public static feh Method659(BlockPos blockPos, double d) {
        feh feh2 = null;
        Vec3d vec3d = new Vec3d(fed.Field313.player.posX, fed.Field313.player.getEntityBoundingBox().minY + (double)fed.Field313.player.getEyeHeight(), fed.Field313.player.posZ);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!feg.Method691(blockPos2)) continue;
            Vec3d vec3d2 = new Vec3d(enumFacing.getDirectionVec());
            for (double d2 = 0.1; d2 < 0.9; d2 += 0.1) {
                for (double d3 = 0.1; d3 < 0.9; d3 += 0.1) {
                    for (double d4 = 0.1; d4 < 0.9; d4 += 0.1) {
                        Vec3d vec3d3 = new Vec3d((Vec3i)blockPos).addVector(d2, d3, d4);
                        double d5 = vec3d.squareDistanceTo(vec3d3);
                        Vec3d vec3d4 = vec3d3.add(new Vec3d(vec3d2.x * 0.5, vec3d2.y * 0.5, vec3d2.z * 0.5));
                        if (vec3d.squareDistanceTo(vec3d4) > 18.0 || d5 > vec3d.squareDistanceTo(vec3d3.add(vec3d2))) continue;
                        if (fed.Field313.world.rayTraceBlocks(vec3d, vec3d4, false, true, false) != null) continue;
                        double d6 = vec3d4.x - vec3d.x;
                        double d7 = vec3d4.y - vec3d.y;
                        double d8 = vec3d4.z - vec3d.z;
                        double d9 = MathHelper.sqrt((double)(d6 * d6 + d8 * d8));
                        Rotation rotation = new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d8, d6)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d7, d9))))));
                        Vec3d vec3d5 = few.Method835().Method834(rotation);
                        Vec3d vec3d6 = vec3d.addVector(vec3d5.x * 4.0, vec3d5.y * 4.0, vec3d5.z * 4.0);
                        RayTraceResult rayTraceResult = fed.Field313.world.rayTraceBlocks(vec3d, vec3d6, false, false, true);
                        if (rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                        if (!rayTraceResult.getBlockPos().equals((Object)blockPos2)) continue;
                        if (feh2 != null) {
                            if (!(few.Method835().Method853(rotation) < few.Method835().Method853(feh2.Method786().Method891()))) continue;
                        }
                        feh2 = new feh(blockPos2, enumFacing.getOpposite(), vec3d4, new fex(vec3d3, rotation, enumFacing.getOpposite()));
                    }
                }
            }
        }
        return feh2;
    }

    public static float Method336(float f) {
        f %= 360.0f;
        while (f >= 180.0f) {
            f -= 360.0f;
        }
        while (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static fea Method660(BlockPos blockPos, float f, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        IBlockState iBlockState = feg.Method701(blockPos);
        if (!iBlockState.getMaterial().isReplaceable()) {
            return fea.NotReplaceable;
        }
        if (!fed.Method667(blockPos)) {
            return fea.Neighbors;
        }
        Vec3d vec3d = new Vec3d(fed.Field313.player.posX, fed.Field313.player.posY + (double)fed.Field313.player.getEyeHeight(), fed.Field313.player.posZ);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            if (!feg.Method701(blockPos2).getBlock().canCollideCheck(feg.Method701(blockPos2), false)) continue;
            Vec3d vec3d2 = new Vec3d((Vec3i)blockPos2).addVector(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5));
            if (!(vec3d.distanceTo(vec3d2) <= (double)f)) continue;
            Block block = feg.Method701(blockPos2).getBlock();
            boolean bl5 = block.onBlockActivated((World)fed.Field313.world, blockPos, feg.Method701(blockPos), (EntityPlayer)fed.Field313.player, EnumHand.MAIN_HAND, enumFacing, 0.0f, 0.0f, 0.0f);
            if (Field441.contains((Object)block) || Field442.contains((Object)block) || bl5) {
                fed.Field313.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)fed.Field313.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            EnumActionResult enumActionResult = null;
            if (bl4) {
                float[] arrf = few.Method835().Method850(blockPos2, enumFacing.getOpposite());
                fed.Field313.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(arrf[0], arrf[1], fed.Field313.player.onGround));
                Pyro.Field6184.Method7536(arrf[0]);
                Pyro.Field6184.Method7539(arrf[1]);
            }
            enumActionResult = bl3 ? fed.Method655(fed.Field313.player, fed.Field313.world, blockPos2, enumFacing2, vec3d2, bl2 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND) : fed.Field313.playerController.processRightClickBlock(fed.Field313.player, fed.Field313.world, blockPos2, enumFacing2, vec3d2, bl2 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
            if (enumActionResult == EnumActionResult.FAIL) continue;
            if (bl) {
                fed.Field313.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            } else {
                fed.Field313.player.swingArm(EnumHand.MAIN_HAND);
            }
            if (bl5) {
                fed.Field313.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)fed.Field313.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            return fea.Placed;
        }
        return fea.CantPlace;
    }

    public static fea Method661(BlockPos blockPos, float f, boolean bl) {
        return fed.Method660(blockPos, f, bl, false, false, false);
    }

    public static feh Method662(int n, int n2, int n3) {
        return fed.Method671(new BlockPos(n, n2, n3));
    }

    public static feb Method663(BlockPos blockPos, EnumFacing enumFacing, ItemStack itemStack) {
        return fed.Method666(blockPos, false, false, enumFacing, itemStack);
    }

    public static float[] Method664(double d, double d2, double d3) {
        return fed.Method656(d, d2, d3, fed.Field313.player.posX, fed.Field313.player.posY + (double)fed.Field313.player.getEyeHeight(), fed.Field313.player.posZ);
    }

    public static fea Method665(BlockPos blockPos, float f, boolean bl, boolean bl2, boolean bl3) {
        return fed.Method660(blockPos, f, bl, bl2, bl3, false);
    }

    public static feb Method666(BlockPos blockPos, boolean bl, boolean bl2, EnumFacing enumFacing, ItemStack itemStack) {
        if (fed.Field313.world == null) {
            return feb.NoEntityCollision;
        }
        if (!fed.Field313.world.checkNoEntityCollision(new AxisAlignedBB(blockPos)) && !bl) {
            return feb.NoEntityCollision;
        }
        if (!fed.Method673(blockPos)) {
            return feb.NoNeighbors;
        }
        if (itemStack.getItem() instanceof ItemBlock) {
            ItemBlock itemBlock = (ItemBlock)itemStack.getItem();
            if (!itemBlock.canPlaceBlockOnSide((World)fed.Field313.world, blockPos, enumFacing, (EntityPlayer)fed.Field313.player, itemStack)) {
                return feb.AlreadyBlockThere;
            }
            return feb.Ok;
        }
        return feb.AlreadyBlockThere;
    }

    public static boolean Method667(BlockPos blockPos) {
        if (!fed.Method673(blockPos)) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                BlockPos blockPos2 = blockPos.offset(enumFacing);
                if (!fed.Method673(blockPos2)) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    public static feh Method668(BlockPos blockPos) {
        return fed.Method674(blockPos, 1.0);
    }

    public static feh Method669(BlockPos blockPos) {
        return fed.Method671(blockPos);
    }

    public static feh Method670(BlockPos blockPos) {
        return fed.Method668(blockPos);
    }

    public static feh Method671(BlockPos blockPos) {
        return fed.Method659(blockPos, 1.0);
    }

    public static float[] Method672(int n, int n2, int n3, EnumFacing enumFacing, double d) {
        return fed.Method664((double)n + 0.5 + (double)enumFacing.getDirectionVec().getX() * d / 2.0, (double)n2 + 0.5 + (double)enumFacing.getDirectionVec().getY() * d / 2.0, (double)n3 + 0.5 + (double)enumFacing.getDirectionVec().getZ() * d / 2.0);
    }

    public static boolean Method673(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (feg.Method701(blockPos2).getMaterial().isReplaceable()) continue;
            return true;
        }
        return false;
    }

    public static feh Method674(BlockPos blockPos, double d) {
        Vec3d vec3d = new Vec3d(fed.Field313.player.posX, fed.Field313.player.getEntityBoundingBox().minY + (double)fed.Field313.player.getEyeHeight(), fed.Field313.player.posZ);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!feg.Method691(blockPos2)) continue;
            Vec3d vec3d2 = new Vec3d(enumFacing.getDirectionVec());
            for (double d2 : Field443) {
                for (double d3 : Field444) {
                    for (double d4 : Field445) {
                        Vec3d vec3d3 = new Vec3d((Vec3i)blockPos).addVector(d2, d3, d4);
                        double d5 = vec3d.squareDistanceTo(vec3d3);
                        Vec3d vec3d4 = vec3d3.add(new Vec3d(vec3d2.x * 0.5, vec3d2.y * 0.5, vec3d2.z * 0.5));
                        if (vec3d.squareDistanceTo(vec3d4) > 18.0 || d5 > vec3d.squareDistanceTo(vec3d3.add(vec3d2)) || fed.Field313.world.rayTraceBlocks(vec3d, vec3d4, false, true, false) != null) continue;
                        double d6 = vec3d4.x - vec3d.x;
                        double d7 = vec3d4.y - vec3d.y;
                        double d8 = vec3d4.z - vec3d.z;
                        double d9 = MathHelper.sqrt((double)(d6 * d6 + d8 * d8));
                        Rotation rotation = new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d8, d6)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d7, d9))))));
                        Vec3d vec3d5 = few.Method835().Method834(rotation);
                        Vec3d vec3d6 = vec3d.addVector(vec3d5.x * 4.0, vec3d5.y * 4.0, vec3d5.z * 4.0);
                        RayTraceResult rayTraceResult = fed.Field313.world.rayTraceBlocks(vec3d, vec3d6, false, false, true);
                        if (rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object)blockPos2)) continue;
                        return new feh(blockPos2, enumFacing.getOpposite(), vec3d4, new fex(vec3d3, rotation, enumFacing.getOpposite()));
                    }
                }
            }
        }
        return null;
    }
}

