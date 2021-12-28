/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fbQ;
import dev.nuker.pyro.fbT;

public class fbP
implements Runnable {
    public fbQ Field1998;

    public fbP(fbQ fbQ2) {
        this.Field1998 = fbQ2;
    }

    @Override
    public void run() {
        int n = (int)fbT.Method2610((fbT)this.Field1998.Field1938).player.posX;
        int n2 = (int)fbT.Method2610((fbT)this.Field1998.Field1938).player.posY;
        int n3 = (int)fbT.Method2610((fbT)this.Field1998.Field1938).player.posZ;
        int n4 = fbT.Method2610((fbT)this.Field1998.Field1938).gameSettings.renderDistanceChunks * 16;
        fbT.Method2610((fbT)this.Field1998.Field1938).renderGlobal.markBlockRangeForRenderUpdate(n - n4, n2 - n4, n3 - n4, n + n4, n2 + n4, n3 + n4);
    }
}

