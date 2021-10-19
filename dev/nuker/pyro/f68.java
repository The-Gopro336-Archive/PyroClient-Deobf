/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.NotNull;

public class f68 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_204 = (BooleanSetting)this.register((f0w)(new BooleanSetting("doubleHoles", "Doubles", "Allow anchoring in double holes", true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_205 = (BooleanSetting)this.register((f0w)(new BooleanSetting("disable_complete", "Disable On Complete", "Disables anchor aftor sucessfully anchoring once", false)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_206 = (BooleanSetting)this.register((f0w)(new BooleanSetting("pitch_mode", "Pitch Mode", "Only enable when looking below X pitch", true)));
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_207 = (IntegerSetting)this.register((f0w)(new IntegerSetting("pitch", "Pitch", "Pitch for pitch mode", 70, -90, 90, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c boolean
   public boolean field_208;

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_293() {
      return this.field_204;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_294() {
      return this.field_205;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_295() {
      return this.field_208;
   }

   public f68() {
      super("anchor", "Anchor", "Pulls you to the bottom of a hole you go over");
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_296() {
      return this.field_206;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g(1)
   @LauncherEventHide
   public void method_297(@NotNull f4p var1) {
      this.field_208 = false;
      if (!(Boolean)this.field_206.c() || this.c.player.rotationPitch >= ((Number)this.field_207.c()).floatValue()) {
         BlockPos var2 = new BlockPos(this.c.player.getPositionVector());
         if (!PyroStatic.field_2472.method_904((Entity)this.c.player)) {
            int var3 = 0;

            for(byte var4 = 5; var3 <= var4; ++var3) {
               if (!this.c.world.isAirBlock(var2.down(var3 + 1))) {
                  int var5 = PyroStatic.field_2517.method_954(var2.down(var3), (Boolean)this.field_204.c());
                  if (var5 != 0) {
                     Vec3d var6 = new Vec3d((Vec3i)var2);
                     if (var5 > 2) {
                        EnumFacing var7 = EnumFacing.VALUES[var5 - 3];
                        boolean var8 = true;
                        int var9 = 0;
                        int var10 = var3;
                        if (var9 <= var3) {
                           while(true) {
                              if (!this.c.world.isAirBlock(var2.offset(var7).down(var3 - var9))) {
                                 var8 = false;
                              }

                              if (var9 == var10) {
                                 break;
                              }

                              ++var9;
                           }
                        }

                        if (var8) {
                           var6 = var6.addVector((double)var7.getFrontOffsetX() / 2.0D, (double)var7.getFrontOffsetY() / 2.0D, (double)var7.getFrontOffsetZ() / 2.0D);
                        }
                     }

                     this.c.player.motionX = 0.0D;
                     this.c.player.motionZ = 0.0D;
                     this.c.player.movementInput.moveForward = 0.0F;
                     this.c.player.movementInput.moveStrafe = 0.0F;
                     if (this.c.player.motionY > -0.1D) {
                        this.c.player.motionY = -0.1D;
                     }

                     if (this.c.player.getEntityBoundingBox().minX <= var6.x || this.c.player.getEntityBoundingBox().minZ <= var6.z || this.c.player.getEntityBoundingBox().maxX >= var6.x + (double)1 || this.c.player.getEntityBoundingBox().maxZ >= var6.z + (double)1) {
                        double var11 = var6.x + 0.5D - this.c.player.posX;
                        double var12 = var6.z + 0.5D - this.c.player.posZ;
                        var1.method_3125(var11 / (double)2);
                        var1.method_3127(var12 / (double)2);
                     }

                     this.field_208 = true;
                     var1.0();
                  }
                  break;
               }
            }
         }
      }

      if (this.c.player.onGround && PyroStatic.field_2472.method_904((Entity)this.c.player) && (!(Boolean)this.field_206.c() || this.c.player.rotationPitch >= ((Number)this.field_207.c()).floatValue())) {
         this.field_208 = true;
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_298() {
      return this.field_207;
   }

   // $FF: renamed from: c (boolean) void
   public void method_299(boolean var1) {
      this.field_208 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g(1)
   @LauncherEventHide
   public void method_300(@NotNull f4t var1) {
      this.field_208 = false;
      if (this.c.player.onGround && PyroStatic.field_2472.method_904((Entity)this.c.player)) {
         if (!(Boolean)this.field_206.c() || this.c.player.rotationPitch >= ((Number)this.field_207.c()).floatValue()) {
            this.field_208 = true;
         }

         if ((Boolean)this.field_205.c()) {
            this.c.method_3033(false);
         }
      }

   }
}
