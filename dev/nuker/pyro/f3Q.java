/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class f3Q implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3Q
   public static f3Q field_2124 = new f3Q();

   public int run(CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "block");
      if (!StringsKt.contains$default((CharSequence)var2, (CharSequence)":", false, 2, (Object)null)) {
         var2 = "minecraft:" + var2;
      }

      if (Block.REGISTRY.containsKey(new ResourceLocation(var2))) {
         if (!PyroStatic.field_2488.method_1046().method_2817().contains(var2)) {
            ((f1s)var1.getSource()).method_3083((new TextComponentString(var2 + " is not an xray block")).setStyle((new Style()).setColor(TextFormatting.RED)));
         } else {
            PyroStatic.field_2488.method_1046().method_2817().remove(var2);
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Removed xray block " + var2)));
            PyroStatic.field_2488.method_1050();
            if ((Boolean)PyroStatic.field_2488.c.method_3034()) {
               PyroStatic.field_2488.method_116(true, (EntityPlayerSP)null, (World)null);
            }
         }
      } else {
         ((f1s)var1.getSource()).method_3083((new TextComponentString(var2 + " is not a valid block")).setStyle((new Style()).setColor(TextFormatting.RED)));
      }

      return 0;
   }
}
