/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class f6N implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f6N
   public static f6N field_1692 = new f6N();

   public void accept(Object var1) {
      this.method_2947((BlockPos)var1);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_2947(@Nullable BlockPos var1) {
      fe5.field_1245.method_1915(7);
      fe5 var10000 = fe5.field_1245;
      if (var1 == null) {
         Intrinsics.throwNpe();
      }

      var10000.method_1917(var1, 1073676288, 63);
      fe5.field_1245.method_1912();
   }
}
