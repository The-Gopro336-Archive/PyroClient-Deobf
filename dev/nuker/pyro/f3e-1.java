/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f3e {
   // $FF: renamed from: c com.mojang.brigadier.CommandDispatcher
   @NotNull
   public static CommandDispatcher field_2141;
   // $FF: renamed from: c dev.nuker.pyro.f3e
   public static f3e field_2142;

   // $FF: renamed from: c (java.lang.String) void
   @JvmStatic
   public static void method_3213(@NotNull String var0) {
      ParseResults var1 = field_2141.parse((String)var0, new f1s());

      try {
         field_2141.execute(var1);
      } catch (CommandSyntaxException var3) {
         (new f1s()).method_3083((new TextComponentString(field_2142.method_3217((Throwable)var3, var0, var1))).setStyle((new Style()).setColor(TextFormatting.RED)));
      }

   }

   // $FF: renamed from: c () com.mojang.brigadier.CommandDispatcher
   @NotNull
   public CommandDispatcher method_3214() {
      return field_2141;
   }

   static {
      f3e var0 = new f3e();
      field_2142 = var0;
      field_2141 = new CommandDispatcher();
      f2w.method_3209(field_2141);
      f3n.field_2175.method_3246(field_2141);
      f2m.method_3196(field_2141);
      f34.method_3080(field_2141);
      f2M.method_3093(field_2141);
      f30.field_2014.method_3095(field_2141);
      f3S.field_2104.method_3190(field_2141);
      f1R.method_3703(field_2141);
      f1z.field_2022.method_3099(field_2141);
      f3j.field_2144.method_3219(field_2141);
      f2q.field_2055.method_3107(field_2141);
      f3t.field_2172.method_3245(field_2141);
      f2X.field_2033.method_3101(field_2141);
      f1D.field_2429.method_3697(field_2141);
      f1v.field_2029.method_3100(field_2141);
      f3M.field_2046.method_3104(field_2141);
      f1r.field_2002.method_3079(field_2141);
      f2s.field_2105.method_3191(field_2141);
      f3F.field_2048.method_3105(field_2141);
      f1x.field_2018.method_3097(field_2141);
      f1l.field_2008.method_3087(field_2141);
      f1h.field_1980.method_3068(field_2141);
      f2D.field_1979.method_3067(field_2141);
      f1j.field_1984.method_3070(field_2141);
      f3D.field_2038.method_3103(field_2141);
      f2O.field_2013.method_3094(field_2141);
      f3x.field_2182.method_3251(field_2141);
      f3v.field_2180.method_3250(field_2141);
      f3z.field_2179.method_3249(field_2141);
      f32.field_1998.method_3074(field_2141);
      f3H.method_3106(field_2141);
      f3l.field_2149.method_3222(field_2141);
      f3B.field_2035.method_3102(field_2141);
      f2Z.field_2021.method_3098(field_2141);
      f2y.field_2125.method_3201(field_2141);
      f2o.field_2118.method_3199(field_2141);
      f3d.field_2140.method_3212(field_2141);
      f1T.field_2450.method_3719(field_2141);
   }

   // $FF: renamed from: 0 (java.lang.String) com.mojang.brigadier.builder.LiteralArgumentBuilder
   @JvmStatic
   @NotNull
   public static LiteralArgumentBuilder method_3215(@Nullable String var0) {
      return LiteralArgumentBuilder.literal(var0);
   }

   // $FF: renamed from: c (java.lang.String, com.mojang.brigadier.arguments.ArgumentType) com.mojang.brigadier.builder.RequiredArgumentBuilder
   @JvmStatic
   @NotNull
   public static RequiredArgumentBuilder method_3216(@Nullable String var0, @Nullable ArgumentType var1) {
      return RequiredArgumentBuilder.argument(var0, var1);
   }

   // $FF: renamed from: c (java.lang.Throwable, java.lang.String, com.mojang.brigadier.ParseResults) java.lang.String
   public String method_3217(Throwable var1, String var2, ParseResults var3) {
      String var10000;
      if (var1 instanceof CommandSyntaxException && Intrinsics.areEqual((Object)((CommandSyntaxException)var1).getRawMessage().getString(), (Object)"Unknown command")) {
         int var5 = ((CommandSyntaxException)var1).getInput().length();
         int var6 = ((CommandSyntaxException)var1).getCursor();
         boolean var7 = false;
         int var4 = Math.min(var5, var6);
         if (var4 == 0) {
            StringBuilder var13 = (new StringBuilder()).append("Unknown command: ");
            byte var11 = 0;
            int var12 = !StringsKt.contains$default((CharSequence)var2, (CharSequence)" ", false, 2, (Object)null) ? var2.length() : StringsKt.indexOf$default((CharSequence)var2, " ", 0, false, 6, (Object)null);
            StringBuilder var9 = var13;
            boolean var8 = false;
            if (var2 == null) {
               throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }

            String var10 = var2.substring(var11, var12);
            var10000 = var9.append(var10).toString();
         } else {
            var10000 = "Unknown argument at position " + ((CommandSyntaxException)var1).getCursor() + ": " + ((CommandSyntaxException)var1).getContext();
         }
      } else {
         var10000 = var1.getMessage();
      }

      return var10000;
   }

   // $FF: renamed from: c (net.minecraft.util.text.ITextComponent) void
   public void method_3218(@Nullable ITextComponent var1) {
      Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((new TextComponentString("")).appendSibling(Pyro.getPrefix()).appendSibling(var1));
   }
}
