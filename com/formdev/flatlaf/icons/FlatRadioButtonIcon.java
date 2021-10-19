package com.formdev.flatlaf.icons;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D.Float;

public class FlatRadioButtonIcon extends FlatCheckBoxIcon {
   protected final int centerDiameter;

   public FlatRadioButtonIcon() {
      this.centerDiameter = getUIInt("RadioButton.icon.centerDiameter", 8, this.style);
   }

   protected void paintFocusBorder(Graphics2D g2) {
      int wh = 15 + this.focusWidth * 2;
      g2.fillOval(-this.focusWidth, -this.focusWidth, wh, wh);
   }

   protected void paintBorder(Graphics2D g2) {
      g2.fillOval(0, 0, 15, 15);
   }

   protected void paintBackground(Graphics2D g2) {
      g2.fillOval(1, 1, 13, 13);
   }

   protected void paintCheckmark(Graphics2D g2) {
      float xy = (float)(15 - this.centerDiameter) / 2.0F;
      g2.fill(new Float(xy, xy, (float)this.centerDiameter, (float)this.centerDiameter));
   }
}
