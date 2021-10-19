/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.launcher;

import dev.nuker.pyro.layer.ThirdLayer;
import dev.nuker.pyro.security.Clientfiles;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.IClassTransformer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import sun.misc.Unsafe;

public class PyroClassTransformer implements IClassTransformer {
   @Nullable
   public byte[] transform(@NotNull String var1, @NotNull String name, @Nullable byte[] basicClass) {
      Map var4;
      byte[] array$iv;
      Charset var6;
      boolean var7;
      boolean var8;
      Iterator var9;
      Object element$iv$iv;
      Entry $dstr$a$_u24__u24$iv;
      boolean var12;
      boolean var13;
      boolean $i$f$getEq;
      byte[] a$iv;
      Object var10000;
      boolean $i$f$firstOrNull;
      boolean var17;
      boolean var18;
      int begin$iv$iv;
      boolean var20;
      boolean var22;
      boolean var23;
      int index$iv$iv;
      int end$iv$iv;
      MessageDigest var32;
      byte[] var33;
      boolean var45;
      Iterable var48;
      Map $this$getEq$iv;
      boolean $i$f$retrieveIndexedBytes;
      byte[] array$iv;
      boolean $i$f$firstOrNull;
      boolean var93;
      Unsafe unsafe$iv$iv;
      byte[] bytes$iv$iv;
      int begin$iv$iv;
      int begin$iv$iv;
      if (StringsKt.startsWith$default(name, "dev.nuker.pyro", false, 2, (Object)null)) {
         var4 = ThirdLayer.sdb;
         var32 = MessageDigest.getInstance("MD5");
         var6 = Charsets.UTF_8;
         var7 = false;
         var33 = name.getBytes(var6);
         array$iv = var32.digest(var33);
         var45 = false;
         var48 = (Iterable)var4.entrySet();
         var8 = false;
         var9 = var48.iterator();

         while(true) {
            if (!var9.hasNext()) {
               var10000 = null;
               break;
            }

            element$iv$iv = var9.next();
            $dstr$a$_u24__u24$iv = (Entry)element$iv$iv;
            var12 = false;
            $i$f$getEq = false;
            a$iv = (byte[])$dstr$a$_u24__u24$iv.getKey();
            $i$f$firstOrNull = false;
            if (Arrays.equals(a$iv, array$iv)) {
               var10000 = element$iv$iv;
               break;
            }
         }

         if (((Entry)var10000 != null ? ((Entry)var10000).getValue() : null) != null) {
            byte byteSplit$iv = 42;
            Map var43 = ThirdLayer.sdb;
            var32 = MessageDigest.getInstance("MD5");
            Charset var49 = Charsets.UTF_8;
            var8 = false;
            var33 = name.getBytes(var49);
            byte[] array$iv = var32.digest(var33);
            var7 = false;
            Iterable var53 = (Iterable)var43.entrySet();
            $i$f$retrieveIndexedBytes = false;
            Iterator var61 = var53.iterator();

            while(true) {
               if (var61.hasNext()) {
                  Object element$iv$iv = var61.next();
                  Entry var75 = (Entry)element$iv$iv;
                  var13 = false;
                  var93 = false;
                  bytes$iv$iv = (byte[])var75.getKey();
                  var17 = false;
                  if (!Arrays.equals(bytes$iv$iv, array$iv)) {
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

            long seed$iv = ((Number)var10000).longValue();
            var7 = false;
            $this$getEq$iv = Clientfiles.INSTANCE.getIndextable();
            MessageDigest var64 = MessageDigest.getInstance("MD5");
            Charset var72 = Charsets.UTF_8;
            var12 = false;
            byte[] var80 = name.getBytes(var72);
            array$iv = var64.digest(var80);
            $i$f$firstOrNull = false;
            Iterable var79 = (Iterable)$this$getEq$iv.entrySet();
            $i$f$getEq = false;
            Iterator var97 = var79.iterator();

            while(true) {
               if (var97.hasNext()) {
                  Object element$iv$iv$iv = var97.next();
                  Entry var107 = (Entry)element$iv$iv$iv;
                  var18 = false;
                  var20 = false;
                  byte[] a$iv$iv = (byte[])var107.getKey();
                  var22 = false;
                  if (!Arrays.equals(a$iv$iv, array$iv)) {
                     continue;
                  }

                  var10000 = element$iv$iv$iv;
                  break;
               }

               var10000 = null;
               break;
            }

            var10000 = (Entry)var10000 != null ? ((Entry)var10000).getValue() : null;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            long[] indexTable$iv$iv = (long[])var10000;
            $i$f$retrieveIndexedBytes = false;
            $i$f$firstOrNull = false;

            Unsafe var84;
            try {
               Field f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv$iv.setAccessible(true);
               var10000 = f$iv$iv$iv.get((Object)null);
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var84 = (Unsafe)var10000;
            } catch (Exception var37) {
               throw (Throwable)(new RuntimeException((Throwable)var37));
            }

            unsafe$iv$iv = var84;
            Random random$iv$iv = RandomKt.Random(seed$iv);
            int splitcount$iv$iv = indexTable$iv$iv.length - 1;
            $i$f$firstOrNull = false;
            Map unusedIndexTable$iv$iv = (Map)(new LinkedHashMap());
            bytes$iv$iv = new byte[(int)indexTable$iv$iv[0]];
            int i$iv$iv = 1;
            int var113 = splitcount$iv$iv;
            if (i$iv$iv <= splitcount$iv$iv) {
               while(true) {
                  unusedIndexTable$iv$iv.put(i$iv$iv, indexTable$iv$iv[i$iv$iv]);
                  if (i$iv$iv == var113) {
                     break;
                  }

                  ++i$iv$iv;
               }
            }

            i$iv$iv = 0;

            for(var113 = splitcount$iv$iv; i$iv$iv < var113; ++i$iv$iv) {
               begin$iv$iv = i$iv$iv * byteSplit$iv;
               begin$iv$iv = bytes$iv$iv.length;
               begin$iv$iv = begin$iv$iv + byteSplit$iv;
               var23 = false;
               index$iv$iv = Math.min(begin$iv$iv, begin$iv$iv);
               begin$iv$iv = ((Number)CollectionsKt.random((Collection)unusedIndexTable$iv$iv.keySet(), random$iv$iv)).intValue();
               var10000 = unusedIndexTable$iv$iv.get(begin$iv$iv);
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               long nextMem$iv$iv = ((Number)var10000).longValue();
               unusedIndexTable$iv$iv.remove(begin$iv$iv);
               end$iv$iv = begin$iv$iv;

               for(int var28 = index$iv$iv; end$iv$iv < var28; ++end$iv$iv) {
                  bytes$iv$iv[end$iv$iv] = unsafe$iv$iv.getByte(nextMem$iv$iv + (long)end$iv$iv - (long)begin$iv$iv);
               }
            }

            return bytes$iv$iv;
         }
      } else {
         var4 = ThirdLayer.idb;
         var32 = MessageDigest.getInstance("MD5");
         var6 = Charsets.UTF_8;
         var7 = false;
         var33 = name.getBytes(var6);
         array$iv = var32.digest(var33);
         var45 = false;
         var48 = (Iterable)var4.entrySet();
         var8 = false;
         var9 = var48.iterator();

         while(true) {
            if (!var9.hasNext()) {
               var10000 = null;
               break;
            }

            element$iv$iv = var9.next();
            $dstr$a$_u24__u24$iv = (Entry)element$iv$iv;
            var12 = false;
            $i$f$getEq = false;
            a$iv = (byte[])$dstr$a$_u24__u24$iv.getKey();
            $i$f$firstOrNull = false;
            if (Arrays.equals(a$iv, array$iv)) {
               var10000 = element$iv$iv;
               break;
            }
         }

         if (((Entry)var10000 != null ? ((Entry)var10000).getValue() : null) != null) {
            try {
               ClassReader reader = new ClassReader(basicClass);
               ClassNode node = new ClassNode();
               reader.accept((ClassVisitor)node, 8);
               String var50 = "IDB: " + name;
               var7 = false;
               System.out.println(var50);
               File var156 = new File("Tranf.class");
               byte byteSplit$iv = 69;
               Map $this$getEq$iv = ThirdLayer.idb;
               MessageDigest var152 = MessageDigest.getInstance("MD5");
               File var151 = var156;
               Charset var63 = Charsets.UTF_8;
               boolean $i$f$retrieve = false;
               byte[] var34 = name.getBytes(var63);
               byte[] array$iv = var152.digest(var34);
               $i$f$retrieveIndexedBytes = false;
               Iterable $this$firstOrNull$iv$iv = (Iterable)$this$getEq$iv.entrySet();
               $i$f$firstOrNull = false;
               Iterator var87 = $this$firstOrNull$iv$iv.iterator();

               Object element$iv$iv;
               byte[] bytes$iv$iv;
               boolean var120;
               while(true) {
                  if (var87.hasNext()) {
                     element$iv$iv = var87.next();
                     Entry $dstr$a$_u24__u24$iv = (Entry)element$iv$iv;
                     var93 = false;
                     var17 = false;
                     bytes$iv$iv = (byte[])$dstr$a$_u24__u24$iv.getKey();
                     var120 = false;
                     if (!Arrays.equals(bytes$iv$iv, array$iv)) {
                        continue;
                     }

                     var10000 = element$iv$iv;
                     break;
                  }

                  var10000 = null;
                  break;
               }

               Object var153 = (Entry)var10000 != null ? ((Entry)var10000).getValue() : null;
               if (var153 == null) {
                  Intrinsics.throwNpe();
               }

               long seed$iv = ((Number)var153).longValue();
               $i$f$retrieveIndexedBytes = false;
               Map $this$getEq$iv$iv = Clientfiles.INSTANCE.getIndextable();
               MessageDigest var90 = MessageDigest.getInstance("MD5");
               Charset var85 = Charsets.UTF_8;
               $i$f$getEq = false;
               a$iv = name.getBytes(var85);
               byte[] array$iv$iv = var90.digest(a$iv);
               var13 = false;
               Iterable $this$firstOrNull$iv$iv$iv = (Iterable)$this$getEq$iv$iv.entrySet();
               $i$f$firstOrNull = false;
               Iterator var121 = $this$firstOrNull$iv$iv$iv.iterator();

               while(true) {
                  if (var121.hasNext()) {
                     Object element$iv$iv$iv = var121.next();
                     Entry $dstr$a$_u24__u24$iv$iv = (Entry)element$iv$iv$iv;
                     var20 = false;
                     var22 = false;
                     byte[] a$iv$iv = (byte[])$dstr$a$_u24__u24$iv$iv.getKey();
                     boolean var141 = false;
                     if (!Arrays.equals(a$iv$iv, array$iv$iv)) {
                        continue;
                     }

                     var10000 = element$iv$iv$iv;
                     break;
                  }

                  var10000 = null;
                  break;
               }

               var10000 = (Entry)var10000 != null ? ((Entry)var10000).getValue() : null;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               long[] indexTable$iv$iv = (long[])var10000;
               $i$f$firstOrNull = false;
               var13 = false;

               Unsafe var105;
               try {
                  Field f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                  f$iv$iv$iv.setAccessible(true);
                  var10000 = f$iv$iv$iv.get((Object)null);
                  if (var10000 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                  }

                  var105 = (Unsafe)var10000;
               } catch (Exception var39) {
                  throw (Throwable)(new RuntimeException((Throwable)var39));
               }

               Unsafe unsafe$iv$iv = var105;
               Random random$iv$iv = RandomKt.Random(seed$iv);
               int splitcount$iv$iv = ~(1 + ~indexTable$iv$iv.length);
               var18 = false;
               Map unusedIndexTable$iv$iv = (Map)(new LinkedHashMap());
               bytes$iv$iv = new byte[(int)indexTable$iv$iv[0]];
               begin$iv$iv = 1;
               int i$iv$iv = splitcount$iv$iv;
               if (begin$iv$iv <= splitcount$iv$iv) {
                  while(true) {
                     unusedIndexTable$iv$iv.put(begin$iv$iv, indexTable$iv$iv[begin$iv$iv]);
                     if (begin$iv$iv == i$iv$iv) {
                        break;
                     }

                     ++begin$iv$iv;
                  }
               }

               begin$iv$iv = 0;

               int j$iv$iv;
               boolean var144;
               for(i$iv$iv = splitcount$iv$iv; begin$iv$iv < i$iv$iv; ++begin$iv$iv) {
                  begin$iv$iv = begin$iv$iv * byteSplit$iv;
                  int index$iv$iv = bytes$iv$iv.length;
                  index$iv$iv = begin$iv$iv + byteSplit$iv;
                  var144 = false;
                  int end$iv$iv = Math.min(index$iv$iv, index$iv$iv);
                  index$iv$iv = ((Number)CollectionsKt.random((Collection)unusedIndexTable$iv$iv.keySet(), random$iv$iv)).intValue();
                  var10000 = unusedIndexTable$iv$iv.get(index$iv$iv);
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  long nextMem$iv$iv = ((Number)var10000).longValue();
                  unusedIndexTable$iv$iv.remove(index$iv$iv);
                  int j$iv$iv = begin$iv$iv;

                  for(j$iv$iv = end$iv$iv; j$iv$iv < j$iv$iv; ++j$iv$iv) {
                     bytes$iv$iv[j$iv$iv] = unsafe$iv$iv.getByte(nextMem$iv$iv + (long)j$iv$iv - (long)begin$iv$iv);
                  }
               }

               FilesKt.writeBytes(var151, bytes$iv$iv);
               byte byteSplit$iv = 69;
               $this$getEq$iv = ThirdLayer.idb;
               MessageDigest var154 = MessageDigest.getInstance("MD5");
               Charset var78 = Charsets.UTF_8;
               $i$f$firstOrNull = false;
               byte[] var35 = name.getBytes(var78);
               array$iv = var154.digest(var35);
               $i$f$retrieve = false;
               Iterable $this$firstOrNull$iv$iv = (Iterable)$this$getEq$iv.entrySet();
               var12 = false;
               Iterator var95 = $this$firstOrNull$iv$iv.iterator();

               byte[] bytes$iv$iv;
               while(true) {
                  if (var95.hasNext()) {
                     Object element$iv$iv = var95.next();
                     Entry $dstr$a$_u24__u24$iv = (Entry)element$iv$iv;
                     $i$f$firstOrNull = false;
                     var18 = false;
                     bytes$iv$iv = (byte[])$dstr$a$_u24__u24$iv.getKey();
                     var20 = false;
                     if (!Arrays.equals(bytes$iv$iv, array$iv)) {
                        continue;
                     }

                     var10000 = element$iv$iv;
                     break;
                  }

                  var10000 = null;
                  break;
               }

               Object var155 = (Entry)var10000 != null ? ((Entry)var10000).getValue() : null;
               if (var155 == null) {
                  Intrinsics.throwNpe();
               }

               long seed$iv = ((Number)var155).longValue();
               $i$f$retrieve = false;
               Map $this$getEq$iv$iv = Clientfiles.INSTANCE.getIndextable();
               MessageDigest var98 = MessageDigest.getInstance("MD5");
               Charset var111 = Charsets.UTF_8;
               var93 = false;
               bytes$iv$iv = name.getBytes(var111);
               byte[] array$iv$iv = var98.digest(bytes$iv$iv);
               $i$f$getEq = false;
               Iterable $this$firstOrNull$iv$iv$iv = (Iterable)$this$getEq$iv$iv.entrySet();
               var17 = false;
               Iterator var128 = $this$firstOrNull$iv$iv$iv.iterator();

               boolean var136;
               while(true) {
                  if (var128.hasNext()) {
                     Object element$iv$iv$iv = var128.next();
                     Entry $dstr$a$_u24__u24$iv$iv = (Entry)element$iv$iv$iv;
                     var136 = false;
                     var23 = false;
                     byte[] a$iv$iv = (byte[])$dstr$a$_u24__u24$iv$iv.getKey();
                     var144 = false;
                     if (!Arrays.equals(a$iv$iv, array$iv$iv)) {
                        continue;
                     }

                     var10000 = element$iv$iv$iv;
                     break;
                  }

                  var10000 = null;
                  break;
               }

               var10000 = (Entry)var10000 != null ? ((Entry)var10000).getValue() : null;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               long[] indexTable$iv$iv = (long[])var10000;
               var12 = false;
               $i$f$getEq = false;

               try {
                  Field f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                  f$iv$iv$iv.setAccessible(true);
                  var10000 = f$iv$iv$iv.get((Object)null);
                  if (var10000 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                  }

                  unsafe$iv$iv = (Unsafe)var10000;
               } catch (Exception var38) {
                  throw (Throwable)(new RuntimeException((Throwable)var38));
               }

               Unsafe unsafe$iv$iv = unsafe$iv$iv;
               Random random$iv$iv = RandomKt.Random(seed$iv);
               int splitcount$iv$iv = indexTable$iv$iv.length - 1;
               var120 = false;
               Map unusedIndexTable$iv$iv = (Map)(new LinkedHashMap());
               bytes$iv$iv = new byte[(int)indexTable$iv$iv[0]];
               i$iv$iv = 1;
               begin$iv$iv = splitcount$iv$iv;
               if (i$iv$iv <= splitcount$iv$iv) {
                  while(true) {
                     unusedIndexTable$iv$iv.put(i$iv$iv, indexTable$iv$iv[i$iv$iv]);
                     if (i$iv$iv == begin$iv$iv) {
                        break;
                     }

                     ++i$iv$iv;
                  }
               }

               i$iv$iv = 0;

               boolean var147;
               for(begin$iv$iv = splitcount$iv$iv; i$iv$iv < begin$iv$iv; ++i$iv$iv) {
                  begin$iv$iv = i$iv$iv * byteSplit$iv;
                  index$iv$iv = bytes$iv$iv.length;
                  int var145 = begin$iv$iv + byteSplit$iv;
                  var147 = false;
                  end$iv$iv = Math.min(index$iv$iv, var145);
                  index$iv$iv = ((Number)CollectionsKt.random((Collection)unusedIndexTable$iv$iv.keySet(), random$iv$iv)).intValue();
                  var10000 = unusedIndexTable$iv$iv.get(index$iv$iv);
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  long nextMem$iv$iv = ((Number)var10000).longValue();
                  unusedIndexTable$iv$iv.remove(index$iv$iv);
                  j$iv$iv = begin$iv$iv;

                  for(int var31 = end$iv$iv; j$iv$iv < var31; ++j$iv$iv) {
                     bytes$iv$iv[j$iv$iv] = unsafe$iv$iv.getByte(nextMem$iv$iv + (long)j$iv$iv - (long)begin$iv$iv);
                  }
               }

               ClassReader reader2 = new ClassReader(bytes$iv$iv);
               ClassNode node2 = new ClassNode();
               reader2.accept((ClassVisitor)node2, 8);
               Injector this_$iv = Injector.INSTANCE;
               $i$f$retrieveIndexedBytes = false;
               $this$firstOrNull$iv$iv = (Iterable)node2.methods;
               $i$f$firstOrNull = false;
               var87 = $this$firstOrNull$iv$iv.iterator();

               while(var87.hasNext()) {
                  element$iv$iv = var87.next();
                  MethodNode it$iv = (MethodNode)element$iv$iv;
                  var93 = false;
                  $i$f$firstOrNull = false;
                  System.out.println(it$iv);
                  if (it$iv.invisibleAnnotations != null) {
                     Iterable $this$map$iv$iv = (Iterable)it$iv.invisibleAnnotations;
                     var18 = false;
                     Collection destination$iv$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10)));
                     var136 = false;
                     Iterator var139 = $this$map$iv$iv.iterator();

                     while(var139.hasNext()) {
                        Object item$iv$iv$iv = var139.next();
                        AnnotationNode it$iv = (AnnotationNode)item$iv$iv$iv;
                        var147 = false;
                        destination$iv$iv$iv.add(it$iv);
                     }

                     Iterator var150 = ((List)destination$iv$iv$iv).iterator();

                     while(var150.hasNext()) {
                        AnnotationNode ann$iv = (AnnotationNode)var150.next();
                        if (Intrinsics.areEqual((Object)ann$iv.desc, (Object)"LEVENTMETA;")) {
                           it$iv.invisibleAnnotations.remove(ann$iv);
                           node.methods.add(it$iv);
                           break;
                        }
                     }
                  }
               }

               ClassWriter writer = new ClassWriter(0);
               node.accept((ClassVisitor)writer);
               return writer.toByteArray();
            } catch (Throwable var40) {
               var40.printStackTrace();
            }
         }
      }

      return basicClass;
   }
}
