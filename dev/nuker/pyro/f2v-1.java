/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.common.collect.Iterables;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedCommandNode;
import java.util.Iterator;
import java.util.Map;
import kotlin.TypeCastException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

public class f2v implements Command {
   // $FF: renamed from: c com.mojang.brigadier.CommandDispatcher
   public CommandDispatcher field_2131;

   public int run(@NotNull CommandContext var1) {
      ParseResults var2 = this.field_2131.parse(StringArgumentType.getString(var1, "command"), var1.getSource());
      if (var2.getContext().getNodes().isEmpty()) {
         throw (Throwable)f2w.method_3210(f2w.field_2134).create();
      } else {
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Usage: ")));
         Map var3 = this.field_2131.getSmartUsage(((ParsedCommandNode)Iterables.getLast((Iterable)var2.getContext().getNodes())).getNode(), var1.getSource());
         Iterator var4 = var3.values().iterator();

         while(var4.hasNext()) {
            Object var10000 = var4.next();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }

            String var5 = (String)var10000;
            var10000 = var1.getSource();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.command.CommandSource");
            }

            ((f1s)var10000).method_3083((ITextComponent)(new TextComponentString(Config.INSTANCE.chatPrefix + var2.getReader().getString() + " " + var5)));
         }

         return var3.size();
      }
   }

   public f2v(CommandDispatcher var1) {
      this.field_2131 = var1;
      super();
   }
}
