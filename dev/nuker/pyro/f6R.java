/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Mouse;

public class f6R extends Module {
   // $FF: renamed from: c boolean
   public boolean field_571;

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_858(@NotNull f4t var1) {
      if (this.c.currentScreen == null) {
         if (!Mouse.isButtonDown(2)) {
            this.field_571 = false;
         } else {
            if (!this.field_571) {
               this.field_571 = true;
               RayTraceResult var2 = this.c.objectMouseOver;
               if (var2.typeOfHit == Type.ENTITY && var2.entityHit instanceof EntityPlayer) {
                  Entity var10000 = var2.entityHit;
                  if (var10000 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.player.EntityPlayer");
                  }

                  String var3 = ((EntityPlayer)var10000).getGameProfile().getName();
                  if (FriendManager.Companion.isFriendIgnoreEnable(var3)) {
                     FriendManager.Companion.removeFriend(var3);
                     Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((new TextComponentString("")).appendSibling(Pyro.getPrefix()).appendSibling((ITextComponent)(new TextComponentString("Removed friend: "))).appendSibling((new TextComponentString(var3)).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
                  } else {
                     FriendManager.Companion.addFriend(var3);
                     Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((new TextComponentString("")).appendSibling(Pyro.getPrefix()).appendSibling((ITextComponent)(new TextComponentString("Added friend: "))).appendSibling((new TextComponentString(var3)).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
                  }

                  if (!FriendManager.Companion.getINSTANCE().getEnabled()) {
                     Pyro.INSTANCE.sendMessage("The friend system is offline, the latest added/removed friend will take effect on friend system enable");
                  }
               }
            }

         }
      }
   }

   // $FF: renamed from: c () boolean
   public boolean method_859() {
      return this.field_571;
   }

   // $FF: renamed from: c (boolean) void
   public void method_860(boolean var1) {
      this.field_571 = var1;
   }

   public f6R() {
      super("mcf", "MiddleClickFriends", (String)null, true);
   }
}
