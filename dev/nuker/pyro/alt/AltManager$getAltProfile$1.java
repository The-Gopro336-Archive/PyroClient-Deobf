/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.alt;

import com.mojang.authlib.GameProfile;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"},
   d2 = {"<anonymous>", "", "it", "Lcom/mojang/authlib/GameProfile;", "accept"}
)
final class AltManager$getAltProfile$1 implements Consumer {
   // $FF: synthetic field
   final Consumer $callback;
   // $FF: synthetic field
   final Alt $alt;

   public final void accept(@NotNull GameProfile it) {
      Intrinsics.checkParameterIsNotNull(it, "it");
      Consumer var10000 = this.$callback;
      if (var10000 != null) {
         var10000.accept(it);
      }

      if (AltManager.INSTANCE.getAlts().contains(this.$alt) && !this.$alt.isCracked() && Intrinsics.areEqual((Object)this.$alt.getUsername(), (Object)it.getName()) ^ true) {
         Alt var2 = this.$alt;
         String var10001 = it.getName();
         Intrinsics.checkExpressionValueIsNotNull(var10001, "it.name");
         var2.setUsername(var10001);
         AltManager.INSTANCE.saveAlts();
      }

   }

   AltManager$getAltProfile$1(Consumer var1, Alt var2) {
      this.$callback = var1;
      this.$alt = var2;
   }
}
