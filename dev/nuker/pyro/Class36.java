/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class15;
import dev.nuker.pyro.Class16;
import dev.nuker.pyro.Class35;
import dev.nuker.pyro.Class37;
import dev.nuker.pyro.Class38;
import dev.nuker.pyro.Class56;
import dev.nuker.pyro.Class57;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.gui.ClickGui;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Class36 {
    @NotNull
    public Class57<Boolean> Field4602;
    @NotNull
    public Class57<Double> Field4603;
    @NotNull
    public Class57<Double> Field4604;
    @Nullable
    public String Field4605;
    @NotNull
    public List<Module> Field4606;

    public void Method6759(@NotNull Class57 class57) {
        this.Field4602 = class57;
    }

    @NotNull
    public List Method6760() {
        return this.Field4606.stream().filter(Class38.Field4588).collect(Collectors.toList());
    }

    @Nullable
    public String Method6761() {
        return this.Field4605;
    }

    public Class36(@Nullable String string, @NotNull List list) {
        this.Field4605 = string;
        this.Field4606 = list;
        this.Field4602 = new Class56(false, Class15.Field3009);
        this.Field4603 = new Class56(0.0, Class16.Field2952);
        this.Field4604 = new Class56(0.0, Class37.Field4601);
    }

    public void Method6762(@NotNull Class57 class57) {
        this.Field4604 = class57;
    }

    @NotNull
    public List Method6763() {
        return this.Field4606;
    }

    public void Method6764(@NotNull Module module) {
        this.Field4606.add(module);
    }

    @NotNull
    public Class57 Method6765() {
        return this.Field4603;
    }

    @NotNull
    public Class57 Method6766() {
        return this.Field4602;
    }

    public void Method6767(@NotNull List list) {
        this.Field4606 = list;
    }

    public void Method6768(@Nullable String string) {
        this.Field4605 = string;
    }

    public void Method6769(@NotNull ClickGui clickGui) {
        String string = this.Field4605;
        if (string == null) {
            Intrinsics.Method6551();
        }
        clickGui.Method4002(string, new Class35(this), this.Field4603, this.Field4604, this.Field4602);
    }

    public void Method6770(@NotNull Class57 class57) {
        this.Field4603 = class57;
    }

    @NotNull
    public Class57 Method6771() {
        return this.Field4604;
    }

    public Class36(@Nullable String string, Module ... arrmodule) {
        this(string, new ArrayList(Arrays.asList(Arrays.copyOf(arrmodule, arrmodule.length))));
    }
}

