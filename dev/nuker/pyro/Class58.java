/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.few;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.function.Consumer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class Class58
extends fdZ {
    public Module Field4482 = null;
    public BlockPos Field4483 = BlockPos.ORIGIN;
    public boolean Field4484 = false;
    public Consumer<Boolean> Field4485 = null;
    public boolean Field4486;
    public static Class58 Field4487 = new Class58();

    @f0g
    @LauncherEventHide
    public void Method498(f4t f4t2) {
        double d;
        double d2;
        block8: {
            block7: {
                if (this.Field4482 == null || this.Field4483 == BlockPos.ORIGIN) {
                    return;
                }
                Block block = feg.Method690(this.Field4483);
                if (block instanceof BlockLiquid) break block7;
                if (!(block instanceof BlockAir) && (Class58.Field313.playerController.isInCreativeMode() || !block.equals((Object)Blocks.BEDROCK) && !block.equals((Object)Blocks.BARRIER))) break block8;
            }
            this.Method4824(true);
            return;
        }
        double d3 = Class58.Field313.player.posX - ((double)this.Field4483.getX() + 0.5);
        double d4 = d3 * d3 + (d2 = Class58.Field313.player.posY - ((double)this.Field4483.getY() + 0.5) + 1.5) * d2 + (d = Class58.Field313.player.posZ - ((double)this.Field4483.getZ() + 0.5)) * d;
        if (d4 > 36.0) {
            this.Method4824(false);
            return;
        }
        Class58.Field313.player.swingArm(EnumHand.MAIN_HAND);
        EnumFacing enumFacing = EnumFacing.UP;
        if (this.Field4486) {
            enumFacing = few.Method848(this.Field4483, true);
        }
        if (!this.Field4484) {
            this.Field4484 = true;
            Class58.Field313.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.Field4483, enumFacing));
            return;
        }
        Class58.Field313.playerController.onPlayerDamageBlock(this.Field4483, enumFacing);
    }

    public void Method4824(boolean bl) {
        if (this.Field4485 != null) {
            this.Field4485.accept(bl);
            this.Field4485 = null;
        }
        this.Field4482 = null;
        this.Field4483 = BlockPos.ORIGIN;
        this.Field4484 = false;
    }

    public Module Method5755() {
        return this.Field4482;
    }

    public Class58() {
        Pyro.Method8978().Method7915(this);
    }

    public void Method6420(Module module, BlockPos blockPos, boolean bl, Consumer consumer) {
        this.Field4482 = module;
        this.Field4483 = blockPos;
        this.Field4484 = false;
        this.Field4486 = bl;
        this.Field4485 = consumer;
    }
}

