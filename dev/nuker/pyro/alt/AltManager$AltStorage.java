/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.alt;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"},
   d2 = {"Ldev/nuker/pyro/alt/AltManager$AltStorage;", "", "()V", "alts", "", "Ldev/nuker/pyro/alt/Alt;", "getAlts", "()Ljava/util/List;", "setAlts", "(Ljava/util/List;)V", "pyroclient"}
)
public final class AltManager$AltStorage {
   @NotNull
   private List alts;

   @NotNull
   public final List getAlts() {
      return this.alts;
   }

   public final void setAlts(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.alts = var1;
   }

   public AltManager$AltStorage() {
      boolean var1 = false;
      List var3 = (List)(new ArrayList());
      this.alts = var3;
   }
}
