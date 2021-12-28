/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.EntityFishHook
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketExplosion
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f4x;
import dev.nuker.pyro.f72;
import dev.nuker.pyro.mixin.SPacketEntityVelocityAccessor;
import dev.nuker.pyro.mixin.SPacketExplosionAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class f73
extends Module {
    @NotNull
    public f0o<f72> Field3083 = (f0o)this.Method7264(new f0o("mode", "Mode", null, f72.Normal));
    @NotNull
    public IntegerSetting Field3084 = (IntegerSetting)this.Method7264(new IntegerSetting("horizontal", "Horizontal", "The horizontal velocity you will take", 0, 0, 100, 1));
    @NotNull
    public IntegerSetting Field3085 = (IntegerSetting)this.Method7264(new IntegerSetting("vertical", "Vertical", "The vertical velocity you will take", 0, 0, 100, 1));
    @NotNull
    public BooleanSetting Field3086 = (BooleanSetting)this.Method7264(new BooleanSetting("explosions", "Explosions", "Apply the velocity modifier on explosions", true));
    @NotNull
    public BooleanSetting Field3087 = (BooleanSetting)this.Method7264(new BooleanSetting("bobbers", "Bobbers", "Apply the velocity modifier on fishing bobber velocity", true));
    @NotNull
    public BooleanSetting Field3088 = (BooleanSetting)this.Method7264(new BooleanSetting("nopush", "NoPush", "Disables collision movement", true));

    @NotNull
    public BooleanSetting Method274() {
        return this.Field3086;
    }

    @NotNull
    public BooleanSetting Method284() {
        return this.Field3088;
    }

    @NotNull
    public IntegerSetting Method4960() {
        return this.Field3084;
    }

    public f73() {
        super("velocity", "Velocity", "Allows you to modify the velocity you receive");
    }

    @NotNull
    public IntegerSetting Method2751() {
        return this.Field3085;
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre) {
            if ((f72)((Object)this.Field3083.Method7979()) != f72.Normal) {
                this.Method7274(((f72)((Object)this.Field3083.Method7979())).toString());
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
                String string = "H:%s%% V:%s%%";
                Object[] arrobject = new Object[]{this.Field3084.Method7979(), this.Field3085.Method7979()};
                f73 f732 = this;
                boolean bl = false;
                String string2 = String.format(string, Arrays.copyOf(arrobject, arrobject.length));
                f732.Method7274(string2);
            }
            if ((f72)((Object)this.Field3083.Method7979()) == f72.AAC && this.Field5233.player.hurtTime != 0) {
                f4u2.Method7948();
                f4u2.Method5597(true);
            }
        }
    }

    @NotNull
    public f0o Method241() {
        return this.Field3083;
    }

    @f0g
    @LauncherEventHide
    public void Method556(@NotNull f4x f4x2) {
        if (((Boolean)this.Field3088.Method7979()).booleanValue()) {
            f4x2.Method7948();
        }
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field3087;
    }

    @f0g
    @LauncherEventHide
    public void Method244(@NotNull f4e f4e2) {
        if (this.Field5233.world == null || this.Field5233.player == null || f4e2.Method5619() != f41.Pre) {
            return;
        }
        if ((f72)((Object)this.Field3083.Method7979()) == f72.Normal) {
            if (f4e2.Method5784() instanceof SPacketEntityStatus && ((Boolean)this.Field3087.Method7979()).booleanValue()) {
                Entity entity;
                Packet packet = f4e2.Method5784();
                if (packet == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketEntityStatus");
                }
                SPacketEntityStatus sPacketEntityStatus = (SPacketEntityStatus)packet;
                if (sPacketEntityStatus.getOpCode() == 31 && (entity = sPacketEntityStatus.getEntity((World)this.Field5233.world)) != null && entity instanceof EntityFishHook && ((EntityFishHook)entity).caughtEntity == this.Field5233.player) {
                    f4e2.Method7948();
                }
            } else if (f4e2.Method5784() instanceof SPacketEntityVelocity) {
                Packet packet = f4e2.Method5784();
                if (packet == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketEntityVelocity");
                }
                SPacketEntityVelocity sPacketEntityVelocity = (SPacketEntityVelocity)packet;
                if (sPacketEntityVelocity == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.SPacketEntityVelocityAccessor");
                }
                SPacketEntityVelocityAccessor sPacketEntityVelocityAccessor = (SPacketEntityVelocityAccessor)sPacketEntityVelocity;
                if (sPacketEntityVelocityAccessor.Method4293() == this.Field5233.player.getEntityId()) {
                    if (((Number)this.Field3084.Method7979()).intValue() == 0 && ((Number)this.Field3085.Method7979()).intValue() == 0) {
                        f4e2.Method7948();
                        return;
                    }
                    if (((Number)this.Field3084.Method7979()).intValue() != 100) {
                        sPacketEntityVelocityAccessor.Method4288(sPacketEntityVelocityAccessor.Method4287() / 100 * ((Number)this.Field3084.Method7979()).intValue());
                        sPacketEntityVelocityAccessor.Method4292(sPacketEntityVelocityAccessor.Method4291() / 100 * ((Number)this.Field3084.Method7979()).intValue());
                    }
                    if (((Number)this.Field3085.Method7979()).intValue() != 100) {
                        sPacketEntityVelocityAccessor.Method4290(sPacketEntityVelocityAccessor.Method4289() / 100 * ((Number)this.Field3085.Method7979()).intValue());
                    }
                }
            } else if (f4e2.Method5784() instanceof SPacketExplosion && ((Boolean)this.Field3086.Method7979()).booleanValue()) {
                Packet packet = f4e2.Method5784();
                if (packet == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketExplosion");
                }
                SPacketExplosion sPacketExplosion = (SPacketExplosion)packet;
                if (sPacketExplosion == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.SPacketExplosionAccessor");
                }
                SPacketExplosionAccessor sPacketExplosionAccessor = (SPacketExplosionAccessor)sPacketExplosion;
                if (((Number)this.Field3084.Method7979()).intValue() == 0 && ((Number)this.Field3085.Method7979()).intValue() == 0) {
                    f4e2.Method7948();
                    return;
                }
                if (((Number)this.Field3084.Method7979()).intValue() != 100) {
                    sPacketExplosionAccessor.Method2005(sPacketExplosionAccessor.Method2004() / (float)100 * ((Number)this.Field3084.Method7979()).floatValue());
                    sPacketExplosionAccessor.Method2009(sPacketExplosionAccessor.Method2008() / (float)100 * ((Number)this.Field3084.Method7979()).floatValue());
                }
                if (((Number)this.Field3085.Method7979()).intValue() != 100) {
                    sPacketExplosionAccessor.Method2007(sPacketExplosionAccessor.Method2006() / (float)100 * ((Number)this.Field3085.Method7979()).floatValue());
                }
            }
        }
    }
}

