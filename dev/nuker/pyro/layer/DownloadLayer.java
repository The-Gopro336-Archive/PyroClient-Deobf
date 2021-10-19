/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import dev.nuker.pyro.launcher.Config;
import dev.nuker.pyro.launcher.LibraryCache$DownloadFile;
import dev.nuker.pyro.launcher.LibraryCache$GradleResource;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.layer.DownloadLayer.run.6;
import dev.nuker.pyro.security.Clientfiles;
import dev.nuker.pyro.security.EncryptedStreamWrapper;
import dev.nuker.pyro.security.Encryption;
import dev.nuker.pyro.security.UtilsKt$hexString$1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.crypto.SecretKey;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

public class DownloadLayer {
   public static DownloadLayer INSTANCE;

   static {
      DownloadLayer var0 = new DownloadLayer();
      INSTANCE = var0;
   }

   @JvmStatic
   public static void run(@NotNull LoaderGui gui, @NotNull DataInputStream si, @NotNull DataOutputStream so) {
      gui.setProgress(Double.longBitsToDouble(Double.doubleToLongBits(-0.6959772356406465D) ^ 9218381843424528695L));
      Ref.BooleanRef shouldStop = new Ref.BooleanRef();
      shouldStop.element = false;
      boolean var5 = false;
      Map channelMap = (Map)(new LinkedHashMap());
      int var61 = si.readInt();
      int var6 = 0;

      String[] var11;
      boolean var14;
      for(int var7 = var61; var6 < var7; ++var6) {
         String name = si.readUTF();
         int versionCount = si.readInt();
         var11 = new String[versionCount];

         for(int var12 = 0; var12 < versionCount; ++var12) {
            var14 = false;
            String var58 = si.readUTF();
            var11[var12] = var58;
         }

         channelMap.put(name, var11);
      }

      Ref.ObjectRef currentChannel = new Ref.ObjectRef();
      currentChannel.element = Config.INSTANCE.channel;
      if (!channelMap.containsKey((String)currentChannel.element)) {
         currentChannel.element = (String)CollectionsKt.first((Iterable)channelMap.keySet());
      }

      Ref.ObjectRef currentVersion = new Ref.ObjectRef();
      Object var10001 = channelMap.get((String)currentChannel.element);
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      currentVersion.element = ((String[])var10001)[0];
      gui.setUI(gui.getDownloadPanel("Loading", channelMap, (Function0)(new DownloadLayer$run$1(shouldStop, currentChannel, currentVersion)), (Function2)(new DownloadLayer$run$2(shouldStop, currentChannel, currentVersion))));
      Field var65 = LaunchClassLoader.class.getDeclaredField("resourceCache");
      boolean var10 = false;
      boolean $i$f$forEach = false;
      boolean var13 = false;
      var65.setAccessible(true);
      Object var10000 = var65.get(Launch.classLoader);
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.ByteArray>");
      } else {
         Map resourceCache = TypeIntrinsics.asMutableMap(var10000);
         EncryptedStreamWrapper stream = new EncryptedStreamWrapper(si, so);
         byte[] bytes = DLBHash.INSTANCE.get();
         boolean var71 = false;
         byte[] var140 = new byte[]{32, 120, 45, 34, 66, 43, 87, 54, 0, 0, 0};
         byte var73;
         stream.setI((byte)((var73 = stream.getI()) + 1));
         var140[8] = var73;
         var140[9] = 16;
         var140[10] = 86;
         stream.setSalt(var140);
         var140 = Encryption.INSTANCE.getRandomNonce(12);
         if (var140 == null) {
            Intrinsics.throwNpe();
         }

         stream.setIv(var140);
         Encryption var77 = Encryption.INSTANCE;
         boolean var16 = false;
         String var17 = ArraysKt.joinToString$default(bytes, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)UtilsKt$hexString$1.INSTANCE, 30, (Object)null);
         var16 = false;
         if (var17 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         } else {
            char[] var92 = var17.toCharArray();
            SecretKey var141 = var77.getAESKeyFromPassword(var92, stream.getSalt());
            if (var141 == null) {
               Intrinsics.throwNpe();
            }

            stream.setKey(var141);
            $i$f$forEach = false;
            DataInputStream $this$readByteArray$iv$iv = stream.getInStream();
            var13 = false;
            InputStream $this$readByteArray$iv$iv$iv = (InputStream)$this$readByteArray$iv$iv;
            int length$iv$iv$iv = $this$readByteArray$iv$iv.readInt();
            var16 = false;
            byte[] array$iv$iv$iv = new byte[length$iv$iv$iv];

            int i;
            int read$iv$iv$iv;
            for(i = 0; i < length$iv$iv$iv; i += read$iv$iv$iv) {
               read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(array$iv$iv$iv, i, ~(i + ~array$iv$iv$iv.length));
               if (read$iv$iv$iv == -1) {
                  break;
               }
            }

            EncryptedStreamWrapper bytes$iv = Encryption.INSTANCE.decryptWithPrefixIV(array$iv$iv$iv, stream.getKey());
            $i$f$forEach = false;
            var71 = false;
            Map map$iv = (Map)(new LinkedHashMap());
            ZipInputStream zipIn$iv = new ZipInputStream((InputStream)(new ByteArrayInputStream(bytes$iv)));
            Ref.ObjectRef entry$iv = new Ref.ObjectRef();

            while(true) {
               ZipEntry var83 = zipIn$iv.getNextEntry();
               var16 = false;
               boolean var97 = false;
               boolean var103 = false;
               entry$iv.element = var83;
               boolean var20;
               boolean var22;
               ZipEntry var142;
               if (var83 == null) {
                  $i$f$forEach = false;
                  var13 = false;
                  Iterator var84 = map$iv.entrySet().iterator();

                  while(var84.hasNext()) {
                     Entry var87 = (Entry)var84.next();
                     var97 = false;
                     var103 = false;
                     String name = (String)var87.getKey();
                     var103 = false;
                     byte[] data = (byte[])var87.getValue();
                     resourceCache.put(StringsKt.substringBeforeLast$default(StringsKt.replace$default(name, "/", ".", false, 4, (Object)null), ".class", (String)null, 2, (Object)null), data);
                  }

                  Ref.BooleanRef doneReading = new Ref.BooleanRef();
                  doneReading.element = false;
                  var11 = null;

                  while(true) {
                     while(!shouldStop.element) {
                        so.writeUTF((String)currentChannel.element);
                        so.writeUTF((String)currentVersion.element);
                        var13 = false;
                        List libUrls = (List)(new ArrayList());
                        boolean var88 = false;
                        var97 = false;
                        DataInputStream var102 = stream.getInStream();
                        var103 = false;
                        InputStream $this$readByteArray$iv$iv$iv$iv = (InputStream)var102;
                        int length$iv$iv$iv$iv = var102.readInt();
                        var22 = false;
                        byte[] array$iv$iv$iv$iv = new byte[length$iv$iv$iv$iv];

                        int read$iv$iv$iv$iv;
                        for(int bytesRead$iv$iv$iv$iv = 0; bytesRead$iv$iv$iv$iv < length$iv$iv$iv$iv; bytesRead$iv$iv$iv$iv += read$iv$iv$iv$iv) {
                           read$iv$iv$iv$iv = $this$readByteArray$iv$iv$iv$iv.read(array$iv$iv$iv$iv, bytesRead$iv$iv$iv$iv, array$iv$iv$iv$iv.length - bytesRead$iv$iv$iv$iv);
                           if (read$iv$iv$iv$iv == -1) {
                              break;
                           }
                        }

                        int var82 = ByteBuffer.wrap(Encryption.INSTANCE.decryptWithPrefixIV(array$iv$iv$iv$iv, stream.getKey())).getInt();
                        EncryptedStreamWrapper this_$iv = 0;

                        for(length$iv$iv$iv = var82; this_$iv < length$iv$iv$iv; ++this_$iv) {
                           libUrls.add(si.readUTF());
                        }

                        Ref.LongRef libMaxBytes = new Ref.LongRef();
                        libMaxBytes.element = (long)-830357338 ^ -830357338L;
                        Ref.LongRef libDownloadedBytes = new Ref.LongRef();
                        libDownloadedBytes.element = (long)1902054407 ^ 1902054407L;
                        var97 = false;
                        List libFiles = (List)(new ArrayList());
                        Iterable var105 = (Iterable)libUrls;
                        boolean var104 = false;
                        Iterator var112 = var105.iterator();

                        while(var112.hasNext()) {
                           Object var113 = var112.next();
                           String it = (String)var113;
                           var22 = false;
                           LibraryCache$GradleResource var124 = new LibraryCache$GradleResource(it);
                           LibraryCache$DownloadFile dfile = var124.getDownloadFile();
                           libFiles.add(dfile);
                           dfile.completionRunnable = (Consumer)DownloadLayer$run$4$1.INSTANCE;
                           dfile.download();
                        }

                        int byteCount = si.readInt();
                        bytes = new byte[byteCount];
                        Iterable $this$any$iv = (Iterable)libFiles;
                        var103 = false;
                        Iterator var115;
                        Object var119;
                        LibraryCache$DownloadFile var122;
                        boolean var125;
                        boolean var139;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                           var139 = false;
                        } else {
                           label2669: {
                              var115 = $this$any$iv.iterator();

                              while(var115.hasNext()) {
                                 var119 = var115.next();
                                 var122 = (LibraryCache$DownloadFile)var119;
                                 var125 = false;
                                 if (!var122.isDownloaded()) {
                                    var139 = true;
                                    break label2669;
                                 }
                              }

                              var139 = false;
                           }
                        }

                        if (var139) {
                           Thread current = Thread.currentThread();
                           ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)(new 6(libFiles, libMaxBytes, libDownloadedBytes, doneReading, gui, byteCount, current)), 30, (Object)null);
                        }

                        i = 0;

                        for(read$iv$iv$iv = byteCount; i < read$iv$iv$iv; ++i) {
                           gui.setProgress((double)((long)i + libDownloadedBytes.element) / (double)((long)byteCount + libMaxBytes.element));
                           bytes[i] = (byte)si.read();
                           if (i % 1000 == 0) {
                              Thread.sleep((long)-1764066842 ^ -1764066841L);
                           }

                           if (i % 500000 == 0) {
                              so.write(shouldStop.element ? 1 : 0);
                              if (shouldStop.element) {
                                 break;
                              }
                           }
                        }

                        so.write(shouldStop.element ? 1 : 0);
                        if (!shouldStop.element) {
                           doneReading.element = true;
                           $this$any$iv = (Iterable)libFiles;
                           var103 = false;
                           if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                              var139 = false;
                           } else {
                              label2670: {
                                 var115 = $this$any$iv.iterator();

                                 while(var115.hasNext()) {
                                    var119 = var115.next();
                                    var122 = (LibraryCache$DownloadFile)var119;
                                    var125 = false;
                                    if (!var122.isDownloaded()) {
                                       var139 = true;
                                       break label2670;
                                    }
                                 }

                                 var139 = false;
                              }
                           }

                           if (var139) {
                              Thread.currentThread().suspend();
                           }

                           gui.setProgress(Double.longBitsToDouble(Double.doubleToLongBits(-8.035968802711773D) ^ 9209881486608475533L));
                           gui.setUI(gui.getTextPanel("Injecting"));
                           byte[] decrypted = Encryption.INSTANCE.decryptWithPrefixIV(bytes, stream.getKey());
                           var14 = false;
                           var88 = false;
                           Map map$iv = (Map)(new LinkedHashMap());
                           ZipInputStream zipIn$iv = new ZipInputStream((InputStream)(new ByteArrayInputStream(decrypted)));
                           Ref.ObjectRef entry$iv = new Ref.ObjectRef();

                           while(true) {
                              ZipEntry var116 = zipIn$iv.getNextEntry();
                              var103 = false;
                              var20 = false;
                              var22 = false;
                              entry$iv.element = var116;
                              if (var116 == null) {
                                 var88 = false;
                                 List mixins = (List)(new ArrayList());
                                 var10000 = Launch.classLoader.loadClass("dev.nuker.pyro.PyroClientLoadingPlugin").getField("resources").get((Object)null);
                                 if (var10000 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.ByteArray>");
                                 }

                                 Map pyroResources = TypeIntrinsics.asMutableMap(var10000);
                                 File refmap = File.createTempFile("ref", (String)null);
                                 refmap.deleteOnExit();
                                 var104 = false;
                                 var20 = false;
                                 Iterator var123 = map$iv.entrySet().iterator();

                                 while(var123.hasNext()) {
                                    Entry var126 = (Entry)var123.next();
                                    boolean var128 = false;
                                    boolean var26 = false;
                                    String name = (String)var126.getKey();
                                    var26 = false;
                                    byte[] data = (byte[])var126.getValue();
                                    if (Intrinsics.areEqual((Object)name, (Object)"refmap.json")) {
                                       Files.write(refmap.toPath(), data, new OpenOption[0]);
                                    } else {
                                       byte var29;
                                       String sub;
                                       if (StringsKt.startsWith$default(name, "resources/", false, 2, (Object)null)) {
                                          var29 = 10;
                                          boolean var132 = false;
                                          if (name == null) {
                                             throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                          }

                                          sub = name.substring(var29);
                                          pyroResources.put(sub, data);
                                       } else {
                                          int var30;
                                          boolean var31;
                                          long rand;
                                          MessageDigest var34;
                                          Map var35;
                                          boolean var36;
                                          byte[] var37;
                                          Field f$iv$iv;
                                          long[] indexTable$iv;
                                          Unsafe unsafe$iv;
                                          double var41;
                                          boolean var43;
                                          Map unusedIndexTable$iv;
                                          int var45;
                                          int begin$iv;
                                          int index$iv;
                                          int var49;
                                          boolean var50;
                                          int end$iv;
                                          long nextMem$iv;
                                          int j$iv;
                                          int var55;
                                          byte bytesplit$iv;
                                          Charset var133;
                                          byte[] var134;
                                          Random random$iv;
                                          Unsafe var136;
                                          int splitcount$iv;
                                          int i$iv;
                                          Map var143;
                                          if (StringsKt.startsWith$default(name, "inject/", false, 2, (Object)null) && !StringsKt.endsWith$default(name, "/", false, 2, (Object)null)) {
                                             var29 = 7;
                                             var30 = name.length() - 6;
                                             var31 = false;
                                             if (name == null) {
                                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                             }

                                             sub = StringsKt.replace$default(name.substring(var29, var30), "/", ".", false, 4, (Object)null);
                                             rand = Random.Default.nextLong();
                                             var143 = ThirdLayer.idb;
                                             var34 = MessageDigest.getInstance("MD5");
                                             var35 = var143;
                                             var133 = Charsets.UTF_8;
                                             var36 = false;
                                             if (sub == null) {
                                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                             }

                                             var37 = sub.getBytes(var133);
                                             var35.put(var34.digest(var37), rand);
                                             var143 = Clientfiles.INSTANCE.getIndextable();
                                             var34 = MessageDigest.getInstance("MD5");
                                             var35 = var143;
                                             var133 = Charsets.UTF_8;
                                             var36 = false;
                                             if (sub == null) {
                                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                             }

                                             var37 = sub.getBytes(var133);
                                             var140 = var34.digest(var37);
                                             bytesplit$iv = 69;
                                             var134 = var140;
                                             var31 = false;
                                             var36 = false;

                                             try {
                                                f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                                                f$iv$iv.setAccessible(true);
                                                var10000 = f$iv$iv.get((Object)null);
                                                if (var10000 == null) {
                                                   throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                                                }

                                                var136 = (Unsafe)var10000;
                                             } catch (Exception var60) {
                                                throw (Throwable)(new RuntimeException((Throwable)var60));
                                             }

                                             unsafe$iv = var136;
                                             random$iv = RandomKt.Random(rand);
                                             var41 = (double)data.length / (double)bytesplit$iv;
                                             var43 = false;
                                             splitcount$iv = (int)Math.ceil(var41);
                                             indexTable$iv = new long[splitcount$iv + 1];
                                             var43 = false;
                                             unusedIndexTable$iv = (Map)(new LinkedHashMap());
                                             indexTable$iv[0] = (long)data.length;
                                             i$iv = 1;
                                             var45 = splitcount$iv;
                                             if (i$iv <= splitcount$iv) {
                                                while(true) {
                                                   indexTable$iv[i$iv] = unsafe$iv.allocateMemory((long)bytesplit$iv);
                                                   unusedIndexTable$iv.put(i$iv, indexTable$iv[i$iv]);
                                                   if (i$iv == var45) {
                                                      break;
                                                   }

                                                   ++i$iv;
                                                }
                                             }

                                             i$iv = 1;
                                             var45 = splitcount$iv;
                                             if (i$iv <= splitcount$iv) {
                                                while(true) {
                                                   begin$iv = (i$iv - 1) * bytesplit$iv;
                                                   index$iv = data.length;
                                                   var49 = begin$iv + bytesplit$iv;
                                                   var50 = false;
                                                   end$iv = Math.min(index$iv, var49);
                                                   index$iv = ((Number)CollectionsKt.random((Collection)unusedIndexTable$iv.keySet(), random$iv)).intValue();
                                                   var10000 = unusedIndexTable$iv.get(index$iv);
                                                   if (var10000 == null) {
                                                      Intrinsics.throwNpe();
                                                   }

                                                   nextMem$iv = ((Number)var10000).longValue();
                                                   unusedIndexTable$iv.remove(index$iv);
                                                   j$iv = begin$iv;

                                                   for(var55 = end$iv; j$iv < var55; ++j$iv) {
                                                      unsafe$iv.putByte(nextMem$iv + (long)j$iv - (long)begin$iv, data[j$iv]);
                                                   }

                                                   if (i$iv == var45) {
                                                      break;
                                                   }

                                                   ++i$iv;
                                                }
                                             }

                                             var35.put(var134, indexTable$iv);
                                          } else if (StringsKt.startsWith$default(name, "classes/", false, 2, (Object)null) && !StringsKt.endsWith$default(name, "/", false, 2, (Object)null)) {
                                             var29 = 8;
                                             var30 = name.length() - 6;
                                             var31 = false;
                                             if (name == null) {
                                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                             }

                                             sub = StringsKt.replace$default(name.substring(var29, var30), "/", ".", false, 4, (Object)null);
                                             if (StringsKt.contains$default((CharSequence)sub, (CharSequence)".mixin", false, 2, (Object)null)) {
                                                mixins.add(sub);
                                                resourceCache.put(sub, data);
                                             } else {
                                                rand = Random.Default.nextLong();
                                                var143 = ThirdLayer.sdb;
                                                var34 = MessageDigest.getInstance("MD5");
                                                var35 = var143;
                                                var133 = Charsets.UTF_8;
                                                var36 = false;
                                                if (sub == null) {
                                                   throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                                }

                                                var37 = sub.getBytes(var133);
                                                var35.put(var34.digest(var37), rand);
                                                var143 = Clientfiles.INSTANCE.getIndextable();
                                                var34 = MessageDigest.getInstance("MD5");
                                                var35 = var143;
                                                var133 = Charsets.UTF_8;
                                                var36 = false;
                                                if (sub == null) {
                                                   throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                                }

                                                var37 = sub.getBytes(var133);
                                                var140 = var34.digest(var37);
                                                bytesplit$iv = 42;
                                                var134 = var140;
                                                var31 = false;
                                                var36 = false;

                                                try {
                                                   f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                                                   f$iv$iv.setAccessible(true);
                                                   var10000 = f$iv$iv.get((Object)null);
                                                   if (var10000 == null) {
                                                      throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                                                   }

                                                   var136 = (Unsafe)var10000;
                                                } catch (Exception var59) {
                                                   throw (Throwable)(new RuntimeException((Throwable)var59));
                                                }

                                                unsafe$iv = var136;
                                                random$iv = RandomKt.Random(rand);
                                                var41 = (double)data.length / (double)bytesplit$iv;
                                                var43 = false;
                                                splitcount$iv = (int)Math.ceil(var41);
                                                indexTable$iv = new long[splitcount$iv + 1];
                                                var43 = false;
                                                unusedIndexTable$iv = (Map)(new LinkedHashMap());
                                                indexTable$iv[0] = (long)data.length;
                                                i$iv = 1;
                                                var45 = splitcount$iv;
                                                if (i$iv <= splitcount$iv) {
                                                   while(true) {
                                                      indexTable$iv[i$iv] = unsafe$iv.allocateMemory((long)bytesplit$iv);
                                                      unusedIndexTable$iv.put(i$iv, indexTable$iv[i$iv]);
                                                      if (i$iv == var45) {
                                                         break;
                                                      }

                                                      ++i$iv;
                                                   }
                                                }

                                                i$iv = 1;
                                                var45 = splitcount$iv;
                                                if (i$iv <= splitcount$iv) {
                                                   while(true) {
                                                      begin$iv = (i$iv - 1) * bytesplit$iv;
                                                      index$iv = data.length;
                                                      var49 = begin$iv + bytesplit$iv;
                                                      var50 = false;
                                                      end$iv = Math.min(index$iv, var49);
                                                      index$iv = ((Number)CollectionsKt.random((Collection)unusedIndexTable$iv.keySet(), random$iv)).intValue();
                                                      var10000 = unusedIndexTable$iv.get(index$iv);
                                                      if (var10000 == null) {
                                                         Intrinsics.throwNpe();
                                                      }

                                                      nextMem$iv = ((Number)var10000).longValue();
                                                      unusedIndexTable$iv.remove(index$iv);
                                                      j$iv = begin$iv;

                                                      for(var55 = end$iv; j$iv < var55; ++j$iv) {
                                                         unsafe$iv.putByte(nextMem$iv + (long)j$iv - (long)begin$iv, data[j$iv]);
                                                      }

                                                      if (i$iv == var45) {
                                                         break;
                                                      }

                                                      ++i$iv;
                                                   }
                                                }

                                                var35.put(var134, indexTable$iv);
                                             }
                                          }
                                       }
                                    }
                                 }

                                 Launch.classLoader.loadClass("dev.nuker.pyro.launcher.LoadingPluginImpl").getMethod("init", List.class, File.class).invoke((Object)null, mixins, refmap);
                                 gui.setUI(gui.getTextPanel("Complete"));
                                 gui.setVisible(false);
                                 PyroClientLoadingPlugin.baseThread.resume();
                                 return;
                              }

                              byte[] contents$iv = new byte[4096];
                              Ref.IntRef direct$iv = new Ref.IntRef();
                              ByteArrayOutputStream stream$iv = new ByteArrayOutputStream();

                              while(true) {
                                 length$iv$iv$iv$iv = zipIn$iv.read(contents$iv, 0, contents$iv.length);
                                 var22 = false;
                                 var125 = false;
                                 boolean var129 = false;
                                 direct$iv.element = length$iv$iv$iv$iv;
                                 if (length$iv$iv$iv$iv < 0) {
                                    var142 = (ZipEntry)entry$iv.element;
                                    if (var142 == null) {
                                       Intrinsics.throwNpe();
                                    }

                                    map$iv.put(var142.getName(), stream$iv.toByteArray());
                                    zipIn$iv.closeEntry();
                                    break;
                                 }

                                 stream$iv.write(contents$iv, 0, direct$iv.element);
                              }
                           }
                        }
                     }

                     Thread.sleep((long)1823523770 ^ 1823523806L);
                  }
               }

               byte[] contents$iv = new byte[4096];
               Ref.IntRef direct$iv = new Ref.IntRef();
               ByteArrayOutputStream stream$iv = new ByteArrayOutputStream();

               while(true) {
                  i = zipIn$iv.read(contents$iv, 0, contents$iv.length);
                  var103 = false;
                  var20 = false;
                  var22 = false;
                  direct$iv.element = i;
                  if (i < 0) {
                     var142 = (ZipEntry)entry$iv.element;
                     if (var142 == null) {
                        Intrinsics.throwNpe();
                     }

                     map$iv.put(var142.getName(), stream$iv.toByteArray());
                     zipIn$iv.closeEntry();
                     break;
                  }

                  stream$iv.write(contents$iv, 0, direct$iv.element);
               }
            }
         }
      }
   }
}
