/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.alt;

import com.mojang.authlib.GameProfile;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltManager;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "it", "Lcom/mojang/authlib/GameProfile;", "accept"})
final class AltManager$getAltProfile$1
implements Consumer {
    final /* synthetic */ Consumer Field72;
    final /* synthetic */ Alt Field73;

    public final void Method129(@NotNull GameProfile it) {
        Intrinsics.Method6567((Object)it, "it");
        Consumer consumer = this.Field72;
        if (consumer != null) {
            consumer.accept(it);
        }
        if (AltManager.Field6702.Method9676().contains(this.Field73) && !this.Field73.Method1432() && Intrinsics.Method6572(this.Field73.Method1436(), it.getName()) ^ true) {
            String string = it.getName();
            Intrinsics.Method6561(string, "it.name");
            this.Field73.Method1437(string);
            AltManager.Field6702.Method9680();
        }
    }

    AltManager$getAltProfile$1(Consumer consumer, Alt alt) {
        this.Field72 = consumer;
        this.Field73 = alt;
    }
}

