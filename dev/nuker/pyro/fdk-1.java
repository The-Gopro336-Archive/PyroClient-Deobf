/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.BlockAccessor;
import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdk extends Module {
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_845 = new fe8();
   // $FF: renamed from: 0 dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_846 = new fe8();
   // $FF: renamed from: c dev.nuker.pyro.fee
   @Nullable
   public fee field_847;
   // $FF: renamed from: c float
   public float field_848;
   // $FF: renamed from: 0 float
   public float field_849;
   // $FF: renamed from: 1 int
   public int field_850;
   // $FF: renamed from: 2 int
   public int field_851;
   // $FF: renamed from: c boolean
   public boolean field_852 = true;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_853 = (BooleanSetting)this.register((f0w)(new BooleanSetting("tower", "Tower", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_854 = (BooleanSetting)this.register((f0w)(new BooleanSetting("stopMotion", "StopMotion", (String)null, false)));
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_855;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_856;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_857;
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_858;
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_859;

   // $FF: renamed from: 8 () float
   public float method_1251() {
      return this.field_849;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fdk) net.minecraft.client.Minecraft
   public static Minecraft method_1252(fdk var0) {
      return var0.c;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1253() {
      return this.field_857;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.fee
   @Nullable
   public fee method_1254() {
      return this.field_847;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_1255(@NotNull f4u var1) {
      if (!var1.c() && var1.c() == f41.field_2120) {
         this.5(((fdi)this.field_855.c()).toString());
         if ((Boolean)this.field_854.c() && this.field_845.method_1980(150.0D) && this.c.player.onGround) {
            this.c.player.motionX = 0.0D;
            this.c.player.motionZ = 0.0D;
            this.field_845.method_1979();
         }

         int var2 = this.method_1256();
         this.field_847 = (fee)null;
         this.field_850 = -1;
         if (!this.c.player.isSneaking() && var2 != -1) {
            boolean var3 = (fdi)this.field_855.c() == fdi.field_1317;
            double var6 = Math.toRadians((double)(this.c.player.rotationYaw + 90.0F));
            boolean var8 = false;
            double var4 = Math.cos(var6);
            double var18 = Math.toRadians((double)(this.c.player.rotationYaw + 90.0F));
            boolean var10 = false;
            var6 = Math.sin(var18);
            var18 = (double)this.c.player.movementInput.moveForward * 0.4D * var4 + (double)this.c.player.movementInput.moveStrafe * 0.4D * var6;
            double var19 = (double)this.c.player.movementInput.moveForward * 0.4D * var6 - (double)this.c.player.movementInput.moveStrafe * 0.4D * var4;
            var18 = this.c.player.posX + (!var3 ? var18 : 0.0D);
            var19 = this.c.player.posZ + (!var3 ? var19 : 0.0D);
            ItemStack var12 = var2 > -1 ? this.c.player.inventory.getStackInSlot(var2) : this.c.player.getHeldItemOffhand();
            boolean var13 = var12.getItem() instanceof ItemSlab;
            double var14 = this.c.player.posY - (var13 ? 0.5D : 1.0D);
            BlockPos var16 = new BlockPos(var18, var14, var19);
            if (feg.method_1790(var16)) {
               this.field_847 = feg.field_1216.method_1787(var16);
               this.field_850 = var2;
               if (this.field_847 != null) {
                  few var10000 = few.method_1716();
                  fee var10001 = this.field_847;
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  BlockPos var21 = var10001.method_2010();
                  fee var10002 = this.field_847;
                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  float[] var17 = var10000.method_1736(var21, var10002.method_2009());
                  var1.method_3139(var17[0]);
                  var1.method_3140(var17[1]);
                  var1.0();
                  this.field_849 = var17[0];
                  this.field_848 = var17[1];
                  var1.method_3133((Consumer)(new fdj(this, var13)));
               }
            } else if (!this.field_846.method_1980(((Number)this.field_856.c()).doubleValue() * 5.0D)) {
               var1.method_3139(this.field_849);
               var1.method_3140(this.field_848);
               var1.0();
            }

            if ((fdi)this.field_855.c() == fdi.field_1316 && (Boolean)this.field_853.c()) {
               this.field_852 = false;
               if (this.c.player.movementInput.jump && !fec.method_1758()) {
                  ++this.field_851;
                  int var20 = this.field_851;
                  if (this.field_847 != null) {
                     if (this.field_851 > 11) {
                        if (this.field_851 > 20) {
                           this.field_851 = 0;
                        }

                        this.c.player.motionY = -this.method_1276(var13);
                        return;
                     }

                     this.c.player.motionY = this.method_1276(var13);
                  } else if (this.c.player.onGround && !this.c.player.isElytraFlying()) {
                     ++this.field_851;
                     var20 = this.field_851;
                     if (this.field_851 > 11) {
                        this.c.player.motionY = -this.method_1276(var13);
                        if (this.field_851 > 20) {
                           this.field_851 = 0;
                        }
                     } else {
                        this.c.player.motionY = this.method_1276(var13);
                     }
                  }
               }
            } else {
               this.field_852 = true;
            }
         }

      }
   }

   // $FF: renamed from: g () int
   public int method_1256() {
      ItemStack var1;
      if ((Boolean)this.field_857.c()) {
         var1 = this.c.player.getHeldItemOffhand();
         if (this.method_1274(var1)) {
            return -420;
         }
      }

      var1 = this.c.player.getHeldItemMainhand();
      if (this.method_1274(var1)) {
         return this.c.player.inventory.currentItem;
      } else {
         int var2 = 0;

         for(byte var3 = 9; var2 <= var3; ++var2) {
            ItemStack var4 = this.c.player.inventory.getStackInSlot(var2);
            if (this.method_1274(var4)) {
               return var2;
            }
         }

         return -1;
      }
   }

   // $FF: renamed from: a () int
   public int method_1257() {
      return this.field_850;
   }

   // $FF: renamed from: 0 (float) void
   public void method_1258(float var1) {
      this.field_848 = var1;
   }

   // $FF: renamed from: 3 (int) void
   public void method_1259(int var1) {
      this.field_850 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      if (this.field_847 != null) {
         fe5.field_1245.method_1915(7);
         fe5 var10000 = fe5.field_1245;
         fee var10001 = this.field_847;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         BlockPos var5 = var10001.method_2010();
         if (var5 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1917(var5, ((f00)this.field_858.c()).meth1(), 63);
         fe5.field_1245.method_1912();
         fee var3 = this.field_847;
         if (var3 == null) {
            Intrinsics.throwNpe();
         }

         BlockPos var4 = var3.method_2010();
         if (var4 == null) {
            Intrinsics.throwNpe();
         }

         PyroRenderUtil.method_1433(var4, ((f00)this.field_859.c()).meth1(), 1.5F, false);
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.fdk, net.minecraft.client.Minecraft) void
   public static void method_1260(fdk var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: b () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1261() {
      return this.field_855;
   }

   // $FF: renamed from: c (float) void
   public void method_1262(float var1) {
      this.field_849 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4o) void
   @f0g
   public void method_1263(@NotNull f4o var1) {
      if ((fdi)this.field_855.c() == fdi.field_1318 && this.field_847 != null) {
         var1.0();
      }

   }

   // $FF: renamed from: 2 () float
   public float method_1264() {
      return this.field_848;
   }

   // $FF: renamed from: 0 () int
   public int method_1265() {
      return this.field_851;
   }

   // $FF: renamed from: d () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1266() {
      return this.field_858;
   }

   // $FF: renamed from: f () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_1267() {
      return this.field_845;
   }

   public fdk() {
      super("scaffold", "Scaffold", (String)null);
      this.field_855 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)fdi.field_1316)));
      this.field_856 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delay", "Delay", (String)null, 75.0D, 1.0D, 600.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_857 = new BooleanSetting("useOffhand", "UseOffhand", (String)null, false);
      this.field_858 = (f0l)this.register((f0w)(new f0l("renderColor", "RenderColor", (String)null, new f00(1.0F, 1.0F, 0.5F, 0.3F))));
      this.field_859 = (f0l)this.register((f0w)(new f0l("renderOutline", "RenderOutline", (String)null, new f00(1.0F, 1.0F, 0.5F, 1.0F))));
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_1268() {
      return this.field_846;
   }

   // $FF: renamed from: 4 (int) void
   public void method_1269(int var1) {
      this.field_851 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f4p) void
   @f0g
   public void method_1270(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120 && (fdi)this.field_855.c() == fdi.field_1318 && (Boolean)this.field_853.c() && this.field_852 && this.field_847 != null) {
         Minecraft var10000 = this.c;
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.MinecraftAccessor");
         }

         MinecraftAccessor var2 = (MinecraftAccessor)var10000;
         var2.setRightClickDelayTimer(3);
         if (this.c.player.movementInput.jump && !fec.method_1758()) {
            var2.setRightClickDelayTimer(0);
            var1.method_3120(1.0D);
            var1.0();
         }
      }

   }

   // $FF: renamed from: 6 () boolean
   public boolean method_1271() {
      return this.field_852;
   }

   // $FF: renamed from: e () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1272() {
      return this.field_853;
   }

   // $FF: renamed from: h () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1273() {
      return this.field_859;
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_1274(ItemStack var1) {
      if (!var1.isEmpty() && var1.getItem() instanceof ItemBlock) {
         Item var10000 = var1.getItem();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
         }

         ItemBlock var2 = (ItemBlock)var10000;
         Block var3 = var2.getBlock();
         if (var3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.BlockAccessor");
         }

         Material var4 = ((BlockAccessor)var3).getMaterial();
         if (var4.isSolid()) {
            if (var3 instanceof BlockPressurePlate) {
               return false;
            }

            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1275() {
      return this.field_854;
   }

   // $FF: renamed from: 0 (boolean) double
   public double method_1276(boolean var1) {
      if (var1) {
         return 0.267999999D;
      } else {
         return (fdi)this.field_855.c() == fdi.field_1316 ? 0.41999998688D : 0.42D;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4x) void
   @f0g
   @LauncherEventHide
   public void method_1277(@NotNull f4x var1) {
      if ((Boolean)this.field_853.c()) {
         var1.0();
      }

   }

   // $FF: renamed from: 5 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1278() {
      return this.field_856;
   }

   // $FF: renamed from: c (boolean) void
   public void method_1279(boolean var1) {
      this.field_852 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fee) void
   public void method_1280(@Nullable fee var1) {
      this.field_847 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g
   @LauncherEventHide
   public void method_1281(@NotNull f4p var1) {
      if (!var1.c() && var1.c() == f41.field_2120) {
         if (!(Boolean)PyroStatic.field_2511.c.method_3034() && this.c.player.onGround) {
            var1.0();
            var1.method_3122(true);
         }

      }
   }
}
