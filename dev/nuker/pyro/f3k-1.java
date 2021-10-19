/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f3k implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3k
   public static f3k field_2147 = new f3k();

   public int run(CommandContext var1) {
      long var2 = (System.nanoTime() / 1000000L - Pyro.STARTUP_TIME) / 1000L;
      long var4 = var2 / 60L;
      long var6 = var4 / 60L;
      String var9 = StringArgumentType.getString(var1, "type");
      boolean var10 = false;
      if (var9 == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         String var8 = var9.toLowerCase();
         var9 = (String)null;
         String var11;
         Object[] var12;
         boolean var13;
         StringCompanionObject var14;
         if (Intrinsics.areEqual((Object)var8, (Object)"second")) {
            var14 = StringCompanionObject.INSTANCE;
            var11 = "%s seconds";
            var12 = new Object[]{var2};
            var13 = false;
            var9 = String.format(var11, Arrays.copyOf(var12, var12.length));
         } else if (Intrinsics.areEqual((Object)var8, (Object)"seconds")) {
            var14 = StringCompanionObject.INSTANCE;
            var11 = "%s seconds";
            var12 = new Object[]{var2};
            var13 = false;
            var9 = String.format(var11, Arrays.copyOf(var12, var12.length));
         } else if (Intrinsics.areEqual((Object)var8, (Object)"minute")) {
            var14 = StringCompanionObject.INSTANCE;
            var11 = "%s minute";
            var12 = new Object[]{var4};
            var13 = false;
            var9 = String.format(var11, Arrays.copyOf(var12, var12.length));
         } else if (Intrinsics.areEqual((Object)var8, (Object)"minutes")) {
            var14 = StringCompanionObject.INSTANCE;
            var11 = "%s minutes";
            var12 = new Object[]{var4};
            var13 = false;
            var9 = String.format(var11, Arrays.copyOf(var12, var12.length));
         } else if (Intrinsics.areEqual((Object)var8, (Object)"hour")) {
            var14 = StringCompanionObject.INSTANCE;
            var11 = "%s hour";
            var12 = new Object[]{var6};
            var13 = false;
            var9 = String.format(var11, Arrays.copyOf(var12, var12.length));
         } else if (Intrinsics.areEqual((Object)var8, (Object)"hours")) {
            var14 = StringCompanionObject.INSTANCE;
            var11 = "%s hours";
            var12 = new Object[]{var6};
            var13 = false;
            var9 = String.format(var11, Arrays.copyOf(var12, var12.length));
         } else {
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Invalid time format, use second, minute, hour.")));
         }

         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("You've been playing for " + var9)));
         return 0;
      }
   }
}
