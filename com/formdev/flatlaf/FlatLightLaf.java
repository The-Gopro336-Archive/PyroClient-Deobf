package com.formdev.flatlaf;

public class FlatLightLaf extends FlatLaf {
   public static boolean install() {
      return install(new FlatLightLaf());
   }

   public String getName() {
      return "FlatLaf Light";
   }

   public String getDescription() {
      return "FlatLaf Light Look and Feel";
   }

   public boolean isDark() {
      return false;
   }
}
