/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public class UtilsKt$hexString$1 extends Lambda implements Function1 {
   public static UtilsKt$hexString$1 INSTANCE = new UtilsKt$hexString$1();

   public Object invoke(Object var1) {
      return this.invoke(((Number)var1).byteValue());
   }

   @NotNull
   public String invoke(byte it) {
      String var2 = "%02x";
      Object[] var3 = new Object[]{it};
      boolean var4 = false;
      return String.format(var2, Arrays.copyOf(var3, var3.length));
   }

   public UtilsKt$hexString$1() {
      super(1);
   }
}
