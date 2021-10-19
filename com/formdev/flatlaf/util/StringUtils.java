package com.formdev.flatlaf.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
   public static String removeLeading(String string, String leading) {
      return string.startsWith(leading) ? string.substring(leading.length()) : string;
   }

   public static String removeTrailing(String string, String trailing) {
      return string.endsWith(trailing) ? string.substring(0, string.length() - trailing.length()) : string;
   }

   public static List split(String str, char delim) {
      ArrayList strs = new ArrayList();
      int delimIndex = str.indexOf(delim);

      int index;
      for(index = 0; delimIndex >= 0; delimIndex = str.indexOf(delim, index)) {
         strs.add(str.substring(index, delimIndex));
         index = delimIndex + 1;
      }

      strs.add(str.substring(index));
      return strs;
   }
}
