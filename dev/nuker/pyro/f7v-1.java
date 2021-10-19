/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7v extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_373 = (BooleanSetting)this.register((f0w)(new BooleanSetting("ridingOnly", "RidingOnly", "Only activates while riding", true)));

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_546() {
      return this.field_373;
   }

   // $FF: renamed from: 0 () boolean
   public boolean method_547() {
      if (this.c.player == null) {
         return false;
      } else {
         int var1 = MathHelper.floor(this.c.player.getEntityBoundingBox().minX);

         for(int var2 = MathHelper.floor(this.c.player.getEntityBoundingBox().maxX) + 1; var1 < var2; ++var1) {
            int var3 = MathHelper.floor(this.c.player.getEntityBoundingBox().minY);

            for(int var4 = MathHelper.floor(this.c.player.getEntityBoundingBox().maxY) + 1; var3 < var4; ++var3) {
               int var5 = MathHelper.floor(this.c.player.getEntityBoundingBox().minZ);

               for(int var6 = MathHelper.floor(this.c.player.getEntityBoundingBox().maxZ) + 1; var5 < var6; ++var5) {
                  Block var7 = feg.method_1779(new BlockPos(var1, var3, var5));
                  if (var7 != null && !(var7 instanceof BlockAir)) {
                     if (var7 instanceof BlockTallGrass) {
                        return false;
                     }

                     AxisAlignedBB var8 = var7.getSelectedBoundingBox(feg.method_1791(new BlockPos(var1, var3, var5)), (World)this.c.world, new BlockPos(var1, var3, var5));
                     if (var8 != null && this.c.player.getEntityBoundingBox().intersects(var8)) {
                        return true;
                     }
                  }
               }
            }
         }

         return false;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   public void method_548(@NotNull f4t var1) {
      if (this.c.player == null || this.c.player.isRiding() || !(Boolean)this.field_373.c()) {
         this.c.player.motionY = 0.0D;
         if (this.c.player.movementInput.jump) {
            this.c.player.motionY = 0.3D;
         } else if (this.c.player.movementInput.sneak) {
            this.c.player.motionY = -0.3D;
         }

      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4x) void
   @f0g
   @LauncherEventHide
   public void method_549(@NotNull f4x var1) {
      if (this.c.player == null || this.c.player.isRiding() || !(Boolean)this.field_373.c()) {
         var1.0();
      }
   }

   public f7v() {
      super("sandphase", "SandPhase", "Allows you to phase in sand");
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.util.math.AxisAlignedBB) net.minecraft.util.math.AxisAlignedBB
   @Nullable
   public AxisAlignedBB method_550(@NotNull BlockPos var1, @NotNull AxisAlignedBB var2) {
      if (this.c.player != null && !this.c.player.isRiding() && (Boolean)this.field_373.c()) {
         return var2;
      } else if (this.method_547()) {
         if (this.c.player != null) {
            this.c.player.noClip = true;
         }

         return null;
      } else {
         return var2;
      }
   }
}
