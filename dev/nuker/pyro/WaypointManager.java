/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.Waypoint;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Ldev/nuker/pyro/WaypointManager;", "", "()V", "folder", "Ljava/io/File;", "waypoints", "", "Ldev/nuker/pyro/Waypoint;", "getWaypoints", "()Ljava/util/Collection;", "waypointsMap", "", "", "deleteWaypoint", "", "waypoint", "findNextEmpty", "name", "getExistingFilename", "getFile", "load", "saveWaypoint", "pyroclient"})
public final class WaypointManager {
    private static File Field6775;
    private static Map<String, Waypoint> Field6776;
    public static final WaypointManager Field6777;

    @NotNull
    public final Collection Method9798() {
        return Field6776.values();
    }

    public final void Method9799(@NotNull String folder) {
        Intrinsics.Method6567(folder, "folder");
        File file = Field6775 = new File("pyro/server/" + folder + "/waypoints/");
        if (file == null) {
            Intrinsics.Method6554("folder");
        }
        file.mkdirs();
        Field6776.clear();
        File file2 = Field6775;
        if (file2 == null) {
            Intrinsics.Method6554("folder");
        }
        File[] arrfile = file2.listFiles();
        Intrinsics.Method6561(arrfile, "this.folder.listFiles()");
        File[] $this$forEach$iv = arrfile;
        boolean $i$f$forEach = false;
        File[] arrfile2 = $this$forEach$iv;
        int n = arrfile2.length;
        for (int i = 0; i < n; ++i) {
            File element$iv;
            File file3 = element$iv = arrfile2[i];
            boolean bl = false;
            FileReader fileReader = new FileReader(file3);
            boolean bl2 = false;
            boolean bl3 = false;
            FileReader it = fileReader;
            boolean bl4 = false;
            File file4 = file3;
            Intrinsics.Method6561(file4, "file");
            String string = file4.getName();
            Intrinsics.Method6561(string, "file.name");
            Object object = Pyro.Field6181.fromJson((Reader)it, Waypoint.class);
            Intrinsics.Method6561(object, "Pyro.GSON.fromJson(it, Waypoint::class.java)");
            Field6776.put(string, (Waypoint)object);
            fileReader.close();
        }
    }

    public final void Method9800(@NotNull Waypoint waypoint) {
        String filename;
        Intrinsics.Method6567(waypoint, "waypoint");
        if (Field6776.containsValue(waypoint) && (filename = this.Method9803(waypoint)) != null) {
            Field6776.remove(filename);
            new File(this.Method9802(filename)).delete();
        }
    }

    public final void Method9801(@NotNull Waypoint waypoint) {
        String name;
        String string;
        Intrinsics.Method6567(waypoint, "waypoint");
        if (Field6776.containsValue(waypoint)) {
            string = this.Method9803(waypoint);
            if (string == null) {
                Intrinsics.Method6551();
            }
        } else {
            string = name = this.Method9804(waypoint.Method9897());
        }
        if (!Field6776.containsValue(waypoint)) {
            Field6776.put(name, waypoint);
        }
        FileWriter fileWriter = new FileWriter(this.Method9802(name));
        boolean bl = false;
        boolean bl2 = false;
        FileWriter it = fileWriter;
        boolean bl3 = false;
        Pyro.Field6181.toJson((Object)waypoint, (Appendable)it);
        fileWriter.close();
    }

    private final String Method9802(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = Field6775;
        if (file == null) {
            Intrinsics.Method6554("folder");
        }
        return stringBuilder.append(file).append('/').append(name).append(".json").toString();
    }

    private final String Method9803(Waypoint waypoint) {
        Object v0;
        block1: {
            Iterable $this$firstOrNull$iv = Field6776.entrySet();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Map.Entry it = (Map.Entry)element$iv;
                boolean bl = false;
                if (!Intrinsics.Method6572((Waypoint)it.getValue(), waypoint)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        Object var2_2 = v0;
        boolean bl = false;
        boolean bl2 = false;
        Map.Entry it = var2_2;
        boolean bl3 = false;
        Map.Entry entry = it;
        return entry != null ? (String)entry.getKey() : null;
    }

    @NotNull
    public final String Method9804(@NotNull String name) {
        String string;
        Intrinsics.Method6567(name, "name");
        if (new File(name).exists()) {
            int num = 0;
            while (new File(name + '_' + num).exists()) {
                ++num;
            }
            string = name + '_' + num;
        } else {
            string = name;
        }
        return string;
    }

    private WaypointManager() {
    }

    static {
        WaypointManager waypointManager;
        Field6777 = waypointManager = new WaypointManager();
        boolean bl = false;
        Field6776 = new LinkedHashMap();
    }
}

