/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.server.SPacketChat;

public class f7Y extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_466 = new DoubleSetting("delay", "Delay", (String)null, 1.0D, 0.0D, 10.0D);
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_467 = new fe8();

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_688(f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketChat) {
         if (!this.field_467.method_1980((Double)this.field_466.c() * 1000.0D)) {
            return;
         }

         SPacketChat var2 = (SPacketChat)var1.c();
         if (var2.getChatComponent().getUnformattedText().contains("has requested to teleport to you.")) {
            String var3 = var2.getChatComponent().getUnformattedText().substring(0, var2.getChatComponent().getUnformattedText().indexOf(" has requested to teleport to you."));
            if (FriendManager.Companion.isFriend(var3)) {
               this.c.player.sendChatMessage("/tpaccept");
            }
         }
      }

   }

   public f7Y() {
      super("autoaccept", "AutoAccept", "Automatically accepts /tpa requests from friends");
      this.register(this.field_466);
   }
}
