/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class faL implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.faN
   public faN field_1477;

   public void accept(Object var1) {
      this.method_2653((f0w)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_2653(@NotNull f0w var1) {
      this.field_1477.method_116((Boolean)this.field_1477.c.method_3034(), (EntityPlayerSP)null, (World)null);
   }

   public faL(faN var1) {
      this.field_1477 = var1;
      super();
   }
}
