/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Config;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f3e;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4i;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4r;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f4v;
import dev.nuker.pyro.f4x;
import dev.nuker.pyro.fb2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.network.play.client.CPacketPlayer.Position;
import net.minecraft.network.play.client.CPacketPlayer.PositionRotation;
import net.minecraft.network.play.client.CPacketPlayer.Rotation;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityPlayerSP.class})
public abstract class EntityPlayerSPMixin extends EntityPlayerMixin {
   private f4u currWalkingPlayerEvent;
   @Shadow
   @Final
   private NetHandlerPlayClient connection;
   @Shadow
   private double lastReportedPosX;
   @Shadow
   private double lastReportedPosY;
   @Shadow
   private double lastReportedPosZ;
   @Shadow
   private float lastReportedYaw;
   @Shadow
   private float lastReportedPitch;
   @Shadow
   private boolean prevOnGround;
   @Shadow
   private boolean serverSneakState;
   @Shadow
   private boolean serverSprintState;
   @Shadow
   private int positionUpdateTicks;
   @Shadow
   private boolean autoJumpEnabled;
   // $FF: renamed from: mc net.minecraft.client.Minecraft
   @Shadow
   private Minecraft field_1398;
   @Shadow
   public float timeInPortal;
   @Shadow
   public MovementInput movementInput;
   @Shadow
   private boolean rowingBoat;

   @Shadow
   public void closeScreenAndDropStack() {
   }

   @Shadow
   public abstract boolean isCurrentViewEntity();

   @Shadow
   public abstract boolean isSneaking();

   @Inject(
      method = {"move"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void move(MoverType type, double x, double y, double z, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1472) {
         Minecraft.getMinecraft().player.noClip = true;
      }

      f4p event = new f4p(f41.field_2120, type, x, y, z, this.isSneaking());
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         boolean wasSneaking = this.isSneaking();
         this.movementInput.sneak = event.method_3121();
         info.cancel();
         super.move(event.method_3124(), event.method_3128(), event.method_3119(), event.method_3123());
         this.movementInput.sneak = wasSneaking;
         Pyro.getEventManager().method_32(new f4p(f41.field_2121, type, x, y, z, this.isSneaking()));
      }

   }

   @Inject(
      method = {"move"},
      at = {@At("RETURN")}
   )
   private void movePost(MoverType type, double x, double y, double z, CallbackInfo info) {
      Pyro.getEventManager().method_32(new f4p(f41.field_2121, type, x, y, z, this.isSneaking()));
   }

