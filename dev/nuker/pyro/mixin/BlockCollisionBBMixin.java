/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockCactus
 *  net.minecraft.block.BlockFire
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Block.class, BlockAir.class, BlockFire.class, BlockCactus.class})
public class BlockCollisionBBMixin {
    @Inject(method={"getCollisionBoundingBox"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method9282(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, CallbackInfoReturnable callbackInfoReturnable) {
        PyroStatic.Field6439.Method285(pos, callbackInfoReturnable);
    }
}

