/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiYesNo
 *  net.minecraft.client.main.GameConfiguration
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f45;
import dev.nuker.pyro.f46;
import dev.nuker.pyro.f4k;
import dev.nuker.pyro.f83;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Minecraft.class})
public class MinecraftMixin {
    @Shadow
    public EntityPlayerSP Field3164;

    @Shadow
    private void Method5072() {
    }

    @Inject(method={"<init>"}, at={@Class0(value="RETURN")})
    private void Method5073(GameConfiguration gameConfig, CallbackInfo ci) {
    }

    @Inject(method={"runGameLoop"}, at={@Class0(value="HEAD")})
    private void Method5074(CallbackInfo ci) {
        f0b.Field5568.Method7906();
    }

    @Inject(method={"setServerData"}, at={@Class0(value="HEAD")})
    public void Method5075(ServerData serverDataIn, CallbackInfo info) {
        if (serverDataIn != null) {
            f83.Field3315 = serverDataIn;
        }
    }

    @Inject(method={"rightClickMouse"}, at={@Class0(value="HEAD")})
    private void Method5076(CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6522.Field5236.Method5264()).booleanValue()) {
            PyroStatic.Field6522.Method5028();
        }
    }

    @Inject(method={"rightClickMouse"}, at={@Class0(value="RETURN")})
    private void Method5077(CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6522.Field5236.Method5264()).booleanValue()) {
            PyroStatic.Field6522.Method2616();
        }
    }

    @Inject(method={"sendClickBlockToController"}, at={@Class0(value="HEAD")})
    private void Method5078(boolean leftClick, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6522.Field5236.Method5264()).booleanValue()) {
            PyroStatic.Field6522.Method2491();
        }
    }

    @Inject(method={"sendClickBlockToController"}, at={@Class0(value="RETURN")})
    private void Method5079(boolean leftClick, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6522.Field5236.Method5264()).booleanValue()) {
            PyroStatic.Field6522.Method5384();
            if (leftClick) {
                this.Method5072();
            }
        }
    }

    @Redirect(method={"runGameLoop"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/Minecraft;shutdown()V"))
    private void Method5080(Minecraft minecraft) {
        if (minecraft.world != null && ((Boolean)PyroStatic.Field6414.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6414.Field3321.Method7979()).booleanValue()) {
            GuiScreen screen = minecraft.currentScreen;
            GuiYesNo g = new GuiYesNo((result, id) -> {
                if (result) {
                    minecraft.shutdown();
                } else {
                    Minecraft.getMinecraft().displayGuiScreen(screen);
                }
            }, "Do you really want to close minecraft?", "", 0);
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)g);
        } else {
            minecraft.shutdown();
        }
    }

    @Redirect(method={"clickMouse"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;clickBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)Z"))
    public boolean Method5081(PlayerControllerMP controllerMP, BlockPos pos, EnumFacing facing) {
        Pyro.Method8978().Method7918(new f4k(pos));
        return controllerMP.clickBlock(pos, facing);
    }

    @Inject(method={"runTickKeyboard"}, at={@Class0(value="INVOKE_ASSIGN", target="org/lwjgl/input/Keyboard.getEventKeyState()Z", remap=false)})
    private void Method5082(CallbackInfo callback) {
        Pyro.Method8978().Method7918(new f45(Keyboard.getEventKeyState()));
    }

    @Inject(method={"runTickMouse"}, at={@Class0(value="INVOKE_ASSIGN", target="Lorg/lwjgl/input/Mouse;getEventButton()I", remap=false)})
    private void Method5083(CallbackInfo callback) {
        Pyro.Method8978().Method7918(new f46(Mouse.getEventButtonState()));
    }

    @Inject(method={"runTick"}, at={@Class0(value="HEAD")})
    public void Method5084(CallbackInfo info) {
        Pyro.Method8978().Method7918(new f43(f41.Pre));
    }

    @Inject(method={"runTick"}, at={@Class0(value="RETURN")})
    public void Method5085(CallbackInfo info) {
        Pyro.Method8978().Method7918(new f43(f41.Post));
    }
}

