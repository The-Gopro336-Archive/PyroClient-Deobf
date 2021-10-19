/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5w extends f5o {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_1079 = new BooleanSetting("rainbow", "Rainbow", (String)null, true);
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_1080 = new IntegerSetting("distance", "Distance", (String)null, 3, 0, 20, 0, 64, (DefaultConstructorMarker)null);
   // $FF: renamed from: c int
   public int field_1081;
   // $FF: renamed from: c dev.nuker.pyro.feq
   @NotNull
   public feq field_1082;

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1595() {
      return this.field_1079;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.feq
   @NotNull
   public feq method_1596() {
      return this.field_1082;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      this.field_1081 = 0;
      super.method_1528(var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: c (dev.nuker.pyro.feq) void
   public void method_1597(@NotNull feq var1) {
      this.field_1082 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5G) int
   public int method_1598(@NotNull f5G var1) {
      if ((Boolean)this.field_1079.c()) {
         this.field_1082.method_2060();
         this.field_1081 += ((Number)this.field_1080.c()).intValue();
         if (this.field_1081 > 360) {
            this.field_1081 = 0;
         }

         return this.field_1082.method_2059(this.field_1081);
      } else {
         return var1.method_1589();
      }
   }

   public f5w(int var1) {
      super("arrayList", var1);
      this.c((f0w)(new f0t((f0w)this.field_1079, new f0w[]{(f0w)this.field_1080})));
      this.field_1082 = new feq(50, 100.0F, 50.0F, 0.0F, 8, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: c () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_1599() {
      return this.field_1080;
   }

   // $FF: renamed from: 0 () int
   public int method_1600() {
      return this.field_1081;
   }

   // $FF: renamed from: c (int) void
   public void method_1601(int var1) {
      this.field_1081 = var1;
   }
}
