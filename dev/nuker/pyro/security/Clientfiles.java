/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.security;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

public class Clientfiles {
    @NotNull
    public static Map<byte[], long[]> Field1321;
    public static Clientfiles Field1322;

    static {
        Clientfiles clientfiles;
        Field1322 = clientfiles = new Clientfiles();
        boolean bl = false;
        Field1321 = new LinkedHashMap();
    }

    @NotNull
    public Map Method1879() {
        return Field1321;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @JvmStatic
    public static void Method1880(@NotNull String var0, @NotNull byte[] var1_1, int var2_2, long var3_3) {
        $i$f$store = false;
        var6_5 = file;
        var27_7 = MessageDigest.getInstance("MD5");
        var26_8 = Clientfiles.Field1322.Method1879();
        var7_9 = Charsets.Field5722;
        var8_12 = false;
        var28_15 = var6_5.getBytes(var7_9);
        var27_7 = var27_7.digest(var28_15);
        $i$f$storeIndexedBytes = false;
        $i$f$getUnsafe = false;
        try {
            v0 = Unsafe.class.getDeclaredField("theUnsafe");
        }
        catch (Exception e$iv$iv) {
            throw (Throwable)new RuntimeException(e$iv$iv);
        }
        f$iv$iv = v0;
        v1 = f$iv$iv;
        v2 = true;
        v1.setAccessible(v2);
        v3 = f$iv$iv;
        v4 = null;
        v5 = v3.get(v4);
        v6 = v5;
        if (v5 != null) ** GOTO lbl41
        v7 = v8;
        v9 = v8;
        v10 = "null cannot be cast to non-null type sun.misc.Unsafe";
        v7(v10);
        throw v9;
lbl41:
        // 1 sources

        f$iv$iv = (Unsafe)v6;
        unsafe$iv = f$iv$iv;
        random$iv = RandomKt.Method7032((long)seed);
        var11_20 = (double)((void)bytes).length / (double)byteSplit;
        var13_21 = 0;
        splitcount$iv = (int)Math.ceil(var11_20);
        indexTable$iv = new long[splitcount$iv + 1];
        var13_21 = 0;
        unusedIndexTable$iv = new LinkedHashMap<K, V>();
        indexTable$iv[0] = ((void)bytes).length;
        var13_21 = 1;
        var15_23 = splitcount$iv;
        if (var13_21 <= var15_23) {
            do {
                indexTable$iv[++i$iv] = unsafe$iv.allocateMemory((long)byteSplit);
                unusedIndexTable$iv.put(i$iv, indexTable$iv[i$iv]);
            } while (i$iv != var15_23);
        }
        if ((i$iv = 1) <= (var15_23 = splitcount$iv)) {
            while (true) {
                begin$iv = (i$iv - 1) * byteSplit;
                length$iv = byteSplit;
                var18_26 = ((void)bytes).length;
                var19_27 = begin$iv + length$iv;
                var20_28 = false;
                end$iv = Math.min(var18_26, var19_27);
                index$iv = ((Number)CollectionsKt.Method3094((Collection)unusedIndexTable$iv.keySet(), random$iv)).intValue();
                v11 = unusedIndexTable$iv.get(index$iv);
                if (v11 == null) {
                    Intrinsics.Method6551();
                }
                nextMem$iv = ((Number)v11).longValue();
                unusedIndexTable$iv.remove(index$iv);
                var24_31 = begin$iv;
                var25_32 = end$iv;
                while (var24_31 < var25_32) {
                    unsafe$iv.putByte(nextMem$iv + (long)j$iv - (long)begin$iv, (byte)bytes[j$iv]);
                    ++j$iv;
                }
                if (i$iv == var15_23) break;
                ++i$iv;
            }
        }
        var28_16 = indexTable$iv;
        var26_8.put(var27_7, var28_16);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @JvmStatic
    @NotNull
    public static byte[] Method1881(@NotNull String var0, int var1_1, long var2_2) {
        block21: {
            $i$f$retrieve = false;
            var5_4 = Clientfiles.Field1322.Method1879();
            var6_5 = file;
            var24_7 = MessageDigest.getInstance("MD5");
            var7_8 = Charsets.Field5722;
            var8_11 = false;
            var25_14 = var6_5.getBytes(var7_8);
            array$iv = var24_7.digest(var25_14);
            $i$f$getEq = false;
            $this$firstOrNull$iv$iv = $this$getEq$iv.entrySet();
            $i$f$firstOrNull = false;
            for (T element$iv$iv : $this$firstOrNull$iv$iv) {
                $dstr$a$_u24__u24$iv = (Map.Entry)element$iv$iv;
                $i$a$-firstOrNull-UtilsKt$getEq$1$iv = false;
                var14_25 = $dstr$a$_u24__u24$iv;
                var15_29 = false;
                a$iv = (byte[])var14_25.getKey();
                var14_25 = a$iv;
                var15_28 = array$iv;
                var17_33 = 0;
                if (!Arrays.equals((byte[])var14_25, var15_28)) continue;
                v0 = element$iv$iv;
                break block21;
            }
            v0 = null;
        }
        v1 = v0;
        v2 = v1 != null ? v1.getValue() : null;
        if (v2 == null) {
            Intrinsics.Method6551();
        }
        indexTable$iv = v2;
        $i$f$retrieveIndexedBytes = false;
        $i$f$getUnsafe = false;
        try {
            v3 = Unsafe.class.getDeclaredField("theUnsafe");
        }
        catch (Exception e$iv$iv) {
            throw (Throwable)new RuntimeException(e$iv$iv);
        }
        f$iv$iv = v3;
        v4 = f$iv$iv;
        v5 = true;
        v4.setAccessible(v5);
        v6 = f$iv$iv;
        v7 = null;
        v8 = v6.get(v7);
        v9 = v8;
        if (v8 != null) ** GOTO lbl63
        v10 = v11;
        v12 = v11;
        v13 = "null cannot be cast to non-null type sun.misc.Unsafe";
        v10(v13);
        throw v12;
lbl63:
        // 1 sources

        f$iv$iv = (Unsafe)v9;
        unsafe$iv = f$iv$iv;
        random$iv = RandomKt.Method7032((long)seed);
        splitcount$iv = indexTable$iv.length - 1;
        element$iv$iv = false;
        unusedIndexTable$iv = new LinkedHashMap<K, V>();
        bytes$iv = new byte[(int)indexTable$iv[0]];
        $dstr$a$_u24__u24$iv = 1;
        var13_24 = splitcount$iv;
        if ($dstr$a$_u24__u24$iv <= var13_24) {
            do {
                unusedIndexTable$iv.put(++i$iv, indexTable$iv[i$iv]);
            } while (i$iv != var13_24);
        }
        i$iv = 0;
        var13_24 = splitcount$iv;
        while (i$iv < var13_24) {
            begin$iv = i$iv * byteSplit;
            length$iv = byteSplit;
            a$iv = bytes$iv.length;
            var17_33 = begin$iv + length$iv;
            var18_34 = false;
            end$iv = Math.min(a$iv, var17_33);
            index$iv = ((Number)CollectionsKt.Method3094((Collection)unusedIndexTable$iv.keySet(), random$iv)).intValue();
            v14 = unusedIndexTable$iv.get(index$iv);
            if (v14 == null) {
                Intrinsics.Method6551();
            }
            nextMem$iv = ((Number)v14).longValue();
            unusedIndexTable$iv.remove(index$iv);
            var22_37 = begin$iv;
            var23_38 = end$iv;
            while (var22_37 < var23_38) {
                bytes$iv[j$iv] = unsafe$iv.getByte(nextMem$iv + (long)j$iv - (long)begin$iv);
                ++j$iv;
            }
            ++i$iv;
        }
        return bytes$iv;
    }
}

