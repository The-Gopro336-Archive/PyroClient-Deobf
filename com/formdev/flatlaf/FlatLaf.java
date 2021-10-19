package com.formdev.flatlaf;

import com.formdev.flatlaf.ui.FlatPopupFactory;
import com.formdev.flatlaf.ui.JBRCustomDecorations;
import com.formdev.flatlaf.util.GrayFilter;
import com.formdev.flatlaf.util.MultiResolutionImageSupport;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIDefaults.ActiveValue;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.text.StyleContext;
import javax.swing.text.html.HTMLEditorKit;

public abstract class FlatLaf extends BasicLookAndFeel {
   static final Logger LOG = Logger.getLogger(FlatLaf.class.getName());
   private static final String DESKTOPFONTHINTS = "awt.font.desktophints";
   private String desktopPropertyName;
   private String desktopPropertyName2;
   private PropertyChangeListener desktopPropertyListener;
   private static boolean aquaLoaded;
   private static boolean updateUIPending;
   private PopupFactory oldPopupFactory;
   private MnemonicHandler mnemonicHandler;
   private Consumer postInitialization;
   private Boolean oldFrameWindowDecorated;
   private Boolean oldDialogWindowDecorated;

   public static boolean install(LookAndFeel newLookAndFeel) {
      try {
         UIManager.setLookAndFeel(newLookAndFeel);
         return true;
      } catch (Exception var2) {
         LOG.log(Level.SEVERE, "FlatLaf: Failed to initialize look and feel '" + newLookAndFeel.getClass().getName() + "'.", var2);
         return false;
      }
   }

   public String getID() {
      return "FlatLaf - " + this.getName();
   }

   public abstract boolean isDark();

   public static boolean isLafDark() {
      LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
      return lookAndFeel instanceof FlatLaf && ((FlatLaf)lookAndFeel).isDark();
   }

   public boolean getSupportsWindowDecorations() {
      return SystemInfo.IS_JETBRAINS_JVM_11_OR_LATER && SystemInfo.IS_WINDOWS_10_OR_LATER && JBRCustomDecorations.isSupported() ? false : SystemInfo.IS_WINDOWS_10_OR_LATER;
   }

   public boolean isNativeLookAndFeel() {
      return false;
   }

   public boolean isSupportedLookAndFeel() {
      return true;
   }

   public Icon getDisabledIcon(JComponent component, Icon icon) {
      if (icon instanceof ImageIcon) {
         Object grayFilter = UIManager.get("Component.grayFilter");
         ImageFilter filter = grayFilter instanceof ImageFilter ? (ImageFilter)grayFilter : GrayFilter.createDisabledIconFilter(this.isDark());
         Function mapper = (img) -> {
            ImageProducer producer = new FilteredImageSource(img.getSource(), filter);
            return Toolkit.getDefaultToolkit().createImage(producer);
         };
         Image image = ((ImageIcon)icon).getImage();
         return new FlatLaf.ImageIconUIResource(MultiResolutionImageSupport.map(image, mapper));
      } else {
         return null;
      }
   }

   public void initialize() {
      if (SystemInfo.IS_MAC) {
         this.initializeAqua();
      }

      super.initialize();
      this.oldPopupFactory = PopupFactory.getSharedInstance();
      PopupFactory.setSharedInstance(new FlatPopupFactory());
      this.mnemonicHandler = new MnemonicHandler();
      this.mnemonicHandler.install();
      if (SystemInfo.IS_WINDOWS) {
         this.desktopPropertyName = "win.messagebox.font";
      } else if (SystemInfo.IS_LINUX) {
         this.desktopPropertyName = "gnome.Gtk/FontName";
         this.desktopPropertyName2 = "gnome.Xft/DPI";
      }

      if (this.desktopPropertyName != null) {
         this.desktopPropertyListener = (e) -> {
            String propertyName = e.getPropertyName();
            if (!this.desktopPropertyName.equals(propertyName) && !propertyName.equals(this.desktopPropertyName2)) {
               if ("awt.font.desktophints".equals(propertyName) && UIManager.getLookAndFeel() instanceof FlatLaf) {
                  this.putAATextInfo(UIManager.getLookAndFeelDefaults());
                  updateUILater();
               }
            } else {
               reSetLookAndFeel();
            }

         };
         Toolkit toolkit = Toolkit.getDefaultToolkit();
         toolkit.addPropertyChangeListener(this.desktopPropertyName, this.desktopPropertyListener);
         if (this.desktopPropertyName2 != null) {
            toolkit.addPropertyChangeListener(this.desktopPropertyName2, this.desktopPropertyListener);
         }

         toolkit.addPropertyChangeListener("awt.font.desktophints", this.desktopPropertyListener);
      }

      this.postInitialization = (defaults) -> {
         Color linkColor = defaults.getColor("Component.linkColor");
         if (linkColor != null) {
            (new HTMLEditorKit()).getStyleSheet().addRule(String.format("a { color: #%06x; }", linkColor.getRGB() & 16777215));
         }

      };
      Boolean useWindowDecorations = FlatSystemProperties.getBooleanStrict("flatlaf.useWindowDecorations", (Boolean)null);
      if (useWindowDecorations != null) {
         this.oldFrameWindowDecorated = JFrame.isDefaultLookAndFeelDecorated();
         this.oldDialogWindowDecorated = JDialog.isDefaultLookAndFeelDecorated();
         JFrame.setDefaultLookAndFeelDecorated(useWindowDecorations);
         JDialog.setDefaultLookAndFeelDecorated(useWindowDecorations);
      }

   }

