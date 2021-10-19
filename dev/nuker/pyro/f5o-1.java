/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5o extends f5q {
   // $FF: renamed from: c dev.nuker.pyro.f5m
   @JvmField
   @NotNull
   public f5m field_1077;

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return Math.max(this.field_1077.method_1609(), 10.0F);
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }

   // $FF: renamed from: c (int, int, int) boolean
   public boolean method_1530(int var1, int var2, int var3) {
      return this.field_1077.method_1607(var1, var2, var3);
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return Math.max(this.field_1077.method_1608(), 10.0F);
   }

   public f5o(@Nullable String var1, int var2) {
      if (var1 == null) {
         Intrinsics.throwNpe();
      }

      super(var1, (String)null, 2, (DefaultConstructorMarker)null);
      this.field_1077 = new f5m(var2);
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_1536() {
      return true;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      this.field_1077.field_1083 = var2;
      int var6 = (int)this.field_1077.method_1609();
      int var7 = (int)this.field_1077.method_1608();
      this.field_1077.method_1616((ScaledResolution)(new f5n(var6, var7, fdZ.field_976)), (int)var4, (int)var5, fdZ.field_976.currentScreen instanceof f5j);
   }
}
