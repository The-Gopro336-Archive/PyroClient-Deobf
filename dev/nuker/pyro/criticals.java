/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4h;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f6E;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.mode;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class criticals
extends Module {
    public f0o<mode> Field3089 = (f0o)this.Method7264(new f0o("mode", "Mode", "The mode of criticals to do", mode.Packet));

    public criticals() {
        super("criticals", "Criticals", "Deal a critical hit on every attack");
    }

    public void Method2407(@Nullable Entity entity) {
        if (this.Field5233.player.fallDistance == 1337.0f) {
            this.Field5233.player.fallDistance = 0.0f;
        }
    }

    @f0g
    @LauncherEventHide
    public void Method4961(@NotNull f4h f4h2) {
        block14: {
            block13: {
                if (f4h2.Method5619() == f41.Post) {
                    if (this.Field5233.player.fallDistance == 1337.0f) {
                        this.Field5233.player.fallDistance = 0.0f;
                    }
                    return;
                }
                if (this.Field5233.player.fallDistance > 0.0f || !(f4h2.Method5637() instanceof EntityLivingBase)) {
                    return;
                }
                if (((Boolean)PyroStatic.Field6430.Field5236.Method5264()).booleanValue() && fec.Method727()) {
                    return;
                }
                if (!this.Field5233.player.onGround || !this.Field5233.player.collidedVertically) break block13;
                if (this.Field5233.player.isInLava()) break block13;
                if (!this.Field5233.player.isInWater()) break block14;
            }
            return;
        }
        switch (f6E.Field2905[((mode)((Object)this.Field3089.Method7979())).ordinal()]) {
            case 1: {
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.11, this.Field5233.player.posZ, false));
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.1100013579, this.Field5233.player.posZ, false));
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.3579E-6, this.Field5233.player.posZ, false));
                break;
            }
            case 2: {
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + (double)0.05f, this.Field5233.player.posZ, false));
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY, this.Field5233.player.posZ, false));
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + (double)0.012511f, this.Field5233.player.posZ, false));
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY, this.Field5233.player.posZ, false));
                break;
            }
            case 3: {
                this.Field5233.player.jump();
                break;
            }
            case 4: {
                this.Field5233.player.jump();
                this.Field5233.player.motionY /= 1.7;
            }
        }
        this.Field5233.player.fallDistance = 1337.0f;
    }

    @f0g
    @LauncherEventHide
    public void Method183(@Nullable f4t f4t2) {
        this.Method7274(((mode)((Object)this.Field3089.Method7979())).toString());
    }
}

