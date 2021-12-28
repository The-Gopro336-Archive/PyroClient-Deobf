/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class57;
import dev.nuker.pyro.f0F;
import dev.nuker.pyro.f0G;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f0Y;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f17;
import dev.nuker.pyro.f18;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;

public class f0O
extends f0Y {
    @JvmField
    @NotNull
    public Class57<T> Field5499;
    public String Field5500;
    public T[] Field5501;
    public String Field5502;
    public double Field5503;
    public boolean Field5504;

    @Override
    public int Method7817(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        return f0F2.Method7814().FONT_HEIGHT + 4 + f0H.Field5476 * 2;
    }

    @Override
    public void Method7818(@NotNull f0F f0F2, @NotNull f0H f0H2, @NotNull f17 f172) {
        if (f172.Method7895() == 0) {
            if (f172 instanceof f18) {
                if (!this.Field5504) {
                    this.Method7821(1);
                }
                this.Field5503 = 0.0;
                this.Field5504 = false;
            } else if (f172 instanceof f15) {
                this.Field5504 = true;
                this.Field5503 += ((f15)f172).Method7880();
                int n = (f0F2.Method7813() - f0H.Field5476 * 2) / this.Field5501.length;
                if (this.Field5503 > (double)n) {
                    this.Method7821(1);
                    this.Field5503 = 0.0;
                } else if (this.Field5503 < (double)(-n)) {
                    this.Method7821(-1);
                    this.Field5503 = 0.0;
                }
            }
        }
    }

    public f0O(@NotNull f0o f0o2) {
        super(f0o2);
        this.Field5500 = f0o2.Method5989();
        this.Field5502 = "";
        this.Field5499 = f0o2.Method7976();
        Object object = this.Field5499.Method5264();
        if (object == null) {
            Intrinsics.Method6551();
        }
        ?[] arrobj = ((Enum)object).getClass().getEnumConstants();
        if (arrobj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        T[] arrT = this.Field5501 = (Enum[])arrobj;
        int n = arrT.length;
        for (int i = 0; i < n; ++i) {
            Object t;
            Object t2 = t = arrT[i];
            if (t2 == null) {
                Intrinsics.Method6551();
            }
            if (((Enum)t2).name().length() <= this.Field5502.length()) continue;
            this.Field5502 = ((Enum)t).name();
        }
    }

    @Override
    public void Method7819(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        int n;
        super.Method7819(f0F2, d, d2, f0H2);
        f0J.Method7775(f0J.Field5485, f0F2.Method7814(), this.Field5500, 0, f0H.Field5476, f0F2.Method7813() - 4, f0F2.Method7815() - f0H.Field5476 * 2 - 4, f0G.LEFT, f0H.Field5476, f0H2.Method7708(), false, 512, null);
        FontRenderer fontRenderer = f0F2.Method7814();
        Object object = this.Field5499.Method5264();
        if (object == null) {
            Intrinsics.Method6551();
        }
        f0J.Method7775(f0J.Field5485, fontRenderer, ((Enum)object).name(), 0, f0H.Field5476, f0F2.Method7813() - 4, f0F2.Method7815() - f0H.Field5476 * 2 - 4, f0G.RIGHT, f0H.Field5476, f0H2.Method7708(), false, 512, null);
        int n2 = (f0F2.Method7813() - f0H.Field5476 * 2) / this.Field5501.length;
        Object object2 = this.Field5499.Method5264();
        if (object2 == null) {
            Intrinsics.Method6551();
        }
        int n3 = n2 * ((Enum)object2).ordinal();
        Object object3 = this.Field5499.Method5264();
        if (object3 == null) {
            Intrinsics.Method6551();
        }
        if (((Enum)object3).ordinal() == this.Field5501.length - 1) {
            n = f0F2.Method7813() - f0H.Field5476 * 2;
        } else {
            Object object4 = this.Field5499.Method5264();
            if (object4 == null) {
                Intrinsics.Method6551();
            }
            n = n2 * (((Enum)object4).ordinal() + 1);
        }
        int n4 = n;
        Gui.drawRect((int)f0H.Field5476, (int)(f0F2.Method7815() - f0H.Field5476), (int)(f0F2.Method7813() - f0H.Field5476), (int)(f0F2.Method7815() - f0H.Field5476 - 1), (int)f0H2.Method7708());
        Gui.drawRect((int)(f0H.Field5476 + n3), (int)(f0F2.Method7815() - f0H.Field5476), (int)(f0H.Field5476 + n4), (int)(f0F2.Method7815() - f0H.Field5476 - 1), (int)f0H2.Method7719());
    }

    @Override
    public int Method7820(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        return f0F2.Method7814().getStringWidth(this.Field5500 + "  " + this.Field5502) + f0H.Field5476 * 2;
    }

    public void Method7821(int n) {
        int n2;
        if (this.Field5499.Method5264() == null) {
            Intrinsics.Method6551();
        }
        for (n2 = ((Enum)(v409009)).ordinal() + n; n2 >= this.Field5501.length; n2 -= this.Field5501.length) {
        }
        while (n2 < 0) {
            n2 += this.Field5501.length;
        }
        this.Field5499.Method5266(this.Field5501[n2]);
    }
}

