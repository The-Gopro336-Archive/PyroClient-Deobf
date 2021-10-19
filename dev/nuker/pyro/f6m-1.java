/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;

public class f6m extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_522 = (DoubleSetting)this.register((f0w)(new DoubleSetting("range", "Range", (String)null, 6.0D, 1.0D, 6.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_523 = (BooleanSetting)this.register((f0w)(new BooleanSetting("noSuicide", "NoSuicide", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   public DoubleSetting field_524 = (DoubleSetting)this.register((f0w)(new DoubleSetting("minDmg", "MinDMG", (String)null, 10.0D, 0.1D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null)));

   // $FF: renamed from: c (dev.nuker.pyro.f6m) net.minecraft.client.Minecraft
   public static Minecraft method_738(f6m var0) {
      return var0.c;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_739(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120 && !var1.c()) {
         if (this.c.player.dimension != 0) {
            ArrayList var2 = this.method_740();
            float var3 = 0.0F;
            Ref.ObjectRef var4 = new Ref.ObjectRef();
            var4.element = (BlockPos)null;
            float var5 = this.c.player.getHealth() + this.c.player.getAbsorptionAmount();
            BlockPos var6 = new BlockPos(this.c.player.getPositionVector());
            ArrayList var7 = new ArrayList();
            int var8 = var6.getX() - 10;
            int var9 = (int)((float)var6.getY() + this.c.player.getEyeHeight() - (float)10);
            int var10 = var6.getZ() - 10;
            int var11 = var6.getX() + 10;
            int var12 = (int)((float)var6.getY() + this.c.player.getEyeHeight() + (float)10);
            int var13 = var6.getZ() + 10;
            double var14 = ((Number)this.field_522.c()).doubleValue() * ((Number)this.field_522.c()).doubleValue();
            int var16 = var8;

            for(int var17 = var11; var16 < var17; ++var16) {
               int var18 = var9;

               for(int var19 = var12; var18 < var19; ++var18) {
                  int var20 = var10;

                  for(int var21 = var13; var20 < var21; ++var20) {
                     BlockPos var22 = new BlockPos(var16, var18, var20);
                     double var23 = this.c.player.posX - ((double)var22.getX() + 0.5D);
                     double var25 = this.c.player.posY - ((double)var22.getY() + 0.5D) + 1.5D;
                     double var27 = this.c.player.posZ - ((double)var22.getZ() + 0.5D);
                     double var29 = var23 * var23 + var25 * var25 + var27 * var27;
                     if (!(var29 > 36.0D) && !(var29 > var14)) {
                        Block var31 = feg.method_1779(var22);
                        if (!Intrinsics.areEqual((Object)var31, (Object)Blocks.AIR) && !(var31 instanceof BlockLiquid)) {
                           if (var31 instanceof BlockBed) {
                              float var46 = fdM.method_1882(var22, (EntityLivingBase)this.c.player);
                              if (!(Boolean)this.field_523.c() || !(var46 >= var5 + (float)1)) {
                                 Iterator var34 = var2.iterator();

                                 while(var34.hasNext()) {
                                    EntityPlayer var33 = (EntityPlayer)var34.next();
                                    float var35 = fdM.method_1882(var22, (EntityLivingBase)var33);
                                    if (var35 >= var3) {
                                       var3 = var35;
                                       var4.element = var22;
                                    }
                                 }
                              }
                           } else if ((BlockPos)var4.element == null) {
                              float[] var32 = few.method_1716().method_1736(var22, EnumFacing.UP);
                              if (this.method_741(var22, var32[0])) {
                                 var7.add(var22);
                              }
                           }
                        }
                     }
                  }
               }
            }

            Ref.ObjectRef var38;
            if ((BlockPos)var4.element != null) {
               var1.0();
               Ref.ObjectRef var37 = new Ref.ObjectRef();
               var37.element = few.method_1732((BlockPos)var4.element, true);
               var38 = new Ref.ObjectRef();
               var38.element = few.method_1716().method_1717((BlockPos)var4.element, (EnumFacing)var37.element);
               var1.method_3139(((fex)var38.element).method_2076().meth3());
               var1.method_3140(((fex)var38.element).method_2076().meth4());
               var1.method_3133((Consumer)(new f6k(this, var4, var37, var38)));
            } else {
               Ref.IntRef var36 = new Ref.IntRef();
               var36.element = fdX.field_1227.method_1839(Items.BED);
               if (var36.element != -1) {
                  var38 = new Ref.ObjectRef();
                  var38.element = (BlockPos)null;
                  Iterator var41 = var7.iterator();

                  while(true) {
                     BlockPos var39;
                     float var42;
                     do {
                        if (!var41.hasNext()) {
                           if ((BlockPos)var38.element != null) {
                              Ref.ObjectRef var40 = new Ref.ObjectRef();
                              var40.element = few.method_1716().method_1717((BlockPos)var38.element, EnumFacing.UP);
                              var1.0();
                              var1.method_3139(((fex)var40.element).method_2076().meth3());
                              var1.method_3140(((fex)var40.element).method_2076().meth4());
                              var1.method_3133((Consumer)(new f6l(this, var36, var38, var40)));
                           }

                           return;
                        }

                        var39 = (BlockPos)var41.next();
                        var42 = fdM.method_1882(var39, (EntityLivingBase)this.c.player);
                     } while((Boolean)this.field_523.c() && var42 >= var5 + (float)1);

                     Iterator var44 = var2.iterator();

                     while(var44.hasNext()) {
                        EntityPlayer var43 = (EntityPlayer)var44.next();
                        float var45 = fdM.method_1882(var39, (EntityLivingBase)var43);
                        if (var45 >= var3) {
                           var3 = var45;
                           var38.element = var39;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   // $FF: renamed from: c () java.util.ArrayList
   @NotNull
   public ArrayList method_740() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.c.world.playerEntities.iterator();

      while(var2.hasNext()) {
         EntityPlayer var3 = (EntityPlayer)var2.next();
         if (var3 != null && Intrinsics.areEqual((Object)var3, (Object)this.c.player) ^ true && !FriendManager.Companion.isFriend(var3)) {
            var1.add(var3);
         }
      }

      return var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, float) boolean
   public boolean method_741(@NotNull BlockPos var1, float var2) {
      BlockPos var3 = var1;
      IBlockState var4 = this.c.world.getBlockState(var1);
      Block var5 = var4.getBlock();
      boolean var6 = var5.isReplaceable((IBlockAccess)this.c.world, var1);
      if (!var6) {
         var3 = var1.up();
      }

      int var7 = MathHelper.floor((double)(var2 * 4.0F / 360.0F) + 0.5D) & 3;
      EnumFacing var8 = EnumFacing.getHorizontal(var7);
      BlockPos var9 = var3.offset(var8);
      IBlockState var10 = feg.method_1791(var9);
      boolean var11 = var10.getBlock().isReplaceable((IBlockAccess)this.c.world, var9);
      boolean var12 = var6 || this.c.world.isAirBlock(var3);
      boolean var13 = var11 || this.c.world.isAirBlock(var9);
      return var12 && var13 && this.c.world.getBlockState(var3.down()).isTopSolid() && this.c.world.getBlockState(var9.down()).isTopSolid();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f6m, net.minecraft.client.Minecraft) void
   public static void method_742(f6m var0, Minecraft var1) {
      var0.c = var1;
   }

   public f6m() {
      super("autobedbomb", "AutoBedBomb", "Automatically places and destroys beds at enemies");
   }
}
