/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.resources.FallbackResourceManager
 *  net.minecraft.client.resources.SimpleReloadableResourceManager
 *  net.minecraft.util.ResourceLocation
 */
package dev.nuker.pyro.mixin;

import java.util.Map;
import net.minecraft.client.resources.FallbackResourceManager;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={SimpleReloadableResourceManager.class})
public class SRRRMMixin {
    @Shadow
    @Final
    private Map<String, FallbackResourceManager> Field212;

    @Inject(method={"getResource"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method298(ResourceLocation location, CallbackInfoReturnable cir) {
        if (location.getResourceDomain().equals("pyro")) {
            cir.Method521(this.Field212.get("minecraft").getResource(location));
        }
    }
}

