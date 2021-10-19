package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.CellRendererPane;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTree.DropLocation;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.plaf.basic.BasicTreeUI.MouseHandler;
import javax.swing.plaf.basic.BasicTreeUI.PropertyChangeHandler;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class FlatTreeUI extends BasicTreeUI {
   protected Color selectionBackground;
   protected Color selectionForeground;
   protected Color selectionInactiveBackground;
   protected Color selectionInactiveForeground;
   protected Color selectionBorderColor;
   protected boolean wideSelection;
   protected boolean showCellFocusIndicator;

   public static ComponentUI createUI(JComponent c) {
      return new FlatTreeUI();
   }

   protected void installDefaults() {
      super.installDefaults();
      LookAndFeel.installBorder(this.tree, "Tree.border");
      this.selectionBackground = UIManager.getColor("Tree.selectionBackground");
      this.selectionForeground = UIManager.getColor("Tree.selectionForeground");
      this.selectionInactiveBackground = UIManager.getColor("Tree.selectionInactiveBackground");
      this.selectionInactiveForeground = UIManager.getColor("Tree.selectionInactiveForeground");
      this.selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
      this.wideSelection = UIManager.getBoolean("Tree.wideSelection");
      this.showCellFocusIndicator = UIManager.getBoolean("Tree.showCellFocusIndicator");
      int rowHeight = FlatUIUtils.getUIInt("Tree.rowHeight", 16);
      if (rowHeight > 0) {
         LookAndFeel.installProperty(this.tree, "rowHeight", UIScale.scale(rowHeight));
      }

      this.setLeftChildIndent(UIScale.scale(this.getLeftChildIndent()));
      this.setRightChildIndent(UIScale.scale(this.getRightChildIndent()));
   }

   protected void uninstallDefaults() {
      super.uninstallDefaults();
      LookAndFeel.uninstallBorder(this.tree);
      this.selectionBackground = null;
      this.selectionForeground = null;
      this.selectionInactiveBackground = null;
      this.selectionInactiveForeground = null;
      this.selectionBorderColor = null;
   }

   protected MouseListener createMouseListener() {
      return (MouseListener)(!this.wideSelection ? super.createMouseListener() : new MouseHandler() {
         public void mousePressed(MouseEvent e) {
            super.mousePressed(this.handleWideMouseEvent(e));
         }

         public void mouseReleased(MouseEvent e) {
            super.mouseReleased(this.handleWideMouseEvent(e));
         }

         public void mouseDragged(MouseEvent e) {
            super.mouseDragged(this.handleWideMouseEvent(e));
         }

         private MouseEvent handleWideMouseEvent(MouseEvent e) {
            if (FlatTreeUI.this.tree.isEnabled() && SwingUtilities.isLeftMouseButton(e) && !e.isConsumed()) {
               int x = e.getX();
               int y = e.getY();
               TreePath path = FlatTreeUI.this.getClosestPathForLocation(FlatTreeUI.this.tree, x, y);
               if (path != null && !FlatTreeUI.this.isLocationInExpandControl(path, x, y)) {
                  Rectangle bounds = FlatTreeUI.this.getPathBounds(FlatTreeUI.this.tree, path);
                  if (bounds != null && y >= bounds.y && y < bounds.y + bounds.height) {
                     int newX = Math.max(bounds.x, Math.min(x, bounds.x + bounds.width - 1));
                     return newX == x ? e : new MouseEvent(e.getComponent(), e.getID(), e.getWhen(), e.getModifiers() | e.getModifiersEx(), newX, e.getY(), e.getClickCount(), e.isPopupTrigger(), e.getButton());
                  } else {
                     return e;
                  }
               } else {
                  return e;
               }
            } else {
               return e;
            }
         }
      });
   }

   protected PropertyChangeListener createPropertyChangeListener() {
      return (PropertyChangeListener)(!this.wideSelection ? super.createPropertyChangeListener() : new PropertyChangeHandler() {
         public void propertyChange(PropertyChangeEvent e) {
            super.propertyChange(e);
            if (e.getSource() == FlatTreeUI.this.tree && e.getPropertyName() == "dropLocation") {
               DropLocation oldValue = (DropLocation)e.getOldValue();
               this.repaintWideDropLocation(oldValue);
               this.repaintWideDropLocation(FlatTreeUI.this.tree.getDropLocation());
            }

         }

         private void repaintWideDropLocation(DropLocation loc) {
            if (loc != null && !FlatTreeUI.this.isDropLine(loc)) {
               Rectangle r = FlatTreeUI.this.tree.getPathBounds(loc.getPath());
               if (r != null) {
                  FlatTreeUI.this.tree.repaint(0, r.y, FlatTreeUI.this.tree.getWidth(), r.height);
               }

            }
         }
      });
   }

   protected void paintRow(Graphics g, Rectangle clipBounds, Insets insets, Rectangle bounds, TreePath path, int row, boolean isExpanded, boolean hasBeenExpanded, boolean isLeaf) {
      boolean isEditing = this.editingComponent != null && this.editingRow == row;
      boolean hasFocus = FlatUIUtils.isPermanentFocusOwner(this.tree);
      boolean cellHasFocus = hasFocus && row == this.getLeadSelectionRow();
      boolean isSelected = this.tree.isRowSelected(row);
      boolean isDropRow = this.isDropRow(row);
      if (!hasFocus && isSelected && this.tree.getParent() instanceof CellRendererPane) {
         hasFocus = FlatUIUtils.isPermanentFocusOwner(this.tree.getParent().getParent());
      }

      if (this.wideSelection && (isSelected || isDropRow)) {
         g.setColor(isDropRow ? UIManager.getColor("Tree.dropCellBackground") : (hasFocus ? this.selectionBackground : this.selectionInactiveBackground));
         g.fillRect(0, bounds.y, this.tree.getWidth(), bounds.height);
         if (this.shouldPaintExpandControl(path, row, isExpanded, hasBeenExpanded, isLeaf)) {
            this.paintExpandControl(g, clipBounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
         }
      }

      if (!isEditing) {
         Component rendererComponent = this.currentCellRenderer.getTreeCellRendererComponent(this.tree, path.getLastPathComponent(), isSelected, isExpanded, isLeaf, row, cellHasFocus);
         Color oldBackgroundSelectionColor = null;
         if (isSelected && !hasFocus && !isDropRow) {
            if (rendererComponent instanceof DefaultTreeCellRenderer) {
               DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)rendererComponent;
               if (renderer.getBackgroundSelectionColor() == this.selectionBackground) {
                  oldBackgroundSelectionColor = renderer.getBackgroundSelectionColor();
                  renderer.setBackgroundSelectionColor(this.selectionInactiveBackground);
               }
            } else if (rendererComponent.getBackground() == this.selectionBackground) {
               rendererComponent.setBackground(this.selectionInactiveBackground);
            }

            if (rendererComponent.getForeground() == this.selectionForeground) {
               rendererComponent.setForeground(this.selectionInactiveForeground);
            }
         }

         Color oldBorderSelectionColor = null;
         if (isSelected && hasFocus && (!this.showCellFocusIndicator || this.tree.getMinSelectionRow() == this.tree.getMaxSelectionRow()) && rendererComponent instanceof DefaultTreeCellRenderer) {
            DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)rendererComponent;
            if (renderer.getBorderSelectionColor() == this.selectionBorderColor) {
               oldBorderSelectionColor = renderer.getBorderSelectionColor();
               renderer.setBorderSelectionColor((Color)null);
            }
         }

         this.rendererPane.paintComponent(g, rendererComponent, this.tree, bounds.x, bounds.y, bounds.width, bounds.height, true);
         if (oldBackgroundSelectionColor != null) {
            ((DefaultTreeCellRenderer)rendererComponent).setBackgroundSelectionColor(oldBackgroundSelectionColor);
         }

         if (oldBorderSelectionColor != null) {
            ((DefaultTreeCellRenderer)rendererComponent).setBorderSelectionColor(oldBorderSelectionColor);
         }

      }
   }

   private boolean isDropRow(int row) {
      DropLocation dropLocation = this.tree.getDropLocation();
      return dropLocation != null && dropLocation.getChildIndex() == -1 && this.tree.getRowForPath(dropLocation.getPath()) == row;
   }

   protected Rectangle getDropLineRect(DropLocation loc) {
      Rectangle r = super.getDropLineRect(loc);
      return this.wideSelection ? new Rectangle(0, r.y, this.tree.getWidth(), r.height) : r;
   }
}
