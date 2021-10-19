/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

public class f8G implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f8J
   public f8J field_1836;
   // $FF: renamed from: c net.minecraft.entity.Entity
   public Entity field_1837;

   public f8G(f8J var1, Entity var2) {
      this.field_1836 = var1;
      this.field_1837 = var2;
      super();
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_3014(EntityPlayerSP var1) {
      f8J.method_617(this.field_1836).playerController.interactWithEntity((EntityPlayer)f8J.method_617(this.field_1836).player, this.field_1837, EnumHand.MAIN_HAND);
   }

   public void accept(Object var1) {
      this.method_3014((EntityPlayerSP)var1);
   }
}
