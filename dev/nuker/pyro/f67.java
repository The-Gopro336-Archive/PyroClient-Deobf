/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.FileUtils
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class29;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Class8;
import dev.nuker.pyro.Config;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.f66;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

public class f67 {
    @NotNull
    public static f66 Field4190;
    public static f67 Field4191;

    public void Method5821() {
        f66 f662;
        if (Config.Field3937.Field3936 != null) {
            File file = new File(Pyro.Field6178, "profiles/" + Config.Field3937.Field3936);
            String string = Config.Field3937.Field3936;
            if (string == null) {
                Intrinsics.Method6551();
            }
            f662 = new f66(file, string);
        } else {
            File file;
            f66 f663 = this.Method5828();
            if ((!f663.Method5809().exists() || !f663.Method5809().isDirectory()) && (file = new File(Pyro.Field6178, "modules")).exists() && file.isDirectory()) {
                this.Method5822();
            }
            f662 = f663;
        }
        this.Method5823(f662);
    }

    public void Method5822() {
        PyroClientLoadingPlugin.Field7533.info("Migrating to profiles system");
        File file = this.Method5828().Method5809();
        FileUtils.copyDirectory((File)new File(Pyro.Field6178, "modules"), (File)new File(file, "modules"));
        if (new File(Pyro.Field6178, "hud.json").exists()) {
            FilesKt.Method10072(new File(Pyro.Field6178, "hud.json"), new File(file, "hud.json"), false, 0, 6, null);
        }
        if (new File(Pyro.Field6178, "hud").exists()) {
            FileUtils.copyDirectory((File)new File(Pyro.Field6178, "hud"), (File)new File(file, "hud"));
        }
    }

    public void Method5823(@NotNull f66 f662) {
        Field4190 = f662;
        Class8.Method4825();
        Class34.Field4599.Method6758();
        Class29.Field3216.Method7300().Method455();
        this.Method5827();
    }

    @NotNull
    public f66 Method5824() {
        return Field4190;
    }

    @NotNull
    public List Method5825() {
        boolean bl = false;
        List list = new ArrayList();
        list.add(this.Method5828());
        File file = new File(Pyro.Field6178, "profiles");
        if (file.exists() && file.isDirectory()) {
            File[] arrfile = file.listFiles();
            boolean bl2 = false;
            File[] arrfile2 = arrfile;
            int n = arrfile2.length;
            for (int i = 0; i < n; ++i) {
                File file2;
                File file3 = file2 = arrfile2[i];
                boolean bl3 = false;
                if (!file3.exists()) continue;
                if (!file3.isDirectory()) continue;
                list.add(new f66(file3, file3.getName()));
            }
        }
        return list;
    }

    @NotNull
    public File Method5826() {
        return new File(Field4190.Method5809(), "hud");
    }

    static {
        f67 f672;
        Field4191 = f672 = new f67();
        Field4190 = f672.Method5828();
    }

    public void Method5827() {
        Config.Field3937.Field3936 = Intrinsics.Method6572(Field4190.Method5810(), "default") ? null : Field4190.Method5810();
        Config.Field3938.Method5382();
    }

    @NotNull
    public f66 Method5828() {
        return new f66(new File(Pyro.Field6178, "profiles/default"), "default");
    }

    @NotNull
    public File Method5829() {
        return new File(Field4190.Method5809(), "modules");
    }
}

