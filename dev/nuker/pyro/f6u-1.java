/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class f6u extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_502 = new BooleanSetting("onRender", "OnRender", (String)null, false);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_503 = new BooleanSetting("noTotems", "NoTotems", (String)null, true);
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_504 = new DoubleSetting("health", "Health", (String)null, 5.0D, 1.0D, 19.0D);

   public f6u() {
      super("autolog", "AutoLog", "Logs out when requirements are met.");
      this.register(this.field_502);
      this.register(this.field_503);
      this.register(this.field_504);
   }

   // $FF: renamed from: 1 (java.lang.String) void
   public void method_711(String var1) {
      if (this.c.getConnection() == null) {
         this.c.world.sendQuittingDisconnectingPacket();
      } else {
         this.c.getConnection().getNetworkManager().closeChannel(new TextComponentString(var1));
      }

      PyroStatic.field_2479.c.method_3033(false);
      this.c.method_3033(false);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_712(f4t var1) {
      this.5(String.valueOf(String.format("%.1f", this.field_504.c())));
      if (this.c.player.isEntityAlive()) {
         if ((Boolean)this.field_502.c()) {
            boolean var2 = (Boolean)PyroStatic.field_2509.field_314.c();
            PyroStatic.field_2509.field_314.c(true);
            boolean var3 = false;
            Iterator var4 = this.c.world.playerEntities.iterator();

            while(var4.hasNext()) {
               EntityPlayer var5 = (EntityPlayer)var4.next();
               if (PyroStatic.field_2509.method_452(var5, (Entity)null, false)) {
                  this.method_711("[AutoLog] " + var5.getName() + " came into render distance.");
                  break;
               }
            }

            PyroStatic.field_2509.field_314.c(var2);
            if (var3) {
               return;
            }
         }

         if ((Boolean)this.field_503.c() && this.c.world.isBlockLoaded(new BlockPos(this.c.player.lastTickPosX, this.c.player.lastTickPosY, this.c.player.lastTickPosZ), false) && this.c.world.isBlockLoaded(new BlockPos(this.c.player.posX, this.c.player.posY, this.c.player.posZ), false) && PyroStatic.field_2492.method_701() > 0) {
            return;
         }

         if ((double)(this.c.player.getHealth() + this.c.player.getAbsorptionAmount()) <= (Double)this.field_504.c()) {
            if (!(Boolean)this.field_503.c()) {
               int var6 = PyroStatic.field_2492.method_701();
               this.method_711("[AutoLog] Logged out with " + var6 + " totems and " + this.c.player.getHealth() + " hearts remaining.");
            } else {
               this.method_711("[AutoLog] Logged out with " + this.c.player.getHealth() + " hearts remaining.");
            }
         }
      }

   }
}
