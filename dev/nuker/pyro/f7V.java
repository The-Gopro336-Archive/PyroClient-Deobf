/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f4n;
import dev.nuker.pyro.f4q;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f7U;
import dev.nuker.pyro.fe9;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

public class f7V
extends Module {
    public f0o<f7U> Field3260 = new f0o("mode", "Mode", null, f7U.Always);
    public boolean Field3261 = false;
    public int Field3262 = 0;

    public f7V() {
        super("antigapdisease", "AntiGapDisease", "Attempts to get rid of gapple disease.", false);
        this.Method7264(this.Field3260);
    }

    @f0g
    @LauncherEventHide
    public void Method4939(f4q f4q2) {
        if (!this.Field5233.player.getHeldItemMainhand().getItem().equals((Object)Items.GOLDEN_APPLE)) {
            return;
        }
        if (((f7U)((Object)this.Field3260.Method7979())).equals((Object)f7U.Always)) {
            this.Field3261 = true;
        }
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        if (this.Field3261) {
            this.Field5233.player.inventory.currentItem = 0;
            if (++this.Field3262 > 1 && this.Field5233.player.getHeldItemMainhand().getItem() != Items.GOLDEN_APPLE) {
                fe9.Method509(Items.GOLDEN_APPLE);
                this.Field3261 = false;
            }
        }
        if (((f7U)((Object)this.Field3260.Method7979())).equals((Object)f7U.Old) && fe9.Method504((EntityPlayer)this.Field5233.player, Items.GOLDEN_APPLE)) {
            if (++this.Field3262 >= 40) {
                this.Field3261 = true;
                this.Field3262 = 0;
            }
        } else if (!this.Field3261) {
            this.Field3262 = 0;
        }
    }

    @f0g
    @LauncherEventHide
    public void Method5143(f4n f4n2) {
        if (!this.Field5233.player.getHeldItemMainhand().getItem().equals((Object)Items.GOLDEN_APPLE)) {
            return;
        }
        if (((f7U)((Object)this.Field3260.Method7979())).equals((Object)f7U.Always)) {
            this.Field3261 = true;
        }
    }
}

