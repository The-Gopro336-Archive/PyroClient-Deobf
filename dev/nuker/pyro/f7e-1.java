/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;

public class f7e extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_396 = (BooleanSetting)this.register((f0w)(new BooleanSetting("pickaxeOnly", "Pickaxe Only", (String)null, true)));

   public f7e() {
      super("nominingtrace", "NoMiningTrace", "Ignores entity collision when holding a pickaxe");
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_599() {
      return this.field_396;
   }
}
