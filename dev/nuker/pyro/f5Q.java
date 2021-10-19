/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5Q extends f5T {
   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return fdZ.field_976.player != null ? (fdZ.field_976.player.getServerBrand() != null ? fdZ.field_976.player.getServerBrand() : "Vanilla") : "Vanilla";
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return 11184810;
   }

   public f5Q() {
      super("serverBrand");
   }
}
