/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Unsafe;

public class StructDissasembler {
   @Nullable
   public static Method findNative;
   @Nullable
   public static ClassLoader classLoader;
   public static StructDissasembler INSTANCE;

   @NotNull
   public static Unsafe getUnsafe() {
      boolean var0 = false;

      try {
         Field f = Unsafe.class.getDeclaredField("theUnsafe");
         f.setAccessible(true);
         Object var10000 = f.get((Object)null);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
         } else {
            Unsafe var4 = (Unsafe)var10000;
            return var4;
         }
      } catch (Exception var3) {
         throw (Throwable)(new RuntimeException((Throwable)var3));
      }
   }

   @JvmStatic
   public static void resolveClassLoader() {
      int $i$f$resolveClassLoader = false;
      String var2 = System.getProperty("os.name");
      boolean var3 = false;
      if (var2 == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         String var1 = var2.toLowerCase();
         ClassLoader var10000;
         if (StringsKt.contains$default((CharSequence)var1, (CharSequence)"windows", false, 2, (Object)null)) {
            var2 = System.getProperty("java.vm.name");
            String dll = StringsKt.contains$default((CharSequence)var2, (CharSequence)"Client VM", false, 2, (Object)null) ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

            try {
               System.load(System.getProperty("java.home") + dll);
            } catch (UnsatisfiedLinkError var10) {
               throw (Throwable)(new RuntimeException((Throwable)var10));
            }

            var10000 = StructDissasembler.class.getClassLoader();
         } else {
            var10000 = null;
         }

         setClassLoader(var10000);
         setFindNative(ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class));

         try {
            Class cls = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            boolean var4 = false;

            Field f$iv;
            Unsafe var17;
            Object var18;
            try {
               f$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv.setAccessible(true);
               var18 = f$iv.get((Object)null);
               if (var18 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var17 = (Unsafe)var18;
            } catch (Exception var11) {
               throw (Throwable)(new RuntimeException((Throwable)var11));
            }

            Unsafe var7 = var17;
            var4 = false;

            try {
               f$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv.setAccessible(true);
               var18 = f$iv.get((Object)null);
               if (var18 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var17 = (Unsafe)var18;
            } catch (Exception var12) {
               throw (Throwable)(new RuntimeException((Throwable)var12));
            }

            var7.putObjectVolatile(cls, var17.staticFieldOffset(logger), (Object)null);
         } catch (Throwable var13) {
         }

         Method var19 = getFindNative();
         if (var19 == null) {
            Intrinsics.throwNpe();
         }

         var19.setAccessible(true);
      }
   }

   public static void setFindNative(@Nullable Method var0) {
      findNative = var0;
   }

   @JvmStatic
   public static boolean checkDisassembly() {
      boolean var0 = false;

      try {
         int $i$f$setupIntrospection = false;
         boolean var2 = false;
         String symbol$iv = System.getProperty("os.name");
         boolean var4 = false;
         if (symbol$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         } else {
            String os$iv$iv = symbol$iv.toLowerCase();
            ClassLoader var10000;
            if (StringsKt.contains$default((CharSequence)os$iv$iv, (CharSequence)"windows", false, 2, (Object)null)) {
               symbol$iv = System.getProperty("java.vm.name");
               String dll$iv$iv = StringsKt.contains$default((CharSequence)symbol$iv, (CharSequence)"Client VM", false, 2, (Object)null) ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

               try {
                  System.load(System.getProperty("java.home") + dll$iv$iv);
               } catch (UnsatisfiedLinkError var12) {
                  throw (Throwable)(new RuntimeException((Throwable)var12));
               }

               var10000 = StructDissasembler.class.getClassLoader();
            } else {
               var10000 = null;
            }

            setClassLoader(var10000);
            setFindNative(ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class));

            Field f$iv;
            Object var29;
            try {
               Class cls$iv$iv = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
               f$iv = cls$iv$iv.getDeclaredField("logger");
               boolean var6 = false;

               Field f$iv$iv$iv;
               Unsafe var26;
               try {
                  f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                  f$iv$iv$iv.setAccessible(true);
                  var29 = f$iv$iv$iv.get((Object)null);
                  if (var29 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                  }

                  var26 = (Unsafe)var29;
               } catch (Exception var16) {
                  throw (Throwable)(new RuntimeException((Throwable)var16));
               }

               Unsafe var10 = var26;
               var6 = false;

               try {
                  f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                  f$iv$iv$iv.setAccessible(true);
                  var29 = f$iv$iv$iv.get((Object)null);
                  if (var29 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                  }

                  var26 = (Unsafe)var29;
               } catch (Exception var15) {
                  throw (Throwable)(new RuntimeException((Throwable)var15));
               }

               var10.putObjectVolatile(cls$iv$iv, var26.staticFieldOffset(f$iv), (Object)null);
            } catch (Throwable var17) {
            }

            Method var30 = getFindNative();
            if (var30 == null) {
               Intrinsics.throwNpe();
            }

            var30.setAccessible(true);
            symbol$iv = "gHotSpotVMStructs";
            var4 = false;
            var30 = getFindNative();
            if (var30 == null) {
               Intrinsics.throwNpe();
            }

            var29 = var30.invoke((Object)null, getClassLoader(), symbol$iv);
            if (var29 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
            } else {
               long address$iv = (Long)var29;
               if (address$iv == ((long)-2001882649 ^ -2001882649L)) {
                  throw (Throwable)(new NoSuchElementException(symbol$iv));
               } else {
                  boolean var27 = false;

                  Unsafe var28;
                  try {
                     Field f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                     f$iv$iv.setAccessible(true);
                     var29 = f$iv$iv.get((Object)null);
                     if (var29 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                     }

                     var28 = (Unsafe)var29;
                  } catch (Exception var14) {
                     throw (Throwable)(new RuntimeException((Throwable)var14));
                  }

                  long entry = var28.getLong(address$iv);
                  boolean var22 = false;

                  Unsafe var25;
                  try {
                     f$iv = Unsafe.class.getDeclaredField("theUnsafe");
                     f$iv.setAccessible(true);
                     var29 = f$iv.get((Object)null);
                     if (var29 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                     }

                     var25 = (Unsafe)var29;
                  } catch (Exception var13) {
                     throw (Throwable)(new RuntimeException((Throwable)var13));
                  }

                  return var25.getLong(entry) == ((long)-1936999865 ^ -1936999865L);
               }
            }
         }
      } catch (Throwable var18) {
         return false;
      }
   }

   @JvmStatic
   public static void setupIntrospection() {
      boolean var0 = false;
      boolean var1 = false;
      String var2 = System.getProperty("os.name");
      boolean var3 = false;
      if (var2 == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         String var4 = var2.toLowerCase();
         ClassLoader var10000;
         if (StringsKt.contains$default((CharSequence)var4, (CharSequence)"windows", false, 2, (Object)null)) {
            var2 = System.getProperty("java.vm.name");
            String dll$iv = StringsKt.contains$default((CharSequence)var2, (CharSequence)"Client VM", false, 2, (Object)null) ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

            try {
               System.load(System.getProperty("java.home") + dll$iv);
            } catch (UnsatisfiedLinkError var11) {
               throw (Throwable)(new RuntimeException((Throwable)var11));
            }

            var10000 = StructDissasembler.class.getClassLoader();
         } else {
            var10000 = null;
         }

         setClassLoader(var10000);
         setFindNative(ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class));

         try {
            Class cls$iv = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
            Field logger$iv = cls$iv.getDeclaredField("logger");
            boolean var5 = false;

            Field f$iv$iv;
            Unsafe var18;
            Object var19;
            try {
               f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv.setAccessible(true);
               var19 = f$iv$iv.get((Object)null);
               if (var19 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var18 = (Unsafe)var19;
            } catch (Exception var12) {
               throw (Throwable)(new RuntimeException((Throwable)var12));
            }

            Unsafe var9 = var18;
            var5 = false;

            try {
               f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv$iv.setAccessible(true);
               var19 = f$iv$iv.get((Object)null);
               if (var19 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var18 = (Unsafe)var19;
            } catch (Exception var13) {
               throw (Throwable)(new RuntimeException((Throwable)var13));
            }

            var9.putObjectVolatile(cls$iv, var18.staticFieldOffset(logger$iv), (Object)null);
         } catch (Throwable var14) {
         }

         Method var20 = getFindNative();
         if (var20 == null) {
            Intrinsics.throwNpe();
         }

         var20.setAccessible(true);
      }
   }

   static {
      StructDissasembler var0 = new StructDissasembler();
      INSTANCE = var0;
   }

   @JvmStatic
   public static int disassembleStruct() {
      boolean var0 = false;

      try {
         int $i$f$setupIntrospection = false;
         boolean var2 = false;
         String vmName$iv$iv = System.getProperty("os.name");
         boolean var4 = false;
         if (vmName$iv$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         } else {
            String os$iv$iv = vmName$iv$iv.toLowerCase();
            ClassLoader var10000;
            if (StringsKt.contains$default((CharSequence)os$iv$iv, (CharSequence)"windows", false, 2, (Object)null)) {
               vmName$iv$iv = System.getProperty("java.vm.name");
               String dll$iv$iv = StringsKt.contains$default((CharSequence)vmName$iv$iv, (CharSequence)"Client VM", false, 2, (Object)null) ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

               try {
                  System.load(System.getProperty("java.home") + dll$iv$iv);
               } catch (UnsatisfiedLinkError var15) {
                  throw (Throwable)(new RuntimeException((Throwable)var15));
               }

               var10000 = StructDissasembler.class.getClassLoader();
            } else {
               var10000 = null;
            }

            setClassLoader(var10000);
            setFindNative(ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class));

            Object var34;
            try {
               Class cls$iv$iv = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.module.IllegalAccessLogger");
               Field logger$iv$iv = cls$iv$iv.getDeclaredField("logger");
               boolean var6 = false;

               Field f$iv$iv$iv;
               Unsafe var33;
               try {
                  f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                  f$iv$iv$iv.setAccessible(true);
                  var34 = f$iv$iv$iv.get((Object)null);
                  if (var34 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                  }

                  var33 = (Unsafe)var34;
               } catch (Exception var19) {
                  throw (Throwable)(new RuntimeException((Throwable)var19));
               }

               Unsafe var10 = var33;
               var6 = false;

               try {
                  f$iv$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                  f$iv$iv$iv.setAccessible(true);
                  var34 = f$iv$iv$iv.get((Object)null);
                  if (var34 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                  }

                  var33 = (Unsafe)var34;
               } catch (Exception var18) {
                  throw (Throwable)(new RuntimeException((Throwable)var18));
               }

               var10.putObjectVolatile(cls$iv$iv, var33.staticFieldOffset(logger$iv$iv), (Object)null);
            } catch (Throwable var20) {
            }

            Method var35 = getFindNative();
            if (var35 == null) {
               Intrinsics.throwNpe();
            }

            var35.setAccessible(true);
            $i$f$setupIntrospection = false;

            Unsafe var25;
            try {
               Field f$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv.setAccessible(true);
               var34 = f$iv.get((Object)null);
               if (var34 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var25 = (Unsafe)var34;
            } catch (Exception var17) {
               throw (Throwable)(new RuntimeException((Throwable)var17));
            }

            String symbol$iv = "gHotSpotVMStructs";
            Unsafe var12 = var25;
            var2 = false;
            var35 = getFindNative();
            if (var35 == null) {
               Intrinsics.throwNpe();
            }

            var34 = var35.invoke((Object)null, getClassLoader(), symbol$iv);
            if (var34 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
            } else {
               long address$iv = (Long)var34;
               if (address$iv == ((long)-470037659 ^ -470037659L)) {
                  throw (Throwable)(new NoSuchElementException(symbol$iv));
               } else {
                  boolean var30 = false;

                  Unsafe var32;
                  try {
                     Field f$iv$iv = Unsafe.class.getDeclaredField("theUnsafe");
                     f$iv$iv.setAccessible(true);
                     var34 = f$iv$iv.get((Object)null);
                     if (var34 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
                     }

                     var32 = (Unsafe)var34;
                  } catch (Exception var16) {
                     throw (Throwable)(new RuntimeException((Throwable)var16));
                  }

                  long var13 = var32.getLong(address$iv);
                  var12.putLong(var13, (long)1904633367 ^ 1904633367L);
                  return 1;
               }
            }
         }
      } catch (NoSuchElementException var21) {
         return 1;
      } catch (Throwable var22) {
         return 0;
      }
   }

   @Nullable
   public static Method getFindNative() {
      return findNative;
   }

   public static void setClassLoader(@Nullable ClassLoader var0) {
      classLoader = var0;
   }

   /** @deprecated */
   @JvmStatic
   public static void findNative$annotations() {
   }

   @JvmStatic
   public static long getSymbol(@NotNull String symbol) {
      int $i$f$getSymbol = false;
      Method var10000 = getFindNative();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Object var9 = var10000.invoke((Object)null, getClassLoader(), symbol);
      if (var9 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      } else {
         long address = (Long)var9;
         if (address == ((long)-1459845692 ^ -1459845692L)) {
            throw (Throwable)(new NoSuchElementException(symbol));
         } else {
            boolean var4 = false;

            Unsafe var8;
            try {
               Field f$iv = Unsafe.class.getDeclaredField("theUnsafe");
               f$iv.setAccessible(true);
               var9 = f$iv.get((Object)null);
               if (var9 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
               }

               var8 = (Unsafe)var9;
            } catch (Exception var7) {
               throw (Throwable)(new RuntimeException((Throwable)var7));
            }

            return var8.getLong(address);
         }
      }
   }

   /** @deprecated */
   @JvmStatic
   public static void classLoader$annotations() {
   }

   /** @deprecated */
   @JvmStatic
   public static void unsafe$annotations() {
   }

   @Nullable
   public static ClassLoader getClassLoader() {
      return classLoader;
   }
}
