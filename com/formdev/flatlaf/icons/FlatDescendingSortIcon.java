package com.formdev.flatlaf.icons;

import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import javax.swing.UIManager;

public class FlatDescendingSortIcon extends FlatAbstractIcon {
   protected final boolean chevron = "chevron".equals(UIManager.getString("Component.arrowType"));
   protected final Color sortIconColor = UIManager.getColor("Table.sortIconColor");

   public FlatDescendingSortIcon() {
      super(10, 5, (Color)null);
   }

   protected void paintIcon(Component c, Graphics2D g) {
      g.setColor(this.sortIconColor);
      if (this.chevron) {
         Path2D path = FlatUIUtils.createPath(false, 1.0D, 0.0D, 5.0D, 4.0D, 9.0D, 0.0D);
         g.setStroke(new BasicStroke(1.0F));
         g.draw(path);
      } else {
         g.fill(FlatUIUtils.createPath(0.5D, 0.0D, 5.0D, 5.0D, 9.5D, 0.0D));
      }

   }
}
