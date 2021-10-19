/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f71 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_603 = new BooleanSetting("hitDelay", "HitDelay", (String)null, true);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_604 = new BooleanSetting("tpsSync", "TPSSync", (String)null, true);
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   public IntegerSetting field_605 = new IntegerSetting("tickDelay", "TickDelay", "How many ticks to wait each hit", 2, 0, 20);
   // $FF: renamed from: 1 int
   public int field_606 = 0;

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_902(f4t var1) {
      ++this.field_606;
      if (this.c.objectMouseOver != null && this.c.objectMouseOver.entityHit != null && this.method_903()) {
         ((MinecraftAccessor)this.c).setLeftClickCounter(0);
         this.c.playerController.attackEntity(this.c.player, this.c.objectMouseOver.entityHit);
         this.c.player.swingArm(EnumHand.MAIN_HAND);
      }

      if (this.field_606 >= (Integer)this.field_605.c()) {
         this.field_606 = 0;
      }

   }

   public f71() {
      super("trigger", "Trigger", "Automatically swings when your crosshair is over an entity");
      this.register(this.field_603);
      this.register(this.field_604);
      this.register(this.field_605);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_606 = 0;
   }

   // $FF: renamed from: c () boolean
   public boolean method_903() {
      if (!(Boolean)this.field_603.c()) {
         return this.field_606 >= (Integer)this.field_605.c();
      } else {
         float var1 = 20.0F - f04.field_2316.method_3478();
         return (Boolean)this.field_603.c() ? this.c.player.getCooledAttackStrength((Boolean)this.field_604.c() ? -var1 : 0.0F) >= 1.0F : true;
      }
   }
}
