/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f6x;
import dev.nuker.pyro.fe4;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.fed;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.few;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f6y
extends Module {
    @NotNull
    public DoubleSetting Field3332 = (DoubleSetting)this.Method7264(new DoubleSetting("range", "Range", null, 6.0, 0.0, 6.0, 0.0, 64, null));
    @NotNull
    public IntegerSetting Field3333 = (IntegerSetting)this.Method7264(new IntegerSetting("toggleTicks", "ToggleTicks", null, 0, 0, 10, 0, 64, null));
    @NotNull
    public BooleanSetting Field3334 = (BooleanSetting)this.Method7264(new BooleanSetting("toggleOnTrap", "ToggleOnTrap", null, false));
    @NotNull
    public f0l Field3335 = (f0l)this.Method7264(new f0l("blockColor", "Block Color", null, new f00(0.0f, 1.0f, 0.5f, 0.33f)));
    @NotNull
    public BooleanSetting Field3336 = (BooleanSetting)this.Method7264(new BooleanSetting("instant", "Instant", null, false));
    @Nullable
    public BlockPos Field3337;
    public int Field3338;
    @Nullable
    public EntityPlayer Field3339;
    @JvmField
    public boolean Field3340;

    @f0g(value=1)
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        if (f4u2.Method5619() != f41.Pre || f4u2.Method7947()) {
            return;
        }
        if (this.Field3337 != null && !feg.Method700(this.Field3337)) {
            this.Field3337 = null;
        }
        if (this.Field3339 != null && ((Boolean)this.Field3334.Method7979()).booleanValue()) {
            EntityPlayer entityPlayer = this.Field3339;
            if (entityPlayer == null) {
                Intrinsics.Method6551();
            }
            if (this.Method2425((Entity)entityPlayer)) {
                Pyro.Field6182.Method8989("Target is trapped, disabling!");
                this.Field5236.Method5266(false);
                return;
            }
        }
        EntityPlayer entityPlayer = null;
        float f = 1337.0f;
        for (EntityPlayer entityPlayer2 : this.Field5233.world.playerEntities) {
            float f2;
            if (entityPlayer2 instanceof EntityPlayerSP) continue;
            if (!fe4.Field250.Method387(entityPlayer2)) continue;
            if (this.Method2425((Entity)entityPlayer2) || !((double)(f2 = this.Field5233.player.getDistance((Entity)entityPlayer2)) <= ((Number)this.Field3332.Method7979()).doubleValue()) || !(f2 < f)) continue;
            f = f2;
            entityPlayer = entityPlayer2;
        }
        ++this.Field3338;
        if (((Number)this.Field3333.Method7979()).intValue() > 0) {
            if (this.Field3338 >= ((Number)this.Field3333.Method7979()).intValue()) {
                Pyro.Field6182.Method8989("Reached ToggleTicks threshold, disabling AutoTrap!");
                this.Field5236.Method5266(false);
                return;
            }
        }
        if (entityPlayer != null) {
            BlockPos[] arrblockPos;
            this.Field3339 = entityPlayer;
            int n = -1;
            boolean bl = true;
            if (!this.Field5233.player.getHeldItemMainhand().isEmpty()) {
                if (this.Field5233.player.getHeldItemMainhand().getItem() instanceof ItemBlock) {
                    Item item = this.Field5233.player.getHeldItemMainhand().getItem();
                    if (item == null) {
                        throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                    }
                    ItemBlock itemBlock = (ItemBlock)item;
                    if (Intrinsics.Method6572((Object)itemBlock.getBlock(), (Object)Blocks.OBSIDIAN)) {
                        n = this.Field5233.player.inventory.currentItem;
                        bl = false;
                    }
                }
            }
            if (n == -1) {
                int n2 = 8;
                for (int i = 0; i <= n2; ++i) {
                    if (!(this.Field5233.player.inventory.getStackInSlot(i).getItem() instanceof ItemBlock)) continue;
                    Item item = this.Field5233.player.inventory.getStackInSlot(i).getItem();
                    if (item == null) {
                        throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                    }
                    arrblockPos = (BlockPos[])item;
                    if (!Intrinsics.Method6572((Object)arrblockPos.getBlock(), (Object)Blocks.OBSIDIAN)) continue;
                    n = i;
                    break;
                }
            }
            if (n == -1) {
                return;
            }
            int n3 = this.Field5233.player.inventory.currentItem;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.Field4235 = false;
            this.Method7274("Trapping");
            this.Field3340 = true;
            arrblockPos = this.Method5172((Entity)entityPlayer);
            boolean bl2 = false;
            Vec3d vec3d = new Vec3d(this.Field5233.player.posX, this.Field5233.player.posY + (double)this.Field5233.player.getEyeHeight(), this.Field5233.player.posZ);
            for (BlockPos blockPos : arrblockPos) {
                if (!feg.Method700(blockPos) || !this.Field5233.world.checkNoEntityCollision(new AxisAlignedBB(blockPos))) continue;
                this.Field3337 = blockPos;
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    BlockPos blockPos2 = blockPos.offset(enumFacing);
                    EnumFacing enumFacing2 = enumFacing.getOpposite();
                    if (!this.Field5233.world.getBlockState(blockPos2).getBlock().canCollideCheck(this.Field5233.world.getBlockState(blockPos2), false)) continue;
                    EnumFacing enumFacing3 = enumFacing2;
                    Vec3d vec3d2 = new Vec3d((Vec3i)blockPos2).addVector(0.5, 0.5, 0.5).add(new Vec3d(enumFacing3.getDirectionVec()).scale(0.5));
                    if (!(vec3d.distanceTo(vec3d2) <= 6.0)) continue;
                    Block block = this.Field5233.world.getBlockState(blockPos2).getBlock();
                    boolean bl3 = block.onBlockActivated((World)this.Field5233.world, blockPos, this.Field5233.world.getBlockState(blockPos), (EntityPlayer)this.Field5233.player, EnumHand.MAIN_HAND, enumFacing, 0.0f, 0.0f, 0.0f);
                    float[] arrf = few.Method835().Method850(blockPos2, enumFacing.getOpposite());
                    if (((Boolean)this.Field3336.Method7979()).booleanValue()) {
                        NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
                        if (netHandlerPlayClient == null) {
                            Intrinsics.Method6551();
                        }
                        netHandlerPlayClient.sendPacket((Packet)new CPacketPlayer.Rotation(arrf[0], arrf[1], this.Field5233.player.onGround));
                        booleanRef.Field4235 = false;
                        if (fed.Field441.contains((Object)block) || fed.Field442.contains((Object)block) || bl3) {
                            this.Field5233.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)this.Field5233.player, CPacketEntityAction.Action.START_SNEAKING));
                            booleanRef.Field4235 = true;
                        }
                        if (bl) {
                            if (!bl2) {
                                bl2 = true;
                                this.Field5233.player.inventory.currentItem = n;
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n));
                            }
                        }
                        this.Field5233.playerController.processRightClickBlock(this.Field5233.player, this.Field5233.world, blockPos2, enumFacing2, vec3d2, EnumHand.MAIN_HAND);
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
                        break;
                    }
                    f4u2.Method7948();
                    f4u2.Method5653(arrf[0]);
                    f4u2.Method5647(arrf[1]);
                    int n4 = n;
                    boolean bl4 = bl;
                    f4u2.Method5816(new f6x(this, booleanRef, bl3, block, bl4, n4, blockPos2, enumFacing2, vec3d2, n3));
                    break;
                }
                if (((Boolean)this.Field3336.Method7979()).booleanValue() || !f4u2.Method7947()) continue;
                return;
            }
            if (((Boolean)this.Field3336.Method7979()).booleanValue()) {
                if (bl && bl2) {
                    this.Field5233.player.inventory.currentItem = n3;
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
                }
                if (booleanRef.Field4235) {
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)this.Field5233.player, CPacketEntityAction.Action.STOP_SNEAKING));
                }
            }
        } else {
            this.Method7274("Looking");
            this.Field3340 = false;
        }
    }

    public void Method541(int n) {
        this.Field3338 = n;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field3338 = 0;
        this.Field3339 = null;
        this.Field3340 = false;
    }

    @NotNull
    public BooleanSetting Method270() {
        return this.Field3336;
    }

    public static Minecraft Method5169(f6y f6y2) {
        return f6y2.Field5233;
    }

    public int Method547() {
        return this.Field3338;
    }

    @Nullable
    public EntityPlayer Method5170() {
        return this.Field3339;
    }

    @NotNull
    public DoubleSetting Method226() {
        return this.Field3332;
    }

    @Nullable
    public BlockPos Method5171() {
        return this.Field3337;
    }

    public void Method209(@Nullable BlockPos blockPos) {
        this.Field3337 = blockPos;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        if (this.Field5233.player != null && this.Field3337 != null) {
            fe5.Field252.Method408(7);
            BlockPos blockPos = this.Field3337;
            if (blockPos == null) {
                Intrinsics.Method6551();
            }
            fe5.Field252.Method410(blockPos, ((f00)this.Field3335.Method7979()).Method7515(), 63);
            fe5.Field252.Method405();
        }
    }

    @NotNull
    public f0l Method242() {
        return this.Field3335;
    }

    @NotNull
    public BlockPos[] Method5172(@NotNull Entity entity) {
        BlockPos blockPos = new BlockPos(MathHelper.floor((double)entity.posX), MathHelper.floor((double)entity.posY), MathHelper.floor((double)entity.posZ));
        BlockPos[] arrblockPos = new BlockPos[10];
        arrblockPos[0] = blockPos.north();
        arrblockPos[1] = blockPos.south();
        arrblockPos[2] = blockPos.west();
        arrblockPos[3] = blockPos.east();
        arrblockPos[4] = blockPos.north().up();
        arrblockPos[5] = blockPos.south().up();
        arrblockPos[6] = blockPos.west().up();
        arrblockPos[7] = blockPos.east().up();
        arrblockPos[8] = blockPos.up().up().east();
        arrblockPos[9] = blockPos.up().up();
        return arrblockPos;
    }

    public boolean Method2425(@NotNull Entity entity) {
        for (BlockPos blockPos : this.Method5172(entity)) {
            IBlockState iBlockState = this.Field5233.world.getBlockState(blockPos);
            if (!this.Field5233.world.isAirBlock(blockPos)) {
                if (!(iBlockState.getBlock() instanceof BlockLiquid) && !iBlockState.getBlock().isReplaceable((IBlockAccess)this.Field5233.world, blockPos)) continue;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field3334;
    }

    public void Method5173(@Nullable EntityPlayer entityPlayer) {
        this.Field3339 = entityPlayer;
    }

    public f6y() {
        super("autoTrap", "AutoTrap", "Automatically traps a player near you in obsidian");
    }

    public static void Method5174(f6y f6y2, Minecraft minecraft) {
        f6y2.Field5233 = minecraft;
    }

    @NotNull
    public IntegerSetting Method5175() {
        return this.Field3333;
    }
}

