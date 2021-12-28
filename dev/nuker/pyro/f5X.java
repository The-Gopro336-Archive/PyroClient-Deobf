/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f5W;
import dev.nuker.pyro.f5Y;
import dev.nuker.pyro.f5k;
import dev.nuker.pyro.f5o;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

public class f5X
extends f5o {
    @NotNull
    public BooleanSetting Field4238 = (BooleanSetting)this.Method4959(new BooleanSetting("showFriends", "ShowFriends", null, true));

    @f0g
    @LauncherEventHide
    public void Method498(@NotNull f4t f4t2) {
        List list = fdZ.Field313.world.playerEntities;
        for (f5k f5k2 : this.Field2980.Field2944) {
            if (list.stream().anyMatch(new f5W(f5k2))) continue;
            f5k2.Method731();
        }
        for (f5k f5k2 : list) {
            if (Intrinsics.Method6572(f5k2, (Object)fdZ.Field313.player)) continue;
            boolean bl = false;
            for (f5k f5k3 : this.Field2980.Field2944) {
                f5q f5q2 = f5k3.Field3010;
                if (f5q2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.TextRadarPlayer");
                }
                if (((f5Y)f5q2).Method2376() != f5k2.getEntityId()) continue;
                f5q f5q3 = f5k3.Field3010;
                if (f5q3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.gui.hud.items.TextRadarPlayer");
                }
                ((f5Y)f5q3).Method456();
                bl = true;
                break;
            }
            if (bl) continue;
            boolean bl2 = FriendManager.Field2145.Method8960((EntityPlayer)f5k2);
            if (!((Boolean)this.Field4238.Method7979()).booleanValue()) {
                if (bl2) continue;
            }
            this.Field2980.Method4833(new f5k("textRadarPlayer", "General", new f5Y(f5k2.getName(), bl2, f5k2.getName(), f5k2.getEntityId()), null, false, 24, null), false);
        }
    }

    @NotNull
    public BooleanSetting Method5859() {
        return this.Field4238;
    }

    public f5X(int n) {
        super("arrayList", n);
    }
}

