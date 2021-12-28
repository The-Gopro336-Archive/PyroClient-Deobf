/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Block.class})
public class BlockMixin {
    @Inject(method={"shouldSideBeRendered"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method8165(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side, CallbackInfoReturnable callback) {
        if (((Boolean)PyroStatic.Field6424.Field5236.Method5264()).booleanValue() && PyroStatic.Field6424.Method2622()) {
            PyroStatic.Field6424.Method2608((Block)this, blockState, blockAccess, pos, side, callback);
        }
    }

    @Inject(method={"canRenderInLayer"}, at={@Class0(value="HEAD")}, cancellable=true, remap=false)
    public void Method8166(IBlockState state, BlockRenderLayer layer, CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6424.Field5236.Method5264()).booleanValue() && PyroStatic.Field6424.Method2622()) {
            PyroStatic.Field6424.Method2621((Block)this, layer, cir);
        }
    }

    @Inject(method={"Lnet/minecraft/block/Block;getLightValue(Lnet/minecraft/block/state/IBlockState;)I"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method8167(IBlockState state, CallbackInfoReturnable callback) {
        if (((Boolean)PyroStatic.Field6424.Field5236.Method5264()).booleanValue() && PyroStatic.Field6424.Method2622()) {
            PyroStatic.Field6424.Method2609((Block)this, callback);
        }
    }

    @Inject(method={"addCollisionBoxToList(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/util/math/AxisAlignedBB;)V"}, at={@Class0(value="HEAD")}, cancellable=true)
    private static void Method8168(BlockPos var0, AxisAlignedBB var1, List var2, AxisAlignedBB var3, CallbackInfo var4) {
        AxisAlignedBB var420;
        AxisAlignedBB var5;
        if (((Boolean)PyroStatic.Field6547.Field5236.Method5264()).booleanValue() && var3 != Block.NULL_AABB && (var5 = var3.offset(var0)) != (var420 = PyroStatic.Field6547.Method5262(var0, var5))) {
            var5 = var420;
            var4.Method9034();
            if (var5 != null && var1.intersects(var5)) {
                var2.add(var5);
            }
        }
    }
}

