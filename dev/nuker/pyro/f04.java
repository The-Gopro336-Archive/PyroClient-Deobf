/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketTimeUpdate
 *  net.minecraft.util.math.MathHelper
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.math.MathHelper;

public class f04 {
    public long Field5415 = -1L;
    public float[] Field5416 = new float[20];
    public int Field5417;
    public static f04 Field5418 = new f04();

    @f0g
    @LauncherEventHide
    public void Method7641(f4e f4e2) {
        if (f4e2.Method5619() != f41.Pre) {
            return;
        }
        if (f4e2.Method5784() instanceof SPacketTimeUpdate) {
            if (this.Field5415 != -1L) {
                this.Field5416[this.Field5417 % this.Field5416.length] = MathHelper.clamp((float)(20.0f / ((float)(System.currentTimeMillis() - this.Field5415) / 1000.0f)), (float)0.0f, (float)20.0f);
                ++this.Field5417;
            }
            this.Field5415 = System.currentTimeMillis();
        }
    }

    public float Method7642() {
        int n = 0;
        float f = 0.0f;
        for (int i = 0; i < this.Field5416.length; ++i) {
            float f2 = this.Field5416[i];
            if (!(f2 > 0.0f)) continue;
            f += f2;
            ++n;
        }
        return MathHelper.clamp((float)(f / (float)n), (float)0.0f, (float)20.0f);
    }

    public f04() {
        int n = this.Field5416.length;
        for (int i = 0; i < n; ++i) {
            this.Field5416[i] = 0.0f;
        }
        Pyro.Method8978().Method7915(this);
    }
}

