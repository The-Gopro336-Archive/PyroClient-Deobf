/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemElytra
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.util.math.MathHelper
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BindSetting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f07;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f0z;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4E;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f9h;
import dev.nuker.pyro.fa7;
import dev.nuker.pyro.fa8;
import dev.nuker.pyro.fa9;
import dev.nuker.pyro.faj;
import dev.nuker.pyro.far;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

public class faa
extends faj {
    @NotNull
    public DoubleSetting Field1758 = new DoubleSetting("horizontalSpeed", "Speed", "Maximum speed", 1.8, 0.0, 5.0, 0.0, 64, null);
    @NotNull
    public BooleanSetting Field1759 = new BooleanSetting("instantStop", "InstantStop", "Stops flying when you stop pressing keys", true);
    @NotNull
    public DoubleSetting Field1760 = new DoubleSetting("factor", "Factor", null, 0.0, 0.0, 10.0, 0.0, 64, null);
    @NotNull
    public DoubleSetting Field1761 = new DoubleSetting("factor", "Factor", null, 0.0, 0.0, 10.0, 0.0, 64, null);
    @NotNull
    public f0z<fa7> Field1762;
    @NotNull
    public DoubleSetting Field1763;
    @NotNull
    public BooleanSetting Field1764;
    @NotNull
    public BooleanSetting Field1765;
    @NotNull
    public DoubleSetting Field1766;
    @NotNull
    public BindSetting Field1767;
    @NotNull
    public BooleanSetting Field1768;
    @NotNull
    public BooleanSetting Field1769;
    @NotNull
    public BooleanSetting Field1770;
    @NotNull
    public IntegerSetting Field1771;
    @NotNull
    public BooleanSetting Field1772;
    @NotNull
    public DoubleSetting Field1773;
    @NotNull
    public BooleanSetting Field1774;
    @NotNull
    public IntegerSetting Field1775;
    public float Field1776;
    public float Field1777;
    public int Field1778;
    @NotNull
    public List<f0w<?>> Field1779;
    public int Field1780;

    public void Method2453(float f) {
        this.Field1776 = f;
    }

    @NotNull
    public BooleanSetting Method2454() {
        return this.Field1769;
    }

    @NotNull
    public BooleanSetting Method2455() {
        return this.Field1765;
    }

    @NotNull
    public BooleanSetting Method2456() {
        return this.Field1770;
    }

    public void Method2457(float f) {
        this.Field1777 = f;
    }

    @NotNull
    public DoubleSetting Method2458() {
        return this.Field1763;
    }

    public int Method2459() {
        return this.Field1778;
    }

    @Override
    @NotNull
    public List Method2460() {
        return this.Field1779;
    }

    @NotNull
    public BooleanSetting Method2461() {
        return this.Field1759;
    }

    @NotNull
    public BooleanSetting Method2462() {
        return this.Field1774;
    }

    public int Method2463() {
        return this.Field1780;
    }

    public float Method2464() {
        return this.Field1777;
    }

    @NotNull
    public BooleanSetting Method2465() {
        return this.Field1764;
    }

    @NotNull
    public DoubleSetting Method2466() {
        return this.Field1760;
    }

    public void Method2467(int n) {
        this.Field1780 = n;
    }

    public float Method2468() {
        return this.Field1776;
    }

    @NotNull
    public f0z Method2469() {
        return this.Field1762;
    }

    @NotNull
    public DoubleSetting Method2470() {
        return this.Field1766;
    }

    public faa(@NotNull f9h f9h2) {
        super(f9h2, "boostControl", "BoostControl");
        List list;
        List[] arrlist;
        int n = 0;
        List[] arrlist2 = arrlist = new List[4];
        Enum enum_ = fa7.Instant;
        String string = null;
        String string2 = "Accelerate";
        String string3 = "accelerate";
        faa faa2 = this;
        boolean bl = false;
        arrlist[n] = list = CollectionsKt.Method1013();
        List[] arrlist3 = arrlist2;
        arrlist2[1] = CollectionsKt.Method9007(this.Field1760);
        arrlist3[2] = CollectionsKt.Method9007(this.Field1761);
        n = 3;
        arrlist = arrlist3;
        arrlist2 = arrlist3;
        bl = false;
        arrlist[n] = list = CollectionsKt.Method1013();
        List[] arrlist4 = arrlist2;
        Enum enum_2 = enum_;
        String string4 = string;
        String string5 = string2;
        String string6 = string3;
        faa2.Field1762 = new f0z(string6, string5, string4, enum_2, arrlist4);
        this.Field1763 = new DoubleSetting("fallSpeed", "GlideSpeed", "Speed to fall/glide at", 1.0, 0.0, 10.0, 0.0, 64, null);
        this.Field1764 = new BooleanSetting("ignoreStill", "WhileMoving", "Stops falling when you aren't moving", true);
        this.Field1765 = new BooleanSetting("cutoff", "Cutoff", "Stops adding speed above the specified pitch", true);
        this.Field1766 = new DoubleSetting("pitch", "Pitch", "Pitch to stop adding speed", 0.58, -90.0, 90.0, 0.0, 64, null);
        this.Field1767 = new BindSetting("snap", "Snap", "Snaps the pitch to the cutoff pitch", -1);
        this.Field1768 = new BooleanSetting("render", "Render", "Draw a line showing the cutoff onscreen", true);
        this.Field1769 = new BooleanSetting("autoStart", "AutoStart", "Automatically starts the elytra fly off ground", true);
        this.Field1770 = new BooleanSetting("autoJump", "AutoJump", "Automatically jumps on ground", true);
        this.Field1771 = new IntegerSetting("waitTicks", "WaitTicks", "The number of ticks to wait after you jump before starting", 20, 0, 60, 0, 64, null);
        this.Field1772 = new BooleanSetting("autoStartTimer", "UseTimer", "Slows down the game speed to allow you to fly easier", true);
        this.Field1773 = new DoubleSetting("minStartHeight", "MinHeight", "Minimum height to start at", 0.5, 0.0, 2.0, 0.0, 64, null);
        this.Field1774 = new BooleanSetting("InWater", "InLiquid", "Sends the fly packet in Liquid", true);
        this.Field1775 = new IntegerSetting("startTicks", "StartTicks", "The number of ticks after offground to try to fly at", 4, 1, 5, 0, 64, null);
        this.Field1776 = -1337.0f;
        this.Field1777 = -1337.0f;
        this.Field1779 = CollectionsKt.Method1014(this.Field1758, this.Field1759, this.Field1762, new f0t(this.Field1763, this.Field1764), new f0t(this.Field1765, this.Field1766, this.Field1767, this.Field1768), new f0t(this.Field1769, this.Field1770, this.Field1773, this.Field1771, this.Field1772, this.Field1774, this.Field1775));
    }

    @NotNull
    public BindSetting Method2471() {
        return this.Field1767;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @f0g
    @LauncherEventHide
    public void Method2472(@NotNull f4u var1_1) {
        block21: {
            block24: {
                block23: {
                    block22: {
                        if (var1_1.Method5619() != f41.Pre) return;
                        if (!((Boolean)this.Field1769.Method7979()).booleanValue()) {
                            this.Field1780 = 0;
                            this.Field1778 = 0;
                            f0b.Field5568.Method7904("elytraFlyAutoStart");
                            return;
                        }
                        var2_2 = this;
                        var3_4 = false;
                        if (Minecraft.getMinecraft().player.isElytraFlying()) {
                            this.Field1780 = 0;
                            this.Field1778 = 0;
                            f0b.Field5568.Method7904("elytraFlyAutoStart");
                            return;
                        }
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
                        if (PyroStatic.Field6436.Method4876()) break block21;
                        if (((Number)this.Field1773.Method7979()).doubleValue() == 0.0) ** GOTO lbl-1000
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
                        if (var6_14.collidesWithAnyBlock(var7_16.player.getEntityBoundingBox().expand(0.0, -((Number)this.Field1773.Method7979()).doubleValue(), 0.0))) {
                            v1 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v1 = var2_3 = false;
                        }
                        if (((Boolean)this.Field1770.Method7979()).booleanValue()) break block22;
                        var3_6 = this;
                        var4_13 = false;
                        if (!Minecraft.getMinecraft().player.movementInput.jump) break block23;
                    }
                    var3_7 = this;
                    var4_13 = false;
                    if (!Minecraft.getMinecraft().player.capabilities.isFlying) break block24;
                }
                this.Field1778 = 0;
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
            if (Minecraft.getMinecraft().player.onGround || var2_3) {
                this.Field1780 = 0;
                f0b.Field5568.Method7904("elytraFlyAutoStart");
                if (((Boolean)this.Field1770.Method7979()).booleanValue()) {
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
                if (!Minecraft.getMinecraft().player.onGround && var2_3) {
                    var3_10 = this.Field1778;
                    this.Field1778 = var3_10 + 1;
                    if (var3_10 > ((Number)this.Field1771.Method7979()).intValue()) {
                        f0b.Field5568.Method7902("elytraFlyAutoStart", f07.MULTIPLY, 2.0f);
                        return;
                    }
                }
                f0b.Field5568.Method7904("elytraFlyAutoStart");
                return;
            }
            if (!((Boolean)this.Field1770.Method7979()).booleanValue()) {
                var3_11 = this.Field1778;
                this.Field1778 = var3_11 + 1;
                if (var3_11 <= ((Number)this.Field1771.Method7979()).intValue()) return;
            }
            if (((Boolean)this.Field1772.Method7979()).booleanValue()) {
                f0b.Field5568.Method7902("elytraFlyAutoStart", f07.MULTIPLY, 0.15f);
            }
            v3 = this;
            ++v3.Field1780;
            if (v3.Field1780 < ((Number)this.Field1775.Method7979()).intValue()) return;
            this.Field1780 = 0;
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
            return;
        }
        if ((Boolean)this.Field1774.Method7979() == false) return;
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

    @NotNull
    public IntegerSetting Method2473() {
        return this.Field1771;
    }

    @NotNull
    public IntegerSetting Method2474() {
        return this.Field1775;
    }

    @NotNull
    public DoubleSetting Method2475() {
        return this.Field1761;
    }

    public void Method2476(int n) {
        this.Field1778 = n;
    }

    @NotNull
    public DoubleSetting Method2477() {
        return this.Field1758;
    }

    @NotNull
    public BooleanSetting Method2478() {
        return this.Field1768;
    }

    @NotNull
    public BooleanSetting Method2479() {
        return this.Field1772;
    }

    @NotNull
    public DoubleSetting Method2480() {
        return this.Field1773;
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
        }
    }

    @f0g
    @LauncherEventHide
    public void Method2482(@NotNull f4E f4E2) {
        faa faa2 = this;
        boolean bl = false;
        if (Minecraft.getMinecraft().player.isElytraFlying() && ((Boolean)this.Field1765.Method7979()).booleanValue() && ((Boolean)this.Field1768.Method7979()).booleanValue()) {
            double d;
            Minecraft minecraft;
            faa faa3 = this;
            boolean bl2 = false;
            Minecraft minecraft2 = minecraft = Minecraft.getMinecraft();
            double d2 = 50.0;
            double d3 = -50.0;
            faa faa4 = this;
            double d4 = (double)new ScaledResolution(minecraft2).getScaledHeight() / 2.0;
            boolean bl3 = false;
            minecraft = Minecraft.getMinecraft();
            double d5 = (double)MathHelper.wrapDegrees((float)minecraft.player.rotationPitch) - ((Number)this.Field1766.Method7979()).doubleValue();
            boolean bl4 = false;
            d3 = d = Math.max(d3, d5);
            boolean bl5 = false;
            d = Math.min(d2, d3);
            double d6 = d4 - d;
            GlStateManager.pushMatrix();
            GlStateManager.translate((double)0.0, (double)d6, (double)0.0);
            faa faa5 = this;
            int n = 0;
            int n2 = 0;
            bl2 = false;
            Minecraft minecraft3 = Minecraft.getMinecraft();
            faa5 = this;
            int n3 = 1;
            int n4 = minecraft3.displayWidth;
            bl2 = false;
            Minecraft minecraft4 = Minecraft.getMinecraft();
            Gui.drawRect((int)n2, (int)n, (int)n4, (int)n3, (int)((double)MathHelper.wrapDegrees((float)minecraft4.player.rotationPitch) >= ((Number)this.Field1766.Method7979()).doubleValue() ? new Color(255, 0, 0, 100).getRGB() : new Color(0, 255, 0, 100).getRGB()));
            GlStateManager.popMatrix();
        }
    }

    @f0g
    @LauncherEventHide
    public void Method2483(@NotNull f4p f4p2) {
        block17: {
            float f;
            double d;
            double d2;
            block19: {
                float f2;
                boolean bl;
                faa faa2;
                block18: {
                    faa faa3 = this;
                    boolean bl2 = false;
                    if (!Minecraft.getMinecraft().player.isElytraFlying()) break block17;
                    if (((Boolean)this.Field1765.Method7979()).booleanValue()) {
                        if (this.Field1767.Method8796()) {
                            faa3 = this;
                            bl2 = false;
                            Minecraft.getMinecraft().player.rotationPitch = (float)((Number)this.Field1766.Method7979()).doubleValue();
                        }
                    }
                    d2 = fec.Method729().moveForward;
                    d = fec.Method729().moveStrafe;
                    if (!((Boolean)this.Field1759.Method7979()).booleanValue() || d2 != 0.0 || d != 0.0) break block18;
                    faa faa4 = this;
                    boolean bl3 = false;
                    Minecraft.getMinecraft().player.motionX = 0.0;
                    faa4 = this;
                    bl3 = false;
                    Minecraft.getMinecraft().player.motionY = 0.0;
                    faa4 = this;
                    bl3 = false;
                    Minecraft.getMinecraft().player.motionZ = 0.0;
                    f4p2.Method5837(0.0);
                    f4p2.Method5834(!((Boolean)this.Field1764.Method7979()).booleanValue() ? -(((Number)this.Field1763.Method7979()).doubleValue() / (double)10000) : 0.0);
                    f4p2.Method5820(0.0);
                    f4p2.Method7948();
                    break block17;
                }
                if (d2 >= 0.0) {
                    faa2 = this;
                    bl = false;
                    f2 = Minecraft.getMinecraft().player.rotationPitch;
                } else {
                    faa2 = this;
                    bl = false;
                    f2 = f = -Minecraft.getMinecraft().player.rotationPitch;
                }
                if (!((Boolean)this.Field1765.Method7979()).booleanValue()) break block19;
                if (!((double)f >= ((Number)this.Field1766.Method7979()).doubleValue())) break block17;
            }
            faa faa5 = this;
            boolean bl = false;
            float f3 = Minecraft.getMinecraft().player.rotationYaw;
            if (d > 0.0) {
                f3 += (float)(d2 > 0.0 ? -45 : (d2 == 0.0 ? -90 : 45));
            } else if (d < 0.0) {
                f3 += (float)(d2 > 0.0 ? 45 : (d2 == 0.0 ? 90 : -45));
            }
            if (d2 < 0.0) {
                f3 += (float)180;
            }
            switch (fa8.Field1622[((fa7)((Object)this.Field1762.Method7991().Method7979())).ordinal()]) {
                case 1: {
                    double d3;
                    float f4 = MathHelper.cos((float)((float)Math.toRadians(f)));
                    boolean bl4 = false;
                    float f5 = Math.abs(f4);
                    faa faa6 = this;
                    bl4 = false;
                    Minecraft.getMinecraft().player.motionX = (double)(-MathHelper.sin((float)((float)Math.toRadians(f3)))) * ((Number)this.Field1758.Method7979()).doubleValue() * (double)f5;
                    faa6 = this;
                    bl4 = false;
                    Minecraft.getMinecraft().player.motionZ = (double)MathHelper.cos((float)((float)Math.toRadians(f3))) * ((Number)this.Field1758.Method7979()).doubleValue() * (double)f5;
                    faa6 = this;
                    bl4 = false;
                    Minecraft.getMinecraft().player.motionY = (double)(-MathHelper.sin((float)((float)Math.toRadians(f)))) * ((Number)this.Field1758.Method7979()).doubleValue();
                    faa6 = this;
                    bl4 = false;
                    double d4 = -(((Number)this.Field1763.Method7979()).doubleValue() / (double)10000);
                    faa faa7 = this;
                    EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().player;
                    boolean bl5 = false;
                    Minecraft minecraft = Minecraft.getMinecraft();
                    double d5 = minecraft.player.motionY;
                    boolean bl6 = false;
                    entityPlayerSP.motionY = d3 = Math.min(d4, d5);
                    break;
                }
                case 2: {
                    float f6 = MathHelper.cos((float)((float)Math.toRadians(f)));
                    boolean bl7 = false;
                    float f7 = Math.abs(f6);
                    fa9 fa92 = new fa9(this);
                    faa faa8 = this;
                    boolean bl8 = false;
                    Minecraft.getMinecraft().player.motionX = (double)(-MathHelper.sin((float)((float)Math.toRadians(f3)))) * fa92.Method2321() * (double)f7;
                    faa8 = this;
                    bl8 = false;
                    Minecraft.getMinecraft().player.motionZ = (double)MathHelper.cos((float)((float)Math.toRadians(f3))) * fa92.Method2321() * (double)f7;
                    break;
                }
                case 3: {
                    faa5 = this;
                    bl = false;
                    double d6 = ((Number)this.Field1758.Method7979()).doubleValue();
                    double d7 = (double)fec.Method733() * ((Number)this.Field1761.Method7979()).doubleValue();
                    double d8 = -MathHelper.sin((float)((float)Math.toRadians(f3)));
                    EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().player;
                    boolean bl9 = false;
                    double d9 = Math.min(d6, d7);
                    entityPlayerSP.motionX = d8 * d9;
                    faa faa9 = this;
                    bl = false;
                    double d10 = ((Number)this.Field1758.Method7979()).doubleValue();
                    d7 = (double)fec.Method733() * ((Number)this.Field1761.Method7979()).doubleValue();
                    d8 = MathHelper.cos((float)((float)Math.toRadians(f3)));
                    entityPlayerSP = Minecraft.getMinecraft().player;
                    bl9 = false;
                    d9 = Math.min(d10, d7);
                    entityPlayerSP.motionZ = d8 * d9;
                    break;
                }
                case 4: {
                    faa5 = this;
                    bl = false;
                    Minecraft.getMinecraft().player.motionX += (double)(-MathHelper.sin((float)((float)Math.toRadians(f3)))) * 0.16 / (double)10;
                    faa5 = this;
                    bl = false;
                    Minecraft.getMinecraft().player.motionZ += (double)MathHelper.cos((float)((float)Math.toRadians(f3))) * 0.16 / (double)10;
                }
            }
        }
    }
}

