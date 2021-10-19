package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Float;
import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JToolBar.Separator;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolBarSeparatorUI;

public class FlatToolBarSeparatorUI extends BasicToolBarSeparatorUI {
   private static final int LINE_WIDTH = 1;
   protected int separatorWidth;
   protected Color separatorColor;
   private boolean defaults_initialized = false;
   private static ComponentUI instance;

   public static ComponentUI createUI(JComponent c) {
      if (instance == null) {
         instance = new FlatToolBarSeparatorUI();
      }

      return instance;
   }

   protected void installDefaults(JSeparator c) {
      super.installDefaults(c);
      if (!this.defaults_initialized) {
         this.separatorWidth = UIManager.getInt("ToolBar.separatorWidth");
         this.separatorColor = UIManager.getColor("ToolBar.separatorColor");
         this.defaults_initialized = true;
      }

      c.setAlignmentX(0.0F);
   }

   protected void uninstallDefaults(JSeparator s) {
      super.uninstallDefaults(s);
      this.defaults_initialized = false;
   }

   public Dimension getPreferredSize(JComponent c) {
      Dimension size = ((Separator)c).getSeparatorSize();
      if (size != null) {
         return UIScale.scale(size);
      } else {
         int sepWidth = UIScale.scale((this.separatorWidth - 1) / 2) * 2 + UIScale.scale(1);
         boolean vertical = this.isVertical(c);
         return new Dimension(vertical ? sepWidth : 0, vertical ? 0 : sepWidth);
      }
   }

   public Dimension getMaximumSize(JComponent c) {
      Dimension size = this.getPreferredSize(c);
      return this.isVertical(c) ? new Dimension(size.width, 32767) : new Dimension(32767, size.height);
   }

   public void paint(Graphics g, JComponent c) {
      int width = c.getWidth();
      int height = c.getHeight();
      float lineWidth = UIScale.scale(1.0F);
      float offset = UIScale.scale(2.0F);
      FlatUIUtils.setRenderingHints((Graphics2D)g);
      g.setColor(this.separatorColor);
      if (this.isVertical(c)) {
         ((Graphics2D)g).fill(new Float((float)Math.round(((float)width - lineWidth) / 2.0F), offset, lineWidth, (float)height - offset * 2.0F));
      } else {
         ((Graphics2D)g).fill(new Float(offset, (float)Math.round(((float)height - lineWidth) / 2.0F), (float)width - offset * 2.0F, lineWidth));
      }

   }

   private boolean isVertical(JComponent c) {
      return ((Separator)c).getOrientation() == 1;
   }
}
