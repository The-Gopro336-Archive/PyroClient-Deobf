/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fbt;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderManager.class})
public class RenderManagerMixin {
    @Inject(method={"renderEntity"}, at={@Class0(value="HEAD")})
    private void Method9856(Entity entityIn, double x, double y, double z, float yaw, float partialTicks, boolean p_188391_10_, CallbackInfo ci) {
        boolean isAutoCrystalTarget;
        boolean bl = isAutoCrystalTarget = (Boolean)PyroStatic.Field6416.Field5236.Method5264() != false && (Boolean)PyroStatic.Field6416.Method8838().Method7979() != false && PyroStatic.Field6416.Method8887() == entityIn;
        if (((Boolean)PyroStatic.Field6465.Field5236.Method5264()).booleanValue() || isAutoCrystalTarget) {
            if (!isAutoCrystalTarget && ((Boolean)PyroStatic.Field6465.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6465.Method270().Method7979() != false ? !(entityIn instanceof EntityLivingBase) && !PyroStatic.Field6465.Method2425(entityIn) : !PyroStatic.Field6465.Method2425(entityIn))) {
                return;
            }
            GL11.glEnable((int)32823);
            GL11.glPolygonOffset((float)1.0f, (float)-2000000.0f);
        }
    }

    @Inject(method={"renderEntity"}, at={@Class0(value="RETURN")})
    private void Method9857(Entity entityIn, double x, double y, double z, float yaw, float partialTicks, boolean p_188391_10_, CallbackInfo ci) {
        boolean isAutoCrystalTarget;
        boolean bl = isAutoCrystalTarget = (Boolean)PyroStatic.Field6416.Field5236.Method5264() != false && (Boolean)PyroStatic.Field6416.Method8838().Method7979() != false && PyroStatic.Field6416.Method8887() == entityIn;
        if (((Boolean)PyroStatic.Field6465.Field5236.Method5264()).booleanValue() || isAutoCrystalTarget) {
            if (!isAutoCrystalTarget && ((Boolean)PyroStatic.Field6465.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6465.Method270().Method7979() != false ? !(entityIn instanceof EntityLivingBase) && !PyroStatic.Field6465.Method2425(entityIn) : !PyroStatic.Field6465.Method2425(entityIn))) {
                return;
            }
            GL11.glPolygonOffset((float)1.0f, (float)1000000.0f);
            GL11.glDisable((int)32823);
        }
    }

    @Inject(method={"renderEntityStatic"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method9858(Entity entityIn, float partialTicks, boolean p_188388_3_, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && entityIn instanceof EntityItem && PyroStatic.Field6443.Method278().Method7979() == fbt.Hide) {
            info.Method9034();
        }
    }
}

