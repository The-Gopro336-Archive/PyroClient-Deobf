/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import org.jetbrains.annotations.NotNull;

public class f7u extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_349 = (DoubleSetting)this.register((f0w)(new DoubleSetting("offset", "Offset", (String)null, 2.0D, -20.0D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null)));

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_506() {
      return this.field_349;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_507(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof CPacketPlayer && this.c.player != null) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayer");
         }

         CPacketPlayer var3 = (CPacketPlayer)var10000;
         if (var3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.CPacketPlayerAccessor");
         }

         CPacketPlayerAccessor var2 = (CPacketPlayerAccessor)var3;
         var2.setPosY(var2.getPosY() + ((Number)this.field_349.c()).doubleValue());
         this.c.player.fallDistance = 0.0F;
         this.c.method_3033(false);
         Pyro.INSTANCE.sendMessage("Attempted to rubberband");
      }

   }

   public f7u() {
      super("rubberband", "Rubberband", "Manually trigger a rubberband");
   }
}
