/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.ForgeModContainer
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0w;
import dev.nuker.pyro.fbP;
import dev.nuker.pyro.fbT;
import java.util.function.Consumer;
import net.minecraftforge.common.ForgeModContainer;
import org.jetbrains.annotations.NotNull;

public class fbQ
implements Consumer {
    public fbT Field1938;

    public void accept(Object object) {
        this.Method374((f0w)object);
    }

    public void Method374(@NotNull f0w f0w2) {
        if (((Boolean)this.Field1938.Field5236.Method5264()).booleanValue() && ((Boolean)f0w2.Method7979()).booleanValue()) {
            if (fbT.Method2610((fbT)this.Field1938).world != null) {
                if (fbT.Method2610((fbT)this.Field1938).renderGlobal != null) {
                    fbT.Method2610(this.Field1938).addScheduledTask((Runnable)new fbP(this));
                }
            }
            ForgeModContainer.forgeLightPipelineEnabled = !this.Field1938.Method2622();
        }
    }

    public fbQ(fbT fbT2) {
        this.Field1938 = fbT2;
    }
}

