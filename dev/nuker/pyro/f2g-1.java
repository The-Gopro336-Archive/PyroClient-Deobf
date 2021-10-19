/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import java.util.Collection;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f2g implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2g
   public static f2g field_2051 = new f2g();

   public int run(@NotNull CommandContext var1) {
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Friends:")));
      ITextComponent var2 = (ITextComponent)(new TextComponentString(""));
      int var3 = 0;

      for(int var4 = ((Collection)FriendManager.Companion.getINSTANCE().getFriends()).size(); var3 < var4; ++var3) {
         var2.appendSibling((new TextComponentString(((class_17)FriendManager.Companion.getINSTANCE().getFriends().get(var3)).method_3416())).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA)));
         if (var3 < FriendManager.Companion.getINSTANCE().getFriends().size() - 1) {
            var2.appendSibling((ITextComponent)(new TextComponentString(", ")));
         }
      }

      ((f1s)var1.getSource()).method_3083(var2);
      return 0;
   }
}
