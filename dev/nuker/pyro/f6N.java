/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fe5;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class f6N
implements Consumer {
    public static f6N Field2951 = new f6N();

    public void accept(Object object) {
        this.Method574((BlockPos)object);
    }

    public void Method574(@Nullable BlockPos blockPos) {
        fe5.Field252.Method408(7);
        BlockPos blockPos2 = blockPos;
        if (blockPos2 == null) {
            Intrinsics.Method6551();
        }
        fe5.Field252.Method410(blockPos2, 0x3FFF0000, 63);
        fe5.Field252.Method405();
    }
}

