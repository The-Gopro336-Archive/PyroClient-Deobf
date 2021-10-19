/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public class f7B {
   // $FF: renamed from: c java.net.Socket
   @NotNull
   public Socket field_1751;
   // $FF: renamed from: c java.io.DataInputStream
   @NotNull
   public DataInputStream field_1752;
   // $FF: renamed from: c java.io.DataOutputStream
   @NotNull
   public DataOutputStream field_1753;
   // $FF: renamed from: c dev.nuker.pyro.f7G
   public f7G field_1754;

   public f7B(@NotNull f7G var1, @NotNull Socket var2, @NotNull DataInputStream var3, DataOutputStream var4) {
      this.field_1754 = var1;
      super();
      this.field_1751 = var2;
      this.field_1752 = var3;
      this.field_1753 = var4;
      ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)(new f7A(this)), 30, (Object)null);
   }

   // $FF: renamed from: 0 () java.io.DataInputStream
   @NotNull
   public DataInputStream method_2985() {
      return this.field_1752;
   }

   // $FF: renamed from: 1 () java.io.DataOutputStream
   @NotNull
   public DataOutputStream method_2986() {
      return this.field_1753;
   }

   // $FF: renamed from: c () java.net.Socket
   @NotNull
   public Socket method_2987() {
      return this.field_1751;
   }

   public f7B(@NotNull f7G var1, Socket var2) {
      this(var1, var2, new DataInputStream(var2.getInputStream()), new DataOutputStream(var2.getOutputStream()));
   }
}
