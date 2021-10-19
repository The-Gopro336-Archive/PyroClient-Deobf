package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public class FlatToolBarBorder extends FlatMarginBorder {
   private static final int DOT_COUNT = 4;
   private static final int DOT_SIZE = 2;
   private static final int GRIP_WIDTH = 6;
   protected final Color gripColor = UIManager.getColor("ToolBar.gripColor");

   public FlatToolBarBorder() {
      super(UIManager.getInsets("ToolBar.borderMargins"));
   }

   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      if (c instanceof JToolBar && ((JToolBar)c).isFloatable()) {
         Graphics2D g2 = (Graphics2D)g.create();

         try {
            FlatUIUtils.setRenderingHints(g2);
            g2.setColor(this.gripColor);
            this.paintGrip(c, g2, x, y, width, height);
         } finally {
            g2.dispose();
         }
      }

   }

   protected void paintGrip(Component c, Graphics g, int x, int y, int width, int height) {
      int dotSize = UIScale.scale(2);
      int gapSize = dotSize;
      int gripSize = dotSize * 4 + dotSize * 3;
      Insets insets = this.getBorderInsets(c);
      boolean horizontal = ((JToolBar)c).getOrientation() == 0;
      if (horizontal) {
         if (c.getComponentOrientation().isLeftToRight()) {
            x += insets.left - dotSize * 2;
         } else {
            x += width - insets.right + dotSize;
         }

         y += Math.round((float)(height - gripSize) / 2.0F);
      } else {
         x += Math.round((float)(width - gripSize) / 2.0F);
         y += insets.top - dotSize * 2;
      }

      for(int i = 0; i < 4; ++i) {
         g.fillOval(x, y, dotSize, dotSize);
         if (horizontal) {
            y += dotSize + gapSize;
         } else {
            x += dotSize + gapSize;
         }
      }

   }

   public Insets getBorderInsets(Component c, Insets insets) {
      insets = super.getBorderInsets(c, insets);
      if (c instanceof JToolBar && ((JToolBar)c).isFloatable()) {
         int gripInset = UIScale.scale(6);
         if (((JToolBar)c).getOrientation() == 0) {
            if (c.getComponentOrientation().isLeftToRight()) {
               insets.left += gripInset;
            } else {
               insets.right += gripInset;
            }
         } else {
            insets.top += gripInset;
         }
      }

      return insets;
   }
}
