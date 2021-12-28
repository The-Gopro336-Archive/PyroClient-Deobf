/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={PlayerControllerMP.class})
public interface PlayerControllerMPAccessor {
    @Accessor(value="isHittingBlock")
    public void Method63(boolean var1);

    @Accessor(value="curBlockDamageMP")
    public void Method64(float var1);

    @Accessor(value="curBlockDamageMP")
    public float Method65();

    @Accessor(value="blockHitDelay")
    public void Method66(int var1);
}

