/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 */
package dev.nuker.pyro.alt;

import com.mojang.authlib.GameProfile;
import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"<anonymous>", "", "it", "Lcom/mojang/authlib/GameProfile;", "kotlin.jvm.PlatformType", "test", "dev/nuker/pyro/alt/AltManager$fillProfileAsync$1$1"})
final class AltManager$fillProfileAsync$$inlined$synchronized$lambda$1
implements Predicate {
    final /* synthetic */ GameProfile Field4098;
    final /* synthetic */ Consumer Field4099;

    AltManager$fillProfileAsync$$inlined$synchronized$lambda$1(GameProfile gameProfile, Consumer consumer) {
        this.Field4098 = gameProfile;
        this.Field4099 = consumer;
    }

    public final boolean Method5747(GameProfile it) {
        return it != null && Intrinsics.Method6572(it.getId(), this.Field4098.getId());
    }
}

