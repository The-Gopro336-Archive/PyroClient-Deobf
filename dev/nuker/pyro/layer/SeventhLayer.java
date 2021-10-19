/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.TopLayer;
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

public class SeventhLayer {
   public static SeventhLayer INSTANCE;

   @JvmStatic
   public static void run(@NotNull ClassLoader var0, @NotNull LoaderGui gui, @NotNull byte[] cs, @NotNull DataInputStream si, @NotNull DataOutputStream so) {
      EncryptedStreamWrapper stream = new EncryptedStreamWrapper(si, so);
      ClassSigGen var7 = ClassSigGen.INSTANCE;
      Class[] classes$iv = new Class[]{SecondLayer.class, ThirdLayer.class, TopLayer.class, FifthLayer.class, FourthLayer.class};
      boolean $i$f$process = false;
      MessageDigest hash$iv = MessageDigest.getInstance("MD5");
      boolean var12 = false;
      Class[] var13 = classes$iv;
      int var14 = classes$iv.length;

      int length$iv$iv$iv;
      Class element$iv$iv;
      boolean var18;
      boolean var21;
      boolean var23;
      boolean var26;
      for(length$iv$iv$iv = 0; length$iv$iv$iv < var14; ++length$iv$iv$iv) {
         element$iv$iv = var13[length$iv$iv$iv];
         var18 = false;
         ClassSigGen var19 = ClassSigGen.INSTANCE;
         var21 = false;
         MessageDigest hash$iv$iv = MessageDigest.getInstance("MD5");
         var23 = false;
         List var24 = (List)(new ArrayList());
         List methods$iv$iv = var24;
         var26 = false;
         var24 = (List)(new ArrayList());
         List fields$iv$iv = var24;
         Field[] var118 = element$iv$iv.getDeclaredFields();
         boolean var27 = false;
         Field[] var28 = var118;
         int var29 = var118.length;

         String var10000;
         StringBuilder var10001;
         int var30;
         boolean var33;
         ClassSigGen var34;
         boolean var38;
         for(var30 = 0; var30 < var29; ++var30) {
            StringBuilder var36;
            label2036: {
               Field var31 = var28[var30];
               var33 = false;
               var10001 = (new StringBuilder()).append(var31.getModifiers()).append(' ').append(var31.getName()).append(' ');
               var34 = ClassSigGen.INSTANCE;
               String name$iv$iv$iv = var31.getType().getName();
               var36 = var10001;
               var38 = false;
               switch(name$iv$iv$iv.hashCode()) {
               case -1325958191:
                  if (name$iv$iv$iv.equals("double")) {
                     var10000 = "D";
                     break label2036;
                  }
                  break;
               case 104431:
                  if (name$iv$iv$iv.equals("int")) {
                     var10000 = "I";
                     break label2036;
                  }
                  break;
               case 3039496:
                  if (name$iv$iv$iv.equals("byte")) {
                     var10000 = "B";
                     break label2036;
                  }
                  break;
               case 3625364:
                  if (name$iv$iv$iv.equals("void")) {
                     var10000 = "V";
                     break label2036;
                  }
                  break;
               case 64711720:
                  if (name$iv$iv$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label2036;
                  }
                  break;
               case 97526364:
                  if (name$iv$iv$iv.equals("float")) {
                     var10000 = "F";
                     break label2036;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var40 = var10000;
            fields$iv$iv.add(var36.append(var40).toString());
         }

         Method[] var119 = element$iv$iv.getDeclaredMethods();
         var27 = false;
         Method[] var121 = var119;
         var29 = var119.length;

         for(var30 = 0; var30 < var29; ++var30) {
            Method var126 = var121[var30];
            var33 = false;
            var10001 = (new StringBuilder()).append(var126.getName()).append(" (");
            Parameter[] var129 = var126.getParameters();
            StringBuilder var131 = var10001;
            boolean var37 = false;
            Collection destination$iv$iv$iv$iv = (Collection)(new ArrayList(var129.length));
            boolean var136 = false;
            Parameter[] var41 = var129;
            int var42 = var129.length;

            for(int var43 = 0; var43 < var42; ++var43) {
               Object item$iv$iv$iv$iv = var41[var43];
               boolean var47 = false;
               Class var48 = item$iv$iv$iv$iv.getType();
               destination$iv$iv$iv$iv.add(var48);
            }

            List var46 = (List)destination$iv$iv$iv$iv;
            Iterable $this$map$iv$iv$iv = (Iterable)var46;
            var37 = false;
            destination$iv$iv$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10)));
            var136 = false;
            Iterator var137 = $this$map$iv$iv$iv.iterator();

            while(var137.hasNext()) {
               label2063: {
                  Object var138 = var137.next();
                  Class it$iv$iv = (Class)var138;
                  boolean var140 = false;
                  ClassSigGen var45 = ClassSigGen.INSTANCE;
                  String name$iv$iv$iv = it$iv$iv.getName();
                  boolean var49 = false;
                  switch(name$iv$iv$iv.hashCode()) {
                  case -1325958191:
                     if (name$iv$iv$iv.equals("double")) {
                        var10000 = "D";
                        break label2063;
                     }
                     break;
                  case 104431:
                     if (name$iv$iv$iv.equals("int")) {
                        var10000 = "I";
                        break label2063;
                     }
                     break;
                  case 3039496:
                     if (name$iv$iv$iv.equals("byte")) {
                        var10000 = "B";
                        break label2063;
                     }
                     break;
                  case 3625364:
                     if (name$iv$iv$iv.equals("void")) {
                        var10000 = "V";
                        break label2063;
                     }
                     break;
                  case 64711720:
                     if (name$iv$iv$iv.equals("boolean")) {
                        var10000 = "Z";
                        break label2063;
                     }
                     break;
                  case 97526364:
                     if (name$iv$iv$iv.equals("float")) {
                        var10000 = "F";
                        break label2063;
                     }
                  }

                  var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
               }

               String var143 = var10000;
               destination$iv$iv$iv$iv.add(var143);
            }

            label2078: {
               var46 = (List)destination$iv$iv$iv$iv;
               var10001 = var131.append(CollectionsKt.joinToString$default((Iterable)var46, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null)).append(')');
               var34 = ClassSigGen.INSTANCE;
               String name$iv$iv$iv = var126.getReturnType().getName();
               var131 = var10001;
               var38 = false;
               switch(name$iv$iv$iv.hashCode()) {
               case -1325958191:
                  if (name$iv$iv$iv.equals("double")) {
                     var10000 = "D";
                     break label2078;
                  }
                  break;
               case 104431:
                  if (name$iv$iv$iv.equals("int")) {
                     var10000 = "I";
                     break label2078;
                  }
                  break;
               case 3039496:
                  if (name$iv$iv$iv.equals("byte")) {
                     var10000 = "B";
                     break label2078;
                  }
                  break;
               case 3625364:
                  if (name$iv$iv$iv.equals("void")) {
                     var10000 = "V";
                     break label2078;
                  }
                  break;
               case 64711720:
                  if (name$iv$iv$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label2078;
                  }
                  break;
               case 97526364:
                  if (name$iv$iv$iv.equals("float")) {
                     var10000 = "F";
                     break label2078;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var141 = var10000;
            methods$iv$iv.add(var131.append(var141).toString());
         }

         Iterable var120 = (Iterable)CollectionsKt.sortedWith((Iterable)fields$iv$iv, (Comparator)ClassSigGen$getClassChecksum2$3.INSTANCE);
         var27 = false;
         Iterator var123 = var120.iterator();

         Object var125;
         String it$iv$iv;
         boolean var128;
         Charset var132;
         boolean var133;
         byte[] var134;
         while(var123.hasNext()) {
            var125 = var123.next();
            it$iv$iv = (String)var125;
            var128 = false;
            var132 = Charsets.UTF_8;
            var133 = false;
            if (it$iv$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            var134 = it$iv$iv.getBytes(var132);
            hash$iv$iv.update(var134);
         }

         var120 = (Iterable)CollectionsKt.sortedWith((Iterable)methods$iv$iv, (Comparator)ClassSigGen$getClassChecksum2$5.INSTANCE);
         var27 = false;
         var123 = var120.iterator();

         while(var123.hasNext()) {
            var125 = var123.next();
            it$iv$iv = (String)var125;
            var128 = false;
            var132 = Charsets.UTF_8;
            var133 = false;
            if (it$iv$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            var134 = it$iv$iv.getBytes(var132);
            hash$iv$iv.update(var134);
         }

         hash$iv.update(hash$iv$iv.digest());
      }

      var12 = false;
      var13 = classes$iv;
      var14 = classes$iv.length;

      boolean var20;
      Object var148;
      for(length$iv$iv$iv = 0; length$iv$iv$iv < var14; ++length$iv$iv$iv) {
         element$iv$iv = var13[length$iv$iv$iv];
         var18 = false;
         var20 = false;
         InputStream var147 = element$iv$iv.getClassLoader().getResourceAsStream(StringsKt.replace$default(element$iv$iv.getName(), ".", "/", false, 4, (Object)null) + ".class");
         if (var147 == null) {
            Field var112 = LaunchClassLoader.class.getDeclaredField("resourceCache");
            boolean var52 = false;
            var23 = false;
            var26 = false;
            var112.setAccessible(true);
            var148 = var112.get(Launch.classLoader);
            if (var148 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
            }

            Map var122 = (Map)var148;
            byte[] var53 = (byte[])var122.get(element$iv$iv.getName());
            var147 = (InputStream)(new ByteArrayInputStream(var53));
         }

         byte[] var124 = IOUtils.toByteArray(var147);
         hash$iv.update(var124);
      }

      byte[] br = hash$iv.digest();
      boolean var56 = false;
      byte[] var144 = new byte[]{32, 120, 45, 34, 66, 43, 87, 54, 0, 0, 0};
      byte var58;
      stream.setI((byte)((var58 = stream.getI()) + 1));
      var144[8] = var58;
      var144[9] = 16;
      var144[10] = 86;
      stream.setSalt(var144);
      var144 = Encryption.INSTANCE.getRandomNonce(12);
      if (var144 == null) {
         Intrinsics.throwNpe();
      }

      stream.setIv(var144);
      Encryption var62 = Encryption.INSTANCE;
      var12 = false;
      String var74 = ArraysKt.joinToString$default(br, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)UtilsKt$hexString$1.INSTANCE, 30, (Object)null);
      var12 = false;
      if (var74 == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         char[] var76 = var74.toCharArray();
         SecretKey var145 = var62.getAESKeyFromPassword(var76, stream.getSalt());
         if (var145 == null) {
            Intrinsics.throwNpe();
         }

         stream.setKey(var145);
         boolean var55 = false;
         byte[] var57 = Encryption.INSTANCE.encryptWithPrefixIV(cs, stream.getKey(), stream.getIv());
         DataOutputStream $this$writeByteArray$iv$iv = stream.getOutStream();
         if (var57 == null) {
            Intrinsics.throwNpe();
         }

         int $i$f$forEach = false;
         $this$writeByteArray$iv$iv.writeInt(var57.length);
         $this$writeByteArray$iv$iv.write(var57);
         NestedClassloader classloader = new NestedClassloader(INSTANCE.getClass().getClassLoader());
         $i$f$process = false;
         DataInputStream var63 = stream.getInStream();
         $i$f$forEach = false;
         InputStream $this$readByteArray$iv$iv$iv = (InputStream)var63;
         int length$iv$iv$iv = var63.readInt();
         boolean var80 = false;
         byte[] bytes$iv = new byte[length$iv$iv$iv];

         int read$iv$iv$iv;
         for(int bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < length$iv$iv$iv; bytesRead$iv$iv$iv += read$iv$iv$iv) {
            read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(bytes$iv, bytesRead$iv$iv$iv, bytes$iv.length - bytesRead$iv$iv$iv);
            if (read$iv$iv$iv == -1) {
               break;
            }
         }

         br = Encryption.INSTANCE.decryptWithPrefixIV(bytes$iv, stream.getKey());
         var56 = false;
         $i$f$process = false;
         Map map$iv = (Map)(new LinkedHashMap());
         ZipInputStream zipIn$iv = new ZipInputStream((InputStream)(new ByteArrayInputStream(br)));
         Ref.ObjectRef entry$iv = new Ref.ObjectRef();

         while(true) {
            ZipEntry var75 = zipIn$iv.getNextEntry();
            boolean var81 = false;
            var80 = false;
            boolean var97 = false;
            entry$iv.element = var75;
            byte[] contents$iv;
            boolean $i$f$writeByteArray;
            boolean var107;
            ZipEntry var146;
            if (var75 == null) {
               $i$f$process = false;
               boolean this_$iv = false;
               Map classMap$iv = (Map)(new LinkedHashMap());
               var81 = false;
               Iterator var85 = map$iv.entrySet().iterator();

               while(var85.hasNext()) {
                  Entry var68 = (Entry)var85.next();
                  var97 = false;
                  String name$iv = (String)var68.getKey();
                  var97 = false;
                  byte[] bytes$iv = (byte[])var68.getValue();
                  if (StringsKt.endsWith$default(name$iv, ".class", false, 2, (Object)null)) {
                     classMap$iv.put(StringsKt.substringBefore$default(StringsKt.replace$default(name$iv, "/", ".", false, 4, (Object)null), ".class", (String)null, 2, (Object)null), bytes$iv);
                  } else {
                     classMap$iv.put(name$iv, bytes$iv);
                     PyroClientLoadingPlugin.resources.put(name$iv, bytes$iv);
                  }
               }

               $i$f$process = false;
               this_$iv = false;
               var12 = false;
               var80 = false;
               var97 = false;
               Iterator var99 = classMap$iv.entrySet().iterator();

               while(var99.hasNext()) {
                  Entry var104 = (Entry)var99.next();
                  var20 = false;
                  boolean var114 = false;
                  String name = (String)var104.getKey();
                  var114 = false;
                  byte[] bytes = (byte[])var104.getValue();
                  classloader.loadResource(name, bytes);
               }

               var148 = classloader.loadClass("dev.nuker.pyro.security.FlagChecker").getMethod("recheck").invoke((Object)null);
               if (var148 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
               }

               int ret = (Integer)var148;
               this_$iv = false;
               contents$iv = ByteBuffer.allocate(4).putInt(ret).array();
               var81 = false;
               byte[] contents$iv = Encryption.INSTANCE.encryptWithPrefixIV(contents$iv, stream.getKey(), stream.getIv());
               DataOutputStream $this$writeByteArray$iv$iv$iv = stream.getOutStream();
               if (contents$iv == null) {
                  Intrinsics.throwNpe();
               }

               $i$f$writeByteArray = false;
               $this$writeByteArray$iv$iv$iv.writeInt(contents$iv.length);
               $this$writeByteArray$iv$iv$iv.write(contents$iv);
               $i$f$forEach = false;
               DataInputStream var84 = stream.getInStream();
               var81 = false;
               InputStream $this$readByteArray$iv$iv$iv = (InputStream)var84;
               length$iv$iv$iv = var84.readInt();
               var97 = false;
               byte[] array$iv$iv$iv = new byte[length$iv$iv$iv];

               int read$iv$iv$iv;
               for(int bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < length$iv$iv$iv; bytesRead$iv$iv$iv += read$iv$iv$iv) {
                  read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(array$iv$iv$iv, bytesRead$iv$iv$iv, array$iv$iv$iv.length - bytesRead$iv$iv$iv);
                  if (read$iv$iv$iv == -1) {
                     break;
                  }
               }

               byte[] nextBytes = Encryption.INSTANCE.decryptWithPrefixIV(array$iv$iv$iv, stream.getKey());
               this_$iv = false;
               $i$f$forEach = false;
               Map map$iv = (Map)(new LinkedHashMap());
               ZipInputStream zipIn$iv = new ZipInputStream((InputStream)(new ByteArrayInputStream(nextBytes)));
               Ref.ObjectRef entry$iv = new Ref.ObjectRef();

               while(true) {
                  ZipEntry var95 = zipIn$iv.getNextEntry();
                  boolean var100 = false;
                  var97 = false;
                  var18 = false;
                  entry$iv.element = var95;
                  if (var95 == null) {
                     $i$f$forEach = false;
                     var12 = false;
                     Map classMap$iv = (Map)(new LinkedHashMap());
                     var100 = false;
                     Iterator var110 = map$iv.entrySet().iterator();

                     while(var110.hasNext()) {
                        Entry var90 = (Entry)var110.next();
                        var18 = false;
                        String name$iv = (String)var90.getKey();
                        var18 = false;
                        bytes$iv = (byte[])var90.getValue();
                        if (StringsKt.endsWith$default(name$iv, ".class", false, 2, (Object)null)) {
                           classMap$iv.put(StringsKt.substringBefore$default(StringsKt.replace$default(name$iv, "/", ".", false, 4, (Object)null), ".class", (String)null, 2, (Object)null), bytes$iv);
                        } else {
                           classMap$iv.put(name$iv, bytes$iv);
                           PyroClientLoadingPlugin.resources.put(name$iv, bytes$iv);
                        }
                     }

                     $i$f$forEach = false;
                     var81 = false;
                     var85 = classMap$iv.entrySet().iterator();

                     while(var85.hasNext()) {
                        Entry var106 = (Entry)var85.next();
                        $i$f$writeByteArray = false;
                        var107 = false;
                        String name = (String)var106.getKey();
                        var107 = false;
                        byte[] bytes = (byte[])var106.getValue();
                        classloader.loadResource(name, bytes);
                     }

                     Method var73 = classloader.loadClass("dev.nuker.pyro.layer.DownloadLayer").getMethod("run", LoaderGui.class, DataInputStream.class, DataOutputStream.class);
                     var73.invoke((Object)null, gui, si, so);
                     return;
                  }

                  contents$iv = new byte[4096];
                  Ref.IntRef direct$iv = new Ref.IntRef();
                  ByteArrayOutputStream stream$iv = new ByteArrayOutputStream();

                  while(true) {
                     read$iv$iv$iv = zipIn$iv.read(contents$iv, 0, contents$iv.length);
                     var18 = false;
                     var107 = false;
                     var21 = false;
                     direct$iv.element = read$iv$iv$iv;
                     if (read$iv$iv$iv < 0) {
                        var146 = (ZipEntry)entry$iv.element;
                        if (var146 == null) {
                           Intrinsics.throwNpe();
                        }

                        map$iv.put(var146.getName(), stream$iv.toByteArray());
                        zipIn$iv.closeEntry();
                        break;
                     }

                     stream$iv.write(contents$iv, 0, direct$iv.element);
                  }
               }
            }

            contents$iv = new byte[4096];
            Ref.IntRef direct$iv = new Ref.IntRef();
            ByteArrayOutputStream stream$iv = new ByteArrayOutputStream();

            while(true) {
               length$iv$iv$iv = zipIn$iv.read(contents$iv, 0, contents$iv.length);
               var97 = false;
               $i$f$writeByteArray = false;
               var107 = false;
               direct$iv.element = length$iv$iv$iv;
               if (length$iv$iv$iv < 0) {
                  var146 = (ZipEntry)entry$iv.element;
                  if (var146 == null) {
                     Intrinsics.throwNpe();
                  }

                  map$iv.put(var146.getName(), stream$iv.toByteArray());
                  zipIn$iv.closeEntry();
                  break;
               }

               stream$iv.write(contents$iv, 0, direct$iv.element);
            }
         }
      }
   }

   static {
      SeventhLayer var0 = new SeventhLayer();
      INSTANCE = var0;
   }
}
