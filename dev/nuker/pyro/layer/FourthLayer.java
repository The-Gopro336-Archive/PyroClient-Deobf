/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.security.NestedClassloader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public class FourthLayer {
   public static FourthLayer INSTANCE;

   @JvmStatic
   public static void run(@NotNull LoaderGui gui, @NotNull DataInputStream si, @NotNull DataOutputStream so) {
      so.writeInt(-326653461);
      NestedClassloader classloader = new NestedClassloader(INSTANCE.getClass().getClassLoader());
      so.writeInt(1210807394);
      boolean var6 = false;
      InputStream $this$readByteArray$iv$iv = (InputStream)si;
      int length$iv$iv = si.readInt();
      boolean var9 = false;
      byte[] bytes$iv = new byte[length$iv$iv];

      int read$iv$iv;
      for(int bytesRead$iv$iv = 0; bytesRead$iv$iv < length$iv$iv; bytesRead$iv$iv += read$iv$iv) {
         read$iv$iv = $this$readByteArray$iv$iv.read(bytes$iv, bytesRead$iv$iv, bytes$iv.length - bytesRead$iv$iv);
         if (read$iv$iv == -1) {
            break;
         }
      }

      int $i$f$dpkgZip = false;
      var6 = false;
      Map map$iv = (Map)(new LinkedHashMap());
      ZipInputStream zipIn$iv = new ZipInputStream((InputStream)(new ByteArrayInputStream(bytes$iv)));
      Ref.ObjectRef entry$iv = new Ref.ObjectRef();

      while(true) {
         ZipEntry var28 = zipIn$iv.getNextEntry();
         boolean var31 = false;
         boolean var34 = false;
         boolean var13 = false;
         entry$iv.element = var28;
         boolean var14;
         byte[] contents$iv;
         if (var28 == null) {
            Map files$iv = map$iv;
            var6 = false;
            boolean var22 = false;
            Map classMap$iv = (Map)(new LinkedHashMap());
            var31 = false;
            Iterator var37 = files$iv.entrySet().iterator();

            while(var37.hasNext()) {
               Entry var23 = (Entry)var37.next();
               var13 = false;
               String name$iv = (String)var23.getKey();
               var13 = false;
               bytes$iv = (byte[])var23.getValue();
               if (StringsKt.endsWith$default(name$iv, ".class", false, 2, (Object)null)) {
                  classMap$iv.put(StringsKt.substringBefore$default(StringsKt.replace$default(name$iv, "/", ".", false, 4, (Object)null), ".class", (String)null, 2, (Object)null), bytes$iv);
               } else {
                  classMap$iv.put(name$iv, bytes$iv);
                  PyroClientLoadingPlugin.resources.put(name$iv, bytes$iv);
               }
            }

            var6 = false;
            map$iv = classMap$iv;
            boolean $i$f$writeByteArray = false;
            Iterator var32 = map$iv.entrySet().iterator();

            while(var32.hasNext()) {
               Entry var35 = (Entry)var32.next();
               boolean var38 = false;
               var14 = false;
               String name = (String)var35.getKey();
               var14 = false;
               byte[] bytes = (byte[])var35.getValue();
               classloader.loadResource(name, bytes);
            }

            Method method = classloader.loadClass("dev.nuker.pyro.layer.FifthLayer").getMethod("run", LoaderGui.class, DataInputStream.class, DataOutputStream.class);
            String file$iv = si.readUTF();
            $i$f$writeByteArray = false;

            try {
               byte[] var40;
               label472: {
                  InputStream var10000 = ((ClassLoader)classloader).getResourceAsStream(file$iv);
                  if (var10000 != null) {
                     var40 = ByteStreamsKt.readBytes(var10000);
                     if (var40 != null) {
                        break label472;
                     }
                  }

                  var40 = new byte[0];
               }

               contents$iv = var40;
            } catch (IOException var17) {
               contents$iv = new byte[0];
            }

            $i$f$writeByteArray = false;
            so.writeInt(contents$iv.length);
            so.write(contents$iv);
            method.invoke((Object)null, gui, si, so);
            return;
         }

         contents$iv = new byte[4096];
         Ref.IntRef direct$iv = new Ref.IntRef();
         ByteArrayOutputStream stream$iv = new ByteArrayOutputStream();

         while(true) {
            read$iv$iv = zipIn$iv.read(contents$iv, 0, contents$iv.length);
            var13 = false;
            var14 = false;
            boolean var16 = false;
            direct$iv.element = read$iv$iv;
            if (read$iv$iv < 0) {
               ZipEntry var10001 = (ZipEntry)entry$iv.element;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               map$iv.put(var10001.getName(), stream$iv.toByteArray());
               zipIn$iv.closeEntry();
               break;
            }

            stream$iv.write(contents$iv, 0, direct$iv.element);
         }
      }
   }

   static {
      FourthLayer var0 = new FourthLayer();
      INSTANCE = var0;
   }
}
