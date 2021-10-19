package com.formdev.flatlaf.ui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.LookAndFeel;
import javax.swing.Scrollable;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import javax.swing.plaf.basic.BasicScrollPaneUI.MouseWheelHandler;
import javax.swing.plaf.basic.BasicScrollPaneUI.PropertyChangeHandler;

public class FlatScrollPaneUI extends BasicScrollPaneUI {
   private FlatScrollPaneUI.Handler handler;
   private static final double EPSILON = 1.0E-5D;

   public static ComponentUI createUI(JComponent c) {
      return new FlatScrollPaneUI();
   }

   public void installUI(JComponent c) {
      super.installUI(c);
      int focusWidth = UIManager.getInt("Component.focusWidth");
      LookAndFeel.installProperty(c, "opaque", focusWidth == 0);
      MigLayoutVisualPadding.install(this.scrollpane);
   }

   public void uninstallUI(JComponent c) {
      MigLayoutVisualPadding.uninstall(this.scrollpane);
      super.uninstallUI(c);
   }

   protected void installListeners(JScrollPane c) {
      super.installListeners(c);
      this.addViewportListeners(this.scrollpane.getViewport());
   }

   protected void uninstallListeners(JComponent c) {
      super.uninstallListeners(c);
      this.removeViewportListeners(this.scrollpane.getViewport());
      this.handler = null;
   }

   protected MouseWheelListener createMouseWheelListener() {
      return new MouseWheelHandler() {
         public void mouseWheelMoved(MouseWheelEvent e) {
            if (UIManager.getBoolean("ScrollPane.smoothScrolling") && FlatScrollPaneUI.this.scrollpane.isWheelScrollingEnabled() && e.getScrollType() == 0 && e.getPreciseWheelRotation() != 0.0D && e.getPreciseWheelRotation() != (double)e.getWheelRotation()) {
               FlatScrollPaneUI.this.mouseWheelMovedSmooth(e);
            } else {
               super.mouseWheelMoved(e);
            }

         }
      };
   }

   private void mouseWheelMovedSmooth(MouseWheelEvent e) {
      JViewport viewport = this.scrollpane.getViewport();
      if (viewport != null) {
         JScrollBar scrollbar = this.scrollpane.getVerticalScrollBar();
         if (scrollbar == null || !scrollbar.isVisible() || e.isShiftDown()) {
            scrollbar = this.scrollpane.getHorizontalScrollBar();
            if (scrollbar == null || !scrollbar.isVisible()) {
               return;
            }
         }

         e.consume();
         double rotation = e.getPreciseWheelRotation();
         int orientation = scrollbar.getOrientation();
         Component view = viewport.getView();
         int unitIncrement;
         int blockIncrement;
         int scrollAmount;
         if (view instanceof Scrollable) {
            Scrollable scrollable = (Scrollable)view;
            Rectangle visibleRect = new Rectangle(viewport.getViewSize());
            unitIncrement = scrollable.getScrollableUnitIncrement(visibleRect, orientation, 1);
            blockIncrement = scrollable.getScrollableBlockIncrement(visibleRect, orientation, 1);
            if (unitIncrement > 0) {
               if (orientation == 1) {
                  visibleRect.y += unitIncrement;
                  visibleRect.height -= unitIncrement;
               } else {
                  visibleRect.x += unitIncrement;
                  visibleRect.width -= unitIncrement;
               }

               int unitIncrement2 = scrollable.getScrollableUnitIncrement(visibleRect, orientation, 1);
               if (unitIncrement2 > 0) {
                  unitIncrement = Math.min(unitIncrement, unitIncrement2);
               }
            }
         } else {
            scrollAmount = rotation < 0.0D ? -1 : 1;
            unitIncrement = scrollbar.getUnitIncrement(scrollAmount);
            blockIncrement = scrollbar.getBlockIncrement(scrollAmount);
         }

         scrollAmount = e.getScrollAmount();
         int viewportWH = orientation == 1 ? viewport.getHeight() : viewport.getWidth();
         if (unitIncrement * scrollAmount > viewportWH) {
            scrollAmount = Math.max(viewportWH / unitIncrement, 1);
         }

         double delta = rotation * (double)scrollAmount * (double)unitIncrement;
         boolean adjustDelta = Math.abs(rotation) < 1.00001D;
         double adjustedDelta = adjustDelta ? Math.max((double)(-blockIncrement), Math.min(delta, (double)blockIncrement)) : delta;
         int value = scrollbar.getValue();
         double minDelta = (double)(scrollbar.getMinimum() - value);
         double maxDelta = (double)(scrollbar.getMaximum() - scrollbar.getModel().getExtent() - value);
         double boundedDelta = Math.max(minDelta, Math.min(adjustedDelta, maxDelta));
         int newValue = value + (int)Math.round(boundedDelta);
         if (newValue != value) {
            scrollbar.setValue(newValue);
         }

      }
   }

