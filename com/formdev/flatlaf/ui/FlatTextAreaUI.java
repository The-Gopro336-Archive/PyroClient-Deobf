package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.HiDPIUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTextAreaUI;
import javax.swing.text.JTextComponent;

public class FlatTextAreaUI extends BasicTextAreaUI {
   protected int minimumWidth;
   protected boolean isIntelliJTheme;
   protected Color disabledBackground;
   protected Color inactiveBackground;

   public static ComponentUI createUI(JComponent c) {
      return new FlatTextAreaUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      this.minimumWidth = UIManager.getInt("Component.minimumWidth");
      this.isIntelliJTheme = UIManager.getBoolean("Component.isIntelliJTheme");
      this.disabledBackground = UIManager.getColor("TextArea.disabledBackground");
      this.inactiveBackground = UIManager.getColor("TextArea.inactiveBackground");
   }

   protected void uninstallDefaults() {
      super.uninstallDefaults();
      this.disabledBackground = null;
      this.inactiveBackground = null;
   }

   protected void propertyChange(PropertyChangeEvent e) {
      super.propertyChange(e);
      FlatEditorPaneUI.propertyChange(this.getComponent(), e);
   }

   protected void paintSafely(Graphics g) {
      super.paintSafely(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g));
   }

   protected void paintBackground(Graphics g) {
      JTextComponent c = this.getComponent();
      Color background = c.getBackground();
      g.setColor(!(background instanceof UIResource) ? background : (this.isIntelliJTheme && (!c.isEnabled() || !c.isEditable()) ? FlatUIUtils.getParentBackground(c) : (!c.isEnabled() ? this.disabledBackground : (!c.isEditable() ? this.inactiveBackground : background))));
      g.fillRect(0, 0, c.getWidth(), c.getHeight());
   }

   public Dimension getPreferredSize(JComponent c) {
      return this.applyMinimumWidth(c, super.getPreferredSize(c));
   }

   public Dimension getMinimumSize(JComponent c) {
      return this.applyMinimumWidth(c, super.getMinimumSize(c));
   }

   private Dimension applyMinimumWidth(JComponent c, Dimension size) {
      return c instanceof JTextArea && ((JTextArea)c).getColumns() > 0 ? size : FlatEditorPaneUI.applyMinimumWidth(c, size, this.minimumWidth);
   }
}
