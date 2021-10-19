package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D.Float;
import java.beans.PropertyChangeEvent;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;

public class FlatButtonUI extends BasicButtonUI {
   protected int minimumWidth;
   protected int iconTextGap;
   protected Color background;
   protected Color foreground;
   protected Color startBackground;
   protected Color endBackground;
   protected Color focusedBackground;
   protected Color hoverBackground;
   protected Color pressedBackground;
   protected Color disabledBackground;
   protected Color disabledText;
   protected Color defaultBackground;
   protected Color defaultEndBackground;
   protected Color defaultForeground;
   protected Color defaultFocusedBackground;
   protected Color defaultHoverBackground;
   protected Color defaultPressedBackground;
   protected boolean defaultBoldText;
   protected int shadowWidth;
   protected Color shadowColor;
   protected Color defaultShadowColor;
   protected Insets toolbarSpacingInsets;
   protected Color toolbarHoverBackground;
   protected Color toolbarPressedBackground;
   private Icon helpButtonIcon;
   private boolean defaults_initialized = false;
   private static ComponentUI instance;
   static final int TYPE_OTHER = -1;
   static final int TYPE_SQUARE = 0;
   static final int TYPE_ROUND_RECT = 1;

   public static ComponentUI createUI(JComponent c) {
      if (instance == null) {
         instance = new FlatButtonUI();
      }

      return instance;
   }

   protected void installDefaults(AbstractButton b) {
      super.installDefaults(b);
      if (!this.defaults_initialized) {
         String prefix = this.getPropertyPrefix();
         this.minimumWidth = UIManager.getInt(prefix + "minimumWidth");
         this.iconTextGap = FlatUIUtils.getUIInt(prefix + "iconTextGap", 4);
         this.background = UIManager.getColor(prefix + "background");
         this.foreground = UIManager.getColor(prefix + "foreground");
         this.startBackground = UIManager.getColor(prefix + "startBackground");
         this.endBackground = UIManager.getColor(prefix + "endBackground");
         this.focusedBackground = UIManager.getColor(prefix + "focusedBackground");
         this.hoverBackground = UIManager.getColor(prefix + "hoverBackground");
         this.pressedBackground = UIManager.getColor(prefix + "pressedBackground");
         this.disabledBackground = UIManager.getColor(prefix + "disabledBackground");
         this.disabledText = UIManager.getColor(prefix + "disabledText");
         if (UIManager.getBoolean("Button.paintShadow")) {
            this.shadowWidth = FlatUIUtils.getUIInt("Button.shadowWidth", 2);
            this.shadowColor = UIManager.getColor("Button.shadowColor");
            this.defaultShadowColor = UIManager.getColor("Button.default.shadowColor");
         } else {
            this.shadowWidth = 0;
            this.shadowColor = null;
            this.defaultShadowColor = null;
         }

         this.defaultBackground = FlatUIUtils.getUIColor("Button.default.startBackground", "Button.default.background");
         this.defaultEndBackground = UIManager.getColor("Button.default.endBackground");
         this.defaultForeground = UIManager.getColor("Button.default.foreground");
         this.defaultFocusedBackground = UIManager.getColor("Button.default.focusedBackground");
         this.defaultHoverBackground = UIManager.getColor("Button.default.hoverBackground");
         this.defaultPressedBackground = UIManager.getColor("Button.default.pressedBackground");
         this.defaultBoldText = UIManager.getBoolean("Button.default.boldText");
         this.toolbarSpacingInsets = UIManager.getInsets("Button.toolbar.spacingInsets");
         this.toolbarHoverBackground = UIManager.getColor(prefix + "toolbar.hoverBackground");
         this.toolbarPressedBackground = UIManager.getColor(prefix + "toolbar.pressedBackground");
         this.helpButtonIcon = UIManager.getIcon("HelpButton.icon");
         this.defaults_initialized = true;
      }

      if (this.startBackground != null) {
         Color bg = b.getBackground();
         if (bg == null || bg instanceof UIResource) {
            b.setBackground(this.startBackground);
         }
      }

      LookAndFeel.installProperty(b, "opaque", false);
      LookAndFeel.installProperty(b, "iconTextGap", UIScale.scale(this.iconTextGap));
      MigLayoutVisualPadding.install(b);
   }

   protected void uninstallDefaults(AbstractButton b) {
      super.uninstallDefaults(b);
      MigLayoutVisualPadding.uninstall(b);
      this.defaults_initialized = false;
   }

   protected BasicButtonListener createButtonListener(AbstractButton b) {
      return new FlatButtonUI.FlatButtonListener(b);
   }

