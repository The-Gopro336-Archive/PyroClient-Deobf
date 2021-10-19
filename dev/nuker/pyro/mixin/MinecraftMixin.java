/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f45;
import dev.nuker.pyro.f46;
import dev.nuker.pyro.f4k;
import dev.nuker.pyro.f83;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Minecraft.class})
public class MinecraftMixin {
   @Shadow
   public EntityPlayerSP player;

   @Shadow
   private void clickMouse() {
   }

   @Inject(
      method = {"<init>"},
      at = {@At("RETURN")}
   )
   private void init(GameConfiguration gameConfig, CallbackInfo ci) {
   }

   @Inject(
      method = {"runGameLoop"},
      at = {@At("HEAD")}
   )
   private void runLoopDependants(CallbackInfo ci) {
      f0b.field_2415.method_3671();
   }

   @Inject(
      method = {"setServerData"},
      at = {@At("HEAD")}
   )
   public void setServerData(ServerData serverDataIn, CallbackInfo info) {
      if (serverDataIn != null) {
         f83.field_462 = serverDataIn;
      }

   }

   @Inject(
      method = {"rightClickMouse"},
      at = {@At("HEAD")}
   )
   private void rightClickMousePre(CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2586.c.method_3034()) {
         PyroStatic.field_2586.method_404();
      }

   }

   @Inject(
      method = {"rightClickMouse"},
      at = {@At("RETURN")}
   )
   private void rightClickMousePost(CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2586.c.method_3034()) {
         PyroStatic.field_2586.method_399();
      }

   }

   @Inject(
      method = {"sendClickBlockToController"},
      at = {@At("HEAD")}
   )
   private void sendClickBlockToControllerPre(boolean leftClick, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2586.c.method_3034()) {
         PyroStatic.field_2586.method_402();
      }

   }

   @Inject(
      method = {"sendClickBlockToController"},
      at = {@At("RETURN")}
   )
   private void sendClickBlockToControllerPost(boolean leftClick, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2586.c.method_3034()) {
         PyroStatic.field_2586.method_405();
         if (leftClick) {
            this.clickMouse();
         }
      }

   }

   @Redirect(
      method = {"runGameLoop"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/Minecraft;shutdown()V"
)
   )
   private void mabeCancelShutdown(Minecraft minecraft) {
      if (minecraft.world != null && (Boolean)PyroStatic.field_2478.c.method_3034() && (Boolean)PyroStatic.field_2478.field_458.c()) {
         GuiScreen screen = minecraft.currentScreen;
         GuiYesNo g = new GuiYesNo((result, id) -> {
            if (result) {
               minecraft.shutdown();
            } else {
               Minecraft.getMinecraft().displayGuiScreen(screen);
            }

         }, "Do you really want to close minecraft?", "", 0);
         Minecraft.getMinecraft().displayGuiScreen(g);
      } else {
         minecraft.shutdown();
      }

   }

   @Redirect(
      method = {"clickMouse"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/multiplayer/PlayerControllerMP;clickBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)Z"
)
   )
   public boolean clickBlock(PlayerControllerMP controllerMP, BlockPos pos, EnumFacing facing) {
      Pyro.getEventManager().method_32(new f4k(pos));
      return controllerMP.clickBlock(pos, facing);
   }

   @Inject(
      method = {"runTickKeyboard"},
      at = {@At(
   value = "INVOKE_ASSIGN",
   target = "org/lwjgl/input/Keyboard.getEventKeyState()Z",
   remap = false
)}
   )
   private void runTickKeyboard(CallbackInfo callback) {
      Pyro.getEventManager().method_32(new f45(Keyboard.getEventKeyState()));
   }

   @Inject(
      method = {"runTickMouse"},
      at = {@At(
   value = "INVOKE_ASSIGN",
   target = "Lorg/lwjgl/input/Mouse;getEventButton()I",
   remap = false
)}
   )
   private void runTickMouse(CallbackInfo callback) {
      Pyro.getEventManager().method_32(new f46(Mouse.getEventButtonState()));
   }

   @Inject(
      method = {"runTick"},
      at = {@At("HEAD")}
   )
   public void preRunTick(CallbackInfo info) {
      Pyro.getEventManager().method_32(new f43(f41.field_2120));
   }

   @Inject(
      method = {"runTick"},
      at = {@At("RETURN")}
   )
   public void postRunTick(CallbackInfo info) {
      Pyro.getEventManager().method_32(new f43(f41.field_2121));
   }
}
