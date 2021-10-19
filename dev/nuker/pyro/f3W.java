/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.jetbrains.annotations.NotNull;

public class f3W implements f3X {
   // $FF: renamed from: c dev.nuker.pyro.f3W
   public static f3W field_2132;

   // $FF: renamed from: c (java.io.DataInputStream) java.lang.Object
   public Object method_17(DataInputStream var1) {
      return this.method_3208(var1);
   }

   // $FF: renamed from: c (java.lang.Object, java.io.DataOutputStream) void
   public void method_18(@NotNull Object var1, @NotNull DataOutputStream var2) {
      var2.writeUTF((String)var1);
   }

   static {
      f3W var0 = new f3W();
      field_2132 = var0;
   }

   // $FF: renamed from: c (java.io.DataInputStream) java.lang.String
   public String method_3208(@NotNull DataInputStream var1) {
      return var1.readUTF();
   }
}
