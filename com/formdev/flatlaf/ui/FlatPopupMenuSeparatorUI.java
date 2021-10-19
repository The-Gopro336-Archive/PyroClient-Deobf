package com.formdev.flatlaf.ui;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class FlatPopupMenuSeparatorUI extends FlatSeparatorUI {
   private static ComponentUI instance;

   public static ComponentUI createUI(JComponent c) {
      if (instance == null) {
         instance = new FlatPopupMenuSeparatorUI();
      }

      return instance;
   }

   protected String getPropertyPrefix() {
      return "PopupMenuSeparator";
   }
}
