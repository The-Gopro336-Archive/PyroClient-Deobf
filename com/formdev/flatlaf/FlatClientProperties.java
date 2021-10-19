package com.formdev.flatlaf;

import java.awt.Color;
import java.util.Objects;
import javax.swing.JComponent;

public interface FlatClientProperties {
   String BUTTON_TYPE = "JButton.buttonType";
   String BUTTON_TYPE_SQUARE = "square";
   String BUTTON_TYPE_ROUND_RECT = "roundRect";
   String BUTTON_TYPE_TAB = "tab";
   String BUTTON_TYPE_HELP = "help";
   String BUTTON_TYPE_TOOLBAR_BUTTON = "toolBarButton";
   String SELECTED_STATE = "JButton.selectedState";
   String SELECTED_STATE_INDETERMINATE = "indeterminate";
   String SQUARE_SIZE = "JButton.squareSize";
   String MINIMUM_WIDTH = "JComponent.minimumWidth";
   String MINIMUM_HEIGHT = "JComponent.minimumHeight";
   String OUTLINE = "JComponent.outline";
   String OUTLINE_ERROR = "error";
   String OUTLINE_WARNING = "warning";
   String COMPONENT_ROUND_RECT = "JComponent.roundRect";
   String POPUP_DROP_SHADOW_PAINTED = "Popup.dropShadowPainted";
   String PROGRESS_BAR_LARGE_HEIGHT = "JProgressBar.largeHeight";
   String PROGRESS_BAR_SQUARE = "JProgressBar.square";
   String MENU_BAR_EMBEDDED = "JRootPane.menuBarEmbedded";
   String SCROLL_BAR_SHOW_BUTTONS = "JScrollBar.showButtons";
   String TABBED_PANE_SHOW_TAB_SEPARATORS = "JTabbedPane.showTabSeparators";
   String TABBED_PANE_HAS_FULL_BORDER = "JTabbedPane.hasFullBorder";
   String TABBED_PANE_TAB_HEIGHT = "JTabbedPane.tabHeight";
   String SELECT_ALL_ON_FOCUS_POLICY = "JTextField.selectAllOnFocusPolicy";
   String SELECT_ALL_ON_FOCUS_POLICY_NEVER = "never";
   String SELECT_ALL_ON_FOCUS_POLICY_ONCE = "once";
   String SELECT_ALL_ON_FOCUS_POLICY_ALWAYS = "always";
   String PLACEHOLDER_TEXT = "JTextField.placeholderText";
   String TAB_BUTTON_UNDERLINE_HEIGHT = "JToggleButton.tab.underlineHeight";
   String TAB_BUTTON_UNDERLINE_COLOR = "JToggleButton.tab.underlineColor";
   String TAB_BUTTON_SELECTED_BACKGROUND = "JToggleButton.tab.selectedBackground";

   static boolean clientPropertyEquals(JComponent c, String key, Object value) {
      return Objects.equals(c.getClientProperty(key), value);
   }

   static boolean clientPropertyBoolean(JComponent c, String key, boolean defaultValue) {
      Object value = c.getClientProperty(key);
      return value instanceof Boolean ? (Boolean)value : defaultValue;
   }

   static int clientPropertyInt(JComponent c, String key, int defaultValue) {
      Object value = c.getClientProperty(key);
      return value instanceof Integer ? (Integer)value : defaultValue;
   }

   static Color clientPropertyColor(JComponent c, String key, Color defaultValue) {
      Object value = c.getClientProperty(key);
      return value instanceof Color ? (Color)value : defaultValue;
   }

   static int clientPropertyChoice(JComponent c, String key, String... choices) {
      Object value = c.getClientProperty(key);

      for(int i = 0; i < choices.length; ++i) {
         if (choices[i].equals(value)) {
            return i;
         }
      }

      return -1;
   }
}
