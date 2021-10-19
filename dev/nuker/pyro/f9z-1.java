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

public class f9z implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f9A
   public f9A field_2252;
   // $FF: renamed from: c net.minecraft.entity.Entity
   public Entity field_2253;

   public void accept(Object var1) {
      this.method_3365((EntityPlayerSP)var1);
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_3365(EntityPlayerSP var1) {
      f9A.method_487(this.field_2252).playerController.attackEntity((EntityPlayer)f9A.method_487(this.field_2252).player, this.field_2253);
      f9A.method_487(this.field_2252).player.swingArm(EnumHand.MAIN_HAND);
   }

   public f9z(f9A var1, Entity var2) {
      this.field_2252 = var1;
      this.field_2253 = var2;
      super();
   }
}
