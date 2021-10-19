/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.TypeCastException;
import org.lwjgl.input.Keyboard;

public class f2z implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2z
   public static f2z field_2127 = new f2z();

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
      if (var2 != null && var5 > 0) {
         class_3.field_990.method_3406().method_1451(var5, StringArgumentType.getString(var1, "message"));
         Pyro.INSTANCE.sendMessage("Added macro for " + Keyboard.getKeyName(var5) + ": " + StringArgumentType.getString(var1, "message"));
      }

      return 0;
   }
}
