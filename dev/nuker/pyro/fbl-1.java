/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class fbl extends Module {
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_641 = (IntegerSetting)this.register((f0w)(new IntegerSetting("range", "Range", (String)null, 10, 5, 20, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_642 = (IntegerSetting)this.register((f0w)(new IntegerSetting("y_range", "Y-Range", (String)null, 7, 3, 20, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_643 = (f0l)this.register((f0w)(new f0l("bedrock_color", "Bedrock", (String)null, new f00(0.0F, 1.0F, 1.0F, 1.0F))));
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_644 = (f0l)this.register((f0w)(new f0l("obsidian_color", "Obsidian", (String)null, new f00(0.1666666F, 1.0F, 1.0F, 1.0F))));
   // $FF: renamed from: 1 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_645 = (f0l)this.register((f0w)(new f0l("bedrockOutline", "BedrockOutline", (String)null, new f00(0.0F, 1.0F, 1.0F, 1.0F))));
   // $FF: renamed from: 2 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_646 = (f0l)this.register((f0w)(new f0l("obsidianOutline", "ObsidianOutline", (String)null, new f00(0.1666666F, 1.0F, 1.0F, 1.0F))));
   // $FF: renamed from: 1 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_647 = new IntegerSetting("holeglow_opacity", "GlowOpacity", (String)null, 100, 0, 255, 0, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_648 = new DoubleSetting("holeglow_height", "GlowHeight", (String)null, 3.0D, 1.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_649 = new DoubleSetting("height", "Height", (String)null, 0.1D, 0.0D, 1.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_650 = (BooleanSetting)this.register((f0w)(new BooleanSetting("doubleHoles", "Double", "Show holes you can move in center of", true)));
   // $FF: renamed from: c dev.nuker.pyro.f0z
   @NotNull
   public f0z field_651;
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_652;

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB, boolean, int) void
   public void method_953(@NotNull AxisAlignedBB var1, boolean var2, int var3) {
      BufferBuilder var4 = fe5.field_1245.getBuffer();
      double var5 = var1.minX + 0.001D;
      double var7 = var1.minY + 0.001D;
      double var9 = var1.minZ + 0.001D;
      double var11 = (double)((float)(var1.maxX - var1.minX)) - 0.002D;
      float var13 = var2 ? (float)(var1.maxY - var1.minY) : (float)((Number)this.field_648.c()).doubleValue();
      double var14 = (double)((float)(var1.maxZ - var1.minZ)) - 0.002D;
      int var16 = ((Number)this.field_647.c()).intValue();
      int var17 = var3 >>> 16 & 255;
      int var18 = var3 >>> 8 & 255;
      int var19 = var3 & 255;
      byte var20 = 25;
      var4.pos(var5 + var11, var7, var9).color(var17, var18, var19, var16).endVertex();
      var4.pos(var5, var7, var9).color(var17, var18, var19, var16).endVertex();
      var4.pos(var5, var7 + (double)var13, var9).color(var17, var18, var19, var20).endVertex();
      var4.pos(var5 + var11, var7 + (double)var13, var9).color(var17, var18, var19, var20).endVertex();
      var4.pos(var5, var7, var9 + var14).color(var17, var18, var19, var16).endVertex();
      var4.pos(var5 + var11, var7, var9 + var14).color(var17, var18, var19, var16).endVertex();
      var4.pos(var5 + var11, var7 + (double)var13, var9 + var14).color(var17, var18, var19, var20).endVertex();
      var4.pos(var5, var7 + (double)var13, var9 + var14).color(var17, var18, var19, var20).endVertex();
      var4.pos(var5, var7, var9).color(var17, var18, var19, var16).endVertex();
      var4.pos(var5, var7, var9 + var14).color(var17, var18, var19, var16).endVertex();
      var4.pos(var5, var7 + (double)var13, var9 + var14).color(var17, var18, var19, var20).endVertex();
      var4.pos(var5, var7 + (double)var13, var9).color(var17, var18, var19, var20).endVertex();
      var4.pos(var5 + var11, var7, var9 + var14).color(var17, var18, var19, var16).endVertex();
      var4.pos(var5 + var11, var7, var9).color(var17, var18, var19, var16).endVertex();
      var4.pos(var5 + var11, var7 + (double)var13, var9).color(var17, var18, var19, var20).endVertex();
      var4.pos(var5 + var11, var7 + (double)var13, var9 + var14).color(var17, var18, var19, var20).endVertex();
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, boolean) int
   public int method_954(@NotNull BlockPos var1, boolean var2) {
      int var3 = 3;
      EnumFacing[] var6 = EnumFacing.VALUES;
      int var7 = var6.length;

      for(int var5 = 0; var5 < var7; ++var5) {
         EnumFacing var4 = var6[var5];
         if (var4 != EnumFacing.UP) {
            int var8 = this.method_959(var1.offset(var4));
            if (var8 == 0 || var3 < 0 && var8 == 1) {
               return 0;
            }

            if (var3 > 0 && var8 == 1 && var2) {
               EnumFacing[] var11 = EnumFacing.VALUES;
               int var12 = var11.length;

               for(int var10 = 0; var10 < var12; ++var10) {
                  EnumFacing var9 = var11[var10];
                  if (var9 != EnumFacing.UP && var9.getOpposite() != var4) {
                     int var13 = this.method_959(var1.offset(var4).offset(var9));
                     if (var13 < 2) {
                        return 0;
                     }

                     if (var9 == EnumFacing.DOWN) {
                        if (var3 > var13) {
                           var3 = var13;
                        }
                     } else {
                        var3 = -1;
                     }
                  }
               }

               if (var3 != -1) {
                  return 0;
               }

               var3 = -var4.getIndex() - 1;
            } else if (var3 > var8) {
               var3 = var8;
            }
         }
      }

      int var10000;
      if (-6 <= var3) {
         if (-1 >= var3) {
            var10000 = -var3 + 2;
            return var10000;
         }
      }

      var10000 = var3 != 0 && var3 != 1 ? var3 - 1 : 0;
      return var10000;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_955() {
      return this.field_646;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_956() {
      return this.field_645;
   }

   public fbl() {
      super("hole_esp", "HoleESP", "Shows bedrock and obsidian holes to help with crystal pvp");
      Enum var10005 = (Enum)fbj.field_1640;
      List[] var10006 = new List[]{CollectionsKt.listOf(new Setting[]{(Setting)this.field_647, (Setting)this.field_648}), null, null, null, null};
      byte var12 = 1;
      List[] var11 = var10006;
      List[] var10 = var10006;
      Enum var9 = var10005;
      String var8 = "The type of rendering";
      String var7 = "Type";
      String var6 = "type";
      boolean var1 = false;
      List var13 = CollectionsKt.emptyList();
      var11[var12] = var13;
      var12 = 2;
      var1 = false;
      var13 = CollectionsKt.emptyList();
      var10[var12] = var13;
      var12 = 3;
      var1 = false;
      var13 = CollectionsKt.emptyList();
      var10[var12] = var13;
      var10[4] = CollectionsKt.listOf(this.field_649);
      this.field_651 = (f0z)this.register((f0w)(new f0z(var6, var7, var8, var9, var10)));
      var1 = false;
      List var3 = (List)(new ArrayList());
      this.field_652 = var3;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f0z
   @NotNull
   public f0z method_957() {
      return this.field_651;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_958() {
      return this.field_648;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) int
   public int method_959(@NotNull BlockPos var1) {
      Block var2 = feg.method_1779(var1);
      return Intrinsics.areEqual((Object)var2, (Object)Blocks.BEDROCK) ? 3 : (Intrinsics.areEqual((Object)var2, (Object)Blocks.OBSIDIAN) ? 2 : (Intrinsics.areEqual((Object)var2, (Object)Blocks.AIR) ? 1 : 0));
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_960() {
      return this.field_643;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_961(@NotNull f4t var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4C) void
   @f0g
   @LauncherEventHide
   public void method_962(@NotNull f4C var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_963() {
      return this.field_642;
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_964() {
      return this.field_649;
   }

   // $FF: renamed from: 3 () java.util.List
   @NotNull
   public List method_965() {
      return this.field_652;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_966() {
      return this.field_647;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_967() {
      return this.field_641;
   }

   // $FF: renamed from: a () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_968() {
      return this.field_650;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_969() {
      return this.field_644;
   }
}
