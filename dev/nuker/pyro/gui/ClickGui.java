/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.settings.KeyBinding
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Class57;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0G;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f16;
import dev.nuker.pyro.f18;
import dev.nuker.pyro.f5j;
import dev.nuker.pyro.gui.ClickGui$AbstractWindow;
import dev.nuker.pyro.gui.ClickGui$Companion;
import dev.nuker.pyro.gui.ClickGui$OpenMode;
import dev.nuker.pyro.gui.ClickGui$WhenMappings;
import dev.nuker.pyro.gui.ClickGui$Window;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \\2\u00020\u0001:\u0004[\\]^B\u0005\u00a2\u0006\u0002\u0010\u0002JL\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0012\u0010@\u001a\u000e\u0012\n\u0012\b\u0018\u00010\fR\u00020\u00000A2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00190C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00190C2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0CJ\b\u0010F\u001a\u00020\nH\u0016J \u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020KH\u0016J\u001c\u0010L\u001a\b\u0018\u00010\u000eR\u00020\u00002\u0006\u0010B\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u0019J\b\u0010M\u001a\u00020=H\u0016J\u0018\u0010N\u001a\u00020=2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0004H\u0014J(\u0010R\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020UH\u0016J \u0010V\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0016J \u0010W\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0016J\u0006\u0010X\u001a\u00020=J\u0010\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020\u0004H\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010*\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00000+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u001a\u00103\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001a\u00106\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR$\u00109\u001a\f\u0012\b\u0012\u00060\u000eR\u00020\u00000+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/\u00a8\u0006_"}, d2={"Ldev/nuker/pyro/gui/ClickGui;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "SEGHEIGHT", "", "getSEGHEIGHT", "()I", "setSEGHEIGHT", "(I)V", "captureEvents", "", "capturingWindow", "Ldev/nuker/pyro/gui/ClickGui$Window;", "dragging", "Ldev/nuker/pyro/gui/ClickGui$AbstractWindow;", "getDragging", "()Ldev/nuker/pyro/gui/ClickGui$AbstractWindow;", "setDragging", "(Ldev/nuker/pyro/gui/ClickGui$AbstractWindow;)V", "invisibleOverlays", "getInvisibleOverlays", "()Z", "setInvisibleOverlays", "(Z)V", "lastX", "", "getLastX", "()D", "setLastX", "(D)V", "lastY", "getLastY", "setLastY", "mode", "Ldev/nuker/pyro/gui/ClickGui$OpenMode;", "getMode", "()Ldev/nuker/pyro/gui/ClickGui$OpenMode;", "setMode", "(Ldev/nuker/pyro/gui/ClickGui$OpenMode;)V", "moduleWidth", "getModuleWidth", "setModuleWidth", "moduleWindows", "", "getModuleWindows", "()Ljava/util/List;", "setModuleWindows", "(Ljava/util/List;)V", "startDragButton", "getStartDragButton", "setStartDragButton", "startDragX", "getStartDragX", "setStartDragX", "startDragY", "getStartDragY", "setStartDragY", "windows", "getWindows", "setWindows", "addWindow", "", "name", "", "processor", "Ljava/util/function/Consumer;", "x", "Ldev/nuker/pyro/api/AbstractHandledValue;", "y", "expanded", "doesGuiPauseGame", "drawScreen", "mouseX", "mouseY", "delta", "", "getTopWindow", "initGui", "keyTyped", "typedChar", "", "keyCode", "mouseClickMove", "button", "badmcp", "", "mouseClicked", "mouseReleased", "reloadWindowList", "requestModuleWidth", "width", "AbstractWindow", "Companion", "OpenMode", "Window", "pyroclient"})
public final class ClickGui
extends GuiScreen {
    @NotNull
    private ClickGui$OpenMode Field2411 = ClickGui$OpenMode.MODULES;
    private int Field2412;
    private boolean Field2413;
    @Nullable
    private ClickGui$AbstractWindow Field2414;
    @NotNull
    private List<ClickGui$Window> Field2415 = new ArrayList();
    @NotNull
    private List<ClickGui$AbstractWindow> Field2416 = new ArrayList();
    private int Field2417;
    private double Field2418 = Integer.MIN_VALUE;
    private double Field2419 = Integer.MIN_VALUE;
    private double Field2420 = -1.0;
    private double Field2421;
    private double Field2422;
    private ClickGui$Window Field2423;
    private boolean Field2424;
    private static double Field2425;
    private static double Field2426;
    @NotNull
    private static f0H Field2427;
    public static final ClickGui$Companion Field2428;

    @NotNull
    public final ClickGui$OpenMode Method3976() {
        return this.Field2411;
    }

    public final void Method3977(@NotNull ClickGui$OpenMode clickGui$OpenMode) {
        Intrinsics.Method6567((Object)clickGui$OpenMode, "<set-?>");
        this.Field2411 = clickGui$OpenMode;
    }

    public final int Method3978() {
        return this.Field2412;
    }

    public final void Method3979(int n) {
        this.Field2412 = n;
    }

    protected final boolean Method3980() {
        return this.Field2413;
    }

    protected final void Method3981(boolean bl) {
        this.Field2413 = bl;
    }

    @Nullable
    public final ClickGui$AbstractWindow Method3982() {
        return this.Field2414;
    }

    public final void Method3983(@Nullable ClickGui$AbstractWindow abstractWindow) {
        this.Field2414 = abstractWindow;
    }

    @NotNull
    public final List Method3984() {
        return this.Field2415;
    }

    public final void Method3985(@NotNull List list) {
        Intrinsics.Method6567(list, "<set-?>");
        this.Field2415 = list;
    }

    @NotNull
    public final List Method3986() {
        return this.Field2416;
    }

    public final void Method3987(@NotNull List list) {
        Intrinsics.Method6567(list, "<set-?>");
        this.Field2416 = list;
    }

    public final int Method3988() {
        return this.Field2417;
    }

    public final void Method3989(int n) {
        this.Field2417 = n;
    }

    public final double Method3990() {
        return this.Field2418;
    }

    public final void Method3991(double d) {
        this.Field2418 = d;
    }

    public final double Method3992() {
        return this.Field2419;
    }

    public final void Method3993(double d) {
        this.Field2419 = d;
    }

    public final double Method3994() {
        return this.Field2420;
    }

    public final void Method3995(double d) {
        this.Field2420 = d;
    }

    public final double Method3996() {
        return this.Field2421;
    }

    public final void Method3997(double d) {
        this.Field2421 = d;
    }

    public final double Method3998() {
        return this.Field2422;
    }

    public final void Method3999(double d) {
        this.Field2422 = d;
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public final void Method4000() {
        this.Field2416.clear();
        switch (ClickGui$WhenMappings.Field4716[this.Field2411.ordinal()]) {
            case 1: {
                this.Field2416.addAll((Collection<ClickGui$AbstractWindow>)this.Field2415);
            }
        }
    }

    protected void keyTyped(char typedChar, int keyCode) {
        int keyCode2 = keyCode;
        KeyBinding keyBinding = Pyro.Field6180;
        Intrinsics.Method6561((Object)keyBinding, "Pyro.KEY");
        if (keyCode2 == keyBinding.getKeyCode()) {
            keyCode2 = 1;
        }
        super.keyTyped(typedChar, keyCode2);
        if (keyCode2 != 1) {
            for (ClickGui$AbstractWindow window : this.Field2416) {
                window.Method5934(typedChar, keyCode2);
            }
        }
    }

    public void drawScreen(int mouseX, int mouseY, float delta) {
        super.drawScreen(mouseX, mouseY, delta);
        GlStateManager.pushMatrix();
        GlStateManager.scale((double)Field2425, (double)Field2425, (double)1.0);
        for (ClickGui$AbstractWindow clickGui$AbstractWindow : this.Field2416) {
            clickGui$AbstractWindow.Method5935((double)mouseX * Field2426 - clickGui$AbstractWindow.Method5929((int)((double)this.width * Field2426)), (double)mouseY * Field2426 - clickGui$AbstractWindow.Method5930((int)((double)this.height * Field2426)));
        }
        if (this.Field2411 == ClickGui$OpenMode.MODULES) {
            this.Field2423 = null;
            for (ClickGui$Window clickGui$Window : this.Field2415) {
                if (!clickGui$Window.Method12544((double)mouseX * Field2426 - clickGui$Window.Method5929((int)((double)this.width * Field2426)), (double)mouseY * Field2426 - clickGui$Window.Method5930((int)((double)this.height * Field2426)))) continue;
                this.Field2423 = clickGui$Window;
                this.Field2424 = clickGui$Window.Method12542();
                break;
            }
            if (this.Field2423 != null) {
                ClickGui$Window clickGui$Window = this.Field2423;
                if (clickGui$Window == null) {
                    Intrinsics.Method6551();
                }
                double d = (double)mouseX * Field2426;
                ClickGui$Window clickGui$Window2 = this.Field2423;
                if (clickGui$Window2 == null) {
                    Intrinsics.Method6551();
                }
                double d2 = d - clickGui$Window2.Method5929((int)((double)this.width * Field2426));
                double d3 = (double)mouseY * Field2426;
                ClickGui$Window clickGui$Window3 = this.Field2423;
                if (clickGui$Window3 == null) {
                    Intrinsics.Method6551();
                }
                clickGui$Window.Method12545(d2, d3 - clickGui$Window3.Method5930((int)((double)this.height * Field2426)));
            }
        }
        f0J.Method7778(0, this.height - 16, 64, 16, Field2427.Method7704(), Field2427.Method7719(), 1);
        FontRenderer fontRenderer = this.fontRenderer;
        Intrinsics.Method6561((Object)fontRenderer, "fontRenderer");
        f0J.Field5485.Method7774(fontRenderer, this.Field2411 == ClickGui$OpenMode.OVERLAYS ? "Modules" : "Overlays", 0, this.height - 16, 64, 16, f0G.CENTER, 0, Field2427.Method7708(), true);
        GlStateManager.popMatrix();
    }

    public void mouseClickMove(int mouseX, int mouseY, int button, long badmcp) {
        block17: {
            double deltaY;
            double deltaX;
            block18: {
                block19: {
                    block20: {
                        if (mouseX <= 64 && mouseY >= this.height - 16) break block17;
                        deltaX = (double)mouseX - this.Field2421;
                        deltaY = (double)mouseY - this.Field2422;
                        if (this.Field2418 != (double)Integer.MIN_VALUE || this.Field2419 != (double)Integer.MIN_VALUE || this.Field2414 != null) break block18;
                        this.Field2414 = this.Method4001(mouseX, mouseY);
                        if (this.Field2414 == null) break block19;
                        if (button != 0) break block20;
                        ClickGui$AbstractWindow clickGui$AbstractWindow = this.Field2414;
                        if (clickGui$AbstractWindow == null) {
                            Intrinsics.Method6551();
                        }
                        if (clickGui$AbstractWindow.Method5928((double)mouseX * Field2426, (double)mouseY * Field2426)) break block19;
                    }
                    this.Field2418 = mouseX;
                    this.Field2419 = mouseY;
                }
                this.Field2420 = button;
            }
            if ((double)button != this.Field2420) {
                this.Field2414 = null;
                this.Field2418 = Integer.MIN_VALUE;
                this.Field2419 = Integer.MIN_VALUE;
            }
            if (this.Field2418 != (double)Integer.MIN_VALUE && this.Field2419 != (double)Integer.MIN_VALUE) {
                ClickGui$AbstractWindow clickGui$AbstractWindow = this.Field2414;
                if (clickGui$AbstractWindow == null) {
                    Intrinsics.Method6551();
                }
                ClickGui$AbstractWindow clickGui$AbstractWindow2 = this.Field2414;
                if (clickGui$AbstractWindow2 == null) {
                    Intrinsics.Method6551();
                }
                double d = this.Field2418 * Field2426 - clickGui$AbstractWindow2.Method5929((int)((double)this.width * Field2426));
                ClickGui$AbstractWindow clickGui$AbstractWindow3 = this.Field2414;
                if (clickGui$AbstractWindow3 == null) {
                    Intrinsics.Method6551();
                }
                double d2 = this.Field2419 * Field2426 - clickGui$AbstractWindow3.Method5930((int)((double)this.height * Field2426));
                double d3 = (double)mouseX * Field2426;
                ClickGui$AbstractWindow clickGui$AbstractWindow4 = this.Field2414;
                if (clickGui$AbstractWindow4 == null) {
                    Intrinsics.Method6551();
                }
                double d4 = d3 - clickGui$AbstractWindow4.Method5929((int)((double)this.width * Field2426));
                double d5 = (double)mouseY * Field2426;
                ClickGui$AbstractWindow clickGui$AbstractWindow5 = this.Field2414;
                if (clickGui$AbstractWindow5 == null) {
                    Intrinsics.Method6551();
                }
                clickGui$AbstractWindow.Method5932(new f15(d, d2, d4, d5 - clickGui$AbstractWindow5.Method5930((int)((double)this.height * Field2426)), deltaX * Field2426, deltaY * Field2426, button));
            } else if (this.Field2414 != null) {
                ClickGui$AbstractWindow clickGui$AbstractWindow = this.Field2414;
                if (clickGui$AbstractWindow == null) {
                    Intrinsics.Method6551();
                }
                ClickGui$AbstractWindow clickGui$AbstractWindow6 = this.Field2414;
                if (clickGui$AbstractWindow6 == null) {
                    Intrinsics.Method6551();
                }
                double d = clickGui$AbstractWindow6.Method5929((int)((double)this.width * Field2426)) + deltaX * Field2426;
                ClickGui$AbstractWindow clickGui$AbstractWindow7 = this.Field2414;
                if (clickGui$AbstractWindow7 == null) {
                    Intrinsics.Method6551();
                }
                clickGui$AbstractWindow.Method5931(d, clickGui$AbstractWindow7.Method5930((int)((double)this.height * Field2426)) + deltaY * Field2426);
            }
            for (ClickGui$AbstractWindow window : this.Field2416) {
                if (window == this.Field2414) continue;
                window.Method5933();
            }
            this.Field2421 = mouseX;
            this.Field2422 = mouseY;
        }
    }

    public void mouseReleased(int mouseX, int mouseY, int button) {
        if (this.Field2418 != (double)Integer.MIN_VALUE && this.Field2419 != (double)Integer.MIN_VALUE) {
            ClickGui$AbstractWindow clickGui$AbstractWindow = this.Field2414;
            if (clickGui$AbstractWindow == null) {
                Intrinsics.Method6551();
            }
            ClickGui$AbstractWindow clickGui$AbstractWindow2 = this.Field2414;
            if (clickGui$AbstractWindow2 == null) {
                Intrinsics.Method6551();
            }
            double d = this.Field2418 * Field2426 - clickGui$AbstractWindow2.Method5929((int)((double)this.width * Field2426));
            ClickGui$AbstractWindow clickGui$AbstractWindow3 = this.Field2414;
            if (clickGui$AbstractWindow3 == null) {
                Intrinsics.Method6551();
            }
            double d2 = this.Field2419 * Field2426 - clickGui$AbstractWindow3.Method5930((int)((double)this.height * Field2426));
            double d3 = (double)mouseX * Field2426;
            ClickGui$AbstractWindow clickGui$AbstractWindow4 = this.Field2414;
            if (clickGui$AbstractWindow4 == null) {
                Intrinsics.Method6551();
            }
            double d4 = d3 - clickGui$AbstractWindow4.Method5929((int)((double)this.width * Field2426));
            double d5 = (double)mouseY * Field2426;
            ClickGui$AbstractWindow clickGui$AbstractWindow5 = this.Field2414;
            if (clickGui$AbstractWindow5 == null) {
                Intrinsics.Method6551();
            }
            clickGui$AbstractWindow.Method5932(new f16(d, d2, d4, d5 - clickGui$AbstractWindow5.Method5930((int)((double)this.height * Field2426)), button));
            this.Field2418 = Integer.MIN_VALUE;
            this.Field2419 = Integer.MIN_VALUE;
        } else {
            if (this.Field2414 == null) {
                this.Field2414 = this.Method4001(mouseX, mouseY);
            }
            if (this.Field2414 != null) {
                ClickGui$AbstractWindow clickGui$AbstractWindow = this.Field2414;
                if (clickGui$AbstractWindow == null) {
                    Intrinsics.Method6551();
                }
                double d = (double)mouseX * Field2426;
                ClickGui$AbstractWindow clickGui$AbstractWindow6 = this.Field2414;
                if (clickGui$AbstractWindow6 == null) {
                    Intrinsics.Method6551();
                }
                double d6 = d - clickGui$AbstractWindow6.Method5929((int)((double)this.width * Field2426));
                double d7 = (double)mouseY * Field2426;
                ClickGui$AbstractWindow clickGui$AbstractWindow7 = this.Field2414;
                if (clickGui$AbstractWindow7 == null) {
                    Intrinsics.Method6551();
                }
                clickGui$AbstractWindow.Method5932(new f18(d6, d7 - clickGui$AbstractWindow7.Method5930((int)((double)this.height * Field2426)), button));
            }
        }
        for (ClickGui$AbstractWindow window : this.Field2416) {
            if (window == this.Field2414) continue;
            window.Method5933();
        }
        this.Field2414 = null;
    }

    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (mouseX <= 64 && mouseY >= this.height - 16) {
            this.Field2411 = this.Field2411 == ClickGui$OpenMode.MODULES ? ClickGui$OpenMode.OVERLAYS : ClickGui$OpenMode.MODULES;
            this.Method4000();
            if (this.Field2411 == ClickGui$OpenMode.OVERLAYS) {
                this.mc.displayGuiScreen((GuiScreen)new f5j());
            }
            return;
        }
        ClickGui$AbstractWindow clicked = this.Method4001(mouseX, mouseY);
        if (clicked != null) {
            clicked.Method5932(new f14((double)mouseX * Field2426 - clicked.Method5929((int)((double)this.width * Field2426)), (double)mouseY * Field2426 - clicked.Method5930((int)((double)this.height * Field2426)), button));
            this.Field2416.remove(clicked);
            this.Field2416.add(clicked);
        }
        for (ClickGui$AbstractWindow window : this.Field2416) {
            if (window == clicked) continue;
            window.Method5933();
        }
        this.Field2421 = mouseX;
        this.Field2422 = mouseY;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final ClickGui$AbstractWindow Method4001(double x, double y) {
        if (this.Field2423 != null) {
            ClickGui$Window clickGui$Window = this.Field2423;
            if (clickGui$Window == null) {
                Intrinsics.Method6551();
            }
            if (clickGui$Window.Method12542()) {
                return this.Field2423;
            }
        }
        int n = ((Collection)this.Field2416).size();
        boolean bl = false;
        while (--n >= 0) {
            void i;
            ClickGui$AbstractWindow window = this.Field2416.get((int)i);
            if (window.Method5927(x * Field2426, y * Field2426)) {
                return window;
            }
            --i;
        }
        return null;
    }

    public void initGui() {
        super.initGui();
        this.Field2415.clear();
        this.Field2412 = this.fontRenderer.FONT_HEIGHT + f0H.Field5476 * 2;
        Class34.Field4599.Method6749(this);
    }

    public final void Method4002(@NotNull String name, @NotNull Consumer processor, @NotNull Class57 x, @NotNull Class57 y, @NotNull Class57 expanded) {
        Intrinsics.Method6567(name, "name");
        Intrinsics.Method6567(processor, "processor");
        Intrinsics.Method6567(x, "x");
        Intrinsics.Method6567(y, "y");
        Intrinsics.Method6567(expanded, "expanded");
        ClickGui$Window window = new ClickGui$Window(this, name, x, y, expanded);
        processor.accept(window);
        this.Field2415.add(window);
    }

    protected final void Method4003(int width) {
        if (width > this.Field2417) {
            this.Field2417 = width;
        }
    }

    static {
        Field2428 = new ClickGui$Companion(null);
        Field2425 = 1.0;
        Field2426 = 1.0 / Field2425;
        Field2427 = f0H.Field5479;
    }

    public static final /* synthetic */ FontRenderer Method4004(ClickGui $this) {
        return $this.fontRenderer;
    }

    public static final /* synthetic */ void Method4005(ClickGui $this, FontRenderer fontRenderer) {
        $this.fontRenderer = fontRenderer;
    }

    public static final /* synthetic */ double Method4006() {
        return Field2425;
    }

    public static final /* synthetic */ void Method4007(double d) {
        Field2425 = d;
    }

    public static final /* synthetic */ double Method4008() {
        return Field2426;
    }

    public static final /* synthetic */ void Method4009(double d) {
        Field2426 = d;
    }

    public static final /* synthetic */ f0H Method4010() {
        return Field2427;
    }

    public static final /* synthetic */ void Method4011(f0H f0H2) {
        Field2427 = f0H2;
    }
}

