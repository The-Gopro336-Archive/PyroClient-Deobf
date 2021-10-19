package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.DerivedColor;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.Paint;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;
import javax.swing.text.JTextComponent;

public class FlatBorder extends MarginBorder {
   protected final int focusWidth = UIManager.getInt("Component.focusWidth");
   protected final float innerFocusWidth = FlatUIUtils.getUIFloat("Component.innerFocusWidth", 0.0F);
   protected final float innerOutlineWidth = FlatUIUtils.getUIFloat("Component.innerOutlineWidth", 0.0F);
   protected final Color focusColor = UIManager.getColor("Component.focusColor");
   protected final Color borderColor = UIManager.getColor("Component.borderColor");
   protected final Color disabledBorderColor = UIManager.getColor("Component.disabledBorderColor");
   protected final Color focusedBorderColor = UIManager.getColor("Component.focusedBorderColor");
   protected final Color errorBorderColor = UIManager.getColor("Component.error.borderColor");
   protected final Color errorFocusedBorderColor = UIManager.getColor("Component.error.focusedBorderColor");
   protected final Color warningBorderColor = UIManager.getColor("Component.warning.borderColor");
   protected final Color warningFocusedBorderColor = UIManager.getColor("Component.warning.focusedBorderColor");
   protected final Color customBorderColor = UIManager.getColor("Component.custom.borderColor");

   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      Graphics2D g2 = (Graphics2D)g.create();

      try {
         FlatUIUtils.setRenderingHints(g2);
         boolean isCellEditor = this.isTableCellEditor(c);
         float focusWidth = isCellEditor ? 0.0F : UIScale.scale((float)this.getFocusWidth(c));
         float borderWidth = UIScale.scale((float)this.getBorderWidth(c));
         float arc = isCellEditor ? 0.0F : UIScale.scale((float)this.getArc(c));
         Color outlineColor = this.getOutlineColor(c);
         if (outlineColor != null || this.isFocused(c)) {
            float innerFocusWidth = !(c instanceof JScrollPane) ? (outlineColor != null ? this.innerOutlineWidth : this.innerFocusWidth) : 0.0F;
            g2.setColor(outlineColor != null ? outlineColor : this.getFocusColor(c));
            FlatUIUtils.paintComponentOuterBorder(g2, x, y, width, height, focusWidth, UIScale.scale((float)this.getLineWidth(c)) + UIScale.scale(innerFocusWidth), arc);
         }

         g2.setPaint((Paint)(outlineColor != null ? outlineColor : this.getBorderColor(c)));
         FlatUIUtils.paintComponentBorder(g2, x, y, width, height, focusWidth, borderWidth, arc);
      } finally {
         g2.dispose();
      }

   }

   protected Color getOutlineColor(Component c) {
      if (!(c instanceof JComponent)) {
         return null;
      } else {
         Object outline = ((JComponent)c).getClientProperty("JComponent.outline");
         if (outline instanceof String) {
            String var3 = (String)outline;
            byte var4 = -1;
            switch(var3.hashCode()) {
            case 96784904:
               if (var3.equals("error")) {
                  var4 = 0;
               }
               break;
            case 1124446108:
               if (var3.equals("warning")) {
                  var4 = 1;
               }
            }

            switch(var4) {
            case 0:
               return this.isFocused(c) ? this.errorFocusedBorderColor : this.errorBorderColor;
            case 1:
               return this.isFocused(c) ? this.warningFocusedBorderColor : this.warningBorderColor;
            }
         } else {
            if (outline instanceof Color) {
               Color color = (Color)outline;
               if (!this.isFocused(c) && this.customBorderColor instanceof DerivedColor) {
                  color = ((DerivedColor)this.customBorderColor).derive(color);
               }

               return color;
            }

            if (outline instanceof Color[] && ((Color[])outline).length >= 2) {
               return ((Color[])outline)[this.isFocused(c) ? 0 : 1];
            }
         }

         return null;
      }
   }

   protected Color getFocusColor(Component c) {
      return this.focusColor;
   }

   protected Paint getBorderColor(Component c) {
      return this.isEnabled(c) ? (this.isFocused(c) ? this.focusedBorderColor : this.borderColor) : this.disabledBorderColor;
   }

   protected boolean isEnabled(Component c) {
      if (c instanceof JScrollPane) {
         JViewport viewport = ((JScrollPane)c).getViewport();
         Component view = viewport != null ? viewport.getView() : null;
         if (view != null && !this.isEnabled(view)) {
            return false;
         }
      }

      return c.isEnabled() && (!(c instanceof JTextComponent) || ((JTextComponent)c).isEditable());
   }

   protected boolean isFocused(Component c) {
      if (c instanceof JScrollPane) {
         JViewport viewport = ((JScrollPane)c).getViewport();
         Component view = viewport != null ? viewport.getView() : null;
         if (view != null) {
            if (FlatUIUtils.isPermanentFocusOwner(view)) {
               return true;
            }

            if (view instanceof JTable && ((JTable)view).isEditing() || view instanceof JTree && ((JTree)view).isEditing()) {
               Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
               if (focusOwner != null) {
                  return SwingUtilities.isDescendingFrom(focusOwner, view);
               }
            }
         }

         return false;
      } else if (c instanceof JComboBox && ((JComboBox)c).isEditable()) {
         Component editorComponent = ((JComboBox)c).getEditor().getEditorComponent();
         return editorComponent != null ? FlatUIUtils.isPermanentFocusOwner(editorComponent) : false;
      } else if (c instanceof JSpinner) {
         if (FlatUIUtils.isPermanentFocusOwner(c)) {
            return true;
         } else {
            JComponent editor = ((JSpinner)c).getEditor();
            if (editor instanceof DefaultEditor) {
               JTextField textField = ((DefaultEditor)editor).getTextField();
               if (textField != null) {
                  return FlatUIUtils.isPermanentFocusOwner(textField);
               }
            }

            return false;
         }
      } else {
         return FlatUIUtils.isPermanentFocusOwner(c);
      }
   }

   protected boolean isTableCellEditor(Component c) {
      return FlatUIUtils.isTableCellEditor(c);
   }

   public Insets getBorderInsets(Component c, Insets insets) {
      boolean isCellEditor = this.isTableCellEditor(c);
      float focusWidth = isCellEditor ? 0.0F : UIScale.scale((float)this.getFocusWidth(c));
      float ow = focusWidth + UIScale.scale((float)this.getLineWidth(c));
      insets = super.getBorderInsets(c, insets);
      insets.top = Math.round(UIScale.scale((float)insets.top) + ow);
      insets.left = Math.round(UIScale.scale((float)insets.left) + ow);
      insets.bottom = Math.round(UIScale.scale((float)insets.bottom) + ow);
      insets.right = Math.round(UIScale.scale((float)insets.right) + ow);
      return insets;
   }

   protected int getFocusWidth(Component c) {
      return this.focusWidth;
   }

   protected int getLineWidth(Component c) {
      return 1;
   }

   protected int getBorderWidth(Component c) {
      return this.getLineWidth(c);
   }

   protected int getArc(Component c) {
      return 0;
   }
}
