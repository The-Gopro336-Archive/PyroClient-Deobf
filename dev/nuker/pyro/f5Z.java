/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5Z extends f5T {
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1055 = "";
   // $FF: renamed from: c int
   public int field_1056 = 11184810;

   // $FF: renamed from: c () int
   public int method_1560() {
      return this.field_1056;
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1055;
   }

   // $FF: renamed from: c (int) void
   public void method_1561(int var1) {
      this.field_1056 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1562(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.player != null) {
         if (fdZ.field_976.player.inventory.getCurrentItem().isItemStackDamageable()) {
            int var2 = fdZ.field_976.player.inventory.getCurrentItem().getMaxDamage();
            int var3 = fdZ.field_976.player.inventory.getCurrentItem().getItemDamage();
            StringCompanionObject var4 = StringCompanionObject.INSTANCE;
            String var5 = "§7Durability §r%s";
            Object[] var6 = new Object[]{var2 - var3};
            boolean var7 = false;
            String var9 = String.format(var5, Arrays.copyOf(var6, var6.length));
            this.field_1055 = var9;
            this.field_1056 = (new feo((float)(var2 - var3) / (float)var2 * 120.0F, 100.0F, 50.0F, 1.0F)).method_2032().getRGB();
         } else {
            this.field_1055 = "§7Durability §rInf";
         }
      }

   }

   public f5Z() {
      super("ping");
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return this.field_1056;
   }
}
