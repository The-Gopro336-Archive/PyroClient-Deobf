package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.UIManager;

public class FlatWindowResizer implements PropertyChangeListener, WindowStateListener, ComponentListener {
   protected static final Integer WINDOW_RESIZER_LAYER;
   protected final JRootPane rootPane;
   protected final int borderDragThickness = FlatUIUtils.getUIInt("RootPane.borderDragThickness", 5);
   protected final int cornerDragWidth = FlatUIUtils.getUIInt("RootPane.cornerDragWidth", 16);
   protected final boolean honorFrameMinimumSizeOnResize = UIManager.getBoolean("RootPane.honorFrameMinimumSizeOnResize");
   protected final boolean honorDialogMinimumSizeOnResize = UIManager.getBoolean("RootPane.honorDialogMinimumSizeOnResize");
   protected final JComponent north;
   protected final JComponent south;
   protected final JComponent west;
   protected final JComponent east;
   protected Window window;

   public FlatWindowResizer(JRootPane rootPane) {
      this.rootPane = rootPane;
      this.north = this.createDragBorderComponent(6, 8, 7);
      this.south = this.createDragBorderComponent(4, 9, 5);
      this.west = this.createDragBorderComponent(6, 10, 4);
      this.east = this.createDragBorderComponent(7, 11, 5);
      JLayeredPane layeredPane = rootPane.getLayeredPane();
      layeredPane.add(this.north, WINDOW_RESIZER_LAYER);
      layeredPane.add(this.south, WINDOW_RESIZER_LAYER);
      layeredPane.add(this.west, WINDOW_RESIZER_LAYER);
      layeredPane.add(this.east, WINDOW_RESIZER_LAYER);
      rootPane.addComponentListener(this);
      rootPane.addPropertyChangeListener("ancestor", this);
      if (rootPane.isDisplayable()) {
         this.addNotify();
      }

   }

   protected FlatWindowResizer.DragBorderComponent createDragBorderComponent(int leadingResizeDir, int centerResizeDir, int trailingResizeDir) {
      return new FlatWindowResizer.DragBorderComponent(leadingResizeDir, centerResizeDir, trailingResizeDir);
   }

   public void uninstall() {
      this.removeNotify();
      this.rootPane.removeComponentListener(this);
      this.rootPane.removePropertyChangeListener("ancestor", this);
      JLayeredPane layeredPane = this.rootPane.getLayeredPane();
      layeredPane.remove(this.north);
      layeredPane.remove(this.south);
      layeredPane.remove(this.west);
      layeredPane.remove(this.east);
   }

   public void doLayout() {
      if (this.north.isVisible()) {
         int x = 0;
         int y = 0;
         int width = this.rootPane.getWidth();
         int height = this.rootPane.getHeight();
         if (width != 0 && height != 0) {
            int thickness = UIScale.scale(this.borderDragThickness);
            int y2 = y + thickness;
            int height2 = height - thickness * 2;
            this.north.setBounds(x, y, width, thickness);
            this.south.setBounds(x, y + height - thickness, width, thickness);
            this.west.setBounds(x, y2, thickness, height2);
            this.east.setBounds(x + width - thickness, y2, thickness, height2);
         }
      }
   }

   protected void addNotify() {
      Container parent = this.rootPane.getParent();
      this.window = parent instanceof Window ? (Window)parent : null;
      if (this.window instanceof Frame) {
         this.window.addPropertyChangeListener("resizable", this);
         this.window.addWindowStateListener(this);
      }

      this.updateVisibility();
   }

   protected void removeNotify() {
      if (this.window instanceof Frame) {
         this.window.removePropertyChangeListener("resizable", this);
         this.window.removeWindowStateListener(this);
      }

      this.window = null;
      this.updateVisibility();
   }

   protected void updateVisibility() {
      boolean visible = this.isWindowResizable();
      if (visible != this.north.isVisible()) {
         this.north.setVisible(visible);
         this.south.setVisible(visible);
         this.west.setVisible(visible);
         this.east.setEnabled(visible);
         if (visible) {
            this.east.setVisible(true);
            this.doLayout();
         } else {
            this.east.setBounds(0, 0, 1, 1);
         }

      }
   }

   protected boolean isWindowResizable() {
      if (!(this.window instanceof Frame)) {
         return this.window instanceof Dialog ? ((Dialog)this.window).isResizable() : false;
      } else {
         return ((Frame)this.window).isResizable() && (((Frame)this.window).getExtendedState() & 6) == 0;
      }
   }

   public void propertyChange(PropertyChangeEvent e) {
      String var2 = e.getPropertyName();
      byte var3 = -1;
      switch(var2.hashCode()) {
      case -973829677:
         if (var2.equals("ancestor")) {
            var3 = 0;
         }
         break;
      case 2144232107:
         if (var2.equals("resizable")) {
            var3 = 1;
         }
      }

      switch(var3) {
      case 0:
         if (e.getNewValue() != null) {
            this.addNotify();
         } else {
            this.removeNotify();
         }
         break;
      case 1:
         this.updateVisibility();
      }

   }

   public void windowStateChanged(WindowEvent e) {
      this.updateVisibility();
   }

   public void componentResized(ComponentEvent e) {
      this.doLayout();
   }

   public void componentMoved(ComponentEvent e) {
   }

   public void componentShown(ComponentEvent e) {
   }

   public void componentHidden(ComponentEvent e) {
   }

