/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f9s;
import dev.nuker.pyro.f9t;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class f9u
extends Module {
    public f0o<f9t> Field4498 = new f0o("mode", "Mode", null, f9t.Solid);
    public BooleanSetting Field4499 = new BooleanSetting("ncpStrict", "NCP Strict", null, false);
    public boolean Field4500 = false;
    public float Field4501;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method2622() {
        if (!(this.Field5233.player.fallDistance < 3.0f)) return false;
        if (this.Field5233.player.movementInput.jump) return false;
        if (this.Method4876()) return false;
        if (this.Field5233.player.isSneaking()) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        if (((Boolean)this.Field4499.Method7979()).booleanValue()) {
            this.Method7274(String.valueOf(this.Field4498.Method7979()) + " Strict");
        } else {
            this.Method7274(String.valueOf(this.Field4498.Method7979()));
        }
        switch (f9s.Field4472[((f9t)((Object)this.Field4498.Method7979())).ordinal()]) {
            case 1: 
            case 2: {
                if (!this.Field5233.player.movementInput.sneak && !this.Field5233.player.movementInput.jump && this.Method4876()) {
                    this.Field5233.player.motionY = 0.1f;
                }
                if ((Boolean)this.Field4499.Method7979() == false) return;
                if (this.Method2622()) return;
                this.Field4501 = 0.0f;
                return;
            }
            case 3: {
                if (this.Method4876() && !this.Field5233.player.isSneaking()) {
                    this.Field5233.player.onGround = false;
                }
                Block block = feg.Method690(new BlockPos(Math.floor(this.Field5233.player.posX), Math.floor(this.Field5233.player.posY), Math.floor(this.Field5233.player.posZ)));
                if (this.Field4500 && !this.Field5233.player.capabilities.isFlying && !this.Field5233.player.isInWater()) {
                    if (this.Field5233.player.motionY < -0.3 || this.Field5233.player.onGround || this.Field5233.player.isOnLadder()) {
                        this.Field4500 = false;
                        return;
                    }
                    this.Field5233.player.motionY = this.Field5233.player.motionY / (double)0.98f + 0.08;
                    this.Field5233.player.motionY -= 0.03120000000005;
                }
                if (this.Field5233.player.isInWater() || this.Field5233.player.isInLava()) {
                    this.Field5233.player.motionY = 0.1f;
                    this.Field4500 = false;
                    return;
                }
                if (this.Field5233.player.isInLava()) return;
                if (!(block instanceof BlockLiquid)) return;
                if (!(this.Field5233.player.motionY < (double)0.2f)) return;
                this.Field5233.player.motionY = (Boolean)this.Field4499.Method7979() == false ? 0.5 : 0.184;
                this.Field4500 = true;
                return;
            }
        }
    }

    public void Method285(BlockPos blockPos, CallbackInfoReturnable callbackInfoReturnable) {
        if (this.Field5233.world == null || this.Field5233.player == null || !((Boolean)this.Field5236.Method5264()).booleanValue()) {
            return;
        }
        if (this.Field4498.Method7979() == f9t.Dolphin) {
            return;
        }
        if (this.Method4876()) {
            return;
        }
        if (!this.Field5233.player.isRowingBoat() && !this.Field5233.player.isSneaking()) {
            callbackInfoReturnable.Method9034();
            callbackInfoReturnable.Method521(Block.FULL_BLOCK_AABB);
            if (this.Field5233.player.getRidingEntity() != null) {
                callbackInfoReturnable.Method521(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, (double)0.95f, 1.0));
            } else if (this.Field4498.Method7979() == f9t.Dolphin) {
                if (this.Method2622()) {
                    callbackInfoReturnable.Method521(new AxisAlignedBB((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getY(), (double)blockPos.getX(), (double)blockPos.getY() + (this.Field5233.player.movementInput.jump ? 0.95 : 0.99), (double)blockPos.getZ()));
                }
            } else if (this.Field4498.Method7979() == f9t.Trampoline && !this.Field5233.player.isSneaking()) {
                callbackInfoReturnable.Method521(new AxisAlignedBB((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getY(), (double)blockPos.getX(), (double)blockPos.getY() + 0.96, (double)blockPos.getZ()));
            }
        }
    }

    public boolean Method4876() {
        if (this.Field5233.player == null) {
            return false;
        }
        boolean bl = false;
        int n = (int)(this.Field5233.player.getEntityBoundingBox().minY + 0.02);
        for (int i = MathHelper.floor((double)this.Field5233.player.getEntityBoundingBox().minX); i < MathHelper.floor((double)this.Field5233.player.getEntityBoundingBox().maxX) + 1; ++i) {
            for (int j = MathHelper.floor((double)this.Field5233.player.getEntityBoundingBox().minZ); j < MathHelper.floor((double)this.Field5233.player.getEntityBoundingBox().maxZ) + 1; ++j) {
                Block block = this.Field5233.world.getBlockState(new BlockPos(i, n, j)).getBlock();
                if (block == null || block instanceof BlockAir) continue;
                if (!(block instanceof BlockLiquid)) {
                    return false;
                }
                bl = true;
            }
        }
        return bl;
    }

    @f0g
    @LauncherEventHide
    public void Method2393(f49 f492) {
        block10: {
            block9: {
                if (f492.Method5619() != f41.Pre || this.Field5233.world == null) break block9;
                if (this.Field5233.player != null) break block10;
            }
            return;
        }
        if (f492.Method5784() instanceof CPacketPlayer && this.Method2412() && this.Method2622()) {
            CPacketPlayerAccessor cPacketPlayerAccessor = (CPacketPlayerAccessor)((CPacketPlayer)f492.Method5784());
            if (!((Boolean)this.Field4499.Method7979()).booleanValue()) {
                if (this.Field5233.player.ticksExisted % 2 == 0 && this.Field4498.Method7979() == f9t.Solid) {
                    cPacketPlayerAccessor.Method8718(cPacketPlayerAccessor.Method8719() - 0.05);
                }
            } else {
                cPacketPlayerAccessor.Method8718(cPacketPlayerAccessor.Method8719() - (double)this.Field4501);
                this.Field4501 += 0.12f;
                if (this.Field4501 > 0.4f) {
                    this.Field4501 = 0.2f;
                }
            }
        }
    }

    public f9u() {
        super("jesus", "Jesus", "Allows you to walk on water");
        this.Method7264(this.Field4498);
        this.Method7264(this.Field4499);
    }

    public boolean Method2412() {
        float f = 0.05f;
        if (this.Field5233.player == null) {
            return false;
        }
        if (this.Field5233.player.fallDistance >= 3.0f) {
            return false;
        }
        if (this.Field5233.player != null) {
            AxisAlignedBB axisAlignedBB = this.Field5233.player.getRidingEntity() != null ? this.Field5233.player.getRidingEntity().getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, (double)-0.05f, 0.0) : this.Field5233.player.getEntityBoundingBox().contract(0.0, 0.0, 0.0).offset(0.0, (double)-0.05f, 0.0);
            boolean bl = false;
            int n = (int)axisAlignedBB.minY;
            for (int i = MathHelper.floor((double)axisAlignedBB.minX); i < MathHelper.floor((double)(axisAlignedBB.maxX + 1.0)); ++i) {
                for (int j = MathHelper.floor((double)axisAlignedBB.minZ); j < MathHelper.floor((double)(axisAlignedBB.maxZ + 1.0)); ++j) {
                    Block block = this.Field5233.world.getBlockState(new BlockPos(i, n, j)).getBlock();
                    if (block == Blocks.AIR) continue;
                    if (!(block instanceof BlockLiquid)) {
                        return false;
                    }
                    bl = true;
                }
            }
            return bl;
        }
        return false;
    }
}

