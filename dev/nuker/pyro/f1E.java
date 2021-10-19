/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;

public class f1E implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1E
   public static f1E field_2430 = new f1E();

   public int run(CommandContext var1) {
      Map var2 = ((f1s)var1.getSource()).method_3081();
      boolean var3 = false;
      boolean var5 = false;
      Iterator var6 = var2.entrySet().iterator();

      while(var6.hasNext()) {
         Entry var7 = (Entry)var6.next();
         boolean var9 = false;
         String var10 = (String)var7.getKey() + " = " + var7.getValue();
         boolean var11 = false;
         System.out.println(var10);
      }

      f3e var10000 = f3e.field_2142;
      TextComponentString var10001 = new TextComponentString;
      f1R var10003 = f1R.field_2437;
      String var18;
      if (((f1s)var1.getSource()).method_3081().containsKey("name")) {
         Object var10004 = ((f1s)var1.getSource()).method_3081().get("name");
         if (var10004 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
         }

         var18 = (String)var10004;
      } else {
         var18 = Minecraft.getMinecraft().player.getGameProfile().getName();
      }

      Vec3d var12;
      if (((f1s)var1.getSource()).method_3081().containsKey("position")) {
         Object var10005 = ((f1s)var1.getSource()).method_3081().get("position");
         if (var10005 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.math.Vec3d");
         }

         var12 = (Vec3d)var10005;
      } else {
         var12 = Minecraft.getMinecraft().player.getPositionVector();
      }

      Vec2f var13;
      if (((f1s)var1.getSource()).method_3081().containsKey("rotation")) {
         Object var10006 = ((f1s)var1.getSource()).method_3081().get("rotation");
         if (var10006 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.util.math.Vec2f");
         }

         var13 = (Vec2f)var10006;
      } else {
         var13 = new Vec2f(Minecraft.getMinecraft().player.rotationYaw, Minecraft.getMinecraft().player.rotationPitch);
      }

      GameType var14;
      if (((f1s)var1.getSource()).method_3081().containsKey("gamemode")) {
         Object var10007 = ((f1s)var1.getSource()).method_3081().get("gamemode");
         if (var10007 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.world.GameType");
         }

         var14 = (GameType)var10007;
      } else {
         var14 = GameType.SURVIVAL;
      }

      float var16;
      if (((f1s)var1.getSource()).method_3081().containsKey("health")) {
         Object var10008 = ((f1s)var1.getSource()).method_3081().get("health");
         if (var10008 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
         }

         var16 = (Float)var10008;
      } else {
         var16 = 20.0F;
      }

      boolean var15 = f1R.method_3708(var10003, var18, var12, var13, var14, var16, !((f1s)var1.getSource()).method_3081().containsKey("modsignore"), ((f1s)var1.getSource()).method_3081().containsKey("naked"));
      String var17;
      if (var15) {
         var17 = TextFormatting.GREEN + "Created fake player";
      } else {
         if (var15) {
            throw new NoWhenBranchMatchedException();
         }

         var17 = TextFormatting.RED + "A fake player with that name already exists";
      }

      var10001.<init>(var17);
      var10000.method_3218((ITextComponent)var10001);
      return 0;
   }
}
