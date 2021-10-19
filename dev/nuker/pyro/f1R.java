/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.SingleRedirectModifier;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import org.jetbrains.annotations.NotNull;

public class f1R {
   // $FF: renamed from: c java.util.List
   @NotNull
   public static List field_2435;
   // $FF: renamed from: c int
   public static int field_2436;
   // $FF: renamed from: c dev.nuker.pyro.f1R
   public static f1R field_2437;

   // $FF: renamed from: c (java.lang.String) boolean
   public boolean method_3701(String var1) {
      Iterable var2 = (Iterable)field_2435;
      boolean var3 = false;
      boolean var10000;
      if (var2 instanceof Collection && ((Collection)var2).isEmpty()) {
         var10000 = false;
      } else {
         Iterator var4 = var2.iterator();

         while(true) {
            if (!var4.hasNext()) {
               var10000 = false;
               break;
            }

            Object var5 = var4.next();
            EntityOtherPlayerMP var6 = (EntityOtherPlayerMP)var5;
            boolean var7 = false;
            if (Intrinsics.areEqual((Object)var6.getGameProfile().getName(), (Object)var1)) {
               var10000 = true;
               break;
            }
         }
      }

      if (var10000) {
         Iterable var12 = (Iterable)field_2435;
         boolean var13 = false;
         boolean var14 = false;
         Iterator var15 = var12.iterator();

         Object var16;
         while(true) {
            if (!var15.hasNext()) {
               var16 = null;
               break;
            }

            Object var8 = var15.next();
            EntityOtherPlayerMP var9 = (EntityOtherPlayerMP)var8;
            boolean var10 = false;
            if (Intrinsics.areEqual((Object)var9.getGameProfile().getName(), (Object)var1)) {
               var16 = var8;
               break;
            }
         }

         EntityOtherPlayerMP var11 = (EntityOtherPlayerMP)var16;
         fe4 var17 = fe4.field_1243;
         if (var11 == null) {
            Intrinsics.throwNpe();
         }

         var17.method_1896(var11);
         field_2435.remove(var11);
         var10000 = true;
      } else {
         var10000 = false;
      }

      return var10000;
   }