   static {
      WINDOW_RESIZER_LAYER = JLayeredPane.DRAG_LAYER + 1;
   }

   protected class DragBorderComponent extends JComponent implements MouseListener, MouseMotionListener {
      private final int leadingResizeDir;
      private final int centerResizeDir;
      private final int trailingResizeDir;
      private int resizeDir = -1;
      private int dragStartMouseX;
      private int dragStartMouseY;
      private Rectangle dragStartWindowBounds;

      protected DragBorderComponent(int leadingResizeDir, int centerResizeDir, int trailingResizeDir) {
         this.leadingResizeDir = leadingResizeDir;
         this.centerResizeDir = centerResizeDir;
         this.trailingResizeDir = trailingResizeDir;
         this.setResizeDir(centerResizeDir);
         this.setVisible(false);
         this.addMouseListener(this);
         this.addMouseMotionListener(this);
      }

      protected void setResizeDir(int resizeDir) {
         if (this.resizeDir != resizeDir) {
            this.resizeDir = resizeDir;
            this.setCursor(Cursor.getPredefinedCursor(resizeDir));
         }
      }

      public Dimension getPreferredSize() {
         int thickness = UIScale.scale(FlatWindowResizer.this.borderDragThickness);
         return new Dimension(thickness, thickness);
      }

      protected void paintComponent(Graphics g) {
         super.paintChildren(g);
         if (FlatWindowResizer.this.window instanceof Dialog) {
            FlatWindowResizer.this.updateVisibility();
         }

      }

      public void mouseClicked(MouseEvent e) {
      }

      public void mousePressed(MouseEvent e) {
         if (FlatWindowResizer.this.window != null) {
            this.dragStartMouseX = e.getXOnScreen();
            this.dragStartMouseY = e.getYOnScreen();
            this.dragStartWindowBounds = FlatWindowResizer.this.window.getBounds();
         }
      }

      public void mouseReleased(MouseEvent e) {
         this.dragStartWindowBounds = null;
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }

      public void mouseMoved(MouseEvent e) {
         boolean topBottom = this.centerResizeDir == 8 || this.centerResizeDir == 9;
         int xy = topBottom ? e.getX() : e.getY();
         int wh = topBottom ? this.getWidth() : this.getHeight();
         int cornerWH = UIScale.scale(FlatWindowResizer.this.cornerDragWidth - (topBottom ? 0 : FlatWindowResizer.this.borderDragThickness));
         this.setResizeDir(xy <= cornerWH ? this.leadingResizeDir : (xy >= wh - cornerWH ? this.trailingResizeDir : this.centerResizeDir));
      }

      public void mouseDragged(MouseEvent e) {
         if (this.dragStartWindowBounds != null) {
            if (FlatWindowResizer.this.isWindowResizable()) {
               int mouseDeltaX = e.getXOnScreen() - this.dragStartMouseX;
               int mouseDeltaY = e.getYOnScreen() - this.dragStartMouseY;
               int deltaX = 0;
               int deltaY = 0;
               int deltaWidth = 0;
               int deltaHeight = 0;
               if (this.resizeDir == 8 || this.resizeDir == 6 || this.resizeDir == 7) {
                  deltaY = mouseDeltaY;
                  deltaHeight = -mouseDeltaY;
               }

               if (this.resizeDir == 9 || this.resizeDir == 4 || this.resizeDir == 5) {
                  deltaHeight = mouseDeltaY;
               }

               if (this.resizeDir == 10 || this.resizeDir == 6 || this.resizeDir == 4) {
                  deltaX = mouseDeltaX;
                  deltaWidth = -mouseDeltaX;
               }

               if (this.resizeDir == 11 || this.resizeDir == 7 || this.resizeDir == 5) {
                  deltaWidth = mouseDeltaX;
               }

               Rectangle newBounds = new Rectangle(this.dragStartWindowBounds);
               newBounds.x += deltaX;
               newBounds.y += deltaY;
               newBounds.width += deltaWidth;
               newBounds.height += deltaHeight;
               boolean honorMinimumSizeOnResize = FlatWindowResizer.this.honorFrameMinimumSizeOnResize && FlatWindowResizer.this.window instanceof Frame || FlatWindowResizer.this.honorDialogMinimumSizeOnResize && FlatWindowResizer.this.window instanceof Dialog;
               Dimension minimumSize = honorMinimumSizeOnResize ? FlatWindowResizer.this.window.getMinimumSize() : null;
               if (minimumSize == null) {
                  minimumSize = UIScale.scale(new Dimension(150, 50));
               }

               if (newBounds.width < minimumSize.width) {
                  if (deltaX != 0) {
                     newBounds.x -= minimumSize.width - newBounds.width;
                  }

                  newBounds.width = minimumSize.width;
               }

               if (newBounds.height < minimumSize.height) {
                  if (deltaY != 0) {
                     newBounds.y -= minimumSize.height - newBounds.height;
                  }

                  newBounds.height = minimumSize.height;
               }

               if (!newBounds.equals(this.dragStartWindowBounds)) {
                  FlatWindowResizer.this.window.setBounds(newBounds);
                  FlatWindowResizer.this.doLayout();
                  if (Toolkit.getDefaultToolkit().isDynamicLayoutActive()) {
                     FlatWindowResizer.this.window.validate();
                     FlatWindowResizer.this.rootPane.repaint();
                  }
               }

            }
         }
      }
   }
}
