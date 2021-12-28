/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.layer;

import com.formdev.flatlaf.FlatDarculaLaf;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.layer.SecondLayer$run$1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public class SecondLayer {
    public static SecondLayer Field7036;

    static {
        SecondLayer secondLayer;
        Field7036 = secondLayer = new SecondLayer();
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    public static void Method11641(@NotNull DataInputStream dataInputStream, @NotNull DataOutputStream dataOutputStream) {
        DataInputStream si;
        void so;
        FlatDarculaLaf.Method5194();
        LoaderGui gui = new LoaderGui();
        ThreadsKt.Method9564(true, false, null, null, 0, new SecondLayer$run$1((DataOutputStream)so, gui, si), 30, null);
    }
}

