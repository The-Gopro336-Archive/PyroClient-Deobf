/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.util.math.AxisAlignedBB
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4o;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.AxisAlignedBB;

public class f9G
extends Module {
    public DoubleSetting Field3594 = new DoubleSetting("motion", "Motion", null, 1.0, 0.1, 2.0);
    public boolean Field3595;

    public static boolean Method576(Block block) {
        return block instanceof BlockLiquid;
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        block7: {
            block6: {
                if (this.Field5233.player.onGround) {
                    this.Field3595 = false;
                }
                if (this.Field5233.player.motionY > 0.0) {
                    this.Field3595 = true;
                }
                if (feg.Method695(this.Field5233.player.getEntityBoundingBox(), f9G::Method576)) break block6;
                if (!feg.Method695(new AxisAlignedBB(this.Field5233.player.getEntityBoundingBox().maxX, this.Field5233.player.getEntityBoundingBox().maxY, this.Field5233.player.getEntityBoundingBox().maxZ, this.Field5233.player.getEntityBoundingBox().minX, this.Field5233.player.getEntityBoundingBox().minY - 0.01, this.Field5233.player.getEntityBoundingBox().minZ), f9G::Method2485)) break block7;
            }
            return;
        }
        if (!this.Field5233.player.onGround && !this.Field5233.player.movementInput.jump && this.Field5233.player.motionY <= 0.0 && this.Field5233.player.fallDistance <= 1.0f && !this.Field3595) {
            this.Field5233.player.motionY = -((Double)this.Field3594.Method7979()).doubleValue();
        }
    }

    public static boolean Method2485(Block block) {
        return block instanceof BlockLiquid;
    }

    public f9G() {
        super("reverseStep", "ReverseStep", null);
        this.Method7264(this.Field3594);
    }

    @f0g
    @LauncherEventHide
    public void Method545(f4o f4o2) {
        this.Field3595 = true;
    }
}

