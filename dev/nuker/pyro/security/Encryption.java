/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import dev.nuker.pyro.security.Encryption.hex.1;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Encryption {
   @NotNull
   public static String ENCRYPT_ALGO = "AES/GCM/NoPadding";
   public static int TAG_LENGTH_BIT = 128;
   public static int IV_LENGTH_BYTE = 12;
   public static int AES_KEY_BIT = 256;
   public static Charset UTF_8;
   public static Encryption INSTANCE;

   public void removeCryptographyRestrictions() {
      try {
         Class jceSecurity = Class.forName("javax.crypto.JceSecurity");
         Class cryptoPermissions = Class.forName("javax.crypto.CryptoPermissions");
         Class cryptoAllPermission = Class.forName("javax.crypto.CryptoAllPermission");
         Field isRestrictedField = jceSecurity.getDeclaredField("isRestricted");
         isRestrictedField.setAccessible(true);
         Field modifiersField = Field.class.getDeclaredField("modifiers");
         modifiersField.setAccessible(true);
         modifiersField.setInt(isRestrictedField, isRestrictedField.getModifiers() & -17);
         isRestrictedField.set((Object)null, false);
         Field defaultPolicyField = jceSecurity.getDeclaredField("defaultPolicy");
         defaultPolicyField.setAccessible(true);
         Object var10000 = defaultPolicyField.get((Object)null);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.security.PermissionCollection");
         }

         PermissionCollection defaultPolicy = (PermissionCollection)var10000;
         Field perms = cryptoPermissions.getDeclaredField("perms");
         perms.setAccessible(true);
         var10000 = perms.get(defaultPolicy);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
         }

         TypeIntrinsics.asMutableMap(var10000).clear();
         Field instance = cryptoAllPermission.getDeclaredField("INSTANCE");
         instance.setAccessible(true);
         Object var10001 = instance.get((Object)null);
         if (var10001 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.security.Permission");
         }

         defaultPolicy.add((Permission)var10001);
      } catch (Exception var10) {
      }

   }

   @Nullable
   public byte[] encryptWithPrefixIV(@Nullable byte[] pText, @Nullable SecretKey secret, @NotNull byte[] iv) {
      byte[] cipherText = this.encrypt(pText, secret, iv);
      return ByteBuffer.allocate(iv.length + cipherText.length).put(iv).put(cipherText).array();
   }

   static {
      Encryption var0 = new Encryption();
      INSTANCE = var0;
      UTF_8 = StandardCharsets.UTF_8;
      var0.removeCryptographyRestrictions();
   }

   @Nullable
   public String hexWithBlockSize(@NotNull byte[] bytes, int blockSize) {
      String hex = this.hex(bytes);
      int blockSize = blockSize * 2;
      List result = (List)(new ArrayList());

      for(int index = 0; index < hex.length(); index += blockSize) {
         int var8 = Math.min(index + blockSize, hex.length());
         boolean var9 = false;
         if (hex == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var11 = hex.substring(index, var8);
         result.add(var11);
      }

      return result.toString();
   }

   @NotNull
   public byte[] decrypt(@Nullable byte[] cText, @Nullable SecretKey secret, @Nullable byte[] iv) {
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(2, (Key)secret, (AlgorithmParameterSpec)(new GCMParameterSpec(128, iv)));
      return cipher.doFinal(cText);
   }

   @Nullable
   public SecretKey getAESKeyFromPassword(@Nullable char[] password, @Nullable byte[] salt) {
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      KeySpec var4 = (KeySpec)(new PBEKeySpec(password, salt, 65536, 256));
      return (SecretKey)(new SecretKeySpec(factory.generateSecret(var4).getEncoded(), "AES"));
   }

   @NotNull
   public byte[] encrypt(@Nullable byte[] pText, @Nullable SecretKey secret, @Nullable byte[] iv) {
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(1, (Key)secret, (AlgorithmParameterSpec)(new GCMParameterSpec(128, iv)));
      return cipher.doFinal(pText);
   }

   @NotNull
   public byte[] decryptWithPrefixIV(@Nullable byte[] cText, @Nullable SecretKey secret) {
      ByteBuffer bb = ByteBuffer.wrap(cText);
      byte[] iv = new byte[12];
      bb.get(iv);
      byte[] var5 = new byte[bb.remaining()];
      bb.get(var5);
      return this.decrypt(var5, secret, iv);
   }

   @Nullable
   public byte[] getRandomNonce(int numBytes) {
      byte[] nonce = new byte[numBytes];
      (new SecureRandom()).nextBytes(nonce);
      return nonce;
   }

   @Nullable
   public SecretKey getAESKey(int keysize) {
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(keysize, SecureRandom.getInstanceStrong());
      return keyGen.generateKey();
   }

   @NotNull
   public String hex(@NotNull byte[] bytes) {
      return ArraysKt.joinToString$default(bytes, (CharSequence)"", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)1.INSTANCE, 30, (Object)null);
   }
}
