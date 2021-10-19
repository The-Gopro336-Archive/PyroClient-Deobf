/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
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

public class UnsafeSecurity {
   public static UnsafeSecurity INSTANCE;

   @NotNull
   public static InsnList getDummyCode() {
      int $i$f$getDummyCode = false;
      InsnList list = new InsnList();
      list.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
      list.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
      list.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
      list.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
      list.add((AbstractInsnNode)(new InsnNode(89)));
      list.add((AbstractInsnNode)(new LdcInsnNode("owned")));
      list.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
      list.add((AbstractInsnNode)(new InsnNode(191)));
      return list;
   }

   @JvmStatic
   public static int checkSecurity(@NotNull Class thisClass) {
      int $i$f$checkSecurity = false;
      boolean $i$f$dissasembleStructs = false;
      Iterator var3 = ManagementFactory.getRuntimeMXBean().getInputArguments().iterator();

      String symbol$iv$iv$iv;
      boolean var5;
      byte var10000;
      while(true) {
         if (var3.hasNext()) {
            symbol$iv$iv$iv = (String)var3.next();
            var5 = false;
            if (!CollectionsKt.listOf(new String[]{"-javaagent", "-Xdebug", "-Xrunjdwp", "-Xnoagent", "-verbose", "-DproxySet", "-DproxyHost", "-DproxyPort", "-Djavax.net.ssl.trustStore", "-Djavax.net.ssl.trustStorePassword", "-Dmixin.debug", "-Dlegacy"}).stream().anyMatch((Predicate)(new UnsafeSecurity$checkLaunchFlags$1(symbol$iv$iv$iv)))) {
               continue;
            }

            var10000 = 8;
            break;
         }

         var10000 = 0;
         break;
      }

      byte var20 = var10000;
      $i$f$dissasembleStructs = false;

      MethodNode var6;
      boolean $i$f$getDummyCode;
      InsnList list$iv$iv$iv;
      byte[] bytes$iv;
      Class c$iv;
      String name$iv$iv;
      boolean var38;
      Method[] var39;
      boolean $i$f$setupIntrospection;
      Field f$iv$iv;
      Unsafe var42;
      ClassNode classNode$iv$iv;
      ClassWriter writer$iv$iv;
      short var59;
      Object var60;
      try {
         name$iv$iv = "sun/instrument/InstrumentationImpl";
         $i$f$setupIntrospection = false;
         classNode$iv$iv = new ClassNode();
         classNode$iv$iv.name = StringsKt.replace$default(name$iv$iv, '.', '/', false, 4, (Object)null);
         classNode$iv$iv.access = 1;
         classNode$iv$iv.version = 52;
         classNode$iv$iv.superName = "java/lang/Object";
         classNode$iv$iv.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
         var6 = (MethodNode)classNode$iv$iv.methods.get(0);
         $i$f$getDummyCode = false;
         list$iv$iv$iv = new InsnList();
         list$iv$iv$iv.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
         list$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
         list$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
         list$iv$iv$iv.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
         list$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(89)));
         list$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("owned")));
         list$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
         list$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(191)));
         var6.instructions = list$iv$iv$iv;
         writer$iv$iv = new ClassWriter(2);
         classNode$iv$iv.accept((ClassVisitor)writer$iv$iv);
         bytes$iv = writer$iv$iv.toByteArray();
         var38 = false;

         try {
            f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv.setAccessible(true);
            var60 = f$iv$iv.get((Object)null);
            if (var60 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var42 = (Unsafe)var60;
         } catch (Exception var34) {
            throw (Throwable)(new RuntimeException((Throwable)var34));
         }

         var42.defineClass("sun.instrument.InstrumentationImpl", bytes$iv, 0, bytes$iv.length, (ClassLoader)null, (ProtectionDomain)null);
         var59 = 32;
      } catch (Throwable var35) {
         label2333: {
            if (var35 instanceof LinkageError) {
               try {
                  c$iv = thisClass.getClassLoader().loadClass("sun.instrument.InstrumentationImpl");
                  var39 = c$iv.getDeclaredMethods();
                  var5 = false;
                  if (var39.length == 0) {
                     var59 = 160;
                     break label2333;
                  }
               } catch (ClassNotFoundException var33) {
               }
            }

            var59 = 0;
         }
      }

      short var21 = var59;
      int var57 = var20 | var21;
      $i$f$dissasembleStructs = false;

      try {
         name$iv$iv = "dev/nuker/pyro/MaliciousClassFilter";
         $i$f$setupIntrospection = false;
         classNode$iv$iv = new ClassNode();
         classNode$iv$iv.name = StringsKt.replace$default(name$iv$iv, '.', '/', false, 4, (Object)null);
         classNode$iv$iv.access = 1;
         classNode$iv$iv.version = 52;
         classNode$iv$iv.superName = "java/lang/Object";
         classNode$iv$iv.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
         var6 = (MethodNode)classNode$iv$iv.methods.get(0);
         $i$f$getDummyCode = false;
         list$iv$iv$iv = new InsnList();
         list$iv$iv$iv.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
         list$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
         list$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
         list$iv$iv$iv.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
         list$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(89)));
         list$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("owned")));
         list$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
         list$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(191)));
         var6.instructions = list$iv$iv$iv;
         writer$iv$iv = new ClassWriter(2);
         classNode$iv$iv.accept((ClassVisitor)writer$iv$iv);
         bytes$iv = writer$iv$iv.toByteArray();
         var38 = false;

         try {
            f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv.setAccessible(true);
            var60 = f$iv$iv.get((Object)null);
            if (var60 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var42 = (Unsafe)var60;
         } catch (Exception var31) {
            throw (Throwable)(new RuntimeException((Throwable)var31));
         }

         var42.defineClass("dev.nuker.pyro.MaliciousClassFilter", bytes$iv, 0, bytes$iv.length, (ClassLoader)null, (ProtectionDomain)null);
         System.setProperty("sun.jvm.hotspot.tools.jcore.filter", "dev.nuker.pyro.MaliciousClassFilter");
         var10000 = 0;
      } catch (Throwable var32) {
         label2313: {
            if (var32 instanceof LinkageError) {
               try {
                  c$iv = thisClass.getClassLoader().loadClass("dev.nuker.pyro.MaliciousClassFilter");
                  var39 = c$iv.getDeclaredMethods();
                  var5 = false;
                  if (var39.length == 0) {
                     var10000 = 4;
                     break label2313;
                  }
               } catch (ClassNotFoundException var30) {
               }
            }

            var10000 = 16;
         }
      }

      byte var58 = var10000;
      var57 |= var58;
      $i$f$dissasembleStructs = false;
      var38 = false;

      try {
         $i$f$setupIntrospection = false;
         var5 = false;
         String vmName$iv$iv$iv$iv = System.getProperty("os.name");
         $i$f$getDummyCode = false;
         if (vmName$iv$iv$iv$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String os$iv$iv$iv$iv = vmName$iv$iv$iv$iv.toLowerCase();
         ClassLoader var61;
         if (StringsKt.contains$default((CharSequence)os$iv$iv$iv$iv, (CharSequence)"windows", false, 2, (Object)null)) {
            vmName$iv$iv$iv$iv = System.getProperty("java.vm.name");
            String dll$iv$iv$iv$iv = StringsKt.contains$default((CharSequence)vmName$iv$iv$iv$iv, (CharSequence)"Client VM", false, 2, (Object)null) ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

            try {
               System.load(System.getProperty("java.home") + dll$iv$iv$iv$iv);
            } catch (UnsatisfiedLinkError var22) {
               throw (Throwable)(new RuntimeException((Throwable)var22));
            }

            var61 = StructDissasembler.class.getClassLoader();
         } else {
            var61 = null;
         }

         StructDissasembler.setClassLoader(var61);
         StructDissasembler.setFindNative(ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class));

         try {
            Class cls$iv$iv$iv$iv = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
            Field logger$iv$iv$iv$iv = cls$iv$iv$iv$iv.getDeclaredField("logger");
            boolean var9 = false;

            Field f$iv$iv$iv$iv$iv;
            Unsafe var56;
            try {
               f$iv$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv$iv$iv$iv.setAccessible(true);
               var60 = f$iv$iv$iv$iv$iv.get((Object)null);
               if (var60 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var56 = (Unsafe)var60;
            } catch (Exception var25) {
               throw (Throwable)(new RuntimeException((Throwable)var25));
            }

            Unsafe var13 = var56;
            var9 = false;

            try {
               f$iv$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv$iv$iv$iv.setAccessible(true);
               var60 = f$iv$iv$iv$iv$iv.get((Object)null);
               if (var60 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var56 = (Unsafe)var60;
            } catch (Exception var24) {
               throw (Throwable)(new RuntimeException((Throwable)var24));
            }

            var13.putObjectVolatile(cls$iv$iv$iv$iv, var56.staticFieldOffset(logger$iv$iv$iv$iv), (Object)null);
         } catch (Throwable var26) {
         }

         Method var62 = StructDissasembler.getFindNative();
         if (var62 == null) {
            Intrinsics.throwNpe();
         }

         var62.setAccessible(true);
         $i$f$setupIntrospection = false;

         Unsafe var48;
         try {
            Field f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv$iv.setAccessible(true);
            var60 = f$iv$iv$iv.get((Object)null);
            if (var60 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var48 = (Unsafe)var60;
         } catch (Exception var23) {
            throw (Throwable)(new RuntimeException((Throwable)var23));
         }

         symbol$iv$iv$iv = "gHotSpotVMStructs";
         Unsafe var15 = var48;
         var5 = false;
         var62 = StructDissasembler.getFindNative();
         if (var62 == null) {
            Intrinsics.throwNpe();
         }

         var60 = var62.invoke((Object)null, StructDissasembler.getClassLoader(), symbol$iv$iv$iv);
         if (var60 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
         }

         long address$iv$iv$iv = (Long)var60;
         if (address$iv$iv$iv == ((long)-208380026 ^ -208380026L)) {
            throw (Throwable)(new NoSuchElementException(symbol$iv$iv$iv));
         }

         boolean var52 = false;

         Unsafe var54;
         try {
            Field f$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv$iv$iv.setAccessible(true);
            var60 = f$iv$iv$iv$iv.get((Object)null);
            if (var60 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var54 = (Unsafe)var60;
         } catch (Exception var27) {
            throw (Throwable)(new RuntimeException((Throwable)var27));
         }

         long var18 = var54.getLong(address$iv$iv$iv);
         var15.putLong(var18, (long)1849619181 ^ 1849619181L);
         var10000 = 1;
      } catch (NoSuchElementException var28) {
         var10000 = 1;
      } catch (Throwable var29) {
         var10000 = 0;
      }

      var58 = var10000;
      return var57 | var58;
   }

   /** @deprecated */
   @JvmStatic
   public static void dummyCode$annotations() {
   }

   /** @deprecated */
   @JvmStatic
   public static void badflags$annotations() {
   }

   @JvmStatic
   public static int disableJavaAgents(@NotNull Class thisClass) {
      boolean var1 = false;

      try {
         String name$iv = "sun/instrument/InstrumentationImpl";
         int $i$f$createDummyClass = false;
         ClassNode classNode$iv = new ClassNode();
         classNode$iv.name = StringsKt.replace$default(name$iv, '.', '/', false, 4, (Object)null);
         classNode$iv.access = 1;
         classNode$iv.version = 52;
         classNode$iv.superName = "java/lang/Object";
         classNode$iv.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
         MethodNode var6 = (MethodNode)classNode$iv.methods.get(0);
         int $i$f$getDummyCode = false;
         InsnList list$iv$iv = new InsnList();
         list$iv$iv.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
         list$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
         list$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
         list$iv$iv.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
         list$iv$iv.add((AbstractInsnNode)(new InsnNode(89)));
         list$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("owned")));
         list$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
         list$iv$iv.add((AbstractInsnNode)(new InsnNode(191)));
         var6.instructions = list$iv$iv;
         ClassWriter writer$iv = new ClassWriter(2);
         classNode$iv.accept((ClassVisitor)writer$iv);
         byte[] bytes = writer$iv.toByteArray();
         boolean var14 = false;

         Unsafe var17;
         try {
            Field f$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv.setAccessible(true);
            Object var10000 = f$iv.get((Object)null);
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var17 = (Unsafe)var10000;
         } catch (Exception var11) {
            throw (Throwable)(new RuntimeException((Throwable)var11));
         }

         var17.defineClass("sun.instrument.InstrumentationImpl", bytes, 0, bytes.length, (ClassLoader)null, (ProtectionDomain)null);
         return 32;
      } catch (Throwable var12) {
         if (var12 instanceof LinkageError) {
            try {
               Class c = thisClass.getClassLoader().loadClass("sun.instrument.InstrumentationImpl");
               Method[] var4 = c.getDeclaredMethods();
               boolean var5 = false;
               if (var4.length == 0) {
                  return 160;
               }
            } catch (ClassNotFoundException var10) {
            }
         }

         return 0;
      }
   }

   @JvmStatic
   public static int setPackageNameFilter(@NotNull Class thisClass) {
      boolean var1 = false;

      try {
         String name$iv = "dev/nuker/pyro/MaliciousClassFilter";
         int $i$f$createDummyClass = false;
         ClassNode classNode$iv = new ClassNode();
         classNode$iv.name = StringsKt.replace$default(name$iv, '.', '/', false, 4, (Object)null);
         classNode$iv.access = 1;
         classNode$iv.version = 52;
         classNode$iv.superName = "java/lang/Object";
         classNode$iv.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
         MethodNode var6 = (MethodNode)classNode$iv.methods.get(0);
         int $i$f$getDummyCode = false;
         InsnList list$iv$iv = new InsnList();
         list$iv$iv.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
         list$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
         list$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
         list$iv$iv.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
         list$iv$iv.add((AbstractInsnNode)(new InsnNode(89)));
         list$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("owned")));
         list$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
         list$iv$iv.add((AbstractInsnNode)(new InsnNode(191)));
         var6.instructions = list$iv$iv;
         ClassWriter writer$iv = new ClassWriter(2);
         classNode$iv.accept((ClassVisitor)writer$iv);
         byte[] bytes = writer$iv.toByteArray();
         boolean var14 = false;

         Unsafe var17;
         try {
            Field f$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv.setAccessible(true);
            Object var10000 = f$iv.get((Object)null);
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var17 = (Unsafe)var10000;
         } catch (Exception var11) {
            throw (Throwable)(new RuntimeException((Throwable)var11));
         }

         var17.defineClass("dev.nuker.pyro.MaliciousClassFilter", bytes, 0, bytes.length, (ClassLoader)null, (ProtectionDomain)null);
         System.setProperty("sun.jvm.hotspot.tools.jcore.filter", "dev.nuker.pyro.MaliciousClassFilter");
         return 0;
      } catch (Throwable var12) {
         if (var12 instanceof LinkageError) {
            try {
               Class c = thisClass.getClassLoader().loadClass("dev.nuker.pyro.MaliciousClassFilter");
               Method[] var4 = c.getDeclaredMethods();
               boolean var5 = false;
               if (var4.length == 0) {
                  return 4;
               }
            } catch (ClassNotFoundException var10) {
            }
         }

         return 16;
      }
   }

   @JvmStatic
   @NotNull
   public static byte[] createDummyClass(@NotNull String name) {
      int $i$f$createDummyClass = false;
      ClassNode classNode = new ClassNode();
      classNode.name = StringsKt.replace$default(name, '.', '/', false, 4, (Object)null);
      classNode.access = 1;
      classNode.version = 52;
      classNode.superName = "java/lang/Object";
      classNode.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
      MethodNode var5 = (MethodNode)classNode.methods.get(0);
      boolean var3 = false;
      InsnList list$iv = new InsnList();
      list$iv.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
      list$iv.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
      list$iv.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
      list$iv.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
      list$iv.add((AbstractInsnNode)(new InsnNode(89)));
      list$iv.add((AbstractInsnNode)(new LdcInsnNode("owned")));
      list$iv.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
      list$iv.add((AbstractInsnNode)(new InsnNode(191)));
      var5.instructions = list$iv;
      int $i$f$getDummyCode = new ClassWriter(2);
      classNode.accept((ClassVisitor)$i$f$getDummyCode);
      return $i$f$getDummyCode.toByteArray();
   }

   static {
      UnsafeSecurity var0 = new UnsafeSecurity();
      INSTANCE = var0;
   }

   @JvmStatic
   public static int dissasembleStructs() {
      int $i$f$dissasembleStructs = false;
      boolean var1 = false;

      byte var10000;
      try {
         boolean var2 = false;
         boolean var3 = false;
         String vmName$iv$iv$iv = System.getProperty("os.name");
         boolean var5 = false;
         if (vmName$iv$iv$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var6 = vmName$iv$iv$iv.toLowerCase();
         ClassLoader var36;
         if (StringsKt.contains$default((CharSequence)var6, (CharSequence)"windows", false, 2, (Object)null)) {
            vmName$iv$iv$iv = System.getProperty("java.vm.name");
            String dll$iv$iv$iv = StringsKt.contains$default((CharSequence)vmName$iv$iv$iv, (CharSequence)"Client VM", false, 2, (Object)null) ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

            try {
               System.load(System.getProperty("java.home") + dll$iv$iv$iv);
            } catch (UnsatisfiedLinkError var18) {
               throw (Throwable)(new RuntimeException((Throwable)var18));
            }

            var36 = StructDissasembler.class.getClassLoader();
         } else {
            var36 = null;
         }

         StructDissasembler.setClassLoader(var36);
         StructDissasembler.setFindNative(ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class));

         Object var37;
         try {
            Class cls$iv$iv$iv = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
            Field logger$iv$iv$iv = cls$iv$iv$iv.getDeclaredField("logger");
            boolean var7 = false;

            Field f$iv$iv$iv$iv;
            Unsafe var35;
            try {
               f$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv$iv$iv.setAccessible(true);
               var37 = f$iv$iv$iv$iv.get((Object)null);
               if (var37 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var35 = (Unsafe)var37;
            } catch (Exception var21) {
               throw (Throwable)(new RuntimeException((Throwable)var21));
            }

            Unsafe var11 = var35;
            var7 = false;

            try {
               f$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv$iv$iv.setAccessible(true);
               var37 = f$iv$iv$iv$iv.get((Object)null);
               if (var37 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var35 = (Unsafe)var37;
            } catch (Exception var20) {
               throw (Throwable)(new RuntimeException((Throwable)var20));
            }

            var11.putObjectVolatile(cls$iv$iv$iv, var35.staticFieldOffset(logger$iv$iv$iv), (Object)null);
         } catch (Throwable var22) {
         }

         Method var38 = StructDissasembler.getFindNative();
         if (var38 == null) {
            Intrinsics.throwNpe();
         }

         var38.setAccessible(true);
         var2 = false;

         Unsafe var28;
         try {
            Field f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv.setAccessible(true);
            var37 = f$iv$iv.get((Object)null);
            if (var37 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var28 = (Unsafe)var37;
         } catch (Exception var23) {
            throw (Throwable)(new RuntimeException((Throwable)var23));
         }

         String symbol$iv$iv = "gHotSpotVMStructs";
         Unsafe var13 = var28;
         var3 = false;
         var38 = StructDissasembler.getFindNative();
         if (var38 == null) {
            Intrinsics.throwNpe();
         }

         var37 = var38.invoke((Object)null, StructDissasembler.getClassLoader(), symbol$iv$iv);
         if (var37 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
         }

         long address$iv$iv = (Long)var37;
         if (address$iv$iv == ((long)992036944 ^ 992036944L)) {
            throw (Throwable)(new NoSuchElementException(symbol$iv$iv));
         }

         boolean var32 = false;

         Unsafe var34;
         try {
            Field f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv$iv.setAccessible(true);
            var37 = f$iv$iv$iv.get((Object)null);
            if (var37 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var34 = (Unsafe)var37;
         } catch (Exception var19) {
            throw (Throwable)(new RuntimeException((Throwable)var19));
         }

         long var16 = var34.getLong(address$iv$iv);
         var13.putLong(var16, (long)1473131738 ^ 1473131738L);
         var10000 = 1;
      } catch (NoSuchElementException var24) {
         var10000 = 1;
      } catch (Throwable var25) {
         var10000 = 0;
      }

      return var10000;
   }

   @JvmStatic
   public static int checkLaunchFlags() {
      int $i$f$checkLaunchFlags = false;
      Iterator var2 = ManagementFactory.getRuntimeMXBean().getInputArguments().iterator();

      String flag;
      do {
         if (!var2.hasNext()) {
            return 0;
         }

         flag = (String)var2.next();
         boolean var3 = false;
      } while(!CollectionsKt.listOf(new String[]{"-javaagent", "-Xdebug", "-Xrunjdwp", "-Xnoagent", "-verbose", "-DproxySet", "-DproxyHost", "-DproxyPort", "-Djavax.net.ssl.trustStore", "-Djavax.net.ssl.trustStorePassword", "-Dmixin.debug", "-Dlegacy"}).stream().anyMatch((Predicate)(new UnsafeSecurity$checkLaunchFlags$1(flag))));

      return 8;
   }

   @NotNull
   public static List getBadflags() {
      boolean var0 = false;
      return CollectionsKt.listOf(new String[]{"-javaagent", "-Xdebug", "-Xrunjdwp", "-Xnoagent", "-verbose", "-DproxySet", "-DproxyHost", "-DproxyPort", "-Djavax.net.ssl.trustStore", "-Djavax.net.ssl.trustStorePassword", "-Dmixin.debug", "-Dlegacy"});
   }
}
