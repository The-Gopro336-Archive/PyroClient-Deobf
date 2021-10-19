/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7s extends Module {
   // $FF: renamed from: c boolean
   public boolean field_352;
   // $FF: renamed from: 1 int
   public int field_353 = -420;

   public f7s() {
      super("portalgodmode", "PortalGodMode", "Abuses an exploit that allows you to take no damage when you enter a portal, however you won't be able to move");
   }

   // $FF: renamed from: c (boolean) void
   public void method_510(boolean var1) {
      this.field_352 = var1;
   }

   // $FF: renamed from: c () boolean
   public boolean method_511() {
      return this.field_352;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_512(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120) {
         if (var1.c() instanceof CPacketConfirmTeleport && this.field_352) {
            var1.0();
         }

      }
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_352 = false;
      if (this.c.player != null) {
         this.field_353 = this.c.player.dimension;
      }

   }

   // $FF: renamed from: 3 (int) void
   public void method_513(int var1) {
      this.field_353 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_514(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120) {
         if (var1.c() instanceof SPacketRespawn) {
            Packet var10000 = var1.c();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketRespawn");
            } else {
               SPacketRespawn var2 = (SPacketRespawn)var10000;
               if (var2.getDimensionID() != this.field_353) {
                  this.field_353 = var2.getDimensionID();
                  this.field_352 = true;
               }

            }
         }
      }
   }

   // $FF: renamed from: 0 () int
   public int method_515() {
      return this.field_353;
   }
}
