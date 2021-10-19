/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

public class Clientfiles {
   @NotNull
   public static Map indextable;
   public static Clientfiles INSTANCE;

   static {
      Clientfiles var0 = new Clientfiles();
      INSTANCE = var0;
      boolean var1 = false;
      indextable = (Map)(new LinkedHashMap());
   }

   @NotNull
   public Map getIndextable() {
      return indextable;
   }

   @JvmStatic
   public static void store(@NotNull String file, @NotNull byte[] bytes, int byteSplit, long seed) {
      int $i$f$store = false;
      Map var10000 = INSTANCE.getIndextable();
      MessageDigest var27 = MessageDigest.getInstance("MD5");
      Map var26 = var10000;
      Charset var7 = Charsets.UTF_8;
      boolean var8 = false;
      byte[] var28 = file.getBytes(var7);
      byte[] var37 = var27.digest(var28);
      boolean var6 = false;
      boolean var30 = false;

      Unsafe var33;
      Object var36;
      try {
         Field f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
         f$iv$iv.setAccessible(true);
         var36 = f$iv$iv.get((Object)null);
         if (var36 == null) {
            throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
         }

         var33 = (Unsafe)var36;
      } catch (Exception var29) {
         throw (Throwable)(new RuntimeException((Throwable)var29));
      }

      Unsafe unsafe$iv = var33;
      Random random$iv = RandomKt.Random(seed);
      double var11 = (double)bytes.length / (double)byteSplit;
      boolean var13 = false;
      int splitcount$iv = (int)Math.ceil(var11);
      long[] indexTable$iv = new long[splitcount$iv + 1];
      var13 = false;
      Map unusedIndexTable$iv = (Map)(new LinkedHashMap());
      indexTable$iv[0] = (long)bytes.length;
      int i$iv = 1;
      int var15 = splitcount$iv;
      if (i$iv <= splitcount$iv) {
         while(true) {
            indexTable$iv[i$iv] = unsafe$iv.allocateMemory((long)byteSplit);
            unusedIndexTable$iv.put(i$iv, indexTable$iv[i$iv]);
            if (i$iv == var15) {
               break;
            }

            ++i$iv;
         }
      }

      i$iv = 1;
      var15 = splitcount$iv;
      if (i$iv <= splitcount$iv) {
         while(true) {
            int begin$iv = (i$iv - 1) * byteSplit;
            int index$iv = bytes.length;
            int var19 = begin$iv + byteSplit;
            boolean var20 = false;
            int end$iv = Math.min(index$iv, var19);
            index$iv = ((Number)CollectionsKt.random((Collection)unusedIndexTable$iv.keySet(), random$iv)).intValue();
            var36 = unusedIndexTable$iv.get(index$iv);
            if (var36 == null) {
               Intrinsics.throwNpe();
            }

            long nextMem$iv = ((Number)var36).longValue();
            unusedIndexTable$iv.remove(index$iv);
            int j$iv = begin$iv;

            for(int var25 = end$iv; j$iv < var25; ++j$iv) {
               unsafe$iv.putByte(nextMem$iv + (long)j$iv - (long)begin$iv, bytes[j$iv]);
            }

            if (i$iv == var15) {
               break;
            }

            ++i$iv;
         }
      }

      var26.put(var37, indexTable$iv);
   }

   @JvmStatic
   @NotNull
   public static byte[] retrieve(@NotNull String file, int byteSplit, long seed) {
      boolean var4 = false;
      Map var5 = INSTANCE.getIndextable();
      MessageDigest var24 = MessageDigest.getInstance("MD5");
      Charset var7 = Charsets.UTF_8;
      boolean var8 = false;
      byte[] var25 = file.getBytes(var7);
      byte[] array$iv = var24.digest(var25);
      boolean var29 = false;
      Iterable var31 = (Iterable)var5.entrySet();
      boolean var9 = false;
      Iterator var10 = var31.iterator();

      Object var10000;
      while(true) {
         if (var10.hasNext()) {
            Object element$iv$iv = var10.next();
            Entry $dstr$a$_u24__u24$iv = (Entry)element$iv$iv;
            boolean var13 = false;
            boolean var15 = false;
            byte[] a$iv = (byte[])$dstr$a$_u24__u24$iv.getKey();
            boolean var17 = false;
            if (!Arrays.equals(a$iv, array$iv)) {
               continue;
            }

            var10000 = element$iv$iv;
            break;
         }

         var10000 = null;
         break;
      }

      var10000 = (Entry)var10000 != null ? ((Entry)var10000).getValue() : null;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      long[] indexTable$iv = (long[])var10000;
      boolean var28 = false;
      var29 = false;

      Unsafe var33;
      try {
         Field f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
         f$iv$iv.setAccessible(true);
         var10000 = f$iv$iv.get((Object)null);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
         }

         var33 = (Unsafe)var10000;
      } catch (Exception var26) {
         throw (Throwable)(new RuntimeException((Throwable)var26));
      }

      Unsafe unsafe$iv = var33;
      Random random$iv = RandomKt.Random(seed);
      int splitcount$iv = indexTable$iv.length - 1;
      boolean var37 = false;
      Map unusedIndexTable$iv = (Map)(new LinkedHashMap());
      byte[] bytes$iv = new byte[(int)indexTable$iv[0]];
      int i$iv = 1;
      int var40 = splitcount$iv;
      if (i$iv <= splitcount$iv) {
         while(true) {
            unusedIndexTable$iv.put(i$iv, indexTable$iv[i$iv]);
            if (i$iv == var40) {
               break;
            }

            ++i$iv;
         }
      }

      i$iv = 0;

      for(var40 = splitcount$iv; i$iv < var40; ++i$iv) {
         int begin$iv = i$iv * byteSplit;
         int index$iv = bytes$iv.length;
         int var42 = begin$iv + byteSplit;
         boolean var18 = false;
         int end$iv = Math.min(index$iv, var42);
         index$iv = ((Number)CollectionsKt.random((Collection)unusedIndexTable$iv.keySet(), random$iv)).intValue();
         var10000 = unusedIndexTable$iv.get(index$iv);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         long nextMem$iv = ((Number)var10000).longValue();
         unusedIndexTable$iv.remove(index$iv);
         int j$iv = begin$iv;

         for(int var23 = end$iv; j$iv < var23; ++j$iv) {
            bytes$iv[j$iv] = unsafe$iv.getByte(nextMem$iv + (long)j$iv - (long)begin$iv);
         }
      }

      return bytes$iv;
   }
}
