/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class57;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.f0F;
import dev.nuker.pyro.f0G;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f0Y;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f16;
import dev.nuker.pyro.f17;
import dev.nuker.pyro.f18;
import java.awt.Color;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.Gui;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0M
extends f0Y {
    @JvmField
    @Nullable
    public String Field5520;
    @JvmField
    @Nullable
    public Class57<Double> Field5521;
    @JvmField
    public double Field5522;
    @JvmField
    public double Field5523;
    @JvmField
    public double Field5524;
    public int Field5525;
    public boolean Field5526;
    @JvmField
    public int Field5527 = -1;
    @JvmField
    @Nullable
    public String Field5528;
    @JvmField
    public boolean Field5529;

    @Override
    public void Method7818(@NotNull f0F f0F2, @NotNull f0H f0H2, @NotNull f17 f172) {
        if (f172 instanceof f16 && f172.Method7895() == 0) {
            Class57<Double> class57 = this.Field5521;
            if (class57 == null) {
                Intrinsics.Method6551();
            }
            Object object = StringCompanionObject.Field4618;
            String string = "%.5f";
            Object[] arrobject = new Object[1];
            Class57<Double> class572 = this.Field5521;
            if (class572 == null) {
                Intrinsics.Method6551();
            }
            arrobject[0] = class572.Method5264();
            Object[] arrobject2 = arrobject;
            double d = this.Field5522;
            double d2 = this.Field5523;
            Class57<Double> class573 = class57;
            boolean bl = false;
            String string2 = String.format(string, Arrays.copyOf(arrobject2, arrobject2.length));
            object = string2;
            boolean bl2 = false;
            double d3 = Double.parseDouble((String)object);
            class573.Method5266((Object)Math.min(d2, Math.max(d, d3)));
        } else if (f172 instanceof f15 && f172.Method7895() == 0) {
            double d;
            Class57<Double> class57 = this.Field5521;
            if (class57 == null) {
                Intrinsics.Method6551();
            }
            if ((d = ((Number)class57.Method5264()).doubleValue() + ((f15)f172).Method7880() / ((double)(f0F2.Method7813() - f0H.Field5476 * 2) / this.Field5524)) > this.Field5523) {
                d = this.Field5523;
            } else if (d < this.Field5522) {
                d = this.Field5522;
            }
            Class57<Double> class574 = this.Field5521;
            if (class574 == null) {
                Intrinsics.Method6551();
            }
            if (Intrinsics.Method6575(d, (Double)class574.Method5264()) ^ true) {
                Class57<Double> class575 = this.Field5521;
                if (class575 == null) {
                    Intrinsics.Method6551();
                }
                class575.Method5266((Object)d);
            }
            this.Field5527 = -1;
            this.Field5528 = null;
        } else if (f172 instanceof f18 && !(f172 instanceof f16) && f172.Method7895() == 0) {
            if (this.Field5527 == -1) {
                this.Field5527 = 0;
                Class57<Double> class57 = this.Field5521;
                if (class57 == null) {
                    Intrinsics.Method6551();
                }
                this.Field5528 = Double.toString(((Number)class57.Method5264()).doubleValue());
            } else {
                this.Method7836();
            }
        }
    }

    @Override
    public int Method7820(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        return f0F2.Method7814().getStringWidth(this.Field5520 + " XX.XXX") + f0H.Field5476 * 2;
    }

    @NotNull
    public String Method7846() {
        String string;
        if (this.Field5528 != null) {
            string = this.Field5528;
        } else {
            Class57<Double> class57 = this.Field5521;
            if (class57 == null) {
                Intrinsics.Method6551();
            }
            string = this.Method7834(((Number)class57.Method5264()).doubleValue());
        }
        if (string == null) {
            Intrinsics.Method6551();
        }
        String string2 = string;
        if (this.Field5527 != -1) {
            String string3 = string2;
            int n = 0;
            int n2 = this.Field5527;
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl = false;
            String string4 = string3;
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string5 = string4.substring(n, n2);
            string3 = string2;
            n = this.Field5527;
            n2 = string2.length();
            stringBuilder = stringBuilder.append(string5).append(this.Field5526 ? "|" : ":");
            bl = false;
            String string6 = string3;
            if (string6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string5 = string6.substring(n, n2);
            string2 = stringBuilder.append(string5).toString();
        }
        return string2;
    }

    @Override
    public void Method7837() {
        this.Field5527 = -1;
        this.Field5528 = null;
        this.Field5529 = false;
    }

    public f0M(@Nullable f0w f0w2) {
        super(f0w2);
    }

    public int Method7859() {
        return this.Field5525;
    }

    @Override
    public void Method7819(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        super.Method7819(f0F2, d, d2, f0H2);
        f0J.Method7775(f0J.Field5485, f0F2.Method7814(), this.Field5520, 0, f0H.Field5476, f0F2.Method7813() - 4, f0F2.Method7815() - f0H.Field5476 * 2 - 4, f0G.LEFT, f0H.Field5476, f0H2.Method7708(), false, 512, null);
        f0J.Method7775(f0J.Field5485, f0F2.Method7814(), this.Method7846(), 0, f0H.Field5476, f0F2.Method7813() - 4, f0F2.Method7815() - f0H.Field5476 * 2 - 4, f0G.RIGHT, f0H.Field5476, this.Field5527 == -1 ? f0H2.Method7708() : (this.Field5529 ? Color.RED.getRGB() : f0H2.Method7702()), false, 512, null);
        double d3 = f0F2.Method7813() - f0H.Field5476 * 2;
        Class57<Double> class57 = this.Field5521;
        if (class57 == null) {
            Intrinsics.Method6551();
        }
        int n = (int)(d3 * ((((Number)class57.Method5264()).doubleValue() - this.Field5522) / (this.Field5523 - this.Field5522)));
        Gui.drawRect((int)f0H.Field5476, (int)(f0F2.Method7815() - f0H.Field5476), (int)(n + f0H.Field5476), (int)(f0F2.Method7815() - f0H.Field5476 - 1), (int)f0H2.Method7719());
        Gui.drawRect((int)(f0H.Field5476 + n), (int)(f0F2.Method7815() - f0H.Field5476), (int)(f0F2.Method7813() - f0H.Field5476), (int)(f0F2.Method7815() - f0H.Field5476 - 1), (int)f0H2.Method7708());
        int n2 = this.Field5525;
        this.Field5525 = n2 + 1;
        if (this.Field5525 >= 20) {
            this.Field5525 = 0;
            this.Field5526 = !this.Field5526;
        }
    }

    public boolean Method7860() {
        return this.Field5526;
    }

    public void Method7836() {
        try {
            Double d = Double.valueOf(this.Field5528);
            if (d >= this.Field5522 && d <= this.Field5523) {
                Class57<Double> class57 = this.Field5521;
                if (class57 == null) {
                    Intrinsics.Method6551();
                }
                class57.Method5266((Object)d);
                this.Field5528 = null;
            } else {
                this.Field5529 = true;
            }
        }
        catch (NumberFormatException numberFormatException) {
            this.Field5529 = true;
        }
        if (!this.Field5529) {
            this.Field5527 = -1;
        }
    }

    public f0M(@NotNull DoubleSetting doubleSetting) {
        super(doubleSetting);
        this.Field5520 = doubleSetting.Method5989();
        this.Field5521 = doubleSetting.Method7976();
        this.Field5522 = doubleSetting.Method12508();
        this.Field5523 = doubleSetting.Method12511();
        this.Field5524 = doubleSetting.Method12507();
    }

    public void Method7861(boolean bl) {
        this.Field5526 = bl;
    }

    @Nullable
    public String Method7834(double d) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
        String string = "%.3f";
        Object[] arrobject = new Object[]{d};
        boolean bl = false;
        return String.format(string, Arrays.copyOf(arrobject, arrobject.length));
    }

    public void Method7821(int n) {
        this.Field5525 = n;
    }

    @Override
    public int Method7817(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        return f0F2.Method7814().FONT_HEIGHT + 4 + f0H.Field5476 * 2;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void Method7840(char c, int n) {
        if (this.Field5527 == -1) return;
        if (this.Field5529) {
            this.Field5529 = false;
        }
        if (n == 205) {
            String string = this.Field5528;
            if (string == null) {
                Intrinsics.Method6551();
            }
            if (this.Field5527 < string.length()) {
                int n2 = this.Field5527;
                this.Field5527 = n2 + 1;
                return;
            }
        }
        if (n == 203 && this.Field5527 > 0) {
            int n3 = this.Field5527;
            this.Field5527 = n3 + -1;
            return;
        }
        if (n == 28) {
            this.Method7836();
            return;
        }
        if (n == 14) {
            if (this.Field5527 <= 0) return;
            StringBuilder stringBuilder = new StringBuilder();
            String string = this.Field5528;
            if (string == null) {
                Intrinsics.Method6551();
            }
            String string2 = string;
            int n4 = 0;
            int n5 = this.Field5527 - 1;
            StringBuilder stringBuilder2 = stringBuilder;
            f0M f0M2 = this;
            boolean bl = false;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.substring(n4, n5);
            StringBuilder stringBuilder3 = stringBuilder2.append(string4);
            String string5 = this.Field5528;
            if (string5 == null) {
                Intrinsics.Method6551();
            }
            string2 = string5;
            n4 = this.Field5527;
            stringBuilder2 = stringBuilder3;
            n5 = 0;
            String string6 = string2;
            if (string6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string4 = string6.substring(n4);
            f0M2.Field5528 = stringBuilder2.append(string4).toString();
            int n6 = this.Field5527;
            this.Field5527 = n6 + -1;
            return;
        }
        if (n == 211) {
            String string = this.Field5528;
            if (string == null) {
                Intrinsics.Method6551();
            }
            if (this.Field5527 >= string.length()) return;
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = this.Field5528;
            if (string7 == null) {
                Intrinsics.Method6551();
            }
            String string8 = string7;
            int n7 = 0;
            int n8 = this.Field5527;
            StringBuilder stringBuilder4 = stringBuilder;
            f0M f0M3 = this;
            boolean bl = false;
            String string9 = string8;
            if (string9 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string10 = string9.substring(n7, n8);
            StringBuilder stringBuilder5 = stringBuilder4.append(string10);
            String string11 = this.Field5528;
            if (string11 == null) {
                Intrinsics.Method6551();
            }
            string8 = string11;
            n7 = this.Field5527 + 1;
            stringBuilder4 = stringBuilder5;
            n8 = 0;
            String string12 = string8;
            if (string12 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string10 = string12.substring(n7);
            f0M3.Field5528 = stringBuilder4.append(string10).toString();
            return;
        }
        if (c == '\u0000') return;
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.Field5528;
        if (string == null) {
            Intrinsics.Method6551();
        }
        String string13 = string;
        int n9 = 0;
        int n10 = this.Field5527;
        StringBuilder stringBuilder6 = stringBuilder;
        f0M f0M4 = this;
        boolean bl = false;
        String string14 = string13;
        if (string14 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string15 = string14.substring(n9, n10);
        StringBuilder stringBuilder7 = stringBuilder6.append(string15).append(c);
        String string16 = this.Field5528;
        if (string16 == null) {
            Intrinsics.Method6551();
        }
        string13 = string16;
        n9 = this.Field5527;
        stringBuilder6 = stringBuilder7;
        n10 = 0;
        String string17 = string13;
        if (string17 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        string15 = string17.substring(n9);
        f0M4.Field5528 = stringBuilder6.append(string15).toString();
        int n11 = this.Field5527;
        this.Field5527 = n11 + 1;
    }
}

