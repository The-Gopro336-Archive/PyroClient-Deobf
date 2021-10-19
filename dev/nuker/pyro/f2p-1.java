/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import org.jetbrains.annotations.Nullable;

public class f2p implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2p
   public static f2p field_2123 = new f2p();

   public int run(@Nullable CommandContext var1) {
      double var2 = DoubleArgumentType.getDouble(var1, "scale");
      f0H.field_2337 = var2;
      Pyro.INSTANCE.sendMessage("Set the gui scale to " + var2);
      return 0;
   }
}
