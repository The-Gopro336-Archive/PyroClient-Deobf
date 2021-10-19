package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.HiDPIUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.text.Caret;
import javax.swing.text.JTextComponent;

public class FlatPasswordFieldUI extends BasicPasswordFieldUI {
   protected int minimumWidth;
   protected boolean isIntelliJTheme;
   protected Color placeholderForeground;
   protected Icon capsLockIcon;
   private FocusListener focusListener;
   private KeyListener capsLockListener;

   public static ComponentUI createUI(JComponent c) {
      return new FlatPasswordFieldUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      String prefix = this.getPropertyPrefix();
      this.minimumWidth = UIManager.getInt("Component.minimumWidth");
      this.isIntelliJTheme = UIManager.getBoolean("Component.isIntelliJTheme");
      this.placeholderForeground = UIManager.getColor(prefix + ".placeholderForeground");
      this.capsLockIcon = UIManager.getIcon("PasswordField.capsLockIcon");
      LookAndFeel.installProperty(this.getComponent(), "opaque", false);
      MigLayoutVisualPadding.install(this.getComponent());
   }

   protected void uninstallDefaults() {
      super.uninstallDefaults();
      this.placeholderForeground = null;
      this.capsLockIcon = null;
      MigLayoutVisualPadding.uninstall(this.getComponent());
   }

   protected void installListeners() {
      super.installListeners();
      this.focusListener = new FlatUIUtils.RepaintFocusListener(this.getComponent());
      this.capsLockListener = new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            this.repaint(e);
         }

         public void keyReleased(KeyEvent e) {
            this.repaint(e);
         }

         private void repaint(KeyEvent e) {
            if (e.getKeyCode() == 20) {
               e.getComponent().repaint();
            }

         }
      };
      this.getComponent().addFocusListener(this.focusListener);
      this.getComponent().addKeyListener(this.capsLockListener);
   }

   protected void uninstallListeners() {
      super.uninstallListeners();
      this.getComponent().removeFocusListener(this.focusListener);
      this.getComponent().removeKeyListener(this.capsLockListener);
      this.focusListener = null;
      this.capsLockListener = null;
   }

   protected Caret createCaret() {
      return new FlatCaret(UIManager.getString("TextComponent.selectAllOnFocusPolicy"));
   }

   protected void propertyChange(PropertyChangeEvent e) {
      super.propertyChange(e);
      FlatTextFieldUI.propertyChange(this.getComponent(), e);
   }

   protected void paintSafely(Graphics g) {
      FlatTextFieldUI.paintBackground(g, this.getComponent(), this.isIntelliJTheme);
      FlatTextFieldUI.paintPlaceholder(g, this.getComponent(), this.placeholderForeground);
      this.paintCapsLock(g);
      super.paintSafely(HiDPIUtils.createGraphicsTextYCorrection((Graphics2D)g));
   }

   protected void paintCapsLock(Graphics g) {
      JTextComponent c = this.getComponent();
      if (FlatUIUtils.isPermanentFocusOwner(c) && Toolkit.getDefaultToolkit().getLockingKeyState(20)) {
         int y = (c.getHeight() - this.capsLockIcon.getIconHeight()) / 2;
         int x = c.getWidth() - this.capsLockIcon.getIconWidth() - y;
         this.capsLockIcon.paintIcon(c, g, x, y);
      }
   }

   protected void paintBackground(Graphics g) {
   }

   public Dimension getPreferredSize(JComponent c) {
      return FlatTextFieldUI.applyMinimumWidth(c, super.getPreferredSize(c), this.minimumWidth);
   }

   public Dimension getMinimumSize(JComponent c) {
      return FlatTextFieldUI.applyMinimumWidth(c, super.getMinimumSize(c), this.minimumWidth);
   }
}
