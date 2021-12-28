/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.entity.player.EntityPlayer
 */
package dev.nuker.pyro.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EntityPlayer.class})
public interface EntityPlayerAccessor {
    @Accessor(value="gameProfile")
    public void Method3038(GameProfile var1);
}

