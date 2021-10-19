package com.formdev.flatlaf;

public class FlatIntelliJLaf extends FlatLightLaf {
   public static boolean install() {
      return install(new FlatIntelliJLaf());
   }

   public String getName() {
      return "FlatLaf IntelliJ";
   }

   public String getDescription() {
      return "FlatLaf IntelliJ Look and Feel";
   }
}
