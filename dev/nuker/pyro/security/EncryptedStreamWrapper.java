/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class EncryptedStreamWrapper {
   @NotNull
   public SecretKey key;
   @NotNull
   public SecureRandom random;
   @NotNull
   public byte[] salt;
   // $FF: renamed from: iv byte[]
   @NotNull
   public byte[] field_2458;
   // $FF: renamed from: i byte
   public byte field_2459;
   @NotNull
   public DataInputStream inStream;
   @NotNull
   public DataOutputStream outStream;

   public void setI(byte var1) {
      this.field_2459 = var1;
   }

   public void setKey(@NotNull SecretKey var1) {
      this.key = var1;
   }

   public int readInt() {
      boolean var1 = false;
      boolean var3 = false;
      DataInputStream $this$readByteArray$iv$iv = this.getInStream();
      boolean var5 = false;
      InputStream $this$readByteArray$iv$iv$iv = (InputStream)$this$readByteArray$iv$iv;
      int length$iv$iv$iv = $this$readByteArray$iv$iv.readInt();
      boolean var8 = false;
      byte[] array$iv$iv$iv = new byte[length$iv$iv$iv];

      int read$iv$iv$iv;
      for(int bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < length$iv$iv$iv; bytesRead$iv$iv$iv += read$iv$iv$iv) {
         read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(array$iv$iv$iv, bytesRead$iv$iv$iv, array$iv$iv$iv.length - bytesRead$iv$iv$iv);
         if (read$iv$iv$iv == -1) {
            break;
         }
      }

      return ByteBuffer.wrap(Encryption.INSTANCE.decryptWithPrefixIV(array$iv$iv$iv, this.getKey())).getInt();
   }

   @NotNull
   public byte[] readByteArray() {
      boolean var1 = false;
      DataInputStream $this$readByteArray$iv = this.getInStream();
      boolean var4 = false;
      InputStream $this$readByteArray$iv$iv = (InputStream)$this$readByteArray$iv;
      int length$iv$iv = $this$readByteArray$iv.readInt();
      boolean var7 = false;
      byte[] array$iv$iv = new byte[length$iv$iv];

      int read$iv$iv;
      for(int bytesRead$iv$iv = 0; bytesRead$iv$iv < length$iv$iv; bytesRead$iv$iv += read$iv$iv) {
         read$iv$iv = $this$readByteArray$iv$iv.read(array$iv$iv, bytesRead$iv$iv, array$iv$iv.length - bytesRead$iv$iv);
         if (read$iv$iv == -1) {
            break;
         }
      }

      return Encryption.INSTANCE.decryptWithPrefixIV(array$iv$iv, this.getKey());
   }

   public void writeByteArray(@NotNull byte[] byteArray) {
      int $i$f$writeByteArray = false;
      byte[] var3 = Encryption.INSTANCE.encryptWithPrefixIV(byteArray, this.getKey(), this.getIv());
      DataOutputStream $this$writeByteArray$iv = this.getOutStream();
      if (var3 == null) {
         Intrinsics.throwNpe();
      }

      boolean var6 = false;
      $this$writeByteArray$iv.writeInt(var3.length);
      $this$writeByteArray$iv.write(var3);
   }

   @NotNull
   public byte[] getSalt() {
      byte[] var10000 = this.salt;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("salt");
      }

      return var10000;
   }

   @NotNull
   public DataInputStream getInStream() {
      return this.inStream;
   }

   public byte getI() {
      return this.field_2459;
   }

   public void setRandom(@NotNull SecureRandom var1) {
      this.random = var1;
   }

   public void setIv(@NotNull byte[] var1) {
      this.field_2458 = var1;
   }

   @NotNull
   public DataOutputStream getOutStream() {
      return this.outStream;
   }

   @NotNull
   public SecretKey getKey() {
      SecretKey var10000 = this.key;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("key");
      }

      return var10000;
   }

   public void writeInt(int value) {
      int $i$f$writeInt = false;
      byte[] var4 = ByteBuffer.allocate(4).putInt(value).array();
      boolean var5 = false;
      byte[] var6 = Encryption.INSTANCE.encryptWithPrefixIV(var4, this.getKey(), this.getIv());
      DataOutputStream $this$writeByteArray$iv$iv = this.getOutStream();
      if (var6 == null) {
         Intrinsics.throwNpe();
      }

      boolean var9 = false;
      $this$writeByteArray$iv$iv.writeInt(var6.length);
      $this$writeByteArray$iv$iv.write(var6);
   }

   public void setSalt(@NotNull byte[] var1) {
      this.salt = var1;
   }

   @NotNull
   public byte[] getIv() {
      byte[] var10000 = this.field_2458;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("iv");
      }

      return var10000;
   }

   @NotNull
   public SecureRandom getRandom() {
      SecureRandom var10000 = this.random;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("random");
      }

      return var10000;
   }

   public void setKey(@NotNull byte[] key) {
      int $i$f$setKey = false;
      byte[] var10001 = new byte[]{32, 120, 45, 34, 66, 43, 87, 54, 0, 0, 0};
      byte var3;
      this.setI((byte)((var3 = this.getI()) + 1));
      var10001[8] = var3;
      var10001[9] = 16;
      var10001[10] = 86;
      this.setSalt(var10001);
      var10001 = Encryption.INSTANCE.getRandomNonce(12);
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      this.setIv(var10001);
      Encryption var6 = Encryption.INSTANCE;
      boolean var4 = false;
      String var7 = ArraysKt.joinToString$default(key, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)UtilsKt$hexString$1.INSTANCE, 30, (Object)null);
      var4 = false;
      if (var7 == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         char[] var8 = var7.toCharArray();
         SecretKey var9 = var6.getAESKeyFromPassword(var8, this.getSalt());
         if (var9 == null) {
            Intrinsics.throwNpe();
         }

         this.setKey(var9);
      }
   }

   public EncryptedStreamWrapper(@NotNull DataInputStream inStream, @NotNull DataOutputStream outStream) {
      this.inStream = inStream;
      this.outStream = outStream;
   }
}
