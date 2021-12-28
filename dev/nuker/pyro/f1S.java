/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f1s {
    @NotNull
    public Map<String, Object> Field3769;

    @NotNull
    public Map Method5487() {
        return this.Field3769;
    }

    public void Method5488(@NotNull Map map) {
        this.Field3769 = map;
    }

    public f1s() {
        Map map;
        f1s f1s2 = this;
        boolean bl = false;
        f1s2.Field3769 = map = (Map)new LinkedHashMap();
    }

    public void Method5489(@Nullable ITextComponent iTextComponent) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("").appendSibling(Pyro.Method8977()).appendSibling(iTextComponent));
    }

    @NotNull
    public f1s Method5490(@NotNull String string, @Nullable Object object) {
        this.Field3769.put(string, object);
        return this;
    }
}

