/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f1W implements Command {
   // $FF: renamed from: c kotlin.jvm.functions.Function1
   public Function1 field_2456;
   // $FF: renamed from: c java.lang.String
   public String field_2457;

   public f1W(Function1 var1, String var2) {
      this.field_2456 = var1;
      this.field_2457 = var2;
      super();
   }

   public int run(CommandContext var1) {
      f3e var10000 = f3e.field_2142;
      TextComponentString var10001 = new TextComponentString;
      boolean var2 = (Boolean)this.field_2456.invoke(false);
      String var10003;
      if (var2) {
         var10003 = TextFormatting.GREEN + "Added pyro friends to " + this.field_2457 + " friends list";
      } else {
         if (var2) {
            throw new NoWhenBranchMatchedException();
         }

         var10003 = TextFormatting.RED + "Could not access " + this.field_2457 + " friends list";
      }

      var10001.<init>(var10003);
      var10000.method_3218((ITextComponent)var10001);
      return 0;
   }
}
