/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.init.Items;

public class f7V extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_499;
   // $FF: renamed from: c boolean
   public boolean field_500;
   // $FF: renamed from: 1 int
   public int field_501;

   public f7V() {
      super("antigapdisease", "AntiGapDisease", "Attempts to get rid of gapple disease.", false);
      this.field_499 = new f0o("mode", "Mode", (String)null, f7U.field_1821);
      this.field_500 = false;
      this.field_501 = 0;
      this.register(this.field_499);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4q) void
   @f0g
   @LauncherEventHide
   public void method_708(f4q var1) {
      if (this.c.player.getHeldItemMainhand().getItem().equals(Items.GOLDEN_APPLE)) {
         if (((f7U)this.field_499.c()).equals(f7U.field_1821)) {
            this.field_500 = true;
         }

      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_709(f4t var1) {
      if (this.field_500) {
         this.c.player.inventory.currentItem = 0;
         if (++this.field_501 > 1 && this.c.player.getHeldItemMainhand().getItem() != Items.GOLDEN_APPLE) {
            fe9.method_1833(Items.GOLDEN_APPLE);
            this.field_500 = false;
         }
      }

      if (((f7U)this.field_499.c()).equals(f7U.field_1822) && fe9.method_1826(this.c.player, Items.GOLDEN_APPLE)) {
         if (++this.field_501 >= 40) {
            this.field_500 = true;
            this.field_501 = 0;
         }
      } else if (!this.field_500) {
         this.field_501 = 0;
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4n) void
   @f0g
   @LauncherEventHide
   public void method_710(f4n var1) {
      if (this.c.player.getHeldItemMainhand().getItem().equals(Items.GOLDEN_APPLE)) {
         if (((f7U)this.field_499.c()).equals(f7U.field_1821)) {
            this.field_500 = true;
         }

      }
   }
}
