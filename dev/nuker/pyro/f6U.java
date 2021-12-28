/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f6u
extends Module {
    public BooleanSetting Field3257 = new BooleanSetting("onRender", "OnRender", null, false);
    public BooleanSetting Field3258 = new BooleanSetting("noTotems", "NoTotems", null, true);
    public DoubleSetting Field3259 = new DoubleSetting("health", "Health", null, 5.0, 1.0, 19.0);

    public f6u() {
        super("autolog", "AutoLog", "Logs out when requirements are met.");
        this.Method7264(this.Field3257);
        this.Method7264(this.Field3258);
        this.Method7264(this.Field3259);
    }

    public void Method5142(String string) {
        if (this.Field5233.getConnection() == null) {
            this.Field5233.world.sendQuittingDisconnectingPacket();
        } else {
            this.Field5233.getConnection().getNetworkManager().closeChannel((ITextComponent)new TextComponentString(string));
        }
        PyroStatic.Field6415.Field5236.Method5266(false);
        this.Field5236.Method5266(false);
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        this.Method7274(String.valueOf(String.format("%.1f", this.Field3259.Method7979())));
        if (this.Field5233.player.isEntityAlive()) {
            int n;
            if (((Boolean)this.Field3257.Method7979()).booleanValue()) {
                n = ((Boolean)PyroStatic.Field6445.Field3549.Method7979()).booleanValue();
                PyroStatic.Field6445.Field3549.Method7975(true);
                boolean bl = false;
                for (EntityPlayer entityPlayer : this.Field5233.world.playerEntities) {
                    if (!PyroStatic.Field6445.Method5355((Entity)entityPlayer, null, false)) continue;
                    this.Method5142("[AutoLog] " + entityPlayer.getName() + " came into render distance.");
                    break;
                }
                PyroStatic.Field6445.Field3549.Method7975(n != 0);
                if (bl) {
                    return;
                }
            }
            if (((Boolean)this.Field3258.Method7979()).booleanValue()) {
                if (this.Field5233.world.isBlockLoaded(new BlockPos(this.Field5233.player.lastTickPosX, this.Field5233.player.lastTickPosY, this.Field5233.player.lastTickPosZ), false) && this.Field5233.world.isBlockLoaded(new BlockPos(this.Field5233.player.posX, this.Field5233.player.posY, this.Field5233.player.posZ), false) && PyroStatic.Field6428.Method2499() > 0) {
                    return;
                }
            }
            if ((double)(this.Field5233.player.getHealth() + this.Field5233.player.getAbsorptionAmount()) <= (Double)this.Field3259.Method7979()) {
                if (!((Boolean)this.Field3258.Method7979()).booleanValue()) {
                    n = PyroStatic.Field6428.Method2499();
                    this.Method5142("[AutoLog] Logged out with " + n + " totems and " + this.Field5233.player.getHealth() + " hearts remaining.");
                } else {
                    this.Method5142("[AutoLog] Logged out with " + this.Field5233.player.getHealth() + " hearts remaining.");
                }
            }
        }
    }
}

