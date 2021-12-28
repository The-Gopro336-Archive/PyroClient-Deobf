/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f5i;
import dev.nuker.pyro.f6G;
import dev.nuker.pyro.f6H;
import dev.nuker.pyro.fe9;
import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f6I
extends Module {
    public f0o<f6H> Field2994 = new f0o("display", "Display", null, f6H.Notification);
    public IntegerSetting Field2995 = new IntegerSetting("durability", "Durability", null, 40, 0, 100);
    public boolean[] Field2996 = new boolean[]{false, false, false, false};

    public String Method4885(int n) {
        switch (n) {
            case 0: {
                return "Helmet is";
            }
            case 1: {
                return "Chestplate is";
            }
            case 2: {
                return "Leggings are";
            }
            case 3: {
                return "Boots are";
            }
        }
        return null;
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        for (int i = 0; i < 3; ++i) {
            float f = fe9.Method503(i);
            if (f <= (float)((Integer)this.Field2995.Method7979()).intValue()) {
                if (this.Field2996[i]) continue;
                String string = this.Method4885(i);
                String string2 = "Your " + string + " below " + this.Field2995.Method7979() + "%";
                switch (f6G.Field2909[((f6H)((Object)this.Field2994.Method7979())).ordinal()]) {
                    case 1: {
                        f5i.Method4887().Method4886("Alert!", string2, -1234904);
                        Pyro.Field6182.Method8989("Alert! " + string2);
                        break;
                    }
                    case 2: {
                        f5i.Method4887().Method4886("Alert!", string2, -1234904);
                        break;
                    }
                    case 3: {
                        Pyro.Field6182.Method8989("Alert! " + string2);
                        break;
                    }
                }
                this.Field2996[i] = true;
                continue;
            }
            this.Field2996[i] = false;
        }
    }

    public f6I() {
        super("durabilityalert", "DurabilityAlert", "Notifies you if your armor is low.");
        this.Method7264(this.Field2994);
        this.Method7264(this.Field2995);
    }
}

