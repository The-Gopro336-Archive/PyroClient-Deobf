/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f07;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f4z;
import dev.nuker.pyro.f9W;
import dev.nuker.pyro.f9X;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f9Y
extends Module {
    public DoubleSetting Field3627 = new DoubleSetting("stepheight", "Height", "How much should step be able to go", 1.0, 1.0, 10.0);
    public double[][] Field3628 = new double[][]{{0.42, 0.753}, {0.42, 0.75, 1.0, 1.16, 1.23, 1.2}, {0.42, 0.78, 0.63, 0.51, 0.9, 1.21, 1.45, 1.43}, {0.425, 0.821, 0.699, 0.599, 1.022, 1.372, 1.652, 1.869, 2.019, 1.907}};
    public f0o<f9X> Field3629 = new f0o("stepmode", "Mode", "What mode to perform on for stepping", f9X.NCP);
    public BooleanSetting Field3630 = new BooleanSetting("useTimer", "UseTimer", null, true);
    public DoubleSetting Field3631 = new DoubleSetting("legitSpeed", "LegitSpeed", null, 0.2, 0.0, 1.0);
    public BooleanSetting Field3632 = new BooleanSetting("Toggle", "Toggle", "Toggles on completing one step", false);
    public int Field3633 = 0;
    public int Field3634 = 0;
    public double Field3635 = 0.0;
    public double Field3636 = 0.0;
    public double Field3637 = 0.0;
    public boolean Field3638 = false;

    @f0g
    @LauncherEventHide
    public void Method5399(f4z f4z2) {
        if (this.Field3629.Method7979() == f9X.NCP) {
            double d;
            if (f4z2.Method5619() == f41.Pre) {
                if (this.Field5233.player.onGround && this.Field5233.player.collidedHorizontally && !this.Field5233.player.movementInput.sneak) {
                    f4z2.Method5647((float)((Double)this.Field3627.Method7979()).doubleValue());
                    this.Field3637 = f4z2.Method5608().minY;
                }
            } else if (f4z2.Method5619() == f41.Post && f4z2.Method5646() == ((Double)this.Field3627.Method7979()).floatValue() && (d = f4z2.Method5608().minY - this.Field3637) > 0.7) {
                this.Field3638 = true;
                if (d <= 0.75) {
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.41999998688698, this.Field5233.player.posZ, false));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.75319999805212, this.Field5233.player.posZ, false));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.00133597911216, this.Field5233.player.posZ, false));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.166109260938214, this.Field5233.player.posZ, false));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.24918707874468, this.Field5233.player.posZ, false));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.25220334025373, this.Field5233.player.posZ, false));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.17675927506424, this.Field5233.player.posZ, false));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.024424088213685, this.Field5233.player.posZ, false));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.79673560066871, this.Field5233.player.posZ, false));
                    if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                        this.Field3633 = 1;
                        f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.5f);
                    }
                } else if (d < 0.875) {
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.41999998688698, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.75319999805212, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.00133597911215, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.166109260938214, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.24918707874468, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.25220334025373, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.17675927506424, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.024424088213685, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                        this.Field3633 = 1;
                        f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.5f);
                    }
                } else if (d <= 0.875) {
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.42, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.73, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                        this.Field3633 = 1;
                        f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.5f);
                    }
                } else if (d <= 1.0) {
                    for (int i = 0; i < this.Field3628[0].length; ++i) {
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + this.Field3628[0][i], this.Field5233.player.posZ, this.Field5233.player.onGround));
                    }
                    if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                        this.Field3633 = 1;
                        f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.5f);
                    }
                } else if (d <= 1.125) {
                    for (int i = 0; i < this.Field3628[0].length; ++i) {
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + this.Field3628[0][i], this.Field5233.player.posZ, this.Field5233.player.onGround));
                    }
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.00133597911215, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.166109260938214, this.Field5233.player.posZ, this.Field5233.player.onGround));
                    if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                        this.Field3633 = 1;
                        f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.25f);
                    }
                } else if (d <= (Double)this.Field3627.Method7979() && d <= 1.5) {
                    for (int i = 0; i < this.Field3628[1].length; ++i) {
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + this.Field3628[1][i], this.Field5233.player.posZ, this.Field5233.player.onGround));
                    }
                    if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                        this.Field3633 = 1;
                        f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.15f);
                    }
                } else if (d <= (Double)this.Field3627.Method7979() && d <= 2.0) {
                    for (int i = 0; i < this.Field3628[2].length; ++i) {
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + this.Field3628[2][i], this.Field5233.player.posZ, this.Field5233.player.onGround));
                    }
                    if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                        this.Field3633 = 1;
                        f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.11f);
                    }
                } else if (d <= (Double)this.Field3627.Method7979()) {
                    for (int i = 0; i < this.Field3628[3].length; ++i) {
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + this.Field3628[3][i], this.Field5233.player.posZ, this.Field5233.player.onGround));
                    }
                    if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                        this.Field3633 = 1;
                        f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.1f);
                    }
                }
                if (((Boolean)this.Field3632.Method7979()).booleanValue()) {
                    Pyro.Field6182.Method8989("Toggling step.");
                    this.Field5236.Method5266(false);
                }
            }
        }
        if (f4z2.Method5619() == f41.Pre && this.Field3629.Method7979() == f9X.Vanilla) {
            f4z2.Method5647((float)((Double)this.Field3627.Method7979()).doubleValue());
        }
    }

    @f0g(value=3)
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre) {
            this.Method7274(String.valueOf(this.Field3629.Method7979()));
            if (this.Field3633 == 0) {
                f0b.Field5568.Method7904("step");
            } else {
                --this.Field3633;
                return;
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public AxisAlignedBB Method5400(double d) {
        if (!this.Field5233.player.onGround) return null;
        if (!this.Field5233.player.collidedHorizontally) return null;
        if (this.Field5233.player.fallDistance != 0.0f) return null;
        if (this.Field5233.player.isInWater()) return null;
        if (this.Field5233.player.isInLava()) return null;
        if (this.Field5233.player.isOnLadder()) return null;
        if (this.Field5233.player.movementInput.jump) return null;
        if (this.Field5233.player.movementInput.sneak) return null;
        boolean bl = true;
        boolean bl2 = bl;
        if (bl2) return this.Method5403(d);
        return null;
    }

    public f9Y() {
        super("step", "Step", "Allows you to automatically step up blocks", true);
        this.Method7264(this.Field3629);
        this.Method7264(this.Field3627);
        this.Method7264(this.Field3630);
        this.Method7264(this.Field3631);
        this.Method7264(this.Field3632);
    }

    public double Method5401(AxisAlignedBB axisAlignedBB) {
        return axisAlignedBB != null ? axisAlignedBB.minY - this.Field5233.player.getEntityBoundingBox().minY : 0.0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public double Method5402(double d) {
        if (!this.Field5233.player.onGround) return 0.0;
        if (!this.Field5233.player.collidedHorizontally) return 0.0;
        if (this.Field5233.player.fallDistance != 0.0f) return 0.0;
        if (this.Field5233.player.isInWater()) return 0.0;
        if (this.Field5233.player.isInLava()) return 0.0;
        if (this.Field5233.player.isOnLadder()) return 0.0;
        if (this.Field5233.player.movementInput.jump) return 0.0;
        if (this.Field5233.player.movementInput.sneak) return 0.0;
        boolean bl = true;
        boolean bl2 = bl;
        if (bl2) return this.Method5403((double)d).minY - this.Field5233.player.getEntityBoundingBox().minY;
        return 0.0;
    }

    public AxisAlignedBB Method5403(double d) {
        int n;
        int n2;
        double[] arrd = fec.Method732(0.2f);
        double d2 = arrd[0];
        double d3 = arrd[1];
        double d4 = d2;
        double d5 = 0.0;
        double d6 = d3;
        List list = this.Field5233.world.getCollisionBoxes((Entity)this.Field5233.player, this.Field5233.player.getEntityBoundingBox().expand(d2, 0.0, d3));
        AxisAlignedBB axisAlignedBB = this.Field5233.player.getEntityBoundingBox();
        if (d2 != 0.0) {
            n2 = list.size();
            for (n = 0; n < n2; ++n) {
                d2 = ((AxisAlignedBB)list.get(n)).calculateXOffset(axisAlignedBB, d2);
            }
            if (d2 != 0.0) {
                axisAlignedBB = axisAlignedBB.offset(d2, 0.0, 0.0);
            }
        }
        if (d3 != 0.0) {
            n2 = list.size();
            for (n = 0; n < n2; ++n) {
                d3 = ((AxisAlignedBB)list.get(n)).calculateZOffset(axisAlignedBB, d3);
            }
            if (d3 != 0.0) {
                axisAlignedBB = axisAlignedBB.offset(0.0, 0.0, d3);
            }
        }
        double d7 = d2;
        double d8 = 0.0;
        double d9 = d3;
        AxisAlignedBB axisAlignedBB2 = this.Field5233.player.getEntityBoundingBox();
        double d10 = d;
        List list2 = this.Field5233.world.getCollisionBoxes((Entity)this.Field5233.player, axisAlignedBB.expand(d4, d10, d6));
        AxisAlignedBB axisAlignedBB3 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB4 = axisAlignedBB3.expand(d4, 0.0, d6);
        double d11 = d10;
        int n3 = list2.size();
        for (int i = 0; i < n3; ++i) {
            d11 = ((AxisAlignedBB)list2.get(i)).calculateYOffset(axisAlignedBB4, d11);
        }
        axisAlignedBB3 = axisAlignedBB3.offset(0.0, d11, 0.0);
        double d12 = d4;
        int n4 = list2.size();
        for (int i = 0; i < n4; ++i) {
            d12 = ((AxisAlignedBB)list2.get(i)).calculateXOffset(axisAlignedBB3, d12);
        }
        axisAlignedBB3 = axisAlignedBB3.offset(d12, 0.0, 0.0);
        double d13 = d6;
        int n5 = list2.size();
        for (int i = 0; i < n5; ++i) {
            d13 = ((AxisAlignedBB)list2.get(i)).calculateZOffset(axisAlignedBB3, d13);
        }
        axisAlignedBB3 = axisAlignedBB3.offset(0.0, 0.0, d13);
        AxisAlignedBB axisAlignedBB5 = axisAlignedBB;
        double d14 = d10;
        int n6 = list2.size();
        for (int i = 0; i < n6; ++i) {
            d14 = ((AxisAlignedBB)list2.get(i)).calculateYOffset(axisAlignedBB5, d14);
        }
        axisAlignedBB5 = axisAlignedBB5.offset(0.0, d14, 0.0);
        double d15 = d4;
        int n7 = list2.size();
        for (int i = 0; i < n7; ++i) {
            d15 = ((AxisAlignedBB)list2.get(i)).calculateXOffset(axisAlignedBB5, d15);
        }
        axisAlignedBB5 = axisAlignedBB5.offset(d15, 0.0, 0.0);
        double d16 = d6;
        int n8 = list2.size();
        for (int i = 0; i < n8; ++i) {
            d16 = ((AxisAlignedBB)list2.get(i)).calculateZOffset(axisAlignedBB5, d16);
        }
        axisAlignedBB5 = axisAlignedBB5.offset(0.0, 0.0, d16);
        double d17 = d12 * d12 + d13 * d13;
        double d18 = d15 * d15 + d16 * d16;
        AxisAlignedBB axisAlignedBB6 = null;
        if (d17 > d18) {
            d2 = d12;
            d3 = d13;
            d10 = -d11;
            axisAlignedBB6 = axisAlignedBB3;
        } else {
            d2 = d15;
            d3 = d16;
            d10 = -d14;
            axisAlignedBB6 = axisAlignedBB5;
        }
        int n9 = list2.size();
        for (int i = 0; i < n9; ++i) {
            d10 = ((AxisAlignedBB)list2.get(i)).calculateYOffset(axisAlignedBB6, d10);
        }
        axisAlignedBB6 = axisAlignedBB6.offset(0.0, d10, 0.0);
        if (d7 * d7 + d9 * d9 >= d2 * d2 + d3 * d3) {
            d2 = d7;
            d10 = d8;
            d3 = d9;
            axisAlignedBB6 = axisAlignedBB2;
        }
        return axisAlignedBB6;
    }

    @f0g(value=2)
    @LauncherEventHide
    public void Method559(f4p f4p2) {
        if (f4p2.Method7947() || f4p2.Method5619() != f41.Pre) {
            return;
        }
        if (!fec.Method727()) {
            return;
        }
        switch (f9W.Field3698[((f9X)((Object)this.Field3629.Method7979())).ordinal()]) {
            case 1: {
                if (!this.Field3638) break;
                this.Field3638 = false;
                float f = (float)fec.Method718();
                f4p2.Method7948();
                f4p2.Method5837((double)(-MathHelper.sin((float)f)) * (Double)this.Field3631.Method7979());
                f4p2.Method5820((double)MathHelper.cos((float)f) * (Double)this.Field3631.Method7979());
                break;
            }
            case 2: {
                if (!this.Field5233.player.collidedHorizontally) {
                    this.Field3634 = 0;
                    f0b.Field5568.Method7904("step");
                    return;
                }
                double d = (Double)this.Field3627.Method7979();
                double d2 = this.Method5402(1.0);
                if (d2 == 0.0 && d >= 1.5) {
                    d2 = this.Method5402(1.5);
                }
                if (d2 == 0.0 && d >= 2.0) {
                    d2 = this.Method5402(2.0);
                }
                if (d2 == 0.0 && d >= 2.5) {
                    d2 = this.Method5402(2.5);
                }
                if (d2 == 0.0) {
                    d2 = this.Method5402(d);
                }
                if (this.Field3634 == 0 && this.Field5233.player.onGround && d2 == 1.0) {
                    f4p2.Method7948();
                    f4p2.Method5834(0.41999998688698);
                    this.Field5233.player.motionY = 0.0;
                    this.Field3634 = 1;
                    this.Field3636 = d2;
                    return;
                }
                if (this.Field3634 > 0) {
                    if (this.Field3636 <= 1.0) {
                        f4p2.Method7948();
                        switch (this.Field3634) {
                            case 1: {
                                f4p2.Method5834(0.33319999363422);
                                this.Field5233.player.motionY = 0.0;
                                this.Field3634 = 2;
                                break;
                            }
                            case 2: {
                                float f = (float)fec.Method718();
                                f4p2.Method5834(0.24813599859094704);
                                f4p2.Method5837((double)(-MathHelper.sin((float)f)) * (Double)this.Field3631.Method7979());
                                f4p2.Method5820((double)MathHelper.cos((float)f) * (Double)this.Field3631.Method7979());
                                this.Field5233.player.motionY = 0.0;
                                this.Field3634 = 0;
                                if (((Boolean)this.Field3632.Method7979()).booleanValue()) {
                                    Pyro.Field6182.Method8989("Toggling step.");
                                    this.Field5236.Method5266(false);
                                }
                                return;
                            }
                        }
                    } else if (this.Field3636 <= 1.5) {
                        f4p2.Method7948();
                        switch (this.Field3634) {
                            case 1: {
                                if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                                    f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.17f);
                                }
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[1][1], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[1][2], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[1][3], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[1][4], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                f4p2.Method5834(this.Field3628[1][5] - this.Field3628[1][0]);
                                this.Field5233.player.motionY = 0.0;
                                ++this.Field3634;
                                break;
                            }
                            case 2: {
                                f4p2.Method7948();
                                f4p2.Method5834(0.31);
                                float f = (float)fec.Method718();
                                f4p2.Method5837((double)(-MathHelper.sin((float)f)) * (Double)this.Field3631.Method7979());
                                f4p2.Method5820((double)MathHelper.cos((float)f) * (Double)this.Field3631.Method7979());
                                this.Field5233.player.motionY = 0.0;
                                this.Field3634 = 0;
                                if (((Boolean)this.Field3632.Method7979()).booleanValue()) {
                                    Pyro.Field6182.Method8989("Toggling step.");
                                    this.Field5236.Method5266(false);
                                }
                                return;
                            }
                        }
                    } else if (this.Field3636 <= 2.0) {
                        f4p2.Method7948();
                        switch (this.Field3634) {
                            case 1: {
                                if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                                    f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.17f);
                                }
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[2][1], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[2][2], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[2][3], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[2][4], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[2][5], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[2][6], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                f4p2.Method5834(this.Field3628[2][7] - this.Field3628[2][0]);
                                this.Field5233.player.motionY = 0.0;
                                ++this.Field3634;
                                break;
                            }
                            case 2: {
                                f4p2.Method5834(Math.floor(this.Field5233.player.posY) + 1.0 - this.Field5233.player.posY);
                                float f = (float)fec.Method718();
                                f4p2.Method5837((double)(-MathHelper.sin((float)f)) * (Double)this.Field3631.Method7979());
                                f4p2.Method5820((double)MathHelper.cos((float)f) * (Double)this.Field3631.Method7979());
                                this.Field5233.player.motionY = 0.0;
                                this.Field3634 = 0;
                                if (((Boolean)this.Field3632.Method7979()).booleanValue()) {
                                    Pyro.Field6182.Method8989("Toggling step.");
                                    this.Field5236.Method5266(false);
                                }
                                return;
                            }
                        }
                    } else if (this.Field3636 <= 2.5) {
                        f4p2.Method7948();
                        switch (this.Field3634) {
                            case 1: {
                                if (((Boolean)this.Field3630.Method7979()).booleanValue()) {
                                    f0b.Field5568.Method7902("step", f07.MULTIPLY, 0.125f);
                                }
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[3][1], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[3][2], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[3][3], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[3][4], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[3][5], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[3][6], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[3][7], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field3635 + this.Field3628[3][8], this.Field5233.player.posZ, this.Field5233.player.onGround));
                                f4p2.Method5834(this.Field3628[3][9] - this.Field3628[3][0]);
                                this.Field5233.player.motionY = 0.0;
                                ++this.Field3634;
                                break;
                            }
                            case 2: {
                                f4p2.Method5834(0.6);
                                float f = (float)fec.Method718();
                                f4p2.Method5837((double)(-MathHelper.sin((float)f)) * (Double)this.Field3631.Method7979());
                                f4p2.Method5820((double)MathHelper.cos((float)f) * (Double)this.Field3631.Method7979());
                                this.Field5233.player.motionY = 0.0;
                                this.Field3634 = 0;
                                if (((Boolean)this.Field3632.Method7979()).booleanValue()) {
                                    Pyro.Field6182.Method8989("Toggling step.");
                                    this.Field5236.Method5266(false);
                                }
                                return;
                            }
                        }
                    } else {
                        f4p2.Method7948();
                        f4p2.Method5834(0.4);
                    }
                }
                if (this.Field3634 != 0 || !this.Field5233.player.onGround || !(d2 <= (Double)this.Field3627.Method7979()) || !(d2 > 0.0)) break;
                f4p2.Method7948();
                f4p2.Method5834((Double)this.Field3627.Method7979() >= 2.5 ? 0.425 : 0.42);
                this.Field5233.player.motionY = 0.0;
                this.Field3634 = 1;
                this.Field3636 = d2;
                this.Field3635 = this.Field5233.player.posY;
                break;
            }
        }
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        f0b.Field5568.Method7904("step");
        this.Field3633 = 0;
        this.Field3637 = 0.0;
        this.Field3638 = false;
    }
}

