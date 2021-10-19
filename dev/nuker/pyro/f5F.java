/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5F extends f5q {
   // $FF: renamed from: c dev.nuker.pyro.f5E[]
   @NotNull
   public f5E[] field_1050;

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return 100.0F;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5E[]) void
   public void method_1553(@NotNull f5E[] var1) {
      this.field_1050 = var1;
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return 100.0F;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      f5E[] var6 = this.field_1050;
      boolean var7 = false;
      f5E[] var8 = var6;
      int var9 = var6.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         f5E var11 = var8[var10];
         boolean var13 = false;
         var11.method_3256();
      }

   }

   // $FF: renamed from: c () dev.nuker.pyro.f5E[]
   @NotNull
   public f5E[] method_1554() {
      return this.field_1050;
   }

   public f5F() {
      super("keystrokes", (String)null, 2, (DefaultConstructorMarker)null);
      this.field_1050 = new f5E[]{new f5E(fdZ.field_976.gameSettings.keyBindForward, 50.0F, 50.0F, 55.0F, 0.0F), new f5E(fdZ.field_976.gameSettings.keyBindLeft, 50.0F, 50.0F, 0.0F, 55.0F), new f5E(fdZ.field_976.gameSettings.keyBindBack, 50.0F, 50.0F, 55.0F, 55.0F), new f5E(fdZ.field_976.gameSettings.keyBindRight, 50.0F, 50.0F, 110.0F, 55.0F), new f5E(fdZ.field_976.gameSettings.keyBindJump, 160.0F, 50.0F, 0.0F, 110.0F)};
   }
}
