/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.LinkedList;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f9a extends Module {
   // $FF: renamed from: c java.util.LinkedList
   public LinkedList field_209 = new LinkedList();
   // $FF: renamed from: c net.minecraft.client.entity.EntityOtherPlayerMP
   public EntityOtherPlayerMP field_210;

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_301(f49 var1) {
      if (var1.c() == f41.field_2120) {
         if (var1.c() instanceof CPacketPlayer || var1.c() instanceof CPacketConfirmTeleport || var1.c() instanceof CPacketVehicleMove) {
            var1.0();
            this.field_209.add(var1.c());
         }

      }
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);

      try {
         if (var1) {
            this.field_209.clear();
            this.field_210 = fe4.field_1243.method_1897(this.c.player, -1337, false);
         } else {
            while(!this.field_209.isEmpty() && this.c.getConnection() != null) {
               this.c.getConnection().sendPacket((Packet)this.field_209.getFirst());
               this.field_209.removeFirst();
            }

            fe4.field_1243.method_1896(this.field_210);
         }
      } catch (Exception var5) {
      }

   }

   public f9a() {
      super("blink", "Blink", "Holds movement packets allowing you to teleport");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4J) void
   @f0g
   @LauncherEventHide
   public void method_302(f4J var1) {
      this.c.method_3033(false);
   }
}
