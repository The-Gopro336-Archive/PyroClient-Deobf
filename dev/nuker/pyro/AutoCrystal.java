/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketPlayerTryUseItemOnBlockAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AutoCrystal extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_100;
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_101;
   @NotNull
   public IntegerSetting placeDelay;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_102;
   @NotNull
   public DoubleSetting breakRange;
   // $FF: renamed from: 1 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_103;
   // $FF: renamed from: 2 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_104;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_105;
   // $FF: renamed from: 3 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_106;
   @NotNull
   public BooleanSetting ak47;
   // $FF: renamed from: 4 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_107;
   // $FF: renamed from: 5 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_108;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_109;
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_110;
   // $FF: renamed from: 1 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_111;
   // $FF: renamed from: c dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting field_112;
   // $FF: renamed from: 2 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_113;
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_114;
   // $FF: renamed from: 0 dev.nuker.pyro.f0o
   @NotNull
   public f0o field_115;
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_116;
   // $FF: renamed from: 6 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_117;
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_118;
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_119;
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_120;
   // $FF: renamed from: 8 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_121;
   // $FF: renamed from: 9 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_122;
   // $FF: renamed from: a dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_123;
   // $FF: renamed from: b dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_124;
   // $FF: renamed from: d dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_125;
   // $FF: renamed from: e dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_126;
   // $FF: renamed from: 7 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_127;
   // $FF: renamed from: f dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_128;
   // $FF: renamed from: g dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_129;
   // $FF: renamed from: h dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_130;
   // $FF: renamed from: i dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_131;
   // $FF: renamed from: j dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_132;
   // $FF: renamed from: k dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_133;
   // $FF: renamed from: l dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_134;
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_135;
   // $FF: renamed from: m dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_136;
   // $FF: renamed from: n dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_137;
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_138;
   // $FF: renamed from: 1 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_139;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_140;
   // $FF: renamed from: c boolean
   public boolean field_141;
   // $FF: renamed from: c float
   public float field_142;
   // $FF: renamed from: 0 float
   public float field_143;
   // $FF: renamed from: c dev.nuker.pyro.f6n
   @Nullable
   public f6n field_144;
   // $FF: renamed from: c net.minecraft.entity.EntityLivingBase
   @Nullable
   public EntityLivingBase field_145;
   // $FF: renamed from: c java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList field_146;
   // $FF: renamed from: 0 dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_147;
   // $FF: renamed from: 1 int
   public int field_148;
   // $FF: renamed from: 0 boolean
   public boolean field_149;
   // $FF: renamed from: c java.util.concurrent.ConcurrentLinkedQueue
   @NotNull
   public ConcurrentLinkedQueue field_150;
   // $FF: renamed from: 1 dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_151;
   // $FF: renamed from: 2 int
   public int field_152;
   // $FF: renamed from: 3 int
   public int field_153;
   // $FF: renamed from: c double
   public double field_154;
   // $FF: renamed from: 0 double
   public double field_155;

   // $FF: renamed from: o () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_144() {
      return this.field_129;
   }

   // $FF: renamed from: X () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_145() {
      return this.field_114;
   }

   // $FF: renamed from: 6 () int
   public int method_146() {
      return this.field_153;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_147() {
      return this.field_104;
   }

   // $FF: renamed from: s () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_148() {
      return this.field_102;
   }

   // $FF: renamed from: 0c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_149() {
      return this.field_137;
   }

   // $FF: renamed from: I () boolean
   public boolean method_150() {
      return this.field_141;
   }

   // $FF: renamed from: B () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_151() {
      return this.field_134;
   }

   // $FF: renamed from: c (net.minecraft.entity.EntityLivingBase) void
   public void method_152(@Nullable EntityLivingBase var1) {
      this.field_145 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe8) void
   public void method_153(@NotNull fe8 var1) {
      this.field_140 = var1;
   }

   // $FF: renamed from: l () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_154() {
      return this.field_136;
   }

   // $FF: renamed from: A () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_155() {
      return this.field_138;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4J) void
   @f0g
   @LauncherEventHide
   public void method_156(@Nullable f4J var1) {
      this.field_146.clear();
      this.field_145 = (EntityLivingBase)null;
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_157(boolean var1) {
      this.field_149 = var1;
   }

   // $FF: renamed from: v () dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting method_158() {
      return this.field_112;
   }

   // $FF: renamed from: e () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_159() {
      return this.field_119;
   }

   // $FF: renamed from: z () int
   public int method_160() {
      return this.field_148;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_161(@NotNull f4u var1) {
      if ((Boolean)this.c.method_3034() && !var1.c() && var1.c() == f41.field_2120) {
         if ((Boolean)this.field_119.c()) {
            if (this.field_141) {
               var1.0();
               var1.method_3140(this.field_142);
               var1.method_3139(this.field_143);
            }

         }
      }
   }

   // $FF: renamed from: Q () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_162() {
      return this.field_122;
   }

   // $FF: renamed from: R () dev.nuker.pyro.f6n
   @Nullable
   public f6n method_163() {
      return this.field_144;
   }

   // $FF: renamed from: M () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_164() {
      return this.field_135;
   }

   // $FF: renamed from: L () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_165() {
      return this.field_109;
   }

   // $FF: renamed from: 0 (float) void
   public void method_166(float var1) {
      this.field_142 = var1;
   }

   // $FF: renamed from: K () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_167() {
      return this.field_151;
   }

   // $FF: renamed from: U () double
   public double method_168() {
      return this.field_154;
   }

   // $FF: renamed from: y () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_169() {
      return this.field_113;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_170(@NotNull f43 var1) {
      if (this.c.player != null) {
         Ref.LongRef var2 = new Ref.LongRef();
         var2.element = System.currentTimeMillis();
         this.field_150.removeIf((Predicate)(new f6s(var2)));
         this.field_152 += -1;
         int var10000 = this.field_152;
         this.field_153 += -1;
         var10000 = this.field_153;
         if ((Boolean)this.field_131.c() || (Boolean)this.c.method_3034()) {
            if (this.field_151.method_1980(this.field_154)) {
               if ((Boolean)this.c.method_3034() && this.field_140.method_1980(1000.0D) && this.field_141) {
                  this.field_141 = false;
               }

               if (this.field_147.method_1980(500.0D) && !this.field_146.isEmpty()) {
                  this.field_146.clear();
               }

               if ((!(Boolean)this.c.method_3034() || this.method_217() || !this.method_192()) && (Boolean)this.field_128.c()) {
                  this.method_184();
                  if (!this.method_217() && (Boolean)this.c.method_3034() && this.field_144 != null && this.field_153 <= 0) {
                     if (!this.method_204()) {
                        return;
                     }

                     EnumFacing var3 = null;
                     boolean var4 = Intrinsics.areEqual((Object)this.c.player.getHeldItemOffhand().getItem(), (Object)Items.END_CRYSTAL);
                     f6n var14 = this.field_144;
                     if (var14 == null) {
                        Intrinsics.throwNpe();
                     }

                     if (var14.method_2995() != null) {
                        var14 = this.field_144;
                        if (var14 == null) {
                           Intrinsics.throwNpe();
                        }

                        feh var15 = var14.method_2995();
                        if (var15 == null) {
                           Intrinsics.throwNpe();
                        }

                        Rotation var5 = var15.method_2042().method_2076();
                        this.field_143 = var5.meth3();
                        this.field_142 = var5.meth4();
                        this.field_141 = true;
                        var14 = this.field_144;
                        if (var14 == null) {
                           Intrinsics.throwNpe();
                        }

                        var15 = var14.method_2995();
                        if (var15 == null) {
                           Intrinsics.throwNpe();
                        }

                        var3 = var15.method_2039();
                     } else {
                        var3 = few.method_1732((BlockPos)this.field_144, true);
                        float[] var12 = few.method_1716().method_1736((BlockPos)this.field_144, var3);
                        this.field_143 = var12[0];
                        this.field_142 = var12[1];
                        this.field_141 = true;
                     }

                     float var13 = this.c.player.rotationPitch;
                     float var6 = this.c.player.rotationYaw;
                     float var7 = this.c.getRenderPartialTicks();
                     this.c.player.rotationPitch = this.field_142;
                     this.c.player.rotationYaw = this.field_143;
                     RayTraceResult var8 = this.c.player.rayTrace((double)this.c.playerController.getBlockReachDistance(), var7);
                     float var9 = 0.0F;
                     float var10 = 0.0F;
                     float var11 = 0.0F;
                     if (var8 != null) {
                        double var16 = var8.hitVec.x;
                        f6n var10001 = this.field_144;
                        if (var10001 == null) {
                           Intrinsics.throwNpe();
                        }

                        var9 = (float)(var16 - (double)var10001.getX());
                        var16 = var8.hitVec.y;
                        var10001 = this.field_144;
                        if (var10001 == null) {
                           Intrinsics.throwNpe();
                        }

                        var10 = (float)(var16 - (double)var10001.getY());
                        var16 = var8.hitVec.z;
                        var10001 = this.field_144;
                        if (var10001 == null) {
                           Intrinsics.throwNpe();
                        }

                        var11 = (float)(var16 - (double)var10001.getZ());
                     }

                     this.c.player.rotationPitch = var13;
                     this.c.player.rotationYaw = var6;
                     NetHandlerPlayClient var17 = this.c.getConnection();
                     if (var17 == null) {
                        Intrinsics.throwNpe();
                     }

                     var17.sendPacket((Packet)(new CPacketPlayerTryUseItemOnBlock((BlockPos)this.field_144, var3, var4 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, var9, var10, var11)));
                     var17 = this.c.getConnection();
                     if (var17 == null) {
                        Intrinsics.throwNpe();
                     }

                     var17.sendPacket((Packet)(new CPacketAnimation(var4 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND)));
                     this.field_153 = ((Number)this.placeDelay.c()).intValue();
                     this.field_154 = RangesKt.coerceAtMost(((Number)this.field_102.c()).doubleValue() * (double)1000, Math.random() * (double)1000);
                     if (this.field_148 != -1 && (f6p)this.field_115.c() == f6p.field_1782 && this.field_148 != this.c.player.inventory.currentItem) {
                        var17 = this.c.getConnection();
                        if (var17 == null) {
                           Intrinsics.throwNpe();
                        }

                        var17.sendPacket((Packet)(new CPacketHeldItemChange(this.c.player.inventory.currentItem)));
                     }
                  }
               }

            }
         }
      }
   }

   // $FF: renamed from: u () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_171() {
      return this.field_103;
   }

   // $FF: renamed from: a () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_172() {
      return this.field_130;
   }

   // $FF: renamed from: J () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_173() {
      return this.field_111;
   }

   // $FF: renamed from: n () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_174() {
      return this.field_127;
   }

   // $FF: renamed from: 4 (int) void
   public void method_175(int var1) {
      this.field_152 = var1;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      this.field_146.clear();
      this.field_150.clear();
      this.field_152 = 0;
      this.field_153 = 0;
   }

   // $FF: renamed from: c (java.util.concurrent.ConcurrentLinkedQueue) void
   public void method_176(@NotNull ConcurrentLinkedQueue var1) {
      this.field_150 = var1;
   }

   // $FF: renamed from: c (double) void
   public void method_177(double var1) {
      this.field_155 = var1;
   }

   // $FF: renamed from: P () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_178() {
      return this.ak47;
   }

   // $FF: renamed from: E () int
   public int method_179() {
      return this.field_152;
   }

   // $FF: renamed from: f () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_180() {
      return this.field_107;
   }

   // $FF: renamed from: T () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_181() {
      return this.field_140;
   }

   // $FF: renamed from: d () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_182() {
      return this.field_132;
   }

   // $FF: renamed from: O () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_183() {
      return this.field_125;
   }

   // $FF: renamed from: p () void
   public void method_184() {
      f6n var1 = (f6n)null;
      EntityLivingBase var2 = (EntityLivingBase)null;
      float var3 = 0.0F;
      ArrayList var4;
      double var10;
      double var11;
      double var12;
      if ((Boolean)this.field_133.c()) {
         var4 = new ArrayList();
         if (this.c.world.playerEntities.size() == 1) {
            return;
         }

         try {
            Iterator var6 = this.c.world.playerEntities.iterator();

            while(var6.hasNext()) {
               EntityPlayer var5 = (EntityPlayer)var6.next();
               if (var5 != null && this.method_202((Entity)var5) && (double)this.c.player.getDistance((Entity)var5) <= 18.0D) {
                  var4.add(var5);
               }
            }
         } catch (Exception var24) {
         }

         ArrayList var25 = this.method_195();
         boolean var27 = this.field_112.method_3330();
         if ((Boolean)this.field_122.c()) {
            Entity var7 = this.c.getRenderViewEntity() == null ? (Entity)this.c.player : this.c.getRenderViewEntity();
            if (var7 == null) {
               Intrinsics.throwNpe();
            }

            double var8 = var7.lastTickPosX + (var7.posX - var7.lastTickPosX) * (double)this.c.getRenderPartialTicks();
            var10 = var7.lastTickPosY + (var7.posY - var7.lastTickPosY) * (double)this.c.getRenderPartialTicks();
            var12 = var7.lastTickPosZ + (var7.posZ - var7.lastTickPosZ) * (double)this.c.getRenderPartialTicks();
            PyroRenderUtil.field_983.setPosition(var8, var10, var12);
         }

         Iterator var33 = var4.iterator();

         label1052:
         while(true) {
            EntityPlayer var30;
            do {
               do {
                  do {
                     if (!var33.hasNext()) {
                        break label1052;
                     }

                     var30 = (EntityPlayer)var33.next();
                  } while(var30 == null);
               } while(!this.method_202((Entity)var30));
            } while(!(var30 instanceof EntityLivingBase));

            Iterator var37 = var25.iterator();

            while(true) {
               f6n var9;
               double var13;
               double var15;
               do {
                  do {
                     do {
                        if (!var37.hasNext()) {
                           continue label1052;
                        }

                        var9 = (f6n)var37.next();
                     } while((Boolean)this.field_132.c() && var9.method_2995() == null);
                  } while(var30.getDistanceSq((BlockPos)var9) >= 144.0D);

                  var11 = (double)var9.getX() + 0.5D;
                  var13 = (double)var9.getY() + 1.0D;
                  var15 = (double)var9.getZ() + 0.5D;
               } while(((Number)this.field_104.c()).doubleValue() != 0.0D && var30.getDistanceSq(var11, var13, var15) >= ((Number)this.field_104.c()).doubleValue() * ((Number)this.field_104.c()).doubleValue());

               float var17 = fdM.method_1881((BlockPos)var9, (EntityLivingBase)var30);
               double var18 = 1.0D;
               if (!var27) {
                  var18 = var30.getHealth() + var30.getAbsorptionAmount() <= ((Number)this.field_111.c()).floatValue() ? 1.0D : ((Number)this.field_107.c()).doubleValue();
               }

               if (((Number)this.field_113.c()).intValue() > 0 && var18 != 1.0D) {
                  float var20 = var17 * ((Number)this.field_113.c()).floatValue();
                  if (var20 >= var30.getHealth() + var30.getAbsorptionAmount()) {
                     var18 = 1.0D;
                  }
               }

               if ((Boolean)this.field_116.c() && var30 instanceof EntityPlayer) {
                  boolean var40 = false;
                  Iterator var22 = var30.inventory.armorInventory.iterator();

                  while(var22.hasNext()) {
                     ItemStack var21 = (ItemStack)var22.next();
                     if (!var21.isEmpty()) {
                        float var23 = fe9.method_1832(var21);
                        if (var23 <= (float)((Number)this.field_117.c()).doubleValue()) {
                           var40 = true;
                           break;
                        }
                     }
                  }

                  if (var40) {
                     var18 = 1.0D;
                  }
               }

               if ((double)var17 >= var18 && var3 <= var17) {
                  var1 = var9;
                  var3 = var17;
                  var2 = (EntityLivingBase)var30;
               }
            }
         }
      } else {
         var4 = this.method_195();
         boolean var26 = this.field_112.method_3330();
         if ((Boolean)this.field_122.c()) {
            Entity var28 = this.c.getRenderViewEntity() == null ? (Entity)this.c.player : this.c.getRenderViewEntity();
            if (var28 == null) {
               Intrinsics.throwNpe();
            }

            double var31 = var28.lastTickPosX + (var28.posX - var28.lastTickPosX) * (double)this.c.getRenderPartialTicks();
            double var35 = var28.lastTickPosY + (var28.posY - var28.lastTickPosY) * (double)this.c.getRenderPartialTicks();
            var11 = var28.lastTickPosZ + (var28.posZ - var28.lastTickPosZ) * (double)this.c.getRenderPartialTicks();
            PyroRenderUtil.field_983.setPosition(var31, var35, var11);
         }

         Iterator var32 = this.c.world.playerEntities.iterator();

         label993:
         while(true) {
            EntityPlayer var29;
            do {
               do {
                  do {
                     if (!var32.hasNext()) {
                        break label993;
                     }

                     var29 = (EntityPlayer)var32.next();
                  } while(var29 == null);
               } while(!this.method_202((Entity)var29));
            } while(!(var29 instanceof EntityLivingBase));

            Iterator var36 = var4.iterator();

            while(true) {
               double var14;
               f6n var34;
               do {
                  do {
                     do {
                        if (!var36.hasNext()) {
                           continue label993;
                        }

                        var34 = (f6n)var36.next();
                     } while((Boolean)this.field_132.c() && var34.method_2995() == null);
                  } while(var29.getDistanceSq((BlockPos)var34) >= 144.0D);

                  var10 = (double)var34.getX() + 0.5D;
                  var12 = (double)var34.getY() + 1.0D;
                  var14 = (double)var34.getZ() + 0.5D;
               } while(((Number)this.field_104.c()).doubleValue() != 0.0D && var29.getDistanceSq(var10, var12, var14) >= ((Number)this.field_104.c()).doubleValue() * ((Number)this.field_104.c()).doubleValue());

               float var16 = fdM.method_1881((BlockPos)var34, (EntityLivingBase)var29);
               double var38 = 1.0D;
               if (!var26) {
                  var38 = var29.getHealth() + var29.getAbsorptionAmount() <= ((Number)this.field_111.c()).floatValue() ? 1.0D : ((Number)this.field_107.c()).doubleValue();
               }

               if (((Number)this.field_113.c()).intValue() > 0 && var38 != 1.0D) {
                  float var19 = var16 * ((Number)this.field_113.c()).floatValue();
                  if (var19 >= var29.getHealth() + var29.getAbsorptionAmount()) {
                     var38 = 1.0D;
                  }
               }

               if ((Boolean)this.field_116.c() && var29 instanceof EntityPlayer) {
                  boolean var39 = false;
                  Iterator var41 = var29.inventory.armorInventory.iterator();

                  while(var41.hasNext()) {
                     ItemStack var42 = (ItemStack)var41.next();
                     if (!var42.isEmpty()) {
                        float var43 = fe9.method_1832(var42);
                        if (var43 <= (float)((Number)this.field_117.c()).doubleValue()) {
                           var39 = true;
                           break;
                        }
                     }
                  }

                  if (var39) {
                     var38 = 1.0D;
                  }
               }

               if ((double)var16 >= var38 && var3 <= var16) {
                  var1 = var34;
                  var3 = var16;
                  var2 = (EntityLivingBase)var29;
               }
            }
         }
      }

      this.field_144 = var1;
      this.field_145 = var2;
      this.field_149 = var3 != 0.0F && (double)var3 < ((Number)this.field_107.c()).doubleValue();
      this.field_155 = (double)var3;
   }

   // $FF: renamed from: g () java.util.concurrent.ConcurrentLinkedQueue
   @NotNull
   public ConcurrentLinkedQueue method_185() {
      return this.field_150;
   }

   // $FF: renamed from: c (dev.nuker.pyro.AutoCrystal, net.minecraft.entity.item.EntityEnderCrystal, boolean, int, java.lang.Object) boolean
   public static boolean method_186(AutoCrystal var0, EntityEnderCrystal var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      return var0.method_210(var1, var2);
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_187() {
      return this.field_105;
   }

   public AutoCrystal() {
      super("autocrystal", "AutoCrystal", "Places and breaks Ender Crystals");
      this.field_100 = new f0o("breakMode", "BreakModes", (String)null, (Enum)f6o.field_1775);
      this.field_101 = new IntegerSetting("breakTickDelay", "BreakTickDelay", (String)null, 0, 0, 10, 0, 64, (DefaultConstructorMarker)null);
      this.placeDelay = new IntegerSetting("placeTickDelay", "PlaceTickDelay", (String)null, 0, 0, 10, 0, 64, (DefaultConstructorMarker)null);
      this.field_102 = new DoubleSetting("randomDelay", "RandomDelay", "Random delay in seconds", 0.0D, 0.0D, 1.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.breakRange = new DoubleSetting("breakRange", "BreakRange", (String)null, 6.0D, 1.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_103 = new DoubleSetting("placeRange", "PlaceRange", (String)null, 6.0D, 1.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_104 = new DoubleSetting("enemyRange", "EnemyRange", (String)null, 6.0D, 0.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_105 = new BooleanSetting("ncp", "NCP", (String)null, true);
      this.field_106 = new DoubleSetting("wallsRange", "WallsRange", (String)null, 3.0D, 0.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.ak47 = new BooleanSetting("ak47", "AK47", "Crystalaura go brr", true);
      this.field_107 = new DoubleSetting("minDmg", "MinDMG", (String)null, 6.0D, 0.1D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_108 = new DoubleSetting("maxSelfDMG", "MaxSelfDMG", (String)null, 6.0D, 0.1D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_109 = new BooleanSetting("noSuicide", "NoSuicide", (String)null, false);
      this.field_110 = new BooleanSetting("ignoreSelfDamage", "IgnoreSelfDamage", "May boost FPS", false);
      this.field_111 = new IntegerSetting("facePlaceHP", "FacePlace", (String)null, 9, 0, 20, 0, 64, (DefaultConstructorMarker)null);
      this.field_112 = new BindSetting("forceFacePlace", "ForceFacePlace", "Force's you to faceplace when this key is held down", -1);
      this.field_113 = new IntegerSetting("lethalMultiplier", "LethalMultiplier", (String)null, 0, 0, 10, 0, 64, (DefaultConstructorMarker)null);
      this.field_114 = new BooleanSetting("throughWalls", "ThroughWalls", (String)null, true);
      this.field_115 = new f0o("switchMode", "SwitchMode", (String)null, (Enum)f6p.field_1780);
      this.field_116 = new BooleanSetting("armorBreaker", "ArmorBreaker", (String)null, false);
      this.field_117 = new DoubleSetting("armorBreakerPct", "Pct", "Percentage of armor to faceplace at", 20.0D, 0.0D, 100.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_118 = new BooleanSetting("antiweakness", "AntiWeakness", "Uses sword to break weakness crystals", false);
      this.field_119 = new BooleanSetting("rotate", "Rotate", "Uses rotation system of client", true);
      this.field_120 = new BooleanSetting("offhandBreak", "OffhandBreak", "Swings offhand instead of mainhand", false);
      this.field_121 = new BooleanSetting("players", "Players", (String)null, true);
      this.field_122 = new BooleanSetting("onlyInFrustram", "OnlyInFrustram", "Only targets entities in the frustram", false);
      this.field_123 = new BooleanSetting("armorCheck", "ArmorCheck", "Only targets entities with armor", false);
      this.field_124 = new BooleanSetting("pauseWhileEating", "Eating", (String)null, true);
      this.field_125 = new BooleanSetting("pauseWhileXPing", "XPing", (String)null, true);
      this.field_126 = new BooleanSetting("pauseWhileMining", "Mining", (String)null, true);
      this.field_127 = new DoubleSetting("pauseWhenBelow", "BelowHealth", "Pauses AutoCrystal when below a certain HP", 0.0D, 0.0D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_128 = new BooleanSetting("autoPlace", "AutoPlace", (String)null, true);
      this.field_129 = new BooleanSetting("useNewLogic", "1.13 Placements", (String)null, false);
      this.field_130 = new BooleanSetting("placeInLiquid", "PlaceInLiquid", (String)null, false);
      this.field_131 = new BooleanSetting("searchOffline", "SearchOffline", (String)null, false);
      this.field_132 = new BooleanSetting("strict", "Strict", (String)null, false);
      this.field_133 = new BooleanSetting("fpsFix", "FPSFix", "Does optimized calculations", true);
      this.field_134 = new BooleanSetting("chams", "Chams", "Renders chams on the targeted entity", true);
      this.field_135 = new f0l("targetColor", "Target", "Tint to render the targeted entity", new f00(0.85F, 0.85F, 1.0F, 0.166666F));
      this.field_136 = new BooleanSetting("blockOverlay", "BlockOverlay", "Renders an overlay over blocks", true);
      this.field_137 = new BooleanSetting("renderDamage", "RenderDamage", "Renders damage over blocks", false);
      this.field_138 = new f0l("placeOverlayColor", "Overlay Color", "Tint to render underneath the block being placed", new f00(0.0F, 1.0F, 0.5F, 0.3F));
      this.field_139 = new f0l("placeOutlineColor", "Outline", "Tint to render underneath the block being placed", new f00(0.0F, 1.0F, 0.5F, 1.0F));
      this.register((f0w)this.field_100);
      this.register((f0w)(new f0t((f0w)(new f0n("timers", "Timers", "Right click to view or modify the timers")), new f0w[]{(f0w)this.field_101, (f0w)this.placeDelay, (f0w)this.field_102})));
      this.register((f0w)(new f0t((f0w)(new f0n("ranges", "Ranges", "Right click to view or modify the range settings")), new f0w[]{(f0w)this.breakRange, (f0w)this.field_103, (f0w)this.field_104, (f0w)this.field_105, (f0w)this.field_106})));
      this.register((f0w)(new f0t((f0w)(new f0n("general", "General", "Right click to view or modify the general settings")), new f0w[]{(f0w)this.ak47, (f0w)this.field_118, (f0w)this.field_107, (f0w)this.field_108, (f0w)this.field_109, (f0w)this.field_110, (f0w)this.field_111, (f0w)this.field_112, (f0w)this.field_113, (f0w)this.field_114, (f0w)(new f0t((f0w)this.field_116, new f0w[]{(f0w)this.field_117})), (f0w)this.field_115, (f0w)this.field_133, (f0w)this.field_119, (f0w)this.field_120})));
      this.register((f0w)(new f0t((f0w)(new f0n("targets", "Targets", "Right click to view or modify the target settings")), new f0w[]{(f0w)this.field_121, (f0w)this.field_122, (f0w)this.field_123})));
      this.register((f0w)(new f0t((f0w)(new f0n("pauseWhen", "PauseWhen", "Right click to view or modify the pausing settings")), new f0w[]{(f0w)this.field_127, (f0w)this.field_124, (f0w)this.field_126, (f0w)this.field_125})));
      this.register((f0w)(new f0t((f0w)(new f0n("placeOptions", "PlaceOptions", "Right click to view or modify the place settings")), new f0w[]{(f0w)this.field_128, (f0w)this.field_129, (f0w)this.field_130, (f0w)this.field_131, (f0w)this.field_132})));
      this.register((f0w)(new f0t((f0w)(new f0n("render", "Render", "Right click to view or modify the render settings")), new f0w[]{(f0w)(new f0t((f0w)this.field_134, new f0w[]{(f0w)this.field_135})), (f0w)(new f0t((f0w)this.field_136, new f0w[]{(f0w)this.field_137, (f0w)this.field_138, (f0w)this.field_139}))})));
      Pyro.getEventManager().method_31(this);
      this.field_140 = new fe8();
      this.field_142 = -1337.0F;
      this.field_143 = -1337.0F;
      this.field_146 = new CopyOnWriteArrayList();
      this.field_147 = new fe8();
      this.field_148 = -1;
      this.field_150 = new ConcurrentLinkedQueue();
      this.field_151 = new fe8();
   }

   // $FF: renamed from: N () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_188() {
      return this.field_115;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_189() {
      return this.field_100;
   }

   // $FF: renamed from: t () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_190() {
      return this.field_147;
   }

   // $FF: renamed from: m () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_191() {
      return this.field_131;
   }

   // $FF: renamed from: 7 () boolean
   public boolean method_192() {
      if ((f6o)this.field_100.c() == f6o.field_1775 && this.field_145 == null) {
         return false;
      } else {
         Iterator var2 = this.c.world.loadedEntityList.iterator();

         Entity var1;
         do {
            if (!var2.hasNext()) {
               return false;
            }

            var1 = (Entity)var2.next();
         } while(!(var1 instanceof EntityEnderCrystal) || var1.isDead || !method_186(this, (EntityEnderCrystal)var1, false, 2, (Object)null) || !fdN.method_1859(var1));

         boolean var3 = few.method_1716().method_1738(var1, ((Number)this.breakRange.c()).doubleValue());
         fex var4 = (fex)null;
         if (!var3 && !(Boolean)this.field_119.c()) {
            var3 = true;
         }

         if (!var3) {
            var4 = few.method_1716().method_1725(((EntityEnderCrystal)var1).getEntityBoundingBox(), false, false, false, (Boolean)this.field_114.c());
         }

         if (var4 != null || var3) {
            if (!var3) {
               if (var4 != null) {
                  this.field_143 = var4.method_2076().meth3();
                  this.field_142 = var4.method_2076().meth4();
                  this.field_141 = true;
                  this.field_140.method_1979();
               }

               return true;
            }

            boolean var5 = true;
            if ((Boolean)this.field_118.c()) {
               double var6 = this.c.player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
               ItemStack var8 = this.c.player.getHeldItemMainhand();
               if (!(var8.getItem() instanceof ItemSword) && !(var8.getItem() instanceof ItemTool)) {
                  if (this.c.player.isPotionActive(MobEffects.WEAKNESS)) {
                     var6 = 0.0D;
                  }
               } else {
                  var6 = 3.0D;
               }

               PotionEffect var9 = this.c.player.getActivePotionEffect(MobEffects.STRENGTH);
               if (var9 != null && (float)var9.getAmplifier() >= 1.0F) {
                  var6 = 1.0D;
               }

               float var10 = EnchantmentHelper.getModifierForCreature(this.c.player.getHeldItemMainhand(), EnumCreatureAttribute.UNDEFINED);
               float var11 = this.c.player.getCooledAttackStrength(0.5F);
               var6 *= (double)(0.2F + var11 * var11 * 0.8F);
               var10 *= var11;
               var5 = var6 > (double)0.0F || var10 > 0.0F;
               if (!var5 && (this.c.player.getHeldItemMainhand().isEmpty() || !(this.c.player.getHeldItemMainhand().getItem() instanceof ItemSword) && !(this.c.player.getHeldItemMainhand().getItem() instanceof ItemTool))) {
                  int var12 = 0;

                  for(byte var13 = 8; var12 <= var13; ++var12) {
                     ItemStack var14 = this.c.player.inventory.getStackInSlot(var12);
                     if (!var14.isEmpty() && (var14.getItem() instanceof ItemTool || var14.getItem() instanceof ItemSword)) {
                        this.c.player.inventory.currentItem = var12;
                        this.c.playerController.updateController();
                        break;
                     }
                  }
               }
            }

            if (this.field_152 <= 0 && var5) {
               this.field_140.method_1979();
               this.c.playerController.attackEntity((EntityPlayer)this.c.player, var1);
               if ((Boolean)this.field_120.c()) {
                  this.c.player.swingArm(EnumHand.OFF_HAND);
               } else {
                  this.c.player.swingArm(EnumHand.MAIN_HAND);
               }

               if ((Boolean)this.ak47.c()) {
                  this.field_146.add(((EntityEnderCrystal)var1).getEntityId());
               }

               this.field_147.method_1979();
               this.field_152 = ((Number)this.field_101.c()).intValue();
               this.field_154 = RangesKt.coerceAtMost(((Number)this.field_102.c()).doubleValue() * (double)1000, Math.random() * (double)1000);
            }
         }

         return true;
      }
   }

   // $FF: renamed from: c (net.minecraft.entity.item.EntityEnderCrystal) boolean
   public boolean method_193(EntityEnderCrystal var1) {
      Iterator var3 = this.field_150.iterator();

      fe3 var2;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         var2 = (fe3)var3.next();
      } while(!(var1.getDistance((double)((BlockPos)var2.method_1959()).getX() + 0.5D, (double)((BlockPos)var2.method_1959()).getY() + 0.5D, (double)((BlockPos)var2.method_1959()).getZ() + 0.5D) <= (double)3));

      return true;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, boolean) boolean
   public boolean method_194(@NotNull BlockPos var1, @Nullable IBlockState var2, boolean var3) {
      BlockPos var4 = var1.up();
      BlockPos var5 = var4.up();
      boolean var6 = !this.c.world.isAirBlock(var4) && !this.c.world.getBlockState(var1).getBlock().isReplaceable((IBlockAccess)this.c.world, var4);
      if (!(Boolean)this.field_129.c()) {
         var6 |= !this.c.world.isAirBlock(var5) && !this.c.world.getBlockState(var5).getBlock().isReplaceable((IBlockAccess)this.c.world, var5);
      }

      if (!(Boolean)this.field_130.c()) {
         var6 |= feg.method_1779(var4) instanceof BlockLiquid;
      }

      if (var6) {
         return false;
      } else {
         double var7 = (double)var4.getX();
         double var9 = (double)var4.getY();
         double var11 = (double)var4.getZ();

         try {
            List var13 = this.c.world.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(var7, var9, var11, var7 + 1.0D, var9 + 2.0D, var11 + 1.0D));
            Collection var14 = (Collection)var13;
            boolean var15 = false;
            if (!var14.isEmpty()) {
               if (!var3) {
                  return false;
               }

               Iterator var18 = var13.iterator();

               while(var18.hasNext()) {
                  Entity var17 = (Entity)var18.next();
                  if (!(var17 instanceof EntityEnderCrystal)) {
                     return false;
                  }

                  if (!this.method_210((EntityEnderCrystal)var17, true)) {
                     return false;
                  }
               }
            }

            return true;
         } catch (Exception var16) {
            return true;
         }
      }
   }

   // $FF: renamed from: i () java.util.ArrayList
   @NotNull
   public ArrayList method_195() {
      ArrayList var1 = new ArrayList();
      BlockPos var2 = new BlockPos(this.c.player.getPositionVector());
      int var3 = (int)((float)var2.getY() + this.c.player.getEyeHeight() - (float)10);
      int var4 = (int)((float)var2.getY() + this.c.player.getEyeHeight() + (float)10);
      int var5 = var2.getX() - 10;
      int var6 = var2.getX() + 10;
      if (var5 <= var6) {
         while(true) {
            int var7 = var3;
            int var8 = var4;
            if (var3 <= var4) {
               while(true) {
                  int var9 = var2.getZ() - 10;
                  int var10 = var2.getZ() + 10;
                  if (var9 <= var10) {
                     while(true) {
                        BlockPos var11 = new BlockPos(var5, var7, var9);
                        if (this.method_223(var11)) {
                           IBlockState var12 = feg.method_1791(var11);
                           if ((var12.getBlock() == Blocks.OBSIDIAN || var12.getBlock() == Blocks.BEDROCK) && this.method_194(var11, var12, true)) {
                              float var13 = (Boolean)this.field_110.c() ? 0.0F : fdM.method_1881(var11, (EntityLivingBase)this.c.player);
                              if (!((double)var13 > ((Number)this.field_108.c()).doubleValue()) && (!(Boolean)this.field_109.c() || !(var13 + 1.0F >= this.c.player.getHealth() + this.c.player.getAbsorptionAmount()))) {
                                 if (!(Boolean)this.field_132.c()) {
                                    var1.add(new f6n(var11, (feh)null, false));
                                 } else {
                                    boolean var14 = false;
                                    feh var15 = (feh)null;
                                    Vec3d var16 = new Vec3d(this.c.player.posX, this.c.player.getEntityBoundingBox().minY + (double)this.c.player.getEyeHeight(), this.c.player.posZ);
                                    double[] var17 = new double[]{0.05D, 0.95D};
                                    double[] var18 = new double[]{0.05D, 0.95D};
                                    double[] var19 = new double[]{0.05D, 0.95D};
                                    double[] var23 = var17;
                                    int var24 = var17.length;
                                    int var22 = 0;

                                    while(true) {
                                       if (var22 >= var24) {
                                          float var49 = 36.0F;
                                          boolean var21 = false;
                                          if (!var14) {
                                             var49 = (float)(((Number)this.field_106.c()).doubleValue() * ((Number)this.field_106.c()).doubleValue());
                                             if (!(Boolean)this.field_114.c()) {
                                                break;
                                             }

                                             var21 = true;
                                          }

                                          if (!(this.c.player.getDistanceSq(var11) > (double)var49)) {
                                             var1.add(new f6n(var11, var15, var21));
                                          }
                                          break;
                                       }

                                       double var20 = var23[var22];
                                       double[] var28 = var18;
                                       int var29 = var18.length;

                                       for(int var27 = 0; var27 < var29; ++var27) {
                                          double var25 = var28[var27];
                                          double[] var33 = var19;
                                          int var34 = var19.length;

                                          for(int var32 = 0; var32 < var34; ++var32) {
                                             double var30 = var33[var32];
                                             Vec3d var35 = (new Vec3d((Vec3i)var11)).addVector(var20, var25, var30);
                                             double var36 = var16.distanceTo(var35);
                                             double var38 = var35.x - var16.x;
                                             double var40 = var35.y - var16.y;
                                             double var42 = var35.z - var16.z;
                                             float var44 = MathHelper.sqrt(var38 * var38 + var42 * var42);
                                             Rotation var45 = new Rotation(MathHelper.wrapDegrees((float)Math.toDegrees(MathHelper.atan2(var42, var38)) - 90.0F), MathHelper.wrapDegrees((float)(-Math.toDegrees(MathHelper.atan2(var40, (double)var44)))));
                                             Vec3d var46 = few.method_1716().method_1714(var45);
                                             Vec3d var47 = var16.addVector(var46.x * var36, var46.y * var36, var46.z * var36);
                                             RayTraceResult var48 = this.c.world.rayTraceBlocks(var16, var47, false, false, true);
                                             if (var48 != null && var48.typeOfHit == Type.BLOCK && var48.getBlockPos().equals(var11)) {
                                                var14 = true;
                                                var15 = new feh(var11, var48.sideHit, var48.hitVec.subtract((double)var11.getX(), (double)var11.getY(), (double)var11.getZ()), new fex(var35, var45, var48.sideHit));
                                                break;
                                             }
                                          }
                                       }

                                       ++var22;
                                    }
                                 }
                              }
                           }
                        }

                        if (var9 == var10) {
                           break;
                        }

                        ++var9;
                     }
                  }

                  if (var7 == var8) {
                     break;
                  }

                  ++var7;
               }
            }

            if (var5 == var6) {
               break;
            }

            ++var5;
         }
      }

      return var1;
   }

   // $FF: renamed from: 3 (int) void
   public void method_196(int var1) {
      this.field_148 = var1;
   }

   // $FF: renamed from: Z () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_197() {
      return this.field_133;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_198() {
      return this.field_139;
   }

   // $FF: renamed from: w () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_199() {
      return this.field_126;
   }

   // $FF: renamed from: V () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_200() {
      return this.field_117;
   }

   // $FF: renamed from: 5 () java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList method_201() {
      return this.field_146;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) boolean
   public boolean method_202(Entity var1) {
      if (!(var1 instanceof EntityLivingBase)) {
         return false;
      } else if (!((EntityLivingBase)var1).isEntityAlive()) {
         return false;
      } else if ((Boolean)this.field_122.c() && !PyroRenderUtil.field_983.isBoundingBoxInFrustum(((EntityLivingBase)var1).getEntityBoundingBox())) {
         return false;
      } else if (!(var1 instanceof EntityPlayer)) {
         return this.c.player.getDistanceSq(var1) <= 300.0D;
      } else {
         if ((Boolean)this.field_123.c()) {
            boolean var2 = false;
            Iterator var4 = ((EntityPlayer)var1).inventory.armorInventory.iterator();

            while(var4.hasNext()) {
               ItemStack var3 = (ItemStack)var4.next();
               if (!var3.isEmpty()) {
                  var2 = true;
                  break;
               }
            }

            if (!var2) {
               return false;
            }
         }

         return (Boolean)this.field_121.c() && fe4.field_1243.method_1894((EntityPlayer)var1);
      }
   }

   // $FF: renamed from: W () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_203() {
      return this.field_110;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      if (this.c.player != null && this.field_144 != null && (Boolean)this.field_136.c()) {
         fe5.field_1245.method_1915(7);
         fe5 var10000 = fe5.field_1245;
         f6n var10001 = this.field_144;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1917((BlockPos)var10001, ((f00)this.field_138.c()).meth1(), 63);
         fe5.field_1245.method_1912();
         PyroRenderUtil.method_1433((BlockPos)this.field_144, ((f00)this.field_139.c()).meth1(), 1.5F, false);
         if (this.field_145 != null && (Boolean)this.field_137.c()) {
            GlStateManager.pushMatrix();
            EntityPlayer var3 = this.c.getRenderViewEntity() instanceof EntityPlayer ? (EntityPlayer)this.c.getRenderViewEntity() : (EntityPlayer)this.c.player;
            f6n var9 = this.field_144;
            if (var9 == null) {
               Intrinsics.throwNpe();
            }

            float var10 = (float)var9.getX() + 0.5F;
            var10001 = this.field_144;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            float var11 = (float)var10001.getY() + 0.5F;
            f6n var10002 = this.field_144;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            PyroRenderUtil.method_1440(var10, var11, (float)var10002.getZ() + 0.5F, (Entity)var3, 1.0F);
            StringCompanionObject var5 = StringCompanionObject.INSTANCE;
            String var6 = "%.1f";
            Object[] var7 = new Object[]{this.field_155};
            boolean var8 = false;
            String var4 = String.format(var6, Arrays.copyOf(var7, var7.length));
            GlStateManager.disableDepth();
            GlStateManager.translate(-((double)PyroRenderUtil.method_1439(var4) / 2.0D), 0.0D, 0.0D);
            PyroRenderUtil.meth1(var4, 0.0F, 0.0F, -1);
            GlStateManager.popMatrix();
         }
      }

   }

   // $FF: renamed from: C () boolean
   public boolean method_204() {
      if (Intrinsics.areEqual((Object)this.c.player.getHeldItemMainhand().getItem(), (Object)Items.END_CRYSTAL) ^ true && Intrinsics.areEqual((Object)this.c.player.getHeldItemOffhand().getItem(), (Object)Items.END_CRYSTAL) ^ true) {
         if ((f6p)this.field_115.c() != f6p.field_1781) {
            int var1 = fdX.field_1227.method_1839(Items.END_CRYSTAL);
            this.field_148 = var1;
            if (var1 != -1) {
               if ((f6p)this.field_115.c() == f6p.field_1780) {
                  this.c.player.inventory.currentItem = var1;
                  this.c.playerController.updateController();
               } else if ((f6p)this.field_115.c() == f6p.field_1782) {
                  NetHandlerPlayClient var10000 = this.c.getConnection();
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var10000.sendPacket((Packet)(new CPacketHeldItemChange(var1)));
               }

               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   // $FF: renamed from: c (float) void
   public void method_205(float var1) {
      this.field_143 = var1;
   }

   // $FF: renamed from: c (boolean) void
   public void method_206(boolean var1) {
      this.field_141 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState) boolean
   public boolean method_207(@NotNull BlockPos var1, @Nullable IBlockState var2) {
      return this.method_194(var1, var2, false);
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_208() {
      return this.placeDelay;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f6n) void
   public void method_209(@Nullable f6n var1) {
      this.field_144 = var1;
   }

   // $FF: renamed from: c (net.minecraft.entity.item.EntityEnderCrystal, boolean) boolean
   public boolean method_210(EntityEnderCrystal var1, boolean var2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: H () float
   public float method_211() {
      return this.field_143;
   }

   // $FF: renamed from: D () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_212() {
      return this.field_116;
   }

   // $FF: renamed from: S () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_213() {
      return this.field_121;
   }

   // $FF: renamed from: F () double
   public double method_214() {
      return this.field_155;
   }

   // $FF: renamed from: Y () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_215() {
      return this.field_118;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fe8) void
   public void method_216(@NotNull fe8 var1) {
      this.field_151 = var1;
   }

   // $FF: renamed from: c () boolean
   public boolean method_217() {
      if ((Boolean)this.field_124.c() && this.c.player.isHandActive() && this.c.player.getHeldItemMainhand().getItem() instanceof ItemFood) {
         return true;
      } else if ((Boolean)this.field_126.c() && this.c.playerController.getIsHittingBlock() && this.c.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe) {
         return true;
      } else if ((Boolean)this.field_125.c() && this.c.gameSettings.keyBindRight.isKeyDown() && Intrinsics.areEqual((Object)this.c.player.getHeldItemMainhand().getItem(), (Object)Items.EXPERIENCE_BOTTLE)) {
         return true;
      } else if ((Boolean)PyroStatic.field_2472.c.method_3034() && !PyroStatic.field_2472.method_916((Entity)this.c.player)) {
         return true;
      } else if ((Boolean)PyroStatic.field_2508.c.method_3034() && PyroStatic.field_2508.field_451) {
         return true;
      } else {
         if ((Boolean)PyroStatic.field_2570.c.method_3034()) {
            if ((Boolean)PyroStatic.field_2570.field_572.c() && PyroStatic.field_2472.method_904((Entity)this.c.player) && !PyroStatic.field_2570.method_862((Entity)this.c.player)) {
               return true;
            }

            if (!(Boolean)PyroStatic.field_2570.field_572.c()) {
               return true;
            }
         }

         return ((Number)this.field_127.c()).doubleValue() > 0.0D && (double)(this.c.player.getHealth() + this.c.player.getAbsorptionAmount()) < ((Number)this.field_127.c()).doubleValue();
      }
   }

   // $FF: renamed from: b () boolean
   public boolean method_218() {
      return this.field_149;
   }

   // $FF: renamed from: 00 () float
   public float method_219() {
      return this.field_142;
   }

   // $FF: renamed from: j () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_220() {
      return this.field_101;
   }

   // $FF: renamed from: r () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_221() {
      return this.field_123;
   }

   // $FF: renamed from: c (java.util.concurrent.CopyOnWriteArrayList) void
   public void method_222(@NotNull CopyOnWriteArrayList var1) {
      this.field_146 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) boolean
   public boolean method_223(BlockPos var1) {
      double var2 = this.c.player.posX - ((double)var1.getX() + 0.5D);
      double var4 = this.c.player.posY - ((double)var1.getY() + 0.5D) + 1.5D;
      double var6 = this.c.player.posZ - ((double)var1.getZ() + 0.5D);
      double var8 = var2 * var2 + var4 * var4 + var6 * var6;
      if (var8 > 36.0D) {
         return false;
      } else if (var8 > ((Number)this.field_103.c()).doubleValue() * ((Number)this.field_103.c()).doubleValue()) {
         return false;
      } else {
         if ((Boolean)this.field_105.c()) {
            boolean var10 = this.c.playerController.gameIsSurvivalOrAdventure();
            if (var8 >= (var10 ? 27.0D : 31.0D)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: renamed from: q () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_224() {
      return this.field_106;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_225() {
      return this.field_128;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_226() {
      return this.breakRange;
   }

   // $FF: renamed from: G () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_227() {
      return this.field_108;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4I) void
   @f0g
   @LauncherEventHide
   public void method_228(@NotNull f4I var1) {
      if (var1.method_3243() instanceof EntityEnderCrystal && this.field_146.contains(var1.method_3243().getEntityId())) {
         this.field_146.remove(var1.method_3243().getEntityId());
      }

   }

   // $FF: renamed from: k () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_229() {
      return this.field_120;
   }

   // $FF: renamed from: x () net.minecraft.entity.EntityLivingBase
   @Nullable
   public EntityLivingBase method_230() {
      return this.field_145;
   }

   // $FF: renamed from: 0 (double) void
   public void method_231(double var1) {
      this.field_154 = var1;
   }

   // $FF: renamed from: h () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_232() {
      return this.field_124;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_233(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof CPacketPlayerTryUseItemOnBlock) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock");
         }

         CPacketPlayerTryUseItemOnBlock var2 = (CPacketPlayerTryUseItemOnBlock)var10000;
         ItemStack var3 = this.c.player.getHeldItem(var2.getHand());
         if (Intrinsics.areEqual((Object)var3.getItem(), (Object)Items.END_CRYSTAL)) {
            this.field_150.removeIf((Predicate)(new f6r(var2)));
            this.field_150.add(new fe3(System.currentTimeMillis() + (long)500, var2.getPos()));
            if (var2.getPos().getY() >= this.c.world.getHeight() - 1 && var2.getDirection() == EnumFacing.UP) {
               if (var2 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.CPacketPlayerTryUseItemOnBlockAccessor");
               }

               ((CPacketPlayerTryUseItemOnBlockAccessor)var2).setPlacedBlockDirection(EnumFacing.DOWN);
            }
         }
      }

   }

   // $FF: renamed from: 5 (int) void
   public void method_234(int var1) {
      this.field_153 = var1;
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.fe8) void
   public void method_235(@NotNull fe8 var1) {
      this.field_147 = var1;
   }
}
