/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class f76 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_584 = (DoubleSetting)this.register((f0w)(new DoubleSetting("offset", "Offset", (String)null, 2.0D, -20.0D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null)));

   // $FF: renamed from: c (dev.nuker.pyro.f76, net.minecraft.client.Minecraft) void
   public static void method_874(f76 var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_875() {
      return this.field_584;
   }

   public f76() {
      super("burrow", "Burrow", "Attempt to place a block and rubberband you into it");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_876(@NotNull f4u var1) {
      if (!feg.method_1790(new BlockPos(this.c.player.getPositionVector()))) {
         Pyro.INSTANCE.sendMessage("Burrowed into a block... disabling");
         this.c.method_3033(false);
      } else if (!this.c.player.onGround) {
         boolean var2 = true;
         Item var10000;
         if (!this.c.player.getHeldItemMainhand().isEmpty() && this.c.player.getHeldItemMainhand().getItem() instanceof ItemBlock) {
            var10000 = this.c.player.getHeldItemMainhand().getItem();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
            }

            ItemBlock var3 = (ItemBlock)var10000;
            if (Intrinsics.areEqual((Object)var3.getBlock(), (Object)Blocks.OBSIDIAN)) {
               var2 = false;
            }
         }

         Ref.IntRef var7 = new Ref.IntRef();
         var7.element = -1;
         if (var2) {
            int var4 = 0;

            for(byte var5 = 8; var4 <= var5; ++var4) {
               if (this.c.player.inventory.getStackInSlot(var4).getItem() instanceof ItemBlock) {
                  var10000 = this.c.player.inventory.getStackInSlot(var4).getItem();
                  if (var10000 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                  }

                  ItemBlock var6 = (ItemBlock)var10000;
                  if (Intrinsics.areEqual((Object)var6.getBlock(), (Object)Blocks.OBSIDIAN)) {
                     var7.element = var4;
                     break;
                  }
               }
            }
         }

         if (var7.element != -1 || !var2) {
            var1.method_3140(90.0F);
            var1.0();
            var1.method_3133((Consumer)(new f75(this, var7)));
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f76) net.minecraft.client.Minecraft
   public static Minecraft method_877(f76 var0) {
      return var0.c;
   }
}
