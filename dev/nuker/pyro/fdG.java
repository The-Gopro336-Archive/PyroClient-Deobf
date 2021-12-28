/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f00;
import dev.nuker.pyro.fdh;
import dev.nuker.pyro.fe5;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class fdg
implements Consumer {
    public fdh Field362;

    public fdg(fdh fdh2) {
        this.Field362 = fdh2;
    }

    public void Method574(@Nullable BlockPos blockPos) {
        fe5.Field252.Method408(7);
        BlockPos blockPos2 = blockPos;
        if (blockPos2 == null) {
            Intrinsics.Method6551();
        }
        fe5.Field252.Method410(blockPos2, ((f00)this.Field362.Method579().Method7979()).Method7515(), 63);
        fe5.Field252.Method405();
    }

    public void accept(Object object) {
        this.Method574((BlockPos)object);
    }
}

