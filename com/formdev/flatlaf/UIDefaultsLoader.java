package com.formdev.flatlaf;

import com.formdev.flatlaf.ui.FlatEmptyBorder;
import com.formdev.flatlaf.ui.FlatLineBorder;
import com.formdev.flatlaf.util.ColorFunctions;
import com.formdev.flatlaf.util.DerivedColor;
import com.formdev.flatlaf.util.GrayFilter;
import com.formdev.flatlaf.util.HSLColor;
import com.formdev.flatlaf.util.StringUtils;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.logging.Level;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UIDefaults.ActiveValue;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;

class UIDefaultsLoader {
   private static final String TYPE_PREFIX = "{";
   private static final String TYPE_PREFIX_END = "}";
   private static final String VARIABLE_PREFIX = "@";
   private static final String PROPERTY_PREFIX = "$";
   private static final String OPTIONAL_PREFIX = "?";
   private static final String GLOBAL_PREFIX = "*.";
   private static UIDefaultsLoader.ValueType[] tempResultValueType = new UIDefaultsLoader.ValueType[1];

   static void loadDefaultsFromProperties(Class lookAndFeelClass, List addons, Properties additionalDefaults, boolean dark, UIDefaults defaults) {
      ArrayList lafClasses = new ArrayList();

      for(Class lafClass = lookAndFeelClass; FlatLaf.class.isAssignableFrom(lafClass); lafClass = lafClass.getSuperclass()) {
         lafClasses.add(0, lafClass);
      }

      loadDefaultsFromProperties((List)lafClasses, addons, additionalDefaults, dark, defaults);
   }

