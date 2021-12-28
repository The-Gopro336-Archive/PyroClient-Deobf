/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.Launch
 *  net.minecraft.launchwrapper.LaunchClassLoader
 *  org.apache.commons.io.IOUtils
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.layer.FifthLayer;
import dev.nuker.pyro.layer.FourthLayer;
import dev.nuker.pyro.layer.SecondLayer;
import dev.nuker.pyro.layer.ThirdLayer;
import dev.nuker.pyro.security.ClassSigGen;
import dev.nuker.pyro.security.ClassSigGen$getClassChecksum2$3;
import dev.nuker.pyro.security.ClassSigGen$getClassChecksum2$5;
import dev.nuker.pyro.security.EncryptedStreamWrapper;
import dev.nuker.pyro.security.Encryption;
import dev.nuker.pyro.security.NestedClassloader;
import dev.nuker.pyro.security.UtilsKt$hexString$1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
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

public class SixthLayer {
    public static SixthLayer Field37;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @JvmStatic
    public static void Method80(@NotNull LoaderGui var0, @NotNull DataInputStream var1_1, @NotNull DataOutputStream var2_2) {
        stream = new EncryptedStreamWrapper((DataInputStream)si, (DataOutputStream)so);
        var5_4 = ClassSigGen.Field911;
        classes$iv = new Class[]{SecondLayer.class, ThirdLayer.class, FifthLayer.class, FourthLayer.class};
        $i$f$getCombinedChecksum2 = false;
        hash$iv = MessageDigest.getInstance("MD5");
        $this$forEach$iv$iv = classes$iv;
        $i$f$forEach = false;
        var11_34 = $this$forEach$iv$iv;
        var12_40 = var11_34.length;
        for (var13_46 = 0; var13_46 < var12_40; ++var13_46) {
            it$iv = element$iv$iv = var11_34[var13_46];
            $i$a$-forEach-ClassSigGen$getCombinedChecksum2$1$iv = false;
            var17_66 = ClassSigGen.Field911;
            var18_70 = hash$iv;
            $i$f$getClassChecksum2 = false;
            hash$iv$iv = MessageDigest.getInstance("MD5");
            var21_84 = false;
            methods$iv$iv = var22_88 = (List)new ArrayList<E>();
            var24_93 = false;
            fields$iv$iv = var22_88 = (List)new ArrayList<E>();
            $this$forEach$iv$iv$iv = it$iv.getDeclaredFields();
            $i$f$forEach = false;
            var26_99 = $this$forEach$iv$iv$iv;
            var27_100 = ((Field[])var26_99).length;
            for (var28_103 = 0; var28_103 < var27_100; ++var28_103) {
                block54: {
                    block50: {
                        block52: {
                            block51: {
                                block53: {
                                    it$iv$iv = element$iv$iv$iv /* !! */  = var26_99[var28_103];
                                    $i$a$-forEach-ClassSigGen$getClassChecksum2$1$iv$iv = false;
                                    v0 = new StringBuilder();
                                    var32_113 = ClassSigGen.Field911;
                                    it$iv$iv.getType().getName();
                                    var34_117 = v0.append(it$iv$iv.getModifiers()).append(' ').append(it$iv$iv.getName()).append(' ');
                                    var35_118 = fields$iv$iv;
                                    $i$f$getDescriptor = false;
                                    var37_122 = name$iv$iv$iv;
                                    switch (var37_122.hashCode()) {
                                        case 64711720: {
                                            if (!var37_122.equals("boolean")) ** break;
                                            break;
                                        }
                                        case 3625364: {
                                            if (!var37_122.equals("void")) ** break;
                                            break block50;
                                        }
                                        case -1325958191: {
                                            if (!var37_122.equals("double")) ** break;
                                            break block51;
                                        }
                                        case 3039496: {
                                            if (!var37_122.equals("byte")) ** break;
                                            break block52;
                                        }
                                        case 97526364: {
                                            if (!var37_122.equals("float")) ** break;
                                            break block53;
                                        }
                                        case 104431: {
                                            if (!var37_122.equals("int")) ** break;
                                            v1 = "I";
                                            break block54;
                                        }
                                    }
                                    v1 = "Z";
                                    break block54;
                                }
                                v1 = "F";
                                break block54;
                            }
                            v1 = "D";
                            break block54;
                        }
                        v1 = "B";
                        break block54;
                    }
                    v1 = "V";
                    break block54;
                    v1 = StringsKt.Method9998((String)name$iv$iv$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                }
                var38_123 = v1;
                var35_118.add(var34_117.append(var38_123).toString());
            }
            $this$forEach$iv$iv$iv = it$iv.getDeclaredMethods();
            $i$f$forEach = false;
            var26_99 = $this$forEach$iv$iv$iv;
            var27_100 = ((AccessibleObject[])var26_99).length;
            for (var28_103 = 0; var28_103 < var27_100; ++var28_103) {
                block64: {
                    block60: {
                        block62: {
                            block61: {
                                block63: {
                                    it$iv$iv = element$iv$iv$iv /* !! */  = var26_99[var28_103];
                                    $i$a$-forEach-ClassSigGen$getClassChecksum2$2$iv$iv = false;
                                    v2 = new StringBuilder();
                                    it$iv$iv.getParameters();
                                    var33_114 = v2.append(it$iv$iv.getName()).append(" (");
                                    var34_117 = methods$iv$iv;
                                    $i$f$map = false;
                                    $i$f$getDescriptor = $this$map$iv$iv$iv;
                                    destination$iv$iv$iv$iv = new ArrayList<E>(((void)$this$map$iv$iv$iv).length);
                                    $i$f$mapTo = false;
                                    var39_125 = $this$mapTo$iv$iv$iv$iv;
                                    var40_126 = ((void)var39_125).length;
                                    for (var41_128 = 0; var41_128 < var40_126; ++var41_128) {
                                        var43_132 = item$iv$iv$iv$iv = var39_125[var41_128];
                                        var44_133 = destination$iv$iv$iv$iv;
                                        $i$a$-map-ClassSigGen$getClassChecksum2$2$1$iv$iv = false;
                                        var46_136 = it$iv$iv.getType();
                                        var44_133.add(var46_136);
                                    }
                                    var44_133 = (List)destination$iv$iv$iv$iv;
                                    $this$map$iv$iv$iv = (Iterable)var44_133;
                                    $i$f$map = false;
                                    $this$mapTo$iv$iv$iv$iv = $this$map$iv$iv$iv;
                                    destination$iv$iv$iv$iv = new ArrayList<E>(CollectionsKt.Method9458($this$map$iv$iv$iv, 10));
                                    $i$f$mapTo = false;
                                    for (T item$iv$iv$iv$iv : $this$mapTo$iv$iv$iv$iv) {
                                        block59: {
                                            block55: {
                                                block57: {
                                                    block56: {
                                                        block58: {
                                                            var41_129 = (Class)item$iv$iv$iv$iv;
                                                            var44_133 = destination$iv$iv$iv$iv;
                                                            $i$a$-map-ClassSigGen$getClassChecksum2$2$2$iv$iv = false;
                                                            it$iv$iv = ClassSigGen.Field911;
                                                            it$iv$iv.getName();
                                                            $i$f$getDescriptor = false;
                                                            var48_138 = name$iv$iv$iv;
                                                            switch (var48_138.hashCode()) {
                                                                case 64711720: {
                                                                    if (!var48_138.equals("boolean")) ** break;
                                                                    break;
                                                                }
                                                                case 3625364: {
                                                                    if (!var48_138.equals("void")) ** break;
                                                                    break block55;
                                                                }
                                                                case -1325958191: {
                                                                    if (!var48_138.equals("double")) ** break;
                                                                    break block56;
                                                                }
                                                                case 3039496: {
                                                                    if (!var48_138.equals("byte")) ** break;
                                                                    break block57;
                                                                }
                                                                case 97526364: {
                                                                    if (!var48_138.equals("float")) ** break;
                                                                    break block58;
                                                                }
                                                                case 104431: {
                                                                    if (!var48_138.equals("int")) ** break;
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
                                            v3 = StringsKt.Method9998(name$iv$iv$iv, "[", false, 2, null) ? StringsKt.Method9968(name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968(name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                                        }
                                        var46_136 = v3;
                                        var44_133.add(var46_136);
                                    }
                                    var44_133 = (List)destination$iv$iv$iv$iv;
                                    $this$map$iv$iv$iv = ClassSigGen.Field911;
                                    it$iv$iv.getReturnType().getName();
                                    var33_114 = var33_114.append(CollectionsKt.Method3238((Iterable)var44_133, "", null, null, 0, null, null, 62, null)).append(')');
                                    $i$f$getDescriptor = false;
                                    var37_122 = name$iv$iv$iv;
                                    switch (var37_122.hashCode()) {
                                        case 64711720: {
                                            if (!var37_122.equals("boolean")) ** break;
                                            break;
                                        }
                                        case 3625364: {
                                            if (!var37_122.equals("void")) ** break;
                                            break block60;
                                        }
                                        case -1325958191: {
                                            if (!var37_122.equals("double")) ** break;
                                            break block61;
                                        }
                                        case 3039496: {
                                            if (!var37_122.equals("byte")) ** break;
                                            break block62;
                                        }
                                        case 97526364: {
                                            if (!var37_122.equals("float")) ** break;
                                            break block63;
                                        }
                                        case 104431: {
                                            if (!var37_122.equals("int")) ** break;
                                            v4 = "I";
                                            break block64;
                                        }
                                    }
                                    v4 = "Z";
                                    break block64;
                                }
                                v4 = "F";
                                break block64;
                            }
                            v4 = "D";
                            break block64;
                        }
                        v4 = "B";
                        break block64;
                    }
                    v4 = "V";
                    break block64;
                    v4 = StringsKt.Method9998((String)name$iv$iv$iv, "[", false, 2, null) ? StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                }
                var44_133 = v4;
                var34_117.add(var33_114.append((String)var44_133).toString());
            }
            $this$forEach$iv$iv$iv = CollectionsKt.Method3129(fields$iv$iv, ClassSigGen$getClassChecksum2$3.Field7245);
            $i$f$forEach = false;
            var26_99 = $this$forEach$iv$iv$iv.iterator();
            while (var26_99.hasNext()) {
                element$iv$iv$iv = var26_99.next();
                it$iv$iv = (String)element$iv$iv$iv;
                $i$a$-forEach-ClassSigGen$getClassChecksum2$4$iv$iv = false;
                var30_109 = it$iv$iv;
                var31_111 = hash$iv$iv;
                var32_113 = Charsets.Field5722;
                var33_115 = false;
                v5 = var30_109;
                if (v5 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var34_117 = v5.getBytes((Charset)var32_113);
                var31_111.update((byte[])var34_117);
            }
            $this$forEach$iv$iv$iv = CollectionsKt.Method3129(methods$iv$iv, ClassSigGen$getClassChecksum2$5.Field7246);
            $i$f$forEach = false;
            var26_99 = $this$forEach$iv$iv$iv.iterator();
            while (var26_99.hasNext()) {
                element$iv$iv$iv = var26_99.next();
                it$iv$iv = (String)element$iv$iv$iv;
                $i$a$-forEach-ClassSigGen$getClassChecksum2$6$iv$iv = false;
                var30_109 = it$iv$iv;
                var31_112 = hash$iv$iv;
                var32_113 = Charsets.Field5722;
                var33_116 = false;
                v6 = var30_109;
                if (v6 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var34_117 = v6.getBytes((Charset)var32_113);
                var31_112.update((byte[])var34_117);
            }
            var18_70.update(var49_139.digest());
        }
        $this$forEach$iv$iv = classes$iv;
        $i$f$forEach = false;
        var11_34 = $this$forEach$iv$iv;
        var12_40 = var11_34.length;
        for (var13_46 = 0; var13_46 < var12_40; ++var13_46) {
            it$iv = element$iv$iv = var11_34[var13_46];
            $i$a$-forEach-ClassSigGen$getCombinedChecksum2$2$iv = false;
            this_$iv$iv = hash$iv;
            $i$f$getClassBytes = false;
            v7 = it$iv.getClassLoader().getResourceAsStream(StringsKt.Method9968(it$iv.getName(), ".", "/", false, 4, null) + ".class");
            if (v7 == null) {
                $i$f$getClassChecksum2 = LaunchClassLoader.class.getDeclaredField("resourceCache");
                var50_140 = false;
                fields$iv$iv = false;
                it$iv$iv = $i$f$getClassChecksum2;
                $i$a$-let-ClassSigGen$getClassBytes$1$iv$iv = false;
                it$iv$iv.setAccessible(true);
                v8 = it$iv$iv.get((Object)Launch.classLoader);
                if (v8 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
                }
                var25_98 = (Map)v8;
                var51_141 = (byte[])var25_98.get(it$iv.getName());
                v7 = new ByteArrayInputStream(var51_141);
            }
            var26_99 = IOUtils.toByteArray((InputStream)v7);
            this_$iv$iv.update((byte[])var26_99);
        }
        cs = hash$iv.digest();
        this_$iv = stream;
        key$iv = cs;
        $i$f$setKey = false;
        v9 = new byte[11];
        v9[0] = 32;
        v9[1] = 120;
        v9[2] = 45;
        v9[3] = 34;
        v9[4] = 66;
        v9[5] = 43;
        v9[6] = 87;
        v9[7] = 54;
        v10 = this_$iv;
        hash$iv = v10.Method8438();
        v10.Method8431((byte)(hash$iv + 1));
        v9[8] = hash$iv;
        v9[9] = 16;
        v9[10] = 86;
        this_$iv.Method8444(v9);
        v11 = Encryption.Field4545.Method6540(12);
        if (v11 == null) {
            Intrinsics.Method6551();
        }
        this_$iv.Method8440(v11);
        hash$iv = key$iv;
        $this$forEach$iv$iv = Encryption.Field4545;
        $i$f$forEach = this_$iv;
        $i$f$hexString = false;
        $this$hexString$iv$iv = var12_41 = ArraysKt.Method11276((byte[])$this$hexString$iv$iv, "", null, null, 0, null, UtilsKt$hexString$1.Field3792, 30, null);
        $i$f$hexString = false;
        v12 = $this$hexString$iv$iv;
        if (v12 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        var12_41 = v12.toCharArray();
        v13 = $this$forEach$iv$iv.Method6537((char[])var12_41, this_$iv.Method8436());
        if (v13 == null) {
            Intrinsics.Method6551();
        }
        $i$f$forEach.Method8432(v13);
        this_$iv = stream;
        value$iv = 42;
        $i$f$writeInt = false;
        $this$hexString$iv$iv = this_$iv;
        byteArray$iv$iv /* !! */  = ByteBuffer.allocate(4).putInt(value$iv).array();
        $i$f$writeByteArray = false;
        newBytes$iv$iv = Encryption.Field4545.Method6534(byteArray$iv$iv /* !! */ , this_$iv$iv.Method8442(), this_$iv$iv.Method8445());
        var12_41 = this_$iv$iv.Method8441();
        if (newBytes$iv$iv == null) {
            Intrinsics.Method6551();
        }
        bytes$iv$iv$iv = newBytes$iv$iv;
        $i$f$writeByteArray = false;
        $this$writeByteArray$iv$iv$iv.writeInt(bytes$iv$iv$iv.length);
        $this$writeByteArray$iv$iv$iv.write(bytes$iv$iv$iv);
        this_$iv = stream;
        value$iv = "life, the universe, and everything";
        $i$f$writeInt = Charsets.Field5722;
        this_$iv$iv = false;
        byteArray$iv = value$iv.getBytes($i$f$writeInt);
        $i$f$writeByteArray = false;
        newBytes$iv = Encryption.Field4545.Method6534(byteArray$iv, this_$iv.Method8442(), this_$iv.Method8445());
        byteArray$iv$iv /* !! */  = (byte[])this_$iv.Method8441();
        if (newBytes$iv == null) {
            Intrinsics.Method6551();
        }
        bytes$iv$iv = newBytes$iv;
        $i$f$writeByteArray = false;
        $this$writeByteArray$iv$iv.writeInt(bytes$iv$iv.length);
        $this$writeByteArray$iv$iv.write(bytes$iv$iv);
        classloaderA = new NestedClassloader(SixthLayer.Field37.getClass().getClassLoader());
        this_$iv = stream;
        $i$f$readByteArray = false;
        $this$readByteArray$iv$iv = this_$iv.Method8437();
        $i$f$readByteArray = false;
        $i$f$writeByteArray = $this$readByteArray$iv$iv;
        length$iv$iv$iv = $this$readByteArray$iv$iv.readInt();
        $i$f$readByteArray = false;
        array$iv$iv$iv = new byte[length$iv$iv$iv];
        for (bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < length$iv$iv$iv; bytesRead$iv$iv$iv += read$iv$iv$iv) {
            read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(array$iv$iv$iv, bytesRead$iv$iv$iv, array$iv$iv$iv.length - bytesRead$iv$iv$iv);
            if (read$iv$iv$iv == -1) break;
        }
        encrypted$iv = array$iv$iv$iv;
        nextBytes = Encryption.Field4545.Method6539(encrypted$iv, this_$iv.Method8442());
        $i$f$dpkgZip = false;
        $this$readByteArray$iv$iv = false;
        map$iv = new LinkedHashMap<K, V>();
        zipIn$iv = new ZipInputStream(new ByteArrayInputStream(nextBytes));
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
                it$iv = zipIn$iv.read((byte[])contents$iv, 0, ((byte[])contents$iv).length);
                $i$a$-also-Utils$dpkgZip$1$iv = false;
                encrypted$iv = false;
                it$iv = it$iv;
                $i$a$-also-Utils$dpkgZip$2$iv = false;
                direct$iv.Field284 = it$iv;
                if (it$iv < 0) break;
                stream$iv.write((byte[])contents$iv, 0, direct$iv.Field284);
            }
            v14 = (ZipEntry)entry$iv.Field5552;
            if (v14 == null) {
                Intrinsics.Method6551();
            }
            map$iv.put(v14.getName(), stream$iv.toByteArray());
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
            $i$a$-also-Utils$dpkgZip$1$iv = false;
            name$iv = (String)it$iv.getKey();
            it$iv = map$iv;
            $i$a$-also-Utils$dpkgZip$1$iv = false;
            bytes$iv = (byte[])it$iv.getValue();
            if (StringsKt.Method10002(name$iv, ".class", false, 2, null)) {
                classMap$iv.put(StringsKt.Method11415(StringsKt.Method9968(name$iv, "/", ".", false, 4, null), ".class", null, 2, null), bytes$iv);
                continue;
            }
            classMap$iv.put(name$iv, bytes$iv);
            PyroClientLoadingPlugin.Field7534.put(name$iv, bytes$iv);
        }
        files$iv = classMap$iv;
        $i$f$process = false;
        map$iv = false;
        it = files$iv;
        $i$a$-also-SixthLayer$run$classes$1 = false;
        $this$forEach$iv = it;
        $i$f$forEach = false;
        it$iv = $this$forEach$iv;
        $i$a$-also-Utils$dpkgZip$1$iv = false;
        encrypted$iv = it$iv.entrySet().iterator();
        while (encrypted$iv.hasNext()) {
            $dstr$name$bytes = element$iv = encrypted$iv.next();
            $i$a$-forEach-SixthLayer$run$classes$1$1 = false;
            fields$iv$iv = $dstr$name$bytes;
            var22_90 = false;
            name = (String)fields$iv$iv.getKey();
            fields$iv$iv = $dstr$name$bytes;
            var22_90 = false;
            bytes = (byte[])fields$iv$iv.getValue();
            classloaderA.Method4761(name, bytes);
        }
        classes = files$iv;
        classloaderBClass = classloaderA.loadClass("dev.nuker.pyro.security.NestedClassloader");
        classloaderB = classloaderBClass.getConstructor(new Class[]{ClassLoader.class}).newInstance(new Object[]{SixthLayer.Field37.getClass().getClassLoader()});
        $this$forEach$iv = classes;
        $i$f$forEach = false;
        var12_45 = $this$forEach$iv;
        var13_53 = false;
        var14_60 = var12_45.entrySet().iterator();
        while (var14_60.hasNext()) {
            $dstr$name$bytes = element$iv = var14_60.next();
            $i$a$-forEach-SixthLayer$run$1 = false;
            var18_74 = $dstr$name$bytes;
            var19_79 = false;
            name = (String)var18_74.getKey();
            var18_74 = $dstr$name$bytes;
            var19_79 = false;
            bytes = (byte[])var18_74.getValue();
            classloaderBClass.getMethod("loadResource", new Class[]{String.class, byte[].class}).invoke(classloaderB, new Object[]{name, bytes});
        }
        v15 = classloaderBClass.getMethod("loadClass", new Class[]{String.class}).invoke(classloaderB, new Object[]{"dev.nuker.pyro.layer.SeventhLayer"});
        if (v15 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
        }
        method = ((Class)v15).getMethod("run", new Class[]{ClassLoader.class, LoaderGui.class, byte[].class, DataInputStream.class, DataOutputStream.class});
        method.invoke(null, new Object[]{SixthLayer.Field37.getClass().getClassLoader(), gui, cs, si, so});
    }

    static {
        SixthLayer sixthLayer;
        Field37 = sixthLayer = new SixthLayer();
    }
}

