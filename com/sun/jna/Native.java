package com.sun.jna;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Window;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public final class Native implements Version {
   public static final String DEFAULT_ENCODING = Charset.defaultCharset().name();
   public static boolean DEBUG_LOAD = Boolean.getBoolean("jna.debug_load");
   public static boolean DEBUG_JNA_LOAD = Boolean.getBoolean("jna.debug_load.jna");
   static String jnidispatchPath = null;
   private static final Map typeOptions = new WeakHashMap();
   private static final Map libraries = new WeakHashMap();
   private static final String _OPTION_ENCLOSING_LIBRARY = "enclosing-library";
   private static final Callback.UncaughtExceptionHandler DEFAULT_HANDLER = new Callback.UncaughtExceptionHandler() {
      public void uncaughtException(Callback c, Throwable e) {
         System.err.println("JNA: Callback " + c + " threw the following exception:");
         e.printStackTrace();
      }
   };
   private static Callback.UncaughtExceptionHandler callbackExceptionHandler;
   public static final int POINTER_SIZE;
   public static final int LONG_SIZE;
   public static final int WCHAR_SIZE;
   public static final int SIZE_T_SIZE;
   public static final int BOOL_SIZE;
   private static final int TYPE_VOIDP = 0;
   private static final int TYPE_LONG = 1;
   private static final int TYPE_WCHAR_T = 2;
   private static final int TYPE_SIZE_T = 3;
   private static final int TYPE_BOOL = 4;
   static final int MAX_ALIGNMENT;
   static final int MAX_PADDING;
   private static final Object finalizer;
   static final String JNA_TMPLIB_PREFIX = "jna";
   private static Map registeredClasses;
   private static Map registeredLibraries;
   static final int CB_HAS_INITIALIZER = 1;
   private static final int CVT_UNSUPPORTED = -1;
   private static final int CVT_DEFAULT = 0;
   private static final int CVT_POINTER = 1;
   private static final int CVT_STRING = 2;
   private static final int CVT_STRUCTURE = 3;
   private static final int CVT_STRUCTURE_BYVAL = 4;
   private static final int CVT_BUFFER = 5;
   private static final int CVT_ARRAY_BYTE = 6;
   private static final int CVT_ARRAY_SHORT = 7;
   private static final int CVT_ARRAY_CHAR = 8;
   private static final int CVT_ARRAY_INT = 9;
   private static final int CVT_ARRAY_LONG = 10;
   private static final int CVT_ARRAY_FLOAT = 11;
   private static final int CVT_ARRAY_DOUBLE = 12;
   private static final int CVT_ARRAY_BOOLEAN = 13;
   private static final int CVT_BOOLEAN = 14;
   private static final int CVT_CALLBACK = 15;
   private static final int CVT_FLOAT = 16;
   private static final int CVT_NATIVE_MAPPED = 17;
   private static final int CVT_NATIVE_MAPPED_STRING = 18;
   private static final int CVT_NATIVE_MAPPED_WSTRING = 19;
   private static final int CVT_WSTRING = 20;
   private static final int CVT_INTEGER_TYPE = 21;
   private static final int CVT_POINTER_TYPE = 22;
   private static final int CVT_TYPE_MAPPER = 23;
   private static final int CVT_TYPE_MAPPER_STRING = 24;
   private static final int CVT_TYPE_MAPPER_WSTRING = 25;
   private static final int CVT_OBJECT = 26;
   private static final int CVT_JNIENV = 27;
   static final int CB_OPTION_DIRECT = 1;
   static final int CB_OPTION_IN_DLL = 2;
   private static final ThreadLocal nativeThreadTerminationFlag;
   private static final Map nativeThreads;

   /** @deprecated */
   @Deprecated
   public static float parseVersion(String v) {
      return Float.parseFloat(v.substring(0, v.lastIndexOf(".")));
   }

   static boolean isCompatibleVersion(String expectedVersion, String nativeVersion) {
      String[] expectedVersionParts = expectedVersion.split("\\.");
      String[] nativeVersionParts = nativeVersion.split("\\.");
      if (expectedVersionParts.length >= 3 && nativeVersionParts.length >= 3) {
         int expectedMajor = Integer.parseInt(expectedVersionParts[0]);
         int nativeMajor = Integer.parseInt(nativeVersionParts[0]);
         int expectedMinor = Integer.parseInt(expectedVersionParts[1]);
         int nativeMinor = Integer.parseInt(nativeVersionParts[1]);
         if (expectedMajor != nativeMajor) {
            return false;
         } else {
            return expectedMinor <= nativeMinor;
         }
      } else {
         return false;
      }
   }

   private static void dispose() {
      CallbackReference.disposeAll();
      Memory.disposeAll();
      NativeLibrary.disposeAll();
      unregisterAll();
      jnidispatchPath = null;
      System.setProperty("jna.loaded", "false");
   }

   static boolean deleteLibrary(File lib) {
      if (lib.delete()) {
         return true;
      } else {
         markTemporaryFile(lib);
         return false;
      }
   }

   private Native() {
   }

   private static native void initIDs();

   public static synchronized native void setProtected(boolean var0);

   public static synchronized native boolean isProtected();

   /** @deprecated */
   @Deprecated
   public static void setPreserveLastError(boolean enable) {
   }

   /** @deprecated */
   @Deprecated
   public static boolean getPreserveLastError() {
      return true;
   }

   public static long getWindowID(Window w) throws HeadlessException {
      return Native.AWT.getWindowID(w);
   }

   public static long getComponentID(Component c) throws HeadlessException {
      return Native.AWT.getComponentID(c);
   }

   public static Pointer getWindowPointer(Window w) throws HeadlessException {
      return new Pointer(Native.AWT.getWindowID(w));
   }

   public static Pointer getComponentPointer(Component c) throws HeadlessException {
      return new Pointer(Native.AWT.getComponentID(c));
   }

   static native long getWindowHandle0(Component var0);

   public static Pointer getDirectBufferPointer(Buffer b) {
      long peer = _getDirectBufferPointer(b);
      return peer == 0L ? null : new Pointer(peer);
   }

   private static native long _getDirectBufferPointer(Buffer var0);

   public static String toString(byte[] buf) {
      return toString(buf, getDefaultStringEncoding());
   }

   public static String toString(byte[] buf, String encoding) {
      int len = buf.length;

      for(int index = 0; index < len; ++index) {
         if (buf[index] == 0) {
            len = index;
            break;
         }
      }

      if (len == 0) {
         return "";
      } else {
         if (encoding != null) {
            try {
               return new String(buf, 0, len, encoding);
            } catch (UnsupportedEncodingException var4) {
               System.err.println("JNA Warning: Encoding '" + encoding + "' is unsupported");
            }
         }

         System.err.println("JNA Warning: Decoding with fallback " + System.getProperty("file.encoding"));
         return new String(buf, 0, len);
      }
   }

   public static String toString(char[] buf) {
      int len = buf.length;

      for(int index = 0; index < len; ++index) {
         if (buf[index] == 0) {
            len = index;
            break;
         }
      }

      return len == 0 ? "" : new String(buf, 0, len);
   }

   public static List toStringList(char[] buf) {
      return toStringList(buf, 0, buf.length);
   }

   public static List toStringList(char[] buf, int offset, int len) {
      List list = new ArrayList();
      int lastPos = offset;
      int maxPos = offset + len;

      for(int curPos = offset; curPos < maxPos; ++curPos) {
         if (buf[curPos] == 0) {
            if (lastPos == curPos) {
               return list;
            }

            String value = new String(buf, lastPos, curPos - lastPos);
            list.add(value);
            lastPos = curPos + 1;
         }
      }

      if (lastPos < maxPos) {
         String value = new String(buf, lastPos, maxPos - lastPos);
         list.add(value);
      }

      return list;
   }

   public static Object loadLibrary(Class interfaceClass) {
      return loadLibrary((String)null, (Class)interfaceClass);
   }

   public static Object loadLibrary(Class interfaceClass, Map options) {
      return loadLibrary((String)null, interfaceClass, options);
   }

   public static Object loadLibrary(String name, Class interfaceClass) {
      return loadLibrary(name, interfaceClass, Collections.emptyMap());
   }

   public static Object loadLibrary(String name, Class interfaceClass, Map options) {
      if (!Library.class.isAssignableFrom(interfaceClass)) {
         throw new IllegalArgumentException("Interface (" + interfaceClass.getSimpleName() + ") of library=" + name + " does not extend " + Library.class.getSimpleName());
      } else {
         Library.Handler handler = new Library.Handler(name, interfaceClass, options);
         ClassLoader loader = interfaceClass.getClassLoader();
         Object proxy = Proxy.newProxyInstance(loader, new Class[]{interfaceClass}, handler);
         cacheOptions(interfaceClass, options, proxy);
         return interfaceClass.cast(proxy);
      }
   }

   private static void loadLibraryInstance(Class cls) {
      synchronized(libraries) {
         if (cls != null && !libraries.containsKey(cls)) {
            try {
               Field[] fields = cls.getFields();

               for(int i = 0; i < fields.length; ++i) {
                  Field field = fields[i];
                  if (field.getType() == cls && Modifier.isStatic(field.getModifiers())) {
                     libraries.put(cls, new WeakReference(field.get((Object)null)));
                     break;
                  }
               }
            } catch (Exception var6) {
               throw new IllegalArgumentException("Could not access instance of " + cls + " (" + var6 + ")");
            }
         }

      }
   }

   static Class findEnclosingLibraryClass(Class cls) {
      if (cls == null) {
         return null;
      } else {
         synchronized(libraries) {
            if (typeOptions.containsKey(cls)) {
               Map libOptions = (Map)typeOptions.get(cls);
               Class enclosingClass = (Class)libOptions.get("enclosing-library");
               if (enclosingClass != null) {
                  return enclosingClass;
               }

               return cls;
            }
         }

         if (Library.class.isAssignableFrom(cls)) {
            return cls;
         } else {
            if (Callback.class.isAssignableFrom(cls)) {
               cls = CallbackReference.findCallbackClass(cls);
            }

            Class declaring = cls.getDeclaringClass();
            Class fromDeclaring = findEnclosingLibraryClass(declaring);
            return fromDeclaring != null ? fromDeclaring : findEnclosingLibraryClass(cls.getSuperclass());
         }
      }
   }

   public static Map getLibraryOptions(Class type) {
      Map libraryOptions;
      synchronized(libraries) {
         libraryOptions = (Map)typeOptions.get(type);
         if (libraryOptions != null) {
            return libraryOptions;
         }
      }

      Class mappingClass = findEnclosingLibraryClass(type);
      if (mappingClass != null) {
         loadLibraryInstance(mappingClass);
      } else {
         mappingClass = type;
      }

      synchronized(libraries) {
         libraryOptions = (Map)typeOptions.get(mappingClass);
         if (libraryOptions != null) {
            typeOptions.put(type, libraryOptions);
            return libraryOptions;
         } else {
            try {
               Field field = mappingClass.getField("OPTIONS");
               field.setAccessible(true);
               libraryOptions = (Map)field.get((Object)null);
               if (libraryOptions == null) {
                  throw new IllegalStateException("Null options field");
               }
            } catch (NoSuchFieldException var6) {
               libraryOptions = Collections.emptyMap();
            } catch (Exception var7) {
               throw new IllegalArgumentException("OPTIONS must be a public field of type java.util.Map (" + var7 + "): " + mappingClass);
            }

            Map libraryOptions = new HashMap(libraryOptions);
            if (!libraryOptions.containsKey("type-mapper")) {
               libraryOptions.put("type-mapper", lookupField(mappingClass, "TYPE_MAPPER", TypeMapper.class));
            }

            if (!libraryOptions.containsKey("structure-alignment")) {
               libraryOptions.put("structure-alignment", lookupField(mappingClass, "STRUCTURE_ALIGNMENT", Integer.class));
            }

            if (!libraryOptions.containsKey("string-encoding")) {
               libraryOptions.put("string-encoding", lookupField(mappingClass, "STRING_ENCODING", String.class));
            }

            libraryOptions = cacheOptions(mappingClass, libraryOptions, (Object)null);
            if (type != mappingClass) {
               typeOptions.put(type, libraryOptions);
            }

            return libraryOptions;
         }
      }
   }

   private static Object lookupField(Class mappingClass, String fieldName, Class resultClass) {
      try {
         Field field = mappingClass.getField(fieldName);
         field.setAccessible(true);
         return field.get((Object)null);
      } catch (NoSuchFieldException var4) {
         return null;
      } catch (Exception var5) {
         throw new IllegalArgumentException(fieldName + " must be a public field of type " + resultClass.getName() + " (" + var5 + "): " + mappingClass);
      }
   }

   public static TypeMapper getTypeMapper(Class cls) {
      Map options = getLibraryOptions(cls);
      return (TypeMapper)options.get("type-mapper");
   }

   public static String getStringEncoding(Class cls) {
      Map options = getLibraryOptions(cls);
      String encoding = (String)options.get("string-encoding");
      return encoding != null ? encoding : getDefaultStringEncoding();
   }

   public static String getDefaultStringEncoding() {
      return System.getProperty("jna.encoding", DEFAULT_ENCODING);
   }

   public static int getStructureAlignment(Class cls) {
      Integer alignment = (Integer)getLibraryOptions(cls).get("structure-alignment");
      return alignment == null ? 0 : alignment;
   }

   static byte[] getBytes(String s) {
      return getBytes(s, getDefaultStringEncoding());
   }

   static byte[] getBytes(String s, String encoding) {
      if (encoding != null) {
         try {
            return s.getBytes(encoding);
         } catch (UnsupportedEncodingException var3) {
            System.err.println("JNA Warning: Encoding '" + encoding + "' is unsupported");
         }
      }

      System.err.println("JNA Warning: Encoding with fallback " + System.getProperty("file.encoding"));
      return s.getBytes();
   }

   public static byte[] toByteArray(String s) {
      return toByteArray(s, getDefaultStringEncoding());
   }

   public static byte[] toByteArray(String s, String encoding) {
      byte[] bytes = getBytes(s, encoding);
      byte[] buf = new byte[bytes.length + 1];
      System.arraycopy(bytes, 0, buf, 0, bytes.length);
      return buf;
   }

   public static char[] toCharArray(String s) {
      char[] chars = s.toCharArray();
      char[] buf = new char[chars.length + 1];
      System.arraycopy(chars, 0, buf, 0, chars.length);
      return buf;
   }

   private static void loadNativeDispatchLibrary() {
      if (!Boolean.getBoolean("jna.nounpack")) {
         try {
            removeTemporaryFiles();
         } catch (IOException var9) {
            System.err.println("JNA Warning: IOException removing temporary files: " + var9.getMessage());
         }
      }

      String libName = System.getProperty("jna.boot.library.name", "jnidispatch");
      String bootPath = System.getProperty("jna.boot.library.path");
      if (bootPath != null) {
         StringTokenizer dirs = new StringTokenizer(bootPath, File.pathSeparator);

         while(dirs.hasMoreTokens()) {
            String dir = dirs.nextToken();
            File file = new File(new File(dir), System.mapLibraryName(libName).replace(".dylib", ".jnilib"));
            String path = file.getAbsolutePath();
            if (DEBUG_JNA_LOAD) {
               System.out.println("Looking in " + path);
            }

            if (file.exists()) {
               try {
                  if (DEBUG_JNA_LOAD) {
                     System.out.println("Trying " + path);
                  }

                  System.setProperty("jnidispatch.path", path);
                  System.load(path);
                  jnidispatchPath = path;
                  if (DEBUG_JNA_LOAD) {
                     System.out.println("Found jnidispatch at " + path);
                  }

                  return;
               } catch (UnsatisfiedLinkError var12) {
               }
            }

            if (Platform.isMac()) {
               String orig;
               String ext;
               if (path.endsWith("dylib")) {
                  orig = "dylib";
                  ext = "jnilib";
               } else {
                  orig = "jnilib";
                  ext = "dylib";
               }

               path = path.substring(0, path.lastIndexOf(orig)) + ext;
               if (DEBUG_JNA_LOAD) {
                  System.out.println("Looking in " + path);
               }

               if ((new File(path)).exists()) {
                  try {
                     if (DEBUG_JNA_LOAD) {
                        System.out.println("Trying " + path);
                     }

                     System.setProperty("jnidispatch.path", path);
                     System.load(path);
                     jnidispatchPath = path;
                     if (DEBUG_JNA_LOAD) {
                        System.out.println("Found jnidispatch at " + path);
                     }

                     return;
                  } catch (UnsatisfiedLinkError var11) {
                     System.err.println("File found at " + path + " but not loadable: " + var11.getMessage());
                  }
               }
            }
         }
      }

      if (!Boolean.getBoolean("jna.nosys")) {
         try {
            if (DEBUG_JNA_LOAD) {
               System.out.println("Trying (via loadLibrary) " + libName);
            }

            System.loadLibrary(libName);
            if (DEBUG_JNA_LOAD) {
               System.out.println("Found jnidispatch on system path");
            }

            return;
         } catch (UnsatisfiedLinkError var10) {
         }
      }

      if (!Boolean.getBoolean("jna.noclasspath")) {
         loadNativeDispatchLibraryFromClasspath();
      } else {
         throw new UnsatisfiedLinkError("Unable to locate JNA native support library");
      }
   }

   private static void loadNativeDispatchLibraryFromClasspath() {
      try {
         String libName = "/com/sun/jna/" + Platform.RESOURCE_PREFIX + "/" + System.mapLibraryName("jnidispatch").replace(".dylib", ".jnilib");
         File lib = extractFromResourcePath(libName, Native.class.getClassLoader());
         if (lib == null && lib == null) {
            throw new UnsatisfiedLinkError("Could not find JNA native support");
         } else {
            if (DEBUG_JNA_LOAD) {
               System.out.println("Trying " + lib.getAbsolutePath());
            }

            System.setProperty("jnidispatch.path", lib.getAbsolutePath());
            System.load(lib.getAbsolutePath());
            jnidispatchPath = lib.getAbsolutePath();
            if (DEBUG_JNA_LOAD) {
               System.out.println("Found jnidispatch at " + jnidispatchPath);
            }

            if (isUnpacked(lib) && !Boolean.getBoolean("jnidispatch.preserve")) {
               deleteLibrary(lib);
            }

         }
      } catch (IOException var2) {
         throw new UnsatisfiedLinkError(var2.getMessage());
      }
   }

   static boolean isUnpacked(File file) {
      return file.getName().startsWith("jna");
   }

   public static File extractFromResourcePath(String name) throws IOException {
      return extractFromResourcePath(name, (ClassLoader)null);
   }

   public static File extractFromResourcePath(String name, ClassLoader loader) throws IOException {
      boolean DEBUG = DEBUG_LOAD || DEBUG_JNA_LOAD && name.indexOf("jnidispatch") != -1;
      if (loader == null) {
         loader = Thread.currentThread().getContextClassLoader();
         if (loader == null) {
            loader = Native.class.getClassLoader();
         }
      }

      if (DEBUG) {
         System.out.println("Looking in classpath from " + loader + " for " + name);
      }

      String libname = name.startsWith("/") ? name : NativeLibrary.mapSharedLibraryName(name);
      String resourcePath = name.startsWith("/") ? name : Platform.RESOURCE_PREFIX + "/" + libname;
      if (resourcePath.startsWith("/")) {
         resourcePath = resourcePath.substring(1);
      }

      URL url = loader.getResource(resourcePath);
      if (url == null && resourcePath.startsWith(Platform.RESOURCE_PREFIX)) {
         url = loader.getResource(libname);
      }

      if (url == null) {
         String path = System.getProperty("java.class.path");
         if (loader instanceof URLClassLoader) {
            path = Arrays.asList(((URLClassLoader)loader).getURLs()).toString();
         }

         throw new IOException("Native library (" + resourcePath + ") not found in resource path (" + path + ")");
      } else {
         if (DEBUG) {
            System.out.println("Found library resource at " + url);
         }

         File lib = null;
         if (url.getProtocol().toLowerCase().equals("file")) {
            try {
               lib = new File(new URI(url.toString()));
            } catch (URISyntaxException var23) {
               lib = new File(url.getPath());
            }

            if (DEBUG) {
               System.out.println("Looking in " + lib.getAbsolutePath());
            }

            if (!lib.exists()) {
               throw new IOException("File URL " + url + " could not be properly decoded");
            }
         } else if (!Boolean.getBoolean("jna.nounpack")) {
            InputStream is = loader.getResourceAsStream(resourcePath);
            if (is == null) {
               throw new IOException("Can't obtain InputStream for " + resourcePath);
            }

            FileOutputStream fos = null;

            try {
               File dir = getTempDir();
               lib = File.createTempFile("jna", Platform.isWindows() ? ".dll" : null, dir);
               if (!Boolean.getBoolean("jnidispatch.preserve")) {
                  lib.deleteOnExit();
               }

               fos = new FileOutputStream(lib);
               byte[] buf = new byte[1024];

               int count;
               while((count = is.read(buf, 0, buf.length)) > 0) {
                  fos.write(buf, 0, count);
               }
            } catch (IOException var24) {
               throw new IOException("Failed to create temporary file for " + name + " library: " + var24.getMessage());
            } finally {
               try {
                  is.close();
               } catch (IOException var22) {
               }

               if (fos != null) {
                  try {
                     fos.close();
                  } catch (IOException var21) {
                  }
               }

            }
         }

         return lib;
      }
   }

   private static native int sizeof(int var0);

   private static native String getNativeVersion();

   private static native String getAPIChecksum();

   public static native int getLastError();

   public static native void setLastError(int var0);

   public static Library synchronizedLibrary(final Library library) {
      Class cls = library.getClass();
      if (!Proxy.isProxyClass(cls)) {
         throw new IllegalArgumentException("Library must be a proxy class");
      } else {
         InvocationHandler ih = Proxy.getInvocationHandler(library);
         if (!(ih instanceof Library.Handler)) {
            throw new IllegalArgumentException("Unrecognized proxy handler: " + ih);
         } else {
            final Library.Handler handler = (Library.Handler)ih;
            InvocationHandler newHandler = new InvocationHandler() {
               public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                  synchronized(handler.getNativeLibrary()) {
                     return handler.invoke(library, method, args);
                  }
               }
            };
            return (Library)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), newHandler);
         }
      }
   }

   public static String getWebStartLibraryPath(String libName) {
      if (System.getProperty("javawebstart.version") == null) {
         return null;
      } else {
         try {
            ClassLoader cl = Native.class.getClassLoader();
            Method m = (Method)AccessController.doPrivileged(new PrivilegedAction() {
               public Method run() {
                  try {
                     Method m = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                     m.setAccessible(true);
                     return m;
                  } catch (Exception var2) {
                     return null;
                  }
               }
            });
            String libpath = (String)m.invoke(cl, libName);
            return libpath != null ? (new File(libpath)).getParent() : null;
         } catch (Exception var4) {
            return null;
         }
      }
   }

   static void markTemporaryFile(File file) {
      try {
         File marker = new File(file.getParentFile(), file.getName() + ".x");
         marker.createNewFile();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   static File getTempDir() throws IOException {
      String prop = System.getProperty("jna.tmpdir");
      File jnatmp;
      if (prop != null) {
         jnatmp = new File(prop);
         jnatmp.mkdirs();
      } else {
         File tmp = new File(System.getProperty("java.io.tmpdir"));
         jnatmp = new File(tmp, "jna-" + System.getProperty("user.name").hashCode());
         jnatmp.mkdirs();
         if (!jnatmp.exists() || !jnatmp.canWrite()) {
            jnatmp = tmp;
         }
      }

      if (!jnatmp.exists()) {
         throw new IOException("JNA temporary directory '" + jnatmp + "' does not exist");
      } else if (!jnatmp.canWrite()) {
         throw new IOException("JNA temporary directory '" + jnatmp + "' is not writable");
      } else {
         return jnatmp;
      }
   }

   static void removeTemporaryFiles() throws IOException {
      File dir = getTempDir();
      FilenameFilter filter = new FilenameFilter() {
         public boolean accept(File dir, String name) {
            return name.endsWith(".x") && name.startsWith("jna");
         }
      };
      File[] files = dir.listFiles(filter);

      for(int i = 0; files != null && i < files.length; ++i) {
         File marker = files[i];
         String name = marker.getName();
         name = name.substring(0, name.length() - 2);
         File target = new File(marker.getParentFile(), name);
         if (!target.exists() || target.delete()) {
            marker.delete();
         }
      }

   }

   public static int getNativeSize(Class type, Object value) {
      if (type.isArray()) {
         int len = Array.getLength(value);
         if (len > 0) {
            Object o = Array.get(value, 0);
            return len * getNativeSize(type.getComponentType(), o);
         } else {
            throw new IllegalArgumentException("Arrays of length zero not allowed: " + type);
         }
      } else if (Structure.class.isAssignableFrom(type) && !Structure.ByReference.class.isAssignableFrom(type)) {
         return Structure.size(type, (Structure)value);
      } else {
         try {
            return getNativeSize(type);
         } catch (IllegalArgumentException var4) {
            throw new IllegalArgumentException("The type \"" + type.getName() + "\" is not supported: " + var4.getMessage());
         }
      }
   }

   public static int getNativeSize(Class cls) {
      if (NativeMapped.class.isAssignableFrom(cls)) {
         cls = NativeMappedConverter.getInstance(cls).nativeType();
      }

      if (cls != Boolean.TYPE && cls != Boolean.class) {
         if (cls != Byte.TYPE && cls != Byte.class) {
            if (cls != Short.TYPE && cls != Short.class) {
               if (cls != Character.TYPE && cls != Character.class) {
                  if (cls != Integer.TYPE && cls != Integer.class) {
                     if (cls != Long.TYPE && cls != Long.class) {
                        if (cls != Float.TYPE && cls != Float.class) {
                           if (cls != Double.TYPE && cls != Double.class) {
                              if (Structure.class.isAssignableFrom(cls)) {
                                 return Structure.ByValue.class.isAssignableFrom(cls) ? Structure.size(cls) : POINTER_SIZE;
                              } else if (!Pointer.class.isAssignableFrom(cls) && (!Platform.HAS_BUFFERS || !Native.Buffers.isBuffer(cls)) && !Callback.class.isAssignableFrom(cls) && String.class != cls && WString.class != cls) {
                                 throw new IllegalArgumentException("Native size for type \"" + cls.getName() + "\" is unknown");
                              } else {
                                 return POINTER_SIZE;
                              }
                           } else {
                              return 8;
                           }
                        } else {
                           return 4;
                        }
                     } else {
                        return 8;
                     }
                  } else {
                     return 4;
                  }
               } else {
                  return WCHAR_SIZE;
               }
            } else {
               return 2;
            }
         } else {
            return 1;
         }
      } else {
         return 4;
      }
   }

   public static boolean isSupportedNativeType(Class cls) {
      if (Structure.class.isAssignableFrom(cls)) {
         return true;
      } else {
         try {
            return getNativeSize(cls) != 0;
         } catch (IllegalArgumentException var2) {
            return false;
         }
      }
   }

   public static void setCallbackExceptionHandler(Callback.UncaughtExceptionHandler eh) {
      callbackExceptionHandler = eh == null ? DEFAULT_HANDLER : eh;
   }

   public static Callback.UncaughtExceptionHandler getCallbackExceptionHandler() {
      return callbackExceptionHandler;
   }

   public static void register(String libName) {
      register(findDirectMappedClass(getCallingClass()), libName);
   }

   public static void register(NativeLibrary lib) {
      register(findDirectMappedClass(getCallingClass()), lib);
   }

   static Class findDirectMappedClass(Class cls) {
      Method[] methods = cls.getDeclaredMethods();
      Method[] var2 = methods;
      int var3 = methods.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Method m = var2[var4];
         if ((m.getModifiers() & 256) != 0) {
            return cls;
         }
      }

      int idx = cls.getName().lastIndexOf("$");
      if (idx != -1) {
         String name = cls.getName().substring(0, idx);

         try {
            return findDirectMappedClass(Class.forName(name, true, cls.getClassLoader()));
         } catch (ClassNotFoundException var6) {
         }
      }

      throw new IllegalArgumentException("Can't determine class with native methods from the current context (" + cls + ")");
   }

   static Class getCallingClass() {
      Class[] context = (new SecurityManager() {
         public Class[] getClassContext() {
            return super.getClassContext();
         }
      }).getClassContext();
      if (context == null) {
         throw new IllegalStateException("The SecurityManager implementation on this platform is broken; you must explicitly provide the class to register");
      } else if (context.length < 4) {
         throw new IllegalStateException("This method must be called from the static initializer of a class");
      } else {
         return context[3];
      }
   }

   public static void setCallbackThreadInitializer(Callback cb, CallbackThreadInitializer initializer) {
      CallbackReference.setCallbackThreadInitializer(cb, initializer);
   }

   private static void unregisterAll() {
      synchronized(registeredClasses) {
         Iterator var1 = registeredClasses.entrySet().iterator();

         while(var1.hasNext()) {
            Entry e = (Entry)var1.next();
            unregister((Class)e.getKey(), (long[])e.getValue());
         }

         registeredClasses.clear();
      }
   }

   public static void unregister() {
      unregister(findDirectMappedClass(getCallingClass()));
   }

   public static void unregister(Class cls) {
      synchronized(registeredClasses) {
         long[] handles = (long[])registeredClasses.get(cls);
         if (handles != null) {
            unregister(cls, handles);
            registeredClasses.remove(cls);
            registeredLibraries.remove(cls);
         }

      }
   }

   public static boolean registered(Class cls) {
      synchronized(registeredClasses) {
         return registeredClasses.containsKey(cls);
      }
   }

   private static native void unregister(Class var0, long[] var1);

   static String getSignature(Class cls) {
      if (cls.isArray()) {
         return "[" + getSignature(cls.getComponentType());
      } else {
         if (cls.isPrimitive()) {
            if (cls == Void.TYPE) {
               return "V";
            }

            if (cls == Boolean.TYPE) {
               return "Z";
            }

            if (cls == Byte.TYPE) {
               return "B";
            }

            if (cls == Short.TYPE) {
               return "S";
            }

            if (cls == Character.TYPE) {
               return "C";
            }

            if (cls == Integer.TYPE) {
               return "I";
            }

            if (cls == Long.TYPE) {
               return "J";
            }

            if (cls == Float.TYPE) {
               return "F";
            }

            if (cls == Double.TYPE) {
               return "D";
            }
         }

         return "L" + replace(".", "/", cls.getName()) + ";";
      }
   }

   static String replace(String s1, String s2, String str) {
      StringBuilder buf = new StringBuilder();

      while(true) {
         int idx = str.indexOf(s1);
         if (idx == -1) {
            buf.append(str);
            return buf.toString();
         }

         buf.append(str.substring(0, idx));
         buf.append(s2);
         str = str.substring(idx + s1.length());
      }
   }

   private static int getConversion(Class type, TypeMapper mapper, boolean allowObjects) {
      if (type == Boolean.class) {
         type = Boolean.TYPE;
      } else if (type == Byte.class) {
         type = Byte.TYPE;
      } else if (type == Short.class) {
         type = Short.TYPE;
      } else if (type == Character.class) {
         type = Character.TYPE;
      } else if (type == Integer.class) {
         type = Integer.TYPE;
      } else if (type == Long.class) {
         type = Long.TYPE;
      } else if (type == Float.class) {
         type = Float.TYPE;
      } else if (type == Double.class) {
         type = Double.TYPE;
      } else if (type == Void.class) {
         type = Void.TYPE;
      }

      if (mapper != null) {
         FromNativeConverter fromNative = mapper.getFromNativeConverter(type);
         ToNativeConverter toNative = mapper.getToNativeConverter(type);
         Class nativeType;
         if (fromNative != null) {
            nativeType = fromNative.nativeType();
            if (nativeType == String.class) {
               return 24;
            }

            if (nativeType == WString.class) {
               return 25;
            }

            return 23;
         }

         if (toNative != null) {
            nativeType = toNative.nativeType();
            if (nativeType == String.class) {
               return 24;
            }

            if (nativeType == WString.class) {
               return 25;
            }

            return 23;
         }
      }

      if (Pointer.class.isAssignableFrom(type)) {
         return 1;
      } else if (String.class == type) {
         return 2;
      } else if (WString.class.isAssignableFrom(type)) {
         return 20;
      } else if (Platform.HAS_BUFFERS && Native.Buffers.isBuffer(type)) {
         return 5;
      } else if (Structure.class.isAssignableFrom(type)) {
         return Structure.ByValue.class.isAssignableFrom(type) ? 4 : 3;
      } else {
         if (type.isArray()) {
            switch(type.getName().charAt(1)) {
            case 'B':
               return 6;
            case 'C':
               return 8;
            case 'D':
               return 12;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            default:
               break;
            case 'F':
               return 11;
            case 'I':
               return 9;
            case 'J':
               return 10;
            case 'S':
               return 7;
            case 'Z':
               return 13;
            }
         }

         if (type.isPrimitive()) {
            return type == Boolean.TYPE ? 14 : 0;
         } else if (Callback.class.isAssignableFrom(type)) {
            return 15;
         } else if (IntegerType.class.isAssignableFrom(type)) {
            return 21;
         } else if (PointerType.class.isAssignableFrom(type)) {
            return 22;
         } else if (NativeMapped.class.isAssignableFrom(type)) {
            Class nativeType = NativeMappedConverter.getInstance(type).nativeType();
            if (nativeType == String.class) {
               return 18;
            } else {
               return nativeType == WString.class ? 19 : 17;
            }
         } else if (JNIEnv.class == type) {
            return 27;
         } else {
            return allowObjects ? 26 : -1;
         }
      }
   }

   public static void register(Class cls, String libName) {
      NativeLibrary library = NativeLibrary.getInstance(libName, Collections.singletonMap("classloader", cls.getClassLoader()));
      register(cls, library);
   }

   public static void register(Class cls, NativeLibrary lib) {
      Method[] methods = cls.getDeclaredMethods();
      List mlist = new ArrayList();
      Map options = lib.getOptions();
      TypeMapper mapper = (TypeMapper)options.get("type-mapper");
      boolean allowObjects = Boolean.TRUE.equals(options.get("allow-objects"));
      cacheOptions(cls, options, (Object)null);
      Method[] var7 = methods;
      int i = methods.length;

      for(int var9 = 0; var9 < i; ++var9) {
         Method m = var7[var9];
         if ((m.getModifiers() & 256) != 0) {
            mlist.add(m);
         }
      }

      long[] handles = new long[mlist.size()];

      for(i = 0; i < handles.length; ++i) {
         Method method = (Method)mlist.get(i);
         String sig = "(";
         Class rclass = method.getReturnType();
         Class[] ptypes = method.getParameterTypes();
         long[] atypes = new long[ptypes.length];
         long[] closure_atypes = new long[ptypes.length];
         int[] cvt = new int[ptypes.length];
         ToNativeConverter[] toNative = new ToNativeConverter[ptypes.length];
         FromNativeConverter fromNative = null;
         int rcvt = getConversion(rclass, mapper, allowObjects);
         boolean throwLastError = false;
         long rtype;
         long closure_rtype;
         switch(rcvt) {
         case -1:
            throw new IllegalArgumentException(rclass + " is not a supported return type (in method " + method.getName() + " in " + cls + ")");
         case 0:
         case 1:
         case 2:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 20:
         default:
            closure_rtype = rtype = Structure.FFIType.get(rclass).peer;
            break;
         case 3:
         case 26:
            closure_rtype = rtype = Structure.FFIType.get(Pointer.class).peer;
            break;
         case 4:
            closure_rtype = Structure.FFIType.get(Pointer.class).peer;
            rtype = Structure.FFIType.get(rclass).peer;
            break;
         case 17:
         case 18:
         case 19:
         case 21:
         case 22:
            closure_rtype = Structure.FFIType.get(Pointer.class).peer;
            rtype = Structure.FFIType.get(NativeMappedConverter.getInstance(rclass).nativeType()).peer;
            break;
         case 23:
         case 24:
         case 25:
            fromNative = mapper.getFromNativeConverter(rclass);
            closure_rtype = Structure.FFIType.get(rclass.isPrimitive() ? rclass : Pointer.class).peer;
            rtype = Structure.FFIType.get(fromNative.nativeType()).peer;
         }

         for(int t = 0; t < ptypes.length; ++t) {
            Class type = ptypes[t];
            sig = sig + getSignature(type);
            int conversionType = getConversion(type, mapper, allowObjects);
            cvt[t] = conversionType;
            if (conversionType == -1) {
               throw new IllegalArgumentException(type + " is not a supported argument type (in method " + method.getName() + " in " + cls + ")");
            }

            if (conversionType != 17 && conversionType != 18 && conversionType != 19 && conversionType != 21) {
               if (conversionType == 23 || conversionType == 24 || conversionType == 25) {
                  toNative[t] = mapper.getToNativeConverter(type);
               }
            } else {
               type = NativeMappedConverter.getInstance(type).nativeType();
            }

            switch(conversionType) {
            case 0:
               closure_atypes[t] = atypes[t] = Structure.FFIType.get(type).peer;
               break;
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 20:
            default:
               closure_atypes[t] = atypes[t] = Structure.FFIType.get(Pointer.class).peer;
               break;
            case 4:
            case 17:
            case 18:
            case 19:
            case 21:
            case 22:
               atypes[t] = Structure.FFIType.get(type).peer;
               closure_atypes[t] = Structure.FFIType.get(Pointer.class).peer;
               break;
            case 23:
            case 24:
            case 25:
               closure_atypes[t] = Structure.FFIType.get(type.isPrimitive() ? type : Pointer.class).peer;
               atypes[t] = Structure.FFIType.get(toNative[t].nativeType()).peer;
            }
         }

         sig = sig + ")";
         sig = sig + getSignature(rclass);
         Class[] etypes = method.getExceptionTypes();

         for(int e = 0; e < etypes.length; ++e) {
            if (LastErrorException.class.isAssignableFrom(etypes[e])) {
               throwLastError = true;
               break;
            }
         }

         Function f = lib.getFunction(method.getName(), method);

         try {
            handles[i] = registerMethod(cls, method.getName(), sig, cvt, closure_atypes, atypes, rcvt, closure_rtype, rtype, method, f.peer, f.getCallingConvention(), throwLastError, toNative, fromNative, f.encoding);
         } catch (NoSuchMethodError var29) {
            throw new UnsatisfiedLinkError("No method " + method.getName() + " with signature " + sig + " in " + cls);
         }
      }

      synchronized(registeredClasses) {
         registeredClasses.put(cls, handles);
         registeredLibraries.put(cls, lib);
      }
   }

   private static Map cacheOptions(Class cls, Map options, Object proxy) {
      Map libOptions = new HashMap(options);
      libOptions.put("enclosing-library", cls);
      synchronized(libraries) {
         typeOptions.put(cls, libOptions);
         if (proxy != null) {
            libraries.put(cls, new WeakReference(proxy));
         }

         if (!cls.isInterface() && Library.class.isAssignableFrom(cls)) {
            Class[] ifaces = cls.getInterfaces();
            Class[] var6 = ifaces;
            int var7 = ifaces.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               Class ifc = var6[var8];
               if (Library.class.isAssignableFrom(ifc)) {
                  cacheOptions(ifc, libOptions, proxy);
                  break;
               }
            }
         }

         return libOptions;
      }
   }

   private static native long registerMethod(Class var0, String var1, String var2, int[] var3, long[] var4, long[] var5, int var6, long var7, long var9, Method var11, long var12, int var14, boolean var15, ToNativeConverter[] var16, FromNativeConverter var17, String var18);

   private static NativeMapped fromNative(Class cls, Object value) {
      return (NativeMapped)NativeMappedConverter.getInstance(cls).fromNative(value, new FromNativeContext(cls));
   }

   private static NativeMapped fromNative(Method m, Object value) {
      Class cls = m.getReturnType();
      return (NativeMapped)NativeMappedConverter.getInstance(cls).fromNative(value, new MethodResultContext(cls, (Function)null, (Object[])null, m));
   }

   private static Class nativeType(Class cls) {
      return NativeMappedConverter.getInstance(cls).nativeType();
   }

   private static Object toNative(ToNativeConverter cvt, Object o) {
      return cvt.toNative(o, new ToNativeContext());
   }

   private static Object fromNative(FromNativeConverter cvt, Object o, Method m) {
      return cvt.fromNative(o, new MethodResultContext(m.getReturnType(), (Function)null, (Object[])null, m));
   }

   public static native long ffi_prep_cif(int var0, int var1, long var2, long var4);

   public static native void ffi_call(long var0, long var2, long var4, long var6);

   public static native long ffi_prep_closure(long var0, Native.ffi_callback var2);

   public static native void ffi_free_closure(long var0);

   static native int initialize_ffi_type(long var0);

   public static void main(String[] args) {
      String DEFAULT_TITLE = "Java Native Access (JNA)";
      String DEFAULT_VERSION = "4.5.1";
      String DEFAULT_BUILD = "4.5.1 (package information missing)";
      Package pkg = Native.class.getPackage();
      String title = pkg != null ? pkg.getSpecificationTitle() : "Java Native Access (JNA)";
      if (title == null) {
         title = "Java Native Access (JNA)";
      }

      String version = pkg != null ? pkg.getSpecificationVersion() : "4.5.1";
      if (version == null) {
         version = "4.5.1";
      }

      title = title + " API Version " + version;
      System.out.println(title);
      version = pkg != null ? pkg.getImplementationVersion() : "4.5.1 (package information missing)";
      if (version == null) {
         version = "4.5.1 (package information missing)";
      }

      System.out.println("Version: " + version);
      System.out.println(" Native: " + getNativeVersion() + " (" + getAPIChecksum() + ")");
      System.out.println(" Prefix: " + Platform.RESOURCE_PREFIX);
   }

   static synchronized native void freeNativeCallback(long var0);

   static synchronized native long createNativeCallback(Callback var0, Method var1, Class[] var2, Class var3, int var4, int var5, String var6);

   static native int invokeInt(Function var0, long var1, int var3, Object[] var4);

   static native long invokeLong(Function var0, long var1, int var3, Object[] var4);

   static native void invokeVoid(Function var0, long var1, int var3, Object[] var4);

   static native float invokeFloat(Function var0, long var1, int var3, Object[] var4);

   static native double invokeDouble(Function var0, long var1, int var3, Object[] var4);

   static native long invokePointer(Function var0, long var1, int var3, Object[] var4);

   private static native void invokeStructure(Function var0, long var1, int var3, Object[] var4, long var5, long var7);

   static Structure invokeStructure(Function function, long fp, int callFlags, Object[] args, Structure s) {
      invokeStructure(function, fp, callFlags, args, s.getPointer().peer, s.getTypeInfo().peer);
      return s;
   }

   static native Object invokeObject(Function var0, long var1, int var3, Object[] var4);

   static long open(String name) {
      return open(name, -1);
   }

   static native long open(String var0, int var1);

   static native void close(long var0);

   static native long findSymbol(long var0, String var2);

   static native long indexOf(Pointer var0, long var1, long var3, byte var5);

   static native void read(Pointer var0, long var1, long var3, byte[] var5, int var6, int var7);

   static native void read(Pointer var0, long var1, long var3, short[] var5, int var6, int var7);

   static native void read(Pointer var0, long var1, long var3, char[] var5, int var6, int var7);

   static native void read(Pointer var0, long var1, long var3, int[] var5, int var6, int var7);

   static native void read(Pointer var0, long var1, long var3, long[] var5, int var6, int var7);

   static native void read(Pointer var0, long var1, long var3, float[] var5, int var6, int var7);

   static native void read(Pointer var0, long var1, long var3, double[] var5, int var6, int var7);

   static native void write(Pointer var0, long var1, long var3, byte[] var5, int var6, int var7);

   static native void write(Pointer var0, long var1, long var3, short[] var5, int var6, int var7);

   static native void write(Pointer var0, long var1, long var3, char[] var5, int var6, int var7);

   static native void write(Pointer var0, long var1, long var3, int[] var5, int var6, int var7);

   static native void write(Pointer var0, long var1, long var3, long[] var5, int var6, int var7);

   static native void write(Pointer var0, long var1, long var3, float[] var5, int var6, int var7);

   static native void write(Pointer var0, long var1, long var3, double[] var5, int var6, int var7);

   static native byte getByte(Pointer var0, long var1, long var3);

   static native char getChar(Pointer var0, long var1, long var3);

   static native short getShort(Pointer var0, long var1, long var3);

   static native int getInt(Pointer var0, long var1, long var3);

   static native long getLong(Pointer var0, long var1, long var3);

   static native float getFloat(Pointer var0, long var1, long var3);

   static native double getDouble(Pointer var0, long var1, long var3);

   static Pointer getPointer(long addr) {
      long peer = _getPointer(addr);
      return peer == 0L ? null : new Pointer(peer);
   }

   private static native long _getPointer(long var0);

   static native String getWideString(Pointer var0, long var1, long var3);

   static String getString(Pointer pointer, long offset) {
      return getString(pointer, offset, getDefaultStringEncoding());
   }

   static String getString(Pointer pointer, long offset, String encoding) {
      byte[] data = getStringBytes(pointer, pointer.peer, offset);
      if (encoding != null) {
         try {
            return new String(data, encoding);
         } catch (UnsupportedEncodingException var6) {
         }
      }

      return new String(data);
   }

   static native byte[] getStringBytes(Pointer var0, long var1, long var3);

   static native void setMemory(Pointer var0, long var1, long var3, long var5, byte var7);

   static native void setByte(Pointer var0, long var1, long var3, byte var5);

   static native void setShort(Pointer var0, long var1, long var3, short var5);

   static native void setChar(Pointer var0, long var1, long var3, char var5);

   static native void setInt(Pointer var0, long var1, long var3, int var5);

   static native void setLong(Pointer var0, long var1, long var3, long var5);

   static native void setFloat(Pointer var0, long var1, long var3, float var5);

   static native void setDouble(Pointer var0, long var1, long var3, double var5);

   static native void setPointer(Pointer var0, long var1, long var3, long var5);

   static native void setWideString(Pointer var0, long var1, long var3, String var5);

   static native ByteBuffer getDirectByteBuffer(Pointer var0, long var1, long var3, long var5);

   public static native long malloc(long var0);

   public static native void free(long var0);

   /** @deprecated */
   @Deprecated
   public static native ByteBuffer getDirectByteBuffer(long var0, long var2);

   public static void detach(boolean detach) {
      Thread thread = Thread.currentThread();
      Pointer p;
      if (detach) {
         nativeThreads.remove(thread);
         p = (Pointer)nativeThreadTerminationFlag.get();
         setDetachState(true, 0L);
      } else if (!nativeThreads.containsKey(thread)) {
         p = (Pointer)nativeThreadTerminationFlag.get();
         nativeThreads.put(thread, p);
         setDetachState(false, p.peer);
      }

   }

   static Pointer getTerminationFlag(Thread t) {
      return (Pointer)nativeThreads.get(t);
   }

   private static native void setDetachState(boolean var0, long var1);

   static {
      callbackExceptionHandler = DEFAULT_HANDLER;
      loadNativeDispatchLibrary();
      if (!isCompatibleVersion("5.2.0", getNativeVersion())) {
         String LS = System.getProperty("line.separator");
         throw new Error(LS + LS + "There is an incompatible JNA native library installed on this system" + LS + "Expected: " + "5.2.0" + LS + "Found:    " + getNativeVersion() + LS + (jnidispatchPath != null ? "(at " + jnidispatchPath + ")" : System.getProperty("java.library.path")) + "." + LS + "To resolve this issue you may do one of the following:" + LS + " - remove or uninstall the offending library" + LS + " - set the system property jna.nosys=true" + LS + " - set jna.boot.library.path to include the path to the version of the " + LS + "   jnidispatch library included with the JNA jar file you are using" + LS);
      } else {
         POINTER_SIZE = sizeof(0);
         LONG_SIZE = sizeof(1);
         WCHAR_SIZE = sizeof(2);
         SIZE_T_SIZE = sizeof(3);
         BOOL_SIZE = sizeof(4);
         initIDs();
         if (Boolean.getBoolean("jna.protected")) {
            setProtected(true);
         }

         MAX_ALIGNMENT = !Platform.isSPARC() && !Platform.isWindows() && (!Platform.isLinux() || !Platform.isARM() && !Platform.isPPC() && !Platform.isMIPS()) && !Platform.isAIX() && !Platform.isAndroid() ? LONG_SIZE : 8;
         MAX_PADDING = Platform.isMac() && Platform.isPPC() ? 8 : MAX_ALIGNMENT;
         System.setProperty("jna.loaded", "true");
         finalizer = new Object() {
            protected void finalize() {
               Native.dispose();
            }
         };
         registeredClasses = new WeakHashMap();
         registeredLibraries = new WeakHashMap();
         nativeThreadTerminationFlag = new ThreadLocal() {
            protected Memory initialValue() {
               Memory m = new Memory(4L);
               m.clear();
               return m;
            }
         };
         nativeThreads = Collections.synchronizedMap(new WeakHashMap());
      }
   }

   private static class AWT {
      static long getWindowID(Window w) throws HeadlessException {
         return getComponentID(w);
      }

      static long getComponentID(Object o) throws HeadlessException {
         if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException("No native windows when headless");
         } else {
            Component c = (Component)o;
            if (c.isLightweight()) {
               throw new IllegalArgumentException("Component must be heavyweight");
            } else if (!c.isDisplayable()) {
               throw new IllegalStateException("Component must be displayable");
            } else if (Platform.isX11() && System.getProperty("java.version").startsWith("1.4") && !c.isVisible()) {
               throw new IllegalStateException("Component must be visible");
            } else {
               return Native.getWindowHandle0(c);
            }
         }
      }
   }

   private static class Buffers {
      static boolean isBuffer(Class cls) {
         return Buffer.class.isAssignableFrom(cls);
      }
   }

   public interface ffi_callback {
      void invoke(long var1, long var3, long var5);
   }
}
