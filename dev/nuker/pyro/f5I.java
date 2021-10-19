/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5I extends f5q {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_1037 = (BooleanSetting)this.c((f0w)(new BooleanSetting("autocrystal", "AutoCrystal", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_1038 = (BooleanSetting)this.c((f0w)(new BooleanSetting("autotrap", "AutoTrap", (String)null, true)));
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_1039 = (BooleanSetting)this.c((f0w)(new BooleanSetting("speed", "Speed", (String)null, true)));
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_1040 = (BooleanSetting)this.c((f0w)(new BooleanSetting("surround", "Surround", (String)null, true)));
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_1041 = (BooleanSetting)this.c((f0w)(new BooleanSetting("auaa", "Aura", (String)null, true)));
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_1042 = (BooleanSetting)this.c((f0w)(new BooleanSetting("offhand", "Offhand", (String)null, true)));
   // $FF: renamed from: c float
   public float field_1043 = 128.0F;
   // $FF: renamed from: 0 float
   public float field_1044;
   // $FF: renamed from: 1 float
   public float field_1045 = 64.0F;

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return this.field_1043;
   }

   // $FF: renamed from: c (float) void
   public void method_1539(float var1) {
      this.field_1043 = var1;
   }

   public f5I() {
      super("pvpinfo", (String)null, 2, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      this.field_1043 = 0.0F;
      this.field_1044 = 0.0F;
      this.method_1542(this.field_1037, "" + ChatFormatting.GRAY + "AC" + ChatFormatting.RESET, (Module)PyroStatic.field_2480);
      this.method_1542(this.field_1038, "" + ChatFormatting.GRAY + "AT" + ChatFormatting.RESET, (Module)PyroStatic.field_2508);
      this.method_1542(this.field_1039, "" + ChatFormatting.GRAY + "S" + ChatFormatting.RESET, (Module)PyroStatic.field_2494);
      this.method_1542(this.field_1040, "" + ChatFormatting.GRAY + "Surr" + ChatFormatting.RESET, (Module)PyroStatic.field_2472);
      this.method_1542(this.field_1041, "" + ChatFormatting.GRAY + "KA" + ChatFormatting.RESET, (Module)PyroStatic.field_2509);
      this.method_1542(this.field_1042, "" + ChatFormatting.GRAY + "Offhand" + ChatFormatting.RESET, (Module)PyroStatic.field_2554);
      this.field_1045 = this.field_1044;
   }

   // $FF: renamed from: 0 (float) void
   public void method_1540(float var1) {
      this.field_1044 = var1;
   }

   public float meth1() {
      return this.field_1045;
   }

   // $FF: renamed from: 2 () float
   public float method_1541() {
      return this.field_1044;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return this.field_1045;
   }

   // $FF: renamed from: c (dev.nuker.pyro.BooleanSetting, java.lang.String, dev.nuker.pyro.Module) void
   public void method_1542(@NotNull BooleanSetting var1, @NotNull String var2, @NotNull Module var3) {
      if ((Boolean)var1.c()) {
         String var4 = (Boolean)var3.field_89.method_3034() ? var2 + " ON" : var2 + " OFF";
         int var5 = (Boolean)var3.field_89.method_3034() ? f0H.field_2338.method_3505() : -1;
         float var6 = PyroRenderUtil.method_1439(var4);
         if (var6 > this.field_1043) {
            this.field_1043 = var6;
         }

         PyroRenderUtil.meth1(var4, 0.0F, this.field_1044, var5);
         this.field_1044 += PyroRenderUtil.meth1();
      }

   }

   // $FF: renamed from: 1 (float) void
   public void method_1543(float var1) {
      this.field_1045 = var1;
   }

   // $FF: renamed from: c () float
   public float method_1544() {
      return this.field_1043;
   }
}
