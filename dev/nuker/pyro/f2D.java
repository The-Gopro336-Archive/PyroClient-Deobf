/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

public class f2D {
   // $FF: renamed from: c dev.nuker.pyro.f2D
   public static f2D field_1979;

   // $FF: renamed from: c (int) void
   public void method_3066(int var1) {
      if (var1 > 0) {
         if (class_3.field_990.method_3406().method_1453(var1) != null) {
            Pyro.INSTANCE.sendMessage("Macros for " + Keyboard.getKeyName(var1) + ':');
            class_12 var10000 = class_3.field_990.method_3406().method_1453(var1);
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            Iterable var2 = (Iterable)var10000.method_3403();
            boolean var3 = false;
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
               Object var5 = var4.next();
               String var6 = (String)var5;
               boolean var7 = false;
               Pyro var16 = Pyro.INSTANCE;
               TextComponentString var10001 = new TextComponentString(ChatFormatting.DARK_GRAY + "- ");
               Style var8 = new Style();
               TextComponentString var9 = var10001;
               Pyro var10 = var16;
               boolean var11 = false;
               boolean var12 = false;
               boolean var14 = false;
               var8.setClickEvent(new ClickEvent(Action.RUN_COMMAND, Config.INSTANCE.chatPrefix + "macro del " + Keyboard.getKeyName(var1) + ' ' + var6));
               var10.sendAndKeepMessage(var9.setStyle(var8).appendText(ChatFormatting.WHITE + var6));
            }
         } else {
            Pyro.INSTANCE.sendMessage(ChatFormatting.RED + "No Macros for " + Keyboard.getKeyName(var1) + ':');
         }
      }

   }

   static {
      f2D var0 = new f2D();
      field_1979 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3067(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("macro").then(f3e.method_3215("add").then(f3e.method_3216("key", (ArgumentType)StringArgumentType.word()).then(f3e.method_3216("message", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f2z.field_2127))))).then(f3e.method_3215("del").then(((RequiredArgumentBuilder)f3e.method_3216("key", (ArgumentType)StringArgumentType.word()).executes((Command)f2A.field_1972)).then(f3e.method_3216("macro", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f2B.field_1974))))).then(f3e.method_3215("delall").then(f3e.method_3216("key", (ArgumentType)StringArgumentType.word()).executes((Command)f2C.field_1976))));
   }
}
