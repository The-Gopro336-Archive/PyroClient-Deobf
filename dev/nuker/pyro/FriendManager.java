/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class12;
import dev.nuker.pyro.FriendManager$Companion;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2={"Ldev/nuker/pyro/FriendManager;", "", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "friends", "", "Ldev/nuker/pyro/Friend;", "getFriends", "()Ljava/util/List;", "setFriends", "(Ljava/util/List;)V", "Companion", "pyroclient"})
public final class FriendManager {
    private boolean Field2142 = true;
    @NotNull
    private List<Class12> Field2143 = new ArrayList();
    @NotNull
    private static FriendManager Field2144;
    public static final FriendManager$Companion Field2145;

    public final boolean Method2779() {
        return this.Field2142;
    }

    public final void Method2780(boolean bl) {
        this.Field2142 = bl;
    }

    @NotNull
    public final List Method2781() {
        return this.Field2143;
    }

    public final void Method2782(@NotNull List list) {
        Intrinsics.Method6567(list, "<set-?>");
        this.Field2143 = list;
    }

    static {
        Field2145 = new FriendManager$Companion(null);
        Field2144 = new FriendManager();
    }

    public static final /* synthetic */ FriendManager Method2783() {
        return Field2144;
    }

    public static final /* synthetic */ void Method2784(FriendManager friendManager) {
        Field2144 = friendManager;
    }

    @JvmStatic
    public static final void Method2785() {
        Field2145.Method8945();
    }
}

