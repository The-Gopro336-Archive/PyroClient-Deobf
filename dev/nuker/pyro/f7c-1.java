/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class f7c implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f70
   public f70 field_1844;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   public BlockPos field_1845;
   // $FF: renamed from: c boolean
   public boolean field_1846;
   // $FF: renamed from: c int
   public int field_1847;

   public f7c(f70 var1, BlockPos var2, boolean var3, int var4) {
      this.field_1844 = var1;
      this.field_1845 = var2;
      this.field_1846 = var3;
      this.field_1847 = var4;
      super();
   }

   // $FF: renamed from: c (net.minecraft.client.entity.EntityPlayerSP) void
   public void method_3019(@Nullable EntityPlayerSP var1) {
      if (this.field_1845 != null) {
         fed.method_1796(this.field_1845, 8.0F, true, false);
      }

      if (this.field_1846) {
         f70.method_906(this.field_1844).player.inventory.currentItem = this.field_1847;
         f70.method_906(this.field_1844).player.connection.sendPacket((Packet)(new CPacketHeldItemChange(this.field_1847)));
      }

   }

   public void accept(Object var1) {
      this.method_3019((EntityPlayerSP)var1);
   }
}
