/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class fdg implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fdh
   public fdh field_1314;

   public fdg(fdh var1) {
      this.field_1314 = var1;
      super();
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_1988(@Nullable BlockPos var1) {
      fe5.field_1245.method_1915(7);
      fe5 var10000 = fe5.field_1245;
      if (var1 == null) {
         Intrinsics.throwNpe();
      }

      var10000.method_1917(var1, ((f00)this.field_1314.method_1234().c()).meth1(), 63);
      fe5.field_1245.method_1912();
   }

   public void accept(Object var1) {
      this.method_1988((BlockPos)var1);
   }
}
