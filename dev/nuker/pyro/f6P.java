/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;

public class f6P implements Runnable {
   // $FF: renamed from: c dev.nuker.pyro.keypearl
   public keypearl field_1695;
   // $FF: renamed from: c int
   public int field_1696;

   public void run() {
      keypearl.method_239(this.field_1695).playerController.windowClick(0, 44, 0, ClickType.PICKUP, (EntityPlayer)keypearl.method_239(this.field_1695).player);
      keypearl.method_239(this.field_1695).playerController.windowClick(0, this.field_1696, 0, ClickType.PICKUP, (EntityPlayer)keypearl.method_239(this.field_1695).player);
      NetHandlerPlayClient var10000 = keypearl.method_239(this.field_1695).getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketClickWindow(0, 0, 0, ClickType.PICKUP, new ItemStack(Items.TOTEM_OF_UNDYING, 5), (short)420)));
      keypearl.method_239(this.field_1695).playerController.updateController();
   }

   public f6P(keypearl var1, int var2) {
      this.field_1695 = var1;
      this.field_1696 = var2;
      super();
   }
}
