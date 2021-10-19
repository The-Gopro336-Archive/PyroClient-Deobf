package com.formdev.flatlaf.icons;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Path2D.Float;
import javax.swing.AbstractButton;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class FlatCheckBoxMenuItemIcon extends FlatAbstractIcon {
   protected final Color checkmarkColor = UIManager.getColor("MenuItemCheckBox.icon.checkmarkColor");
   protected final Color disabledCheckmarkColor = UIManager.getColor("MenuItemCheckBox.icon.disabledCheckmarkColor");
   protected final Color selectionForeground = UIManager.getColor("MenuItem.selectionForeground");

   public FlatCheckBoxMenuItemIcon() {
      super(15, 15, (Color)null);
   }

   protected void paintIcon(Component c, Graphics2D g2) {
      boolean selected = c instanceof AbstractButton && ((AbstractButton)c).isSelected();
      if (selected) {
         g2.setColor(this.getCheckmarkColor(c));
         this.paintCheckmark(g2);
      }

   }

   protected void paintCheckmark(Graphics2D g2) {
      Float path = new Float();
      path.moveTo(4.5F, 7.5F);
      path.lineTo(6.6F, 10.0F);
      path.lineTo(11.25F, 3.5F);
      g2.setStroke(new BasicStroke(1.9F, 1, 1));
      g2.draw(path);
   }

   protected Color getCheckmarkColor(Component c) {
      if (c instanceof JMenuItem && ((JMenuItem)c).isArmed() && !this.isUnderlineSelection()) {
         return this.selectionForeground;
      } else {
         return c.isEnabled() ? this.checkmarkColor : this.disabledCheckmarkColor;
      }
   }

   protected boolean isUnderlineSelection() {
      return "underline".equals(UIManager.getString("MenuItem.selectionType"));
   }
}
