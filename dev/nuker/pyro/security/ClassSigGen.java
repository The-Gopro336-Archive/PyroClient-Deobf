/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import sun.misc.SharedSecrets;

public class ClassSigGen {
   public static ClassSigGen INSTANCE;

   @NotNull
   public String getDescriptor(@NotNull String name) {
      boolean var2 = false;
      String var10000;
      switch(name.hashCode()) {
      case -1325958191:
         if (name.equals("double")) {
            var10000 = "D";
            return var10000;
         }
         break;
      case 104431:
         if (name.equals("int")) {
            var10000 = "I";
            return var10000;
         }
         break;
      case 3039496:
         if (name.equals("byte")) {
            var10000 = "B";
            return var10000;
         }
         break;
      case 3625364:
         if (name.equals("void")) {
            var10000 = "V";
            return var10000;
         }
         break;
      case 64711720:
         if (name.equals("boolean")) {
            var10000 = "Z";
            return var10000;
         }
         break;
      case 97526364:
         if (name.equals("float")) {
            var10000 = "F";
            return var10000;
         }
      }

      var10000 = StringsKt.startsWith$default(name, "[", false, 2, (Object)null) ? StringsKt.replace$default(name, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name, ".", "/", false, 4, (Object)null) + ';';
      return var10000;
   }

