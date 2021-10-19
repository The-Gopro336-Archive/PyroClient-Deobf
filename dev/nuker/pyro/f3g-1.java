/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import org.jetbrains.annotations.Nullable;

public class f3g implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3g
   public static f3g field_2163 = new f3g();

   public int run(@Nullable CommandContext var1) {
      class_37.field_2633.method_3983();
      Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Reloaded modules");
      return 0;
   }
}
