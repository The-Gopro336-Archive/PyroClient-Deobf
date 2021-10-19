/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Mouse;

public class f6U extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_585;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_586;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_587;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_588;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_589;
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_590;
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_591;
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_592;
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_593;
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_594;
   // $FF: renamed from: c dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting field_595;
   // $FF: renamed from: c boolean
   public boolean field_596;
   // $FF: renamed from: 0 boolean
   public boolean field_597;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_598;

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_878() {
      return this.field_591;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_879() {
      return this.field_594;
   }

   public f6U() {
      super("offhand", "Offhand", "Automatically swaps your offhand to a different item if that item is currently not present");
      this.field_585 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f6S.field_1729)));
      this.field_586 = (DoubleSetting)this.register((f0w)(new DoubleSetting("health", "Health", "When you fall below this health value, offhand will disable", 8.0D, 0.0D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_587 = (BooleanSetting)this.register((f0w)(new BooleanSetting("miscActivation", "ForceTotem", "Offhand only activates when something forces it to (ForceEat)", false)));
      this.field_588 = (BooleanSetting)this.register((f0w)(new BooleanSetting("strength", "Strength", "Puts a strength in offhand if you have a sword in main hand and don't have a strength effect active", false)));
      this.field_589 = (BooleanSetting)this.register((f0w)(new BooleanSetting("lethalCrystalCheck", "LethalCrystalCheck", "If a crystal near you will kill you, offhand will disable, so you can fall back to AutoTotem", false)));
      this.field_590 = (DoubleSetting)this.register((f0w)(new DoubleSetting("fallDistance", "FallDistance", (String)null, 20.0D, 0.0D, 100.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_591 = (BooleanSetting)this.register((f0w)(new BooleanSetting("elytraPause", "ElytraPause", (String)null, true)));
      this.field_592 = (BooleanSetting)this.register((f0w)(new BooleanSetting("keepEnabled", "KeepEnabled", (String)null, true)));
      this.field_593 = (BooleanSetting)this.register((f0w)(new BooleanSetting("noSwitchWhileEating", "PauseWhileEating", (String)null, true)));
      this.field_594 = (BooleanSetting)this.register((f0w)(new BooleanSetting("forceEat", "ForceEat", "Force OffhandGap while trying to eat", false)));
      this.field_595 = (BindSetting)this.register((f0w)(new BindSetting("swapKey", "Swap", "Key to swap to crystal/gap", -1)));
      this.field_598 = new fe8();
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_596 = false;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_880() {
      return this.field_585;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4y) void
   @f0g
   @LauncherEventHide
   public void method_881(@NotNull f4y var1) {
      if ((Boolean)this.field_594.c() && var1.method_3115() == EnumHand.OFF_HAND) {
         Item var2 = this.c.player.getHeldItem(EnumHand.OFF_HAND).getItem();
         if (Intrinsics.areEqual((Object)var2, (Object)Items.TOTEM_OF_UNDYING) || Intrinsics.areEqual((Object)var2, (Object)Items.END_CRYSTAL) || var2 == null) {
            this.field_597 = true;
         }
      }

   }

   // $FF: renamed from: 0 () boolean
   public boolean method_882() {
      return this.field_596;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_883() {
      return this.field_589;
   }

   // $FF: renamed from: 4 () boolean
   public boolean method_884() {
      return this.field_597;
   }

   // $FF: renamed from: a () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_885() {
      return this.field_586;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BindSetting
   @NotNull
   public BindSetting method_886() {
      return this.field_595;
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_887() {
      return this.field_588;
   }

   // $FF: renamed from: c (boolean) void
   public void method_888(boolean var1) {
      this.field_597 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g(3)
   @LauncherEventHide
   public void method_889(@NotNull f43 var1) {
      this.5(((f6S)this.field_585.c()).toString());
      if (this.c.player != null) {
         if (this.field_595.method_3330() && this.field_598.method_1980(500.0D)) {
            this.field_585.c((f6S)this.field_585.c() == f6S.field_1728 ? f6S.field_1729 : f6S.field_1728);
            Pyro.INSTANCE.sendMessage("Set the mode to " + (f6S)this.field_585.c());
            this.field_598.method_1979();
         }

         if (!this.field_597 && !(Boolean)this.field_593.c() || !this.c.player.isHandActive()) {
            int var2 = PyroStatic.field_2492.method_701();
            if (!this.field_597) {
               if ((Boolean)this.field_587.c()) {
                  this.field_596 = false;
                  return;
               }

               if ((double)this.c.player.fallDistance >= ((Number)this.field_590.c()).doubleValue() || (Boolean)this.field_591.c() && this.c.player.isElytraFlying()) {
                  this.field_596 = false;
                  return;
               }

               if ((double)(this.c.player.getHealth() + this.c.player.getAbsorptionAmount()) < ((Number)this.field_586.c()).doubleValue() && var2 > 0) {
                  if (this.field_596) {
                     Pyro.INSTANCE.sendMessage("[Offhand]: Disabling due to health requirement");
                  }

                  if (!(Boolean)this.field_592.c()) {
                     this.c.method_3033(false);
                  }

                  this.field_596 = false;
                  return;
               }

               if ((Boolean)this.field_589.c() && var2 > 0) {
                  Iterator var4 = this.c.world.loadedEntityList.iterator();

                  while(var4.hasNext()) {
                     Entity var3 = (Entity)var4.next();
                     if (var3 instanceof EntityEnderCrystal && fdM.method_1883((EntityEnderCrystal)var3, (EntityLivingBase)this.c.player) >= this.c.player.getHealth() + this.c.player.getAbsorptionAmount() && !var3.isDead) {
                        if (this.field_596) {
                           Pyro.INSTANCE.sendMessage("[Offhand]: Disabling due to detection of an end crystal dealing lethal damage to you.");
                        }

                        if (!(Boolean)this.field_592.c()) {
                           this.c.method_3033(false);
                        }

                        this.field_596 = false;
                        return;
                     }
                  }
               }
            } else if (Intrinsics.areEqual((Object)this.c.player.getHeldItem(EnumHand.OFF_HAND).getItem(), (Object)Items.GOLDEN_APPLE) && !Mouse.isButtonDown(1)) {
               this.field_597 = false;
            }

            this.field_596 = true;
            if (!(this.c.currentScreen instanceof GuiContainer) || this.c.currentScreen instanceof GuiInventory) {
               if (!this.method_892(this.c.player.getHeldItem(EnumHand.OFF_HAND))) {
                  if (!this.c.player.isCreative()) {
                     ItemStack var8 = this.c.player.inventory.getItemStack();
                     if (!var8.isEmpty() && this.method_892(var8)) {
                        this.c.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
                        NetHandlerPlayClient var10000 = this.c.getConnection();
                        if (var10000 == null) {
                           Intrinsics.throwNpe();
                        }

                        var10000.sendPacket((Packet)(new CPacketClickWindow(0, 0, 0, ClickType.PICKUP, new ItemStack(Items.TOTEM_OF_UNDYING, 5), (short)420)));
                     } else {
                        boolean var9 = !this.c.player.inventoryContainer.getSlot(45).getStack().isEmpty();
                        int var5 = 9;

                        for(byte var6 = 44; var5 <= var6; ++var5) {
                           ItemStack var7 = this.c.player.inventoryContainer.getSlot(var5).getStack();
                           if (this.method_892(var7)) {
                              this.c.playerController.windowClick(0, var5, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
                              this.c.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
                              if (var9) {
                                 this.c.playerController.windowClick(0, var5, 0, ClickType.PICKUP, (EntityPlayer)this.c.player);
                              }

                              return;
                           }
                        }

                        this.field_597 = false;
                     }
                  }
               }
            }
         }
      }
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_890(boolean var1) {
      this.field_596 = var1;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_891() {
      return this.field_593;
   }

   // $FF: renamed from: c (net.minecraft.item.ItemStack) boolean
   public boolean method_892(ItemStack var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_893() {
      return this.field_592;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_894() {
      return this.field_590;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_895() {
      return this.field_587;
   }
}