   @Inject(
      method = {"updateRidden"},
      at = {@At("RETURN")}
   )
   private void updateRiddenPost(CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2538.c.method_3034() && this.getRidingEntity() instanceof EntityBoat) {
         EntityBoat entityboat = (EntityBoat)this.getRidingEntity();
         entityboat.updateInputs(this.movementInput.leftKeyDown, this.movementInput.rightKeyDown, this.movementInput.moveForward > 0.0F, this.movementInput.backKeyDown);
         this.rowingBoat |= this.movementInput.leftKeyDown || this.movementInput.rightKeyDown || this.movementInput.moveForward > 0.0F || this.movementInput.backKeyDown;
      }

   }

   @Inject(
      method = {"isCurrentViewEntity"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isFreecamOrRenderView(CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471) {
         cir.setReturnValue(true);
      }

   }

   @Inject(
      method = {"isUser"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isFreecamingOrUser(CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471) {
         cir.setReturnValue(false);
      }

   }

   @Inject(
      method = {"onUpdate"},
      at = {@At("HEAD")}
   )
   public void onUpdate(CallbackInfo ci) {
      Pyro.getEventManager().method_32(new f4t());
   }

   private void syncSprintSneakPackets() {
      boolean flag = this.isSprinting();
      if (flag != this.serverSprintState) {
         if (flag) {
            this.connection.sendPacket(new CPacketEntityAction((EntityPlayerSP)this, Action.START_SPRINTING));
         } else {
            this.connection.sendPacket(new CPacketEntityAction((EntityPlayerSP)this, Action.STOP_SPRINTING));
         }

         this.serverSprintState = flag;
      }

      boolean flag1 = this.isSneaking();
      if (flag1 != this.serverSneakState) {
         if (flag1) {
            this.connection.sendPacket(new CPacketEntityAction((EntityPlayerSP)this, Action.START_SNEAKING));
         } else {
            this.connection.sendPacket(new CPacketEntityAction((EntityPlayerSP)this, Action.STOP_SNEAKING));
         }

         this.serverSneakState = flag1;
      }

   }

   private void sendPositionPackets(AxisAlignedBB axisAlignedBB) {
      this.syncSprintSneakPackets();
      if (this.isCurrentViewEntity()) {
         double d0 = this.posX - this.lastReportedPosX;
         double d1 = this.currWalkingPlayerEvent.method_3130() - this.lastReportedPosY;
         double d2 = this.posZ - this.lastReportedPosZ;
         double d3 = (double)(this.currWalkingPlayerEvent.method_3134() - this.lastReportedYaw);
         double d4 = (double)(this.currWalkingPlayerEvent.method_3131() - this.lastReportedPitch);
         ++this.positionUpdateTicks;
         boolean flag2 = d0 * d0 + d1 * d1 + d2 * d2 > 9.0E-4D || this.positionUpdateTicks >= 20;
         boolean flag3 = d3 != 0.0D || d4 != 0.0D;
         if (this.isRiding()) {
            this.connection.sendPacket(new PositionRotation(this.motionX, -999.0D, this.motionZ, this.currWalkingPlayerEvent.method_3134(), this.currWalkingPlayerEvent.method_3131(), this.currWalkingPlayerEvent.method_3132()));
            flag2 = false;
         } else if (flag2 && flag3) {
            this.connection.sendPacket(new PositionRotation(this.posX, this.currWalkingPlayerEvent.method_3130(), this.posZ, this.currWalkingPlayerEvent.method_3134(), this.currWalkingPlayerEvent.method_3131(), this.currWalkingPlayerEvent.method_3132()));
         } else if (flag2) {
            this.connection.sendPacket(new Position(this.posX, this.currWalkingPlayerEvent.method_3130(), this.posZ, this.currWalkingPlayerEvent.method_3132()));
         } else if (flag3) {
            this.connection.sendPacket(new Rotation(this.currWalkingPlayerEvent.method_3134(), this.currWalkingPlayerEvent.method_3131(), this.currWalkingPlayerEvent.method_3132()));
         } else if (this.prevOnGround != this.currWalkingPlayerEvent.method_3132()) {
            this.connection.sendPacket(new CPacketPlayer(this.currWalkingPlayerEvent.method_3132()));
         }

         if (flag2) {
            this.lastReportedPosX = this.posX;
            this.lastReportedPosY = this.currWalkingPlayerEvent.method_3130();
            this.lastReportedPosZ = this.posZ;
            this.positionUpdateTicks = 0;
         }

         if (flag3) {
            this.lastReportedYaw = this.currWalkingPlayerEvent.method_3134();
            this.lastReportedPitch = this.currWalkingPlayerEvent.method_3131();
         }

         this.prevOnGround = this.currWalkingPlayerEvent.method_3132();
         this.autoJumpEnabled = this.field_1398.gameSettings.autoJump;
      }

   }

   @Inject(
      method = {"onUpdateWalkingPlayer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onUpdateWalkingPlayer(CallbackInfo ci) {
      AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
      Pyro.getEventManager().method_32(this.currWalkingPlayerEvent = new f4u(f41.field_2120, this.rotationPitch, this.rotationYaw, axisalignedbb.minY, this.onGround));
      if (this.currWalkingPlayerEvent.method_3136()) {
         ci.cancel();
         this.syncSprintSneakPackets();
         this.currWalkingPlayerEvent.c(f41.field_2121);
         Pyro.getEventManager().method_32(this.currWalkingPlayerEvent);
      } else {
         if (this.currWalkingPlayerEvent.c()) {
            Pyro.rotationManager.method_3457(this.currWalkingPlayerEvent.method_3131());
            Pyro.rotationManager.method_3454(this.currWalkingPlayerEvent.method_3134());
            ci.cancel();
            Pyro.getEventManager().method_32(new f4v(f41.field_2120, this.currWalkingPlayerEvent));
            this.sendPositionPackets(axisalignedbb);
            if (this.currWalkingPlayerEvent.method_3137() != null) {
               this.currWalkingPlayerEvent.method_3137().accept((EntityPlayerSP)this);
            }
         }

         this.currWalkingPlayerEvent.c(f41.field_2121);
         Pyro.getEventManager().method_32(this.currWalkingPlayerEvent);
      }
   }

   @Inject(
      method = {"pushOutOfBlocks"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void pushOutOfBlocks(double x, double y, double z, CallbackInfoReturnable info) {
      f4x event = new f4x();
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         info.setReturnValue(false);
      }

   }

   @Inject(
      method = {"onLivingUpdate"},
      at = {@At("HEAD")}
   )
   public void preLivingUpdate(CallbackInfo ci) {
      if (this.inPortal) {
         if (this.timeInPortal == 0.0F) {
            this.field_1398.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.BLOCK_PORTAL_TRIGGER, this.rand.nextFloat() * 0.4F + 0.8F));
         }

         this.timeInPortal += 0.0125F;
         if (this.timeInPortal >= 1.0F) {
            this.timeInPortal = 1.0F;
         }

         this.inPortal = false;
      }

   }

   @Inject(
      method = {"sendChatMessage"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void sendChatMessage(String originalMessage, CallbackInfo info) {
      if (originalMessage.startsWith(Config.INSTANCE.chatPrefix)) {
         Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(originalMessage);
         f3e.method_3213(originalMessage.substring(Config.INSTANCE.chatPrefix.length()));
         info.cancel();
      } else {
         f4i event = new f4i(originalMessage);
         Pyro.getEventManager().method_32(event);
         if (event.c()) {
            info.cancel();
            if (event.method_3141() != null) {
               this.connection.sendPacket(new CPacketChatMessage(event.method_3141()));
            }
         }
      }

   }

   @Inject(
      method = {"displayGUIChest"},
      at = {@At("HEAD")}
   )
   public void displayGUIChest(IInventory inv, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2595.c.method_3034()) {
         PyroStatic.field_2595.method_462(inv);
      }

   }

   @Inject(
      method = {"startRiding"},
      at = {@At("HEAD")}
   )
   public void startRiding(Entity entity, boolean forced, CallbackInfoReturnable info) {
      Pyro.getEventManager().method_32(new f4r(entity));
   }
}
