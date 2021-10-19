package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D.Float;
import javax.swing.JMenuBar;
import javax.swing.UIManager;

public class FlatMenuBarBorder extends FlatMarginBorder {
   private final Color borderColor = UIManager.getColor("MenuBar.borderColor");

   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      Graphics2D g2 = (Graphics2D)g.create();

      try {
         float lineHeight = UIScale.scale(1.0F);
         FlatUIUtils.setRenderingHints(g2);
         g2.setColor(this.borderColor);
         g2.fill(new Float((float)x, (float)(y + height) - lineHeight, (float)width, lineHeight));
      } finally {
         g2.dispose();
      }

   }

   public Insets getBorderInsets(Component c, Insets insets) {
      Insets margin = c instanceof JMenuBar ? ((JMenuBar)c).getMargin() : new Insets(0, 0, 0, 0);
      insets.top = UIScale.scale(margin.top);
      insets.left = UIScale.scale(margin.left);
      insets.bottom = UIScale.scale(margin.bottom + 1);
      insets.right = UIScale.scale(margin.right);
      return insets;
   }
}