   static void loadDefaultsFromProperties(List lafClasses, List addons, Properties additionalDefaults, boolean dark, UIDefaults defaults) {
      try {
         Properties properties = new Properties();
         Iterator var6 = lafClasses.iterator();

         String lightOrDarkPrefix;
         while(var6.hasNext()) {
            Class lafClass = (Class)var6.next();
            lightOrDarkPrefix = '/' + lafClass.getName().replace('.', '/') + ".properties";
            InputStream in = lafClass.getResourceAsStream(lightOrDarkPrefix);

            try {
               if (in != null) {
                  properties.load(in);
               }
            } catch (Throwable var21) {
               if (in != null) {
                  try {
                     in.close();
                  } catch (Throwable var17) {
                     var21.addSuppressed(var17);
                  }
               }

               throw var21;
            }

            if (in != null) {
               in.close();
            }
         }

         var6 = addons.iterator();

         Iterator var27;
         while(var6.hasNext()) {
            FlatDefaultsAddon addon = (FlatDefaultsAddon)var6.next();
            var27 = lafClasses.iterator();

            while(var27.hasNext()) {
               Class lafClass = (Class)var27.next();
               InputStream in = addon.getDefaults(lafClass);

               try {
                  if (in != null) {
                     properties.load(in);
                  }
               } catch (Throwable var20) {
                  if (in != null) {
                     try {
                        in.close();
                     } catch (Throwable var16) {
                        var20.addSuppressed(var16);
                     }
                  }

                  throw var20;
               }

               if (in != null) {
                  in.close();
               }
            }
         }

         List addonClassLoaders = new ArrayList();
         Iterator var25 = addons.iterator();

         while(var25.hasNext()) {
            FlatDefaultsAddon addon = (FlatDefaultsAddon)var25.next();
            ClassLoader addonClassLoader = addon.getClass().getClassLoader();
            if (!addonClassLoaders.contains(addonClassLoader)) {
               addonClassLoaders.add(addonClassLoader);
            }
         }

         if (additionalDefaults != null) {
            properties.putAll(additionalDefaults);
         }

         ArrayList platformSpecificKeys = new ArrayList();
         var27 = properties.keySet().iterator();

         label191:
         while(true) {
            String key;
            do {
               do {
                  if (!var27.hasNext()) {
                     Object key;
                     if (!platformSpecificKeys.isEmpty()) {
                        lightOrDarkPrefix = dark ? "[dark]" : "[light]";
                        Iterator var34 = platformSpecificKeys.iterator();

                        while(var34.hasNext()) {
                           key = (String)var34.next();
                           if (key.startsWith(lightOrDarkPrefix)) {
                              properties.put(key.substring(lightOrDarkPrefix.length()), properties.remove(key));
                           }
                        }

                        String platformPrefix = SystemInfo.IS_WINDOWS ? "[win]" : (SystemInfo.IS_MAC ? "[mac]" : (SystemInfo.IS_LINUX ? "[linux]" : "[unknown]"));
                        Iterator var37 = platformSpecificKeys.iterator();

                        while(var37.hasNext()) {
                           String key = (String)var37.next();
                           key = properties.remove(key);
                           if (key.startsWith(platformPrefix)) {
                              properties.put(key.substring(platformPrefix.length()), key);
                           }
                        }
                     }

                     Function propertiesGetter = (keyx) -> {
                        return properties.getProperty(keyx);
                     };
                     Function resolver = (valuex) -> {
                        return resolveValue(valuex, propertiesGetter);
                     };
                     HashMap globals = new HashMap();
                     Iterator var39 = properties.entrySet().iterator();

                     String key;
                     String value;
                     Entry e;
                     while(var39.hasNext()) {
                        e = (Entry)var39.next();
                        key = (String)e.getKey();
                        if (key.startsWith("*.")) {
                           value = resolveValue((String)e.getValue(), propertiesGetter);

                           try {
                              globals.put(key.substring("*.".length()), parseValue(key, value, (UIDefaultsLoader.ValueType[])null, resolver, addonClassLoaders));
                           } catch (RuntimeException var19) {
                              logParseError(Level.SEVERE, key, value, var19);
                           }
                        }
                     }

                     var39 = defaults.keySet().iterator();

                     while(var39.hasNext()) {
                        key = var39.next();
                        if (key instanceof String && ((String)key).contains(".")) {
                           key = (String)key;
                           value = key.substring(key.lastIndexOf(46) + 1);
                           Object globalValue = globals.get(value);
                           if (globalValue != null) {
                              defaults.put(key, globalValue);
                           }
                        }
                     }

                     var39 = properties.entrySet().iterator();

                     while(var39.hasNext()) {
                        e = (Entry)var39.next();
                        key = (String)e.getKey();
                        if (!key.startsWith("@") && !key.startsWith("*.")) {
                           value = resolveValue((String)e.getValue(), propertiesGetter);

                           try {
                              defaults.put(key, parseValue(key, value, (UIDefaultsLoader.ValueType[])null, resolver, addonClassLoaders));
                           } catch (RuntimeException var18) {
                              logParseError(Level.SEVERE, key, value, var18);
                           }
                        }
                     }
                     break label191;
                  }

                  Object okey = var27.next();
                  key = (String)okey;
               } while(!key.startsWith("["));
            } while(!key.startsWith("[win]") && !key.startsWith("[mac]") && !key.startsWith("[linux]") && !key.startsWith("[light]") && !key.startsWith("[dark]"));

            platformSpecificKeys.add(key);
         }
      } catch (IOException var22) {
         FlatLaf.LOG.log(Level.SEVERE, "FlatLaf: Failed to load properties files.", var22);
      }

   }

   static void logParseError(Level level, String key, String value, RuntimeException ex) {
      FlatLaf.LOG.log(level, "FlatLaf: Failed to parse: '" + key + '=' + value + '\'', ex);
   }

   static String resolveValue(String value, Function propertiesGetter) {
      value = value.trim();
      String value0 = value;
      if (value.startsWith("$")) {
         value = value.substring("$".length());
      } else if (!value.startsWith("@")) {
         return value;
      }

      boolean optional = false;
      if (value.startsWith("?")) {
         value = value.substring("?".length());
         optional = true;
      }

      String newValue = (String)propertiesGetter.apply(value);
      if (newValue == null) {
         if (optional) {
            return "null";
         } else {
            throw new IllegalArgumentException("variable or property '" + value + "' not found");
         }
      } else if (newValue.equals(value0)) {
         throw new IllegalArgumentException("endless recursion in variable or property '" + value + "'");
      } else {
         return resolveValue(newValue, propertiesGetter);
      }
   }

