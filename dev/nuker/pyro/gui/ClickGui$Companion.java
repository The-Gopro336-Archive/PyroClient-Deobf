/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.f0H;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"},
   d2 = {"Ldev/nuker/pyro/gui/ClickGui$Companion;", "", "()V", "DSCALE", "", "getDSCALE", "()D", "setDSCALE", "(D)V", "SCALE", "getSCALE", "setSCALE", "settings", "Ldev/nuker/pyro/api/ui/GuiSettings;", "getSettings", "()Ldev/nuker/pyro/api/ui/GuiSettings;", "setSettings", "(Ldev/nuker/pyro/api/ui/GuiSettings;)V", "pyroclient"}
)
public final class ClickGui$Companion {
   public final double getSCALE() {
      return ClickGui.access$getSCALE$cp();
   }

   public final void setSCALE(double var1) {
      ClickGui.access$setSCALE$cp(var1);
   }

   public final double getDSCALE() {
      return ClickGui.access$getDSCALE$cp();
   }

   public final void setDSCALE(double var1) {
      ClickGui.access$setDSCALE$cp(var1);
   }

   @NotNull
   public final f0H getSettings() {
      return ClickGui.access$getSettings$cp();
   }

   public final void setSettings(@NotNull f0H var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      ClickGui.access$setSettings$cp(var1);
   }

   private ClickGui$Companion() {
   }

   // $FF: synthetic method
   public ClickGui$Companion(DefaultConstructorMarker $constructor_marker) {
      this();
   }
}
