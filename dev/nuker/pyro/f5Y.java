/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5Y extends f5T {
   // $FF: renamed from: c int
   public int field_1057;
   // $FF: renamed from: c boolean
   public boolean field_1058;
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1059;
   // $FF: renamed from: 0 int
   public int field_1060;

   // $FF: renamed from: 0 (int) void
   public void method_1563(int var1) {
      this.field_1060 = var1;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_1564(@NotNull String var1) {
      this.field_1059 = var1;
   }

   // $FF: renamed from: c (int) void
   public void method_1565(int var1) {
      this.field_1057 = var1;
   }

   // $FF: renamed from: c (boolean) void
   public void method_1566(boolean var1) {
      this.field_1058 = var1;
   }

   // $FF: renamed from: 1 () int
   public int method_1567() {
      return this.field_1057;
   }

   public void meth2() {
      Entity var1 = fdZ.field_976.world.getEntityByID(this.field_1060);
      if (var1 != null) {
         StringCompanionObject var2 = StringCompanionObject.INSTANCE;
         String var3 = "%s [%.1f]";
         Object[] var4 = new Object[]{var1.getName(), fdZ.field_976.player.getDistance(var1)};
         boolean var5 = false;
         String var7 = String.format(var3, Arrays.copyOf(var4, var4.length));
         this.field_1059 = var7;
         float var8 = var1.getDistance((Entity)fdZ.field_976.player);
         float var9 = var8 >= 60.0F ? 120.0F : var8 + var8;
         this.field_1057 = (new feo(var9, 100.0F, 50.0F, 1.0F)).method_2032().getRGB();
      }

   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return this.field_1058 ? 1831126 : this.field_1057;
   }

   public f5Y(@NotNull String var1, boolean var2, @NotNull String var3, int var4) {
      super(var1);
      this.field_1058 = var2;
      this.field_1059 = var3;
      this.field_1060 = var4;
      this.field_1057 = -1;
   }

   // $FF: renamed from: 0 () boolean
   public boolean method_1568() {
      return this.field_1058;
   }

   // $FF: renamed from: c () int
   public int method_1569() {
      return this.field_1060;
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1059;
   }

   // $FF: renamed from: 5 () java.lang.String
   @NotNull
   public String method_1570() {
      return this.field_1059;
   }
}