   static Object parseValue(String key, String value) {
      return parseValue(key, value, (UIDefaultsLoader.ValueType[])null, (v) -> {
         return v;
      }, Collections.emptyList());
   }

   static Object parseValue(String key, String value, UIDefaultsLoader.ValueType[] resultValueType, Function resolver, List addonClassLoaders) {
      if (resultValueType == null) {
         resultValueType = tempResultValueType;
      }

      value = value.trim();
      byte var6 = -1;
      switch(value.hashCode()) {
      case 3392903:
         if (value.equals("null")) {
            var6 = 0;
         }
         break;
      case 3569038:
         if (value.equals("true")) {
            var6 = 2;
         }
         break;
      case 97196323:
         if (value.equals("false")) {
            var6 = 1;
         }
      }

      switch(var6) {
      case 0:
         resultValueType[0] = UIDefaultsLoader.ValueType.NULL;
         return null;
      case 1:
         resultValueType[0] = UIDefaultsLoader.ValueType.BOOLEAN;
         return false;
      case 2:
         resultValueType[0] = UIDefaultsLoader.ValueType.BOOLEAN;
         return true;
      default:
         if (value.startsWith("lazy(") && value.endsWith(")")) {
            resultValueType[0] = UIDefaultsLoader.ValueType.LAZY;
            String uiKey = value.substring(5, value.length() - 1).trim();
            return (t) -> {
               return lazyUIManagerGet(uiKey);
            };
         } else {
            UIDefaultsLoader.ValueType valueType = UIDefaultsLoader.ValueType.UNKNOWN;
            if (value.startsWith("#")) {
               valueType = UIDefaultsLoader.ValueType.COLOR;
            } else if (value.startsWith("\"") && value.endsWith("\"")) {
               valueType = UIDefaultsLoader.ValueType.STRING;
               value = value.substring(1, value.length() - 1);
            } else if (value.startsWith("{")) {
               int end = value.indexOf("}");
               if (end != -1) {
                  try {
                     String typeStr = value.substring("{".length(), end);
                     valueType = UIDefaultsLoader.ValueType.valueOf(typeStr.toUpperCase(Locale.ENGLISH));
                     value = value.substring(end + "}".length());
                  } catch (IllegalArgumentException var9) {
                  }
               }
            }

            if (valueType == UIDefaultsLoader.ValueType.UNKNOWN) {
               if (!key.endsWith("ground") && !key.endsWith("Color")) {
                  if (!key.endsWith(".border") && !key.endsWith("Border")) {
                     if (!key.endsWith(".icon") && !key.endsWith("Icon")) {
                        if (!key.endsWith(".margin") && !key.endsWith(".padding") && !key.endsWith("Margins") && !key.endsWith("Insets")) {
                           if (key.endsWith("Size")) {
                              valueType = UIDefaultsLoader.ValueType.DIMENSION;
                           } else if (!key.endsWith("Width") && !key.endsWith("Height")) {
                              if (key.endsWith("Char")) {
                                 valueType = UIDefaultsLoader.ValueType.CHARACTER;
                              } else if (key.endsWith("UI")) {
                                 valueType = UIDefaultsLoader.ValueType.STRING;
                              } else if (key.endsWith("grayFilter")) {
                                 valueType = UIDefaultsLoader.ValueType.GRAYFILTER;
                              }
                           } else {
                              valueType = UIDefaultsLoader.ValueType.INTEGER;
                           }
                        } else {
                           valueType = UIDefaultsLoader.ValueType.INSETS;
                        }
                     } else {
                        valueType = UIDefaultsLoader.ValueType.ICON;
                     }
                  } else {
                     valueType = UIDefaultsLoader.ValueType.BORDER;
                  }
               } else {
                  valueType = UIDefaultsLoader.ValueType.COLOR;
               }
            }

            resultValueType[0] = valueType;
            switch(valueType) {
            case STRING:
               return value;
            case CHARACTER:
               return parseCharacter(value);
            case INTEGER:
               return parseInteger(value, true);
            case FLOAT:
               return parseFloat(value, true);
            case BORDER:
               return parseBorder(value, resolver, addonClassLoaders);
            case ICON:
               return parseInstance(value, addonClassLoaders);
            case INSETS:
               return parseInsets(value);
            case DIMENSION:
               return parseDimension(value);
            case COLOR:
               return parseColorOrFunction(value, resolver, true);
            case SCALEDINTEGER:
               return parseScaledInteger(value);
            case SCALEDFLOAT:
               return parseScaledFloat(value);
            case SCALEDINSETS:
               return parseScaledInsets(value);
            case SCALEDDIMENSION:
               return parseScaledDimension(value);
            case INSTANCE:
               return parseInstance(value, addonClassLoaders);
            case CLASS:
               return parseClass(value, addonClassLoaders);
            case GRAYFILTER:
               return parseGrayFilter(value);
            case UNKNOWN:
            default:
               Object color = parseColorOrFunction(value, resolver, false);
               if (color != null) {
                  resultValueType[0] = UIDefaultsLoader.ValueType.COLOR;
                  return color;
               } else {
                  Integer integer = parseInteger(value, false);
                  if (integer != null) {
                     resultValueType[0] = UIDefaultsLoader.ValueType.INTEGER;
                     return integer;
                  } else {
                     Float f = parseFloat(value, false);
                     if (f != null) {
                        resultValueType[0] = UIDefaultsLoader.ValueType.FLOAT;
                        return f;
                     } else {
                        resultValueType[0] = UIDefaultsLoader.ValueType.STRING;
                        return value;
                     }
                  }
               }
            }
         }
      }
   }

