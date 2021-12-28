/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemElytra
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f07;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0n;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f0z;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4s;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f9h;
import dev.nuker.pyro.fab;
import dev.nuker.pyro.fad;
import dev.nuker.pyro.fae;
import dev.nuker.pyro.faf;
import dev.nuker.pyro.fag;
import dev.nuker.pyro.fah;
import dev.nuker.pyro.faj;
import dev.nuker.pyro.far;
import dev.nuker.pyro.fdU;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fai
extends faj {
    @NotNull
    public DoubleSetting Field1822 = new DoubleSetting("horizontalSpeed", "Horizontal", "Maximum speed to go horizontally", 1.8, 0.0, 5.0, 0.0, 64, null);
    @NotNull
    public DoubleSetting Field1823 = new DoubleSetting("downSpeed", "Down", "Maximum speed to go down", 1.5, 0.0, 5.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field1824 = new BooleanSetting("timer", "Timer", "Automatically enables timer while flying", true);
    @NotNull
    public DoubleSetting Field1825 = new DoubleSetting("multiplier", "Multiplier", "Tick multiplier while flying", 1.07, 1.0, 2.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field1826 = new BooleanSetting("ignoreStill", "WhileMoving", "Disables Timer unless you are actually moving", true);
    @NotNull
    public BooleanSetting Field1827 = new BooleanSetting("spoofRotations", "Rotations", "Spoofs rotations sent to the server to avoid anticheat issues", true);
    @NotNull
    public BooleanSetting Field1828 = new BooleanSetting("spoofPitch", "Pitch", "Spoof the pitch sent to the server", true);
    @NotNull
    public DoubleSetting Field1829 = new DoubleSetting("pitch", "Pitch", "The pitch to spoof to", 0.58, -90.0, 90.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field1830 = new BooleanSetting("spoofYaw", "Yaw", "Spoof the yaw sent to the server", true);
    @NotNull
    public DoubleSetting Field1831 = new DoubleSetting("pitch", "Pitch", "Pitch to ascend at", 40.0, 0.0, 90.0, 0.0, 64, null);
    @NotNull
    public f0z<fab> Field1832 = new f0z("ascension", "Ascension", "The method to use to go up", fab.Vanilla, new List[]{CollectionsKt.Method9007(this.Field1831)});
    @NotNull
    public DoubleSetting Field1833 = new DoubleSetting("fallSpeed", "GlideSpeed", "Speed to fall/glide at", 1.0, 0.0, 10.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field1834 = new BooleanSetting("ignoreStill", "WhileMoving", "Stops falling when you aren't moving", true);
    @NotNull
    public BooleanSetting Field1835 = new BooleanSetting("autoAccelerate", "AutoAccelerate", "Automatically accelerates you when you are holding space", true);
    @NotNull
    public DoubleSetting Field1836 = new DoubleSetting("requiredSpeed", "RequiredSpeed", "The speed required to accelerate", 0.7, 0.2, 1.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field1837 = new BooleanSetting("autoStart", "AutoStart", "Automatically starts the elytra fly off ground", true);
    @NotNull
    public BooleanSetting Field1838 = new BooleanSetting("autoJump", "AutoJump", "Automatically jumps on ground", true);
    @NotNull
    public IntegerSetting Field1839 = new IntegerSetting("waitTicks", "WaitTicks", "The number of ticks to wait after you jump before starting", 20, 0, 60, 0, 64, null);
    @NotNull
    public BooleanSetting Field1840 = new BooleanSetting("autoStartTimer", "UseTimer", "Slows down the game speed to allow you to fly easier", true);
    @NotNull
    public DoubleSetting Field1841 = new DoubleSetting("minStartHeight", "MinHeight", "Minimum height to start at", 0.5, 0.0, 2.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field1842 = new BooleanSetting("InWater", "InLiquid", "Sends the fly packet in Liquid", true);
    @NotNull
    public IntegerSetting Field1843 = new IntegerSetting("startTicks", "StartTicks", "The number of ticks after offground to try to fly at", 4, 1, 5, 0, 64, null);
    @NotNull
    public DoubleSetting Field1844 = new DoubleSetting("pitch", "Pitch", "The pitch to use while going up", 0.0, 0.0, 90.0, 0.0, 64, null);
    @NotNull
    public DoubleSetting Field1845 = new DoubleSetting("range", "Range", "Approx area to cover while going up (more = better)", 5.0, 0.0, 20.0, 0.0, 64, null);
    @NotNull
    public f0z<fad> Field1846;
    public float Field1847;
    public float Field1848;
    public int Field1849;
    @NotNull
    public List<f0w<?>> Field1850;
    public int Field1851;
    @Nullable
    public Vec3d Field1852;
    public int Field1853;

    public void Method2467(int n) {
        this.Field1851 = n;
    }

    @NotNull
    public IntegerSetting Method2512() {
        return this.Field1839;
    }

    @NotNull
    public DoubleSetting Method2513() {
        return this.Field1831;
    }

    @NotNull
    public DoubleSetting Method2514() {
        return this.Field1829;
    }

    @NotNull
    public BooleanSetting Method2515() {
        return this.Field1827;
    }

    @NotNull
    public DoubleSetting Method2477() {
        return this.Field1844;
    }

    @NotNull
    public BooleanSetting Method2456() {
        return this.Field1826;
    }

    @NotNull
    public DoubleSetting Method2516() {
        return this.Field1845;
    }

    public void Method2517(@Nullable Vec3d vec3d) {
        this.Field1852 = vec3d;
    }

    public float Method2518() {
        return this.Field1848;
    }

    @NotNull
    public BooleanSetting Method2519() {
        return this.Field1835;
    }

    @Nullable
    public Vec3d Method2520() {
        return this.Field1852;
    }

    @f0g
    @LauncherEventHide
    public void Method2521(@NotNull f4s f4s2) {
        fai fai2 = this;
        boolean bl = false;
        if (Minecraft.getMinecraft().player.isElytraFlying()) {
            double d = fec.Method729().moveForward;
            double d2 = fec.Method729().moveStrafe;
            fai fai3 = this;
            boolean bl2 = false;
            if (Minecraft.getMinecraft().player.movementInput.jump && (fab)((Object)this.Field1832.Method7991().Method7979()) == fab.Vanilla && (d != 0.0 || d2 != 0.0)) {
                this.Field1847 = -((float)((Number)this.Field1831.Method7979()).doubleValue());
                float f = fec.Method730();
                if (d2 > 0.0) {
                    f += (float)(d >= 0.0 ? -45 : 45);
                } else if (d2 < 0.0) {
                    f += (float)(d >= 0.0 ? 45 : -45);
                }
                if (d < 0.0) {
                    f += (float)180;
                }
                Pyro.Method8979().Method7542(this.Field1847);
                Pyro.Method8979().Method7538(f);
            }
        }
    }

    @NotNull
    public BooleanSetting Method2522() {
        return this.Field1838;
    }

    @NotNull
    public f0z Method2523() {
        return this.Field1846;
    }

    public void Method2524(int n) {
        this.Field1849 = n;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @f0g
    @LauncherEventHide
    public void Method2483(@NotNull f4p var1_1) {
        block23: {
            if (var1_1.Method5619() != f41.Pre) return;
            var2_2 = this;
            var3_4 = false;
            if (Minecraft.getMinecraft().player.isElytraFlying() == false) return;
            var2_3 = fec.Method729().moveForward;
            var4_5 = fec.Method729().moveStrafe;
            if ((fad)this.Field1846.Method7991().Method7979() == fad.Off) break block23;
            var6_6 = this;
            var7_9 = false;
            if (!Minecraft.getMinecraft().player.movementInput.jump || var2_3 != 0.0 || var4_5 != 0.0) break block23;
            if (this.Field1852 == null) {
                var6_6 = this;
                var14_13 = this;
                var7_9 = false;
                var15_14 = Minecraft.getMinecraft();
                var14_13.Field1852 = var15_14.player.getPositionVector();
            }
            switch (fae.Field1915[((fad)this.Field1846.Method7991().Method7979()).ordinal()]) {
                case 1: {
                    var6_6 = new Ref.DoubleRef();
                    var6_6.Field6986 = 0.0;
                    var7_10 = new Ref.FloatRef();
                    v0 = fdU.Field255.Method463();
                    v1 = this.Field1852;
                    if (v1 == null) {
                        Intrinsics.Method6551();
                    }
                    var7_10.Field5298 = v0.Method422((Vec3d)v1).x;
                    var8_15 = new faf(this, var1_1, (Ref.DoubleRef)var6_6, var7_10, var4_5);
                    var9_19 = this.Field1851;
                    var10_22 = var9_19;
                    if (0 <= var10_22 && 2 >= var10_22) {
                        var6_6.Field6986 = 1.5;
                        var1_1.Method5834(-0.01);
                        this.Field1847 = 0.0f;
                        Pyro.Method8979().Method7542(this.Field1847);
                        var8_15.Method2267();
                    } else {
                        var10_22 = var9_19;
                        if (3 <= var10_22 && 5 >= var10_22) {
                            this.Field1847 = -15.0f;
                            Pyro.Method8979().Method7542(0.0f);
                            v2 = var1_1;
                            v2.Method5834(v2.Method5815() + (0.08 - (double)this.Field1851 * 0.01));
                            var6_6.Field6986 = 1.0 - (double)this.Field1851 * 0.1;
                            var8_15.Method2267();
                        } else {
                            this.Field1851 = -1;
                            var1_1.Method7948();
                        }
                    }
                    var9_19 = this.Field1851;
                    var10_22 = 0;
                    System.out.println(var9_19);
                    var9_19 = this.Field1851;
                    this.Field1851 = var9_19 + 1;
                    return;
                }
                case 2: {
                    var6_7 = (double)fec.Method733() <= ((Number)this.Field1836.Method7979()).doubleValue();
                    v3 = fdU.Field255.Method463();
                    v4 = this.Field1852;
                    if (v4 == null) {
                        Intrinsics.Method6551();
                    }
                    var8_16 = this;
                    var15_14 = v4;
                    var14_13 = v3;
                    var9_20 = false;
                    var16_24 = Minecraft.getMinecraft();
                    var7_11 = var14_13.Method421((Vec3d)var15_14, (Vec3d)var16_24.player.getPositionVector()).x;
                    v5 = this.Field1852;
                    if (v5 == null) {
                        Intrinsics.Method6551();
                    }
                    var9_21 = fdU.Field255.Method463().Method422((Vec3d)(var8_16 = v5.add((Vec3d)new Vec3d((double)0.0, (double)0.0, (double)((Number)this.Field1845.Method7979()).doubleValue()).rotateYaw((float)((float)(-Math.toRadians((double)((double)var7_11 + (var6_7 ? 15.0 : 15.0))))))))).x;
                    this.Field1847 = -((float)((Number)this.Field1844.Method7979()).doubleValue());
                    this.Field1848 = var9_21;
                    Pyro.Method8979().Method7538(var9_21);
                    if (var6_7) {
                        var10_23 = ((Number)this.Field1822.Method7979()).doubleValue();
                        var1_1.Method5837(var10_23 * Math.cos(Math.toRadians((double)var9_21 + (double)90.0f)) + var4_5 * var10_23 * Math.sin(Math.toRadians((double)var9_21 + (double)90.0f)));
                        var1_1.Method5820(var10_23 * Math.sin(Math.toRadians((double)var9_21 + (double)90.0f)) - var4_5 * var10_23 * Math.cos(Math.toRadians((double)var9_21 + (double)90.0f)));
                        var1_1.Method5834(-(((Number)this.Field1833.Method7979()).doubleValue() / (double)10000));
                        var1_1.Method7948();
                        var12_25 = this;
                        var13_26 = false;
                        Minecraft.getMinecraft().player.motionX = var1_1.Method5839();
                        var12_25 = this;
                        var13_26 = false;
                        Minecraft.getMinecraft().player.motionY = var1_1.Method5815();
                        var12_25 = this;
                        var13_26 = false;
                        Minecraft.getMinecraft().player.motionZ = var1_1.Method5835();
                        if ((Boolean)this.Field1828.Method7979() == false) return;
                        this.Field1847 = (float)((Number)this.Field1829.Method7979()).doubleValue();
                        return;
                    }
                    ** GOTO lbl101
                }
                ** default:
lbl100:
                // 1 sources

                return;
lbl101:
                // 1 sources

                Pyro.Method8979().Method7542(this.Field1847);
                return;
            }
        }
        this.Field1852 = null;
        var7_12 = this;
        var8_17 = false;
        v6 = var6_8 = Minecraft.getMinecraft().player.movementInput.jump != false && (fab)this.Field1832.Method7991().Method7979() == fab.Vanilla;
        if (((Boolean)this.Field1835.Method7979()).booleanValue() && (double)fec.Method733() <= ((Number)this.Field1836.Method7979()).doubleValue()) {
            var6_8 = false;
        }
        if (!var6_8) {
            if (((Boolean)this.Field1828.Method7979()).booleanValue()) {
                this.Field1847 = (float)((Number)this.Field1829.Method7979()).doubleValue();
            }
            fec.Method744(var1_1, ((Number)this.Field1822.Method7979()).doubleValue());
            var7_12 = this;
            var8_17 = false;
            if (Minecraft.getMinecraft().player.isSneaking()) {
                var1_1.Method5834(-((Number)this.Field1823.Method7979()).doubleValue());
            } else if (!((Boolean)this.Field1834.Method7979()).booleanValue() || fec.Method727()) {
                var1_1.Method5834(-(((Number)this.Field1833.Method7979()).doubleValue() / (double)10000));
            } else {
                var1_1.Method5834(0.0);
            }
            var1_1.Method7948();
            var7_12 = this;
            var8_17 = false;
            Minecraft.getMinecraft().player.motionX = var1_1.Method5839();
            var7_12 = this;
            var8_17 = false;
            Minecraft.getMinecraft().player.motionY = var1_1.Method5815();
            var7_12 = this;
            var8_17 = false;
            Minecraft.getMinecraft().player.motionZ = var1_1.Method5835();
        }
        var7_12 = new fag(this);
        var8_18 = fah.Field1818;
        if (!((Boolean)this.Field1824.Method7979()).booleanValue()) {
            var8_18.Method2267();
            return;
        }
        if (!((Boolean)this.Field1826.Method7979()).booleanValue()) {
            var8_18.Method2267();
            return;
        }
        if (var1_1.Method5839() == 0.0 && var1_1.Method5835() == 0.0) {
            var8_18.Method2267();
            return;
        }
        var7_12.Method2267();
    }

    @NotNull
    public f0z Method2525() {
        return this.Field1832;
    }

    public void Method2476(int n) {
        this.Field1853 = n;
    }

    public int Method2526() {
        return this.Field1853;
    }

    public float Method2527() {
        return this.Field1847;
    }

    @NotNull
    public BooleanSetting Method2528() {
        return this.Field1837;
    }

    @NotNull
    public DoubleSetting Method2529() {
        return this.Field1841;
    }

    @NotNull
    public DoubleSetting Method2530() {
        return this.Field1833;
    }

    @NotNull
    public DoubleSetting Method2531() {
        return this.Field1825;
    }

    public void Method2481(@NotNull f4p f4p2, double d, float f) {
        float f2 = f;
        double d2 = fec.Method729().moveForward;
        double d3 = fec.Method729().moveStrafe;
        if (d2 == 0.0 && d3 == 0.0) {
            f4p2.Method5837(0.0);
            f4p2.Method5820(0.0);
        } else {
            if (d2 != 0.0) {
                if (d3 > 0.0) {
                    f2 += (float)(d2 > 0.0 ? -45 : 45);
                } else if (d3 < 0.0) {
                    f2 += (float)(d2 > 0.0 ? 45 : -45);
                }
                d3 = 0.0;
                if (d2 > 0.0) {
                    d2 = 1.0;
                } else if (d2 < 0.0) {
                    d2 = -1.0;
                }
            }
            f4p2.Method5837(d2 * d * Math.cos(Math.toRadians((double)f2 + (double)90.0f)) + d3 * d * Math.sin(Math.toRadians((double)f2 + (double)90.0f)));
            f4p2.Method5820(d2 * d * Math.sin(Math.toRadians((double)f2 + (double)90.0f)) - d3 * d * Math.cos(Math.toRadians((double)f2 + (double)90.0f)));
            this.Field1848 = f2;
        }
    }

    @NotNull
    public DoubleSetting Method2532() {
        return this.Field1836;
    }

    @NotNull
    public BooleanSetting Method2533() {
        return this.Field1830;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @f0g
    @LauncherEventHide
    public void Method2472(@NotNull f4u var1_1) {
        block25: {
            block26: {
                block27: {
                    block28: {
                        block33: {
                            block32: {
                                block31: {
                                    block30: {
                                        block29: {
                                            if (var1_1.Method5619() != f41.Pre) break block25;
                                            if (!((Boolean)this.Field1837.Method7979()).booleanValue()) break block26;
                                            var2_2 = this;
                                            var3_4 = false;
                                            if (Minecraft.getMinecraft().player.isElytraFlying()) break block27;
                                            var2_2 = this;
                                            var3_4 = false;
                                            if (Intrinsics.Method6572((Object)Minecraft.getMinecraft().player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem(), (Object)Items.ELYTRA) ^ true) {
                                                return;
                                            }
                                            var2_2 = this;
                                            var3_4 = false;
                                            if (!ItemElytra.isUsable((ItemStack)Minecraft.getMinecraft().player.getItemStackFromSlot(EntityEquipmentSlot.CHEST))) {
                                                return;
                                            }
                                            if (PyroStatic.Field6436.Method4876()) break block28;
                                            if (((Number)this.Field1841.Method7979()).doubleValue() == 0.0) ** GOTO lbl-1000
                                            var3_5 = this;
                                            var4_13 = false;
                                            v0 = Minecraft.getMinecraft().world;
                                            if (v0 == null) {
                                                Intrinsics.Method6551();
                                            }
                                            var3_5 = this;
                                            var6_14 = v0;
                                            var4_13 = false;
                                            var7_16 = Minecraft.getMinecraft();
                                            if (var6_14.collidesWithAnyBlock(var7_16.player.getEntityBoundingBox().expand(0.0, -((Number)this.Field1841.Method7979()).doubleValue(), 0.0))) {
                                                v1 = true;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                v1 = var2_3 = false;
                                            }
                                            if (((Boolean)this.Field1838.Method7979()).booleanValue()) break block29;
                                            var3_6 = this;
                                            var4_13 = false;
                                            if (!Minecraft.getMinecraft().player.movementInput.jump) break block30;
                                        }
                                        var3_7 = this;
                                        var4_13 = false;
                                        if (!Minecraft.getMinecraft().player.capabilities.isFlying) break block31;
                                    }
                                    this.Field1849 = 0;
                                    f0b.Field5568.Method7904("elytraFlyAutoStart");
                                    return;
                                }
                                if (feg.Field454.Method693(far.Field313.player.getPosition().up().up()).blocksMovement()) {
                                    var3_7 = this;
                                    var4_13 = false;
                                    var3_7 = this;
                                    var6_14 = Minecraft.getMinecraft().player;
                                    var4_13 = false;
                                    var7_16 = Minecraft.getMinecraft();
                                    var3_7 = this;
                                    var7_17 = var7_16.player.posX;
                                    var4_13 = false;
                                    var9_18 = Minecraft.getMinecraft();
                                    var3_8 = var9_18.player.posY;
                                    var5_23 = false;
                                    var9_19 = Math.floor(var3_8);
                                    var3_9 = this;
                                    var4_13 = false;
                                    var11_24 = Minecraft.getMinecraft();
                                    var6_14.setPosition(var7_17, var9_19 += 0.2, var11_24.player.posZ);
                                    var3_9 = this;
                                    var4_13 = false;
                                    v2 = Minecraft.getMinecraft().getConnection();
                                    if (v2 == null) {
                                        Intrinsics.Method6551();
                                    }
                                    var3_9 = this;
                                    var6_14 = v2;
                                    var4_13 = false;
                                    var9_20 = Minecraft.getMinecraft();
                                    var12_25 = CPacketEntityAction.Action.START_FALL_FLYING;
                                    var13_26 = (Entity)var9_20.player;
                                    var6_14.sendPacket((Packet)new CPacketEntityAction(var13_26, var12_25));
                                    return;
                                }
                                var3_7 = this;
                                var4_13 = false;
                                if (!Minecraft.getMinecraft().player.onGround && !var2_3) break block32;
                                this.Field1853 = 0;
                                f0b.Field5568.Method7904("elytraFlyAutoStart");
                                if (((Boolean)this.Field1838.Method7979()).booleanValue()) {
                                    var3_7 = this;
                                    var4_13 = false;
                                    if (Minecraft.getMinecraft().player.onGround) {
                                        var3_7 = this;
                                        var4_13 = false;
                                        Minecraft.getMinecraft().player.jump();
                                    }
                                }
                                var3_7 = this;
                                var4_13 = false;
                                if (Minecraft.getMinecraft().player.onGround || !var2_3) ** GOTO lbl-1000
                                var3_10 = this.Field1849;
                                this.Field1849 = var3_10 + 1;
                                if (var3_10 > ((Number)this.Field1839.Method7979()).intValue()) {
                                    f0b.Field5568.Method7902("elytraFlyAutoStart", f07.MULTIPLY, 2.0f);
                                } else lbl-1000:
                                // 2 sources

                                {
                                    f0b.Field5568.Method7904("elytraFlyAutoStart");
                                }
                                break block25;
                            }
                            if (((Boolean)this.Field1838.Method7979()).booleanValue()) break block33;
                            var3_11 = this.Field1849;
                            this.Field1849 = var3_11 + 1;
                            if (var3_11 <= ((Number)this.Field1839.Method7979()).intValue()) break block25;
                        }
                        if (((Boolean)this.Field1840.Method7979()).booleanValue()) {
                            f0b.Field5568.Method7902("elytraFlyAutoStart", f07.MULTIPLY, 0.15f);
                        }
                        v3 = this;
                        ++v3.Field1853;
                        if (v3.Field1853 >= ((Number)this.Field1843.Method7979()).intValue()) {
                            this.Field1853 = 0;
                            var3_12 = this;
                            var4_13 = false;
                            v4 = Minecraft.getMinecraft().getConnection();
                            if (v4 == null) {
                                Intrinsics.Method6551();
                            }
                            var3_12 = this;
                            var6_14 = v4;
                            var4_13 = false;
                            var9_21 = Minecraft.getMinecraft();
                            var14_27 = CPacketEntityAction.Action.START_FALL_FLYING;
                            var15_28 = (Entity)var9_21.player;
                            var6_14.sendPacket((Packet)new CPacketEntityAction(var15_28, var14_27));
                        }
                        break block25;
                    }
                    if (((Boolean)this.Field1842.Method7979()).booleanValue()) {
                        var2_2 = this;
                        var3_4 = false;
                        v5 = Minecraft.getMinecraft().getConnection();
                        if (v5 == null) {
                            Intrinsics.Method6551();
                        }
                        var2_2 = this;
                        var6_15 = v5;
                        var3_4 = false;
                        var9_22 = Minecraft.getMinecraft();
                        var16_29 = CPacketEntityAction.Action.START_FALL_FLYING;
                        var17_30 = (Entity)var9_22.player;
                        var6_15.sendPacket((Packet)new CPacketEntityAction(var17_30, var16_29));
                    }
                    break block25;
                }
                this.Field1853 = 0;
                this.Field1849 = 0;
                f0b.Field5568.Method7904("elytraFlyAutoStart");
                break block25;
            }
            this.Field1853 = 0;
            this.Field1849 = 0;
            f0b.Field5568.Method7904("elytraFlyAutoStart");
        }
        if ((Boolean)this.Field1827.Method7979() == false) return;
        if (var1_1.Method5619() != f41.Pre) {
            this.Field1847 = -1337.0f;
            this.Field1848 = -1337.0f;
            return;
        }
        if (((Boolean)this.Field1828.Method7979()).booleanValue() && this.Field1847 != -1337.0f) {
            var1_1.Method7948();
            var1_1.Method5647(this.Field1847);
        }
        if ((Boolean)this.Field1830.Method7979() == false) return;
        if (this.Field1848 == -1337.0f) return;
        var1_1.Method7948();
        var1_1.Method5653(this.Field1848);
    }

    @NotNull
    public BooleanSetting Method2455() {
        return this.Field1834;
    }

    @Override
    @NotNull
    public List Method2460() {
        return this.Field1850;
    }

    @NotNull
    public BooleanSetting Method2534() {
        return this.Field1828;
    }

    public void Method2453(float f) {
        this.Field1848 = f;
    }

    @NotNull
    public IntegerSetting Method2535() {
        return this.Field1843;
    }

    public int Method2536() {
        return this.Field1849;
    }

    @Override
    public void Method2537(boolean bl) {
        String string = "Enabled: " + bl;
        boolean bl2 = false;
        System.out.println((Object)string);
        f0b.Field5568.Method7904("elytraflyCreative");
        f0b.Field5568.Method7904("elytraFlyAutoStart");
    }

    @NotNull
    public BooleanSetting Method2538() {
        return this.Field1842;
    }

    @NotNull
    public BooleanSetting Method2539() {
        return this.Field1840;
    }

    @NotNull
    public DoubleSetting Method2540() {
        return this.Field1823;
    }

    public int Method2541() {
        return this.Field1851;
    }

    public void Method2457(float f) {
        this.Field1847 = f;
    }

    @NotNull
    public BooleanSetting Method2542() {
        return this.Field1824;
    }

    @NotNull
    public DoubleSetting Method2543() {
        return this.Field1822;
    }

    public fai(@NotNull f9h f9h2) {
        super(f9h2, "creative", "Creative");
        List list;
        List[] arrlist;
        int n = 0;
        List[] arrlist2 = arrlist = new List[3];
        Enum enum_ = fad.Spin;
        String string = "Attempts to go directly upwards when only holding space";
        String string2 = "StraightUp";
        String string3 = "straightUp";
        fai fai2 = this;
        boolean bl = false;
        arrlist[n] = list = CollectionsKt.Method1013();
        arrlist2[1] = CollectionsKt.Method1014(this.Field1844, this.Field1845);
        n = 2;
        arrlist2 = arrlist = arrlist2;
        bl = false;
        arrlist[n] = list = CollectionsKt.Method1013();
        List[] arrlist3 = arrlist2;
        Enum enum_2 = enum_;
        String string4 = string;
        String string5 = string2;
        String string6 = string3;
        fai2.Field1846 = new f0z(string6, string5, string4, enum_2, arrlist3);
        this.Field1847 = -1337.0f;
        this.Field1848 = -1337.0f;
        this.Field1850 = CollectionsKt.Method1014(this.Field1832, this.Field1846, new f0t(new f0n("speed", "Speed", null), this.Field1822, this.Field1823, new f0t(this.Field1824, this.Field1825, this.Field1826)), new f0t(this.Field1827, new f0t(this.Field1828, this.Field1829), this.Field1830), new f0t(this.Field1833, this.Field1834), new f0t(this.Field1835, this.Field1836), new f0t(this.Field1837, this.Field1838, this.Field1841, this.Field1839, this.Field1840, this.Field1842, this.Field1843));
    }
}

