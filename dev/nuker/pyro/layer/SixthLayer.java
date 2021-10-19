/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.LoaderGui;
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
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.crypto.SecretKey;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

public class SixthLayer {
   public static SixthLayer INSTANCE;

   @JvmStatic
   public static void run(@NotNull LoaderGui gui, @NotNull DataInputStream si, @NotNull DataOutputStream so) {
      EncryptedStreamWrapper stream = new EncryptedStreamWrapper(si, so);
      ClassSigGen var5 = ClassSigGen.INSTANCE;
      Class[] classes$iv = new Class[]{SecondLayer.class, ThirdLayer.class, FifthLayer.class, FourthLayer.class};
      boolean var7 = false;
      MessageDigest hash$iv = MessageDigest.getInstance("MD5");
      boolean var10 = false;
      Class[] var11 = classes$iv;
      int length$iv$iv$iv = classes$iv.length;

      int var13;
      Class var14;
      boolean var16;
      boolean var19;
      boolean var21;
      boolean var24;
      for(var13 = 0; var13 < length$iv$iv$iv; ++var13) {
         var14 = var11[var13];
         var16 = false;
         ClassSigGen var17 = ClassSigGen.INSTANCE;
         var19 = false;
         MessageDigest hash$iv$iv = MessageDigest.getInstance("MD5");
         var21 = false;
         List var22 = (List)(new ArrayList());
         List methods$iv$iv = var22;
         var24 = false;
         var22 = (List)(new ArrayList());
         List fields$iv$iv = var22;
         Field[] var102 = var14.getDeclaredFields();
         boolean var25 = false;
         Field[] var26 = var102;
         int var27 = var102.length;

         String var10000;
         StringBuilder var10001;
         int var28;
         boolean var31;
         ClassSigGen var32;
         boolean var36;
         for(var28 = 0; var28 < var27; ++var28) {
            StringBuilder var34;
            label1777: {
               Field var29 = var26[var28];
               var31 = false;
               var10001 = (new StringBuilder()).append(var29.getModifiers()).append(' ').append(var29.getName()).append(' ');
               var32 = ClassSigGen.INSTANCE;
               String name$iv$iv$iv = var29.getType().getName();
               var34 = var10001;
               var36 = false;
               switch(name$iv$iv$iv.hashCode()) {
               case -1325958191:
                  if (name$iv$iv$iv.equals("double")) {
                     var10000 = "D";
                     break label1777;
                  }
                  break;
               case 104431:
                  if (name$iv$iv$iv.equals("int")) {
                     var10000 = "I";
                     break label1777;
                  }
                  break;
               case 3039496:
                  if (name$iv$iv$iv.equals("byte")) {
                     var10000 = "B";
                     break label1777;
                  }
                  break;
               case 3625364:
                  if (name$iv$iv$iv.equals("void")) {
                     var10000 = "V";
                     break label1777;
                  }
                  break;
               case 64711720:
                  if (name$iv$iv$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label1777;
                  }
                  break;
               case 97526364:
                  if (name$iv$iv$iv.equals("float")) {
                     var10000 = "F";
                     break label1777;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var38 = var10000;
            fields$iv$iv.add(var34.append(var38).toString());
         }

         Method[] $this$forEach$iv$iv$iv = var14.getDeclaredMethods();
         var25 = false;
         Method[] var106 = $this$forEach$iv$iv$iv;
         var27 = $this$forEach$iv$iv$iv.length;

         for(var28 = 0; var28 < var27; ++var28) {
            Object element$iv$iv$iv = var106[var28];
            var31 = false;
            var10001 = (new StringBuilder()).append(element$iv$iv$iv.getName()).append(" (");
            Parameter[] var114 = element$iv$iv$iv.getParameters();
            StringBuilder var116 = var10001;
            boolean var35 = false;
            Collection destination$iv$iv$iv$iv = (Collection)(new ArrayList(var114.length));
            boolean var121 = false;
            Parameter[] var39 = var114;
            int var40 = var114.length;

            for(int var41 = 0; var41 < var40; ++var41) {
               Object item$iv$iv$iv$iv = var39[var41];
               boolean var45 = false;
               Class var46 = item$iv$iv$iv$iv.getType();
               destination$iv$iv$iv$iv.add(var46);
            }

            List var44 = (List)destination$iv$iv$iv$iv;
            Iterable $this$map$iv$iv$iv = (Iterable)var44;
            var35 = false;
            destination$iv$iv$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10)));
            var121 = false;
            Iterator var122 = $this$map$iv$iv$iv.iterator();

            while(var122.hasNext()) {
               label1804: {
                  Object var123 = var122.next();
                  Class it$iv$iv = (Class)var123;
                  boolean var125 = false;
                  ClassSigGen var43 = ClassSigGen.INSTANCE;
                  String name$iv$iv$iv = it$iv$iv.getName();
                  boolean var47 = false;
                  switch(name$iv$iv$iv.hashCode()) {
                  case -1325958191:
                     if (name$iv$iv$iv.equals("double")) {
                        var10000 = "D";
                        break label1804;
                     }
                     break;
                  case 104431:
                     if (name$iv$iv$iv.equals("int")) {
                        var10000 = "I";
                        break label1804;
                     }
                     break;
                  case 3039496:
                     if (name$iv$iv$iv.equals("byte")) {
                        var10000 = "B";
                        break label1804;
                     }
                     break;
                  case 3625364:
                     if (name$iv$iv$iv.equals("void")) {
                        var10000 = "V";
                        break label1804;
                     }
                     break;
                  case 64711720:
                     if (name$iv$iv$iv.equals("boolean")) {
                        var10000 = "Z";
                        break label1804;
                     }
                     break;
                  case 97526364:
                     if (name$iv$iv$iv.equals("float")) {
                        var10000 = "F";
                        break label1804;
                     }
                  }

                  var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
               }

               String var128 = var10000;
               destination$iv$iv$iv$iv.add(var128);
            }

            label1819: {
               var44 = (List)destination$iv$iv$iv$iv;
               var10001 = var116.append(CollectionsKt.joinToString$default((Iterable)var44, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null)).append(')');
               var32 = ClassSigGen.INSTANCE;
               String name$iv$iv$iv = element$iv$iv$iv.getReturnType().getName();
               var116 = var10001;
               var36 = false;
               switch(name$iv$iv$iv.hashCode()) {
               case -1325958191:
                  if (name$iv$iv$iv.equals("double")) {
                     var10000 = "D";
                     break label1819;
                  }
                  break;
               case 104431:
                  if (name$iv$iv$iv.equals("int")) {
                     var10000 = "I";
                     break label1819;
                  }
                  break;
               case 3039496:
                  if (name$iv$iv$iv.equals("byte")) {
                     var10000 = "B";
                     break label1819;
                  }
                  break;
               case 3625364:
                  if (name$iv$iv$iv.equals("void")) {
                     var10000 = "V";
                     break label1819;
                  }
                  break;
               case 64711720:
                  if (name$iv$iv$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label1819;
                  }
                  break;
               case 97526364:
                  if (name$iv$iv$iv.equals("float")) {
                     var10000 = "F";
                     break label1819;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var126 = var10000;
            methods$iv$iv.add(var116.append(var126).toString());
         }

         Iterable $this$forEach$iv$iv$iv = (Iterable)CollectionsKt.sortedWith((Iterable)fields$iv$iv, (Comparator)ClassSigGen$getClassChecksum2$3.INSTANCE);
         var25 = false;
         Iterator var108 = $this$forEach$iv$iv$iv.iterator();

         Object var110;
         String it$iv$iv;
         boolean var113;
         Charset var117;
         boolean var118;
         byte[] var119;
         while(var108.hasNext()) {
            var110 = var108.next();
            it$iv$iv = (String)var110;
            var113 = false;
            var117 = Charsets.UTF_8;
            var118 = false;
            if (it$iv$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            var119 = it$iv$iv.getBytes(var117);
            hash$iv$iv.update(var119);
         }

         $this$forEach$iv$iv$iv = (Iterable)CollectionsKt.sortedWith((Iterable)methods$iv$iv, (Comparator)ClassSigGen$getClassChecksum2$5.INSTANCE);
         var25 = false;
         var108 = $this$forEach$iv$iv$iv.iterator();

         while(var108.hasNext()) {
            var110 = var108.next();
            it$iv$iv = (String)var110;
            var113 = false;
            var117 = Charsets.UTF_8;
            var118 = false;
            if (it$iv$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            var119 = it$iv$iv.getBytes(var117);
            hash$iv$iv.update(var119);
         }

         hash$iv.update(hash$iv$iv.digest());
      }

      var10 = false;
      var11 = classes$iv;
      length$iv$iv$iv = classes$iv.length;

      Object var133;
      for(var13 = 0; var13 < length$iv$iv$iv; ++var13) {
         var14 = var11[var13];
         var16 = false;
         boolean var18 = false;
         InputStream var132 = var14.getClassLoader().getResourceAsStream(StringsKt.replace$default(var14.getName(), ".", "/", false, 4, (Object)null) + ".class");
         if (var132 == null) {
            Field var95 = LaunchClassLoader.class.getDeclaredField("resourceCache");
            boolean var50 = false;
            var21 = false;
            var24 = false;
            var95.setAccessible(true);
            var133 = var95.get(Launch.classLoader);
            if (var133 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
            }

            Map var107 = (Map)var133;
            byte[] var51 = (byte[])var107.get(var14.getName());
            var132 = (InputStream)(new ByteArrayInputStream(var51));
         }

         byte[] var109 = IOUtils.toByteArray(var132);
         hash$iv.update(var109);
      }

      byte[] cs = hash$iv.digest();
      var7 = false;
      byte[] var129 = new byte[]{32, 120, 45, 34, 66, 43, 87, 54, 0, 0, 0};
      byte var57;
      stream.setI((byte)((var57 = stream.getI()) + 1));
      var129[8] = var57;
      var129[9] = 16;
      var129[10] = 86;
      stream.setSalt(var129);
      var129 = Encryption.INSTANCE.getRandomNonce(12);
      if (var129 == null) {
         Intrinsics.throwNpe();
      }

      stream.setIv(var129);
      Encryption var9 = Encryption.INSTANCE;
      boolean $i$f$writeByteArray = false;
      String name$iv = ArraysKt.joinToString$default(cs, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)UtilsKt$hexString$1.INSTANCE, 30, (Object)null);
      $i$f$writeByteArray = false;
      if (name$iv == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         char[] var75 = name$iv.toCharArray();
         SecretKey var130 = var9.getAESKeyFromPassword(var75, stream.getSalt());
         if (var130 == null) {
            Intrinsics.throwNpe();
         }

         stream.setKey(var130);
         byte value$iv = 42;
         var7 = false;
         byte[] var61 = ByteBuffer.allocate(4).putInt(value$iv).array();
         var10 = false;
         byte[] var72 = Encryption.INSTANCE.encryptWithPrefixIV(var61, stream.getKey(), stream.getIv());
         DataOutputStream $this$writeByteArray$iv$iv$iv = stream.getOutStream();
         if (var72 == null) {
            Intrinsics.throwNpe();
         }

         boolean var83 = false;
         $this$writeByteArray$iv$iv$iv.writeInt(var72.length);
         $this$writeByteArray$iv$iv$iv.write(var72);
         int value$iv = "life, the universe, and everything";
         Charset var56 = Charsets.UTF_8;
         boolean $i$f$readByteArray = false;
         byte[] nextBytes = value$iv.getBytes(var56);
         var7 = false;
         byte[] var60 = Encryption.INSTANCE.encryptWithPrefixIV(nextBytes, stream.getKey(), stream.getIv());
         DataOutputStream $this$writeByteArray$iv$iv = stream.getOutStream();
         if (var60 == null) {
            Intrinsics.throwNpe();
         }

         $i$f$writeByteArray = false;
         $this$writeByteArray$iv$iv.writeInt(var60.length);
         $this$writeByteArray$iv$iv.write(var60);
         NestedClassloader classloaderA = new NestedClassloader(INSTANCE.getClass().getClassLoader());
         $i$f$readByteArray = false;
         DataInputStream var63 = stream.getInStream();
         var10 = false;
         InputStream $this$readByteArray$iv$iv$iv = (InputStream)var63;
         length$iv$iv$iv = var63.readInt();
         boolean var81 = false;
         byte[] array$iv$iv$iv = new byte[length$iv$iv$iv];

         int bytesRead$iv$iv$iv;
         int read$iv$iv$iv;
         for(bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < length$iv$iv$iv; bytesRead$iv$iv$iv += read$iv$iv$iv) {
            read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(array$iv$iv$iv, bytesRead$iv$iv$iv, array$iv$iv$iv.length - bytesRead$iv$iv$iv);
            if (read$iv$iv$iv == -1) {
               break;
            }
         }

         nextBytes = Encryption.INSTANCE.decryptWithPrefixIV(array$iv$iv$iv, stream.getKey());
         $i$f$readByteArray = false;
         boolean var65 = false;
         Map map$iv = (Map)(new LinkedHashMap());
         ZipInputStream zipIn$iv = new ZipInputStream((InputStream)(new ByteArrayInputStream(nextBytes)));
         Ref.ObjectRef entry$iv = new Ref.ObjectRef();

         while(true) {
            ZipEntry var80 = zipIn$iv.getNextEntry();
            var81 = false;
            var83 = false;
            var16 = false;
            entry$iv.element = var80;
            boolean var92;
            if (var80 == null) {
               var65 = false;
               var10 = false;
               Map classMap$iv = (Map)(new LinkedHashMap());
               var81 = false;
               Iterator var89 = map$iv.entrySet().iterator();

               while(var89.hasNext()) {
                  Entry var71 = (Entry)var89.next();
                  var16 = false;
                  name$iv = (String)var71.getKey();
                  var16 = false;
                  byte[] bytes$iv = (byte[])var71.getValue();
                  if (StringsKt.endsWith$default(name$iv, ".class", false, 2, (Object)null)) {
                     classMap$iv.put(StringsKt.substringBefore$default(StringsKt.replace$default(name$iv, "/", ".", false, 4, (Object)null), ".class", (String)null, 2, (Object)null), bytes$iv);
                  } else {
                     classMap$iv.put(name$iv, bytes$iv);
                     PyroClientLoadingPlugin.resources.put(name$iv, bytes$iv);
                  }
               }

               var65 = false;
               var10 = false;
               boolean var86 = false;
               var83 = false;
               var16 = false;
               Iterator var93 = classMap$iv.entrySet().iterator();

               while(var93.hasNext()) {
                  Entry var94 = (Entry)var93.next();
                  boolean var96 = false;
                  boolean var100 = false;
                  String name = (String)var94.getKey();
                  var100 = false;
                  byte[] bytes = (byte[])var94.getValue();
                  classloaderA.loadResource(name, bytes);
               }

               Class classloaderBClass = classloaderA.loadClass("dev.nuker.pyro.security.NestedClassloader");
               Object classloaderB = classloaderBClass.getConstructor(ClassLoader.class).newInstance(INSTANCE.getClass().getClassLoader());
               $i$f$writeByteArray = false;
               var81 = false;
               var89 = classMap$iv.entrySet().iterator();

               while(var89.hasNext()) {
                  Entry var90 = (Entry)var89.next();
                  var92 = false;
                  var19 = false;
                  String name = (String)var90.getKey();
                  var19 = false;
                  byte[] bytes = (byte[])var90.getValue();
                  classloaderBClass.getMethod("loadResource", String.class, byte[].class).invoke(classloaderB, name, bytes);
               }

               var133 = classloaderBClass.getMethod("loadClass", String.class).invoke(classloaderB, "dev.nuker.pyro.layer.SeventhLayer");
               if (var133 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
               }

               Method var74 = ((Class)var133).getMethod("run", ClassLoader.class, LoaderGui.class, byte[].class, DataInputStream.class, DataOutputStream.class);
               var74.invoke((Object)null, INSTANCE.getClass().getClassLoader(), gui, cs, si, so);
               return;
            }

            byte[] contents$iv = new byte[4096];
            Ref.IntRef direct$iv = new Ref.IntRef();
            ByteArrayOutputStream stream$iv = new ByteArrayOutputStream();

            while(true) {
               bytesRead$iv$iv$iv = zipIn$iv.read(contents$iv, 0, contents$iv.length);
               var16 = false;
               var92 = false;
               var19 = false;
               direct$iv.element = bytesRead$iv$iv$iv;
               if (bytesRead$iv$iv$iv < 0) {
                  ZipEntry var131 = (ZipEntry)entry$iv.element;
                  if (var131 == null) {
                     Intrinsics.throwNpe();
                  }

                  map$iv.put(var131.getName(), stream$iv.toByteArray());
                  zipIn$iv.closeEntry();
                  break;
               }

               stream$iv.write(contents$iv, 0, direct$iv.element);
            }
         }
      }
   }

   static {
      SixthLayer var0 = new SixthLayer();
      INSTANCE = var0;
   }
}
