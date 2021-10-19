/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHandSide;
import org.jetbrains.annotations.NotNull;

public class fbm extends Module {
   // $FF: renamed from: c double
   public double field_917;
   // $FF: renamed from: 0 double
   public double field_918;
   // $FF: renamed from: 1 double
   public double field_919;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_920;
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_921;
   // $FF: renamed from: 1 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_922;
   // $FF: renamed from: 2 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_923;
   // $FF: renamed from: 3 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_924;
   // $FF: renamed from: 4 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_925;
   // $FF: renamed from: 5 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_926;
   // $FF: renamed from: 6 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_927;
   // $FF: renamed from: 7 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_928;
   // $FF: renamed from: 8 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_929;
   // $FF: renamed from: 9 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_930;
   // $FF: renamed from: a dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_931;
   // $FF: renamed from: b dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_932;
   // $FF: renamed from: d dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_933;
   // $FF: renamed from: e dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_934;
   // $FF: renamed from: f dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_935;
   // $FF: renamed from: g dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_936;
   // $FF: renamed from: h dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_937;

   // $FF: renamed from: e () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1348() {
      return this.field_921;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1349() {
      return this.field_931;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1350() {
      return this.field_926;
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1351() {
      return this.field_935;
   }

   // $FF: renamed from: a () double
   public double method_1352() {
      return this.field_919;
   }

   // $FF: renamed from: k () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1353() {
      return this.field_932;
   }

   // $FF: renamed from: f () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1354() {
      return this.field_936;
   }

