/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8g extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f8e
   @NotNull
   public f8e field_332;
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_333;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_334;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_335;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_336;
   // $FF: renamed from: c net.minecraft.inventory.IInventory
   @Nullable
   public IInventory field_337;

   // $FF: renamed from: c (dev.nuker.pyro.BooleanSetting) void
   public void method_461(@NotNull BooleanSetting var1) {
      this.field_334 = var1;
   }

   // $FF: renamed from: c (net.minecraft.inventory.IInventory) void
   public void method_462(@NotNull IInventory var1) {
      this.field_337 = var1;
   }

   // $FF: renamed from: c (int, boolean) void
   public void method_463(int var1, boolean var2) {
      IInventory var10000 = this.field_337;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      int var3 = var10000.getSizeInventory();

      for(int var4 = this.c.player.openContainer.inventorySlots.size(); var3 < var4; ++var3) {
         ItemStack var5 = ((Slot)this.c.player.openContainer.inventorySlots.get(var3)).getStack();
         if (!var5.isEmpty() && (!var2 || this.method_477(var5))) {
            PlayerControllerMP var6 = this.c.playerController;
            if (var6 == null) {
               Intrinsics.throwNpe();
            }

            var6.windowClick(this.c.player.openContainer.windowId, var3, 0, ClickType.QUICK_MOVE, (EntityPlayer)this.c.player);
            this.field_336.method_1979();
            return;
         }
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_464() {
      return this.field_336;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_465() {
      return this.field_334;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_466() {
      return this.field_333;
   }

   // $FF: renamed from: 0 (net.minecraft.inventory.IInventory) void
   public void method_467(@Nullable IInventory var1) {
      this.field_337 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_468(@NotNull f4t var1) {
      this.5(((f8f)this.field_333.c()).toString());
      if (this.c.currentScreen != null && this.c.currentScreen instanceof GuiContainer && this.field_337 != null && this.c.player.openContainer != null && this.c.player.openContainer.windowId != 0) {
         if (!this.field_336.method_1980(((Number)this.field_335.c()).doubleValue() * (double)100)) {
            return;
         }

         int var2 = 0;
         IInventory var10000 = this.field_337;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         int var3 = var10000.getSizeInventory();
         if (var2 <= var3) {
            while(true) {
               var10000 = this.field_337;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               ItemStack var4 = var10000.getStackInSlot(var2);
               if (var4.isEmpty()) {
                  if ((f8f)this.field_333.c() == f8f.field_1898) {
                     this.method_463(var2, true);
                     return;
                  }
               } else if ((f8f)this.field_333.c() != f8f.field_1898 && this.method_477(var4)) {
                  if ((f8f)this.field_333.c() == f8f.field_1899) {
                     this.method_476(var2);
                  } else if ((f8f)this.field_333.c() == f8f.field_1900) {
                     PlayerControllerMP var5 = this.c.playerController;
                     if (var5 == null) {
                        Intrinsics.throwNpe();
                     }

                     var5.windowClick(this.c.player.openContainer.windowId, var2, 999, ClickType.THROW, (EntityPlayer)this.c.player);
                  }

                  this.field_336.method_1979();
                  return;
               }

               if (var2 == var3) {
                  break;
               }

               ++var2;
            }
         }
      }

   }

   // $FF: renamed from: c (net.minecraft.item.Item) boolean
   public boolean method_469(@NotNull Item var1) {
      boolean var2;
      if ((Boolean)this.c.method_3034()) {
         f8e var10000 = this.field_332;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         if (var10000.method_3048().contains(String.valueOf(Item.REGISTRY.getNameForObject(var1)))) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f8e) void
   public void method_470(@NotNull f8e var1) {
      this.field_332 = var1;
   }

   public f8g() {
      super("cheststealer", "ChestStealer", "Takes items from containers");
      this.field_333 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f8f.field_1899)));
      this.field_334 = (BooleanSetting)this.register((f0w)(new BooleanSetting("whitelist", "Whitelist", "Only take from the cheststealer list", false)));
      this.field_335 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delay", "Delay", (String)null, 1.0D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_336 = new fe8();
      this.method_479();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0o) void
   public void method_471(@NotNull f0o var1) {
      this.field_333 = var1;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f8e
   @NotNull
   public f8e method_472() {
      f8e var10000 = this.field_332;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("storage");
      }

      return var10000;
   }

   // $FF: renamed from: c (int, kotlin.jvm.functions.Function1) void
   public void method_473(int var1, @NotNull Function1 var2) {
      IInventory var10000 = this.field_337;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      int var3 = var10000.getSizeInventory();

      for(int var4 = this.c.player.openContainer.inventorySlots.size(); var3 < var4; ++var3) {
         ItemStack var5 = ((Slot)this.c.player.openContainer.inventorySlots.get(var3)).getStack();
         if (!var5.isEmpty() && (Boolean)var2.invoke(var5)) {
            PlayerControllerMP var6 = this.c.playerController;
            if (var6 == null) {
               Intrinsics.throwNpe();
            }

            var6.windowClick(this.c.player.openContainer.windowId, var3, 0, ClickType.QUICK_MOVE, (EntityPlayer)this.c.player);
            this.field_336.method_1979();
            return;
         }
      }

   }

   // $FF: renamed from: 4 () void
   public void method_474() {
      try {
         FileWriter var1 = new FileWriter("pyro/cheststealer_items.json");
         Gson var10000 = Pyro.GSON;
         f8e var10001 = this.field_332;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         var10000.toJson(var10001, (Appendable)var1);
         var1.close();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   // $FF: renamed from: 3 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_475() {
      return this.field_335;
   }

   // $FF: renamed from: 3 (int) void
   public void method_476(int var1) {
      if (this.field_336.method_1980(((Number)this.field_335.c()).doubleValue() * (double)100)) {
         PlayerControllerMP var10000 = this.c.playerController;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.windowClick(this.c.player.openContainer.windowId, var1, 0, ClickType.QUICK_MOVE, (EntityPlayer)this.c.player);
         this.field_336.method_1979();
      }

   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_477(@NotNull ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      } else {
         return (Boolean)this.field_334.c() ? this.method_469(var1.getItem()) : true;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.DoubleSetting) void
   public void method_478(@NotNull DoubleSetting var1) {
      this.field_335 = var1;
   }

   // $FF: renamed from: 1 () void
   public void method_479() {
      if ((new File("pyro/cheststealer_items.json")).exists()) {
         try {
            FileReader var1 = new FileReader("pyro/cheststealer_items.json");
            this.field_332 = (f8e)Pyro.GSON.fromJson((Reader)var1, f8e.class);
            var1.close();
         } catch (IOException var13) {
            var13.printStackTrace();
         }
      } else {
         this.field_332 = new f8e();
         f8e var10000 = this.field_332;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storage");
         }

         Iterable var14 = (Iterable)CollectionsKt.listOf(new Item[]{Items.END_CRYSTAL, Items.GOLDEN_APPLE, Items.EXPERIENCE_BOTTLE, (Item)Items.POTIONITEM});
         f8e var10 = var10000;
         boolean var2 = false;
         Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var14, 10)));
         boolean var5 = false;
         Iterator var6 = var14.iterator();

         while(var6.hasNext()) {
            Object var7 = var6.next();
            Item var8 = (Item)var7;
            boolean var9 = false;
            String var12 = String.valueOf(Item.REGISTRY.getNameForObject(var8));
            var4.add(var12);
         }

         List var11 = (List)var4;
         var10.method_3047(CollectionsKt.toMutableList((Collection)var11));
      }

   }

   // $FF: renamed from: 6 () net.minecraft.inventory.IInventory
   @Nullable
   public IInventory method_480() {
      return this.field_337;
   }
}
