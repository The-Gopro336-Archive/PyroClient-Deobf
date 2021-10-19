/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdy extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdy
   public static fdy field_64 = new fdy();

   public Object invoke(Object var1) {
      return this.method_100((ItemStack)var1);
   }

   public fdy() {
      super(1);
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_100(@NotNull ItemStack var1) {
      return var1.isEmpty();
   }
}
