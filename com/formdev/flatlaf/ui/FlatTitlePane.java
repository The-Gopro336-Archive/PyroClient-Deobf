package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatSystemProperties;
import com.formdev.flatlaf.util.ScaledImageIcon;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class FlatTitlePane extends JComponent {
   protected final Color activeBackground = UIManager.getColor("TitlePane.background");
   protected final Color inactiveBackground = UIManager.getColor("TitlePane.inactiveBackground");
   protected final Color activeForeground = UIManager.getColor("TitlePane.foreground");
   protected final Color inactiveForeground = UIManager.getColor("TitlePane.inactiveForeground");
   protected final Color embeddedForeground = UIManager.getColor("TitlePane.embeddedForeground");
   protected final Insets menuBarMargins = UIManager.getInsets("TitlePane.menuBarMargins");
   protected final Dimension iconSize = UIManager.getDimension("TitlePane.iconSize");
   protected final int buttonMaximizedHeight = UIManager.getInt("TitlePane.buttonMaximizedHeight");
   protected final JRootPane rootPane;
   protected JPanel leftPanel;
   protected JLabel iconLabel;
   protected JComponent menuBarPlaceholder;
   protected JLabel titleLabel;
   protected JPanel buttonPanel;
   protected JButton iconifyButton;
   protected JButton maximizeButton;
   protected JButton restoreButton;
   protected JButton closeButton;
   protected Window window;
   private final FlatTitlePane.Handler handler;

   public FlatTitlePane(JRootPane rootPane) {
      this.rootPane = rootPane;
      this.handler = this.createHandler();
      this.setBorder(this.createTitlePaneBorder());
      this.addSubComponents();
      this.activeChanged(true);
      this.addMouseListener(this.handler);
      this.addMouseMotionListener(this.handler);
      this.iconLabel.addMouseListener(this.handler);
   }

   protected FlatTitlePane.FlatTitlePaneBorder createTitlePaneBorder() {
      return new FlatTitlePane.FlatTitlePaneBorder();
   }

   protected FlatTitlePane.Handler createHandler() {
      return new FlatTitlePane.Handler();
   }

   protected void addSubComponents() {
      this.leftPanel = new JPanel();
      this.iconLabel = new JLabel();
      this.titleLabel = new JLabel();
      this.iconLabel.setBorder(new FlatEmptyBorder(UIManager.getInsets("TitlePane.iconMargins")));
      this.titleLabel.setBorder(new FlatEmptyBorder(UIManager.getInsets("TitlePane.titleMargins")));
      this.leftPanel.setLayout(new BoxLayout(this.leftPanel, 2));
      this.leftPanel.setOpaque(false);
      this.leftPanel.add(this.iconLabel);
      this.menuBarPlaceholder = new JComponent() {
         public Dimension getPreferredSize() {
            JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
            return menuBar != null && FlatTitlePane.this.isMenuBarEmbedded() ? FlatUIUtils.addInsets(menuBar.getPreferredSize(), UIScale.scale(FlatTitlePane.this.menuBarMargins)) : new Dimension();
         }
      };
      this.leftPanel.add(this.menuBarPlaceholder);
      this.createButtons();
      this.setLayout(new BorderLayout());
      this.add(this.leftPanel, "Before");
      this.add(this.titleLabel, "Center");
      this.add(this.buttonPanel, "After");
   }

   protected void createButtons() {
      this.iconifyButton = this.createButton("TitlePane.iconifyIcon", "Iconify", (e) -> {
         this.iconify();
      });
      this.maximizeButton = this.createButton("TitlePane.maximizeIcon", "Maximize", (e) -> {
         this.maximize();
      });
      this.restoreButton = this.createButton("TitlePane.restoreIcon", "Restore", (e) -> {
         this.restore();
      });
      this.closeButton = this.createButton("TitlePane.closeIcon", "Close", (e) -> {
         this.close();
      });
      this.buttonPanel = new JPanel() {
         public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            if (FlatTitlePane.this.buttonMaximizedHeight > 0 && FlatTitlePane.this.window instanceof Frame && (((Frame)FlatTitlePane.this.window).getExtendedState() & 6) != 0) {
               size = new Dimension(size.width, Math.min(size.height, UIScale.scale(FlatTitlePane.this.buttonMaximizedHeight)));
            }

            return size;
         }
      };
      this.buttonPanel.setOpaque(false);
      this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, 2));
      if (this.rootPane.getWindowDecorationStyle() == 1) {
         this.restoreButton.setVisible(false);
         this.buttonPanel.add(this.iconifyButton);
         this.buttonPanel.add(this.maximizeButton);
         this.buttonPanel.add(this.restoreButton);
      }

      this.buttonPanel.add(this.closeButton);
   }

   protected JButton createButton(String iconKey, String accessibleName, ActionListener action) {
      JButton button = new JButton(UIManager.getIcon(iconKey));
      button.setFocusable(false);
      button.setContentAreaFilled(false);
      button.setBorder(BorderFactory.createEmptyBorder());
      button.putClientProperty("AccessibleName", accessibleName);
      button.addActionListener(action);
      return button;
   }

   protected void activeChanged(boolean active) {
      boolean hasEmbeddedMenuBar = this.rootPane.getJMenuBar() != null && this.isMenuBarEmbedded();
      Color background = FlatUIUtils.nonUIResource(active ? this.activeBackground : this.inactiveBackground);
      Color foreground = FlatUIUtils.nonUIResource(active ? (hasEmbeddedMenuBar ? this.embeddedForeground : this.activeForeground) : this.inactiveForeground);
      this.setBackground(background);
      this.titleLabel.setForeground(foreground);
      this.titleLabel.setHorizontalAlignment(hasEmbeddedMenuBar ? 0 : 10);
      this.iconifyButton.setBackground(background);
      this.maximizeButton.setBackground(background);
      this.restoreButton.setBackground(background);
      this.closeButton.setBackground(background);
   }

   protected void frameStateChanged() {
      if (this.window != null && this.rootPane.getWindowDecorationStyle() == 1) {
         if (this.window instanceof Frame) {
            Frame frame = (Frame)this.window;
            boolean resizable = frame.isResizable();
            boolean maximized = (frame.getExtendedState() & 6) != 0;
            this.iconifyButton.setVisible(true);
            this.maximizeButton.setVisible(resizable && !maximized);
            this.restoreButton.setVisible(resizable && maximized);
         } else {
            this.iconifyButton.setVisible(false);
            this.maximizeButton.setVisible(false);
            this.restoreButton.setVisible(false);
            this.revalidate();
            this.repaint();
         }

      }
   }

   protected void updateIcon() {
      List images = this.window.getIconImages();
      if (images.isEmpty()) {
         for(Window owner = this.window.getOwner(); owner != null; owner = owner.getOwner()) {
            images = owner.getIconImages();
            if (!images.isEmpty()) {
               break;
            }
         }
      }

      boolean hasIcon = true;
      if (!images.isEmpty()) {
         this.iconLabel.setIcon(FlatTitlePaneIcon.create(images, this.iconSize));
      } else {
         Icon defaultIcon = UIManager.getIcon("InternalFrame.icon");
         if (defaultIcon != null && (((Icon)defaultIcon).getIconWidth() == 0 || ((Icon)defaultIcon).getIconHeight() == 0)) {
            defaultIcon = null;
         }

         if (defaultIcon != null) {
            if (defaultIcon instanceof ImageIcon) {
               defaultIcon = new ScaledImageIcon((ImageIcon)defaultIcon, this.iconSize.width, this.iconSize.height);
            }

            this.iconLabel.setIcon((Icon)defaultIcon);
         } else {
            hasIcon = false;
         }
      }

      this.iconLabel.setVisible(hasIcon);
      this.updateJBRHitTestSpotsAndTitleBarHeightLater();
   }

   public void addNotify() {
      super.addNotify();
      this.uninstallWindowListeners();
      this.window = SwingUtilities.getWindowAncestor(this);
      if (this.window != null) {
         this.frameStateChanged();
         this.activeChanged(this.window.isActive());
         this.updateIcon();
         this.titleLabel.setText(this.getWindowTitle());
         this.installWindowListeners();
      }

      this.updateJBRHitTestSpotsAndTitleBarHeightLater();
   }

   public void removeNotify() {
      super.removeNotify();
      this.uninstallWindowListeners();
      this.window = null;
   }

   protected String getWindowTitle() {
      if (this.window instanceof Frame) {
         return ((Frame)this.window).getTitle();
      } else {
         return this.window instanceof Dialog ? ((Dialog)this.window).getTitle() : null;
      }
   }

   protected void installWindowListeners() {
      if (this.window != null) {
         this.window.addPropertyChangeListener(this.handler);
         this.window.addWindowListener(this.handler);
         this.window.addWindowStateListener(this.handler);
         this.window.addComponentListener(this.handler);
      }
   }

   protected void uninstallWindowListeners() {
      if (this.window != null) {
         this.window.removePropertyChangeListener(this.handler);
         this.window.removeWindowListener(this.handler);
         this.window.removeWindowStateListener(this.handler);
         this.window.removeComponentListener(this.handler);
      }
   }

   protected boolean isMenuBarEmbedded() {
      return UIManager.getBoolean("TitlePane.menuBarEmbedded") && FlatClientProperties.clientPropertyBoolean(this.rootPane, "JRootPane.menuBarEmbedded", true) && FlatSystemProperties.getBoolean("flatlaf.menuBarEmbedded", true);
   }

   protected Rectangle getMenuBarBounds() {
      Insets insets = this.rootPane.getInsets();
      Rectangle bounds = new Rectangle(SwingUtilities.convertPoint(this.menuBarPlaceholder, -insets.left, -insets.top, this.rootPane), this.menuBarPlaceholder.getSize());
      Insets borderInsets = this.getBorder().getBorderInsets(this);
      bounds.height += borderInsets.bottom;
      return FlatUIUtils.subtractInsets(bounds, UIScale.scale(this.getMenuBarMargins()));
   }

   protected void menuBarChanged() {
      this.menuBarPlaceholder.invalidate();
      EventQueue.invokeLater(() -> {
         this.activeChanged(this.window == null || this.window.isActive());
      });
   }

   protected Insets getMenuBarMargins() {
      return this.getComponentOrientation().isLeftToRight() ? this.menuBarMargins : new Insets(this.menuBarMargins.top, this.menuBarMargins.right, this.menuBarMargins.bottom, this.menuBarMargins.left);
   }

   protected void paintComponent(Graphics g) {
      g.setColor(this.getBackground());
      g.fillRect(0, 0, this.getWidth(), this.getHeight());
   }

   protected void repaintWindowBorder() {
      int width = this.rootPane.getWidth();
      int height = this.rootPane.getHeight();
      Insets insets = this.rootPane.getInsets();
      this.rootPane.repaint(0, 0, width, insets.top);
      this.rootPane.repaint(0, 0, insets.left, height);
      this.rootPane.repaint(0, height - insets.bottom, width, insets.bottom);
      this.rootPane.repaint(width - insets.right, 0, insets.right, height);
   }

   protected void iconify() {
      if (this.window instanceof Frame) {
         Frame frame = (Frame)this.window;
         frame.setExtendedState(frame.getExtendedState() | 1);
      }

   }

   protected void maximize() {
      if (this.window instanceof Frame) {
         Frame frame = (Frame)this.window;
         if (!this.hasJBRCustomDecoration() && (frame.getMaximizedBounds() == null || Objects.equals(frame.getMaximizedBounds(), this.rootPane.getClientProperty("_flatlaf.maximizedBounds")))) {
            GraphicsConfiguration gc = this.window.getGraphicsConfiguration();
            Rectangle screenBounds = gc.getBounds();
            int maximizedX = screenBounds.x;
            int maximizedY = screenBounds.y;
            int maximizedWidth = screenBounds.width;
            int maximizedHeight = screenBounds.height;
            if (!SystemInfo.IS_JAVA_15_OR_LATER) {
               maximizedX = 0;
               maximizedY = 0;
               AffineTransform defaultTransform = gc.getDefaultTransform();
               maximizedWidth = (int)((double)maximizedWidth * defaultTransform.getScaleX());
               maximizedHeight = (int)((double)maximizedHeight * defaultTransform.getScaleY());
            }

            Insets screenInsets = this.window.getToolkit().getScreenInsets(gc);
            Rectangle maximizedBounds = new Rectangle(maximizedX + screenInsets.left, maximizedY + screenInsets.top, maximizedWidth - screenInsets.left - screenInsets.right, maximizedHeight - screenInsets.top - screenInsets.bottom);
            frame.setMaximizedBounds(maximizedBounds);
            this.rootPane.putClientProperty("_flatlaf.maximizedBounds", maximizedBounds);
         }

         frame.setExtendedState(frame.getExtendedState() | 6);
      }
   }

   protected void restore() {
      if (this.window instanceof Frame) {
         Frame frame = (Frame)this.window;
         int state = frame.getExtendedState();
         frame.setExtendedState((state & 1) != 0 ? state & -2 : state & -7);
      }

   }

   protected void close() {
      if (this.window != null) {
         this.window.dispatchEvent(new WindowEvent(this.window, 201));
      }

   }

   protected boolean hasJBRCustomDecoration() {
      return FlatRootPaneUI.canUseJBRCustomDecorations && this.window != null && JBRCustomDecorations.hasCustomDecoration(this.window);
   }

   protected void updateJBRHitTestSpotsAndTitleBarHeightLater() {
      EventQueue.invokeLater(() -> {
         this.updateJBRHitTestSpotsAndTitleBarHeight();
      });
   }

   protected void updateJBRHitTestSpotsAndTitleBarHeight() {
      if (this.isDisplayable()) {
         if (this.hasJBRCustomDecoration()) {
            List hitTestSpots = new ArrayList();
            if (this.iconLabel.isVisible()) {
               this.addJBRHitTestSpot(this.iconLabel, false, hitTestSpots);
            }

            this.addJBRHitTestSpot(this.buttonPanel, false, hitTestSpots);
            this.addJBRHitTestSpot(this.menuBarPlaceholder, true, hitTestSpots);
            int titleBarHeight = this.getHeight();
            if (titleBarHeight > 0) {
               --titleBarHeight;
            }

            JBRCustomDecorations.setHitTestSpotsAndTitleBarHeight(this.window, hitTestSpots, titleBarHeight);
         }
      }
   }

   protected void addJBRHitTestSpot(JComponent c, boolean subtractMenuBarMargins, List hitTestSpots) {
      Dimension size = c.getSize();
      if (size.width > 0 && size.height > 0) {
         Point location = SwingUtilities.convertPoint(c, 0, 0, this.window);
         Rectangle r = new Rectangle(location, size);
         if (subtractMenuBarMargins) {
            r = FlatUIUtils.subtractInsets(r, UIScale.scale(this.getMenuBarMargins()));
         }

         r.grow(2, 2);
         hitTestSpots.add(r);
      }
   }

   protected class Handler extends WindowAdapter implements PropertyChangeListener, MouseListener, MouseMotionListener, ComponentListener {
      private int lastXOnScreen;
      private int lastYOnScreen;

      public void propertyChange(PropertyChangeEvent e) {
         String var2 = e.getPropertyName();
         byte var3 = -1;
         switch(var2.hashCode()) {
         case -1410965406:
            if (var2.equals("iconImage")) {
               var3 = 2;
            }
            break;
         case 110371416:
            if (var2.equals("title")) {
               var3 = 0;
            }
            break;
         case 1247047827:
            if (var2.equals("componentOrientation")) {
               var3 = 3;
            }
            break;
         case 2144232107:
            if (var2.equals("resizable")) {
               var3 = 1;
            }
         }

         switch(var3) {
         case 0:
            FlatTitlePane.this.titleLabel.setText(FlatTitlePane.this.getWindowTitle());
            break;
         case 1:
            if (FlatTitlePane.this.window instanceof Frame) {
               FlatTitlePane.this.frameStateChanged();
            }
            break;
         case 2:
            FlatTitlePane.this.updateIcon();
            break;
         case 3:
            FlatTitlePane.this.updateJBRHitTestSpotsAndTitleBarHeightLater();
         }

      }

      public void windowActivated(WindowEvent e) {
         FlatTitlePane.this.activeChanged(true);
         FlatTitlePane.this.updateJBRHitTestSpotsAndTitleBarHeight();
         if (FlatTitlePane.this.hasJBRCustomDecoration()) {
            JBRCustomDecorations.JBRWindowTopBorder.getInstance().repaintBorder(FlatTitlePane.this);
         }

         FlatTitlePane.this.repaintWindowBorder();
      }

      public void windowDeactivated(WindowEvent e) {
         FlatTitlePane.this.activeChanged(false);
         FlatTitlePane.this.updateJBRHitTestSpotsAndTitleBarHeight();
         if (FlatTitlePane.this.hasJBRCustomDecoration()) {
            JBRCustomDecorations.JBRWindowTopBorder.getInstance().repaintBorder(FlatTitlePane.this);
         }

         FlatTitlePane.this.repaintWindowBorder();
      }

      public void windowStateChanged(WindowEvent e) {
         FlatTitlePane.this.frameStateChanged();
         FlatTitlePane.this.updateJBRHitTestSpotsAndTitleBarHeight();
      }

      public void mouseClicked(MouseEvent e) {
         if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
            if (e.getSource() == FlatTitlePane.this.iconLabel) {
               FlatTitlePane.this.close();
            } else if (!FlatTitlePane.this.hasJBRCustomDecoration() && FlatTitlePane.this.window instanceof Frame && ((Frame)FlatTitlePane.this.window).isResizable()) {
               Frame frame = (Frame)FlatTitlePane.this.window;
               if ((frame.getExtendedState() & 6) != 0) {
                  FlatTitlePane.this.restore();
               } else {
                  FlatTitlePane.this.maximize();
               }
            }
         }

      }

      public void mousePressed(MouseEvent e) {
         this.lastXOnScreen = e.getXOnScreen();
         this.lastYOnScreen = e.getYOnScreen();
      }

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }

      public void mouseDragged(MouseEvent e) {
         if (!FlatTitlePane.this.hasJBRCustomDecoration()) {
            int xOnScreen = e.getXOnScreen();
            int yOnScreen = e.getYOnScreen();
            if (this.lastXOnScreen != xOnScreen || this.lastYOnScreen != yOnScreen) {
               int state;
               if (FlatTitlePane.this.window instanceof Frame) {
                  Frame frame = (Frame)FlatTitlePane.this.window;
                  state = frame.getExtendedState();
                  if ((state & 6) != 0) {
                     int maximizedX = FlatTitlePane.this.window.getX();
                     int maximizedY = FlatTitlePane.this.window.getY();
                     frame.setExtendedState(state & -7);
                     int restoredWidth = FlatTitlePane.this.window.getWidth();
                     int newXx = maximizedX;
                     JComponent rightComp = FlatTitlePane.this.getComponentOrientation().isLeftToRight() ? FlatTitlePane.this.buttonPanel : FlatTitlePane.this.leftPanel;
                     if (xOnScreen >= maximizedX + restoredWidth - rightComp.getWidth() - 10) {
                        newXx = xOnScreen + rightComp.getWidth() + 10 - restoredWidth;
                     }

                     FlatTitlePane.this.window.setLocation(newXx, maximizedY);
                     return;
                  }
               }

               int newX = FlatTitlePane.this.window.getX() + (xOnScreen - this.lastXOnScreen);
               state = FlatTitlePane.this.window.getY() + (yOnScreen - this.lastYOnScreen);
               FlatTitlePane.this.window.setLocation(newX, state);
               this.lastXOnScreen = xOnScreen;
               this.lastYOnScreen = yOnScreen;
            }
         }
      }

      public void mouseMoved(MouseEvent e) {
      }

      public void componentResized(ComponentEvent e) {
         FlatTitlePane.this.updateJBRHitTestSpotsAndTitleBarHeightLater();
      }

      public void componentMoved(ComponentEvent e) {
      }

      public void componentShown(ComponentEvent e) {
      }

      public void componentHidden(ComponentEvent e) {
      }
   }

   protected class FlatTitlePaneBorder extends AbstractBorder {
      public Insets getBorderInsets(Component c, Insets insets) {
         super.getBorderInsets(c, insets);
         Border menuBarBorder = this.getMenuBarBorder();
         if (menuBarBorder != null) {
            Insets menuBarInsets = menuBarBorder.getBorderInsets(c);
            insets.bottom += menuBarInsets.bottom;
         }

         if (FlatTitlePane.this.hasJBRCustomDecoration()) {
            insets = FlatUIUtils.addInsets(insets, JBRCustomDecorations.JBRWindowTopBorder.getInstance().getBorderInsets());
         }

         return insets;
      }

      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         Border menuBarBorder = this.getMenuBarBorder();
         if (menuBarBorder != null) {
            menuBarBorder.paintBorder(c, g, x, y, width, height);
         }

         if (FlatTitlePane.this.hasJBRCustomDecoration()) {
            JBRCustomDecorations.JBRWindowTopBorder.getInstance().paintBorder(c, g, x, y, width, height);
         }

      }

      protected Border getMenuBarBorder() {
         JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
         return menuBar != null && FlatTitlePane.this.isMenuBarEmbedded() ? menuBar.getBorder() : null;
      }
   }
}
