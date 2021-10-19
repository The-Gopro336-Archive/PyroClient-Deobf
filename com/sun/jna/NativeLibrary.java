package com.sun.jna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class NativeLibrary {
   private long handle;
   private final String libraryName;
   private final String libraryPath;
   private final Map functions = new HashMap();
   final int callFlags;
   private String encoding;
   final Map options;
   private static final Map libraries = new HashMap();
   private static final Map searchPaths = Collections.synchronizedMap(new HashMap());
   private static final List librarySearchPath = new ArrayList();
   private static final int DEFAULT_OPEN_OPTIONS = -1;

   private static String functionKey(String name, int flags, String encoding) {
      return name + "|" + flags + "|" + encoding;
   }

   private NativeLibrary(String libraryName, String libraryPath, long handle, Map options) {
      this.libraryName = this.getLibraryName(libraryName);
      this.libraryPath = libraryPath;
      this.handle = handle;
      Object option = options.get("calling-convention");
      int callingConvention = option instanceof Number ? ((Number)option).intValue() : 0;
      this.callFlags = callingConvention;
      this.options = options;
      this.encoding = (String)options.get("string-encoding");
      if (this.encoding == null) {
         this.encoding = Native.getDefaultStringEncoding();
      }

      if (Platform.isWindows() && "kernel32".equals(this.libraryName.toLowerCase())) {
         synchronized(this.functions) {
            Function f = new Function(this, "GetLastError", 63, this.encoding) {
               Object invoke(Object[] args, Class returnType, boolean b, int fixedArgs) {
                  return Native.getLastError();
               }

               Object invoke(Method invokingMethod, Class[] paramTypes, Class returnType, Object[] inArgs, Map options) {
                  return Native.getLastError();
               }
            };
            this.functions.put(functionKey("GetLastError", this.callFlags, this.encoding), f);
         }
      }

   }

   private static int openFlags(Map options) {
      Object opt = options.get("open-flags");
      return opt instanceof Number ? ((Number)opt).intValue() : -1;
   }

   private static NativeLibrary loadLibrary(String libraryName, Map options) {
      if (Native.DEBUG_LOAD) {
         System.out.println("Looking for library '" + libraryName + "'");
      }

      boolean isAbsolutePath = (new File(libraryName)).isAbsolute();
      List searchPath = new ArrayList();
      int openFlags = openFlags(options);
      String webstartPath = Native.getWebStartLibraryPath(libraryName);
      if (webstartPath != null) {
         if (Native.DEBUG_LOAD) {
            System.out.println("Adding web start path " + webstartPath);
         }

         searchPath.add(webstartPath);
      }

      List customPaths = (List)searchPaths.get(libraryName);
      if (customPaths != null) {
         synchronized(customPaths) {
            searchPath.addAll(0, customPaths);
         }
      }

      if (Native.DEBUG_LOAD) {
         System.out.println("Adding paths from jna.library.path: " + System.getProperty("jna.library.path"));
      }

      searchPath.addAll(initPaths("jna.library.path"));
      String libraryPath = findLibraryPath(libraryName, searchPath);
      long handle = 0L;

      try {
         if (Native.DEBUG_LOAD) {
            System.out.println("Trying " + libraryPath);
         }

         handle = Native.open(libraryPath, openFlags);
      } catch (UnsatisfiedLinkError var30) {
         if (Native.DEBUG_LOAD) {
            System.out.println("Adding system paths: " + librarySearchPath);
         }

         searchPath.addAll(librarySearchPath);
      }

      try {
         if (handle == 0L) {
            libraryPath = findLibraryPath(libraryName, searchPath);
            if (Native.DEBUG_LOAD) {
               System.out.println("Trying " + libraryPath);
            }

            handle = Native.open(libraryPath, openFlags);
            if (handle == 0L) {
               throw new UnsatisfiedLinkError("Failed to load library '" + libraryName + "'");
            }
         }
      } catch (UnsatisfiedLinkError var29) {
         UnsatisfiedLinkError e = var29;
         if (Platform.isAndroid()) {
            try {
               if (Native.DEBUG_LOAD) {
                  System.out.println("Preload (via System.loadLibrary) " + libraryName);
               }

               System.loadLibrary(libraryName);
               handle = Native.open(libraryPath, openFlags);
            } catch (UnsatisfiedLinkError var25) {
               e = var25;
            }
         } else if (!Platform.isLinux() && !Platform.isFreeBSD()) {
            if (Platform.isMac() && !libraryName.endsWith(".dylib")) {
               if (Native.DEBUG_LOAD) {
                  System.out.println("Looking for matching frameworks");
               }

               libraryPath = matchFramework(libraryName);
               if (libraryPath != null) {
                  try {
                     if (Native.DEBUG_LOAD) {
                        System.out.println("Trying " + libraryPath);
                     }

                     handle = Native.open(libraryPath, openFlags);
                  } catch (UnsatisfiedLinkError var23) {
                     e = var23;
                  }
               }
            } else if (Platform.isWindows() && !isAbsolutePath) {
               if (Native.DEBUG_LOAD) {
                  System.out.println("Looking for lib- prefix");
               }

               libraryPath = findLibraryPath("lib" + libraryName, searchPath);
               if (libraryPath != null) {
                  if (Native.DEBUG_LOAD) {
                     System.out.println("Trying " + libraryPath);
                  }

                  try {
                     handle = Native.open(libraryPath, openFlags);
                  } catch (UnsatisfiedLinkError var22) {
                     e = var22;
                  }
               }
            }
         } else {
            if (Native.DEBUG_LOAD) {
               System.out.println("Looking for version variants");
            }

            libraryPath = matchLibrary(libraryName, searchPath);
            if (libraryPath != null) {
               if (Native.DEBUG_LOAD) {
                  System.out.println("Trying " + libraryPath);
               }

               try {
                  handle = Native.open(libraryPath, openFlags);
               } catch (UnsatisfiedLinkError var24) {
                  e = var24;
               }
            }
         }

         if (handle == 0L) {
            try {
               File embedded = Native.extractFromResourcePath(libraryName, (ClassLoader)options.get("classloader"));

               try {
                  handle = Native.open(embedded.getAbsolutePath(), openFlags);
                  libraryPath = embedded.getAbsolutePath();
               } finally {
                  if (Native.isUnpacked(embedded)) {
                     Native.deleteLibrary(embedded);
                  }

               }
            } catch (IOException var28) {
               e = new UnsatisfiedLinkError(var28.getMessage());
            }
         }

         if (handle == 0L) {
            throw new UnsatisfiedLinkError("Unable to load library '" + libraryName + "': " + e.getMessage());
         }
      }

      if (Native.DEBUG_LOAD) {
         System.out.println("Found library '" + libraryName + "' at " + libraryPath);
      }

      return new NativeLibrary(libraryName, libraryPath, handle, options);
   }

   static String matchFramework(String libraryName) {
      File framework = new File(libraryName);
      if (framework.isAbsolute()) {
         if (libraryName.indexOf(".framework") != -1 && framework.exists()) {
            return framework.getAbsolutePath();
         }

         framework = new File(new File(framework.getParentFile(), framework.getName() + ".framework"), framework.getName());
         if (framework.exists()) {
            return framework.getAbsolutePath();
         }
      } else {
         String[] PREFIXES = new String[]{System.getProperty("user.home"), "", "/System"};
         String suffix = libraryName.indexOf(".framework") == -1 ? libraryName + ".framework/" + libraryName : libraryName;

         for(int i = 0; i < PREFIXES.length; ++i) {
            String libraryPath = PREFIXES[i] + "/Library/Frameworks/" + suffix;
            if ((new File(libraryPath)).exists()) {
               return libraryPath;
            }
         }
      }

      return null;
   }

   private String getLibraryName(String libraryName) {
      String simplified = libraryName;
      String BASE = "---";
      String template = mapSharedLibraryName("---");
      int prefixEnd = template.indexOf("---");
      if (prefixEnd > 0 && libraryName.startsWith(template.substring(0, prefixEnd))) {
         simplified = libraryName.substring(prefixEnd);
      }

      String suffix = template.substring(prefixEnd + "---".length());
      int suffixStart = simplified.indexOf(suffix);
      if (suffixStart != -1) {
         simplified = simplified.substring(0, suffixStart);
      }

      return simplified;
   }

   public static final NativeLibrary getInstance(String libraryName) {
      return getInstance(libraryName, Collections.emptyMap());
   }

   public static final NativeLibrary getInstance(String libraryName, ClassLoader classLoader) {
      return getInstance(libraryName, Collections.singletonMap("classloader", classLoader));
   }

   public static final NativeLibrary getInstance(String libraryName, Map libraryOptions) {
      Map options = new HashMap(libraryOptions);
      if (options.get("calling-convention") == null) {
         options.put("calling-convention", 0);
      }

      if ((Platform.isLinux() || Platform.isFreeBSD() || Platform.isAIX()) && Platform.C_LIBRARY_NAME.equals(libraryName)) {
         libraryName = null;
      }

      synchronized(libraries) {
         Reference ref = (Reference)libraries.get(libraryName + options);
         NativeLibrary library = ref != null ? (NativeLibrary)ref.get() : null;
         if (library == null) {
            if (libraryName == null) {
               library = new NativeLibrary("<process>", (String)null, Native.open((String)null, openFlags(options)), options);
            } else {
               library = loadLibrary(libraryName, options);
            }

            Reference ref = new WeakReference(library);
            libraries.put(library.getName() + options, ref);
            File file = library.getFile();
            if (file != null) {
               libraries.put(file.getAbsolutePath() + options, ref);
               libraries.put(file.getName() + options, ref);
            }
         }

         return library;
      }
   }

   public static final synchronized NativeLibrary getProcess() {
      return getInstance((String)null);
   }

   public static final synchronized NativeLibrary getProcess(Map options) {
      return getInstance((String)null, (Map)options);
   }

   public static final void addSearchPath(String libraryName, String path) {
      synchronized(searchPaths) {
         List customPaths = (List)searchPaths.get(libraryName);
         if (customPaths == null) {
            customPaths = Collections.synchronizedList(new ArrayList());
            searchPaths.put(libraryName, customPaths);
         }

         customPaths.add(path);
      }
   }

   public Function getFunction(String functionName) {
      return this.getFunction(functionName, this.callFlags);
   }

   Function getFunction(String name, Method method) {
      FunctionMapper mapper = (FunctionMapper)this.options.get("function-mapper");
      if (mapper != null) {
         name = mapper.getFunctionName(this, method);
      }

      String prefix = System.getProperty("jna.profiler.prefix", "$$YJP$$");
      if (name.startsWith(prefix)) {
         name = name.substring(prefix.length());
      }

      int flags = this.callFlags;
      Class[] etypes = method.getExceptionTypes();

      for(int i = 0; i < etypes.length; ++i) {
         if (LastErrorException.class.isAssignableFrom(etypes[i])) {
            flags |= 64;
         }
      }

      return this.getFunction(name, flags);
   }

   public Function getFunction(String functionName, int callFlags) {
      return this.getFunction(functionName, callFlags, this.encoding);
   }

   public Function getFunction(String functionName, int callFlags, String encoding) {
      if (functionName == null) {
         throw new NullPointerException("Function name may not be null");
      } else {
         synchronized(this.functions) {
            String key = functionKey(functionName, callFlags, encoding);
            Function function = (Function)this.functions.get(key);
            if (function == null) {
               function = new Function(this, functionName, callFlags, encoding);
               this.functions.put(key, function);
            }

            return function;
         }
      }
   }

   public Map getOptions() {
      return this.options;
   }

   public Pointer getGlobalVariableAddress(String symbolName) {
      try {
         return new Pointer(this.getSymbolAddress(symbolName));
      } catch (UnsatisfiedLinkError var3) {
         throw new UnsatisfiedLinkError("Error looking up '" + symbolName + "': " + var3.getMessage());
      }
   }

   long getSymbolAddress(String name) {
      if (this.handle == 0L) {
         throw new UnsatisfiedLinkError("Library has been unloaded");
      } else {
         return Native.findSymbol(this.handle, name);
      }
   }

   public String toString() {
      return "Native Library <" + this.libraryPath + "@" + this.handle + ">";
   }

   public String getName() {
      return this.libraryName;
   }

   public File getFile() {
      return this.libraryPath == null ? null : new File(this.libraryPath);
   }

   protected void finalize() {
      this.dispose();
   }

   static void disposeAll() {
      LinkedHashSet values;
      synchronized(libraries) {
         values = new LinkedHashSet(libraries.values());
      }

      Iterator var1 = values.iterator();

      while(var1.hasNext()) {
         Reference ref = (Reference)var1.next();
         NativeLibrary lib = (NativeLibrary)ref.get();
         if (lib != null) {
            lib.dispose();
         }
      }

   }

   public void dispose() {
      Set keys = new HashSet();
      synchronized(libraries) {
         Iterator var3 = libraries.entrySet().iterator();

         while(true) {
            if (!var3.hasNext()) {
               var3 = keys.iterator();

               while(var3.hasNext()) {
                  String k = (String)var3.next();
                  libraries.remove(k);
               }
               break;
            }

            Entry e = (Entry)var3.next();
            Reference ref = (Reference)e.getValue();
            if (ref.get() == this) {
               keys.add(e.getKey());
            }
         }
      }

      synchronized(this) {
         if (this.handle != 0L) {
            Native.close(this.handle);
            this.handle = 0L;
         }

      }
   }

   private static List initPaths(String key) {
      String value = System.getProperty(key, "");
      if ("".equals(value)) {
         return Collections.emptyList();
      } else {
         StringTokenizer st = new StringTokenizer(value, File.pathSeparator);
         ArrayList list = new ArrayList();

         while(st.hasMoreTokens()) {
            String path = st.nextToken();
            if (!"".equals(path)) {
               list.add(path);
            }
         }

         return list;
      }
   }

   private static String findLibraryPath(String libName, List searchPath) {
      if ((new File(libName)).isAbsolute()) {
         return libName;
      } else {
         String name = mapSharedLibraryName(libName);
         Iterator var3 = searchPath.iterator();

         while(var3.hasNext()) {
            String path = (String)var3.next();
            File file = new File(path, name);
            if (file.exists()) {
               return file.getAbsolutePath();
            }

            if (Platform.isMac() && name.endsWith(".dylib")) {
               file = new File(path, name.substring(0, name.lastIndexOf(".dylib")) + ".jnilib");
               if (file.exists()) {
                  return file.getAbsolutePath();
               }
            }
         }

         return name;
      }
   }

   static String mapSharedLibraryName(String libName) {
      if (Platform.isMac()) {
         if (!libName.startsWith("lib") || !libName.endsWith(".dylib") && !libName.endsWith(".jnilib")) {
            String name = System.mapLibraryName(libName);
            return name.endsWith(".jnilib") ? name.substring(0, name.lastIndexOf(".jnilib")) + ".dylib" : name;
         } else {
            return libName;
         }
      } else {
         if (!Platform.isLinux() && !Platform.isFreeBSD()) {
            if (Platform.isAIX()) {
               if (libName.startsWith("lib")) {
                  return libName;
               }
            } else if (Platform.isWindows() && (libName.endsWith(".drv") || libName.endsWith(".dll"))) {
               return libName;
            }
         } else if (isVersionedName(libName) || libName.endsWith(".so")) {
            return libName;
         }

         return System.mapLibraryName(libName);
      }
   }

   private static boolean isVersionedName(String name) {
      if (name.startsWith("lib")) {
         int so = name.lastIndexOf(".so.");
         if (so != -1 && so + 4 < name.length()) {
            for(int i = so + 4; i < name.length(); ++i) {
               char ch = name.charAt(i);
               if (!Character.isDigit(ch) && ch != '.') {
                  return false;
               }
            }

            return true;
         }
      }

      return false;
   }

   static String matchLibrary(final String libName, List searchPath) {
      File lib = new File(libName);
      if (lib.isAbsolute()) {
         searchPath = Arrays.asList(lib.getParent());
      }

      FilenameFilter filter = new FilenameFilter() {
         public boolean accept(File dir, String filename) {
            return (filename.startsWith("lib" + libName + ".so") || filename.startsWith(libName + ".so") && libName.startsWith("lib")) && NativeLibrary.isVersionedName(filename);
         }
      };
      Collection matches = new LinkedList();
      Iterator var5 = searchPath.iterator();

      while(var5.hasNext()) {
         String path = (String)var5.next();
         File[] files = (new File(path)).listFiles(filter);
         if (files != null && files.length > 0) {
            matches.addAll(Arrays.asList(files));
         }
      }

      double bestVersion = -1.0D;
      String bestMatch = null;
      Iterator var8 = matches.iterator();

      while(var8.hasNext()) {
         File f = (File)var8.next();
         String path = f.getAbsolutePath();
         String ver = path.substring(path.lastIndexOf(".so.") + 4);
         double version = parseVersion(ver);
         if (version > bestVersion) {
            bestVersion = version;
            bestMatch = path;
         }
      }

      return bestMatch;
   }

   static double parseVersion(String ver) {
      double v = 0.0D;
      double divisor = 1.0D;

      for(int dot = ver.indexOf("."); ver != null; divisor *= 100.0D) {
         String num;
         if (dot != -1) {
            num = ver.substring(0, dot);
            ver = ver.substring(dot + 1);
            dot = ver.indexOf(".");
         } else {
            num = ver;
            ver = null;
         }

         try {
            v += (double)Integer.parseInt(num) / divisor;
         } catch (NumberFormatException var8) {
            return 0.0D;
         }
      }

      return v;
   }

   private static String getMultiArchPath() {
      String cpu = Platform.ARCH;
      String kernel = Platform.iskFreeBSD() ? "-kfreebsd" : (Platform.isGNU() ? "" : "-linux");
      String libc = "-gnu";
      if (Platform.isIntel()) {
         cpu = Platform.is64Bit() ? "x86_64" : "i386";
      } else if (Platform.isPPC()) {
         cpu = Platform.is64Bit() ? "powerpc64" : "powerpc";
      } else if (Platform.isARM()) {
         cpu = "arm";
         libc = "-gnueabi";
      } else if (Platform.ARCH.equals("mips64el")) {
         libc = "-gnuabi64";
      }

      return cpu + kernel + libc;
   }

   private static ArrayList getLinuxLdPaths() {
      ArrayList ldPaths = new ArrayList();

      try {
         Process process = Runtime.getRuntime().exec("/sbin/ldconfig -p");
         BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
         String buffer = "";

         while((buffer = reader.readLine()) != null) {
            int startPath = buffer.indexOf(" => ");
            int endPath = buffer.lastIndexOf(47);
            if (startPath != -1 && endPath != -1 && startPath < endPath) {
               String path = buffer.substring(startPath + 4, endPath);
               if (!ldPaths.contains(path)) {
                  ldPaths.add(path);
               }
            }
         }

         reader.close();
      } catch (Exception var7) {
      }

      return ldPaths;
   }

   static {
      if (Native.POINTER_SIZE == 0) {
         throw new Error("Native library not initialized");
      } else {
         String webstartPath = Native.getWebStartLibraryPath("jnidispatch");
         if (webstartPath != null) {
            librarySearchPath.add(webstartPath);
         }

         if (System.getProperty("jna.platform.library.path") == null && !Platform.isWindows()) {
            String platformPath = "";
            String sep = "";
            String archPath = "";
            if (Platform.isLinux() || Platform.isSolaris() || Platform.isFreeBSD() || Platform.iskFreeBSD()) {
               archPath = (Platform.isSolaris() ? "/" : "") + Pointer.SIZE * 8;
            }

            String[] paths = new String[]{"/usr/lib" + archPath, "/lib" + archPath, "/usr/lib", "/lib"};
            if (Platform.isLinux() || Platform.iskFreeBSD() || Platform.isGNU()) {
               String multiArchPath = getMultiArchPath();
               paths = new String[]{"/usr/lib/" + multiArchPath, "/lib/" + multiArchPath, "/usr/lib" + archPath, "/lib" + archPath, "/usr/lib", "/lib"};
            }

            if (Platform.isLinux()) {
               ArrayList ldPaths = getLinuxLdPaths();

               for(int i = paths.length - 1; 0 <= i; --i) {
                  int found = ldPaths.indexOf(paths[i]);
                  if (found != -1) {
                     ldPaths.remove(found);
                  }

                  ldPaths.add(0, paths[i]);
               }

               paths = (String[])ldPaths.toArray(new String[ldPaths.size()]);
            }

            for(int i = 0; i < paths.length; ++i) {
               File dir = new File(paths[i]);
               if (dir.exists() && dir.isDirectory()) {
                  platformPath = platformPath + sep + paths[i];
                  sep = File.pathSeparator;
               }
            }

            if (!"".equals(platformPath)) {
               System.setProperty("jna.platform.library.path", platformPath);
            }
         }

         librarySearchPath.addAll(initPaths("jna.platform.library.path"));
      }
   }
}
