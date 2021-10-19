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

public class f2h implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2h
   public static f2h field_2053 = new f2h();

   public int run(CommandContext var1) {
      FriendManager.Companion.getINSTANCE().getFriends().clear();
      FriendManager.Companion.saveFriends();
      f3e.field_2142.method_3218((ITextComponent)(new TextComponentString(TextFormatting.GREEN + "Cleared friends list")));
      return 0;
   }
}