   private static Object parseBorder(String value, Function resolver, List addonClassLoaders) {
      if (value.indexOf(44) >= 0) {
         List parts = split(value, ',');
         Insets insets = parseInsets(value);
         ColorUIResource lineColor = parts.size() >= 5 ? (ColorUIResource)parseColorOrFunction((String)resolver.apply((String)parts.get(4)), resolver, true) : null;
         float lineThickness = parts.size() >= 6 ? parseFloat((String)parts.get(5), true) : 1.0F;
         return (t) -> {
            return lineColor != null ? new FlatLineBorder(insets, lineColor, lineThickness) : new FlatEmptyBorder(insets);
         };
      } else {
         return parseInstance(value, addonClassLoaders);
      }
   }

   private static Object parseInstance(String value, List addonClassLoaders) {
      return (t) -> {
         try {
            return findClass(value, addonClassLoaders).newInstance();
         } catch (IllegalAccessException | ClassNotFoundException | InstantiationException var4) {
            FlatLaf.LOG.log(Level.SEVERE, "FlatLaf: Failed to instantiate '" + value + "'.", var4);
            return null;
         }
      };
   }

   private static Object parseClass(String value, List addonClassLoaders) {
      return (t) -> {
         try {
            return findClass(value, addonClassLoaders);
         } catch (ClassNotFoundException var4) {
            FlatLaf.LOG.log(Level.SEVERE, "FlatLaf: Failed to find class '" + value + "'.", var4);
            return null;
         }
      };
   }

   private static Class findClass(String className, List addonClassLoaders) throws ClassNotFoundException {
      try {
         return Class.forName(className);
      } catch (ClassNotFoundException var7) {
         Iterator var3 = addonClassLoaders.iterator();

         while(var3.hasNext()) {
            ClassLoader addonClassLoader = (ClassLoader)var3.next();

            try {
               return addonClassLoader.loadClass(className);
            } catch (ClassNotFoundException var6) {
            }
         }

         throw var7;
      }
   }

   private static Insets parseInsets(String value) {
      List numbers = split(value, ',');

      try {
         return new InsetsUIResource(Integer.parseInt((String)numbers.get(0)), Integer.parseInt((String)numbers.get(1)), Integer.parseInt((String)numbers.get(2)), Integer.parseInt((String)numbers.get(3)));
      } catch (NumberFormatException var3) {
         throw new IllegalArgumentException("invalid insets '" + value + "'");
      }
   }

   private static Dimension parseDimension(String value) {
      List numbers = split(value, ',');

      try {
         return new DimensionUIResource(Integer.parseInt((String)numbers.get(0)), Integer.parseInt((String)numbers.get(1)));
      } catch (NumberFormatException var3) {
         throw new IllegalArgumentException("invalid size '" + value + "'");
      }
   }

