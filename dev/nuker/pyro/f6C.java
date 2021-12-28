/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f48;
import dev.nuker.pyro.f4J;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f5i;
import dev.nuker.pyro.f6B;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f6C
extends Module {
    public BooleanSetting Field2928 = new BooleanSetting("notifications", "Notifications", null, true);
    public BooleanSetting Field2929 = new BooleanSetting("messages", "Messages", null, true);
    public DoubleSetting Field2930 = new DoubleSetting("distance", "Distance", null, 25.0, 0.0, 100.0);
    public Map<Integer, f6B> Field2931 = new ConcurrentHashMap<Integer, f6B>();

    public f6B Method4817(String string, int n) {
        f6B f6B2;
        if (this.Field2931.containsKey(n)) {
            f6B2 = this.Field2931.get(n);
            if (f6B2.Field2920.equals(string)) {
                return f6B2;
            }
        }
        f6B2 = new f6B(this, string);
        this.Field2931.put(n, f6B2);
        return f6B2;
    }

    public f6C() {
        super("combatnotifier", "CombatNotifier", null, true);
        Pyro.Method8978().Method7915(this);
        this.Method7264(this.Field2929);
        this.Method7264(this.Field2928);
        this.Method7264(this.Field2930);
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        this.Field2931.entrySet().forEach(this::Method4818);
    }

    public void Method4818(Map.Entry entry) {
        if (this.Field5233.world.getEntityByID(((Integer)entry.getKey()).intValue()) == null) {
            ((f6B)entry.getValue()).Field2921 = 0;
        }
    }

    @f0g
    @LauncherEventHide
    public void Method244(f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre) {
            Entity entity;
            SPacketEntityStatus sPacketEntityStatus;
            if (f4e2.Method5784() instanceof SPacketEntityStatus && this.Field5233.world != null && (sPacketEntityStatus = (SPacketEntityStatus)f4e2.Method5784()).getOpCode() == 35 && sPacketEntityStatus.getEntity((World)this.Field5233.world) != null && (entity = sPacketEntityStatus.getEntity((World)this.Field5233.world)) instanceof EntityPlayer && (double)entity.getDistance((Entity)this.Field5233.player) <= (Double)this.Field2930.Method7979()) {
                f6B f6B2 = this.Method4817(entity.getName(), entity.getEntityId());
                ++f6B2.Field2921;
                if (((Boolean)this.Field5236.Method5264()).booleanValue() && !(entity instanceof EntityPlayerSP)) {
                    if (f6B2.Field2921 == 1) {
                        if (((Boolean)this.Field2929.Method7979()).booleanValue()) {
                            Pyro.Field6182.Method8989((Object)(FriendManager.Field2145.Method8958(entity.getName()) ? ChatFormatting.AQUA : ChatFormatting.RED) + entity.getName() + (Object)(FriendManager.Field2145.Method8958(entity.getName()) ? ChatFormatting.RED : ChatFormatting.GREEN) + " has popped a totem!");
                        }
                        if (((Boolean)this.Field2928.Method7979()).booleanValue()) {
                            f5i.Method4887().Method4886(entity.getName(), "has popped a totem!", -1334220);
                        }
                    } else {
                        if (((Boolean)this.Field2929.Method7979()).booleanValue()) {
                            Pyro.Field6182.Method8989((Object)(FriendManager.Field2145.Method8958(entity.getName()) ? ChatFormatting.AQUA : ChatFormatting.RED) + entity.getName() + (Object)(FriendManager.Field2145.Method8958(entity.getName()) ? ChatFormatting.RED : ChatFormatting.GREEN) + " has popped " + f6B2.Field2921 + " totems!");
                        }
                        if (((Boolean)this.Field2928.Method7979()).booleanValue()) {
                            f5i.Method4887().Method4886(entity.getName(), "has popped " + f6B2.Field2921 + " totems!", -1334220);
                        }
                    }
                }
            }
        }
    }

    @f0g
    @LauncherEventHide
    public void Method187(f4J f4J2) {
        this.Field2931.clear();
    }

    @f0g
    @LauncherEventHide
    public void Method4819(f48 f482) {
        if (f482.Method5637() instanceof EntityPlayer && (double)f482.Method5637().getDistance((Entity)this.Field5233.player) <= (Double)this.Field2930.Method7979()) {
            f6B f6B2 = this.Method4817(f482.Method5637().getName(), f482.Method5637().getEntityId());
            ++f6B2.Field2922;
            if (((Boolean)this.Field5236.Method5264()).booleanValue()) {
                if (!(f482.Method5637() instanceof EntityPlayerSP)) {
                    if (f6B2.Field2922 == 1) {
                        if (((Boolean)this.Field2929.Method7979()).booleanValue()) {
                            Pyro.Field6182.Method8989((Object)(FriendManager.Field2145.Method8958(f482.Method5637().getName()) ? ChatFormatting.AQUA : ChatFormatting.RED) + f482.Method5637().getName() + (Object)(FriendManager.Field2145.Method8958(f482.Method5637().getName()) ? ChatFormatting.RED : ChatFormatting.GREEN) + " has died for the first time!");
                        }
                        if (((Boolean)this.Field2928.Method7979()).booleanValue()) {
                            f5i.Method4887().Method4886(f482.Method5637().getName(), "has died for the first time!", -4439307);
                        }
                    } else {
                        if (((Boolean)this.Field2929.Method7979()).booleanValue()) {
                            Pyro.Field6182.Method8989((Object)(FriendManager.Field2145.Method8958(f482.Method5637().getName()) ? ChatFormatting.AQUA : ChatFormatting.RED) + f482.Method5637().getName() + (Object)(FriendManager.Field2145.Method8958(f482.Method5637().getName()) ? ChatFormatting.RED : ChatFormatting.GREEN) + " has died " + f6B2.Field2922 + " times!");
                        }
                        if (((Boolean)this.Field2928.Method7979()).booleanValue()) {
                            f5i.Method4887().Method4886(f482.Method5637().getName(), "has died " + f6B2.Field2922 + " times!", -4439307);
                        }
                    }
                }
            }
        }
    }
}

