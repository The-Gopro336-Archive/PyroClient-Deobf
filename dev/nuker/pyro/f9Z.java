/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f9A;
import java.util.function.Consumer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

public class f9z
implements Consumer {
    public f9A Field4495;
    public Entity Field4496;

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }

    public void Method597(EntityPlayerSP entityPlayerSP) {
        f9A.Method5278((f9A)this.Field4495).playerController.attackEntity((EntityPlayer)f9A.Method5278((f9A)this.Field4495).player, this.Field4496);
        f9A.Method5278((f9A)this.Field4495).player.swingArm(EnumHand.MAIN_HAND);
    }

    public f9z(f9A f9A2, Entity entity) {
        this.Field4495 = f9A2;
        this.Field4496 = entity;
    }
}

