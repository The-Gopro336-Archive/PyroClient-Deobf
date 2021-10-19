package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.SystemInfo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class FlatPopupFactory extends PopupFactory {
   private Method java8getPopupMethod;
   private Method java9getPopupMethod;

   public Popup getPopup(Component owner, Component contents, int x, int y) throws IllegalArgumentException {
      if (!this.isDropShadowPainted(owner, contents)) {
         return new FlatPopupFactory.NonFlashingPopup(super.getPopup(owner, contents, x, y), contents);
      } else if (!SystemInfo.IS_MAC && !SystemInfo.IS_LINUX) {
         return new FlatPopupFactory.DropShadowPopup(super.getPopup(owner, contents, x, y), owner, contents);
      } else {
         Popup popup = this.getHeavyWeightPopup(owner, contents, x, y);
         if (popup == null) {
            popup = super.getPopup(owner, contents, x, y);
         }

         return new FlatPopupFactory.NonFlashingPopup(popup, contents);
      }
   }

   private boolean isDropShadowPainted(Component owner, Component contents) {
      Boolean b = this.isDropShadowPainted(owner);
      if (b != null) {
         return b;
      } else {
         b = this.isDropShadowPainted(contents);
         return b != null ? b : UIManager.getBoolean("Popup.dropShadowPainted");
      }
   }

   private Boolean isDropShadowPainted(Component c) {
      if (!(c instanceof JComponent)) {
         return null;
      } else {
         Object value = ((JComponent)c).getClientProperty("Popup.dropShadowPainted");
         return value instanceof Boolean ? (Boolean)value : null;
      }
   }

   private Popup getHeavyWeightPopup(Component owner, Component contents, int x, int y) throws IllegalArgumentException {
      try {
         if (SystemInfo.IS_JAVA_9_OR_LATER) {
            if (this.java9getPopupMethod == null) {
               this.java9getPopupMethod = PopupFactory.class.getDeclaredMethod("getPopup", Component.class, Component.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
            }

            return (Popup)this.java9getPopupMethod.invoke(this, owner, contents, x, y, true);
         } else {
            if (this.java8getPopupMethod == null) {
               this.java8getPopupMethod = PopupFactory.class.getDeclaredMethod("getPopup", Component.class, Component.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
               this.java8getPopupMethod.setAccessible(true);
            }

            return (Popup)this.java8getPopupMethod.invoke(this, owner, contents, x, y, 2);
         }
      } catch (SecurityException | IllegalAccessException | InvocationTargetException | NoSuchMethodException var6) {
         return null;
      }
   }

   private class DropShadowPopup extends FlatPopupFactory.NonFlashingPopup {
      private final Component owner;
      private JComponent lightComp;
      private Border oldBorder;
      private boolean oldOpaque;
      private boolean mediumWeightShown;
      private Panel mediumWeightPanel;
      private JPanel dropShadowPanel;
      private ComponentListener mediumPanelListener;
      private Popup dropShadowDelegate;
      private Window dropShadowWindow;
      private Color oldDropShadowWindowBackground;

      DropShadowPopup(Popup delegate, Component owner, Component contents) {
         super(delegate, contents);
         this.owner = owner;
         Dimension size = contents.getPreferredSize();
         if (size.width > 0 && size.height > 0) {
            if (this.popupWindow != null) {
               JPanel dropShadowPanel = new JPanel();
               dropShadowPanel.setBorder(this.createDropShadowBorder());
               dropShadowPanel.setOpaque(false);
               Dimension prefSize = this.popupWindow.getPreferredSize();
               Insets insets = dropShadowPanel.getInsets();
               dropShadowPanel.setPreferredSize(new Dimension(prefSize.width + insets.left + insets.right, prefSize.height + insets.top + insets.bottom));
               int x = this.popupWindow.getX() - insets.left;
               int y = this.popupWindow.getY() - insets.top;
               this.dropShadowDelegate = FlatPopupFactory.this.getHeavyWeightPopup(owner, dropShadowPanel, x, y);
               this.dropShadowWindow = SwingUtilities.windowForComponent(dropShadowPanel);
               if (this.dropShadowWindow != null) {
                  this.oldDropShadowWindowBackground = this.dropShadowWindow.getBackground();
                  this.dropShadowWindow.setBackground(new Color(0, true));
               }
            } else {
               this.mediumWeightPanel = (Panel)SwingUtilities.getAncestorOfClass(Panel.class, contents);
               if (this.mediumWeightPanel != null) {
                  this.dropShadowPanel = new JPanel();
                  this.dropShadowPanel.setBorder(this.createDropShadowBorder());
                  this.dropShadowPanel.setOpaque(false);
                  this.dropShadowPanel.setSize(FlatUIUtils.addInsets(this.mediumWeightPanel.getSize(), this.dropShadowPanel.getInsets()));
               } else {
                  Container p = contents.getParent();
                  if (!(p instanceof JComponent)) {
                     return;
                  }

                  this.lightComp = (JComponent)p;
                  this.oldBorder = this.lightComp.getBorder();
                  this.oldOpaque = this.lightComp.isOpaque();
                  this.lightComp.setBorder(this.createDropShadowBorder());
                  this.lightComp.setOpaque(false);
                  this.lightComp.setSize(this.lightComp.getPreferredSize());
               }
            }

         }
      }

      private Border createDropShadowBorder() {
         return new FlatDropShadowBorder(UIManager.getColor("Popup.dropShadowColor"), UIManager.getInsets("Popup.dropShadowInsets"), FlatUIUtils.getUIFloat("Popup.dropShadowOpacity", 0.5F));
      }

      public void show() {
         if (this.dropShadowDelegate != null) {
            this.dropShadowDelegate.show();
         }

         if (this.mediumWeightPanel != null) {
            this.showMediumWeightDropShadow();
         }

         super.show();
         if (this.lightComp != null) {
            Insets insets = this.lightComp.getInsets();
            if (insets.left != 0 || insets.top != 0) {
               this.lightComp.setLocation(this.lightComp.getX() - insets.left, this.lightComp.getY() - insets.top);
            }
         }

      }

      public void hide() {
         if (this.dropShadowDelegate != null) {
            this.dropShadowDelegate.hide();
            this.dropShadowDelegate = null;
         }

         if (this.mediumWeightPanel != null) {
            this.hideMediumWeightDropShadow();
            this.dropShadowPanel = null;
            this.mediumWeightPanel = null;
         }

         super.hide();
         if (this.dropShadowWindow != null) {
            this.dropShadowWindow.setBackground(this.oldDropShadowWindowBackground);
            this.dropShadowWindow = null;
         }

         if (this.lightComp != null) {
            this.lightComp.setBorder(this.oldBorder);
            this.lightComp.setOpaque(this.oldOpaque);
            this.lightComp = null;
         }

      }

      private void showMediumWeightDropShadow() {
         if (!this.mediumWeightShown) {
            this.mediumWeightShown = true;
            Window window = SwingUtilities.windowForComponent(this.owner);
            if (window != null) {
               if (window instanceof RootPaneContainer) {
                  this.dropShadowPanel.setVisible(false);
                  JLayeredPane layeredPane = ((RootPaneContainer)window).getLayeredPane();
                  layeredPane.add(this.dropShadowPanel, JLayeredPane.POPUP_LAYER, 0);
                  this.mediumPanelListener = new ComponentListener() {
                     public void componentShown(ComponentEvent e) {
                        if (DropShadowPopup.this.dropShadowPanel != null) {
                           DropShadowPopup.this.dropShadowPanel.setVisible(true);
                        }

                     }

                     public void componentHidden(ComponentEvent e) {
                        if (DropShadowPopup.this.dropShadowPanel != null) {
                           DropShadowPopup.this.dropShadowPanel.setVisible(false);
                        }

                     }

                     public void componentMoved(ComponentEvent e) {
                        if (DropShadowPopup.this.dropShadowPanel != null && DropShadowPopup.this.mediumWeightPanel != null) {
                           Point location = DropShadowPopup.this.mediumWeightPanel.getLocation();
                           Insets insets = DropShadowPopup.this.dropShadowPanel.getInsets();
                           DropShadowPopup.this.dropShadowPanel.setLocation(location.x - insets.left, location.y - insets.top);
                        }

                     }

                     public void componentResized(ComponentEvent e) {
                        if (DropShadowPopup.this.dropShadowPanel != null) {
                           DropShadowPopup.this.dropShadowPanel.setSize(FlatUIUtils.addInsets(DropShadowPopup.this.mediumWeightPanel.getSize(), DropShadowPopup.this.dropShadowPanel.getInsets()));
                        }

                     }
                  };
                  this.mediumWeightPanel.addComponentListener(this.mediumPanelListener);
               }
            }
         }
      }

      private void hideMediumWeightDropShadow() {
         this.mediumWeightPanel.removeComponentListener(this.mediumPanelListener);
         Container parent = this.dropShadowPanel.getParent();
         if (parent != null) {
            Rectangle bounds = this.dropShadowPanel.getBounds();
            parent.remove(this.dropShadowPanel);
            parent.repaint(bounds.x, bounds.y, bounds.width, bounds.height);
         }

      }
   }

   private class NonFlashingPopup extends Popup {
      private Popup delegate;
      protected Window popupWindow;
      private Color oldPopupWindowBackground;

      NonFlashingPopup(Popup delegate, Component contents) {
         this.delegate = delegate;
         this.popupWindow = SwingUtilities.windowForComponent(contents);
         if (this.popupWindow != null) {
            this.oldPopupWindowBackground = this.popupWindow.getBackground();
            this.popupWindow.setBackground(contents.getBackground());
         }

      }

      public void show() {
         if (this.delegate != null) {
            this.delegate.show();
         }

      }

      public void hide() {
         if (this.delegate != null) {
            this.delegate.hide();
            this.delegate = null;
         }

         if (this.popupWindow != null) {
            this.popupWindow.setBackground(this.oldPopupWindowBackground);
            this.popupWindow = null;
         }

      }
   }
}
