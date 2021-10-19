package com.formdev.flatlaf.ui;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicViewportUI;

public class FlatViewportUI extends BasicViewportUI {
   private static ComponentUI instance;

   public static ComponentUI createUI(JComponent c) {
      if (instance == null) {
         instance = new FlatViewportUI();
      }

      return instance;
   }

   public void update(Graphics g, JComponent c) {
      Component view = ((JViewport)c).getView();
      if (c.isOpaque() && view instanceof JTable) {
         g.setColor(view.getBackground());
         g.fillRect(0, 0, c.getWidth(), c.getHeight());
         this.paint(g, c);
      } else {
         super.update(g, c);
      }

   }
}
