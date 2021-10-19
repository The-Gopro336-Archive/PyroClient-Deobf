/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.RenderGlobalAccessor;
import dev.nuker.pyro.mixin.ShaderGroupAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.shader.Shader;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderUniform;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fbc extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_662;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_663;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_664;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_665;
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_666;
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_667;
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_668;
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_669;
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_670;
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_671;
   // $FF: renamed from: 8 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_672;
   // $FF: renamed from: 9 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_673;
   // $FF: renamed from: a dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_674;
   // $FF: renamed from: b dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_675;
   // $FF: renamed from: c dev.nuker.pyro.f0t
   @NotNull
   public f0t field_676;
   // $FF: renamed from: 0 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_677;
   // $FF: renamed from: 1 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_678;
   // $FF: renamed from: 2 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_679;
   // $FF: renamed from: 3 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_680;
   // $FF: renamed from: d dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_681;
   // $FF: renamed from: 4 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_682;
   // $FF: renamed from: 5 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_683;
   // $FF: renamed from: e dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_684;
   // $FF: renamed from: 6 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_685;
   // $FF: renamed from: 7 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_686;
   // $FF: renamed from: 8 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_687;
   // $FF: renamed from: 9 dev.nuker.pyro.f0t
   @NotNull
   public f0t field_688;
   // $FF: renamed from: a dev.nuker.pyro.f0t
   @NotNull
   public f0t field_689;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_690;
   // $FF: renamed from: c boolean
   public boolean field_691;

   // $FF: renamed from: o () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_972() {
      return this.field_679;
   }

   // $FF: renamed from: 0 (net.minecraft.entity.Entity) dev.nuker.pyro.f00
   @Nullable
   public f00 method_973(@NotNull Entity var1) {
      if (this.c.player == null) {
         return null;
      } else if (!Intrinsics.areEqual((Object)var1, (Object)this.c.player) && (!this.c.player.isRiding() || !Intrinsics.areEqual((Object)var1, (Object)this.c.player.getRidingEntity()))) {
         f0t var2 = this.method_1011(var1);
         f00 var3;
         if (var2 != null) {
            f0l var10000 = (f0l)this.1(var2.3() + ".color");
            var3 = var10000 != null ? (f00)var10000.c() : null;
         } else {
            var3 = null;
         }

         return var3;
      } else {
         return null;
      }
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_974() {
      return this.field_662;
   }

   // $FF: renamed from: p () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_975() {
      return this.field_682;
   }

   // $FF: renamed from: m () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_976() {
      return this.field_680;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_977() {
      return this.field_668;
   }

   // $FF: renamed from: a () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_978() {
      return this.field_671;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_979() {
      return this.field_675;
   }

   // $FF: renamed from: d () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_980() {
      return this.field_669;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_981() {
      return this.field_681;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_982() {
      return this.field_667;
   }

   // $FF: renamed from: s () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_983() {
      return this.field_670;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_984() {
      return this.field_685;
   }

   // $FF: renamed from: l () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_985() {
      return this.field_684;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      this.field_691 = false;
      boolean var3 = this.c.gameSettings.fancyGraphics;
      float var4 = this.c.gameSettings.gammaSetting;
      this.c.gameSettings.fancyGraphics = false;
      this.c.gameSettings.gammaSetting = 100.0F;
      fe2.method_1848();
      Entity var10000;
      if (fdZ.field_976.getRenderViewEntity() == null) {
         var10000 = (Entity)fdZ.field_976.player;
      } else {
         var10000 = fdZ.field_976.getRenderViewEntity();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }
      }

      Entity var5 = var10000;
      double var6 = var5.lastTickPosX + (var5.posX - var5.lastTickPosX) * (double)var2;
      double var8 = var5.lastTickPosY + (var5.posY - var5.lastTickPosY) * (double)var2;
      double var10 = var5.lastTickPosZ + (var5.posZ - var5.lastTickPosZ) * (double)var2;
      PyroRenderUtil.field_983.setPosition(var6, var8, var10);
      if ((faV)this.field_662.c() == faV.field_1490) {
         fep.meth2();
         fep.method_1702(var2);
         fep.meth0();
         fep.method_1702(var2);
         fep.method_1703();
         fep.meth3();
         fep.method_1702(var2);
         fep.method_1705();
      }

      if ((Boolean)this.field_684.c()) {
         RenderHelper.enableStandardItemLighting();
         fep.meth2();
         fep.method_1701(var2);
         fep.meth0();
         fep.method_1701(var2);
         fep.method_1703();
         fep.meth3();
         fep.method_1701(var2);
         fep.method_1705();
         RenderHelper.disableStandardItemLighting();
      }

      this.c.gameSettings.gammaSetting = var4;
      this.c.gameSettings.fancyGraphics = var3;
      fep.method_1700(new Color(255, 255, 255, 255));
      this.field_691 = true;
      if ((Boolean)this.field_668.c()) {
         List var12 = (List)(new ArrayList());
         this.c.world.loadedEntityList.stream().filter((Predicate)faX.field_1481).forEach((Consumer)(new faY(this, var12)));
         CollectionsKt.sortWith(var12, (Comparator)(new faZ(this)));
         Iterator var14 = var12.iterator();

         while(true) {
            Entity var13;
            UUID var15;
            while(true) {
               if (!var14.hasNext()) {
                  return;
               }

               var13 = (Entity)var14.next();
               var15 = (UUID)null;
               if (var13 instanceof EntityWolf) {
                  if (((EntityWolf)var13).isTamed()) {
                     var15 = ((EntityWolf)var13).getOwnerId();
                     break;
                  }
               } else {
                  if (!(var13 instanceof AbstractHorse)) {
                     break;
                  }

                  if (((AbstractHorse)var13).isTame()) {
                     var15 = ((AbstractHorse)var13).getOwnerUniqueId();
                     break;
                  }
               }
            }

            Entity var16 = this.c.getRenderViewEntity();
            Vec3d var17 = fdY.method_1816(var13, var2);
            double var18 = var17.x;
            double var20 = var17.y + 0.65D;
            double var22 = var17.z;
            double var24 = var20 - 0.58D;
            var17 = fdY.method_1816(var16, var2);
            if (var16 == null) {
               Intrinsics.throwNpe();
            }

            double var26 = var16.posX;
            double var28 = var16.posY;
            double var30 = var16.posZ;
            var16.posX = var17.x;
            var16.posY = var17.y;
            var16.posZ = var17.z;
            var20 = var16.getDistance(var18, var20, var22);
            double var32 = 0.04D;
            if (var20 > 0.0D) {
               var32 = 0.02D + (double)0.003F * var20;
            }

            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enablePolygonOffset();
            GlStateManager.doPolygonOffset(1.0F, -1500000.0F);
            GlStateManager.disableLighting();
            GlStateManager.translate((float)var18, (float)var24 + 1.4F, (float)var22);
            float var34 = -this.c.getRenderManager().playerViewY;
            float var35 = 1.0F;
            float var36 = 0.0F;
            GlStateManager.rotate(var34, var36, var35, var36);
            GlStateManager.rotate(this.c.getRenderManager().playerViewX, this.c.gameSettings.thirdPersonView == 2 ? -1.0F : 1.0F, 0.0F, (float)0);
            GlStateManager.scale(-var32, -var32, var32);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            String var37 = this.method_998(var13, var15);
            if ((Boolean)this.field_681.c()) {
               var37 = var37 + " " + var13.getEntityId();
            }

            float var38 = PyroRenderUtil.method_1439(var37) / (float)2;
            float var39 = PyroRenderUtil.meth1();
            float var40 = 0.0F;
            float var41 = var38 + (float)2;
            PyroRenderUtil.method_1444(var37, -var38 + (float)1, -var40 - var39 + (float)3, -1);
            GlStateManager.enableDepth();
            GlStateManager.disableBlend();
            GlStateManager.disablePolygonOffset();
            GlStateManager.doPolygonOffset(1.0F, 1500000.0F);
            GlStateManager.popMatrix();
            var16.posX = var26;
            var16.posY = var28;
            var16.posZ = var30;
         }
      }
   }

   // $FF: renamed from: t () boolean
   public boolean method_986() {
      return this.field_691;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4J) void
   @f0g
   @LauncherEventHide
   public void method_987(@NotNull f4J var1) {
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.method_1008();
   }

   // $FF: renamed from: i () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_988() {
      return this.field_690;
   }

   // $FF: renamed from: q () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_989() {
      return this.field_687;
   }

   public fbc() {
      super("esp", "ESP", "Outlines entities");
      this.field_662 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)faV.field_1491)));
      this.field_663 = new BooleanSetting("players", "Players", (String)null, true);
      this.field_664 = new BooleanSetting("friends", "Friends", (String)null, true);
      this.field_665 = new BooleanSetting("bosses", "Bosses", (String)null, true);
      this.field_666 = new BooleanSetting("hostiles", "Hostiles", (String)null, true);
      this.field_667 = new BooleanSetting("passives", "Passives", (String)null, true);
      this.field_668 = new BooleanSetting("tamed", "Tamed", (String)null, true);
      this.field_669 = new BooleanSetting("items", "Items", (String)null, false);
      this.field_670 = new BooleanSetting("other", "Other", (String)null, false);
      this.field_671 = new BooleanSetting("chests", "Chest", (String)null, true);
      this.field_672 = new BooleanSetting("shulkers", "Shulker", (String)null, true);
      this.field_673 = new BooleanSetting("enderchests", "EnderChest", (String)null, true);
      this.field_674 = new BooleanSetting("beds", "Beds", (String)null, true);
      this.field_675 = (BooleanSetting)this.register((f0w)(new BooleanSetting("maxDist", "MaxDist", "Overrides vanilla max tile entity distance, Causes FPS drops", false)));
      this.field_676 = (f0t)this.register((f0w)(new f0t((f0w)this.field_663, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, f00.field_2296.method_3687(255, 255, 255, 255)))})));
      this.field_677 = (f0t)this.register((f0w)(new f0t((f0w)this.field_664, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, f00.field_2296.method_3687(5, 255, 240, 255)))})));
      this.field_678 = (f0t)this.register((f0w)(new f0t((f0w)this.field_665, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, new f00(0, 1, 1, 1)))})));
      this.field_679 = (f0t)this.register((f0w)(new f0t((f0w)this.field_666, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, new f00(0.08F, 1.0F, 1.0F, 1.0F)))})));
      this.field_680 = (f0t)this.register((f0w)(new f0t((f0w)this.field_667, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, new f00(0.33F, 0.6F, 1.0F, 1.0F)))})));
      this.field_681 = (BooleanSetting)this.register((f0w)(new BooleanSetting("entityId", "EntityId", (String)null, false)));
      this.register((f0w)(new f0t((f0w)this.field_668, new f0w[]{(f0w)this.field_681})));
      this.field_682 = (f0t)this.register((f0w)(new f0t((f0w)this.field_669, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, new f00(0.5F, 1.0F, 1.0F, 1.0F)))})));
      this.field_683 = (f0t)this.register((f0w)(new f0t((f0w)this.field_670, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, new f00(0.6F, 1.0F, 1.0F, 1.0F)))})));
      this.field_684 = new BooleanSetting("storages", "Storages", (String)null, true);
      this.field_685 = new f0t((f0w)this.field_671, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, f00.field_2296.method_3687(255, 252, 99, 255)))});
      this.field_686 = new f0t((f0w)this.field_672, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, f00.field_2296.method_3687(255, 0, 151, 255)))});
      this.field_687 = new f0t((f0w)this.field_673, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, f00.field_2296.method_3687(166, 0, 238, 255)))});
      this.field_688 = new f0t((f0w)this.field_674, new f0w[]{(f0w)(new f0l("color", "Color", (String)null, f00.field_2296.method_3687(255, 255, 255, 255)))});
      this.field_689 = (f0t)this.register((f0w)(new f0t((f0w)this.field_684, new f0w[]{(f0w)this.field_685, (f0w)this.field_686, (f0w)this.field_687, (f0w)this.field_688})));
      this.field_690 = (DoubleSetting)this.register((f0w)(new DoubleSetting("width", "Width", "Changes the width of the outline", 3.0D, 1.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_691 = true;
      this.field_690.c((Consumer)(new faT(this)));
      this.field_662.c((Consumer)(new faU(this)));
   }

   // $FF: renamed from: r () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_990() {
      return this.field_683;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_991() {
      return this.field_678;
   }

   // $FF: renamed from: k () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_992() {
      return this.field_689;
   }

   // $FF: renamed from: j () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_993() {
      return this.field_672;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_994() {
      return this.field_674;
   }

   // $FF: renamed from: c (net.minecraft.tileentity.TileEntity) boolean
   public boolean method_995(@NotNull TileEntity var1) {
      return var1 instanceof TileEntityShulkerBox ? (Boolean)this.field_672.c() : (var1 instanceof TileEntityChest ? (Boolean)this.field_671.c() : (var1 instanceof TileEntityEnderChest ? (Boolean)this.field_673.c() : (var1 instanceof TileEntityBed ? (Boolean)this.field_674.c() : false)));
   }

   // $FF: renamed from: c (dev.nuker.pyro.fbc) net.minecraft.client.Minecraft
   public static Minecraft method_996(fbc var0) {
      return var0.c;
   }

   // $FF: renamed from: h () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_997() {
      return this.field_673;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, java.util.UUID) java.lang.String
   @NotNull
   public String method_998(@NotNull Entity var1, @Nullable UUID var2) {
      return f0d.field_987.method_1449(StringsKt.replace$default(String.valueOf(var2), "-", "", false, 4, (Object)null));
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_999() {
      return this.field_676;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_1000() {
      return this.field_688;
   }

   // $FF: renamed from: u () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1001() {
      return this.field_663;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1002() {
      return this.field_664;
   }

   // $FF: renamed from: e () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1003() {
      return this.field_666;
   }

   // $FF: renamed from: f () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_1004() {
      return this.field_686;
   }

   // $FF: renamed from: 0 (net.minecraft.tileentity.TileEntity) dev.nuker.pyro.f00
   @Nullable
   public f00 method_1005(@NotNull TileEntity var1) {
      f0l var10000 = (f0l)this.1(var1 instanceof TileEntityShulkerBox ? "storages.shulkers.color" : (var1 instanceof TileEntityChest ? "storages.chests.color" : (var1 instanceof TileEntityEnderChest ? "storages.enderchests.color" : (var1 instanceof TileEntityBed ? "storages.beds.color" : null))));
      return var10000 != null ? (f00)var10000.c() : null;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fbc, net.minecraft.client.Minecraft) void
   public static void method_1006(fbc var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: c (boolean) void
   public void method_1007(boolean var1) {
      this.field_691 = var1;
   }

   // $FF: renamed from: b () void
   public void method_1008() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: g () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1009() {
      return this.field_665;
   }

   // $FF: renamed from: n () dev.nuker.pyro.f0t
   @NotNull
   public f0t method_1010() {
      return this.field_677;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) dev.nuker.pyro.f0t
   @Nullable
   public f0t method_1011(@NotNull Entity var1) {
      if (var1 instanceof EntityPlayer) {
         if ((Boolean)this.field_664.c() && FriendManager.Companion.isFriend((EntityPlayer)var1)) {
            return this.field_677;
         }

         if ((Boolean)this.field_663.c()) {
            return this.field_676;
         }
      } else if (!(var1 instanceof EntityDragon) && !(var1 instanceof EntityWither)) {
         if (fdN.method_1874(var1)) {
            if ((Boolean)this.field_667.c()) {
               return this.field_680;
            }
         } else if (var1.isCreatureType(EnumCreatureType.MONSTER, false)) {
            if ((Boolean)this.field_666.c()) {
               return this.field_679;
            }
         } else if (var1 instanceof EntityItem) {
            if ((Boolean)this.field_669.c()) {
               return this.field_682;
            }
         } else if ((Boolean)this.field_670.c()) {
            return this.field_683;
         }
      } else if ((Boolean)this.field_665.c()) {
         return this.field_678;
      }

      return null;
   }
}
