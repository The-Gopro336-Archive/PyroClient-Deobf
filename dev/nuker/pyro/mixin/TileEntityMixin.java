/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.tileentity.TileEntity
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={TileEntity.class})
public class TileEntityMixin {
    @Inject(method={"getMaxRenderDistanceSquared"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method653(CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6434.Field5236.Method5264()).booleanValue() && PyroStatic.Field6434.Method2721((TileEntity)this) && ((Boolean)PyroStatic.Field6434.Method280().Method7979()).booleanValue()) {
            cir.Method521(65536.0);
        }
    }
}

