/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.class_53;
import dev.nuker.pyro.f4o;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityPlayer.class})
public abstract class EntityPlayerMixin extends EntityLivingBaseMixin {
   @Shadow
   public Container openContainer;

   @Redirect(
      method = {"getEyeHeight"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/player/EntityPlayer;isSneaking()Z"
)
   )
   private boolean noImNot(EntityPlayer player) {
      return false;
   }

   @Inject(
      method = {"isPushedByWater"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void pushOutOfBlocks(CallbackInfoReturnable info) {
      if (Minecraft.getMinecraft().player == (EntityPlayer)this && (Boolean)PyroStatic.field_2495.c.method_3034() && (Boolean)PyroStatic.field_2495.method_850().c()) {
         info.setReturnValue(false);
      }

   }

   @Inject(
      method = {"isEntityInsideOpaqueBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isEntityInsideOpaqueBlock(CallbackInfoReturnable callback) {
      if (Minecraft.getMinecraft().player == (EntityPlayer)this && ((Boolean)PyroStatic.field_2513.c.method_3034() || (Boolean)PyroStatic.field_2611.c.method_3034())) {
         callback.cancel();
      }

   }

   @Inject(
      method = {"applyEntityCollision"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void applyEntityCollision(Entity e, CallbackInfo info) {
      if (Minecraft.getMinecraft().player == (EntityPlayer)this && (Boolean)PyroStatic.field_2495.c.method_3034() && (Boolean)PyroStatic.field_2495.method_850().c()) {
         info.cancel();
      }

   }

   @Inject(
      method = {"isWearing"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void alwaysWearingMenu(EnumPlayerModelParts part, CallbackInfoReturnable cir) {
      if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu || Minecraft.getMinecraft().currentScreen instanceof class_53) {
         cir.setReturnValue(true);
      }

   }

   @Inject(
      method = {"jump"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void jump(CallbackInfo ci) {
      if (Minecraft.getMinecraft().player == (EntityPlayer)this) {
         f4o event = new f4o();
         Pyro.getEventManager().method_32(event);
         if (event.c()) {
            ci.cancel();
         }
      }

   }
}
