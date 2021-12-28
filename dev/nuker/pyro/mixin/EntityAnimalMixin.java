/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.EntityAnimal
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.mixin.EntityAgeableMixin;
import net.minecraft.entity.passive.EntityAnimal;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={EntityAnimal.class})
public abstract class EntityAnimalMixin
extends EntityAgeableMixin {
}

