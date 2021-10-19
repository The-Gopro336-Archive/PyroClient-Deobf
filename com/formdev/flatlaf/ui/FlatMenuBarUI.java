package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.SystemInfo;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class FlatMenuBarUI extends BasicMenuBarUI {
   public static ComponentUI createUI(JComponent c) {
      return new FlatMenuBarUI();
   }

   protected void installKeyboardActions() {
      super.installKeyboardActions();
      ActionMap map = SwingUtilities.getUIActionMap(this.menuBar);
      if (map == null) {
         map = new ActionMapUIResource();
         SwingUtilities.replaceUIActionMap(this.menuBar, (ActionMap)map);
      }

      ((ActionMap)map).put("takeFocus", new FlatMenuBarUI.TakeFocus());
   }

   private static class TakeFocus extends AbstractAction {
      private TakeFocus() {
      }

      public void actionPerformed(ActionEvent e) {
         JMenuBar menuBar = (JMenuBar)e.getSource();
         JMenu menu = menuBar.getMenu(0);
         if (menu != null) {
            MenuSelectionManager.defaultManager().setSelectedPath(SystemInfo.IS_WINDOWS ? new MenuElement[]{menuBar, menu} : new MenuElement[]{menuBar, menu, menu.getPopupMenu()});
            FlatLaf.showMnemonics(menuBar);
         }

      }

      // $FF: synthetic method
      TakeFocus(Object x0) {
         this();
      }
   }
}
