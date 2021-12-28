/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityAgeable
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.mixin.EntityCreatureMixin;
import net.minecraft.entity.EntityAgeable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={EntityAgeable.class})
public abstract class EntityAgeableMixin
extends EntityCreatureMixin {
}

