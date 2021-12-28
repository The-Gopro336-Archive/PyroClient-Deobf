/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  org.lwjgl.opengl.Display
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class8;
import dev.nuker.pyro.fdZ;
import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class Class9
extends TimerTask {
    public Minecraft Field5285 = fdZ.Field313;

    @Override
    public void run() {
        if (this.Field5285.world != null && Display.isCreated() && Display.isVisible()) {
            Class8.Field5278.Method7305();
        }
    }
}

