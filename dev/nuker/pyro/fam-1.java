/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import java.util.Random;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fam extends faj {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1501 = new DoubleSetting("horizontalSpeed", "Horizontal", "Maximum speed to go horizontally", 50.0D, 0.0D, 50.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1502 = new DoubleSetting("downSpeed", "Down", "Maximum speed to go down", 1.5D, 0.0D, 5.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1503 = new BooleanSetting("autoAccelerate", "AutoAccelerate", "Automatically accelerates your speed", true);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1504 = new BooleanSetting("stopOnGround", "StopOnGround", "Stops when you are on the ground", true);
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1505 = new BooleanSetting("antiKick", "AntiKick", "Prevents you from getting kicked while not moving", true);
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1506 = new BooleanSetting("infDurability", "InfiniteDurability", "Prevents you from taking durability loss", true);
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1507 = new BooleanSetting("ncpStrict", "NCPStrict", "Allows packet elytra to work on servers with a strict NCP config", false);
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1508 = new BooleanSetting("useTimer", "UseTimer", "Automatically enables timer while flying", true);
   // $FF: renamed from: 1 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1509 = new DoubleSetting("multiplier", "Multiplier", "Tick multiplier while flying", 1.07D, 1.0D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1510 = new BooleanSetting("ignoreStill", "WhileMoving", "Disables Timer unless you are actually moving", true);
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1511 = new BooleanSetting("spoofRotations", "Rotations", "Spoofs rotations sent to the server to avoid anticheat issues", true);
   // $FF: renamed from: 7 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1512 = new BooleanSetting("spoofPitch", "Pitch", "Spoof the pitch sent to the server", true);
   // $FF: renamed from: 2 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1513 = new DoubleSetting("pitch", "Pitch", "The pitch to spoof to", 0.58D, -90.0D, 90.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: 3 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_1514 = new DoubleSetting("pitch", "Pitch", "Pitch to ascend at", 40.0D, 0.0D, 90.0D, 0.0D, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_1515;
   // $FF: renamed from: c double
   public double field_1516;
   // $FF: renamed from: c boolean
   public boolean field_1517;
   // $FF: renamed from: 0 boolean
   public boolean field_1518;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_1519;
   // $FF: renamed from: c int
   public int field_1520;
   // $FF: renamed from: c java.util.Random
   @NotNull
   public Random field_1521;
   // $FF: renamed from: c float
   public float field_1522;
   // $FF: renamed from: 0 float
   public float field_1523;
   // $FF: renamed from: 1 float
   public float field_1524;
   // $FF: renamed from: 0 int
   public int field_1525;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d field_1526;

   // $FF: renamed from: c (float, float) net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_2674(float var1, float var2) {
      float var3 = MathHelper.cos(-var2 * 0.017453292F - (float)3.141592653589793D);
      float var4 = MathHelper.sin(-var2 * 0.017453292F - (float)3.141592653589793D);
      float var5 = -MathHelper.cos(-var1 * 0.017453292F);
      float var6 = MathHelper.sin(-var1 * 0.017453292F);
      return new Vec3d((double)(var4 * var5), (double)var6, (double)(var3 * var5));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4m) void
   @f0g
   @LauncherEventHide
   public void method_2675(@NotNull f4m var1) {
      boolean var3 = false;
      if (!Minecraft.getMinecraft().player.movementInput.jump) {
         var1.0();
         this.field_1517 = var1.method_3145();
         var1.method_3146(false);
      }
   }

   // $FF: renamed from: 1 () java.util.List
   @NotNull
   public List method_2673() {
      return this.field_1515;
   }

   // $FF: renamed from: g () boolean
   public boolean method_2676() {
      return this.field_1518;
   }

   // $FF: renamed from: l () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_2677() {
      return this.field_1519;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_2678(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketPlayerPosLook) {
         boolean var3 = false;
         if (Minecraft.getMinecraft().player != null) {
            var3 = false;
            if (Intrinsics.areEqual((Object)Minecraft.getMinecraft().player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem(), (Object)Items.ELYTRA) ^ true) {
               return;
            }

            this.field_1518 = true;
         }
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2679() {
      return this.field_1504;
   }

   // $FF: renamed from: i () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2680() {
      return this.field_1506;
   }

   // $FF: renamed from: 4 () java.util.Random
   @NotNull
   public Random method_2681() {
      return this.field_1521;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(5)
   @LauncherEventHide
   public void method_2682(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         boolean var3 = false;
         if (!Minecraft.getMinecraft().player.onGround || !(Boolean)this.field_1504.c()) {
            if ((Boolean)this.field_1506.c() || !this.field_1517) {
               var3 = false;
               NetHandlerPlayClient var10000 = Minecraft.getMinecraft().getConnection();
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               NetHandlerPlayClient var4 = var10000;
               var3 = false;
               Minecraft var7 = Minecraft.getMinecraft();
               Entity var10001 = (Entity)var7.player;
               Action var8 = Action.START_FALL_FLYING;
               Entity var9 = var10001;
               var4.sendPacket((Packet)(new CPacketEntityAction(var9, var8)));
            }

            if ((Boolean)this.field_1511.c()) {
               if (var1.c() == f41.field_2120) {
                  if ((Boolean)this.field_1512.c() && this.field_1523 != -1337.0F) {
                     var1.0();
                     var1.method_3140(this.field_1523);
                  }
               } else {
                  this.field_1523 = -1337.0F;
                  this.field_1524 = -1337.0F;
               }
            }
         }
      }

   }

   // $FF: renamed from: 3 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2683() {
      return this.field_1514;
   }

   // $FF: renamed from: 8 () int
   public int method_2684() {
      return this.field_1520;
   }

   // $FF: renamed from: 0 (float) void
   public void method_2685(float var1) {
      this.field_1524 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4s) void
   @f0g
   @LauncherEventHide
   public void method_2686(@NotNull f4s var1) {
      boolean var3 = false;
      if (Minecraft.getMinecraft().player.isElytraFlying()) {
         var3 = false;
         if (Minecraft.getMinecraft().player.movementInput.jump) {
            double var2 = (double)fec.method_1760().moveForward;
            double var4 = (double)fec.method_1760().moveStrafe;
            boolean var7 = false;
            if (Minecraft.getMinecraft().player.movementInput.jump && (var2 != 0.0D || var4 != 0.0D)) {
               this.field_1523 = -((float)((Number)this.field_1514.c()).doubleValue());
               float var6 = fec.method_1761();
               if (var4 > 0.0D) {
                  var6 += (float)(var2 > 0.0D ? -45 : 45);
               } else if (var4 < 0.0D) {
                  var6 += (float)(var2 > 0.0D ? 45 : -45);
               }

               if (var2 < (double)0) {
                  var6 += (float)180;
               }

               Pyro.getRotationManager().method_3460(this.field_1523);
               Pyro.getRotationManager().method_3456(var6);
            }

            return;
         }
      }

      this.field_1523 = fec.method_1758() ? (float)((Number)this.field_1513.c()).doubleValue() : -1337.0F;
   }

   // $FF: renamed from: c (boolean) void
   public void method_2668(boolean var1) {
      f0b.field_2415.method_3669("elytraflyCreative");
   }

   // $FF: renamed from: o () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2687() {
      return this.field_1510;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2688() {
      return this.field_1505;
   }

   // $FF: renamed from: 1 (boolean) void
   public void method_2689(boolean var1) {
      this.field_1518 = var1;
   }

   // $FF: renamed from: n () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2690() {
      return this.field_1503;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p, float) void
   public void method_2691(@NotNull f4p var1, float var2) {
      double var3 = var1.method_3128();
      double var5 = var1.method_3119();
      double var7 = var1.method_3123();
      boolean var11 = false;
      float var9 = MathHelper.cos(-Minecraft.getMinecraft().player.rotationYaw * 0.017453292F - (float)3.141592653589793D);
      boolean var12 = false;
      float var10 = MathHelper.sin(-Minecraft.getMinecraft().player.rotationYaw * 0.017453292F - (float)3.141592653589793D);
      float var30 = -MathHelper.cos(-var2 * 0.017453292F);
      float var31 = MathHelper.sin(-var2 * 0.017453292F);
      Vec3d var13 = new Vec3d((double)(var10 * var30), (double)var31, (double)(var9 * var30));
      float var14 = var2 * 0.017453292F;
      double var17 = var13.x * var13.x + var13.z * var13.z;
      boolean var19 = false;
      double var15 = Math.sqrt(var17);
      var17 = var13.lengthVector();
      float var32 = MathHelper.cos(var14);
      var32 = (float)((double)var32 * (double)var32 * Math.min(1.0D, var17 / 0.4D));
      boolean var21 = false;
      EntityPlayerSP var10000 = Minecraft.getMinecraft().player;
      var10000.motionY += -0.08D + (double)var32 * 0.06D;
      var21 = false;
      double var20;
      if (Minecraft.getMinecraft().player.motionY < 0.0D && var15 > 0.0D) {
         boolean var23 = false;
         var20 = Minecraft.getMinecraft().player.motionY * -0.1D * (double)var32;
         var23 = false;
         var10000 = Minecraft.getMinecraft().player;
         var10000.motionY += var20;
         var23 = false;
         var10000 = Minecraft.getMinecraft().player;
         var10000.motionX += var13.x * var20 / var15;
         var23 = false;
         var10000 = Minecraft.getMinecraft().player;
         var10000.motionZ += var13.z * var20 / var15;
      }

      if (var14 < 0.0F) {
         var20 = (double)fec.method_1764() * (double)(-MathHelper.sin(var14)) * 0.04D;
         var5 += var20 * 3.2D;
         var3 -= var13.x * var20 / var15;
         var7 -= var13.z * var20 / var15;
      }

      if (var15 > 0.0D) {
         var21 = false;
         var10000 = Minecraft.getMinecraft().player;
         double var10001 = var10000.motionX;
         double var27 = var13.x / var15 * (double)fec.method_1764();
         double var25 = var10001;
         EntityPlayerSP var24 = var10000;
         var21 = false;
         Minecraft var29 = Minecraft.getMinecraft();
         var24.motionX = var25 + (var27 - var29.player.motionX) * 0.1D;
         var21 = false;
         var10000 = Minecraft.getMinecraft().player;
         var10001 = var10000.motionZ;
         var27 = var13.z / var15 * (double)fec.method_1764();
         var25 = var10001;
         var24 = var10000;
         var21 = false;
         var29 = Minecraft.getMinecraft();
         var24.motionZ = var25 + (var27 - var29.player.motionZ) * 0.1D;
      }

      var3 *= 0.9900000095367432D;
      var5 *= 0.9800000190734863D;
      var7 *= 0.9900000095367432D;
      var21 = false;
      Minecraft.getMinecraft().player.motionX = var3;
      var21 = false;
      Minecraft.getMinecraft().player.motionY = var5;
      var21 = false;
      Minecraft.getMinecraft().player.motionZ = var7;
      var1.method_3125(var3);
      var1.method_3120(var5);
      var1.method_3127(var7);
   }

   // $FF: renamed from: k () int
   public int method_2692() {
      return this.field_1525;
   }

   // $FF: renamed from: b () float
   public float method_2693() {
      return this.field_1522;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2694() {
      return this.field_1513;
   }

   // $FF: renamed from: c (float) void
   public void method_2695(float var1) {
      this.field_1522 = var1;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2696() {
      return this.field_1512;
   }

   // $FF: renamed from: a () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2697() {
      return this.field_1502;
   }

   // $FF: renamed from: m () float
   public float method_2698() {
      return this.field_1523;
   }

   // $FF: renamed from: f () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2699() {
      return this.field_1501;
   }

   // $FF: renamed from: d () double
   public double method_2700() {
      return this.field_1516;
   }

   // $FF: renamed from: e () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2701() {
      return this.field_1507;
   }

   // $FF: renamed from: c (int) void
   public void method_2702(int var1) {
      this.field_1525 = var1;
   }

   // $FF: renamed from: c (double) void
   public void method_2703(double var1) {
      this.field_1516 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2704() {
      return this.field_1511;
   }

   public fam(@NotNull f9h var1) {
      super(var1, "creative", "Creative");
      this.field_1515 = CollectionsKt.listOf(new f0w[]{(f0w)(new f0t((f0w)(new f0n("speed", "Speed", (String)null)), new f0w[]{(f0w)this.field_1501, (f0w)this.field_1502})), (f0w)this.field_1503, (f0w)this.field_1504, (f0w)this.field_1505, (f0w)this.field_1506, (f0w)this.field_1507, (f0w)(new f0t((f0w)this.field_1511, new f0w[]{(f0w)(new f0t((f0w)this.field_1512, new f0w[]{(f0w)this.field_1513})), (f0w)this.field_1514})), (f0w)(new f0t((f0w)this.field_1508, new f0w[]{(f0w)this.field_1509, (f0w)this.field_1510}))});
      this.field_1519 = new fe8();
      this.field_1521 = new Random();
      this.field_1522 = 1337.0F;
      this.field_1523 = -1337.0F;
      this.field_1524 = -1337.0F;
   }

   // $FF: renamed from: 0 (int) void
   public void method_2705(int var1) {
      this.field_1520 = var1;
   }

   // $FF: renamed from: 1 (float) void
   public void method_2706(float var1) {
      this.field_1523 = var1;
   }

   // $FF: renamed from: c (java.util.Random) void
   public void method_2707(@NotNull Random var1) {
      this.field_1521 = var1;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_2708() {
      return this.field_1509;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_2709() {
      return this.field_1508;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g(5)
   @LauncherEventHide
   public void method_2710(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120) {
         boolean var3 = false;
         if (Intrinsics.areEqual((Object)Minecraft.getMinecraft().player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem(), (Object)Items.ELYTRA) ^ true) {
            return;
         }

         var3 = false;
         if (!ItemElytra.isUsable(Minecraft.getMinecraft().player.getItemStackFromSlot(EntityEquipmentSlot.CHEST))) {
            return;
         }

         var3 = false;
         if (!Minecraft.getMinecraft().player.onGround || !(Boolean)this.field_1504.c()) {
            if ((Boolean)this.field_1503.c()) {
               if (this.field_1518) {
                  this.field_1516 = 1.0D;
                  this.field_1518 = false;
               }

               if (this.field_1516 < ((Number)this.field_1501.c()).doubleValue()) {
                  this.field_1516 += 0.1D;
               }

               if (this.field_1516 - 0.1D > ((Number)this.field_1501.c()).doubleValue()) {
                  this.field_1516 -= 0.1D;
               }
            } else {
               if (this.field_1518) {
                  this.field_1516 = 1.0D;
                  this.field_1518 = false;
               }

               this.field_1516 = ((Number)this.field_1501.c()).doubleValue();
            }

            label626: {
               if (!fec.method_1752()) {
                  var3 = false;
                  if (!Minecraft.getMinecraft().player.collided && (Boolean)this.field_1505.c()) {
                     if (this.field_1519.method_1980(1000.0D)) {
                        this.field_1518 = true;
                        int var10001 = this.field_1520++;
                        var3 = false;
                        EntityPlayerSP var10000 = Minecraft.getMinecraft().player;
                        var10000.motionX += 0.03D * (double)MathHelper.sin((float)Math.toRadians((double)(this.field_1520 * 4)));
                        var3 = false;
                        var10000 = Minecraft.getMinecraft().player;
                        var10000.motionZ += 0.03D * (double)MathHelper.cos((float)Math.toRadians((double)(this.field_1520 * 4)));
                        var3 = false;
                        Minecraft var7 = Minecraft.getMinecraft();
                        var1.method_3125(var7.player.motionX);
                        var3 = false;
                        var7 = Minecraft.getMinecraft();
                        var1.method_3127(var7.player.motionZ);
                        var1.method_3120(-1.0E-8D);
                        var1.0();
                        if (this.field_1520 > 360) {
                           this.field_1520 = 0;
                        }

                        return;
                     }
                     break label626;
                  }
               }

               this.field_1519.method_1979();
            }

            var3 = false;
            double var2;
            if (Minecraft.getMinecraft().player.movementInput.jump) {
               if ((double)fec.method_1764() <= 1.0D) {
                  var2 = this.field_1516;
                  if (this.field_1518) {
                     var2 = 0.5D;
                  }

                  boolean var5;
                  if ((Boolean)this.field_1507.c()) {
                     fec.method_1774(var1, var2);
                     var1.method_3120(-1.0E-8D);
                     var5 = false;
                     Minecraft.getMinecraft().player.motionY = var1.method_3119();
                  } else {
                     var1.method_3125(var1.method_3128() * var2);
                     var1.method_3127(var1.method_3123() * var2);
                  }

                  var5 = false;
                  Minecraft.getMinecraft().player.motionX = var1.method_3128();
                  var5 = false;
                  Minecraft.getMinecraft().player.motionZ = var1.method_3123();
                  var1.0();
               }

               return;
            }

            var3 = false;
            if (Minecraft.getMinecraft().player.movementInput.sneak) {
               var1.method_3120(-((Number)this.field_1502.c()).doubleValue());
               var3 = false;
               Minecraft.getMinecraft().player.motionY = var1.method_3119();
            } else if ((Boolean)this.field_1507.c() && fec.method_1758()) {
               var1.method_3120(-1.0E-8D);
               var3 = false;
               Minecraft.getMinecraft().player.motionY = var1.method_3119();
            } else {
               var1.method_3120(0.0D);
               var3 = false;
               Minecraft.getMinecraft().player.motionY = var1.method_3119();
            }

            var2 = this.field_1516;
            if (this.field_1518) {
               var2 = 0.5D;
            }

            if ((Boolean)this.field_1507.c()) {
               fec.method_1774(var1, var2);
            } else {
               var1.method_3125(var1.method_3128() * var2);
               var1.method_3127(var1.method_3123() * var2);
            }

            var1.0();
         }

         fak var8 = new fak(this);
         fal var9 = fal.field_48;
         if ((Boolean)this.field_1508.c()) {
            if ((Boolean)this.field_1510.c()) {
               if (var1.method_3128() == 0.0D && var1.method_3123() == 0.0D) {
                  var9.method_91();
               } else {
                  var8.method_94();
               }
            } else {
               var9.method_91();
            }
         } else {
            var9.method_91();
         }
      }

   }

   // $FF: renamed from: h () net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d method_2711() {
      return this.field_1526;
   }

   // $FF: renamed from: j () boolean
   public boolean method_2712() {
      return this.field_1517;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d) void
   public void method_2713(@Nullable Vec3d var1) {
      this.field_1526 = var1;
   }

   // $FF: renamed from: 5 () float
   public float method_2714() {
      return this.field_1524;
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_2715(boolean var1) {
      this.field_1517 = var1;
   }
}
