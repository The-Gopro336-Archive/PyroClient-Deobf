/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdX extends fdZ {
   // $FF: renamed from: c short
   public short field_1222 = -1;
   // $FF: renamed from: c dev.nuker.pyro.fdW
   public fdW field_1223;
   // $FF: renamed from: c java.util.concurrent.ConcurrentLinkedQueue
   public ConcurrentLinkedQueue field_1224 = new ConcurrentLinkedQueue();
   // $FF: renamed from: c boolean
   public boolean field_1225;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_1226 = new fe8();
   // $FF: renamed from: c dev.nuker.pyro.fdX
   @JvmField
   @NotNull
   public static fdX field_1227 = new fdX();
   // $FF: renamed from: c dev.nuker.pyro.fdV
   public static fdV field_1228 = new fdV((DefaultConstructorMarker)null);

   // $FF: renamed from: c (net.minecraft.item.Item) int
   public int method_1834(@NotNull Item var1) {
      if (fdZ.field_976.player == null) {
         return 0;
      } else {
         int var2 = 0;
         int var3 = 0;

         for(byte var4 = 44; var3 <= var4; ++var3) {
            ItemStack var5 = fdZ.field_976.player.inventory.getStackInSlot(var3);
            if (var5.getItem() == var1) {
               var2 += var5.getCount();
            }
         }

         return var2;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_1835(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketConfirmTransaction && this.field_1225 && this.field_1222 != -1) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketConfirmTransaction");
         }

         SPacketConfirmTransaction var2 = (SPacketConfirmTransaction)var10000;
         int var3 = var2.getWindowId();
         short var4 = var2.getActionNumber();
         boolean var5 = var2.wasAccepted();
         if (var3 == 0 && var4 == this.field_1222 && this.field_1223 != null) {
            fdW var7;
            if (var5) {
               var7 = this.field_1223;
               if (var7 == null) {
                  Intrinsics.throwNpe();
               }

               var7.method_1974(var7.method_1965() + 1);
               var7 = this.field_1223;
               if (var7 == null) {
                  Intrinsics.throwNpe();
               }

               int var8;
               int var9;
               fdW var10002;
               fdW var10003;
               fdW var10005;
               switch(var7.method_1965()) {
               case 1:
                  var10002 = this.field_1223;
                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  var8 = var10002.method_1975();
                  var10003 = this.field_1223;
                  if (var10003 == null) {
                     Intrinsics.throwNpe();
                  }

                  var9 = var10003.method_1971();
                  var10005 = this.field_1223;
                  if (var10005 == null) {
                     Intrinsics.throwNpe();
                  }

                  this.field_1222 = this.method_1842(var8, var9, 0, var10005.method_1963(), (EntityPlayer)fdZ.field_976.player);
                  break;
               case 2:
                  if (!fdZ.field_976.player.inventory.getItemStack().isEmpty()) {
                     var10002 = this.field_1223;
                     if (var10002 == null) {
                        Intrinsics.throwNpe();
                     }

                     var8 = var10002.method_1975();
                     var10003 = this.field_1223;
                     if (var10003 == null) {
                        Intrinsics.throwNpe();
                     }

                     var9 = var10003.method_1968();
                     var10005 = this.field_1223;
                     if (var10005 == null) {
                        Intrinsics.throwNpe();
                     }

                     this.field_1222 = this.method_1842(var8, var9, 0, var10005.method_1963(), (EntityPlayer)fdZ.field_976.player);
                  } else {
                     var7 = this.field_1223;
                     if (var7 == null) {
                        Intrinsics.throwNpe();
                     }

                     var7.method_1966().accept(true);
                     this.field_1225 = false;
                     this.field_1222 = -1;
                     this.field_1223 = (fdW)null;
                     fdZ.field_976.playerController.updateController();
                  }
                  break;
               case 3:
                  var7 = this.field_1223;
                  if (var7 == null) {
                     Intrinsics.throwNpe();
                  }

                  var7.method_1966().accept(true);
                  this.field_1225 = false;
                  this.field_1222 = -1;
                  this.field_1223 = (fdW)null;
                  fdZ.field_976.playerController.updateController();
               }
            } else {
               var7 = this.field_1223;
               if (var7 == null) {
                  Intrinsics.throwNpe();
               }

               var7.method_1966().accept(false);
               this.field_1225 = false;
               this.field_1222 = -1;
               this.field_1223 = (fdW)null;
               fdZ.field_976.playerController.updateController();
            }
         }
      }

   }

   // $FF: renamed from: c (int, int, int, net.minecraft.inventory.ClickType, int, java.util.function.Consumer) void
   public void method_1836(int var1, int var2, int var3, @NotNull ClickType var4, int var5, @NotNull Consumer var6) {
      this.field_1224.add(new fdW(this, var1, var2, var3, var4, var5, var6));
   }

   public fdX() {
      Pyro.getEventManager().method_31(this);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4J) void
   @f0g
   @LauncherEventHide
   public void method_1837(@Nullable f4J var1) {
      while(!this.field_1224.isEmpty()) {
         fdW var2 = (fdW)this.field_1224.poll();
         var2.method_1966().accept(false);
      }

   }

   // $FF: renamed from: 0 (net.minecraft.item.Item) int
   public int method_1838(@NotNull Item var1) {
      if (fdZ.field_976.player == null) {
         return 0;
      } else {
         int var2 = 0;

         for(byte var3 = 44; var2 <= var3; ++var2) {
            ItemStack var4 = fdZ.field_976.player.inventory.getStackInSlot(var2);
            if (var4.getItem() == var1) {
               return var2;
            }
         }

         return -1;
      }
   }

   // $FF: renamed from: 1 (net.minecraft.item.Item) int
   public int method_1839(@NotNull Item var1) {
      if (fdZ.field_976.player == null) {
         return 0;
      } else {
         int var2 = 0;

         for(byte var3 = 8; var2 <= var3; ++var2) {
            ItemStack var4 = fdZ.field_976.player.inventory.getStackInSlot(var2);
            if (var4.getItem() == var1) {
               return var2;
            }
         }

         return -1;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1840(@Nullable f4t var1) {
      if (PyroStatic.field_2492.method_700()) {
         this.field_1223 = (fdW)null;
         this.field_1222 = -1;
         this.field_1225 = false;
      } else if (this.field_1225) {
         if (this.field_1226.method_1980(1000.0D)) {
            this.field_1223 = (fdW)null;
            this.field_1225 = false;
            this.field_1222 = -1;
         }

      } else {
         while(!this.field_1224.isEmpty()) {
            fdW var2 = (fdW)this.field_1224.peek();
            if (var2.method_1964() <= 0) {
               var2 = (fdW)this.field_1224.poll();
               if (var2.method_1963() == ClickType.PICKUP) {
                  this.field_1225 = true;
                  this.field_1226.method_1979();
                  this.field_1222 = this.method_1842(var2.method_1975(), var2.method_1968(), 0, var2.method_1963(), (EntityPlayer)fdZ.field_976.player);
                  this.field_1223 = var2;
               } else {
                  this.field_1223 = (fdW)null;
                  this.field_1225 = false;
                  this.field_1222 = -1;
                  fdZ.field_976.playerController.windowClick(var2.method_1975(), var2.method_1968(), var2.method_1971(), var2.method_1963(), (EntityPlayer)fdZ.field_976.player);
                  var2.method_1966().accept(true);
                  fdZ.field_976.playerController.updateController();
               }
               break;
            }

            var2.method_1969(var2.method_1964() + -1);
         }

      }
   }

   // $FF: renamed from: c (int, int, int, net.minecraft.inventory.ClickType, java.util.function.Consumer) void
   public void method_1841(int var1, int var2, int var3, @NotNull ClickType var4, @NotNull Consumer var5) {
      this.field_1224.add(new fdW(this, var1, var2, var3, var4, 0, var5));
   }

   // $FF: renamed from: c (int, int, int, net.minecraft.inventory.ClickType, net.minecraft.entity.player.EntityPlayer) short
   public short method_1842(int var1, int var2, int var3, @Nullable ClickType var4, @NotNull EntityPlayer var5) {
      short var6 = var5.openContainer.getNextTransactionID(var5.inventory);
      ItemStack var7 = var5.openContainer.slotClick(var2, var3, var4, var5);
      NetHandlerPlayClient var10000 = fdZ.field_976.getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketClickWindow(var1, var2, var3, var4, var7, var6)));
      return var6;
   }
}
