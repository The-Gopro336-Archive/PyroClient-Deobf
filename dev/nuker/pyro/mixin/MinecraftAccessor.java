/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Session
 *  net.minecraft.util.Timer
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Minecraft.class})
public interface MinecraftAccessor {
    @Accessor(value="timer")
    public Timer Method6086();

    @Accessor(value="rightClickDelayTimer")
    public int Method6087();

    @Accessor(value="rightClickDelayTimer")
    public void Method6088(int var1);

    @Accessor(value="session")
    public void Method6089(Session var1);

    @Accessor(value="renderPartialTicksPaused")
    public float Method6090();

    @Accessor(value="leftClickCounter")
    public void Method6091(int var1);
}