   public void uninitialize() {
      if (this.desktopPropertyListener != null) {
         Toolkit toolkit = Toolkit.getDefaultToolkit();
         toolkit.removePropertyChangeListener(this.desktopPropertyName, this.desktopPropertyListener);
         if (this.desktopPropertyName2 != null) {
            toolkit.removePropertyChangeListener(this.desktopPropertyName2, this.desktopPropertyListener);
         }

         toolkit.removePropertyChangeListener("awt.font.desktophints", this.desktopPropertyListener);
         this.desktopPropertyName = null;
         this.desktopPropertyName2 = null;
         this.desktopPropertyListener = null;
      }

      if (this.oldPopupFactory != null) {
         PopupFactory.setSharedInstance(this.oldPopupFactory);
         this.oldPopupFactory = null;
      }

      if (this.mnemonicHandler != null) {
         this.mnemonicHandler.uninstall();
         this.mnemonicHandler = null;
      }

      (new HTMLEditorKit()).getStyleSheet().addRule("a { color: blue; }");
      this.postInitialization = null;
      if (this.oldFrameWindowDecorated != null) {
         JFrame.setDefaultLookAndFeelDecorated(this.oldFrameWindowDecorated);
         JDialog.setDefaultLookAndFeelDecorated(this.oldDialogWindowDecorated);
         this.oldFrameWindowDecorated = null;
         this.oldDialogWindowDecorated = null;
      }

      super.uninitialize();
   }

   private void initializeAqua() {
      if (!aquaLoaded) {
         aquaLoaded = true;
         String aquaLafClassName = "com.apple.laf.AquaLookAndFeel";

         BasicLookAndFeel aquaLaf;
         try {
            if (SystemInfo.IS_JAVA_9_OR_LATER) {
               Method m = UIManager.class.getMethod("createLookAndFeel", String.class);
               aquaLaf = (BasicLookAndFeel)m.invoke((Object)null, "Mac OS X");
            } else {
               aquaLaf = (BasicLookAndFeel)Class.forName(aquaLafClassName).newInstance();
            }
         } catch (Exception var4) {
            LOG.log(Level.SEVERE, "FlatLaf: Failed to initialize Aqua look and feel '" + aquaLafClassName + "'.", var4);
            throw new IllegalStateException();
         }

         PopupFactory oldPopupFactory = PopupFactory.getSharedInstance();
         aquaLaf.initialize();
         aquaLaf.uninitialize();
         PopupFactory.setSharedInstance(oldPopupFactory);
      }
   }