   @NotNull
   public MessageDigest getCombinedChecksum(@NotNull Class... classes) {
      int $i$f$getCombinedChecksum = false;
      MessageDigest hash = MessageDigest.getInstance("MD5");
      boolean $i$f$forEach = false;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      boolean var8 = false;
      Class[] var9 = classes;
      int var10 = classes.length;

      boolean var18;
      for(int var11 = 0; var11 < var10; ++var11) {
         Class var12 = var9[var11];
         boolean var14 = false;
         boolean var15 = false;
         boolean var16 = false;
         List data$iv = (List)(new ArrayList());
         Field[] var52 = var12.getDeclaredFields();
         var18 = false;
         Field[] var19 = var52;
         int var20 = var52.length;

         int var21;
         boolean var24;
         for(var21 = 0; var21 < var20; ++var21) {
            Object element$iv$iv = var19[var21];
            var24 = false;
            data$iv.add(element$iv$iv.getType().getName());
            data$iv.add(element$iv$iv.getName());
         }

         Method[] var54 = var12.getDeclaredMethods();
         var18 = false;
         Method[] var57 = var54;
         var20 = var54.length;

         boolean var27;
         Collection destination$iv$iv$iv;
         boolean var30;
         int var32;
         int var33;
         List var36;
         boolean var37;
         String var38;
         for(var21 = 0; var21 < var20; ++var21) {
            Method var60 = var57[var21];
            var24 = false;
            data$iv.add(String.valueOf(var60.getModifiers()));
            data$iv.add(var60.getName());
            data$iv.add(String.valueOf(var60.getParameterCount()));
            Class[] var25 = var60.getParameterTypes();
            var27 = false;
            destination$iv$iv$iv = (Collection)(new ArrayList(var25.length));
            var30 = false;
            Class[] var31 = var25;
            var32 = var25.length;

            for(var33 = 0; var33 < var32; ++var33) {
               Object item$iv$iv$iv = var31[var33];
               var37 = false;
               var38 = item$iv$iv$iv.getName();
               destination$iv$iv$iv.add(var38);
            }

            var36 = (List)destination$iv$iv$iv;
            data$iv.addAll((Collection)var36);
         }

         data$iv.add(var12.getSimpleName());
         data$iv.add(String.valueOf(SharedSecrets.getJavaLangAccess().getConstantPool(var12).getSize()));
         data$iv.addAll((Collection)INSTANCE.recursiveMashupCall(var12.getDeclaredClasses()));
         Constructor[] var55 = var12.getConstructors();
         var18 = false;
         Constructor[] var58 = var55;
         var20 = var55.length;

         for(var21 = 0; var21 < var20; ++var21) {
            Constructor var61 = var58[var21];
            var24 = false;
            data$iv.add(String.valueOf(var61.getModifiers()));
            Parameter[] var64 = var61.getParameters();
            var27 = false;
            destination$iv$iv$iv = (Collection)(new ArrayList(var64.length));
            var30 = false;
            Parameter[] var65 = var64;
            var32 = var64.length;

            for(var33 = 0; var33 < var32; ++var33) {
               Object item$iv$iv$iv = var65[var33];
               var37 = false;
               var38 = item$iv$iv$iv.getName();
               destination$iv$iv$iv.add(var38);
            }

            var36 = (List)destination$iv$iv$iv;
            data$iv.addAll((Collection)var36);
            data$iv.add(String.valueOf(var61.getParameterCount()));
         }

         Iterable list$iv$iv = (Iterable)data$iv;
         CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
      }

      Iterable $this$forEach$iv = (Iterable)((List)destination$iv$iv);
      $i$f$forEach = false;
      Iterator var6 = $this$forEach$iv.iterator();

      boolean var49;
      while(var6.hasNext()) {
         Object var41 = var6.next();
         String it = (String)var41;
         boolean var45 = false;
         Charset var48 = Charsets.UTF_8;
         var49 = false;
         if (it == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         byte[] var50 = it.getBytes(var48);
         hash.update(var50);
      }

      $i$f$forEach = false;
      Class[] var40 = classes;
      int var42 = classes.length;

      for(int var44 = 0; var44 < var42; ++var44) {
         Object element$iv = var40[var44];
         boolean var47 = false;
         var49 = false;
         InputStream var10000 = element$iv.getClassLoader().getResourceAsStream(StringsKt.replace$default(element$iv.getName(), ".", "/", false, 4, (Object)null) + ".class");
         if (var10000 == null) {
            Field var51 = LaunchClassLoader.class.getDeclaredField("resourceCache");
            boolean var56 = false;
            var18 = false;
            boolean var59 = false;
            var51.setAccessible(true);
            Object var53 = var51.get(Launch.classLoader);
            if (var53 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
            }

            Map var63 = (Map)var53;
            byte[] var39 = (byte[])var63.get(element$iv.getName());
            var10000 = (InputStream)(new ByteArrayInputStream(var39));
         }

         byte[] var62 = IOUtils.toByteArray(var10000);
         hash.update(var62);
      }

      return hash;
   }

   @JvmStatic
   @NotNull
   public static List getReflectMashup(@NotNull Class clazz) {
      int $i$f$getReflectMashup = false;
      boolean var3 = false;
      List data = (List)(new ArrayList());
      Field[] var25 = clazz.getDeclaredFields();
      boolean var4 = false;
      Field[] var5 = var25;
      int var6 = var25.length;

      int var7;
      boolean var10;
      for(var7 = 0; var7 < var6; ++var7) {
         Field var8 = var5[var7];
         var10 = false;
         data.add(var8.getType().getName());
         data.add(var8.getName());
      }

      Method[] var26 = clazz.getDeclaredMethods();
      var4 = false;
      Method[] var28 = var26;
      var6 = var26.length;

      boolean var13;
      Collection destination$iv$iv;
      boolean var16;
      int var18;
      int var19;
      List var22;
      boolean var23;
      String var24;
      for(var7 = 0; var7 < var6; ++var7) {
         Method var30 = var28[var7];
         var10 = false;
         data.add(String.valueOf(var30.getModifiers()));
         data.add(var30.getName());
         data.add(String.valueOf(var30.getParameterCount()));
         Class[] var11 = var30.getParameterTypes();
         var13 = false;
         destination$iv$iv = (Collection)(new ArrayList(var11.length));
         var16 = false;
         Class[] var17 = var11;
         var18 = var11.length;

         for(var19 = 0; var19 < var18; ++var19) {
            Class item$iv$iv = var17[var19];
            var23 = false;
            var24 = item$iv$iv.getName();
            destination$iv$iv.add(var24);
         }

         var22 = (List)destination$iv$iv;
         data.addAll((Collection)var22);
      }

      data.add(clazz.getSimpleName());
      data.add(String.valueOf(SharedSecrets.getJavaLangAccess().getConstantPool(clazz).getSize()));
      data.addAll((Collection)INSTANCE.recursiveMashupCall(clazz.getDeclaredClasses()));
      Constructor[] var27 = clazz.getConstructors();
      var4 = false;
      Constructor[] var29 = var27;
      var6 = var27.length;

      for(var7 = 0; var7 < var6; ++var7) {
         Object element$iv = var29[var7];
         var10 = false;
         data.add(String.valueOf(element$iv.getModifiers()));
         Parameter[] var32 = element$iv.getParameters();
         var13 = false;
         destination$iv$iv = (Collection)(new ArrayList(var32.length));
         var16 = false;
         Parameter[] var33 = var32;
         var18 = var32.length;

         for(var19 = 0; var19 < var18; ++var19) {
            Parameter item$iv$iv = var33[var19];
            var23 = false;
            var24 = item$iv$iv.getName();
            destination$iv$iv.add(var24);
         }

         var22 = (List)destination$iv$iv;
         data.addAll((Collection)var22);
         data.add(String.valueOf(element$iv.getParameterCount()));
      }

      return data;
   }

   @NotNull
   public MessageDigest getCombinedChecksum2(@NotNull Class... classes) {
      boolean var2 = false;
      MessageDigest hash = MessageDigest.getInstance("MD5");
      boolean var5 = false;
      Class[] var6 = classes;
      int var7 = classes.length;

      int var8;
      Class var9;
      boolean var11;
      boolean var18;
      boolean var20;
      for(var8 = 0; var8 < var7; ++var8) {
         var9 = var6[var8];
         var11 = false;
         ClassSigGen var12 = INSTANCE;
         boolean var14 = false;
         MessageDigest hash$iv = MessageDigest.getInstance("MD5");
         var18 = false;
         List var19 = (List)(new ArrayList());
         List methods$iv = var19;
         var20 = false;
         var19 = (List)(new ArrayList());
         List fields$iv = var19;
         Field[] var49 = var9.getDeclaredFields();
         boolean var21 = false;
         Field[] var22 = var49;
         int var23 = var49.length;

         String var10000;
         StringBuilder var10001;
         int var24;
         boolean var27;
         ClassSigGen var28;
         boolean var32;
         for(var24 = 0; var24 < var23; ++var24) {
            StringBuilder var30;
            label1061: {
               Field var25 = var22[var24];
               var27 = false;
               var10001 = (new StringBuilder()).append(var25.getModifiers()).append(' ').append(var25.getName()).append(' ');
               var28 = INSTANCE;
               String name$iv$iv = var25.getType().getName();
               var30 = var10001;
               var32 = false;
               switch(name$iv$iv.hashCode()) {
               case -1325958191:
                  if (name$iv$iv.equals("double")) {
                     var10000 = "D";
                     break label1061;
                  }
                  break;
               case 104431:
                  if (name$iv$iv.equals("int")) {
                     var10000 = "I";
                     break label1061;
                  }
                  break;
               case 3039496:
                  if (name$iv$iv.equals("byte")) {
                     var10000 = "B";
                     break label1061;
                  }
                  break;
               case 3625364:
                  if (name$iv$iv.equals("void")) {
                     var10000 = "V";
                     break label1061;
                  }
                  break;
               case 64711720:
                  if (name$iv$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label1061;
                  }
                  break;
               case 97526364:
                  if (name$iv$iv.equals("float")) {
                     var10000 = "F";
                     break label1061;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var34 = var10000;
            fields$iv.add(var30.append(var34).toString());
         }

         Method[] var50 = var9.getDeclaredMethods();
         var21 = false;
         Method[] var52 = var50;
         var23 = var50.length;

         for(var24 = 0; var24 < var23; ++var24) {
            Method var57 = var52[var24];
            var27 = false;
            var10001 = (new StringBuilder()).append(var57.getName()).append(" (");
            Parameter[] var60 = var57.getParameters();
            StringBuilder var62 = var10001;
            boolean var31 = false;
            Collection destination$iv$iv$iv = (Collection)(new ArrayList(var60.length));
            boolean var67 = false;
            Parameter[] var35 = var60;
            int var36 = var60.length;

            for(int var37 = 0; var37 < var36; ++var37) {
               Object item$iv$iv$iv = var35[var37];
               boolean var41 = false;
               Class var42 = item$iv$iv$iv.getType();
               destination$iv$iv$iv.add(var42);
            }

            List var40 = (List)destination$iv$iv$iv;
            Iterable $this$map$iv$iv = (Iterable)var40;
            var31 = false;
            destination$iv$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10)));
            var67 = false;
            Iterator var68 = $this$map$iv$iv.iterator();

            while(var68.hasNext()) {
               label1088: {
                  Object var69 = var68.next();
                  Class it$iv = (Class)var69;
                  boolean var71 = false;
                  ClassSigGen var39 = INSTANCE;
                  String name$iv$iv = it$iv.getName();
                  boolean var43 = false;
                  switch(name$iv$iv.hashCode()) {
                  case -1325958191:
                     if (name$iv$iv.equals("double")) {
                        var10000 = "D";
                        break label1088;
                     }
                     break;
                  case 104431:
                     if (name$iv$iv.equals("int")) {
                        var10000 = "I";
                        break label1088;
                     }
                     break;
                  case 3039496:
                     if (name$iv$iv.equals("byte")) {
                        var10000 = "B";
                        break label1088;
                     }
                     break;
                  case 3625364:
                     if (name$iv$iv.equals("void")) {
                        var10000 = "V";
                        break label1088;
                     }
                     break;
                  case 64711720:
                     if (name$iv$iv.equals("boolean")) {
                        var10000 = "Z";
                        break label1088;
                     }
                     break;
                  case 97526364:
                     if (name$iv$iv.equals("float")) {
                        var10000 = "F";
                        break label1088;
                     }
                  }

                  var10000 = StringsKt.startsWith$default(name$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv, ".", "/", false, 4, (Object)null) + ';';
               }

               String var74 = var10000;
               destination$iv$iv$iv.add(var74);
            }

            label1103: {
               var40 = (List)destination$iv$iv$iv;
               var10001 = var62.append(CollectionsKt.joinToString$default((Iterable)var40, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null)).append(')');
               var28 = INSTANCE;
               String name$iv$iv = var57.getReturnType().getName();
               var62 = var10001;
               var32 = false;
               switch(name$iv$iv.hashCode()) {
               case -1325958191:
                  if (name$iv$iv.equals("double")) {
                     var10000 = "D";
                     break label1103;
                  }
                  break;
               case 104431:
                  if (name$iv$iv.equals("int")) {
                     var10000 = "I";
                     break label1103;
                  }
                  break;
               case 3039496:
                  if (name$iv$iv.equals("byte")) {
                     var10000 = "B";
                     break label1103;
                  }
                  break;
               case 3625364:
                  if (name$iv$iv.equals("void")) {
                     var10000 = "V";
                     break label1103;
                  }
                  break;
               case 64711720:
                  if (name$iv$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label1103;
                  }
                  break;
               case 97526364:
                  if (name$iv$iv.equals("float")) {
                     var10000 = "F";
                     break label1103;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var72 = var10000;
            methods$iv.add(var62.append(var72).toString());
         }

         Iterable $this$forEach$iv$iv = (Iterable)CollectionsKt.sortedWith((Iterable)fields$iv, (Comparator)ClassSigGen$getClassChecksum2$3.INSTANCE);
         var21 = false;
         Iterator var54 = $this$forEach$iv$iv.iterator();

         Object var56;
         String it$iv;
         boolean var59;
         Charset var63;
         boolean var64;
         byte[] var65;
         while(var54.hasNext()) {
            var56 = var54.next();
            it$iv = (String)var56;
            var59 = false;
            var63 = Charsets.UTF_8;
            var64 = false;
            if (it$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            var65 = it$iv.getBytes(var63);
            hash$iv.update(var65);
         }

         $this$forEach$iv$iv = (Iterable)CollectionsKt.sortedWith((Iterable)methods$iv, (Comparator)ClassSigGen$getClassChecksum2$5.INSTANCE);
         var21 = false;
         var54 = $this$forEach$iv$iv.iterator();

         while(var54.hasNext()) {
            var56 = var54.next();
            it$iv = (String)var56;
            var59 = false;
            var63 = Charsets.UTF_8;
            var64 = false;
            if (it$iv == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            var65 = it$iv.getBytes(var63);
            hash$iv.update(var65);
         }

         hash.update(hash$iv.digest());
      }

      var5 = false;
      var6 = classes;
      var7 = classes.length;

      for(var8 = 0; var8 < var7; ++var8) {
         var9 = var6[var8];
         var11 = false;
         boolean var13 = false;
         InputStream var75 = var9.getClassLoader().getResourceAsStream(StringsKt.replace$default(var9.getName(), ".", "/", false, 4, (Object)null) + ".class");
         if (var75 == null) {
            Field var47 = LaunchClassLoader.class.getDeclaredField("resourceCache");
            boolean var17 = false;
            var18 = false;
            var20 = false;
            var47.setAccessible(true);
            Object var76 = var47.get(Launch.classLoader);
            if (var76 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
            }

            Map var53 = (Map)var76;
            byte[] var46 = (byte[])var53.get(var9.getName());
            var75 = (InputStream)(new ByteArrayInputStream(var46));
         }

         byte[] var55 = IOUtils.toByteArray(var75);
         hash.update(var55);
      }

      return hash;
   }

   @NotNull
   public List recursiveMashupCall(@NotNull Class[] classes) {
      boolean var3 = false;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      boolean var6 = false;
      Class[] var7 = classes;
      int var8 = classes.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         Object element$iv$iv = var7[var9];
         boolean var12 = false;
         boolean var13 = false;
         boolean var14 = false;
         List data$iv = (List)(new ArrayList());
         Field[] var37 = element$iv$iv.getDeclaredFields();
         boolean var16 = false;
         Field[] var17 = var37;
         int var18 = var37.length;

         int var19;
         boolean var22;
         for(var19 = 0; var19 < var18; ++var19) {
            Object element$iv$iv = var17[var19];
            var22 = false;
            data$iv.add(element$iv$iv.getType().getName());
            data$iv.add(element$iv$iv.getName());
         }

         Method[] $this$forEach$iv$iv = element$iv$iv.getDeclaredMethods();
         var16 = false;
         Method[] var40 = $this$forEach$iv$iv;
         var18 = $this$forEach$iv$iv.length;

         boolean var25;
         Collection destination$iv$iv$iv;
         boolean var28;
         int var30;
         int var31;
         List var34;
         boolean var35;
         String var36;
         for(var19 = 0; var19 < var18; ++var19) {
            Method var42 = var40[var19];
            var22 = false;
            data$iv.add(String.valueOf(var42.getModifiers()));
            data$iv.add(var42.getName());
            data$iv.add(String.valueOf(var42.getParameterCount()));
            Class[] var23 = var42.getParameterTypes();
            var25 = false;
            destination$iv$iv$iv = (Collection)(new ArrayList(var23.length));
            var28 = false;
            Class[] var29 = var23;
            var30 = var23.length;

            for(var31 = 0; var31 < var30; ++var31) {
               Class item$iv$iv$iv = var29[var31];
               var35 = false;
               var36 = item$iv$iv$iv.getName();
               destination$iv$iv$iv.add(var36);
            }

            var34 = (List)destination$iv$iv$iv;
            data$iv.addAll((Collection)var34);
         }

         data$iv.add(element$iv$iv.getSimpleName());
         data$iv.add(String.valueOf(SharedSecrets.getJavaLangAccess().getConstantPool(element$iv$iv).getSize()));
         data$iv.addAll((Collection)INSTANCE.recursiveMashupCall(element$iv$iv.getDeclaredClasses()));
         Constructor[] var39 = element$iv$iv.getConstructors();
         var16 = false;
         Constructor[] var41 = var39;
         var18 = var39.length;

         for(var19 = 0; var19 < var18; ++var19) {
            Object element$iv$iv = var41[var19];
            var22 = false;
            data$iv.add(String.valueOf(element$iv$iv.getModifiers()));
            Parameter[] var44 = element$iv$iv.getParameters();
            var25 = false;
            destination$iv$iv$iv = (Collection)(new ArrayList(var44.length));
            var28 = false;
            Parameter[] var45 = var44;
            var30 = var44.length;

            for(var31 = 0; var31 < var30; ++var31) {
               Object item$iv$iv$iv = var45[var31];
               var35 = false;
               var36 = item$iv$iv$iv.getName();
               destination$iv$iv$iv.add(var36);
            }

            var34 = (List)destination$iv$iv$iv;
            data$iv.addAll((Collection)var34);
            data$iv.add(String.valueOf(element$iv$iv.getParameterCount()));
         }

         Iterable list$iv$iv = (Iterable)data$iv;
         CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
      }

      return (List)destination$iv$iv;
   }

   static {
      ClassSigGen var0 = new ClassSigGen();
      INSTANCE = var0;
   }

   @NotNull
   public MessageDigest getChecksum(@NotNull Class clazz) {
      int $i$f$getChecksum = false;
      MessageDigest hash = MessageDigest.getInstance("MD5");
      boolean var4 = false;
      boolean $i$f$forEach = false;
      List data$iv = (List)(new ArrayList());
      Field[] var32 = clazz.getDeclaredFields();
      boolean var7 = false;
      Field[] var8 = var32;
      int var9 = var32.length;

      int var10;
      boolean var13;
      for(var10 = 0; var10 < var9; ++var10) {
         Field var11 = var8[var10];
         var13 = false;
         data$iv.add(var11.getType().getName());
         data$iv.add(var11.getName());
      }

      Method[] var33 = clazz.getDeclaredMethods();
      var7 = false;
      Method[] var38 = var33;
      var9 = var33.length;

      boolean var16;
      Collection destination$iv$iv$iv;
      boolean var19;
      int var21;
      int var22;
      List var25;
      boolean var26;
      String var27;
      for(var10 = 0; var10 < var9; ++var10) {
         Method var43 = var38[var10];
         var13 = false;
         data$iv.add(String.valueOf(var43.getModifiers()));
         data$iv.add(var43.getName());
         data$iv.add(String.valueOf(var43.getParameterCount()));
         Class[] var14 = var43.getParameterTypes();
         var16 = false;
         destination$iv$iv$iv = (Collection)(new ArrayList(var14.length));
         var19 = false;
         Class[] var20 = var14;
         var21 = var14.length;

         for(var22 = 0; var22 < var21; ++var22) {
            Object item$iv$iv$iv = var20[var22];
            var26 = false;
            var27 = item$iv$iv$iv.getName();
            destination$iv$iv$iv.add(var27);
         }

         var25 = (List)destination$iv$iv$iv;
         data$iv.addAll((Collection)var25);
      }

      data$iv.add(clazz.getSimpleName());
      data$iv.add(String.valueOf(SharedSecrets.getJavaLangAccess().getConstantPool(clazz).getSize()));
      data$iv.addAll((Collection)INSTANCE.recursiveMashupCall(clazz.getDeclaredClasses()));
      Constructor[] var34 = clazz.getConstructors();
      var7 = false;
      Constructor[] var39 = var34;
      var9 = var34.length;

      for(var10 = 0; var10 < var9; ++var10) {
         Constructor var44 = var39[var10];
         var13 = false;
         data$iv.add(String.valueOf(var44.getModifiers()));
         Parameter[] var47 = var44.getParameters();
         var16 = false;
         destination$iv$iv$iv = (Collection)(new ArrayList(var47.length));
         var19 = false;
         Parameter[] var50 = var47;
         var21 = var47.length;

         for(var22 = 0; var22 < var21; ++var22) {
            Parameter item$iv$iv$iv = var50[var22];
            var26 = false;
            var27 = item$iv$iv$iv.getName();
            destination$iv$iv$iv.add(var27);
         }

         var25 = (List)destination$iv$iv$iv;
         data$iv.addAll((Collection)var25);
         data$iv.add(String.valueOf(var44.getParameterCount()));
      }

      Iterable $this$forEach$iv = (Iterable)data$iv;
      $i$f$forEach = false;
      Iterator var35 = $this$forEach$iv.iterator();

      boolean var42;
      while(var35.hasNext()) {
         Object var37 = var35.next();
         String var40 = (String)var37;
         var42 = false;
         Charset var12 = Charsets.UTF_8;
         var13 = false;
         if (var40 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         byte[] var48 = var40.getBytes(var12);
         hash.update(var48);
      }

      var4 = false;
      InputStream var10000 = clazz.getClassLoader().getResourceAsStream(StringsKt.replace$default(clazz.getName(), ".", "/", false, 4, (Object)null) + ".class");
      if (var10000 == null) {
         Field var36 = LaunchClassLoader.class.getDeclaredField("resourceCache");
         boolean var41 = false;
         var42 = false;
         boolean var45 = false;
         var36.setAccessible(true);
         Object var49 = var36.get(Launch.classLoader);
         if (var49 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
         }

         Map var46 = (Map)var49;
         byte[] var30 = (byte[])var46.get(clazz.getName());
         var10000 = (InputStream)(new ByteArrayInputStream(var30));
      }

      byte[] var29 = IOUtils.toByteArray(var10000);
      hash.digest(var29);
      return hash;
   }

   @NotNull
   public MessageDigest getClassChecksum2(@NotNull Class clazz) {
      int $i$f$getClassChecksum2 = false;
      MessageDigest hash = MessageDigest.getInstance("MD5");
      boolean var5 = false;
      List var31 = (List)(new ArrayList());
      List methods = var31;
      boolean var6 = false;
      var31 = (List)(new ArrayList());
      List fields = var31;
      Field[] var33 = clazz.getDeclaredFields();
      boolean var7 = false;
      Field[] var8 = var33;
      int var9 = var33.length;

      int var10;
      boolean var13;
      ClassSigGen var14;
      String var10000;
      StringBuilder var10001;
      boolean var18;
      for(var10 = 0; var10 < var9; ++var10) {
         StringBuilder var16;
         label913: {
            Object element$iv = var8[var10];
            var13 = false;
            var10001 = (new StringBuilder()).append(element$iv.getModifiers()).append(' ').append(element$iv.getName()).append(' ');
            var14 = INSTANCE;
            String name$iv = element$iv.getType().getName();
            var16 = var10001;
            var18 = false;
            switch(name$iv.hashCode()) {
            case -1325958191:
               if (name$iv.equals("double")) {
                  var10000 = "D";
                  break label913;
               }
               break;
            case 104431:
               if (name$iv.equals("int")) {
                  var10000 = "I";
                  break label913;
               }
               break;
            case 3039496:
               if (name$iv.equals("byte")) {
                  var10000 = "B";
                  break label913;
               }
               break;
            case 3625364:
               if (name$iv.equals("void")) {
                  var10000 = "V";
                  break label913;
               }
               break;
            case 64711720:
               if (name$iv.equals("boolean")) {
                  var10000 = "Z";
                  break label913;
               }
               break;
            case 97526364:
               if (name$iv.equals("float")) {
                  var10000 = "F";
                  break label913;
               }
            }

            var10000 = StringsKt.startsWith$default(name$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv, ".", "/", false, 4, (Object)null) + ';';
         }

         String var20 = var10000;
         fields.add(var16.append(var20).toString());
      }

      Method[] $this$forEach$iv = clazz.getDeclaredMethods();
      var7 = false;
      Method[] var36 = $this$forEach$iv;
      var9 = $this$forEach$iv.length;

      for(var10 = 0; var10 < var9; ++var10) {
         Method var39 = var36[var10];
         var13 = false;
         var10001 = (new StringBuilder()).append(var39.getName()).append(" (");
         Parameter[] var42 = var39.getParameters();
         StringBuilder var44 = var10001;
         boolean var17 = false;
         Collection destination$iv$iv = (Collection)(new ArrayList(var42.length));
         boolean var49 = false;
         Parameter[] var21 = var42;
         int var22 = var42.length;

         for(int var23 = 0; var23 < var22; ++var23) {
            Object item$iv$iv = var21[var23];
            boolean var27 = false;
            Class var28 = item$iv$iv.getType();
            destination$iv$iv.add(var28);
         }

         List var26 = (List)destination$iv$iv;
         Iterable $this$map$iv = (Iterable)var26;
         var17 = false;
         destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
         var49 = false;
         Iterator var50 = $this$map$iv.iterator();

         while(var50.hasNext()) {
            label882: {
               Object var51 = var50.next();
               Class it = (Class)var51;
               boolean var53 = false;
               ClassSigGen var25 = INSTANCE;
               String name$iv = it.getName();
               boolean var29 = false;
               switch(name$iv.hashCode()) {
               case -1325958191:
                  if (name$iv.equals("double")) {
                     var10000 = "D";
                     break label882;
                  }
                  break;
               case 104431:
                  if (name$iv.equals("int")) {
                     var10000 = "I";
                     break label882;
                  }
                  break;
               case 3039496:
                  if (name$iv.equals("byte")) {
                     var10000 = "B";
                     break label882;
                  }
                  break;
               case 3625364:
                  if (name$iv.equals("void")) {
                     var10000 = "V";
                     break label882;
                  }
                  break;
               case 64711720:
                  if (name$iv.equals("boolean")) {
                     var10000 = "Z";
                     break label882;
                  }
                  break;
               case 97526364:
                  if (name$iv.equals("float")) {
                     var10000 = "F";
                     break label882;
                  }
               }

               var10000 = StringsKt.startsWith$default(name$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv, ".", "/", false, 4, (Object)null) + ';';
            }

            String var56 = var10000;
            destination$iv$iv.add(var56);
         }

         label897: {
            var26 = (List)destination$iv$iv;
            var10001 = var44.append(CollectionsKt.joinToString$default((Iterable)var26, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null)).append(')');
            var14 = INSTANCE;
            String name$iv = var39.getReturnType().getName();
            var44 = var10001;
            var18 = false;
            switch(name$iv.hashCode()) {
            case -1325958191:
               if (name$iv.equals("double")) {
                  var10000 = "D";
                  break label897;
               }
               break;
            case 104431:
               if (name$iv.equals("int")) {
                  var10000 = "I";
                  break label897;
               }
               break;
            case 3039496:
               if (name$iv.equals("byte")) {
                  var10000 = "B";
                  break label897;
               }
               break;
            case 3625364:
               if (name$iv.equals("void")) {
                  var10000 = "V";
                  break label897;
               }
               break;
            case 64711720:
               if (name$iv.equals("boolean")) {
                  var10000 = "Z";
                  break label897;
               }
               break;
            case 97526364:
               if (name$iv.equals("float")) {
                  var10000 = "F";
                  break label897;
               }
            }

            var10000 = StringsKt.startsWith$default(name$iv, "[", false, 2, (Object)null) ? StringsKt.replace$default(name$iv, ".", "/", false, 4, (Object)null) : 'L' + StringsKt.replace$default(name$iv, ".", "/", false, 4, (Object)null) + ';';
         }

         String var54 = var10000;
         methods.add(var44.append(var54).toString());
      }

      Iterable var35 = (Iterable)CollectionsKt.sortedWith((Iterable)fields, (Comparator)ClassSigGen$getClassChecksum2$3.INSTANCE);
      var7 = false;
      Iterator var37 = var35.iterator();

      Object var38;
      String it;
      boolean var41;
      Charset var45;
      boolean var46;
      byte[] var47;
      while(var37.hasNext()) {
         var38 = var37.next();
         it = (String)var38;
         var41 = false;
         var45 = Charsets.UTF_8;
         var46 = false;
         if (it == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         var47 = it.getBytes(var45);
         hash.update(var47);
      }

      var35 = (Iterable)CollectionsKt.sortedWith((Iterable)methods, (Comparator)ClassSigGen$getClassChecksum2$5.INSTANCE);
      var7 = false;
      var37 = var35.iterator();

      while(var37.hasNext()) {
         var38 = var37.next();
         it = (String)var38;
         var41 = false;
         var45 = Charsets.UTF_8;
         var46 = false;
         if (it == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         var47 = it.getBytes(var45);
         hash.update(var47);
      }

      return hash;
   }

   @JvmStatic
   public static byte[] getClassBytes(@NotNull Class clazz) {
      int $i$f$getClassBytes = false;
      InputStream var10000 = clazz.getClassLoader().getResourceAsStream(StringsKt.replace$default(clazz.getName(), ".", "/", false, 4, (Object)null) + ".class");
      if (var10000 == null) {
         Field var2 = LaunchClassLoader.class.getDeclaredField("resourceCache");
         boolean var3 = false;
         boolean var4 = false;
         boolean var6 = false;
         var2.setAccessible(true);
         Object var11 = var2.get(Launch.classLoader);
         if (var11 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.ByteArray?>");
         }

         Map var9 = (Map)var11;
         byte[] var10 = (byte[])var9.get(clazz.getName());
         var10000 = (InputStream)(new ByteArrayInputStream(var10));
      }

      return IOUtils.toByteArray(var10000);
   }
}
