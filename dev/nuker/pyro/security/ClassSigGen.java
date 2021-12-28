/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.Launch
 *  net.minecraft.launchwrapper.LaunchClassLoader
 *  org.apache.commons.io.IOUtils
 *  org.jetbrains.annotations.NotNull
 *  sun.misc.SharedSecrets
 */
package dev.nuker.pyro.security;

import dev.nuker.pyro.security.ClassSigGen$getClassChecksum2$3;
import dev.nuker.pyro.security.ClassSigGen$getClassChecksum2$5;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import sun.misc.SharedSecrets;

public class ClassSigGen {
    public static ClassSigGen Field911;

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @NotNull
    public String Method1413(@NotNull String string) {
        void name;
        boolean $i$f$getDescriptor = false;
        void var3_3 = name;
        switch (var3_3.hashCode()) {
            case 64711720: {
                if (!var3_3.equals("boolean")) break;
                return "Z";
            }
            case 3625364: {
                if (!var3_3.equals("void")) break;
                return "V";
            }
            case -1325958191: {
                if (!var3_3.equals("double")) break;
                return "D";
            }
            case 3039496: {
                if (!var3_3.equals("byte")) break;
                return "B";
            }
            case 97526364: {
                if (!var3_3.equals("float")) break;
                return "F";
            }
            case 104431: {
                if (!var3_3.equals("int")) break;
                return "I";
            }
        }
        String string2 = StringsKt.Method9998((String)name, "[", false, 2, null) ? StringsKt.Method9968((String)name, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name, ".", "/", false, 4, null) + ';';
        return string2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public MessageDigest Method1414(Class ... arrclass) {
        Object object;
        void $this$flatMapTo$iv$iv;
        void classes;
        boolean $i$f$getCombinedChecksum = false;
        MessageDigest hash = MessageDigest.getInstance("MD5");
        void $this$flatMap$iv = classes;
        boolean $i$f$flatMap = false;
        Object object2 = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        void var9_11 = $this$flatMapTo$iv$iv;
        int n = ((void)var9_11).length;
        for (int i = 0; i < n; ++i) {
            String string;
            Parameter it$iv;
            Collection<String> collection;
            Parameter[] $this$mapTo$iv$iv$iv;
            boolean $i$f$mapTo;
            Collection destination$iv$iv$iv;
            Parameter[] $this$map$iv$iv;
            boolean $i$f$map;
            List list;
            Field it$iv2;
            AccessibleObject element$iv$iv;
            int n2;
            void element$iv$iv2;
            void it = element$iv$iv2 = var9_11[i];
            boolean bl = false;
            boolean $i$f$getReflectMashup = false;
            boolean bl2 = false;
            List data$iv = new ArrayList();
            AccessibleObject[] $this$forEach$iv$iv = it.getDeclaredFields();
            boolean $i$f$forEach = false;
            AccessibleObject[] arraccessibleObject = $this$forEach$iv$iv;
            int n3 = arraccessibleObject.length;
            for (n2 = 0; n2 < n3; ++n2) {
                it$iv2 = element$iv$iv = arraccessibleObject[n2];
                boolean bl3 = false;
                data$iv.add(it$iv2.getType().getName());
                data$iv.add(it$iv2.getName());
            }
            $this$forEach$iv$iv = it.getDeclaredMethods();
            $i$f$forEach = false;
            arraccessibleObject = $this$forEach$iv$iv;
            n3 = arraccessibleObject.length;
            for (n2 = 0; n2 < n3; ++n2) {
                it$iv2 = element$iv$iv = arraccessibleObject[n2];
                boolean bl4 = false;
                data$iv.add(String.valueOf(((Method)((Object)it$iv2)).getModifiers()));
                data$iv.add(((Method)((Object)it$iv2)).getName());
                data$iv.add(String.valueOf(((Method)((Object)it$iv2)).getParameterCount()));
                ((Method)((Object)it$iv2)).getParameterTypes();
                list = data$iv;
                $i$f$map = false;
                void var28_43 = $this$map$iv$iv;
                destination$iv$iv$iv = new ArrayList($this$map$iv$iv.length);
                $i$f$mapTo = false;
                for (Parameter item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
                    void var35_50 = item$iv$iv$iv;
                    collection = destination$iv$iv$iv;
                    boolean bl5 = false;
                    string = ((Class)((Object)it$iv)).getName();
                    collection.add(string);
                }
                collection = (List)destination$iv$iv$iv;
                list.addAll((Collection)collection);
            }
            data$iv.add(it.getSimpleName());
            data$iv.add(String.valueOf(SharedSecrets.getJavaLangAccess().getConstantPool((Class)it).getSize()));
            data$iv.addAll(Field911.Method1417(it.getDeclaredClasses()));
            $this$forEach$iv$iv = it.getConstructors();
            $i$f$forEach = false;
            arraccessibleObject = $this$forEach$iv$iv;
            n3 = arraccessibleObject.length;
            for (n2 = 0; n2 < n3; ++n2) {
                it$iv2 = element$iv$iv = arraccessibleObject[n2];
                boolean bl6 = false;
                data$iv.add(String.valueOf(((Constructor)((Object)it$iv2)).getModifiers()));
                ((Executable)((Object)it$iv2)).getParameters();
                list = data$iv;
                $i$f$map = false;
                $this$mapTo$iv$iv$iv = $this$map$iv$iv;
                destination$iv$iv$iv = new ArrayList($this$map$iv$iv.length);
                $i$f$mapTo = false;
                Parameter[] arrparameter = $this$mapTo$iv$iv$iv;
                int n4 = arrparameter.length;
                for (int j = 0; j < n4; ++j) {
                    Parameter item$iv$iv$iv;
                    it$iv = item$iv$iv$iv = arrparameter[j];
                    collection = destination$iv$iv$iv;
                    boolean bl7 = false;
                    string = it$iv.getName();
                    collection.add(string);
                }
                collection = (List)destination$iv$iv$iv;
                list.addAll(collection);
                data$iv.add(String.valueOf(((Constructor)((Object)it$iv2)).getParameterCount()));
            }
            Iterable list$iv$iv = data$iv;
            CollectionsKt.Method9754(destination$iv$iv, list$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            byte[] arrby;
            String it = (String)element$iv;
            boolean bl = false;
            String string = it;
            MessageDigest messageDigest = hash;
            object = Charsets.Field5722;
            boolean list$iv$iv = false;
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string2.getBytes((Charset)object);
            messageDigest.update(arrby);
        }
        $this$forEach$iv = classes;
        $i$f$forEach = false;
        object2 = $this$forEach$iv;
        int n5 = ((Object)object2).length;
        for (int i = 0; i < n5; ++i) {
            Object element$iv;
            Object it = element$iv = object2[i];
            boolean bl = false;
            object = hash;
            boolean $i$f$getClassBytes = false;
            InputStream inputStream = ((Class)it).getClassLoader().getResourceAsStream(StringsKt.Method9968(((Class)it).getName(), ".", "/", false, 4, null) + ".class");
            if (inputStream == null) {
                Field field = LaunchClassLoader.class.getDeclaredField("resourceCache");
                boolean bl8 = false;
                boolean bl9 = false;
                Field it$iv = field;
                boolean bl10 = false;
                it$iv.setAccessible(true);
                Object object3 = it$iv.get((Object)Launch.classLoader);
                if (object3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
                }
                Map map = (Map)object3;
                byte[] arrby = (byte[])map.get(((Class)it).getName());
                inputStream = new ByteArrayInputStream(arrby);
            }
            byte[] arrby = IOUtils.toByteArray((InputStream)inputStream);
            ((MessageDigest)object).update(arrby);
        }
        return hash;
    }

    @JvmStatic
    @NotNull
    public static List Method1415(@NotNull Class class_) {
        String string;
        Parameter it;
        Collection<String> collection;
        Parameter[] $this$mapTo$iv$iv;
        boolean $i$f$mapTo;
        Collection destination$iv$iv;
        Parameter[] $this$map$iv;
        boolean $i$f$map;
        List list;
        Field it2;
        AccessibleObject element$iv;
        int n;
        Class clazz;
        boolean $i$f$getReflectMashup = false;
        boolean bl = false;
        List data = new ArrayList();
        AccessibleObject[] $this$forEach$iv = clazz.getDeclaredFields();
        boolean $i$f$forEach = false;
        AccessibleObject[] arraccessibleObject = $this$forEach$iv;
        int n2 = arraccessibleObject.length;
        for (n = 0; n < n2; ++n) {
            it2 = element$iv = arraccessibleObject[n];
            boolean bl2 = false;
            data.add(it2.getType().getName());
            data.add(it2.getName());
        }
        $this$forEach$iv = clazz.getDeclaredMethods();
        $i$f$forEach = false;
        arraccessibleObject = $this$forEach$iv;
        n2 = arraccessibleObject.length;
        for (n = 0; n < n2; ++n) {
            it2 = element$iv = arraccessibleObject[n];
            boolean bl3 = false;
            data.add(String.valueOf(((Method)((Object)it2)).getModifiers()));
            data.add(((Method)((Object)it2)).getName());
            data.add(String.valueOf(((Method)((Object)it2)).getParameterCount()));
            ((Method)((Object)it2)).getParameterTypes();
            list = data;
            $i$f$map = false;
            void var14_15 = $this$map$iv;
            destination$iv$iv = new ArrayList($this$map$iv.length);
            $i$f$mapTo = false;
            for (Parameter item$iv$iv : $this$mapTo$iv$iv) {
                void var21_22 = item$iv$iv;
                collection = destination$iv$iv;
                boolean bl4 = false;
                string = ((Class)((Object)it)).getName();
                collection.add(string);
            }
            collection = (List)destination$iv$iv;
            list.addAll((Collection)collection);
        }
        data.add(clazz.getSimpleName());
        data.add(String.valueOf(SharedSecrets.getJavaLangAccess().getConstantPool(clazz).getSize()));
        data.addAll(Field911.Method1417(clazz.getDeclaredClasses()));
        $this$forEach$iv = clazz.getConstructors();
        $i$f$forEach = false;
        arraccessibleObject = $this$forEach$iv;
        n2 = arraccessibleObject.length;
        for (n = 0; n < n2; ++n) {
            it2 = element$iv = arraccessibleObject[n];
            boolean bl5 = false;
            data.add(String.valueOf(((Constructor)((Object)it2)).getModifiers()));
            ((Executable)((Object)it2)).getParameters();
            list = data;
            $i$f$map = false;
            $this$mapTo$iv$iv = $this$map$iv;
            destination$iv$iv = new ArrayList($this$map$iv.length);
            $i$f$mapTo = false;
            Parameter[] arrparameter = $this$mapTo$iv$iv;
            int n3 = arrparameter.length;
            for (int i = 0; i < n3; ++i) {
                Parameter item$iv$iv;
                it = item$iv$iv = arrparameter[i];
                collection = destination$iv$iv;
                boolean bl6 = false;
                string = it.getName();
                collection.add(string);
            }
            collection = (List)destination$iv$iv;
            list.addAll(collection);
            data.add(String.valueOf(((Constructor)((Object)it2)).getParameterCount()));
        }
        return data;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @NotNull
    public MessageDigest Method1416(Class ... var1_1) {
        $i$f$getCombinedChecksum2 = false;
        hash = MessageDigest.getInstance("MD5");
        $this$forEach$iv = classes;
        $i$f$forEach = false;
        var6_6 = $this$forEach$iv;
        var7_7 = ((void)var6_6).length;
        var8_8 = 0;
        while (true) {
            if (var8_8 >= var7_7) break;
            it = element$iv = var6_6[var8_8];
            $i$a$-forEach-ClassSigGen$getCombinedChecksum2$1 = false;
            var12_12 = ClassSigGen.Field911;
            var13_13 = hash;
            $i$f$getClassChecksum2 = false;
            hash$iv = MessageDigest.getInstance("MD5");
            var18_20 = false;
            methods$iv = var19_22 = (List)new ArrayList<E>();
            var20_24 = false;
            fields$iv = var19_22 = (List)new ArrayList<E>();
            $this$forEach$iv$iv = it.getDeclaredFields();
            $i$f$forEach = false;
            var22_29 = $this$forEach$iv$iv;
            var23_30 = ((Field[])var22_29).length;
            for (var24_33 = 0; var24_33 < var23_30; ++var24_33) {
                block46: {
                    block41: {
                        block42: {
                            block44: {
                                block43: {
                                    block45: {
                                        it$iv = element$iv$iv = var22_29[var24_33];
                                        $i$a$-forEach-ClassSigGen$getClassChecksum2$1$iv = false;
                                        v0 = new StringBuilder();
                                        var28_43 = ClassSigGen.Field911;
                                        it$iv.getType().getName();
                                        var30_47 = v0.append(it$iv.getModifiers()).append(' ').append(it$iv.getName()).append(' ');
                                        var31_48 = fields$iv;
                                        $i$f$getDescriptor = false;
                                        var33_52 = name$iv$iv;
                                        switch (var33_52.hashCode()) {
                                            case 64711720: {
                                                if (var33_52.equals("boolean")) {
                                                    break;
                                                }
                                                break block41;
                                            }
                                            case 3625364: {
                                                if (!var33_52.equals("void")) ** break;
                                                break block42;
                                            }
                                            case -1325958191: {
                                                if (!var33_52.equals("double")) break block41;
                                                break block43;
                                            }
                                            case 3039496: {
                                                if (!var33_52.equals("byte")) break block41;
                                                break block44;
                                            }
                                            case 97526364: {
                                                if (!var33_52.equals("float")) ** break;
                                                break block45;
                                            }
                                            case 104431: {
                                                if (!var33_52.equals("int")) ** break;
                                                v1 = "I";
                                                break block46;
                                            }
                                        }
                                        v1 = "Z";
                                        break block46;
                                    }
                                    v1 = "F";
                                    break block46;
                                }
                                v1 = "D";
                                break block46;
                            }
                            v1 = "B";
                            break block46;
                        }
                        v1 = "V";
                        break block46;
                    }
                    v1 = StringsKt.Method9998((String)name$iv$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv$iv, ".", "/", false, 4, null) + ';';
                }
                var34_53 = v1;
                var31_48.add(var30_47.append(var34_53).toString());
            }
            $this$forEach$iv$iv = it.getDeclaredMethods();
            $i$f$forEach = false;
            var22_29 = $this$forEach$iv$iv;
            var23_30 = ((Field[])var22_29).length;
            var24_33 = 0;
            while (true) {
                block58: {
                    block53: {
                        block54: {
                            block56: {
                                block55: {
                                    block57: {
                                        if (var24_33 < var23_30) {
                                            it$iv = element$iv$iv = var22_29[var24_33];
                                            $i$a$-forEach-ClassSigGen$getClassChecksum2$2$iv = false;
                                            v2 = new StringBuilder();
                                            it$iv.getParameters();
                                            var29_44 = v2.append(it$iv.getName()).append(" (");
                                            var30_47 = methods$iv;
                                            $i$f$map = false;
                                            $i$f$getDescriptor = $this$map$iv$iv;
                                            destination$iv$iv$iv = new ArrayList<E>(((void)$this$map$iv$iv).length);
                                            $i$f$mapTo = false;
                                            var35_55 = $this$mapTo$iv$iv$iv;
                                            var36_56 = ((void)var35_55).length;
                                            for (var37_58 = 0; var37_58 < var36_56; ++var37_58) {
                                                var39_62 = item$iv$iv$iv = var35_55[var37_58];
                                                var40_63 = destination$iv$iv$iv;
                                                $i$a$-map-ClassSigGen$getClassChecksum2$2$1$iv = false;
                                                var42_66 = it$iv.getType();
                                                var40_63.add(var42_66);
                                            }
                                            var40_63 = (List)destination$iv$iv$iv;
                                            $this$map$iv$iv = (Iterable)var40_63;
                                            $i$f$map = false;
                                            $this$mapTo$iv$iv$iv = $this$map$iv$iv;
                                            destination$iv$iv$iv = new ArrayList<E>(CollectionsKt.Method9458($this$map$iv$iv, 10));
                                            $i$f$mapTo = false;
                                            var35_55 = $this$mapTo$iv$iv$iv.iterator();
                                        } else {
                                            $this$forEach$iv$iv = CollectionsKt.Method3129(fields$iv, ClassSigGen$getClassChecksum2$3.Field7245);
                                            $i$f$forEach = false;
                                            var22_29 = $this$forEach$iv$iv.iterator();
                                            break;
                                        }
                                        while (var35_55.hasNext()) {
                                            block52: {
                                                block47: {
                                                    block48: {
                                                        block50: {
                                                            block49: {
                                                                block51: {
                                                                    item$iv$iv$iv = var35_55.next();
                                                                    var37_59 = (Class)item$iv$iv$iv;
                                                                    var40_63 = destination$iv$iv$iv;
                                                                    $i$a$-map-ClassSigGen$getClassChecksum2$2$2$iv = false;
                                                                    it$iv = ClassSigGen.Field911;
                                                                    it$iv.getName();
                                                                    $i$f$getDescriptor = false;
                                                                    var44_68 = name$iv$iv;
                                                                    switch (var44_68.hashCode()) {
                                                                        case 64711720: {
                                                                            if (var44_68.equals("boolean")) {
                                                                                break;
                                                                            }
                                                                            break block47;
                                                                        }
                                                                        case 3625364: {
                                                                            if (!var44_68.equals("void")) ** break;
                                                                            break block48;
                                                                        }
                                                                        case -1325958191: {
                                                                            if (!var44_68.equals("double")) ** break;
                                                                            break block49;
                                                                        }
                                                                        case 3039496: {
                                                                            if (!var44_68.equals("byte")) ** break;
                                                                            break block50;
                                                                        }
                                                                        case 97526364: {
                                                                            if (!var44_68.equals("float")) ** break;
                                                                            break block51;
                                                                        }
                                                                        case 104431: {
                                                                            if (!var44_68.equals("int")) break block47;
                                                                            v3 = "I";
                                                                            break block52;
                                                                        }
                                                                    }
                                                                    v3 = "Z";
                                                                    break block52;
                                                                }
                                                                v3 = "F";
                                                                break block52;
                                                            }
                                                            v3 = "D";
                                                            break block52;
                                                        }
                                                        v3 = "B";
                                                        break block52;
                                                    }
                                                    v3 = "V";
                                                    break block52;
                                                }
                                                v3 = StringsKt.Method9998(name$iv$iv, "[", false, 2, null) ? StringsKt.Method9968(name$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968(name$iv$iv, ".", "/", false, 4, null) + ';';
                                            }
                                            var42_66 = v3;
                                            var40_63.add(var42_66);
                                        }
                                        var40_63 = (List)destination$iv$iv$iv;
                                        $this$map$iv$iv = ClassSigGen.Field911;
                                        it$iv.getReturnType().getName();
                                        var29_44 = var29_44.append(CollectionsKt.Method3238((Iterable)var40_63, "", null, null, 0, null, null, 62, null)).append(')');
                                        $i$f$getDescriptor = false;
                                        var33_52 = name$iv$iv;
                                        switch (var33_52.hashCode()) {
                                            case 64711720: {
                                                if (var33_52.equals("boolean")) {
                                                    break;
                                                }
                                                break block53;
                                            }
                                            case 3625364: {
                                                if (!var33_52.equals("void")) break block53;
                                                break block54;
                                            }
                                            case -1325958191: {
                                                if (!var33_52.equals("double")) ** break;
                                                break block55;
                                            }
                                            case 3039496: {
                                                if (!var33_52.equals("byte")) break block53;
                                                break block56;
                                            }
                                            case 97526364: {
                                                if (!var33_52.equals("float")) break block53;
                                                break block57;
                                            }
                                            case 104431: {
                                                if (!var33_52.equals("int")) break block53;
                                                v4 = "I";
                                                break block58;
                                            }
                                        }
                                        v4 = "Z";
                                        break block58;
                                    }
                                    v4 = "F";
                                    break block58;
                                }
                                v4 = "D";
                                break block58;
                            }
                            v4 = "B";
                            break block58;
                        }
                        v4 = "V";
                        break block58;
                    }
                    v4 = StringsKt.Method9998((String)name$iv$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv$iv, ".", "/", false, 4, null) + ';';
                }
                var40_63 = v4;
                var30_47.add(var29_44.append((String)var40_63).toString());
                ++var24_33;
            }
            while (var22_29.hasNext()) {
                element$iv$iv = var22_29.next();
                it$iv = (String)element$iv$iv;
                $i$a$-forEach-ClassSigGen$getClassChecksum2$4$iv = false;
                var26_39 = it$iv;
                var27_41 = hash$iv;
                var28_43 = Charsets.Field5722;
                var29_45 = false;
                v5 = var26_39;
                if (v5 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var30_47 = v5.getBytes((Charset)var28_43);
                var27_41.update((byte[])var30_47);
            }
            $this$forEach$iv$iv = CollectionsKt.Method3129(methods$iv, ClassSigGen$getClassChecksum2$5.Field7246);
            $i$f$forEach = false;
            var22_29 = $this$forEach$iv$iv.iterator();
            while (var22_29.hasNext()) {
                element$iv$iv = var22_29.next();
                it$iv = (String)element$iv$iv;
                $i$a$-forEach-ClassSigGen$getClassChecksum2$6$iv = false;
                var26_39 = it$iv;
                var27_42 = hash$iv;
                var28_43 = Charsets.Field5722;
                var29_46 = false;
                v6 = var26_39;
                if (v6 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                var30_47 = v6.getBytes((Charset)var28_43);
                var27_42.update((byte[])var30_47);
            }
            var13_13.update(var45_69.digest());
            ++var8_8;
        }
        $this$forEach$iv = classes;
        $i$f$forEach = false;
        var6_6 = $this$forEach$iv;
        var7_7 = ((void)var6_6).length;
        var8_8 = 0;
        while (var8_8 < var7_7) {
            it = element$iv = var6_6[var8_8];
            $i$a$-forEach-ClassSigGen$getCombinedChecksum2$2 = false;
            var12_12 = hash;
            $i$f$getClassBytes = false;
            v7 = it.getClassLoader().getResourceAsStream(StringsKt.Method9968(it.getName(), ".", "/", false, 4, null) + ".class");
            if (v7 == null) {
                var14_16 = LaunchClassLoader.class.getDeclaredField("resourceCache");
                var17_70 = false;
                var18_21 = false;
                it$iv = var14_16;
                $i$a$-let-ClassSigGen$getClassBytes$1$iv = false;
                it$iv.setAccessible(true);
                v8 = it$iv.get((Object)Launch.classLoader);
                if (v8 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
                }
                var21_28 = (Map)v8;
                var46_71 = (byte[])var21_28.get(it.getName());
                v7 = new ByteArrayInputStream(var46_71);
            }
            var22_29 = IOUtils.toByteArray((InputStream)v7);
            var12_12.update((byte[])var22_29);
            ++var8_8;
        }
        return hash;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List Method1417(@NotNull Class[] arrclass) {
        void $this$flatMapTo$iv$iv;
        void classes;
        void $this$flatMap$iv = classes;
        boolean $i$f$flatMap = false;
        void var4_4 = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        void var7_7 = $this$flatMapTo$iv$iv;
        int n = ((void)var7_7).length;
        for (int i = 0; i < n; ++i) {
            String string;
            Parameter it$iv;
            Collection<String> collection;
            Parameter[] $this$mapTo$iv$iv$iv;
            boolean $i$f$mapTo;
            Collection destination$iv$iv$iv;
            Parameter[] $this$map$iv$iv;
            boolean $i$f$map;
            List list;
            Field it$iv2;
            AccessibleObject element$iv$iv;
            int n2;
            void element$iv$iv2;
            void it = element$iv$iv2 = var7_7[i];
            boolean bl = false;
            boolean $i$f$getReflectMashup = false;
            boolean bl2 = false;
            List data$iv = new ArrayList();
            AccessibleObject[] $this$forEach$iv$iv = it.getDeclaredFields();
            boolean $i$f$forEach = false;
            AccessibleObject[] arraccessibleObject = $this$forEach$iv$iv;
            int n3 = arraccessibleObject.length;
            for (n2 = 0; n2 < n3; ++n2) {
                it$iv2 = element$iv$iv = arraccessibleObject[n2];
                boolean bl3 = false;
                data$iv.add(it$iv2.getType().getName());
                data$iv.add(it$iv2.getName());
            }
            $this$forEach$iv$iv = it.getDeclaredMethods();
            $i$f$forEach = false;
            arraccessibleObject = $this$forEach$iv$iv;
            n3 = arraccessibleObject.length;
            for (n2 = 0; n2 < n3; ++n2) {
                it$iv2 = element$iv$iv = arraccessibleObject[n2];
                boolean bl4 = false;
                data$iv.add(String.valueOf(((Method)((Object)it$iv2)).getModifiers()));
                data$iv.add(((Method)((Object)it$iv2)).getName());
                data$iv.add(String.valueOf(((Method)((Object)it$iv2)).getParameterCount()));
                ((Method)((Object)it$iv2)).getParameterTypes();
                list = data$iv;
                $i$f$map = false;
                void var26_27 = $this$map$iv$iv;
                destination$iv$iv$iv = new ArrayList($this$map$iv$iv.length);
                $i$f$mapTo = false;
                for (Parameter item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
                    void var33_34 = item$iv$iv$iv;
                    collection = destination$iv$iv$iv;
                    boolean bl5 = false;
                    string = ((Class)((Object)it$iv)).getName();
                    collection.add(string);
                }
                collection = (List)destination$iv$iv$iv;
                list.addAll((Collection)collection);
            }
            data$iv.add(it.getSimpleName());
            data$iv.add(String.valueOf(SharedSecrets.getJavaLangAccess().getConstantPool((Class)it).getSize()));
            data$iv.addAll(Field911.Method1417(it.getDeclaredClasses()));
            $this$forEach$iv$iv = it.getConstructors();
            $i$f$forEach = false;
            arraccessibleObject = $this$forEach$iv$iv;
            n3 = arraccessibleObject.length;
            for (n2 = 0; n2 < n3; ++n2) {
                it$iv2 = element$iv$iv = arraccessibleObject[n2];
                boolean bl6 = false;
                data$iv.add(String.valueOf(((Constructor)((Object)it$iv2)).getModifiers()));
                ((Executable)((Object)it$iv2)).getParameters();
                list = data$iv;
                $i$f$map = false;
                $this$mapTo$iv$iv$iv = $this$map$iv$iv;
                destination$iv$iv$iv = new ArrayList($this$map$iv$iv.length);
                $i$f$mapTo = false;
                Parameter[] arrparameter = $this$mapTo$iv$iv$iv;
                int n4 = arrparameter.length;
                for (int j = 0; j < n4; ++j) {
                    Parameter item$iv$iv$iv;
                    it$iv = item$iv$iv$iv = arrparameter[j];
                    collection = destination$iv$iv$iv;
                    boolean bl7 = false;
                    string = it$iv.getName();
                    collection.add(string);
                }
                collection = (List)destination$iv$iv$iv;
                list.addAll(collection);
                data$iv.add(String.valueOf(((Constructor)((Object)it$iv2)).getParameterCount()));
            }
            Iterable list$iv$iv = data$iv;
            CollectionsKt.Method9754(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    static {
        ClassSigGen classSigGen;
        Field911 = classSigGen = new ClassSigGen();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public MessageDigest Method1418(@NotNull Class class_) {
        Object object;
        String string;
        Parameter it$iv;
        Collection<String> collection;
        Parameter[] $this$mapTo$iv$iv$iv;
        boolean $i$f$mapTo;
        Collection destination$iv$iv$iv;
        Parameter[] $this$map$iv$iv;
        boolean $i$f$map;
        List list;
        AccessibleObject it$iv2;
        int n;
        void clazz;
        boolean $i$f$getChecksum = false;
        MessageDigest hash = MessageDigest.getInstance("MD5");
        boolean $i$f$getReflectMashup = false;
        boolean bl = false;
        List data$iv = new ArrayList();
        AccessibleObject[] $this$forEach$iv$iv = clazz.getDeclaredFields();
        boolean $i$f$forEach = false;
        AccessibleObject[] arraccessibleObject = $this$forEach$iv$iv;
        int n2 = arraccessibleObject.length;
        for (n = 0; n < n2; ++n) {
            Field field;
            Field it$iv22 = field = arraccessibleObject[n];
            boolean bl2 = false;
            data$iv.add(it$iv22.getType().getName());
            data$iv.add(it$iv22.getName());
        }
        $this$forEach$iv$iv = clazz.getDeclaredMethods();
        $i$f$forEach = false;
        arraccessibleObject = $this$forEach$iv$iv;
        n2 = arraccessibleObject.length;
        for (n = 0; n < n2; ++n) {
            AccessibleObject accessibleObject;
            it$iv2 = accessibleObject = arraccessibleObject[n];
            boolean bl3 = false;
            data$iv.add(String.valueOf(((Method)it$iv2).getModifiers()));
            data$iv.add(((Method)it$iv2).getName());
            data$iv.add(String.valueOf(((Method)it$iv2).getParameterCount()));
            ((Method)it$iv2).getParameterTypes();
            list = data$iv;
            $i$f$map = false;
            void var17_33 = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList($this$map$iv$iv.length);
            $i$f$mapTo = false;
            for (Parameter item$iv$iv$iv : $this$mapTo$iv$iv$iv) {
                void var24_40 = item$iv$iv$iv;
                collection = destination$iv$iv$iv;
                boolean bl4 = false;
                string = ((Class)((Object)it$iv)).getName();
                collection.add(string);
            }
            collection = (List)destination$iv$iv$iv;
            list.addAll((Collection)collection);
        }
        data$iv.add(clazz.getSimpleName());
        data$iv.add(String.valueOf(SharedSecrets.getJavaLangAccess().getConstantPool((Class)clazz).getSize()));
        data$iv.addAll(Field911.Method1417(clazz.getDeclaredClasses()));
        $this$forEach$iv$iv = clazz.getConstructors();
        $i$f$forEach = false;
        arraccessibleObject = $this$forEach$iv$iv;
        n2 = arraccessibleObject.length;
        for (n = 0; n < n2; ++n) {
            AccessibleObject accessibleObject;
            it$iv2 = accessibleObject = arraccessibleObject[n];
            boolean bl5 = false;
            data$iv.add(String.valueOf(((Constructor)it$iv2).getModifiers()));
            ((Executable)it$iv2).getParameters();
            list = data$iv;
            $i$f$map = false;
            $this$mapTo$iv$iv$iv = $this$map$iv$iv;
            destination$iv$iv$iv = new ArrayList($this$map$iv$iv.length);
            $i$f$mapTo = false;
            Parameter[] arrparameter = $this$mapTo$iv$iv$iv;
            int n3 = arrparameter.length;
            for (int i = 0; i < n3; ++i) {
                Parameter item$iv$iv$iv;
                it$iv = item$iv$iv$iv = arrparameter[i];
                collection = destination$iv$iv$iv;
                boolean bl6 = false;
                string = it$iv.getName();
                collection.add(string);
            }
            collection = (List)destination$iv$iv$iv;
            list.addAll(collection);
            data$iv.add(String.valueOf(((Constructor)it$iv2).getParameterCount()));
        }
        Iterable $this$forEach$iv = data$iv;
        boolean $i$f$forEach2 = false;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String)element$iv;
            boolean bl7 = false;
            String string2 = it;
            MessageDigest messageDigest = hash;
            object = Charsets.Field5722;
            boolean bl2 = false;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object[] arrobject = string3.getBytes((Charset)object);
            messageDigest.update((byte[])arrobject);
        }
        MessageDigest messageDigest = hash;
        boolean $i$f$getClassBytes = false;
        InputStream inputStream = clazz.getClassLoader().getResourceAsStream(StringsKt.Method9968(clazz.getName(), ".", "/", false, 4, null) + ".class");
        if (inputStream == null) {
            Field field = LaunchClassLoader.class.getDeclaredField("resourceCache");
            boolean bl9 = false;
            n2 = 0;
            Field it$iv3 = field;
            boolean bl3 = false;
            it$iv3.setAccessible(true);
            Object object2 = it$iv3.get((Object)Launch.classLoader);
            if (object2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
            }
            object = (Map)object2;
            byte[] arrby = (byte[])object.get(clazz.getName());
            inputStream = new ByteArrayInputStream(arrby);
        }
        byte[] arrby = IOUtils.toByteArray((InputStream)inputStream);
        messageDigest.digest(arrby);
        return hash;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @NotNull
    public MessageDigest Method1419(@NotNull Class var1_1) {
        $i$f$getClassChecksum2 = false;
        hash = MessageDigest.getInstance("MD5");
        var5_4 = false;
        methods = var31_6 = (List)new ArrayList<E>();
        var6_8 = false;
        fields = var31_6 = (List)new ArrayList<E>();
        $this$forEach$iv = clazz.getDeclaredFields();
        $i$f$forEach = false;
        for (Field var11_18 : $this$forEach$iv) {
            block40: {
                block35: {
                    block36: {
                        block38: {
                            block37: {
                                block39: {
                                    it = var11_18;
                                    $i$a$-forEach-ClassSigGen$getClassChecksum2$1 = false;
                                    v0 = new StringBuilder();
                                    var14_27 = ClassSigGen.Field911;
                                    it.getType().getName();
                                    var16_31 = v0.append(it.getModifiers()).append(' ').append(it.getName()).append(' ');
                                    var17_32 = fields;
                                    $i$f$getDescriptor = false;
                                    var19_36 = name$iv;
                                    switch (var19_36.hashCode()) {
                                        case 64711720: {
                                            if (!var19_36.equals("boolean")) ** break;
                                            break;
                                        }
                                        case 3625364: {
                                            if (!var19_36.equals("void")) break block35;
                                            break block36;
                                        }
                                        case -1325958191: {
                                            if (!var19_36.equals("double")) break block35;
                                            break block37;
                                        }
                                        case 3039496: {
                                            if (!var19_36.equals("byte")) ** break;
                                            break block38;
                                        }
                                        case 97526364: {
                                            if (!var19_36.equals("float")) break block35;
                                            break block39;
                                        }
                                        case 104431: {
                                            if (!var19_36.equals("int")) ** break;
                                            v1 = "I";
                                            break block40;
                                        }
                                    }
                                    v1 = "Z";
                                    break block40;
                                }
                                v1 = "F";
                                break block40;
                            }
                            v1 = "D";
                            break block40;
                        }
                        v1 = "B";
                        break block40;
                    }
                    v1 = "V";
                    break block40;
                }
                v1 = StringsKt.Method9998((String)name$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv, ".", "/", false, 4, null) + ';';
            }
            var20_37 = v1;
            var17_32.add(var16_31.append(var20_37).toString());
        }
        $this$forEach$iv = clazz.getDeclaredMethods();
        $i$f$forEach = false;
        var8_11 = $this$forEach$iv;
        var9_12 = ((AccessibleObject[])var8_11).length;
        var10_15 = 0;
        while (true) {
            block51: {
                block46: {
                    block47: {
                        block49: {
                            block48: {
                                block50: {
                                    if (var10_15 < var9_12) {
                                        it = var11_20 = var8_11[var10_15];
                                        $i$a$-forEach-ClassSigGen$getClassChecksum2$2 = false;
                                        v2 = new StringBuilder();
                                        it.getParameters();
                                        var15_28 = v2.append(it.getName()).append(" (");
                                        var16_31 = methods;
                                        $i$f$map = false;
                                        $i$f$getDescriptor = $this$map$iv;
                                        destination$iv$iv = new ArrayList<E>(((void)$this$map$iv).length);
                                        $i$f$mapTo = false;
                                        var21_39 = $this$mapTo$iv$iv;
                                        var22_40 = ((void)var21_39).length;
                                        for (var23_42 = 0; var23_42 < var22_40; ++var23_42) {
                                            var25_46 = item$iv$iv = var21_39[var23_42];
                                            var26_47 = destination$iv$iv;
                                            $i$a$-map-ClassSigGen$getClassChecksum2$2$1 = false;
                                            var28_50 = it.getType();
                                            var26_47.add(var28_50);
                                        }
                                        var26_47 = (List)destination$iv$iv;
                                        $this$map$iv = (Iterable)var26_47;
                                        $i$f$map = false;
                                        $this$mapTo$iv$iv = $this$map$iv;
                                        destination$iv$iv = new ArrayList<E>(CollectionsKt.Method9458($this$map$iv, 10));
                                        $i$f$mapTo = false;
                                        var21_39 = $this$mapTo$iv$iv.iterator();
                                    } else {
                                        $this$forEach$iv = CollectionsKt.Method3129(fields, ClassSigGen$getClassChecksum2$3.Field7245);
                                        $i$f$forEach = false;
                                        var8_11 = $this$forEach$iv.iterator();
                                        break;
                                    }
                                    while (var21_39.hasNext()) {
                                        block45: {
                                            block41: {
                                                block43: {
                                                    block42: {
                                                        block44: {
                                                            item$iv$iv = var21_39.next();
                                                            var23_43 = (Class)item$iv$iv;
                                                            var26_47 = destination$iv$iv;
                                                            $i$a$-map-ClassSigGen$getClassChecksum2$2$2 = false;
                                                            it = ClassSigGen.Field911;
                                                            it.getName();
                                                            $i$f$getDescriptor = false;
                                                            var30_52 = name$iv;
                                                            switch (var30_52.hashCode()) {
                                                                case 64711720: {
                                                                    if (!var30_52.equals("boolean")) ** break;
                                                                    break;
                                                                }
                                                                case 3625364: {
                                                                    if (!var30_52.equals("void")) ** break;
                                                                    break block41;
                                                                }
                                                                case -1325958191: {
                                                                    if (!var30_52.equals("double")) ** break;
                                                                    break block42;
                                                                }
                                                                case 3039496: {
                                                                    if (!var30_52.equals("byte")) ** break;
                                                                    break block43;
                                                                }
                                                                case 97526364: {
                                                                    if (!var30_52.equals("float")) ** break;
                                                                    break block44;
                                                                }
                                                                case 104431: {
                                                                    if (!var30_52.equals("int")) ** break;
                                                                    v3 = "I";
                                                                    break block45;
                                                                }
                                                            }
                                                            v3 = "Z";
                                                            break block45;
                                                        }
                                                        v3 = "F";
                                                        break block45;
                                                    }
                                                    v3 = "D";
                                                    break block45;
                                                }
                                                v3 = "B";
                                                break block45;
                                            }
                                            v3 = "V";
                                            break block45;
                                            v3 = StringsKt.Method9998(name$iv, "[", false, 2, null) ? StringsKt.Method9968(name$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968(name$iv, ".", "/", false, 4, null) + ';';
                                        }
                                        var28_50 = v3;
                                        var26_47.add(var28_50);
                                    }
                                    var26_47 = (List)destination$iv$iv;
                                    $this$map$iv = ClassSigGen.Field911;
                                    it.getReturnType().getName();
                                    var15_28 = var15_28.append(CollectionsKt.Method3238((Iterable)var26_47, "", null, null, 0, null, null, 62, null)).append(')');
                                    $i$f$getDescriptor = false;
                                    var19_36 = name$iv;
                                    switch (var19_36.hashCode()) {
                                        case 64711720: {
                                            if (var19_36.equals("boolean")) {
                                                break;
                                            }
                                            break block46;
                                        }
                                        case 3625364: {
                                            if (!var19_36.equals("void")) break block46;
                                            break block47;
                                        }
                                        case -1325958191: {
                                            if (!var19_36.equals("double")) break block46;
                                            break block48;
                                        }
                                        case 3039496: {
                                            if (!var19_36.equals("byte")) break block46;
                                            break block49;
                                        }
                                        case 97526364: {
                                            if (!var19_36.equals("float")) ** break;
                                            break block50;
                                        }
                                        case 104431: {
                                            if (!var19_36.equals("int")) ** break;
                                            v4 = "I";
                                            break block51;
                                        }
                                    }
                                    v4 = "Z";
                                    break block51;
                                }
                                v4 = "F";
                                break block51;
                            }
                            v4 = "D";
                            break block51;
                        }
                        v4 = "B";
                        break block51;
                    }
                    v4 = "V";
                    break block51;
                }
                v4 = StringsKt.Method9998((String)name$iv, "[", false, 2, null) != false ? StringsKt.Method9968((String)name$iv, ".", "/", false, 4, null) : 'L' + StringsKt.Method9968((String)name$iv, ".", "/", false, 4, null) + ';';
            }
            var26_47 = v4;
            var16_31.add(var15_28.append((String)var26_47).toString());
            ++var10_15;
        }
        while (var8_11.hasNext()) {
            element$iv = var8_11.next();
            it = (String)element$iv;
            var11_21 = false;
            var12_23 = it;
            var13_25 = hash;
            var14_27 = Charsets.Field5722;
            var15_29 = false;
            v5 = var12_23;
            if (v5 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            var16_31 = v5.getBytes((Charset)var14_27);
            var13_25.update((byte[])var16_31);
        }
        $this$forEach$iv = CollectionsKt.Method3129(methods, ClassSigGen$getClassChecksum2$5.Field7246);
        $i$f$forEach = false;
        var8_11 = $this$forEach$iv.iterator();
        while (var8_11.hasNext() != false) {
            element$iv = var8_11.next();
            it = (String)element$iv;
            var11_22 = false;
            var12_23 = it;
            var13_26 = hash;
            var14_27 = Charsets.Field5722;
            var15_30 = false;
            v6 = var12_23;
            if (v6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            var16_31 = v6.getBytes((Charset)var14_27);
            var13_26.update((byte[])var16_31);
        }
        return hash;
    }

    @JvmStatic
    public static byte[] Method1420(@NotNull Class class_) {
        Class clazz;
        boolean $i$f$getClassBytes = false;
        InputStream inputStream = clazz.getClassLoader().getResourceAsStream(StringsKt.Method9968(clazz.getName(), ".", "/", false, 4, null) + ".class");
        if (inputStream == null) {
            Field field = LaunchClassLoader.class.getDeclaredField("resourceCache");
            boolean bl = false;
            boolean bl2 = false;
            Field it = field;
            boolean bl3 = false;
            it.setAccessible(true);
            Object object = it.get((Object)Launch.classLoader);
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
            }
            Map map = (Map)object;
            byte[] arrby = (byte[])map.get(clazz.getName());
            inputStream = new ByteArrayInputStream(arrby);
        }
        return IOUtils.toByteArray((InputStream)inputStream);
    }
}

