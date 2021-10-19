package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.HiDPIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D.Float;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class FlatProgressBarUI extends BasicProgressBarUI {
   protected int arc;
   protected Dimension horizontalSize;
   protected Dimension verticalSize;
   private PropertyChangeListener propertyChangeListener;

   public static ComponentUI createUI(JComponent c) {
      return new FlatProgressBarUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      LookAndFeel.installProperty(this.progressBar, "opaque", false);
      this.arc = UIManager.getInt("ProgressBar.arc");
      this.horizontalSize = UIManager.getDimension("ProgressBar.horizontalSize");
      this.verticalSize = UIManager.getDimension("ProgressBar.verticalSize");
   }

   protected void installListeners() {
      super.installListeners();
      this.propertyChangeListener = (e) -> {
         String var2 = e.getPropertyName();
         byte var3 = -1;
         switch(var2.hashCode()) {
         case 904341840:
            if (var2.equals("JProgressBar.largeHeight")) {
               var3 = 0;
            }
            break;
         case 2133843791:
            if (var2.equals("JProgressBar.square")) {
               var3 = 1;
            }
         }

         switch(var3) {
         case 0:
         case 1:
            this.progressBar.revalidate();
            this.progressBar.repaint();
         default:
         }
      };
      this.progressBar.addPropertyChangeListener(this.propertyChangeListener);
   }

   protected void uninstallListeners() {
      super.uninstallListeners();
      this.progressBar.removePropertyChangeListener(this.propertyChangeListener);
      this.propertyChangeListener = null;
   }

   public Dimension getPreferredSize(JComponent c) {
      Dimension size = super.getPreferredSize(c);
      if (this.progressBar.isStringPainted() || FlatClientProperties.clientPropertyBoolean(c, "JProgressBar.largeHeight", false)) {
         Insets insets = this.progressBar.getInsets();
         FontMetrics fm = this.progressBar.getFontMetrics(this.progressBar.getFont());
         if (this.progressBar.getOrientation() == 0) {
            size.height = Math.max(fm.getHeight() + insets.top + insets.bottom, this.getPreferredInnerHorizontal().height);
         } else {
            size.width = Math.max(fm.getHeight() + insets.left + insets.right, this.getPreferredInnerVertical().width);
         }
      }

      return size;
   }

   protected Dimension getPreferredInnerHorizontal() {
      return UIScale.scale(this.horizontalSize);
   }

   protected Dimension getPreferredInnerVertical() {
      return UIScale.scale(this.verticalSize);
   }

   public void update(Graphics g, JComponent c) {
      if (c.isOpaque()) {
         FlatUIUtils.paintParentBackground(g, c);
      }

      this.paint(g, c);
   }

   public void paint(Graphics g, JComponent c) {
      Insets insets = this.progressBar.getInsets();
      int x = insets.left;
      int y = insets.top;
      int width = this.progressBar.getWidth() - (insets.right + insets.left);
      int height = this.progressBar.getHeight() - (insets.top + insets.bottom);
      if (width > 0 && height > 0) {
         boolean horizontal = this.progressBar.getOrientation() == 0;
         int arc = FlatClientProperties.clientPropertyBoolean(c, "JProgressBar.square", false) ? 0 : Math.min(UIScale.scale(this.arc), horizontal ? height : width);
         FlatUIUtils.setRenderingHints((Graphics2D)g);
         Float trackShape = new Float((float)x, (float)y, (float)width, (float)height, (float)arc, (float)arc);
         g.setColor(this.progressBar.getBackground());
         ((Graphics2D)g).fill(trackShape);
         if (this.progressBar.isIndeterminate()) {
            this.boxRect = this.getBox(this.boxRect);
            if (this.boxRect != null) {
               g.setColor(this.progressBar.getForeground());
               ((Graphics2D)g).fill(new Float((float)this.boxRect.x, (float)this.boxRect.y, (float)this.boxRect.width, (float)this.boxRect.height, (float)arc, (float)arc));
            }

            if (this.progressBar.isStringPainted()) {
               this.paintString(g, x, y, width, height, 0, insets);
            }
         } else {
            int amountFull = this.getAmountFull(insets, width, height);
            Float progressShape = horizontal ? new Float(c.getComponentOrientation().isLeftToRight() ? (float)x : (float)(x + (width - amountFull)), (float)y, (float)amountFull, (float)height, (float)arc, (float)arc) : new Float((float)x, (float)(y + (height - amountFull)), (float)width, (float)amountFull, (float)arc, (float)arc);
            g.setColor(this.progressBar.getForeground());
            if (amountFull < (horizontal ? height : width)) {
               Area area = new Area(trackShape);
               area.intersect(new Area(progressShape));
               ((Graphics2D)g).fill(area);
            } else {
               ((Graphics2D)g).fill(progressShape);
            }

            if (this.progressBar.isStringPainted()) {
               this.paintString(g, x, y, width, height, amountFull, insets);
            }
         }

      }
   }

   protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
      super.paintString(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g), x, y, width, height, amountFull, b);
   }

   protected void setAnimationIndex(int newValue) {
      super.setAnimationIndex(newValue);
      double systemScaleFactor = UIScale.getSystemScaleFactor(this.progressBar.getGraphicsConfiguration());
      if ((double)((int)systemScaleFactor) != systemScaleFactor) {
         this.progressBar.repaint();
      }

   }
}
