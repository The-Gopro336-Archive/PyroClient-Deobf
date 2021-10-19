package com.formdev.flatlaf;

public class FlatDarkLaf extends FlatLaf {
   public static boolean install() {
      return install(new FlatDarkLaf());
   }

   public String getName() {
      return "FlatLaf Dark";
   }

   public String getDescription() {
      return "FlatLaf Dark Look and Feel";
   }

   public boolean isDark() {
      return true;
   }
}
