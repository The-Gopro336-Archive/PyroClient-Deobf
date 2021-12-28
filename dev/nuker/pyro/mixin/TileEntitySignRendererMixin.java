/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.tileentity.TileEntitySignRenderer
 *  net.minecraft.util.text.ITextComponent
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={TileEntitySignRenderer.class})
public class TileEntitySignRendererMixin {
    @Redirect(method={"render"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/util/text/ITextComponent;getFormattedText()Ljava/lang/String;"))
    private String Method1729(ITextComponent iTextComponent) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method275().Method7979()).booleanValue()) {
            return "";
        }
        return iTextComponent.getFormattedText();
    }
}

