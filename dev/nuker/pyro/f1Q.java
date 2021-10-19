/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.context.CommandContext;
import org.jetbrains.annotations.NotNull;

public class f1Q implements SingleRedirectModifier {
   // $FF: renamed from: c dev.nuker.pyro.f1Q
   public static f1Q field_2434 = new f1Q();

   public Object apply(CommandContext var1) {
      return this.method_3700(var1);
   }

   // $FF: renamed from: c (com.mojang.brigadier.context.CommandContext) dev.nuker.pyro.f1s
   @NotNull
   public f1s method_3700(CommandContext var1) {
      return ((f1s)var1.getSource()).method_3084("modsignore", true);
   }
}
