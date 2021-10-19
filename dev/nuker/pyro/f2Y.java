/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import java.awt.Desktop;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f2Y implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2Y
   public static f2Y field_2019 = new f2Y();

   public int run(CommandContext var1) {
      String var2 = "Opened the " + Config.INSTANCE.watermark + " folder.";

      try {
         Desktop.getDesktop().open(Pyro.FOLDER);
      } catch (Exception var4) {
         var2 = "Failed to open folder.";
      }

      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString(var2)));
      return 0;
   }
}
