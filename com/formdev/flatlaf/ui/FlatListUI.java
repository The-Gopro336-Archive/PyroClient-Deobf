package com.formdev.flatlaf.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.plaf.basic.BasicListUI.FocusHandler;

public class FlatListUI extends BasicListUI {
   protected Color selectionBackground;
   protected Color selectionForeground;
   protected Color selectionInactiveBackground;
   protected Color selectionInactiveForeground;

   public static ComponentUI createUI(JComponent c) {
      return new FlatListUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      this.selectionBackground = UIManager.getColor("List.selectionBackground");
      this.selectionForeground = UIManager.getColor("List.selectionForeground");
      this.selectionInactiveBackground = UIManager.getColor("List.selectionInactiveBackground");
      this.selectionInactiveForeground = UIManager.getColor("List.selectionInactiveForeground");
      this.toggleSelectionColors();
   }

   protected void uninstallDefaults() {
      super.uninstallDefaults();
      this.selectionBackground = null;
      this.selectionForeground = null;
      this.selectionInactiveBackground = null;
      this.selectionInactiveForeground = null;
   }

   protected FocusListener createFocusListener() {
      return new FocusHandler() {
         public void focusGained(FocusEvent e) {
            super.focusGained(e);
            FlatListUI.this.toggleSelectionColors();
         }

         public void focusLost(FocusEvent e) {
            super.focusLost(e);
            EventQueue.invokeLater(() -> {
               FlatListUI.this.toggleSelectionColors();
            });
         }
      };
   }

   private void toggleSelectionColors() {
      if (FlatUIUtils.isPermanentFocusOwner(this.list)) {
         if (this.list.getSelectionBackground() == this.selectionInactiveBackground) {
            this.list.setSelectionBackground(this.selectionBackground);
         }

         if (this.list.getSelectionForeground() == this.selectionInactiveForeground) {
            this.list.setSelectionForeground(this.selectionForeground);
         }
      } else {
         if (this.list.getSelectionBackground() == this.selectionBackground) {
            this.list.setSelectionBackground(this.selectionInactiveBackground);
         }

         if (this.list.getSelectionForeground() == this.selectionForeground) {
            this.list.setSelectionForeground(this.selectionInactiveForeground);
         }
      }

   }
}
