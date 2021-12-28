/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.util.SoundEvent
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import java.util.List;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.SoundEvent;

public class f8q
extends Module {
    public List<SoundEvent> Field3602 = Arrays.asList(new SoundEvent[]{SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, SoundEvents.ITEM_ARMOR_EQUIP_IRON, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER});

    public f8q() {
        super("nosoundlag", "NoSoundLag", null);
    }

    @f0g
    @LauncherEventHide
    public void Method244(f4e f4e2) {
        SPacketSoundEffect sPacketSoundEffect;
        if (f4e2.Method5619() == f41.Pre && f4e2.Method5784() instanceof SPacketSoundEffect && this.Field3602.contains((Object)(sPacketSoundEffect = (SPacketSoundEffect)f4e2.Method5784()).getSound())) {
            f4e2.Method7948();
        }
    }
}

