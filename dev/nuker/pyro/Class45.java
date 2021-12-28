/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiListExtended
 *  net.minecraft.client.gui.GuiListExtended$IGuiListEntry
 */
package dev.nuker.pyro;

import com.google.common.collect.Lists;
import dev.nuker.pyro.Class46;
import dev.nuker.pyro.Class48;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltManager;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;

public class Class45
extends GuiListExtended {
    public Class48 Field4676;
    public List<Class46> Field4677 = Lists.newArrayList();
    public int Field4678 = -1;

    public Class48 Method6841() {
        return this.Field4676;
    }

    public void Method6842() {
        this.Field4677.clear();
        for (Alt alt : AltManager.Field6702.Method9676()) {
            Alt alt2;
            Class45 class45;
            Class46 class46;
            Class46 class462;
            List<Class46> list;
            try {
                Class46 class463;
                list = this.Field4677;
                class462 = class463;
                class46 = class463;
                class45 = this;
                alt2 = alt;
            }
            catch (Exception exception) {}
            class462(class45, alt2);
            list.add(class46);
        }
    }

    public int getListWidth() {
        return super.getListWidth() + 50;
    }

    public int getSize() {
        return this.Field4677.size();
    }

    public GuiListExtended.IGuiListEntry getListEntry(int n) {
        return this.Method6844(n);
    }

    public void Method6843(int n) {
        this.Field4678 = n;
    }

    public Class46 Method6844(int n) {
        return this.Field4677.get(n);
    }

    public Class45(Class48 class48, Minecraft minecraft, int n, int n2, int n3, int n4, int n5) {
        super(minecraft, n, n2, n3, n4, n5);
        this.Field4676 = class48;
        this.Method6842();
    }

    @Nullable
    public Class46 Method6845() {
        return this.Field4678 >= 0 && this.Field4678 < this.getSize() ? this.Method6844(this.Field4678) : null;
    }

    public int getScrollBarX() {
        return super.getScrollBarX() + 20;
    }

    public boolean isSelected(int n) {
        return n == this.Field4678;
    }
}

