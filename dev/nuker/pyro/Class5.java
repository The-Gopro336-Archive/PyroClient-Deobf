/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.arikia.dev.drpc.DiscordRPC;

public class Class5
extends Lambda
implements Function0 {
    public static Class5 Field5307 = new Class5();

    public Object Method945() {
        this.Method2267();
        return Unit.Field4531;
    }

    public Class5() {
        super(0);
    }

    public void Method2267() {
        while (true) {
            DiscordRPC.Method6004();
            Class2.Field5304.Method7338();
            Thread.sleep(1000L);
        }
    }
}

