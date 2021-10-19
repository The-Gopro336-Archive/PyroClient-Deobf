package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.HiDPIUtils;
import com.formdev.flatlaf.util.StringUtils;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolTipUI;

public class FlatToolTipUI extends BasicToolTipUI {
   private static PropertyChangeListener sharedPropertyChangedListener;
   private static ComponentUI instance;

   public static ComponentUI createUI(JComponent c) {
      if (instance == null) {
         instance = new FlatToolTipUI();
      }

      return instance;
   }

   public void installUI(JComponent c) {
      super.installUI(c);
      FlatLabelUI.updateHTMLRenderer(c, ((JToolTip)c).getTipText(), false);
   }

   protected void installListeners(JComponent c) {
      super.installListeners(c);
      if (sharedPropertyChangedListener == null) {
         sharedPropertyChangedListener = (e) -> {
            String name = e.getPropertyName();
            if (name == "text" || name == "font" || name == "foreground") {
               JToolTip toolTip = (JToolTip)e.getSource();
               FlatLabelUI.updateHTMLRenderer(toolTip, toolTip.getTipText(), false);
            }

         };
      }

      c.addPropertyChangeListener(sharedPropertyChangedListener);
   }

   protected void uninstallListeners(JComponent c) {
      super.uninstallListeners(c);
      c.removePropertyChangeListener(sharedPropertyChangedListener);
   }

   public Dimension getPreferredSize(JComponent c) {
      if (!this.isMultiLine(c)) {
         return super.getPreferredSize(c);
      } else {
         FontMetrics fm = c.getFontMetrics(c.getFont());
         Insets insets = c.getInsets();
         List lines = StringUtils.split(((JToolTip)c).getTipText(), '\n');
         int width = 0;
         int height = fm.getHeight() * Math.max(lines.size(), 1);

         String line;
         for(Iterator var7 = lines.iterator(); var7.hasNext(); width = Math.max(width, SwingUtilities.computeStringWidth(fm, line))) {
            line = (String)var7.next();
         }

         return new Dimension(insets.left + width + insets.right + 6, insets.top + height + insets.bottom);
      }
   }

   public void paint(Graphics g, JComponent c) {
      if (this.isMultiLine(c)) {
         FontMetrics fm = c.getFontMetrics(c.getFont());
         Insets insets = c.getInsets();
         FlatUIUtils.setRenderingHints((Graphics2D)g);
         g.setColor(c.getForeground());
         List lines = StringUtils.split(((JToolTip)c).getTipText(), '\n');
         int x = insets.left + 3;
         int x2 = c.getWidth() - insets.right - 3;
         int y = insets.top - fm.getDescent();
         int lineHeight = fm.getHeight();
         JComponent comp = ((JToolTip)c).getComponent();
         boolean leftToRight = (comp != null ? comp : c).getComponentOrientation().isLeftToRight();
         Iterator var12 = lines.iterator();

         while(var12.hasNext()) {
            String line = (String)var12.next();
            y += lineHeight;
            FlatUIUtils.drawString(c, g, line, leftToRight ? x : x2 - SwingUtilities.computeStringWidth(fm, line), y);
         }
      } else {
         super.paint(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g), c);
      }

   }

   private boolean isMultiLine(JComponent c) {
      String text = ((JToolTip)c).getTipText();
      return c.getClientProperty("html") == null && text != null && text.indexOf(10) >= 0;
   }
}
