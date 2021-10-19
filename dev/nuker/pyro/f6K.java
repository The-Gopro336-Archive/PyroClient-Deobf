/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.world.World;

public class f6K implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f6L
   public f6L field_1708;

   public f6K(f6L var1) {
      this.field_1708 = var1;
      super();
   }

   public void accept(Object var1) {
      this.method_2961((Boolean)var1);
   }

   // $FF: renamed from: c (java.lang.Boolean) void
   public void method_2961(Boolean var1) {
      class_37.field_2633.method_3980();
      this.field_1708.method_116((Boolean)this.field_1708.c.method_3034(), f6L.method_896(this.field_1708).player, (World)f6L.method_896(this.field_1708).world);
   }
}
