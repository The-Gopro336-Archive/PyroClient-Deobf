package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class FlatPopupMenuBorder extends FlatLineBorder {
   public FlatPopupMenuBorder() {
      super(UIManager.getInsets("PopupMenu.borderInsets"), UIManager.getColor("PopupMenu.borderColor"));
   }

   public Insets getBorderInsets(Component c, Insets insets) {
      if (c instanceof Container && ((Container)c).getComponentCount() > 0 && ((Container)c).getComponent(0) instanceof JScrollPane) {
         insets.left = insets.top = insets.right = insets.bottom = UIScale.scale(1);
         return insets;
      } else {
         return super.getBorderInsets(c, insets);
      }
   }
}
