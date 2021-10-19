package com.formdev.flatlaf;

public interface FlatSystemProperties {
   String UI_SCALE = "flatlaf.uiScale";
   String USE_UBUNTU_FONT = "flatlaf.useUbuntuFont";
   String USE_WINDOW_DECORATIONS = "flatlaf.useWindowDecorations";
   String USE_JETBRAINS_CUSTOM_DECORATIONS = "flatlaf.useJetBrainsCustomDecorations";
   String MENUBAR_EMBEDDED = "flatlaf.menuBarEmbedded";
   String USE_TEXT_Y_CORRECTION = "flatlaf.useTextYCorrection";

   static boolean getBoolean(String key, boolean defaultValue) {
      String value = System.getProperty(key);
      return value != null ? Boolean.parseBoolean(value) : defaultValue;
   }

   static Boolean getBooleanStrict(String key, Boolean defaultValue) {
      String value = System.getProperty(key);
      if ("true".equalsIgnoreCase(value)) {
         return Boolean.TRUE;
      } else {
         return "false".equalsIgnoreCase(value) ? Boolean.FALSE : defaultValue;
      }
   }
}
