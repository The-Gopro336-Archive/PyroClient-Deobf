package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.DerivedColor;
import com.formdev.flatlaf.util.Graphics2DProxy;
import com.formdev.flatlaf.util.HiDPIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Float;
import java.util.function.Consumer;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.UIResource;

public class FlatUIUtils {
   public static final boolean MAC_USE_QUARTZ = Boolean.getBoolean("apple.awt.graphics.UseQuartz");

   public static Rectangle addInsets(Rectangle r, Insets insets) {
      return new Rectangle(r.x - insets.left, r.y - insets.top, r.width + insets.left + insets.right, r.height + insets.top + insets.bottom);
   }

   public static Rectangle subtractInsets(Rectangle r, Insets insets) {
      return new Rectangle(r.x + insets.left, r.y + insets.top, r.width - insets.left - insets.right, r.height - insets.top - insets.bottom);
   }

   public static Dimension addInsets(Dimension dim, Insets insets) {
      return new Dimension(dim.width + insets.left + insets.right, dim.height + insets.top + insets.bottom);
   }

   public static Insets addInsets(Insets insets1, Insets insets2) {
      return new Insets(insets1.top + insets2.top, insets1.left + insets2.left, insets1.bottom + insets2.bottom, insets1.right + insets2.right);
   }

   public static void setInsets(Insets dest, Insets src) {
      dest.top = src.top;
      dest.left = src.left;
      dest.bottom = src.bottom;
      dest.right = src.right;
   }

   public static Color getUIColor(String key, int defaultColorRGB) {
      Color color = UIManager.getColor(key);
      return color != null ? color : new Color(defaultColorRGB);
   }

   public static Color getUIColor(String key, Color defaultColor) {
      Color color = UIManager.getColor(key);
      return color != null ? color : defaultColor;
   }

   public static Color getUIColor(String key, String defaultKey) {
      Color color = UIManager.getColor(key);
      return color != null ? color : UIManager.getColor(defaultKey);
   }

   public static int getUIInt(String key, int defaultValue) {
      Object value = UIManager.get(key);
      return value instanceof Integer ? (Integer)value : defaultValue;
   }

   public static float getUIFloat(String key, float defaultValue) {
      Object value = UIManager.get(key);
      return value instanceof Number ? ((Number)value).floatValue() : defaultValue;
   }

   public static Color nonUIResource(Color c) {
      return c instanceof UIResource ? new Color(c.getRGB(), true) : c;
   }

   public static Font nonUIResource(Font font) {
      return font instanceof UIResource ? font.deriveFont(font.getStyle()) : font;
   }

   public static int minimumWidth(JComponent c, int minimumWidth) {
      return FlatClientProperties.clientPropertyInt(c, "JComponent.minimumWidth", minimumWidth);
   }

   public static int minimumHeight(JComponent c, int minimumHeight) {
      return FlatClientProperties.clientPropertyInt(c, "JComponent.minimumHeight", minimumHeight);
   }

   public static boolean isTableCellEditor(Component c) {
      return c instanceof JComponent && Boolean.TRUE.equals(((JComponent)c).getClientProperty("JComboBox.isTableCellEditor"));
   }

   public static boolean isPermanentFocusOwner(Component c) {
      KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
      return keyboardFocusManager.getPermanentFocusOwner() == c && keyboardFocusManager.getActiveWindow() == SwingUtilities.windowForComponent(c);
   }

   public static boolean isRoundRect(Component c) {
      return c instanceof JComponent && FlatClientProperties.clientPropertyBoolean((JComponent)c, "JComponent.roundRect", false);
   }

   public static float getBorderFocusWidth(JComponent c) {
      FlatBorder border = getOutsideFlatBorder(c);
      return border != null ? UIScale.scale((float)border.getFocusWidth(c)) : 0.0F;
   }

   public static float getBorderArc(JComponent c) {
      FlatBorder border = getOutsideFlatBorder(c);
      return border != null ? UIScale.scale((float)border.getArc(c)) : 0.0F;
   }

