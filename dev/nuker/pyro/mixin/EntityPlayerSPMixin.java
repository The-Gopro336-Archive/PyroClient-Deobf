/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MoverType
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AxisAlignedBB
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
import dev.nuker.pyro.mixin.EntityPlayerMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.MovementInput;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityPlayerSP.class})
public abstract class EntityPlayerSPMixin
extends EntityPlayerMixin {
    private f4u Field614;
    @Shadow
    @Final
    private NetHandlerPlayClient Field615;
    @Shadow
    private double Field616;
    @Shadow
    private double Field617;
    @Shadow
    private double Field618;
    @Shadow
    private float Field619;
    @Shadow
    private float Field620;
    @Shadow
    private boolean Field621;
    @Shadow
    private boolean Field622;
    @Shadow
    private boolean Field623;
    @Shadow
    private int Field624;
    @Shadow
    private boolean Field625;
    @Shadow
    private Minecraft Field626;
    @Shadow
    public float Field627;
    @Shadow
    public MovementInput Field628;
    @Shadow
    private boolean Field629;

    @Shadow
    public void Method1120() {
    }

    @Shadow
    public abstract boolean Method1121();

    @Override
    @Shadow
    public abstract boolean Method1122();

    @Inject(method={"move"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method1123(MoverType type, double x, double y, double z, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.PACKET) {
            Minecraft.getMinecraft().player.noClip = true;
        }
        f4p event = new f4p(f41.Pre, type, x, y, z, this.Method1122());
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            boolean wasSneaking = this.Method1122();
            this.Field628.sneak = event.Method5594();
            info.Method9034();
            super.Method12582(event.Method5836(), event.Method5839(), event.Method5815(), event.Method5835());
            this.Field628.sneak = wasSneaking;
            Pyro.Method8978().Method7918(new f4p(f41.Post, type, x, y, z, this.Method1122()));
        }
    }

    @Inject(method={"move"}, at={@Class0(value="RETURN")})
    private void Method1124(MoverType type, double x, double y, double z, CallbackInfo info) {
        Pyro.Method8978().Method7918(new f4p(f41.Post, type, x, y, z, this.Method1122()));
    }

    @Inject(method={"updateRidden"}, at={@Class0(value="RETURN")})
    private void Method1125(CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6474.Field5236.Method5264()).booleanValue() && this.Method12586() instanceof EntityBoat) {
            EntityBoat entityboat = (EntityBoat)this.Method12586();
            entityboat.updateInputs(this.Field628.leftKeyDown, this.Field628.rightKeyDown, this.Field628.moveForward > 0.0f, this.Field628.backKeyDown);
            this.Field629 |= this.Field628.leftKeyDown || this.Field628.rightKeyDown || this.Field628.moveForward > 0.0f || this.Field628.backKeyDown;
        }
    }

    @Inject(method={"isCurrentViewEntity"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method1126(CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA) {
            cir.Method521(true);
        }
    }

    @Inject(method={"isUser"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method1127(CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA) {
            cir.Method521(false);
        }
    }

    @Inject(method={"onUpdate"}, at={@Class0(value="HEAD")})
    public void Method1128(CallbackInfo ci) {
        Pyro.Method8978().Method7918(new f4t());
    }

    private void Method1129() {
        boolean flag1;
        boolean flag = this.Method12583();
        if (flag != this.Field623) {
            if (flag) {
                this.Field615.sendPacket((Packet)new CPacketEntityAction((Entity)((EntityPlayerSP)this), CPacketEntityAction.Action.START_SPRINTING));
            } else {
                this.Field615.sendPacket((Packet)new CPacketEntityAction((Entity)((EntityPlayerSP)this), CPacketEntityAction.Action.STOP_SPRINTING));
            }
            this.Field623 = flag;
        }
        if ((flag1 = this.Method1122()) != this.Field622) {
            if (flag1) {
                this.Field615.sendPacket((Packet)new CPacketEntityAction((Entity)((EntityPlayerSP)this), CPacketEntityAction.Action.START_SNEAKING));
            } else {
                this.Field615.sendPacket((Packet)new CPacketEntityAction((Entity)((EntityPlayerSP)this), CPacketEntityAction.Action.STOP_SNEAKING));
            }
            this.Field622 = flag1;
        }
    }

    private void Method1130(AxisAlignedBB axisAlignedBB) {
        this.Method1129();
        if (this.Method1121()) {
            boolean flag3;
            double d0 = this.Field7643 - this.Field616;
            double d1 = this.Field614.Method5815() - this.Field617;
            double d2 = this.Field7645 - this.Field618;
            double d3 = this.Field614.Method5817() - this.Field619;
            double d4 = this.Field614.Method5651() - this.Field620;
            ++this.Field624;
            boolean flag2 = d0 * d0 + d1 * d1 + d2 * d2 > 9.0E-4 || this.Field624 >= 20;
            boolean bl = flag3 = d3 != 0.0 || d4 != 0.0;
            if (this.Method12585()) {
                this.Field615.sendPacket((Packet)new CPacketPlayer.PositionRotation(this.Field7646, -999.0, this.Field7648, this.Field614.Method5817(), this.Field614.Method5651(), this.Field614.Method5594()));
                flag2 = false;
            } else if (flag2 && flag3) {
                this.Field615.sendPacket((Packet)new CPacketPlayer.PositionRotation(this.Field7643, this.Field614.Method5815(), this.Field7645, this.Field614.Method5817(), this.Field614.Method5651(), this.Field614.Method5594()));
            } else if (flag2) {
                this.Field615.sendPacket((Packet)new CPacketPlayer.Position(this.Field7643, this.Field614.Method5815(), this.Field7645, this.Field614.Method5594()));
            } else if (flag3) {
                this.Field615.sendPacket((Packet)new CPacketPlayer.Rotation(this.Field614.Method5817(), this.Field614.Method5651(), this.Field614.Method5594()));
            } else if (this.Field621 != this.Field614.Method5594()) {
                this.Field615.sendPacket((Packet)new CPacketPlayer(this.Field614.Method5594()));
            }
            if (flag2) {
                this.Field616 = this.Field7643;
                this.Field617 = this.Field614.Method5815();
                this.Field618 = this.Field7645;
                this.Field624 = 0;
            }
            if (flag3) {
                this.Field619 = this.Field614.Method5817();
                this.Field620 = this.Field614.Method5651();
            }
            this.Field621 = this.Field614.Method5594();
            this.Field625 = this.Field626.gameSettings.autoJump;
        }
    }

    @Inject(method={"onUpdateWalkingPlayer"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method1131(CallbackInfo ci) {
        AxisAlignedBB axisalignedbb = this.Method12584();
        this.Field614 = new f4u(f41.Pre, this.Field7641, this.Field7642, axisalignedbb.minY, this.Field7649);
        Pyro.Method8978().Method7918(this.Field614);
        if (this.Field614.Method5818()) {
            ci.Method9034();
            this.Method1129();
            this.Field614.Method5620(f41.Post);
            Pyro.Method8978().Method7918(this.Field614);
            return;
        }
        if (this.Field614.Method7947()) {
            Pyro.Field6184.Method7539(this.Field614.Method5651());
            Pyro.Field6184.Method7536(this.Field614.Method5817());
            ci.Method9034();
            Pyro.Method8978().Method7918(new f4v(f41.Pre, this.Field614));
            this.Method1130(axisalignedbb);
            if (this.Field614.Method5819() != null) {
                this.Field614.Method5819().accept((EntityPlayerSP)this);
            }
        }
        this.Field614.Method5620(f41.Post);
        Pyro.Method8978().Method7918(this.Field614);
    }

    @Inject(method={"pushOutOfBlocks"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method1132(double x, double y, double z, CallbackInfoReturnable info) {
        f4x event = new f4x();
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            info.Method521(false);
        }
    }

    @Inject(method={"onLivingUpdate"}, at={@Class0(value="HEAD")})
    public void Method1133(CallbackInfo ci) {
        if (this.Field7653) {
            if (this.Field627 == 0.0f) {
                this.Field626.getSoundHandler().playSound((ISound)PositionedSoundRecord.getMasterRecord((SoundEvent)SoundEvents.BLOCK_PORTAL_TRIGGER, (float)(this.Field7654.nextFloat() * 0.4f + 0.8f)));
            }
            this.Field627 += 0.0125f;
            if (this.Field627 >= 1.0f) {
                this.Field627 = 1.0f;
            }
            this.Field7653 = false;
        }
    }

    @Inject(method={"sendChatMessage"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method1134(String originalMessage, CallbackInfo info) {
        if (originalMessage.startsWith(Config.Field3937.Field3931)) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(originalMessage);
            f3e.Method5655(originalMessage.substring(Config.Field3937.Field3931.length()));
            info.Method9034();
        } else {
            f4i event = new f4i(originalMessage);
            Pyro.Method8978().Method7918(event);
            if (event.Method7947()) {
                info.Method9034();
                if (event.Method5798() != null) {
                    this.Field615.sendPacket((Packet)new CPacketChatMessage(event.Method5798()));
                }
            }
        }
    }

    @Inject(method={"displayGUIChest"}, at={@Class0(value="HEAD")})
    public void Method1135(IInventory inv, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6531.Field5236.Method5264()).booleanValue()) {
            PyroStatic.Field6531.Method5342(inv);
        }
    }

    @Inject(method={"startRiding"}, at={@Class0(value="HEAD")})
    public void Method1136(Entity entity, boolean forced, CallbackInfoReturnable info) {
        Pyro.Method8978().Method7918(new f4r(entity));
    }
}

