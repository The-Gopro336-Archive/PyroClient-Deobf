/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class f6J extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting field_599 = (BindSetting)this.register((f0w)(new BindSetting("key", "Key", "Active while holding this key", -1)));

   // $FF: renamed from: c () dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting method_898() {
      return this.field_599;
   }

   public f6J() {
      super("fall", "Fall", "Imm falllliiinnggggg......");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g(1)
   @LauncherEventHide
   public void method_899(@NotNull f4p var1) {
      if (this.field_599.method_3330()) {
         this.c.player.motionX = 0.0D;
         this.c.player.motionZ = 0.0D;
         this.c.player.movementInput.moveForward = 0.0F;
         this.c.player.movementInput.moveStrafe = 0.0F;
         if (this.c.player.motionY > -0.1D) {
            this.c.player.motionY = -0.1D;
         }

         BlockPos var2 = new BlockPos(this.c.player.getPositionVector());
         if (this.c.player.getEntityBoundingBox().minX <= (double)var2.getX() || this.c.player.getEntityBoundingBox().minZ <= (double)var2.getZ() || this.c.player.getEntityBoundingBox().maxX >= (double)(var2.getX() + 1) || this.c.player.getEntityBoundingBox().maxZ >= (double)(var2.getZ() + 1)) {
            double var3 = (double)var2.getX() + 0.5D - this.c.player.posX;
            double var5 = (double)var2.getZ() + 0.5D - this.c.player.posZ;
            var1.method_3125(var3 / (double)2);
            var1.method_3127(var5 / (double)2);
         }

         var1.0();
      }

   }
}
