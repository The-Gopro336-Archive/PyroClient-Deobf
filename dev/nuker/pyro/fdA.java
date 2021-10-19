/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdA extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.fdF
   public fdF field_72;

   public Object invoke(Object var1) {
      return this.method_107((ItemStack)var1);
   }

   public fdA(fdF var1) {
      this.field_72 = var1;
      super(1);
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_107(@NotNull ItemStack var1) {
      fdF var10000 = this.field_72;
      ItemStack var10001 = fdF.method_1296(this.field_72);
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      return var10000.method_1302(var10001, var1);
   }
}
