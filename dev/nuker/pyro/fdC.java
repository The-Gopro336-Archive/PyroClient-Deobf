/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class fdC extends Lambda implements Function1 {
   // $FF: renamed from: c net.minecraft.item.ItemStack
   public ItemStack field_75;
   // $FF: renamed from: c dev.nuker.pyro.fdF
   public fdF field_76;
   // $FF: renamed from: c kotlin.jvm.internal.Ref$ObjectRef
   public Ref.ObjectRef field_77;
   // $FF: renamed from: c dev.nuker.pyro.fdr
   public fdr field_78;

   public Object invoke(Object var1) {
      return this.method_110((ItemStack)var1);
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_110(@NotNull ItemStack var1) {
      return this.field_76.method_1302(this.field_75, var1);
   }

   public fdC(ItemStack var1, fdF var2, Ref.ObjectRef var3, fdr var4) {
      this.field_75 = var1;
      this.field_76 = var2;
      this.field_77 = var3;
      this.field_78 = var4;
      super(1);
   }
}
