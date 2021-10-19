/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.PlayerControllerMPAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.util.EnumHand;

public class fdm extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_842;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_843;
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_844;

   public fdm() {
      super("speedmine", "Speedmine", "Allows you to mine blocks faster");
      this.field_842 = new f0o("mode", "Mode", (String)null, fdl.field_1310);
      this.field_843 = new DoubleSetting("startDamage", "Start Damage", (String)null, 0.0D, 0.0D, 1.0D);
      this.field_844 = new DoubleSetting("enddamage", "End Damage", (String)null, 0.699999988079071D, 0.0D, 1.0D);
      this.register(this.field_842);
      this.register(this.field_843);
      this.register(this.field_844);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4l) void
   @f0g
   @LauncherEventHide
   public void method_1249(f4l var1) {
      if (var1.c() == f41.field_2120 && this.field_842.c() == fdl.field_1311) {
         var1.0();
         this.c.player.swingArm(EnumHand.MAIN_HAND);
         this.c.player.connection.sendPacket(new CPacketPlayerDigging(Action.START_DESTROY_BLOCK, var1.method_3148(), var1.method_3147()));
         this.c.player.connection.sendPacket(new CPacketPlayerDigging(Action.STOP_DESTROY_BLOCK, var1.method_3148(), var1.method_3147()));
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1250(f4t var1) {
      this.5(String.valueOf(this.field_842.c()));
      if (this.field_842.c() == fdl.field_1310) {
         PlayerControllerMPAccessor var2 = (PlayerControllerMPAccessor)this.c.playerController;
         var2.setBlockHitDelay(0);
         if ((Double)this.field_843.c() != 0.0D && (double)var2.getCurBlockDamageMP() <= (Double)this.field_843.c()) {
            double var3 = (Double)this.field_843.c();
            var2.setCurBlockDamageMP((float)var3);
         }

         if ((double)var2.getCurBlockDamageMP() >= (Double)this.field_844.c()) {
            var2.setCurBlockDamageMP(1.0F);
         }
      }

   }
}
