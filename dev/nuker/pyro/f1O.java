/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import org.jetbrains.annotations.NotNull;

public class f1O implements SingleRedirectModifier {
   // $FF: renamed from: c dev.nuker.pyro.f1O
   public static f1O field_2443 = new f1O();

   // $FF: renamed from: c (com.mojang.brigadier.context.CommandContext) dev.nuker.pyro.f1s
   @NotNull
   public f1s method_3715(CommandContext var1) {
      return ((f1s)var1.getSource()).method_3084("health", FloatArgumentType.getFloat(var1, "health"));
   }

   public Object apply(CommandContext var1) {
      return this.method_3715(var1);
   }
}
