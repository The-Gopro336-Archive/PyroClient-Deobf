/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.FriendManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "it", "", "invoke"})
final class FriendManager$Companion$saveAresFriends$1
extends Lambda
implements Function1 {
    final /* synthetic */ boolean Field2953;
    final /* synthetic */ List Field2954;

    public final void Method1587(@NotNull String it) {
        Intrinsics.Method6567(it, "it");
        if (!this.Field2953 || FriendManager.Field2145.Method8946(it)) {
            this.Field2954.add(it);
        }
    }

    FriendManager$Companion$saveAresFriends$1(boolean bl, List list) {
        this.Field2953 = bl;
        this.Field2954 = list;
        super(1);
    }
}

