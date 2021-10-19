/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import org.jetbrains.annotations.Nullable;

public class f3f implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3f
   public static f3f field_2162 = new f3f();

   public int run(@Nullable CommandContext var1) {
      class_59.field_2713.method_4138();
      Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Reloaded fonts");
      return 0;
   }
}
