/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Arrays;
import java.util.UUID;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f2n implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2n
   public static f2n field_2114 = new f2n();

   public int run(CommandContext var1) {
      String var3 = StringArgumentType.getString(var1, "type");
      boolean var4 = false;
      if (var3 == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         String var2 = var3.toLowerCase();
         Clipboard var10000;
         switch(var2.hashCode()) {
         case -1354750946:
            if (var2.equals("coords")) {
               var10000 = Toolkit.getDefaultToolkit().getSystemClipboard();
               StringCompanionObject var14 = StringCompanionObject.INSTANCE;
               String var15 = "X: %s, Y: %s, Z: %s";
               Object[] var16 = new Object[]{(int)fdZ.field_976.player.posX, (int)fdZ.field_976.player.posY, (int)fdZ.field_976.player.posZ};
               Clipboard var8 = var10000;
               boolean var7 = false;
               String var11 = String.format(var15, Arrays.copyOf(var16, var16.length));
               var8.setContents((Transferable)(new StringSelection(var11)), (ClipboardOwner)null);
            }

            return 0;
         case -666719309:
            if (!var2.equals("mobowner")) {
               return 0;
            }
            break;
         case 3367:
            if (var2.equals("ip")) {
               if (fdZ.field_976.isSingleplayer()) {
                  ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("You are in singleplayer!")));
               } else if (fdZ.field_976.getCurrentServerData() != null) {
                  var10000 = Toolkit.getDefaultToolkit().getSystemClipboard();
                  StringSelection var10001 = new StringSelection;
                  ServerData var10003 = fdZ.field_976.getCurrentServerData();
                  if (var10003 == null) {
                     Intrinsics.throwNpe();
                  }

                  var10001.<init>(var10003.serverIP);
                  var10000.setContents((Transferable)var10001, (ClipboardOwner)null);
                  ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Copied the server IP")));
                  return 0;
               }

               return 0;
            }

            return 0;
         case 3373707:
            if (var2.equals("name")) {
               Toolkit.getDefaultToolkit().getSystemClipboard().setContents((Transferable)(new StringSelection(String.valueOf(fdZ.field_976.player.getName()))), (ClipboardOwner)null);
               ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Copied the player name")));
            }

            return 0;
         case 806538016:
            if (!var2.equals("mobowners")) {
               return 0;
            }
            break;
         default:
            return 0;
         }

         if (fdZ.field_976.objectMouseOver != Type.ENTITY) {
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("No entity found in crosshair.")));
         } else {
            Entity var13 = fdZ.field_976.objectMouseOver.entityHit;
            if (var13 != null) {
               UUID var5 = (UUID)null;
               if (var13 instanceof EntityWolf) {
                  if (((EntityWolf)var13).isTamed()) {
                     var5 = ((EntityWolf)var13).getOwnerId();
                  }
               } else if (var13 instanceof AbstractHorse && ((AbstractHorse)var13).isTame()) {
                  var5 = ((AbstractHorse)var13).getOwnerUniqueId();
               }

               if (var5 != null) {
                  String var6 = f0d.field_987.method_1447(StringsKt.replace$default(var5.toString(), "-", "", false, 4, (Object)null));
                  Toolkit.getDefaultToolkit().getSystemClipboard().setContents((Transferable)(new StringSelection(var6)), (ClipboardOwner)null);
                  ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Owner: " + var6)));
               } else {
                  ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("This entity has no owner.")));
               }
            }
         }

         return 0;
      }
   }
}
