/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import org.jetbrains.annotations.NotNull;

public class f69 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_203 = (BooleanSetting)this.register((f0w)(new BooleanSetting("gwen", "Gwen", "Tries to remove bots on the GWEN anticheat (Mineplex)", true)));

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_291() {
      return this.field_203;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_292(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120 && (Boolean)this.field_203.c() && var1.c() instanceof SPacketSpawnPlayer) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSpawnPlayer");
         }

         SPacketSpawnPlayer var2 = (SPacketSpawnPlayer)var10000;
         double var3 = var2.getX() / 32.0D;
         double var5 = var2.getY() / 32.0D;
         double var7 = var2.getZ() / 32.0D;
         double var9 = this.c.player.posX - var3;
         double var11 = this.c.player.posY - var5;
         double var13 = this.c.player.posZ - var7;
         double var17 = var9 * var9 + var11 * var11 + var13 * var13;
         boolean var19 = false;
         double var15 = Math.sqrt(var17);
         if (var15 <= (double)17 && var3 != this.c.player.posX && var5 != this.c.player.posY && var7 != this.c.player.posZ) {
            Pyro.INSTANCE.sendMessage("Removed a bot. [GWEN]");
            var1.0();
         }
      }

   }

   public f69() {
      super("antibots", "AntiBots", "Attempts to remove bots on hypixel/mineplex servers");
   }
}
