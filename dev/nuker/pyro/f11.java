/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class56;
import dev.nuker.pyro.Class57;
import dev.nuker.pyro.f0F;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0O;
import dev.nuker.pyro.f0V;
import dev.nuker.pyro.f0Z;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f10;
import dev.nuker.pyro.f13;
import dev.nuker.pyro.f1c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class f11
extends f0V {
    public List<f13>[] Field5508;
    public List<f0F>[] Field5509;
    public Enum<?> Field5510;

    @Override
    public void Method7819(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        if (this.Field5510 != null) {
            Enum<?> enum_ = this.Field5510;
            if (enum_ == null) {
                Intrinsics.Method6551();
            }
            List<f0F> list = this.Field5509[enum_.ordinal()];
            if (list == null) {
                Intrinsics.Method6551();
            }
            this.Field5553 = list;
            Enum<?> enum_2 = this.Field5510;
            if (enum_2 == null) {
                Intrinsics.Method6551();
            }
            this.Method7891(this.Field5508[enum_2.ordinal()]);
            this.Method7824(f0F2);
            f0F2.Method7811();
            this.Field5510 = null;
        }
        super.Method7819(f0F2, d, d2, f0H2);
    }

    public static void Method7823(f11 f112, Enum enum_) {
        f112.Method7825(enum_);
    }

    public f11(@NotNull f0o f0o2, @NotNull List[] arrlist, @NotNull Class57 class57) {
        super(null, arrlist[((Enum)f0o2.Method7979()).ordinal()], class57);
        this.Method7887(new f0O(f0o2));
        f13 f132 = this.Method7886();
        if (f132 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.ui.control.EnumControl<T>");
        }
        if (((f0O)f132).Method7870() == null) {
            Intrinsics.Method6551();
        }
        ((f0O)f132).Method7870().Field4478 = new f0Z(this);
        if (this.Method7886() == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.ui.control.EnumControl<T>");
        }
        ((f0O)this.Method7886()).Field5499 = new Class56(f0o2.Method7979(), new f1c(this, f0o2));
        this.Field5508 = arrlist;
        this.Field5509 = new List[arrlist.length];
        int n = this.Field5509.length;
        for (int i = 0; i < n; ++i) {
            this.Field5509[i] = new ArrayList();
        }
    }

    @Override
    public int Method7820(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        this.Method7889(f0F2);
        f13 f132 = this.Method7886();
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        f0F f0F3 = this.Field5554;
        if (f0F3 == null) {
            Intrinsics.Method6551();
        }
        int n = f132.Method7820(f0F3, f0H2);
        int n2 = this.Field5508.length;
        for (int i = 0; i < n2; ++i) {
            List<f13> list = this.Field5508[i];
            if (this.Field5509[i] == null) {
                Intrinsics.Method6551();
            }
            int n3 = ((Collection)list).size();
            for (int j = 0; j < n3; ++j) {
                List<f0F> list2;
                f0F f0F4;
                f13 f133 = list.get(j);
                f0F f0F5 = f0F4 = list2.get(j);
                if (f0F5 == null) {
                    Intrinsics.Method6551();
                }
                f0F5.Method7810(f133.Method7817(f0F2, f0H2));
                int n4 = f133.Method7820(f0F4, f0H2) + 1;
                if (n4 <= n) continue;
                n = n4;
            }
        }
        return n;
    }

    @Override
    public void Method7824(@NotNull f0F f0F2) {
        int n = this.Field5508.length;
        for (int i = 0; i < n; ++i) {
            List<f0F> list;
            List<f13> list2 = this.Field5508[i];
            List<f0F> list3 = list = this.Field5509[i];
            if (list3 == null) {
                Intrinsics.Method6551();
            }
            list3.clear();
            int n2 = ((Collection)list2).size();
            for (int j = 0; j < n2; ++j) {
                list.add(new f0F(new f10(f0F2), f0F2.Method7805(), 0, f0F2.Method7803(), f0F2.Method7814()));
            }
        }
        f13 f132 = this.Method7886();
        if (f132 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.ui.control.EnumControl<T>");
        }
        Object object = ((f0O)f132).Field5499.Method5264();
        if (object == null) {
            Intrinsics.Method6551();
        }
        List<f0F> list = this.Field5509[((Enum)object).ordinal()];
        if (list == null) {
            Intrinsics.Method6551();
        }
        this.Field5553 = list;
    }

    public void Method7825(Enum enum_) {
        this.Field5510 = enum_;
    }
}

