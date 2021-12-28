/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.f0F;
import dev.nuker.pyro.gui.ClickGui$Window$Module;
import java.util.function.BiFunction;
import kotlin.Metadata;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2={"<anonymous>", "", "x", "", "y", "apply"})
final class ClickGui$Window$Module$buildContexts$3
implements BiFunction {
    final /* synthetic */ ClickGui$Window$Module Field6199;
    final /* synthetic */ int Field6200;

    public final boolean Method9004(double x, double y) {
        if (this.Field6199.Method11362(x, y)) {
            return y > 0.0 && y < (double)((f0F)this.Field6199.Method11344().get(this.Field6200)).Method7815();
        }
        return false;
    }

    ClickGui$Window$Module$buildContexts$3(ClickGui$Window$Module clickGui$Window$Module, int n) {
        this.Field6199 = clickGui$Window$Module;
        this.Field6200 = n;
    }
}

