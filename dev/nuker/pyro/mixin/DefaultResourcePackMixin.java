/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.resources.DefaultResourcePack
 *  net.minecraft.launchwrapper.Launch
 *  net.minecraft.util.ResourceLocation
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={DefaultResourcePack.class})
public class DefaultResourcePackMixin {
    @Inject(method={"resourceExists"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12792(ResourceLocation location, CallbackInfoReturnable cir) {
        if (location.getResourceDomain().equals("pyro")) {
            try {
                if (Launch.classLoader.getClassBytes("net.minecraft.world.World") != null) {
                    cir.Method521(Launch.classLoader.getResourceAsStream(location.getResourcePath()) != null);
                } else {
                    cir.Method521(PyroClientLoadingPlugin.Field7534.containsKey(location.getResourcePath()));
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Inject(method={"getResourceStream"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12793(ResourceLocation location, CallbackInfoReturnable cir) {
        if (location.getResourceDomain().equals("pyro")) {
            try {
                if (Launch.classLoader.getClassBytes("net.minecraft.world.World") != null) {
                    cir.Method521(Launch.classLoader.getResourceAsStream(location.getResourcePath()));
                } else {
                    cir.Method521(PyroClientLoadingPlugin.Field7534.containsKey(location.getResourcePath()) ? new ByteArrayInputStream(PyroClientLoadingPlugin.Field7534.get(location.getResourcePath())) : null);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

