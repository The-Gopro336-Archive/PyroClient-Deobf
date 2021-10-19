package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.plaf.basic.BasicTableUI.FocusHandler;
import javax.swing.table.TableCellRenderer;

public class FlatTableUI extends BasicTableUI {
   protected boolean showHorizontalLines;
   protected boolean showVerticalLines;
   protected Dimension intercellSpacing;
   protected Color selectionBackground;
   protected Color selectionForeground;
   protected Color selectionInactiveBackground;
   protected Color selectionInactiveForeground;
   private boolean oldShowHorizontalLines;
   private boolean oldShowVerticalLines;
   private Dimension oldIntercellSpacing;

   public static ComponentUI createUI(JComponent c) {
      return new FlatTableUI();
   }

   public void installUI(JComponent c) {
      super.installUI(c);
   }

   public void uninstallUI(JComponent c) {
      super.uninstallUI(c);
   }

   protected void installDefaults() {
      super.installDefaults();
      this.showHorizontalLines = UIManager.getBoolean("Table.showHorizontalLines");
      this.showVerticalLines = UIManager.getBoolean("Table.showVerticalLines");
      this.intercellSpacing = UIManager.getDimension("Table.intercellSpacing");
      this.selectionBackground = UIManager.getColor("Table.selectionBackground");
      this.selectionForeground = UIManager.getColor("Table.selectionForeground");
      this.selectionInactiveBackground = UIManager.getColor("Table.selectionInactiveBackground");
      this.selectionInactiveForeground = UIManager.getColor("Table.selectionInactiveForeground");
      this.toggleSelectionColors();
      int rowHeight = FlatUIUtils.getUIInt("Table.rowHeight", 16);
      if (rowHeight > 0) {
         LookAndFeel.installProperty(this.table, "rowHeight", UIScale.scale(rowHeight));
      }

      if (!this.showHorizontalLines) {
         this.oldShowHorizontalLines = this.table.getShowHorizontalLines();
         this.table.setShowHorizontalLines(false);
      }

      if (!this.showVerticalLines) {
         this.oldShowVerticalLines = this.table.getShowVerticalLines();
         this.table.setShowVerticalLines(false);
      }

      if (this.intercellSpacing != null) {
         this.oldIntercellSpacing = this.table.getIntercellSpacing();
         this.table.setIntercellSpacing(this.intercellSpacing);
      }

      TableCellRenderer booleanRenderer = this.table.getDefaultRenderer(Boolean.class);
      if (booleanRenderer instanceof JCheckBox) {
         ((JCheckBox)booleanRenderer).setOpaque(true);
      }

   }

   protected void uninstallDefaults() {
      super.uninstallDefaults();
      this.selectionBackground = null;
      this.selectionForeground = null;
      this.selectionInactiveBackground = null;
      this.selectionInactiveForeground = null;
      if (!this.showHorizontalLines && this.oldShowHorizontalLines && !this.table.getShowHorizontalLines()) {
         this.table.setShowHorizontalLines(true);
      }

      if (!this.showVerticalLines && this.oldShowVerticalLines && !this.table.getShowVerticalLines()) {
         this.table.setShowVerticalLines(true);
      }

      if (this.intercellSpacing != null && this.table.getIntercellSpacing().equals(this.intercellSpacing)) {
         this.table.setIntercellSpacing(this.oldIntercellSpacing);
      }

   }

   protected FocusListener createFocusListener() {
      return new FocusHandler() {
         public void focusGained(FocusEvent e) {
            super.focusGained(e);
            FlatTableUI.this.toggleSelectionColors();
         }

         public void focusLost(FocusEvent e) {
            super.focusLost(e);
            EventQueue.invokeLater(() -> {
               FlatTableUI.this.toggleSelectionColors();
            });
         }
      };
   }

   private void toggleSelectionColors() {
      if (FlatUIUtils.isPermanentFocusOwner(this.table)) {
         if (this.table.getSelectionBackground() == this.selectionInactiveBackground) {
            this.table.setSelectionBackground(this.selectionBackground);
         }

         if (this.table.getSelectionForeground() == this.selectionInactiveForeground) {
            this.table.setSelectionForeground(this.selectionForeground);
         }
      } else {
         if (this.table.getSelectionBackground() == this.selectionBackground) {
            this.table.setSelectionBackground(this.selectionInactiveBackground);
         }

         if (this.table.getSelectionForeground() == this.selectionForeground) {
            this.table.setSelectionForeground(this.selectionInactiveForeground);
         }
      }

   }
}
