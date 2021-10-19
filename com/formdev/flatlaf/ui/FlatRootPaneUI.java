package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.HiDPIUtils;
import com.formdev.flatlaf.util.SystemInfo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.util.function.Function;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;
import javax.swing.plaf.basic.BasicRootPaneUI;

public class FlatRootPaneUI extends BasicRootPaneUI {
   static final boolean canUseJBRCustomDecorations;
   protected JRootPane rootPane;
   protected FlatTitlePane titlePane;
   protected FlatWindowResizer windowResizer;
   private LayoutManager oldLayout;
   protected static final Integer TITLE_PANE_LAYER;

   public static ComponentUI createUI(JComponent c) {
      return new FlatRootPaneUI();
   }

   public void installUI(JComponent c) {
      super.installUI(c);
      this.rootPane = (JRootPane)c;
      if (this.rootPane.getWindowDecorationStyle() != 0) {
         this.installClientDecorations();
      }

      if (canUseJBRCustomDecorations) {
         JBRCustomDecorations.install(this.rootPane);
      }

   }

   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
      this.uninstallClientDecorations();
      this.rootPane = null;
   }

   protected void installDefaults(JRootPane c) {
      super.installDefaults(c);
      Container parent = c.getParent();
      if (parent instanceof JFrame || parent instanceof JDialog) {
         Color background = parent.getBackground();
         if (background == null || background instanceof UIResource) {
            parent.setBackground(UIManager.getColor("control"));
         }
      }

      if (SystemInfo.IS_JETBRAINS_JVM && SystemInfo.IS_MAC_OS_10_14_MOJAVE) {
         LookAndFeel laf = UIManager.getLookAndFeel();
         boolean isDark = laf instanceof FlatLaf && ((FlatLaf)laf).isDark();
         c.putClientProperty("jetbrains.awt.windowDarkAppearance", isDark);
      }

   }

   protected void installClientDecorations() {
      boolean isJBRSupported = canUseJBRCustomDecorations && JBRCustomDecorations.isSupported();
      if (this.rootPane.getWindowDecorationStyle() != 0 && !isJBRSupported) {
         LookAndFeel.installBorder(this.rootPane, "RootPane.border");
      } else {
         LookAndFeel.uninstallBorder(this.rootPane);
      }

      this.setTitlePane(this.createTitlePane());
      this.oldLayout = this.rootPane.getLayout();
      this.rootPane.setLayout(this.createRootLayout());
      if (!isJBRSupported) {
         this.windowResizer = this.createWindowResizer();
      }

   }

   protected void uninstallClientDecorations() {
      LookAndFeel.uninstallBorder(this.rootPane);
      this.setTitlePane((FlatTitlePane)null);
      if (this.windowResizer != null) {
         this.windowResizer.uninstall();
         this.windowResizer = null;
      }

      if (this.oldLayout != null) {
         this.rootPane.setLayout(this.oldLayout);
         this.oldLayout = null;
      }

      if (this.rootPane.getWindowDecorationStyle() == 0) {
         this.rootPane.revalidate();
         this.rootPane.repaint();
      }

   }

   protected FlatRootPaneUI.FlatRootLayout createRootLayout() {
      return new FlatRootPaneUI.FlatRootLayout();
   }

   protected FlatWindowResizer createWindowResizer() {
      return new FlatWindowResizer(this.rootPane);
   }

   protected FlatTitlePane createTitlePane() {
      return new FlatTitlePane(this.rootPane);
   }

   protected void setTitlePane(FlatTitlePane newTitlePane) {
      JLayeredPane layeredPane = this.rootPane.getLayeredPane();
      if (this.titlePane != null) {
         layeredPane.remove(this.titlePane);
      }

      if (newTitlePane != null) {
         layeredPane.add(newTitlePane, TITLE_PANE_LAYER);
      }

      this.titlePane = newTitlePane;
   }

   public void propertyChange(PropertyChangeEvent e) {
      super.propertyChange(e);
      String var2 = e.getPropertyName();
      byte var3 = -1;
      switch(var2.hashCode()) {
      case -1091051311:
         if (var2.equals("windowDecorationStyle")) {
            var3 = 0;
         }
         break;
      case -793947964:
         if (var2.equals("JRootPane.menuBarEmbedded")) {
            var3 = 1;
         }
      }

      switch(var3) {
      case 0:
         this.uninstallClientDecorations();
         if (this.rootPane.getWindowDecorationStyle() != 0) {
            this.installClientDecorations();
         }
         break;
      case 1:
         if (this.titlePane != null) {
            this.titlePane.menuBarChanged();
            this.rootPane.revalidate();
            this.rootPane.repaint();
         }
      }

   }

   static {
      canUseJBRCustomDecorations = SystemInfo.IS_JETBRAINS_JVM_11_OR_LATER && SystemInfo.IS_WINDOWS_10_OR_LATER;
      TITLE_PANE_LAYER = JLayeredPane.FRAME_CONTENT_LAYER - 1;
   }

   public static class FlatWindowBorder extends EmptyBorderUIResource {
      protected final Color activeBorderColor = UIManager.getColor("RootPane.activeBorderColor");
      protected final Color inactiveBorderColor = UIManager.getColor("RootPane.inactiveBorderColor");
      protected final Color baseBorderColor = UIManager.getColor("Panel.background");

      public FlatWindowBorder() {
         super(1, 1, 1, 1);
      }

      public Insets getBorderInsets(Component c, Insets insets) {
         if (this.isWindowMaximized(c)) {
            insets.top = insets.left = insets.bottom = insets.right = 0;
            return insets;
         } else {
            return super.getBorderInsets(c, insets);
         }
      }

      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         if (!this.isWindowMaximized(c)) {
            Container parent = c.getParent();
            boolean active = parent instanceof Window ? ((Window)parent).isActive() : false;
            g.setColor(FlatUIUtils.deriveColor(active ? this.activeBorderColor : this.inactiveBorderColor, this.baseBorderColor));
            HiDPIUtils.paintAtScale1x((Graphics2D)g, x, y, width, height, this::paintImpl);
         }
      }

      private void paintImpl(Graphics2D g, int x, int y, int width, int height, double scaleFactor) {
         g.drawRect(x, y, width - 1, height - 1);
      }

      protected boolean isWindowMaximized(Component c) {
         Container parent = c.getParent();
         return parent instanceof Frame ? (((Frame)parent).getExtendedState() & 6) != 0 : false;
      }
   }

   protected class FlatRootLayout implements LayoutManager2 {
      public void addLayoutComponent(String name, Component comp) {
      }

      public void addLayoutComponent(Component comp, Object constraints) {
      }

      public void removeLayoutComponent(Component comp) {
      }

      public Dimension preferredLayoutSize(Container parent) {
         return this.computeLayoutSize(parent, (c) -> {
            return c.getPreferredSize();
         });
      }

      public Dimension minimumLayoutSize(Container parent) {
         return this.computeLayoutSize(parent, (c) -> {
            return c.getMinimumSize();
         });
      }

      public Dimension maximumLayoutSize(Container parent) {
         return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
      }

      private Dimension computeLayoutSize(Container parent, Function getSizeFunc) {
         JRootPane rootPane = (JRootPane)parent;
         Dimension titlePaneSize = FlatRootPaneUI.this.titlePane != null ? (Dimension)getSizeFunc.apply(FlatRootPaneUI.this.titlePane) : new Dimension();
         Dimension contentSize = rootPane.getContentPane() != null ? (Dimension)getSizeFunc.apply(rootPane.getContentPane()) : rootPane.getSize();
         int width = Math.max(titlePaneSize.width, contentSize.width);
         int height = titlePaneSize.height + contentSize.height;
         if (FlatRootPaneUI.this.titlePane == null || !FlatRootPaneUI.this.titlePane.isMenuBarEmbedded()) {
            Dimension menuBarSize = rootPane.getJMenuBar() != null ? (Dimension)getSizeFunc.apply(rootPane.getJMenuBar()) : new Dimension();
            width = Math.max(width, menuBarSize.width);
            height += menuBarSize.height;
         }

         Insets insets = rootPane.getInsets();
         return new Dimension(width + insets.left + insets.right, height + insets.top + insets.bottom);
      }

      public void layoutContainer(Container parent) {
         JRootPane rootPane = (JRootPane)parent;
         Insets insets = rootPane.getInsets();
         int x = insets.left;
         int y = insets.top;
         int width = rootPane.getWidth() - insets.left - insets.right;
         int height = rootPane.getHeight() - insets.top - insets.bottom;
         if (rootPane.getLayeredPane() != null) {
            rootPane.getLayeredPane().setBounds(x, y, width, height);
         }

         if (rootPane.getGlassPane() != null) {
            rootPane.getGlassPane().setBounds(x, y, width, height);
         }

         int nextY = 0;
         if (FlatRootPaneUI.this.titlePane != null) {
            Dimension prefSize = FlatRootPaneUI.this.titlePane.getPreferredSize();
            FlatRootPaneUI.this.titlePane.setBounds(0, 0, width, prefSize.height);
            nextY += prefSize.height;
         }

         JMenuBar menuBar = rootPane.getJMenuBar();
         if (menuBar != null) {
            if (FlatRootPaneUI.this.titlePane != null && FlatRootPaneUI.this.titlePane.isMenuBarEmbedded()) {
               FlatRootPaneUI.this.titlePane.validate();
               menuBar.setBounds(FlatRootPaneUI.this.titlePane.getMenuBarBounds());
            } else {
               Dimension prefSizex = menuBar.getPreferredSize();
               menuBar.setBounds(0, nextY, width, prefSizex.height);
               nextY += prefSizex.height;
            }
         }

         Container contentPane = rootPane.getContentPane();
         if (contentPane != null) {
            contentPane.setBounds(0, nextY, width, Math.max(height - nextY, 0));
         }

      }

      public void invalidateLayout(Container parent) {
         if (FlatRootPaneUI.this.titlePane != null) {
            FlatRootPaneUI.this.titlePane.menuBarChanged();
         }

      }

      public float getLayoutAlignmentX(Container target) {
         return 0.0F;
      }

      public float getLayoutAlignmentY(Container target) {
         return 0.0F;
      }
   }
}
