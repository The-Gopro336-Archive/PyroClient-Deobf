package com.sun.jna;

import java.nio.CharBuffer;

class NativeString implements CharSequence, Comparable {
   static final String WIDE_STRING = "--WIDE-STRING--";
   private Pointer pointer;
   private String encoding;

   public NativeString(String string) {
      this(string, Native.getDefaultStringEncoding());
   }

   public NativeString(String string, boolean wide) {
      this(string, wide ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
   }

   public NativeString(WString string) {
      this(string.toString(), "--WIDE-STRING--");
   }

   public NativeString(String string, String encoding) {
      if (string == null) {
         throw new NullPointerException("String must not be null");
      } else {
         this.encoding = encoding;
         if ("--WIDE-STRING--".equals(this.encoding)) {
            int len = (string.length() + 1) * Native.WCHAR_SIZE;
            this.pointer = new NativeString.StringMemory((long)len);
            this.pointer.setWideString(0L, string);
         } else {
            byte[] data = Native.getBytes(string, encoding);
            this.pointer = new NativeString.StringMemory((long)(data.length + 1));
            this.pointer.write(0L, (byte[])data, 0, data.length);
            this.pointer.setByte((long)data.length, (byte)0);
         }

      }
   }

   public int hashCode() {
      return this.toString().hashCode();
   }

   public boolean equals(Object other) {
      if (other instanceof CharSequence) {
         return this.compareTo(other) == 0;
      } else {
         return false;
      }
   }

   public String toString() {
      boolean wide = "--WIDE-STRING--".equals(this.encoding);
      String s = wide ? "const wchar_t*" : "const char*";
      s = s + "(" + (wide ? this.pointer.getWideString(0L) : this.pointer.getString(0L, this.encoding)) + ")";
      return s;
   }

   public Pointer getPointer() {
      return this.pointer;
   }

   public char charAt(int index) {
      return this.toString().charAt(index);
   }

   public int length() {
      return this.toString().length();
   }

   public CharSequence subSequence(int start, int end) {
      return CharBuffer.wrap(this.toString()).subSequence(start, end);
   }

   public int compareTo(Object other) {
      return other == null ? 1 : this.toString().compareTo(other.toString());
   }

   private class StringMemory extends Memory {
      public StringMemory(long size) {
         super(size);
      }

      public String toString() {
         return NativeString.this.toString();
      }
   }
}
