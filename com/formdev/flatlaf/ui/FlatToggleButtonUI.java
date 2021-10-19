package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

public class FlatToggleButtonUI extends FlatButtonUI {
   protected Color selectedBackground;
   protected Color selectedForeground;
   protected Color disabledSelectedBackground;
   protected Color toolbarSelectedBackground;
   protected int tabUnderlineHeight;
   protected Color tabUnderlineColor;
   protected Color tabDisabledUnderlineColor;
   protected Color tabSelectedBackground;
   protected Color tabHoverBackground;
   protected Color tabFocusBackground;
   private boolean defaults_initialized = false;
   private static ComponentUI instance;

   public static ComponentUI createUI(JComponent c) {
      if (instance == null) {
         instance = new FlatToggleButtonUI();
      }

      return instance;
   }

   protected String getPropertyPrefix() {
      return "ToggleButton.";
   }

   protected void installDefaults(AbstractButton b) {
      super.installDefaults(b);
      if (!this.defaults_initialized) {
         this.selectedBackground = UIManager.getColor("ToggleButton.selectedBackground");
         this.selectedForeground = UIManager.getColor("ToggleButton.selectedForeground");
         this.disabledSelectedBackground = UIManager.getColor("ToggleButton.disabledSelectedBackground");
         this.toolbarSelectedBackground = UIManager.getColor("ToggleButton.toolbar.selectedBackground");
         this.tabUnderlineHeight = UIManager.getInt("ToggleButton.tab.underlineHeight");
         this.tabUnderlineColor = UIManager.getColor("ToggleButton.tab.underlineColor");
         this.tabDisabledUnderlineColor = UIManager.getColor("ToggleButton.tab.disabledUnderlineColor");
         this.tabSelectedBackground = UIManager.getColor("ToggleButton.tab.selectedBackground");
         this.tabHoverBackground = UIManager.getColor("ToggleButton.tab.hoverBackground");
         this.tabFocusBackground = UIManager.getColor("ToggleButton.tab.focusBackground");
         this.defaults_initialized = true;
      }

   }

   protected void uninstallDefaults(AbstractButton b) {
      super.uninstallDefaults(b);
      this.defaults_initialized = false;
   }

   protected void propertyChange(AbstractButton b, PropertyChangeEvent e) {
      super.propertyChange(b, e);
      String var3 = e.getPropertyName();
      byte var4 = -1;
      switch(var3.hashCode()) {
      case -1405676274:
         if (var3.equals("JToggleButton.tab.underlineColor")) {
            var4 = 2;
         }
         break;
      case -1336690752:
         if (var3.equals("JToggleButton.tab.selectedBackground")) {
            var4 = 3;
         }
         break;
      case -492478244:
         if (var3.equals("JToggleButton.tab.underlineHeight")) {
            var4 = 1;
         }
         break;
      case 1428734622:
         if (var3.equals("JButton.buttonType")) {
            var4 = 0;
         }
      }

      switch(var4) {
      case 0:
         if ("tab".equals(e.getOldValue()) || "tab".equals(e.getNewValue())) {
            MigLayoutVisualPadding.uninstall(b);
            MigLayoutVisualPadding.install(b);
            b.revalidate();
         }

         b.repaint();
         break;
      case 1:
      case 2:
      case 3:
         b.repaint();
      }

   }

   static boolean isTabButton(Component c) {
      return c instanceof JToggleButton && FlatClientProperties.clientPropertyEquals((JToggleButton)c, "JButton.buttonType", "tab");
   }

   protected void paintBackground(Graphics g, JComponent c) {
      if (isTabButton(c)) {
         int height = c.getHeight();
         int width = c.getWidth();
         boolean selected = ((AbstractButton)c).isSelected();
         Color background = buttonStateColor(c, selected ? FlatClientProperties.clientPropertyColor(c, "JToggleButton.tab.selectedBackground", this.tabSelectedBackground) : null, (Color)null, this.tabFocusBackground, this.tabHoverBackground, (Color)null);
         if (background != null) {
            g.setColor(background);
            g.fillRect(0, 0, width, height);
         }

         if (selected) {
            int underlineHeight = UIScale.scale(FlatClientProperties.clientPropertyInt(c, "JToggleButton.tab.underlineHeight", this.tabUnderlineHeight));
            g.setColor(c.isEnabled() ? FlatClientProperties.clientPropertyColor(c, "JToggleButton.tab.underlineColor", this.tabUnderlineColor) : this.tabDisabledUnderlineColor);
            g.fillRect(0, height - underlineHeight, width, underlineHeight);
         }
      } else {
         super.paintBackground(g, c);
      }

   }

   protected Color getBackground(JComponent c) {
      ButtonModel model = ((AbstractButton)c).getModel();
      if (model.isSelected()) {
         boolean toolBarButton = isToolBarButton(c);
         return buttonStateColor(c, toolBarButton ? this.toolbarSelectedBackground : this.selectedBackground, toolBarButton ? this.toolbarSelectedBackground : this.disabledSelectedBackground, (Color)null, (Color)null, toolBarButton ? this.toolbarPressedBackground : this.pressedBackground);
      } else {
         return super.getBackground(c);
      }
   }

   protected Color getForeground(JComponent c) {
      return c.isEnabled() && ((AbstractButton)c).isSelected() && !isToolBarButton(c) ? this.selectedForeground : super.getForeground(c);
   }
}
