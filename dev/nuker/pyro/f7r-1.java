/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketKeepAlive;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7r extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_354 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delay", "Delay", (String)null, 600.0D, 1.0D, 2000.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_355 = new fe8();
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_356 = (List)(new CopyOnWriteArrayList());

   // $FF: renamed from: 1 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_516() {
      return this.field_354;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_517(@Nullable f4t var1) {
      this.5("" + (int)((Number)this.field_354.c()).doubleValue() + "ms");
      if (this.field_355.method_1980(((Number)this.field_354.c()).doubleValue())) {
         this.field_356.forEach((Consumer)(new f7q(this)));
         this.field_356.clear();
         this.field_355.method_1979();
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f7r, net.minecraft.client.Minecraft) void
   public static void method_518(f7r var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe8) void
   public void method_519(@NotNull fe8 var1) {
      this.field_355 = var1;
   }

   // $FF: renamed from: 0 () java.util.List
   @NotNull
   public List method_520() {
      return this.field_356;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_521(@NotNull List var1) {
      this.field_356 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7r) net.minecraft.client.Minecraft
   public static Minecraft method_522(f7r var0) {
      return var0.c;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_523(@NotNull f49 var1) {
      if (var1.c() instanceof CPacketKeepAlive && var1.c() == f41.field_2120) {
         List var10000 = this.field_356;
         Packet var10001 = var1.c();
         if (var10001 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketKeepAlive");
         }

         if (!var10000.contains((CPacketKeepAlive)var10001)) {
            var10000 = this.field_356;
            var10001 = var1.c();
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketKeepAlive");
            }

            var10000.add((CPacketKeepAlive)var10001);
            var1.0();
         }
      }

   }

   public f7r() {
      super("pingspoof", "PingSpoof", (String)null);
   }

   // $FF: renamed from: c () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_524() {
      return this.field_355;
   }
}