   public static boolean hasRoundBorder(JComponent c) {
      return getBorderArc(c) >= (float)c.getHeight();
   }

   public static FlatBorder getOutsideFlatBorder(JComponent c) {
      Border border;
      for(border = c.getBorder(); !(border instanceof FlatBorder); border = ((CompoundBorder)border).getOutsideBorder()) {
         if (!(border instanceof CompoundBorder)) {
            return null;
         }
      }

      return (FlatBorder)border;
   }

   public static void setRenderingHints(Graphics2D g) {
      g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, MAC_USE_QUARTZ ? RenderingHints.VALUE_STROKE_PURE : RenderingHints.VALUE_STROKE_NORMALIZE);
   }

   public static Color deriveColor(Color color, Color baseColor) {
      return color instanceof DerivedColor ? ((DerivedColor)color).derive(baseColor) : color;
   }

   public static void paintComponentOuterBorder(Graphics2D g, int x, int y, int width, int height, float focusWidth, float lineWidth, float arc) {
      double systemScaleFactor = UIScale.getSystemScaleFactor(g);
      if (systemScaleFactor != 1.0D && systemScaleFactor != 2.0D) {
         HiDPIUtils.paintAtScale1x(g, x, y, width, height, (g2d, x2, y2, width2, height2, scaleFactor) -> {
            paintComponentOuterBorderImpl(g2d, x2, y2, width2, height2, (float)((double)focusWidth * scaleFactor), (float)((double)lineWidth * scaleFactor), (float)((double)arc * scaleFactor));
         });
      } else {
         paintComponentOuterBorderImpl(g, x, y, width, height, focusWidth, lineWidth, arc);
      }
   }

   private static void paintComponentOuterBorderImpl(Graphics2D g, int x, int y, int width, int height, float focusWidth, float lineWidth, float arc) {
      float ow = focusWidth + lineWidth;
      float outerArc = arc + focusWidth * 2.0F;
      float innerArc = arc - lineWidth * 2.0F;
      if (arc > 0.0F && arc < (float)UIScale.scale(10)) {
         outerArc -= UIScale.scale(2.0F);
      }

      Path2D path = new Float(0);
      path.append(createComponentRectangle((float)x, (float)y, (float)width, (float)height, outerArc), false);
      path.append(createComponentRectangle((float)x + ow, (float)y + ow, (float)width - ow * 2.0F, (float)height - ow * 2.0F, innerArc), false);
      g.fill(path);
   }

   public static void paintComponentBorder(Graphics2D g, int x, int y, int width, int height, float focusWidth, float lineWidth, float arc) {
      double systemScaleFactor = UIScale.getSystemScaleFactor(g);
      if (systemScaleFactor != 1.0D && systemScaleFactor != 2.0D) {
         HiDPIUtils.paintAtScale1x(g, x, y, width, height, (g2d, x2, y2, width2, height2, scaleFactor) -> {
            paintComponentBorderImpl(g2d, x2, y2, width2, height2, (float)((double)focusWidth * scaleFactor), (float)((double)lineWidth * scaleFactor), (float)((double)arc * scaleFactor));
         });
      } else {
         paintComponentBorderImpl(g, x, y, width, height, focusWidth, lineWidth, arc);
      }
   }

   private static void paintComponentBorderImpl(Graphics2D g, int x, int y, int width, int height, float focusWidth, float lineWidth, float arc) {
      float x1 = (float)x + focusWidth;
      float y1 = (float)y + focusWidth;
      float width1 = (float)width - focusWidth * 2.0F;
      float height1 = (float)height - focusWidth * 2.0F;
      float arc2 = arc - lineWidth * 2.0F;
      Shape r1 = createComponentRectangle(x1, y1, width1, height1, arc);
      Shape r2 = createComponentRectangle(x1 + lineWidth, y1 + lineWidth, width1 - lineWidth * 2.0F, height1 - lineWidth * 2.0F, arc2);
      Path2D border = new Float(0);
      border.append(r1, false);
      border.append(r2, false);
      g.fill(border);
   }

   public static void paintComponentBackground(Graphics2D g, int x, int y, int width, int height, float focusWidth, float arc) {
      double systemScaleFactor = UIScale.getSystemScaleFactor(g);
      if (systemScaleFactor != 1.0D && systemScaleFactor != 2.0D) {
         HiDPIUtils.paintAtScale1x(g, x, y, width, height, (g2d, x2, y2, width2, height2, scaleFactor) -> {
            paintComponentBackgroundImpl(g2d, x2, y2, width2, height2, (float)((double)focusWidth * scaleFactor), (float)((double)arc * scaleFactor));
         });
      } else {
         paintComponentBackgroundImpl(g, x, y, width, height, focusWidth, arc);
      }
   }

   private static void paintComponentBackgroundImpl(Graphics2D g, int x, int y, int width, int height, float focusWidth, float arc) {
      g.fill(createComponentRectangle((float)x + focusWidth, (float)y + focusWidth, (float)width - focusWidth * 2.0F, (float)height - focusWidth * 2.0F, arc));
   }

   public static Shape createComponentRectangle(float x, float y, float w, float h, float arc) {
      if (arc <= 0.0F) {
         return new java.awt.geom.Rectangle2D.Float(x, y, w, h);
      } else {
         arc = Math.min(arc, Math.min(w, h));
         return new java.awt.geom.RoundRectangle2D.Float(x, y, w, h, arc, arc);
      }
   }

   public static void paintParentBackground(Graphics g, JComponent c) {
      Container parent = findOpaqueParent(c);
      if (parent != null) {
         g.setColor(parent.getBackground());
         g.fillRect(0, 0, c.getWidth(), c.getHeight());
      }

   }

   public static Color getParentBackground(JComponent c) {
      Container parent = findOpaqueParent(c);
      return parent != null ? parent.getBackground() : UIManager.getColor("Panel.background");
   }

   private static Container findOpaqueParent(Container c) {
      while(true) {
         if ((c = c.getParent()) != null) {
            if (!c.isOpaque()) {
               continue;
            }

            return c;
         }

         return null;
      }
   }

   public static Path2D createRectangle(float x, float y, float width, float height, float lineWidth) {
      Path2D path = new Float(0);
      path.append(new java.awt.geom.Rectangle2D.Float(x, y, width, height), false);
      path.append(new java.awt.geom.Rectangle2D.Float(x + lineWidth, y + lineWidth, width - lineWidth * 2.0F, height - lineWidth * 2.0F), false);
      return path;
   }

   public static Path2D createRoundRectangle(float x, float y, float width, float height, float lineWidth, float arcTopLeft, float arcTopRight, float arcBottomLeft, float arcBottomRight) {
      Path2D path = new Float(0);
      path.append(createRoundRectanglePath(x, y, width, height, arcTopLeft, arcTopRight, arcBottomLeft, arcBottomRight), false);
      path.append(createRoundRectanglePath(x + lineWidth, y + lineWidth, width - lineWidth * 2.0F, height - lineWidth * 2.0F, arcTopLeft - lineWidth, arcTopRight - lineWidth, arcBottomLeft - lineWidth, arcBottomRight - lineWidth), false);
      return path;
   }

   public static Shape createRoundRectanglePath(float x, float y, float width, float height, float arcTopLeft, float arcTopRight, float arcBottomLeft, float arcBottomRight) {
      if (arcTopLeft <= 0.0F && arcTopRight <= 0.0F && arcBottomLeft <= 0.0F && arcBottomRight <= 0.0F) {
         return new java.awt.geom.Rectangle2D.Float(x, y, width, height);
      } else {
         float maxArc = Math.min(width, height) / 2.0F;
         arcTopLeft = arcTopLeft > 0.0F ? Math.min(arcTopLeft, maxArc) : 0.0F;
         arcTopRight = arcTopRight > 0.0F ? Math.min(arcTopRight, maxArc) : 0.0F;
         arcBottomLeft = arcBottomLeft > 0.0F ? Math.min(arcBottomLeft, maxArc) : 0.0F;
         arcBottomRight = arcBottomRight > 0.0F ? Math.min(arcBottomRight, maxArc) : 0.0F;
         float x2 = x + width;
         float y2 = y + height;
         Path2D rect = new Float();
         rect.moveTo((double)(x2 - arcTopRight), (double)y);
         rect.quadTo((double)x2, (double)y, (double)x2, (double)(y + arcTopRight));
         rect.lineTo((double)x2, (double)(y2 - arcBottomRight));
         rect.quadTo((double)x2, (double)y2, (double)(x2 - arcBottomRight), (double)y2);
         rect.lineTo((double)(x + arcBottomLeft), (double)y2);
         rect.quadTo((double)x, (double)y2, (double)x, (double)(y2 - arcBottomLeft));
         rect.lineTo((double)x, (double)(y + arcTopLeft));
         rect.quadTo((double)x, (double)y, (double)(x + arcTopLeft), (double)y);
         rect.closePath();
         return rect;
      }
   }

   public static Path2D createPath(double... points) {
      return createPath(true, points);
   }

   public static Path2D createPath(boolean close, double... points) {
      Path2D path = new Float();
      path.moveTo(points[0], points[1]);

      for(int i = 2; i < points.length; i += 2) {
         path.lineTo(points[i], points[i + 1]);
      }

      if (close) {
         path.closePath();
      }

      return path;
   }

   public static void drawString(JComponent c, Graphics g, String text, int x, int y) {
      HiDPIUtils.drawStringWithYCorrection(c, (Graphics2D)g, text, x, y);
   }

   public static void drawStringUnderlineCharAt(JComponent c, Graphics g, String text, int underlinedIndex, int x, int y) {
      if (underlinedIndex >= 0 && UIScale.getUserScaleFactor() > 1.0F) {
         g = new Graphics2DProxy((Graphics2D)g) {
            public void fillRect(int x, int y, int width, int height) {
               if (height == 1) {
                  height = Math.round(UIScale.scale(0.9F));
                  y += height - 1;
               }

               super.fillRect(x, y, width, height);
            }
         };
      }

      HiDPIUtils.drawStringUnderlineCharAtWithYCorrection(c, (Graphics2D)g, text, underlinedIndex, x, y);
   }

   public static boolean hasOpaqueBeenExplicitlySet(JComponent c) {
      boolean oldOpaque = c.isOpaque();
      LookAndFeel.installProperty(c, "opaque", !oldOpaque);
      boolean explicitlySet = c.isOpaque() == oldOpaque;
      LookAndFeel.installProperty(c, "opaque", oldOpaque);
      return explicitlySet;
   }

   public static class RepaintFocusListener implements FocusListener {
      private final Component repaintComponent;

      public RepaintFocusListener(Component repaintComponent) {
         this.repaintComponent = repaintComponent;
      }

      public void focusGained(FocusEvent e) {
         this.repaintComponent.repaint();
      }

      public void focusLost(FocusEvent e) {
         this.repaintComponent.repaint();
      }
   }

   public static class HoverListener extends MouseAdapter {
      private final Component repaintComponent;
      private final Consumer hoverChanged;

      public HoverListener(Component repaintComponent, Consumer hoverChanged) {
         this.repaintComponent = repaintComponent;
         this.hoverChanged = hoverChanged;
      }

      public void mouseEntered(MouseEvent e) {
         this.hoverChanged.accept(true);
         this.repaint();
      }

      public void mouseExited(MouseEvent e) {
         this.hoverChanged.accept(false);
         this.repaint();
      }

      private void repaint() {
         if (this.repaintComponent != null && this.repaintComponent.isEnabled()) {
            this.repaintComponent.repaint();
         }

      }
   }
}
