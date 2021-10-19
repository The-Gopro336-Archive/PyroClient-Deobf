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

public class f2B implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2B
   public static f2B field_1974 = new f2B();

   public int run(CommandContext var1) {
      String var10000 = StringArgumentType.getString(var1, "key");
      String var3;
      if (var10000 != null) {
         var3 = var10000;
         boolean var4 = false;
         if (var3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         var10000 = var3.toUpperCase();
      } else {
         var10000 = null;
      }

      String var2 = var10000;
      var3 = StringArgumentType.getString(var1, "macro");
      int var5 = Keyboard.getKeyIndex(var2);
      if (var2 != null) {
         class_3.field_990.method_3406().method_1454(var5, var3);
         f2D.field_1979.method_3066(var5);
      }

      return 0;
   }
}
