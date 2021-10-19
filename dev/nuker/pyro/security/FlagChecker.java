/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
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

public class FlagChecker {
   public static FlagChecker INSTANCE;

   static {
      FlagChecker var0 = new FlagChecker();
      INSTANCE = var0;
   }

   @JvmStatic
   public static int recheck() {
      boolean var0 = false;

      boolean var3;
      byte var10000;
      boolean var29;
      boolean $i$f$createDummyClass;
      Object var47;
      try {
         String name$iv$iv = "sun/instrument/InstrumentationImpl";
         $i$f$createDummyClass = false;
         ClassNode classNode$iv$iv = new ClassNode();
         classNode$iv$iv.name = StringsKt.replace$default(name$iv$iv, '.', '/', false, 4, (Object)null);
         classNode$iv$iv.access = 1;
         classNode$iv$iv.version = 52;
         classNode$iv$iv.superName = "java/lang/Object";
         classNode$iv$iv.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
         MethodNode var4 = (MethodNode)classNode$iv$iv.methods.get(0);
         int $i$f$getDummyCode = false;
         InsnList list$iv$iv$iv = new InsnList();
         list$iv$iv$iv.add((AbstractInsnNode)(new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;")));
         list$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("Nice try")));
         list$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)));
         list$iv$iv$iv.add((AbstractInsnNode)(new TypeInsnNode(187, "java/lang/Throwable")));
         list$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(89)));
         list$iv$iv$iv.add((AbstractInsnNode)(new LdcInsnNode("owned")));
         list$iv$iv$iv.add((AbstractInsnNode)(new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false)));
         list$iv$iv$iv.add((AbstractInsnNode)(new InsnNode(191)));
         var4.instructions = list$iv$iv$iv;
         ClassWriter writer$iv$iv = new ClassWriter(2);
         classNode$iv$iv.accept((ClassVisitor)writer$iv$iv);
         byte[] bytes$iv = writer$iv$iv.toByteArray();
         var29 = false;

         Unsafe var32;
         try {
            Field f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv.setAccessible(true);
            var47 = f$iv$iv.get((Object)null);
            if (var47 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var32 = (Unsafe)var47;
         } catch (Exception var26) {
            throw (Throwable)(new RuntimeException((Throwable)var26));
         }

         var32.defineClass("sun.instrument.InstrumentationImpl", bytes$iv, 0, bytes$iv.length, (ClassLoader)null, (ProtectionDomain)null);
         var10000 = 4;
      } catch (Throwable var27) {
         label1462: {
            if (var27 instanceof LinkageError) {
               try {
                  Class c$iv = INSTANCE.getClass().getClassLoader().loadClass("sun.instrument.InstrumentationImpl");
                  Method[] var2 = c$iv.getDeclaredMethods();
                  var3 = false;
                  if (var2.length == 0) {
                     var10000 = 8;
                     break label1462;
                  }
               } catch (ClassNotFoundException var25) {
               }
            }

            var10000 = 0;
         }
      }

      byte var16 = var10000;
      var0 = false;

      boolean var48;
      try {
         var29 = false;
         $i$f$createDummyClass = false;
         String symbol$iv$iv = System.getProperty("os.name");
         boolean var35 = false;
         if (symbol$iv$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String os$iv$iv$iv = symbol$iv$iv.toLowerCase();
         ClassLoader var49;
         if (StringsKt.contains$default((CharSequence)os$iv$iv$iv, (CharSequence)"windows", false, 2, (Object)null)) {
            symbol$iv$iv = System.getProperty("java.vm.name");
            String dll$iv$iv$iv = StringsKt.contains$default((CharSequence)symbol$iv$iv, (CharSequence)"Client VM", false, 2, (Object)null) ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

            try {
               System.load(System.getProperty("java.home") + dll$iv$iv$iv);
            } catch (UnsatisfiedLinkError var18) {
               throw (Throwable)(new RuntimeException((Throwable)var18));
            }

            var49 = StructDissasembler.class.getClassLoader();
         } else {
            var49 = null;
         }

         StructDissasembler.setClassLoader(var49);
         StructDissasembler.setFindNative(ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class));

         Field f$iv$iv;
         try {
            Class cls$iv$iv$iv = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
            f$iv$iv = cls$iv$iv$iv.getDeclaredField("logger");
            boolean var42 = false;

            Field f$iv$iv$iv$iv;
            Unsafe var43;
            try {
               f$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv$iv$iv.setAccessible(true);
               var47 = f$iv$iv$iv$iv.get((Object)null);
               if (var47 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var43 = (Unsafe)var47;
            } catch (Exception var20) {
               throw (Throwable)(new RuntimeException((Throwable)var20));
            }

            Unsafe var10 = var43;
            var42 = false;

            try {
               f$iv$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv$iv$iv.setAccessible(true);
               var47 = f$iv$iv$iv$iv.get((Object)null);
               if (var47 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var43 = (Unsafe)var47;
            } catch (Exception var21) {
               throw (Throwable)(new RuntimeException((Throwable)var21));
            }

            var10.putObjectVolatile(cls$iv$iv$iv, var43.staticFieldOffset(f$iv$iv), (Object)null);
         } catch (Throwable var22) {
         }

         Method var50 = StructDissasembler.getFindNative();
         if (var50 == null) {
            Intrinsics.throwNpe();
         }

         var50.setAccessible(true);
         symbol$iv$iv = "gHotSpotVMStructs";
         var35 = false;
         var50 = StructDissasembler.getFindNative();
         if (var50 == null) {
            Intrinsics.throwNpe();
         }

         var47 = var50.invoke((Object)null, StructDissasembler.getClassLoader(), symbol$iv$iv);
         if (var47 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
         }

         long address$iv$iv = (Long)var47;
         if (address$iv$iv == ((long)-1678936560 ^ -1678936560L)) {
            throw (Throwable)(new NoSuchElementException(symbol$iv$iv));
         }

         boolean var44 = false;

         Unsafe var46;
         try {
            Field f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv$iv.setAccessible(true);
            var47 = f$iv$iv$iv.get((Object)null);
            if (var47 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var46 = (Unsafe)var47;
         } catch (Exception var19) {
            throw (Throwable)(new RuntimeException((Throwable)var19));
         }

         long entry$iv = var46.getLong(address$iv$iv);
         var3 = false;

         Unsafe var41;
         try {
            f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv$iv.setAccessible(true);
            var47 = f$iv$iv.get((Object)null);
            if (var47 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var41 = (Unsafe)var47;
         } catch (Exception var23) {
            throw (Throwable)(new RuntimeException((Throwable)var23));
         }

         var48 = var41.getLong(entry$iv) == ((long)-905079762 ^ -905079762L);
      } catch (Throwable var24) {
         var48 = false;
      }

      boolean var17 = var48;
      return var16 | (var17 ? 0 : 0);
   }

   @JvmStatic
   public static int disableJavaAgents() {
      boolean var0 = false;

      try {
         String name$iv = "sun/instrument/InstrumentationImpl";
         int $i$f$createDummyClass = false;
         ClassNode classNode$iv = new ClassNode();
         classNode$iv.name = StringsKt.replace$default(name$iv, '.', '/', false, 4, (Object)null);
         classNode$iv.access = 1;
         classNode$iv.version = 52;
         classNode$iv.superName = "java/lang/Object";
         classNode$iv.methods = Arrays.asList(new MethodNode(9, "<clinit>", "()V", (String)null, (String[])null));
         MethodNode var5 = (MethodNode)classNode$iv.methods.get(0);
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
         var5.instructions = list$iv$iv;
         ClassWriter writer$iv = new ClassWriter(2);
         classNode$iv.accept((ClassVisitor)writer$iv);
         byte[] bytes = writer$iv.toByteArray();
         boolean var13 = false;

         Unsafe var16;
         try {
            Field f$iv = Unsafe.class.getDeclaredField("theUnsafe");
            f$iv.setAccessible(true);
            Object var10000 = f$iv.get((Object)null);
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
            }

            var16 = (Unsafe)var10000;
         } catch (Exception var10) {
            throw (Throwable)(new RuntimeException((Throwable)var10));
         }

         var16.defineClass("sun.instrument.InstrumentationImpl", bytes, 0, bytes.length, (ClassLoader)null, (ProtectionDomain)null);
         return 4;
      } catch (Throwable var11) {
         if (var11 instanceof LinkageError) {
            try {
               Class c = INSTANCE.getClass().getClassLoader().loadClass("sun.instrument.InstrumentationImpl");
               Method[] var3 = c.getDeclaredMethods();
               boolean var4 = false;
               if (var3.length == 0) {
                  return 8;
               }
            } catch (ClassNotFoundException var9) {
            }
         }

         return 0;
      }
   }
}
