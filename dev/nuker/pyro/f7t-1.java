/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public class f7t extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_350 = (DoubleSetting)this.register((f0w)(new DoubleSetting("reachAdd", "ReachAdd", (String)null, 1.0D, 0.0D, 3.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_351 = (DoubleSetting)this.register((f0w)(new DoubleSetting("hitboxAdd", "HitboxAdd", (String)null, 1.0D, 0.0D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null)));

   // $FF: renamed from: 0 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_508() {
      return this.field_351;
   }

   public f7t() {
      super("reach", "Reach", "Allows you to interact with entities or blocks farther than normal");
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_509() {
      return this.field_350;
   }
}
