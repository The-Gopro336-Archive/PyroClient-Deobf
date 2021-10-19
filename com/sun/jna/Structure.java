package com.sun.jna;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class Structure {
   public static final int ALIGN_DEFAULT = 0;
   public static final int ALIGN_NONE = 1;
   public static final int ALIGN_GNUC = 2;
   public static final int ALIGN_MSVC = 3;
   protected static final int CALCULATE_SIZE = -1;
   static final Map layoutInfo = new WeakHashMap();
   static final Map fieldOrder = new WeakHashMap();
   private Pointer memory;
   private int size;
   private int alignType;
   private String encoding;
   private int actualAlignType;
   private int structAlignment;
   private Map structFields;
   private final Map nativeStrings;
   private TypeMapper typeMapper;
   private long typeInfo;
   private boolean autoRead;
   private boolean autoWrite;
   private Structure[] array;
   private boolean readCalled;
   private static final ThreadLocal reads = new ThreadLocal() {
      protected synchronized Map initialValue() {
         return new HashMap();
      }
   };
   private static final ThreadLocal busy = new ThreadLocal() {
      protected synchronized Set initialValue() {
         return new Structure.StructureSet();
      }
   };
   private static final Pointer PLACEHOLDER_MEMORY = new Pointer(0L) {
      public Pointer share(long offset, long sz) {
         return this;
      }
   };

   protected Structure() {
      this(0);
   }

   protected Structure(TypeMapper mapper) {
      this((Pointer)null, 0, mapper);
   }

   protected Structure(int alignType) {
      this((Pointer)null, alignType);
   }

   protected Structure(int alignType, TypeMapper mapper) {
      this((Pointer)null, alignType, mapper);
   }

   protected Structure(Pointer p) {
      this(p, 0);
   }

   protected Structure(Pointer p, int alignType) {
      this(p, alignType, (TypeMapper)null);
   }

   protected Structure(Pointer p, int alignType, TypeMapper mapper) {
      this.size = -1;
      this.nativeStrings = new HashMap();
      this.autoRead = true;
      this.autoWrite = true;
      this.setAlignType(alignType);
      this.setStringEncoding(Native.getStringEncoding(this.getClass()));
      this.initializeTypeMapper(mapper);
      this.validateFields();
      if (p != null) {
         this.useMemory(p, 0, true);
      } else {
         this.allocateMemory(-1);
      }

      this.initializeFields();
   }

   Map fields() {
      return this.structFields;
   }

   TypeMapper getTypeMapper() {
      return this.typeMapper;
   }

   private void initializeTypeMapper(TypeMapper mapper) {
      if (mapper == null) {
         mapper = Native.getTypeMapper(this.getClass());
      }

      this.typeMapper = mapper;
      this.layoutChanged();
   }

   private void layoutChanged() {
      if (this.size != -1) {
         this.size = -1;
         if (this.memory instanceof Structure.AutoAllocated) {
            this.memory = null;
         }

         this.ensureAllocated();
      }

   }

   protected void setStringEncoding(String encoding) {
      this.encoding = encoding;
   }

   protected String getStringEncoding() {
      return this.encoding;
   }

   protected void setAlignType(int alignType) {
      this.alignType = alignType;
      if (alignType == 0) {
         alignType = Native.getStructureAlignment(this.getClass());
         if (alignType == 0) {
            if (Platform.isWindows()) {
               alignType = 3;
            } else {
               alignType = 2;
            }
         }
      }

      this.actualAlignType = alignType;
      this.layoutChanged();
   }

   protected Memory autoAllocate(int size) {
      return new Structure.AutoAllocated(size);
   }

   protected void useMemory(Pointer m) {
      this.useMemory(m, 0);
   }

   protected void useMemory(Pointer m, int offset) {
      this.useMemory(m, offset, false);
   }

   void useMemory(Pointer m, int offset, boolean force) {
      try {
         this.nativeStrings.clear();
         if (this instanceof Structure.ByValue && !force) {
            byte[] buf = new byte[this.size()];
            m.read(0L, (byte[])buf, 0, buf.length);
            this.memory.write(0L, (byte[])buf, 0, buf.length);
         } else {
            this.memory = m.share((long)offset);
            if (this.size == -1) {
               this.size = this.calculateSize(false);
            }

            if (this.size != -1) {
               this.memory = m.share((long)offset, (long)this.size);
            }
         }

         this.array = null;
         this.readCalled = false;
      } catch (IndexOutOfBoundsException var5) {
         throw new IllegalArgumentException("Structure exceeds provided memory bounds", var5);
      }
   }

   protected void ensureAllocated() {
      this.ensureAllocated(false);
   }

   private void ensureAllocated(boolean avoidFFIType) {
      if (this.memory == null) {
         this.allocateMemory(avoidFFIType);
      } else if (this.size == -1) {
         this.size = this.calculateSize(true, avoidFFIType);
         if (!(this.memory instanceof Structure.AutoAllocated)) {
            try {
               this.memory = this.memory.share(0L, (long)this.size);
            } catch (IndexOutOfBoundsException var3) {
               throw new IllegalArgumentException("Structure exceeds provided memory bounds", var3);
            }
         }
      }

   }

   protected void allocateMemory() {
      this.allocateMemory(false);
   }

   private void allocateMemory(boolean avoidFFIType) {
      this.allocateMemory(this.calculateSize(true, avoidFFIType));
   }

   protected void allocateMemory(int size) {
      if (size == -1) {
         size = this.calculateSize(false);
      } else if (size <= 0) {
         throw new IllegalArgumentException("Structure size must be greater than zero: " + size);
      }

      if (size != -1) {
         if (this.memory == null || this.memory instanceof Structure.AutoAllocated) {
            this.memory = this.autoAllocate(size);
         }

         this.size = size;
      }

   }

   public int size() {
      this.ensureAllocated();
      return this.size;
   }

   public void clear() {
      this.ensureAllocated();
      this.memory.clear((long)this.size());
   }

   public Pointer getPointer() {
      this.ensureAllocated();
      return this.memory;
   }

   static Set busy() {
      return (Set)busy.get();
   }

   static Map reading() {
      return (Map)reads.get();
   }

   void conditionalAutoRead() {
      if (!this.readCalled) {
         this.autoRead();
      }

   }

   public void read() {
      if (this.memory != PLACEHOLDER_MEMORY) {
         this.readCalled = true;
         this.ensureAllocated();
         if (!busy().contains(this)) {
            busy().add(this);
            if (this instanceof Structure.ByReference) {
               reading().put(this.getPointer(), this);
            }

            try {
               Iterator var1 = this.fields().values().iterator();

               while(var1.hasNext()) {
                  Structure.StructField structField = (Structure.StructField)var1.next();
                  this.readField(structField);
               }
            } finally {
               busy().remove(this);
               if (reading().get(this.getPointer()) == this) {
                  reading().remove(this.getPointer());
               }

            }

         }
      }
   }

   protected int fieldOffset(String name) {
      this.ensureAllocated();
      Structure.StructField f = (Structure.StructField)this.fields().get(name);
      if (f == null) {
         throw new IllegalArgumentException("No such field: " + name);
      } else {
         return f.offset;
      }
   }

   public Object readField(String name) {
      this.ensureAllocated();
      Structure.StructField f = (Structure.StructField)this.fields().get(name);
      if (f == null) {
         throw new IllegalArgumentException("No such field: " + name);
      } else {
         return this.readField(f);
      }
   }

   Object getFieldValue(Field field) {
      try {
         return field.get(this);
      } catch (Exception var3) {
         throw new Error("Exception reading field '" + field.getName() + "' in " + this.getClass(), var3);
      }
   }

   void setFieldValue(Field field, Object value) {
      this.setFieldValue(field, value, false);
   }

   private void setFieldValue(Field field, Object value, boolean overrideFinal) {
      try {
         field.set(this, value);
      } catch (IllegalAccessException var6) {
         int modifiers = field.getModifiers();
         if (Modifier.isFinal(modifiers)) {
            if (overrideFinal) {
               throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + field.getName() + "' within " + this.getClass() + ")", var6);
            } else {
               throw new UnsupportedOperationException("Attempt to write to read-only field '" + field.getName() + "' within " + this.getClass(), var6);
            }
         } else {
            throw new Error("Unexpectedly unable to write to field '" + field.getName() + "' within " + this.getClass(), var6);
         }
      }
   }

   static Structure updateStructureByReference(Class type, Structure s, Pointer address) {
      if (address == null) {
         s = null;
      } else if (s != null && address.equals(s.getPointer())) {
         s.autoRead();
      } else {
         Structure s1 = (Structure)reading().get(address);
         if (s1 != null && type.equals(s1.getClass())) {
            s = s1;
            s1.autoRead();
         } else {
            s = newInstance(type, address);
            s.conditionalAutoRead();
         }
      }

      return s;
   }

   protected Object readField(Structure.StructField structField) {
      int offset = structField.offset;
      Class fieldType = structField.type;
      FromNativeConverter readConverter = structField.readConverter;
      if (readConverter != null) {
         fieldType = readConverter.nativeType();
      }

      Object currentValue = !Structure.class.isAssignableFrom(fieldType) && !Callback.class.isAssignableFrom(fieldType) && (!Platform.HAS_BUFFERS || !Buffer.class.isAssignableFrom(fieldType)) && !Pointer.class.isAssignableFrom(fieldType) && !NativeMapped.class.isAssignableFrom(fieldType) && !fieldType.isArray() ? null : this.getFieldValue(structField.field);
      Object result;
      if (fieldType == String.class) {
         Pointer p = this.memory.getPointer((long)offset);
         result = p == null ? null : p.getString(0L, this.encoding);
      } else {
         result = this.memory.getValue((long)offset, fieldType, currentValue);
      }

      if (readConverter != null) {
         result = readConverter.fromNative(result, structField.context);
         if (currentValue != null && currentValue.equals(result)) {
            result = currentValue;
         }
      }

      if (fieldType.equals(String.class) || fieldType.equals(WString.class)) {
         this.nativeStrings.put(structField.name + ".ptr", this.memory.getPointer((long)offset));
         this.nativeStrings.put(structField.name + ".val", result);
      }

      this.setFieldValue(structField.field, result, true);
      return result;
   }

   public void write() {
      if (this.memory != PLACEHOLDER_MEMORY) {
         this.ensureAllocated();
         if (this instanceof Structure.ByValue) {
            this.getTypeInfo();
         }

         if (!busy().contains(this)) {
            busy().add(this);

            try {
               Iterator var1 = this.fields().values().iterator();

               while(var1.hasNext()) {
                  Structure.StructField sf = (Structure.StructField)var1.next();
                  if (!sf.isVolatile) {
                     this.writeField(sf);
                  }
               }
            } finally {
               busy().remove(this);
            }

         }
      }
   }

   public void writeField(String name) {
      this.ensureAllocated();
      Structure.StructField f = (Structure.StructField)this.fields().get(name);
      if (f == null) {
         throw new IllegalArgumentException("No such field: " + name);
      } else {
         this.writeField(f);
      }
   }

   public void writeField(String name, Object value) {
      this.ensureAllocated();
      Structure.StructField structField = (Structure.StructField)this.fields().get(name);
      if (structField == null) {
         throw new IllegalArgumentException("No such field: " + name);
      } else {
         this.setFieldValue(structField.field, value);
         this.writeField(structField);
      }
   }

   protected void writeField(Structure.StructField structField) {
      if (!structField.isReadOnly) {
         int offset = structField.offset;
         Object value = this.getFieldValue(structField.field);
         Class fieldType = structField.type;
         ToNativeConverter converter = structField.writeConverter;
         if (converter != null) {
            value = converter.toNative(value, new StructureWriteContext(this, structField.field));
            fieldType = converter.nativeType();
         }

         if (String.class == fieldType || WString.class == fieldType) {
            boolean wide = fieldType == WString.class;
            if (value != null) {
               if (this.nativeStrings.containsKey(structField.name + ".ptr") && value.equals(this.nativeStrings.get(structField.name + ".val"))) {
                  return;
               }

               NativeString nativeString = wide ? new NativeString(value.toString(), true) : new NativeString(value.toString(), this.encoding);
               this.nativeStrings.put(structField.name, nativeString);
               value = nativeString.getPointer();
            } else {
               this.nativeStrings.remove(structField.name);
            }

            this.nativeStrings.remove(structField.name + ".ptr");
            this.nativeStrings.remove(structField.name + ".val");
         }

         try {
            this.memory.setValue((long)offset, value, fieldType);
         } catch (IllegalArgumentException var8) {
            String msg = "Structure field \"" + structField.name + "\" was declared as " + structField.type + (structField.type == fieldType ? "" : " (native type " + fieldType + ")") + ", which is not supported within a Structure";
            throw new IllegalArgumentException(msg, var8);
         }
      }
   }

   protected abstract List getFieldOrder();

   /** @deprecated */
   @Deprecated
   protected final void setFieldOrder(String[] fields) {
      throw new Error("This method is obsolete, use getFieldOrder() instead");
   }

   protected void sortFields(List fields, List names) {
      for(int i = 0; i < names.size(); ++i) {
         String name = (String)names.get(i);

         for(int f = 0; f < fields.size(); ++f) {
            Field field = (Field)fields.get(f);
            if (name.equals(field.getName())) {
               Collections.swap(fields, i, f);
               break;
            }
         }
      }

   }

   protected List getFieldList() {
      List flist = new ArrayList();

      for(Class cls = this.getClass(); !cls.equals(Structure.class); cls = cls.getSuperclass()) {
         List classFields = new ArrayList();
         Field[] fields = cls.getDeclaredFields();

         for(int i = 0; i < fields.length; ++i) {
            int modifiers = fields[i].getModifiers();
            if (!Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
               classFields.add(fields[i]);
            }
         }

         flist.addAll(0, classFields);
      }

      return flist;
   }

   private List fieldOrder() {
      Class clazz = this.getClass();
      synchronized(fieldOrder) {
         List list = (List)fieldOrder.get(clazz);
         if (list == null) {
            list = this.getFieldOrder();
            fieldOrder.put(clazz, list);
         }

         return list;
      }
   }

   public static List createFieldsOrder(List baseFields, String... extraFields) {
      return createFieldsOrder(baseFields, Arrays.asList(extraFields));
   }

   public static List createFieldsOrder(List baseFields, List extraFields) {
      List fields = new ArrayList(baseFields.size() + extraFields.size());
      fields.addAll(baseFields);
      fields.addAll(extraFields);
      return Collections.unmodifiableList(fields);
   }

   public static List createFieldsOrder(String field) {
      return Collections.unmodifiableList(Collections.singletonList(field));
   }

   public static List createFieldsOrder(String... fields) {
      return Collections.unmodifiableList(Arrays.asList(fields));
   }

   private static List sort(Collection c) {
      List list = new ArrayList(c);
      Collections.sort(list);
      return list;
   }

   protected List getFields(boolean force) {
      List flist = this.getFieldList();
      Set names = new HashSet();
      Iterator var4 = flist.iterator();

      while(var4.hasNext()) {
         Field f = (Field)var4.next();
         names.add(f.getName());
      }

      List fieldOrder = this.fieldOrder();
      if (fieldOrder.size() != flist.size() && flist.size() > 1) {
         if (force) {
            throw new Error("Structure.getFieldOrder() on " + this.getClass() + " does not provide enough names [" + fieldOrder.size() + "] (" + sort(fieldOrder) + ") to match declared fields [" + flist.size() + "] (" + sort(names) + ")");
         } else {
            return null;
         }
      } else {
         Set orderedNames = new HashSet(fieldOrder);
         if (!orderedNames.equals(names)) {
            throw new Error("Structure.getFieldOrder() on " + this.getClass() + " returns names (" + sort(fieldOrder) + ") which do not match declared field names (" + sort(names) + ")");
         } else {
            this.sortFields(flist, fieldOrder);
            return flist;
         }
      }
   }

   protected int calculateSize(boolean force) {
      return this.calculateSize(force, false);
   }

   static int size(Class type) {
      return size(type, (Structure)null);
   }

   static int size(Class type, Structure value) {
      Structure.LayoutInfo info;
      synchronized(layoutInfo) {
         info = (Structure.LayoutInfo)layoutInfo.get(type);
      }

      int sz = info != null && !info.variable ? info.size : -1;
      if (sz == -1) {
         if (value == null) {
            value = newInstance(type, PLACEHOLDER_MEMORY);
         }

         sz = value.size();
      }

      return sz;
   }

   int calculateSize(boolean force, boolean avoidFFIType) {
      int size = -1;
      Class clazz = this.getClass();
      Structure.LayoutInfo info;
      synchronized(layoutInfo) {
         info = (Structure.LayoutInfo)layoutInfo.get(clazz);
      }

      if (info == null || this.alignType != info.alignType || this.typeMapper != info.typeMapper) {
         info = this.deriveLayout(force, avoidFFIType);
      }

      if (info != null) {
         this.structAlignment = info.alignment;
         this.structFields = info.fields;
         if (!info.variable) {
            synchronized(layoutInfo) {
               if (!layoutInfo.containsKey(clazz) || this.alignType != 0 || this.typeMapper != null) {
                  layoutInfo.put(clazz, info);
               }
            }
         }

         size = info.size;
      }

      return size;
   }

   private void validateField(String name, Class type) {
      if (this.typeMapper != null) {
         ToNativeConverter toNative = this.typeMapper.getToNativeConverter(type);
         if (toNative != null) {
            this.validateField(name, toNative.nativeType());
            return;
         }
      }

      if (type.isArray()) {
         this.validateField(name, type.getComponentType());
      } else {
         try {
            this.getNativeSize(type);
         } catch (IllegalArgumentException var5) {
            String msg = "Invalid Structure field in " + this.getClass() + ", field name '" + name + "' (" + type + "): " + var5.getMessage();
            throw new IllegalArgumentException(msg, var5);
         }
      }

   }

   private void validateFields() {
      List fields = this.getFieldList();
      Iterator var2 = fields.iterator();

      while(var2.hasNext()) {
         Field f = (Field)var2.next();
         this.validateField(f.getName(), f.getType());
      }

   }

   private Structure.LayoutInfo deriveLayout(boolean force, boolean avoidFFIType) {
      int calculatedSize = 0;
      List fields = this.getFields(force);
      if (fields == null) {
         return null;
      } else {
         Structure.LayoutInfo info = new Structure.LayoutInfo();
         info.alignType = this.alignType;
         info.typeMapper = this.typeMapper;
         boolean firstField = true;

         for(Iterator i = fields.iterator(); i.hasNext(); firstField = false) {
            Field field = (Field)i.next();
            int modifiers = field.getModifiers();
            Class type = field.getType();
            if (type.isArray()) {
               info.variable = true;
            }

            Structure.StructField structField = new Structure.StructField();
            structField.isVolatile = Modifier.isVolatile(modifiers);
            structField.isReadOnly = Modifier.isFinal(modifiers);
            if (structField.isReadOnly) {
               if (!Platform.RO_FIELDS) {
                  throw new IllegalArgumentException("This VM does not support read-only fields (field '" + field.getName() + "' within " + this.getClass() + ")");
               }

               field.setAccessible(true);
            }

            structField.field = field;
            structField.name = field.getName();
            structField.type = type;
            if (Callback.class.isAssignableFrom(type) && !type.isInterface()) {
               throw new IllegalArgumentException("Structure Callback field '" + field.getName() + "' must be an interface");
            }

            if (type.isArray() && Structure.class.equals(type.getComponentType())) {
               String msg = "Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined";
               throw new IllegalArgumentException(msg);
            }

            int fieldAlignment = true;
            if (Modifier.isPublic(field.getModifiers())) {
               Object value = this.getFieldValue(structField.field);
               if (value == null && type.isArray()) {
                  if (force) {
                     throw new IllegalStateException("Array fields must be initialized");
                  }

                  return null;
               }

               Class nativeType = type;
               if (NativeMapped.class.isAssignableFrom(type)) {
                  NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
                  nativeType = tc.nativeType();
                  structField.writeConverter = tc;
                  structField.readConverter = tc;
                  structField.context = new StructureReadContext(this, field);
               } else if (this.typeMapper != null) {
                  ToNativeConverter writeConverter = this.typeMapper.getToNativeConverter(type);
                  FromNativeConverter readConverter = this.typeMapper.getFromNativeConverter(type);
                  if (writeConverter != null && readConverter != null) {
                     value = writeConverter.toNative(value, new StructureWriteContext(this, structField.field));
                     nativeType = value != null ? value.getClass() : Pointer.class;
                     structField.writeConverter = writeConverter;
                     structField.readConverter = readConverter;
                     structField.context = new StructureReadContext(this, field);
                  } else if (writeConverter != null || readConverter != null) {
                     String msg = "Structures require bidirectional type conversion for " + type;
                     throw new IllegalArgumentException(msg);
                  }
               }

               if (value == null) {
                  value = this.initializeField(structField.field, type);
               }

               int fieldAlignment;
               try {
                  structField.size = this.getNativeSize(nativeType, value);
                  fieldAlignment = this.getNativeAlignment(nativeType, value, firstField);
               } catch (IllegalArgumentException var18) {
                  if (!force && this.typeMapper == null) {
                     return null;
                  }

                  String msg = "Invalid Structure field in " + this.getClass() + ", field name '" + structField.name + "' (" + structField.type + "): " + var18.getMessage();
                  throw new IllegalArgumentException(msg, var18);
               }

               if (fieldAlignment == 0) {
                  throw new Error("Field alignment is zero for field '" + structField.name + "' within " + this.getClass());
               }

               info.alignment = Math.max(info.alignment, fieldAlignment);
               if (calculatedSize % fieldAlignment != 0) {
                  calculatedSize += fieldAlignment - calculatedSize % fieldAlignment;
               }

               if (this instanceof Union) {
                  structField.offset = 0;
                  calculatedSize = Math.max(calculatedSize, structField.size);
               } else {
                  structField.offset = calculatedSize;
                  calculatedSize += structField.size;
               }

               info.fields.put(structField.name, structField);
               if (info.typeInfoField == null || info.typeInfoField.size < structField.size || info.typeInfoField.size == structField.size && Structure.class.isAssignableFrom(structField.type)) {
                  info.typeInfoField = structField;
               }
            }
         }

         if (calculatedSize > 0) {
            int size = this.addPadding(calculatedSize, info.alignment);
            if (this instanceof Structure.ByValue && !avoidFFIType) {
               this.getTypeInfo();
            }

            info.size = size;
            return info;
         } else {
            throw new IllegalArgumentException("Structure " + this.getClass() + " has unknown or zero size (ensure all fields are public)");
         }
      }
   }

   private void initializeFields() {
      List flist = this.getFieldList();
      Iterator var2 = flist.iterator();

      while(var2.hasNext()) {
         Field f = (Field)var2.next();

         try {
            Object o = f.get(this);
            if (o == null) {
               this.initializeField(f, f.getType());
            }
         } catch (Exception var5) {
            throw new Error("Exception reading field '" + f.getName() + "' in " + this.getClass(), var5);
         }
      }

   }

   private Object initializeField(Field field, Class type) {
      Object value = null;
      if (Structure.class.isAssignableFrom(type) && !Structure.ByReference.class.isAssignableFrom(type)) {
         try {
            value = newInstance(type, PLACEHOLDER_MEMORY);
            this.setFieldValue(field, value);
         } catch (IllegalArgumentException var6) {
            String msg = "Can't determine size of nested structure";
            throw new IllegalArgumentException(msg, var6);
         }
      } else if (NativeMapped.class.isAssignableFrom(type)) {
         NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
         value = tc.defaultValue();
         this.setFieldValue(field, value);
      }

      return value;
   }

   private int addPadding(int calculatedSize) {
      return this.addPadding(calculatedSize, this.structAlignment);
   }

   private int addPadding(int calculatedSize, int alignment) {
      if (this.actualAlignType != 1 && calculatedSize % alignment != 0) {
         calculatedSize += alignment - calculatedSize % alignment;
      }

      return calculatedSize;
   }

   protected int getStructAlignment() {
      if (this.size == -1) {
         this.calculateSize(true);
      }

      return this.structAlignment;
   }

   protected int getNativeAlignment(Class type, Object value, boolean isFirstElement) {
      int alignment = true;
      if (NativeMapped.class.isAssignableFrom(type)) {
         NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
         type = tc.nativeType();
         value = tc.toNative(value, new ToNativeContext());
      }

      int size = Native.getNativeSize(type, value);
      int alignment;
      if (!type.isPrimitive() && Long.class != type && Integer.class != type && Short.class != type && Character.class != type && Byte.class != type && Boolean.class != type && Float.class != type && Double.class != type) {
         if ((!Pointer.class.isAssignableFrom(type) || Function.class.isAssignableFrom(type)) && (!Platform.HAS_BUFFERS || !Buffer.class.isAssignableFrom(type)) && !Callback.class.isAssignableFrom(type) && WString.class != type && String.class != type) {
            if (Structure.class.isAssignableFrom(type)) {
               if (Structure.ByReference.class.isAssignableFrom(type)) {
                  alignment = Pointer.SIZE;
               } else {
                  if (value == null) {
                     value = newInstance(type, PLACEHOLDER_MEMORY);
                  }

                  alignment = ((Structure)value).getStructAlignment();
               }
            } else {
               if (!type.isArray()) {
                  throw new IllegalArgumentException("Type " + type + " has unknown native alignment");
               }

               alignment = this.getNativeAlignment(type.getComponentType(), (Object)null, isFirstElement);
            }
         } else {
            alignment = Pointer.SIZE;
         }
      } else {
         alignment = size;
      }

      if (this.actualAlignType == 1) {
         alignment = 1;
      } else if (this.actualAlignType == 3) {
         alignment = Math.min(8, alignment);
      } else if (this.actualAlignType == 2) {
         if (!isFirstElement || !Platform.isMac() || !Platform.isPPC()) {
            alignment = Math.min(Native.MAX_ALIGNMENT, alignment);
         }

         if (!isFirstElement && Platform.isAIX() && (type == Double.TYPE || type == Double.class)) {
            alignment = 4;
         }
      }

      return alignment;
   }

   public String toString() {
      return this.toString(Boolean.getBoolean("jna.dump_memory"));
   }

   public String toString(boolean debug) {
      return this.toString(0, true, debug);
   }

   private String format(Class type) {
      String s = type.getName();
      int dot = s.lastIndexOf(".");
      return s.substring(dot + 1);
   }

   private String toString(int indent, boolean showContents, boolean dumpMemory) {
      this.ensureAllocated();
      String LS = System.getProperty("line.separator");
      String name = this.format(this.getClass()) + "(" + this.getPointer() + ")";
      if (!(this.getPointer() instanceof Memory)) {
         name = name + " (" + this.size() + " bytes)";
      }

      String prefix = "";

      for(int idx = 0; idx < indent; ++idx) {
         prefix = prefix + "  ";
      }

      String contents = LS;
      if (!showContents) {
         contents = "...}";
      } else {
         Iterator i = this.fields().values().iterator();

         while(i.hasNext()) {
            Structure.StructField sf = (Structure.StructField)i.next();
            Object value = this.getFieldValue(sf.field);
            String type = this.format(sf.type);
            String index = "";
            contents = contents + prefix;
            if (sf.type.isArray() && value != null) {
               type = this.format(sf.type.getComponentType());
               index = "[" + Array.getLength(value) + "]";
            }

            contents = contents + String.format("  %s %s%s@0x%X", type, sf.name, index, sf.offset);
            if (value instanceof Structure) {
               value = ((Structure)value).toString(indent + 1, !(value instanceof Structure.ByReference), dumpMemory);
            }

            contents = contents + "=";
            if (value instanceof Long) {
               contents = contents + String.format("0x%08X", (Long)value);
            } else if (value instanceof Integer) {
               contents = contents + String.format("0x%04X", (Integer)value);
            } else if (value instanceof Short) {
               contents = contents + String.format("0x%02X", (Short)value);
            } else if (value instanceof Byte) {
               contents = contents + String.format("0x%01X", (Byte)value);
            } else {
               contents = contents + String.valueOf(value).trim();
            }

            contents = contents + LS;
            if (!i.hasNext()) {
               contents = contents + prefix + "}";
            }
         }
      }

      if (indent == 0 && dumpMemory) {
         int BYTES_PER_ROW = true;
         contents = contents + LS + "memory dump" + LS;
         byte[] buf = this.getPointer().getByteArray(0L, this.size());

         for(int i = 0; i < buf.length; ++i) {
            if (i % 4 == 0) {
               contents = contents + "[";
            }

            if (buf[i] >= 0 && buf[i] < 16) {
               contents = contents + "0";
            }

            contents = contents + Integer.toHexString(buf[i] & 255);
            if (i % 4 == 3 && i < buf.length - 1) {
               contents = contents + "]" + LS;
            }
         }

         contents = contents + "]";
      }

      return name + " {" + contents;
   }

   public Structure[] toArray(Structure[] array) {
      this.ensureAllocated();
      int i;
      if (this.memory instanceof Structure.AutoAllocated) {
         Memory m = (Memory)this.memory;
         i = array.length * this.size();
         if (m.size() < (long)i) {
            this.useMemory(this.autoAllocate(i));
         }
      }

      array[0] = this;
      int size = this.size();

      for(i = 1; i < array.length; ++i) {
         array[i] = newInstance(this.getClass(), this.memory.share((long)(i * size), (long)size));
         array[i].conditionalAutoRead();
      }

      if (!(this instanceof Structure.ByValue)) {
         this.array = array;
      }

      return array;
   }

   public Structure[] toArray(int size) {
      return this.toArray((Structure[])((Structure[])Array.newInstance(this.getClass(), size)));
   }

   private Class baseClass() {
      return (this instanceof Structure.ByReference || this instanceof Structure.ByValue) && Structure.class.isAssignableFrom(this.getClass().getSuperclass()) ? this.getClass().getSuperclass() : this.getClass();
   }

   public boolean dataEquals(Structure s) {
      return this.dataEquals(s, false);
   }

   public boolean dataEquals(Structure s, boolean clear) {
      if (clear) {
         s.getPointer().clear((long)s.size());
         s.write();
         this.getPointer().clear((long)this.size());
         this.write();
      }

      byte[] data = s.getPointer().getByteArray(0L, s.size());
      byte[] ref = this.getPointer().getByteArray(0L, this.size());
      if (data.length == ref.length) {
         for(int i = 0; i < data.length; ++i) {
            if (data[i] != ref[i]) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean equals(Object o) {
      return o instanceof Structure && o.getClass() == this.getClass() && ((Structure)o).getPointer().equals(this.getPointer());
   }

   public int hashCode() {
      Pointer p = this.getPointer();
      return p != null ? this.getPointer().hashCode() : this.getClass().hashCode();
   }

   protected void cacheTypeInfo(Pointer p) {
      this.typeInfo = p.peer;
   }

   Pointer getFieldTypeInfo(Structure.StructField f) {
      Class type = f.type;
      Object value = this.getFieldValue(f.field);
      if (this.typeMapper != null) {
         ToNativeConverter nc = this.typeMapper.getToNativeConverter(type);
         if (nc != null) {
            type = nc.nativeType();
            value = nc.toNative(value, new ToNativeContext());
         }
      }

      return Structure.FFIType.get(value, type);
   }

   Pointer getTypeInfo() {
      Pointer p = getTypeInfo(this);
      this.cacheTypeInfo(p);
      return p;
   }

   public void setAutoSynch(boolean auto) {
      this.setAutoRead(auto);
      this.setAutoWrite(auto);
   }

   public void setAutoRead(boolean auto) {
      this.autoRead = auto;
   }

   public boolean getAutoRead() {
      return this.autoRead;
   }

   public void setAutoWrite(boolean auto) {
      this.autoWrite = auto;
   }

   public boolean getAutoWrite() {
      return this.autoWrite;
   }

   static Pointer getTypeInfo(Object obj) {
      return Structure.FFIType.get(obj);
   }

   private static Structure newInstance(Class type, long init) {
      try {
         Structure s = newInstance(type, init == 0L ? PLACEHOLDER_MEMORY : new Pointer(init));
         if (init != 0L) {
            s.conditionalAutoRead();
         }

         return s;
      } catch (Throwable var4) {
         System.err.println("JNA: Error creating structure: " + var4);
         return null;
      }
   }

   public static Structure newInstance(Class type, Pointer init) throws IllegalArgumentException {
      String msg;
      try {
         Constructor ctor = type.getConstructor(Pointer.class);
         return (Structure)ctor.newInstance(init);
      } catch (NoSuchMethodException var4) {
      } catch (SecurityException var5) {
      } catch (InstantiationException var6) {
         msg = "Can't instantiate " + type;
         throw new IllegalArgumentException(msg, var6);
      } catch (IllegalAccessException var7) {
         msg = "Instantiation of " + type + " (Pointer) not allowed, is it public?";
         throw new IllegalArgumentException(msg, var7);
      } catch (InvocationTargetException var8) {
         msg = "Exception thrown while instantiating an instance of " + type;
         var8.printStackTrace();
         throw new IllegalArgumentException(msg, var8);
      }

      Structure s = newInstance(type);
      if (init != PLACEHOLDER_MEMORY) {
         s.useMemory(init);
      }

      return s;
   }

   public static Structure newInstance(Class type) throws IllegalArgumentException {
      String msg;
      try {
         Structure s = (Structure)type.newInstance();
         if (s instanceof Structure.ByValue) {
            s.allocateMemory();
         }

         return s;
      } catch (InstantiationException var3) {
         msg = "Can't instantiate " + type;
         throw new IllegalArgumentException(msg, var3);
      } catch (IllegalAccessException var4) {
         msg = "Instantiation of " + type + " not allowed, is it public?";
         throw new IllegalArgumentException(msg, var4);
      }
   }

   Structure.StructField typeInfoField() {
      Structure.LayoutInfo info;
      synchronized(layoutInfo) {
         info = (Structure.LayoutInfo)layoutInfo.get(this.getClass());
      }

      return info != null ? info.typeInfoField : null;
   }

   private static void structureArrayCheck(Structure[] ss) {
      if (!Structure.ByReference[].class.isAssignableFrom(ss.getClass())) {
         Pointer base = ss[0].getPointer();
         int size = ss[0].size();

         for(int si = 1; si < ss.length; ++si) {
            if (ss[si].getPointer().peer != base.peer + (long)(size * si)) {
               String msg = "Structure array elements must use contiguous memory (bad backing address at Structure array index " + si + ")";
               throw new IllegalArgumentException(msg);
            }
         }

      }
   }

   public static void autoRead(Structure[] ss) {
      structureArrayCheck(ss);
      if (ss[0].array == ss) {
         ss[0].autoRead();
      } else {
         for(int si = 0; si < ss.length; ++si) {
            if (ss[si] != null) {
               ss[si].autoRead();
            }
         }
      }

   }

   public void autoRead() {
      if (this.getAutoRead()) {
         this.read();
         if (this.array != null) {
            for(int i = 1; i < this.array.length; ++i) {
               this.array[i].autoRead();
            }
         }
      }

   }

   public static void autoWrite(Structure[] ss) {
      structureArrayCheck(ss);
      if (ss[0].array == ss) {
         ss[0].autoWrite();
      } else {
         for(int si = 0; si < ss.length; ++si) {
            if (ss[si] != null) {
               ss[si].autoWrite();
            }
         }
      }

   }

   public void autoWrite() {
      if (this.getAutoWrite()) {
         this.write();
         if (this.array != null) {
            for(int i = 1; i < this.array.length; ++i) {
               this.array[i].autoWrite();
            }
         }
      }

   }

   protected int getNativeSize(Class nativeType) {
      return this.getNativeSize(nativeType, (Object)null);
   }

   protected int getNativeSize(Class nativeType, Object value) {
      return Native.getNativeSize(nativeType, value);
   }

   static void validate(Class cls) {
      newInstance(cls, PLACEHOLDER_MEMORY);
   }

   private static class AutoAllocated extends Memory {
      public AutoAllocated(int size) {
         super((long)size);
         super.clear();
      }

      public String toString() {
         return "auto-" + super.toString();
      }
   }

   static class FFIType extends Structure {
      private static final Map typeInfoMap = new WeakHashMap();
      private static final int FFI_TYPE_STRUCT = 13;
      public Structure.FFIType.size_t size;
      public short alignment;
      public short type = 13;
      public Pointer elements;

      private FFIType(Structure ref) {
         ref.ensureAllocated(true);
         Pointer[] els;
         if (ref instanceof Union) {
            Structure.StructField sf = ((Union)ref).typeInfoField();
            els = new Pointer[]{get(ref.getFieldValue(sf.field), sf.type), null};
         } else {
            els = new Pointer[ref.fields().size() + 1];
            int idx = 0;

            Structure.StructField sf;
            for(Iterator var4 = ref.fields().values().iterator(); var4.hasNext(); els[idx++] = ref.getFieldTypeInfo(sf)) {
               sf = (Structure.StructField)var4.next();
            }
         }

         this.init(els);
      }

      private FFIType(Object array, Class type) {
         int length = Array.getLength(array);
         Pointer[] els = new Pointer[length + 1];
         Pointer p = get((Object)null, type.getComponentType());

         for(int i = 0; i < length; ++i) {
            els[i] = p;
         }

         this.init(els);
      }

      protected List getFieldOrder() {
         return Arrays.asList("size", "alignment", "type", "elements");
      }

      private void init(Pointer[] els) {
         this.elements = new Memory((long)(Pointer.SIZE * els.length));
         this.elements.write(0L, (Pointer[])els, 0, els.length);
         this.write();
      }

      static Pointer get(Object obj) {
         if (obj == null) {
            return Structure.FFIType.FFITypes.ffi_type_pointer;
         } else {
            return obj instanceof Class ? get((Object)null, (Class)obj) : get(obj, obj.getClass());
         }
      }

      private static Pointer get(Object obj, Class cls) {
         TypeMapper mapper = Native.getTypeMapper(cls);
         if (mapper != null) {
            ToNativeConverter nc = mapper.getToNativeConverter(cls);
            if (nc != null) {
               cls = nc.nativeType();
            }
         }

         synchronized(typeInfoMap) {
            Object o = typeInfoMap.get(cls);
            if (o instanceof Pointer) {
               return (Pointer)o;
            } else if (o instanceof Structure.FFIType) {
               return ((Structure.FFIType)o).getPointer();
            } else if ((!Platform.HAS_BUFFERS || !Buffer.class.isAssignableFrom(cls)) && !Callback.class.isAssignableFrom(cls)) {
               Structure.FFIType type;
               if (Structure.class.isAssignableFrom(cls)) {
                  if (obj == null) {
                     obj = newInstance(cls, Structure.PLACEHOLDER_MEMORY);
                  }

                  if (Structure.ByReference.class.isAssignableFrom(cls)) {
                     typeInfoMap.put(cls, Structure.FFIType.FFITypes.ffi_type_pointer);
                     return Structure.FFIType.FFITypes.ffi_type_pointer;
                  } else {
                     type = new Structure.FFIType((Structure)obj);
                     typeInfoMap.put(cls, type);
                     return type.getPointer();
                  }
               } else if (NativeMapped.class.isAssignableFrom(cls)) {
                  NativeMappedConverter c = NativeMappedConverter.getInstance(cls);
                  return get(c.toNative(obj, new ToNativeContext()), c.nativeType());
               } else if (cls.isArray()) {
                  type = new Structure.FFIType(obj, cls);
                  typeInfoMap.put(obj, type);
                  return type.getPointer();
               } else {
                  throw new IllegalArgumentException("Unsupported type " + cls);
               }
            } else {
               typeInfoMap.put(cls, Structure.FFIType.FFITypes.ffi_type_pointer);
               return Structure.FFIType.FFITypes.ffi_type_pointer;
            }
         }
      }

      static {
         if (Native.POINTER_SIZE == 0) {
            throw new Error("Native library not initialized");
         } else if (Structure.FFIType.FFITypes.ffi_type_void == null) {
            throw new Error("FFI types not initialized");
         } else {
            typeInfoMap.put(Void.TYPE, Structure.FFIType.FFITypes.ffi_type_void);
            typeInfoMap.put(Void.class, Structure.FFIType.FFITypes.ffi_type_void);
            typeInfoMap.put(Float.TYPE, Structure.FFIType.FFITypes.ffi_type_float);
            typeInfoMap.put(Float.class, Structure.FFIType.FFITypes.ffi_type_float);
            typeInfoMap.put(Double.TYPE, Structure.FFIType.FFITypes.ffi_type_double);
            typeInfoMap.put(Double.class, Structure.FFIType.FFITypes.ffi_type_double);
            typeInfoMap.put(Long.TYPE, Structure.FFIType.FFITypes.ffi_type_sint64);
            typeInfoMap.put(Long.class, Structure.FFIType.FFITypes.ffi_type_sint64);
            typeInfoMap.put(Integer.TYPE, Structure.FFIType.FFITypes.ffi_type_sint32);
            typeInfoMap.put(Integer.class, Structure.FFIType.FFITypes.ffi_type_sint32);
            typeInfoMap.put(Short.TYPE, Structure.FFIType.FFITypes.ffi_type_sint16);
            typeInfoMap.put(Short.class, Structure.FFIType.FFITypes.ffi_type_sint16);
            Pointer ctype = Native.WCHAR_SIZE == 2 ? Structure.FFIType.FFITypes.ffi_type_uint16 : Structure.FFIType.FFITypes.ffi_type_uint32;
            typeInfoMap.put(Character.TYPE, ctype);
            typeInfoMap.put(Character.class, ctype);
            typeInfoMap.put(Byte.TYPE, Structure.FFIType.FFITypes.ffi_type_sint8);
            typeInfoMap.put(Byte.class, Structure.FFIType.FFITypes.ffi_type_sint8);
            typeInfoMap.put(Pointer.class, Structure.FFIType.FFITypes.ffi_type_pointer);
            typeInfoMap.put(String.class, Structure.FFIType.FFITypes.ffi_type_pointer);
            typeInfoMap.put(WString.class, Structure.FFIType.FFITypes.ffi_type_pointer);
            typeInfoMap.put(Boolean.TYPE, Structure.FFIType.FFITypes.ffi_type_uint32);
            typeInfoMap.put(Boolean.class, Structure.FFIType.FFITypes.ffi_type_uint32);
         }
      }

      private static class FFITypes {
         private static Pointer ffi_type_void;
         private static Pointer ffi_type_float;
         private static Pointer ffi_type_double;
         private static Pointer ffi_type_longdouble;
         private static Pointer ffi_type_uint8;
         private static Pointer ffi_type_sint8;
         private static Pointer ffi_type_uint16;
         private static Pointer ffi_type_sint16;
         private static Pointer ffi_type_uint32;
         private static Pointer ffi_type_sint32;
         private static Pointer ffi_type_uint64;
         private static Pointer ffi_type_sint64;
         private static Pointer ffi_type_pointer;
      }

      public static class size_t extends IntegerType {
         private static final long serialVersionUID = 1L;

         public size_t() {
            this(0L);
         }

         public size_t(long value) {
            super(Native.SIZE_T_SIZE, value);
         }
      }
   }

   protected static class StructField {
      public String name;
      public Class type;
      public Field field;
      public int size = -1;
      public int offset = -1;
      public boolean isVolatile;
      public boolean isReadOnly;
      public FromNativeConverter readConverter;
      public ToNativeConverter writeConverter;
      public FromNativeContext context;

      public String toString() {
         return this.name + "@" + this.offset + "[" + this.size + "] (" + this.type + ")";
      }
   }

   private static class LayoutInfo {
      private int size;
      private int alignment;
      private final Map fields;
      private int alignType;
      private TypeMapper typeMapper;
      private boolean variable;
      private Structure.StructField typeInfoField;

      private LayoutInfo() {
         this.size = -1;
         this.alignment = 1;
         this.fields = Collections.synchronizedMap(new LinkedHashMap());
         this.alignType = 0;
      }

      // $FF: synthetic method
      LayoutInfo(Object x0) {
         this();
      }
   }

   static class StructureSet extends AbstractCollection implements Set {
      Structure[] elements;
      private int count;

      private void ensureCapacity(int size) {
         if (this.elements == null) {
            this.elements = new Structure[size * 3 / 2];
         } else if (this.elements.length < size) {
            Structure[] e = new Structure[size * 3 / 2];
            System.arraycopy(this.elements, 0, e, 0, this.elements.length);
            this.elements = e;
         }

      }

      public Structure[] getElements() {
         return this.elements;
      }

      public int size() {
         return this.count;
      }

      public boolean contains(Object o) {
         return this.indexOf((Structure)o) != -1;
      }

      public boolean add(Structure o) {
         if (!this.contains(o)) {
            this.ensureCapacity(this.count + 1);
            this.elements[this.count++] = o;
         }

         return true;
      }

      private int indexOf(Structure s1) {
         for(int i = 0; i < this.count; ++i) {
            Structure s2 = this.elements[i];
            if (s1 == s2 || s1.getClass() == s2.getClass() && s1.size() == s2.size() && s1.getPointer().equals(s2.getPointer())) {
               return i;
            }
         }

         return -1;
      }

      public boolean remove(Object o) {
         int idx = this.indexOf((Structure)o);
         if (idx != -1) {
            if (--this.count >= 0) {
               this.elements[idx] = this.elements[this.count];
               this.elements[this.count] = null;
            }

            return true;
         } else {
            return false;
         }
      }

      public Iterator iterator() {
         Structure[] e = new Structure[this.count];
         if (this.count > 0) {
            System.arraycopy(this.elements, 0, e, 0, this.count);
         }

         return Arrays.asList(e).iterator();
      }
   }

   public interface ByReference {
   }

   public interface ByValue {
   }
}
