/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import org.jetbrains.annotations.Nullable;

public class f3i implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3i
   public static f3i field_2167 = new f3i();

   public int run(@Nullable CommandContext var1) {
      class_3.field_990.method_3406().method_1452();
      Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Reloaded macros");
      return 0;
   }
}
