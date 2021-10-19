package com.formdev.flatlaf.util;

import java.util.Locale;
import java.util.StringTokenizer;

public class SystemInfo {
   public static final boolean IS_WINDOWS;
   public static final boolean IS_MAC;
   public static final boolean IS_LINUX;
   public static final boolean IS_WINDOWS_10_OR_LATER;
   public static final boolean IS_MAC_OS_10_11_EL_CAPITAN_OR_LATER;
   public static final boolean IS_MAC_OS_10_14_MOJAVE;
   public static final boolean IS_MAC_OS_10_15_CATALINA_OR_LATER;
   public static final boolean IS_JAVA_9_OR_LATER;
   public static final boolean IS_JAVA_11_OR_LATER;
   public static final boolean IS_JAVA_15_OR_LATER;
   public static final boolean IS_JETBRAINS_JVM;
   public static final boolean IS_JETBRAINS_JVM_11_OR_LATER;
   public static final boolean IS_KDE;

   public static long scanVersion(String version) {
      int major = 1;
      int minor = 0;
      int micro = 0;
      int patch = 0;

      try {
         StringTokenizer st = new StringTokenizer(version, "._-+");
         major = Integer.parseInt(st.nextToken());
         minor = Integer.parseInt(st.nextToken());
         micro = Integer.parseInt(st.nextToken());
         patch = Integer.parseInt(st.nextToken());
      } catch (Exception var6) {
      }

      return toVersion(major, minor, micro, patch);
   }

   public static long toVersion(int major, int minor, int micro, int patch) {
      return ((long)major << 48) + ((long)minor << 32) + ((long)micro << 16) + (long)patch;
   }

   static {
      String osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
      IS_WINDOWS = osName.startsWith("windows");
      IS_MAC = osName.startsWith("mac");
      IS_LINUX = osName.startsWith("linux");
      long osVersion = scanVersion(System.getProperty("os.version"));
      IS_WINDOWS_10_OR_LATER = IS_WINDOWS && osVersion >= toVersion(10, 0, 0, 0);
      IS_MAC_OS_10_11_EL_CAPITAN_OR_LATER = IS_MAC && osVersion >= toVersion(10, 11, 0, 0);
      IS_MAC_OS_10_14_MOJAVE = IS_MAC && osVersion >= toVersion(10, 14, 0, 0);
      IS_MAC_OS_10_15_CATALINA_OR_LATER = IS_MAC && osVersion >= toVersion(10, 15, 0, 0);
      long javaVersion = scanVersion(System.getProperty("java.version"));
      IS_JAVA_9_OR_LATER = javaVersion >= toVersion(9, 0, 0, 0);
      IS_JAVA_11_OR_LATER = javaVersion >= toVersion(11, 0, 0, 0);
      IS_JAVA_15_OR_LATER = javaVersion >= toVersion(15, 0, 0, 0);
      IS_JETBRAINS_JVM = System.getProperty("java.vm.vendor", "Unknown").toLowerCase(Locale.ENGLISH).contains("jetbrains");
      IS_JETBRAINS_JVM_11_OR_LATER = IS_JETBRAINS_JVM && IS_JAVA_11_OR_LATER;
      IS_KDE = IS_LINUX && System.getenv("KDE_FULL_SESSION") != null;
   }
}
