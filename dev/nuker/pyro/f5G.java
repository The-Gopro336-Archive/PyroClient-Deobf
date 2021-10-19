/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5G extends f5T {
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1071;
   // $FF: renamed from: 2 java.lang.String
   @Nullable
   public String field_1072;
   // $FF: renamed from: c int
   public int field_1073;
   // $FF: renamed from: c dev.nuker.pyro.f5w
   public f5w field_1074;

   // $FF: renamed from: 0 (java.lang.String) void
   public void method_1584(@NotNull String var1) {
      this.field_1071 = var1;
   }

   // $FF: renamed from: 2 () java.lang.String
   @NotNull
   public String method_1585() {
      return this.field_1071;
   }

   // $FF: renamed from: 0 () java.lang.String
   @Nullable
   public String method_1586() {
      return this.field_1072;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_1587(@Nullable String var1) {
      this.field_1072 = var1;
   }

   // $FF: renamed from: c (int) void
   public void method_1588(int var1) {
      this.field_1073 = var1;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return this.field_1074.method_1598(this);
   }

   // $FF: renamed from: 1 () int
   public int method_1589() {
      return this.field_1073;
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1071 + ChatFormatting.GRAY + (this.field_1072 == null ? "" : ' ' + this.field_1072);
   }

   public f5G(@NotNull String var1, @Nullable String var2, int var3, @NotNull f5w var4) {
      super("");
      this.field_1071 = var1;
      this.field_1072 = var2;
      this.field_1073 = var3;
      this.field_1074 = var4;
   }
}
