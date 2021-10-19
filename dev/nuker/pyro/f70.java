/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class f70 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_607 = (BooleanSetting)this.register((f0w)(new BooleanSetting("toggles", "Toggle", "Toggles off after surrounded", false)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_608 = (BooleanSetting)this.register((f0w)(new BooleanSetting("center", "Center", "Tries to center you in the middle of the block", true)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_609 = (BooleanSetting)this.register((f0w)(new BooleanSetting("toggleOffGround", "ToggleOffGround", "Toggles when your offground", true)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_610 = (BooleanSetting)this.register((f0w)(new BooleanSetting("toggleInHole", "EnableInHole", "Enables surround when you jump in a hole", false)));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_611 = (BooleanSetting)this.register((f0w)(new BooleanSetting("doubles", "Double", "Surrounds two layers", false)));
   // $FF: renamed from: c dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting field_612 = (BindSetting)this.register((f0w)(new BindSetting("doubles", "Double", "Surrounds two layers", -1)));
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_613 = (f0l)this.register((f0w)(new f0l("unplaced_color", "Unplaced Color", (String)null, new f00(0.0F, 1.0F, 1.0F, 0.13636F))));
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_614 = (f0l)this.register((f0w)(new f0l("placed_color", "Placed Color", (String)null, new f00(0.35F, 1.0F, 0.46666F, 0.13636F))));
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_615 = (BooleanSetting)this.register((f0w)(new BooleanSetting("checkCollision", "CheckCollision", "Checks for entity collision before trying to place", true)));
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_616 = (BooleanSetting)this.register((f0w)(new BooleanSetting("instant", "Instant", (String)null, false)));
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   public Vec3d field_617;
   // $FF: renamed from: c boolean
   public boolean field_618;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos[]
   @Nullable
   public BlockPos[] field_619;
   // $FF: renamed from: c boolean[]
   public boolean[] field_620;
   // $FF: renamed from: c dev.nuker.pyro.f6Z
   public static f6Z field_621 = new f6Z((DefaultConstructorMarker)null);

   // $FF: renamed from: 3 (net.minecraft.entity.Entity) boolean
   public boolean method_904(@NotNull Entity var1) {
      BlockPos[] var4 = this.method_912(var1);
      int var5 = var4.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         BlockPos var2 = var4[var3];
         IBlockState var6 = this.c.world.getBlockState(var2);
         if (this.c.world.getBlockState(var2).getBlock() != Blocks.OBSIDIAN && this.c.world.getBlockState(var2).getBlock() != Blocks.BEDROCK || var6.getBlock() instanceof BlockLiquid || var6.getBlock().isReplaceable((IBlockAccess)this.c.world, var2)) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f70, net.minecraft.client.Minecraft) void
   public static void method_905(f70 var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f70) net.minecraft.client.Minecraft
   public static Minecraft method_906(f70 var0) {
      return var0.c;
   }

   public f70() {
      super("surround", "Surround", "Automatically surrounds you with obsidian to prevent being crystalled");
      this.field_617 = Vec3d.ZERO;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) net.minecraft.util.math.BlockPos[]
   @NotNull
   public BlockPos[] method_907(@NotNull BlockPos var1) {
      return new BlockPos[]{var1.down(), var1.north(), var1.south(), var1.west(), var1.east()};
   }

   // $FF: renamed from: b () net.minecraft.util.math.Vec3d
   public Vec3d method_908() {
      return this.field_617;
   }

   // $FF: renamed from: 8 () net.minecraft.util.math.BlockPos[]
   @Nullable
   public BlockPos[] method_909() {
      return this.field_619;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_910() {
      return this.field_614;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_911() {
      return this.field_613;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) net.minecraft.util.math.BlockPos[]
   @NotNull
   public BlockPos[] method_912(@NotNull Entity var1) {
      BlockPos var2 = new BlockPos(MathHelper.floor(var1.posX), MathHelper.floor(var1.posY), MathHelper.floor(var1.posZ));
      return this.method_907(var2);
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_913() {
      return this.field_609;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_914() {
      return this.field_615;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      if (this.field_619 != null) {
         fe5.field_1245.method_1915(7);
         int var3 = 0;
         BlockPos[] var10000 = this.field_619;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         for(int var4 = var10000.length; var3 < var4; ++var3) {
            var10000 = this.field_619;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            BlockPos var5 = var10000[var3];
            fe5 var6 = fe5.field_1245;
            float var10001 = (float)var5.getX() - 0.001F;
            float var10002 = (float)var5.getY() - 0.001F;
            float var10003 = (float)var5.getZ() - 0.001F;
            boolean[] var10007 = this.field_620;
            if (var10007 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("filledArr");
            }

            var6.method_1901(var10001, var10002, var10003, 1.002F, 1.002F, 1.002F, var10007[var3] ? ((f00)this.field_614.c()).meth1() : ((f00)this.field_613.c()).meth1(), 63);
         }

         GlStateManager.enableDepth();
         fe5.field_1245.method_1912();
      }

   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_915() {
      return this.field_616;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (this.c.player != null) {
         this.field_618 = !this.c.player.onGround;
         if ((Boolean)this.field_608.c()) {
            this.field_617 = field_621.method_2974(this.c.player.posX, this.c.player.posY, this.c.player.posZ);
            this.c.player.motionX = 0.0D;
            this.c.player.motionZ = 0.0D;
         } else {
            this.field_617 = Vec3d.ZERO;
         }

      }
   }

   // $FF: renamed from: 0 (net.minecraft.entity.Entity) boolean
   public boolean method_916(@NotNull Entity var1) {
      BlockPos[] var4 = this.method_912(var1);
      int var5 = var4.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         BlockPos var2 = var4[var3];
         IBlockState var6 = this.c.world.getBlockState(var2);
         if (this.c.world.isAirBlock(var2) || var6.getBlock() instanceof BlockLiquid || var6.getBlock().isReplaceable((IBlockAccess)this.c.world, var2)) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos[]) void
   public void method_917(@Nullable BlockPos[] var1) {
      this.field_619 = var1;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_918() {
      return this.field_607;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d) void
   public void method_919(Vec3d var1) {
      this.field_617 = var1;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_920() {
      return this.field_610;
   }

   // $FF: renamed from: c (dev.nuker.pyro.BooleanSetting) void
   public void method_921(@NotNull BooleanSetting var1) {
      this.field_610 = var1;
   }

   // $FF: renamed from: 2 (net.minecraft.entity.Entity) net.minecraft.util.math.BlockPos[]
   @NotNull
   public BlockPos[] method_922(@NotNull Entity var1) {
      BlockPos var2 = new BlockPos(MathHelper.floor(var1.posX), MathHelper.floor(var1.posY), MathHelper.floor(var1.posZ));
      return !(Boolean)this.field_611.c() && !(((Number)this.field_612.c()).intValue() > 1 ? Keyboard.isKeyDown(((Number)this.field_612.c()).intValue()) : (((Number)this.field_612.c()).intValue() < -1 ? Mouse.isButtonDown(-((Number)this.field_612.c()).intValue()) : false)) ? new BlockPos[]{var2.north().down(), var2.south().down(), var2.west().down(), var2.east().down(), var2.north(), var2.south(), var2.west(), var2.east()} : new BlockPos[]{var2.north().down(), var2.south().down(), var2.west().down(), var2.east().down(), var2.north(), var2.south(), var2.west(), var2.east(), var2.north().up(), var2.south().up(), var2.west().up(), var2.east().up()};
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_923() {
      return this.field_611;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting method_924() {
      return this.field_612;
   }

   // $FF: renamed from: 1 (net.minecraft.entity.Entity) boolean
   public boolean method_925(@NotNull Entity var1) {
      BlockPos[] var4 = this.method_922(var1);
      int var5 = var4.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         BlockPos var2 = var4[var3];
         IBlockState var6 = this.c.world.getBlockState(var2);
         if (this.c.world.isAirBlock(var2) || var6.getBlock() instanceof BlockLiquid || var6.getBlock().isReplaceable((IBlockAccess)this.c.world, var2)) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: c (boolean) void
   public void method_926(boolean var1) {
      this.field_618 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) boolean
   public boolean method_927(@NotNull BlockPos var1) {
      BlockPos[] var4 = this.method_907(var1);
      int var5 = var4.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         BlockPos var2 = var4[var3];
         IBlockState var6 = this.c.world.getBlockState(var2);
         if (var6.getBlock() != Blocks.OBSIDIAN && var6.getBlock() != Blocks.BEDROCK) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_928() {
      return this.field_608;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(2)
   @LauncherEventHide
   public void method_929(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         this.field_619 = this.method_922((Entity)this.c.player);
         BlockPos[] var10001 = this.field_619;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         this.field_620 = new boolean[var10001.length];
         int var2 = 0;
         BlockPos[] var10000 = this.field_619;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         for(int var3 = var10000.length; var2 < var3; ++var2) {
            boolean[] var30 = this.field_620;
            if (var30 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("filledArr");
            }

            BlockPos[] var10002 = this.field_619;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            var30[var2] = !feg.method_1790(var10002[var2]);
         }

         if (this.method_925((Entity)this.c.player)) {
            if ((Boolean)this.field_607.c()) {
               this.c.method_3033(false);
            }

         } else {
            if (this.field_618 && this.c.player.onGround) {
               this.field_618 = false;
            }

            if (!this.field_618 && !this.c.player.onGround && (Boolean)this.field_609.c()) {
               this.c.method_3033(false);
               Pyro.INSTANCE.sendMessage(ChatFormatting.AQUA.toString() + "[Surround]: " + ChatFormatting.RESET + " you are off ground, toggling!");
            } else {
               if ((Boolean)this.field_608.c() && this.field_617 != Vec3d.ZERO) {
                  double var22 = Math.abs(this.field_617.x - this.c.player.posX);
                  double var4 = Math.abs(this.field_617.z - this.c.player.posZ);
                  if (var22 <= 0.1D && var4 <= 0.1D) {
                     this.field_617 = Vec3d.ZERO;
                  } else {
                     double var6 = this.field_617.x - this.c.player.posX;
                     double var8 = this.field_617.z - this.c.player.posZ;
                     this.c.player.motionX = var6 / (double)2;
                     this.c.player.motionZ = var8 / (double)2;
                  }
               }

               var2 = -1;
               boolean var23 = true;
               Item var31;
               if (!this.c.player.getHeldItemMainhand().isEmpty() && this.c.player.getHeldItemMainhand().getItem() instanceof ItemBlock) {
                  var31 = this.c.player.getHeldItemMainhand().getItem();
                  if (var31 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                  }

                  ItemBlock var24 = (ItemBlock)var31;
                  if (Intrinsics.areEqual((Object)var24.getBlock(), (Object)Blocks.OBSIDIAN)) {
                     var23 = false;
                  }
               }

               int var25;
               if (var23) {
                  var25 = 0;

                  for(byte var5 = 8; var25 <= var5; ++var25) {
                     if (this.c.player.inventory.getStackInSlot(var25).getItem() instanceof ItemBlock) {
                        var31 = this.c.player.inventory.getStackInSlot(var25).getItem();
                        if (var31 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                        }

                        ItemBlock var27 = (ItemBlock)var31;
                        if (Intrinsics.areEqual((Object)var27.getBlock(), (Object)Blocks.OBSIDIAN)) {
                           var2 = var25;
                           break;
                        }
                     }
                  }

                  if (var2 == -1) {
                     return;
                  }
               }

               var25 = this.c.player.inventory.currentItem;
               BlockPos[] var26 = this.method_922((Entity)this.c.player);
               boolean var28 = false;
               BlockPos var7 = (BlockPos)null;
               int var29 = 0;

               label701:
               for(int var9 = var26.length; var29 < var9; ++var29) {
                  BlockPos var10 = var26[var29];
                  if ((!((double)var10.getY() < this.c.player.posY) || feg.method_1790(var10.up())) && (!(Boolean)this.field_615.c() || this.c.world.checkNoEntityCollision(new AxisAlignedBB(var10))) && feg.method_1790(var10)) {
                     if (var23 && !var28) {
                        this.c.player.inventory.currentItem = var2;
                        this.c.playerController.updateController();
                        var28 = true;
                     }

                     if (!(Boolean)this.field_616.c()) {
                        Vec3d var11 = new Vec3d(this.c.player.posX, this.c.player.posY + (double)this.c.player.getEyeHeight(), this.c.player.posZ);
                        EnumFacing[] var14 = EnumFacing.values();
                        int var15 = var14.length;
                        int var13 = 0;

                        while(true) {
                           if (var13 >= var15) {
                              break label701;
                           }

                           EnumFacing var12 = var14[var13];
                           BlockPos var16 = var10.offset(var12);
                           EnumFacing var17 = var12.getOpposite();
                           if (this.c.world.getBlockState(var16).getBlock().canCollideCheck(this.c.world.getBlockState(var16), false)) {
                              Vec3d var18 = (new Vec3d((Vec3i)var16)).addVector(0.5D, 0.5D, 0.5D).add((new Vec3d(var17.getDirectionVec())).scale(0.5D));
                              if (var11.distanceTo(var18) <= (double)8.0F) {
                                 var1.0();
                                 float[] var19 = fed.method_1792(var10.getX(), var10.getY(), var10.getZ(), var12);
                                 var1.method_3139(var19[0]);
                                 var1.method_3140(var19[1]);
                                 var1.method_3133((Consumer)(new f7c(this, var10, var28, var25)));
                                 return;
                              }
                           }

                           ++var13;
                        }
                     }

                     fed.method_1796(var10, 8.0F, true, true);
                  }
               }

               if (var28) {
                  this.c.player.inventory.currentItem = var25;
                  this.c.playerController.updateController();
               }

            }
         }
      }
   }

   // $FF: renamed from: a () boolean
   public boolean method_930() {
      return this.field_618;
   }
}
