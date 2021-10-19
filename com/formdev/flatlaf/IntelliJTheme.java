package com.formdev.flatlaf;

import com.formdev.flatlaf.json.Json;
import com.formdev.flatlaf.json.ParseException;
import com.formdev.flatlaf.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.Level;
import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;

public class IntelliJTheme {
   public final String name;
   public final boolean dark;
   public final String author;
   private final Map colors;
   // $FF: renamed from: ui java.util.Map
   private final Map field_1659;
   private final Map icons;
   private Map namedColors = Collections.emptyMap();
   private static Map uiKeyMapping = new HashMap();
   private static Map uiKeyCopying = new HashMap();
   private static Map uiKeyInverseMapping = new HashMap();
   private static Map checkboxKeyMapping = new HashMap();
   private static Map checkboxDuplicateColors = new HashMap();

   public static boolean install(InputStream in) {
      try {
         return FlatLaf.install(createLaf(in));
      } catch (Exception var2) {
         FlatLaf.LOG.log(Level.SEVERE, "FlatLaf: Failed to load IntelliJ theme", var2);
         return false;
      }
   }

   public static FlatLaf createLaf(InputStream in) throws IOException {
      return createLaf(new IntelliJTheme(in));
   }

   public static FlatLaf createLaf(IntelliJTheme theme) {
      return new IntelliJTheme.ThemeLaf(theme);
   }

   public IntelliJTheme(InputStream in) throws IOException {
      Map json;
      try {
         InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);

         try {
            json = (Map)Json.parse(reader);
         } catch (Throwable var7) {
            try {
               reader.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }

            throw var7;
         }

         reader.close();
      } catch (ParseException var8) {
         throw new IOException(var8.getMessage(), var8);
      }

