/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class fbo extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_911 = new BooleanSetting("color", "Color", (String)null, true);

   public fbo() {
      super("nameprotect", "NameProtect", "Displays friends names with their aliases in nametags and chat", true);
      this.register(this.field_911);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_1340(f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketChat) {
         SPacketChat var2 = (SPacketChat)var1.c();
         if (var2.getType() == ChatType.CHAT) {
            ITextComponent var3 = var2.getChatComponent();
            if (var3 instanceof TextComponentTranslation) {
               TextComponentTranslation var4 = (TextComponentTranslation)var3;
               if (var4.getFormatArgs().length > 0 && var4.getFormatArgs()[0] instanceof TextComponentString) {
                  TextComponentString var5 = (TextComponentString)var4.getFormatArgs()[0];
                  if (!var5.getSiblings().isEmpty() && var5.getSiblings().get(0) instanceof TextComponentString) {
                     TextComponentString var6 = (TextComponentString)var5.getSiblings().get(0);
                     class_17 var7 = FriendManager.Companion.getFriend(var6.getText());
                     if (var7 != null) {
                        if ((Boolean)this.field_911.c()) {
                           var5.getSiblings().set(0, (new TextComponentString(var7.method_3409())).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA)));
                        } else {
                           var5.getSiblings().set(0, new TextComponentString(var7.method_3409()));
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
