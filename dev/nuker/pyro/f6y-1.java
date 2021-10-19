/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f6y extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_443 = (DoubleSetting)this.register((f0w)(new DoubleSetting("range", "Range", (String)null, 6.0D, 0.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_444 = (IntegerSetting)this.register((f0w)(new IntegerSetting("toggleTicks", "ToggleTicks", (String)null, 0, 0, 10, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_445 = (BooleanSetting)this.register((f0w)(new BooleanSetting("toggleOnTrap", "ToggleOnTrap", (String)null, false)));
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_446 = (f0l)this.register((f0w)(new f0l("blockColor", "Block Color", (String)null, new f00(0.0F, 1.0F, 0.5F, 0.33F))));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_447 = (BooleanSetting)this.register((f0w)(new BooleanSetting("instant", "Instant", (String)null, false)));
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_448;
   // $FF: renamed from: 1 int
   public int field_449;
   // $FF: renamed from: c net.minecraft.entity.player.EntityPlayer
   @Nullable
   public EntityPlayer field_450;
   // $FF: renamed from: c boolean
   @JvmField
   public boolean field_451;

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(1)
   @LauncherEventHide
   public void method_655(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120 && !var1.c()) {
         if (this.field_448 != null && !feg.method_1790(this.field_448)) {
            this.field_448 = (BlockPos)null;
         }

         if (this.field_450 != null && (Boolean)this.field_445.c()) {
            EntityPlayer var10001 = this.field_450;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            if (this.method_666((Entity)var10001)) {
               Pyro.INSTANCE.sendMessage("Target is trapped, disabling!");
               this.c.method_3033(false);
               return;
            }
         }

         EntityPlayer var2 = (EntityPlayer)null;
         float var3 = 1337.0F;
         Iterator var5 = this.c.world.playerEntities.iterator();

         while(var5.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var5.next();
            if (!(var4 instanceof EntityPlayerSP) && fe4.field_1243.method_1894(var4) && !this.method_666((Entity)var4)) {
               float var6 = this.c.player.getDistance((Entity)var4);
               if ((double)var6 <= ((Number)this.field_443.c()).doubleValue() && var6 < var3) {
                  var3 = var6;
                  var2 = var4;
               }
            }
         }

         ++this.field_449;
         int var10000 = this.field_449;
         if (((Number)this.field_444.c()).intValue() > 0 && this.field_449 >= ((Number)this.field_444.c()).intValue()) {
            Pyro.INSTANCE.sendMessage("Reached ToggleTicks threshold, disabling AutoTrap!");
            this.c.method_3033(false);
         } else {
            if (var2 != null) {
               this.field_450 = var2;
               int var27 = -1;
               boolean var28 = true;
               Item var33;
               if (!this.c.player.getHeldItemMainhand().isEmpty() && this.c.player.getHeldItemMainhand().getItem() instanceof ItemBlock) {
                  var33 = this.c.player.getHeldItemMainhand().getItem();
                  if (var33 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                  }

                  ItemBlock var29 = (ItemBlock)var33;
                  if (Intrinsics.areEqual((Object)var29.getBlock(), (Object)Blocks.OBSIDIAN)) {
                     var27 = this.c.player.inventory.currentItem;
                     var28 = false;
                  }
               }

               int var30;
               if (var27 == -1) {
                  var30 = 0;

                  for(byte var7 = 8; var30 <= var7; ++var30) {
                     if (this.c.player.inventory.getStackInSlot(var30).getItem() instanceof ItemBlock) {
                        var33 = this.c.player.inventory.getStackInSlot(var30).getItem();
                        if (var33 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                        }

                        ItemBlock var8 = (ItemBlock)var33;
                        if (Intrinsics.areEqual((Object)var8.getBlock(), (Object)Blocks.OBSIDIAN)) {
                           var27 = var30;
                           break;
                        }
                     }
                  }
               }

               if (var27 == -1) {
                  return;
               }

               var30 = this.c.player.inventory.currentItem;
               Ref.BooleanRef var31 = new Ref.BooleanRef();
               var31.element = false;
               this.5("Trapping");
               this.field_451 = true;
               BlockPos[] var32 = this.method_665((Entity)var2);
               boolean var9 = false;
               Vec3d var10 = new Vec3d(this.c.player.posX, this.c.player.posY + (double)this.c.player.getEyeHeight(), this.c.player.posZ);
               BlockPos[] var13 = var32;
               int var14 = var32.length;

               for(int var12 = 0; var12 < var14; ++var12) {
                  BlockPos var11 = var13[var12];
                  if (feg.method_1790(var11) && this.c.world.checkNoEntityCollision(new AxisAlignedBB(var11))) {
                     this.field_448 = var11;
                     EnumFacing[] var17 = EnumFacing.values();
                     int var18 = var17.length;

                     for(int var16 = 0; var16 < var18; ++var16) {
                        EnumFacing var15 = var17[var16];
                        BlockPos var19 = var11.offset(var15);
                        EnumFacing var20 = var15.getOpposite();
                        if (this.c.world.getBlockState(var19).getBlock().canCollideCheck(this.c.world.getBlockState(var19), false)) {
                           Vec3d var21 = (new Vec3d((Vec3i)var19)).addVector(0.5D, 0.5D, 0.5D).add((new Vec3d(var20.getDirectionVec())).scale(0.5D));
                           if (var10.distanceTo(var21) <= 6.0D) {
                              Block var22 = this.c.world.getBlockState(var19).getBlock();
                              boolean var23 = var22.onBlockActivated((World)this.c.world, var11, this.c.world.getBlockState(var11), (EntityPlayer)this.c.player, EnumHand.MAIN_HAND, var15, 0.0F, 0.0F, 0.0F);
                              float[] var24 = few.method_1716().method_1736(var19, var15.getOpposite());
                              if ((Boolean)this.field_447.c()) {
                                 NetHandlerPlayClient var34 = this.c.getConnection();
                                 if (var34 == null) {
                                    Intrinsics.throwNpe();
                                 }

                                 var34.sendPacket((Packet)(new net.minecraft.network.play.client.CPacketPlayer.Rotation(var24[0], var24[1], this.c.player.onGround)));
                                 var31.element = false;
                                 if (fed.field_1217.contains(var22) || fed.field_1218.contains(var22) || var23) {
                                    this.c.player.connection.sendPacket((Packet)(new CPacketEntityAction((Entity)this.c.player, Action.START_SNEAKING)));
                                    var31.element = true;
                                 }

                                 if (var28 && !var9) {
                                    var9 = true;
                                    this.c.player.inventory.currentItem = var27;
                                    this.c.player.connection.sendPacket((Packet)(new CPacketHeldItemChange(var27)));
                                 }

                                 this.c.playerController.processRightClickBlock(this.c.player, this.c.world, var19, var20, var21, EnumHand.MAIN_HAND);
                                 this.c.player.connection.sendPacket((Packet)(new CPacketAnimation(EnumHand.MAIN_HAND)));
                              } else {
                                 var1.0();
                                 var1.method_3139(var24[0]);
                                 var1.method_3140(var24[1]);
                                 var1.method_3133((Consumer)(new f6x(this, var31, var23, var22, var28, var27, var19, var20, var21, var30)));
                              }
                              break;
                           }
                        }
                     }

                     if (!(Boolean)this.field_447.c() && var1.c()) {
                        return;
                     }
                  }
               }

               if ((Boolean)this.field_447.c()) {
                  if (var28 && var9) {
                     this.c.player.inventory.currentItem = var30;
                     this.c.player.connection.sendPacket((Packet)(new CPacketHeldItemChange(var30)));
                  }

                  if (var31.element) {
                     this.c.player.connection.sendPacket((Packet)(new CPacketEntityAction((Entity)this.c.player, Action.STOP_SNEAKING)));
                  }
               }
            } else {
               this.5("Looking");
               this.field_451 = false;
            }

         }
      }
   }

   // $FF: renamed from: 3 (int) void
   public void method_656(int var1) {
      this.field_449 = var1;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_449 = 0;
      this.field_450 = (EntityPlayer)null;
      this.field_451 = false;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_657() {
      return this.field_447;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f6y) net.minecraft.client.Minecraft
   public static Minecraft method_658(f6y var0) {
      return var0.c;
   }

   // $FF: renamed from: 0 () int
   public int method_659() {
      return this.field_449;
   }

   // $FF: renamed from: 3 () net.minecraft.entity.player.EntityPlayer
   @Nullable
   public EntityPlayer method_660() {
      return this.field_450;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_661() {
      return this.field_443;
   }

   // $FF: renamed from: 4 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_662() {
      return this.field_448;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_663(@Nullable BlockPos var1) {
      this.field_448 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      if (this.c.player != null && this.field_448 != null) {
         fe5.field_1245.method_1915(7);
         fe5 var10000 = fe5.field_1245;
         BlockPos var10001 = this.field_448;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1917(var10001, ((f00)this.field_446.c()).meth1(), 63);
         fe5.field_1245.method_1912();
      }

   }

   // $FF: renamed from: 1 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_664() {
      return this.field_446;
   }

   // $FF: renamed from: 0 (net.minecraft.entity.Entity) net.minecraft.util.math.BlockPos[]
   @NotNull
   public BlockPos[] method_665(@NotNull Entity var1) {
      BlockPos var2 = new BlockPos(MathHelper.floor(var1.posX), MathHelper.floor(var1.posY), MathHelper.floor(var1.posZ));
      return new BlockPos[]{var2.north(), var2.south(), var2.west(), var2.east(), var2.north().up(), var2.south().up(), var2.west().up(), var2.east().up(), var2.up().up().east(), var2.up().up()};
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) boolean
   public boolean method_666(@NotNull Entity var1) {
      BlockPos[] var4 = this.method_665(var1);
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

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_667() {
      return this.field_445;
   }

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer) void
   public void method_668(@Nullable EntityPlayer var1) {
      this.field_450 = var1;
   }

   public f6y() {
      super("autoTrap", "AutoTrap", "Automatically traps a player near you in obsidian");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f6y, net.minecraft.client.Minecraft) void
   public static void method_669(f6y var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_670() {
      return this.field_444;
   }
}
