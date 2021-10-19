/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdE extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdE
   public static fdE field_73 = new fdE();

   public Object invoke(Object var1) {
      return this.method_108((ItemStack)var1);
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_108(@NotNull ItemStack var1) {
      return var1.isEmpty();
   }

   public fdE() {
      super(1);
   }
}
