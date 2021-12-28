/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.fa1;
import dev.nuker.pyro.fa3;
import dev.nuker.pyro.fa6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.util.math.BlockPos;

public class fa0
extends Lambda
implements Function0 {
    public fa1 Field1596;

    public void Method2267() {
        Collection<BlockPos> collection;
        fa6 fa62 = this.Field1596.Method2271();
        if (fa62 == null) {
            Intrinsics.Method6551();
        }
        Pyro.Field6182.Method8989(fa62.Method2348().name());
        fa6 fa63 = this.Field1596.Method2271();
        if (fa63 == null) {
            Intrinsics.Method6551();
        }
        LinkedList linkedList = fa63.Method2349();
        if (linkedList == null) {
            Intrinsics.Method6551();
        }
        Iterable iterable = linkedList;
        fa1 fa12 = this.Field1596;
        boolean bl = false;
        Iterable iterable2 = iterable;
        Collection collection2 = new ArrayList(CollectionsKt.Method9458(iterable, 10));
        boolean bl2 = false;
        for (Object t : iterable2) {
            fa3 fa32 = (fa3)t;
            collection = collection2;
            boolean bl3 = false;
            BlockPos blockPos = fa32.Method2295();
            collection.add(blockPos);
        }
        collection = (List)collection2;
        Collection collection3 = collection;
        fa12.Method2281(new LinkedList(collection3));
    }

    public fa0(fa1 fa12) {
        this.Field1596 = fa12;
        super(0);
    }

    public Object Method945() {
        this.Method2267();
        return Unit.Field4531;
    }
}

