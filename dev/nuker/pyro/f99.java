/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.Settings$Setting
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import baritone.api.BaritoneAPI;
import baritone.api.Settings;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Class57;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f8L;
import dev.nuker.pyro.f8M;
import dev.nuker.pyro.f8N;
import dev.nuker.pyro.f8O;
import dev.nuker.pyro.f8P;
import dev.nuker.pyro.f8Q;
import dev.nuker.pyro.f8R;
import dev.nuker.pyro.f8S;
import dev.nuker.pyro.f8T;
import dev.nuker.pyro.f8U;
import dev.nuker.pyro.f8V;
import dev.nuker.pyro.f8W;
import dev.nuker.pyro.f8X;
import dev.nuker.pyro.f8Y;
import dev.nuker.pyro.f8Z;
import dev.nuker.pyro.f90;
import dev.nuker.pyro.f91;
import dev.nuker.pyro.f92;
import dev.nuker.pyro.f93;
import dev.nuker.pyro.f94;
import dev.nuker.pyro.f95;
import dev.nuker.pyro.f96;
import dev.nuker.pyro.f97;
import dev.nuker.pyro.f98;
import dev.nuker.pyro.f9c;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f99
extends Module {
    @NotNull
    public BooleanSetting Field3469 = (BooleanSetting)this.Method7264(new BooleanSetting("allowSprint", "Allow Sprint", "Let Baritone sprint", true));
    @NotNull
    public BooleanSetting Field3470 = (BooleanSetting)this.Method7264(new BooleanSetting("allowPlace", "Allow Place", "Let Baritone place blocks", true));
    @NotNull
    public BooleanSetting Field3471 = (BooleanSetting)this.Method7264(new BooleanSetting("allowBreak", "Allow Break", "Let Baritone break blocks", true));
    @NotNull
    public BooleanSetting Field3472 = (BooleanSetting)this.Method7264(new BooleanSetting("allowParkour", "Allow Parkour", "Let Baritone do parkour", false));
    @NotNull
    public BooleanSetting Field3473 = (BooleanSetting)this.Method7264(new BooleanSetting("allowParkourPlace", "Allow Parkour Place", "Let Baritone place blocks while doing parkour", false));
    @NotNull
    public BooleanSetting Field3474 = (BooleanSetting)this.Method7264(new BooleanSetting("allowInventory", "Allow Inventory Use", "Let Baritone use things in your inventory", false));
    @NotNull
    public BooleanSetting Field3475 = (BooleanSetting)this.Method7264(new BooleanSetting("mapartMode", "Map Art Mode", "Enable Map art mode - tbh not totally sure what this does", false));
    @NotNull
    public BooleanSetting Field3476 = (BooleanSetting)this.Method7264(new BooleanSetting("sneakCancel", "Sneak2Stop", "Stops Baritone when you sneak", true));
    @NotNull
    public BooleanSetting Field3477 = (BooleanSetting)this.Method7264(new BooleanSetting("antiElytra", "Anti Elytra", "Stops Baritone from accidentally triggering elytra", true));
    @NotNull
    public f0l Field3478 = (f0l)this.Method7264(new f0l("pathColor", "Path Color", "Finalized path color", f00.Field5379.Method7937(Color.RED)));
    @NotNull
    public f0l Field3479 = (f0l)this.Method7264(new f0l("nextColor", "Next Path Color", "Color for next path segment", f00.Field5379.Method7937(Color.MAGENTA)));
    @NotNull
    public f0l Field3480 = (f0l)this.Method7264(new f0l("bestColor", "Best Path Color", "Color for next best path segment", f00.Field5379.Method7937(Color.BLUE)));
    @NotNull
    public f0l Field3481 = (f0l)this.Method7264(new f0l("consideringColor", "Considering Path Color", "Last checked path color", f00.Field5379.Method7937(Color.CYAN)));
    @NotNull
    public f0l Field3482 = (f0l)this.Method7264(new f0l("goalColor", "Goal Color", "Goal box color", f00.Field5379.Method7937(Color.GREEN)));
    public boolean Field3483;

    @NotNull
    public BooleanSetting Method276() {
        return this.Field3476;
    }

    @NotNull
    public BooleanSetting Method271() {
        return this.Field3474;
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field3473;
    }

    @f0g
    @LauncherEventHide
    public void Method2393(@NotNull f49 f492) {
        block5: {
            block6: {
                if (f492.Method5619() != f41.Pre) break block5;
                if (!(f492.Method5784() instanceof CPacketEntityAction)) break block5;
                if (((Boolean)PyroStatic.Field6403.Field5236.Method5264()).booleanValue() && !PyroStatic.Field6403.Method2269()) break block6;
                if (!((Boolean)PyroStatic.Field6425.Field3477.Method7979()).booleanValue()) break block5;
                if (!BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing()) break block5;
            }
            Packet packet = f492.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketEntityAction");
            }
            CPacketEntityAction cPacketEntityAction = (CPacketEntityAction)packet;
            if (cPacketEntityAction.getAction() == CPacketEntityAction.Action.START_FALL_FLYING) {
                f492.Method7948();
            }
        }
    }

    @NotNull
    public BooleanSetting Method2424() {
        return this.Field3475;
    }

    public Class57 Method5272(Settings.Setting setting, Function1 function1, Function1 function12) {
        return new f98(setting, function1, function12);
    }

    @NotNull
    public f0l Method5273() {
        return this.Field3480;
    }

    public void Method5008() {
        if (this.Field3483) {
            this.Field3469.Method7978(this.Method5272(BaritoneAPI.getSettings().allowSprint, f8L.Field3455, f8W.Field3461));
            this.Field3470.Method7978(this.Method5272(BaritoneAPI.getSettings().allowPlace, f91.Field3425, f92.Field3445));
            this.Field3471.Method7978(this.Method5272(BaritoneAPI.getSettings().allowBreak, f93.Field3448, f94.Field3492));
            this.Field3472.Method7978(this.Method5272(BaritoneAPI.getSettings().allowParkour, f95.Field3496, f96.Field3500));
            this.Field3473.Method7978(this.Method5272(BaritoneAPI.getSettings().allowParkourPlace, f97.Field3503, f8M.Field3457));
            this.Field3474.Method7978(this.Method5272(BaritoneAPI.getSettings().allowInventory, f8N.Field3459, f8O.Field3421));
            this.Field3475.Method7978(this.Method5272(BaritoneAPI.getSettings().mapArtMode, f8P.Field3424, f8Q.Field3444));
            this.Field3478.Method7978(this.Method5272(BaritoneAPI.getSettings().colorCurrentPath, f8R.Field3447, f8S.Field3491));
            this.Field3479.Method7978(this.Method5272(BaritoneAPI.getSettings().colorNextPath, f8T.Field3495, f8U.Field3499));
            this.Field3480.Method7978(this.Method5272(BaritoneAPI.getSettings().colorBestPathSoFar, f8V.Field3502, f8X.Field3468));
            this.Field3481.Method7978(this.Method5272(BaritoneAPI.getSettings().colorMostRecentConsidered, f8Y.Field3485, f8Z.Field3487));
            this.Field3482.Method7978(this.Method5272(BaritoneAPI.getSettings().colorGoalBox, f9c.Field3713, f90.Field3422));
        }
    }

    public void Method557(boolean bl) {
        this.Field3483 = bl;
    }

    @NotNull
    public f0l Method5274() {
        return this.Field3478;
    }

    public boolean Method4876() {
        return this.Field3483;
    }

    @NotNull
    public BooleanSetting Method281() {
        return this.Field3472;
    }

    @NotNull
    public BooleanSetting Method273() {
        return this.Field3469;
    }

    @NotNull
    public f0l Method2369() {
        return this.Field3481;
    }

    @NotNull
    public BooleanSetting Method269() {
        return this.Field3477;
    }

    @NotNull
    public f0l Method214() {
        return this.Field3482;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        if (bl) {
            this.Field5236.Method5266(false);
        }
    }

    public f99() {
        super("baritone", "Baritone", "Settings for baritone");
        try {
            this.Field3483 = Pyro.class.getClassLoader().loadClass("baritone.api.BaritoneAPI") != null;
            Pyro.Method8978().Method7915(this);
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
    }

    @NotNull
    public BooleanSetting Method283() {
        return this.Field3471;
    }

    @NotNull
    public f0l Method2368() {
        return this.Field3479;
    }

    @NotNull
    public BooleanSetting Method279() {
        return this.Field3470;
    }
}