   // $FF: renamed from: j () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1355() {
      return this.field_928;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1356() {
      return this.field_924;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1357() {
      return this.field_929;
   }

   // $FF: renamed from: i () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1358() {
      return this.field_923;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1359() {
      return this.field_922;
   }

   // $FF: renamed from: 8 () double
   public double method_1360() {
      return this.field_918;
   }

   // $FF: renamed from: 3 () double
   public double method_1361() {
      return this.field_917;
   }

   public fbm() {
      this.field_917 = 3.0D;
      this.field_918 = 3.0D;
      this.field_919 = 360.0D;
      super("itemViewModel", "ItemViewModel", "Changes the view model of hand items");
      this.field_917 = 3.0D;
      this.field_918 = 3.0D;
      this.field_919 = 360.0D;
      this.field_920 = new DoubleSetting("x", "X", (String)null, 0.0D, -this.field_917, this.field_917, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_921 = new DoubleSetting("y", "Y", (String)null, 0.0D, -this.field_917, this.field_917, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_922 = new DoubleSetting("z", "Z", (String)null, 0.0D, -this.field_917, this.field_917, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_923 = new DoubleSetting("x", "X", (String)null, 1.0D, 0.0D, this.field_918, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_924 = new DoubleSetting("y", "Y", (String)null, 1.0D, 0.0D, this.field_918, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_925 = new DoubleSetting("z", "Z", (String)null, 1.0D, 0.0D, this.field_918, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_926 = new DoubleSetting("x", "X", (String)null, 0.0D, 0.0D, this.field_919, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_927 = new DoubleSetting("y", "Y", (String)null, 0.0D, 0.0D, this.field_919, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_928 = new DoubleSetting("z", "Z", (String)null, 0.0D, 0.0D, this.field_919, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_929 = new DoubleSetting("x", "X", (String)null, 0.0D, -this.field_917, this.field_917, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_930 = new DoubleSetting("y", "Y", (String)null, 0.0D, -this.field_917, this.field_917, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_931 = new DoubleSetting("z", "Z", (String)null, 0.0D, -this.field_917, this.field_917, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_932 = new DoubleSetting("x", "X", (String)null, 1.0D, 0.0D, this.field_918, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_933 = new DoubleSetting("y", "Y", (String)null, 1.0D, 0.0D, this.field_918, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_934 = new DoubleSetting("z", "Z", (String)null, 1.0D, 0.0D, this.field_918, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_935 = new DoubleSetting("x", "X", (String)null, 0.0D, 0.0D, this.field_919, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_936 = new DoubleSetting("y", "Y", (String)null, 0.0D, 0.0D, this.field_919, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_937 = new DoubleSetting("z", "Z", (String)null, 0.0D, 0.0D, this.field_919, 0.0D, 64, (DefaultConstructorMarker)null);
      this.register((f0w)(new f0t((f0w)(new f0n("mainhand", "Mainhand", (String)null)), new f0w[]{(f0w)(new f0t((f0w)(new f0n("translate", "Translation", (String)null)), new f0w[]{(f0w)this.field_920, (f0w)this.field_921, (f0w)this.field_922})), (f0w)(new f0t((f0w)(new f0n("scale", "Scale", (String)null)), new f0w[]{(f0w)this.field_923, (f0w)this.field_924, (f0w)this.field_925})), (f0w)(new f0t((f0w)(new f0n("rotation", "Rotation", (String)null)), new f0w[]{(f0w)this.field_926, (f0w)this.field_927, (f0w)this.field_928}))})));
      this.register((f0w)(new f0t((f0w)(new f0n("offhand", "Offhand", (String)null)), new f0w[]{(f0w)(new f0t((f0w)(new f0n("translate", "Translation", (String)null)), new f0w[]{(f0w)this.field_929, (f0w)this.field_930, (f0w)this.field_931})), (f0w)(new f0t((f0w)(new f0n("scale", "Scale", (String)null)), new f0w[]{(f0w)this.field_932, (f0w)this.field_933, (f0w)this.field_934})), (f0w)(new f0t((f0w)(new f0n("rotation", "Rotation", (String)null)), new f0w[]{(f0w)this.field_935, (f0w)this.field_936, (f0w)this.field_937}))})));
   }

   // $FF: renamed from: d () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1362() {
      return this.field_927;
   }

   // $FF: renamed from: b () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1363() {
      return this.field_934;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1364() {
      return this.field_925;
   }

   // $FF: renamed from: h () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1365() {
      return this.field_933;
   }

   // $FF: renamed from: g () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1366() {
      return this.field_930;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1367() {
      return this.field_937;
   }

   // $FF: renamed from: c (net.minecraft.util.EnumHandSide) void
   public void method_1368(@NotNull EnumHandSide var1) {
      if (var1 == EnumHandSide.RIGHT) {
         GlStateManager.translate(((Number)this.field_920.c()).doubleValue(), ((Number)this.field_921.c()).doubleValue(), ((Number)this.field_922.c()).doubleValue());
         GlStateManager.scale(((Number)this.field_923.c()).doubleValue(), ((Number)this.field_923.c()).doubleValue(), ((Number)this.field_925.c()).doubleValue());
         GlStateManager.rotate((float)((Number)this.field_926.c()).doubleValue(), 1.0F, 0.0F, 0.0F);
         GlStateManager.rotate((float)((Number)this.field_927.c()).doubleValue(), 0.0F, 1.0F, 0.0F);
         GlStateManager.rotate((float)((Number)this.field_928.c()).doubleValue(), 0.0F, 0.0F, 1.0F);
      } else {
         GlStateManager.translate(((Number)this.field_929.c()).doubleValue(), ((Number)this.field_930.c()).doubleValue(), ((Number)this.field_931.c()).doubleValue());
         GlStateManager.scale(((Number)this.field_932.c()).doubleValue(), ((Number)this.field_932.c()).doubleValue(), ((Number)this.field_934.c()).doubleValue());
         GlStateManager.rotate((float)((Number)this.field_935.c()).doubleValue(), 1.0F, 0.0F, 0.0F);
         GlStateManager.rotate((float)((Number)this.field_936.c()).doubleValue(), 0.0F, 1.0F, 0.0F);
         GlStateManager.rotate((float)((Number)this.field_937.c()).doubleValue(), 0.0F, 0.0F, 1.0F);
      }

   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1369() {
      return this.field_920;
   }
}
