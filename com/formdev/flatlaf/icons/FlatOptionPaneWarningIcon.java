package com.formdev.flatlaf.icons;

import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Float;

public class FlatOptionPaneWarningIcon extends FlatOptionPaneAbstractIcon {
   public FlatOptionPaneWarningIcon() {
      super("OptionPane.icon.warningColor", "Actions.Yellow");
   }

   protected Shape createOutside() {
      return FlatUIUtils.createPath(16.0D, 2.0D, 31.0D, 28.0D, 1.0D, 28.0D);
   }

   protected Shape createInside() {
      Path2D inside = new Float(0);
      inside.append(new java.awt.geom.Rectangle2D.Float(14.0F, 10.0F, 4.0F, 8.0F), false);
      inside.append(new java.awt.geom.Rectangle2D.Float(14.0F, 21.0F, 4.0F, 4.0F), false);
      return inside;
   }
}