   public UIDefaults getDefaults() {
      UIDefaults defaults = super.getDefaults();
      defaults.addResourceBundle("com.formdev.flatlaf.resources.Bundle");
      this.putDefaults(defaults, defaults.getColor("control"), "Button.disabledBackground", "EditorPane.disabledBackground", "EditorPane.inactiveBackground", "FormattedTextField.disabledBackground", "PasswordField.disabledBackground", "Spinner.disabledBackground", "TextArea.disabledBackground", "TextArea.inactiveBackground", "TextField.disabledBackground", "TextPane.disabledBackground", "TextPane.inactiveBackground", "ToggleButton.disabledBackground");
      this.putDefaults(defaults, defaults.getColor("textInactiveText"), "Button.disabledText", "CheckBox.disabledText", "CheckBoxMenuItem.disabledForeground", "Menu.disabledForeground", "MenuItem.disabledForeground", "RadioButton.disabledText", "RadioButtonMenuItem.disabledForeground", "Spinner.disabledForeground", "ToggleButton.disabledText");
      this.putDefaults(defaults, defaults.getColor("textText"), "DesktopIcon.foreground");
      this.initFonts(defaults);
      initIconColors(defaults, this.isDark());
      FlatInputMaps.initInputMaps(defaults);
      ServiceLoader addonLoader = ServiceLoader.load(FlatDefaultsAddon.class);
      List addons = new ArrayList();
      Iterator var4 = addonLoader.iterator();

      while(var4.hasNext()) {
         FlatDefaultsAddon addon = (FlatDefaultsAddon)var4.next();
         addons.add(addon);
      }

      addons.sort((addon1, addon2) -> {
         return addon1.getPriority() - addon2.getPriority();
      });
      List lafClassesForDefaultsLoading = this.getLafClassesForDefaultsLoading();
      if (lafClassesForDefaultsLoading != null) {
         UIDefaultsLoader.loadDefaultsFromProperties((List)lafClassesForDefaultsLoading, addons, this.getAdditionalDefaults(), this.isDark(), defaults);
      } else {
         UIDefaultsLoader.loadDefaultsFromProperties((Class)this.getClass(), addons, this.getAdditionalDefaults(), this.isDark(), defaults);
      }

      if (SystemInfo.IS_MAC && Boolean.getBoolean("apple.laf.useScreenMenuBar")) {
         defaults.put("MenuBarUI", "com.apple.laf.AquaMenuBarUI");
         defaults.put("MenuBar.backgroundPainter", BorderFactory.createEmptyBorder());
      }

      this.putAATextInfo(defaults);
      this.applyAdditionalDefaults(defaults);
      Iterator var8 = addons.iterator();

      while(var8.hasNext()) {
         FlatDefaultsAddon addon = (FlatDefaultsAddon)var8.next();
         addon.afterDefaultsLoading(this, defaults);
      }

      defaults.put("laf.scaleFactor", (t) -> {
         return UIScale.getUserScaleFactor();
      });
      if (this.postInitialization != null) {
         this.postInitialization.accept(defaults);
         this.postInitialization = null;
      }

      return defaults;
   }

   void applyAdditionalDefaults(UIDefaults defaults) {
   }

   protected List getLafClassesForDefaultsLoading() {
      return null;
   }

   protected Properties getAdditionalDefaults() {
      return null;
   }

   private void initFonts(UIDefaults defaults) {
      FontUIResource uiFont = null;
      Font font;
      if (SystemInfo.IS_WINDOWS) {
         font = (Font)Toolkit.getDefaultToolkit().getDesktopProperty("win.messagebox.font");
         if (font != null) {
            uiFont = createCompositeFont(font.getFamily(), font.getStyle(), font.getSize());
         }
      } else if (SystemInfo.IS_MAC) {
         String fontName;
         if (SystemInfo.IS_MAC_OS_10_15_CATALINA_OR_LATER) {
            fontName = "Helvetica Neue";
         } else if (SystemInfo.IS_MAC_OS_10_11_EL_CAPITAN_OR_LATER) {
            fontName = ".SF NS Text";
         } else {
            fontName = "Lucida Grande";
         }

         uiFont = createCompositeFont(fontName, 0, 13);
      } else if (SystemInfo.IS_LINUX) {
         font = LinuxFontPolicy.getFont();
         uiFont = font instanceof FontUIResource ? (FontUIResource)font : new FontUIResource(font);
      }

      if (uiFont == null) {
         uiFont = createCompositeFont("SansSerif", 0, 12);
      }

      uiFont = UIScale.applyCustomScaleFactor(uiFont);
      Object activeFont = new FlatLaf.ActiveFont(1.0F);
      Iterator var4 = defaults.keySet().iterator();

      while(true) {
         Object key;
         do {
            do {
               if (!var4.hasNext()) {
                  defaults.put("ProgressBar.font", new FlatLaf.ActiveFont(0.85F));
                  defaults.put("defaultFont", uiFont);
                  return;
               }

               key = var4.next();
            } while(!(key instanceof String));
         } while(!((String)key).endsWith(".font") && !((String)key).endsWith("Font"));

         defaults.put(key, activeFont);
      }
   }

   static FontUIResource createCompositeFont(String family, int style, int size) {
      Font font = StyleContext.getDefaultStyleContext().getFont(family, style, size);
      return font instanceof FontUIResource ? (FontUIResource)font : new FontUIResource(font);
   }

