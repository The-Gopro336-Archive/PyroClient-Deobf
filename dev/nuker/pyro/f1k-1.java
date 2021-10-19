/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1k implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1k
   public static f1k field_1986 = new f1k();

   public int run(CommandContext var1) {
      Minecraft var2 = fdZ.field_976;
      int var3 = 0;
      Iterable var4 = (Iterable)var2.world.loadedEntityList;
      boolean var5 = false;
      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         Object var7 = var6.next();
         Entity var8 = (Entity)var7;
         boolean var9 = false;
         if (var8 instanceof EntityAnimal && f1l.method_3085(f1l.field_2008, (EntityAnimal)var8)) {
            int var10 = 36;

            for(int var11 = var10; var11 < 45; var11 = var10) {
               ItemStack var12 = var2.player.inventoryContainer.getSlot(var10).getStack();
               if (!var12.isEmpty() && f1l.method_3088(f1l.field_2008, (EntityAnimal)var8, var12)) {
                  var2.player.connection.sendPacket((Packet)(new CPacketHeldItemChange(var10 - 36)));
                  NetHandlerPlayClient var13 = var2.player.connection;
                  ++var3;
                  var13.sendPacket((Packet)(new CPacketUseEntity(var8, EnumHand.MAIN_HAND)));
                  if (!var2.player.capabilities.isCreativeMode) {
                     int var14 = var12.getCount();
                     --var14;
                     if (var14 <= 0) {
                        var2.player.inventory.setInventorySlotContents(var10, var12);
                     }
                  }
                  break;
               }

               ++var10;
            }
         }
      }

      var2.player.connection.sendPacket((Packet)(new CPacketHeldItemChange(var2.player.inventory.currentItem)));
      String var15 = var3 == 1 ? "" : "s";
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Bred " + var3 + " animal" + var15 + '.')));
      return 0;
   }
}
