/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.nuker.pyro.security.Encryption$hex$1
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.security;

import dev.nuker.pyro.security.Encryption;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.SecureRandom;
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
    public static String Field4540;
    public static int Field4541;
    public static int Field4542;
    public static int Field4543;
    public static Charset Field4544;
    public static Encryption Field4545;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void Method6533() {
        block76: {
            v0 = Class.forName("javax.crypto.JceSecurity");
            jceSecurity = v0;
            v1 = "javax.crypto.CryptoPermissions";
            v2 = Class.forName(v1);
            cryptoPermissions = v2;
            v3 = "javax.crypto.CryptoAllPermission";
            v4 = Class.forName(v3);
            cryptoAllPermission = v4;
            v5 = jceSecurity;
            v6 = "isRestricted";
            v7 = v5.getDeclaredField(v6);
            v8 = isRestrictedField = v7;
            v9 = true;
            v8.setAccessible(v9);
            v10 = Field.class;
            v11 = "modifiers";
            v12 = v10.getDeclaredField(v11);
            v13 = modifiersField = v12;
            v14 = true;
            v13.setAccessible(v14);
            v15 = modifiersField;
            v16 = isRestrictedField;
            v17 = isRestrictedField;
            v18 = v17.getModifiers();
            v19 = v18 & -17;
            v15.setInt(v16, v19);
            v20 = isRestrictedField;
            v21 = null;
            v22 = false;
            v23 = v22;
            v20.set(v21, v23);
            v24 = jceSecurity;
            v25 = "defaultPolicy";
            v26 = v24.getDeclaredField(v25);
            v27 = defaultPolicyField = v26;
            v28 = true;
            v27.setAccessible(v28);
            v29 = defaultPolicyField;
            v30 = null;
            v31 = v29.get(v30);
            v32 = v31;
            if (v31 != null) ** GOTO lbl88
            v33 = v34;
            v35 = v34;
            v36 = "null cannot be cast to non-null type java.security.PermissionCollection";
            v33(v36);
            throw v35;
lbl88:
            // 1 sources

            defaultPolicy = (PermissionCollection)v32;
            v37 = cryptoPermissions;
            v38 = "perms";
            v39 = v37.getDeclaredField(v38);
            v40 = perms = v39;
            v41 = true;
            v40.setAccessible(v41);
            v42 = perms;
            v43 = defaultPolicy;
            v44 = v42.get(v43);
            v45 = v44;
            if (v44 != null) break block76;
            v46 = v47;
            v48 = v47;
            v49 = "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>";
            v46(v49);
            throw v48;
        }
        v50 = TypeIntrinsics.Method5573(v45);
        v50.clear();
        v51 = cryptoAllPermission;
        v52 = "INSTANCE";
        v53 = v51.getDeclaredField(v52);
        v54 = instance = v53;
        v55 = true;
        v54.setAccessible(v55);
        v56 = defaultPolicy;
        v57 = instance;
        v58 = null;
        v59 = v57.get(v58);
        v60 = v59;
        if (v59 != null) ** GOTO lbl150
        v61 = v62;
        v63 = v62;
        v64 = "null cannot be cast to non-null type java.security.Permission";
        v61(v64);
        throw v63;
lbl150:
        // 1 sources

        v65 = (Permission)v60;
        try {
            v56.add(v65);
            return;
        }
        catch (Exception var1_1) {
            // empty catch block
        }
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public byte[] Method6534(@Nullable byte[] arrby, @Nullable SecretKey secretKey, @NotNull byte[] arrby2) {
        void iv;
        void secret;
        void pText;
        byte[] cipherText = this.Method6538((byte[])pText, (SecretKey)secret, (byte[])iv);
        return ByteBuffer.allocate(((void)iv).length + cipherText.length).put((byte[])iv).put(cipherText).array();
    }

    static {
        Encryption encryption;
        Field4543 = 256;
        Field4542 = 12;
        Field4541 = 128;
        Field4540 = "AES/GCM/NoPadding";
        Field4545 = encryption = new Encryption();
        Field4544 = StandardCharsets.UTF_8;
        encryption.Method6533();
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public String Method6535(@NotNull byte[] arrby, int n) {
        void bytes;
        void blockSize;
        void blockSize2 = blockSize;
        String hex = this.Method6542((byte[])bytes);
        List result = new ArrayList();
        for (int index = 0; index < hex.length(); index += (blockSize2 *= 2)) {
            String string;
            String string2 = hex;
            int n2 = Math.min(index + blockSize2, hex.length());
            List list = result;
            boolean bl = false;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string3.substring(index, n2);
            list.add(string);
        }
        return result.toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public byte[] Method6536(@Nullable byte[] arrby, @Nullable SecretKey secretKey, @Nullable byte[] arrby2) {
        void cText;
        void iv;
        void secret;
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, (Key)secret, new GCMParameterSpec(128, (byte[])iv));
        return cipher.doFinal((byte[])cText);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public SecretKey Method6537(@Nullable char[] arrc, @Nullable byte[] arrby) {
        void salt;
        void password;
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec((char[])password, (byte[])salt, 65536, 256);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public byte[] Method6538(@Nullable byte[] arrby, @Nullable SecretKey secretKey, @Nullable byte[] arrby2) {
        void pText;
        void iv;
        void secret;
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, (Key)secret, new GCMParameterSpec(128, (byte[])iv));
        return cipher.doFinal((byte[])pText);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public byte[] Method6539(@Nullable byte[] arrby, @Nullable SecretKey secretKey) {
        void secret;
        void cText;
        ByteBuffer bb = ByteBuffer.wrap((byte[])cText);
        byte[] iv = new byte[12];
        bb.get(iv);
        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);
        return this.Method6536(cipherText, (SecretKey)secret, iv);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public byte[] Method6540(int n) {
        void numBytes;
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public SecretKey Method6541(int n) {
        void keysize;
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init((int)keysize, SecureRandom.getInstanceStrong());
        return keyGen.generateKey();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public String Method6542(@NotNull byte[] arrby) {
        void bytes;
        return ArraysKt.Method11276((byte[])bytes, "", null, null, 0, null, (Function1)hex.1.INSTANCE, 30, null);
    }
}

