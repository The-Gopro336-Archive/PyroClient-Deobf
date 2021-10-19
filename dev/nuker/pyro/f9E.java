/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.MovementInput;
import org.lwjgl.input.Keyboard;

public class f9E extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_285 = new BooleanSetting("inventoryMove", "InventoryMove", "Allows you to move while a gui is open", true);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_286 = new BooleanSetting("items", "Items", "Doesn't allow items to slow you down", true);
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_287 = new BooleanSetting("ncpstrict", "NCP Strict", "Allows you to eat without getting slowed down on servers with a strict NCP config", true);
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_288 = new BooleanSetting("rotate", "Rotate", "Allows you to rotate your pitch with your arrow keys while inventory moving", true);

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_416(f4u var1) {
      if (var1.c() == f41.field_2121) {
         Item var2 = this.c.player.getHeldItemMainhand().getItem();
         Item var3 = this.c.player.getHeldItem(EnumHand.OFF_HAND).getItem();
         if ((Boolean)this.field_287.c() && (Boolean)this.field_286.c() && this.c.player.isHandActive() && !this.c.player.isRiding() && fec.method_1758() && (var2 instanceof ItemFood || var3 instanceof ItemFood) || var2 instanceof ItemBow || var2 instanceof ItemPotion) {
            this.c.player.connection.sendPacket(new CPacketPlayerDigging(Action.ABORT_DESTROY_BLOCK, this.c.player.getPosition(), EnumFacing.DOWN));
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_417(f49 var1) {
      if ((Boolean)this.field_287.c() && var1.c() instanceof CPacketClickWindow) {
         if (var1.c() == f41.field_2120) {
            if (this.c.player.isActiveItemStackBlocking()) {
               this.c.playerController.onStoppedUsingItem(this.c.player);
            }

            if (this.c.player.isSneaking()) {
               this.c.player.connection.sendPacket(new CPacketEntityAction(this.c.player, net.minecraft.network.play.client.CPacketEntityAction.Action.STOP_SNEAKING));
            }

            if (this.c.player.isSprinting()) {
               this.c.player.connection.sendPacket(new CPacketEntityAction(this.c.player, net.minecraft.network.play.client.CPacketEntityAction.Action.STOP_SPRINTING));
            }
         } else {
            if (this.c.player.isSneaking()) {
               this.c.player.connection.sendPacket(new CPacketEntityAction(this.c.player, net.minecraft.network.play.client.CPacketEntityAction.Action.START_SNEAKING));
            }

            if (this.c.player.isSprinting()) {
               this.c.player.connection.sendPacket(new CPacketEntityAction(this.c.player, net.minecraft.network.play.client.CPacketEntityAction.Action.START_SPRINTING));
            }
         }
      }

   }

   // $FF: renamed from: 0 (float) void
   public void method_418(float var1) {
      float var2 = this.c.player.rotationPitch + var1;
      var2 = Math.max(var2, -90.0F);
      var2 = Math.min(var2, 90.0F);
      this.c.player.rotationPitch = var2;
   }

   public f9E() {
      super("noslow", "NoSlow", "Allows you to not be slowed down by various actions", true);
      this.register(this.field_285);
      this.register(this.field_286);
      this.register(this.field_287);
      this.register(this.field_288);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4A) void
   @f0g
   @LauncherEventHide
   public void method_419(f4A var1) {
      if (this.c.player.isHandActive() && (Boolean)this.field_286.c() && !this.c.player.isRiding()) {
         MovementInput var10000 = this.c.player.movementInput;
         var10000.moveForward /= 0.2F;
         var10000 = this.c.player.movementInput;
         var10000.moveStrafe /= 0.2F;
      }

      if ((Boolean)this.field_285.c() && !var1.c()) {
         if (this.c.currentScreen != null && !(this.c.currentScreen instanceof GuiChat) && !(this.c.currentScreen instanceof GuiContainerCreative) && !(this.c.currentScreen instanceof GuiCommandBlock) && !(this.c.currentScreen instanceof GuiScreenBook) && !(this.c.currentScreen instanceof GuiEditSign) && !(this.c.currentScreen instanceof GuiRepair)) {
            if ((Boolean)this.field_288.c()) {
               if (Keyboard.isKeyDown(200)) {
                  this.method_418(-5.0F);
               }

               if (Keyboard.isKeyDown(208)) {
                  this.method_418(5.0F);
               }

               if (Keyboard.isKeyDown(205)) {
                  this.method_420(5.0F);
               }

               if (Keyboard.isKeyDown(203)) {
                  this.method_420(-5.0F);
               }
            }

            this.c.player.movementInput.moveStrafe = 0.0F;
            this.c.player.movementInput.moveForward = 0.0F;
            KeyBinding.setKeyBindState(this.c.gameSettings.keyBindForward.getKeyCode(), Keyboard.isKeyDown(this.c.gameSettings.keyBindForward.getKeyCode()));
            if (Keyboard.isKeyDown(this.c.gameSettings.keyBindForward.getKeyCode())) {
               ++this.c.player.movementInput.moveForward;
               this.c.player.movementInput.forwardKeyDown = true;
            } else {
               this.c.player.movementInput.forwardKeyDown = false;
            }

            KeyBinding.setKeyBindState(this.c.gameSettings.keyBindBack.getKeyCode(), Keyboard.isKeyDown(this.c.gameSettings.keyBindBack.getKeyCode()));
            if (Keyboard.isKeyDown(this.c.gameSettings.keyBindBack.getKeyCode())) {
               --this.c.player.movementInput.moveForward;
               this.c.player.movementInput.backKeyDown = true;
            } else {
               this.c.player.movementInput.backKeyDown = false;
            }

            KeyBinding.setKeyBindState(this.c.gameSettings.keyBindLeft.getKeyCode(), Keyboard.isKeyDown(this.c.gameSettings.keyBindLeft.getKeyCode()));
            if (Keyboard.isKeyDown(this.c.gameSettings.keyBindLeft.getKeyCode())) {
               ++this.c.player.movementInput.moveStrafe;
               this.c.player.movementInput.leftKeyDown = true;
            } else {
               this.c.player.movementInput.leftKeyDown = false;
            }

            KeyBinding.setKeyBindState(this.c.gameSettings.keyBindRight.getKeyCode(), Keyboard.isKeyDown(this.c.gameSettings.keyBindRight.getKeyCode()));
            if (Keyboard.isKeyDown(this.c.gameSettings.keyBindRight.getKeyCode())) {
               --this.c.player.movementInput.moveStrafe;
               this.c.player.movementInput.rightKeyDown = true;
            } else {
               this.c.player.movementInput.rightKeyDown = false;
            }

            KeyBinding.setKeyBindState(this.c.gameSettings.keyBindJump.getKeyCode(), Keyboard.isKeyDown(this.c.gameSettings.keyBindJump.getKeyCode()));
            this.c.player.movementInput.jump = Keyboard.isKeyDown(this.c.gameSettings.keyBindJump.getKeyCode());
         }
      }
   }

   // $FF: renamed from: c (float) void
   public void method_420(float var1) {
      this.c.player.rotationYaw += var1;
   }
}
