package com.formdev.flatlaf.ui;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FlatTableCellBorder extends FlatLineBorder {
   final boolean showCellFocusIndicator = UIManager.getBoolean("Table.showCellFocusIndicator");

   protected FlatTableCellBorder() {
      super(UIManager.getInsets("Table.cellMargins"), UIManager.getColor("Table.cellFocusColor"));
   }

   public static class Selected extends FlatTableCellBorder {
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         if (!this.showCellFocusIndicator) {
            JTable table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c);
            if (table != null && !this.isSelectionEditable(table)) {
               return;
            }
         }

         super.paintBorder(c, g, x, y, width, height);
      }

      protected boolean isSelectionEditable(JTable table) {
         int rowCount;
         int[] selectedColumns;
         int[] var4;
         int var5;
         int var6;
         int selectedColumn;
         int row;
         if (table.getRowSelectionAllowed()) {
            rowCount = table.getColumnCount();
            selectedColumns = table.getSelectedRows();
            var4 = selectedColumns;
            var5 = selectedColumns.length;

            for(var6 = 0; var6 < var5; ++var6) {
               selectedColumn = var4[var6];

               for(row = 0; row < rowCount; ++row) {
                  if (table.isCellEditable(selectedColumn, row)) {
                     return true;
                  }
               }
            }
         }

         if (table.getColumnSelectionAllowed()) {
            rowCount = table.getRowCount();
            selectedColumns = table.getSelectedColumns();
            var4 = selectedColumns;
            var5 = selectedColumns.length;

            for(var6 = 0; var6 < var5; ++var6) {
               selectedColumn = var4[var6];

               for(row = 0; row < rowCount; ++row) {
                  if (table.isCellEditable(row, selectedColumn)) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public static class Focused extends FlatTableCellBorder {
   }

   public static class Default extends FlatTableCellBorder {
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      }
   }
}
