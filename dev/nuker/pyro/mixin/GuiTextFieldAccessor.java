/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiTextField
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiTextField.class})
public interface GuiTextFieldAccessor {
    @Accessor(value="text")
    public void Method4366(String var1);
}

