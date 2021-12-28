/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MoverType
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketInput
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.util.MovementInputFromOptions
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0z;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4x;
import dev.nuker.pyro.fb1;
import dev.nuker.pyro.fb2;
import dev.nuker.pyro.fb3;
import dev.nuker.pyro.fe4;
import dev.nuker.pyro.mixin.EntityFlagAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fb4
extends Module {
    @Nullable
    public Entity Field1702;
    public boolean Field1703;
    public double Field1704;
    public double Field1705;
    public double Field1706;
    public float Field1707;
    public float Field1708;
    @JvmField
    public float Field1709;
    @JvmField
    public float Field1710;
    @NotNull
    public MovementInputFromOptions Field1711;
    @JvmField
    @Nullable
    public EntityOtherPlayerMP Field1712;
    @NotNull
    public BooleanSetting Field1713;
    @JvmField
    @NotNull
    public f0z<fb2> Field1714;
    @NotNull
    public DoubleSetting Field1715;
    public boolean Field1716;
    public float Field1717;
    public float Field1718;
    public float Field1719;
    public boolean Field1720;

    public void Method2389(double d) {
        this.Field1705 = d;
    }

    public boolean Method2390() {
        return this.Field1720;
    }

    public void Method2391(@NotNull MovementInputFromOptions movementInputFromOptions) {
        this.Field1711 = movementInputFromOptions;
    }

    public void Method2392() {
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP = this.Field1712;
        if (entityOtherPlayerMP == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.lastTickPosX = entityOtherPlayerMP.posX;
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP2 = this.Field1712;
        if (entityOtherPlayerMP2 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.prevPosX = entityOtherPlayerMP2.lastTickPosX;
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP3 = this.Field1712;
        if (entityOtherPlayerMP3 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.lastTickPosY = entityOtherPlayerMP3.posY;
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP4 = this.Field1712;
        if (entityOtherPlayerMP4 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.prevPosY = entityOtherPlayerMP4.lastTickPosY;
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP5 = this.Field1712;
        if (entityOtherPlayerMP5 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.lastTickPosZ = entityOtherPlayerMP5.posZ;
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP6 = this.Field1712;
        if (entityOtherPlayerMP6 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.prevPosZ = entityOtherPlayerMP6.lastTickPosZ;
    }

    @f0g
    @LauncherEventHide
    public void Method2393(@NotNull f49 f492) {
        if (f492.Method5619() == f41.Pre && f492.Method5784() instanceof CPacketUseEntity) {
            Packet packet = f492.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketUseEntity");
            }
            if (Intrinsics.Method6572((Object)((CPacketUseEntity)packet).getEntityFromWorld((World)this.Field5233.world), (Object)this.Field5233.player)) {
                f492.Method7948();
            }
        }
        if (f492.Method5619() == f41.Pre) {
            if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && (fb2)((Object)PyroStatic.Field6417.Field1714.Method7991().Method7979()) == fb2.PACKET) {
                Packet packet = f492.Method5784();
                if (((Boolean)PyroStatic.Field6417.Field1713.Method7979()).booleanValue() && (packet instanceof CPacketPlayer || packet instanceof CPacketInput)) {
                    f492.Method7948();
                }
                if (((Boolean)PyroStatic.Field6417.Field1713.Method7979()).booleanValue()) {
                    if (packet instanceof CPacketUseEntity || packet instanceof CPacketVehicleMove) {
                        f492.Method7948();
                    }
                }
            }
        }
    }

    public float Method2394() {
        return this.Field1707;
    }

    public double Method2395() {
        return this.Field1704;
    }

    public fb4() {
        super("freecam", "Freecam", "Free your eyes from your body");
        List list;
        List[] arrlist;
        this.Field1711 = new MovementInputFromOptions(this.Field5233.gameSettings);
        this.Field1713 = new BooleanSetting("packet_cancel", "Riding Packet Cancel", "Cancel riding packets", false);
        int n = 0;
        List[] arrlist2 = arrlist = new List[2];
        Enum enum_ = fb2.CAMERA;
        String string = "Camera mode moves the camera, Packet mode desynchronizes position";
        String string2 = "Mode";
        String string3 = "mode";
        fb4 fb42 = this;
        fb4 fb43 = this;
        boolean bl = false;
        arrlist[n] = list = CollectionsKt.Method1013();
        arrlist2[1] = CollectionsKt.Method9007(this.Field1713);
        List[] arrlist3 = arrlist2;
        Enum enum_2 = enum_;
        String string4 = string;
        String string5 = string2;
        String string6 = string3;
        fb43.Field1714 = (f0z)fb42.Method7264(new f0z(string6, string5, string4, enum_2, arrlist3));
        this.Field1715 = (DoubleSetting)this.Method7264(new DoubleSetting("speed", "Speed", null, 20.0, 0.0, 50.0, 25.0));
        this.Field1714.Method7991().Method7980(new fb1(this));
    }

    public float Method2396(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f3;
        if (f2 != 0.0f) {
            if (f2 < 0.0f) {
                f5 *= -1.0f;
            }
            if (f2 < 0.0f != f4 < 0.0f) {
                f4 = 0.0f;
            }
            f4 = MathHelper.clamp((float)(f4 + f5), (float)-1.0f, (float)1.0f);
        } else {
            f4 *= 0.5f;
        }
        return f4;
    }

    public float Method2397() {
        return this.Field1719;
    }

    public float Method2398() {
        return this.Field1708;
    }

    @f0g
    @LauncherEventHide
    public void Method277(@NotNull f43 f432) {
        if (this.Field5233.player == null) {
            return;
        }
        if (f432.Method5619() == f41.Pre && this.Field1712 != null && (fb2)((Object)this.Field1714.Method7991().Method7979()) == fb2.CAMERA) {
            this.Method2392();
        } else {
            switch (fb3.Field1694[((fb2)((Object)this.Field1714.Method7991().Method7979())).ordinal()]) {
                case 1: {
                    this.Field5233.setRenderViewEntity((Entity)this.Field1712);
                    this.Method2392();
                    this.Method2411(this.Field5233.player.movementInput.sneak, this.Field5233.player.movementInput.jump);
                    break;
                }
                case 2: {
                    this.Field5233.player.capabilities.isFlying = true;
                    this.Field5233.player.capabilities.setFlySpeed((float)(((Number)this.Field1715.Method7979()).doubleValue() / (double)100.0f));
                    this.Field5233.player.onGround = false;
                    this.Field5233.player.noClip = true;
                    this.Field5233.player.fallDistance = 0.0f;
                    if (this.Field1702 != null) {
                        EntityOtherPlayerMP entityOtherPlayerMP = this.Field1712;
                        if (entityOtherPlayerMP == null) {
                            Intrinsics.Method6551();
                        }
                        if (entityOtherPlayerMP.getRidingEntity() != this.Field1702) {
                            if (!this.Field1716) {
                                EntityOtherPlayerMP entityOtherPlayerMP2 = this.Field1712;
                                if (entityOtherPlayerMP2 == null) {
                                    Intrinsics.Method6551();
                                }
                                entityOtherPlayerMP2.startRiding(this.Field1702, true);
                                break;
                            }
                        }
                    }
                    EntityOtherPlayerMP entityOtherPlayerMP = this.Field1712;
                    if (entityOtherPlayerMP == null) {
                        Intrinsics.Method6551();
                    }
                    if (entityOtherPlayerMP.getRidingEntity() != this.Field1702) break;
                    this.Field1716 = true;
                }
            }
            try {
                EntityOtherPlayerMP entityOtherPlayerMP = this.Field1712;
                if (entityOtherPlayerMP == null) {
                    Intrinsics.Method6551();
                }
                entityOtherPlayerMP.inventory.copyInventory(this.Field5233.player.inventory);
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void Method2399(boolean var1_1) {
        if (var1_1) {
            this.Field1704 = this.Field5233.player.posX;
            this.Field1705 = this.Field5233.player.posY;
            this.Field1706 = this.Field5233.player.posZ;
            if (this.Field5233.player.getRidingEntity() != null) {
                this.Field1702 = this.Field5233.player.getRidingEntity();
                this.Field5233.player.dismountRidingEntity();
            }
            this.Field1707 = this.Field5233.player.rotationPitch;
            this.Field1708 = this.Field5233.player.rotationYaw;
            this.Field1703 = this.Field5233.player.isElytraFlying();
            this.Field1712 = fe4.Field250.Method390((EntityPlayer)this.Field5233.player, -6969, false);
            this.Field1716 = false;
        } else {
            this.Field5233.player.setPositionAndRotation(this.Field1704, this.Field1705, this.Field1706, this.Field1708, this.Field1707);
            this.Field1704 = this.Field1705 = (this.Field1706 = 0.0);
            this.Field1707 = this.Field1708 = 0.0f;
            v0 = this.Field5233.player;
            if (v0 == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityFlagAccessor");
            }
            ((EntityFlagAccessor)v0).Method2970(7, this.Field1703);
            this.Field5233.player.motionX = this.Field5233.player.motionY = (this.Field5233.player.motionZ = 0.0);
            if (this.Field1702 != null) {
                v1 = this.Field1712;
                if (v1 == null) {
                    Intrinsics.Method6551();
                }
                if (v1.getRidingEntity() != null) {
                    v2 = this.Field1712;
                    if (v2 == null) {
                        Intrinsics.Method6551();
                    }
                    this.Field5233.player.startRiding(v2.getRidingEntity(), true);
                    this.Field1702 = null;
                }
            }
            v3 = this.Field1712;
            if (v3 == null) {
                Intrinsics.Method6551();
            }
            fe4.Field250.Method389(v3);
        }
        this.Field5233.player.capabilities.isFlying = var1_1;
        this.Field5233.player.capabilities.setFlySpeed(var1_1 != false ? (float)(((Number)this.Field1715.Method7979()).doubleValue() / (double)100.0f) : 0.05f);
        if (var1_1) ** GOTO lbl-1000
        if (this.Field5233.player.isSpectator()) lbl-1000:
        // 2 sources

        {
            v4 = true;
        } else {
            v4 = false;
        }
        this.Field5233.player.noClip = v4;
    }

    public double Method2400() {
        return this.Field1705;
    }

    public void Method2401(double d) {
        this.Field1706 = d;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (entityPlayerSP != null) {
            switch (fb3.Field1693[((fb2)((Object)this.Field1714.Method7991().Method7979())).ordinal()]) {
                case 1: {
                    this.Method2406(bl);
                    break;
                }
                case 2: {
                    this.Method2399(bl);
                    break;
                }
            }
        }
    }

    public void Method2402(boolean bl) {
        this.Field1703 = bl;
    }

    public float Method2403() {
        return this.Field1717;
    }

    public void Method2404(float f, float f2, float f3) {
        EntityOtherPlayerMP entityOtherPlayerMP = this.Field1712;
        if (entityOtherPlayerMP == null) {
            Intrinsics.Method6551();
        }
        double d = Math.sin((double)entityOtherPlayerMP.rotationYaw * Math.PI / 180.0);
        EntityOtherPlayerMP entityOtherPlayerMP2 = this.Field1712;
        if (entityOtherPlayerMP2 == null) {
            Intrinsics.Method6551();
        }
        double d2 = Math.cos((double)entityOtherPlayerMP2.rotationYaw * Math.PI / 180.0);
        double d3 = this.Method229();
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.motionX = ((double)f3 * d2 - (double)f * d) * d3;
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.motionY = (double)f2 * d3;
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.motionZ = ((double)f * d2 + (double)f3 * d) * d3;
        if (this.Field1712 == null) {
            Intrinsics.Method6551();
        }
        this.Field1712.noClip = true;
        EntityOtherPlayerMP entityOtherPlayerMP3 = this.Field1712;
        if (entityOtherPlayerMP3 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP4 = this.Field1712;
        if (entityOtherPlayerMP4 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP5 = this.Field1712;
        if (entityOtherPlayerMP5 == null) {
            Intrinsics.Method6551();
        }
        EntityOtherPlayerMP entityOtherPlayerMP6 = this.Field1712;
        if (entityOtherPlayerMP6 == null) {
            Intrinsics.Method6551();
        }
        entityOtherPlayerMP3.move(MoverType.SELF, entityOtherPlayerMP4.motionX, entityOtherPlayerMP5.motionY, entityOtherPlayerMP6.motionZ);
    }

    @NotNull
    public MovementInputFromOptions Method2405() {
        return this.Field1711;
    }

    public void Method2406(boolean bl) {
        if (bl) {
            this.Field1709 = this.Field5233.player.rotationPitch;
            this.Field1710 = this.Field5233.player.rotationYaw;
            this.Field1712 = fe4.Field250.Method392((EntityPlayer)this.Field5233.player, -6969, false);
            if (this.Field1712 == null) {
                Intrinsics.Method6551();
            }
            this.Field1712.posX = this.Field5233.player.posX;
            if (this.Field1712 == null) {
                Intrinsics.Method6551();
            }
            this.Field1712.posY = this.Field5233.player.posY;
            if (this.Field1712 == null) {
                Intrinsics.Method6551();
            }
            this.Field1712.posZ = this.Field5233.player.posZ;
            this.Field5233.setRenderViewEntity((Entity)this.Field1712);
        } else {
            this.Field5233.setRenderViewEntity((Entity)this.Field5233.player);
            if (this.Field1712 != null) {
                EntityOtherPlayerMP entityOtherPlayerMP = this.Field1712;
                if (entityOtherPlayerMP == null) {
                    Intrinsics.Method6551();
                }
                fe4.Field250.Method389(entityOtherPlayerMP);
            }
            this.Field1712 = null;
        }
    }

    public void Method2407(@Nullable Entity entity) {
        this.Field1702 = entity;
    }

    public void Method540(float f) {
        this.Field1718 = f;
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field1713;
    }

    public double Method229() {
        return ((Number)this.Field1715.Method7979()).doubleValue() / (double)9;
    }

    public void Method2408(float f) {
        this.Field1719 = f;
    }

    public void Method2409(float f) {
        this.Field1707 = f;
    }

    @NotNull
    public DoubleSetting Method233() {
        return this.Field1715;
    }

    public void Method2410(float f) {
        this.Field1717 = f;
    }

    public double Method221() {
        return this.Field1706;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Method2411(boolean bl, boolean bl2) {
        EntityOtherPlayerMP entityOtherPlayerMP = this.Field1712;
        if (entityOtherPlayerMP != null) {
            float f;
            Minecraft minecraft = Minecraft.getMinecraft();
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            GameSettings gameSettings = minecraft.gameSettings;
            if (gameSettings.keyBindForward.isKeyDown()) {
                f = f2;
                f2 = f + 1.0f;
            }
            if (gameSettings.keyBindBack.isKeyDown()) {
                f = f2;
                f2 = f + -1.0f;
            }
            if (gameSettings.keyBindLeft.isKeyDown()) {
                f = f4;
                f4 = f + 1.0f;
            }
            if (gameSettings.keyBindRight.isKeyDown()) {
                f = f4;
                f4 = f + -1.0f;
            }
            if (gameSettings.keyBindJump.isKeyDown()) {
                f = f3;
                f3 = f + 1.0f;
            }
            if (gameSettings.keyBindSneak.isKeyDown()) {
                f = f3;
                f3 = f + -1.0f;
            }
            if (gameSettings.keyBindSprint.isKeyDown()) {
                this.Field1720 = true;
            } else if (f2 == 0.0f) {
                this.Field1720 = false;
            }
            f = 0.15f;
            float f5 = f4 * f4 + f2 * f2;
            f5 = f2 != 0.0f && f4 != 0.0f ? (float)Math.sqrt((double)f5 * 0.6) : 1.0f;
            this.Field1717 = this.Method2396(this.Field1717, f2, f) / f5;
            this.Field1719 = this.Method2396(this.Field1719, f3, f);
            this.Field1718 = this.Method2396(this.Field1718, f4, f) / f5;
            f2 = this.Field1720 ? this.Field1717 * (float)2 : this.Field1717;
            this.Method2404(f2, this.Field1719, this.Field1718);
        }
    }

    public boolean Method2412() {
        return this.Field1703;
    }

    public boolean Method304() {
        return this.Field1716;
    }

    public void Method544(float f) {
        this.Field1708 = f;
    }

    public void Method557(boolean bl) {
        this.Field1716 = bl;
    }

    public void Method2413(boolean bl) {
        this.Field1720 = bl;
    }

    public float Method2414() {
        return this.Field1718;
    }

    @f0g
    @LauncherEventHide
    public void Method556(@NotNull f4x f4x2) {
        f4x2.Method7948();
    }

    public void Method2415(double d) {
        this.Field1704 = d;
    }

    @Nullable
    public Entity Method2416() {
        return this.Field1702;
    }
}

