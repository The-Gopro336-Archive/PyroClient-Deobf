/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.jetbrains.annotations.NotNull;

public class f3V implements f3X {
   // $FF: renamed from: c dev.nuker.pyro.f3V
   public static f3V field_2129;

   // $FF: renamed from: c (java.lang.Object, java.io.DataOutputStream) void
   public void method_18(@NotNull Object var1, @NotNull DataOutputStream var2) {
      var2.writeInt((Integer)var1);
   }

   // $FF: renamed from: c (java.io.DataInputStream) java.lang.Object
   public Object method_17(DataInputStream var1) {
      return this.method_3206(var1);
   }

   static {
      f3V var0 = new f3V();
      field_2129 = var0;
   }

   // $FF: renamed from: c (java.io.DataInputStream) java.lang.Integer
   @NotNull
   public Integer method_3206(@NotNull DataInputStream var1) {
      return var1.readInt();
   }
}
