/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import kotlin.TypeCastException;
import org.lwjgl.input.Keyboard;

public class f2C implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2C
   public static f2C field_1976 = new f2C();

   public int run(CommandContext var1) {
      String var10000 = StringArgumentType.getString(var1, "key");
      if (var10000 != null) {
         String var3 = var10000;
         boolean var4 = false;
         if (var3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         var10000 = var3.toUpperCase();
      } else {
         var10000 = null;
      }

      String var2 = var10000;
      int var5 = Keyboard.getKeyIndex(var2);
      if (var2 != null) {
         class_3.field_990.method_3406().method_1456(var5);
         Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Deleted all macros for " + Keyboard.getKeyName(var5) + ':');
      }

      return 0;
   }
}