   private static Object parseColorOrFunction(String value, Function resolver, boolean reportError) {
      return value.endsWith(")") ? parseColorFunctions(value, resolver, reportError) : parseColor(value, reportError);
   }

   static ColorUIResource parseColor(String value) {
      return parseColor(value, false);
   }

   private static ColorUIResource parseColor(String value, boolean reportError) {
      try {
         int rgba = parseColorRGBA(value);
         return (rgba & -16777216) == -16777216 ? new ColorUIResource(rgba) : new ColorUIResource(new Color(rgba, true));
      } catch (IllegalArgumentException var3) {
         if (reportError) {
            throw new IllegalArgumentException("invalid color '" + value + "'");
         } else {
            return null;
         }
      }
   }

   static int parseColorRGBA(String value) {
      int len = value.length();
      if ((len == 4 || len == 5 || len == 7 || len == 9) && value.charAt(0) == '#') {
         int n = 0;

         int n1;
         int digit;
         for(n1 = 1; n1 < len; ++n1) {
            char ch = value.charAt(n1);
            if (ch >= '0' && ch <= '9') {
               digit = ch - 48;
            } else if (ch >= 'a' && ch <= 'f') {
               digit = ch - 97 + 10;
            } else {
               if (ch < 'A' || ch > 'F') {
                  throw new IllegalArgumentException();
               }

               digit = ch - 65 + 10;
            }

            n = n << 4 | digit;
         }

         if (len <= 5) {
            n1 = n & '\uf000';
            int n2 = n & 3840;
            digit = n & 240;
            int n4 = n & 15;
            n = n1 << 16 | n1 << 12 | n2 << 12 | n2 << 8 | digit << 8 | digit << 4 | n4 << 4 | n4;
         }

         return len != 4 && len != 7 ? n >> 8 & 16777215 | (n & 255) << 24 : -16777216 | n;
      } else {
         throw new IllegalArgumentException();
      }
   }

   private static Object parseColorFunctions(String value, Function resolver, boolean reportError) {
      int paramsStart = value.indexOf(40);
      if (paramsStart < 0) {
         if (reportError) {
            throw new IllegalArgumentException("missing opening parenthesis in function '" + value + "'");
         } else {
            return null;
         }
      } else {
         String function = value.substring(0, paramsStart).trim();
         List params = splitFunctionParams(value.substring(paramsStart + 1, value.length() - 1), ',');
         if (params.isEmpty()) {
            throw new IllegalArgumentException("missing parameters in function '" + value + "'");
         } else {
            byte var7 = -1;
            switch(function.hashCode()) {
            case -2114203985:
               if (function.equals("saturate")) {
                  var7 = 6;
               }
               break;
            case -1338968417:
               if (function.equals("darken")) {
                  var7 = 5;
               }
               break;
            case 103617:
               if (function.equals("hsl")) {
                  var7 = 2;
               }
               break;
            case 112845:
               if (function.equals("rgb")) {
                  var7 = 0;
               }
               break;
            case 3212224:
               if (function.equals("hsla")) {
                  var7 = 3;
               }
               break;
            case 3498292:
               if (function.equals("rgba")) {
                  var7 = 1;
               }
               break;
            case 170546239:
               if (function.equals("lighten")) {
                  var7 = 4;
               }
               break;
            case 1839974960:
               if (function.equals("desaturate")) {
                  var7 = 7;
               }
            }

            switch(var7) {
            case 0:
               return parseColorRgbOrRgba(false, params, resolver, reportError);
            case 1:
               return parseColorRgbOrRgba(true, params, resolver, reportError);
            case 2:
               return parseColorHslOrHsla(false, params);
            case 3:
               return parseColorHslOrHsla(true, params);
            case 4:
               return parseColorHSLIncreaseDecrease(2, true, params, resolver, reportError);
            case 5:
               return parseColorHSLIncreaseDecrease(2, false, params, resolver, reportError);
            case 6:
               return parseColorHSLIncreaseDecrease(1, true, params, resolver, reportError);
            case 7:
               return parseColorHSLIncreaseDecrease(1, false, params, resolver, reportError);
            default:
               throw new IllegalArgumentException("unknown color function '" + value + "'");
            }
         }
      }
   }

