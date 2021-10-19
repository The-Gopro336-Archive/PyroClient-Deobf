package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D.Float;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI.PropertyChangeHandler;
import javax.swing.text.View;

public class FlatTabbedPaneUI extends BasicTabbedPaneUI {
   private static Set focusForwardTraversalKeys;
   private static Set focusBackwardTraversalKeys;
   protected Color disabledForeground;
   protected Color selectedBackground;
   protected Color selectedForeground;
   protected Color underlineColor;
   protected Color disabledUnderlineColor;
   protected Color hoverColor;
   protected Color focusColor;
   protected Color tabSeparatorColor;
   protected Color contentAreaColor;
   protected int tabHeight;
   protected int tabSelectionHeight;
   protected int contentSeparatorHeight;
   protected boolean showTabSeparators;
   protected boolean tabSeparatorsFullHeight;
   protected boolean hasFullBorder;
   protected boolean tabsOverlapBorder;

   public static ComponentUI createUI(JComponent c) {
      return new FlatTabbedPaneUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      this.disabledForeground = UIManager.getColor("TabbedPane.disabledForeground");
      this.selectedBackground = UIManager.getColor("TabbedPane.selectedBackground");
      this.selectedForeground = UIManager.getColor("TabbedPane.selectedForeground");
      this.underlineColor = UIManager.getColor("TabbedPane.underlineColor");
      this.disabledUnderlineColor = UIManager.getColor("TabbedPane.disabledUnderlineColor");
      this.hoverColor = UIManager.getColor("TabbedPane.hoverColor");
      this.focusColor = UIManager.getColor("TabbedPane.focusColor");
      this.tabSeparatorColor = UIManager.getColor("TabbedPane.tabSeparatorColor");
      this.contentAreaColor = UIManager.getColor("TabbedPane.contentAreaColor");
      this.tabHeight = UIManager.getInt("TabbedPane.tabHeight");
      this.tabSelectionHeight = UIManager.getInt("TabbedPane.tabSelectionHeight");
      this.contentSeparatorHeight = UIManager.getInt("TabbedPane.contentSeparatorHeight");
      this.showTabSeparators = UIManager.getBoolean("TabbedPane.showTabSeparators");
      this.tabSeparatorsFullHeight = UIManager.getBoolean("TabbedPane.tabSeparatorsFullHeight");
      this.hasFullBorder = UIManager.getBoolean("TabbedPane.hasFullBorder");
      this.tabsOverlapBorder = UIManager.getBoolean("TabbedPane.tabsOverlapBorder");
      this.textIconGap = UIScale.scale(this.textIconGap);
      this.tabInsets = UIScale.scale(this.tabInsets);
      this.selectedTabPadInsets = UIScale.scale(this.selectedTabPadInsets);
      this.tabAreaInsets = UIScale.scale(this.tabAreaInsets);
      this.tabHeight = UIScale.scale(this.tabHeight);
      this.tabSelectionHeight = UIScale.scale(this.tabSelectionHeight);
      if (focusForwardTraversalKeys == null) {
         focusForwardTraversalKeys = Collections.singleton(KeyStroke.getKeyStroke(9, 0));
         focusBackwardTraversalKeys = Collections.singleton(KeyStroke.getKeyStroke(9, 1));
      }

      this.tabPane.setFocusTraversalKeys(0, focusForwardTraversalKeys);
      this.tabPane.setFocusTraversalKeys(1, focusBackwardTraversalKeys);
      MigLayoutVisualPadding.install(this.tabPane, (Insets)null);
   }

   protected void uninstallDefaults() {
      this.tabPane.setFocusTraversalKeys(0, (Set)null);
      this.tabPane.setFocusTraversalKeys(1, (Set)null);
      super.uninstallDefaults();
      this.disabledForeground = null;
      this.selectedBackground = null;
      this.selectedForeground = null;
      this.underlineColor = null;
      this.disabledUnderlineColor = null;
      this.hoverColor = null;
      this.focusColor = null;
      this.tabSeparatorColor = null;
      this.contentAreaColor = null;
      MigLayoutVisualPadding.uninstall(this.tabPane);
   }

