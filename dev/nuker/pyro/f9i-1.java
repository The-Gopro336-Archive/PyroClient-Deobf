/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityPlayerSPAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

public class f9i extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_197 = (BooleanSetting)this.register((f0w)(new BooleanSetting("control", "Control", (String)null, true)));
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_198 = (DoubleSetting)this.register((f0w)(new DoubleSetting("jumpStrength", "JumpStrength", (String)null, 1.0D, 0.0D, 1.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_199 = (BooleanSetting)this.register((f0w)(new BooleanSetting("noPigAI", "No Pig AI", (String)null, true)));

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_280(@NotNull f4t var1) {
      if (this.c.player.isRidingHorse() && ((Number)this.field_198.c()).doubleValue() > 0.0D) {
         EntityPlayerSP var10000 = this.c.player;
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityPlayerSPAccessor");
         }

         ((EntityPlayerSPAccessor)var10000).setHorseJumpPower(1.0F);
      }

   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_281() {
      return this.field_198;
   }

   public f9i() {
      super("entitycontrol", "EntityControl", "Allows you to control horses, donkeys and llamas without a saddle");
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_282() {
      return this.field_199;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_283() {
      return this.field_197;
   }
}