   public static void initIconColors(UIDefaults defaults, boolean dark) {
      FlatIconColors[] var2 = FlatIconColors.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         FlatIconColors c = var2[var4];
         if (c.light == !dark || c.dark == dark) {
            defaults.put(c.key, new ColorUIResource(c.rgb));
         }
      }

   }

   private void putAATextInfo(UIDefaults defaults) {
      Object desktopHints;
      if (SystemInfo.IS_JAVA_9_OR_LATER) {
         desktopHints = Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints");
         if (desktopHints instanceof Map) {
            Map hints = (Map)desktopHints;
            Object aaHint = hints.get(RenderingHints.KEY_TEXT_ANTIALIASING);
            if (aaHint != null && aaHint != RenderingHints.VALUE_TEXT_ANTIALIAS_OFF && aaHint != RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT) {
               defaults.put(RenderingHints.KEY_TEXT_ANTIALIASING, aaHint);
               defaults.put(RenderingHints.KEY_TEXT_LCD_CONTRAST, hints.get(RenderingHints.KEY_TEXT_LCD_CONTRAST));
            }
         }
      } else {
         try {
            desktopHints = Class.forName("sun.swing.SwingUtilities2").getField("AA_TEXT_PROPERTY_KEY").get((Object)null);
            Object value = Class.forName("sun.swing.SwingUtilities2$AATextInfo").getMethod("getAATextInfo", Boolean.TYPE).invoke((Object)null, true);
            defaults.put(desktopHints, value);
         } catch (Exception var5) {
            Logger.getLogger(FlatLaf.class.getName()).log(Level.SEVERE, (String)null, var5);
            throw new RuntimeException(var5);
         }
      }

   }

   private void putDefaults(UIDefaults defaults, Object value, String... keys) {
      String[] var4 = keys;
      int var5 = keys.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         String key = var4[var6];
         defaults.put(key, value);
      }

   }

   private static void reSetLookAndFeel() {
      EventQueue.invokeLater(() -> {
         LookAndFeel lookAndFeel = UIManager.getLookAndFeel();

         try {
            UIManager.setLookAndFeel(lookAndFeel);
            PropertyChangeEvent e = new PropertyChangeEvent(UIManager.class, "lookAndFeel", lookAndFeel, lookAndFeel);
            PropertyChangeListener[] var2 = UIManager.getPropertyChangeListeners();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               PropertyChangeListener l = var2[var4];
               l.propertyChange(e);
            }

            updateUI();
         } catch (UnsupportedLookAndFeelException var6) {
            LOG.log(Level.SEVERE, "FlatLaf: Failed to reinitialize look and feel '" + lookAndFeel.getClass().getName() + "'.", var6);
         }

      });
   }

   public static void updateUI() {
      Window[] var0 = Window.getWindows();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         Window w = var0[var2];
         SwingUtilities.updateComponentTreeUI(w);
      }

   }

   public static void updateUILater() {
      Class var0 = FlatLaf.class;
      synchronized(FlatLaf.class) {
         if (updateUIPending) {
            return;
         }

         updateUIPending = true;
      }

      EventQueue.invokeLater(() -> {
         updateUI();
         Class var0 = FlatLaf.class;
         synchronized(FlatLaf.class) {
            updateUIPending = false;
         }
      });
   }

   public static boolean isShowMnemonics() {
      return MnemonicHandler.isShowMnemonics();
   }

   public static void showMnemonics(Component c) {
      MnemonicHandler.showMnemonics(true, c);
   }

   public static void hideMnemonics() {
      MnemonicHandler.showMnemonics(false, (Component)null);
   }

   private static class ImageIconUIResource extends ImageIcon implements UIResource {
      ImageIconUIResource(Image image) {
         super(image);
      }
   }

   private static class ActiveFont implements ActiveValue {
      private final float scaleFactor;
      private Font font;
      private Font lastDefaultFont;

      ActiveFont(float scaleFactor) {
         this.scaleFactor = scaleFactor;
      }

      public Object createValue(UIDefaults table) {
         Font defaultFont = UIManager.getFont("defaultFont");
         if (this.lastDefaultFont != defaultFont) {
            this.lastDefaultFont = defaultFont;
            if (this.scaleFactor != 1.0F) {
               int newFontSize = Math.round((float)defaultFont.getSize() * this.scaleFactor);
               this.font = new FontUIResource(defaultFont.deriveFont((float)newFontSize));
            } else {
               this.font = (Font)(defaultFont instanceof UIResource ? defaultFont : new FontUIResource(defaultFont));
            }
         }

         return this.font;
      }
   }
}
