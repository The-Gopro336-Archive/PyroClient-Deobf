/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f9n;
import dev.nuker.pyro.f9o;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f9p
extends Module {
    public BooleanSetting Field4460 = new BooleanSetting("damage", "Damage", null, false);
    public f0o<f9o> Field4461 = new f0o("mode", "Mode", null, f9o.Creative);
    public DoubleSetting Field4462 = new DoubleSetting("glideSpeed", "GlideSpeed", null, 1.0, 0.0, 10.0);
    public BooleanSetting Field4463 = new BooleanSetting("animation", "Animation", null, true);
    public BooleanSetting Field4464 = new BooleanSetting("glide", "Glide", null, false);
    public DoubleSetting Field4465 = new DoubleSetting("speed", "Speed", null, 10.0, 0.0, 20.0);
    public DoubleSetting Field4466 = new DoubleSetting("aacY", "AACY", null, 0.83, 0.0, 10.0);
    public BooleanSetting Field4467 = new BooleanSetting("antiFallDamage", "Anti Fall Damage", null, false);
    public BooleanSetting Field4468 = new BooleanSetting("antiKick", "AntiKick", null, true);
    public int Field4469;

    @f0g
    @LauncherEventHide
    public void Method2393(f49 f492) {
        if (f492.Method5619() == f41.Pre) {
            if (!f492.Method7947()) {
                switch (f9n.Field4479[((f9o)((Object)this.Field4461.Method7979())).ordinal()]) {
                    case 1: {
                        if (!(this.Field5233.player.fallDistance > 3.8f) || !(f492.Method5784() instanceof CPacketPlayer)) break;
                        CPacketPlayerAccessor cPacketPlayerAccessor = (CPacketPlayerAccessor)f492.Method5784();
                        cPacketPlayerAccessor.Method8722(true);
                        this.Field5233.player.fallDistance = 0.0f;
                        break;
                    }
                    case 2: {
                        if (!((Boolean)this.Field4467.Method7979()).booleanValue() || !(f492.Method5784() instanceof CPacketPlayer)) break;
                        CPacketPlayerAccessor cPacketPlayerAccessor = (CPacketPlayerAccessor)f492.Method5784();
                        cPacketPlayerAccessor.Method8722(false);
                        break;
                    }
                }
            }
        }
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        switch (f9n.Field4479[((f9o)((Object)this.Field4461.Method7979())).ordinal()]) {
            case 1: {
                if ((float)this.Field5233.player.hurtTime != 10.0f) break;
                this.Field5233.player.motionY = (Double)this.Field4466.Method7979();
            }
        }
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Method7274(String.valueOf(this.Field4461.Method7979()));
        if (((Boolean)this.Field4460.Method7979()).booleanValue() && bl) {
            fec.Method731();
        }
    }

    public void Method6412(f0w f0w2) {
        this.Method7274(String.valueOf(this.Field4461.Method7979()));
    }

    @f0g(value=1337)
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (f4u2.Method7947() || f4u2.Method5619() != f41.Pre) {
            return;
        }
        if (((Boolean)this.Field4468.Method7979()).booleanValue() && this.Method6413(this.Field4469 + 1) >= 12 && !this.Field5233.player.isPotionActive(MobEffects.LEVITATION) && !this.Field5233.player.isElytraFlying() && this.Field5233.world.getCollisionBoxes((Entity)this.Field5233.player, this.Field5233.player.getEntityBoundingBox().grow(0.0625).expand(0.05, -0.55, 0.05)).isEmpty()) {
            f4u2.Method7948();
            f4u2.Method5820(f4u2.Method5815() - 0.03126);
            f4u2.Method5597(true);
            if (this.Field4469 >= 22) {
                this.Field4469 = 0;
            }
        }
    }

    public int Method6413(int n) {
        this.Field4469 = n;
        return this.Field4469;
    }

    public f9p() {
        super("flight", "Flight", "Allows you to fly");
        this.Method7264(this.Field4460);
        this.Method7264(this.Field4461);
        this.Method7264(this.Field4462);
        this.Method7264(this.Field4463);
        this.Method7264(this.Field4464);
        this.Method7264(this.Field4465);
        this.Method7264(this.Field4466);
        this.Method7264(this.Field4467);
        this.Method7264(this.Field4468);
        this.Field4461.Method7980(this::Method6412);
    }

    @f0g(value=1337)
    @LauncherEventHide
    public void Method559(f4p f4p2) {
        switch (f9n.Field4479[((f9o)((Object)this.Field4461.Method7979())).ordinal()]) {
            case 2: {
                f4p2.Method7948();
                this.Field5233.player.setVelocity(0.0, 0.0, 0.0);
                f4p2.Method5837(0.0);
                f4p2.Method5834(0.0);
                f4p2.Method5820(0.0);
                if (!fec.Method727()) {
                    // empty if block
                }
                if (this.Field5233.player.movementInput.jump) {
                    f4p2.Method5834((Double)this.Field4465.Method7979() / 10.0);
                } else if (this.Field5233.player.movementInput.sneak) {
                    f4p2.Method5834(-((Double)this.Field4465.Method7979() / 10.0));
                }
                if (((Boolean)this.Field4464.Method7979()).booleanValue()) {
                    f4p2.Method5834(f4p2.Method5815() - (Double)this.Field4462.Method7979());
                }
                double[] arrd = fec.Method732((Double)this.Field4465.Method7979() / 10.0);
                if (arrd == null) break;
                f4p2.Method5837(arrd[0]);
                f4p2.Method5820(arrd[1]);
                break;
            }
            case 3: {
                f4p2.Method7948();
                if (((Boolean)this.Field4463.Method7979()).booleanValue()) {
                    this.Field5233.player.onGround = true;
                    this.Field5233.player.fallDistance = 0.0f;
                    this.Field5233.player.jumpMovementFactor = 0.0f;
                }
                float f = (float)((Double)this.Field4465.Method7979() / 10.0);
                if (this.Field5233.player.movementInput.jump) {
                    this.Field5233.player.motionY = f;
                    f4p2.Method5834(this.Field5233.player.motionY);
                } else if (this.Field5233.player.movementInput.sneak) {
                    this.Field5233.player.motionY = -f;
                    f4p2.Method5834(this.Field5233.player.motionY);
                } else {
                    this.Field5233.player.motionY = 0.0;
                    f4p2.Method5834(0.0);
                    if (!this.Field5233.player.collidedVertically && ((Boolean)this.Field4464.Method7979()).booleanValue()) {
                        f4p2.Method5834(this.Field5233.player.motionY -= ((Double)this.Field4462.Method7979()).doubleValue());
                    }
                }
                fec.Method744(f4p2, (Double)this.Field4465.Method7979() / 10.0);
                break;
            }
            case 1: {
                if (this.Field5233.player.onGround || !fec.Method727()) {
                    return;
                }
                f4p2.Method7948();
                fec.Method744(f4p2, 0.4521096646785736);
                break;
            }
        }
    }
}

