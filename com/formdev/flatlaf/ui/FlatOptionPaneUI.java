package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonAreaLayout;

public class FlatOptionPaneUI extends BasicOptionPaneUI {
   protected int iconMessageGap;
   protected int messagePadding;
   protected int maxCharactersPerLine;
   private int focusWidth;

   public static ComponentUI createUI(JComponent c) {
      return new FlatOptionPaneUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      this.iconMessageGap = UIManager.getInt("OptionPane.iconMessageGap");
      this.messagePadding = UIManager.getInt("OptionPane.messagePadding");
      this.maxCharactersPerLine = UIManager.getInt("OptionPane.maxCharactersPerLine");
      this.focusWidth = UIManager.getInt("Component.focusWidth");
   }

   protected void installComponents() {
      super.installComponents();
      this.updateChildPanels(this.optionPane);
   }

   public Dimension getMinimumOptionPaneSize() {
      return UIScale.scale(super.getMinimumOptionPaneSize());
   }

   protected int getMaxCharactersPerLineCount() {
      int max = super.getMaxCharactersPerLineCount();
      return this.maxCharactersPerLine > 0 && max == Integer.MAX_VALUE ? this.maxCharactersPerLine : max;
   }

   protected Container createMessageArea() {
      Container messageArea = super.createMessageArea();
      if (this.iconMessageGap > 0) {
         Component iconMessageSeparator = this.findByName(messageArea, "OptionPane.separator");
         if (iconMessageSeparator != null) {
            iconMessageSeparator.setPreferredSize(new Dimension(UIScale.scale(this.iconMessageGap), 1));
         }
      }

      return messageArea;
   }

   protected Container createButtonArea() {
      Container buttonArea = super.createButtonArea();
      if (buttonArea.getLayout() instanceof ButtonAreaLayout) {
         ButtonAreaLayout layout = (ButtonAreaLayout)buttonArea.getLayout();
         layout.setPadding(UIScale.scale(layout.getPadding() - this.focusWidth * 2));
      }

      return buttonArea;
   }

   protected void addMessageComponents(Container container, GridBagConstraints cons, Object msg, int maxll, boolean internallyCreated) {
      if (this.messagePadding > 0) {
         cons.insets.bottom = UIScale.scale(this.messagePadding);
      }

      if (msg instanceof String && BasicHTML.isHTMLString((String)msg)) {
         maxll = Integer.MAX_VALUE;
      }

      super.addMessageComponents(container, cons, msg, maxll, internallyCreated);
   }

   private void updateChildPanels(Container c) {
      Component[] var2 = c.getComponents();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Component child = var2[var4];
         if (child instanceof JPanel) {
            JPanel panel = (JPanel)child;
            panel.setOpaque(false);
            Border border = panel.getBorder();
            if (border instanceof UIResource) {
               panel.setBorder(new FlatOptionPaneUI.NonUIResourceBorder(border));
            }
         }

         if (child instanceof Container) {
            this.updateChildPanels((Container)child);
         }
      }

   }

   private Component findByName(Container c, String name) {
      Component[] var3 = c.getComponents();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Component child = var3[var5];
         if (name.equals(child.getName())) {
            return child;
         }

         if (child instanceof Container) {
            Component c2 = this.findByName((Container)child, name);
            if (c2 != null) {
               return c2;
            }
         }
      }

      return null;
   }

   private static class NonUIResourceBorder implements Border {
      private final Border delegate;

      NonUIResourceBorder(Border delegate) {
         this.delegate = delegate;
      }

      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         this.delegate.paintBorder(c, g, x, y, width, height);
      }

      public Insets getBorderInsets(Component c) {
         return this.delegate.getBorderInsets(c);
      }

      public boolean isBorderOpaque() {
         return this.delegate.isBorderOpaque();
      }
   }
}
