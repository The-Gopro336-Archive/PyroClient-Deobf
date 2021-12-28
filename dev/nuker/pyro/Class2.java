/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class1;
import dev.nuker.pyro.Class3;
import dev.nuker.pyro.Class4;
import dev.nuker.pyro.Class5;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.PyroStatic;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.callbacks.DisconnectedCallback;
import net.arikia.dev.drpc.callbacks.ErroredCallback;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Class2 {
    public static long Field5302;
    @NotNull
    public static String[] Field5303;
    public static Class2 Field5304;

    public Boolean Method7336() {
        return (Boolean)PyroStatic.Field6421.Field5236.Method5264();
    }

    public long Method7337() {
        return Field5302;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void Method7338() {
        block41: {
            block40: {
                block38: {
                    block39: {
                        block37: {
                            v0 = this.Method7336();
                            v1 = v0;
                            if (v1 == false) return;
                            if (Class2.Field5303[0] == null) ** GOTO lbl22
                            v2 = Class2.Field5303[0];
                            if (v2 != null) break block37;
                            Intrinsics.Method6551();
                        }
                        v3 = v2.length();
                        if (v3 <= 1) ** GOTO lbl22
                        v4 = true;
                        break block39;
lbl22:
                        // 2 sources

                        v4 = var1_1 = false;
                    }
                    if (Class2.Field5303[1] == null) ** GOTO lbl-1000
                    v5 = Class2.Field5303[1];
                    if (v5 != null) break block38;
                    Intrinsics.Method6551();
                }
                v6 = v5.length();
                if (v6 > 1) {
                    v7 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v7 = var2_3 = false;
                }
                if (!var1_1 || !var2_3) ** GOTO lbl41
                v8 = Class2.Field5303[1];
                break block40;
lbl41:
                // 1 sources

                v8 = var3_4 = var2_3 != false ? Class2.Field5303[1] : Class2.Field5303[0];
            }
            if (!var1_1 || !var2_3) ** GOTO lbl47
            v9 = Class2.Field5303[0];
            break block41;
lbl47:
            // 1 sources

            v9 = null;
        }
        var4_5 = v9;
        v10 = v11;
        v12 = v11;
        v13 = var3_4;
        v10(v13);
        v14 = "logo";
        v15 = "https://pyroclient.com";
        v16 = v12.Method12516(v14, v15);
        var5_6 = v16;
        if (var4_5 == null) ** GOTO lbl76
        v17 = var4_5;
        v18 = v17.length();
        if (v18 <= 1) ** GOTO lbl76
        v19 = var5_6;
        v20 = var4_5;
        v19.Method12513(v20);
lbl76:
        // 3 sources

        v21 = var5_6;
        v22 = Class2.Field5302;
        v21.Method12514(v22);
        v23 = var5_6;
        v24 = v23.Method12522();
        try {
            DiscordRPC.Method6005(v24);
            return;
        }
        catch (Throwable var1_2) {
            System.err.println("Could not update discord presence");
        }
    }

    public void Method7339() {
        try {
            DiscordRPC.Method6006();
        }
        catch (Throwable throwable) {
            System.err.println("Could not update discord presence");
        }
    }

    @NotNull
    public String[] Method7340() {
        return Field5303;
    }

    public void Method7341(int n, @Nullable String string) {
        Class2.Field5303[n] = string;
        switch (n) {
            case 0: {
                Config.Field3937.Field3933 = string;
                break;
            }
            case 1: {
                Config.Field3937.Field3934 = string;
            }
        }
        Config.Field3938.Method5382();
    }

    public void Method7342() {
        DiscordEventHandlers.Builder builder;
        DiscordEventHandlers.Builder builder2 = builder;
        DiscordEventHandlers.Builder builder3 = builder;
        builder2();
        ReadyCallback readyCallback = Class3.Field5305;
        DiscordEventHandlers.Builder builder4 = builder3.Method6013(readyCallback);
        ErroredCallback erroredCallback = Class4.Field5306;
        DiscordEventHandlers.Builder builder5 = builder4.Method6015(erroredCallback);
        DisconnectedCallback disconnectedCallback = Class1.Field5301;
        DiscordEventHandlers.Builder builder6 = builder5.Method6014(disconnectedCallback);
        DiscordEventHandlers discordEventHandlers = builder6.Method6019();
        Object object3 = discordEventHandlers;
        String string = "740056531286098001";
        Object object2 = object3;
        boolean bl = true;
        DiscordRPC.Method5998(string, (DiscordEventHandlers)object2, bl);
        Class2.Field5303[0] = Config.Field3937.Field3933;
        Class2.Field5303[1] = Config.Field3937.Field3934;
        boolean bl2 = true;
        boolean bl3 = false;
        ClassLoader classLoader = null;
        String string2 = null;
        int n = 0;
        Function0 function0 = Class5.Field5307;
        int n2 = 30;
        Object v20 = null;
        ThreadsKt.Method9564(bl2, bl3, classLoader, string2, n, function0, n2, v20);
        try {
        }
        catch (Throwable object3) {
            System.err.println("Could not initialize discord");
        }
    }

    static {
        Class2 class2;
        Field5304 = class2 = new Class2();
        Field5302 = System.currentTimeMillis();
        Field5303 = new String[]{null, null};
    }

    public void Method7343() {
        this.Method7338();
    }
}

