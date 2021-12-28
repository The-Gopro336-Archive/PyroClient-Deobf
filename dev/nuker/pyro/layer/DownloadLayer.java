/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.nuker.pyro.layer.DownloadLayer$run$6
 *  net.minecraft.launchwrapper.Launch
 *  net.minecraft.launchwrapper.LaunchClassLoader
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.Config;
import dev.nuker.pyro.launcher.LibraryCache$DownloadFile;
import dev.nuker.pyro.launcher.LibraryCache$GradleResource;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.layer.DLBHash;
import dev.nuker.pyro.layer.DownloadLayer;
import dev.nuker.pyro.layer.DownloadLayer$run$1;
import dev.nuker.pyro.layer.DownloadLayer$run$2;
import dev.nuker.pyro.layer.DownloadLayer$run$4$1;
import dev.nuker.pyro.layer.ThirdLayer;
import dev.nuker.pyro.security.Clientfiles;
import dev.nuker.pyro.security.EncryptedStreamWrapper;
import dev.nuker.pyro.security.Encryption;
import dev.nuker.pyro.security.UtilsKt$hexString$1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

public class DownloadLayer {
    public static DownloadLayer Field7087;

    static {
        DownloadLayer downloadLayer;
        Field7087 = downloadLayer = new DownloadLayer();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static void Method11715(@NotNull LoaderGui var0, @NotNull DataInputStream var1_1, @NotNull DataOutputStream var2_2) {
        block84: {
            gui.Method12440(Double.longBitsToDouble(Double.doubleToLongBits(-0.6959772356406465) ^ 9218381843424528695L));
            var3_3 = new Ref.BooleanRef();
            var3_3.Field4235 = false;
            var5_4 = false;
            channelMap = new LinkedHashMap<K, V>();
            channelCount = si.readInt();
            var6_6 = 0;
            var7_8 = channelCount;
            while (var6_6 < var7_8) {
                name = si.readUTF();
                versionCount = si.readInt();
                var11_16 = new String[versionCount];
                var12_21 = 0;
                while (var12_21 < versionCount) {
                    var13_27 = var12_21;
                    var57_39 = var12_21++;
                    var56_38 = var11_16;
                    $i$a$-<init>-DownloadLayer$run$versionMap$1 = false;
                    var56_38[var57_39] = var58_40 = si.readUTF();
                }
                versionMap = var11_16;
                channelMap.put(name, versionMap);
                ++i;
            }
            i = new Ref.ObjectRef<T>();
            i.Field5552 = Config.Field7637.Field7640;
            if (!channelMap.containsKey((String)currentChannel.Field5552)) {
                currentChannel.Field5552 = (String)CollectionsKt.Method3069((Iterable)channelMap.keySet());
            }
            var7_9 = new Ref.ObjectRef<T>();
            v0 = channelMap.get((String)currentChannel.Field5552);
            if (v0 == null) {
                Intrinsics.Method6551();
            }
            var7_9.Field5552 = ((String[])v0)[0];
            gui.Method12446(gui.Method12445("Loading", channelMap, new DownloadLayer$run$1((Ref.BooleanRef)shouldStop, (Ref.ObjectRef)currentChannel, (Ref.ObjectRef)currentVersion), new DownloadLayer$run$2((Ref.BooleanRef)shouldStop, (Ref.ObjectRef)currentChannel, (Ref.ObjectRef)currentVersion)));
            versionCount = LaunchClassLoader.class.getDeclaredField("resourceCache");
            versionMap = false;
            var11_17 = false;
            it = versionCount;
            $i$a$-also-DownloadLayer$run$resourceCache$1 = 0;
            it.setAccessible(true);
            v1 = versionCount.get((Object)Launch.classLoader);
            if (v1 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.ByteArray>");
            }
            resourceCache = TypeIntrinsics.Method5573(v1);
            versionMap = stream = new EncryptedStreamWrapper((DataInputStream)si, (DataOutputStream)so);
            key$iv = DLBHash.Field3824.Method5514();
            $i$f$setKey = false;
            v2 = new byte[11];
            v2[0] = 32;
            v2[1] = 120;
            v2[2] = 45;
            v2[3] = 34;
            v2[4] = 66;
            v2[5] = 43;
            v2[6] = 87;
            v2[7] = 54;
            v3 = this_$iv;
            $i$a$-also-DownloadLayer$run$resourceCache$1 = v3.Method8438();
            v3.Method8431((byte)($i$a$-also-DownloadLayer$run$resourceCache$1 + 1));
            v2[8] = $i$a$-also-DownloadLayer$run$resourceCache$1;
            v2[9] = 16;
            v2[10] = 86;
            this_$iv.Method8444(v2);
            v4 = Encryption.Field4545.Method6540(12);
            if (v4 == null) {
                Intrinsics.Method6551();
            }
            this_$iv.Method8440(v4);
            $i$a$-also-DownloadLayer$run$resourceCache$1 = key$iv;
            $i$a$-<init>-DownloadLayer$run$versionMap$1 = Encryption.Field4545;
            var15_41 = this_$iv;
            $i$f$hexString = false;
            var17_53 = ArraysKt.Method11276((byte[])$this$hexString$iv$iv, "", null, null, 0, null, UtilsKt$hexString$1.Field3792, 30, null);
            $this$hexString$iv$iv = var17_53;
            $i$f$hexString = false;
            v5 = $this$hexString$iv$iv;
            if (v5 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            var17_53 = v5.toCharArray();
            v6 = $i$a$-<init>-DownloadLayer$run$versionMap$1.Method6537((char[])var17_53, this_$iv.Method8436());
            if (v6 == null) {
                Intrinsics.Method6551();
            }
            var15_41.Method8432(v6);
            this_$iv = stream;
            $i$f$readByteArray = false;
            $this$readByteArray$iv$iv = this_$iv.Method8437();
            $i$f$readByteArray = false;
            $i$a$-<init>-DownloadLayer$run$versionMap$1 = $this$readByteArray$iv$iv;
            length$iv$iv$iv = $this$readByteArray$iv$iv.readInt();
            $i$f$readByteArray = false;
            array$iv$iv$iv = new byte[length$iv$iv$iv];
            for (bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < length$iv$iv$iv && (read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(array$iv$iv$iv, bytesRead$iv$iv$iv, ~(bytesRead$iv$iv$iv + ~array$iv$iv$iv.length))) != -1; bytesRead$iv$iv$iv += read$iv$iv$iv) {
            }
            encrypted$iv = array$iv$iv$iv;
            bytes$iv = Encryption.Field4545.Method6539(encrypted$iv, this_$iv.Method8442());
            $i$f$dpkgZip = false;
            $this$readByteArray$iv$iv = false;
            map$iv = new LinkedHashMap<K, V>();
            zipIn$iv = new ZipInputStream(new ByteArrayInputStream(bytes$iv));
            entry$iv = new Ref.ObjectRef<T>();
            while (true) {
                length$iv$iv$iv = zipIn$iv.getNextEntry();
                $i$f$readByteArray = false;
                array$iv$iv$iv = false;
                it$iv = length$iv$iv$iv;
                $i$a$-also-Utils$dpkgZip$1$iv = false;
                entry$iv.Field5552 = it$iv;
                if (length$iv$iv$iv == null) break;
                contents$iv = new byte[4096];
                direct$iv = new Ref.IntRef();
                stream$iv = new ByteArrayOutputStream();
                while (true) {
                    it$iv = zipIn$iv.read(contents$iv, 0, contents$iv.length);
                    $i$a$-also-Utils$dpkgZip$1$iv = false;
                    encrypted$iv = false;
                    it$iv = it$iv;
                    $i$a$-also-Utils$dpkgZip$2$iv = false;
                    direct$iv.Field284 = it$iv;
                    if (it$iv < 0) break;
                    stream$iv.write(contents$iv, 0, direct$iv.Field284);
                }
                v7 = (ZipEntry)entry$iv.Field5552;
                if (v7 == null) {
                    Intrinsics.Method6551();
                }
                map$iv.put(v7.getName(), stream$iv.toByteArray());
                zipIn$iv.closeEntry();
            }
            $this$forEach$iv = map$iv;
            $i$f$forEach = false;
            zipIn$iv = $this$forEach$iv;
            map$iv = false;
            entry$iv = zipIn$iv.entrySet().iterator();
            while (entry$iv.hasNext()) {
                $dstr$name$data = element$iv = (Map.Entry)entry$iv.next();
                $i$a$-forEach-DownloadLayer$run$3 = false;
                it$iv = $dstr$name$data;
                $i$a$-also-Utils$dpkgZip$1$iv = false;
                name = (String)it$iv.getKey();
                it$iv = $dstr$name$data;
                $i$a$-also-Utils$dpkgZip$1$iv = false;
                data = (byte[])it$iv.getValue();
                resourceCache.put(StringsKt.Method11423(StringsKt.Method9968((String)name, "/", ".", false, 4, null), ".class", null, 2, null), data);
            }
            $this$forEach$iv = new Ref.BooleanRef();
            $this$forEach$iv.Field4235 = false;
            bytes = null;
            while (true) {
                block83: {
                    if (shouldStop.Field4235) {
                        Thread.sleep((long)1823523770 ^ 1823523806L);
                        continue;
                    }
                    so.writeUTF((String)currentChannel.Field5552);
                    so.writeUTF((String)currentVersion.Field5552);
                    map$iv = false;
                    libUrls = new ArrayList<E>();
                    this_$iv = stream;
                    $i$f$readInt = 0;
                    this_$iv$iv = this_$iv;
                    $i$f$readByteArray = false;
                    $this$readByteArray$iv$iv$iv = this_$iv$iv.Method8437();
                    $i$f$readByteArray = false;
                    name = $this$readByteArray$iv$iv$iv;
                    length$iv$iv$iv$iv = $this$readByteArray$iv$iv$iv.readInt();
                    $i$f$readByteArray = false;
                    array$iv$iv$iv$iv = new byte[length$iv$iv$iv$iv];
                    for (bytesRead$iv$iv$iv$iv = 0; bytesRead$iv$iv$iv$iv < length$iv$iv$iv$iv && (read$iv$iv$iv$iv = $this$readByteArray$iv$iv$iv$iv.read(array$iv$iv$iv$iv, bytesRead$iv$iv$iv$iv, array$iv$iv$iv$iv.length - bytesRead$iv$iv$iv$iv)) != -1; bytesRead$iv$iv$iv$iv += read$iv$iv$iv$iv) {
                    }
                    encrypted$iv$iv = array$iv$iv$iv$iv;
                    libCount = ByteBuffer.wrap(Encryption.Field4545.Method6539(encrypted$iv$iv, this_$iv$iv.Method8442())).getInt();
                    this_$iv = 0;
                    $i$f$readInt = libCount;
                    while (this_$iv < $i$f$readInt) {
                        libUrls.add(si.readUTF());
                        ++i;
                    }
                    i = new Ref.LongRef();
                    i.Field4347 = (long)-830357338 ^ -830357338L;
                    $i$f$readInt = new Ref.LongRef();
                    $i$f$readInt.Field4347 = (long)1902054407 ^ 1902054407L;
                    $i$f$readByteArray = false;
                    libFiles = new ArrayList<E>();
                    $this$forEach$iv = libUrls;
                    $i$f$forEach = false;
                    for (Object element$iv : $this$forEach$iv) {
                        it = (String)element$iv;
                        $i$a$-forEach-DownloadLayer$run$4 = false;
                        resource = new LibraryCache$GradleResource(it);
                        dfile = resource.Method649();
                        libFiles.add(dfile);
                        dfile.Field2795 = DownloadLayer$run$4$1.Field1537;
                        dfile.Method4622();
                    }
                    byteCount = si.readInt();
                    bytes = new byte[byteCount];
                    $this$any$iv = libFiles;
                    $i$f$any = 0;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        v8 = false;
                    } else {
                        element$iv = $this$any$iv.iterator();
                        while (element$iv.hasNext()) {
                            element$iv = element$iv.next();
                            it = (LibraryCache$DownloadFile)element$iv;
                            $i$a$-any-DownloadLayer$run$5 = false;
                            if (!(it.Method4620() == false)) continue;
                            v8 = true;
                            break block83;
                        }
                        v8 = false;
                    }
                }
                if (v8) {
                    current = Thread.currentThread();
                    ThreadsKt.Method9564(true, false, null, null, 0, (Function0)new run.6(libFiles, (Ref.LongRef)libMaxBytes, (Ref.LongRef)libDownloadedBytes, (Ref.BooleanRef)doneReading, gui, byteCount, current), 30, null);
                }
                current = 0;
                $i$f$any = byteCount;
                while (current < $i$f$any) {
                    gui.Method12440((double)((long)i + libDownloadedBytes.Field4347) / (double)((long)byteCount + libMaxBytes.Field4347));
                    bytes[i] = (byte)si.read();
                    if (i % 1000 == false) {
                        Thread.sleep((long)-1764066842 ^ -1764066841L);
                    }
                    if (i % 500000 == false) {
                        so.write(shouldStop.Field4235 != false ? 1 : 0);
                        if (shouldStop.Field4235) break;
                    }
                    ++i;
                }
                so.write(shouldStop.Field4235 != false ? 1 : 0);
                if (!shouldStop.Field4235) break;
            }
            doneReading.Field4235 = true;
            $this$any$iv = libFiles;
            $i$f$any = 0;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                v9 = false;
            } else {
                element$iv = $this$any$iv.iterator();
                while (element$iv.hasNext()) {
                    element$iv = element$iv.next();
                    it = (LibraryCache$DownloadFile)element$iv;
                    $i$a$-any-DownloadLayer$run$7 = false;
                    if (!(it.Method4620() == false)) continue;
                    v9 = true;
                    break block84;
                }
                v9 = false;
            }
        }
        if (v9) {
            Thread.currentThread().suspend();
        }
        gui.Method12440(Double.longBitsToDouble(Double.doubleToLongBits(-8.035968802711773) ^ 9209881486608475533L));
        gui.Method12446(gui.Method12443("Injecting"));
        decrypted = Encryption.Field4545.Method6539(bytes, stream.Method8442());
        $i$f$dpkgZip = false;
        libDownloadedBytes = false;
        map$iv = new LinkedHashMap<K, V>();
        zipIn$iv = new ZipInputStream(new ByteArrayInputStream(decrypted));
        entry$iv = new Ref.ObjectRef<T>();
        while (true) {
            $this$any$iv = zipIn$iv.getNextEntry();
            $i$f$any = false;
            element$iv = false;
            it$iv = $this$any$iv;
            $i$a$-also-Utils$dpkgZip$1$iv = false;
            entry$iv.Field5552 = it$iv;
            if ($this$any$iv == null) break;
            contents$iv = new byte[4096];
            direct$iv = new Ref.IntRef();
            stream$iv = new ByteArrayOutputStream();
            while (true) {
                var21_80 = zipIn$iv.read(contents$iv, 0, contents$iv.length);
                $i$a$-also-Utils$dpkgZip$1$iv = false;
                $i$a$-any-DownloadLayer$run$7 = false;
                it$iv = var21_80;
                $i$a$-also-Utils$dpkgZip$2$iv = false;
                direct$iv.Field284 = it$iv;
                if (var21_80 < 0) break;
                stream$iv.write(contents$iv, 0, direct$iv.Field284);
            }
            v10 = (ZipEntry)entry$iv.Field5552;
            if (v10 == null) {
                Intrinsics.Method6551();
            }
            map$iv.put(v10.getName(), stream$iv.toByteArray());
            zipIn$iv.closeEntry();
        }
        files = map$iv;
        zipIn$iv = false;
        mixins = new ArrayList<E>();
        v11 = Launch.classLoader.loadClass("dev.nuker.pyro.PyroClientLoadingPlugin").getField("resources").get(null);
        if (v11 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.ByteArray>");
        }
        pyroResources = TypeIntrinsics.Method5573(v11);
        refmap = File.createTempFile("ref", null);
        refmap.deleteOnExit();
        $this$forEach$iv = files;
        $i$f$forEach = false;
        var19_69 = $this$forEach$iv;
        var20_72 = false;
        var21_79 = var19_69.entrySet().iterator();
        while (true) {
            block88: {
                block89: {
                    block86: {
                        block87: {
                            block85: {
                                if (!var21_79.hasNext()) {
                                    Launch.classLoader.loadClass("dev.nuker.pyro.launcher.LoadingPluginImpl").getMethod("init", new Class[]{List.class, File.class}).invoke(null, new Object[]{mixins, refmap});
                                    gui.Method12446(gui.Method12443("Complete"));
                                    gui.setVisible(false);
                                    PyroClientLoadingPlugin.Field7535.resume();
                                    return;
                                }
                                $dstr$name$data = element$iv = var21_79.next();
                                $i$a$-forEach-DownloadLayer$run$8 = false;
                                $i$a$-also-Utils$dpkgZip$2$iv = $dstr$name$data;
                                var26_96 = false;
                                name = (String)$i$a$-also-Utils$dpkgZip$2$iv.getKey();
                                $i$a$-also-Utils$dpkgZip$2$iv = $dstr$name$data;
                                var26_96 = false;
                                data = (byte[])$i$a$-also-Utils$dpkgZip$2$iv.getValue();
                                if (Intrinsics.Method6572(name, "refmap.json")) {
                                    Files.write(refmap.toPath(), data, new OpenOption[0]);
                                    continue;
                                }
                                if (StringsKt.Method9998(name, "resources/", false, 2, null)) {
                                    var26_97 = name;
                                    var29_102 = 10;
                                    var30_103 = 0;
                                    v12 = var26_97;
                                    if (v12 == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    v12.substring(var29_102);
                                    pyroResources.put(sub, data);
                                    continue;
                                }
                                if (!StringsKt.Method9998(name, "inject/", false, 2, null) || StringsKt.Method10002(name, "/", false, 2, null)) break block85;
                                var26_98 = name;
                                var29_102 = 7;
                                var30_103 = name.length() - 6;
                                var31_106 = false;
                                v13 = var26_98;
                                if (v13 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                sub = StringsKt.Method9968(v13.substring(var29_102, var30_103), "/", ".", false, 4, null);
                                rand = Random.Field4299.Method5951();
                                var30_104 = sub;
                                var34_110 = MessageDigest.getInstance("MD5");
                                var35_111 = ThirdLayer.Field2255;
                                var31_107 = Charsets.Field5722;
                                var36_113 = false;
                                v14 = var30_104;
                                if (v14 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                v14.getBytes(var31_107);
                                var35_111.put((byte[])var34_110.digest(var37_116), rand);
                                var30_104 = sub;
                                var34_110 = MessageDigest.getInstance("MD5");
                                var35_111 = Clientfiles.Field1322.Method1879();
                                var31_107 = Charsets.Field5722;
                                var36_113 = false;
                                v15 = var30_104;
                                if (v15 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                v15.getBytes(var31_107);
                                var30_103 = 69;
                                var34_110 = var34_110.digest(var37_117);
                                $i$f$storeIndexedBytes = false;
                                $i$f$getUnsafe = false;
                                try {
                                    v16 = Unsafe.class.getDeclaredField("theUnsafe");
                                }
                                catch (Exception e$iv$iv) {
                                    throw (Throwable)new RuntimeException(e$iv$iv);
                                }
                                f$iv$iv = v16;
                                v17 = f$iv$iv;
                                v18 = true;
                                v17.setAccessible(v18);
                                v19 = f$iv$iv;
                                v20 = null;
                                v21 = v19.get(v20);
                                v22 = v21;
                                if (v21 != null) ** GOTO lbl414
                                v23 = v24;
                                v25 = v24;
                                v26 = "null cannot be cast to non-null type sun.misc.Unsafe";
                                v23(v26);
                                throw v25;
lbl414:
                                // 1 sources

                                f$iv$iv = (Unsafe)v22;
                                unsafe$iv = f$iv$iv;
                                random$iv = RandomKt.Method7032(rand);
                                var41_129 = (double)data.length / (double)bytesplit$iv;
                                var43_130 = 0;
                                splitcount$iv = (int)Math.ceil(var41_129);
                                indexTable$iv = new long[splitcount$iv + 1];
                                var43_130 = 0;
                                unusedIndexTable$iv = new LinkedHashMap<K, V>();
                                indexTable$iv[0] = data.length;
                                var43_130 = 1;
                                var45_132 = splitcount$iv;
                                if (var43_130 <= var45_132) {
                                    while (true) {
                                        indexTable$iv[i$iv] = unsafe$iv.allocateMemory(bytesplit$iv);
                                        unusedIndexTable$iv.put(i$iv, indexTable$iv[i$iv]);
                                        if (i$iv == var45_132) break;
                                        ++i$iv;
                                    }
                                }
                                if ((i$iv = 1) > (var45_132 = splitcount$iv)) break block86;
                                break block87;
                            }
                            if (!StringsKt.Method9998(name, "classes/", false, 2, null) || StringsKt.Method10002(name, "/", false, 2, null)) continue;
                            var26_99 = name;
                            var29_102 = 8;
                            bytesplit$iv = name.length() - 6;
                            $i$f$storeIndexedBytes = false;
                            v27 = var26_99;
                            if (v27 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                            sub = StringsKt.Method9968(v27.substring(var29_102, bytesplit$iv), "/", ".", false, 4, null);
                            if (StringsKt.Method11503(sub, ".mixin", false, 2, null)) {
                                mixins.add(sub);
                                resourceCache.put(sub, data);
                                continue;
                            }
                            rand = Random.Field4299.Method5951();
                            bytesplit$iv = sub;
                            var34_110 = MessageDigest.getInstance("MD5");
                            var35_111 = ThirdLayer.Field2254;
                            $i$f$storeIndexedBytes = Charsets.Field5722;
                            random$iv = false;
                            v28 = bytesplit$iv;
                            if (v28 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                            v28.getBytes($i$f$storeIndexedBytes);
                            var35_111.put(var34_110.digest(var37_119), rand);
                            bytesplit$iv = sub;
                            var34_110 = MessageDigest.getInstance("MD5");
                            var35_111 = Clientfiles.Field1322.Method1879();
                            $i$f$storeIndexedBytes = Charsets.Field5722;
                            random$iv = false;
                            v29 = bytesplit$iv;
                            if (v29 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                            v29.getBytes($i$f$storeIndexedBytes);
                            bytesplit$iv = 42;
                            var34_110 = var34_110.digest(var37_120);
                            $i$f$storeIndexedBytes = false;
                            $i$f$getUnsafe = false;
                            try {
                                v30 = Unsafe.class.getDeclaredField("theUnsafe");
                            }
                            catch (Exception e$iv$iv) {
                                throw (Throwable)new RuntimeException(e$iv$iv);
                            }
                            f$iv$iv = v30;
                            v31 = f$iv$iv;
                            v32 = true;
                            v31.setAccessible(v32);
                            v33 = f$iv$iv;
                            v34 = null;
                            v35 = v33.get(v34);
                            v36 = v35;
                            if (v35 != null) ** GOTO lbl510
                            v37 = v38;
                            v39 = v38;
                            v40 = "null cannot be cast to non-null type sun.misc.Unsafe";
                            v37(v40);
                            throw v39;
lbl510:
                            // 1 sources

                            f$iv$iv = (Unsafe)v36;
                            unsafe$iv = f$iv$iv;
                            random$iv = RandomKt.Method7032(rand);
                            var41_129 = (double)data.length / (double)bytesplit$iv;
                            i$iv = 0;
                            splitcount$iv = (int)Math.ceil(var41_129);
                            indexTable$iv = new long[splitcount$iv + 1];
                            i$iv = 0;
                            unusedIndexTable$iv = new LinkedHashMap<K, V>();
                            indexTable$iv[0] = data.length;
                            i$iv = 1;
                            var45_132 = splitcount$iv;
                            if (i$iv <= var45_132) {
                                while (true) {
                                    indexTable$iv[i$iv] = unsafe$iv.allocateMemory(bytesplit$iv);
                                    unusedIndexTable$iv.put(i$iv, indexTable$iv[i$iv]);
                                    if (i$iv == var45_132) break;
                                    ++i$iv;
                                }
                            }
                            if ((i$iv = 1) > (var45_132 = splitcount$iv)) break block88;
                            break block89;
                        }
                        while (true) {
                            begin$iv = (i$iv - 1) * bytesplit$iv;
                            length$iv = bytesplit$iv;
                            var48_135 = data.length;
                            var49_136 = begin$iv + length$iv;
                            var50_137 = false;
                            end$iv = Math.min(var48_135, var49_136);
                            index$iv = ((Number)CollectionsKt.Method3094((Collection)unusedIndexTable$iv.keySet(), random$iv)).intValue();
                            v41 = unusedIndexTable$iv.get(index$iv);
                            if (v41 == null) {
                                Intrinsics.Method6551();
                            }
                            nextMem$iv = ((Number)v41).longValue();
                            unusedIndexTable$iv.remove(index$iv);
                            var54_140 = begin$iv;
                            var55_141 = end$iv;
                            while (var54_140 < var55_141) {
                                unsafe$iv.putByte(nextMem$iv + (long)j$iv - (long)begin$iv, data[j$iv]);
                                ++j$iv;
                            }
                            if (i$iv == var45_132) break;
                            ++i$iv;
                        }
                    }
                    var37_118 = indexTable$iv;
                    var35_111.put(var34_110, var37_118);
                    continue;
                }
                while (true) {
                    begin$iv = (i$iv - 1) * bytesplit$iv;
                    length$iv = bytesplit$iv;
                    index$iv = data.length;
                    var49_136 = begin$iv + length$iv;
                    var50_137 = false;
                    end$iv = Math.min(index$iv, var49_136);
                    index$iv = ((Number)CollectionsKt.Method3094((Collection)unusedIndexTable$iv.keySet(), random$iv)).intValue();
                    v42 = unusedIndexTable$iv.get(index$iv);
                    if (v42 == null) {
                        Intrinsics.Method6551();
                    }
                    nextMem$iv = ((Number)v42).longValue();
                    unusedIndexTable$iv.remove(index$iv);
                    var55_141 = end$iv;
                    for (j$iv = begin$iv; j$iv < var55_141; ++j$iv) {
                        unsafe$iv.putByte(nextMem$iv + (long)j$iv - (long)begin$iv, data[j$iv]);
                    }
                    if (i$iv == var45_132) break;
                    ++i$iv;
                }
            }
            var37_121 = indexTable$iv;
            var35_111.put(var34_110, var37_121);
        }
    }
}

