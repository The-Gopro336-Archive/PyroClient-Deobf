/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.projectile.EntityFishHook
 *  net.minecraft.init.Items
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f80;
import dev.nuker.pyro.fdX;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f81
extends Module {
    @NotNull
    public BooleanSetting Field3207 = (BooleanSetting)this.Method7264(new BooleanSetting("openinv", "OpenInventory", "Replenishes rods", true));
    @NotNull
    public IntegerSetting Field3208 = (IntegerSetting)this.Method7264(new IntegerSetting("castingDelay", "CastingDelay", null, 15, 10, 25, 0, 64, null));
    @NotNull
    public DoubleSetting Field3209 = (DoubleSetting)this.Method7264(new DoubleSetting("maxSoundDist", "MaxSoundDist", null, 5.0, 0.0, 5.0, 0.0, 64, null));
    public boolean Field3210;
    public boolean Field3211 = true;
    public int Field3212;

    @f0g
    @LauncherEventHide
    public void Method183(@NotNull f4t f4t2) {
        this.Field3211 = this.Method4991();
        if (!this.Field3211) {
            return;
        }
        if (this.Field3210) {
            this.Field3210 = false;
            if (this.Field5233.player.fishEntity != null) {
                this.Field3212 = ((Number)this.Field3208.Method7979()).intValue();
                this.Method5033();
            }
        } else if (this.Field3212 > 0) {
            int n = this.Field3212;
            this.Field3212 = n + -1;
            if (this.Field3212 == 0) {
                this.Method5033();
            }
        }
    }

    public void Method557(boolean bl) {
        this.Field3211 = bl;
    }

    public boolean Method4991() {
        if (Intrinsics.Method6572((Object)this.Field5233.player.getHeldItemMainhand().getItem(), (Object)Items.FISHING_ROD) ^ true) {
            int n = fdX.Field311.Method497((Item)Items.FISHING_ROD);
            if (n != -1) {
                this.Field5233.player.inventory.currentItem = n;
                this.Field5233.playerController.updateController();
                return true;
            }
            if (((Boolean)this.Field3207.Method7979()).booleanValue()) {
                int n2 = fdX.Field311.Method496((Item)Items.FISHING_ROD);
                if (n2 != -1) {
                    fdX.Field311.Method499(0, n2, 0, ClickType.PICKUP, new f80(this));
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public void Method2402(boolean bl) {
        this.Field3210 = bl;
    }

    public f81() {
        super("autofish", "AutoFish", "Automatically fishes for you");
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
    }

    @NotNull
    public IntegerSetting Method2502() {
        return this.Field3208;
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field3207;
    }

    public void Method5033() {
        if (Intrinsics.Method6572((Object)this.Field5233.player.getHeldItem(EnumHand.MAIN_HAND).getItem(), (Object)Items.FISHING_ROD)) {
            NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            NetHandlerPlayClient netHandlerPlayClient2 = this.Field5233.getConnection();
            if (netHandlerPlayClient2 == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient2.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        } else if (Intrinsics.Method6572((Object)this.Field5233.player.getHeldItem(EnumHand.OFF_HAND).getItem(), (Object)Items.FISHING_ROD)) {
            NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
            NetHandlerPlayClient netHandlerPlayClient3 = this.Field5233.getConnection();
            if (netHandlerPlayClient3 == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient3.sendPacket((Packet)new CPacketAnimation(EnumHand.OFF_HAND));
        }
    }

    @NotNull
    public DoubleSetting Method219() {
        return this.Field3209;
    }

    @f0g
    @LauncherEventHide
    public void Method244(@NotNull f4e f4e2) {
        block5: {
            block6: {
                if (f4e2.Method5619() != f41.Pre || !(f4e2.Method5784() instanceof SPacketSoundEffect)) break block5;
                Packet packet = f4e2.Method5784();
                if (packet == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSoundEffect");
                }
                SPacketSoundEffect sPacketSoundEffect = (SPacketSoundEffect)packet;
                if (!sPacketSoundEffect.getSound().equals((Object)SoundEvents.ENTITY_BOBBER_SPLASH) || this.Field5233.player.fishEntity == null) break block5;
                EntityFishHook entityFishHook = this.Field5233.player.fishEntity;
                if (entityFishHook == null) {
                    Intrinsics.Method6551();
                }
                if (!entityFishHook.getAngler().equals((Object)this.Field5233.player)) break block5;
                if (((Number)this.Field3209.Method7979()).doubleValue() == 0.0) break block6;
                EntityPlayerSP entityPlayerSP = this.Field5233.player;
                Vec3d vec3d = new Vec3d(sPacketSoundEffect.getX(), sPacketSoundEffect.getY(), sPacketSoundEffect.getZ());
                if (!(entityPlayerSP.getPositionVector().distanceTo(vec3d) <= ((Number)this.Field3209.Method7979()).doubleValue())) break block5;
            }
            this.Field3210 = true;
        }
    }

    public boolean Method5124() {
        return this.Field3211;
    }

    public int Method5125() {
        return this.Field3212;
    }

    public void Method541(int n) {
        this.Field3212 = n;
    }

    public boolean Method4876() {
        return this.Field3210;
    }
}

