/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5U extends f5T {
   // $FF: renamed from: 1 java.lang.String
   @NotNull
   public String field_1064 = "TPS";

   public f5U() {
      super("tps");
   }

   // $FF: renamed from: 4 () java.lang.String
   @NotNull
   public String method_1559() {
      return this.field_1064;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      return 11184810;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1576(@NotNull f43 var1) {
      if (var1.c() == f41.field_2120 && fdZ.field_976.world != null && fdZ.field_976.player != null) {
         StringBuilder var10001 = (new StringBuilder("TPS ")).append(ChatFormatting.WHITE);
         StringCompanionObject var2 = StringCompanionObject.INSTANCE;
         String var3 = "%.1f";
         Object[] var4 = new Object[]{f04.field_2316.method_3478()};
         StringBuilder var7 = var10001;
         boolean var5 = false;
         String var8 = String.format(var3, Arrays.copyOf(var4, var4.length));
         this.field_1064 = var7.append(var8).toString();
      }
   }
}
