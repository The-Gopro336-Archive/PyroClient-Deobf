/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketPlayer.Position;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f9Y extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_265 = new DoubleSetting("stepheight", "Height", "How much should step be able to go", 1.0D, 1.0D, 10.0D);
   // $FF: renamed from: c double[][]
   public double[][] field_266 = new double[][]{{0.42D, 0.753D}, {0.42D, 0.75D, 1.0D, 1.16D, 1.23D, 1.2D}, {0.42D, 0.78D, 0.63D, 0.51D, 0.9D, 1.21D, 1.45D, 1.43D}, {0.425D, 0.821D, 0.699D, 0.599D, 1.022D, 1.372D, 1.652D, 1.869D, 2.019D, 1.907D}};
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_267;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_268;
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_269;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_270;
   // $FF: renamed from: 1 int
   public int field_271;
   // $FF: renamed from: 2 int
   public int field_272;
   // $FF: renamed from: c double
   public double field_273;
   // $FF: renamed from: 0 double
   public double field_274;
   // $FF: renamed from: 1 double
   public double field_275;
   // $FF: renamed from: c boolean
   public boolean field_276;

   // $FF: renamed from: c (dev.nuker.pyro.f4z) void
   @f0g
   @LauncherEventHide
   public void method_392(f4z var1) {
      if (this.field_267.c() == f9X.field_1949) {
         if (var1.c() == f41.field_2120) {
            if (this.c.player.onGround && this.c.player.collidedHorizontally && !this.c.player.movementInput.sneak) {
               var1.method_3185((float)(Double)this.field_265.c());
               this.field_275 = var1.c().minY;
            }
         } else if (var1.c() == f41.field_2121 && var1.method_3184() == ((Double)this.field_265.c()).floatValue()) {
            double var2 = var1.c().minY - this.field_275;
            if (var2 > 0.7D) {
               this.field_276 = true;
               if (var2 <= 0.75D) {
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.41999998688698D, this.c.player.posZ, false));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.75319999805212D, this.c.player.posZ, false));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.00133597911216D, this.c.player.posZ, false));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.166109260938214D, this.c.player.posZ, false));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.24918707874468D, this.c.player.posZ, false));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.25220334025373D, this.c.player.posZ, false));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.17675927506424D, this.c.player.posZ, false));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.024424088213685D, this.c.player.posZ, false));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.79673560066871D, this.c.player.posZ, false));
                  if ((Boolean)this.field_268.c()) {
                     this.field_271 = 1;
                     f0b.field_2415.method_3667("step", f07.field_2303, 0.5F);
                  }
               } else if (var2 < 0.875D) {
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.41999998688698D, this.c.player.posZ, this.c.player.onGround));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.75319999805212D, this.c.player.posZ, this.c.player.onGround));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.00133597911215D, this.c.player.posZ, this.c.player.onGround));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.166109260938214D, this.c.player.posZ, this.c.player.onGround));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.24918707874468D, this.c.player.posZ, this.c.player.onGround));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.25220334025373D, this.c.player.posZ, this.c.player.onGround));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.17675927506424D, this.c.player.posZ, this.c.player.onGround));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.024424088213685D, this.c.player.posZ, this.c.player.onGround));
                  if ((Boolean)this.field_268.c()) {
                     this.field_271 = 1;
                     f0b.field_2415.method_3667("step", f07.field_2303, 0.5F);
                  }
               } else if (var2 <= 0.875D) {
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.42D, this.c.player.posZ, this.c.player.onGround));
                  this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 0.73D, this.c.player.posZ, this.c.player.onGround));
                  if ((Boolean)this.field_268.c()) {
                     this.field_271 = 1;
                     f0b.field_2415.method_3667("step", f07.field_2303, 0.5F);
                  }
               } else {
                  int var4;
                  if (var2 <= 1.0D) {
                     for(var4 = 0; var4 < this.field_266[0].length; ++var4) {
                        this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + this.field_266[0][var4], this.c.player.posZ, this.c.player.onGround));
                     }

                     if ((Boolean)this.field_268.c()) {
                        this.field_271 = 1;
                        f0b.field_2415.method_3667("step", f07.field_2303, 0.5F);
                     }
                  } else if (var2 <= 1.125D) {
                     for(var4 = 0; var4 < this.field_266[0].length; ++var4) {
                        this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + this.field_266[0][var4], this.c.player.posZ, this.c.player.onGround));
                     }

                     this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.00133597911215D, this.c.player.posZ, this.c.player.onGround));
                     this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + 1.166109260938214D, this.c.player.posZ, this.c.player.onGround));
                     if ((Boolean)this.field_268.c()) {
                        this.field_271 = 1;
                        f0b.field_2415.method_3667("step", f07.field_2303, 0.25F);
                     }
                  } else if (var2 <= (Double)this.field_265.c() && var2 <= 1.5D) {
                     for(var4 = 0; var4 < this.field_266[1].length; ++var4) {
                        this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + this.field_266[1][var4], this.c.player.posZ, this.c.player.onGround));
                     }

                     if ((Boolean)this.field_268.c()) {
                        this.field_271 = 1;
                        f0b.field_2415.method_3667("step", f07.field_2303, 0.15F);
                     }
                  } else if (var2 <= (Double)this.field_265.c() && var2 <= 2.0D) {
                     for(var4 = 0; var4 < this.field_266[2].length; ++var4) {
                        this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + this.field_266[2][var4], this.c.player.posZ, this.c.player.onGround));
                     }

                     if ((Boolean)this.field_268.c()) {
                        this.field_271 = 1;
                        f0b.field_2415.method_3667("step", f07.field_2303, 0.11F);
                     }
                  } else if (var2 <= (Double)this.field_265.c()) {
                     for(var4 = 0; var4 < this.field_266[3].length; ++var4) {
                        this.c.player.connection.sendPacket(new Position(this.c.player.posX, this.c.player.posY + this.field_266[3][var4], this.c.player.posZ, this.c.player.onGround));
                     }

                     if ((Boolean)this.field_268.c()) {
                        this.field_271 = 1;
                        f0b.field_2415.method_3667("step", f07.field_2303, 0.1F);
                     }
                  }
               }

               if ((Boolean)this.field_270.c()) {
                  Pyro.INSTANCE.sendMessage("Toggling step.");
                  this.c.method_3033(false);
               }
            }
         }
      }

      if (var1.c() == f41.field_2120 && this.field_267.c() == f9X.field_1951) {
         var1.method_3185((float)(Double)this.field_265.c());
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(3)
   @LauncherEventHide
   public void method_393(f4u var1) {
      if (var1.c() == f41.field_2120) {
         this.5(String.valueOf(this.field_267.c()));
         if (this.field_271 != 0) {
            --this.field_271;
            return;
         }

         f0b.field_2415.method_3669("step");
      }

   }

   // $FF: renamed from: 0 (double) net.minecraft.util.math.AxisAlignedBB
   public AxisAlignedBB method_394(double var1) {
      boolean var3 = this.c.player.onGround && this.c.player.collidedHorizontally && this.c.player.fallDistance == 0.0F && !this.c.player.isInWater() && !this.c.player.isInLava() && !this.c.player.isOnLadder() && !this.c.player.movementInput.jump && !this.c.player.movementInput.sneak;
      return !var3 ? null : this.method_397(var1);
   }

   public f9Y() {
      super("step", "Step", "Allows you to automatically step up blocks", true);
      this.field_267 = new f0o("stepmode", "Mode", "What mode to perform on for stepping", f9X.field_1949);
      this.field_268 = new BooleanSetting("useTimer", "UseTimer", (String)null, true);
      this.field_269 = new DoubleSetting("legitSpeed", "LegitSpeed", (String)null, 0.2D, 0.0D, 1.0D);
      this.field_270 = new BooleanSetting("Toggle", "Toggle", "Toggles on completing one step", false);
      this.field_271 = 0;
      this.field_272 = 0;
      this.field_273 = 0.0D;
      this.field_274 = 0.0D;
      this.field_275 = 0.0D;
      this.field_276 = false;
      this.register(this.field_267);
      this.register(this.field_265);
      this.register(this.field_268);
      this.register(this.field_269);
      this.register(this.field_270);
   }

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB) double
   public double method_395(AxisAlignedBB var1) {
      return var1 != null ? var1.minY - this.c.player.getEntityBoundingBox().minY : 0.0D;
   }

   // $FF: renamed from: c (double) double
   public double method_396(double var1) {
      boolean var3 = this.c.player.onGround && this.c.player.collidedHorizontally && this.c.player.fallDistance == 0.0F && !this.c.player.isInWater() && !this.c.player.isInLava() && !this.c.player.isOnLadder() && !this.c.player.movementInput.jump && !this.c.player.movementInput.sneak;
      return !var3 ? 0.0D : this.method_397(var1).minY - this.c.player.getEntityBoundingBox().minY;
   }

   // $FF: renamed from: 1 (double) net.minecraft.util.math.AxisAlignedBB
   public AxisAlignedBB method_397(double var1) {
      double[] var3 = fec.method_1763(0.20000000298023224D);
      double var4 = var3[0];
      double var6 = var3[1];
      double var8 = var4;
      double var10 = 0.0D;
      double var12 = var6;
      List var14 = this.c.world.getCollisionBoxes(this.c.player, this.c.player.getEntityBoundingBox().expand(var4, 0.0D, var6));
      AxisAlignedBB var15 = this.c.player.getEntityBoundingBox();
      int var16;
      int var17;
      if (var4 != 0.0D) {
         var16 = 0;

         for(var17 = var14.size(); var16 < var17; ++var16) {
            var4 = ((AxisAlignedBB)var14.get(var16)).calculateXOffset(var15, var4);
         }

         if (var4 != 0.0D) {
            var15 = var15.offset(var4, 0.0D, 0.0D);
         }
      }

      if (var6 != 0.0D) {
         var16 = 0;

         for(var17 = var14.size(); var16 < var17; ++var16) {
            var6 = ((AxisAlignedBB)var14.get(var16)).calculateZOffset(var15, var6);
         }

         if (var6 != 0.0D) {
            var15 = var15.offset(0.0D, 0.0D, var6);
         }
      }

      double var56 = var4;
      double var18 = 0.0D;
      double var20 = var6;
      AxisAlignedBB var22 = this.c.player.getEntityBoundingBox();
      List var25 = this.c.world.getCollisionBoxes(this.c.player, var15.expand(var8, var1, var12));
      AxisAlignedBB var27 = var15.expand(var8, 0.0D, var12);
      double var28 = var1;
      int var30 = 0;

      for(int var31 = var25.size(); var30 < var31; ++var30) {
         var28 = ((AxisAlignedBB)var25.get(var30)).calculateYOffset(var27, var28);
      }

      AxisAlignedBB var26 = var15.offset(0.0D, var28, 0.0D);
      double var57 = var8;
      int var33 = 0;

      for(int var34 = var25.size(); var33 < var34; ++var33) {
         var57 = ((AxisAlignedBB)var25.get(var33)).calculateXOffset(var26, var57);
      }

      var26 = var26.offset(var57, 0.0D, 0.0D);
      double var58 = var12;
      int var36 = 0;

      for(int var37 = var25.size(); var36 < var37; ++var36) {
         var58 = ((AxisAlignedBB)var25.get(var36)).calculateZOffset(var26, var58);
      }

      var26 = var26.offset(0.0D, 0.0D, var58);
      AxisAlignedBB var59 = var15;
      double var38 = var1;
      int var40 = 0;

      for(int var41 = var25.size(); var40 < var41; ++var40) {
         var38 = ((AxisAlignedBB)var25.get(var40)).calculateYOffset(var59, var38);
      }

      var59 = var59.offset(0.0D, var38, 0.0D);
      double var60 = var8;
      int var43 = 0;

      for(int var44 = var25.size(); var43 < var44; ++var43) {
         var60 = ((AxisAlignedBB)var25.get(var43)).calculateXOffset(var59, var60);
      }

      var59 = var59.offset(var60, 0.0D, 0.0D);
      double var54 = var12;
      int var46 = 0;

      for(int var47 = var25.size(); var46 < var47; ++var46) {
         var54 = ((AxisAlignedBB)var25.get(var46)).calculateZOffset(var59, var54);
      }

      var59 = var59.offset(0.0D, 0.0D, var54);
      double var55 = var57 * var57 + var58 * var58;
      double var49 = var60 * var60 + var54 * var54;
      AxisAlignedBB var51 = null;
      double var23;
      if (var55 > var49) {
         var4 = var57;
         var6 = var58;
         var23 = -var28;
         var51 = var26;
      } else {
         var4 = var60;
         var6 = var54;
         var23 = -var38;
         var51 = var59;
      }

      int var52 = 0;

      for(int var53 = var25.size(); var52 < var53; ++var52) {
         var23 = ((AxisAlignedBB)var25.get(var52)).calculateYOffset(var51, var23);
      }

      var51 = var51.offset(0.0D, var23, 0.0D);
      if (var56 * var56 + var20 * var20 >= var4 * var4 + var6 * var6) {
         var51 = var22;
      }

      return var51;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g(2)
   @LauncherEventHide
   public void method_398(f4p var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      f0b.field_2415.method_3669("step");
      this.field_271 = 0;
      this.field_275 = 0.0D;
      this.field_276 = false;
   }
}
