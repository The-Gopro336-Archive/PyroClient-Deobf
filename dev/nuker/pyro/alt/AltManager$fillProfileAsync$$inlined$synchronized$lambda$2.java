/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.alt;

import com.mojang.authlib.GameProfile;
import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"},
   d2 = {"<anonymous>", "", "it", "Lcom/mojang/authlib/GameProfile;", "kotlin.jvm.PlatformType", "test", "dev/nuker/pyro/alt/AltManager$fillProfileAsync$1$3"}
)
final class AltManager$fillProfileAsync$$inlined$synchronized$lambda$2 implements Predicate {
   // $FF: synthetic field
   final GameProfile $profile$inlined;
   // $FF: synthetic field
   final Consumer $callback$inlined;

   AltManager$fillProfileAsync$$inlined$synchronized$lambda$2(GameProfile var1, Consumer var2) {
      this.$profile$inlined = var1;
      this.$callback$inlined = var2;
   }

   public final boolean test(GameProfile it) {
      Intrinsics.checkExpressionValueIsNotNull(it, "it");
      return Intrinsics.areEqual((Object)it.getId(), (Object)this.$profile$inlined.getId());
   }
}
