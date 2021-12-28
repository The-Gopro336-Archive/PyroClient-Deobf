/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.mixin.EntityLivingMixin;
import net.minecraft.entity.EntityCreature;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={EntityCreature.class})
public abstract class EntityCreatureMixin
extends EntityLivingMixin {
}