      this.name = (String)json.get("name");
      this.dark = Boolean.parseBoolean((String)json.get("dark"));
      this.author = (String)json.get("author");
      this.colors = (Map)json.get("colors");
      this.field_1659 = (Map)json.get("ui");
      this.icons = (Map)json.get("icons");
   }

   private void applyProperties(UIDefaults defaults) {
      if (this.field_1659 != null) {
         defaults.put("Component.isIntelliJTheme", true);
         defaults.put("Button.paintShadow", true);
         defaults.put("Button.shadowWidth", this.dark ? 2 : 1);
         Map themeSpecificDefaults = this.removeThemeSpecificDefaults(defaults);
         this.loadNamedColors(defaults);
         ArrayList defaultsKeysCache = new ArrayList();
         Set uiKeys = new HashSet();
         Iterator var5 = this.field_1659.entrySet().iterator();

         while(var5.hasNext()) {
            Entry e = (Entry)var5.next();
            this.apply((String)e.getKey(), e.getValue(), defaults, defaultsKeysCache, uiKeys);
         }

         this.applyColorPalette(defaults);
         this.applyCheckBoxColors(defaults);
         Object panelBackground = defaults.get("Panel.background");
         defaults.put("Button.disabledBackground", panelBackground);
         defaults.put("ToggleButton.disabledBackground", panelBackground);
         Object helpButtonBackground = defaults.get("Button.startBackground");
         Object helpButtonBorderColor = defaults.get("Button.startBorderColor");
         if (helpButtonBackground == null) {
            helpButtonBackground = defaults.get("Button.background");
         }

         if (helpButtonBorderColor == null) {
            helpButtonBorderColor = defaults.get("Button.borderColor");
         }

         defaults.put("HelpButton.background", helpButtonBackground);
         defaults.put("HelpButton.borderColor", helpButtonBorderColor);
         defaults.put("HelpButton.disabledBackground", panelBackground);
         defaults.put("HelpButton.disabledBorderColor", defaults.get("Button.disabledBorderColor"));
         defaults.put("HelpButton.focusedBorderColor", defaults.get("Button.focusedBorderColor"));
         defaults.put("HelpButton.focusedBackground", defaults.get("Button.focusedBackground"));
         defaults.put("ComboBox.editableBackground", defaults.get("TextField.background"));
         defaults.put("Spinner.background", defaults.get("TextField.background"));
         defaults.put("Spinner.buttonBackground", defaults.get("ComboBox.buttonEditableBackground"));
         defaults.put("Spinner.buttonArrowColor", defaults.get("ComboBox.buttonArrowColor"));
         defaults.put("Spinner.buttonDisabledArrowColor", defaults.get("ComboBox.buttonDisabledArrowColor"));
         if (uiKeys.contains("TextField.background")) {
            Object textFieldBackground = defaults.get("TextField.background");
            if (!uiKeys.contains("FormattedTextField.background")) {
               defaults.put("FormattedTextField.background", textFieldBackground);
            }

            if (!uiKeys.contains("PasswordField.background")) {
               defaults.put("PasswordField.background", textFieldBackground);
            }

            if (!uiKeys.contains("EditorPane.background")) {
               defaults.put("EditorPane.background", textFieldBackground);
            }

            if (!uiKeys.contains("TextArea.background")) {
               defaults.put("TextArea.background", textFieldBackground);
            }

            if (!uiKeys.contains("TextPane.background")) {
               defaults.put("TextPane.background", textFieldBackground);
            }

            if (!uiKeys.contains("Spinner.background")) {
               defaults.put("Spinner.background", textFieldBackground);
            }
         }

         if (!uiKeys.contains("ToggleButton.startBackground") && !uiKeys.contains("*.startBackground")) {
            defaults.put("ToggleButton.startBackground", defaults.get("Button.startBackground"));
         }

         if (!uiKeys.contains("ToggleButton.endBackground") && !uiKeys.contains("*.endBackground")) {
            defaults.put("ToggleButton.endBackground", defaults.get("Button.endBackground"));
         }

         if (!uiKeys.contains("ToggleButton.foreground") && uiKeys.contains("Button.foreground")) {
            defaults.put("ToggleButton.foreground", defaults.get("Button.foreground"));
         }

         int rowHeight = defaults.getInt("Tree.rowHeight");
         if (rowHeight > 22) {
            defaults.put("Tree.rowHeight", 22);
         }

         defaults.putAll(themeSpecificDefaults);
      }
   }

   private Map removeThemeSpecificDefaults(UIDefaults defaults) {
      ArrayList themeSpecificKeys = new ArrayList();
      Iterator var3 = defaults.keySet().iterator();

      while(var3.hasNext()) {
         Object key = var3.next();
         if (key instanceof String && ((String)key).startsWith("[")) {
            themeSpecificKeys.add((String)key);
         }
      }

      Map themeSpecificDefaults = new HashMap();
      String currentThemePrefix = '[' + this.name.replace(' ', '_') + ']';
      Iterator var5 = themeSpecificKeys.iterator();

      while(var5.hasNext()) {
         String key = (String)var5.next();
         Object value = defaults.remove(key);
         if (key.startsWith(currentThemePrefix)) {
            themeSpecificDefaults.put(key.substring(currentThemePrefix.length()), value);
         }
      }

      return themeSpecificDefaults;
   }

   private void loadNamedColors(UIDefaults defaults) {
      if (this.colors != null) {
         this.namedColors = new HashMap();
         Iterator var2 = this.colors.entrySet().iterator();

         while(var2.hasNext()) {
            Entry e = (Entry)var2.next();
            String value = (String)e.getValue();
            ColorUIResource color = UIDefaultsLoader.parseColor(value);
            if (color != null) {
               String key = (String)e.getKey();
               this.namedColors.put(key, color);
               defaults.put("ColorPalette." + key, color);
            }
         }

      }
   }

   private void apply(String key, Object value, UIDefaults defaults, ArrayList defaultsKeysCache, Set uiKeys) {
      if (value instanceof Map) {
         Iterator var14 = ((Map)value).entrySet().iterator();

         while(var14.hasNext()) {
            Entry e = (Entry)var14.next();
            this.apply(key + '.' + (String)e.getKey(), e.getValue(), defaults, defaultsKeysCache, uiKeys);
         }
      } else {
         uiKeys.add(key);
         boolean isMaterialUILite = this.author.equals("Mallowigi");
         if (isMaterialUILite && (key.equals("ComboBox.padding") || key.equals("Spinner.border"))) {
            return;
         }

         key = (String)uiKeyMapping.getOrDefault(key, key);
         if (key.isEmpty()) {
            return;
         }

         String valueStr = value.toString();
         Object uiValue = this.namedColors.get(valueStr);
         if (uiValue == null) {
            if (valueStr.startsWith("#") || !key.endsWith("ground") && !key.endsWith("Color")) {
               if (valueStr.startsWith("##")) {
                  valueStr = this.fixColorIfValid(valueStr.substring(1), valueStr);
               } else if (key.endsWith(".border") || key.endsWith("Border")) {
                  List parts = StringUtils.split(valueStr, ',');
                  if (parts.size() == 5 && !((String)parts.get(4)).startsWith("#")) {
                     parts.set(4, "#" + (String)parts.get(4));
                     valueStr = String.join(",", parts);
                  }
               }
            } else {
               valueStr = this.fixColorIfValid("#" + valueStr, valueStr);
            }

            try {
               uiValue = UIDefaultsLoader.parseValue(key, valueStr);
            } catch (RuntimeException var13) {
               UIDefaultsLoader.logParseError(Level.CONFIG, key, valueStr, var13);
               return;
            }
         }

         if (key.startsWith("*.")) {
            String tail = key.substring(1);
            if (defaultsKeysCache.size() != defaults.size()) {
               defaultsKeysCache.clear();
               Enumeration e = defaults.keys();

               while(e.hasMoreElements()) {
                  defaultsKeysCache.add(e.nextElement());
               }
            }

            Iterator var17 = defaultsKeysCache.iterator();

            while(var17.hasNext()) {
               Object k = var17.next();
               if (k instanceof String) {
                  String km = (String)uiKeyInverseMapping.getOrDefault(k, (String)k);
                  if (km.endsWith(tail) && !((String)k).startsWith("CheckBox.icon.")) {
                     defaults.put(k, uiValue);
                  }
               }
            }
         } else {
            defaults.put(key, uiValue);
         }
      }

   }

   private String fixColorIfValid(String newColorStr, String colorStr) {
      try {
         UIDefaultsLoader.parseColorRGBA(newColorStr);
         return newColorStr;
      } catch (IllegalArgumentException var4) {
         return colorStr;
      }
   }

   private void applyColorPalette(UIDefaults defaults) {
      if (this.icons != null) {
         Object palette = this.icons.get("ColorPalette");
         if (palette instanceof Map) {
            Map colorPalette = (Map)palette;
            Iterator var4 = colorPalette.entrySet().iterator();

            while(var4.hasNext()) {
               Entry e = (Entry)var4.next();
               String key = (String)e.getKey();
               Object value = e.getValue();
               if (!key.startsWith("Checkbox.") && value instanceof String) {
                  if (this.dark) {
                     key = StringUtils.removeTrailing(key, ".Dark");
                  }

                  ColorUIResource color = this.toColor((String)value);
                  if (color != null) {
                     defaults.put(key, color);
                  }
               }
            }

         }
      }
   }

   private ColorUIResource toColor(String value) {
      ColorUIResource color = (ColorUIResource)this.namedColors.get(value);
      return color != null ? color : UIDefaultsLoader.parseColor(value);
   }

   private void applyCheckBoxColors(UIDefaults defaults) {
      if (this.icons != null) {
         Object palette = this.icons.get("ColorPalette");
         if (palette instanceof Map) {
            boolean checkboxModified = false;
            Map colorPalette = (Map)palette;
            Iterator var5 = colorPalette.entrySet().iterator();

            while(true) {
               String key;
               Object value;
               do {
                  do {
                     Entry e;
                     if (!var5.hasNext()) {
                        if (checkboxModified) {
                           defaults.remove("CheckBox.icon.focusWidth");
                           defaults.remove("CheckBox.icon.hoverBorderColor");
                           defaults.remove("CheckBox.icon.focusedBackground");
                           defaults.remove("CheckBox.icon.hoverBackground");
                           defaults.remove("CheckBox.icon.pressedBackground");
                           defaults.remove("CheckBox.icon.selectedFocusedBackground");
                           defaults.remove("CheckBox.icon.selectedHoverBackground");
                           defaults.remove("CheckBox.icon.selectedPressedBackground");
                           defaults.remove("CheckBox.icon[filled].focusWidth");
                           defaults.remove("CheckBox.icon[filled].hoverBorderColor");
                           defaults.remove("CheckBox.icon[filled].focusedBackground");
                           defaults.remove("CheckBox.icon[filled].hoverBackground");
                           defaults.remove("CheckBox.icon[filled].pressedBackground");
                           defaults.remove("CheckBox.icon[filled].selectedFocusedBackground");
                           defaults.remove("CheckBox.icon[filled].selectedHoverBackground");
                           defaults.remove("CheckBox.icon[filled].selectedPressedBackground");
                        }

                        var5 = uiKeyCopying.entrySet().iterator();

                        while(var5.hasNext()) {
                           e = (Entry)var5.next();
                           defaults.put(e.getKey(), defaults.get(e.getValue()));
                        }

                        return;
                     }

                     e = (Entry)var5.next();
                     key = (String)e.getKey();
                     value = e.getValue();
                  } while(!key.startsWith("Checkbox."));
               } while(!(value instanceof String));

               if (key.equals("Checkbox.Background.Default") || key.equals("Checkbox.Foreground.Selected")) {
                  value = "#ffffff";
               }

               String key2 = (String)checkboxDuplicateColors.get(key);
               if (this.dark) {
                  key = StringUtils.removeTrailing(key, ".Dark");
               }

               String newKey = (String)checkboxKeyMapping.get(key);
               if (newKey != null) {
                  String checkBoxIconPrefix = "CheckBox.icon.";
                  if (!this.dark && newKey.startsWith(checkBoxIconPrefix)) {
                     newKey = "CheckBox.icon[filled].".concat(newKey.substring(checkBoxIconPrefix.length()));
                  }

                  ColorUIResource color = this.toColor((String)value);
                  if (color != null) {
                     defaults.put(newKey, color);
                     if (key2 != null) {
                        if (this.dark) {
                           key2 = StringUtils.removeTrailing(key2, ".Dark");
                        }

                        String newKey2 = (String)checkboxKeyMapping.get(key2);
                        if (newKey2 != null) {
                           defaults.put(newKey2, color);
                        }
                     }
                  }

                  checkboxModified = true;
               }
            }
         }
      }
   }

   static {
      uiKeyMapping.put("ComboBox.background", "");
      uiKeyMapping.put("ComboBox.nonEditableBackground", "ComboBox.background");
      uiKeyMapping.put("ComboBox.ArrowButton.background", "ComboBox.buttonEditableBackground");
      uiKeyMapping.put("ComboBox.ArrowButton.disabledIconColor", "ComboBox.buttonDisabledArrowColor");
      uiKeyMapping.put("ComboBox.ArrowButton.iconColor", "ComboBox.buttonArrowColor");
      uiKeyMapping.put("ComboBox.ArrowButton.nonEditableBackground", "ComboBox.buttonBackground");
      uiKeyMapping.put("Component.inactiveErrorFocusColor", "Component.error.borderColor");
      uiKeyMapping.put("Component.errorFocusColor", "Component.error.focusedBorderColor");
      uiKeyMapping.put("Component.inactiveWarningFocusColor", "Component.warning.borderColor");
      uiKeyMapping.put("Component.warningFocusColor", "Component.warning.focusedBorderColor");
      uiKeyMapping.put("Link.activeForeground", "Component.linkColor");
      uiKeyMapping.put("Menu.border", "Menu.margin");
      uiKeyMapping.put("MenuItem.border", "MenuItem.margin");
      uiKeyCopying.put("CheckBoxMenuItem.margin", "MenuItem.margin");
      uiKeyCopying.put("RadioButtonMenuItem.margin", "MenuItem.margin");
      uiKeyMapping.put("PopupMenu.border", "PopupMenu.borderInsets");
      uiKeyCopying.put("Menu.selectionBackground", "List.selectionBackground");
      uiKeyCopying.put("MenuItem.selectionBackground", "List.selectionBackground");
      uiKeyCopying.put("CheckBoxMenuItem.selectionBackground", "List.selectionBackground");
      uiKeyCopying.put("RadioButtonMenuItem.selectionBackground", "List.selectionBackground");
      uiKeyMapping.put("ProgressBar.background", "");
      uiKeyMapping.put("ProgressBar.foreground", "");
      uiKeyMapping.put("ProgressBar.trackColor", "ProgressBar.background");
      uiKeyMapping.put("ProgressBar.progressColor", "ProgressBar.foreground");
      uiKeyMapping.put("ScrollBar.trackColor", "ScrollBar.track");
      uiKeyMapping.put("ScrollBar.thumbColor", "ScrollBar.thumb");
      uiKeyMapping.put("Separator.separatorColor", "Separator.foreground");
      uiKeyMapping.put("Slider.trackWidth", "");
      uiKeyMapping.put("TitlePane.infoForeground", "TitlePane.foreground");
      uiKeyMapping.put("TitlePane.inactiveInfoForeground", "TitlePane.inactiveForeground");
      Iterator var0 = uiKeyMapping.entrySet().iterator();

      while(var0.hasNext()) {
         Entry e = (Entry)var0.next();
         uiKeyInverseMapping.put((String)e.getValue(), (String)e.getKey());
      }

      uiKeyCopying.put("ToggleButton.tab.underlineColor", "TabbedPane.underlineColor");
      uiKeyCopying.put("ToggleButton.tab.disabledUnderlineColor", "TabbedPane.disabledUnderlineColor");
      uiKeyCopying.put("ToggleButton.tab.selectedBackground", "TabbedPane.selectedBackground");
      uiKeyCopying.put("ToggleButton.tab.hoverBackground", "TabbedPane.hoverColor");
      uiKeyCopying.put("ToggleButton.tab.focusBackground", "TabbedPane.focusColor");
      checkboxKeyMapping.put("Checkbox.Background.Default", "CheckBox.icon.background");
      checkboxKeyMapping.put("Checkbox.Background.Disabled", "CheckBox.icon.disabledBackground");
      checkboxKeyMapping.put("Checkbox.Border.Default", "CheckBox.icon.borderColor");
      checkboxKeyMapping.put("Checkbox.Border.Disabled", "CheckBox.icon.disabledBorderColor");
      checkboxKeyMapping.put("Checkbox.Focus.Thin.Default", "CheckBox.icon.focusedBorderColor");
      checkboxKeyMapping.put("Checkbox.Focus.Wide", "CheckBox.icon.focusColor");
      checkboxKeyMapping.put("Checkbox.Foreground.Disabled", "CheckBox.icon.disabledCheckmarkColor");
      checkboxKeyMapping.put("Checkbox.Background.Selected", "CheckBox.icon.selectedBackground");
      checkboxKeyMapping.put("Checkbox.Border.Selected", "CheckBox.icon.selectedBorderColor");
      checkboxKeyMapping.put("Checkbox.Foreground.Selected", "CheckBox.icon.checkmarkColor");
      checkboxKeyMapping.put("Checkbox.Focus.Thin.Selected", "CheckBox.icon.selectedFocusedBorderColor");
      checkboxDuplicateColors.put("Checkbox.Background.Default.Dark", "Checkbox.Background.Selected.Dark");
      checkboxDuplicateColors.put("Checkbox.Border.Default.Dark", "Checkbox.Border.Selected.Dark");
      checkboxDuplicateColors.put("Checkbox.Focus.Thin.Default.Dark", "Checkbox.Focus.Thin.Selected.Dark");
      Entry[] entries = (Entry[])checkboxDuplicateColors.entrySet().toArray(new Entry[checkboxDuplicateColors.size()]);
      Entry[] var6 = entries;
      int var2 = entries.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Entry e = var6[var3];
         checkboxDuplicateColors.put((String)e.getValue(), (String)e.getKey());
      }

   }

   public static class ThemeLaf extends FlatLaf {
      private final IntelliJTheme theme;

      public ThemeLaf(IntelliJTheme theme) {
         this.theme = theme;
      }

      public String getName() {
         return this.theme.name;
      }

      public String getDescription() {
         return this.theme.name;
      }

      public boolean isDark() {
         return this.theme.dark;
      }

      public IntelliJTheme getTheme() {
         return this.theme;
      }

      void applyAdditionalDefaults(UIDefaults defaults) {
         this.theme.applyProperties(defaults);
      }

      protected ArrayList getLafClassesForDefaultsLoading() {
         ArrayList lafClasses = new ArrayList();
         lafClasses.add(FlatLaf.class);
         lafClasses.add(this.theme.dark ? FlatDarkLaf.class : FlatLightLaf.class);
         lafClasses.add(this.theme.dark ? FlatDarculaLaf.class : FlatIntelliJLaf.class);
         lafClasses.add(IntelliJTheme.ThemeLaf.class);
         return lafClasses;
      }
   }
}
