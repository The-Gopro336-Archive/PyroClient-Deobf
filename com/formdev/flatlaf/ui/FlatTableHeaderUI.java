package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D.Float;
import java.util.Objects;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FlatTableHeaderUI extends BasicTableHeaderUI {
   protected Color separatorColor;
   protected Color bottomSeparatorColor;
   protected int height;
   protected int sortIconPosition;

   public static ComponentUI createUI(JComponent c) {
      return new FlatTableHeaderUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      this.separatorColor = UIManager.getColor("TableHeader.separatorColor");
      this.bottomSeparatorColor = UIManager.getColor("TableHeader.bottomSeparatorColor");
      this.height = UIManager.getInt("TableHeader.height");
      String var1 = Objects.toString(UIManager.getString("TableHeader.sortIconPosition"), "right");
      byte var2 = -1;
      switch(var1.hashCode()) {
      case -1383228885:
         if (var1.equals("bottom")) {
            var2 = 4;
         }
         break;
      case 115029:
         if (var1.equals("top")) {
            var2 = 3;
         }
         break;
      case 3317767:
         if (var1.equals("left")) {
            var2 = 2;
         }
         break;
      case 108511772:
         if (var1.equals("right")) {
            var2 = 1;
         }
      }

      switch(var2) {
      case 1:
      default:
         this.sortIconPosition = 4;
         break;
      case 2:
         this.sortIconPosition = 2;
         break;
      case 3:
         this.sortIconPosition = 1;
         break;
      case 4:
         this.sortIconPosition = 3;
      }

   }

   protected void uninstallDefaults() {
      super.uninstallDefaults();
      this.separatorColor = null;
      this.bottomSeparatorColor = null;
   }

   public void paint(Graphics g, JComponent c) {
      TableCellRenderer defaultRenderer = this.header.getDefaultRenderer();
      boolean paintBorders = this.isSystemDefaultRenderer(defaultRenderer);
      if (!paintBorders && this.header.getColumnModel().getColumnCount() > 0) {
         Component rendererComponent = defaultRenderer.getTableCellRendererComponent(this.header.getTable(), "", false, false, -1, 0);
         paintBorders = this.isSystemDefaultRenderer(rendererComponent);
      }

      if (paintBorders) {
         this.paintColumnBorders(g, c);
      }

      FlatTableHeaderUI.FlatTableCellHeaderRenderer sortIconRenderer = null;
      if (this.sortIconPosition != 4) {
         sortIconRenderer = new FlatTableHeaderUI.FlatTableCellHeaderRenderer(this.header.getDefaultRenderer());
         this.header.setDefaultRenderer(sortIconRenderer);
      }

      super.paint(g, c);
      if (sortIconRenderer != null) {
         sortIconRenderer.reset();
         this.header.setDefaultRenderer(sortIconRenderer.delegate);
      }

      if (paintBorders) {
         this.paintDraggedColumnBorders(g, c);
      }

   }

   private boolean isSystemDefaultRenderer(Object headerRenderer) {
      String rendererClassName = headerRenderer.getClass().getName();
      return rendererClassName.equals("sun.swing.table.DefaultTableCellHeaderRenderer") || rendererClassName.equals("sun.swing.FilePane$AlignableTableHeaderRenderer");
   }

   private void paintColumnBorders(Graphics g, JComponent c) {
      int width = c.getWidth();
      int height = c.getHeight();
      float lineWidth = UIScale.scale(1.0F);
      float topLineIndent = lineWidth;
      float bottomLineIndent = lineWidth * 3.0F;
      TableColumnModel columnModel = this.header.getColumnModel();
      int columnCount = columnModel.getColumnCount();
      Graphics2D g2 = (Graphics2D)g.create();

      try {
         FlatUIUtils.setRenderingHints(g2);
         g2.setColor(this.bottomSeparatorColor);
         g2.fill(new Float(0.0F, (float)height - lineWidth, (float)width, lineWidth));
         g2.setColor(this.separatorColor);
         int sepCount = columnCount;
         if (this.header.getTable().getAutoResizeMode() != 0 && !this.isVerticalScrollBarVisible()) {
            sepCount = columnCount - 1;
         }

         int x;
         int i;
         if (this.header.getComponentOrientation().isLeftToRight()) {
            x = 0;

            for(i = 0; i < sepCount; ++i) {
               x += columnModel.getColumn(i).getWidth();
               g2.fill(new Float((float)x - lineWidth, topLineIndent, lineWidth, (float)height - bottomLineIndent));
            }
         } else {
            x = width;

            for(i = 0; i < sepCount; ++i) {
               x -= columnModel.getColumn(i).getWidth();
               g2.fill(new Float((float)x - (i < sepCount - 1 ? lineWidth : 0.0F), topLineIndent, lineWidth, (float)height - bottomLineIndent));
            }
         }
      } finally {
         g2.dispose();
      }

   }

   private void paintDraggedColumnBorders(Graphics g, JComponent c) {
      TableColumn draggedColumn = this.header.getDraggedColumn();
      if (draggedColumn != null) {
         TableColumnModel columnModel = this.header.getColumnModel();
         int columnCount = columnModel.getColumnCount();
         int draggedColumnIndex = -1;

         for(int i = 0; i < columnCount; ++i) {
            if (columnModel.getColumn(i) == draggedColumn) {
               draggedColumnIndex = i;
               break;
            }
         }

         if (draggedColumnIndex >= 0) {
            float lineWidth = UIScale.scale(1.0F);
            float topLineIndent = lineWidth;
            float bottomLineIndent = lineWidth * 3.0F;
            Rectangle r = this.header.getHeaderRect(draggedColumnIndex);
            r.x += this.header.getDraggedDistance();
            Graphics2D g2 = (Graphics2D)g.create();

            try {
               FlatUIUtils.setRenderingHints(g2);
               g2.setColor(this.bottomSeparatorColor);
               g2.fill(new Float((float)r.x, (float)(r.y + r.height) - lineWidth, (float)r.width, lineWidth));
               g2.setColor(this.separatorColor);
               g2.fill(new Float((float)r.x, topLineIndent, lineWidth, (float)r.height - bottomLineIndent));
               g2.fill(new Float((float)(r.x + r.width) - lineWidth, (float)r.y + topLineIndent, lineWidth, (float)r.height - bottomLineIndent));
            } finally {
               g2.dispose();
            }

         }
      }
   }

   public Dimension getPreferredSize(JComponent c) {
      Dimension size = super.getPreferredSize(c);
      if (size.height > 0) {
         size.height = Math.max(size.height, UIScale.scale(this.height));
      }

      return size;
   }

   private boolean isVerticalScrollBarVisible() {
      JScrollPane scrollPane = this.getScrollPane();
      return scrollPane != null && scrollPane.getVerticalScrollBar() != null ? scrollPane.getVerticalScrollBar().isVisible() : false;
   }

   private JScrollPane getScrollPane() {
      Container parent = this.header.getParent();
      if (parent == null) {
         return null;
      } else {
         parent = parent.getParent();
         return parent instanceof JScrollPane ? (JScrollPane)parent : null;
      }
   }

   private class FlatTableCellHeaderRenderer implements TableCellRenderer, Border, UIResource {
      private final TableCellRenderer delegate;
      // $FF: renamed from: l javax.swing.JLabel
      private JLabel field_2616;
      private int oldHorizontalTextPosition = -1;
      private Border origBorder;
      private Icon sortIcon;

      FlatTableCellHeaderRenderer(TableCellRenderer delegate) {
         this.delegate = delegate;
      }

      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         Component c = this.delegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
         if (!(c instanceof JLabel)) {
            return c;
         } else {
            this.field_2616 = (JLabel)c;
            if (FlatTableHeaderUI.this.sortIconPosition == 2) {
               if (this.oldHorizontalTextPosition < 0) {
                  this.oldHorizontalTextPosition = this.field_2616.getHorizontalTextPosition();
               }

               this.field_2616.setHorizontalTextPosition(4);
            } else {
               this.sortIcon = this.field_2616.getIcon();
               this.origBorder = this.field_2616.getBorder();
               this.field_2616.setIcon((Icon)null);
               this.field_2616.setBorder(this);
            }

            return this.field_2616;
         }
      }

      void reset() {
         if (this.field_2616 != null && FlatTableHeaderUI.this.sortIconPosition == 2 && this.oldHorizontalTextPosition >= 0) {
            this.field_2616.setHorizontalTextPosition(this.oldHorizontalTextPosition);
         }

      }

      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         if (this.origBorder != null) {
            this.origBorder.paintBorder(c, g, x, y, width, height);
         }

         if (this.sortIcon != null) {
            int xi = x + (width - this.sortIcon.getIconWidth()) / 2;
            int yi = FlatTableHeaderUI.this.sortIconPosition == 1 ? y + UIScale.scale(1) : y + height - this.sortIcon.getIconHeight() - 1 - (int)(1.0F * UIScale.getUserScaleFactor());
            this.sortIcon.paintIcon(c, g, xi, yi);
         }

      }

      public Insets getBorderInsets(Component c) {
         return this.origBorder != null ? this.origBorder.getBorderInsets(c) : new Insets(0, 0, 0, 0);
      }

      public boolean isBorderOpaque() {
         return this.origBorder != null ? this.origBorder.isBorderOpaque() : false;
      }
   }
}
