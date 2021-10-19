/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import org.jetbrains.annotations.Nullable;

public class f1t implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1t
   public static f1t field_2023 = new f1t();

   public int run(@Nullable CommandContext var1) {
      int var2 = IntegerArgumentType.getInteger(var1, "line");
      class_9.field_2271.method_3398(var2 - 1, (String)null);
      class_9.field_2271.method_3395();
      Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Cleared RPC line " + var2);
      return 0;
   }
}
