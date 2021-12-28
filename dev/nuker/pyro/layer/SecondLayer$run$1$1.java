/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.layer.SecondLayer$run$1$1$handlers$1;
import dev.nuker.pyro.layer.SecondLayer$run$1$1$handlers$2;
import dev.nuker.pyro.layer.SecondLayer$run$1$1$handlers$3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;

public class SecondLayer$run$1$1
extends Lambda
implements Function0 {
    public Ref.ObjectRef Field7046;
    public Thread Field7047;

    /*
     * WARNING - void declaration
     */
    public void Method3860() {
        DiscordEventHandlers handlers2 = new DiscordEventHandlers.Builder().Method6013(new SecondLayer$run$1$1$handlers$1(this)).Method6015(SecondLayer$run$1$1$handlers$2.Field7382).Method6014(SecondLayer$run$1$1$handlers$3.Field7381).Method6019();
        DiscordRPC.Method5998("740056531286098001", handlers2, true);
        int n = 0;
        int n2 = 30;
        while (n <= n2) {
            void i;
            Thread.sleep((long)595741596 ^ 0x23824BF8L);
            DiscordRPC.Method6004();
            if ((String)this.Field7046.Field5552 != null) break;
            ++i;
        }
        DiscordRPC.Method6003();
        this.Field7047.resume();
    }

    public Object Method945() {
        this.Method3860();
        return Unit.Field4531;
    }

    public SecondLayer$run$1$1(Ref.ObjectRef objectRef, Thread thread2) {
        this.Field7046 = objectRef;
        this.Field7047 = thread2;
        super(0);
    }
}

