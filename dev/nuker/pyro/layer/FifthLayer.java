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
import dev.nuker.pyro.security.NestedClassloader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
import kotlin.TypeCastException;
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

public class FifthLayer {
   public static FifthLayer INSTANCE;

   @JvmStatic
   public static void run(@NotNull LoaderGui gui, @NotNull DataInputStream si, @NotNull DataOutputStream so) {
      so.writeInt(-616972404);
      NestedClassloader classloader = new NestedClassloader(INSTANCE.getClass().getClassLoader());
      so.writeInt(-497447601);
      ClassSigGen var5 = ClassSigGen.INSTANCE;
      Class[] classes$iv = new Class[]{TopLayer.class, SecondLayer.class, ThirdLayer.class, FourthLayer.class, FifthLayer.class};
      boolean $i$f$writeByteArray = false;
      MessageDigest hash$iv = MessageDigest.getInstance("MD5");
      boolean var10 = false;
      Class[] var11 = classes$iv;
      int bytesRead$iv$iv = classes$iv.length;

      int read$iv$iv;
      Class element$iv$iv;
      boolean var16;
      boolean var21;
      boolean var24;
      for(read$iv$iv = 0; read$iv$iv < bytesRead$iv$iv; ++read$iv$iv) {
         element$iv$iv = var11[read$iv$iv];
         var16 = false;
         ClassSigGen var17 = ClassSigGen.INSTANCE;
         boolean var19 = false;
         MessageDigest hash$iv$iv = MessageDigest.getInstance("MD5");
         var21 = false;
         List var22 = (List)(new ArrayList());
         List methods$iv$iv = var22;
         var24 = false;
         var22 = (List)(new ArrayList());
         List fields$iv$iv = var22;
         Field[] var81 = element$iv$iv.getDeclaredFields();
         boolean var25 = false;
         Field[] var26 = var81;
         int var27 = var81.length;

         String var10000;
         StringBuilder var10001;
         int var28;
         boolean var31;
         ClassSigGen var32;
         boolean var36;
         for(var28 = 0; var28 < var27; ++var28) {
            StringBuilder var34;
            label1464: {
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
                     break label1464;
                  }
                  break;
               case 104431:
                  if (name$iv$iv$iv.equals("int")) {
                     var10000 = "I";
                     break label1464;
                  }
                  break;
               case 3039496:
                  if (name$iv$iv$iv.equals("byte")) {
                     var10000 = "B";
                     break label1464;
                  }
                  break;
               case 3625364:
                  if (name$iv$iv$iv.equals("void")) {
                     var10000 = "V";
                     break label1464;
                  }
                  break;
               case 64711720:
                  if (name$iv$iv$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label1464;
                  }
                  break;
               case 97526364:
                  if (name$iv$iv$iv.equals("float")) {
                     var10000 = "F";
                     break label1464;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var38 = var10000;
            fields$iv$iv.add(var34.append(var38).toString());
         }

         Method[] var82 = element$iv$iv.getDeclaredMethods();
         var25 = false;
         Method[] var84 = var82;
         var27 = var82.length;

         for(var28 = 0; var28 < var27; ++var28) {
            Method var89 = var84[var28];
            var31 = false;
            var10001 = (new StringBuilder()).append(var89.getName()).append(" (");
            Parameter[] var92 = var89.getParameters();
            StringBuilder var94 = var10001;
            boolean var35 = false;
            Collection destination$iv$iv$iv$iv = (Collection)(new ArrayList(var92.length));
            boolean var99 = false;
            Parameter[] var39 = var92;
            int var40 = var92.length;

            for(int var41 = 0; var41 < var40; ++var41) {
               Parameter item$iv$iv$iv$iv = var39[var41];
               boolean var45 = false;
               Class var46 = item$iv$iv$iv$iv.getType();
               destination$iv$iv$iv$iv.add(var46);
            }

            List var44 = (List)destination$iv$iv$iv$iv;
            Iterable $this$map$iv$iv$iv = (Iterable)var44;
            var35 = false;
            destination$iv$iv$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv$iv, 10)));
            var99 = false;
            Iterator var100 = $this$map$iv$iv$iv.iterator();

            while(var100.hasNext()) {
               label1491: {
                  Object var101 = var100.next();
                  Class it$iv$iv = (Class)var101;
                  boolean var103 = false;
                  ClassSigGen var43 = ClassSigGen.INSTANCE;
                  String name$iv$iv$iv = it$iv$iv.getName();
                  boolean var47 = false;
                  switch(name$iv$iv$iv.hashCode()) {
                  case -1325958191:
                     if (name$iv$iv$iv.equals("double")) {
                        var10000 = "D";
                        break label1491;
                     }
                     break;
                  case 104431:
                     if (name$iv$iv$iv.equals("int")) {
                        var10000 = "I";
                        break label1491;
                     }
                     break;
                  case 3039496:
                     if (name$iv$iv$iv.equals("byte")) {
                        var10000 = "B";
                        break label1491;
                     }
                     break;
                  case 3625364:
                     if (name$iv$iv$iv.equals("void")) {
                        var10000 = "V";
                        break label1491;
                     }
                     break;
                  case 64711720:
                     if (name$iv$iv$iv.equals("boolean")) {
                        var10000 = "Z";
                        break label1491;
                     }
                     break;
                  case 97526364:
                     if (name$iv$iv$iv.equals("float")) {
                        var10000 = "F";
                        break label1491;
                     }
                  }

                  var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
               }

               String var106 = var10000;
               destination$iv$iv$iv$iv.add(var106);
            }

            label1506: {
               var44 = (List)destination$iv$iv$iv$iv;
               var10001 = var94.append(CollectionsKt.joinToString$default((Iterable)var44, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null)).append(')');
               var32 = ClassSigGen.INSTANCE;
               String name$iv$iv$iv = var89.getReturnType().getName();
               var94 = var10001;
               var36 = false;
               switch(name$iv$iv$iv.hashCode()) {
               case -1325958191:
                  if (name$iv$iv$iv.equals("double")) {
                     var10000 = "D";
                     break label1506;
                  }
                  break;
               case 104431:
                  if (name$iv$iv$iv.equals("int")) {
                     var10000 = "I";
                     break label1506;
                  }
                  break;
               case 3039496:
                  if (name$iv$iv$iv.equals("byte")) {
                     var10000 = "B";
                     break label1506;
                  }
                  break;
               case 3625364:
                  if (name$iv$iv$iv.equals("void")) {
                     var10000 = "V";
                     break label1506;
                  }
                  break;
               case 64711720:
                  if (name$iv$iv$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label1506;
                  }
                  break;
               case 97526364:
                  if (name$iv$iv$iv.equals("float")) {
                     var10000 = "F";
                     break label1506;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var104 = var10000;
            methods$iv$iv.add(var94.append(var104).toString());
         }

         Iterable var83 = (Iterable)CollectionsKt.sortedWith((Iterable)fields$iv$iv, (Comparator)ClassSigGen$getClassChecksum2$3.INSTANCE);
         var25 = false;
         Iterator var86 = var83.iterator();

         Object var88;
         String it$iv$iv;
         boolean var91;
         Charset var95;
         boolean var96;
         byte[] var97;
         while(var86.hasNext()) {
            var88 = var86.next();
            it$iv$iv = (String)var88;
            var91 = false;
            var95 = Charsets.UTF_8;
            var96 = false;
            if (it$iv$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            var97 = it$iv$iv.getBytes(var95);
            hash$iv$iv.update(var97);
         }

         var83 = (Iterable)CollectionsKt.sortedWith((Iterable)methods$iv$iv, (Comparator)ClassSigGen$getClassChecksum2$5.INSTANCE);
         var25 = false;
         var86 = var83.iterator();

         while(var86.hasNext()) {
            var88 = var86.next();
            it$iv$iv = (String)var88;
            var91 = false;
            var95 = Charsets.UTF_8;
            var96 = false;
            if (it$iv$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            var97 = it$iv$iv.getBytes(var95);
            hash$iv$iv.update(var97);
         }

         hash$iv.update(hash$iv$iv.digest());
      }

      var10 = false;
      var11 = classes$iv;
      bytesRead$iv$iv = classes$iv.length;

      for(read$iv$iv = 0; read$iv$iv < bytesRead$iv$iv; ++read$iv$iv) {
         element$iv$iv = var11[read$iv$iv];
         var16 = false;
         boolean var18 = false;
         InputStream var108 = element$iv$iv.getClassLoader().getResourceAsStream(StringsKt.replace$default(element$iv$iv.getName(), ".", "/", false, 4, (Object)null) + ".class");
         if (var108 == null) {
            Field var79 = LaunchClassLoader.class.getDeclaredField("resourceCache");
            boolean var50 = false;
            var21 = false;
            var24 = false;
            var79.setAccessible(true);
            Object var109 = var79.get(Launch.classLoader);
            if (var109 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
            }

            Map var85 = (Map)var109;
            byte[] var51 = (byte[])var85.get(element$iv$iv.getName());
            var108 = (InputStream)(new ByteArrayInputStream(var51));
         }

         byte[] var87 = IOUtils.toByteArray(var108);
         hash$iv.update(var87);
      }

      byte[] var4 = hash$iv.digest();
      $i$f$writeByteArray = false;
      so.writeInt(var4.length);
      so.write(var4);
      so.writeInt(1172574186);
      $i$f$writeByteArray = false;
      InputStream $this$readByteArray$iv$iv = (InputStream)si;
      int length$iv$iv = si.readInt();
      var10 = false;
      byte[] bytes$iv = new byte[length$iv$iv];

      for(bytesRead$iv$iv = 0; bytesRead$iv$iv < length$iv$iv; bytesRead$iv$iv += read$iv$iv) {
         read$iv$iv = $this$readByteArray$iv$iv.read(bytes$iv, bytesRead$iv$iv, bytes$iv.length - bytesRead$iv$iv);
         if (read$iv$iv == -1) {
            break;
         }
      }

      boolean var52 = false;
      $i$f$writeByteArray = false;
      Map map$iv = (Map)(new LinkedHashMap());
      ZipInputStream zipIn$iv = new ZipInputStream((InputStream)(new ByteArrayInputStream(bytes$iv)));
      Ref.ObjectRef entry$iv = new Ref.ObjectRef();

      while(true) {
         ZipEntry var63 = zipIn$iv.getNextEntry();
         boolean var67 = false;
         boolean var70 = false;
         boolean var74 = false;
         entry$iv.element = var63;
         boolean var15;
         if (var63 == null) {
            $i$f$writeByteArray = false;
            boolean var58 = false;
            Map classMap$iv = (Map)(new LinkedHashMap());
            var67 = false;
            Iterator var73 = map$iv.entrySet().iterator();

            while(var73.hasNext()) {
               Entry var60 = (Entry)var73.next();
               var74 = false;
               String name$iv = (String)var60.getKey();
               var74 = false;
               bytes$iv = (byte[])var60.getValue();
               if (StringsKt.endsWith$default(name$iv, ".class", false, 2, (Object)null)) {
                  classMap$iv.put(StringsKt.substringBefore$default(StringsKt.replace$default(name$iv, "/", ".", false, 4, (Object)null), ".class", (String)null, 2, (Object)null), bytes$iv);
               } else {
                  classMap$iv.put(name$iv, bytes$iv);
                  PyroClientLoadingPlugin.resources.put(name$iv, bytes$iv);
               }
            }

            $i$f$writeByteArray = false;
            boolean var62 = false;
            Iterator var68 = classMap$iv.entrySet().iterator();

            while(var68.hasNext()) {
               Entry var71 = (Entry)var68.next();
               boolean var75 = false;
               var15 = false;
               String name = (String)var71.getKey();
               var15 = false;
               byte[] bytes = (byte[])var71.getValue();
               classloader.loadResource(name, bytes);
            }

            Method var54 = classloader.loadClass("dev.nuker.pyro.layer.SixthLayer").getMethod("run", LoaderGui.class, DataInputStream.class, DataOutputStream.class);
            var54.invoke((Object)null, gui, si, so);
            return;
         }

         byte[] contents$iv = new byte[4096];
         Ref.IntRef direct$iv = new Ref.IntRef();
         ByteArrayOutputStream stream$iv = new ByteArrayOutputStream();

         while(true) {
            read$iv$iv = zipIn$iv.read(contents$iv, 0, contents$iv.length);
            var74 = false;
            var15 = false;
            boolean var77 = false;
            direct$iv.element = read$iv$iv;
            if (read$iv$iv < 0) {
               ZipEntry var107 = (ZipEntry)entry$iv.element;
               if (var107 == null) {
                  Intrinsics.throwNpe();
               }

               map$iv.put(var107.getName(), stream$iv.toByteArray());
               zipIn$iv.closeEntry();
               break;
            }

            stream$iv.write(contents$iv, 0, direct$iv.element);
         }
      }
   }

   static {
      FifthLayer var0 = new FifthLayer();
      INSTANCE = var0;
   }
}
