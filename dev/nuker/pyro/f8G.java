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

import dev.nuker.pyro.f8J;
import java.util.function.Consumer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

public class f8G
implements Consumer {
    public f8J Field3356;
    public Entity Field3357;

    public f8G(f8J f8J2, Entity entity) {
        this.Field3356 = f8J2;
        this.Field3357 = entity;
    }

    public void Method597(EntityPlayerSP entityPlayerSP) {
        f8J.Method5200((f8J)this.Field3356).playerController.interactWithEntity((EntityPlayer)f8J.Method5200((f8J)this.Field3356).player, this.Field3357, EnumHand.MAIN_HAND);
    }

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }
}

