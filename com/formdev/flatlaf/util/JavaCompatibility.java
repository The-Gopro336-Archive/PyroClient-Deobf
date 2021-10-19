package com.formdev.flatlaf.util;

import com.formdev.flatlaf.FlatLaf;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class JavaCompatibility {
   private static Method drawStringUnderlineCharAtMethod;

   public static void drawStringUnderlineCharAt(JComponent c, Graphics g, String text, int underlinedIndex, int x, int y) {
      Class var6 = JavaCompatibility.class;
      synchronized(JavaCompatibility.class) {
         if (drawStringUnderlineCharAtMethod == null) {
            try {
               Class cls = Class.forName(SystemInfo.IS_JAVA_9_OR_LATER ? "javax.swing.plaf.basic.BasicGraphicsUtils" : "sun.swing.SwingUtilities2");
               drawStringUnderlineCharAtMethod = cls.getMethod("drawStringUnderlineCharAt", SystemInfo.IS_JAVA_9_OR_LATER ? new Class[]{JComponent.class, Graphics2D.class, String.class, Integer.TYPE, Float.TYPE, Float.TYPE} : new Class[]{JComponent.class, Graphics.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
            } catch (Exception var10) {
               Logger.getLogger(FlatLaf.class.getName()).log(Level.SEVERE, (String)null, var10);
               throw new RuntimeException(var10);
            }
         }
      }

      try {
         if (SystemInfo.IS_JAVA_9_OR_LATER) {
            drawStringUnderlineCharAtMethod.invoke((Object)null, c, g, text, underlinedIndex, (float)x, (float)y);
         } else {
            drawStringUnderlineCharAtMethod.invoke((Object)null, c, g, text, underlinedIndex, x, y);
         }

      } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException var9) {
         Logger.getLogger(FlatLaf.class.getName()).log(Level.SEVERE, (String)null, var9);
         throw new RuntimeException(var9);
      }
   }
}
