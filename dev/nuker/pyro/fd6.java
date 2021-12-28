/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Class58;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.fd5;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.few;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fd6
extends Module {
    @NotNull
    public BooleanSetting Field125 = (BooleanSetting)this.Method7264(new BooleanSetting("rotate", "Rotate", null, true));
    @NotNull
    public BooleanSetting Field126 = (BooleanSetting)this.Method7264(new BooleanSetting("raytrace", "Raytrace", null, true));
    @NotNull
    public f0l Field127 = (f0l)this.Method7264(new f0l("renderColor", "RenderColor", null, new f00(1.0f, 1.0f, 0.5f, 0.3f)));
    @NotNull
    public f0l Field128 = (f0l)this.Method7264(new f0l("renderOutline", "RenderOutline", null, new f00(1.0f, 1.0f, 0.5f, 1.0f)));
    @Nullable
    public BlockPos Field129;

    public void Method209(@Nullable BlockPos blockPos) {
        this.Field129 = blockPos;
    }

    @NotNull
    public EnumFacing Method210() {
        switch (MathHelper.floor((double)((double)(this.Field5233.player.rotationYaw * 8.0f / 360.0f) + 0.5)) & 7) {
            case 0: 
            case 1: {
                return EnumFacing.SOUTH;
            }
            case 2: 
            case 3: {
                return EnumFacing.WEST;
            }
            case 4: 
            case 5: {
                return EnumFacing.NORTH;
            }
            case 6: 
            case 67: {
                return EnumFacing.EAST;
            }
        }
        return EnumFacing.NORTH;
    }

    @Nullable
    public BlockPos Method211() {
        return this.Field129;
    }

    public boolean Method204(@NotNull f4u f4u2, @NotNull BlockPos blockPos) {
        if (((Boolean)this.Field125.Method7979()).booleanValue()) {
            float[] arrf = few.Method835().Method850(blockPos, few.Method848(blockPos, true));
            if (arrf != null) {
                f4u2.Method7948();
                f4u2.Method5653(arrf[0]);
                f4u2.Method5647(arrf[1]);
                return true;
            }
            return false;
        }
        return true;
    }

    public fd6() {
        super("autotunnel", "AutoTunnel", null);
    }

    public boolean Method212(@NotNull IBlockState iBlockState, @NotNull BlockPos blockPos, @NotNull Block block) {
        if (this.Field5233.playerController == null) {
            return false;
        }
        if (PyroStatic.Field6504.Method584().contains((Object)block)) {
            return false;
        }
        if ((double)iBlockState.getBlockHardness((World)this.Field5233.world, blockPos) == 1.0) {
            if (!this.Field5233.playerController.isInCreativeMode()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field126;
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        EnumFacing enumFacing;
        if (f4u2.Method7947()) {
            return;
        }
        if (f4u2.Method5619() != f41.Pre) {
            return;
        }
        if (Class58.Field4487.Method5755() != null) {
            if (Intrinsics.Method6572(Class58.Field4487.Method5755(), this) ^ true) {
                return;
            }
        }
        if (Intrinsics.Method6572(Class58.Field4487.Method5755(), this)) {
            if (this.Field129 != null) {
                BlockPos blockPos = this.Field129;
                if (blockPos == null) {
                    Intrinsics.Method6551();
                }
                this.Method204(f4u2, blockPos);
                return;
            }
        }
        if ((enumFacing = this.Method210()) != null) {
            BlockPos blockPos = new BlockPos(MathHelper.floor((double)this.Field5233.player.posX), MathHelper.floor((double)this.Field5233.player.posY), MathHelper.floor((double)this.Field5233.player.posZ)).offset(enumFacing);
            ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
            int n = 3;
            for (int i = 0; i <= n; ++i) {
                arrayList.add(blockPos.offset(enumFacing, i));
                arrayList.add(blockPos.offset(enumFacing, i).up());
            }
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                BlockPos blockPos2 = (BlockPos)iterator2.next();
                double d = this.Field5233.player.posX - ((double)blockPos2.getX() + 0.5);
                double d2 = this.Field5233.player.posY - ((double)blockPos2.getY() + 0.5) + 1.5;
                double d3 = this.Field5233.player.posZ - ((double)blockPos2.getZ() + 0.5);
                double d4 = d * d + d2 * d2 + d3 * d3;
                if (d4 > 36.0) continue;
                Block block = feg.Method690(blockPos2);
                if (!this.Method212(feg.Method701(blockPos2), blockPos2, block) || !this.Method204(f4u2, blockPos2)) continue;
                this.Field129 = blockPos2;
                Class58.Field4487.Method6420(this, blockPos2, (Boolean)this.Field126.Method7979(), new fd5(this));
                break;
            }
        }
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (Class58.Field4487.Method5755() != null) {
            if (Intrinsics.Method6572(Class58.Field4487.Method5755(), this)) {
                Class58.Field4487.Method4824(false);
                return;
            }
        }
    }

    @NotNull
    public f0l Method214() {
        return this.Field128;
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field125;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        if (this.Field129 != null) {
            fe5.Field252.Method408(7);
            BlockPos blockPos = this.Field129;
            if (blockPos == null) {
                Intrinsics.Method6551();
            }
            fe5.Field252.Method410(blockPos, ((f00)this.Field127.Method7979()).Method7515(), 63);
            fe5.Field252.Method405();
            BlockPos blockPos2 = this.Field129;
            if (blockPos2 == null) {
                Intrinsics.Method6551();
            }
            PyroRenderUtil.Method12305(blockPos2, ((f00)this.Field128.Method7979()).Method7515(), 1.5f, false);
        }
    }

    @NotNull
    public f0l Method216() {
        return this.Field127;
    }
}

