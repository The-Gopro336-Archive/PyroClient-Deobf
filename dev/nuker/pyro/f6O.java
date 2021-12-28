/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f6M;
import dev.nuker.pyro.f6N;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.few;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
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

public class f6O
extends Module {
    @NotNull
    public DoubleSetting Field2957 = (DoubleSetting)this.Method7264(new DoubleSetting("range", "Range", null, 6.0, 1.0, 6.0, 0.0, 64, null));
    @NotNull
    public List<BlockPos> Field2958 = new ArrayList();

    public static Minecraft Method4839(f6O f6O2) {
        return f6O2.Field5233;
    }

    public static void Method4840(f6O f6O2, Minecraft minecraft) {
        f6O2.Field5233 = minecraft;
    }

    public f6O() {
        super("holefiller", "HoleFiller", null);
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        super.Method195(vec3d, f);
        this.Field2958.forEach(f6N.Field2951);
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field2958.clear();
    }

    @NotNull
    public DoubleSetting Method238() {
        return this.Field2957;
    }

    public void Method4841(@NotNull List list) {
        this.Field2958 = list;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method4842(@NotNull BlockPos blockPos) {
        Block block = feg.Method690(blockPos);
        if (!Intrinsics.Method6572((Object)block, (Object)Blocks.AIR)) return false;
        for (BlockPos blockPos2 : new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west(), blockPos.down()}) {
            Block block2 = feg.Method690(blockPos2);
            if (block2 instanceof BlockLiquid) return false;
            if (!Intrinsics.Method6572((Object)block2, (Object)Blocks.AIR)) continue;
            return false;
        }
        if (!Intrinsics.Method6572((Object)feg.Method690(blockPos.up()), (Object)Blocks.AIR)) return false;
        if (!Intrinsics.Method6572((Object)feg.Method690(blockPos.up().up()), (Object)Blocks.AIR)) return false;
        return true;
    }

    @NotNull
    public List Method4843() {
        return this.Field2958;
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre && !f4u2.Method7947()) {
            BlockPos blockPos;
            int n;
            this.Field2958.clear();
            int n2 = -1;
            int n3 = 8;
            for (n = 0; n <= n3; ++n) {
                if (!(this.Field5233.player.inventory.getStackInSlot(n).getItem() instanceof ItemBlock)) continue;
                Item item = this.Field5233.player.inventory.getStackInSlot(n).getItem();
                if (item == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                }
                ItemBlock itemBlock = (ItemBlock)item;
                if (!Intrinsics.Method6572((Object)itemBlock.getBlock(), (Object)Blocks.OBSIDIAN)) continue;
                n2 = n;
                break;
            }
            if (n2 == -1) {
                this.Method7274("No block");
                return;
            }
            n = this.Field5233.player.inventory.currentItem;
            n3 = (int)(this.Field5233.player.posX - (double)10);
            int n4 = (int)(this.Field5233.player.posX + (double)10);
            int n5 = (int)(this.Field5233.player.posY - (double)10);
            int n6 = (int)(this.Field5233.player.posY + (double)10);
            int n7 = (int)(this.Field5233.player.posZ - (double)10);
            int n8 = (int)(this.Field5233.player.posZ + (double)10);
            Vec3d vec3d = new Vec3d(this.Field5233.player.posX, this.Field5233.player.getEntityBoundingBox().minY + (double)this.Field5233.player.getEyeHeight(), this.Field5233.player.posZ);
            int n9 = n4;
            for (int i = n3; i < n9; ++i) {
                int n10 = n6;
                for (int j = n5; j < n10; ++j) {
                    int n11 = n8;
                    for (int k = n7; k < n11; ++k) {
                        blockPos = new BlockPos(i, j, k);
                        double d = this.Field5233.player.posX - ((double)blockPos.getX() + 0.5);
                        double d2 = this.Field5233.player.posY - ((double)blockPos.getY() + 0.5) + 1.5;
                        double d3 = this.Field5233.player.posZ - ((double)blockPos.getZ() + 0.5);
                        double d4 = d * d + d2 * d2 + d3 * d3;
                        if (d4 > 36.0 || d4 > ((Number)this.Field2957.Method7979()).doubleValue() * ((Number)this.Field2957.Method7979()).doubleValue() || !this.Method4842(blockPos) || this.Field2958.contains((Object)blockPos) || !feg.Method700(blockPos) || !this.Field5233.world.checkNoEntityCollision(new AxisAlignedBB(blockPos))) continue;
                        this.Field2958.add(blockPos);
                    }
                }
            }
            if (this.Field2958.isEmpty()) {
                Pyro.Field6182.Method8989("Done filling");
                this.Field5236.Method5266(false);
                return;
            }
            this.Method7274("Filling");
            for (BlockPos blockPos2 : this.Field2958) {
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    blockPos = blockPos2.offset(enumFacing);
                    EnumFacing enumFacing2 = enumFacing.getOpposite();
                    if (!this.Field5233.world.getBlockState(blockPos).getBlock().canCollideCheck(this.Field5233.world.getBlockState(blockPos), false)) continue;
                    BlockPos blockPos3 = blockPos;
                    if (blockPos3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.math.Vec3i");
                    }
                    EnumFacing enumFacing3 = enumFacing2;
                    Vec3d vec3d2 = new Vec3d((Vec3i)blockPos3).addVector(0.5, 0.5, 0.5).add(new Vec3d(enumFacing3.getDirectionVec()).scale(0.5));
                    if (!(vec3d.distanceTo(vec3d2) <= 6.0)) continue;
                    Block block = this.Field5233.world.getBlockState(blockPos).getBlock();
                    boolean bl = block.onBlockActivated((World)this.Field5233.world, blockPos2, this.Field5233.world.getBlockState(blockPos2), (EntityPlayer)this.Field5233.player, EnumHand.MAIN_HAND, enumFacing, 0.0f, 0.0f, 0.0f);
                    float[] arrf = few.Method835().Method850(blockPos, enumFacing.getOpposite());
                    f4u2.Method7948();
                    f4u2.Method5653(arrf[0]);
                    f4u2.Method5647(arrf[1]);
                    int n12 = n2;
                    f4u2.Method5816(new f6M(this, bl, block, n12, blockPos, enumFacing2, vec3d2, n));
                    break;
                }
                if (!f4u2.Method7947()) continue;
                return;
            }
        }
    }
}

