/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.launcher;

import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

public class LoadingPluginImpl {
    @NotNull
    public static File Field2879;
    @NotNull
    public static List<String> Field2880;
    public static LoadingPluginImpl Field2881;

    @JvmStatic
    @Nullable
    public static String Method4775() {
        return null;
    }

    static {
        LoadingPluginImpl loadingPluginImpl;
        Field2881 = loadingPluginImpl = new LoadingPluginImpl();
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    public static void Method4776(@NotNull List list, @NotNull File file) {
        void mf;
        List mixins;
        Field2880 = mixins;
        Field2879 = mf;
    }

    @JvmStatic
    @Nullable
    public static String Method4777() {
        return null;
    }

    @JvmStatic
    @Nullable
    public static String Method4778() {
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public void Method4779(@NotNull List list) {
        void <set-?>;
        Field2880 = <set-?>;
    }

    @NotNull
    public List Method4780() {
        List<String> list = Field2880;
        if (list == null) {
            Intrinsics.Method6554("mixins");
        }
        return list;
    }

    @JvmStatic
    @Nullable
    public static String[] Method4781() {
        return new String[]{null};
    }

    @NotNull
    public File Method4782() {
        File file = Field2879;
        if (file == null) {
            Intrinsics.Method6554("mf");
        }
        return file;
    }

    /*
     * WARNING - void declaration
     */
    public void Method4783(@NotNull File file) {
        void <set-?>;
        Field2879 = <set-?>;
    }

    @JvmStatic
    public static void Method4784(@Nullable Map data) {
        MixinBootstrap.Method3899();
        System.out.println("Initialized Mixin Bootstrap");
        MixinEnvironment.Method992().Method981("searge");
        MixinEnvironment.Method992().Method974(MixinEnvironment.Side.CLIENT);
        System.out.println("Loading Pyro Mixin Config");
        Mixins.Method11756("mixins.pyroclient.json");
        System.out.println("Binscure won't save your terrible security solution! - Crystallinqq");
    }
}

