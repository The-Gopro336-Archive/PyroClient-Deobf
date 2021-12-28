/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f9h;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

public class faj {
    @NotNull
    public f9h Field1892;
    @NotNull
    public String Field1893;
    @NotNull
    public String Field1894;

    public void Method2537(boolean bl) {
    }

    public faj(@NotNull f9h f9h2, @NotNull String string, @NotNull String string2) {
        this.Field1892 = f9h2;
        this.Field1893 = string;
        this.Field1894 = string2;
    }

    @NotNull
    public String Method2555() {
        return this.Field1894;
    }

    public Minecraft Method2556() {
        int n = 0;
        return Minecraft.getMinecraft();
    }

    @NotNull
    public f9h Method2557() {
        return this.Field1892;
    }

    @NotNull
    public String Method2558() {
        return this.Field1893;
    }

    @NotNull
    public List Method2460() {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }
}

