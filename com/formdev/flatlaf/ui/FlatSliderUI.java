package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Float;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;

public class FlatSliderUI extends BasicSliderUI {
   private int trackWidth;
   private int thumbWidth;
   private Color trackColor;
   private Color thumbColor;
   private Color focusColor;
   private Color hoverColor;
   private Color disabledForeground;
   private MouseListener hoverListener;
   private boolean hover;

   public static ComponentUI createUI(JComponent c) {
      return new FlatSliderUI();
   }

   public FlatSliderUI() {
      super((JSlider)null);
   }

   protected void installListeners(JSlider slider) {
      super.installListeners(slider);
      this.hoverListener = new FlatUIUtils.HoverListener(slider, (h) -> {
         this.hover = h;
      });
      slider.addMouseListener(this.hoverListener);
   }

   protected void uninstallListeners(JSlider slider) {
      super.uninstallListeners(slider);
      slider.removeMouseListener(this.hoverListener);
      this.hoverListener = null;
   }

   protected void installDefaults(JSlider slider) {
      super.installDefaults(slider);
      LookAndFeel.installProperty(slider, "opaque", false);
      this.trackWidth = UIManager.getInt("Slider.trackWidth");
      this.thumbWidth = UIManager.getInt("Slider.thumbWidth");
      this.trackColor = UIManager.getColor("Slider.trackColor");
      this.thumbColor = UIManager.getColor("Slider.thumbColor");
      this.focusColor = FlatUIUtils.getUIColor("Slider.focusedColor", "Component.focusColor");
      this.hoverColor = FlatUIUtils.getUIColor("Slider.hoverColor", this.focusColor);
      this.disabledForeground = UIManager.getColor("Slider.disabledForeground");
   }

   protected void uninstallDefaults(JSlider slider) {
      super.uninstallDefaults(slider);
      this.trackColor = null;
      this.thumbColor = null;
      this.focusColor = null;
      this.hoverColor = null;
      this.disabledForeground = null;
   }

   public Dimension getPreferredHorizontalSize() {
      return UIScale.scale(super.getPreferredHorizontalSize());
   }

   public Dimension getPreferredVerticalSize() {
      return UIScale.scale(super.getPreferredVerticalSize());
   }

   public Dimension getMinimumHorizontalSize() {
      return UIScale.scale(super.getMinimumHorizontalSize());
   }

   public Dimension getMinimumVerticalSize() {
      return UIScale.scale(super.getMinimumVerticalSize());
   }

   protected int getTickLength() {
      return UIScale.scale(super.getTickLength());
   }

   protected Dimension getThumbSize() {
      return new Dimension(UIScale.scale(this.thumbWidth), UIScale.scale(this.thumbWidth));
   }

   public void paint(Graphics g, JComponent c) {
      FlatUIUtils.setRenderingHints((Graphics2D)g);
      super.paint(g, c);
   }

   public void paintFocus(Graphics g) {
   }

   public void paintTrack(Graphics g) {
      boolean enabled = this.slider.isEnabled();
      float tw = UIScale.scale((float)this.trackWidth);
      RoundRectangle2D coloredTrack = null;
      Float track;
      float y;
      int cw;
      if (this.slider.getOrientation() == 0) {
         y = (float)this.trackRect.y + ((float)this.trackRect.height - tw) / 2.0F;
         if (enabled && this.isRoundThumb()) {
            if (this.slider.getComponentOrientation().isLeftToRight()) {
               cw = this.thumbRect.x + this.thumbRect.width / 2 - this.trackRect.x;
               coloredTrack = new Float((float)this.trackRect.x, y, (float)cw, tw, tw, tw);
               track = new Float((float)(this.trackRect.x + cw), y, (float)(this.trackRect.width - cw), tw, tw, tw);
            } else {
               cw = this.trackRect.x + this.trackRect.width - this.thumbRect.x - this.thumbRect.width / 2;
               coloredTrack = new Float((float)(this.trackRect.x + this.trackRect.width - cw), y, (float)cw, tw, tw, tw);
               track = new Float((float)this.trackRect.x, y, (float)(this.trackRect.width - cw), tw, tw, tw);
            }
         } else {
            track = new Float((float)this.trackRect.x, y, (float)this.trackRect.width, tw, tw, tw);
         }
      } else {
         y = (float)this.trackRect.x + ((float)this.trackRect.width - tw) / 2.0F;
         if (enabled && this.isRoundThumb()) {
            cw = this.thumbRect.y + this.thumbRect.height / 2 - this.trackRect.y;
            track = new Float(y, (float)this.trackRect.y, tw, (float)cw, tw, tw);
            coloredTrack = new Float(y, (float)(this.trackRect.y + cw), tw, (float)(this.trackRect.height - cw), tw, tw);
         } else {
            track = new Float(y, (float)this.trackRect.y, tw, (float)this.trackRect.height, tw, tw);
         }
      }

      if (coloredTrack != null) {
         g.setColor(FlatUIUtils.deriveColor(FlatUIUtils.isPermanentFocusOwner(this.slider) ? this.focusColor : (this.hover ? this.hoverColor : this.thumbColor), this.thumbColor));
         ((Graphics2D)g).fill(coloredTrack);
      }

      g.setColor(enabled ? this.trackColor : this.disabledForeground);
      ((Graphics2D)g).fill(track);
   }

   public void paintThumb(Graphics g) {
      g.setColor(FlatUIUtils.deriveColor(this.slider.isEnabled() ? (FlatUIUtils.isPermanentFocusOwner(this.slider) ? this.focusColor : (this.hover ? this.hoverColor : this.thumbColor)) : this.disabledForeground, this.thumbColor));
      if (this.isRoundThumb()) {
         g.fillOval(this.thumbRect.x, this.thumbRect.y, this.thumbRect.width, this.thumbRect.height);
      } else {
         double w = (double)this.thumbRect.width;
         double h = (double)this.thumbRect.height;
         double wh = w / 2.0D;
         Path2D thumb = FlatUIUtils.createPath(0.0D, 0.0D, w, 0.0D, w, h - wh, wh, h, 0.0D, h - wh);
         Graphics2D g2 = (Graphics2D)g.create();

         try {
            g2.translate(this.thumbRect.x, this.thumbRect.y);
            if (this.slider.getOrientation() == 1) {
               if (this.slider.getComponentOrientation().isLeftToRight()) {
                  g2.translate(0, this.thumbRect.height);
                  g2.rotate(Math.toRadians(270.0D));
               } else {
                  g2.translate(this.thumbRect.width, 0);
                  g2.rotate(Math.toRadians(90.0D));
               }
            }

            g2.fill(thumb);
         } finally {
            g2.dispose();
         }
      }

   }

   private boolean isRoundThumb() {
      return !this.slider.getPaintTicks() && !this.slider.getPaintLabels();
   }
}
