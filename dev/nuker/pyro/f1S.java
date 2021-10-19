/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class f1S implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1S
   public static f1S field_2439 = new f1S();

   public int run(CommandContext var1) {
      int var2 = IntegerArgumentType.getInteger(var1, "entityId");
      Minecraft var3 = fdZ.field_976;
      Entity var4 = var3.world.getEntityByID(var2);
      NetHandlerPlayClient var10000;
      if (var4 != null) {
         var10000 = var3.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketUseEntity(var4, EnumHand.MAIN_HAND)));
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Attempted to force mount with entity in world " + var4.getName())));
      } else {
         var4 = (Entity)(new EntityDonkey((World)var3.world));
         ((EntityDonkey)var4).setEntityId(var2);
         var10000 = var3.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketUseEntity(var4, EnumHand.MAIN_HAND)));
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Attempted to force mount with entityid " + var2)));
      }

      return 0;
   }
}
