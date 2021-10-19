/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f88 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_482 = new BooleanSetting("prefix", "Prefix", (String)null, true);
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_483;
   // $FF: renamed from: 0 dev.nuker.pyro.f0o
   public f0o field_484;
   // $FF: renamed from: 1 dev.nuker.pyro.f0o
   public f0o field_485;
   // $FF: renamed from: c boolean
   public static boolean field_486 = !f88.class.desiredAssertionStatus();

   // $FF: renamed from: c (dev.nuker.pyro.f0o) com.mojang.realmsclient.gui.ChatFormatting
   public ChatFormatting method_703(f0o var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_704(f4e var1) {
      if (var1.c() == f41.field_2120) {
         if (var1.c() instanceof SPacketChat) {
            SPacketChat var2 = (SPacketChat)var1.c();
            if (!(var2.getChatComponent() instanceof TextComponentString) || var2.getType() == ChatType.GAME_INFO) {
               return;
            }

            Object var3 = (Boolean)this.field_482.c() ? Pyro.getPrefix() : new TextComponentString("");
            String var4 = var2.getChatComponent().getFormattedText();
            if ((!var4.toLowerCase().contains("to") || !var4.toLowerCase().contains("whisper") || !var4.toLowerCase().contains(":")) && this.field_483 != null && this.field_484 != null) {
               var4 = var4.replaceAll("(?i)" + this.c.player.getName(), this.method_703(this.field_483) + this.c.player.getName() + ChatFormatting.RESET);
               if (var4.contains("<") && var4.contains(">")) {
                  var4 = var4.replaceFirst("<", this.method_703(this.field_485) + "[" + this.method_703(this.field_484)).replaceFirst(">", this.method_703(this.field_485) + "]" + ChatFormatting.RESET);
               }
            }

            var1.0();
            if (Minecraft.getMinecraft().ingameGUI != null || this.c.player == null) {
               if (!field_486 && Minecraft.getMinecraft().ingameGUI == null) {
                  throw new AssertionError();
               }

               Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((new TextComponentString("")).appendSibling((ITextComponent)var3).appendSibling(new TextComponentString(var4 + ChatFormatting.RESET)));
            }
         }

      }
   }

   public f88() {
      super("betterchat", "BetterChat", "Makes chat more customizable.", true);
      this.field_483 = new f0o("self", "Self", (String)null, f87.field_1798);
      this.field_484 = new f0o("players", "Players", (String)null, f87.field_1796);
      this.field_485 = new f0o("brackets", "Brackets", (String)null, f87.field_1797);
      this.register(this.field_482);
      this.register(this.field_483);
      this.register(this.field_484);
      this.register(this.field_485);
   }
}
