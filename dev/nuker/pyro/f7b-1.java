/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7b extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_405;
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_406;

   // $FF: renamed from: c (dev.nuker.pyro.f7b) net.minecraft.client.Minecraft
   public static Minecraft method_610(f7b var0) {
      return var0.c;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_611(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120) {
         if (var1.c() instanceof SPacketChunkData) {
            Packet var10000 = var1.c();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketChunkData");
            }

            SPacketChunkData var2 = (SPacketChunkData)var10000;
            if (!var2.isFullChunk()) {
               this.field_406.removeIf((Predicate)(new f7a(var2)));
               fe3 var3 = new fe3(var2.getChunkX(), var2.getChunkZ());
               if (!this.field_406.contains(var3)) {
                  this.field_406.add(var3);
               }
            }
         }

      }
   }

   // $FF: renamed from: 0 () java.util.List
   @NotNull
   public List method_612() {
      return this.field_406;
   }

   public f7b() {
      super("newchunks", "NewChunks", "Renders chunks that are classified as new on Spigot servers");
      this.field_405 = (f0l)this.register((f0w)(new f0l("color", "Color", (String)null, f00.field_2296.method_3686(0.6F, 0.0F, 0.9333333F, 0.5F))));
      this.field_406 = (List)(new CopyOnWriteArrayList());
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4B) void
   @f0g
   @LauncherEventHide
   public void method_613(@Nullable f4B var1) {
      this.field_406.forEach((Consumer)(new f79(this)));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7b, net.minecraft.client.Minecraft) void
   public static void method_614(f7b var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_615(@NotNull List var1) {
      this.field_406 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_616() {
      return this.field_405;
   }
}
