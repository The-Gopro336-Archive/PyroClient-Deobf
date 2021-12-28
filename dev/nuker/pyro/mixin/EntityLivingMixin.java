/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLiving
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.mixin.EntityLivingBaseMixin;
import net.minecraft.entity.EntityLiving;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={EntityLiving.class})
public abstract class EntityLivingMixin
extends EntityLivingBaseMixin {
    @Shadow
    public abstract boolean Method5720();

    @Shadow
    public abstract boolean Method5721();

    @Shadow
    public void Method5722(float speedIn) {
    }
}