   // $FF: renamed from: c (int) void
   public void method_3702(int var1) {
      field_2436 = var1;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   @JvmStatic
   public static void method_3703(@NotNull CommandDispatcher var0) {
      LiteralCommandNode var1 = var0.register(f3e.method_3215("fakeplayer"));
      var0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("fakeplayer").then(f3e.method_3215("spawn").executes((Command)f1E.field_2430))).then(f3e.method_3215("position").then(f3e.method_3216("x", (ArgumentType)DoubleArgumentType.doubleArg()).then(f3e.method_3216("y", (ArgumentType)DoubleArgumentType.doubleArg()).then(f3e.method_3216("z", (ArgumentType)DoubleArgumentType.doubleArg()).redirect((CommandNode)var1, (SingleRedirectModifier)f1J.field_2427)))))).then(f3e.method_3215("name").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.word()).redirect((CommandNode)var1, (SingleRedirectModifier)f1K.field_2428)))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("gamemode").then(f3e.method_3215("creative").redirect((CommandNode)var1, (SingleRedirectModifier)f1L.field_2440))).then(f3e.method_3215("survival").redirect((CommandNode)var1, (SingleRedirectModifier)f1M.field_2441))).then(f3e.method_3215("spectator").redirect((CommandNode)var1, (SingleRedirectModifier)f1N.field_2442)))).then(f3e.method_3215("health").then(f3e.method_3216("health", (ArgumentType)FloatArgumentType.floatArg(0.0F)).redirect((CommandNode)var1, (SingleRedirectModifier)f1O.field_2443)))).then(f3e.method_3215("rotate").then(f3e.method_3216("yaw", (ArgumentType)FloatArgumentType.floatArg(0.0F, 360.0F)).then(f3e.method_3216("pitch", (ArgumentType)FloatArgumentType.floatArg(-90.0F, 90.0F)).redirect((CommandNode)var1, (SingleRedirectModifier)f1P.field_2433))))).then(f3e.method_3215("modsignore").redirect((CommandNode)var1, (SingleRedirectModifier)f1Q.field_2434))).then(f3e.method_3215("naked").redirect((CommandNode)var1, (SingleRedirectModifier)f1F.field_2431))).then(f3e.method_3215("remove").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.word()).executes((Command)f1G.field_2432)))).then(f3e.method_3215("list").executes((Command)f1H.field_2418))).then(f3e.method_3215("purge").executes((Command)f1I.field_2422)));
   }

   // $FF: renamed from: c (java.lang.String, net.minecraft.util.math.Vec3d, net.minecraft.util.math.Vec2f, net.minecraft.world.GameType, float, boolean, boolean) boolean
   public boolean method_3704(String var1, Vec3d var2, Vec2f var3, GameType var4, float var5, boolean var6, boolean var7) {
      Iterable var8 = (Iterable)field_2435;
      boolean var9 = false;
      boolean var10000;
      if (var8 instanceof Collection && ((Collection)var8).isEmpty()) {
         var10000 = false;
      } else {
         Iterator var10 = var8.iterator();

         while(true) {
            if (!var10.hasNext()) {
               var10000 = false;
               break;
            }

            Object var11 = var10.next();
            EntityOtherPlayerMP var12 = (EntityOtherPlayerMP)var11;
            boolean var13 = false;
            if (Intrinsics.areEqual((Object)var12.getGameProfile().getName(), (Object)var1)) {
               var10000 = true;
               break;
            }
         }
      }

      if (!var10000) {
         fe4 var16 = fe4.field_1243;
         int var15;
         field_2436 = (var15 = field_2436) + 1;
         EntityOtherPlayerMP var14 = var16.method_1898(var1, -10000 - var15, var6);
         var14.setGameType(var4);
         var14.capabilities.disableDamage = true;
         var14.setPositionAndRotation(var2.x, var2.y, var2.z, var3.x, var3.y);
         var14.rotationYawHead = var3.x;
         var14.setHealth(var5);
         if (!var7) {
            var14.inventory.copyInventory(Minecraft.getMinecraft().player.inventory);
         }

         field_2435.add(var14);
         var10000 = true;
      } else {
         var10000 = false;
      }

      return var10000;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_3705(@NotNull List var1) {
      field_2435 = var1;
   }

   // $FF: renamed from: 0 () void
   public void method_3706() {
      while(true) {
         Collection var1 = (Collection)field_2435;
         boolean var2 = false;
         if (var1.isEmpty()) {
            field_2436 = 0;
            return;
         }

         Object var10001 = field_2435.get(0);
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         this.method_3701(((EntityOtherPlayerMP)var10001).getGameProfile().getName());
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f1R, java.lang.String) boolean
   public static boolean method_3707(f1R var0, String var1) {
      return var0.method_3701(var1);
   }

   static {
      f1R var0 = new f1R();
      field_2437 = var0;
      boolean var1 = false;
      field_2435 = (List)(new ArrayList());
   }

   // $FF: renamed from: c (dev.nuker.pyro.f1R, java.lang.String, net.minecraft.util.math.Vec3d, net.minecraft.util.math.Vec2f, net.minecraft.world.GameType, float, boolean, boolean) boolean
   public static boolean method_3708(f1R var0, String var1, Vec3d var2, Vec2f var3, GameType var4, float var5, boolean var6, boolean var7) {
      return var0.method_3704(var1, var2, var3, var4, var5, var6, var7);
   }

   // $FF: renamed from: c () java.util.List
   @NotNull
   public List method_3709() {
      return field_2435;
   }

   // $FF: renamed from: 1 () int
   public int method_3710() {
      return field_2436;
   }
}
