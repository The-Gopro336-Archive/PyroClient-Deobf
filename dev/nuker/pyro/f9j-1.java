/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f9j extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_193 = (BooleanSetting)this.register((f0w)(new BooleanSetting("antiStuck", "AntiStuck", (String)null, false)));
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_194 = (DoubleSetting)this.register((f0w)(new DoubleSetting("speed", "Speed", (String)null, 0.5D, 0.1D, 3.8D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_195 = new fe8();
   // $FF: renamed from: 0 dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_196 = new fe8();

   // $FF: renamed from: 2 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_275() {
      return this.field_194;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_276() {
      return this.field_193;
   }

   public f9j() {
      super("entityspeed", "EntitySpeed", "Control the speed of your riding entity");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_277(@Nullable f4t var1) {
      StringCompanionObject var2 = StringCompanionObject.INSTANCE;
      String var3 = "%.1f";
      Object[] var4 = new Object[]{this.field_194.c()};
      boolean var5 = false;
      String var10 = String.format(var3, Arrays.copyOf(var4, var4.length));
      this.5(var10);
      if (this.c.player.isRiding()) {
         double var12 = Math.toRadians((double)(this.c.player.rotationYaw + 90.0F));
         boolean var6 = false;
         double var11 = Math.cos(var12);
         double var13 = Math.toRadians((double)(this.c.player.rotationYaw + 90.0F));
         boolean var8 = false;
         var12 = Math.sin(var13);
         BlockPos var14 = new BlockPos(this.c.player.posX + 2.0D * var11 + 0.0D * var12, this.c.player.posY - 1.0D, this.c.player.posZ + (2.0D * var12 - 0.0D * var11));
         BlockPos var7 = new BlockPos(this.c.player.posX + 2.0D * var11 + 0.0D * var12, this.c.player.posY - 2.0D, this.c.player.posZ + (2.0D * var12 - 0.0D * var11));
         Entity var10000 = this.c.player.getRidingEntity();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         if (!var10000.onGround && !this.c.world.getBlockState(var14).getMaterial().blocksMovement() && !this.c.world.getBlockState(var7).getMaterial().blocksMovement() && (Boolean)this.field_193.c()) {
            fec.method_1753(0.0D);
            this.field_195.method_1979();
            return;
         }

         if (this.c.world.getBlockState(new BlockPos(this.c.player.posX + 2.0D * var11 + 0.0D * var12, this.c.player.posY, this.c.player.posZ + (2.0D * var12 - 0.0D * var11))).getMaterial().blocksMovement() && (Boolean)this.field_193.c()) {
            fec.method_1753(0.0D);
            this.field_195.method_1979();
            return;
         }

         if (this.c.world.getBlockState(new BlockPos(this.c.player.posX + 1.0D * var11 + 0.0D * var12, this.c.player.posY + 1.0D, this.c.player.posZ + (1.0D * var12 - 0.0D * var11))).getMaterial().blocksMovement() && (Boolean)this.field_193.c()) {
            fec.method_1753(0.0D);
            this.field_195.method_1979();
            return;
         }

         if (this.c.player.movementInput.jump) {
            this.field_196.method_1979();
         }

         if (this.field_195.method_1980(10000.0D) || !(Boolean)this.field_193.c()) {
            f9e var15 = PyroStatic.field_2582;
            var10000 = this.c.player.getRidingEntity();
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            if (!var10000.isInWater() && !(Boolean)var15.c.method_3034() && !this.c.player.movementInput.jump && this.field_196.method_1980(1000.0D)) {
               var10000 = this.c.player.getRidingEntity();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               if (var10000.onGround) {
                  var10000 = this.c.player.getRidingEntity();
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var10000.motionY = 0.4D;
               }

               var10000 = this.c.player.getRidingEntity();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var10000.motionY = -0.4D;
            }

            fec.method_1753(((Number)this.field_194.c()).doubleValue());
         }
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_278() {
      return this.field_195;
   }

   // $FF: renamed from: c () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_279() {
      return this.field_196;
   }
}
