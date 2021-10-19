/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class f9u extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_158;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_159;
   // $FF: renamed from: c boolean
   public boolean field_160;
   // $FF: renamed from: c float
   public float field_161;

   // $FF: renamed from: 1 () boolean
   public boolean method_242() {
      return this.c.player.fallDistance < 3.0F && !this.c.player.movementInput.jump && !this.method_245() && !this.c.player.isSneaking();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_243(f4t var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable) void
   public void method_244(BlockPos var1, CallbackInfoReturnable var2) {
      if (this.c.world != null && this.c.player != null && (Boolean)this.c.method_3034()) {
         if (this.field_158.c() != f9t.field_2255) {
            if (!this.method_245()) {
               if (!this.c.player.isRowingBoat() && !this.c.player.isSneaking()) {
                  var2.cancel();
                  var2.setReturnValue(Block.FULL_BLOCK_AABB);
                  if (this.c.player.getRidingEntity() != null) {
                     var2.setReturnValue(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.949999988079071D, 1.0D));
                  } else if (this.field_158.c() == f9t.field_2255) {
                     if (this.method_242()) {
                        var2.setReturnValue(new AxisAlignedBB((double)var1.getX(), (double)var1.getY(), (double)var1.getY(), (double)var1.getX(), (double)var1.getY() + (this.c.player.movementInput.jump ? 0.95D : 0.99D), (double)var1.getZ()));
                     }
                  } else if (this.field_158.c() == f9t.field_2256 && !this.c.player.isSneaking()) {
                     var2.setReturnValue(new AxisAlignedBB((double)var1.getX(), (double)var1.getY(), (double)var1.getY(), (double)var1.getX(), (double)var1.getY() + 0.96D, (double)var1.getZ()));
                  }
               }

            }
         }
      }
   }

   // $FF: renamed from: c () boolean
   public boolean method_245() {
      if (this.c.player == null) {
         return false;
      } else {
         boolean var1 = false;
         int var2 = (int)(this.c.player.getEntityBoundingBox().minY + 0.02D);

         for(int var3 = MathHelper.floor(this.c.player.getEntityBoundingBox().minX); var3 < MathHelper.floor(this.c.player.getEntityBoundingBox().maxX) + 1; ++var3) {
            for(int var4 = MathHelper.floor(this.c.player.getEntityBoundingBox().minZ); var4 < MathHelper.floor(this.c.player.getEntityBoundingBox().maxZ) + 1; ++var4) {
               Block var5 = this.c.world.getBlockState(new BlockPos(var3, var2, var4)).getBlock();
               if (var5 != null && !(var5 instanceof BlockAir)) {
                  if (!(var5 instanceof BlockLiquid)) {
                     return false;
                  }

                  var1 = true;
               }
            }
         }

         return var1;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_246(f49 var1) {
      if (var1.c() == f41.field_2120 && this.c.world != null && this.c.player != null) {
         if (var1.c() instanceof CPacketPlayer && this.method_247() && this.method_242()) {
            CPacketPlayerAccessor var2 = (CPacketPlayerAccessor)((CPacketPlayer)var1.c());
            if (!(Boolean)this.field_159.c()) {
               if (this.c.player.ticksExisted % 2 == 0 && this.field_158.c() == f9t.field_2254) {
                  var2.setPosY(var2.getPosY() - 0.05D);
               }
            } else {
               var2.setPosY(var2.getPosY() - (double)this.field_161);
               this.field_161 += 0.12F;
               if (this.field_161 > 0.4F) {
                  this.field_161 = 0.2F;
               }
            }
         }

      }
   }

   public f9u() {
      super("jesus", "Jesus", "Allows you to walk on water");
      this.field_158 = new f0o("mode", "Mode", (String)null, f9t.field_2254);
      this.field_159 = new BooleanSetting("ncpStrict", "NCP Strict", (String)null, false);
      this.field_160 = false;
      this.register(this.field_158);
      this.register(this.field_159);
   }

   // $FF: renamed from: 0 () boolean
   public boolean method_247() {
      float var1 = 0.05F;
      if (this.c.player == null) {
         return false;
      } else if (this.c.player.fallDistance >= 3.0F) {
         return false;
      } else if (this.c.player == null) {
         return false;
      } else {
         AxisAlignedBB var2 = this.c.player.getRidingEntity() != null ? this.c.player.getRidingEntity().getEntityBoundingBox().contract(0.0D, 0.0D, 0.0D).offset(0.0D, -0.05000000074505806D, 0.0D) : this.c.player.getEntityBoundingBox().contract(0.0D, 0.0D, 0.0D).offset(0.0D, -0.05000000074505806D, 0.0D);
         boolean var3 = false;
         int var4 = (int)var2.minY;

         for(int var5 = MathHelper.floor(var2.minX); var5 < MathHelper.floor(var2.maxX + 1.0D); ++var5) {
            for(int var6 = MathHelper.floor(var2.minZ); var6 < MathHelper.floor(var2.maxZ + 1.0D); ++var6) {
               Block var7 = this.c.world.getBlockState(new BlockPos(var5, var4, var6)).getBlock();
               if (var7 != Blocks.AIR) {
                  if (!(var7 instanceof BlockLiquid)) {
                     return false;
                  }

                  var3 = true;
               }
            }
         }

         return var3;
      }
   }
}
