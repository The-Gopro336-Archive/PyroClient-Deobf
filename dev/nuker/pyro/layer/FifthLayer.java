/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.nuker.pyro.TopLayer
 *  net.minecraft.launchwrapper.Launch
 *  net.minecraft.launchwrapper.LaunchClassLoader
 *  org.apache.commons.io.IOUtils
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.TopLayer;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.layer.FourthLayer;
import dev.nuker.pyro.layer.SecondLayer;
import dev.nuker.pyro.layer.ThirdLayer;
import dev.nuker.pyro.security.ClassSigGen;
import dev.nuker.pyro.security.ClassSigGen$getClassChecksum2$3;
import dev.nuker.pyro.security.ClassSigGen$getClassChecksum2$5;
import dev.nuker.pyro.security.NestedClassloader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

public class FifthLayer {
    public static FifthLayer Field559;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static void Method917(@NotNull LoaderGui var0, @NotNull DataInputStream var1_1, @NotNull DataOutputStream var2_2) {
        so.writeInt(-616972404);
        classloader = new NestedClassloader(FifthLayer.Field559.getClass().getClassLoader());
        so.writeInt(-497447601);
        var5_4 = ClassSigGen.Field911;
        classes$iv = new Class[]{TopLayer.class, SecondLayer.class, ThirdLayer.class, FourthLayer.class, FifthLayer.class};
        $i$f$getCombinedChecksum2 = false;
        hash$iv = MessageDigest.getInstance("MD5");
        $this$forEach$iv$iv = classes$iv;
        $i$f$forEach = false;
        var11_21 = $this$forEach$iv$iv;
        var12_25 = var11_21.length;
        var13_28 = 0;
        while (true) {
            if (var13_28 < var12_25) {
                it$iv = element$iv$iv = var11_21[var13_28];
                $i$a$-forEach-ClassSigGen$getCombinedChecksum2$1$iv = false;
                var17_39 = ClassSigGen.Field911;
                var18_42 = hash$iv;
                $i$f$getClassChecksum2 = false;
                hash$iv$iv = MessageDigest.getInstance("MD5");
                var21_48 = false;
                methods$iv$iv = var22_50 = (List)new ArrayList<E>();
                var24_53 = false;
                fields$iv$iv = var22_50 = (List)new ArrayList<E>();
                $this$forEach$iv$iv$iv = it$iv.getDeclaredFields();
                $i$f$forEach = false;
                var26_58 = $this$forEach$iv$iv$iv;
                var27_59 = ((Field[])var26_58).length;
            } else {
                $this$forEach$iv$iv = classes$iv;
                $i$f$forEach = false;
                var11_21 = $this$forEach$iv$iv;
                var12_25 = var11_21.length;
                break;
            }
            for (var28_62 = 0; var28_62 < var27_59; ++var28_62) {
                block53: {
                    block49: {
                        block48: {
                            block51: {
                                block50: {
                                    block52: {
                                        it$iv$iv = element$iv$iv$iv = var26_58[var28_62];
                                        $i$a$-forEach-ClassSigGen$getClassChecksum2$1$iv$iv = false;
                                        v0 = new StringBuilder();
                                        var32_72 = ClassSigGen.Field911;
                                        it$iv$iv.getType().getName();
                                        var34_76 = v0.append(it$iv$iv.getModifiers()).append(' ').append(it$iv$iv.getName()).append(' ');
                                        var35_77 = fields$iv$iv;
                                        $i$f$getDescriptor = false;
                                        var37_81 = name$iv$iv$iv;
                                        switch (var37_81.hashCode()) {
                                            case 64711720: {
                                                if (!var37_81.equals("boolean")) ** break;
                                                break;
                                            }
                                            case 3625364: {
                                                if (!var37_81.equals("void")) ** break;
                                                break block48;
                                            }
                                            case -1325958191: {
                                                if (!var37_81.equals("double")) break block49;
                                                break block50;
                                            }
                                            case 3039496: {
                                                if (!var37_81.equals("byte")) break block49;
                                                break block51;
                                            }
                                            case 97526364: {
                                                if (!var37_81.equals("float")) break block49;
                                                break block52;
                                            }
                                            case 104431: {
                                                if (!var37_81.equals("int")) ** break;
                                                v1 = "I";
                                                break block53;
                                            }
                                        }
                                        v1 = "Z";
                                        break block53;
                                    }
                                    v1 = "F";
                                    break block53;
                                }
                                v1 = "D";
                                break block53;
                            }
                            v1 = "B";
                            break block53;
                        }
                        v1 = "V";
                        break block53;
                    }
                    v1 = StringsKt.Method9998((String)name$iv$iv$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                }
                var38_82 = v1;
                var35_77.add(var34_76.append(var38_82).toString());
            }
            $this$forEach$iv$iv$iv = it$iv.getDeclaredMethods();
            $i$f$forEach = false;
            var26_58 = $this$forEach$iv$iv$iv;
            var27_59 = ((Field[])var26_58).length;
            var28_62 = 0;
            while (true) {
                block65: {
                    block62: {
                        block60: {
                            block63: {
                                block61: {
                                    block64: {
                                        if (var28_62 < var27_59) {
                                            it$iv$iv = element$iv$iv$iv = var26_58[var28_62];
                                            $i$a$-forEach-ClassSigGen$getClassChecksum2$2$iv$iv = false;
                                            v2 = new StringBuilder();
                                            it$iv$iv.getParameters();
                                            var33_73 = v2.append(it$iv$iv.getName()).append(" (");
                                            var34_76 = methods$iv$iv;
                                            $i$f$map = false;
                                            $i$f$getDescriptor = $this$map$iv$iv$iv;
                                            destination$iv$iv$iv$iv = new ArrayList<E>(((void)$this$map$iv$iv$iv).length);
                                            $i$f$mapTo = false;
                                            var39_84 = $this$mapTo$iv$iv$iv$iv;
                                            var40_85 = ((void)var39_84).length;
                                            for (var41_87 = 0; var41_87 < var40_85; ++var41_87) {
                                                var43_91 = item$iv$iv$iv$iv = var39_84[var41_87];
                                                var44_92 = destination$iv$iv$iv$iv;
                                                $i$a$-map-ClassSigGen$getClassChecksum2$2$1$iv$iv = false;
                                                var46_95 = it$iv$iv.getType();
                                                var44_92.add(var46_95);
                                            }
                                            var44_92 = (List)destination$iv$iv$iv$iv;
                                            $this$map$iv$iv$iv = (Iterable)var44_92;
                                            $i$f$map = false;
                                            $this$mapTo$iv$iv$iv$iv = $this$map$iv$iv$iv;
                                            destination$iv$iv$iv$iv = new ArrayList<E>(CollectionsKt.Method9458($this$map$iv$iv$iv, 10));
                                            $i$f$mapTo = false;
                                            var39_84 = $this$mapTo$iv$iv$iv$iv.iterator();
                                        } else {
                                            $this$forEach$iv$iv$iv = CollectionsKt.Method3129(fields$iv$iv, ClassSigGen$getClassChecksum2$3.Field7245);
                                            $i$f$forEach = false;
                                            var26_58 = $this$forEach$iv$iv$iv.iterator();
                                            break;
                                        }
                                        while (var39_84.hasNext()) {
                                            block59: {
                                                block54: {
                                                    block55: {
                                                        block57: {
                                                            block56: {
                                                                block58: {
                                                                    item$iv$iv$iv$iv = var39_84.next();
                                                                    var41_88 = (Class)item$iv$iv$iv$iv;
                                                                    var44_92 = destination$iv$iv$iv$iv;
                                                                    $i$a$-map-ClassSigGen$getClassChecksum2$2$2$iv$iv = false;
                                                                    it$iv$iv = ClassSigGen.Field911;
                                                                    it$iv$iv.getName();
                                                                    $i$f$getDescriptor = false;
                                                                    var48_97 = name$iv$iv$iv;
                                                                    switch (var48_97.hashCode()) {
                                                                        case 64711720: {
                                                                            if (!var48_97.equals("boolean")) ** break;
                                                                            break;
                                                                        }
                                                                        case 3625364: {
                                                                            if (!var48_97.equals("void")) break block54;
                                                                            break block55;
                                                                        }
                                                                        case -1325958191: {
                                                                            if (!var48_97.equals("double")) ** break;
                                                                            break block56;
                                                                        }
                                                                        case 3039496: {
                                                                            if (!var48_97.equals("byte")) ** break;
                                                                            break block57;
                                                                        }
                                                                        case 97526364: {
                                                                            if (!var48_97.equals("float")) ** break;
                                                                            break block58;
                                                                        }
                                                                        case 104431: {
                                                                            if (!var48_97.equals("int")) ** break;
                                                                            v3 = "I";
                                                                            break block59;
                                                                        }
                                                                    }
                                                                    v3 = "Z";
                                                                    break block59;
                                                                }
                                                                v3 = "F";
                                                                break block59;
                                                            }
                                                            v3 = "D";
                                                            break block59;
                                                        }
                                                        v3 = "B";
                                                        break block59;
                                                    }
                                                    v3 = "V";
                                                    break block59;
                                                }
                                                v3 = StringsKt.Method9998(name$iv$iv$iv, "[", false, 2, null) ? StringsKt.Method9968(name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968(name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                                            }
                                            var46_95 = v3;
                                            var44_92.add(var46_95);
                                        }
                                        var44_92 = (List)destination$iv$iv$iv$iv;
                                        $this$map$iv$iv$iv = ClassSigGen.Field911;
                                        it$iv$iv.getReturnType().getName();
                                        var33_73 = var33_73.append(CollectionsKt.Method3238((Iterable)var44_92, "", null, null, 0, null, null, 62, null)).append(')');
                                        $i$f$getDescriptor = false;
                                        var37_81 = name$iv$iv$iv;
                                        switch (var37_81.hashCode()) {
                                            case 64711720: {
                                                if (!var37_81.equals("boolean")) ** break;
                                                break;
                                            }
                                            case 3625364: {
                                                if (!var37_81.equals("void")) ** break;
                                                break block60;
                                            }
                                            case -1325958191: {
                                                if (!var37_81.equals("double")) ** break;
                                                break block61;
                                            }
                                            case 3039496: {
                                                if (!var37_81.equals("byte")) break block62;
                                                break block63;
                                            }
                                            case 97526364: {
                                                if (!var37_81.equals("float")) break block62;
                                                break block64;
                                            }
                                            case 104431: {
                                                if (!var37_81.equals("int")) ** break;
                                                v4 = "I";
                                                break block65;
                                            }
                                        }
                                        v4 = "Z";
                                        break block65;
                                    }
                                    v4 = "F";
                                    break block65;
                                }
                                v4 = "D";
                                break block65;
                            }
                            v4 = "B";
                            break block65;
                        }
                        v4 = "V";
                        break block65;
                    }
                    v4 = StringsKt.Method9998((String)name$iv$iv$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                }
                var44_92 = v4;
                var34_76.add(var33_73.append((String)var44_92).toString());
                ++var28_62;
            }
            while (var26_58.hasNext()) {
                element$iv$iv$iv = var26_58.next();
                it$iv$iv = (String)element$iv$iv$iv;
                $i$a$-forEach-ClassSigGen$getClassChecksum2$4$iv$iv = false;
                var30_68 = it$iv$iv;
                var31_70 = hash$iv$iv;
                var32_72 = Charsets.Field5722;
                var33_74 = false;
                v5 = var30_68;
                if (v5 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var34_76 = v5.getBytes((Charset)var32_72);
                var31_70.update((byte[])var34_76);
            }
            $this$forEach$iv$iv$iv = CollectionsKt.Method3129(methods$iv$iv, ClassSigGen$getClassChecksum2$5.Field7246);
            $i$f$forEach = false;
            var26_58 = $this$forEach$iv$iv$iv.iterator();
            while (var26_58.hasNext()) {
                element$iv$iv$iv = var26_58.next();
                it$iv$iv = (String)element$iv$iv$iv;
                $i$a$-forEach-ClassSigGen$getClassChecksum2$6$iv$iv = false;
                var30_68 = it$iv$iv;
                var31_71 = hash$iv$iv;
                var32_72 = Charsets.Field5722;
                var33_75 = false;
                v6 = var30_68;
                if (v6 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var34_76 = v6.getBytes((Charset)var32_72);
                var31_71.update((byte[])var34_76);
            }
            var18_42.update(var49_98.digest());
            ++var13_28;
        }
        for (var13_28 = 0; var13_28 < var12_25; ++var13_28) {
            it$iv = element$iv$iv = var11_21[var13_28];
            $i$a$-forEach-ClassSigGen$getCombinedChecksum2$2$iv = false;
            this_$iv$iv = hash$iv;
            $i$f$getClassBytes = false;
            v7 = it$iv.getClassLoader().getResourceAsStream(StringsKt.Method9968(it$iv.getName(), ".", "/", false, 4, null) + ".class");
            if (v7 == null) {
                var19_45 = LaunchClassLoader.class.getDeclaredField("resourceCache");
                var50_99 = false;
                var21_49 = false;
                it$iv$iv = var19_45;
                $i$a$-let-ClassSigGen$getClassBytes$1$iv$iv = false;
                it$iv$iv.setAccessible(true);
                v8 = it$iv$iv.get((Object)Launch.classLoader);
                if (v8 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
                }
                var25_57 = (Map)v8;
                var51_100 = (byte[])var25_57.get(it$iv.getName());
                v7 = new ByteArrayInputStream(var51_100);
            }
            var26_58 = IOUtils.toByteArray((InputStream)v7);
            this_$iv$iv.update((byte[])var26_58);
        }
        cs = hash$iv.digest();
        this_$iv = so;
        bytes$iv = cs;
        $i$f$writeByteArray = false;
        $this$writeByteArray$iv.writeInt(bytes$iv.length);
        $this$writeByteArray$iv.write(bytes$iv);
        so.writeInt(1172574186);
        $this$readByteArray$iv = si;
        $i$f$readByteArray = false;
        hash$iv = (InputStream)$this$readByteArray$iv;
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
                var14_32 = false;
                var15_35 = false;
                it$iv = it$iv;
                $i$a$-also-Utils$dpkgZip$2$iv = false;
                direct$iv.Field284 = it$iv;
                if (it$iv < 0) break;
                stream$iv.write((byte[])contents$iv, 0, direct$iv.Field284);
            }
            v9 = (ZipEntry)entry$iv.Field5552;
            if (v9 == null) {
                Intrinsics.Method6551();
            }
            map$iv.put(v9.getName(), stream$iv.toByteArray());
            zipIn$iv.closeEntry();
        }
        files$iv = map$iv;
        $i$f$process = false;
        var8_12 = false;
        classMap$iv = new LinkedHashMap<K, V>();
        contents$iv = files$iv;
        direct$iv = false;
        stream$iv = contents$iv.entrySet().iterator();
        while (stream$iv.hasNext()) {
            it$iv = var8_13 = stream$iv.next();
            var14_32 = false;
            name$iv = (String)it$iv.getKey();
            it$iv = var8_13;
            var14_32 = false;
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
        var8_14 = $this$forEach$iv;
        var9_18 = false;
        var10_20 = var8_14.entrySet().iterator();
        while (true) {
            if (!var10_20.hasNext()) {
                method = classloader.loadClass("dev.nuker.pyro.layer.SixthLayer").getMethod("run", new Class[]{LoaderGui.class, DataInputStream.class, DataOutputStream.class});
                method.invoke(null, new Object[]{gui, si, so});
                return;
            }
            $dstr$name$bytes = element$iv = var10_20.next();
            $i$a$-forEach-FifthLayer$run$1 = false;
            var14_33 = $dstr$name$bytes;
            var15_36 = false;
            name = (String)var14_33.getKey();
            var14_33 = $dstr$name$bytes;
            var15_36 = false;
            bytes = (byte[])var14_33.getValue();
            classloader.Method4761(name, bytes);
        }
    }

    static {
        FifthLayer fifthLayer;
        Field559 = fifthLayer = new FifthLayer();
    }
}

