/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.shader.ShaderGroup
 */
package dev.nuker.pyro.mixin;

import java.util.List;
import net.minecraft.client.shader.ShaderGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ShaderGroup.class})
public interface ShaderGroupAccessor {
    @Accessor(value="listShaders")
    public List Method6772();
}

