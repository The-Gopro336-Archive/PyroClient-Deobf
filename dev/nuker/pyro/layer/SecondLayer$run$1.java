/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import dev.nuker.pyro.launcher.Config;
import dev.nuker.pyro.launcher.LoaderGui;
import dev.nuker.pyro.layer.SecondLayer.run.1.3;
import dev.nuker.pyro.security.StructDissasembler;
import dev.nuker.pyro.security.UnsafeSecurity$checkLaunchFlags$1;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import sun.misc.Unsafe;

public class SecondLayer$run$1 extends Lambda implements Function0 {
   public DataOutputStream $so;
   public LoaderGui $gui;
   public DataInputStream $si;

   public SecondLayer$run$1(DataOutputStream var1, LoaderGui var2, DataInputStream var3) {
      this.$so = var1;
      this.$gui = var2;
      this.$si = var3;
      super(0);
   }

   public Object invoke() {
      this.invoke();
      return Unit.INSTANCE;
   }

   public void invoke() {
      DataOutputStream $this$writeByteArray$iv = this.$so;
      int $i$f$getHWID = false;
      StringBuilder s$iv = new StringBuilder();
      String osName$iv = System.getProperty("os.name");
      byte var5 = 0;
      byte var6 = 3;
      boolean var8 = false;
      if (osName$iv == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         String vmName$iv$iv$iv$iv$iv = osName$iv.substring(var5, var6);
         s$iv.append(vmName$iv$iv$iv$iv$iv);
         String $this$hexBytes$iv = System.getProperty("os.name");
         boolean $i$f$setupIntrospection = false;
         if ($this$hexBytes$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         } else {
            osName$iv = $this$hexBytes$iv.toLowerCase();
            $this$hexBytes$iv = StringsKt.startsWith$default(osName$iv, "windows", false, 2, (Object)null) ? "wmic baseboard get serialnumber" : (StringsKt.startsWith$default(osName$iv, "mac", false, 2, (Object)null) ? "ioreg -l | grep IOPlatformSerialNumber" : "cat /etc/machine-id");

            boolean var12;
            boolean var13;
            try {
               Process child$iv = Runtime.getRuntime().exec($this$hexBytes$iv);
               InputStream in$iv = child$iv.getInputStream();
               Ref.IntRef ch$iv = new Ref.IntRef();

               while(true) {
                  int var11 = in$iv.read();
                  var12 = false;
                  var13 = false;
                  boolean var15 = false;
                  ch$iv.element = var11;
                  if (var11 == -1) {
                     break;
                  }

                  s$iv.append(ch$iv.element);
               }
            } catch (IOException var41) {
               var41.printStackTrace();
            }

            String symbol$iv$iv$iv$iv = s$iv.toString();
            var8 = false;
            boolean $i$f$getDummyCode = false;
            var12 = false;
            byte var14 = 0;
            int var87 = Integer.min(symbol$iv$iv$iv$iv.length(), 1000);
            boolean var16 = false;
            if (symbol$iv$iv$iv$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } else {
               symbol$iv$iv$iv$iv = symbol$iv$iv$iv$iv.substring(var14, var87);
               Charset var61 = Charsets.UTF_8;
               $i$f$getDummyCode = false;
               if (symbol$iv$iv$iv$iv == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
               } else {
                  byte[] var10000 = symbol$iv$iv$iv$iv.getBytes(var61);
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  byte[] bytes$iv = var10000;
                  boolean $i$f$writeByteArray = false;
                  $this$writeByteArray$iv.writeInt(bytes$iv.length);
                  $this$writeByteArray$iv.write(bytes$iv);
                  byte[] thisClass$iv = SecondLayer.INSTANCE.getClass();
                  $i$f$writeByteArray = false;
                  boolean var48 = false;
                  Iterator var50 = ManagementFactory.getRuntimeMXBean().getInputArguments().iterator();

                  boolean var7;
                  byte var89;
                  while(true) {
                     if (var50.hasNext()) {
                        symbol$iv$iv$iv$iv = (String)var50.next();
                        var7 = false;
                        if (!CollectionsKt.listOf(new String[]{"-javaagent", "-Xdebug", "-Xrunjdwp", "-Xnoagent", "-verbose", "-DproxySet", "-DproxyHost", "-DproxyPort", "-Djavax.net.ssl.trustStore", "-Djavax.net.ssl.trustStorePassword", "-Dmixin.debug", "-Dlegacy"}).stream().anyMatch((Predicate)(new UnsafeSecurity$checkLaunchFlags$1(symbol$iv$iv$iv$iv)))) {
                           continue;
                        }

                        var89 = 8;
                        break;
                     }

                     var89 = 0;
                     break;
                  }

                  byte var64 = var89;
                  var48 = false;

                  Class c$iv$iv;
                  boolean var56;
                  ClassNode classNode$iv$iv$iv;
                  Method[] var58;
                  Field f$iv$iv$iv;
                  Unsafe var62;
                  MethodNode var65;
                  InsnList list$iv$iv$iv$iv;
                  ClassWriter writer$iv$iv$iv;
                  byte[] bytes$iv$iv;
                  short var90;
                  Object var91;
                  try {
                     $this$hexBytes$iv = "sun/instrument/InstrumentationImpl";
                     $i$f$setupIntrospection = false;
                     classNode$iv$iv$iv = new ClassNode();
                     classNode$iv$iv$iv.name = StringsKt.replace$default($this$hexBytes$iv, '.', '/', false, 4, (Object)null);
                     classNode$iv$iv$iv.access = 1;
                     classNode$iv$iv$iv.version = 52;
                     classNode$iv$iv$iv.superName = "java/lang/Object";
                     classNode$iv$iv$iv.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
                     var65 = (MethodNode)classNode$iv$iv$iv.methods.get(0);
                     $i$f$getDummyCode = false;
                     list$iv$iv$iv$iv = new InsnList();
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(89)));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("owned")));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(191)));
                     var65.instructions = list$iv$iv$iv$iv;
                     writer$iv$iv$iv = new ClassWriter(2);
                     classNode$iv$iv$iv.accept((ClassVisitor)writer$iv$iv$iv);
                     bytes$iv$iv = writer$iv$iv$iv.toByteArray();
                     var56 = false;

