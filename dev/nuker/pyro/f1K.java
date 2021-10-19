/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import org.jetbrains.annotations.NotNull;

public class f1K implements SingleRedirectModifier {
   // $FF: renamed from: c dev.nuker.pyro.f1K
   public static f1K field_2428 = new f1K();

   public Object apply(CommandContext var1) {
      return this.method_3683(var1);
   }

   // $FF: renamed from: c (com.mojang.brigadier.context.CommandContext) dev.nuker.pyro.f1s
   @NotNull
   public f1s method_3683(CommandContext var1) {
      return ((f1s)var1.getSource()).method_3084("name", StringArgumentType.getString(var1, "name"));
   }
}
