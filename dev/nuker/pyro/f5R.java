/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5R extends f5q {
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_1034 = new fe8();
   // $FF: renamed from: c float
   public float field_1035 = 50.0F;

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      float var6 = (float)(System.currentTimeMillis() - this.field_1034.method_1977()) / 1000.0F % 60.0F;
      if (var6 < (float)2) {
         if (fdZ.field_976.currentScreen instanceof f5j) {
            PyroRenderUtil.meth1("Server has stopped responding for x seconds..", 0.0F, 0.0F, -1);
         }

      } else if (!fdZ.field_976.isSingleplayer()) {
         StringCompanionObject var8 = StringCompanionObject.INSTANCE;
         String var9 = "Server has stopped responding for %.2f seconds..";
         Object[] var10 = new Object[]{var6};
         boolean var11 = false;
         String var7 = String.format(var9, Arrays.copyOf(var10, var10.length));
         this.field_1035 = PyroRenderUtil.method_1439(var7);
         class_59.field_2713.method_4135().drawCenteredString(var7, this.method_1526() / (float)2, 0.0F, -1, true);
      }
   }

   public f5R() {
      super("serverNotResponding", (String)null, 2, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_1537(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120) {
         this.field_1034.method_1979();
      }

   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return PyroRenderUtil.meth4();
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return this.field_1035;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }
}
