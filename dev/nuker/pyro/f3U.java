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

public class f3U
implements f3X {
    public static f3U Field3903;

    @NotNull
    public Boolean Method5601(@NotNull DataInputStream dataInputStream) {
        return dataInputStream.readBoolean();
    }

    @Override
    public Object Method5602(DataInputStream dataInputStream) {
        return this.Method5601(dataInputStream);
    }

    static {
        f3U f3U2;
        Field3903 = f3U2 = new f3U();
    }

    @Override
    public void Method5603(@NotNull Object object, @NotNull DataOutputStream dataOutputStream) {
        dataOutputStream.writeBoolean((Boolean)object);
    }
}

