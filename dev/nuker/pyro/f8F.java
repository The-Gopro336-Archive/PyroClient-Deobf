/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f07;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.far;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import kotlin.ranges.RangesKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8F
extends Module {
    @NotNull
    public DoubleSetting Field3413 = (DoubleSetting)this.Method7264(new DoubleSetting("speed", "Speed", null, 1.15, 1.0, 2.149, 0.0, 64, null));
    @NotNull
    public DoubleSetting Field3414 = (DoubleSetting)this.Method7264(new DoubleSetting("yMotion", "YMotion", null, 0.4, 0.01, 0.415, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field3415 = (BooleanSetting)this.Method7264(new BooleanSetting("autoJump", "AutoJump", null, false));
    @NotNull
    public DoubleSetting Field3416 = (DoubleSetting)this.Method7264(new DoubleSetting("timer", "Timer", null, 1.088, 1.0, 2.0, 0.0, 64, null));
    public double Field3417;
    public int Field3418 = 4;
    public double Field3419 = far.Method2606();

    public double Method5217() {
        return this.Field3419;
    }

    public double Method5218() {
        return this.Field3417;
    }

    /*
     * Enabled aggressive block sorting
     */
    @f0g(value=-1)
    @LauncherEventHide
    public void Method559(@NotNull f4p f4p2) {
        if (f4p2.Method7947()) return;
        if (f4p2.Method5619() != f41.Pre) return;
        boolean bl = this.Field5233.player.movementInput.jump;
        if (!bl) {
            bl = (Boolean)this.Field3415.Method7979();
        }
        if (bl && fec.Method727()) {
            if (this.Field3418 == 1) {
                f0b.Field5568.Method7902("airstrafe", f07.MULTIPLY, (float)((Number)this.Field3416.Method7979()).doubleValue());
                this.Field3419 = 1.35 * far.Method2606() - 0.01;
            } else if (this.Field3418 == 2 && this.Field5233.player.collidedVertically) {
                f4p2.Method7948();
                Object object = this.Field3414.Method7979();
                f4p f4p3 = f4p2;
                boolean bl2 = false;
                boolean bl3 = false;
                double d = ((Number)object).doubleValue();
                boolean bl4 = false;
                this.Field5233.player.motionY = d;
                Object object2 = object;
                f4p3.Method5834(((Number)object2).doubleValue());
                this.Field3419 *= ((Number)this.Field3413.Method7979()).doubleValue();
            } else if (this.Field3418 == 3) {
                double d = 0.66 * (this.Field3417 - far.Method2606());
                this.Field3419 = this.Field3417 - d;
            } else {
                List list = this.Field5233.world.getCollisionBoxes((Entity)this.Field5233.player, this.Field5233.player.getEntityBoundingBox().offset(0.0, this.Field5233.player.motionY, 0.0));
                if ((list.size() > 0 || this.Field5233.player.collidedVertically) && this.Field3418 > 0) {
                    this.Field3418 = 1;
                }
                this.Field3419 = this.Field3417 - this.Field3417 / 159.0;
            }
            this.Field3419 = RangesKt.Method4261(this.Field3419, far.Method2606());
            f4p2.Method7948();
            fec.Method744(f4p2, this.Field3419);
            ++this.Field3418;
            return;
        }
        f0b.Field5568.Method7904("airstrafe");
        this.Field3418 = 0;
    }

    @NotNull
    public DoubleSetting Method220() {
        return this.Field3416;
    }

    @NotNull
    public BooleanSetting Method282() {
        return this.Field3415;
    }

    public void Method2415(double d) {
        this.Field3417 = d;
    }

    @NotNull
    public DoubleSetting Method219() {
        return this.Field3414;
    }

    public f8F() {
        super("airstrafe", "AirStrafe", "Allows you to strafe while in air, speed will override this, useful while using OnGround speed or manually jumping");
    }

    @NotNull
    public DoubleSetting Method2279() {
        return this.Field3413;
    }

    @f0g
    @LauncherEventHide
    public void Method244(@NotNull f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre && f4e2.Method5784() instanceof SPacketPlayerPosLook) {
            this.Field3418 = 4;
            this.Field3419 = far.Method2606();
            this.Field3417 = 0.0;
        }
    }

    public void Method541(int n) {
        this.Field3418 = n;
    }

    public void Method2401(double d) {
        this.Field3419 = d;
    }

    public int Method5125() {
        return this.Field3418;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field3418 = 4;
        f0b.Field5568.Method7904("airstrafe");
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        double d;
        if (f4u2.Method5619() != f41.Pre) {
            return;
        }
        double d2 = this.Field5233.player.posX - this.Field5233.player.prevPosX;
        double d3 = this.Field5233.player.posZ - this.Field5233.player.prevPosZ;
        double d4 = d2 * d2 + d3 * d3;
        f8F f8F2 = this;
        boolean bl = false;
        f8F2.Field3417 = d = Math.sqrt(d4);
    }
}

