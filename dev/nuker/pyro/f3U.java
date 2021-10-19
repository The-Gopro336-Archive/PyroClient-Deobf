/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.jetbrains.annotations.NotNull;

public class f3U implements f3X {
   // $FF: renamed from: c dev.nuker.pyro.f3U
   public static f3U field_2110;

   // $FF: renamed from: c (java.io.DataInputStream) java.lang.Boolean
   @NotNull
   public Boolean method_3194(@NotNull DataInputStream var1) {
      return var1.readBoolean();
   }

   // $FF: renamed from: c (java.io.DataInputStream) java.lang.Object
   public Object method_17(DataInputStream var1) {
      return this.method_3194(var1);
   }

   static {
      f3U var0 = new f3U();
      field_2110 = var0;
   }

   // $FF: renamed from: c (java.lang.Object, java.io.DataOutputStream) void
   public void method_18(@NotNull Object var1, @NotNull DataOutputStream var2) {
      var2.writeBoolean((Boolean)var1);
   }
}
