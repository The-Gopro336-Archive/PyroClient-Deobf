package com.sun.jna;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class Pointer {
   public static final int SIZE;
   public static final Pointer NULL;
   protected long peer;

   public static final Pointer createConstant(long peer) {
      return new Pointer.Opaque(peer);
   }

   public static final Pointer createConstant(int peer) {
      return new Pointer.Opaque((long)peer & -1L);
   }

   Pointer() {
   }

   public Pointer(long peer) {
      this.peer = peer;
   }

   public Pointer share(long offset) {
      return this.share(offset, 0L);
   }

   public Pointer share(long offset, long sz) {
      return offset == 0L ? this : new Pointer(this.peer + offset);
   }

   public void clear(long size) {
      this.setMemory(0L, size, (byte)0);
   }

   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (o == null) {
         return false;
      } else {
         return o instanceof Pointer && ((Pointer)o).peer == this.peer;
      }
   }

   public int hashCode() {
      return (int)((this.peer >>> 32) + (this.peer & -1L));
   }

   public long indexOf(long offset, byte value) {
      return Native.indexOf(this, this.peer, offset, value);
   }

   public void read(long offset, byte[] buf, int index, int length) {
      Native.read(this, this.peer, offset, buf, index, length);
   }

   public void read(long offset, short[] buf, int index, int length) {
      Native.read(this, this.peer, offset, buf, index, length);
   }

   public void read(long offset, char[] buf, int index, int length) {
      Native.read(this, this.peer, offset, buf, index, length);
   }

   public void read(long offset, int[] buf, int index, int length) {
      Native.read(this, this.peer, offset, buf, index, length);
   }

   public void read(long offset, long[] buf, int index, int length) {
      Native.read(this, this.peer, offset, buf, index, length);
   }

   public void read(long offset, float[] buf, int index, int length) {
      Native.read(this, this.peer, offset, buf, index, length);
   }

   public void read(long offset, double[] buf, int index, int length) {
      Native.read(this, this.peer, offset, buf, index, length);
   }

   public void read(long offset, Pointer[] buf, int index, int length) {
      for(int i = 0; i < length; ++i) {
         Pointer p = this.getPointer(offset + (long)(i * SIZE));
         Pointer oldp = buf[i + index];
         if (oldp == null || p == null || p.peer != oldp.peer) {
            buf[i + index] = p;
         }
      }

   }

   public void write(long offset, byte[] buf, int index, int length) {
      Native.write(this, this.peer, offset, buf, index, length);
   }

   public void write(long offset, short[] buf, int index, int length) {
      Native.write(this, this.peer, offset, buf, index, length);
   }

   public void write(long offset, char[] buf, int index, int length) {
      Native.write(this, this.peer, offset, buf, index, length);
   }

   public void write(long offset, int[] buf, int index, int length) {
      Native.write(this, this.peer, offset, buf, index, length);
   }

   public void write(long offset, long[] buf, int index, int length) {
      Native.write(this, this.peer, offset, buf, index, length);
   }

   public void write(long offset, float[] buf, int index, int length) {
      Native.write(this, this.peer, offset, buf, index, length);
   }

   public void write(long offset, double[] buf, int index, int length) {
      Native.write(this, this.peer, offset, buf, index, length);
   }

   public void write(long bOff, Pointer[] buf, int index, int length) {
      for(int i = 0; i < length; ++i) {
         this.setPointer(bOff + (long)(i * SIZE), buf[index + i]);
      }

   }

   Object getValue(long offset, Class type, Object currentValue) {
      Object result = null;
      if (Structure.class.isAssignableFrom(type)) {
         Structure s = (Structure)currentValue;
         if (Structure.ByReference.class.isAssignableFrom(type)) {
            s = Structure.updateStructureByReference(type, s, this.getPointer(offset));
         } else {
            s.useMemory(this, (int)offset, true);
            s.read();
         }

         result = s;
      } else if (type != Boolean.TYPE && type != Boolean.class) {
         if (type != Byte.TYPE && type != Byte.class) {
            if (type != Short.TYPE && type != Short.class) {
               if (type != Character.TYPE && type != Character.class) {
                  if (type != Integer.TYPE && type != Integer.class) {
                     if (type != Long.TYPE && type != Long.class) {
                        if (type != Float.TYPE && type != Float.class) {
                           if (type != Double.TYPE && type != Double.class) {
                              Pointer bp;
                              Pointer oldbp;
                              if (Pointer.class.isAssignableFrom(type)) {
                                 bp = this.getPointer(offset);
                                 if (bp != null) {
                                    oldbp = currentValue instanceof Pointer ? (Pointer)currentValue : null;
                                    if (oldbp != null && bp.peer == oldbp.peer) {
                                       result = oldbp;
                                    } else {
                                       result = bp;
                                    }
                                 }
                              } else if (type == String.class) {
                                 bp = this.getPointer(offset);
                                 result = bp != null ? bp.getString(0L) : null;
                              } else if (type == WString.class) {
                                 bp = this.getPointer(offset);
                                 result = bp != null ? new WString(bp.getWideString(0L)) : null;
                              } else if (Callback.class.isAssignableFrom(type)) {
                                 bp = this.getPointer(offset);
                                 if (bp == null) {
                                    result = null;
                                 } else {
                                    Callback cb = (Callback)currentValue;
                                    Pointer oldfp = CallbackReference.getFunctionPointer(cb);
                                    if (!bp.equals(oldfp)) {
                                       cb = CallbackReference.getCallback(type, bp);
                                    }

                                    result = cb;
                                 }
                              } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(type)) {
                                 bp = this.getPointer(offset);
                                 if (bp == null) {
                                    result = null;
                                 } else {
                                    oldbp = currentValue == null ? null : Native.getDirectBufferPointer((Buffer)currentValue);
                                    if (oldbp == null || !oldbp.equals(bp)) {
                                       throw new IllegalStateException("Can't autogenerate a direct buffer on memory read");
                                    }

                                    result = currentValue;
                                 }
                              } else if (NativeMapped.class.isAssignableFrom(type)) {
                                 NativeMapped nm = (NativeMapped)currentValue;
                                 if (nm != null) {
                                    Object value = this.getValue(offset, nm.nativeType(), (Object)null);
                                    result = nm.fromNative(value, new FromNativeContext(type));
                                    if (nm.equals(result)) {
                                       result = nm;
                                    }
                                 } else {
                                    NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
                                    Object value = this.getValue(offset, tc.nativeType(), (Object)null);
                                    result = tc.fromNative(value, new FromNativeContext(type));
                                 }
                              } else {
                                 if (!type.isArray()) {
                                    throw new IllegalArgumentException("Reading \"" + type + "\" from memory is not supported");
                                 }

                                 result = currentValue;
                                 if (currentValue == null) {
                                    throw new IllegalStateException("Need an initialized array");
                                 }

                                 this.readArray(offset, currentValue, type.getComponentType());
                              }
                           } else {
                              result = this.getDouble(offset);
                           }
                        } else {
                           result = this.getFloat(offset);
                        }
                     } else {
                        result = this.getLong(offset);
                     }
                  } else {
                     result = this.getInt(offset);
                  }
               } else {
                  result = this.getChar(offset);
               }
            } else {
               result = this.getShort(offset);
            }
         } else {
            result = this.getByte(offset);
         }
      } else {
         result = Function.valueOf(this.getInt(offset) != 0);
      }

      return result;
   }

   private void readArray(long offset, Object o, Class cls) {
      int length = false;
      int length = Array.getLength(o);
      if (cls == Byte.TYPE) {
         this.read(offset, (byte[])((byte[])((byte[])o)), 0, length);
      } else if (cls == Short.TYPE) {
         this.read(offset, (short[])((short[])((short[])o)), 0, length);
      } else if (cls == Character.TYPE) {
         this.read(offset, (char[])((char[])((char[])o)), 0, length);
      } else if (cls == Integer.TYPE) {
         this.read(offset, (int[])((int[])((int[])o)), 0, length);
      } else if (cls == Long.TYPE) {
         this.read(offset, (long[])((long[])((long[])o)), 0, length);
      } else if (cls == Float.TYPE) {
         this.read(offset, (float[])((float[])((float[])o)), 0, length);
      } else if (cls == Double.TYPE) {
         this.read(offset, (double[])((double[])((double[])o)), 0, length);
      } else if (Pointer.class.isAssignableFrom(cls)) {
         this.read(offset, (Pointer[])((Pointer[])((Pointer[])o)), 0, length);
      } else {
         int i;
         int i;
         if (Structure.class.isAssignableFrom(cls)) {
            Structure[] sarray = (Structure[])((Structure[])o);
            if (Structure.ByReference.class.isAssignableFrom(cls)) {
               Pointer[] parray = this.getPointerArray(offset, sarray.length);

               for(i = 0; i < sarray.length; ++i) {
                  sarray[i] = Structure.updateStructureByReference(cls, sarray[i], parray[i]);
               }
            } else {
               Structure first = sarray[0];
               if (first == null) {
                  first = Structure.newInstance(cls, this.share(offset));
                  first.conditionalAutoRead();
                  sarray[0] = first;
               } else {
                  first.useMemory(this, (int)offset, true);
                  first.read();
               }

               Structure[] tmp = first.toArray(sarray.length);

               for(i = 1; i < sarray.length; ++i) {
                  if (sarray[i] == null) {
                     sarray[i] = tmp[i];
                  } else {
                     sarray[i].useMemory(this, (int)(offset + (long)(i * sarray[i].size())), true);
                     sarray[i].read();
                  }
               }
            }
         } else {
            if (!NativeMapped.class.isAssignableFrom(cls)) {
               throw new IllegalArgumentException("Reading array of " + cls + " from memory not supported");
            }

            NativeMapped[] array = (NativeMapped[])((NativeMapped[])o);
            NativeMappedConverter tc = NativeMappedConverter.getInstance(cls);
            i = Native.getNativeSize(o.getClass(), o) / array.length;

            for(i = 0; i < array.length; ++i) {
               Object value = this.getValue(offset + (long)(i * i), tc.nativeType(), array[i]);
               array[i] = (NativeMapped)tc.fromNative(value, new FromNativeContext(cls));
            }
         }
      }

   }

   public byte getByte(long offset) {
      return Native.getByte(this, this.peer, offset);
   }

   public char getChar(long offset) {
      return Native.getChar(this, this.peer, offset);
   }

   public short getShort(long offset) {
      return Native.getShort(this, this.peer, offset);
   }

   public int getInt(long offset) {
      return Native.getInt(this, this.peer, offset);
   }

   public long getLong(long offset) {
      return Native.getLong(this, this.peer, offset);
   }

   public NativeLong getNativeLong(long offset) {
      return new NativeLong(NativeLong.SIZE == 8 ? this.getLong(offset) : (long)this.getInt(offset));
   }

   public float getFloat(long offset) {
      return Native.getFloat(this, this.peer, offset);
   }

   public double getDouble(long offset) {
      return Native.getDouble(this, this.peer, offset);
   }

   public Pointer getPointer(long offset) {
      return Native.getPointer(this.peer + offset);
   }

   public ByteBuffer getByteBuffer(long offset, long length) {
      return Native.getDirectByteBuffer(this, this.peer, offset, length).order(ByteOrder.nativeOrder());
   }

   /** @deprecated */
   @Deprecated
   public String getString(long offset, boolean wide) {
      return wide ? this.getWideString(offset) : this.getString(offset);
   }

   public String getWideString(long offset) {
      return Native.getWideString(this, this.peer, offset);
   }

   public String getString(long offset) {
      return this.getString(offset, Native.getDefaultStringEncoding());
   }

   public String getString(long offset, String encoding) {
      return Native.getString(this, offset, encoding);
   }

   public byte[] getByteArray(long offset, int arraySize) {
      byte[] buf = new byte[arraySize];
      this.read(offset, (byte[])buf, 0, arraySize);
      return buf;
   }

   public char[] getCharArray(long offset, int arraySize) {
      char[] buf = new char[arraySize];
      this.read(offset, (char[])buf, 0, arraySize);
      return buf;
   }

   public short[] getShortArray(long offset, int arraySize) {
      short[] buf = new short[arraySize];
      this.read(offset, (short[])buf, 0, arraySize);
      return buf;
   }

   public int[] getIntArray(long offset, int arraySize) {
      int[] buf = new int[arraySize];
      this.read(offset, (int[])buf, 0, arraySize);
      return buf;
   }

   public long[] getLongArray(long offset, int arraySize) {
      long[] buf = new long[arraySize];
      this.read(offset, (long[])buf, 0, arraySize);
      return buf;
   }

   public float[] getFloatArray(long offset, int arraySize) {
      float[] buf = new float[arraySize];
      this.read(offset, (float[])buf, 0, arraySize);
      return buf;
   }

   public double[] getDoubleArray(long offset, int arraySize) {
      double[] buf = new double[arraySize];
      this.read(offset, (double[])buf, 0, arraySize);
      return buf;
   }

   public Pointer[] getPointerArray(long offset) {
      List array = new ArrayList();
      int addOffset = 0;

      for(Pointer p = this.getPointer(offset); p != null; p = this.getPointer(offset + (long)addOffset)) {
         array.add(p);
         addOffset += SIZE;
      }

      return (Pointer[])array.toArray(new Pointer[array.size()]);
   }

   public Pointer[] getPointerArray(long offset, int arraySize) {
      Pointer[] buf = new Pointer[arraySize];
      this.read(offset, (Pointer[])buf, 0, arraySize);
      return buf;
   }

   public String[] getStringArray(long offset) {
      return this.getStringArray(offset, -1, Native.getDefaultStringEncoding());
   }

   public String[] getStringArray(long offset, String encoding) {
      return this.getStringArray(offset, -1, encoding);
   }

   public String[] getStringArray(long offset, int length) {
      return this.getStringArray(offset, length, Native.getDefaultStringEncoding());
   }

   /** @deprecated */
   @Deprecated
   public String[] getStringArray(long offset, boolean wide) {
      return this.getStringArray(offset, -1, wide);
   }

   public String[] getWideStringArray(long offset) {
      return this.getWideStringArray(offset, -1);
   }

   public String[] getWideStringArray(long offset, int length) {
      return this.getStringArray(offset, length, "--WIDE-STRING--");
   }

   /** @deprecated */
   @Deprecated
   public String[] getStringArray(long offset, int length, boolean wide) {
      return this.getStringArray(offset, length, wide ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
   }

   public String[] getStringArray(long offset, int length, String encoding) {
      List strings = new ArrayList();
      int addOffset = 0;
      Pointer p;
      if (length != -1) {
         p = this.getPointer(offset + (long)addOffset);
         int count = 0;

         while(count++ < length) {
            String s = p == null ? null : ("--WIDE-STRING--".equals(encoding) ? p.getWideString(0L) : p.getString(0L, encoding));
            strings.add(s);
            if (count < length) {
               addOffset += SIZE;
               p = this.getPointer(offset + (long)addOffset);
            }
         }
      } else {
         while((p = this.getPointer(offset + (long)addOffset)) != null) {
            String s = p == null ? null : ("--WIDE-STRING--".equals(encoding) ? p.getWideString(0L) : p.getString(0L, encoding));
            strings.add(s);
            addOffset += SIZE;
         }
      }

      return (String[])strings.toArray(new String[strings.size()]);
   }

   void setValue(long offset, Object value, Class type) {
      if (type != Boolean.TYPE && type != Boolean.class) {
         if (type != Byte.TYPE && type != Byte.class) {
            if (type != Short.TYPE && type != Short.class) {
               if (type != Character.TYPE && type != Character.class) {
                  if (type != Integer.TYPE && type != Integer.class) {
                     if (type != Long.TYPE && type != Long.class) {
                        if (type != Float.TYPE && type != Float.class) {
                           if (type != Double.TYPE && type != Double.class) {
                              if (type == Pointer.class) {
                                 this.setPointer(offset, (Pointer)value);
                              } else if (type == String.class) {
                                 this.setPointer(offset, (Pointer)value);
                              } else if (type == WString.class) {
                                 this.setPointer(offset, (Pointer)value);
                              } else if (Structure.class.isAssignableFrom(type)) {
                                 Structure s = (Structure)value;
                                 if (Structure.ByReference.class.isAssignableFrom(type)) {
                                    this.setPointer(offset, s == null ? null : s.getPointer());
                                    if (s != null) {
                                       s.autoWrite();
                                    }
                                 } else {
                                    s.useMemory(this, (int)offset, true);
                                    s.write();
                                 }
                              } else if (Callback.class.isAssignableFrom(type)) {
                                 this.setPointer(offset, CallbackReference.getFunctionPointer((Callback)value));
                              } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(type)) {
                                 Pointer p = value == null ? null : Native.getDirectBufferPointer((Buffer)value);
                                 this.setPointer(offset, p);
                              } else if (NativeMapped.class.isAssignableFrom(type)) {
                                 NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
                                 Class nativeType = tc.nativeType();
                                 this.setValue(offset, tc.toNative(value, new ToNativeContext()), nativeType);
                              } else {
                                 if (!type.isArray()) {
                                    throw new IllegalArgumentException("Writing " + type + " to memory is not supported");
                                 }

                                 this.writeArray(offset, value, type.getComponentType());
                              }
                           } else {
                              this.setDouble(offset, value == null ? 0.0D : (Double)value);
                           }
                        } else {
                           this.setFloat(offset, value == null ? 0.0F : (Float)value);
                        }
                     } else {
                        this.setLong(offset, value == null ? 0L : (Long)value);
                     }
                  } else {
                     this.setInt(offset, value == null ? 0 : (Integer)value);
                  }
               } else {
                  this.setChar(offset, value == null ? '\u0000' : (Character)value);
               }
            } else {
               this.setShort(offset, value == null ? 0 : (Short)value);
            }
         } else {
            this.setByte(offset, value == null ? 0 : (Byte)value);
         }
      } else {
         this.setInt(offset, Boolean.TRUE.equals(value) ? -1 : 0);
      }

   }

   private void writeArray(long offset, Object value, Class cls) {
      if (cls == Byte.TYPE) {
         byte[] buf = (byte[])((byte[])value);
         this.write(offset, (byte[])buf, 0, buf.length);
      } else if (cls == Short.TYPE) {
         short[] buf = (short[])((short[])value);
         this.write(offset, (short[])buf, 0, buf.length);
      } else if (cls == Character.TYPE) {
         char[] buf = (char[])((char[])value);
         this.write(offset, (char[])buf, 0, buf.length);
      } else if (cls == Integer.TYPE) {
         int[] buf = (int[])((int[])value);
         this.write(offset, (int[])buf, 0, buf.length);
      } else if (cls == Long.TYPE) {
         long[] buf = (long[])((long[])value);
         this.write(offset, (long[])buf, 0, buf.length);
      } else if (cls == Float.TYPE) {
         float[] buf = (float[])((float[])value);
         this.write(offset, (float[])buf, 0, buf.length);
      } else if (cls == Double.TYPE) {
         double[] buf = (double[])((double[])value);
         this.write(offset, (double[])buf, 0, buf.length);
      } else if (Pointer.class.isAssignableFrom(cls)) {
         Pointer[] buf = (Pointer[])((Pointer[])value);
         this.write(offset, (Pointer[])buf, 0, buf.length);
      } else {
         int i;
         if (Structure.class.isAssignableFrom(cls)) {
            Structure[] sbuf = (Structure[])((Structure[])value);
            if (Structure.ByReference.class.isAssignableFrom(cls)) {
               Pointer[] buf = new Pointer[sbuf.length];

               for(int i = 0; i < sbuf.length; ++i) {
                  if (sbuf[i] == null) {
                     buf[i] = null;
                  } else {
                     buf[i] = sbuf[i].getPointer();
                     sbuf[i].write();
                  }
               }

               this.write(offset, (Pointer[])buf, 0, buf.length);
            } else {
               Structure first = sbuf[0];
               if (first == null) {
                  first = Structure.newInstance(cls, this.share(offset));
                  sbuf[0] = first;
               } else {
                  first.useMemory(this, (int)offset, true);
               }

               first.write();
               Structure[] tmp = first.toArray(sbuf.length);

               for(i = 1; i < sbuf.length; ++i) {
                  if (sbuf[i] == null) {
                     sbuf[i] = tmp[i];
                  } else {
                     sbuf[i].useMemory(this, (int)(offset + (long)(i * sbuf[i].size())), true);
                  }

                  sbuf[i].write();
               }
            }
         } else {
            if (!NativeMapped.class.isAssignableFrom(cls)) {
               throw new IllegalArgumentException("Writing array of " + cls + " to memory not supported");
            }

            NativeMapped[] buf = (NativeMapped[])((NativeMapped[])value);
            NativeMappedConverter tc = NativeMappedConverter.getInstance(cls);
            Class nativeType = tc.nativeType();
            i = Native.getNativeSize(value.getClass(), value) / buf.length;

            for(int i = 0; i < buf.length; ++i) {
               Object element = tc.toNative(buf[i], new ToNativeContext());
               this.setValue(offset + (long)(i * i), element, nativeType);
            }
         }
      }

   }

   public void setMemory(long offset, long length, byte value) {
      Native.setMemory(this, this.peer, offset, length, value);
   }

   public void setByte(long offset, byte value) {
      Native.setByte(this, this.peer, offset, value);
   }

   public void setShort(long offset, short value) {
      Native.setShort(this, this.peer, offset, value);
   }

   public void setChar(long offset, char value) {
      Native.setChar(this, this.peer, offset, value);
   }

   public void setInt(long offset, int value) {
      Native.setInt(this, this.peer, offset, value);
   }

   public void setLong(long offset, long value) {
      Native.setLong(this, this.peer, offset, value);
   }

   public void setNativeLong(long offset, NativeLong value) {
      if (NativeLong.SIZE == 8) {
         this.setLong(offset, value.longValue());
      } else {
         this.setInt(offset, value.intValue());
      }

   }

   public void setFloat(long offset, float value) {
      Native.setFloat(this, this.peer, offset, value);
   }

   public void setDouble(long offset, double value) {
      Native.setDouble(this, this.peer, offset, value);
   }

   public void setPointer(long offset, Pointer value) {
      Native.setPointer(this, this.peer, offset, value != null ? value.peer : 0L);
   }

   /** @deprecated */
   @Deprecated
   public void setString(long offset, String value, boolean wide) {
      if (wide) {
         this.setWideString(offset, value);
      } else {
         this.setString(offset, value);
      }

   }

   public void setWideString(long offset, String value) {
      Native.setWideString(this, this.peer, offset, value);
   }

   public void setString(long offset, WString value) {
      this.setWideString(offset, value == null ? null : value.toString());
   }

   public void setString(long offset, String value) {
      this.setString(offset, value, Native.getDefaultStringEncoding());
   }

   public void setString(long offset, String value, String encoding) {
      byte[] data = Native.getBytes(value, encoding);
      this.write(offset, (byte[])data, 0, data.length);
      this.setByte(offset + (long)data.length, (byte)0);
   }

   public String dump(long offset, int size) {
      int BYTES_PER_ROW = true;
      String TITLE = "memory dump";
      StringWriter sw = new StringWriter("memory dump".length() + 2 + size * 2 + size / 4 * 4);
      PrintWriter out = new PrintWriter(sw);
      out.println("memory dump");

      for(int i = 0; i < size; ++i) {
         byte b = this.getByte(offset + (long)i);
         if (i % 4 == 0) {
            out.print("[");
         }

         if (b >= 0 && b < 16) {
            out.print("0");
         }

         out.print(Integer.toHexString(b & 255));
         if (i % 4 == 3 && i < size - 1) {
            out.println("]");
         }
      }

      if (sw.getBuffer().charAt(sw.getBuffer().length() - 2) != ']') {
         out.println("]");
      }

      return sw.toString();
   }

   public String toString() {
      return "native@0x" + Long.toHexString(this.peer);
   }

   public static long nativeValue(Pointer p) {
      return p == null ? 0L : p.peer;
   }

   public static void nativeValue(Pointer p, long value) {
      p.peer = value;
   }

   static {
      if ((SIZE = Native.POINTER_SIZE) == 0) {
         throw new Error("Native library not initialized");
      } else {
         NULL = null;
      }
   }

   private static class Opaque extends Pointer {
      private final String MSG;

      private Opaque(long peer) {
         super(peer);
         this.MSG = "This pointer is opaque: " + this;
      }

      public Pointer share(long offset, long size) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void clear(long size) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public long indexOf(long offset, byte value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void read(long bOff, byte[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void read(long bOff, char[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void read(long bOff, short[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void read(long bOff, int[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void read(long bOff, long[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void read(long bOff, float[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void read(long bOff, double[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void read(long bOff, Pointer[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void write(long bOff, byte[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void write(long bOff, char[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void write(long bOff, short[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void write(long bOff, int[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void write(long bOff, long[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void write(long bOff, float[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void write(long bOff, double[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void write(long bOff, Pointer[] buf, int index, int length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public ByteBuffer getByteBuffer(long offset, long length) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public byte getByte(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public char getChar(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public short getShort(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public int getInt(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public long getLong(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public float getFloat(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public double getDouble(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public Pointer getPointer(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public String getString(long bOff, String encoding) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public String getWideString(long bOff) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setByte(long bOff, byte value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setChar(long bOff, char value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setShort(long bOff, short value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setInt(long bOff, int value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setLong(long bOff, long value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setFloat(long bOff, float value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setDouble(long bOff, double value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setPointer(long offset, Pointer value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setString(long offset, String value, String encoding) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setWideString(long offset, String value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public void setMemory(long offset, long size, byte value) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public String dump(long offset, int size) {
         throw new UnsupportedOperationException(this.MSG);
      }

      public String toString() {
         return "const@0x" + Long.toHexString(this.peer);
      }

      // $FF: synthetic method
      Opaque(long x0, Object x1) {
         this(x0);
      }
   }
}
