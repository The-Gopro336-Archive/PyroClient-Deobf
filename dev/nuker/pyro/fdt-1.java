/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdt extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdt
   public static fdt field_69 = new fdt();

   public fdt() {
      super(1);
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_104(@NotNull ItemStack var1) {
      return var1.isEmpty();
   }

   public Object invoke(Object var1) {
      return this.method_104((ItemStack)var1);
   }
}
