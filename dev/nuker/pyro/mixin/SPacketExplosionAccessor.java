/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketExplosion
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.server.SPacketExplosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketExplosion.class})
public interface SPacketExplosionAccessor {
    @Accessor(value="motionX")
    public float Method2004();

    @Accessor(value="motionX")
    public void Method2005(float var1);

    @Accessor(value="motionY")
    public float Method2006();

    @Accessor(value="motionY")
    public void Method2007(float var1);

    @Accessor(value="motionZ")
    public float Method2008();

    @Accessor(value="motionZ")
    public void Method2009(float var1);
}

