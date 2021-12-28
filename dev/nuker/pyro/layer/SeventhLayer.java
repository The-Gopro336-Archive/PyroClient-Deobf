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

public class SeventhLayer {
    public static SeventhLayer Field6154;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static void Method8890(@NotNull ClassLoader var0, @NotNull LoaderGui var1_1, @NotNull byte[] var2_2, @NotNull DataInputStream var3_3, @NotNull DataOutputStream var4_4) {
        var6_6 = stream = new EncryptedStreamWrapper((DataInputStream)si, (DataOutputStream)so);
        var7_7 = ClassSigGen.Field911;
        classes$iv = new Class[]{SecondLayer.class, ThirdLayer.class, TopLayer.class, FifthLayer.class, FourthLayer.class};
        $i$f$getCombinedChecksum2 = 0;
        hash$iv = MessageDigest.getInstance("MD5");
        $this$forEach$iv$iv = classes$iv;
        $i$f$forEach = false;
        var13_42 = $this$forEach$iv$iv;
        var14_57 = var13_42.length;
        var15_73 = 0;
        while (true) {
            if (var15_73 < var14_57) {
                it$iv = element$iv$iv = var13_42[var15_73];
                $i$a$-forEach-ClassSigGen$getCombinedChecksum2$1$iv = false;
                var19_104 = ClassSigGen.Field911;
                var20_110 = hash$iv;
                $i$f$getClassChecksum2 = false;
                hash$iv$iv = MessageDigest.getInstance("MD5");
                var23_124 = false;
                methods$iv$iv = var24_127 = (List)new ArrayList<E>();
                var26_130 = false;
                fields$iv$iv = var24_127 = (List)new ArrayList<E>();
                $this$forEach$iv$iv$iv = it$iv.getDeclaredFields();
                $i$f$forEach = false;
                var28_135 = $this$forEach$iv$iv$iv;
                var29_136 = ((Field[])var28_135).length;
            } else {
                $this$forEach$iv$iv = classes$iv;
                $i$f$forEach = false;
                var13_43 = $this$forEach$iv$iv;
                var14_58 = var13_43.length;
                break;
            }
            for (var30_139 = 0; var30_139 < var29_136; ++var30_139) {
                block67: {
                    block64: {
                        block62: {
                            block65: {
                                block63: {
                                    block66: {
                                        it$iv$iv = element$iv$iv$iv = var28_135[var30_139];
                                        $i$a$-forEach-ClassSigGen$getClassChecksum2$1$iv$iv = false;
                                        v0 = new StringBuilder();
                                        var34_149 = ClassSigGen.Field911;
                                        it$iv$iv.getType().getName();
                                        var36_153 = v0.append(it$iv$iv.getModifiers()).append(' ').append(it$iv$iv.getName()).append(' ');
                                        var37_154 = fields$iv$iv;
                                        $i$f$getDescriptor = false;
                                        var39_158 = name$iv$iv$iv;
                                        switch (var39_158.hashCode()) {
                                            case 64711720: {
                                                if (!var39_158.equals("boolean")) ** break;
                                                break;
                                            }
                                            case 3625364: {
                                                if (!var39_158.equals("void")) ** break;
                                                break block62;
                                            }
                                            case -1325958191: {
                                                if (!var39_158.equals("double")) ** break;
                                                break block63;
                                            }
                                            case 3039496: {
                                                if (!var39_158.equals("byte")) break block64;
                                                break block65;
                                            }
                                            case 97526364: {
                                                if (!var39_158.equals("float")) ** break;
                                                break block66;
                                            }
                                            case 104431: {
                                                if (!var39_158.equals("int")) break block64;
                                                v1 = "I";
                                                break block67;
                                            }
                                        }
                                        v1 = "Z";
                                        break block67;
                                    }
                                    v1 = "F";
                                    break block67;
                                }
                                v1 = "D";
                                break block67;
                            }
                            v1 = "B";
                            break block67;
                        }
                        v1 = "V";
                        break block67;
                    }
                    v1 = StringsKt.Method9998((String)name$iv$iv$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                }
                var40_159 = v1;
                var37_154.add(var36_153.append(var40_159).toString());
            }
            $this$forEach$iv$iv$iv = it$iv.getDeclaredMethods();
            $i$f$forEach = false;
            var28_135 = $this$forEach$iv$iv$iv;
            var29_136 = ((Field[])var28_135).length;
            var30_139 = 0;
            while (true) {
                block79: {
                    block74: {
                        block75: {
                            block77: {
                                block76: {
                                    block78: {
                                        if (var30_139 < var29_136) {
                                            it$iv$iv = element$iv$iv$iv = var28_135[var30_139];
                                            $i$a$-forEach-ClassSigGen$getClassChecksum2$2$iv$iv = false;
                                            v2 = new StringBuilder();
                                            it$iv$iv.getParameters();
                                            var35_150 = v2.append(it$iv$iv.getName()).append(" (");
                                            var36_153 = methods$iv$iv;
                                            $i$f$map = false;
                                            $i$f$getDescriptor = $this$map$iv$iv$iv;
                                            destination$iv$iv$iv$iv = new ArrayList<E>(((void)$this$map$iv$iv$iv).length);
                                            $i$f$mapTo = false;
                                            var41_161 = $this$mapTo$iv$iv$iv$iv;
                                            var42_162 = ((void)var41_161).length;
                                            for (var43_164 = 0; var43_164 < var42_162; ++var43_164) {
                                                var45_168 = item$iv$iv$iv$iv = var41_161[var43_164];
                                                var46_169 = destination$iv$iv$iv$iv;
                                                $i$a$-map-ClassSigGen$getClassChecksum2$2$1$iv$iv = false;
                                                var48_172 = it$iv$iv.getType();
                                                var46_169.add(var48_172);
                                            }
                                            var46_169 = (List)destination$iv$iv$iv$iv;
                                            $this$map$iv$iv$iv = (Iterable)var46_169;
                                            $i$f$map = false;
                                            $this$mapTo$iv$iv$iv$iv = $this$map$iv$iv$iv;
                                            destination$iv$iv$iv$iv = new ArrayList<E>(CollectionsKt.Method9458($this$map$iv$iv$iv, 10));
                                            $i$f$mapTo = false;
                                            var41_161 = $this$mapTo$iv$iv$iv$iv.iterator();
                                        } else {
                                            $this$forEach$iv$iv$iv = CollectionsKt.Method3129(fields$iv$iv, ClassSigGen$getClassChecksum2$3.Field7245);
                                            $i$f$forEach = false;
                                            var28_135 = $this$forEach$iv$iv$iv.iterator();
                                            break;
                                        }
                                        while (var41_161.hasNext()) {
                                            block73: {
                                                block71: {
                                                    block68: {
                                                        block70: {
                                                            block69: {
                                                                block72: {
                                                                    item$iv$iv$iv$iv = var41_161.next();
                                                                    var43_165 = (Class)item$iv$iv$iv$iv;
                                                                    var46_169 = destination$iv$iv$iv$iv;
                                                                    $i$a$-map-ClassSigGen$getClassChecksum2$2$2$iv$iv = false;
                                                                    it$iv$iv = ClassSigGen.Field911;
                                                                    it$iv$iv.getName();
                                                                    $i$f$getDescriptor = false;
                                                                    var50_174 = name$iv$iv$iv;
                                                                    switch (var50_174.hashCode()) {
                                                                        case 64711720: {
                                                                            if (!var50_174.equals("boolean")) ** break;
                                                                            break;
                                                                        }
                                                                        case 3625364: {
                                                                            if (!var50_174.equals("void")) ** break;
                                                                            break block68;
                                                                        }
                                                                        case -1325958191: {
                                                                            if (!var50_174.equals("double")) ** break;
                                                                            break block69;
                                                                        }
                                                                        case 3039496: {
                                                                            if (!var50_174.equals("byte")) ** break;
                                                                            break block70;
                                                                        }
                                                                        case 97526364: {
                                                                            if (!var50_174.equals("float")) break block71;
                                                                            break block72;
                                                                        }
                                                                        case 104431: {
                                                                            if (!var50_174.equals("int")) ** break;
                                                                            v3 = "I";
                                                                            break block73;
                                                                        }
                                                                    }
                                                                    v3 = "Z";
                                                                    break block73;
                                                                }
                                                                v3 = "F";
                                                                break block73;
                                                            }
                                                            v3 = "D";
                                                            break block73;
                                                        }
                                                        v3 = "B";
                                                        break block73;
                                                    }
                                                    v3 = "V";
                                                    break block73;
                                                }
                                                v3 = StringsKt.Method9998(name$iv$iv$iv, "[", false, 2, null) ? StringsKt.Method9968(name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968(name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                                            }
                                            var48_172 = v3;
                                            var46_169.add(var48_172);
                                        }
                                        var46_169 = (List)destination$iv$iv$iv$iv;
                                        $this$map$iv$iv$iv = ClassSigGen.Field911;
                                        it$iv$iv.getReturnType().getName();
                                        var35_150 = var35_150.append(CollectionsKt.Method3238((Iterable)var46_169, "", null, null, 0, null, null, 62, null)).append(')');
                                        $i$f$getDescriptor = false;
                                        var39_158 = name$iv$iv$iv;
                                        switch (var39_158.hashCode()) {
                                            case 64711720: {
                                                if (var39_158.equals("boolean")) {
                                                    break;
                                                }
                                                break block74;
                                            }
                                            case 3625364: {
                                                if (!var39_158.equals("void")) ** break;
                                                break block75;
                                            }
                                            case -1325958191: {
                                                if (!var39_158.equals("double")) ** break;
                                                break block76;
                                            }
                                            case 3039496: {
                                                if (!var39_158.equals("byte")) break block74;
                                                break block77;
                                            }
                                            case 97526364: {
                                                if (!var39_158.equals("float")) ** break;
                                                break block78;
                                            }
                                            case 104431: {
                                                if (!var39_158.equals("int")) ** break;
                                                v4 = "I";
                                                break block79;
                                            }
                                        }
                                        v4 = "Z";
                                        break block79;
                                    }
                                    v4 = "F";
                                    break block79;
                                }
                                v4 = "D";
                                break block79;
                            }
                            v4 = "B";
                            break block79;
                        }
                        v4 = "V";
                        break block79;
                    }
                    v4 = StringsKt.Method9998((String)name$iv$iv$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv$iv$iv, ".", "/", false, 4, null) + ';';
                }
                var46_169 = v4;
                var36_153.add(var35_150.append((String)var46_169).toString());
                ++var30_139;
            }
            while (var28_135.hasNext()) {
                element$iv$iv$iv = var28_135.next();
                it$iv$iv = (String)element$iv$iv$iv;
                $i$a$-forEach-ClassSigGen$getClassChecksum2$4$iv$iv = false;
                var32_145 = it$iv$iv;
                var33_147 = hash$iv$iv;
                var34_149 = Charsets.Field5722;
                var35_151 = false;
                v5 = var32_145;
                if (v5 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var36_153 = v5.getBytes((Charset)var34_149);
                var33_147.update((byte[])var36_153);
            }
            $this$forEach$iv$iv$iv = CollectionsKt.Method3129(methods$iv$iv, ClassSigGen$getClassChecksum2$5.Field7246);
            $i$f$forEach = false;
            var28_135 = $this$forEach$iv$iv$iv.iterator();
            while (var28_135.hasNext()) {
                element$iv$iv$iv = var28_135.next();
                it$iv$iv = (String)element$iv$iv$iv;
                $i$a$-forEach-ClassSigGen$getClassChecksum2$6$iv$iv = false;
                var32_145 = it$iv$iv;
                var33_148 = hash$iv$iv;
                var34_149 = Charsets.Field5722;
                var35_152 = false;
                v6 = var32_145;
                if (v6 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var36_153 = v6.getBytes((Charset)var34_149);
                var33_148.update((byte[])var36_153);
            }
            var20_110.update(var51_175.digest());
            ++var15_73;
        }
        for (var15_73 = 0; var15_73 < var14_58; ++var15_73) {
            it$iv = element$iv$iv = var13_43[var15_73];
            $i$a$-forEach-ClassSigGen$getCombinedChecksum2$2$iv = false;
            this_$iv$iv = hash$iv;
            $i$f$getClassBytes = false;
            v7 = it$iv.getClassLoader().getResourceAsStream(StringsKt.Method9968(it$iv.getName(), ".", "/", false, 4, null) + ".class");
            if (v7 == null) {
                $i$f$getClassChecksum2 = LaunchClassLoader.class.getDeclaredField("resourceCache");
                var52_176 = false;
                fields$iv$iv = false;
                it$iv$iv = $i$f$getClassChecksum2;
                $i$a$-let-ClassSigGen$getClassBytes$1$iv$iv = false;
                it$iv$iv.setAccessible(true);
                v8 = it$iv$iv.get((Object)Launch.classLoader);
                if (v8 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
                }
                var27_134 = (Map)v8;
                var53_177 = (byte[])var27_134.get(it$iv.getName());
                v7 = new ByteArrayInputStream(var53_177);
            }
            var28_135 = IOUtils.toByteArray((InputStream)v7);
            this_$iv$iv.update((byte[])var28_135);
        }
        key$iv = hash$iv.digest();
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
        $i$f$getCombinedChecksum2 = v10.Method8438();
        v10.Method8431((byte)($i$f$getCombinedChecksum2 + 1));
        v9[8] = $i$f$getCombinedChecksum2;
        v9[9] = 16;
        v9[10] = 86;
        this_$iv.Method8444(v9);
        v11 = Encryption.Field4545.Method6540(12);
        if (v11 == null) {
            Intrinsics.Method6551();
        }
        this_$iv.Method8440(v11);
        $i$f$getCombinedChecksum2 = key$iv;
        hash$iv = Encryption.Field4545;
        $this$forEach$iv$iv = this_$iv;
        $i$f$hexString = false;
        var13_44 = ArraysKt.Method11276((byte[])$this$hexString$iv$iv, "", null, null, 0, null, UtilsKt$hexString$1.Field3792, 30, null);
        $this$hexString$iv$iv = var13_44;
        $i$f$hexString = false;
        v12 = $this$hexString$iv$iv;
        if (v12 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        var13_45 = v12.toCharArray();
        v13 = hash$iv.Method6537(var13_45, this_$iv.Method8436());
        if (v13 == null) {
            Intrinsics.Method6551();
        }
        $this$forEach$iv$iv.Method8432(v13);
        this_$iv = stream;
        $i$f$writeByteArray = false;
        newBytes$iv = Encryption.Field4545.Method6534((byte[])cs, this_$iv.Method8442(), this_$iv.Method8445());
        $this$hexString$iv$iv = this_$iv.Method8441();
        if (newBytes$iv == null) {
            Intrinsics.Method6551();
        }
        bytes$iv$iv = newBytes$iv;
        $i$f$writeByteArray = false;
        $this$writeByteArray$iv$iv.writeInt(bytes$iv$iv.length);
        $this$writeByteArray$iv$iv.write(bytes$iv$iv);
        classloader = new NestedClassloader(SeventhLayer.Field6154.getClass().getClassLoader());
        this_$iv = stream;
        $i$f$readByteArray = false;
        $this$readByteArray$iv$iv = this_$iv.Method8437();
        $i$f$readByteArray = false;
        $i$f$hexString = $this$readByteArray$iv$iv;
        var13_46 = $this$readByteArray$iv$iv.readInt();
        var14_59 = false;
        array$iv$iv$iv = new byte[var13_46];
        for (bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < var13_46 && (read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(array$iv$iv$iv, bytesRead$iv$iv$iv, array$iv$iv$iv.length - bytesRead$iv$iv$iv)) != -1; bytesRead$iv$iv$iv += read$iv$iv$iv) {
        }
        encrypted$iv = array$iv$iv$iv;
        br = Encryption.Field4545.Method6539(encrypted$iv, this_$iv.Method8442());
        $i$f$dpkgZip = false;
        $i$f$readByteArray = false;
        map$iv = new LinkedHashMap<K, V>();
        zipIn$iv = new ZipInputStream(new ByteArrayInputStream(br));
        entry$iv = new Ref.ObjectRef<T>();
        while (true) {
            $this$readByteArray$iv$iv$iv = zipIn$iv.getNextEntry();
            var13_47 = false;
            var14_60 = false;
            it$iv = $this$readByteArray$iv$iv$iv;
            $i$a$-also-Utils$dpkgZip$1$iv = false;
            entry$iv.Field5552 = it$iv;
            if ($this$readByteArray$iv$iv$iv == null) break;
            contents$iv = new byte[4096];
            var13_48 = new Ref.IntRef();
            var14_61 = new ByteArrayOutputStream();
            while (true) {
                it$iv = zipIn$iv.read((byte[])contents$iv, 0, ((Object)contents$iv).length);
                $i$a$-also-Utils$dpkgZip$1$iv = false;
                read$iv$iv$iv = false;
                it$iv = it$iv;
                $i$a$-also-Utils$dpkgZip$2$iv = false;
                var13_48.Field284 = it$iv;
                if (it$iv < 0) break;
                var14_61.write((byte[])contents$iv, 0, var13_48.Field284);
            }
            v14 = (ZipEntry)entry$iv.Field5552;
            if (v14 == null) {
                Intrinsics.Method6551();
            }
            map$iv.put(v14.getName(), var14_61.toByteArray());
            zipIn$iv.closeEntry();
        }
        files$iv = map$iv;
        $i$f$process = false;
        map$iv = false;
        classMap$iv = new LinkedHashMap<K, V>();
        contents$iv = files$iv;
        var13_49 = false;
        for (Map.Entry<K, V> map$iv : contents$iv.entrySet()) {
            it$iv = map$iv;
            $i$a$-also-Utils$dpkgZip$1$iv = false;
            name$iv = (String)it$iv.getKey();
            it$iv = map$iv;
            $i$a$-also-Utils$dpkgZip$1$iv = false;
            var13_50 = (byte[])it$iv.getValue();
            if (StringsKt.Method10002(name$iv, ".class", false, 2, null)) {
                classMap$iv.put(StringsKt.Method11415(StringsKt.Method9968(name$iv, "/", ".", false, 4, null), ".class", null, 2, null), var13_50);
                continue;
            }
            classMap$iv.put(name$iv, var13_50);
            PyroClientLoadingPlugin.Field7534.put(name$iv, var13_50);
        }
        files$iv = classMap$iv;
        $i$f$process = false;
        map$iv = false;
        it = files$iv;
        $i$a$-also-SeventhLayer$run$1 = false;
        var13_51 = it;
        var14_63 = false;
        it$iv = var13_51;
        $i$a$-also-Utils$dpkgZip$1$iv = false;
        read$iv$iv$iv = it$iv.entrySet().iterator();
        while (read$iv$iv$iv.hasNext()) {
            $dstr$name$bytes = element$iv = read$iv$iv$iv.next();
            $i$a$-forEach-SeventhLayer$run$1$1 = false;
            $i$f$getClassChecksum2 = $dstr$name$bytes;
            var22_122 = false;
            name = (String)$i$f$getClassChecksum2.getKey();
            $i$f$getClassChecksum2 = $dstr$name$bytes;
            var22_122 = false;
            bytes = (byte[])$i$f$getClassChecksum2.getValue();
            classloader.Method4761(name, bytes);
        }
        v15 = classloader.loadClass("dev.nuker.pyro.security.FlagChecker").getMethod("recheck", new Class[0]).invoke(null, new Object[0]);
        if (v15 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        ret = (Integer)v15;
        this_$iv = stream;
        $i$f$writeInt = false;
        it = this_$iv;
        byteArray$iv$iv = ByteBuffer.allocate(4).putInt(ret).array();
        var13_52 = false;
        var14_64 = Encryption.Field4545.Method6534(byteArray$iv$iv, this_$iv$iv.Method8442(), this_$iv$iv.Method8445());
        it$iv = this_$iv$iv.Method8441();
        if (var14_64 == null) {
            Intrinsics.Method6551();
        }
        bytes$iv$iv$iv = var14_64;
        $i$f$writeByteArray = false;
        $this$writeByteArray$iv$iv$iv.writeInt(bytes$iv$iv$iv.length);
        $this$writeByteArray$iv$iv$iv.write(bytes$iv$iv$iv);
        this_$iv = stream;
        $i$f$readByteArray = false;
        $this$readByteArray$iv$iv = this_$iv.Method8437();
        var13_53 = false;
        var14_65 = $this$readByteArray$iv$iv;
        length$iv$iv$iv = $this$readByteArray$iv$iv.readInt();
        $i$f$readByteArray = false;
        array$iv$iv$iv = new byte[length$iv$iv$iv];
        for (bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < length$iv$iv$iv && (read$iv$iv$iv = var14_65.read(array$iv$iv$iv, bytesRead$iv$iv$iv, array$iv$iv$iv.length - bytesRead$iv$iv$iv)) != -1; bytesRead$iv$iv$iv += read$iv$iv$iv) {
        }
        encrypted$iv = array$iv$iv$iv;
        nextBytes = Encryption.Field4545.Method6539(encrypted$iv, this_$iv.Method8442());
        $i$f$dpkgZip = false;
        $i$f$readByteArray = false;
        map$iv = new LinkedHashMap<K, V>();
        zipIn$iv = new ZipInputStream(new ByteArrayInputStream(nextBytes));
        var13_54 = new Ref.ObjectRef<T>();
        while (true) {
            var14_67 = zipIn$iv.getNextEntry();
            length$iv$iv$iv = false;
            $i$f$readByteArray = false;
            it$iv = var14_67;
            $i$a$-also-Utils$dpkgZip$1$iv = false;
            var13_54.Field5552 = it$iv;
            if (var14_67 == null) break;
            var14_68 = new byte[4096];
            direct$iv = new Ref.IntRef();
            stream$iv = new ByteArrayOutputStream();
            while (true) {
                it$iv = zipIn$iv.read(var14_68, 0, var14_68.length);
                var18_102 = false;
                var19_108 = false;
                it$iv = it$iv;
                $i$a$-also-Utils$dpkgZip$2$iv = false;
                direct$iv.Field284 = it$iv;
                if (it$iv < 0) break;
                stream$iv.write(var14_68, 0, direct$iv.Field284);
            }
            v16 = (ZipEntry)var13_54.Field5552;
            if (v16 == null) {
                Intrinsics.Method6551();
            }
            map$iv.put(v16.getName(), stream$iv.toByteArray());
            zipIn$iv.closeEntry();
        }
        files$iv = map$iv;
        $i$f$process = false;
        var12_39 = false;
        var13_55 = new LinkedHashMap<K, V>();
        var14_69 = files$iv;
        direct$iv = false;
        stream$iv = var14_69.entrySet().iterator();
        while (stream$iv.hasNext()) {
            it$iv = var12_40 = stream$iv.next();
            var18_102 = false;
            var14_71 = (String)it$iv.getKey();
            it$iv = var12_40;
            var18_102 = false;
            bytes$iv = (byte[])it$iv.getValue();
            if (StringsKt.Method10002(var14_71, ".class", false, 2, null)) {
                var13_55.put(StringsKt.Method11415(StringsKt.Method9968(var14_71, "/", ".", false, 4, null), ".class", null, 2, null), bytes$iv);
                continue;
            }
            var13_55.put(var14_71, bytes$iv);
            PyroClientLoadingPlugin.Field7534.put(var14_71, bytes$iv);
        }
        $this$forEach$iv = var13_55;
        $i$f$forEach = false;
        var12_41 = $this$forEach$iv;
        var13_56 = false;
        var14_72 = var12_41.entrySet().iterator();
        while (true) {
            if (!var14_72.hasNext()) {
                method = classloader.loadClass("dev.nuker.pyro.layer.DownloadLayer").getMethod("run", new Class[]{LoaderGui.class, DataInputStream.class, DataOutputStream.class});
                method.invoke(null, new Object[]{gui, si, so});
                return;
            }
            $dstr$name$bytes = element$iv = var14_72.next();
            $i$a$-forEach-SeventhLayer$run$2 = false;
            var18_103 = $dstr$name$bytes;
            var19_109 = false;
            name = (String)var18_103.getKey();
            var18_103 = $dstr$name$bytes;
            var19_109 = false;
            bytes = (byte[])var18_103.getValue();
            classloader.Method4761(name, bytes);
        }
    }

    static {
        SeventhLayer seventhLayer;
        Field6154 = seventhLayer = new SeventhLayer();
    }
}

