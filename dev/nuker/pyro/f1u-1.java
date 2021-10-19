/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import org.jetbrains.annotations.Nullable;

public class f1u implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1u
   public static f1u field_2026 = new f1u();

   public int run(@Nullable CommandContext var1) {
      int var2 = IntegerArgumentType.getInteger(var1, "line");
      String var3 = StringArgumentType.getString(var1, "text");
      class_9.field_2271.method_3398(var2 - 1, var3);
      class_9.field_2271.method_3395();
      Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Set custom text for rpc line " + var2);
      return 0;
   }
}
