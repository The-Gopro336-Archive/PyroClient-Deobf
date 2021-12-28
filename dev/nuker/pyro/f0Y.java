/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class56;
import dev.nuker.pyro.f0F;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f0W;
import dev.nuker.pyro.f0X;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f12;
import dev.nuker.pyro.f13;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f17;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0Y
implements f13 {
    public boolean Field5533;
    @Nullable
    public Class56<Object> Field5534;
    @Nullable
    public f0w<?> Field5535;
    @NotNull
    public static String Field5536 = "Defaults";
    public static f0X Field5537 = new f0X(null);

    @Override
    public void Method7837() {
        f12.Method7828(this);
    }

    @Override
    public void Method7818(@NotNull f0F f0F2, @NotNull f0H f0H2, @NotNull f17 f172) {
        f12.Method7832(this, f0F2, f0H2, f172);
    }

    public void Method7866(@Nullable f0w f0w2) {
        this.Field5535 = f0w2;
    }

    @Override
    public boolean Method7841(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        return this.Field5535 != null && this.Method7838(f0F2, d, d2, f0H2) && d >= (double)(f0F2.Method7813() + f0H.Field5476);
    }

    public void Method7867(@Nullable Class56 class56) {
        this.Field5534 = class56;
    }

    public int Method7868(FontRenderer fontRenderer) {
        int n = f0J.Field5485.Method7776(fontRenderer, "Defaults");
        f0w<?> f0w2 = this.Field5535;
        if (f0w2 == null) {
            Intrinsics.Method6551();
        }
        return Math.max(n, f0J.Field5485.Method7776(fontRenderer, f0w2.Method7969()));
    }

    public f0Y(@Nullable f0w f0w2) {
        Class56 class56;
        this.Field5535 = f0w2;
        if (this.Field5535 != null) {
            f0w<?> f0w3 = this.Field5535;
            if (f0w3 == null) {
                Intrinsics.Method6551();
            }
            class56 = new Class56(f0w3.Method7979(), new f0W(this));
        } else {
            class56 = null;
        }
        this.Field5534 = class56;
    }

    @Override
    public void Method7842(@NotNull f0F f0F2, @NotNull f0H f0H2, @NotNull f17 f172) {
        if (f172 instanceof f14 && f172.Method7895() == 0) {
            if (f172.Method7896() >= (double)f0H.Field5476 && f172.Method7897() >= (double)f0F2.Method7813() && f172.Method7896() <= (double)(f0F2.Method7814().FONT_HEIGHT + f0H.Field5476) && f172.Method7897() <= (double)(f0F2.Method7814().getStringWidth("Defaults") + f0F2.Method7813())) {
                Class56<Object> class56 = this.Field5534;
                if (class56 == null) {
                    Intrinsics.Method6551();
                }
                f0w<?> f0w2 = this.Field5535;
                if (f0w2 == null) {
                    Intrinsics.Method6551();
                }
                class56.Method5266(f0w2.Method7979());
                Class56<Object> class562 = this.Field5534;
                if (class562 == null) {
                    Intrinsics.Method6551();
                }
                f0w<?> f0w3 = this.Field5535;
                if (f0w3 == null) {
                    Intrinsics.Method6551();
                }
                class562.Method5266(f0w3.Method7966());
            }
        }
    }

    @Override
    public void Method7819(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        if (this.Field5535 == null) {
            return;
        }
        if (d >= 0.0 && d2 >= 0.0) {
            if (d <= (double)f0F2.Method7813() && d2 <= (double)f0F2.Method7815()) {
                this.Field5533 = true;
            }
        }
    }

    @Nullable
    public f0w Method7869() {
        return this.Field5535;
    }

    @Override
    public boolean Method7838(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        block5: {
            block6: {
                block7: {
                    if (this.Field5535 == null) {
                        return false;
                    }
                    if (!this.Field5533) break block5;
                    if (!(d2 >= 0.0)) break block6;
                    if (d2 <= (double)f0F2.Method7815() && d >= 0.0) break block7;
                    f0w<?> f0w2 = this.Field5535;
                    if (f0w2 == null) {
                        Intrinsics.Method6551();
                    }
                    int n = f0w2.Method7969() == null ? f0H.Field5476 * 2 + f0F2.Method7814().FONT_HEIGHT : f0H.Field5476 * 2 + 5 + f0F2.Method7814().FONT_HEIGHT * 2;
                    if (!(d2 <= (double)n) || !(d >= (double)(f0F2.Method7813() + f0H.Field5476))) break block6;
                }
                if (d <= (double)(f0F2.Method7813() + this.Method7868(f0F2.Method7814()) + f0H.Field5476 * 3)) break block5;
            }
            this.Field5533 = false;
        }
        return this.Field5533;
    }

    @Override
    public void Method7840(char c, int n) {
        f12.Method7829(this, c, n);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void Method7839(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        double d3 = d;
        if (this.Field5535 == null) {
            return;
        }
        d3 -= (double)f0F2.Method7813();
        int n = this.Method7868(f0F2.Method7814()) + f0H.Field5476 * 2;
        int n2 = f0F2.Method7813() + f0H.Field5476;
        f0w<?> f0w2 = this.Field5535;
        if (f0w2 == null) {
            Intrinsics.Method6551();
        }
        f0J.Method7778(n2, 0, n, f0w2.Method7969() == null ? f0H.Field5476 * 2 + f0F2.Method7814().FONT_HEIGHT : f0H.Field5476 * 4 + f0F2.Method7814().FONT_HEIGHT * 2, f0H2.Method7704(), f0H2.Method7719(), 1);
        f0w<?> f0w3 = this.Field5535;
        if (f0w3 == null) {
            Intrinsics.Method6551();
        }
        if (f0w3.Method7969() != null) {
            Gui.drawRect((int)n2, (int)(f0F2.Method7814().FONT_HEIGHT + f0H.Field5476 * 2), (int)(n2 + n), (int)(f0F2.Method7814().FONT_HEIGHT + f0H.Field5476 * 2 + 1), (int)f0H2.Method7719());
        }
        f0J.Field5485.Method7773(f0F2.Method7814(), "Defaults", n2 += f0H.Field5476, f0H.Field5476 + 1, d2 >= (double)f0H.Field5476 && d3 >= (double)f0H.Field5476 && d2 <= (double)(f0F2.Method7814().FONT_HEIGHT + f0H.Field5476) && d3 <= (double)f0F2.Method7814().getStringWidth("Defaults") ? f0H2.Method7719() : f0H2.Method7708());
        f0w<?> f0w4 = this.Field5535;
        if (f0w4 == null) {
            Intrinsics.Method6551();
        }
        if (f0w4.Method7969() != null) {
            FontRenderer fontRenderer = f0F2.Method7814();
            f0w<?> f0w5 = this.Field5535;
            if (f0w5 == null) {
                Intrinsics.Method6551();
            }
            f0J.Field5485.Method7773(fontRenderer, f0w5.Method7969(), n2, f0F2.Method7814().FONT_HEIGHT + f0H.Field5476 * 3 + 1, f0H2.Method7708());
        }
    }

    @Nullable
    public Class56 Method7870() {
        return this.Field5534;
    }
}

