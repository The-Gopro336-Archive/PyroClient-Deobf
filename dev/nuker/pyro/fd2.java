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

public class fd2
implements Consumer {
    public fd4 Field163;

    public void Method182(Boolean bl) {
        fd4.Method201(this.Field163, BlockPos.ORIGIN);
    }

    public fd2(fd4 fd42) {
        this.Field163 = fd42;
    }

    public void accept(Object object) {
        this.Method182((Boolean)object);
    }
}

