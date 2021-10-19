/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.f0F;
import java.util.function.BiFunction;
import kotlin.Metadata;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"},
   d2 = {"<anonymous>", "", "x", "", "y", "apply"}
)
final class ClickGui$Window$Module$buildContexts$3 implements BiFunction {
   // $FF: synthetic field
   final ClickGui$Window$Module this$0;
   // $FF: renamed from: $i int
   // $FF: synthetic field
   final int field_2463;

   public final boolean apply(double x, double y) {
      if (!this.this$0.isOnTop(x, y)) {
         return false;
      } else {
         return y > (double)0 && y < (double)((f0F)this.this$0.getContexts().get(this.field_2463)).method_3583();
      }
   }

   ClickGui$Window$Module$buildContexts$3(ClickGui$Window$Module var1, int var2) {
      this.this$0 = var1;
      this.field_2463 = var2;
   }
}
