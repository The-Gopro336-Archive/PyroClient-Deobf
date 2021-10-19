package com.formdev.flatlaf.ui;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class FlatCheckBoxUI extends FlatRadioButtonUI {
   private static ComponentUI instance;

   public static ComponentUI createUI(JComponent c) {
      if (instance == null) {
         instance = new FlatCheckBoxUI();
      }

      return instance;
   }

   public String getPropertyPrefix() {
      return "CheckBox.";
   }
}
