/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  baritone.api.pathing.goals.Goal
 *  baritone.api.pathing.goals.GoalXZ
 *  baritone.api.utils.BetterBlockPos
 *  io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$Consumer
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockButton
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiDisconnected
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.GuiConnecting
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.item.EntityMinecartEmpty
 *  net.minecraft.entity.passive.AbstractChestHorse
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketVehicleMove
 *  net.minecraft.network.play.server.SPacketSetPassengers
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.utils.BetterBlockPos;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f3Y;
import dev.nuker.pyro.f3Z;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4A;
import dev.nuker.pyro.f4I;
import dev.nuker.pyro.f4c;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4r;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f7B;
import dev.nuker.pyro.f7C;
import dev.nuker.pyro.f7E;
import dev.nuker.pyro.f7F;
import dev.nuker.pyro.f7H;
import dev.nuker.pyro.f7I;
import dev.nuker.pyro.f7J;
import dev.nuker.pyro.f7K;
import dev.nuker.pyro.f7L;
import dev.nuker.pyro.f7M;
import dev.nuker.pyro.f7N;
import dev.nuker.pyro.f7O;
import dev.nuker.pyro.f7z;
import dev.nuker.pyro.f83;
import dev.nuker.pyro.fdN;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.few;
import dev.nuker.pyro.mixin.GuiDisconnectedAccessor;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7G
extends Module {
    @Nullable
    public ServerSocket Field3132;
    @Nullable
    public Thread Field3133;
    @Nullable
    public f7B Field3134;
    @NotNull
    public List<f7B> Field3135;
    public int Field3136;
    public boolean Field3137;
    @Nullable
    public MessagePassingQueue.Consumer<Boolean> Field3138;
    @NotNull
    public CopyOnWriteArrayList<Integer> Field3139;
    public boolean Field3140;
    @Nullable
    public fe8 Field3141;
    public boolean Field3142;
    public int Field3143;
    @NotNull
    public fe8 Field3144;
    public boolean Field3145;
    public boolean Field3146;
    public boolean Field3147;
    public int Field3148;
    @Nullable
    public fe8 Field3149;
    @NotNull
    public CopyOnWriteArrayList<Integer> Field3150;
    @Nullable
    public MessagePassingQueue.Consumer<Boolean> Field3151;
    public boolean Field3152;
    @Nullable
    public Vec3d Field3153;
    public boolean Field3154;
    @Nullable
    public fe8 Field3155;
    public boolean Field3156;
    @Nullable
    public Vec3d Field3157;
    @Nullable
    public Vec3d Field3158;
    @Nullable
    public BlockPos Field3159;
    public boolean Field3160;
    @NotNull
    public static f4c Field3161;
    public static f7z Field3162;

    public void Method551(int n) {
        this.Field3136 = n;
    }

    public boolean Method2390() {
        return this.Field3145;
    }

    public void Method4977(int n) {
        this.Field3143 = n;
    }

    @NotNull
    public List Method4978() {
        ArrayList<Entity> arrayList = new ArrayList<Entity>();
        for (Entity entity : this.Field5233.world.loadedEntityList) {
            if (!(entity instanceof AbstractChestHorse) || !((AbstractChestHorse)entity).hasChest() || !((AbstractChestHorse)entity).isRiding() || !(((AbstractChestHorse)entity).getRidingEntity() instanceof EntityBoat)) continue;
            arrayList.add(entity);
        }
        return arrayList;
    }

    public boolean Method4979() {
        return this.Field3152;
    }

    public static void Method4980(f7G f7G2, Minecraft minecraft) {
        f7G2.Field5233 = minecraft;
    }

    @f0g
    public void Method4981(@NotNull f4A f4A2) {
        if (this.Field3137) {
            if (this.Field5233.player.isRiding()) {
                f4A2.Method7948();
                this.Field5233.player.movementInput.sneak = true;
            } else {
                this.Field3137 = false;
                Pyro.Field6182.Method8989("Dismounted sucessfully!");
                f4A2.Method7948();
                this.Field5233.player.movementInput.sneak = false;
                if (this.Field3138 != null) {
                    MessagePassingQueue.Consumer<Boolean> consumer = this.Field3138;
                    if (consumer == null) {
                        Intrinsics.Method6551();
                    }
                    consumer.accept((Object)true);
                }
            }
        }
    }

    public void Method557(boolean bl) {
        this.Field3156 = bl;
    }

    public void Method2286(@NotNull BlockPos blockPos) {
        this.Method5002();
        GoalXZ goalXZ = new GoalXZ(new BetterBlockPos(blockPos));
        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath((Goal)goalXZ);
        this.Field3153 = new Vec3d((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ());
        this.Field3152 = true;
    }

    public void Method4982(@NotNull f3Y f3Y2, @NotNull f7B f7B2) {
        f3Z.Field3928.Method5628(f3Y2, Field3161, f7B2.Method5090());
    }

    @f0g
    public void Method244(@NotNull f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre && f4e2.Method5784() instanceof SPacketSetPassengers) {
            Packet packet = f4e2.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSetPassengers");
            }
            SPacketSetPassengers sPacketSetPassengers = (SPacketSetPassengers)packet;
        }
    }

    public void Method4983() {
        this.Field3157 = this.Field5233.player.getPositionVector();
        Pyro.Field6182.Method8989("Set the start pos");
    }

    public void Method4984(boolean bl) {
        this.Field3147 = bl;
    }

    @Nullable
    public Vec3d Method4985() {
        return this.Field3157;
    }

    public void Method4986() {
        if (this.Field5233.objectMouseOver != null && this.Field5233.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
            Block block = feg.Method690(this.Field5233.objectMouseOver.getBlockPos());
            if (block instanceof BlockButton) {
                this.Field3159 = this.Field5233.objectMouseOver.getBlockPos();
                Pyro.Field6182.Method8989("Set the button!");
                return;
            }
        }
        Pyro.Field6182.Method8989("WARNING! invalid button");
    }

    public void Method4987(@Nullable MessagePassingQueue.Consumer consumer) {
        this.Field3151 = consumer;
    }

    @Nullable
    public Vec3d Method4988() {
        return this.Field3158;
    }

    public void Method4989() {
        this.Field3137 = false;
        this.Field3138 = null;
        this.Field3139.clear();
        this.Field3140 = false;
        this.Field3141 = null;
        this.Field3142 = false;
        this.Field3145 = false;
        this.Field3146 = false;
        this.Field3147 = false;
        this.Field3148 = this.Field3135.size();
        this.Field3149 = null;
        this.Field3143 = -1;
        this.Field3150.clear();
        this.Field3151 = null;
        this.Field3152 = false;
        this.Field3153 = null;
        this.Field3154 = false;
        this.Field3155 = null;
        this.Field3156 = false;
    }

    public boolean Method4990() {
        return this.Field3132 != null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method4991() {
        if (!this.Field5233.player.isRiding()) return false;
        if (!(this.Field5233.player.getRidingEntity() instanceof EntityMinecartEmpty)) return false;
        return true;
    }

    public void Method4992(@Nullable f7B f7B2) {
        this.Field3134 = f7B2;
    }

    @Nullable
    public MessagePassingQueue.Consumer Method4993() {
        return this.Field3151;
    }

    public void Method4994(@Nullable Vec3d vec3d) {
        this.Field3153 = vec3d;
    }

    @Nullable
    public fe8 Method4995() {
        return this.Field3149;
    }

    public boolean Method4996() {
        return this.Field3160;
    }

    public void Method4997() {
        if (this.Field5233.player != null) {
            this.Field3160 = false;
            PyroStatic.Field6415.Field5236.Method5266(true);
            PyroStatic.Field6415.Method238().Method7975(900.0);
            this.Field3144.Method490();
            this.Field3145 = true;
            NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.getNetworkManager().closeChannel((ITextComponent)new TextComponentString("Waiting for other client to tell us we can reconnect"));
        } else {
            String string = "recv disconnect but already DC!";
            boolean bl = false;
            System.out.println((Object)string);
        }
    }

    public void Method4998(@NotNull f3Y f3Y2, @NotNull f7B f7B2) {
        f3Y f3Y3 = f3Y2;
        if (f3Y3 instanceof f7J) {
            Pyro.Field6182.Method8989("PING: " + ((f7J)f3Y2).Method5103());
            if (Intrinsics.Method6572(((f7J)f3Y2).Method5103(), "Ping")) {
                this.Method4982(new f7J("Pong"), f7B2);
            }
        } else if (f3Y3 instanceof f7O) {
            this.Method2491();
        } else if (f3Y3 instanceof f7M) {
            this.Method5041((f7M)f3Y2, f7B2);
        } else if (f3Y3 instanceof f7N) {
            this.Method5019((f7N)f3Y2);
        } else if (f3Y3 instanceof f7H) {
            this.Method5028();
        } else if (f3Y3 instanceof f7I) {
            this.Method4997();
        } else if (f3Y3 instanceof f7L) {
            this.Method5033();
        } else if (f3Y3 instanceof f7K) {
            this.Method5008();
        }
    }

    public void Method2406(boolean bl) {
        this.Field3145 = bl;
    }

    public int Method539() {
        return this.Field3136;
    }

    public void Method2413(boolean bl) {
        this.Field3152 = bl;
    }

    @Nullable
    public MessagePassingQueue.Consumer Method4999() {
        return this.Field3138;
    }

    public void Method5000() {
        this.Field3158 = this.Field5233.player.getPositionVector();
        Pyro.Field6182.Method8989("Set the quarry pos");
    }

    public boolean Method5001() {
        return this.Field3137;
    }

    public void Method5002() {
        BaritoneAPI.getSettings().allowSprint.value = true;
        BaritoneAPI.getSettings().allowBreak.value = false;
        BaritoneAPI.getSettings().primaryTimeoutMS.value = 2000L;
    }

    public boolean Method4930() {
        return this.Field3147;
    }

    public void Method5003(@Nullable fe8 fe82) {
        this.Field3141 = fe82;
    }

    public void Method541(int n) {
        this.Field3136 = n;
        this.Field3132 = new ServerSocket(n);
        this.Field3133 = ThreadsKt.Method9564(true, false, null, null, 0, new f7F(this), 30, null);
    }

    @Nullable
    public EntityMinecartEmpty Method5004() {
        if (this.Method4991()) {
            Entity entity = this.Field5233.player.getRidingEntity();
            if (entity == null) {
                Intrinsics.Method6551();
            }
            if (!this.Field3139.contains(entity.getEntityId())) {
                Entity entity2 = this.Field5233.player.getRidingEntity();
                if (entity2 == null) {
                    Intrinsics.Method6551();
                }
                this.Field3139.add(entity2.getEntityId());
            }
        }
        EntityMinecartEmpty entityMinecartEmpty = null;
        float f = 1000.0f;
        for (Entity entity : this.Field5233.world.loadedEntityList) {
            float f2;
            if (!(entity instanceof EntityMinecartEmpty) || this.Field3139.contains(((EntityMinecartEmpty)entity).getEntityId()) || !((f2 = this.Field5233.player.getDistance(entity)) < f) || !fdN.Method348(entity)) continue;
            f = f2;
            entityMinecartEmpty = (EntityMinecartEmpty)entity;
        }
        return entityMinecartEmpty;
    }

    public void Method2491() {
        this.Field5236.Method5266(false);
        this.Field5236.Method5266(true);
        this.Field3160 = true;
        Pyro.Field6182.Method8989("Received start packet!");
        this.Field3140 = true;
    }

    public static f4c Method5005() {
        return Field3161;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        block2: {
            block4: {
                block3: {
                    super.Method205(bl, entityPlayerSP, world);
                    this.Method4989();
                    if (!bl || !this.Method4990()) break block2;
                    if (this.Field3159 == null) break block3;
                    if (this.Field3158 != null && this.Field3157 != null) break block4;
                }
                Pyro.Field6182.Method8989("Bad config. You didn't set a position");
                this.Field5236.Method5266(false);
                return;
            }
            Pyro.Field6182.Method8989("Starting the dupe..... sending the packet to all clients to start!");
            this.Method5012(new f7O());
        }
    }

    public void Method316(@NotNull CopyOnWriteArrayList copyOnWriteArrayList) {
        this.Field3150 = copyOnWriteArrayList;
    }

    public void Method5006(@NotNull String string, int n) {
        this.Field3136 = n;
        this.Field3134 = new f7B(this, new Socket(string, n));
    }

    public void Method5007(@Nullable Vec3d vec3d) {
        this.Field3158 = vec3d;
    }

    public void Method5008() {
        f7G f7G2 = this;
        f7G2.Field3148 += -1;
        if (f7G2.Field3148 <= 0) {
            this.Method4989();
            Pyro.Field6182.Method8989("Repeating the dupe!!..... sending the packet to all clients to start!");
            this.Method5012(new f7O());
        }
    }

    public void Method209(@Nullable BlockPos blockPos) {
        this.Field3159 = blockPos;
    }

    public void Method5009(@NotNull CopyOnWriteArrayList copyOnWriteArrayList) {
        this.Field3139 = copyOnWriteArrayList;
    }

    public int Method5010() {
        return this.Field3148;
    }

    public void Method2276(@Nullable Thread thread2) {
        this.Field3133 = thread2;
    }

    public void Method5011(@Nullable fe8 fe82) {
        this.Field3155 = fe82;
    }

    public void Method5012(@NotNull f3Y f3Y2) {
        if (this.Method4990()) {
            Iterable iterable = this.Field3135;
            boolean bl = false;
            for (Object t : iterable) {
                f7B f7B2 = (f7B)t;
                boolean bl2 = false;
                this.Method4982(f3Y2, f7B2);
            }
        } else {
            f7B f7B3 = this.Field3134;
            if (f7B3 == null) {
                Intrinsics.Method6551();
            }
            this.Method4982(f3Y2, f7B3);
        }
    }

    public void Method5013(@NotNull fe8 fe82) {
        this.Field3144 = fe82;
    }

    @NotNull
    public CopyOnWriteArrayList Method5014() {
        return this.Field3150;
    }

    public void Method2402(boolean bl) {
        this.Field3160 = bl;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        super.Method195(vec3d, f);
        if (this.Field3159 != null) {
            fe5.Field252.Method408(7);
            BlockPos blockPos = this.Field3159;
            if (blockPos == null) {
                Intrinsics.Method6551();
            }
            fe5.Field252.Method410(blockPos, 0x3FFF0000, 63);
            fe5.Field252.Method405();
        }
    }

    public int Method5015() {
        return this.Field3143;
    }

    public f7G() {
        super("autodupe", "AutoDupe", null);
        List list;
        f7G f7G2 = this;
        boolean bl = false;
        f7G2.Field3135 = list = (List)new ArrayList();
        this.Field3136 = -1;
        this.Field3139 = new CopyOnWriteArrayList();
        this.Field3143 = -1;
        this.Field3144 = new fe8();
        this.Field3150 = new CopyOnWriteArrayList();
    }

    static {
        Field3162 = new f7z(null);
        Field3161 = new f4c(CollectionsKt.Method1018(f7J.class, f7O.class, f7M.class, f7N.class, f7H.class, f7I.class, f7L.class, f7K.class));
    }

    @Nullable
    public ServerSocket Method5016() {
        return this.Field3132;
    }

    public boolean Method4876() {
        return this.Field3140;
    }

    public void Method5017(boolean bl) {
        this.Field3154 = bl;
    }

    public boolean Method5018() {
        return this.Field3154;
    }

    public void Method5019(@NotNull f7N f7N2) {
        int n;
        Pyro.Field6182.Method8989("Received RideEntityIDPacket with entityid " + f7N2.Method5103());
        Pyro.Field6182.Method8989("Sending the packet....");
        String string = f7N2.Method5103();
        f7G f7G2 = this;
        boolean bl = false;
        f7G2.Field3143 = n = Integer.parseInt(string);
        string = new EntityDonkey((World)this.Field5233.world);
        string.setEntityId(this.Field3143);
        NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
        if (netHandlerPlayClient == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient.sendPacket((Packet)new CPacketUseEntity((Entity)string, EnumHand.MAIN_HAND));
        this.Method5012(new f7H());
    }

    public boolean Method5020() {
        return this.Field3142;
    }

    public static Minecraft Method5021(f7G f7G2) {
        return f7G2.Field5233;
    }

    @f0g
    public void Method5022(@NotNull f4I f4I2) {
        if (this.Method4990() && f4I2.Method5702() instanceof AbstractChestHorse && this.Field3156) {
            int n = f4I2.Method5702().getEntityId();
            if (this.Field3150.contains(n)) {
                this.Field3150.remove((Object)n);
            }
            if (this.Field3150.isEmpty()) {
                Pyro.Field6182.Method8989("All duped donkies are dead!");
                PyroStatic.Field6445.Field5236.Method5266(false);
                this.Method5012(new f7L());
                Vec3d vec3d = this.Field3157;
                if (vec3d == null) {
                    Intrinsics.Method6551();
                }
                this.Method2283(vec3d);
            } else {
                Pyro.Field6182.Method8989("Waiting for " + this.Field3150.size() + " more donkies to be killed!");
            }
        }
    }

    public boolean Method5023() {
        return this.Field3156;
    }

    public void Method5024(@Nullable Vec3d vec3d) {
        this.Field3157 = vec3d;
    }

    public void Method5025(boolean bl) {
        this.Field3146 = bl;
    }

    public boolean Method5026() {
        return this.Field3146;
    }

    @Nullable
    public fe8 Method5027() {
        return this.Field3141;
    }

    @f0g
    public void Method2393(@NotNull f49 f492) {
        if (f492.Method5619() == f41.Pre && this.Field3160) {
            Packet packet = f492.Method5784();
            if (packet instanceof CPacketVehicleMove) {
                f492.Method7948();
            } else if (packet instanceof CPacketPlayer) {
                f492.Method7948();
            }
        }
    }

    public void Method5028() {
        f7G f7G2 = this;
        f7G2.Field3148 += -1;
        if (f7G2.Field3148 <= 0) {
            Pyro.Field6182.Method8989("Received enough accounts riding! riding the minecart!");
            this.Field3140 = true;
        }
    }

    public void Method5029(int n) {
        this.Field3148 = n;
    }

    @Nullable
    public f7B Method5030() {
        return this.Field3134;
    }

    @f0g
    public void Method183(@NotNull f4t f4t2) {
        if (this.Field3149 != null) {
            fe8 fe82 = this.Field3149;
            if (fe82 == null) {
                Intrinsics.Method6551();
            }
            if (fe82.Method491(10000.0)) {
                this.Field3149 = null;
            }
            return;
        }
        if (this.Field3155 != null) {
            fe8 fe83 = this.Field3155;
            if (fe83 == null) {
                Intrinsics.Method6551();
            }
            if (fe83.Method491(3000.0)) {
                this.Method5012(new f7K());
                Pyro.Field6182.Method8989("Sent the ready packet!");
                this.Field3155 = null;
                this.Field5236.Method5266(false);
            }
            return;
        }
        if (this.Field3152) {
            double d;
            Vec3d vec3d = this.Field3153;
            if (vec3d == null) {
                Intrinsics.Method6551();
            }
            Vec3d vec3d2 = this.Field3153;
            if (vec3d2 == null) {
                Intrinsics.Method6551();
            }
            Vec3d vec3d3 = this.Field3153;
            if (vec3d3 == null) {
                Intrinsics.Method6551();
            }
            if ((d = this.Field5233.player.getDistance(vec3d.x, vec3d2.y, vec3d3.z)) <= (double)2) {
                this.Field3152 = false;
                if (this.Field3151 != null) {
                    Pyro.Field6182.Method8989("Accepting callback of baritone");
                    MessagePassingQueue.Consumer<Boolean> consumer = this.Field3151;
                    if (consumer == null) {
                        Intrinsics.Method6551();
                    }
                    consumer.accept((Object)true);
                    this.Field3151 = null;
                }
            }
        }
        if (this.Field3140) {
            EntityMinecartEmpty entityMinecartEmpty = this.Method5004();
            if (entityMinecartEmpty != null) {
                NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
                if (netHandlerPlayClient == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient.sendPacket((Packet)new CPacketUseEntity((Entity)entityMinecartEmpty, EnumHand.MAIN_HAND));
                this.Field3141 = null;
            } else if (this.Field3141 == null) {
                fe8 fe84 = this.Field3141 = new fe8();
                if (fe84 == null) {
                    Intrinsics.Method6551();
                }
                fe84.Method490();
            } else {
                fe8 fe85 = this.Field3141;
                if (fe85 == null) {
                    Intrinsics.Method6551();
                }
                if (fe85.Method491(1000.0)) {
                    if (!this.Field3142) {
                        this.Field3142 = true;
                        Pyro.Field6182.Method8989("No more minecarts found!");
                        if (!this.Method4990()) {
                            this.Field3140 = false;
                            this.Method5012(new f7M(String.valueOf(this.Field5233.player.getEntityId())));
                            Pyro.Field6182.Method8989("Asking for an entity to ride");
                        } else {
                            fe8 fe86 = this.Field3149 = new fe8();
                            if (fe86 == null) {
                                Intrinsics.Method6551();
                            }
                            fe86.Method490();
                            Pyro.Field6182.Method8989("Delaying for 10 seconds as we went through the track.");
                            this.Field3140 = true;
                            this.Field3139.clear();
                        }
                    } else {
                        if (!this.Method4990() && this.Field3145 && !this.Field3147) {
                            this.Field3147 = true;
                            fe8 fe87 = this.Field3155 = new fe8();
                            if (fe87 == null) {
                                Intrinsics.Method6551();
                            }
                            fe87.Method490();
                        }
                        if (this.Method4990()) {
                            if (this.Field5233.world.playerEntities.size() == 1) {
                                List list = this.Method4978();
                                if (list != null) {
                                    this.Field3150.clear();
                                    Iterable iterable = list;
                                    boolean bl = false;
                                    for (Object t : iterable) {
                                        AbstractChestHorse abstractChestHorse = (AbstractChestHorse)t;
                                        boolean bl2 = false;
                                        this.Field3150.add(abstractChestHorse.getEntityId());
                                    }
                                    Pyro.Field6182.Method8989("Found " + list.size() + " duped donkies, dismounting");
                                    this.Field3156 = true;
                                    this.Field3137 = true;
                                    this.Field3140 = false;
                                    this.Method5012(new f7I());
                                    this.Field3138 = new f7E(this);
                                }
                            } else {
                                Pyro.Field6182.Method8989("Dupe failed! Reloading chunk");
                                this.Field3139.clear();
                                this.Field3142 = false;
                            }
                        }
                    }
                }
            }
        }
    }

    public void Method2399(boolean bl) {
        this.Field3142 = bl;
    }

    public void Method4965(@Nullable fe8 fe82) {
        this.Field3149 = fe82;
    }

    public void Method4841(@NotNull List list) {
        this.Field3135 = list;
    }

    public void Method5031() {
        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(null);
    }

    public void Method2407(@NotNull Entity entity) {
        this.Method2283(entity.getPositionVector());
    }

    public void Method5032(boolean bl) {
        this.Field3137 = bl;
    }

    public void Method5033() {
        String string = "We can reconnect now!";
        boolean bl = false;
        System.out.println((Object)string);
        if (this.Field5233.player == null) {
            this.Field3146 = true;
            this.Field3139.clear();
            this.Field3140 = true;
        }
    }

    @Nullable
    public BlockPos Method5034() {
        return this.Field3159;
    }

    @f0g
    public void Method277(@NotNull f43 f432) {
        if (f432.Method5619() == f41.Pre && this.Field5233.currentScreen instanceof GuiDisconnected) {
            if (this.Field3146 && this.Field3144.Method491(35000.0)) {
                GuiScreen guiScreen = this.Field5233.currentScreen;
                if (guiScreen == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.GuiDisconnectedAccessor");
                }
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiConnecting(((GuiDisconnectedAccessor)guiScreen).Method1350(), Minecraft.getMinecraft(), f83.Field3315));
            }
        }
    }

    public void Method5035(@Nullable MessagePassingQueue.Consumer consumer) {
        this.Field3138 = consumer;
    }

    @Nullable
    public Thread Method5036() {
        return this.Field3133;
    }

    @Nullable
    public fe8 Method5037() {
        return this.Field3155;
    }

    @Nullable
    public Vec3d Method5038() {
        return this.Field3153;
    }

    public void Method5039(@Nullable ServerSocket serverSocket) {
        this.Field3132 = serverSocket;
    }

    @f0g
    public void Method203(@NotNull f4u f4u2) {
        if (!f4u2.Method7947() && f4u2.Method5619() == f41.Pre && this.Method4990()) {
            if (this.Field3154) {
                this.Field3154 = false;
                BlockPos blockPos = this.Field3159;
                if (blockPos == null) {
                    Intrinsics.Method6551();
                }
                BlockPos blockPos2 = blockPos;
                EnumFacing enumFacing = few.Method848(blockPos2, true);
                float[] arrf = few.Method835().Method850(blockPos2, enumFacing);
                f4u2.Method7948();
                f4u2.Method5653(arrf[0]);
                f4u2.Method5647(arrf[1]);
                RayTraceResult rayTraceResult = few.Method835().Method849(arrf[0], arrf[1]);
                Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.Field5298 = 0.0f;
                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                floatRef2.Field5298 = 0.0f;
                Ref.FloatRef floatRef3 = new Ref.FloatRef();
                floatRef3.Field5298 = 0.0f;
                if (rayTraceResult != null) {
                    BlockPos blockPos3 = blockPos2;
                    if (blockPos3 == null) {
                        Intrinsics.Method6551();
                    }
                    floatRef.Field5298 = (float)(rayTraceResult.hitVec.x - (double)blockPos3.getX());
                    floatRef2.Field5298 = (float)(rayTraceResult.hitVec.y - (double)blockPos2.getY());
                    floatRef3.Field5298 = (float)(rayTraceResult.hitVec.z - (double)blockPos2.getZ());
                }
                f4u2.Method5816(new f7C(this, blockPos2, enumFacing, floatRef, floatRef2, floatRef3));
            }
        }
    }

    @NotNull
    public List Method5040() {
        return this.Field3135;
    }

    public void Method5041(@NotNull f7M f7M2, @NotNull f7B f7B2) {
        Pyro.Field6182.Method8989("recieved entityid with " + f7M2.Method5103());
        AbstractChestHorse abstractChestHorse = null;
        float f = 100.0f;
        for (Entity entity : this.Field5233.world.loadedEntityList) {
            float f2;
            if (!(entity instanceof AbstractChestHorse)) continue;
            if (((AbstractChestHorse)entity).hasChest() || !((AbstractChestHorse)entity).isRiding() || !(((AbstractChestHorse)entity).getRidingEntity() instanceof EntityBoat) || !((AbstractChestHorse)entity).getPassengers().isEmpty() || !((f2 = this.Field5233.player.getDistance(entity)) < f)) continue;
            f = f2;
            abstractChestHorse = (AbstractChestHorse)entity;
        }
        if (abstractChestHorse != null) {
            this.Method4982(new f7N(String.valueOf(abstractChestHorse.getEntityId())), f7B2);
            Pyro.Field6182.Method8989("Found donkey EntityID " + abstractChestHorse.getEntityId() + " for " + f7M2.Method5103() + " to ride");
        }
    }

    @f0g
    public void Method5042(@NotNull f4r f4r2) {
        this.Field5233.player.setPosition(f4r2.Method5852().posX, f4r2.Method5852().posY, f4r2.Method5852().posZ);
        if (f4r2.Method5852() instanceof EntityMinecartEmpty) {
            if (!this.Field3139.contains(f4r2.Method5852().getEntityId())) {
                this.Field3139.add(f4r2.Method5852().getEntityId());
            } else {
                Pyro.Field6182.Method8989("WARNING! Ridden a duplicated id in the minecart list!");
            }
        }
    }

    @NotNull
    public CopyOnWriteArrayList Method5043() {
        return this.Field3139;
    }

    @NotNull
    public fe8 Method5044() {
        return this.Field3144;
    }

    public void Method5045(boolean bl) {
        this.Field3140 = bl;
    }

    public void Method2283(@NotNull Vec3d vec3d) {
        this.Method5002();
        GoalXZ goalXZ = new GoalXZ(new BetterBlockPos(vec3d.x, vec3d.y, vec3d.z));
        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath((Goal)goalXZ);
        this.Field3153 = vec3d;
        this.Field3152 = true;
    }
}