   protected void propertyChange(AbstractButton b, PropertyChangeEvent e) {
      String var3 = e.getPropertyName();
      byte var4 = -1;
      switch(var3.hashCode()) {
      case -1302441837:
         if (var3.equals("JComponent.minimumWidth")) {
            var4 = 1;
         }
         break;
      case -1134471216:
         if (var3.equals("JButton.squareSize")) {
            var4 = 0;
         }
         break;
      case 1428734622:
         if (var3.equals("JButton.buttonType")) {
            var4 = 3;
         }
         break;
      case 2140981242:
         if (var3.equals("JComponent.minimumHeight")) {
            var4 = 2;
         }
      }

      switch(var4) {
      case 0:
      case 1:
      case 2:
         b.revalidate();
         break;
      case 3:
         b.revalidate();
         b.repaint();
      }

   }

   static boolean isContentAreaFilled(Component c) {
      return !(c instanceof AbstractButton) || ((AbstractButton)c).isContentAreaFilled();
   }

   public static boolean isFocusPainted(Component c) {
      return !(c instanceof AbstractButton) || ((AbstractButton)c).isFocusPainted();
   }

   static boolean isDefaultButton(Component c) {
      return c instanceof JButton && ((JButton)c).isDefaultButton();
   }

   static boolean isIconOnlyOrSingleCharacterButton(Component c) {
      if (!(c instanceof JButton) && !(c instanceof JToggleButton)) {
         return false;
      } else {
         Icon icon = ((AbstractButton)c).getIcon();
         String text = ((AbstractButton)c).getText();
         return icon != null && (text == null || text.isEmpty()) || icon == null && text != null && ("...".equals(text) || text.length() == 1);
      }
   }

   static int getButtonType(Component c) {
      return c instanceof AbstractButton ? FlatClientProperties.clientPropertyChoice((AbstractButton)c, "JButton.buttonType", "square", "roundRect") : -1;
   }

   static boolean isHelpButton(Component c) {
      return c instanceof JButton && FlatClientProperties.clientPropertyEquals((JButton)c, "JButton.buttonType", "help");
   }

   static boolean isToolBarButton(Component c) {
      return c.getParent() instanceof JToolBar || c instanceof AbstractButton && FlatClientProperties.clientPropertyEquals((AbstractButton)c, "JButton.buttonType", "toolBarButton");
   }

   public void update(Graphics g, JComponent c) {
      if (c.isOpaque()) {
         FlatUIUtils.paintParentBackground(g, c);
      }

      if (isHelpButton(c)) {
         this.helpButtonIcon.paintIcon(c, g, 0, 0);
      } else {
         if (isContentAreaFilled(c)) {
            this.paintBackground(g, c);
         }

         this.paint(g, c);
      }
   }

   protected void paintBackground(Graphics g, JComponent c) {
      Color background = this.getBackground(c);
      if (background != null) {
         Graphics2D g2 = (Graphics2D)g.create();

         try {
            FlatUIUtils.setRenderingHints(g2);
            boolean isToolBarButton = isToolBarButton(c);
            float focusWidth = isToolBarButton ? 0.0F : FlatUIUtils.getBorderFocusWidth(c);
            float arc = FlatUIUtils.getBorderArc(c);
            boolean def = isDefaultButton(c);
            int x = 0;
            int y = 0;
            int width = c.getWidth();
            int height = c.getHeight();
            if (isToolBarButton) {
               Insets spacing = UIScale.scale(this.toolbarSpacingInsets);
               x += spacing.left;
               y += spacing.top;
               width -= spacing.left + spacing.right;
               height -= spacing.top + spacing.bottom;
            }

            Color shadowColor = def ? this.defaultShadowColor : this.shadowColor;
            if (!isToolBarButton && shadowColor != null && this.shadowWidth > 0 && focusWidth > 0.0F && (!isFocusPainted(c) || !FlatUIUtils.isPermanentFocusOwner(c)) && c.isEnabled()) {
               g2.setColor(shadowColor);
               g2.fill(new Float(focusWidth, focusWidth + UIScale.scale((float)this.shadowWidth), (float)width - focusWidth * 2.0F, (float)height - focusWidth * 2.0F, arc, arc));
            }

            Color startBg = def ? this.defaultBackground : this.startBackground;
            Color endBg = def ? this.defaultEndBackground : this.endBackground;
            if (background == startBg && endBg != null && !startBg.equals(endBg)) {
               g2.setPaint(new GradientPaint(0.0F, 0.0F, startBg, 0.0F, (float)height, endBg));
            } else {
               g2.setColor(FlatUIUtils.deriveColor(background, this.getBackgroundBase(c, def)));
            }

            FlatUIUtils.paintComponentBackground(g2, x, y, width, height, focusWidth, arc);
         } finally {
            g2.dispose();
         }

      }
   }

   public void paint(Graphics g, JComponent c) {
      super.paint(FlatLabelUI.createGraphicsHTMLTextYCorrection(g, c), c);
   }

   protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
      if (!isHelpButton(b)) {
         if (this.defaultBoldText && isDefaultButton(b) && b.getFont() instanceof UIResource) {
            Font boldFont = g.getFont().deriveFont(1);
            g.setFont(boldFont);
            int boldWidth = b.getFontMetrics(boldFont).stringWidth(text);
            if (boldWidth > textRect.width) {
               textRect.x -= (boldWidth - textRect.width) / 2;
               textRect.width = boldWidth;
            }
         }

         paintText(g, b, textRect, text, this.getForeground(b));
      }
   }

   public static void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text, Color foreground) {
      FontMetrics fm = b.getFontMetrics(b.getFont());
      int mnemonicIndex = FlatLaf.isShowMnemonics() ? b.getDisplayedMnemonicIndex() : -1;
      g.setColor(foreground);
      FlatUIUtils.drawStringUnderlineCharAt(b, g, text, mnemonicIndex, textRect.x, textRect.y + fm.getAscent());
   }

   protected Color getBackground(JComponent c) {
      if (!c.isEnabled()) {
         return this.disabledBackground;
      } else if (isToolBarButton(c)) {
         ButtonModel model = ((AbstractButton)c).getModel();
         if (model.isPressed()) {
            return this.toolbarPressedBackground;
         } else {
            return model.isRollover() ? this.toolbarHoverBackground : c.getParent().getBackground();
         }
      } else {
         boolean def = isDefaultButton(c);
         return buttonStateColor(c, this.getBackgroundBase(c, def), (Color)null, this.isCustomBackground(c.getBackground()) ? null : (def ? this.defaultFocusedBackground : this.focusedBackground), def ? this.defaultHoverBackground : this.hoverBackground, def ? this.defaultPressedBackground : this.pressedBackground);
      }
   }

   protected Color getBackgroundBase(JComponent c, boolean def) {
      Color bg = c.getBackground();
      if (this.isCustomBackground(bg)) {
         return bg;
      } else {
         return def ? this.defaultBackground : bg;
      }
   }

   protected boolean isCustomBackground(Color bg) {
      return bg != this.background && (this.startBackground == null || bg != this.startBackground);
   }

   public static Color buttonStateColor(Component c, Color enabledColor, Color disabledColor, Color focusedColor, Color hoverColor, Color pressedColor) {
      AbstractButton b = c instanceof AbstractButton ? (AbstractButton)c : null;
      if (!c.isEnabled()) {
         return disabledColor;
      } else if (pressedColor != null && b != null && b.getModel().isPressed()) {
         return pressedColor;
      } else if (hoverColor != null && b != null && b.getModel().isRollover()) {
         return hoverColor;
      } else {
         return focusedColor != null && isFocusPainted(c) && FlatUIUtils.isPermanentFocusOwner(c) ? focusedColor : enabledColor;
      }
   }

   protected Color getForeground(JComponent c) {
      if (!c.isEnabled()) {
         return this.disabledText;
      } else {
         Color fg = c.getForeground();
         if (this.isCustomForeground(fg)) {
            return fg;
         } else {
            boolean def = isDefaultButton(c);
            return def ? this.defaultForeground : fg;
         }
      }
   }

   protected boolean isCustomForeground(Color fg) {
      return fg != this.foreground;
   }

   public Dimension getPreferredSize(JComponent c) {
      if (isHelpButton(c)) {
         return new Dimension(this.helpButtonIcon.getIconWidth(), this.helpButtonIcon.getIconHeight());
      } else {
         Dimension prefSize = super.getPreferredSize(c);
         if (prefSize == null) {
            return null;
         } else {
            boolean isIconOnlyOrSingleCharacter = isIconOnlyOrSingleCharacterButton(c);
            if (FlatClientProperties.clientPropertyBoolean(c, "JButton.squareSize", false)) {
               prefSize.width = prefSize.height = Math.max(prefSize.width, prefSize.height);
            } else if (isIconOnlyOrSingleCharacter && ((AbstractButton)c).getIcon() == null) {
               prefSize.width = Math.max(prefSize.width, prefSize.height);
            } else if (!isIconOnlyOrSingleCharacter && !isToolBarButton(c) && c.getBorder() instanceof FlatButtonBorder) {
               float focusWidth = FlatUIUtils.getBorderFocusWidth(c);
               prefSize.width = Math.max(prefSize.width, UIScale.scale(FlatUIUtils.minimumWidth(c, this.minimumWidth)) + Math.round(focusWidth * 2.0F));
               prefSize.height = Math.max(prefSize.height, UIScale.scale(FlatUIUtils.minimumHeight(c, 0)) + Math.round(focusWidth * 2.0F));
            }

            return prefSize;
         }
      }
   }

   protected class FlatButtonListener extends BasicButtonListener {
      // $FF: renamed from: b javax.swing.AbstractButton
      private final AbstractButton field_2461;

      protected FlatButtonListener(AbstractButton b) {
         super(b);
         this.field_2461 = b;
      }

      public void propertyChange(PropertyChangeEvent e) {
         super.propertyChange(e);
         FlatButtonUI.this.propertyChange(this.field_2461, e);
      }
   }
}
