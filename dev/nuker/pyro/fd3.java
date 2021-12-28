/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fd4;
import java.util.function.Consumer;
import net.minecraft.util.math.BlockPos;

public class fd3
implements Consumer {
    public fd4 Field108;

    public void Method182(Boolean bl) {
        fd4.Method201(this.Field108, BlockPos.ORIGIN);
    }

    public void accept(Object object) {
        this.Method182((Boolean)object);
    }

    public fd3(fd4 fd42) {
        this.Field108 = fd42;
    }
}

