/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

public class faj {
   // $FF: renamed from: c dev.nuker.pyro.f9h
   @NotNull
   public f9h field_1498;
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_1499;
   // $FF: renamed from: 0 java.lang.String
   @NotNull
   public String field_1500;

   // $FF: renamed from: c (boolean) void
   public void method_2668(boolean var1) {
   }

   public faj(@NotNull f9h var1, @NotNull String var2, @NotNull String var3) {
      this.field_1498 = var1;
      this.field_1499 = var2;
      this.field_1500 = var3;
   }

   // $FF: renamed from: 2 () java.lang.String
   @NotNull
   public String method_2669() {
      return this.field_1500;
   }

   // $FF: renamed from: 0 () net.minecraft.client.Minecraft
   public Minecraft method_2670() {
      byte var1 = 0;
      return Minecraft.getMinecraft();
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.f9h
   @NotNull
   public f9h method_2671() {
      return this.field_1498;
   }

   // $FF: renamed from: c () java.lang.String
   @NotNull
   public String method_2672() {
      return this.field_1499;
   }

   // $FF: renamed from: 1 () java.util.List
   @NotNull
   public List method_2673() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }
}
