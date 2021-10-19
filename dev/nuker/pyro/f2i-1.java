/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f2i implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2i
   public static f2i field_2042 = new f2i();

   public int run(CommandContext var1) {
      f3e.field_2142.method_3218((ITextComponent)(new TextComponentString(TextFormatting.GREEN + "Reloading pyro friends list")));
      FriendManager.Companion.loadFriends();
      return 0;
   }
}