   private static ColorUIResource parseColorRgbOrRgba(boolean hasAlpha, List params, Function resolver, boolean reportError) {
      int green;
      if (hasAlpha && params.size() == 2) {
         String colorStr = (String)params.get(0);
         green = parseInteger((String)params.get(1), 0, 255, true);
         ColorUIResource color = (ColorUIResource)parseColorOrFunction((String)resolver.apply(colorStr), resolver, reportError);
         return new ColorUIResource(new Color((green & 255) << 24 | color.getRGB() & 16777215, true));
      } else {
         int red = parseInteger((String)params.get(0), 0, 255, true);
         green = parseInteger((String)params.get(1), 0, 255, true);
         int blue = parseInteger((String)params.get(2), 0, 255, true);
         int alpha = hasAlpha ? parseInteger((String)params.get(3), 0, 255, true) : 255;
         return hasAlpha ? new ColorUIResource(new Color(red, green, blue, alpha)) : new ColorUIResource(red, green, blue);
      }
   }

   private static ColorUIResource parseColorHslOrHsla(boolean hasAlpha, List params) {
      int hue = parseInteger((String)params.get(0), 0, 360, false);
      int saturation = parsePercentage((String)params.get(1));
      int lightness = parsePercentage((String)params.get(2));
      int alpha = hasAlpha ? parsePercentage((String)params.get(3)) : 100;
      float[] hsl = new float[]{(float)hue, (float)saturation, (float)lightness};
      return new ColorUIResource(HSLColor.toRGB(hsl, (float)alpha / 100.0F));
   }

   private static Object parseColorHSLIncreaseDecrease(int hslIndex, boolean increase, List params, Function resolver, boolean reportError) {
      String colorStr = (String)params.get(0);
      int amount = parsePercentage((String)params.get(1));
      boolean relative = false;
      boolean autoInverse = false;
      boolean lazy = false;
      boolean derived = false;
      if (params.size() > 2) {
         String options = (String)params.get(2);
         relative = options.contains("relative");
         autoInverse = options.contains("autoInverse");
         lazy = options.contains("lazy");
         derived = options.contains("derived");
         if (derived && !options.contains("noAutoInverse")) {
            autoInverse = true;
         }
      }

      ColorFunctions.ColorFunction function = new ColorFunctions.HSLIncreaseDecrease(hslIndex, increase, (float)amount, relative, autoInverse);
      if (lazy) {
         return (t) -> {
            Object color = lazyUIManagerGet(colorStr);
            return color instanceof Color ? new ColorUIResource(ColorFunctions.applyFunctions((Color)color, function)) : null;
         };
      } else {
         String resolvedColorStr = (String)resolver.apply(colorStr);
         ColorUIResource baseColor = (ColorUIResource)parseColorOrFunction(resolvedColorStr, resolver, reportError);
         Color newColor = ColorFunctions.applyFunctions(baseColor, function);
         if (!derived) {
            return new ColorUIResource(newColor);
         } else {
            ColorFunctions.ColorFunction[] functions;
            if (baseColor instanceof DerivedColor && resolvedColorStr == colorStr) {
               ColorFunctions.ColorFunction[] baseFunctions = ((DerivedColor)baseColor).getFunctions();
               functions = new ColorFunctions.ColorFunction[baseFunctions.length + 1];
               System.arraycopy(baseFunctions, 0, functions, 0, baseFunctions.length);
               functions[baseFunctions.length] = function;
            } else {
               functions = new ColorFunctions.ColorFunction[]{function};
            }

            return new DerivedColor(newColor, functions);
         }
      }
   }

   private static int parsePercentage(String value) {
      if (!value.endsWith("%")) {
         throw new NumberFormatException("invalid percentage '" + value + "'");
      } else {
         int val;
         try {
            val = Integer.parseInt(value.substring(0, value.length() - 1));
         } catch (NumberFormatException var3) {
            throw new NumberFormatException("invalid percentage '" + value + "'");
         }

         if (val >= 0 && val <= 100) {
            return val;
         } else {
            throw new IllegalArgumentException("percentage out of range (0-100%) '" + value + "'");
         }
      }
   }

