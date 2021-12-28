/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fac
extends Module {
    @NotNull
    public IntegerSetting Field1793 = (IntegerSetting)this.Method7264(new IntegerSetting("directions", "Directions", "Number of snap directions. A multiple of 2 is recommended", 8, 2, 16, 0, 64, null));
    @NotNull
    public BooleanSetting Field1794 = (BooleanSetting)this.Method7264(new BooleanSetting("lock_mouse", "Lock Mouse", "You can't move the mouse at all..", false));
    @NotNull
    public IntegerSetting Field1795 = (IntegerSetting)this.Method7264(new IntegerSetting("snap_ticks", "Snap Ticks", "Delay between mouse movement and snapping to yaw", 10, 0, 200, 0, 64, null));
    public int Field1796;
    public float Field1797 = FloatCompanionObject.Field5818.Method8423();

    public int Method2499() {
        return this.Field1796;
    }

    public float Method2500(float f, int n) {
        return (float)MathKt.Method9439(f / (360.0f / (float)n)) * (360.0f / (float)n);
    }

    public float Method2420() {
        return this.Field1797;
    }

    @NotNull
    public IntegerSetting Method2501() {
        return this.Field1795;
    }

    public void Method541(int n) {
        this.Field1796 = n;
    }

    @f0g
    @LauncherEventHide
    public void Method277(@NotNull f43 f432) {
        if (this.Field5233.player == null) {
            return;
        }
        if (f432.Method5619() == f41.Pre && ((Boolean)this.Field1794.Method7979()).booleanValue()) {
            this.Field5233.player.rotationYaw = this.Field1797;
        }
        if (((Boolean)this.Field1794.Method7979()).booleanValue()) {
            this.Field5233.player.rotationYaw = this.Field1797;
        } else {
            if (this.Field5233.player.rotationYaw != this.Field1797) {
                this.Field1796 = ((Number)this.Field1795.Method7979()).intValue();
                this.Field1797 = this.Field5233.player.rotationYaw;
            }
            if (this.Field1796 <= 0) {
                this.Field1797 = this.Field5233.player.rotationYaw = this.Method2500(this.Field5233.player.rotationYaw, ((Number)this.Field1793.Method7979()).intValue());
            }
            if (this.Field1796 > 0) {
                int n = this.Field1796;
                this.Field1796 = n + -1;
            }
        }
    }

    public void Method544(float f) {
        this.Field1797 = f;
    }

    public fac() {
        super("yaw_lock", "YawLock", "Lock your yaw so you can fly straight down a highway");
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field1794;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (entityPlayerSP == null) {
            return;
        }
        this.Field1797 = bl && (Boolean)this.Field1794.Method7979() != false ? this.Method2500(entityPlayerSP.rotationYaw, ((Number)this.Field1793.Method7979()).intValue()) : FloatCompanionObject.Field5818.Method8423();
        this.Field1796 = 0;
    }

    @NotNull
    public IntegerSetting Method2502() {
        return this.Field1793;
    }
}

