/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fd6 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_938 = (BooleanSetting)this.register((f0w)(new BooleanSetting("rotate", "Rotate", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_939 = (BooleanSetting)this.register((f0w)(new BooleanSetting("raytrace", "Raytrace", (String)null, true)));
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_940 = (f0l)this.register((f0w)(new f0l("renderColor", "RenderColor", (String)null, new f00(1.0F, 1.0F, 0.5F, 0.3F))));
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_941 = (f0l)this.register((f0w)(new f0l("renderOutline", "RenderOutline", (String)null, new f00(1.0F, 1.0F, 0.5F, 1.0F))));
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_942;

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_1370(@Nullable BlockPos var1) {
      this.field_942 = var1;
   }

   // $FF: renamed from: 0 () net.minecraft.util.EnumFacing
   @NotNull
   public EnumFacing method_1371() {
      switch(MathHelper.floor((double)(this.c.player.rotationYaw * 8.0F / 360.0F) + 0.5D) & 7) {
      case 0:
      case 1:
         return EnumFacing.SOUTH;
      case 2:
      case 3:
         return EnumFacing.WEST;
      case 4:
      case 5:
         return EnumFacing.NORTH;
      case 6:
      case 67:
         return EnumFacing.EAST;
      default:
         return EnumFacing.NORTH;
      }
   }

   // $FF: renamed from: 2 () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_1372() {
      return this.field_942;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u, net.minecraft.util.math.BlockPos) boolean
   public boolean method_1373(@NotNull f4u var1, @NotNull BlockPos var2) {
      if ((Boolean)this.field_938.c()) {
         float[] var3 = few.method_1716().method_1736(var2, few.method_1732(var2, true));
         if (var3 != null) {
            var1.0();
            var1.method_3139(var3[0]);
            var1.method_3140(var3[1]);
            return true;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public fd6() {
      super("autotunnel", "AutoTunnel", (String)null);
   }

   // $FF: renamed from: c (net.minecraft.block.state.IBlockState, net.minecraft.util.math.BlockPos, net.minecraft.block.Block) boolean
   public boolean method_1374(@NotNull IBlockState var1, @NotNull BlockPos var2, @NotNull Block var3) {
      if (this.c.playerController == null) {
         return false;
      } else if (PyroStatic.field_2568.method_1244().contains(var3)) {
         return false;
      } else {
         return (double)var1.getBlockHardness((World)this.c.world, var2) != 1.0D || this.c.playerController.isInCreativeMode();
      }
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1375() {
      return this.field_939;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_1376(@NotNull f4u var1) {
      if (!var1.c()) {
         if (var1.c() == f41.field_2120) {
            if (class_2.field_982.method_1424() == null || !(Intrinsics.areEqual((Object)class_2.field_982.method_1424(), (Object)((fd6)this)) ^ true)) {
               if (Intrinsics.areEqual((Object)class_2.field_982.method_1424(), (Object)((fd6)this)) && this.field_942 != null) {
                  BlockPos var10002 = this.field_942;
                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  this.method_1373(var1, var10002);
               } else {
                  EnumFacing var2 = this.method_1371();
                  if (var2 != null) {
                     BlockPos var3 = (new BlockPos(MathHelper.floor(this.c.player.posX), MathHelper.floor(this.c.player.posY), MathHelper.floor(this.c.player.posZ))).offset(var2);
                     ArrayList var4 = new ArrayList();
                     int var5 = 0;

                     for(byte var6 = 3; var5 <= var6; ++var5) {
                        var4.add(var3.offset(var2, var5));
                        var4.add(var3.offset(var2, var5).up());
                     }

                     Iterator var17 = var4.iterator();

                     while(var17.hasNext()) {
                        BlockPos var16 = (BlockPos)var17.next();
                        double var7 = this.c.player.posX - ((double)var16.getX() + 0.5D);
                        double var9 = this.c.player.posY - ((double)var16.getY() + 0.5D) + 1.5D;
                        double var11 = this.c.player.posZ - ((double)var16.getZ() + 0.5D);
                        double var13 = var7 * var7 + var9 * var9 + var11 * var11;
                        if (!(var13 > 36.0D)) {
                           Block var15 = feg.method_1779(var16);
                           if (this.method_1374(feg.method_1791(var16), var16, var15) && this.method_1373(var1, var16)) {
                              this.field_942 = var16;
                              class_2.field_982.method_1425((Module)this, var16, (Boolean)this.field_939.c(), (Consumer)(new fd5(this)));
                              break;
                           }
                        }
                     }
                  }

               }
            }
         }
      }
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (class_2.field_982.method_1424() != null && Intrinsics.areEqual((Object)class_2.field_982.method_1424(), (Object)((fd6)this))) {
         class_2.field_982.method_1423(false);
      }
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1377() {
      return this.field_941;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1378() {
      return this.field_938;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      if (this.field_942 != null) {
         fe5.field_1245.method_1915(7);
         fe5 var10000 = fe5.field_1245;
         BlockPos var10001 = this.field_942;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1917(var10001, ((f00)this.field_940.c()).meth1(), 63);
         fe5.field_1245.method_1912();
         BlockPos var3 = this.field_942;
         if (var3 == null) {
            Intrinsics.throwNpe();
         }

         PyroRenderUtil.method_1433(var3, ((f00)this.field_941.c()).meth1(), 1.5F, false);
      }

   }

   // $FF: renamed from: 4 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1379() {
      return this.field_940;
   }
}
