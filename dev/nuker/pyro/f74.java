/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;

public class f74
extends Module {
    @NotNull
    public BooleanSetting Field3092 = (BooleanSetting)this.Method7264(new BooleanSetting("ground", "Ground", null, true));
    @NotNull
    public BooleanSetting Field3093 = (BooleanSetting)this.Method7264(new BooleanSetting("sprint", "Sprint", null, true));
    public boolean Field3094;
    @NotNull
    public fe8 Field3095 = new fe8();

    @NotNull
    public BooleanSetting Method215() {
        return this.Field3093;
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field3092;
    }

    public boolean Method2390() {
        return this.Field3094;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @f0g
    @LauncherEventHide
    public void Method2393(@NotNull f49 var1_1) {
        block9: {
            if (var1_1.Method5619() != f41.Pre) {
                return;
            }
            if (this.Field5233.player == null) {
                return;
            }
            if (!(var1_1.Method5784() instanceof CPacketPlayer) || !((Boolean)this.Field3092.Method7979()).booleanValue()) break block9;
            if (this.Field3095.Method491(5000.0)) {
                if (!this.Field5233.player.isElytraFlying() && this.Field3094) {
                    this.Field3094 = false;
                }
            }
            if (this.Field5233.player.isElytraFlying() || this.Field3094) break block9;
            v0 = var1_1.Method5784();
            if (v0 == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.CPacketPlayerAccessor");
            }
            var2_2 = (CPacketPlayerAccessor)v0;
            if (this.Field5233.player.fallDistance > (float)false) ** GOTO lbl-1000
            if (this.Field5233.playerController.getIsHittingBlock()) lbl-1000:
            // 2 sources

            {
                var2_2.Method8722(true);
            } else {
                var2_2.Method8722(false);
            }
        }
        if (var1_1.Method5784() instanceof CPacketEntityAction == false) return;
        if ((Boolean)this.Field3093.Method7979() == false) return;
        v1 = var1_1.Method5784();
        if (v1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketEntityAction");
        }
        var2_2 = (CPacketEntityAction)v1;
        if (var2_2.getAction() == CPacketEntityAction.Action.START_SPRINTING || var2_2.getAction() == CPacketEntityAction.Action.STOP_SPRINTING) {
            var1_1.Method7948();
        }
        if (var2_2.getAction() != CPacketEntityAction.Action.START_FALL_FLYING) return;
        this.Field3094 = true;
        this.Field3095.Method490();
    }

    public void Method557(boolean bl) {
        this.Field3094 = bl;
    }

    @NotNull
    public fe8 Method4964() {
        return this.Field3095;
    }

    public void Method4965(@NotNull fe8 fe82) {
        this.Field3095 = fe82;
    }

    public f74() {
        super("antihunger", "AntiHunger", "Allows you greatly reduce hunger loss by modifying packets you send");
    }
}

