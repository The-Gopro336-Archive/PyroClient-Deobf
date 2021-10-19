package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.HiDPIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.Caret;
import javax.swing.text.JTextComponent;

public class FlatTextFieldUI extends BasicTextFieldUI {
   protected int minimumWidth;
   protected boolean isIntelliJTheme;
   protected Color placeholderForeground;
   private FocusListener focusListener;

   public static ComponentUI createUI(JComponent c) {
      return new FlatTextFieldUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      String prefix = this.getPropertyPrefix();
      this.minimumWidth = UIManager.getInt("Component.minimumWidth");
      this.isIntelliJTheme = UIManager.getBoolean("Component.isIntelliJTheme");
      this.placeholderForeground = UIManager.getColor(prefix + ".placeholderForeground");
      LookAndFeel.installProperty(this.getComponent(), "opaque", false);
      MigLayoutVisualPadding.install(this.getComponent());
   }

   protected void uninstallDefaults() {
      super.uninstallDefaults();
      this.placeholderForeground = null;
      MigLayoutVisualPadding.uninstall(this.getComponent());
   }

   protected void installListeners() {
      super.installListeners();
      this.focusListener = new FlatUIUtils.RepaintFocusListener(this.getComponent());
      this.getComponent().addFocusListener(this.focusListener);
   }

   protected void uninstallListeners() {
      super.uninstallListeners();
      this.getComponent().removeFocusListener(this.focusListener);
      this.focusListener = null;
   }

   protected Caret createCaret() {
      return new FlatCaret(UIManager.getString("TextComponent.selectAllOnFocusPolicy"));
   }

   protected void propertyChange(PropertyChangeEvent e) {
      super.propertyChange(e);
      propertyChange(this.getComponent(), e);
   }

   static void propertyChange(JTextComponent c, PropertyChangeEvent e) {
      String var2 = e.getPropertyName();
      byte var3 = -1;
      switch(var2.hashCode()) {
      case -1302441837:
         if (var2.equals("JComponent.minimumWidth")) {
            var3 = 2;
         }
         break;
      case -742334409:
         if (var2.equals("JComponent.roundRect")) {
            var3 = 1;
         }
         break;
      case 151255029:
         if (var2.equals("JTextField.placeholderText")) {
            var3 = 0;
         }
      }

      switch(var3) {
      case 0:
      case 1:
         c.repaint();
         break;
      case 2:
         c.revalidate();
      }

   }

   protected void paintSafely(Graphics g) {
      paintBackground(g, this.getComponent(), this.isIntelliJTheme);
      paintPlaceholder(g, this.getComponent(), this.placeholderForeground);
      super.paintSafely(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g));
   }

   protected void paintBackground(Graphics g) {
   }

   static void paintBackground(Graphics g, JTextComponent c, boolean isIntelliJTheme) {
      if (c.isOpaque() || FlatUIUtils.getOutsideFlatBorder(c) != null || !FlatUIUtils.hasOpaqueBeenExplicitlySet(c)) {
         float focusWidth = FlatUIUtils.getBorderFocusWidth(c);
         float arc = FlatUIUtils.getBorderArc(c);
         if (c.isOpaque() && (focusWidth > 0.0F || arc > 0.0F)) {
            FlatUIUtils.paintParentBackground(g, c);
         }

         Graphics2D g2 = (Graphics2D)g.create();

         try {
            FlatUIUtils.setRenderingHints(g2);
            Color background = c.getBackground();
            g2.setColor(!(background instanceof UIResource) ? background : (isIntelliJTheme && (!c.isEnabled() || !c.isEditable()) ? FlatUIUtils.getParentBackground(c) : background));
            FlatUIUtils.paintComponentBackground(g2, 0, 0, c.getWidth(), c.getHeight(), focusWidth, arc);
         } finally {
            g2.dispose();
         }

      }
   }

   static void paintPlaceholder(Graphics g, JTextComponent c, Color placeholderForeground) {
      if (c.getDocument().getLength() <= 0) {
         Container parent = c.getParent();
         JComponent jc = parent instanceof JComboBox ? (JComboBox)parent : c;
         Object placeholder = ((JComponent)jc).getClientProperty("JTextField.placeholderText");
         if (placeholder instanceof String) {
            Insets insets = c.getInsets();
            FontMetrics fm = c.getFontMetrics(c.getFont());
            int x = insets.left;
            int y = insets.top + fm.getAscent() + (c.getHeight() - insets.top - insets.bottom - fm.getHeight()) / 2;
            g.setColor(placeholderForeground);
            FlatUIUtils.drawString(c, g, (String)placeholder, x, y);
         }
      }
   }

   public Dimension getPreferredSize(JComponent c) {
      return applyMinimumWidth(c, super.getPreferredSize(c), this.minimumWidth);
   }

   public Dimension getMinimumSize(JComponent c) {
      return applyMinimumWidth(c, super.getMinimumSize(c), this.minimumWidth);
   }

   static Dimension applyMinimumWidth(JComponent c, Dimension size, int minimumWidth) {
      if (c instanceof JTextField && ((JTextField)c).getColumns() > 0) {
         return size;
      } else {
         Container parent = c.getParent();
         if (!(parent instanceof JComboBox) && !(parent instanceof JSpinner) && (parent == null || !(parent.getParent() instanceof JSpinner))) {
            minimumWidth = FlatUIUtils.minimumWidth(c, minimumWidth);
            float focusWidth = FlatUIUtils.getBorderFocusWidth(c);
            size.width = Math.max(size.width, UIScale.scale(minimumWidth) + Math.round(focusWidth * 2.0F));
            return size;
         } else {
            return size;
         }
      }
   }
}
