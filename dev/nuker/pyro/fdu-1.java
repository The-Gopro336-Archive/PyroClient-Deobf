/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdu extends Lambda implements Function1 {
   // $FF: renamed from: c net.minecraft.item.ItemStack
   public ItemStack field_67;
   // $FF: renamed from: c dev.nuker.pyro.fdF
   public fdF field_68;

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_103(@NotNull ItemStack var1) {
      return this.field_68.method_1302(this.field_67, var1);
   }

   public fdu(ItemStack var1, fdF var2) {
      this.field_67 = var1;
      this.field_68 = var2;
      super(1);
   }

   public Object invoke(Object var1) {
      return this.method_103((ItemStack)var1);
   }
}
