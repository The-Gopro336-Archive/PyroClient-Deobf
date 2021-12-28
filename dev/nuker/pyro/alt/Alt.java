/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Charsets
 *  com.mojang.authlib.GameProfile
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.alt;

import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\u0004\u00a8\u0006#"}, d2={"Ldev/nuker/pyro/alt/Alt;", "", "username", "", "(Ljava/lang/String;)V", "email", "password", "uuid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "gameProfile", "Lcom/mojang/authlib/GameProfile;", "getGameProfile", "()Lcom/mojang/authlib/GameProfile;", "isCracked", "", "()Z", "getPassword", "setPassword", "getUsername", "setUsername", "getUuid", "setUuid", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "pyroclient"})
public final class Alt {
    @NotNull
    private String Field919;
    @NotNull
    private String Field920;
    @NotNull
    private String Field921;
    @NotNull
    private String Field922;

    public final boolean Method1432() {
        CharSequence charSequence = this.Field921;
        boolean bl = false;
        return charSequence.length() == 0;
    }

    @NotNull
    public final GameProfile Method1433() {
        CharSequence charSequence = this.Field922;
        boolean bl = false;
        boolean bl2 = charSequence.length() == 0;
        String string = this.Field920;
        UUID uUID = bl2 ? null : UUID.fromString(this.Field922);
        return new GameProfile(uUID, string);
    }

    @NotNull
    public final String Method1434() {
        return this.Field919;
    }

    public final void Method1435(@NotNull String string) {
        Intrinsics.Method6567(string, "<set-?>");
        this.Field919 = string;
    }

    @NotNull
    public final String Method1436() {
        return this.Field920;
    }

    public final void Method1437(@NotNull String string) {
        Intrinsics.Method6567(string, "<set-?>");
        this.Field920 = string;
    }

    @NotNull
    public final String Method1438() {
        return this.Field921;
    }

    public final void Method1439(@NotNull String string) {
        Intrinsics.Method6567(string, "<set-?>");
        this.Field921 = string;
    }

    @NotNull
    public final String Method1440() {
        return this.Field922;
    }

    public final void Method1441(@NotNull String string) {
        Intrinsics.Method6567(string, "<set-?>");
        this.Field922 = string;
    }

    public Alt(@NotNull String email, @NotNull String username, @NotNull String password, @NotNull String uuid) {
        Intrinsics.Method6567(email, "email");
        Intrinsics.Method6567(username, "username");
        Intrinsics.Method6567(password, "password");
        Intrinsics.Method6567(uuid, "uuid");
        this.Field919 = email;
        this.Field920 = username;
        this.Field921 = password;
        this.Field922 = uuid;
    }

    public Alt(@NotNull String username) {
        Intrinsics.Method6567(username, "username");
        String string = "OfflinePlayer:" + username;
        Charset charset = Charsets.UTF_8;
        Intrinsics.Method6561(charset, "Charsets.UTF_8");
        Charset charset2 = charset;
        String string2 = "";
        String string3 = username;
        String string4 = "";
        Alt alt = this;
        boolean bl = false;
        String string5 = string;
        if (string5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] arrby = string5.getBytes(charset2);
        Intrinsics.Method6561(arrby, "(this as java.lang.String).getBytes(charset)");
        byte[] arrby2 = arrby;
        String string6 = UUID.nameUUIDFromBytes(arrby2).toString();
        Intrinsics.Method6561(string6, "UUID.nameUUIDFromBytes(\"\u2026arsets.UTF_8)).toString()");
        alt(string4, string3, string2, string6);
    }

    @NotNull
    public final String Method1442() {
        return this.Field919;
    }

    @NotNull
    public final String Method1443() {
        return this.Field920;
    }

    @NotNull
    public final String Method1444() {
        return this.Field921;
    }

    @NotNull
    public final String Method1445() {
        return this.Field922;
    }

    @NotNull
    public final Alt Method1446(@NotNull String email, @NotNull String username, @NotNull String password, @NotNull String uuid) {
        Intrinsics.Method6567(email, "email");
        Intrinsics.Method6567(username, "username");
        Intrinsics.Method6567(password, "password");
        Intrinsics.Method6567(uuid, "uuid");
        return new Alt(email, username, password, uuid);
    }

    public static /* synthetic */ Alt Method1447(Alt alt, String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 1) != 0) {
            string = alt.Field919;
        }
        if ((n & 2) != 0) {
            string2 = alt.Field920;
        }
        if ((n & 4) != 0) {
            string3 = alt.Field921;
        }
        if ((n & 8) != 0) {
            string4 = alt.Field922;
        }
        return alt.Method1446(string, string2, string3, string4);
    }

    @NotNull
    public String toString() {
        return "Alt(email=" + this.Field919 + ", username=" + this.Field920 + ", password=" + this.Field921 + ", uuid=" + this.Field922 + ")";
    }

    public int hashCode() {
        String string = this.Field919;
        String string2 = this.Field920;
        String string3 = this.Field921;
        String string4 = this.Field922;
        return (((string != null ? string.hashCode() : 0) * 31 + (string2 != null ? string2.hashCode() : 0)) * 31 + (string3 != null ? string3.hashCode() : 0)) * 31 + (string4 != null ? string4.hashCode() : 0);
    }

    public boolean equals(@Nullable Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof Alt)) break block3;
                Alt alt = (Alt)object;
                if (!Intrinsics.Method6572(this.Field919, alt.Field919) || !Intrinsics.Method6572(this.Field920, alt.Field920) || !Intrinsics.Method6572(this.Field921, alt.Field921) || !Intrinsics.Method6572(this.Field922, alt.Field922)) break block3;
            }
            return true;
        }
        return false;
    }
}

