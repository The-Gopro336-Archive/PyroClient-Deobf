/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fe3;
import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.math.BlockPos;

public class f6r
implements Predicate {
    public CPacketPlayerTryUseItemOnBlock Field3317;

    public boolean Method5155(fe3 fe32) {
        return Intrinsics.Method6572((Object)((BlockPos)fe32.Method465()), (Object)this.Field3317.getPos());
    }

    public f6r(CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock) {
        this.Field3317 = cPacketPlayerTryUseItemOnBlock;
    }

    public boolean test(Object object) {
        return this.Method5155((fe3)object);
    }
}

