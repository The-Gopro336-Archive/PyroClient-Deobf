/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import org.jetbrains.annotations.Nullable;

public class f3h implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3h
   public static f3h field_2165 = new f3h();

   public int run(@Nullable CommandContext var1) {
      class_5.method_1479();
      Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Reloaded hud");
      return 0;
   }
}