   private static Character parseCharacter(String value) {
      if (value.length() != 1) {
         throw new IllegalArgumentException("invalid character '" + value + "'");
      } else {
         return value.charAt(0);
      }
   }

   private static Integer parseInteger(String value, int min, int max, boolean allowPercentage) {
      if (allowPercentage && value.endsWith("%")) {
         int percent = parsePercentage(value);
         return max * percent / 100;
      } else {
         Integer integer = parseInteger(value, true);
         if (integer >= min && integer <= max) {
            return integer;
         } else {
            throw new NumberFormatException("integer '" + value + "' out of range (" + min + '-' + max + ')');
         }
      }
   }

   private static Integer parseInteger(String value, boolean reportError) {
      try {
         return Integer.parseInt(value);
      } catch (NumberFormatException var3) {
         if (reportError) {
            throw new NumberFormatException("invalid integer '" + value + "'");
         } else {
            return null;
         }
      }
   }

   private static Float parseFloat(String value, boolean reportError) {
      try {
         return Float.parseFloat(value);
      } catch (NumberFormatException var3) {
         if (reportError) {
            throw new NumberFormatException("invalid float '" + value + "'");
         } else {
            return null;
         }
      }
   }

   private static ActiveValue parseScaledInteger(String value) {
      int val = parseInteger(value, true);
      return (t) -> {
         return UIScale.scale(val);
      };
   }

   private static ActiveValue parseScaledFloat(String value) {
      float val = parseFloat(value, true);
      return (t) -> {
         return UIScale.scale(val);
      };
   }

   private static ActiveValue parseScaledInsets(String value) {
      Insets insets = parseInsets(value);
      return (t) -> {
         return UIScale.scale(insets);
      };
   }

   private static ActiveValue parseScaledDimension(String value) {
      Dimension dimension = parseDimension(value);
      return (t) -> {
         return UIScale.scale(dimension);
      };
   }

   private static Object parseGrayFilter(String value) {
      List numbers = split(value, ',');

      try {
         int brightness = Integer.parseInt((String)numbers.get(0));
         int contrast = Integer.parseInt((String)numbers.get(1));
         int alpha = Integer.parseInt((String)numbers.get(2));
         return (t) -> {
            return new GrayFilter(brightness, contrast, alpha);
         };
      } catch (NumberFormatException var5) {
         throw new IllegalArgumentException("invalid gray filter '" + value + "'");
      }
   }

   private static List split(String str, char delim) {
      List result = StringUtils.split(str, delim);
      int size = result.size();

      for(int i = 0; i < size; ++i) {
         result.set(i, ((String)result.get(i)).trim());
      }

      return result;
   }

   private static List splitFunctionParams(String str, char delim) {
      ArrayList strs = new ArrayList();
      int nestLevel = 0;
      int start = 0;
      int strlen = str.length();

      for(int i = 0; i < strlen; ++i) {
         char ch = str.charAt(i);
         if (ch == '(') {
            ++nestLevel;
         } else if (ch == ')') {
            --nestLevel;
         } else if (nestLevel == 0 && ch == delim) {
            strs.add(str.substring(start, i).trim());
            start = i + 1;
         }
      }

      strs.add(str.substring(start).trim());
      return strs;
   }

   private static Object lazyUIManagerGet(String uiKey) {
      boolean optional = false;
      if (uiKey.startsWith("?")) {
         uiKey = uiKey.substring("?".length());
         optional = true;
      }

      Object value = UIManager.get(uiKey);
      if (value == null && !optional) {
         FlatLaf.LOG.log(Level.SEVERE, "FlatLaf: '" + uiKey + "' not found in UI defaults.");
      }

      return value;
   }

   static enum ValueType {
      UNKNOWN,
      STRING,
      BOOLEAN,
      CHARACTER,
      INTEGER,
      FLOAT,
      BORDER,
      ICON,
      INSETS,
      DIMENSION,
      COLOR,
      SCALEDINTEGER,
      SCALEDFLOAT,
      SCALEDINSETS,
      SCALEDDIMENSION,
      INSTANCE,
      CLASS,
      GRAYFILTER,
      NULL,
      LAZY;
   }
}
