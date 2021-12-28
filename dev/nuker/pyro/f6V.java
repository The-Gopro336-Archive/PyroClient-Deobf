/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.MobEffects
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemSplashPotion
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.potion.PotionType
 *  net.minecraft.potion.PotionUtils
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSplashPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f6v
extends Module {
    public BooleanSetting Field3264 = new BooleanSetting("onGroundOnly", "OnGroundOnly", null, false);
    public DoubleSetting Field3265 = new DoubleSetting("health", "Health", null, 10.0, 0.0, 20.0);
    public DoubleSetting Field3266 = new DoubleSetting("delay", "Delay", null, 0.7, 0.0, 0.9);
    public IntegerSetting Field3267 = new IntegerSetting("slot", "Slot", null, 6, 1, 9);
    public BooleanSetting Field3268 = new BooleanSetting("oldFix", "1.9Fix", null, true);
    public fe8 Field3269 = new fe8();
    public int Field3270;
    public boolean Field3271;
    public boolean Field3272;
    public double Field3273;
    public double Field3274;
    public double Field3275;

    public f6v() {
        super("autopot", "AutoPot", "Throws a potion of health at your feet if requirements are met");
        this.Method7264(this.Field3264);
        this.Method7264(this.Field3265);
        this.Method7264(this.Field3266);
        this.Method7264(this.Field3267);
        this.Method7264(this.Field3268);
    }

    @f0g(value=3)
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (f4u2.Method7947()) {
            return;
        }
        if (f4u2.Method5619() == f41.Pre) {
            int n;
            boolean bl = this.Field3269.Method491((Double)this.Field3266.Method7979() * 1000.0);
            if (((Boolean)this.Field3264.Method7979()).booleanValue() && !this.Field5233.player.onGround) {
                bl = false;
            }
            if ((n = this.Method547()) != -1 && (double)this.Field5233.player.getHealth() <= (Double)this.Field3265.Method7979() && bl) {
                if (this.Field5233.player.collidedVertically && !((Boolean)PyroStatic.Field6430.Field5236.Method5264()).booleanValue()) {
                    this.Field3272 = true;
                    this.Field3269.Method490();
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(this.Field5233.player.posX, this.Field5233.player.posY, this.Field5233.player.posZ, this.Field5233.player.rotationYaw, -90.0f, true));
                    this.Method5146(n, (Integer)this.Field3267.Method7979());
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(((Integer)this.Field3267.Method7979()).intValue()));
                    if (((Boolean)this.Field3268.Method7979()).booleanValue()) {
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    } else {
                        this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
                    }
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field5233.player.inventory.currentItem));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.42, this.Field5233.player.posZ, true));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 0.75, this.Field5233.player.posZ, true));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.0, this.Field5233.player.posZ, true));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.16, this.Field5233.player.posZ, true));
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayer.Position(this.Field5233.player.posX, this.Field5233.player.posY + 1.24, this.Field5233.player.posZ, true));
                    this.Field3273 = this.Field5233.player.posX;
                    this.Field3274 = this.Field5233.player.posY + 1.24;
                    this.Field3275 = this.Field5233.player.posZ;
                    this.Field3270 = 5;
                } else {
                    f4u2.Method7948();
                    f4u2.Method5647(90.0f);
                    this.Field3271 = true;
                    this.Field3272 = true;
                    this.Field3269.Method490();
                }
            }
            if (this.Field3270 >= 0) {
                f4u2.Method5814();
            }
            if (this.Field3270 == 0) {
                this.Field5233.player.motionX = 0.0;
                this.Field5233.player.motionZ = 0.0;
                this.Field5233.player.setPositionAndUpdate(this.Field3273, this.Field3274, this.Field3275);
                this.Field5233.player.motionY = -0.08;
            }
            --this.Field3270;
        } else if (this.Field3271) {
            this.Method5146(this.Method547(), (Integer)this.Field3267.Method7979());
            this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(((Integer)this.Field3267.Method7979()).intValue()));
            if (((Boolean)this.Field3268.Method7979()).booleanValue()) {
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            } else {
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
            }
            this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field5233.player.inventory.currentItem));
            this.Field3269.Method490();
            this.Field3271 = false;
        }
    }

    public int Method547() {
        int n = -1;
        int n2 = 0;
        for (int i = 1; i < 45; ++i) {
            if (!this.Field5233.player.inventoryContainer.getSlot(i).getHasStack()) continue;
            ItemStack itemStack = this.Field5233.player.inventoryContainer.getSlot(i).getStack();
            Item item = itemStack.getItem();
            if (!(item instanceof ItemSplashPotion)) continue;
            PotionType potionType = PotionUtils.getPotionFromItem((ItemStack)itemStack);
            for (PotionEffect potionEffect : potionType.getEffects()) {
                if (potionEffect.getPotion() != MobEffects.INSTANT_HEALTH) continue;
                ++n2;
                n = i;
            }
        }
        this.Method7274(String.valueOf(n2));
        return n;
    }

    public void Method5146(int n, int n2) {
        this.Field5233.playerController.windowClick(this.Field5233.player.inventoryContainer.windowId, n, n2, ClickType.SWAP, (EntityPlayer)this.Field5233.player);
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (bl) {
            this.Field3270 = -1;
        } else {
            this.Field3271 = false;
        }
    }
}

