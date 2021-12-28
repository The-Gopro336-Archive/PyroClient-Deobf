/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.alt;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltManager$AltStorage;
import dev.nuker.pyro.alt.AltManager$fillProfileAsync$$inlined$synchronized$lambda$1;
import dev.nuker.pyro.alt.AltManager$fillProfileAsync$$inlined$synchronized$lambda$2;
import dev.nuker.pyro.alt.AltManager$fillProfileAsync$$inlined$synchronized$lambda$3;
import dev.nuker.pyro.alt.AltManager$getAltProfile$1;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0017R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Ldev/nuker/pyro/alt/AltManager;", "", "()V", "alts", "", "Ldev/nuker/pyro/alt/Alt;", "getAlts", "()Ljava/util/List;", "filledProfiles", "Lcom/mojang/authlib/GameProfile;", "makeRequestMethod", "Ljava/lang/reflect/Method;", "storage", "Ldev/nuker/pyro/alt/AltManager$AltStorage;", "addAlt", "", "alt", "fillProfileAsync", "profile", "callback", "Ljava/util/function/Consumer;", "getAltProfile", "loadAlts", "", "makeFirst", "removeAlt", "saveAlts", "AltStorage", "pyroclient"})
public final class AltManager {
    private static final Method Field6699;
    private static final List<GameProfile> Field6700;
    private static AltManager$AltStorage Field6701;
    public static final AltManager Field6702;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @NotNull
    public final GameProfile Method9672(@NotNull GameProfile profile, @Nullable Consumer callback) {
        Intrinsics.Method6567((Object)profile, "profile");
        List<GameProfile> list = Field6700;
        boolean bl = false;
        boolean bl2 = false;
        synchronized (list) {
            block6: {
                boolean bl3 = false;
                if (!Field6700.stream().anyMatch(new AltManager$fillProfileAsync$$inlined$synchronized$lambda$1(profile, callback))) break block6;
                Consumer consumer = callback;
                if (consumer != null) {
                    Object element$iv2;
                    Consumer consumer2;
                    block7: {
                        void $this$first$iv;
                        Iterable iterable = Field6700;
                        consumer2 = consumer;
                        boolean $i$f$first = false;
                        for (Object element$iv2 : $this$first$iv) {
                            GameProfile it = (GameProfile)element$iv2;
                            boolean bl4 = false;
                            if (!Intrinsics.Method6572(it.getId(), profile.getId())) continue;
                            break block7;
                        }
                        throw (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    Object t = element$iv2;
                    consumer2.accept(t);
                }
                Object e = Field6700.stream().filter(new AltManager$fillProfileAsync$$inlined$synchronized$lambda$2(profile, callback)).findAny().get();
                Intrinsics.Method6561(e, "filledProfiles.stream().\u2026file.id }.findAny().get()");
                GameProfile gameProfile = (GameProfile)e;
                return gameProfile;
            }
            ThreadsKt.Method9564(true, false, null, null, 0, new AltManager$fillProfileAsync$$inlined$synchronized$lambda$3(profile, callback), 30, null);
            GameProfile gameProfile = profile;
            return gameProfile;
        }
    }

    public static /* synthetic */ GameProfile Method9673(AltManager altManager, GameProfile gameProfile, Consumer consumer, int n, Object object) {
        if ((n & 2) != 0) {
            consumer = null;
        }
        return altManager.Method9672(gameProfile, consumer);
    }

    @NotNull
    public final GameProfile Method9674(@NotNull Alt alt, @Nullable Consumer callback) {
        Intrinsics.Method6567(alt, "alt");
        return this.Method9672(alt.Method1433(), new AltManager$getAltProfile$1(callback, alt));
    }

    public static /* synthetic */ GameProfile Method9675(AltManager altManager, Alt alt, Consumer consumer, int n, Object object) {
        if ((n & 2) != 0) {
            consumer = null;
        }
        return altManager.Method9674(alt, consumer);
    }

    @NotNull
    public final List Method9676() {
        AltManager$AltStorage altManager$AltStorage = Field6701;
        if (altManager$AltStorage == null) {
            Intrinsics.Method6554("storage");
        }
        return altManager$AltStorage.Method114();
    }

    public final boolean Method9677(@NotNull Alt alt) {
        boolean bl;
        Intrinsics.Method6567(alt, "alt");
        if (this.Method9676().contains(alt)) {
            bl = false;
        } else {
            this.Method9676().add(alt);
            this.Method9680();
            bl = true;
        }
        return bl;
    }

    public final void Method9678(@NotNull Alt alt) {
        Intrinsics.Method6567(alt, "alt");
        this.Method9676().remove(alt);
        this.Method9680();
    }

    public final void Method9679(@NotNull Alt alt) {
        Intrinsics.Method6567(alt, "alt");
        this.Method9676().remove(alt);
        this.Method9676().add(0, alt);
        this.Method9680();
    }

    public final void Method9680() {
        try {
            FileWriter writer = new FileWriter("pyro/alts.json");
            AltManager$AltStorage altManager$AltStorage = Field6701;
            if (altManager$AltStorage == null) {
                Intrinsics.Method6554("storage");
            }
            Pyro.Field6181.toJson((Object)altManager$AltStorage, (Appendable)writer);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void Method9681() {
        if (new File("pyro/alts.json").exists()) {
            try {
                FileReader reader = new FileReader("pyro/alts.json");
                Object object = Pyro.Field6181.fromJson((Reader)reader, AltManager$AltStorage.class);
                Intrinsics.Method6561(object, "Pyro.GSON.fromJson(reader, AltStorage::class.java)");
                Field6701 = (AltManager$AltStorage)object;
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Field6701 = new AltManager$AltStorage();
        }
    }

    private AltManager() {
    }

    static {
        Method method;
        AltManager altManager;
        Field6702 = altManager = new AltManager();
        Method method2 = method = YggdrasilAuthenticationService.class.getDeclaredMethod("makeRequest", URL.class, Object.class, Class.class);
        Intrinsics.Method6561(method2, "method");
        method2.setAccessible(true);
        Field6699 = method;
        altManager.Method9681();
        boolean bl = false;
        Field6700 = new ArrayList();
    }

    public static final /* synthetic */ Method Method9682(AltManager $this) {
        AltManager altManager = $this;
        return Field6699;
    }

    public static final /* synthetic */ List Method9683(AltManager $this) {
        AltManager altManager = $this;
        return Field6700;
    }
}

