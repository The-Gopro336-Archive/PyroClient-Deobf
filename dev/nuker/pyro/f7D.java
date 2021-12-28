/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$Consumer
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f7E;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;

public class f7D
implements MessagePassingQueue.Consumer {
    public f7E Field3185;

    public void Method5095(Boolean bl) {
        this.Field3185.Field3187.Method5017(true);
    }

    public void Method5096(Object object) {
        this.Method5095((Boolean)object);
    }

    public f7D(f7E f7E2) {
        this.Field3185 = f7E2;
    }
}

