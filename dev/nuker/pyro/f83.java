/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.multiplayer.ServerData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f83 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_460 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delayy", "Delay", "Delay in seconds", 5.0D, 0.0D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_461 = (BooleanSetting)this.register((f0w)(new BooleanSetting("show", "Show Buttons", "Show reconnect buttons on the disconnect screen", true)));
   // $FF: renamed from: c net.minecraft.client.multiplayer.ServerData
   @JvmField
   @Nullable
   public static ServerData field_462;
   // $FF: renamed from: c dev.nuker.pyro.f82
   public static f82 field_463 = new f82((DefaultConstructorMarker)null);

   // $FF: renamed from: c (dev.nuker.pyro.BooleanSetting) void
   public void method_681(@NotNull BooleanSetting var1) {
      this.field_461 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_682() {
      return this.field_460;
   }

   // $FF: renamed from: c (dev.nuker.pyro.DoubleSetting) void
   public void method_683(@NotNull DoubleSetting var1) {
      this.field_460 = var1;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_684() {
      return this.field_461;
   }

   public f83() {
      super("auto_reconnect", "AutoReconnect", "Automatically reconnects to a server when you get disconnected.");
   }
}
