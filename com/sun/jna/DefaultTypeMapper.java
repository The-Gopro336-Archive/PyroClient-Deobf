package com.sun.jna;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DefaultTypeMapper implements TypeMapper {
   private List toNativeConverters = new ArrayList();
   private List fromNativeConverters = new ArrayList();

   private Class getAltClass(Class cls) {
      if (cls == Boolean.class) {
         return Boolean.TYPE;
      } else if (cls == Boolean.TYPE) {
         return Boolean.class;
      } else if (cls == Byte.class) {
         return Byte.TYPE;
      } else if (cls == Byte.TYPE) {
         return Byte.class;
      } else if (cls == Character.class) {
         return Character.TYPE;
      } else if (cls == Character.TYPE) {
         return Character.class;
      } else if (cls == Short.class) {
         return Short.TYPE;
      } else if (cls == Short.TYPE) {
         return Short.class;
      } else if (cls == Integer.class) {
         return Integer.TYPE;
      } else if (cls == Integer.TYPE) {
         return Integer.class;
      } else if (cls == Long.class) {
         return Long.TYPE;
      } else if (cls == Long.TYPE) {
         return Long.class;
      } else if (cls == Float.class) {
         return Float.TYPE;
      } else if (cls == Float.TYPE) {
         return Float.class;
      } else if (cls == Double.class) {
         return Double.TYPE;
      } else {
         return cls == Double.TYPE ? Double.class : null;
      }
   }

   public void addToNativeConverter(Class cls, ToNativeConverter converter) {
      this.toNativeConverters.add(new DefaultTypeMapper.Entry(cls, converter));
      Class alt = this.getAltClass(cls);
      if (alt != null) {
         this.toNativeConverters.add(new DefaultTypeMapper.Entry(alt, converter));
      }

   }

   public void addFromNativeConverter(Class cls, FromNativeConverter converter) {
      this.fromNativeConverters.add(new DefaultTypeMapper.Entry(cls, converter));
      Class alt = this.getAltClass(cls);
      if (alt != null) {
         this.fromNativeConverters.add(new DefaultTypeMapper.Entry(alt, converter));
      }

   }

   public void addTypeConverter(Class cls, TypeConverter converter) {
      this.addFromNativeConverter(cls, converter);
      this.addToNativeConverter(cls, converter);
   }

   private Object lookupConverter(Class javaClass, Collection converters) {
      Iterator var3 = converters.iterator();

      DefaultTypeMapper.Entry entry;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         entry = (DefaultTypeMapper.Entry)var3.next();
      } while(!entry.type.isAssignableFrom(javaClass));

      return entry.converter;
   }

   public FromNativeConverter getFromNativeConverter(Class javaType) {
      return (FromNativeConverter)this.lookupConverter(javaType, this.fromNativeConverters);
   }

   public ToNativeConverter getToNativeConverter(Class javaType) {
      return (ToNativeConverter)this.lookupConverter(javaType, this.toNativeConverters);
   }

   private static class Entry {
      public Class type;
      public Object converter;

      public Entry(Class type, Object converter) {
         this.type = type;
         this.converter = converter;
      }
   }
}
