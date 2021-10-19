/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import org.jetbrains.annotations.NotNull;

public class f77 extends Module {
   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_866(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketDestroyEntities) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketDestroyEntities");
         }

         SPacketDestroyEntities var2 = (SPacketDestroyEntities)var10000;
         int[] var5 = var2.getEntityIDs();
         int var6 = var5.length;

         for(int var4 = 0; var4 < var6; ++var4) {
            int var3 = var5[var4];
            Entity var7 = this.c.world.getEntityByID(var3);
            if (var7 != null && var7.getDistance((Entity)this.c.player) > (float)1000) {
               Pyro.INSTANCE.sendMessage("Entity despawned far away at " + var7.getPosition().toString());
            }
         }
      }

   }

   public f77() {
      super("coordtpexploit", "CoordTpExploit", (String)null);
   }
}
