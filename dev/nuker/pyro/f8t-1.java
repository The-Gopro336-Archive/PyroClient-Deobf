/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketUpdateHealth;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.Display;

public class f8t extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_222 = new BooleanSetting("queue", "Queue", (String)null, true);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_223 = new BooleanSetting("kick", "Kick", (String)null, true);
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_224 = new BooleanSetting("pm", "PM", (String)null, true);
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_225 = new BooleanSetting("name", "Name", (String)null, true);
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_226 = new BooleanSetting("stuck", "Stuck", (String)null, true);
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_227 = new BooleanSetting("damage", "Damage", (String)null, true);
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_228 = new BooleanSetting("totem", "Totem", (String)null, true);
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_229 = new BooleanSetting("nearby", "Nearby", (String)null, true);
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_230 = new BooleanSetting("showFriends", "ShowFriends", (String)null, true);
   // $FF: renamed from: c java.awt.SystemTray
   public SystemTray field_231;
   // $FF: renamed from: c java.awt.TrayIcon
   public TrayIcon field_232;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_233 = new fe8();
   // $FF: renamed from: 0 dev.nuker.pyro.fe8
   public fe8 field_234 = new fe8();
   // $FF: renamed from: 1 dev.nuker.pyro.fe8
   public fe8 field_235 = new fe8();
   // $FF: renamed from: 2 dev.nuker.pyro.fe8
   public fe8 field_236 = new fe8();
   // $FF: renamed from: 1 int
   public int field_237 = -1337;

   public f8t() {
      super("notifications", "Notifications", "Gives notifications out of game focus when something happens");
      this.register(this.field_222);
      this.register(this.field_223);
      this.register(this.field_224);
      this.register(this.field_225);
      this.register(this.field_226);
      this.register(this.field_227);
      this.register(this.field_228);
      this.register(this.field_229);
      this.register(this.field_230);
      if (SystemTray.isSupported()) {
         this.field_231 = SystemTray.getSystemTray();

         try {
            BufferedImage var1 = ImageIO.read(Pyro.getResourceAsStream("assets/textures/iconsquare.png"));
            this.field_232 = new TrayIcon((new ImageIcon(var1)).getImage(), "Pyro");
            this.field_232.setImageAutoSize(true);
            this.field_232.setToolTip("Pyro Notifications");
            this.field_231.add(this.field_232);
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4H) void
   @f0g
   @LauncherEventHide
   public void method_325(f4H var1) {
      if (!this.c.inGameHasFocus && (Boolean)this.field_229.c() && !(var1.method_3242() instanceof EntityPlayerSP) && var1.method_3242() instanceof EntityPlayer && !(var1.method_3242() instanceof EntityPlayerSP) && ((Boolean)this.field_230.c() || !FriendManager.Companion.isFriend((EntityPlayer)var1.method_3242()))) {
         this.method_327(var1.method_3242().getName() + " " + "has just came into your render distance!");
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_326(f4t var1) {
      if (!Display.isActive()) {
         if (this.field_233.method_1980(10000.0D)) {
            if ((Boolean)PyroStatic.field_2538.c.method_3034() && (Boolean)this.field_226.c() && Math.abs(this.c.player.motionX) < 0.1D && Math.abs(this.c.player.motionZ) < 0.1D) {
               this.method_327("AutoWalk has detected you are stuck.");
               this.field_233.method_1979();
            }

            if (this.field_237 != this.c.player.dimension) {
               if (this.field_237 == 1 && this.c.getCurrentServerData() != null && this.c.getCurrentServerData().serverIP.equals("2b2t.org") && (Boolean)this.field_222.c()) {
                  this.method_327("You've finished going through the queue.");
               }

               this.field_237 = this.c.player.dimension;
            }

         }
      }
   }

   // $FF: renamed from: 1 (java.lang.String) void
   public void method_327(String var1) {
      try {
         this.field_232.displayMessage("Pyro", var1, MessageType.NONE);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_328(f4e var1) {
      if (var1.c() == f41.field_2120) {
         if (Display.isActive()) {
            return;
         }

         try {
            if (var1.c() instanceof SPacketEntityStatus && (Boolean)this.field_228.c()) {
               if (!this.field_235.method_1980(10000.0D)) {
                  return;
               }

               if (this.c.world == null) {
                  return;
               }

               SPacketEntityStatus var5 = (SPacketEntityStatus)var1.c();
               if (var5.getEntity(this.c.world) == this.c.player && var5.getOpCode() == 35) {
                  this.field_235.method_1979();
                  this.method_327("You just popped a totem.");
               }
            } else if (var1.c() instanceof SPacketUpdateHealth && (Boolean)this.field_227.c()) {
               if (!this.field_234.method_1980(10000.0D)) {
                  return;
               }

               SPacketUpdateHealth var4 = (SPacketUpdateHealth)var1.c();
               if (var4.getHealth() < this.c.player.getHealth()) {
                  this.field_234.method_1979();
                  this.method_327("You've just taken damage.");
               }
            } else if (!(var1.c() instanceof SPacketChat) || !(Boolean)this.field_224.c() && !(Boolean)this.field_225.c()) {
               if (var1.c() instanceof SPacketDisconnect && (Boolean)this.field_223.c()) {
                  this.method_327("You've just disconnected");
               }
            } else {
               if (!this.field_236.method_1980(10000.0D)) {
                  return;
               }

               SPacketChat var2 = (SPacketChat)var1.c();
               if (var2.getChatComponent().getFormattedText().contains(this.c.player.getName()) && (Boolean)this.field_225.c()) {
                  this.field_236.method_1979();
                  this.method_327("You were mentioned in chat.");
               } else if (var2.getChatComponent().getFormattedText().contains("whispers") && (Boolean)this.field_224.c()) {
                  this.field_236.method_1979();
                  this.method_327("You received a public message");
               }
            }
         } catch (Exception var3) {
         }
      }

   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (var1 && (!SystemTray.isSupported() || this.field_231 == null || this.field_232 == null)) {
         Pyro.INSTANCE.sendMessage("Fatal error in Notifications occured it can not be enabled");
         this.c.method_3033(false);
      }

   }
}
