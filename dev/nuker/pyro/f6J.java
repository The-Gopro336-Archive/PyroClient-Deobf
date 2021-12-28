/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BindSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class f6J
extends Module {
    @NotNull
    public BindSetting Field3005 = (BindSetting)this.Method7264(new BindSetting("key", "Key", "Active while holding this key", -1));

    @NotNull
    public BindSetting Method4888() {
        return this.Field3005;
    }

    public f6J() {
        super("fall", "Fall", "Imm falllliiinnggggg......");
    }

    @f0g(value=1)
    @LauncherEventHide
    public void Method559(@NotNull f4p f4p2) {
        block4: {
            block6: {
                BlockPos blockPos;
                block5: {
                    if (!this.Field3005.Method8796()) break block4;
                    this.Field5233.player.motionX = 0.0;
                    this.Field5233.player.motionZ = 0.0;
                    this.Field5233.player.movementInput.moveForward = 0.0f;
                    this.Field5233.player.movementInput.moveStrafe = 0.0f;
                    if (this.Field5233.player.motionY > -0.1) {
                        this.Field5233.player.motionY = -0.1;
                    }
                    blockPos = new BlockPos(this.Field5233.player.getPositionVector());
                    if (this.Field5233.player.getEntityBoundingBox().minX <= (double)blockPos.getX()) break block5;
                    if (this.Field5233.player.getEntityBoundingBox().minZ <= (double)blockPos.getZ()) break block5;
                    if (this.Field5233.player.getEntityBoundingBox().maxX >= (double)(blockPos.getX() + 1)) break block5;
                    EntityPlayerSP entityPlayerSP = this.Field5233.player;
                    if (!(entityPlayerSP.getEntityBoundingBox().maxZ >= (double)(blockPos.getZ() + 1))) break block6;
                }
                double d = (double)blockPos.getX() + 0.5 - this.Field5233.player.posX;
                double d2 = (double)blockPos.getZ() + 0.5 - this.Field5233.player.posZ;
                f4p2.Method5837(d / (double)2);
                f4p2.Method5820(d2 / (double)2);
            }
            f4p2.Method7948();
        }
    }
}

