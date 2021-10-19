/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f4A;
import dev.nuker.pyro.fb2;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({MovementInputFromOptions.class})
public class MovementInputOptionsMixin {
   @Inject(
      method = {"updatePlayerMoveState"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void updatePlayerMoveStateReturn(CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471) {
         ((MovementInputFromOptions)this).moveForward = 0.0F;
         ((MovementInputFromOptions)this).moveStrafe = 0.0F;
         ((MovementInputFromOptions)this).jump = false;
         ((MovementInputFromOptions)this).sneak = false;
         ((MovementInputFromOptions)this).forwardKeyDown = false;
         ((MovementInputFromOptions)this).backKeyDown = false;
         ((MovementInputFromOptions)this).leftKeyDown = false;
         ((MovementInputFromOptions)this).rightKeyDown = false;
      }

      if (!((MovementInput)this).jump) {
         ((MovementInput)this).jump = (Boolean)PyroStatic.field_2467.c.method_3034() && PyroStatic.field_2467.method_1192();
      }

      if ((Boolean)PyroStatic.field_2523.c.method_3034() && PyroStatic.field_2523.method_295() || (Boolean)PyroStatic.field_2565.c.method_3034() && PyroStatic.field_2565.method_898().method_3330()) {
         ((MovementInputFromOptions)this).jump = false;
         ((MovementInputFromOptions)this).moveForward = 0.0F;
         ((MovementInputFromOptions)this).moveStrafe = 0.0F;
      }

      Pyro.getEventManager().method_32(new f4A());
   }
}
