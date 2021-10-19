package com.formdev.flatlaf.util;

import com.formdev.flatlaf.FlatSystemProperties;
import java.awt.Graphics2D;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D.Double;
import java.text.AttributedCharacterIterator;
import javax.swing.JComponent;

public class HiDPIUtils {
   private static Boolean useTextYCorrection;

   public static void paintAtScale1x(Graphics2D g, JComponent c, HiDPIUtils.Painter painter) {
      paintAtScale1x(g, 0, 0, c.getWidth(), c.getHeight(), painter);
   }

   public static void paintAtScale1x(Graphics2D g, int x, int y, int width, int height, HiDPIUtils.Painter painter) {
      AffineTransform transform = g.getTransform();
      if (transform.getScaleX() == 1.0D && transform.getScaleY() == 1.0D) {
         painter.paint(g, x, y, width, height, 1.0D);
      } else {
         Double scaledRect = scale(transform, x, y, width, height);

         try {
            g.setTransform(new AffineTransform(1.0D, 0.0D, 0.0D, 1.0D, Math.floor(scaledRect.x), Math.floor(scaledRect.y)));
            int swidth = (int)scaledRect.width;
            int sheight = (int)scaledRect.height;
            painter.paint(g, 0, 0, swidth, sheight, transform.getScaleX());
         } finally {
            g.setTransform(transform);
         }

      }
   }

   private static Double scale(AffineTransform transform, int x, int y, int width, int height) {
      double dx1 = transform.getScaleX();
      double dy2 = transform.getScaleY();
      double px = (double)x * dx1 + transform.getTranslateX();
      double py = (double)y * dy2 + transform.getTranslateY();
      dx1 *= (double)width;
      dy2 *= (double)height;
      double newx = normalize(px);
      double newy = normalize(py);
      dx1 = normalize(px + dx1) - newx;
      dy2 = normalize(py + dy2) - newy;
      return new Double(newx, newy, dx1, dy2);
   }

   private static double normalize(double value) {
      return Math.floor(value + 0.25D) + 0.25D;
   }

   private static boolean useTextYCorrection() {
      if (useTextYCorrection == null) {
         useTextYCorrection = FlatSystemProperties.getBoolean("flatlaf.useTextYCorrection", true);
      }

      return useTextYCorrection;
   }

   public static float computeTextYCorrection(Graphics2D g) {
      if (useTextYCorrection() && SystemInfo.IS_WINDOWS) {
         if (!SystemInfo.IS_JAVA_9_OR_LATER) {
            return UIScale.getUserScaleFactor() > 1.0F ? -UIScale.scale(0.625F) : 0.0F;
         } else {
            AffineTransform t = g.getTransform();
            double scaleY = t.getScaleY();
            if (scaleY < 1.25D) {
               return 0.0F;
            } else if (scaleY <= 1.25D) {
               return -0.875F;
            } else if (scaleY <= 1.5D) {
               return -0.625F;
            } else if (scaleY <= 1.75D) {
               return -0.875F;
            } else if (scaleY <= 2.0D) {
               return -0.75F;
            } else if (scaleY <= 2.25D) {
               return -0.875F;
            } else {
               return scaleY <= 3.5D ? -0.75F : -0.875F;
            }
         }
      } else {
         return 0.0F;
      }
   }

   public static void drawStringWithYCorrection(JComponent c, Graphics2D g, String text, int x, int y) {
      drawStringUnderlineCharAtWithYCorrection(c, g, text, -1, x, y);
   }

   public static void drawStringUnderlineCharAtWithYCorrection(JComponent c, Graphics2D g, String text, int underlinedIndex, int x, int y) {
      float yCorrection = computeTextYCorrection(g);
      if (yCorrection != 0.0F) {
         g.translate(0.0D, (double)yCorrection);
         JavaCompatibility.drawStringUnderlineCharAt(c, g, text, underlinedIndex, x, y);
         g.translate(0.0D, (double)(-yCorrection));
      } else {
         JavaCompatibility.drawStringUnderlineCharAt(c, g, text, underlinedIndex, x, y);
      }

   }

   public static Graphics2D createGraphicsTextYCorrection(Graphics2D g) {
      final float yCorrection = computeTextYCorrection(g);
      return (Graphics2D)(yCorrection == 0.0F ? g : new Graphics2DProxy(g) {
         public void drawString(String str, int x, int y) {
            super.drawString(str, (float)x, (float)y + yCorrection);
         }

         public void drawString(String str, float x, float y) {
            super.drawString(str, x, y + yCorrection);
         }

         public void drawString(AttributedCharacterIterator iterator, int x, int y) {
            super.drawString(iterator, (float)x, (float)y + yCorrection);
         }

         public void drawString(AttributedCharacterIterator iterator, float x, float y) {
            super.drawString(iterator, x, y + yCorrection);
         }

         public void drawChars(char[] data, int offset, int length, int x, int y) {
            super.drawChars(data, offset, length, x, Math.round((float)y + yCorrection));
         }

         public void drawBytes(byte[] data, int offset, int length, int x, int y) {
            super.drawBytes(data, offset, length, x, Math.round((float)y + yCorrection));
         }

         public void drawGlyphVector(GlyphVector g, float x, float y) {
            super.drawGlyphVector(g, x, y + yCorrection);
         }
      });
   }

   public interface Painter {
      void paint(Graphics2D var1, int var2, int var3, int var4, int var5, double var6);
   }
}
