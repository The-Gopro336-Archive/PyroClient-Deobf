/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraftforge.common.ForgeModContainer;
import org.jetbrains.annotations.NotNull;

public class fbQ implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fbT
   public fbT field_1612;

   public void accept(Object var1) {
      this.method_2816((f0w)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_2816(@NotNull f0w var1) {
      if ((Boolean)this.field_1612.c.method_3034() && (Boolean)var1.method_3318()) {
         if (fbT.method_1039(this.field_1612).world != null && fbT.method_1039(this.field_1612).renderGlobal != null) {
            fbT.method_1039(this.field_1612).addScheduledTask((Runnable)(new fbP(this)));
         }

         ForgeModContainer.forgeLightPipelineEnabled = !this.field_1612.method_1056();
      }

   }

   public fbQ(fbT var1) {
      this.field_1612 = var1;
      super();
   }
}
