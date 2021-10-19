package com.formdev.flatlaf;

import com.formdev.flatlaf.util.StringUtils;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;

class LinuxFontPolicy {
   static Font getFont() {
      return SystemInfo.IS_KDE ? getKDEFont() : getGnomeFont();
   }

   private static Font getGnomeFont() {
      Object fontName = Toolkit.getDefaultToolkit().getDesktopProperty("gnome.Gtk/FontName");
      if (!(fontName instanceof String)) {
         fontName = "sans 10";
      }

      String family = "";
      int style = 0;
      int size = 10;
      StringTokenizer st = new StringTokenizer((String)fontName);

      while(st.hasMoreTokens()) {
         String word = st.nextToken();
         if (word.equalsIgnoreCase("italic")) {
            style |= 2;
         } else if (word.equalsIgnoreCase("bold")) {
            style |= 1;
         } else if (Character.isDigit(word.charAt(0))) {
            try {
               size = Integer.parseInt(word);
            } catch (NumberFormatException var8) {
            }
         } else {
            family = family.isEmpty() ? word : family + ' ' + word;
         }
      }

      if (family.startsWith("Ubuntu") && !SystemInfo.IS_JETBRAINS_JVM && !FlatSystemProperties.getBoolean("flatlaf.useUbuntuFont", false)) {
         family = "Liberation Sans";
      }

      double dsize = (double)size * getGnomeFontScale();
      size = (int)(dsize + 0.5D);
      if (size < 1) {
         size = 1;
      }

      String logicalFamily = mapFcName(family.toLowerCase());
      if (logicalFamily != null) {
         family = logicalFamily;
      }

      return createFont(family, style, size, dsize);
   }

   private static Font createFont(String family, int style, int size, double dsize) {
      Font font = FlatLaf.createCompositeFont(family, style, size);
      Font font = font.deriveFont(style, (float)dsize);
      return font;
   }

   private static double getGnomeFontScale() {
      if (isSystemScaling()) {
         return 1.3333333333333333D;
      } else {
         Object value = Toolkit.getDefaultToolkit().getDesktopProperty("gnome.Xft/DPI");
         if (value instanceof Integer) {
            int dpi = (Integer)value / 1024;
            if (dpi == -1) {
               dpi = 96;
            }

            if (dpi < 50) {
               dpi = 50;
            }

            return (double)dpi / 72.0D;
         } else {
            return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getNormalizingTransform().getScaleY();
         }
      }
   }

   private static String mapFcName(String name) {
      byte var2 = -1;
      switch(name.hashCode()) {
      case -1536685117:
         if (name.equals("sans-serif")) {
            var2 = 1;
         }
         break;
      case -1431958525:
         if (name.equals("monospace")) {
            var2 = 3;
         }
         break;
      case 3522707:
         if (name.equals("sans")) {
            var2 = 0;
         }
         break;
      case 109326717:
         if (name.equals("serif")) {
            var2 = 2;
         }
      }

      switch(var2) {
      case 0:
         return "sansserif";
      case 1:
         return "sansserif";
      case 2:
         return "serif";
      case 3:
         return "monospaced";
      default:
         return null;
      }
   }

   private static Font getKDEFont() {
      List kdeglobals = readConfig("kdeglobals");
      List kcmfonts = readConfig("kcmfonts");
      String generalFont = getConfigEntry(kdeglobals, "General", "font");
      String forceFontDPI = getConfigEntry(kcmfonts, "General", "forceFontDPI");
      String family = "sansserif";
      int style = 0;
      int size = 10;
      if (generalFont != null) {
         List strs = StringUtils.split(generalFont, ',');

         try {
            family = (String)strs.get(0);
            size = Integer.parseInt((String)strs.get(1));
            if ("75".equals(strs.get(4))) {
               style |= 1;
            }

            if ("1".equals(strs.get(5))) {
               style |= 2;
            }
         } catch (RuntimeException var13) {
            FlatLaf.LOG.log(Level.CONFIG, "FlatLaf: Failed to parse 'font=" + generalFont + "'.", var13);
         }
      }

      int dpi = 96;
      if (forceFontDPI != null && !isSystemScaling()) {
         try {
            dpi = Integer.parseInt(forceFontDPI);
            if (dpi <= 0) {
               dpi = 96;
            }

            if (dpi < 50) {
               dpi = 50;
            }
         } catch (NumberFormatException var12) {
            FlatLaf.LOG.log(Level.CONFIG, "FlatLaf: Failed to parse 'forceFontDPI=" + forceFontDPI + "'.", var12);
         }
      }

      double fontScale = (double)dpi / 72.0D;
      double dsize = (double)size * fontScale;
      size = (int)(dsize + 0.5D);
      if (size < 1) {
         size = 1;
      }

      return createFont(family, style, size, dsize);
   }

   private static List readConfig(String filename) {
      File userHome = new File(System.getProperty("user.home"));
      String[] configDirs = new String[]{".config", ".kde4/share/config", ".kde/share/config"};
      File file = null;
      String[] var4 = configDirs;
      int var5 = configDirs.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         String configDir = var4[var6];
         file = new File(userHome, configDir + "/" + filename);
         if (file.isFile()) {
            break;
         }
      }

      if (!file.isFile()) {
         return Collections.emptyList();
      } else {
         ArrayList lines = new ArrayList(200);

         try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            try {
               String line = null;

               while((line = reader.readLine()) != null) {
                  lines.add(line);
               }
            } catch (Throwable var9) {
               try {
                  reader.close();
               } catch (Throwable var8) {
                  var9.addSuppressed(var8);
               }

               throw var9;
            }

            reader.close();
         } catch (IOException var10) {
            FlatLaf.LOG.log(Level.CONFIG, "FlatLaf: Failed to read '" + filename + "'.", var10);
         }

         return lines;
      }
   }

   private static String getConfigEntry(List config, String group, String key) {
      int groupLength = group.length();
      int keyLength = key.length();
      boolean inGroup = false;
      Iterator var6 = config.iterator();

      while(var6.hasNext()) {
         String line = (String)var6.next();
         if (!inGroup) {
            if (line.length() >= groupLength + 2 && line.charAt(0) == '[' && line.charAt(groupLength + 1) == ']' && line.indexOf(group) == 1) {
               inGroup = true;
            }
         } else {
            if (line.startsWith("[")) {
               return null;
            }

            if (line.length() >= keyLength + 2 && line.charAt(keyLength) == '=' && line.startsWith(key)) {
               return line.substring(keyLength + 1);
            }
         }
      }

      return null;
   }

   private static boolean isSystemScaling() {
      GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
      return UIScale.getSystemScaleFactor(gc) > 1.0D;
   }
}
