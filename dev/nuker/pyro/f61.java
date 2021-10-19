/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.common.collect.ComparisonChain;
import java.util.Comparator;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.world.GameType;

public class f61 implements Comparator {
   public f61() {
   }

   public int compare(Object var1, Object var2) {
      return this.method_3284((NetworkPlayerInfo)var1, (NetworkPlayerInfo)var2);
   }

   // $FF: renamed from: c (net.minecraft.client.network.NetworkPlayerInfo, net.minecraft.client.network.NetworkPlayerInfo) int
   public int method_3284(NetworkPlayerInfo var1, NetworkPlayerInfo var2) {
      ScorePlayerTeam var3 = var1.getPlayerTeam();
      ScorePlayerTeam var4 = var2.getPlayerTeam();
      return ComparisonChain.start().compareTrueFirst(var1.getGameType() != GameType.SPECTATOR, var2.getGameType() != GameType.SPECTATOR).compare(var3 != null ? var3.getName() : "", var4 != null ? var4.getName() : "").compare(var1.getGameProfile().getName(), var2.getGameProfile().getName()).result();
   }

   public f61(f60 var1) {
      this();
   }
}
