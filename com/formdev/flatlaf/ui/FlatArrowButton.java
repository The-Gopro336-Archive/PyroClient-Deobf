package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D.Float;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicArrowButton;

public class FlatArrowButton extends BasicArrowButton implements UIResource {
   public static final int DEFAULT_ARROW_WIDTH = 8;
   private final boolean chevron;
   private final Color foreground;
   private final Color disabledForeground;
   private final Color hoverForeground;
   private final Color hoverBackground;
   private final Color pressedBackground;
   private int arrowWidth;
   private int xOffset;
   private int yOffset;
   private boolean hover;
   private boolean pressed;

   public FlatArrowButton(int direction, String type, Color foreground, Color disabledForeground, Color hoverForeground, Color hoverBackground) {
      this(direction, type, foreground, disabledForeground, hoverForeground, hoverBackground, (Color)null);
   }

   public FlatArrowButton(int direction, String type, Color foreground, Color disabledForeground, Color hoverForeground, Color hoverBackground, Color pressedBackground) {
      super(direction, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
      this.arrowWidth = 8;
      this.xOffset = 0;
      this.yOffset = 0;
      this.chevron = "chevron".equals(type);
      this.foreground = foreground;
      this.disabledForeground = disabledForeground;
      this.hoverForeground = hoverForeground;
      this.hoverBackground = hoverBackground;
      this.pressedBackground = pressedBackground;
      this.setOpaque(false);
      this.setBorder((Border)null);
      if (hoverForeground != null || hoverBackground != null || pressedBackground != null) {
         this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
               FlatArrowButton.this.hover = true;
               FlatArrowButton.this.repaint();
            }

            public void mouseExited(MouseEvent e) {
               FlatArrowButton.this.hover = false;
               FlatArrowButton.this.repaint();
            }

            public void mousePressed(MouseEvent e) {
               FlatArrowButton.this.pressed = true;
               FlatArrowButton.this.repaint();
            }

            public void mouseReleased(MouseEvent e) {
               FlatArrowButton.this.pressed = false;
               FlatArrowButton.this.repaint();
            }
         });
      }

   }

   public int getArrowWidth() {
      return this.arrowWidth;
   }

   public void setArrowWidth(int arrowWidth) {
      this.arrowWidth = arrowWidth;
   }

   protected boolean isHover() {
      return this.hover;
   }

   protected boolean isPressed() {
      return this.pressed;
   }

   public int getXOffset() {
      return this.xOffset;
   }

   public void setXOffset(int xOffset) {
      this.xOffset = xOffset;
   }

   public int getYOffset() {
      return this.yOffset;
   }

   public void setYOffset(int yOffset) {
      this.yOffset = yOffset;
   }

   protected Color deriveBackground(Color background) {
      return background;
   }

   public Dimension getPreferredSize() {
      return UIScale.scale(super.getPreferredSize());
   }

   public Dimension getMinimumSize() {
      return UIScale.scale(super.getMinimumSize());
   }

   public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      FlatUIUtils.setRenderingHints(g2);
      int width = this.getWidth();
      int height = this.getHeight();
      boolean enabled = this.isEnabled();
      if (enabled) {
         Color background = this.pressedBackground != null && this.isPressed() ? this.deriveBackground(this.pressedBackground) : (this.hoverBackground != null && this.isHover() ? this.deriveBackground(this.hoverBackground) : null);
         if (background != null) {
            g.setColor(background);
            g.fillRect(0, 0, width, height);
         }
      }

      int direction = this.getDirection();
      boolean vert = direction == 1 || direction == 5;
      int w = UIScale.scale(this.arrowWidth + (this.chevron ? 0 : 1));
      int h = UIScale.scale(this.arrowWidth / 2 + (this.chevron ? 0 : 1));
      int rw = vert ? w : h;
      int rh = vert ? h : w;
      if (this.chevron) {
         ++rw;
         ++rh;
      }

      int x = Math.round((float)(width - rw) / 2.0F + UIScale.scale((float)this.xOffset));
      int y = Math.round((float)(height - rh) / 2.0F + UIScale.scale((float)this.yOffset));
      Container parent = this.getParent();
      if (vert && parent instanceof JComponent && FlatUIUtils.hasRoundBorder((JComponent)parent)) {
         x -= UIScale.scale(parent.getComponentOrientation().isLeftToRight() ? 1 : -1);
      }

      g.setColor(enabled ? (this.isHover() && this.hoverForeground != null ? this.hoverForeground : this.foreground) : this.disabledForeground);
      g.translate(x, y);
      Shape arrowShape = createArrowShape(direction, this.chevron, (float)w, (float)h);
      if (this.chevron) {
         g2.setStroke(new BasicStroke(UIScale.scale(1.0F)));
         g2.draw(arrowShape);
      } else {
         g2.fill(arrowShape);
      }

      g.translate(-x, -y);
   }

   public static Shape createArrowShape(int direction, boolean chevron, float w, float h) {
      switch(direction) {
      case 1:
         return FlatUIUtils.createPath(!chevron, 0.0D, (double)h, (double)(w / 2.0F), 0.0D, (double)w, (double)h);
      case 2:
      case 4:
      case 6:
      default:
         return new Float();
      case 3:
         return FlatUIUtils.createPath(!chevron, 0.0D, 0.0D, (double)h, (double)(w / 2.0F), 0.0D, (double)w);
      case 5:
         return FlatUIUtils.createPath(!chevron, 0.0D, 0.0D, (double)(w / 2.0F), (double)h, (double)w, 0.0D);
      case 7:
         return FlatUIUtils.createPath(!chevron, (double)h, 0.0D, 0.0D, (double)(w / 2.0F), (double)h, (double)w);
      }
   }
}
