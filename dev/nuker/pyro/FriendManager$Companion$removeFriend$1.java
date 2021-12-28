/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class12;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=3, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "it", "Ldev/nuker/pyro/Friend;", "test"})
final class FriendManager$Companion$removeFriend$1
implements Predicate {
    final /* synthetic */ String Field4842;

    public final boolean Method2367(@NotNull Class12 it) {
        Intrinsics.Method6567(it, "it");
        return StringsKt.Method9963(it.Method4896(), this.Field4842, true);
    }

    FriendManager$Companion$removeFriend$1(String string) {
        this.Field4842 = string;
    }
}

