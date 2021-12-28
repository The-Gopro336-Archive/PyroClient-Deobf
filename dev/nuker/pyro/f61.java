/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ComparisonChain
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.scoreboard.ScorePlayerTeam
 *  net.minecraft.world.GameType
 */
package dev.nuker.pyro;

import com.google.common.collect.ComparisonChain;
import dev.nuker.pyro.f60;
import java.util.Comparator;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.world.GameType;

public class f61
implements Comparator {
    public f61() {
    }

    public int compare(Object object, Object object2) {
        return this.Method5833((NetworkPlayerInfo)object, (NetworkPlayerInfo)object2);
    }

    public int Method5833(NetworkPlayerInfo networkPlayerInfo, NetworkPlayerInfo networkPlayerInfo2) {
        ScorePlayerTeam scorePlayerTeam = networkPlayerInfo.getPlayerTeam();
        ScorePlayerTeam scorePlayerTeam2 = networkPlayerInfo2.getPlayerTeam();
        return ComparisonChain.start().compareTrueFirst(networkPlayerInfo.getGameType() != GameType.SPECTATOR, networkPlayerInfo2.getGameType() != GameType.SPECTATOR).compare((Comparable)((Object)(scorePlayerTeam != null ? scorePlayerTeam.getName() : "")), (Comparable)((Object)(scorePlayerTeam2 != null ? scorePlayerTeam2.getName() : ""))).compare((Comparable)((Object)networkPlayerInfo.getGameProfile().getName()), (Comparable)((Object)networkPlayerInfo2.getGameProfile().getName())).result();
    }

    public f61(f60 f602) {
        this();
    }
}

