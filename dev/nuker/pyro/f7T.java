/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

public class f7T extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @JvmField
   @NotNull
   public BooleanSetting field_457 = (BooleanSetting)this.register((f0w)(new BooleanSetting("disconnect", "Block Disconnect", "Add a confirmation popup for the disconnect button", true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @JvmField
   @NotNull
   public BooleanSetting field_458 = (BooleanSetting)this.register((f0w)(new BooleanSetting("close_window", "Block Window Close", "Add a confirmation popup for the 'X' button", true)));

   public f7T() {
      super("anti_disconnect", "AntiDisconnect", "Gives a confirmation screen before you disconnect", true);
   }
}
