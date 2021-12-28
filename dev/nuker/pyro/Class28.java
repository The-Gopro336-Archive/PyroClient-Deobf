/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdZ;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

public class Class28
implements Consumer {
    public static Class28 Field3192 = new Class28();

    public void Method5105(@Nullable String string) {
        fdZ.Field313.player.sendChatMessage(string);
    }

    public void accept(Object object) {
        this.Method5105((String)object);
    }
}

