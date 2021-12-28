/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockLiquid.class})
public class BlockLiquidMixin {
    @Inject(method={"canCollideCheck"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method1348(IBlockState blockState, boolean b, CallbackInfoReturnable callbackInfoReturnable) {
        if (((Boolean)PyroStatic.Field6451.Field5236.Method5264()).booleanValue()) {
            callbackInfoReturnable.Method9034();
            callbackInfoReturnable.Method521(true);
        }
    }

    @Inject(method={"getCollisionBoundingBox"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method1349(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, CallbackInfoReturnable callbackInfoReturnable) {
        PyroStatic.Field6436.Method285(pos, callbackInfoReturnable);
    }
}

