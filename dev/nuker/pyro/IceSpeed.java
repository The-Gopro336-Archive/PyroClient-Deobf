/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IceSpeed
extends Module {
    @NotNull
    public DoubleSetting Field2613 = (DoubleSetting)this.Method7264(new DoubleSetting("speed", "Speed", null, 0.4, 0.1, 0.98, 0.0, 64, null));

    @NotNull
    public DoubleSetting Method238() {
        return this.Field2613;
    }

    public IceSpeed() {
        super("icespeed", "IceSpeed", "Allows you to walk faster on ice, packed ice, and frosted ice");
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (!bl) {
            Blocks.ICE.setDefaultSlipperiness(0.98f);
            Blocks.PACKED_ICE.setDefaultSlipperiness(0.98f);
            Blocks.FROSTED_ICE.setDefaultSlipperiness(0.98f);
        }
    }

    @f0g
    @LauncherEventHide
    public void Method183(@Nullable f4t f4t2) {
        Blocks.ICE.setDefaultSlipperiness((float)((Number)this.Field2613.Method7979()).doubleValue());
        Blocks.PACKED_ICE.setDefaultSlipperiness((float)((Number)this.Field2613.Method7979()).doubleValue());
        Blocks.FROSTED_ICE.setDefaultSlipperiness((float)((Number)this.Field2613.Method7979()).doubleValue());
    }
}

