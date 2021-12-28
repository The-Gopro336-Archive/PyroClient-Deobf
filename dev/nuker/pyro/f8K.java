/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.mixin.CPacketPlayerTryUseItemOnBlockAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;

public class f8k
extends Module {
    @f0g
    @LauncherEventHide
    public void Method2393(f49 f492) {
        CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock;
        if (f492.Method5784() instanceof CPacketPlayerTryUseItemOnBlock && f492.Method5619() == f41.Pre && (cPacketPlayerTryUseItemOnBlock = (CPacketPlayerTryUseItemOnBlock)f492.Method5784()).getPos().getY() >= 255 && cPacketPlayerTryUseItemOnBlock.getDirection() == EnumFacing.UP) {
            ((CPacketPlayerTryUseItemOnBlockAccessor)cPacketPlayerTryUseItemOnBlock).Method6416(EnumFacing.DOWN);
        }
    }

    public f8k() {
        super("maxheightinteract", "MaxHeightInteract", "Allows you to interact with blocks at build height");
    }
}

