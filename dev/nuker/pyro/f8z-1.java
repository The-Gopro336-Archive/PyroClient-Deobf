/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.BlockAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Collection;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8z extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_254 = (DoubleSetting)this.register((f0w)(new DoubleSetting("delay", "Delay", (String)null, 1.0D, 0.0D, 5.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_255 = (BooleanSetting)this.register((f0w)(new BooleanSetting("inInventory", "InInventory", (String)null, true)));
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_256 = new fe8();
   // $FF: renamed from: c boolean
   public boolean field_257;

   // $FF: renamed from: c (net.minecraft.item.ItemStack) int
   public int method_367(ItemStack var1) {
      if (this.c.player == null) {
         return 0;
      } else {
         int var2 = 0;
         int var3 = ((Collection)this.c.player.inventoryContainer.getInventory()).size();

         while(true) {
            label241: {
               if (var2 < var3) {
                  if (var2 == 0 || var2 == 5 || var2 == 6 || var2 == 7 || var2 == 8) {
                     break label241;
                  }

                  if (var2 <= 35) {
                     ItemStack var4 = (ItemStack)this.c.player.inventoryContainer.getInventory().get(var2);
                     if (var4.isEmpty() || !Intrinsics.areEqual((Object)var4.getItem(), (Object)var1.getItem()) || !Intrinsics.areEqual((Object)var4.getDisplayName(), (Object)var1.getDisplayName())) {
                        break label241;
                     }

                     if (var4.getItem() instanceof ItemBlock) {
                        Item var10000 = var4.getItem();
                        if (var10000 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                        }

                        Block var7 = ((ItemBlock)var10000).getBlock();
                        if (var7 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.BlockAccessor");
                        }

                        BlockAccessor var5 = (BlockAccessor)var7;
                        var10000 = var1.getItem();
                        if (var10000 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                        }

                        var7 = ((ItemBlock)var10000).getBlock();
                        if (var7 == null) {
                           throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.BlockAccessor");
                        }

                        BlockAccessor var6 = (BlockAccessor)var7;
                        if (Intrinsics.areEqual((Object)var5.getMaterial(), (Object)var6.getMaterial()) ^ true) {
                           break label241;
                        }
                     }

                     if (var4.getItemDamage() == var1.getItemDamage()) {
                        return var2;
                     }
                     break label241;
                  }
               }

               return -1;
            }

            ++var2;
         }
      }
   }

   public f8z() {
      super("refill", "Refill", "Replenishes your hotbar if the stack is compatible from your inventory");
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_368() {
      return this.field_255;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_369() {
      return this.field_256;
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack, int) boolean
   public boolean method_370(ItemStack var1, int var2) {
      int var3 = this.method_367(var1);
      if (var3 != -1) {
         ItemStack var4 = (ItemStack)this.c.player.inventoryContainer.getInventory().get(var3);
         this.c.playerController.windowClick(0, var3, 0, ClickType.QUICK_MOVE, (EntityPlayer)this.c.player);
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_371() {
      return this.field_257;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_372(@Nullable f4t var1) {
      if (this.field_256.method_1980(((Number)this.field_254.c()).doubleValue() * (double)1000)) {
         this.field_256.method_1979();
         if (!this.field_257 && !this.c.player.isHandActive()) {
            if (!(this.c.currentScreen instanceof GuiContainer)) {
               if (!(this.c.currentScreen instanceof GuiInventory) || (Boolean)this.field_255.c()) {
                  int var2 = 0;

                  for(byte var3 = 8; var2 <= var3; ++var2) {
                     ItemStack var4 = this.c.player.inventory.getStackInSlot(var2);
                     if (!var4.isEmpty() && var4.isStackable() && var4.getCount() < var4.getMaxStackSize() && this.method_370(var4, var2 + 36)) {
                        return;
                     }
                  }

               }
            }
         }
      }
   }

   // $FF: renamed from: c (boolean) void
   public void method_373(boolean var1) {
      this.field_257 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_374() {
      return this.field_254;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe8) void
   public void method_375(@NotNull fe8 var1) {
      this.field_256 = var1;
   }
}
