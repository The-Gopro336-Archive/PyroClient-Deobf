/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class fda extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_860 = new BooleanSetting("place", "Place", (String)null, true);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_861 = new BooleanSetting("destroy", "Destroy", (String)null, true);

   public fda() {
      super("noglitchblocks", "NoGlitchBlocks", "Waits for the server to confirm a block has been destroyed/placed");
      this.register(this.field_860);
      this.register(this.field_861);
   }
}
