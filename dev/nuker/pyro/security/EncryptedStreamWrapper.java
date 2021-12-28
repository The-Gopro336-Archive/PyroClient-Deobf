/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro.security;

import dev.nuker.pyro.security.Encryption;
import dev.nuker.pyro.security.UtilsKt$hexString$1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class EncryptedStreamWrapper {
    @NotNull
    public SecretKey Field5820;
    @NotNull
    public SecureRandom Field5821;
    @NotNull
    public byte[] Field5822;
    @NotNull
    public byte[] Field5823;
    public byte Field5824;
    @NotNull
    public DataInputStream Field5825;
    @NotNull
    public DataOutputStream Field5826;

    /*
     * WARNING - void declaration
     */
    public void Method8431(byte by) {
        void <set-?>;
        this.Field5824 = <set-?>;
    }

    /*
     * WARNING - void declaration
     */
    public void Method8432(@NotNull SecretKey secretKey) {
        void <set-?>;
        this.Field5820 = <set-?>;
    }

    /*
     * WARNING - void declaration
     */
    public int Method8433() {
        void $this$readByteArray$iv$iv$iv;
        int read$iv$iv$iv;
        boolean $i$f$readInt = false;
        EncryptedStreamWrapper this_$iv = this;
        boolean $i$f$readByteArray = false;
        DataInputStream $this$readByteArray$iv$iv = this_$iv.Method8437();
        boolean $i$f$readByteArray2 = false;
        InputStream inputStream = $this$readByteArray$iv$iv;
        int length$iv$iv$iv = $this$readByteArray$iv$iv.readInt();
        boolean $i$f$readByteArray3 = false;
        byte[] array$iv$iv$iv = new byte[length$iv$iv$iv];
        for (int bytesRead$iv$iv$iv = 0; bytesRead$iv$iv$iv < length$iv$iv$iv && (read$iv$iv$iv = $this$readByteArray$iv$iv$iv.read(array$iv$iv$iv, bytesRead$iv$iv$iv, array$iv$iv$iv.length - bytesRead$iv$iv$iv)) != -1; bytesRead$iv$iv$iv += read$iv$iv$iv) {
        }
        byte[] encrypted$iv = array$iv$iv$iv;
        return ByteBuffer.wrap(Encryption.Field4545.Method6539(encrypted$iv, this_$iv.Method8442())).getInt();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public byte[] Method8434() {
        void $this$readByteArray$iv$iv;
        int read$iv$iv;
        boolean $i$f$readByteArray = false;
        DataInputStream $this$readByteArray$iv = this.Method8437();
        boolean $i$f$readByteArray2 = false;
        InputStream inputStream = $this$readByteArray$iv;
        int length$iv$iv = $this$readByteArray$iv.readInt();
        boolean $i$f$readByteArray3 = false;
        byte[] array$iv$iv = new byte[length$iv$iv];
        for (int bytesRead$iv$iv = 0; bytesRead$iv$iv < length$iv$iv && (read$iv$iv = $this$readByteArray$iv$iv.read(array$iv$iv, bytesRead$iv$iv, array$iv$iv.length - bytesRead$iv$iv)) != -1; bytesRead$iv$iv += read$iv$iv) {
        }
        byte[] encrypted = array$iv$iv;
        return Encryption.Field4545.Method6539(encrypted, this.Method8442());
    }

    /*
     * WARNING - void declaration
     */
    public void Method8435(@NotNull byte[] arrby) {
        void $this$writeByteArray$iv;
        void byteArray;
        boolean $i$f$writeByteArray = false;
        byte[] newBytes = Encryption.Field4545.Method6534((byte[])byteArray, this.Method8442(), this.Method8445());
        DataOutputStream dataOutputStream = this.Method8441();
        if (newBytes == null) {
            Intrinsics.Method6551();
        }
        byte[] bytes$iv = newBytes;
        boolean $i$f$writeByteArray2 = false;
        $this$writeByteArray$iv.writeInt(bytes$iv.length);
        $this$writeByteArray$iv.write(bytes$iv);
    }

    @NotNull
    public byte[] Method8436() {
        if (this.Field5822 == null) {
            Intrinsics.Method6554("salt");
        }
        return this.Field5822;
    }

    @NotNull
    public DataInputStream Method8437() {
        return this.Field5825;
    }

    public byte Method8438() {
        return this.Field5824;
    }

    /*
     * WARNING - void declaration
     */
    public void Method8439(@NotNull SecureRandom secureRandom) {
        void <set-?>;
        this.Field5821 = <set-?>;
    }

    /*
     * WARNING - void declaration
     */
    public void Method8440(@NotNull byte[] arrby) {
        void <set-?>;
        this.Field5823 = <set-?>;
    }

    @NotNull
    public DataOutputStream Method8441() {
        return this.Field5826;
    }

    @NotNull
    public SecretKey Method8442() {
        SecretKey secretKey = this.Field5820;
        if (secretKey == null) {
            Intrinsics.Method6554("key");
        }
        return secretKey;
    }

    /*
     * WARNING - void declaration
     */
    public void Method8443(int n) {
        void $this$writeByteArray$iv$iv;
        void this_$iv;
        void value;
        boolean $i$f$writeInt = false;
        EncryptedStreamWrapper encryptedStreamWrapper = this;
        byte[] byteArray$iv = ByteBuffer.allocate(4).putInt((int)value).array();
        boolean $i$f$writeByteArray = false;
        byte[] newBytes$iv = Encryption.Field4545.Method6534(byteArray$iv, this_$iv.Method8442(), this_$iv.Method8445());
        DataOutputStream dataOutputStream = this_$iv.Method8441();
        if (newBytes$iv == null) {
            Intrinsics.Method6551();
        }
        byte[] bytes$iv$iv = newBytes$iv;
        boolean $i$f$writeByteArray2 = false;
        $this$writeByteArray$iv$iv.writeInt(bytes$iv$iv.length);
        $this$writeByteArray$iv$iv.write(bytes$iv$iv);
    }

    /*
     * WARNING - void declaration
     */
    public void Method8444(@NotNull byte[] arrby) {
        void <set-?>;
        this.Field5822 = <set-?>;
    }

    @NotNull
    public byte[] Method8445() {
        if (this.Field5823 == null) {
            Intrinsics.Method6554("iv");
        }
        return this.Field5823;
    }

    @NotNull
    public SecureRandom Method8446() {
        SecureRandom secureRandom = this.Field5821;
        if (secureRandom == null) {
            Intrinsics.Method6554("random");
        }
        return secureRandom;
    }

    /*
     * WARNING - void declaration
     */
    public void Method8447(@NotNull byte[] arrby) {
        void $this$hexString$iv;
        void key;
        boolean $i$f$setKey = false;
        byte[] arrby2 = new byte[11];
        arrby2[0] = 32;
        arrby2[1] = 120;
        arrby2[2] = 45;
        arrby2[3] = 34;
        arrby2[4] = 66;
        arrby2[5] = 43;
        arrby2[6] = 87;
        arrby2[7] = 54;
        EncryptedStreamWrapper encryptedStreamWrapper = this;
        byte by = encryptedStreamWrapper.Method8438();
        encryptedStreamWrapper.Method8431((byte)(by + 1));
        arrby2[8] = by;
        arrby2[9] = 16;
        arrby2[10] = 86;
        this.Method8444(arrby2);
        byte[] arrby3 = Encryption.Field4545.Method6540(12);
        if (arrby3 == null) {
            Intrinsics.Method6551();
        }
        this.Method8440(arrby3);
        String string = key;
        Encryption encryption = Encryption.Field4545;
        EncryptedStreamWrapper encryptedStreamWrapper2 = this;
        boolean $i$f$hexString = false;
        Object object = ArraysKt.Method11276((byte[])$this$hexString$iv, "", null, null, 0, null, UtilsKt$hexString$1.Field3792, 30, null);
        string = object;
        boolean bl = false;
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        object = string2.toCharArray();
        SecretKey secretKey = encryption.Method6537((char[])object, this.Method8436());
        if (secretKey == null) {
            Intrinsics.Method6551();
        }
        encryptedStreamWrapper2.Method8432(secretKey);
    }

    public EncryptedStreamWrapper(@NotNull DataInputStream inStream, @NotNull DataOutputStream outStream) {
        this.Field5825 = inStream;
        this.Field5826 = outStream;
    }
}

