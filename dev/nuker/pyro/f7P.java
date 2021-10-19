/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7P extends Module {
   // $FF: renamed from: c net.minecraft.entity.Entity
   @Nullable
   public Entity field_521;

   public f7P() {
      super("entitdesync", "EntityDesync", (String)null, true);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_733(@Nullable f4t var1) {
      if (this.field_521 != null) {
         Entity var10000 = this.field_521;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.setPosition(this.c.player.posX, this.c.player.posY, this.c.player.posZ);
         NetHandlerPlayClient var2 = this.c.getConnection();
         if (var2 == null) {
            Intrinsics.throwNpe();
         }

         var2.sendPacket((Packet)(new CPacketVehicleMove(this.field_521)));
      }

   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) void
   public void method_734(@Nullable Entity var1) {
      this.field_521 = var1;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (var1 && this.c.player.isRiding()) {
         this.field_521 = this.c.player.getRidingEntity();
         this.c.player.dismountRidingEntity();
         this.c.world.removeEntity(this.field_521);
      } else if (!var1 && this.field_521 != null) {
         Entity var10000 = this.field_521;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.isDead = false;
         this.c.world.spawnEntity(this.field_521);
         this.c.player.startRiding(this.field_521, true);
         this.field_521 = (Entity)null;
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_735(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120) {
         Packet var10000;
         Entity var10001;
         int var3;
         int var4;
         int[] var5;
         int var6;
         if (var1.c() instanceof SPacketSetPassengers) {
            if (this.field_521 != null) {
               var10000 = var1.c();
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSetPassengers");
               }

               SPacketSetPassengers var2 = (SPacketSetPassengers)var10000;
               int var8 = var2.getEntityId();
               var10001 = this.field_521;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               if (var8 == var10001.getEntityId()) {
                  var5 = var2.getPassengerIds();
                  var6 = var5.length;

                  for(var4 = 0; var4 < var6; ++var4) {
                     var3 = var5[var4];
                     if (var3 == this.c.player.getEntityId()) {
                        return;
                     }
                  }

                  Pyro.INSTANCE.sendMessage("[EntityDesync]: " + ChatFormatting.RED + "The server has kicked you off the riding entity");
                  this.field_521 = (Entity)null;
                  this.c.method_3033(false);
               } else {
                  var5 = var2.getPassengerIds();
                  var6 = var5.length;

                  for(var4 = 0; var4 < var6; ++var4) {
                     var3 = var5[var4];
                     if (var3 == this.c.player.getEntityId()) {
                        Pyro.INSTANCE.sendMessage("[EntityDesync]: " + ChatFormatting.RED + "You started riding another entity");
                        this.field_521 = (Entity)null;
                        this.c.method_3033(false);
                        return;
                     }
                  }
               }
            }
         } else if (var1.c() instanceof SPacketDestroyEntities) {
            var10000 = var1.c();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketDestroyEntities");
            }

            SPacketDestroyEntities var7 = (SPacketDestroyEntities)var10000;
            if (this.field_521 != null) {
               var5 = var7.getEntityIDs();
               var6 = var5.length;

               for(var4 = 0; var4 < var6; ++var4) {
                  var3 = var5[var4];
                  var10001 = this.field_521;
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (var3 == var10001.getEntityId()) {
                     Pyro.INSTANCE.sendMessage("[EntityDesync]: " + ChatFormatting.RED + "The server has despawned the riding entity");
                     this.field_521 = (Entity)null;
                     this.c.method_3033(false);
                     return;
                  }
               }
            }
         } else if (var1.c() instanceof SPacketDisconnect) {
            this.field_521 = (Entity)null;
            this.c.method_3033(false);
         }
      }

   }

   // $FF: renamed from: c () net.minecraft.entity.Entity
   @Nullable
   public Entity method_736() {
      return this.field_521;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4J) void
   @f0g
   @LauncherEventHide
   public void method_737(@Nullable f4J var1) {
      this.field_521 = (Entity)null;
      this.c.method_3033(false);
   }
}
