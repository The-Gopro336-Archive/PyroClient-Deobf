/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Iterator;
import kotlin.text.StringsKt;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.lwjgl.input.Keyboard;

public class f1i implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1i
   public static f1i field_1982 = new f1i();

   public int run(CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "module");
      String var3 = StringArgumentType.getString(var1, "key");
      int var4 = -1;
      if (var3 != null) {
         boolean var6 = false;
         var4 = Keyboard.getKeyIndex(var3.toUpperCase());
         var3 = Keyboard.getKeyName(var4);
      }

      Iterator var8 = class_37.field_2633.method_3981().iterator();

      while(var8.hasNext()) {
         Module var5 = (Module)var8.next();
         String var7 = var5.method_127();
         if (StringsKt.startsWith(var7, var2, true)) {
            var5.method_115(var4);
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Set the bind of " + var5.method_127() + " to " + var3)));
            break;
         }
      }

      return 0;
   }
}
