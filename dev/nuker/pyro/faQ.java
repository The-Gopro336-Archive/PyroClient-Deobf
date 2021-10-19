/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public class faQ extends Module {
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_788 = (IntegerSetting)this.register((f0w)(new IntegerSetting("fov", "FOV", (String)null, 120, 30, 150, 0, 64, (DefaultConstructorMarker)null)));

   // $FF: renamed from: c () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_1173() {
      return this.field_788;
   }

   public faQ() {
      super("customFOV", "CustomFOV", "Allows you to override the game FOV", true);
   }
}
