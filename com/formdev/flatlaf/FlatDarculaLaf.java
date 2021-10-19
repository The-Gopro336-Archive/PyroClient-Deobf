package com.formdev.flatlaf;

public class FlatDarculaLaf extends FlatDarkLaf {
   public static boolean install() {
      return install(new FlatDarculaLaf());
   }

   public String getName() {
      return "FlatLaf Darcula";
   }

   public String getDescription() {
      return "FlatLaf Darcula Look and Feel";
   }
}
