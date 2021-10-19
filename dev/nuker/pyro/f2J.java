/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Arrays;
import java.util.Optional;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.Nullable;

public class f2J implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2J
   public static f2J field_1983 = new f2J();

   public int run(@Nullable CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "module");
      Optional var3 = f2M.method_3092(f2M.field_2009, var2);
      if (var3.isPresent()) {
         Object var10000;
         if ((Boolean)((Module)var3.get()).field_89.method_3034()) {
            ((Module)var3.get()).field_89.method_3033(false);
            if (var1 == null) {
               Intrinsics.throwNpe();
            }

            var10000 = var1.getSource();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            ((f1s)var10000).method_3083((new TextComponentString("Disabled Module: ")).appendSibling((new TextComponentString(((Module)var3.get()).method_127())).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
         } else {
            if (var1 == null) {
               Intrinsics.throwNpe();
            }

            var10000 = var1.getSource();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            ((f1s)var10000).method_3083((new TextComponentString("Module Already Disabled: ")).appendSibling((new TextComponentString(((Module)var3.get()).method_127())).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
         }

         return 0;
      } else {
         StringCompanionObject var4 = StringCompanionObject.INSTANCE;
         String var5 = "Module %s does not exist";
         Object[] var6 = new Object[]{var2};
         boolean var7 = false;
         String var12 = String.format(var5, Arrays.copyOf(var6, var6.length));
         Message var14 = (Message)(new LiteralMessage(var12));
         throw (Throwable)(new SimpleCommandExceptionType(var14)).create();
      }
   }
}
