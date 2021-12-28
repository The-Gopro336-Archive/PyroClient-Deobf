/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f3X;
import dev.nuker.pyro.f3Y;
import dev.nuker.pyro.f4c;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class f3Z {
    public static f3Z Field3928;

    public void Method5625(@NotNull Object object, @NotNull DataOutputStream dataOutputStream) {
        int n;
        Object object2;
        block3: {
            int n2;
            object2 = f3X.Field3948.Method5599();
            boolean bl = false;
            int n3 = 0;
            Iterator iterator2 = object2.iterator();
            while (iterator2.hasNext()) {
                Object e = iterator2.next();
                Pair pair = (Pair)e;
                boolean bl2 = false;
                if (Intrinsics.Method6572((Class)pair.Method998(), object.getClass())) {
                    n2 = n3;
                    break block3;
                }
                ++n3;
            }
            n2 = n = -1;
        }
        if (n == -1) {
            throw (Throwable)new IllegalArgumentException("Invalid data type");
        }
        dataOutputStream.writeInt(n);
        object2 = (Pair)f3X.Field3948.Method5599().get(n);
        ((f3X)((Pair)object2).Method999()).Method5603(object, dataOutputStream);
    }

    @NotNull
    public Object Method5626(@NotNull DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        return ((f3X)((Pair)f3X.Field3948.Method5599().get(n)).Method999()).Method5602(dataInputStream);
    }

    @NotNull
    public f3Y Method5627(@NotNull DataInputStream dataInputStream, @NotNull f4c f4c2) {
        int n = dataInputStream.readInt();
        f3Y f3Y2 = f4c2.Method5764(n);
        int n2 = dataInputStream.readInt();
        int n3 = 0;
        List list = new ArrayList();
        int n4 = n2;
        for (n3 = 0; n3 < n4; ++n3) {
            list.add(this.Method5626(dataInputStream));
        }
        f3Y2.Method5071(list);
        return f3Y2;
    }

    public void Method5628(@NotNull f3Y f3Y2, @NotNull f4c f4c2, @NotNull DataOutputStream dataOutputStream) {
        int n = f4c2.Method5763().indexOf(f3Y2.getClass());
        if (n == -1) {
            throw (Throwable)new IllegalArgumentException("Invalid packet");
        }
        dataOutputStream.writeInt(n);
        List list = f3Y2.Method5070();
        dataOutputStream.writeInt(list.size());
        Iterable iterable = list;
        boolean bl = false;
        Iterator iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            Object t;
            Object t2 = t = iterator2.next();
            boolean bl2 = false;
            Field3928.Method5625(t2, dataOutputStream);
        }
    }

    static {
        f3Z f3Z2;
        Field3928 = f3Z2 = new f3Z();
    }
}

