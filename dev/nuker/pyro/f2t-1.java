/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.CommandNode;
import java.util.Iterator;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

public class f2t implements Command {
   // $FF: renamed from: c com.mojang.brigadier.CommandDispatcher
   public CommandDispatcher field_2109;

   public int run(@NotNull CommandContext var1) {
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Pyro Commands: ")));
      Iterator var3 = this.field_2109.getSmartUsage((CommandNode)this.field_2109.getRoot(), var1.getSource()).values().iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString(Config.INSTANCE.chatPrefix + var2)));
      }

      return 0;
   }

   public f2t(CommandDispatcher var1) {
      this.field_2109 = var1;
      super();
   }
}
