/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EntityPlayerSP.class})
public interface EntityPlayerSPAccessor {
    @Accessor(value="prevOnGround")
    public boolean Method9337();

    @Accessor(value="handActive")
    public void Method9338(boolean var1);

    @Accessor(value="horseJumpPower")
    public void Method9339(float var1);
}

