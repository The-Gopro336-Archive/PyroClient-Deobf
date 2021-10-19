/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5B extends f5T {
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1069 = "Elytras 0";

   public f5B() {
      super("elytraCount");
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1069;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return 11184810;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1580(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.world != null && fdZ.field_976.player != null) {
         int var2 = 0;
         int var3 = 0;

         for(byte var4 = 43; var3 <= var4; ++var3) {
            if (!fdZ.field_976.player.inventory.getStackInSlot(var3).isEmpty()) {
               ItemStack var5 = fdZ.field_976.player.inventory.getStackInSlot(var3);
               if (var5.getItem() instanceof ItemElytra && ItemElytra.isUsable(var5)) {
                  ++var2;
               }
            }
         }

         this.field_1069 = "Elytras " + ChatFormatting.WHITE + var2;
      }
   }
}