   protected PropertyChangeListener createPropertyChangeListener() {
      return new PropertyChangeHandler() {
         public void propertyChange(PropertyChangeEvent e) {
            super.propertyChange(e);
            String var2 = e.getPropertyName();
            byte var3 = -1;
            switch(var2.hashCode()) {
            case -550815195:
               if (var2.equals("JTabbedPane.hasFullBorder")) {
                  var3 = 1;
               }
               break;
            case -20133524:
               if (var2.equals("JTabbedPane.tabHeight")) {
                  var3 = 2;
               }
               break;
            case 739719158:
               if (var2.equals("JTabbedPane.showTabSeparators")) {
                  var3 = 0;
               }
            }

            switch(var3) {
            case 0:
            case 1:
            case 2:
               FlatTabbedPaneUI.this.tabPane.revalidate();
               FlatTabbedPaneUI.this.tabPane.repaint();
            default:
            }
         }
      };
   }

   protected JButton createScrollButton(int direction) {
      return new FlatArrowButton(direction, UIManager.getString("Component.arrowType"), UIManager.getColor("TabbedPane.foreground"), UIManager.getColor("TabbedPane.disabledForeground"), (Color)null, UIManager.getColor("TabbedPane.hoverColor"));
   }

   protected void setRolloverTab(int index) {
      int oldIndex = this.getRolloverTab();
      super.setRolloverTab(index);
      if (index != oldIndex) {
         this.repaintTab(oldIndex);
         this.repaintTab(index);
      }
   }

   private void repaintTab(int tabIndex) {
      if (tabIndex >= 0 && tabIndex < this.tabPane.getTabCount()) {
         Rectangle r = this.getTabBounds(this.tabPane, tabIndex);
         if (r != null) {
            this.tabPane.repaint(r);
         }

      }
   }

   protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
      return super.calculateTabWidth(tabPlacement, tabIndex, metrics) - 3;
   }

   protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
      int tabHeight = FlatClientProperties.clientPropertyInt(this.tabPane, "JTabbedPane.tabHeight", this.tabHeight);
      return Math.max(tabHeight, super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) - 2);
   }

   protected Insets getContentBorderInsets(int tabPlacement) {
      boolean hasFullBorder = FlatClientProperties.clientPropertyBoolean(this.tabPane, "JTabbedPane.hasFullBorder", this.hasFullBorder);
      int sh = UIScale.scale(this.contentSeparatorHeight);
      Insets insets = hasFullBorder ? new Insets(sh, sh, sh, sh) : new Insets(sh, 0, 0, 0);
      Insets contentBorderInsets = new Insets(0, 0, 0, 0);
      rotateInsets(insets, contentBorderInsets, tabPlacement);
      return contentBorderInsets;
   }

   protected int getTabLabelShiftX(int tabPlacement, int tabIndex, boolean isSelected) {
      return 0;
   }

   protected int getTabLabelShiftY(int tabPlacement, int tabIndex, boolean isSelected) {
      return 0;
   }

   public void update(Graphics g, JComponent c) {
      FlatUIUtils.setRenderingHints((Graphics2D)g);
      super.update(g, c);
   }

   protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
      g.setFont(font);
      View view = this.getTextViewForTab(tabIndex);
      if (view != null) {
         view.paint(g, textRect);
      } else {
         Color color;
         if (this.tabPane.isEnabled() && this.tabPane.isEnabledAt(tabIndex)) {
            color = this.tabPane.getForegroundAt(tabIndex);
            if (isSelected && color instanceof UIResource && this.selectedForeground != null) {
               color = this.selectedForeground;
            }
         } else {
            color = this.disabledForeground;
         }

         int mnemIndex = FlatLaf.isShowMnemonics() ? this.tabPane.getDisplayedMnemonicIndexAt(tabIndex) : -1;
         g.setColor(color);
         FlatUIUtils.drawStringUnderlineCharAt(this.tabPane, g, title, mnemIndex, textRect.x, textRect.y + metrics.getAscent());
      }
   }

   protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
      boolean enabled = this.tabPane.isEnabled();
      g.setColor(enabled && this.tabPane.isEnabledAt(tabIndex) && this.getRolloverTab() == tabIndex ? this.hoverColor : (enabled && isSelected && FlatUIUtils.isPermanentFocusOwner(this.tabPane) ? this.focusColor : (this.selectedBackground != null && enabled && isSelected ? this.selectedBackground : this.tabPane.getBackgroundAt(tabIndex))));
      g.fillRect(x, y, w, h);
   }

   protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
      if (FlatClientProperties.clientPropertyBoolean(this.tabPane, "JTabbedPane.showTabSeparators", this.showTabSeparators) && !this.isLastInRun(tabIndex)) {
         this.paintTabSeparator(g, tabPlacement, x, y, w, h);
      }

      if (isSelected) {
         this.paintTabSelection(g, tabPlacement, x, y, w, h);
      }

   }

   protected void paintTabSeparator(Graphics g, int tabPlacement, int x, int y, int w, int h) {
      float sepWidth = UIScale.scale(1.0F);
      float offset = this.tabSeparatorsFullHeight ? 0.0F : UIScale.scale(5.0F);
      g.setColor(this.tabSeparatorColor != null ? this.tabSeparatorColor : this.contentAreaColor);
      if (tabPlacement != 2 && tabPlacement != 4) {
         if (this.tabPane.getComponentOrientation().isLeftToRight()) {
            ((Graphics2D)g).fill(new Float((float)(x + w) - sepWidth, (float)y + offset, sepWidth, (float)h - offset * 2.0F));
         } else {
            ((Graphics2D)g).fill(new Float((float)x, (float)y + offset, sepWidth, (float)h - offset * 2.0F));
         }
      } else {
         ((Graphics2D)g).fill(new Float((float)x + offset, (float)(y + h) - sepWidth, (float)w - offset * 2.0F, sepWidth));
      }

   }

   protected void paintTabSelection(Graphics g, int tabPlacement, int x, int y, int w, int h) {
      Rectangle clipBounds = this.isScrollTabLayout() ? g.getClipBounds() : null;
      int sy;
      if (clipBounds != null) {
         Rectangle newClipBounds = new Rectangle(clipBounds);
         sy = UIScale.scale(this.contentSeparatorHeight);
         switch(tabPlacement) {
         case 1:
         default:
            newClipBounds.height += sy;
            break;
         case 2:
            newClipBounds.width += sy;
            break;
         case 3:
            newClipBounds.y -= sy;
            newClipBounds.height += sy;
            break;
         case 4:
            newClipBounds.x -= sy;
            newClipBounds.width += sy;
         }

         g.setClip(newClipBounds);
      }

      g.setColor(this.tabPane.isEnabled() ? this.underlineColor : this.disabledUnderlineColor);
      Insets contentInsets = this.getContentBorderInsets(tabPlacement);
      switch(tabPlacement) {
      case 1:
      default:
         sy = y + h + contentInsets.top - this.tabSelectionHeight;
         g.fillRect(x, sy, w, this.tabSelectionHeight);
         break;
      case 2:
         int sx = x + w + contentInsets.left - this.tabSelectionHeight;
         g.fillRect(sx, y, this.tabSelectionHeight, h);
         break;
      case 3:
         g.fillRect(x, y - contentInsets.bottom, w, this.tabSelectionHeight);
         break;
      case 4:
         g.fillRect(x - contentInsets.right, y, this.tabSelectionHeight, h);
      }

      if (clipBounds != null) {
         g.setClip(clipBounds);
      }

   }

   protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
      if (this.tabPane.getTabCount() > 0) {
         Insets insets = this.tabPane.getInsets();
         Insets tabAreaInsets = this.getTabAreaInsets(tabPlacement);
         int x = insets.left;
         int y = insets.top;
         int w = this.tabPane.getWidth() - insets.right - insets.left;
         int h = this.tabPane.getHeight() - insets.top - insets.bottom;
         switch(tabPlacement) {
         case 1:
         default:
            y += this.calculateTabAreaHeight(tabPlacement, this.runCount, this.maxTabHeight);
            if (this.tabsOverlapBorder) {
               y -= tabAreaInsets.bottom;
            }

            h -= y - insets.top;
            break;
         case 2:
            x += this.calculateTabAreaWidth(tabPlacement, this.runCount, this.maxTabWidth);
            if (this.tabsOverlapBorder) {
               x -= tabAreaInsets.right;
            }

            w -= x - insets.left;
            break;
         case 3:
            h -= this.calculateTabAreaHeight(tabPlacement, this.runCount, this.maxTabHeight);
            if (this.tabsOverlapBorder) {
               h += tabAreaInsets.top;
            }
            break;
         case 4:
            w -= this.calculateTabAreaWidth(tabPlacement, this.runCount, this.maxTabWidth);
            if (this.tabsOverlapBorder) {
               w += tabAreaInsets.left;
            }
         }

         boolean hasFullBorder = FlatClientProperties.clientPropertyBoolean(this.tabPane, "JTabbedPane.hasFullBorder", this.hasFullBorder);
         int sh = UIScale.scale(this.contentSeparatorHeight * 100);
         Insets ci = new Insets(0, 0, 0, 0);
         rotateInsets(hasFullBorder ? new Insets(sh, sh, sh, sh) : new Insets(sh, 0, 0, 0), ci, tabPlacement);
         g.setColor(this.contentAreaColor);
         Path2D path = new java.awt.geom.Path2D.Float(0);
         path.append(new Float((float)x, (float)y, (float)w, (float)h), false);
         path.append(new Float((float)x + (float)ci.left / 100.0F, (float)y + (float)ci.top / 100.0F, (float)w - (float)ci.left / 100.0F - (float)ci.right / 100.0F, (float)h - (float)ci.top / 100.0F - (float)ci.bottom / 100.0F), false);
         ((Graphics2D)g).fill(path);
         if (this.isScrollTabLayout() && selectedIndex >= 0) {
            Component scrollableTabViewport = this.findComponentByClassName(this.tabPane, BasicTabbedPaneUI.class.getName() + "$ScrollableTabViewport");
            if (scrollableTabViewport != null) {
               Rectangle tabRect = this.getTabBounds(this.tabPane, selectedIndex);
               Shape oldClip = g.getClip();
               g.setClip(scrollableTabViewport.getBounds());
               this.paintTabSelection(g, tabPlacement, tabRect.x, tabRect.y, tabRect.width, tabRect.height);
               g.setClip(oldClip);
            }
         }

      }
   }

   protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
   }

   private boolean isLastInRun(int tabIndex) {
      int run = this.getRunForTab(this.tabPane.getTabCount(), tabIndex);
      return this.lastTabInRun(this.tabPane.getTabCount(), run) == tabIndex;
   }

   private boolean isScrollTabLayout() {
      return this.tabPane.getTabLayoutPolicy() == 1;
   }

   private Component findComponentByClassName(Container c, String className) {
      Component[] var3 = c.getComponents();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Component child = var3[var5];
         if (className.equals(child.getClass().getName())) {
            return child;
         }

         if (child instanceof Container) {
            Component c2 = this.findComponentByClassName((Container)child, className);
            if (c2 != null) {
               return c2;
            }
         }
      }

      return null;
   }
}
