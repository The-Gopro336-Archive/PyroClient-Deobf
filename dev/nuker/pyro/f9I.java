/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.mixin.EntityPlayerSPAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

public class f9i
extends Module {
    @NotNull
    public BooleanSetting Field4422 = (BooleanSetting)this.Method7264(new BooleanSetting("control", "Control", null, true));
    @NotNull
    public DoubleSetting Field4423 = (DoubleSetting)this.Method7264(new DoubleSetting("jumpStrength", "JumpStrength", null, 1.0, 0.0, 1.0, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field4424 = (BooleanSetting)this.Method7264(new BooleanSetting("noPigAI", "No Pig AI", null, true));

    @f0g
    @LauncherEventHide
    public void Method183(@NotNull f4t f4t2) {
        if (this.Field5233.player.isRidingHorse()) {
            if (((Number)this.Field4423.Method7979()).doubleValue() > 0.0) {
                EntityPlayerSP entityPlayerSP = this.Field5233.player;
                if (entityPlayerSP == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityPlayerSPAccessor");
                }
                ((EntityPlayerSPAccessor)entityPlayerSP).Method9339(1.0f);
            }
        }
    }

    @NotNull
    public DoubleSetting Method238() {
        return this.Field4423;
    }

    public f9i() {
        super("entitycontrol", "EntityControl", "Allows you to control horses, donkeys and llamas without a saddle");
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field4424;
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field4422;
    }
}

