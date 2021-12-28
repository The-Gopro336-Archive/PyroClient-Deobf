/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.EnumSkyBlock
 *  net.minecraft.world.World
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f4H;
import dev.nuker.pyro.f4I;
import dev.nuker.pyro.fbY;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={World.class})
public class WorldMixin {
    @Inject(method={"onEntityAdded"}, at={@Class0(value="HEAD")})
    private void Method806(Entity entityIn, CallbackInfo info) {
        Pyro.Method8978().Method7918(new f4H(entityIn));
    }

    @Inject(method={"onEntityRemoved"}, at={@Class0(value="RETURN")})
    private void Method807(Entity entityIn, CallbackInfo info) {
        Pyro.Method8978().Method7918(new f4I(entityIn));
    }

    @Inject(method={"checkLightFor"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method808(EnumSkyBlock lightType, BlockPos pos, CallbackInfoReturnable callback) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method283().Method7979()).booleanValue()) {
            callback.Method9034();
            callback.Method521(true);
        }
    }

    @Inject(method={"getRainStrength"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method809(float delta, CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6441.Field5236.Method5264()).booleanValue()) {
            cir.Method521(Float.valueOf(PyroStatic.Field6441.Method2672().Method7979() == fbY.Clear ? 0.0f : 1.0f));
        }
    }

    @Inject(method={"getThunderStrength"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method810(float delta, CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6441.Field5236.Method5264()).booleanValue()) {
            cir.Method521(Float.valueOf(PyroStatic.Field6441.Method2672().Method7979() == fbY.Thunder ? 1.0f : 0.0f));
        }
    }

    @Inject(method={"getSkyColor"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method811(Entity entityIn, float partialTicks, CallbackInfoReturnable callback) {
        if (((Boolean)PyroStatic.Field6521.Field5236.Method5264()).booleanValue()) {
            callback.Method521(PyroStatic.Field6521.Method2503());
        }
    }
}

