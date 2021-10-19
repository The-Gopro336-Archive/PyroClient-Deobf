/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdB extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdB
   public static fdB field_71 = new fdB();

   public Object invoke(Object var1) {
      return this.method_106((ItemStack)var1);
   }

   public fdB() {
      super(1);
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_106(@NotNull ItemStack var1) {
      return var1.isEmpty();
   }
}
