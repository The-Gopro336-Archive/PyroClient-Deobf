/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketConfirmTeleport
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketInput
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketSteerBoat
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.network.play.server.SPacketMoveVehicle
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.network.play.server.SPacketSetPassengers
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f9b;
import dev.nuker.pyro.f9d;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.mixin.CPacketVehicleMoveAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Collection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f9e
extends Module {
    @NotNull
    public DoubleSetting Field4439 = (DoubleSetting)this.Method7264(new DoubleSetting("speed", "Speed", null, 1.0, 0.1, 10.0, 0.0, 64, null));
    @NotNull
    public DoubleSetting Field4440 = (DoubleSetting)this.Method7264(new DoubleSetting("upSpeed", "UpSpeed", null, 1.0, 0.1, 10.0, 0.0, 64, null));
    @NotNull
    public DoubleSetting Field4441 = (DoubleSetting)this.Method7264(new DoubleSetting("downSpeed", "DownSpeed", null, 1.0, 0.1, 10.0, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field4442 = (BooleanSetting)this.Method7264(new BooleanSetting("ncp", "NCP", null, true));
    @NotNull
    public BooleanSetting Field4443 = (BooleanSetting)this.Method7264(new BooleanSetting("antiKick", "AntiKick", null, true));
    @NotNull
    public DoubleSetting Field4444 = (DoubleSetting)this.Method7264(new DoubleSetting("scale", "RenderScale", "Make the first person boat render smaller", 0.4, 0.0, 1.0, 0.0, 64, null));
    @NotNull
    public f0o<f9b> Field4445 = (f0o)this.Method7264(new f0o("rubberMode", "RubberMode", "Figure out which rubberband packets to accept", f9b.Both));
    @NotNull
    public IntegerSetting Field4446 = (IntegerSetting)this.Method7264(new IntegerSetting("frequency", "Frequency", "Amount of rubberband packets sent in one second to actually rubberband", 15, 1, 20, 0, 64, null));
    @NotNull
    public IntegerSetting Field4447 = (IntegerSetting)this.Method7264(new IntegerSetting("distance", "Distance", "Minimum distance to count a rubberband packet as valid", 35, 1, 100, 0, 64, null));
    public int Field4448;
    public boolean Field4449;
    public int Field4450;
    public double Field4451 = -1.0;
    public int Field4452;
    public long Field4453;
    public float Field4454;

    @NotNull
    public DoubleSetting Method5279() {
        return this.Field4444;
    }

    @f0g
    @LauncherEventHide
    public void Method244(@NotNull f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre && !f4e2.Method7947()) {
            if (f4e2.Method5784() instanceof SPacketPlayerPosLook) {
                Packet packet = f4e2.Method5784();
                if (packet == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketPlayerPosLook");
                }
                SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook)packet;
                this.Field4450 = sPacketPlayerPosLook.getTeleportId();
                if (this.Field5233.player.isRiding()) {
                    f4e2.Method7948();
                }
            } else if (f4e2.Method5784() instanceof SPacketMoveVehicle) {
                boolean bl;
                Packet packet = f4e2.Method5784();
                if (packet == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketMoveVehicle");
                }
                SPacketMoveVehicle sPacketMoveVehicle = (SPacketMoveVehicle)packet;
                if (this.Field5233.player.isRiding()) {
                    Entity entity = this.Field5233.player.getRidingEntity();
                    if (entity == null) {
                        Intrinsics.Method6551();
                    }
                    Collection collection = this.Field5233.world.getCollisionBoxes(null, entity.getEntityBoundingBox().grow(0.0625));
                    boolean bl2 = false;
                    boolean bl3 = !collection.isEmpty();
                    if (bl3) {
                        return;
                    }
                }
                switch (f9d.Field4438[((f9b)((Object)this.Field4445.Method7979())).ordinal()]) {
                    case 1: {
                        bl = true;
                        break;
                    }
                    case 2: {
                        int n = this.Field4452;
                        this.Field4452 = n + 1;
                        Pyro.Field6182.Method8989("Count: " + this.Field4452);
                        if (this.Field4452 < ((Number)this.Field4446.Method7979()).intValue()) {
                            bl = true;
                            break;
                        }
                        bl = false;
                        break;
                    }
                    case 3: {
                        if (this.Field5233.player.getDistance(sPacketMoveVehicle.getX(), sPacketMoveVehicle.getY(), sPacketMoveVehicle.getZ()) <= ((Number)this.Field4447.Method7979()).doubleValue()) {
                            bl = true;
                            break;
                        }
                        bl = false;
                        break;
                    }
                    case 4: {
                        int n = this.Field4452;
                        this.Field4452 = n + 1;
                        Pyro.Field6182.Method8989("Count: " + this.Field4452);
                        if (this.Field4452 < ((Number)this.Field4446.Method7979()).intValue() || this.Field5233.player.getDistance(sPacketMoveVehicle.getX(), sPacketMoveVehicle.getY(), sPacketMoveVehicle.getZ()) <= ((Number)this.Field4447.Method7979()).doubleValue()) {
                            bl = true;
                            break;
                        }
                        bl = false;
                        break;
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (bl) {
                    f4e2.Method7948();
                } else if (((Boolean)PyroStatic.Field6403.Field5236.Method5264()).booleanValue()) {
                    PyroStatic.Field6403.Method2268(sPacketMoveVehicle.getX(), sPacketMoveVehicle.getY(), sPacketMoveVehicle.getZ());
                }
                Pyro.Field6182.Method8989(String.valueOf(this.Field5233.player.getDistance(sPacketMoveVehicle.getX(), sPacketMoveVehicle.getY(), sPacketMoveVehicle.getZ())));
            } else if (f4e2.Method5784() instanceof SPacketSetPassengers) {
                if (this.Field5233.player.isRiding()) {
                    Packet packet = f4e2.Method5784();
                    if (packet == null) {
                        throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSetPassengers");
                    }
                    SPacketSetPassengers sPacketSetPassengers = (SPacketSetPassengers)packet;
                    int n = sPacketSetPassengers.getEntityId();
                    Entity entity = this.Field5233.player.getRidingEntity();
                    if (entity == null) {
                        Intrinsics.Method6551();
                    }
                    if (n == entity.getEntityId()) {
                        for (int n2 : sPacketSetPassengers.getPassengerIds()) {
                            if (n2 != this.Field5233.player.getEntityId()) continue;
                            f4e2.Method7948();
                            return;
                        }
                    }
                }
            }
        }
    }

    @f0g
    @LauncherEventHide
    public void Method183(@NotNull f4t f4t2) {
        if (this.Field4453 + (long)1000 < System.currentTimeMillis()) {
            this.Field4453 = System.currentTimeMillis();
            this.Field4452 -= ((Number)this.Field4446.Method7979()).intValue();
            if (this.Field4452 < 0) {
                this.Field4452 = 0;
            }
        }
        if (this.Field5233.player.isRiding() && this.Field4450 > 0 && ((Boolean)this.Field4442.Method7979()).booleanValue() && this.Field5233.player.ticksExisted % 2 == 0) {
            NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            Entity entity = this.Field5233.player.getRidingEntity();
            if (entity == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.sendPacket((Packet)new CPacketUseEntity(entity, EnumHand.OFF_HAND));
            NetHandlerPlayClient netHandlerPlayClient2 = this.Field5233.getConnection();
            if (netHandlerPlayClient2 == null) {
                Intrinsics.Method6551();
            }
            int n = this.Field4450;
            this.Field4450 = n + 1;
            netHandlerPlayClient2.sendPacket((Packet)new CPacketConfirmTeleport(n));
        }
    }

    public f9e() {
        super("boatfly", "BoatFly", "Allows you to fly with boats");
    }

    @NotNull
    public f0o Method2672() {
        return this.Field4445;
    }

    @NotNull
    public BooleanSetting Method270() {
        return this.Field4442;
    }

    @NotNull
    public IntegerSetting Method6386() {
        return this.Field4447;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field4450 = 0;
        this.Field4451 = -1.0;
        this.Field4454 = this.Field5233.player.rotationYaw;
    }

    @NotNull
    public DoubleSetting Method228() {
        return this.Field4439;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @f0g
    @LauncherEventHide
    public void Method2393(@NotNull f49 f492) {
        if (f492.Method5619() != f41.Pre) return;
        if (f492.Method7947()) return;
        Packet packet = f492.Method5784();
        if (packet instanceof CPacketVehicleMove) {
            Packet packet2 = f492.Method5784();
            if (packet2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketVehicleMove");
            }
            CPacketVehicleMove cPacketVehicleMove = (CPacketVehicleMove)packet2;
            if (!((Boolean)this.Field4443.Method7979()).booleanValue() || !this.Field4449) return;
            Entity entity = this.Field5233.player.getRidingEntity();
            if (entity == null) {
                Intrinsics.Method6551();
            }
            if (entity.onGround) return;
            Entity entity2 = this.Field5233.player.getRidingEntity();
            if (entity2 == null) {
                Intrinsics.Method6551();
            }
            if (!this.Field5233.world.getCollisionBoxes(null, entity2.getEntityBoundingBox().grow(0.0625).expand(0.0, -0.05, 0.0)).isEmpty()) return;
            this.Field4449 = false;
            Packet packet3 = f492.Method5784();
            if (packet3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.CPacketVehicleMoveAccessor");
            }
            ((CPacketVehicleMoveAccessor)packet3).Method12239(cPacketVehicleMove.getY() - 0.05);
            return;
        } else if (packet instanceof CPacketSteerBoat) {
            f492.Method7948();
            return;
        } else if (packet instanceof CPacketInput) {
            if (!this.Field5233.player.isRiding()) return;
            Packet packet4 = f492.Method5784();
            if (packet4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketInput");
            }
            if (((CPacketInput)packet4).isSneaking()) {
                Entity entity = this.Field5233.player.getRidingEntity();
                if (entity == null) {
                    Intrinsics.Method6551();
                }
                if (entity.onGround) return;
            }
            f492.Method7948();
            return;
        } else if (packet instanceof CPacketPlayer) {
            if (!this.Field5233.player.isRiding()) return;
            f492.Method7948();
            return;
        } else {
            if (!(packet instanceof CPacketEntityAction)) return;
            if (!this.Field5233.player.isRiding()) return;
            Packet packet5 = f492.Method5784();
            if (packet5 == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketEntityAction");
            }
            if (((CPacketEntityAction)packet5).getAction() == CPacketEntityAction.Action.OPEN_INVENTORY) return;
            f492.Method7948();
        }
    }

    public void Method544(float f) {
        this.Field4454 = f;
    }

    public float Method6387() {
        return this.Field4454;
    }

    @NotNull
    public BooleanSetting Method213() {
        return this.Field4443;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Method5384() {
        double[] arrd;
        if (!this.Field5233.player.isRiding()) {
            this.Field4451 = -1.0;
            return;
        }
        Entity entity = this.Field5233.player.getRidingEntity();
        if (entity == null) return;
        int n = this.Field4448;
        this.Field4448 = n + 1;
        boolean bl = this.Field4449 = !this.Field5233.player.movementInput.sneak && this.Field5233.player.ticksExisted % 2 == 0 && !entity.collidedHorizontally && this.Field5233.world.getCollisionBoxes(null, entity.getEntityBoundingBox().grow(0.0625).expand(0.0, -0.05, 0.0)).isEmpty();
        if (this.Field4448 > 2) {
            this.Field4448 = 0;
        }
        entity.motionY = 0.0;
        double[] arrd2 = fec.Method723(((Number)this.Field4439.Method7979()).doubleValue());
        double[] arrd3 = arrd = (Boolean)PyroStatic.Field6403.Field5236.Method5264() != false ? PyroStatic.Field6403.Method2284(((Number)this.Field4439.Method7979()).doubleValue()) : null;
        if (arrd != null) {
            arrd2 = arrd;
        }
        if (((Boolean)PyroStatic.Field6403.Field5236.Method5264()).booleanValue()) {
            double[] arrd4 = PyroStatic.Field6403.Method2284(((Number)this.Field4439.Method7979()).doubleValue());
            if (arrd4 != null) {
                entity.motionX = arrd4[0];
                entity.motionZ = arrd4[1];
                entity.motionY = arrd4[2];
                return;
            }
            entity.motionX = 0.0;
            entity.motionY = 0.0;
            entity.motionZ = 0.0;
            return;
        }
        if (this.Field5233.player.movementInput.jump) {
            entity.motionY = ((Number)this.Field4440.Method7979()).doubleValue();
        } else if (this.Field5233.player.movementInput.sneak) {
            entity.motionY = -((Number)this.Field4441.Method7979()).doubleValue();
        }
        fec.Method722(((Number)this.Field4439.Method7979()).doubleValue());
    }

    @NotNull
    public DoubleSetting Method220() {
        return this.Field4440;
    }

    @NotNull
    public DoubleSetting Method218() {
        return this.Field4441;
    }

    @NotNull
    public IntegerSetting Method2502() {
        return this.Field4446;
    }
}

