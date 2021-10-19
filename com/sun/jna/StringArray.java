package com.sun.jna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArray extends Memory implements Function.PostCallRead {
   private String encoding;
   private List natives;
   private Object[] original;

   public StringArray(String[] strings) {
      this(strings, false);
   }

   public StringArray(String[] strings, boolean wide) {
      this((Object[])strings, wide ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
   }

   public StringArray(String[] strings, String encoding) {
      this((Object[])strings, encoding);
   }

   public StringArray(WString[] strings) {
      this((Object[])strings, "--WIDE-STRING--");
   }

   private StringArray(Object[] strings, String encoding) {
      super((long)((strings.length + 1) * Pointer.SIZE));
      this.natives = new ArrayList();
      this.original = strings;
      this.encoding = encoding;

      for(int i = 0; i < strings.length; ++i) {
         Pointer p = null;
         if (strings[i] != null) {
            NativeString ns = new NativeString(strings[i].toString(), encoding);
            this.natives.add(ns);
            p = ns.getPointer();
         }

         this.setPointer((long)(Pointer.SIZE * i), p);
      }

      this.setPointer((long)(Pointer.SIZE * strings.length), (Pointer)null);
   }

   public void read() {
      boolean returnWide = this.original instanceof WString[];
      boolean wide = "--WIDE-STRING--".equals(this.encoding);

      for(int si = 0; si < this.original.length; ++si) {
         Pointer p = this.getPointer((long)(si * Pointer.SIZE));
         Object s = null;
         if (p != null) {
            s = wide ? p.getWideString(0L) : p.getString(0L, this.encoding);
            if (returnWide) {
               s = new WString((String)s);
            }
         }

         this.original[si] = s;
      }

   }

   public String toString() {
      boolean wide = "--WIDE-STRING--".equals(this.encoding);
      String s = wide ? "const wchar_t*[]" : "const char*[]";
      s = s + Arrays.asList(this.original);
      return s;
   }
}
