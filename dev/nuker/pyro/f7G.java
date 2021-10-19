/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.utils.BetterBlockPos;
import dev.nuker.pyro.mixin.GuiDisconnectedAccessor;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7G extends Module {
   // $FF: renamed from: c java.net.ServerSocket
   @Nullable
   public ServerSocket field_525;
   // $FF: renamed from: c java.lang.Thread
   @Nullable
   public Thread field_526;
   // $FF: renamed from: c dev.nuker.pyro.f7B
   @Nullable
   public f7B field_527;
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_528;
   // $FF: renamed from: 1 int
   public int field_529;
   // $FF: renamed from: c boolean
   public boolean field_530;
   // $FF: renamed from: c io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer
   @Nullable
   public Consumer field_531;
   // $FF: renamed from: c java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList field_532;
   // $FF: renamed from: 0 boolean
   public boolean field_533;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @Nullable
   public fe8 field_534;
   // $FF: renamed from: 1 boolean
   public boolean field_535;
   // $FF: renamed from: 2 int
   public int field_536;
   // $FF: renamed from: 0 dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_537;
   // $FF: renamed from: 2 boolean
   public boolean field_538;
   // $FF: renamed from: 3 boolean
   public boolean field_539;
   // $FF: renamed from: 4 boolean
   public boolean field_540;
   // $FF: renamed from: 3 int
   public int field_541;
   // $FF: renamed from: 1 dev.nuker.pyro.fe8
   @Nullable
   public fe8 field_542;
   // $FF: renamed from: 0 java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList field_543;
   // $FF: renamed from: 0 io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer
   @Nullable
   public Consumer field_544;
   // $FF: renamed from: 5 boolean
   public boolean field_545;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d field_546;
   // $FF: renamed from: 6 boolean
   public boolean field_547;
   // $FF: renamed from: 2 dev.nuker.pyro.fe8
   @Nullable
   public fe8 field_548;
   // $FF: renamed from: 7 boolean
   public boolean field_549;
   // $FF: renamed from: 0 net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d field_550;
   // $FF: renamed from: 1 net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d field_551;
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos field_552;
   // $FF: renamed from: 8 boolean
   public boolean field_553;
   // $FF: renamed from: c dev.nuker.pyro.f4c
   @NotNull
   public static f4c field_554 = new f4c(CollectionsKt.mutableListOf(new Class[]{f7J.class, f7O.class, f7M.class, f7N.class, f7H.class, f7I.class, f7L.class, f7K.class}));
   // $FF: renamed from: c dev.nuker.pyro.f7z
   public static f7z field_555 = new f7z((DefaultConstructorMarker)null);

   // $FF: renamed from: 4 (int) void
   public void method_743(int var1) {
      this.field_529 = var1;
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_744() {
      return this.field_538;
   }

   // $FF: renamed from: 5 (int) void
   public void method_745(int var1) {
      this.field_536 = var1;
   }

   // $FF: renamed from: E () java.util.List
   @NotNull
   public List method_746() {
      ArrayList var1 = new ArrayList();
      Iterator var3 = this.c.world.loadedEntityList.iterator();

      while(var3.hasNext()) {
         Entity var2 = (Entity)var3.next();
         if (var2 instanceof AbstractChestHorse && ((AbstractChestHorse)var2).hasChest() && ((AbstractChestHorse)var2).isRiding() && ((AbstractChestHorse)var2).getRidingEntity() instanceof EntityBoat) {
            var1.add(var2);
         }
      }

      return (List)var1;
   }

   // $FF: renamed from: e () boolean
   public boolean method_747() {
      return this.field_545;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7G, net.minecraft.client.Minecraft) void
   public static void method_748(f7G var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4A) void
   @f0g
   public void method_749(@NotNull f4A var1) {
      if (this.field_530) {
         if (this.c.player.isRiding()) {
            var1.0();
            this.c.player.movementInput.sneak = true;
         } else {
            this.field_530 = false;
            Pyro.INSTANCE.sendMessage("Dismounted sucessfully!");
            var1.0();
            this.c.player.movementInput.sneak = false;
            if (this.field_531 != null) {
               Consumer var10000 = this.field_531;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var10000.accept(true);
            }
         }
      }

   }

   // $FF: renamed from: c (boolean) void
   public void method_750(boolean var1) {
      this.field_549 = var1;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos) void
   public void method_751(@NotNull BlockPos var1) {
      this.method_776();
      GoalXZ var2 = new GoalXZ(new BetterBlockPos(var1));
      BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath((Goal)var2);
      this.field_546 = new Vec3d((double)var1.getX(), (double)var1.getY(), (double)var1.getZ());
      this.field_545 = true;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f3Y, dev.nuker.pyro.f7B) void
   public void method_752(@NotNull f3Y var1, @NotNull f7B var2) {
      f3Z.field_2126.method_3205(var1, field_554, var2.method_2986());
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   public void method_753(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketSetPassengers) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSetPassengers");
         }

         SPacketSetPassengers var2 = (SPacketSetPassengers)var10000;
      }

   }

   // $FF: renamed from: s () void
   public void method_754() {
      this.field_550 = this.c.player.getPositionVector();
      Pyro.INSTANCE.sendMessage("Set the start pos");
   }

   // $FF: renamed from: 6 (boolean) void
   public void method_755(boolean var1) {
      this.field_540 = var1;
   }

   // $FF: renamed from: g () net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d method_756() {
      return this.field_550;
   }

   // $FF: renamed from: z () void
   public void method_757() {
      if (this.c.objectMouseOver != null && this.c.objectMouseOver.typeOfHit == Type.BLOCK) {
         Block var1 = feg.method_1779(this.c.objectMouseOver.getBlockPos());
         if (var1 instanceof BlockButton) {
            this.field_552 = this.c.objectMouseOver.getBlockPos();
            Pyro.INSTANCE.sendMessage("Set the button!");
            return;
         }
      }

      Pyro.INSTANCE.sendMessage("WARNING! invalid button");
   }

   // $FF: renamed from: 0 (io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer) void
   public void method_758(@Nullable Consumer var1) {
      this.field_544 = var1;
   }

   // $FF: renamed from: 7 () net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d method_759() {
      return this.field_551;
   }

   // $FF: renamed from: 5 () void
   public void method_760() {
      this.field_530 = false;
      this.field_531 = (Consumer)null;
      this.field_532.clear();
      this.field_533 = false;
      this.field_534 = (fe8)null;
      this.field_535 = false;
      this.field_538 = false;
      this.field_539 = false;
      this.field_540 = false;
      this.field_541 = this.field_528.size();
      this.field_542 = (fe8)null;
      this.field_536 = -1;
      this.field_543.clear();
      this.field_544 = (Consumer)null;
      this.field_545 = false;
      this.field_546 = (Vec3d)null;
      this.field_547 = false;
      this.field_548 = (fe8)null;
      this.field_549 = false;
   }

   // $FF: renamed from: i () boolean
   public boolean method_761() {
      return this.field_525 != null;
   }

   // $FF: renamed from: 3 () boolean
   public boolean method_762() {
      return this.c.player.isRiding() && this.c.player.getRidingEntity() instanceof EntityMinecartEmpty;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7B) void
   public void method_763(@Nullable f7B var1) {
      this.field_527 = var1;
   }

   // $FF: renamed from: o () io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer
   @Nullable
   public Consumer method_764() {
      return this.field_544;
   }

   // $FF: renamed from: 2 (net.minecraft.util.math.Vec3d) void
   public void method_765(@Nullable Vec3d var1) {
      this.field_546 = var1;
   }

   // $FF: renamed from: n () dev.nuker.pyro.fe8
   @Nullable
   public fe8 method_766() {
      return this.field_542;
   }

   // $FF: renamed from: x () boolean
   public boolean method_767() {
      return this.field_553;
   }

   // $FF: renamed from: u () void
   public void method_768() {
      if (this.c.player != null) {
         this.field_553 = false;
         PyroStatic.field_2479.c.method_3033(true);
         PyroStatic.field_2479.method_682().c(900.0D);
         this.field_537.method_1979();
         this.field_538 = true;
         NetHandlerPlayClient var10000 = this.c.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.getNetworkManager().closeChannel((ITextComponent)(new TextComponentString("Waiting for other client to tell us we can reconnect")));
      } else {
         String var1 = "recv disconnect but already DC!";
         boolean var2 = false;
         System.out.println(var1);
      }

   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f3Y, dev.nuker.pyro.f7B) void
   public void method_769(@NotNull f3Y var1, @NotNull f7B var2) {
      if (var1 instanceof f7J) {
         Pyro.INSTANCE.sendMessage("PING: " + ((f7J)var1).method_2980());
         if (Intrinsics.areEqual((Object)((f7J)var1).method_2980(), (Object)"Ping")) {
            this.method_752((f3Y)(new f7J("Pong")), var2);
         }
      } else if (var1 instanceof f7O) {
         this.method_781();
      } else if (var1 instanceof f7M) {
         this.method_831((f7M)var1, var2);
      } else if (var1 instanceof f7N) {
         this.method_801((f7N)var1);
      } else if (var1 instanceof f7H) {
         this.method_811();
      } else if (var1 instanceof f7I) {
         this.method_768();
      } else if (var1 instanceof f7L) {
         this.method_821();
      } else if (var1 instanceof f7K) {
         this.method_786();
      }

   }

   // $FF: renamed from: 1 (boolean) void
   public void method_770(boolean var1) {
      this.field_538 = var1;
   }

   // $FF: renamed from: a () int
   public int method_771() {
      return this.field_529;
   }

   // $FF: renamed from: 3 (boolean) void
   public void method_772(boolean var1) {
      this.field_545 = var1;
   }

   // $FF: renamed from: B () io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer
   @Nullable
   public Consumer method_773() {
      return this.field_531;
   }

   // $FF: renamed from: y () void
   public void method_774() {
      this.field_551 = this.c.player.getPositionVector();
      Pyro.INSTANCE.sendMessage("Set the quarry pos");
   }

   // $FF: renamed from: l () boolean
   public boolean method_775() {
      return this.field_530;
   }

   // $FF: renamed from: h () void
   public void method_776() {
      BaritoneAPI.getSettings().allowSprint.value = true;
      BaritoneAPI.getSettings().allowBreak.value = false;
      BaritoneAPI.getSettings().primaryTimeoutMS.value = 2000L;
   }

   // $FF: renamed from: 4 () boolean
   public boolean method_777() {
      return this.field_540;
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.fe8) void
   public void method_778(@Nullable fe8 var1) {
      this.field_534 = var1;
   }

   // $FF: renamed from: 3 (int) void
   public void method_779(int var1) {
      this.field_529 = var1;
      this.field_525 = new ServerSocket(var1);
      this.field_526 = ThreadsKt.thread$default(true, false, (ClassLoader)null, (String)null, 0, (Function0)(new f7F(this)), 30, (Object)null);
   }

   // $FF: renamed from: r () net.minecraft.entity.item.EntityMinecartEmpty
   @Nullable
   public EntityMinecartEmpty method_780() {
      if (this.method_762()) {
         CopyOnWriteArrayList var10000 = this.field_532;
         Entity var10001 = this.c.player.getRidingEntity();
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         if (!var10000.contains(var10001.getEntityId())) {
            var10000 = this.field_532;
            var10001 = this.c.player.getRidingEntity();
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            var10000.add(var10001.getEntityId());
         }
      }

      EntityMinecartEmpty var1 = (EntityMinecartEmpty)null;
      float var2 = 1000.0F;
      Iterator var4 = this.c.world.loadedEntityList.iterator();

      while(var4.hasNext()) {
         Entity var3 = (Entity)var4.next();
         if (var3 instanceof EntityMinecartEmpty && !this.field_532.contains(((EntityMinecartEmpty)var3).getEntityId())) {
            float var5 = this.c.player.getDistance(var3);
            if (var5 < var2 && fdN.method_1859(var3)) {
               var2 = var5;
               var1 = (EntityMinecartEmpty)var3;
            }
         }
      }

      return var1;
   }

   // $FF: renamed from: 0 () void
   public void method_781() {
      this.c.method_3033(false);
      this.c.method_3033(true);
      this.field_553 = true;
      Pyro.INSTANCE.sendMessage("Received start packet!");
      this.field_533 = true;
   }

   // $FF: renamed from: I () dev.nuker.pyro.f4c
   public static f4c method_782() {
      return field_554;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.method_760();
      if (var1 && this.method_761()) {
         if (this.field_552 == null || this.field_551 == null || this.field_550 == null) {
            Pyro.INSTANCE.sendMessage("Bad config. You didn't set a position");
            this.c.method_3033(false);
            return;
         }

         Pyro.INSTANCE.sendMessage("Starting the dupe..... sending the packet to all clients to start!");
         this.method_792((f3Y)(new f7O()));
      }

   }

   // $FF: renamed from: c (java.util.concurrent.CopyOnWriteArrayList) void
   public void method_783(@NotNull CopyOnWriteArrayList var1) {
      this.field_543 = var1;
   }

   // $FF: renamed from: c (java.lang.String, int) void
   public void method_784(@NotNull String var1, int var2) {
      this.field_529 = var2;
      this.field_527 = new f7B(this, new Socket(var1, var2));
   }

   // $FF: renamed from: 1 (net.minecraft.util.math.Vec3d) void
   public void method_785(@Nullable Vec3d var1) {
      this.field_551 = var1;
   }

   // $FF: renamed from: 9 () void
   public void method_786() {
      this.field_541 += -1;
      if (this.field_541 <= 0) {
         this.method_760();
         Pyro.INSTANCE.sendMessage("Repeating the dupe!!..... sending the packet to all clients to start!");
         this.method_792((f3Y)(new f7O()));
      }

   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_787(@Nullable BlockPos var1) {
      this.field_552 = var1;
   }

   // $FF: renamed from: 0 (java.util.concurrent.CopyOnWriteArrayList) void
   public void method_788(@NotNull CopyOnWriteArrayList var1) {
      this.field_532 = var1;
   }

   // $FF: renamed from: p () int
   public int method_789() {
      return this.field_541;
   }

   // $FF: renamed from: c (java.lang.Thread) void
   public void method_790(@Nullable Thread var1) {
      this.field_526 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fe8) void
   public void method_791(@Nullable fe8 var1) {
      this.field_548 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f3Y) void
   public void method_792(@NotNull f3Y var1) {
      if (this.method_761()) {
         Iterable var2 = (Iterable)this.field_528;
         boolean var3 = false;
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            f7B var6 = (f7B)var5;
            boolean var7 = false;
            this.method_752(var1, var6);
         }
      } else {
         f7B var10002 = this.field_527;
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         this.method_752(var1, var10002);
      }

   }

   // $FF: renamed from: 2 (dev.nuker.pyro.fe8) void
   public void method_793(@NotNull fe8 var1) {
      this.field_537 = var1;
   }

   // $FF: renamed from: G () java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList method_794() {
      return this.field_543;
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_795(boolean var1) {
      this.field_553 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      if (this.field_552 != null) {
         fe5.field_1245.method_1915(7);
         fe5 var10000 = fe5.field_1245;
         BlockPos var10001 = this.field_552;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_1917(var10001, 1073676288, 63);
         fe5.field_1245.method_1912();
      }

   }

   // $FF: renamed from: 8 () int
   public int method_796() {
      return this.field_536;
   }

   public f7G() {
      super("autodupe", "AutoDupe", (String)null);
      boolean var1 = false;
      List var3 = (List)(new ArrayList());
      this.field_528 = var3;
      this.field_529 = -1;
      this.field_532 = new CopyOnWriteArrayList();
      this.field_536 = -1;
      this.field_537 = new fe8();
      this.field_543 = new CopyOnWriteArrayList();
   }

   // $FF: renamed from: d () java.net.ServerSocket
   @Nullable
   public ServerSocket method_797() {
      return this.field_525;
   }

   // $FF: renamed from: c () boolean
   public boolean method_798() {
      return this.field_533;
   }

   // $FF: renamed from: 5 (boolean) void
   public void method_799(boolean var1) {
      this.field_547 = var1;
   }

   // $FF: renamed from: q () boolean
   public boolean method_800() {
      return this.field_547;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7N) void
   public void method_801(@NotNull f7N var1) {
      Pyro.INSTANCE.sendMessage("Received RideEntityIDPacket with entityid " + var1.method_2982());
      Pyro.INSTANCE.sendMessage("Sending the packet....");
      String var2 = var1.method_2982();
      boolean var3 = false;
      int var5 = Integer.parseInt(var2);
      this.field_536 = var5;
      EntityDonkey var6 = new EntityDonkey((World)this.c.world);
      var6.setEntityId(this.field_536);
      NetHandlerPlayClient var10000 = this.c.getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketUseEntity((Entity)var6, EnumHand.MAIN_HAND)));
      this.method_792((f3Y)(new f7H()));
   }

   // $FF: renamed from: H () boolean
   public boolean method_802() {
      return this.field_535;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7G) net.minecraft.client.Minecraft
   public static Minecraft method_803(f7G var0) {
      return var0.c;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4I) void
   @f0g
   public void method_804(@NotNull f4I var1) {
      if (this.method_761() && var1.method_3243() instanceof AbstractChestHorse && this.field_549) {
         int var2 = var1.method_3243().getEntityId();
         if (this.field_543.contains(var2)) {
            this.field_543.remove(var2);
         }

         if (this.field_543.isEmpty()) {
            Pyro.INSTANCE.sendMessage("All duped donkies are dead!");
            PyroStatic.field_2509.c.method_3033(false);
            this.method_792((f3Y)(new f7L()));
            Vec3d var10001 = this.field_550;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            this.method_836(var10001);
         } else {
            Pyro.INSTANCE.sendMessage("Waiting for " + this.field_543.size() + " more donkies to be killed!");
         }
      }

   }

   // $FF: renamed from: j () boolean
   public boolean method_805() {
      return this.field_549;
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.Vec3d) void
   public void method_806(@Nullable Vec3d var1) {
      this.field_550 = var1;
   }

   // $FF: renamed from: 8 (boolean) void
   public void method_807(boolean var1) {
      this.field_539 = var1;
   }

   // $FF: renamed from: F () boolean
   public boolean method_808() {
      return this.field_539;
   }

   // $FF: renamed from: m () dev.nuker.pyro.fe8
   @Nullable
   public fe8 method_809() {
      return this.field_534;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   public void method_810(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120 && this.field_553) {
         Packet var2 = var1.c();
         if (var2 instanceof CPacketVehicleMove) {
            var1.0();
         } else if (var2 instanceof CPacketPlayer) {
            var1.0();
         }
      }

   }

   // $FF: renamed from: 1 () void
   public void method_811() {
      this.field_541 += -1;
      if (this.field_541 <= 0) {
         Pyro.INSTANCE.sendMessage("Received enough accounts riding! riding the minecart!");
         this.field_533 = true;
      }

   }

   // $FF: renamed from: 6 (int) void
   public void method_812(int var1) {
      this.field_541 = var1;
   }

   // $FF: renamed from: A () dev.nuker.pyro.f7B
   @Nullable
   public f7B method_813() {
      return this.field_527;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   public void method_814(@NotNull f4t var1) {
      fe8 var13;
      if (this.field_542 != null) {
         var13 = this.field_542;
         if (var13 == null) {
            Intrinsics.throwNpe();
         }

         if (var13.method_1980(10000.0D)) {
            this.field_542 = (fe8)null;
         }

      } else if (this.field_548 != null) {
         var13 = this.field_548;
         if (var13 == null) {
            Intrinsics.throwNpe();
         }

         if (var13.method_1980(3000.0D)) {
            this.method_792((f3Y)(new f7K()));
            Pyro.INSTANCE.sendMessage("Sent the ready packet!");
            this.field_548 = (fe8)null;
            this.c.method_3033(false);
         }

      } else {
         if (this.field_545) {
            EntityPlayerSP var10000 = this.c.player;
            Vec3d var10001 = this.field_546;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            double var14 = var10001.x;
            Vec3d var10002 = this.field_546;
            if (var10002 == null) {
               Intrinsics.throwNpe();
            }

            double var15 = var10002.y;
            Vec3d var10003 = this.field_546;
            if (var10003 == null) {
               Intrinsics.throwNpe();
            }

            double var2 = var10000.getDistance(var14, var15, var10003.z);
            if (var2 <= (double)2) {
               this.field_545 = false;
               if (this.field_544 != null) {
                  Pyro.INSTANCE.sendMessage("Accepting callback of baritone");
                  Consumer var11 = this.field_544;
                  if (var11 == null) {
                     Intrinsics.throwNpe();
                  }

                  var11.accept(true);
                  this.field_544 = (Consumer)null;
               }
            }
         }

         if (this.field_533) {
            EntityMinecartEmpty var10 = this.method_780();
            if (var10 != null) {
               NetHandlerPlayClient var12 = this.c.getConnection();
               if (var12 == null) {
                  Intrinsics.throwNpe();
               }

               var12.sendPacket((Packet)(new CPacketUseEntity((Entity)var10, EnumHand.MAIN_HAND)));
               this.field_534 = (fe8)null;
            } else if (this.field_534 == null) {
               this.field_534 = new fe8();
               var13 = this.field_534;
               if (var13 == null) {
                  Intrinsics.throwNpe();
               }

               var13.method_1979();
            } else {
               var13 = this.field_534;
               if (var13 == null) {
                  Intrinsics.throwNpe();
               }

               if (var13.method_1980(1000.0D)) {
                  if (!this.field_535) {
                     this.field_535 = true;
                     Pyro.INSTANCE.sendMessage("No more minecarts found!");
                     if (!this.method_761()) {
                        this.field_533 = false;
                        this.method_792((f3Y)(new f7M(String.valueOf(this.c.player.getEntityId()))));
                        Pyro.INSTANCE.sendMessage("Asking for an entity to ride");
                     } else {
                        this.field_542 = new fe8();
                        var13 = this.field_542;
                        if (var13 == null) {
                           Intrinsics.throwNpe();
                        }

                        var13.method_1979();
                        Pyro.INSTANCE.sendMessage("Delaying for 10 seconds as we went through the track.");
                        this.field_533 = true;
                        this.field_532.clear();
                     }
                  } else {
                     if (!this.method_761() && this.field_538 && !this.field_540) {
                        this.field_540 = true;
                        this.field_548 = new fe8();
                        var13 = this.field_548;
                        if (var13 == null) {
                           Intrinsics.throwNpe();
                        }

                        var13.method_1979();
                     }

                     if (this.method_761()) {
                        if (this.c.world.playerEntities.size() == 1) {
                           List var3 = this.method_746();
                           if (var3 != null) {
                              this.field_543.clear();
                              Iterable var4 = (Iterable)var3;
                              boolean var5 = false;
                              Iterator var6 = var4.iterator();

                              while(var6.hasNext()) {
                                 Object var7 = var6.next();
                                 AbstractChestHorse var8 = (AbstractChestHorse)var7;
                                 boolean var9 = false;
                                 this.field_543.add(var8.getEntityId());
                              }

                              Pyro.INSTANCE.sendMessage("Found " + var3.size() + " duped donkies, dismounting");
                              this.field_549 = true;
                              this.field_530 = true;
                              this.field_533 = false;
                              this.method_792((f3Y)(new f7I()));
                              this.field_531 = (Consumer)(new f7E(this));
                           }
                        } else {
                           Pyro.INSTANCE.sendMessage("Dupe failed! Reloading chunk");
                           this.field_532.clear();
                           this.field_535 = false;
                        }
                     }
                  }
               }
            }
         }

      }
   }

   // $FF: renamed from: 2 (boolean) void
   public void method_815(boolean var1) {
      this.field_535 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe8) void
   public void method_816(@Nullable fe8 var1) {
      this.field_542 = var1;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_817(@NotNull List var1) {
      this.field_528 = var1;
   }

   // $FF: renamed from: t () void
   public void method_818() {
      BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath((Goal)null);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) void
   public void method_819(@NotNull Entity var1) {
      this.method_836(var1.getPositionVector());
   }

   // $FF: renamed from: 7 (boolean) void
   public void method_820(boolean var1) {
      this.field_530 = var1;
   }

   // $FF: renamed from: 6 () void
   public void method_821() {
      String var1 = "We can reconnect now!";
      boolean var2 = false;
      System.out.println(var1);
      if (this.c.player == null) {
         this.field_539 = true;
         this.field_532.clear();
         this.field_533 = true;
      }

   }

   // $FF: renamed from: f () net.minecraft.util.math.BlockPos
   @Nullable
   public BlockPos method_822() {
      return this.field_552;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   public void method_823(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && this.c.currentScreen instanceof GuiDisconnected && this.field_539 && this.field_537.method_1980(35000.0D)) {
         Minecraft var10000 = Minecraft.getMinecraft();
         GuiConnecting var10001 = new GuiConnecting;
         GuiScreen var10003 = this.c.currentScreen;
         if (var10003 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.GuiDisconnectedAccessor");
         }

         var10001.<init>(((GuiDisconnectedAccessor)var10003).getParent(), Minecraft.getMinecraft(), f83.field_462);
         var10000.displayGuiScreen((GuiScreen)var10001);
      }

   }

   // $FF: renamed from: c (io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer) void
   public void method_824(@Nullable Consumer var1) {
      this.field_531 = var1;
   }

   // $FF: renamed from: v () java.lang.Thread
   @Nullable
   public Thread method_825() {
      return this.field_526;
   }

   // $FF: renamed from: w () dev.nuker.pyro.fe8
   @Nullable
   public fe8 method_826() {
      return this.field_548;
   }

   // $FF: renamed from: k () net.minecraft.util.math.Vec3d
   @Nullable
   public Vec3d method_827() {
      return this.field_546;
   }

   // $FF: renamed from: c (java.net.ServerSocket) void
   public void method_828(@Nullable ServerSocket var1) {
      this.field_525 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   public void method_829(@NotNull f4u var1) {
      if (!var1.c() && var1.c() == f41.field_2120 && this.method_761() && this.field_547) {
         this.field_547 = false;
         BlockPos var10000 = this.field_552;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         BlockPos var2 = var10000;
         EnumFacing var3 = few.method_1732(var2, true);
         float[] var4 = few.method_1716().method_1736(var2, var3);
         var1.0();
         var1.method_3139(var4[0]);
         var1.method_3140(var4[1]);
         RayTraceResult var5 = few.method_1716().method_1734(var4[0], var4[1]);
         Ref.FloatRef var6 = new Ref.FloatRef();
         var6.element = 0.0F;
         Ref.FloatRef var7 = new Ref.FloatRef();
         var7.element = 0.0F;
         Ref.FloatRef var8 = new Ref.FloatRef();
         var8.element = 0.0F;
         if (var5 != null) {
            double var10001 = var5.hitVec.x;
            if (var2 == null) {
               Intrinsics.throwNpe();
            }

            var6.element = (float)(var10001 - (double)var2.getX());
            var7.element = (float)(var5.hitVec.y - (double)var2.getY());
            var8.element = (float)(var5.hitVec.z - (double)var2.getZ());
         }

         var1.method_3133((java.util.function.Consumer)(new f7C(this, var2, var3, var6, var7, var8)));
      }

   }

   // $FF: renamed from: b () java.util.List
   @NotNull
   public List method_830() {
      return this.field_528;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f7M, dev.nuker.pyro.f7B) void
   public void method_831(@NotNull f7M var1, @NotNull f7B var2) {
      Pyro.INSTANCE.sendMessage("recieved entityid with " + var1.method_2979());
      AbstractChestHorse var3 = (AbstractChestHorse)null;
      float var4 = 100.0F;
      Iterator var6 = this.c.world.loadedEntityList.iterator();

      while(var6.hasNext()) {
         Entity var5 = (Entity)var6.next();
         if (var5 instanceof AbstractChestHorse && !((AbstractChestHorse)var5).hasChest() && ((AbstractChestHorse)var5).isRiding() && ((AbstractChestHorse)var5).getRidingEntity() instanceof EntityBoat && ((AbstractChestHorse)var5).getPassengers().isEmpty()) {
            float var7 = this.c.player.getDistance(var5);
            if (var7 < var4) {
               var4 = var7;
               var3 = (AbstractChestHorse)var5;
            }
         }
      }

      if (var3 != null) {
         this.method_752((f3Y)(new f7N(String.valueOf(var3.getEntityId()))), var2);
         Pyro.INSTANCE.sendMessage("Found donkey EntityID " + var3.getEntityId() + " for " + var1.method_2979() + " to ride");
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4r) void
   @f0g
   public void method_832(@NotNull f4r var1) {
      this.c.player.setPosition(var1.method_3289().posX, var1.method_3289().posY, var1.method_3289().posZ);
      if (var1.method_3289() instanceof EntityMinecartEmpty) {
         if (!this.field_532.contains(var1.method_3289().getEntityId())) {
            this.field_532.add(var1.method_3289().getEntityId());
         } else {
            Pyro.INSTANCE.sendMessage("WARNING! Ridden a duplicated id in the minecart list!");
         }
      }

   }

   // $FF: renamed from: C () java.util.concurrent.CopyOnWriteArrayList
   @NotNull
   public CopyOnWriteArrayList method_833() {
      return this.field_532;
   }

   // $FF: renamed from: D () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_834() {
      return this.field_537;
   }

   // $FF: renamed from: 4 (boolean) void
   public void method_835(boolean var1) {
      this.field_533 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d) void
   public void method_836(@NotNull Vec3d var1) {
      this.method_776();
      GoalXZ var2 = new GoalXZ(new BetterBlockPos(var1.x, var1.y, var1.z));
      BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath((Goal)var2);
      this.field_546 = var1;
      this.field_545 = true;
   }
}
