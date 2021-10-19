/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.text.StringsKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class f1n implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1n
   public static f1n field_2012 = new f1n();

   public int run(CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "block");
      if (!StringsKt.contains$default((CharSequence)var2, (CharSequence)":", false, 2, (Object)null)) {
         var2 = "minecraft:" + var2;
      }

      if (Item.REGISTRY.containsKey(new ResourceLocation(var2))) {
         if (PyroStatic.field_2595.method_472().method_3048().contains(var2)) {
            ((f1s)var1.getSource()).method_3083((new TextComponentString(var2 + " is already an cheststealer block")).setStyle((new Style()).setColor(TextFormatting.RED)));
         } else {
            PyroStatic.field_2595.method_472().method_3048().add(var2);
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Added cheststealer block " + var2)));
            PyroStatic.field_2595.method_474();
            if ((Boolean)PyroStatic.field_2595.c.method_3034()) {
               PyroStatic.field_2595.c(true, (EntityPlayerSP)null, (World)null);
            }
         }
      } else {
         ((f1s)var1.getSource()).method_3083((new TextComponentString(var2 + " is not a valid block")).setStyle((new Style()).setColor(TextFormatting.RED)));
      }

      return 0;
   }
}
