package com.formdev.flatlaf.icons;

import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Component;
import java.awt.Graphics2D;
import javax.swing.UIManager;

public class FlatTreeLeafIcon extends FlatAbstractIcon {
   public FlatTreeLeafIcon() {
      super(16, 16, UIManager.getColor("Tree.icon.leafColor"));
   }

   protected void paintIcon(Component c, Graphics2D g) {
      g.fill(FlatUIUtils.createPath(8.0D, 6.0D, 8.0D, 1.0D, 13.0D, 1.0D, 13.0D, 15.0D, 3.0D, 15.0D, 3.0D, 6.0D));
      g.fill(FlatUIUtils.createPath(3.0D, 5.0D, 7.0D, 5.0D, 7.0D, 1.0D));
   }
}
