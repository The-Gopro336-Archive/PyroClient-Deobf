/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import baritone.api.BaritoneAPI;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.network.play.server.SPacketPlayerListItem.Action;
import net.minecraft.network.play.server.SPacketPlayerListItem.AddPlayerData;
import net.minecraft.server.integrated.IntegratedServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

// $FF: renamed from: dev.nuker.pyro.f6
public class class_4 extends fdZ {
   // $FF: renamed from: c boolean
   public boolean field_991 = true;
   // $FF: renamed from: c dev.nuker.pyro.f4O
   @Nullable
   public f4O field_992;
   // $FF: renamed from: c dev.nuker.pyro.f6
   @JvmField
   @NotNull
   public static class_4 field_993 = new class_4();
   // $FF: renamed from: c dev.nuker.pyro.f5
   public static class_18 field_994 = new class_18((DefaultConstructorMarker)null);

   // $FF: renamed from: c (dev.nuker.pyro.f46) void
   @f0g
   @LauncherEventHide
   public void method_1459(@NotNull f46 var1) {
      if (var1.method_3195()) {
         class_37.field_2633.method_3977(Mouse.getEventButton());
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f4O
   @Nullable
   public f4O method_1460() {
      return this.field_992;
   }

   // $FF: renamed from: c () void
   public void method_1461() {
      Pyro.getEventManager().method_31(this);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f45) void
   @f0g
   @LauncherEventHide
   public void method_1462(@NotNull f45 var1) {
      if (var1.method_3193() && fdZ.field_976.currentScreen == null) {
         int var2 = Keyboard.getEventKey();
         if (var2 == Pyro.KEY.getKeyCode()) {
            if (this.field_992 == null) {
               this.field_992 = new f4O();
            }

            fdZ.field_976.displayGuiScreen((GuiScreen)this.field_992);
         } else {
            class_3.field_990.method_3406().method_1450(var2);
            class_37.field_2633.method_3982(var2);
         }

         if (var2 == fdZ.field_976.gameSettings.keyBindSneak.getKeyCode() && PyroStatic.field_2489.method_537() && (Boolean)PyroStatic.field_2489.method_527().c() && BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing() && !(Boolean)PyroStatic.field_2481.c.method_3034()) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_1463(@NotNull f4e var1) {
      if (var1.c() != f41.field_2120) {
         if (var1.c() instanceof SPacketDisconnect) {
            this.field_991 = true;
         }
      } else {
         if (var1.c() instanceof SPacketPlayerListItem) {
            Packet var10000 = var1.c();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketPlayerListItem");
            }

            SPacketPlayerListItem var2 = (SPacketPlayerListItem)var10000;

            try {
               Iterable var3 = (Iterable)var2.getEntries();
               boolean var4 = false;
               Iterator var5 = var3.iterator();

               while(var5.hasNext()) {
                  Object var6 = var5.next();
                  AddPlayerData var7 = (AddPlayerData)var6;
                  boolean var8 = false;
                  if (var7 != null && var7.getProfile() != null && var7.getProfile().getName() != null) {
                     if (var2.getAction() == Action.REMOVE_PLAYER) {
                        NetHandlerPlayClient var20 = fdZ.field_976.getConnection();
                        if (var20 == null) {
                           Intrinsics.throwNpe();
                        }

                        Iterator var9 = var20.getPlayerInfoMap().iterator();

                        while(var9.hasNext()) {
                           NetworkPlayerInfo var10 = (NetworkPlayerInfo)var9.next();
                           if (Intrinsics.areEqual((Object)var10.getGameProfile().getId(), (Object)var7.getProfile().getId())) {
                              Pyro.getEventManager().method_32(new f4d(var7.getProfile().getName()));
                              break;
                           }
                        }
                     } else if (var2.getAction() == Action.ADD_PLAYER) {
                        Pyro.getEventManager().method_32(new f4b(var7.getProfile().getName()));
                     }
                  }
               }
            } catch (Exception var11) {
               var11.printStackTrace();
            }
         }

         if (fdZ.field_976.player != null && this.field_991) {
            PyroStatic.field_2489.method_534();
            PyroStatic.field_2481.c.method_3033(false);
            PyroStatic.field_2513.c.method_3033(false);
            fe4.field_1243.method_1895();
            f1R.field_2437.method_3706();
            ServerData var10001;
            if (fdZ.field_976.getCurrentServerData() != null) {
               StringBuilder var21 = (new StringBuilder()).append("server-");
               var10001 = Minecraft.getMinecraft().getCurrentServerData();
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               String var12 = var21.append(StringsKt.substringBeforeLast$default(var10001.serverIP, ":", (String)null, 2, (Object)null)).toString();
               Iterable var14 = (Iterable)f67.field_2201.method_3278();
               boolean var15 = false;
               Iterator var16 = var14.iterator();

               Object var22;
               while(true) {
                  if (var16.hasNext()) {
                     Object var17 = var16.next();
                     f66 var18 = (f66)var17;
                     boolean var19 = false;
                     if (!Intrinsics.areEqual((Object)var18.method_3273(), (Object)var12)) {
                        continue;
                     }

                     var22 = var17;
                     break;
                  }

                  var22 = null;
                  break;
               }

               f66 var13 = (f66)var22;
               if (var13 != null) {
                  f67.field_2201.method_3276(var13);
                  class_37.field_2633.method_3983();
               }
            }

            WaypointManager var25 = WaypointManager.INSTANCE;
            String var24;
            if (fdZ.field_976.getCurrentServerData() == null) {
               StringBuilder var23 = (new StringBuilder()).append("singleplayer/");
               IntegratedServer var10002 = Minecraft.getMinecraft().getIntegratedServer();
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var24 = var23.append(var10002.getFolderName()).toString();
            } else {
               var10001 = Minecraft.getMinecraft().getCurrentServerData();
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var24 = StringsKt.replace$default(var10001.serverIP, ":", "", false, 4, (Object)null);
            }

            var25.load(var24);
            this.field_991 = false;
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4O) void
   public void method_1464(@Nullable f4O var1) {
      this.field_992 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1465(@NotNull f43 var1) {
      if (fdZ.field_976.getCurrentServerData() == null && fdZ.field_976.getIntegratedServer() == null) {
         this.field_991 = true;
      }

      f0b.field_2415.method_3670();
      if (var1.c() == f41.field_2120) {
         f03.field_2312.method_3476();
      }

   }
}
