/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f3X;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.jetbrains.annotations.NotNull;

public class f3V
implements f3X {
    public static f3V Field3941;

    @Override
    public void Method5603(@NotNull Object object, @NotNull DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt((Integer)object);
    }

    @Override
    public Object Method5602(DataInputStream dataInputStream) {
        return this.Method5634(dataInputStream);
    }

    static {
        f3V f3V2;
        Field3941 = f3V2 = new f3V();
    }

    @NotNull
    public Integer Method5634(@NotNull DataInputStream dataInputStream) {
        return dataInputStream.readInt();
    }
}

