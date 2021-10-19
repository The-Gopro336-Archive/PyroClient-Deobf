package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class FlatSplitPaneUI extends BasicSplitPaneUI {
   protected String arrowType;
   private Boolean continuousLayout;
   private Color oneTouchArrowColor;
   private Color oneTouchHoverArrowColor;

   public static ComponentUI createUI(JComponent c) {
      return new FlatSplitPaneUI();
   }

   protected void installDefaults() {
      this.arrowType = UIManager.getString("Component.arrowType");
      this.oneTouchArrowColor = UIManager.getColor("SplitPaneDivider.oneTouchArrowColor");
      this.oneTouchHoverArrowColor = UIManager.getColor("SplitPaneDivider.oneTouchHoverArrowColor");
      super.installDefaults();
      this.continuousLayout = (Boolean)UIManager.get("SplitPane.continuousLayout");
   }

   public boolean isContinuousLayout() {
      return super.isContinuousLayout() || this.continuousLayout != null && Boolean.TRUE.equals(this.continuousLayout);
   }

   public BasicSplitPaneDivider createDefaultDivider() {
      return new FlatSplitPaneUI.FlatSplitPaneDivider(this);
   }

   protected class FlatSplitPaneDivider extends BasicSplitPaneDivider {
      protected FlatSplitPaneDivider(BasicSplitPaneUI ui) {
         super(ui);
      }

      public void setDividerSize(int newSize) {
         super.setDividerSize(UIScale.scale(newSize));
      }

      protected JButton createLeftOneTouchButton() {
         return new FlatSplitPaneUI.FlatSplitPaneDivider.FlatOneTouchButton(true);
      }

      protected JButton createRightOneTouchButton() {
         return new FlatSplitPaneUI.FlatSplitPaneDivider.FlatOneTouchButton(false);
      }

      private class FlatOneTouchButton extends FlatArrowButton {
         private final boolean left;

         public FlatOneTouchButton(boolean left) {
            super(1, FlatSplitPaneUI.this.arrowType, FlatSplitPaneUI.this.oneTouchArrowColor, (Color)null, FlatSplitPaneUI.this.oneTouchHoverArrowColor, (Color)null);
            this.setCursor(Cursor.getPredefinedCursor(0));
            this.left = left;
         }

         public int getDirection() {
            return FlatSplitPaneDivider.this.orientation == 0 ? (this.left ? 1 : 5) : (this.left ? 7 : 3);
         }
      }
   }
}
