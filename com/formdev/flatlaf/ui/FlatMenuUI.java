package com.formdev.flatlaf.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuUI;
import javax.swing.plaf.basic.BasicMenuUI.MouseInputHandler;

public class FlatMenuUI extends BasicMenuUI {
   private Color hoverBackground;
   private FlatMenuItemRenderer renderer;

   public static ComponentUI createUI(JComponent c) {
      return new FlatMenuUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      LookAndFeel.installProperty(this.menuItem, "iconTextGap", FlatUIUtils.getUIInt("MenuItem.iconTextGap", 4));
      this.menuItem.setRolloverEnabled(true);
      this.hoverBackground = UIManager.getColor("MenuBar.hoverBackground");
      this.renderer = this.createRenderer();
   }

   protected void uninstallDefaults() {
      super.uninstallDefaults();
      this.hoverBackground = null;
      this.renderer = null;
   }

   protected FlatMenuItemRenderer createRenderer() {
      return new FlatMenuUI.FlatMenuRenderer(this.menuItem, this.checkIcon, this.arrowIcon, this.acceleratorFont, this.acceleratorDelimiter);
   }

   protected MouseInputListener createMouseInputListener(JComponent c) {
      return new MouseInputHandler() {
         public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            this.rollover(e, true);
         }

         public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            this.rollover(e, false);
         }

         private void rollover(MouseEvent e, boolean rollover) {
            JMenu menu = (JMenu)e.getSource();
            if (menu.isTopLevelMenu() && menu.isRolloverEnabled()) {
               menu.getModel().setRollover(rollover);
               menu.repaint();
            }

         }
      };
   }

   protected Dimension getPreferredMenuItemSize(JComponent c, Icon checkIcon, Icon arrowIcon, int defaultTextIconGap) {
      return this.renderer.getPreferredMenuItemSize();
   }

   public void paint(Graphics g, JComponent c) {
      this.renderer.paintMenuItem(g, this.selectionBackground, this.selectionForeground, this.disabledForeground, this.acceleratorForeground, this.acceleratorSelectionForeground);
   }

   protected class FlatMenuRenderer extends FlatMenuItemRenderer {
      protected FlatMenuRenderer(JMenuItem menuItem, Icon checkIcon, Icon arrowIcon, Font acceleratorFont, String acceleratorDelimiter) {
         super(menuItem, checkIcon, arrowIcon, acceleratorFont, acceleratorDelimiter);
      }

      protected void paintBackground(Graphics g, Color selectionBackground) {
         ButtonModel model = this.menuItem.getModel();
         if (model.isRollover() && !model.isArmed() && !model.isSelected() && model.isEnabled() && ((JMenu)this.menuItem).isTopLevelMenu()) {
            g.setColor(this.deriveBackground(FlatMenuUI.this.hoverBackground));
            g.fillRect(0, 0, this.menuItem.getWidth(), this.menuItem.getHeight());
         } else {
            super.paintBackground(g, selectionBackground);
         }

      }
   }
}
