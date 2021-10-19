/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.Config;
import dev.nuker.pyro.layer.SecondLayer.run.1.2.2;
import dev.nuker.pyro.layer.SecondLayer.run.1.2.4;
import dev.nuker.pyro.layer.SecondLayer.run.1.2.5;
import dev.nuker.pyro.layer.SecondLayer.run.1.2.6;
import dev.nuker.pyro.security.UtilsKt$hexString$1;
import java.awt.EventQueue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.SocketException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.jetbrains.annotations.NotNull;

public class SecondLayer$run$1$2 extends Lambda implements Function2 {
   public SecondLayer$run$1 this$0;

   public SecondLayer$run$1$2(SecondLayer$run$1 var1) {
      this.this$0 = var1;
      super(2);
   }

   public Object invoke(Object var1, Object var2) {
      this.invoke((String)var1, (byte[])var2);
      return Unit.INSTANCE;
   }

   public void invoke(@NotNull String user, @NotNull byte[] pass) {
      EventQueue.invokeAndWait((Runnable)(new SecondLayer$run$1$2$1(this)));
      this.this$0.$so.writeUTF(user);
      DataOutputStream var3 = this.this$0.$so;
      boolean var4 = false;
      var3.writeInt(pass.length);
      var3.write(pass);
      switch(this.this$0.$si.readInt()) {
      case 0:
         EventQueue.invokeAndWait((Runnable)(new 2(this)));
         break;
      case 1:
         EventQueue.invokeAndWait((Runnable)(new SecondLayer$run$1$2$3(this)));
         Config.INSTANCE.username = user;
         Config var19 = Config.INSTANCE;
         var4 = false;
         String var20 = ArraysKt.joinToString$default(pass, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)UtilsKt$hexString$1.INSTANCE, 30, (Object)null);
         var19.password = var20;
         Config.save();
         Field var25 = LaunchClassLoader.class.getDeclaredField("resourceCache");
         var25.setAccessible(true);
         Object var10000 = var25.get(Launch.classLoader);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.ByteArray>");
         }

         Map resourceCache = TypeIntrinsics.asMutableMap(var10000);
         DataInputStream $this$readByteArray$iv = this.this$0.$si;
         boolean var7 = false;
         InputStream $this$readByteArray$iv$iv = (InputStream)$this$readByteArray$iv;
         int length$iv$iv = $this$readByteArray$iv.readInt();
         boolean var10 = false;
         byte[] contents$iv = new byte[length$iv$iv];

         int read$iv$iv;
         for(int bytesRead$iv$iv = 0; bytesRead$iv$iv < length$iv$iv; bytesRead$iv$iv += read$iv$iv) {
            read$iv$iv = $this$readByteArray$iv$iv.read(contents$iv, bytesRead$iv$iv, contents$iv.length - bytesRead$iv$iv);
            if (read$iv$iv == -1) {
               break;
            }
         }

         var7 = false;
         boolean var29 = false;
         Map map$iv = (Map)(new LinkedHashMap());
         ZipInputStream zipIn$iv = new ZipInputStream((InputStream)(new ByteArrayInputStream(contents$iv)));
         Ref.ObjectRef entry$iv = new Ref.ObjectRef();

         while(true) {
            ZipEntry var37 = zipIn$iv.getNextEntry();
            boolean var39 = false;
            boolean var41 = false;
            boolean var15 = false;
            entry$iv.element = var37;
            if (var37 == null) {
               Map files$iv = map$iv;
               var29 = false;
               boolean var32 = false;
               Map classMap$iv = (Map)(new LinkedHashMap());
               var39 = false;
               Iterator var44 = files$iv.entrySet().iterator();

               while(var44.hasNext()) {
                  Entry var33 = (Entry)var44.next();
                  var15 = false;
                  String name$iv = (String)var33.getKey();
                  var15 = false;
                  byte[] bytes$iv = (byte[])var33.getValue();
                  if (StringsKt.endsWith$default(name$iv, ".class", false, 2, (Object)null)) {
                     classMap$iv.put(StringsKt.substringBefore$default(StringsKt.replace$default(name$iv, "/", ".", false, 4, (Object)null), ".class", (String)null, 2, (Object)null), bytes$iv);
                  } else {
                     classMap$iv.put(name$iv, bytes$iv);
                     PyroClientLoadingPlugin.resources.put(name$iv, bytes$iv);
                  }
               }

               resourceCache.putAll(classMap$iv);
               byte errType = 0;

               try {
                  try {
                     ThirdLayer.run(this.this$0.$gui, this.this$0.$si, this.this$0.$so);
                  } catch (Throwable var21) {
                     Throwable e2;
                     Throwable var45;
                     for(e2 = var21; e2.getCause() != null; e2 = var45) {
                        var45 = e2.getCause();
                        if (var45 == null) {
                           Intrinsics.throwNpe();
                        }
                     }

                     throw e2;
                  }
               } catch (SocketException var22) {
                  errType = 1;
               } catch (EOFException var23) {
                  errType = 1;
               } catch (Throwable var24) {
                  var24.printStackTrace();
                  errType = -1;
               }

               switch(errType) {
               case -1:
                  EventQueue.invokeAndWait((Runnable)(new 5(this)));
                  return;
               case 0:
               default:
                  return;
               case 1:
                  EventQueue.invokeAndWait((Runnable)(new 4(this)));
                  return;
               }
            }

            contents$iv = new byte[4096];
            Ref.IntRef direct$iv = new Ref.IntRef();
            ByteArrayOutputStream stream$iv = new ByteArrayOutputStream();

            while(true) {
               int var14 = zipIn$iv.read(contents$iv, 0, contents$iv.length);
               var15 = false;
               boolean var16 = false;
               boolean var18 = false;
               direct$iv.element = var14;
               if (var14 < 0) {
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
      case 2:
         EventQueue.invokeAndWait((Runnable)(new 6(this)));
      }

   }
}
