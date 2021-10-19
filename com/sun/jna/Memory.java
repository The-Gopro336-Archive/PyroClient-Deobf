package com.sun.jna;

import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public class Memory extends Pointer {
   private static final Map allocatedMemory = Collections.synchronizedMap(new WeakHashMap());
   private static final WeakMemoryHolder buffers = new WeakMemoryHolder();
   protected long size;

   public static void purge() {
      buffers.clean();
   }

   public static void disposeAll() {
      Collection refs = new LinkedList(allocatedMemory.keySet());
      Iterator var1 = refs.iterator();

      while(var1.hasNext()) {
         Memory r = (Memory)var1.next();
         r.dispose();
      }

   }

   public Memory(long size) {
      this.size = size;
      if (size <= 0L) {
         throw new IllegalArgumentException("Allocation size must be greater than zero");
      } else {
         this.peer = malloc(size);
         if (this.peer == 0L) {
            throw new OutOfMemoryError("Cannot allocate " + size + " bytes");
         } else {
            allocatedMemory.put(this, new WeakReference(this));
         }
      }
   }

   protected Memory() {
   }

   public Pointer share(long offset) {
      return this.share(offset, this.size() - offset);
   }

   public Pointer share(long offset, long sz) {
      this.boundsCheck(offset, sz);
      return new Memory.SharedMemory(offset, sz);
   }

   public Memory align(int byteBoundary) {
      if (byteBoundary <= 0) {
         throw new IllegalArgumentException("Byte boundary must be positive: " + byteBoundary);
      } else {
         for(int i = 0; i < 32; ++i) {
            if (byteBoundary == 1 << i) {
               long mask = ~((long)byteBoundary - 1L);
               if ((this.peer & mask) != this.peer) {
                  long newPeer = this.peer + (long)byteBoundary - 1L & mask;
                  long newSize = this.peer + this.size - newPeer;
                  if (newSize <= 0L) {
                     throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
                  }

                  return (Memory)this.share(newPeer - this.peer, newSize);
               }

               return this;
            }
         }

         throw new IllegalArgumentException("Byte boundary must be a power of two");
      }
   }

   protected void finalize() {
      this.dispose();
   }

   protected synchronized void dispose() {
      try {
         free(this.peer);
      } finally {
         allocatedMemory.remove(this);
         this.peer = 0L;
      }

   }

   public void clear() {
      this.clear(this.size);
   }

   public boolean valid() {
      return this.peer != 0L;
   }

   public long size() {
      return this.size;
   }

   protected void boundsCheck(long off, long sz) {
      if (off < 0L) {
         throw new IndexOutOfBoundsException("Invalid offset: " + off);
      } else if (off + sz > this.size) {
         String msg = "Bounds exceeds available space : size=" + this.size + ", offset=" + (off + sz);
         throw new IndexOutOfBoundsException(msg);
      }
   }

   public void read(long bOff, byte[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 1L);
      super.read(bOff, buf, index, length);
   }

   public void read(long bOff, short[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 2L);
      super.read(bOff, buf, index, length);
   }

   public void read(long bOff, char[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 2L);
      super.read(bOff, buf, index, length);
   }

   public void read(long bOff, int[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 4L);
      super.read(bOff, buf, index, length);
   }

   public void read(long bOff, long[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 8L);
      super.read(bOff, buf, index, length);
   }

   public void read(long bOff, float[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 4L);
      super.read(bOff, buf, index, length);
   }

   public void read(long bOff, double[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 8L);
      super.read(bOff, buf, index, length);
   }

   public void write(long bOff, byte[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 1L);
      super.write(bOff, buf, index, length);
   }

   public void write(long bOff, short[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 2L);
      super.write(bOff, buf, index, length);
   }

   public void write(long bOff, char[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 2L);
      super.write(bOff, buf, index, length);
   }

   public void write(long bOff, int[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 4L);
      super.write(bOff, buf, index, length);
   }

   public void write(long bOff, long[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 8L);
      super.write(bOff, buf, index, length);
   }

   public void write(long bOff, float[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 4L);
      super.write(bOff, buf, index, length);
   }

   public void write(long bOff, double[] buf, int index, int length) {
      this.boundsCheck(bOff, (long)length * 8L);
      super.write(bOff, buf, index, length);
   }

   public byte getByte(long offset) {
      this.boundsCheck(offset, 1L);
      return super.getByte(offset);
   }

   public char getChar(long offset) {
      this.boundsCheck(offset, 1L);
      return super.getChar(offset);
   }

   public short getShort(long offset) {
      this.boundsCheck(offset, 2L);
      return super.getShort(offset);
   }

   public int getInt(long offset) {
      this.boundsCheck(offset, 4L);
      return super.getInt(offset);
   }

   public long getLong(long offset) {
      this.boundsCheck(offset, 8L);
      return super.getLong(offset);
   }

   public float getFloat(long offset) {
      this.boundsCheck(offset, 4L);
      return super.getFloat(offset);
   }

   public double getDouble(long offset) {
      this.boundsCheck(offset, 8L);
      return super.getDouble(offset);
   }

   public Pointer getPointer(long offset) {
      this.boundsCheck(offset, (long)Pointer.SIZE);
      return super.getPointer(offset);
   }

   public ByteBuffer getByteBuffer(long offset, long length) {
      this.boundsCheck(offset, length);
      ByteBuffer b = super.getByteBuffer(offset, length);
      buffers.put(b, this);
      return b;
   }

   public String getString(long offset, String encoding) {
      this.boundsCheck(offset, 0L);
      return super.getString(offset, encoding);
   }

   public String getWideString(long offset) {
      this.boundsCheck(offset, 0L);
      return super.getWideString(offset);
   }

   public void setByte(long offset, byte value) {
      this.boundsCheck(offset, 1L);
      super.setByte(offset, value);
   }

   public void setChar(long offset, char value) {
      this.boundsCheck(offset, (long)Native.WCHAR_SIZE);
      super.setChar(offset, value);
   }

   public void setShort(long offset, short value) {
      this.boundsCheck(offset, 2L);
      super.setShort(offset, value);
   }

   public void setInt(long offset, int value) {
      this.boundsCheck(offset, 4L);
      super.setInt(offset, value);
   }

   public void setLong(long offset, long value) {
      this.boundsCheck(offset, 8L);
      super.setLong(offset, value);
   }

   public void setFloat(long offset, float value) {
      this.boundsCheck(offset, 4L);
      super.setFloat(offset, value);
   }

   public void setDouble(long offset, double value) {
      this.boundsCheck(offset, 8L);
      super.setDouble(offset, value);
   }

   public void setPointer(long offset, Pointer value) {
      this.boundsCheck(offset, (long)Pointer.SIZE);
      super.setPointer(offset, value);
   }

   public void setString(long offset, String value, String encoding) {
      this.boundsCheck(offset, (long)Native.getBytes(value, encoding).length + 1L);
      super.setString(offset, value, encoding);
   }

   public void setWideString(long offset, String value) {
      this.boundsCheck(offset, ((long)value.length() + 1L) * (long)Native.WCHAR_SIZE);
      super.setWideString(offset, value);
   }

   public String toString() {
      return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
   }

   protected static void free(long p) {
      if (p != 0L) {
         Native.free(p);
      }

   }

   protected static long malloc(long size) {
      return Native.malloc(size);
   }

   public String dump() {
      return this.dump(0L, (int)this.size());
   }

   private class SharedMemory extends Memory {
      public SharedMemory(long offset, long size) {
         this.size = size;
         this.peer = Memory.this.peer + offset;
      }

      protected void dispose() {
         this.peer = 0L;
      }

      protected void boundsCheck(long off, long sz) {
         Memory.this.boundsCheck(this.peer - Memory.this.peer + off, sz);
      }

      public String toString() {
         return super.toString() + " (shared from " + Memory.this.toString() + ")";
      }
   }
}
