/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.math.Vec2f;
import org.jetbrains.annotations.NotNull;

public class f1P implements SingleRedirectModifier {
   // $FF: renamed from: c dev.nuker.pyro.f1P
   public static f1P field_2433 = new f1P();

   public Object apply(CommandContext var1) {
      return this.method_3699(var1);
   }

   // $FF: renamed from: c (com.mojang.brigadier.context.CommandContext) dev.nuker.pyro.f1s
   @NotNull
   public f1s method_3699(CommandContext var1) {
      return ((f1s)var1.getSource()).method_3084("rotation", new Vec2f(FloatArgumentType.getFloat(var1, "yaw"), FloatArgumentType.getFloat(var1, "pitch")));
   }
}
