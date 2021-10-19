package com.sun.jna;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Union extends Structure {
   private Structure.StructField activeField;

   protected Union() {
   }

   protected Union(Pointer p) {
      super(p);
   }

   protected Union(Pointer p, int alignType) {
      super(p, alignType);
   }

   protected Union(TypeMapper mapper) {
      super(mapper);
   }

   protected Union(Pointer p, int alignType, TypeMapper mapper) {
      super(p, alignType, mapper);
   }

   protected List getFieldOrder() {
      List flist = this.getFieldList();
      List list = new ArrayList(flist.size());
      Iterator var3 = flist.iterator();

      while(var3.hasNext()) {
         Field f = (Field)var3.next();
         list.add(f.getName());
      }

      return list;
   }

   public void setType(Class type) {
      this.ensureAllocated();
      Iterator var2 = this.fields().values().iterator();

      Structure.StructField f;
      do {
         if (!var2.hasNext()) {
            throw new IllegalArgumentException("No field of type " + type + " in " + this);
         }

         f = (Structure.StructField)var2.next();
      } while(f.type != type);

      this.activeField = f;
   }

   public void setType(String fieldName) {
      this.ensureAllocated();
      Structure.StructField f = (Structure.StructField)this.fields().get(fieldName);
      if (f != null) {
         this.activeField = f;
      } else {
         throw new IllegalArgumentException("No field named " + fieldName + " in " + this);
      }
   }

   public Object readField(String fieldName) {
      this.ensureAllocated();
      this.setType(fieldName);
      return super.readField(fieldName);
   }

   public void writeField(String fieldName) {
      this.ensureAllocated();
      this.setType(fieldName);
      super.writeField(fieldName);
   }

   public void writeField(String fieldName, Object value) {
      this.ensureAllocated();
      this.setType(fieldName);
      super.writeField(fieldName, value);
   }

   public Object getTypedValue(Class type) {
      this.ensureAllocated();
      Iterator var2 = this.fields().values().iterator();

      Structure.StructField f;
      do {
         if (!var2.hasNext()) {
            throw new IllegalArgumentException("No field of type " + type + " in " + this);
         }

         f = (Structure.StructField)var2.next();
      } while(f.type != type);

      this.activeField = f;
      this.read();
      return this.getFieldValue(this.activeField.field);
   }

   public Object setTypedValue(Object object) {
      Structure.StructField f = this.findField(object.getClass());
      if (f != null) {
         this.activeField = f;
         this.setFieldValue(f.field, object);
         return this;
      } else {
         throw new IllegalArgumentException("No field of type " + object.getClass() + " in " + this);
      }
   }

   private Structure.StructField findField(Class type) {
      this.ensureAllocated();
      Iterator var2 = this.fields().values().iterator();

      Structure.StructField f;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         f = (Structure.StructField)var2.next();
      } while(!f.type.isAssignableFrom(type));

      return f;
   }

   protected void writeField(Structure.StructField field) {
      if (field == this.activeField) {
         super.writeField(field);
      }

   }

   protected Object readField(Structure.StructField field) {
      return field != this.activeField && (Structure.class.isAssignableFrom(field.type) || String.class.isAssignableFrom(field.type) || WString.class.isAssignableFrom(field.type)) ? null : super.readField(field);
   }

   protected int getNativeAlignment(Class type, Object value, boolean isFirstElement) {
      return super.getNativeAlignment(type, value, true);
   }
}
