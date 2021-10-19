/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdv extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdv
   public static fdv field_66 = new fdv();

   public fdv() {
      super(1);
   }

   public Object invoke(Object var1) {
      return this.method_102((ItemStack)var1);
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_102(@NotNull ItemStack var1) {
      return var1.isEmpty();
   }
}
