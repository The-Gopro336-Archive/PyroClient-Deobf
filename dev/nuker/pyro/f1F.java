/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.context.CommandContext;
import org.jetbrains.annotations.NotNull;

public class f1F implements SingleRedirectModifier {
   // $FF: renamed from: c dev.nuker.pyro.f1F
   public static f1F field_2431 = new f1F();

   // $FF: renamed from: c (com.mojang.brigadier.context.CommandContext) dev.nuker.pyro.f1s
   @NotNull
   public f1s method_3698(CommandContext var1) {
      return ((f1s)var1.getSource()).method_3084("naked", true);
   }

   public Object apply(CommandContext var1) {
      return this.method_3698(var1);
   }
}
