/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.chunk.ChunkRenderWorker
 *  net.minecraft.entity.Entity
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.chunk.ChunkRenderWorker;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={ChunkRenderWorker.class})
public class ChunkRenderWorkerMixin {
    @Redirect(method={"processTask"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/Minecraft;getRenderViewEntity()Lnet/minecraft/entity/Entity;"))
    private Entity Method12690(Minecraft minecraft) {
        return ((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() ? (PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA ? minecraft.player : PyroStatic.Field6417.Field1712) : minecraft.getRenderViewEntity();
    }
}

