/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f04;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.mixin.MinecraftAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f71
extends Module {
    public BooleanSetting Field2983 = new BooleanSetting("hitDelay", "HitDelay", null, true);
    public BooleanSetting Field2984 = new BooleanSetting("tpsSync", "TPSSync", null, true);
    public IntegerSetting Field2985 = new IntegerSetting("tickDelay", "TickDelay", "How many ticks to wait each hit", 2, 0, 20);
    public int Field2986 = 0;

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        ++this.Field2986;
        if (this.Field5233.objectMouseOver != null && this.Field5233.objectMouseOver.entityHit != null && this.Method4876()) {
            ((MinecraftAccessor)this.Field5233).Method6091(0);
            this.Field5233.playerController.attackEntity((EntityPlayer)this.Field5233.player, this.Field5233.objectMouseOver.entityHit);
            this.Field5233.player.swingArm(EnumHand.MAIN_HAND);
        }
        if (this.Field2986 >= (Integer)this.Field2985.Method7979()) {
            this.Field2986 = 0;
        }
    }

    public f71() {
        super("trigger", "Trigger", "Automatically swings when your crosshair is over an entity");
        this.Method7264(this.Field2983);
        this.Method7264(this.Field2984);
        this.Method7264(this.Field2985);
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field2986 = 0;
    }

    public boolean Method4876() {
        if (!((Boolean)this.Field2983.Method7979()).booleanValue()) {
            return this.Field2986 >= (Integer)this.Field2985.Method7979();
        }
        float f = 20.0f - f04.Field5418.Method7642();
        return ((Boolean)this.Field2983.Method7979()).booleanValue() ? this.Field5233.player.getCooledAttackStrength((Boolean)this.Field2984.Method7979() != false ? -f : 0.0f) >= 1.0f : true;
    }
}

