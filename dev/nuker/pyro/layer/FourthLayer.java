/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.security.NestedClassloader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public class FourthLayer {
    public static FourthLayer Field2296;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static void Method3255(@NotNull LoaderGui var0, @NotNull DataInputStream var1_1, @NotNull DataOutputStream var2_2) {
        so.writeInt(-326653461);
        classloader = new NestedClassloader(FourthLayer.Field2296.getClass().getClassLoader());
        so.writeInt(1210807394);
        $this$readByteArray$iv = si;
        $i$f$readByteArray = false;
        var7_11 = (InputStream)$this$readByteArray$iv;
        length$iv$iv = $this$readByteArray$iv.readInt();
        $i$f$readByteArray = false;
        array$iv$iv = new byte[length$iv$iv];
        for (bytesRead$iv$iv = 0; bytesRead$iv$iv < length$iv$iv && (read$iv$iv = $this$readByteArray$iv$iv.read(array$iv$iv, bytesRead$iv$iv, array$iv$iv.length - bytesRead$iv$iv)) != -1; bytesRead$iv$iv += read$iv$iv) {
        }
        nextBytes = array$iv$iv;
        $i$f$dpkgZip = false;
        $i$f$readByteArray = false;
        map$iv = new LinkedHashMap<K, V>();
        zipIn$iv = new ZipInputStream(new ByteArrayInputStream(nextBytes));
        entry$iv = new Ref.ObjectRef<T>();
        while (true) {
            $i$f$readByteArray = zipIn$iv.getNextEntry();
            array$iv$iv = false;
            bytesRead$iv$iv = 0;
            it$iv = $i$f$readByteArray;
            $i$a$-also-Utils$dpkgZip$1$iv = false;
            entry$iv.Field5552 = it$iv;
            if ($i$f$readByteArray == null) break;
            contents$iv = new byte[4096];
            direct$iv = new Ref.IntRef();
            stream$iv = new ByteArrayOutputStream();
            while (true) {
                it$iv = zipIn$iv.read((byte[])contents$iv, 0, ((byte[])contents$iv).length);
                var13_32 = false;
                var14_35 = false;
                it$iv = it$iv;
                $i$a$-also-Utils$dpkgZip$2$iv = false;
                direct$iv.Field284 = it$iv;
                if (it$iv < 0) break;
                stream$iv.write((byte[])contents$iv, 0, direct$iv.Field284);
            }
            v0 = (ZipEntry)entry$iv.Field5552;
            if (v0 == null) {
                Intrinsics.Method6551();
            }
            map$iv.put(v0.getName(), stream$iv.toByteArray());
            zipIn$iv.closeEntry();
        }
        files$iv = map$iv;
        $i$f$process = false;
        map$iv = false;
        classMap$iv = new LinkedHashMap<K, V>();
        contents$iv = files$iv;
        direct$iv = false;
        stream$iv = contents$iv.entrySet().iterator();
        while (stream$iv.hasNext()) {
            it$iv = map$iv = stream$iv.next();
            var13_32 = false;
            name$iv = (String)it$iv.getKey();
            it$iv = map$iv;
            var13_32 = false;
            bytes$iv = (byte[])it$iv.getValue();
            if (StringsKt.Method10002(name$iv, ".class", false, 2, null)) {
                classMap$iv.put(StringsKt.Method11415(StringsKt.Method9968(name$iv, "/", ".", false, 4, null), ".class", null, 2, null), bytes$iv);
                continue;
            }
            classMap$iv.put(name$iv, bytes$iv);
            PyroClientLoadingPlugin.Field7534.put(name$iv, bytes$iv);
        }
        $this$forEach$iv = classMap$iv;
        $i$f$forEach = false;
        map$iv = $this$forEach$iv;
        classMap$iv = false;
        var9_19 = map$iv.entrySet().iterator();
        while (var9_19.hasNext()) {
            $dstr$name$bytes = element$iv = var9_19.next();
            $i$a$-forEach-FourthLayer$run$1 = false;
            var13_34 = $dstr$name$bytes;
            var14_35 = false;
            name = (String)var13_34.getKey();
            var13_34 = $dstr$name$bytes;
            var14_35 = false;
            bytes = (byte[])var13_34.getValue();
            classloader.Method4761(name, bytes);
        }
        method = classloader.loadClass("dev.nuker.pyro.layer.FifthLayer").getMethod("run", new Class[]{LoaderGui.class, DataInputStream.class, DataOutputStream.class});
        $i$f$forEach = so;
        file$iv = si.readUTF();
        $i$f$getLocal = false;
        v1 = ((ClassLoader)classloader).getResourceAsStream(file$iv);
        if (v1 == null) ** GOTO lbl103
        v2 = ByteStreamsKt.Method5067((InputStream)v1);
        try {
            block16: {
                v1 = v2;
                if (v2 != null) break block16;
lbl103:
                // 2 sources

                v1 = new byte[0];
            }
            var9_19 = v1;
        }
        catch (IOException e$iv) {
            var9_19 = new byte[0];
        }
        bytes$iv = var9_19;
        $i$f$writeByteArray = false;
        $this$writeByteArray$iv.writeInt(((Object)bytes$iv).length);
        $this$writeByteArray$iv.write((byte[])bytes$iv);
        method.invoke(null, new Object[]{gui, si, so});
    }

    static {
        FourthLayer fourthLayer;
        Field2296 = fourthLayer = new FourthLayer();
    }
}

