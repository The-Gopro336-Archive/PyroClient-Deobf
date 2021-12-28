/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.feg;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class fd7
extends Module {
    public BooleanSetting Field194 = new BooleanSetting("fire", "Fire", "Prevents walking into fire", true);
    public BooleanSetting Field195 = new BooleanSetting("cactus", "Cactus", "Prevents walking into cactus", true);
    public BooleanSetting Field196 = new BooleanSetting("unloaded", "Unloaded", "Prevents walking into unloaded chunks", true);

    public void Method285(BlockPos blockPos, CallbackInfoReturnable callbackInfoReturnable) {
        block8: {
            block6: {
                block7: {
                    block5: {
                        block4: {
                            if (this.Field5233.world == null) break block4;
                            if (((Boolean)this.Field5236.Method5264()).booleanValue()) break block5;
                        }
                        return;
                    }
                    Block block = feg.Method690(blockPos);
                    if (block.equals((Object)Blocks.FIRE) && ((Boolean)this.Field194.Method7979()).booleanValue()) break block6;
                    if (!block.equals((Object)Blocks.CACTUS)) break block7;
                    if (((Boolean)this.Field195.Method7979()).booleanValue()) break block6;
                }
                if (this.Field5233.world.isBlockLoaded(blockPos, false) && blockPos.getY() >= 0 || !((Boolean)this.Field196.Method7979()).booleanValue()) break block8;
            }
            callbackInfoReturnable.Method9034();
            callbackInfoReturnable.Method521(Block.FULL_BLOCK_AABB);
        }
    }

    public fd7() {
        super("avoid", "Avoid", "Avoids fire, cactus and optionally unloaded chunks");
        this.Method7264(this.Field194);
        this.Method7264(this.Field195);
        this.Method7264(this.Field196);
    }
}

