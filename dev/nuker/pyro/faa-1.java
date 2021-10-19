/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

public class faa extends faj {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1559 = new DoubleSetting("horizontalSpeed", "Speed", "Maximum speed", 1.8D, 0.0D, 5.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1560 = new BooleanSetting("instantStop", "InstantStop", "Stops flying when you stop pressing keys", true);
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1561 = new DoubleSetting("factor", "Factor", (String)null, 0.0D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: 1 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1562 = new DoubleSetting("factor", "Factor", (String)null, 0.0D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c dev.nuker.pyro.f0z
   @NotNull
   public f0z field_1563;
   // $FF: renamed from: 2 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1564;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1565;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1566;
   // $FF: renamed from: 3 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1567;
   // $FF: renamed from: c dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting field_1568;
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1569;
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1570;
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1571;
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_1572;
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1573;
   // $FF: renamed from: 4 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1574;
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1575;
   // $FF: renamed from: 0 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_1576;
   // $FF: renamed from: c float
   public float field_1577;
   // $FF: renamed from: 0 float
   public float field_1578;
   // $FF: renamed from: c int
   public int field_1579;
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_1580;
   // $FF: renamed from: 0 int
   public int field_1581;

   // $FF: renamed from: c (float) void
   public void method_2757(float var1) {
      this.field_1577 = var1;
   }

   // $FF: renamed from: i () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2758() {
      return this.field_1570;
   }

   // $FF: renamed from: b () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2759() {
      return this.field_1566;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2760() {
      return this.field_1571;
   }

   // $FF: renamed from: 0 (float) void
   public void method_2761(float var1) {
      this.field_1578 = var1;
   }

   // $FF: renamed from: e () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2762() {
      return this.field_1564;
   }

   // $FF: renamed from: d () int
   public int method_2763() {
      return this.field_1579;
   }

   // $FF: renamed from: 1 () java.util.List
   @NotNull
   public List method_2673() {
      return this.field_1580;
   }

   // $FF: renamed from: h () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2764() {
      return this.field_1560;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2765() {
      return this.field_1575;
   }

   // $FF: renamed from: f () int
   public int method_2766() {
      return this.field_1581;
   }

   // $FF: renamed from: 7 () float
   public float method_2767() {
      return this.field_1578;
   }

   // $FF: renamed from: l () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2768() {
      return this.field_1565;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2769() {
      return this.field_1561;
   }

   // $FF: renamed from: c (int) void
   public void method_2770(int var1) {
      this.field_1581 = var1;
   }

   // $FF: renamed from: 1 () float
   public float method_2771() {
      return this.field_1577;
   }

   // $FF: renamed from: a () dev.nuker.pyro.f0z
   @NotNull
   public f0z method_2772() {
      return this.field_1563;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2773() {
      return this.field_1567;
   }

   public faa(@NotNull f9h var1) {
      super(var1, "boostControl", "BoostControl");
      Enum var10004 = (Enum)fa7.field_1465;
      List[] var10005 = new List[4];
      byte var12 = 0;
      List[] var11 = var10005;
      List[] var10 = var10005;
      Enum var9 = var10004;
      Object var8 = null;
      String var7 = "Accelerate";
      String var6 = "accelerate";
      boolean var2 = false;
      List var13 = CollectionsKt.emptyList();
      var11[var12] = var13;
      var10[1] = CollectionsKt.listOf(this.field_1561);
      var10[2] = CollectionsKt.listOf(this.field_1562);
      var12 = 3;
      var2 = false;
      var13 = CollectionsKt.emptyList();
      var10[var12] = var13;
      this.field_1563 = new f0z(var6, var7, (String)var8, var9, var10);
      this.field_1564 = new DoubleSetting("fallSpeed", "GlideSpeed", "Speed to fall/glide at", 1.0D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_1565 = new BooleanSetting("ignoreStill", "WhileMoving", "Stops falling when you aren't moving", true);
      this.field_1566 = new BooleanSetting("cutoff", "Cutoff", "Stops adding speed above the specified pitch", true);
      this.field_1567 = new DoubleSetting("pitch", "Pitch", "Pitch to stop adding speed", 0.58D, -90.0D, 90.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_1568 = new BindSetting("snap", "Snap", "Snaps the pitch to the cutoff pitch", -1);
      this.field_1569 = new BooleanSetting("render", "Render", "Draw a line showing the cutoff onscreen", true);
      this.field_1570 = new BooleanSetting("autoStart", "AutoStart", "Automatically starts the elytra fly off ground", true);
      this.field_1571 = new BooleanSetting("autoJump", "AutoJump", "Automatically jumps on ground", true);
      this.field_1572 = new IntegerSetting("waitTicks", "WaitTicks", "The number of ticks to wait after you jump before starting", 20, 0, 60, 0, 64, (DefaultConstructorMarker)null);
      this.field_1573 = new BooleanSetting("autoStartTimer", "UseTimer", "Slows down the game speed to allow you to fly easier", true);
      this.field_1574 = new DoubleSetting("minStartHeight", "MinHeight", "Minimum height to start at", 0.5D, 0.0D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_1575 = new BooleanSetting("InWater", "InLiquid", "Sends the fly packet in Liquid", true);
      this.field_1576 = new IntegerSetting("startTicks", "StartTicks", "The number of ticks after offground to try to fly at", 4, 1, 5, 0, 64, (DefaultConstructorMarker)null);
      this.field_1577 = -1337.0F;
      this.field_1578 = -1337.0F;
      this.field_1580 = CollectionsKt.listOf(new f0w[]{(f0w)this.field_1559, (f0w)this.field_1560, (f0w)this.field_1563, (f0w)(new f0t((f0w)this.field_1564, new f0w[]{(f0w)this.field_1565})), (f0w)(new f0t((f0w)this.field_1566, new f0w[]{(f0w)this.field_1567, (f0w)this.field_1568, (f0w)this.field_1569})), (f0w)(new f0t((f0w)this.field_1570, new f0w[]{(f0w)this.field_1571, (f0w)this.field_1574, (f0w)this.field_1572, (f0w)this.field_1573, (f0w)this.field_1575, (f0w)this.field_1576}))});
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting method_2774() {
      return this.field_1568;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_2775(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         if (!(Boolean)this.field_1570.c()) {
            this.field_1581 = 0;
            this.field_1579 = 0;
            f0b.field_2415.method_3669("elytraFlyAutoStart");
         } else {
            boolean var3 = false;
            if (!Minecraft.getMinecraft().player.isElytraFlying()) {
               var3 = false;
               if (Intrinsics.areEqual((Object)Minecraft.getMinecraft().player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem(), (Object)Items.ELYTRA) ^ true) {
                  return;
               }

               var3 = false;
               if (!ItemElytra.isUsable(Minecraft.getMinecraft().player.getItemStackFromSlot(EntityEquipmentSlot.CHEST))) {
                  return;
               }

               Minecraft var9;
               Entity var10001;
               NetHandlerPlayClient var20;
               NetHandlerPlayClient var25;
               if (PyroStatic.field_2500.method_245()) {
                  if ((Boolean)this.field_1575.c()) {
                     var3 = false;
                     var25 = Minecraft.getMinecraft().getConnection();
                     if (var25 == null) {
                        Intrinsics.throwNpe();
                     }

                     var20 = var25;
                     var3 = false;
                     var9 = Minecraft.getMinecraft();
                     var10001 = (Entity)var9.player;
                     Action var16 = Action.START_FALL_FLYING;
                     Entity var17 = var10001;
                     var20.sendPacket((Packet)(new CPacketEntityAction(var17, var16)));
                  }
               } else {
                  boolean var4;
                  Minecraft var7;
                  boolean var24;
                  label641: {
                     if (((Number)this.field_1574.c()).doubleValue() != 0.0D) {
                        var4 = false;
                        WorldClient var10000 = Minecraft.getMinecraft().world;
                        if (var10000 == null) {
                           Intrinsics.throwNpe();
                        }

                        WorldClient var6 = var10000;
                        var4 = false;
                        var7 = Minecraft.getMinecraft();
                        if (var6.collidesWithAnyBlock(var7.player.getEntityBoundingBox().expand(0.0D, -((Number)this.field_1574.c()).doubleValue(), 0.0D))) {
                           var24 = true;
                           break label641;
                        }
                     }

                     var24 = false;
                  }

                  label635: {
                     boolean var2 = var24;
                     if (!(Boolean)this.field_1571.c()) {
                        var4 = false;
                        if (!Minecraft.getMinecraft().player.movementInput.jump) {
                           break label635;
                        }
                     }

                     var4 = false;
                     if (!Minecraft.getMinecraft().player.capabilities.isFlying) {
                        if (feg.field_1216.method_1783(far.c.player.getPosition().up().up()).blocksMovement()) {
                           var4 = false;
                           EntityPlayerSP var21 = Minecraft.getMinecraft().player;
                           var4 = false;
                           var7 = Minecraft.getMinecraft();
                           double var22 = var7.player.posX;
                           var4 = false;
                           var9 = Minecraft.getMinecraft();
                           double var19 = var9.player.posY;
                           boolean var5 = false;
                           double var23 = Math.floor(var19);
                           var23 += 0.2D;
                           var4 = false;
                           Minecraft var11 = Minecraft.getMinecraft();
                           var21.setPosition(var22, var23, var11.player.posZ);
                           var4 = false;
                           var25 = Minecraft.getMinecraft().getConnection();
                           if (var25 == null) {
                              Intrinsics.throwNpe();
                           }

                           var20 = var25;
                           var4 = false;
                           var9 = Minecraft.getMinecraft();
                           var10001 = (Entity)var9.player;
                           Action var12 = Action.START_FALL_FLYING;
                           Entity var13 = var10001;
                           var20.sendPacket((Packet)(new CPacketEntityAction(var13, var12)));
                           return;
                        }

                        var4 = false;
                        int var18;
                        if (!Minecraft.getMinecraft().player.onGround && !var2) {
                           if (!(Boolean)this.field_1571.c()) {
                              this.field_1579 = (var18 = this.field_1579) + 1;
                              if (var18 <= ((Number)this.field_1572.c()).intValue()) {
                                 return;
                              }
                           }

                           if ((Boolean)this.field_1573.c()) {
                              f0b.field_2415.method_3667("elytraFlyAutoStart", f07.field_2303, 0.15F);
                           }

                           ++this.field_1581;
                           if (this.field_1581 >= ((Number)this.field_1576.c()).intValue()) {
                              this.field_1581 = 0;
                              var4 = false;
                              var25 = Minecraft.getMinecraft().getConnection();
                              if (var25 == null) {
                                 Intrinsics.throwNpe();
                              }

                              var20 = var25;
                              var4 = false;
                              var9 = Minecraft.getMinecraft();
                              var10001 = (Entity)var9.player;
                              Action var14 = Action.START_FALL_FLYING;
                              Entity var15 = var10001;
                              var20.sendPacket((Packet)(new CPacketEntityAction(var15, var14)));
                              return;
                           }
                        } else {
                           this.field_1581 = 0;
                           f0b.field_2415.method_3669("elytraFlyAutoStart");
                           if ((Boolean)this.field_1571.c()) {
                              var4 = false;
                              if (Minecraft.getMinecraft().player.onGround) {
                                 var4 = false;
                                 Minecraft.getMinecraft().player.jump();
                              }
                           }

                           var4 = false;
                           if (!Minecraft.getMinecraft().player.onGround && var2) {
                              this.field_1579 = (var18 = this.field_1579) + 1;
                              if (var18 > ((Number)this.field_1572.c()).intValue()) {
                                 f0b.field_2415.method_3667("elytraFlyAutoStart", f07.field_2303, 2.0F);
                                 return;
                              }
                           }

                           f0b.field_2415.method_3669("elytraFlyAutoStart");
                        }

                        return;
                     }
                  }

                  this.field_1579 = 0;
                  f0b.field_2415.method_3669("elytraFlyAutoStart");
                  return;
               }
            } else {
               this.field_1581 = 0;
               this.field_1579 = 0;
               f0b.field_2415.method_3669("elytraFlyAutoStart");
            }
         }
      }

   }

   // $FF: renamed from: 9 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_2776() {
      return this.field_1572;
   }

   // $FF: renamed from: k () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_2777() {
      return this.field_1576;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2778() {
      return this.field_1562;
   }

   // $FF: renamed from: 0 (int) void
   public void method_2779(int var1) {
      this.field_1579 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2780() {
      return this.field_1559;
   }

   // $FF: renamed from: j () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2781() {
      return this.field_1569;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2782() {
      return this.field_1573;
   }

   // $FF: renamed from: g () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2783() {
      return this.field_1574;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p, double, float) void
   public void method_2784(@NotNull f4p var1, double var2, float var4) {
      float var5 = var4;
      double var6 = (double)fec.method_1760().moveForward;
      double var8 = (double)fec.method_1760().moveStrafe;
      if (var6 == 0.0D && var8 == 0.0D) {
         var1.method_3125(0.0D);
         var1.method_3127(0.0D);
      } else {
         if (var6 != 0.0D) {
            if (var8 > 0.0D) {
               var5 = var4 + (float)(var6 > 0.0D ? -45 : 45);
            } else if (var8 < 0.0D) {
               var5 = var4 + (float)(var6 > 0.0D ? 45 : -45);
            }

            var8 = 0.0D;
            if (var6 > 0.0D) {
               var6 = 1.0D;
            } else if (var6 < 0.0D) {
               var6 = -1.0D;
            }
         }

         var1.method_3125(var6 * var2 * Math.cos(Math.toRadians((double)var5 + (double)90.0F)) + var8 * var2 * Math.sin(Math.toRadians((double)var5 + (double)90.0F)));
         var1.method_3127(var6 * var2 * Math.sin(Math.toRadians((double)var5 + (double)90.0F)) - var8 * var2 * Math.cos(Math.toRadians((double)var5 + (double)90.0F)));
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4E) void
   @f0g
   @LauncherEventHide
   public void method_2785(@NotNull f4E var1) {
      boolean var3 = false;
      if (Minecraft.getMinecraft().player.isElytraFlying() && (Boolean)this.field_1566.c() && (Boolean)this.field_1569.c()) {
         boolean var5 = false;
         Minecraft var13 = Minecraft.getMinecraft();
         double var10000 = (double)(new ScaledResolution(var13)).getScaledHeight() / 2.0D;
         double var4 = 50.0D;
         double var6 = -50.0D;
         double var11 = var10000;
         boolean var9 = false;
         var13 = Minecraft.getMinecraft();
         double var8 = (double)MathHelper.wrapDegrees(var13.player.rotationPitch) - ((Number)this.field_1567.c()).doubleValue();
         boolean var10 = false;
         double var19 = Math.max(var6, var8);
         boolean var17 = false;
         var19 = Math.min(var4, var19);
         double var2 = var11 - var19;
         GlStateManager.pushMatrix();
         GlStateManager.translate(0.0D, var2, 0.0D);
         byte var12 = 0;
         byte var18 = 0;
         var5 = false;
         var13 = Minecraft.getMinecraft();
         byte var14 = 1;
         int var20 = var13.displayWidth;
         var5 = false;
         Minecraft var15 = Minecraft.getMinecraft();
         Gui.drawRect(var18, var12, var20, var14, (double)MathHelper.wrapDegrees(var15.player.rotationPitch) >= ((Number)this.field_1567.c()).doubleValue() ? (new Color(255, 0, 0, 100)).getRGB() : (new Color(0, 255, 0, 100)).getRGB());
         GlStateManager.popMatrix();
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g
   @LauncherEventHide
   public void method_2786(@NotNull f4p var1) {
      // $FF: Couldn't be decompiled
   }
}
