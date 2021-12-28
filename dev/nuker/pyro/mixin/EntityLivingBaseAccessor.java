/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.datasync.DataParameter
 */
package dev.nuker.pyro.mixin;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.datasync.DataParameter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EntityLivingBase.class})
public interface EntityLivingBaseAccessor {
    @Accessor(value="POTION_EFFECTS")
    public DataParameter Method0();
}

