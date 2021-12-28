/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.Tuple
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class57;
import dev.nuker.pyro.f0F;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0T;
import dev.nuker.pyro.f0U;
import dev.nuker.pyro.f13;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f16;
import dev.nuker.pyro.f17;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.Tuple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0V
implements f13 {
    @JvmField
    @NotNull
    public List<f0F> Field5553;
    @JvmField
    @Nullable
    public f0F Field5554;
    @NotNull
    public Class57<Boolean> Field5555;
    @Nullable
    public f13 Field5556;
    @NotNull
    public List<? extends f13> Field5557;

    @Override
    public void Method7839(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        f13 f132 = this.Field5556;
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        if (f132.Method7838(f0F2, d, d2, f0H2)) {
            f13 f133 = this.Field5556;
            if (f133 == null) {
                Intrinsics.Method6551();
            }
            f0F f0F3 = this.Field5554;
            if (f0F3 == null) {
                Intrinsics.Method6551();
            }
            f133.Method7839(f0F3, d, d2, f0H2);
        }
        if (((Boolean)this.Field5555.Method5264()).booleanValue()) {
            f0F f0F4 = this.Field5554;
            if (f0F4 == null) {
                Intrinsics.Method6551();
            }
            int n = f0F4.Method7815();
            int n2 = ((Collection)this.Field5557).size();
            for (int i = 0; i < n2; ++i) {
                f0F f0F5;
                f13 f134 = this.Field5557.get(i);
                if (this.Field5553.get(i) == null) {
                    Intrinsics.Method6551();
                }
                if (f134.Method7838(f0F2, d, d2 - (double)n, f0H2)) {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((float)1.0f, (float)n, (float)0.0f);
                    f134.Method7839(f0F5, d, d2 - (double)n, f0H2);
                    GlStateManager.popMatrix();
                }
                n += f0F5.Method7815();
            }
        }
    }

    @NotNull
    public Class57 Method7885() {
        return this.Field5555;
    }

    @Override
    public boolean Method7841(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        f13 f132 = this.Field5556;
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        f0F f0F3 = this.Field5554;
        if (f0F3 == null) {
            Intrinsics.Method6551();
        }
        if (f132.Method7841(f0F3, d, d2, f0H2)) {
            return true;
        }
        if (((Boolean)this.Field5555.Method5264()).booleanValue()) {
            f0F f0F4 = this.Field5554;
            if (f0F4 == null) {
                Intrinsics.Method6551();
            }
            int n = f0F4.Method7815();
            int n2 = ((Collection)this.Field5557).size();
            for (int i = 0; i < n2; ++i) {
                f0F f0F5;
                f13 f133 = this.Field5557.get(i);
                if (this.Field5553.get(i) == null) {
                    Intrinsics.Method6551();
                }
                if (f133.Method7841(f0F5, d, d2 - (double)n, f0H2)) {
                    return true;
                }
                n += f0F5.Method7815();
            }
        }
        return false;
    }

    @Override
    public void Method7840(char c, int n) {
        for (f13 f132 : this.Field5557) {
            f132.Method7840(c, n);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void Method7818(@NotNull f0F f0F2, @NotNull f0H f0H2, @NotNull f17 f172) {
        if (f172 instanceof f14 && f172.Method7895() == 1) {
            double d = f172.Method7896();
            f0F f0F3 = this.Field5554;
            if (f0F3 == null) {
                Intrinsics.Method6551();
            }
            if (d < (double)f0F3.Method7815()) {
                this.Field5555.Method5266((Object)((Boolean)this.Field5555.Method5264() == false ? 1 : 0));
                Iterator<? extends f13> iterator2 = this.Field5557.iterator();
                while (true) {
                    if (!iterator2.hasNext()) {
                        f0F2.Method7811();
                        return;
                    }
                    f13 f132 = iterator2.next();
                    f132.Method7837();
                }
            }
        }
        Tuple tuple = this.Method7890(f172 instanceof f15 ? ((f15)f172).Method7875() : (f172 instanceof f16 ? ((f16)f172).Method7879() : f172.Method7896()));
        if (tuple == null) {
            Intrinsics.Method6551();
        }
        Tuple tuple2 = tuple;
        f13 f133 = (f13)((Tuple)tuple2.getFirst()).getFirst();
        Object object = ((Tuple)tuple2.getFirst()).getSecond();
        if (object == null) {
            Intrinsics.Method6551();
        }
        f133.Method7818((f0F)object, f0H2, f172.Method7865(1.0, ((Number)tuple2.getSecond()).intValue()));
        Iterator<? extends f13> iterator3 = this.Field5557.iterator();
        while (iterator3.hasNext()) {
            f13 f134 = iterator3.next();
            if (f134 == (f13)((Tuple)tuple2.getFirst()).getFirst()) continue;
            f134.Method7837();
        }
    }

    public void Method7843(@NotNull Class57 class57) {
        this.Field5555 = class57;
    }

    @Nullable
    public f13 Method7886() {
        return this.Field5556;
    }

    @Override
    public void Method7837() {
        f13 f132 = this.Field5556;
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        f132.Method7837();
        for (f13 f133 : this.Field5557) {
            f133.Method7837();
        }
    }

    public f0V(@Nullable f13 f132, @NotNull List list, @NotNull Class57 class57) {
        this.Field5556 = f132;
        this.Field5557 = list;
        this.Field5553 = new ArrayList();
        this.Field5555 = class57;
    }

    public void Method7824(@NotNull f0F f0F2) {
        this.Field5553.clear();
        int n = ((Collection)this.Field5557).size();
        for (int i = 0; i < n; ++i) {
            this.Field5553.add(new f0F(new f0T(f0F2), f0F2.Method7805(), 0, f0F2.Method7803(), f0F2.Method7814()));
        }
    }

    @Override
    public void Method7842(@NotNull f0F f0F2, @NotNull f0H f0H2, @NotNull f17 f172) {
        double d = f172 instanceof f15 ? ((f15)f172).Method7881() : f172.Method7897();
        double d2 = f172 instanceof f15 ? ((f15)f172).Method7875() : f172.Method7896();
        f13 f132 = this.Field5556;
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        f0F f0F3 = this.Field5554;
        if (f0F3 == null) {
            Intrinsics.Method6551();
        }
        if (f132.Method7841(f0F3, d, d2, f0H2)) {
            f13 f133 = this.Field5556;
            if (f133 == null) {
                Intrinsics.Method6551();
            }
            f133.Method7842(f0F2, f0H2, f172);
        }
        if (((Boolean)this.Field5555.Method5264()).booleanValue()) {
            f0F f0F4 = this.Field5554;
            if (f0F4 == null) {
                Intrinsics.Method6551();
            }
            int n = f0F4.Method7815();
            int n2 = ((Collection)this.Field5557).size();
            for (int i = 0; i < n2; ++i) {
                f0F f0F5;
                f13 f134 = this.Field5557.get(i);
                if (this.Field5553.get(i) == null) {
                    Intrinsics.Method6551();
                }
                if (f134.Method7841(f0F5, d, d2 - (double)n, f0H2)) {
                    f134.Method7842(f0F2, f0H2, f172.Method7865(0.0, n));
                }
                n += f0F5.Method7815();
            }
        }
    }

    @Override
    public boolean Method7838(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        f13 f132 = this.Field5556;
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        f0F f0F3 = this.Field5554;
        if (f0F3 == null) {
            Intrinsics.Method6551();
        }
        if (f132.Method7838(f0F3, d, d2, f0H2)) {
            return true;
        }
        if (((Boolean)this.Field5555.Method5264()).booleanValue()) {
            f0F f0F4 = this.Field5554;
            if (f0F4 == null) {
                Intrinsics.Method6551();
            }
            int n = f0F4.Method7815();
            int n2 = ((Collection)this.Field5557).size();
            for (int i = 0; i < n2; ++i) {
                f0F f0F5;
                f13 f133 = this.Field5557.get(i);
                if (this.Field5553.get(i) == null) {
                    Intrinsics.Method6551();
                }
                if (f133.Method7838(f0F5, d, d2 - (double)n, f0H2)) {
                    return true;
                }
                n += f0F5.Method7815();
            }
        }
        return false;
    }

    @Override
    public int Method7817(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        this.Method7889(f0F2);
        f13 f132 = this.Field5556;
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        f0F f0F3 = this.Field5554;
        if (f0F3 == null) {
            Intrinsics.Method6551();
        }
        int n = f132.Method7817(f0F3, f0H2);
        f0F f0F4 = this.Field5554;
        if (f0F4 == null) {
            Intrinsics.Method6551();
        }
        f0F4.Method7810(n);
        if (((Boolean)this.Field5555.Method5264()).booleanValue()) {
            int n2 = ((Collection)this.Field5557).size();
            for (int i = 0; i < n2; ++i) {
                f13 f133 = this.Field5557.get(i);
                f0F f0F5 = this.Field5553.get(i);
                if (f0F5 == null) {
                    Intrinsics.Method6551();
                }
                int n3 = f133.Method7817(f0F5, f0H2);
                f0F f0F6 = this.Field5553.get(i);
                if (f0F6 == null) {
                    Intrinsics.Method6551();
                }
                f0F6.Method7810(n3);
                n += n3;
            }
        }
        return n;
    }

    public void Method7887(@Nullable f13 f132) {
        this.Field5556 = f132;
    }

    @Override
    public void Method7819(@NotNull f0F f0F2, double d, double d2, @NotNull f0H f0H2) {
        this.Method7889(f0F2);
        f0F f0F3 = this.Field5554;
        if (f0F3 == null) {
            Intrinsics.Method6551();
        }
        f0F3.Method7808(f0F2.Method7814());
        f13 f132 = this.Field5556;
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        f0F f0F4 = this.Field5554;
        if (f0F4 == null) {
            Intrinsics.Method6551();
        }
        f132.Method7819(f0F4, d, d2, f0H2);
        if (((Boolean)this.Field5555.Method5264()).booleanValue()) {
            f0F f0F5 = this.Field5554;
            if (f0F5 == null) {
                Intrinsics.Method6551();
            }
            int n = f0F5.Method7815();
            int n2 = ((Collection)this.Field5557).size();
            for (int i = 0; i < n2; ++i) {
                f0F f0F6;
                f13 f133 = this.Field5557.get(i);
                if (this.Field5553.get(i) == null) {
                    Intrinsics.Method6551();
                }
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)1.0f, (float)n, (float)0.0f);
                f133.Method7819(f0F6, d, d2 - (double)n, f0H2);
                GlStateManager.popMatrix();
                n += f0F6.Method7815();
            }
            f0F f0F7 = this.Field5554;
            if (f0F7 == null) {
                Intrinsics.Method6551();
            }
            Gui.drawRect((int)1, (int)f0F7.Method7815(), (int)2, (int)n, (int)f0H2.Method7719());
        }
    }

    @NotNull
    public List Method7888() {
        return this.Field5557;
    }

    public void Method7889(@NotNull f0F f0F2) {
        if (this.Field5554 == null) {
            this.Field5554 = new f0F(new f0U(f0F2), f0F2.Method7805(), 0, f0F2.Method7803(), f0F2.Method7814());
            this.Method7824(f0F2);
        }
    }

    @Nullable
    public Tuple Method7890(double d) {
        f0F f0F2 = this.Field5554;
        if (f0F2 == null) {
            Intrinsics.Method6551();
        }
        int n = f0F2.Method7815();
        if (d <= (double)n) {
            f13 f132 = this.Field5556;
            if (f132 == null) {
                Intrinsics.Method6551();
            }
            return new Tuple((Object)new Tuple((Object)f132, (Object)this.Field5554), (Object)0);
        }
        int n2 = ((Collection)this.Field5557).size();
        for (int i = 0; i < n2; ++i) {
            f0F f0F3;
            if (this.Field5553.get(i) == null) {
                Intrinsics.Method6551();
            }
            if (!(d <= (double)(n += f0F3.Method7815()))) continue;
            return new Tuple((Object)new Tuple((Object)this.Field5557.get(i), (Object)f0F3), (Object)(n - f0F3.Method7815()));
        }
        return null;
    }

    public void Method7891(@NotNull List list) {
        this.Field5557 = list;
    }

    @Override
    public int Method7820(@NotNull f0F f0F2, @NotNull f0H f0H2) {
        this.Method7889(f0F2);
        f13 f132 = this.Field5556;
        if (f132 == null) {
            Intrinsics.Method6551();
        }
        f0F f0F3 = this.Field5554;
        if (f0F3 == null) {
            Intrinsics.Method6551();
        }
        int n = f132.Method7820(f0F3, f0H2);
        int n2 = ((Collection)this.Field5557).size();
        for (int i = 0; i < n2; ++i) {
            f13 f133 = this.Field5557.get(i);
            f0F f0F4 = this.Field5553.get(i);
            if (f0F4 == null) {
                Intrinsics.Method6551();
            }
            int n3 = f133.Method7820(f0F4, f0H2) + 1;
            if (n3 <= n) continue;
            n = n3;
        }
        return n;
    }
}