   protected PropertyChangeListener createPropertyChangeListener() {
      return new PropertyChangeHandler() {
         public void propertyChange(PropertyChangeEvent e) {
            super.propertyChange(e);
            String var2 = e.getPropertyName();
            byte var3 = -1;
            switch(var2.hashCode()) {
            case -1979886954:
               if (var2.equals("LOWER_RIGHT_CORNER")) {
                  var3 = 2;
               }
               break;
            case -1731521899:
               if (var2.equals("UPPER_RIGHT_CORNER")) {
                  var3 = 4;
               }
               break;
            case -29602513:
               if (var2.equals("LOWER_LEFT_CORNER")) {
                  var3 = 1;
               }
               break;
            case 193872818:
               if (var2.equals("JScrollBar.showButtons")) {
                  var3 = 0;
               }
               break;
            case 1086787920:
               if (var2.equals("UPPER_LEFT_CORNER")) {
                  var3 = 3;
               }
            }

            switch(var3) {
            case 0:
               JScrollBar vsb = FlatScrollPaneUI.this.scrollpane.getVerticalScrollBar();
               JScrollBar hsb = FlatScrollPaneUI.this.scrollpane.getHorizontalScrollBar();
               if (vsb != null) {
                  vsb.revalidate();
                  vsb.repaint();
               }

               if (hsb != null) {
                  hsb.revalidate();
                  hsb.repaint();
               }
               break;
            case 1:
            case 2:
            case 3:
            case 4:
               Object corner = e.getNewValue();
               if (corner instanceof JButton && ((JButton)corner).getBorder() instanceof FlatButtonBorder && FlatScrollPaneUI.this.scrollpane.getViewport() != null && FlatScrollPaneUI.this.scrollpane.getViewport().getView() instanceof JTable) {
                  ((JButton)corner).setBorder(BorderFactory.createEmptyBorder());
                  ((JButton)corner).setFocusable(false);
               }
            }

         }
      };
   }

   private FlatScrollPaneUI.Handler getHandler() {
      if (this.handler == null) {
         this.handler = new FlatScrollPaneUI.Handler();
      }

      return this.handler;
   }

   protected void updateViewport(PropertyChangeEvent e) {
      super.updateViewport(e);
      JViewport oldViewport = (JViewport)e.getOldValue();
      JViewport newViewport = (JViewport)e.getNewValue();
      this.removeViewportListeners(oldViewport);
      this.addViewportListeners(newViewport);
   }

   private void addViewportListeners(JViewport viewport) {
      if (viewport != null) {
         viewport.addContainerListener(this.getHandler());
         Component view = viewport.getView();
         if (view != null) {
            view.addFocusListener(this.getHandler());
         }

      }
   }

   private void removeViewportListeners(JViewport viewport) {
      if (viewport != null) {
         viewport.removeContainerListener(this.getHandler());
         Component view = viewport.getView();
         if (view != null) {
            view.removeFocusListener(this.getHandler());
         }

      }
   }

   public void update(Graphics g, JComponent c) {
      if (c.isOpaque()) {
         FlatUIUtils.paintParentBackground(g, c);
         Insets insets = c.getInsets();
         g.setColor(c.getBackground());
         g.fillRect(insets.left, insets.top, c.getWidth() - insets.left - insets.right, c.getHeight() - insets.top - insets.bottom);
      }

      this.paint(g, c);
   }

   private class Handler implements ContainerListener, FocusListener {
      private Handler() {
      }

      public void componentAdded(ContainerEvent e) {
         e.getChild().addFocusListener(this);
      }

      public void componentRemoved(ContainerEvent e) {
         e.getChild().removeFocusListener(this);
      }

      public void focusGained(FocusEvent e) {
         FlatScrollPaneUI.this.scrollpane.repaint();
      }

      public void focusLost(FocusEvent e) {
         FlatScrollPaneUI.this.scrollpane.repaint();
      }

      // $FF: synthetic method
      Handler(Object x1) {
         this();
      }
   }
}
