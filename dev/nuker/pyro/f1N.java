/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.world.GameType;
import org.jetbrains.annotations.NotNull;

public class f1N implements SingleRedirectModifier {
   // $FF: renamed from: c dev.nuker.pyro.f1N
   public static f1N field_2442 = new f1N();

   // $FF: renamed from: c (com.mojang.brigadier.context.CommandContext) dev.nuker.pyro.f1s
   @NotNull
   public f1s method_3714(CommandContext var1) {
      return ((f1s)var1.getSource()).method_3084("gamemode", GameType.SPECTATOR);
   }

   public Object apply(CommandContext var1) {
      return this.method_3714(var1);
   }
}
