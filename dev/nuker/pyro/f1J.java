/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

public class f1J implements SingleRedirectModifier {
   // $FF: renamed from: c dev.nuker.pyro.f1J
   public static f1J field_2427 = new f1J();

   // $FF: renamed from: c (com.mojang.brigadier.context.CommandContext) dev.nuker.pyro.f1s
   @NotNull
   public f1s method_3682(CommandContext var1) {
      return ((f1s)var1.getSource()).method_3084("position", new Vec3d(DoubleArgumentType.getDouble(var1, "x"), DoubleArgumentType.getDouble(var1, "y"), DoubleArgumentType.getDouble(var1, "z")));
   }

   public Object apply(CommandContext var1) {
      return this.method_3682(var1);
   }
}
