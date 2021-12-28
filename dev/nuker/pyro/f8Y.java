/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f8v;
import dev.nuker.pyro.f8w;
import dev.nuker.pyro.f8x;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8y
extends Module {
    @NotNull
    public File Field3639 = new File("packetlog.diff");
    @NotNull
    public File Field3640 = new File("packetignore.txt");
    @NotNull
    public List<String> Field3641;
    @NotNull
    public f0o<f8v> Field3642;
    @NotNull
    public BooleanSetting Field3643;
    @Nullable
    public f49 Field3644;
    @Nullable
    public f8v Field3645;

    @Nullable
    public f8v Method5404() {
        return this.Field3645;
    }

    public void Method5405(@Nullable f8v f8v2) {
        this.Field3645 = f8v2;
    }

    @NotNull
    public String Method5364() {
        String string = "";
        boolean bl = false;
        StackTraceElement[] arrstackTraceElement = Thread.currentThread().getStackTrace();
        boolean bl2 = false;
        StackTraceElement[] arrstackTraceElement2 = arrstackTraceElement;
        int n = arrstackTraceElement2.length;
        for (int i = 0; i < n; ++i) {
            StackTraceElement stackTraceElement;
            StackTraceElement stackTraceElement2 = stackTraceElement = arrstackTraceElement2[i];
            boolean bl3 = false;
            if (bl) {
                string = string + stackTraceElement2.getClassName() + '.' + stackTraceElement2.getMethodName() + '\n';
            }
            if (bl) continue;
            if (!Intrinsics.Method6572(stackTraceElement2.getClassName() + '.' + stackTraceElement2.getMethodName(), "net.minecraft.client.network.NetHandlerPlayClient.sendPacket")) continue;
            bl = true;
        }
        return StringsKt.Method11423(string, "\n", null, 2, null);
    }

    @Nullable
    public f49 Method5406() {
        return this.Field3644;
    }

    @NotNull
    public String Method5407(@NotNull String string, @NotNull String string2) {
        return string2 + CollectionsKt.Method3238(StringsKt.Method11518(string, new char[]{'\n'}, false, 0, 6, null), '\n' + string2, null, null, 0, null, null, 62, null) + '\n';
    }

    @NotNull
    public File Method5408() {
        return this.Field3640;
    }

    @NotNull
    public String Method5409(@NotNull Object object) {
        boolean bl;
        Field field;
        Field field2;
        int n;
        int n2;
        Field[] arrfield;
        boolean bl2;
        Field[] arrfield2;
        StackTraceElement[] arrstackTraceElement = Thread.currentThread().getStackTrace();
        Class<?> class_ = object.getClass();
        String string = class_.getName() + " {\n";
        Class<?> class_2 = class_.getSuperclass();
        if (class_2.getSuperclass() != null) {
            string = string + " super = " + class_2.getName() + " {\n";
            arrfield2 = class_2.getDeclaredFields();
            bl2 = false;
            arrfield = arrfield2;
            n2 = arrfield.length;
            for (n = 0; n < n2; ++n) {
                field = field2 = arrfield[n];
                bl = false;
                field.setAccessible(true);
                string = string + "  " + field.getName() + " = " + field.get(object) + '\n';
            }
            string = string + " }\n";
        }
        arrfield2 = class_.getDeclaredFields();
        bl2 = false;
        arrfield = arrfield2;
        n2 = arrfield.length;
        for (n = 0; n < n2; ++n) {
            field = field2 = arrfield[n];
            bl = false;
            field.setAccessible(true);
            string = string + ' ' + field.getName() + " = " + field.get(object) + '\n';
        }
        string = string + "}";
        return string;
    }

    public f8y() {
        super("packetsniffer", "PacketSniffer", null);
        f8y f8y2 = this;
        boolean bl = false;
        List list = CollectionsKt.Method1013();
        f8y2.Field3641 = list;
        this.Field3642 = (f0o)this.Method7264(new f0o("mode", "Mode", null, f8v.MODIFIED));
        this.Field3643 = (BooleanSetting)this.Method7264(new BooleanSetting("trace", "Trace", null, true));
    }

    @NotNull
    public File Method5410() {
        return this.Field3639;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @f0g
    public void Method5411(@NotNull f49 var1_1) {
        if (this.Field3645 == null) {
            return;
        }
        v0 = this.Field3641;
        if (v0 == null) {
            Intrinsics.Method6551();
        }
        if (v0.contains(var1_1.Method5784().getClass().getName())) {
            return;
        }
        v1 = this.Field3645;
        if (v1 == null) {
            return;
        }
        switch (f8x.Field3626[v1.ordinal()]) {
            case 1: {
                v2 = var1_1.Method5619();
                if (v2 == null) {
                    return;
                }
                switch (f8x.Field3625[v2.ordinal()]) {
                    case 1: {
                        if (this.Field3644 != null) {
                            if (((Boolean)this.Field3643.Method7979()).booleanValue()) {
                                this.Method5142(" TRACE:\n" + this.Method5407(this.Method5364(), " "));
                            }
                            v3 = new StringBuilder();
                            v4 = this.Field3644;
                            if (v4 == null) {
                                Intrinsics.Method6551();
                            }
                            this.Method5142(v3.append(this.Method5407(this.Method5409((Object)v4.Method5784()), "-")).append(" \n").toString());
                        }
                        this.Field3644 = var1_1;
                        return;
                    }
                    case 2: {
                        if (this.Field3644 == null) {
                            v5 = null;
                        } else {
                            v6 = this.Field3644;
                            if (v6 == null) {
                                Intrinsics.Method6551();
                            }
                            v5 = this.Method5409((Object)v6.Method5784());
                        }
                        var2_2 = v5;
                        var3_4 = this.Method5409((Object)var1_1.Method5784());
                        var5_6 = var2_2;
                        v7 = var5_6 == null ? f8w.ADDED : (var4_8 = Intrinsics.Method6572(var5_6, var3_4) != false ? f8w.UNCHANGED : f8w.MODIFIED);
                        if (((Boolean)this.Field3643.Method7979()).booleanValue()) {
                            this.Method5142(" TRACE:\n" + this.Method5407(this.Method5364(), " "));
                        }
                        v8 = new StringBuilder();
                        switch (f8x.Field3624[var4_8.ordinal()]) {
                            case 1: {
                                v9 = this.Method5407(var3_4, " ");
                                break;
                            }
                            case 2: {
                                v9 = this.Method5407(var3_4, "+");
                                break;
                            }
                            case 3: {
                                v10 = new StringBuilder();
                                v11 = var2_2;
                                if (v11 == null) {
                                    Intrinsics.Method6551();
                                }
                                v9 = v10.append(this.Method5407(v11, "-")).append(this.Method5407(var3_4, "+")).toString();
                                break;
                            }
                            default: {
                                throw (Throwable)new IllegalStateException();
                            }
                        }
                        this.Method5142(v8.append(v9).append(" \n").toString());
                        this.Field3644 = null;
                        return;
                    }
                }
                return;
            }
            case 2: {
                if (var1_1.Method5619() != f41.Post) return;
                this.Method5142(this.Method5407(this.Method5364(), "-") + this.Method5407(this.Method5409((Object)var1_1.Method5784()), "+") + " \n");
                return;
            }
            case 3: {
                if (var1_1.Method5619() != f41.Post) return;
                if (!StringsKt.Method9998(this.Method5364(), "net.minecraft", false, 2, null)) {
                    this.Method5142(this.Method5407(this.Method5364(), "-") + " \n" + this.Method5407(this.Method5409((Object)var1_1.Method5784()), "+") + " \n");
                    return;
                }
            }
            this.Method5142(this.Method5407(this.Method5364(), "-") + this.Method5407(this.Method5409((Object)var1_1.Method5784()), "+") + " \n");
            return;
            case 4: {
                if (var1_1.Method5619() != f41.Post) return;
                var2_3 = StringsKt.Method11514(this.Method5364(), new String[]{"\n"}, false, 0, 6, null);
                var3_5 = false;
                if (!(var2_3 instanceof Collection) || !((Collection)var2_3).isEmpty()) ** GOTO lbl86
                v12 = false;
                ** GOTO lbl93
lbl86:
                // 2 sources

                for (T var5_7 : var2_3) {
                    var6_10 = (String)var5_7;
                    var7_11 = false;
                    if (!(StringsKt.Method9998(var6_10, "net.minecraft", false, 2, null) == false && StringsKt.Method9998(var6_10, "java", false, 2, null) == false && StringsKt.Method9998(var6_10, "sun", false, 2, null) == false && StringsKt.Method9998(var6_10, "net.minecraftforge", false, 2, null) == false && StringsKt.Method9998(var6_10, "org.multimc", false, 2, null) == false && StringsKt.Method9998(var6_10, "GradleStart", false, 2, null) == false)) continue;
                    v12 = true;
                    ** GOTO lbl93
                }
                v12 = false;
lbl93:
                // 3 sources

                if (v12) {
                    this.Method5142(this.Method5407(this.Method5364(), "-") + " \n" + this.Method5407(this.Method5409((Object)var1_1.Method5784()), "+") + " \n");
                    return;
                }
                ** GOTO lbl100
            }
            ** default:
lbl99:
            // 1 sources

            return;
lbl100:
            // 1 sources

            this.Method5142(this.Method5407(this.Method5364(), "-") + this.Method5407(this.Method5409((Object)var1_1.Method5784()), "+") + " \n");
            return;
        }
    }

    public void Method2393(@Nullable f49 f492) {
        this.Field3644 = f492;
    }

    public void Method4841(@NotNull List list) {
        this.Field3641 = list;
    }

    @NotNull
    public List Method5365() {
        return this.Field3641;
    }

    public void Method5142(@NotNull String string) {
        FilesKt.Method8754(this.Field3639, string, Charsets.Field5722);
    }

    @NotNull
    public f0o Method2419() {
        return this.Field3642;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field3644 = null;
        if (bl) {
            List<String> list;
            f8y f8y2 = this;
            if (this.Field3640.isFile()) {
                list = FilesKt.Method8762(this.Field3640, Charsets.Field5722);
            } else {
                f8y f8y3 = f8y2;
                boolean bl2 = false;
                List list2 = CollectionsKt.Method1013();
                f8y2 = f8y3;
                list = list2;
            }
            f8y2.Field3641 = list;
            this.Field3645 = (f8v)((Object)this.Field3642.Method7979());
            Pyro.Field6182.Method8988("Logging packets to packetlog.diff", false);
            Iterable iterable = this.Field3641;
            boolean bl3 = false;
            if (!iterable.isEmpty()) {
                Pyro.Field6182.Method8988("Ignoring:", false);
                iterable = this.Field3641;
                bl3 = false;
                for (Object e : iterable) {
                    String string = (String)e;
                    boolean bl4 = false;
                    Pyro.Field6182.Method8988(string, false);
                }
            }
            this.Field3639.delete();
            this.Field3639.createNewFile();
            this.Method5142("--- OLD\n+++ NEW\n@@ -1,2 +0,0 @@\n-LOG:\n+LOG:\n");
        }
    }

    @NotNull
    public BooleanSetting Method270() {
        return this.Field3643;
    }
}

