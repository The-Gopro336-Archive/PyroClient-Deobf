/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class57;
import java.util.function.Consumer;

public class Class56
extends Class57 {
    public T Field4477;
    public Consumer<T> Field4478;

    @Override
    public Object Method5264() {
        return this.Field4477;
    }

    public Class56(Object object) {
        this(object, null);
    }

    @Override
    public void Method5266(Object object) {
        if (object != this.Field4477) {
            this.Field4477 = object;
            this.Method5263();
        }
    }

    public Class56(Object object, Consumer consumer) {
        this.Field4477 = object;
        this.Field4478 = consumer;
    }

    @Override
    public void Method5263() {
        if (this.Field4478 != null) {
            this.Field4478.accept(this.Field4477);
        }
    }
}

