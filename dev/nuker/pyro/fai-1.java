/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fai extends faj {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1527 = new DoubleSetting("horizontalSpeed", "Horizontal", "Maximum speed to go horizontally", 1.8D, 0.0D, 5.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1528 = new DoubleSetting("downSpeed", "Down", "Maximum speed to go down", 1.5D, 0.0D, 5.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1529 = new BooleanSetting("timer", "Timer", "Automatically enables timer while flying", true);
   // $FF: renamed from: 1 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1530 = new DoubleSetting("multiplier", "Multiplier", "Tick multiplier while flying", 1.07D, 1.0D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1531 = new BooleanSetting("ignoreStill", "WhileMoving", "Disables Timer unless you are actually moving", true);
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1532 = new BooleanSetting("spoofRotations", "Rotations", "Spoofs rotations sent to the server to avoid anticheat issues", true);
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1533 = new BooleanSetting("spoofPitch", "Pitch", "Spoof the pitch sent to the server", true);
   // $FF: renamed from: 2 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1534 = new DoubleSetting("pitch", "Pitch", "The pitch to spoof to", 0.58D, -90.0D, 90.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1535 = new BooleanSetting("spoofYaw", "Yaw", "Spoof the yaw sent to the server", true);
   // $FF: renamed from: 3 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1536 = new DoubleSetting("pitch", "Pitch", "Pitch to ascend at", 40.0D, 0.0D, 90.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c dev.nuker.pyro.f0z
   @NotNull
   public f0z field_1537;
   // $FF: renamed from: 4 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1538;
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1539;
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1540;
   // $FF: renamed from: 5 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1541;
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1542;
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1543;
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_1544;
   // $FF: renamed from: 8 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1545;
   // $FF: renamed from: 6 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1546;
   // $FF: renamed from: 9 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1547;
   // $FF: renamed from: 0 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_1548;
   // $FF: renamed from: 7 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1549;
   // $FF: renamed from: 8 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1550;
   // $FF: renamed from: 0 dev.nuker.pyro.f0z
   @NotNull
   public f0z field_1551;
   // $FF: renamed from: c float
   public float field_1552;
   // $FF: renamed from: 0 float
   public float field_1553;
   // $FF: renamed from: c int
   public int field_1554;
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_1555;
   // $FF: renamed from: 0 int
   public int field_1556;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d field_1557;
   // $FF: renamed from: 1 int
   public int field_1558;

   // $FF: renamed from: c (int) void
   public void method_2716(int var1) {
      this.field_1556 = var1;
   }

   // $FF: renamed from: a () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_2717() {
      return this.field_1544;
   }

   // $FF: renamed from: o () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2718() {
      return this.field_1536;
   }

   // $FF: renamed from: q () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2719() {
      return this.field_1534;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2720() {
      return this.field_1532;
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2721() {
      return this.field_1549;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2722() {
      return this.field_1531;
   }

   // $FF: renamed from: i () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2723() {
      return this.field_1550;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d) void
   public void method_2724(@Nullable Vec3d var1) {
      this.field_1557 = var1;
   }

   // $FF: renamed from: 5 () float
   public float method_2725() {
      return this.field_1553;
   }

   // $FF: renamed from: e () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2726() {
      return this.field_1540;
   }

   // $FF: renamed from: 3 () net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d method_2727() {
      return this.field_1557;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4s) void
   @f0g
   @LauncherEventHide
   public void method_2728(@NotNull f4s var1) {
      boolean var3 = false;
      if (Minecraft.getMinecraft().player.isElytraFlying()) {
         double var2 = (double)fec.method_1760().moveForward;
         double var4 = (double)fec.method_1760().moveStrafe;
         boolean var7 = false;
         if (Minecraft.getMinecraft().player.movementInput.jump && (fab)this.field_1537.method_3334().c() == fab.field_1582 && (var2 != 0.0D || var4 != 0.0D)) {
            this.field_1552 = -((float)((Number)this.field_1536.c()).doubleValue());
            float var6 = fec.method_1761();
            if (var4 > 0.0D) {
               var6 += (float)(var2 >= 0.0D ? -45 : 45);
            } else if (var4 < 0.0D) {
               var6 += (float)(var2 >= 0.0D ? 45 : -45);
            }

            if (var2 < (double)0) {
               var6 += (float)180;
            }

            Pyro.getRotationManager().method_3460(this.field_1552);
            Pyro.getRotationManager().method_3456(var6);
         }
      }

   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2729() {
      return this.field_1543;
   }

   // $FF: renamed from: s () dev.nuker.pyro.f0z
   @NotNull
   public f0z method_2730() {
      return this.field_1551;
   }

   // $FF: renamed from: 1 (int) void
   public void method_2731(int var1) {
      this.field_1554 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g
   @LauncherEventHide
   public void method_2732(@NotNull f4p var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: h () dev.nuker.pyro.f0z
   @NotNull
   public f0z method_2733() {
      return this.field_1537;
   }

   // $FF: renamed from: 0 (int) void
   public void method_2734(int var1) {
      this.field_1558 = var1;
   }

   // $FF: renamed from: 0 () int
   public int method_2735() {
      return this.field_1558;
   }

   // $FF: renamed from: 9 () float
   public float method_2736() {
      return this.field_1552;
   }

   // $FF: renamed from: m () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2737() {
      return this.field_1542;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2738() {
      return this.field_1546;
   }

   // $FF: renamed from: f () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2739() {
      return this.field_1538;
   }

   // $FF: renamed from: k () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2740() {
      return this.field_1530;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p, double, float) void
   public void method_2741(@NotNull f4p var1, double var2, float var4) {
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
         this.field_1553 = var5;
      }

   }

   // $FF: renamed from: n () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2742() {
      return this.field_1541;
   }

   // $FF: renamed from: t () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2743() {
      return this.field_1535;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_2744(@NotNull f4u var1) {
      label736: {
         if (var1.c() == f41.field_2120) {
            if (!(Boolean)this.field_1542.c()) {
               this.field_1558 = 0;
               this.field_1554 = 0;
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
                     if ((Boolean)this.field_1547.c()) {
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
                     label720: {
                        if (((Number)this.field_1546.c()).doubleValue() != 0.0D) {
                           var4 = false;
                           WorldClient var10000 = Minecraft.getMinecraft().world;
                           if (var10000 == null) {
                              Intrinsics.throwNpe();
                           }

                           WorldClient var6 = var10000;
                           var4 = false;
                           var7 = Minecraft.getMinecraft();
                           if (var6.collidesWithAnyBlock(var7.player.getEntityBoundingBox().expand(0.0D, -((Number)this.field_1546.c()).doubleValue(), 0.0D))) {
                              var24 = true;
                              break label720;
                           }
                        }

                        var24 = false;
                     }

                     boolean var2 = var24;
                     if (!(Boolean)this.field_1543.c()) {
                        var4 = false;
                        if (!Minecraft.getMinecraft().player.movementInput.jump) {
                           break label736;
                        }
                     }

                     var4 = false;
                     if (Minecraft.getMinecraft().player.capabilities.isFlying) {
                        break label736;
                     }

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
                        label732: {
                           if (!(Boolean)this.field_1543.c()) {
                              this.field_1554 = (var18 = this.field_1554) + 1;
                              if (var18 <= ((Number)this.field_1544.c()).intValue()) {
                                 break label732;
                              }
                           }

                           if ((Boolean)this.field_1545.c()) {
                              f0b.field_2415.method_3667("elytraFlyAutoStart", f07.field_2303, 0.15F);
                           }

                           ++this.field_1558;
                           if (this.field_1558 >= ((Number)this.field_1548.c()).intValue()) {
                              this.field_1558 = 0;
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
                           }
                        }
                     } else {
                        label737: {
                           this.field_1558 = 0;
                           f0b.field_2415.method_3669("elytraFlyAutoStart");
                           if ((Boolean)this.field_1543.c()) {
                              var4 = false;
                              if (Minecraft.getMinecraft().player.onGround) {
                                 var4 = false;
                                 Minecraft.getMinecraft().player.jump();
                              }
                           }

                           var4 = false;
                           if (!Minecraft.getMinecraft().player.onGround && var2) {
                              this.field_1554 = (var18 = this.field_1554) + 1;
                              if (var18 > ((Number)this.field_1544.c()).intValue()) {
                                 f0b.field_2415.method_3667("elytraFlyAutoStart", f07.field_2303, 2.0F);
                                 break label737;
                              }
                           }

                           f0b.field_2415.method_3669("elytraFlyAutoStart");
                        }
                     }
                  }
               } else {
                  this.field_1558 = 0;
                  this.field_1554 = 0;
                  f0b.field_2415.method_3669("elytraFlyAutoStart");
               }
            }
         }

         if ((Boolean)this.field_1532.c()) {
            if (var1.c() == f41.field_2120) {
               if ((Boolean)this.field_1533.c() && this.field_1552 != -1337.0F) {
                  var1.0();
                  var1.method_3140(this.field_1552);
               }

               if ((Boolean)this.field_1535.c() && this.field_1553 != -1337.0F) {
                  var1.0();
                  var1.method_3139(this.field_1553);
               }
            } else {
               this.field_1552 = -1337.0F;
               this.field_1553 = -1337.0F;
            }
         }

         return;
      }

      this.field_1554 = 0;
      f0b.field_2415.method_3669("elytraFlyAutoStart");
   }

   // $FF: renamed from: b () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2745() {
      return this.field_1539;
   }

   // $FF: renamed from: 1 () java.util.List
   @NotNull
   public List method_2673() {
      return this.field_1555;
   }

   // $FF: renamed from: u () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2746() {
      return this.field_1533;
   }

   // $FF: renamed from: c (float) void
   public void method_2747(float var1) {
      this.field_1553 = var1;
   }

   // $FF: renamed from: d () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_2748() {
      return this.field_1548;
   }

   // $FF: renamed from: j () int
   public int method_2749() {
      return this.field_1554;
   }

   // $FF: renamed from: c (boolean) void
   public void method_2668(boolean var1) {
      String var2 = "Enabled: " + var1;
      boolean var3 = false;
      System.out.println(var2);
      f0b.field_2415.method_3669("elytraflyCreative");
      f0b.field_2415.method_3669("elytraFlyAutoStart");
   }

   // $FF: renamed from: g () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2750() {
      return this.field_1547;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2751() {
      return this.field_1545;
   }

   // $FF: renamed from: l () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2752() {
      return this.field_1528;
   }

   // $FF: renamed from: r () int
   public int method_2753() {
      return this.field_1556;
   }

   // $FF: renamed from: 0 (float) void
   public void method_2754(float var1) {
      this.field_1552 = var1;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2755() {
      return this.field_1529;
   }

   // $FF: renamed from: p () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2756() {
      return this.field_1527;
   }

   public fai(@NotNull f9h var1) {
      super(var1, "creative", "Creative");
      this.field_1537 = new f0z("ascension", "Ascension", "The method to use to go up", (Enum)fab.field_1582, new List[]{CollectionsKt.listOf(this.field_1536)});
      this.field_1538 = new DoubleSetting("fallSpeed", "GlideSpeed", "Speed to fall/glide at", 1.0D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_1539 = new BooleanSetting("ignoreStill", "WhileMoving", "Stops falling when you aren't moving", true);
      this.field_1540 = new BooleanSetting("autoAccelerate", "AutoAccelerate", "Automatically accelerates you when you are holding space", true);
      this.field_1541 = new DoubleSetting("requiredSpeed", "RequiredSpeed", "The speed required to accelerate", 0.7D, 0.2D, 1.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_1542 = new BooleanSetting("autoStart", "AutoStart", "Automatically starts the elytra fly off ground", true);
      this.field_1543 = new BooleanSetting("autoJump", "AutoJump", "Automatically jumps on ground", true);
      this.field_1544 = new IntegerSetting("waitTicks", "WaitTicks", "The number of ticks to wait after you jump before starting", 20, 0, 60, 0, 64, (DefaultConstructorMarker)null);
      this.field_1545 = new BooleanSetting("autoStartTimer", "UseTimer", "Slows down the game speed to allow you to fly easier", true);
      this.field_1546 = new DoubleSetting("minStartHeight", "MinHeight", "Minimum height to start at", 0.5D, 0.0D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_1547 = new BooleanSetting("InWater", "InLiquid", "Sends the fly packet in Liquid", true);
      this.field_1548 = new IntegerSetting("startTicks", "StartTicks", "The number of ticks after offground to try to fly at", 4, 1, 5, 0, 64, (DefaultConstructorMarker)null);
      this.field_1549 = new DoubleSetting("pitch", "Pitch", "The pitch to use while going up", 0.0D, 0.0D, 90.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_1550 = new DoubleSetting("range", "Range", "Approx area to cover while going up (more = better)", 5.0D, 0.0D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      Enum var10004 = (Enum)fad.field_1599;
      List[] var10005 = new List[3];
      byte var12 = 0;
      List[] var11 = var10005;
      List[] var10 = var10005;
      Enum var9 = var10004;
      String var8 = "Attempts to go directly upwards when only holding space";
      String var7 = "StraightUp";
      String var6 = "straightUp";
      boolean var2 = false;
      List var13 = CollectionsKt.emptyList();
      var11[var12] = var13;
      var10[1] = CollectionsKt.listOf(new DoubleSetting[]{this.field_1549, this.field_1550});
      var12 = 2;
      var2 = false;
      var13 = CollectionsKt.emptyList();
      var10[var12] = var13;
      this.field_1551 = new f0z(var6, var7, var8, var9, var10);
      this.field_1552 = -1337.0F;
      this.field_1553 = -1337.0F;
      this.field_1555 = CollectionsKt.listOf(new f0w[]{(f0w)this.field_1537, (f0w)this.field_1551, (f0w)(new f0t((f0w)(new f0n("speed", "Speed", (String)null)), new f0w[]{(f0w)this.field_1527, (f0w)this.field_1528, (f0w)(new f0t((f0w)this.field_1529, new f0w[]{(f0w)this.field_1530, (f0w)this.field_1531}))})), (f0w)(new f0t((f0w)this.field_1532, new f0w[]{(f0w)(new f0t((f0w)this.field_1533, new f0w[]{(f0w)this.field_1534})), (f0w)this.field_1535})), (f0w)(new f0t((f0w)this.field_1538, new f0w[]{(f0w)this.field_1539})), (f0w)(new f0t((f0w)this.field_1540, new f0w[]{(f0w)this.field_1541})), (f0w)(new f0t((f0w)this.field_1542, new f0w[]{(f0w)this.field_1543, (f0w)this.field_1546, (f0w)this.field_1544, (f0w)this.field_1545, (f0w)this.field_1547, (f0w)this.field_1548}))});
   }
}
