/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

public class faG extends far {
   // $FF: renamed from: c () void
   public void method_1682() {
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(@NotNull f4u var1) {
      if (fec.method_1758() && var1.c() == f41.field_2120) {
         KeyBinding.setKeyBindState(far.c.gameSettings.keyBindSprint.getKeyCode(), true);
         if (far.c.player.collidedVertically) {
            far.c.player.jump();
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(@NotNull f4p var1) {
   }

   public void meth0() {
   }
}
