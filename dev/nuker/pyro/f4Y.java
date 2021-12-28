/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f4W;
import dev.nuker.pyro.f4X;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class f4Y
extends f4W {
    public static boolean Method5759(String string, Module module) {
        return module.Method7267().equals(string);
    }

    public void Method5760(Module module) {
        this.Field4088.add(new f4X(module));
    }

    public f4Y(String string, float f, float f2) {
        super(string, f, f2);
        this.Method4824(true);
        List<Module> list = Class34.Field4599.Method6756().stream().filter(arg_0 -> f4Y.Method5759(string, arg_0)).collect(Collectors.toList());
        list.sort(Comparator.comparing(Module::Method7265));
        list.forEach(this::Method5760);
    }
}

