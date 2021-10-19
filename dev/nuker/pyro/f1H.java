/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import java.util.Iterator;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f1H implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1H
   public static f1H field_2418 = new f1H();

   public int run(CommandContext var1) {
      f3e.field_2142.method_3218((ITextComponent)(new TextComponentString(TextFormatting.YELLOW + (f1R.field_2437.method_3709().isEmpty() ? "No fake players are in the world" : "Fake Players:"))));
      Iterable var2 = (Iterable)f1R.field_2437.method_3709();
      boolean var3 = false;
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         EntityOtherPlayerMP var6 = (EntityOtherPlayerMP)var5;
         boolean var7 = false;
         f3e.field_2142.method_3218((ITextComponent)(new TextComponentString(var6.getGameProfile().getName())));
      }

      return 0;
   }
}