                     try {
                        f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                        f$iv$iv$iv.setAccessible(true);
                        var91 = f$iv$iv$iv.get((Object)null);
                        if (var91 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                        }

                        var62 = (Unsafe)var91;
                     } catch (Exception var39) {
                        throw (Throwable)(new RuntimeException((Throwable)var39));
                     }

                     var62.defineClass("sun.instrument.InstrumentationImpl", bytes$iv$iv, 0, bytes$iv$iv.length, (ClassLoader)null, (ProtectionDomain)null);
                     var90 = 32;
                  } catch (Throwable var40) {
                     label2868: {
                        if (var40 instanceof LinkageError) {
                           try {
                              c$iv$iv = thisClass$iv.getClassLoader().loadClass("sun.instrument.InstrumentationImpl");
                              var58 = c$iv$iv.getDeclaredMethods();
                              var7 = false;
                              if (var58.length == 0) {
                                 var90 = 160;
                                 break label2868;
                              }
                           } catch (ClassNotFoundException var38) {
                           }
                        }

                        var90 = 0;
                     }
                  }

                  short var84 = var90;
                  int i$iv = var64 | var84;
                  var48 = false;

                  try {
                     $this$hexBytes$iv = "dev/nuker/pyro/MaliciousClassFilter";
                     $i$f$setupIntrospection = false;
                     classNode$iv$iv$iv = new ClassNode();
                     classNode$iv$iv$iv.name = StringsKt.replace$default($this$hexBytes$iv, '.', '/', false, 4, (Object)null);
                     classNode$iv$iv$iv.access = 1;
                     classNode$iv$iv$iv.version = 52;
                     classNode$iv$iv$iv.superName = "java/lang/Object";
                     classNode$iv$iv$iv.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
                     var65 = (MethodNode)classNode$iv$iv$iv.methods.get(0);
                     $i$f$getDummyCode = false;
                     list$iv$iv$iv$iv = new InsnList();
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(89)));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("owned")));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
                     list$iv$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(191)));
                     var65.instructions = list$iv$iv$iv$iv;
                     writer$iv$iv$iv = new ClassWriter(2);
                     classNode$iv$iv$iv.accept((ClassVisitor)writer$iv$iv$iv);
                     bytes$iv$iv = writer$iv$iv$iv.toByteArray();
                     var56 = false;

                     try {
                        f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                        f$iv$iv$iv.setAccessible(true);
                        var91 = f$iv$iv$iv.get((Object)null);
                        if (var91 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                        }

                        var62 = (Unsafe)var91;
                     } catch (Exception var36) {
                        throw (Throwable)(new RuntimeException((Throwable)var36));
                     }

                     var62.defineClass("dev.nuker.pyro.MaliciousClassFilter", bytes$iv$iv, 0, bytes$iv$iv.length, (ClassLoader)null, (ProtectionDomain)null);
                     System.setProperty("sun.jvm.hotspot.tools.jcore.filter", "dev.nuker.pyro.MaliciousClassFilter");
                     var89 = 0;
                  } catch (Throwable var37) {
                     label2851: {
                        if (var37 instanceof LinkageError) {
                           try {
                              c$iv$iv = thisClass$iv.getClassLoader().loadClass("dev.nuker.pyro.MaliciousClassFilter");
                              var58 = c$iv$iv.getDeclaredMethods();
                              var7 = false;
                              if (var58.length == 0) {
                                 var89 = 4;
                                 break label2851;
                              }
                           } catch (ClassNotFoundException var35) {
                           }
                        }

                        var89 = 16;
                     }
                  }

                  var14 = var89;
                  i$iv |= var14;
                  var48 = false;
                  var56 = false;

                  String os$iv$iv$iv$iv$iv;
                  try {
                     $i$f$setupIntrospection = false;
                     var7 = false;
                     vmName$iv$iv$iv$iv$iv = System.getProperty("os.name");
                     $i$f$getDummyCode = false;
                     if (vmName$iv$iv$iv$iv$iv == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                     }

                     os$iv$iv$iv$iv$iv = vmName$iv$iv$iv$iv$iv.toLowerCase();
                     ClassLoader var92;
                     if (StringsKt.contains$default((CharSequence)os$iv$iv$iv$iv$iv, (CharSequence)"windows", false, 2, (Object)null)) {
                        vmName$iv$iv$iv$iv$iv = System.getProperty("java.vm.name");
                        String dll$iv$iv$iv$iv$iv = StringsKt.contains$default((CharSequence)vmName$iv$iv$iv$iv$iv, (CharSequence)"Client VM", false, 2, (Object)null) ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

                        try {
                           System.load(System.getProperty("java.home") + dll$iv$iv$iv$iv$iv);
                        } catch (UnsatisfiedLinkError var27) {
                           throw (Throwable)(new RuntimeException((Throwable)var27));
                        }

                        var92 = StructDissasembler.class.getClassLoader();
                     } else {
                        var92 = null;
                     }

                     StructDissasembler.setClassLoader(var92);
                     StructDissasembler.setFindNative(ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class));

                     try {
                        Class cls$iv$iv$iv$iv$iv = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
                        Field logger$iv$iv$iv$iv$iv = cls$iv$iv$iv$iv$iv.getDeclaredField("logger");
                        var12 = false;

                        Field f$iv$iv$iv$iv$iv$iv;
                        Unsafe var86;
                        try {
                           f$iv$iv$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                           f$iv$iv$iv$iv$iv$iv.setAccessible(true);
                           var91 = f$iv$iv$iv$iv$iv$iv.get((Object)null);
                           if (var91 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                           }

                           var86 = (Unsafe)var91;
                        } catch (Exception var29) {
                           throw (Throwable)(new RuntimeException((Throwable)var29));
                        }

                        Unsafe var17 = var86;
                        var12 = false;

                        try {
                           f$iv$iv$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                           f$iv$iv$iv$iv$iv$iv.setAccessible(true);
                           var91 = f$iv$iv$iv$iv$iv$iv.get((Object)null);
                           if (var91 == null) {
                              throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                           }

                           var86 = (Unsafe)var91;
                        } catch (Exception var30) {
                           throw (Throwable)(new RuntimeException((Throwable)var30));
                        }

                        var17.putObjectVolatile(cls$iv$iv$iv$iv$iv, var86.staticFieldOffset(logger$iv$iv$iv$iv$iv), (Object)null);
                     } catch (Throwable var31) {
                     }

                     Method var93 = StructDissasembler.getFindNative();
                     if (var93 == null) {
                        Intrinsics.throwNpe();
                     }

                     var93.setAccessible(true);
                     $i$f$setupIntrospection = false;

                     Unsafe var66;
                     try {
                        Field f$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                        f$iv$iv$iv$iv.setAccessible(true);
                        var91 = f$iv$iv$iv$iv.get((Object)null);
                        if (var91 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                        }

                        var66 = (Unsafe)var91;
                     } catch (Exception var28) {
                        throw (Throwable)(new RuntimeException((Throwable)var28));
                     }

                     symbol$iv$iv$iv$iv = "gHotSpotVMStructs";
                     var7 = false;
                     var93 = StructDissasembler.getFindNative();
                     if (var93 == null) {
                        Intrinsics.throwNpe();
                     }

                     var91 = var93.invoke((Object)null, StructDissasembler.getClassLoader(), symbol$iv$iv$iv$iv);
                     if (var91 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
                     }

                     long address$iv$iv$iv$iv = (Long)var91;
                     if (address$iv$iv$iv$iv == ((long)-503030176 ^ -503030176L)) {
                        throw (Throwable)(new NoSuchElementException(symbol$iv$iv$iv$iv));
                     }

                     boolean var75 = false;

                     Unsafe var81;
                     try {
                        Field f$iv$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                        f$iv$iv$iv$iv$iv.setAccessible(true);
                        var91 = f$iv$iv$iv$iv$iv.get((Object)null);
                        if (var91 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                        }

                        var81 = (Unsafe)var91;
                     } catch (Exception var32) {
                        throw (Throwable)(new RuntimeException((Throwable)var32));
                     }

                     long var22 = var81.getLong(address$iv$iv$iv$iv);
                     var66.putLong(var22, (long)-1159178941 ^ -1159178941L);
                     var89 = 1;
                  } catch (NoSuchElementException var33) {
                     var89 = 1;
                  } catch (Throwable var34) {
                     var89 = 0;
                  }

                  var14 = var89;
                  int checks = i$iv | var14;
                  this.$so.writeInt(checks);
                  Config.load();
                  Ref.ObjectRef discord = new Ref.ObjectRef();
                  discord.element = (String)null;
                  Thread var47 = Thread.currentThread();
                  ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)(new SecondLayer$run$1$1(discord, var47)), 30, (Object)null);
                  DataOutputStream var94 = this.$so;
                  String var10001 = (String)discord.element;
                  if (var10001 == null) {
                     var10001 = "nodiscord";
                  }

                  var94.writeUTF(var10001);
                  SecondLayer$run$1$2 $fun$login$2 = new SecondLayer$run$1$2(this);
                  if (Config.INSTANCE.username != null && Config.INSTANCE.password != null) {
                     $this$hexBytes$iv = Config.INSTANCE.password;
                     String var25 = Config.INSTANCE.username;
                     $i$f$setupIntrospection = false;
                     byte[] val$iv = new byte[$this$hexBytes$iv.length() / 2];
                     i$iv = 0;

                     for(int var71 = val$iv.length; i$iv < var71; ++i$iv) {
                        int index$iv = i$iv * 2;
                        int var82 = index$iv + 2;
                        var13 = false;
                        os$iv$iv$iv$iv$iv = $this$hexBytes$iv.substring(index$iv, var82);
                        byte var85 = 16;
                        var13 = false;
                        int var88 = Integer.parseInt(os$iv$iv$iv$iv$iv, CharsKt.checkRadix(var85));
                        val$iv[i$iv] = (byte)var88;
                     }

                     $fun$login$2.invoke(var25, val$iv);
                  } else {
                     EventQueue.invokeAndWait((Runnable)(new 3(this, $fun$login$2)));
                  }

               }
            }
         }
      }
   }
}
