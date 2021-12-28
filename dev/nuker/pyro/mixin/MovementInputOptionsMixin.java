/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.MovementInputFromOptions
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f4A;
import dev.nuker.pyro.fb2;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MovementInputFromOptions.class})
public class MovementInputOptionsMixin {
    @Inject(method={"updatePlayerMoveState"}, at={@Class0(value="RETURN")}, cancellable=true)
    private void Method1359(CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA) {
            ((MovementInputFromOptions)this).moveForward = 0.0f;
            ((MovementInputFromOptions)this).moveStrafe = 0.0f;
            ((MovementInputFromOptions)this).jump = false;
            ((MovementInputFromOptions)this).sneak = false;
            ((MovementInputFromOptions)this).forwardKeyDown = false;
            ((MovementInputFromOptions)this).backKeyDown = false;
            ((MovementInputFromOptions)this).leftKeyDown = false;
            ((MovementInputFromOptions)this).rightKeyDown = false;
        }
        if (!((MovementInput)this).jump) {
            boolean bl = ((MovementInput)this).jump = (Boolean)PyroStatic.Field6403.Field5236.Method5264() != false && PyroStatic.Field6403.Method2269();
        }
        if (((Boolean)PyroStatic.Field6459.Field5236.Method5264()).booleanValue() && PyroStatic.Field6459.Method2622() || ((Boolean)PyroStatic.Field6501.Field5236.Method5264()).booleanValue() && PyroStatic.Field6501.Method4888().Method8796()) {
            ((MovementInputFromOptions)this).jump = false;
            ((MovementInputFromOptions)this).moveForward = 0.0f;
            ((MovementInputFromOptions)this).moveStrafe = 0.0f;
        }
        Pyro.Method8978().Method7918(new f4A());
    }
}

