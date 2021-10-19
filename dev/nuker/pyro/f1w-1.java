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
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1w implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1w
   public static f1w field_2032 = new f1w();

   public int run(CommandContext var1) {
      int var2 = IntegerArgumentType.getInteger(var1, "entityId");
      Minecraft var3 = fdZ.field_976;
      Entity var4 = var3.world.getEntityByID(var2);
      if (var4 != null) {
         NetHandlerPlayClient var10000 = var3.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketEntityAction((Entity)var3.player, Action.START_SNEAKING)));
         var10000 = var3.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketUseEntity(var4, EnumHand.MAIN_HAND, new Vec3d(Math.random(), Math.random(), Math.random()))));
         var10000 = var3.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketUseEntity(var4, EnumHand.MAIN_HAND)));
         var10000 = var3.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.sendPacket((Packet)(new CPacketEntityAction((Entity)var3.player, Action.STOP_SNEAKING)));
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Attempted to interact with entityId " + var2)));
      }

      return 0;
   }
}
