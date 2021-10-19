/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f6n extends BlockPos {
   // $FF: renamed from: c dev.nuker.pyro.feh
   @Nullable
   public feh field_1772;
   // $FF: renamed from: c boolean
   public boolean field_1773;

   // $FF: renamed from: 0 () dev.nuker.pyro.feh
   @Nullable
   public feh method_2995() {
      return this.field_1772;
   }

   public f6n(@NotNull BlockPos var1, @Nullable feh var2, boolean var3) {
      super((Vec3i)var1);
      this.field_1772 = var2;
      this.field_1773 = var3;
   }

   // $FF: renamed from: c (dev.nuker.pyro.feh) void
   public void method_2996(@Nullable feh var1) {
      this.field_1772 = var1;
   }

   // $FF: renamed from: c (boolean) void
   public void method_2997(boolean var1) {
      this.field_1773 = var1;
   }

   // $FF: renamed from: c () boolean
   public boolean method_2998() {
      return this.field_1773;
   }
}
