package com.sun.jna.win32;

import com.sun.jna.DefaultTypeMapper;
import com.sun.jna.FromNativeContext;
import com.sun.jna.StringArray;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;
import com.sun.jna.TypeMapper;
import com.sun.jna.WString;

public class W32APITypeMapper extends DefaultTypeMapper {
   public static final TypeMapper UNICODE = new W32APITypeMapper(true);
   public static final TypeMapper ASCII = new W32APITypeMapper(false);
   public static final TypeMapper DEFAULT;

   protected W32APITypeMapper(boolean unicode) {
      TypeConverter booleanConverter;
      if (unicode) {
         booleanConverter = new TypeConverter() {
            public Object toNative(Object value, ToNativeContext context) {
               if (value == null) {
                  return null;
               } else {
                  return value instanceof String[] ? new StringArray((String[])((String[])value), true) : new WString(value.toString());
               }
            }

            public Object fromNative(Object value, FromNativeContext context) {
               return value == null ? null : value.toString();
            }

            public Class nativeType() {
               return WString.class;
            }
         };
         this.addTypeConverter(String.class, booleanConverter);
         this.addToNativeConverter(String[].class, booleanConverter);
      }

      booleanConverter = new TypeConverter() {
         public Object toNative(Object value, ToNativeContext context) {
            return Boolean.TRUE.equals(value) ? 1 : 0;
         }

         public Object fromNative(Object value, FromNativeContext context) {
            return (Integer)value != 0 ? Boolean.TRUE : Boolean.FALSE;
         }

         public Class nativeType() {
            return Integer.class;
         }
      };
      this.addTypeConverter(Boolean.class, booleanConverter);
   }

   static {
      DEFAULT = Boolean.getBoolean("w32.ascii") ? ASCII : UNICODE;
   }
}
