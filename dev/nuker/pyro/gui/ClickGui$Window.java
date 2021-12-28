/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.GlStateManager
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.Class57;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f16;
import dev.nuker.pyro.f17;
import dev.nuker.pyro.gui.ClickGui;
import dev.nuker.pyro.gui.ClickGui$AbstractWindow;
import dev.nuker.pyro.gui.ClickGui$Window$Module;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002:\u0001EB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\u0002\u0010\u000bJ^\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020\n2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006J\u0018\u00100\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u00101\u001a\u00020\u0018J\u0010\u0010#\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0018H\u0016J\u0018\u00104\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007J\u0016\u00108\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0018H\u0016J\u0010\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020(H\u0016J\u0018\u0010A\u001a\u00020(2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0016J\u0016\u0010B\u001a\u00020(2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007J\u0018\u0010C\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010D\u001a\u00020(R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\f\u0018\u00010\u0012R\u00060\u0000R\u00020\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n0\u0012R\u00060\u0000R\u00020\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016\u00a8\u0006F"}, d2={"Ldev/nuker/pyro/gui/ClickGui$Window;", "Ldev/nuker/pyro/gui/ClickGui$AbstractWindow;", "Ldev/nuker/pyro/gui/ClickGui;", "name", "", "x", "Ldev/nuker/pyro/api/AbstractHandledValue;", "", "y", "expanded", "", "(Ldev/nuker/pyro/gui/ClickGui;Ljava/lang/String;Ldev/nuker/pyro/api/AbstractHandledValue;Ldev/nuker/pyro/api/AbstractHandledValue;Ldev/nuker/pyro/api/AbstractHandledValue;)V", "captureEvents", "getCaptureEvents", "()Z", "setCaptureEvents", "(Z)V", "capturingModule", "Ldev/nuker/pyro/gui/ClickGui$Window$Module;", "getExpanded", "()Ldev/nuker/pyro/api/AbstractHandledValue;", "setExpanded", "(Ldev/nuker/pyro/api/AbstractHandledValue;)V", "height_", "", "getHeight_", "()I", "setHeight_", "(I)V", "modules", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getX", "setX", "getY", "setY", "addModule", "", "module", "enabled", "controls", "Ldev/nuker/pyro/api/ui/control/UiControl;", "handler", "Ljava/util/function/Consumer;", "hotkey", "contains", "getHeight", "width", "height", "headerContains", "isCapturing", "mouseX", "mouseY", "isOnTop", "keyTyped", "typedChar", "", "keyCode", "mouseEvent", "event", "Ldev/nuker/pyro/api/ui/mouse/MouseEvent;", "onClickedElsewhere", "render", "renderCapture", "setPosition", "updateModulePositions", "Module", "pyroclient"})
public final class ClickGui$Window
extends ClickGui$AbstractWindow {
    private int Field7610;
    private List<ClickGui$Window$Module> Field7611;
    private ClickGui$Window$Module Field7612;
    private boolean Field7613;
    @NotNull
    private String Field7614;
    @NotNull
    private Class57<Double> Field7615;
    @NotNull
    private Class57<Double> Field7616;
    @NotNull
    private Class57<Boolean> Field7617;
    final /* synthetic */ ClickGui Field7618;

    public final int Method12540() {
        return this.Field7610;
    }

    public final void Method12541(int n) {
        this.Field7610 = n;
    }

    public final boolean Method12542() {
        return this.Field7613;
    }

    public final void Method12543(boolean bl) {
        this.Field7613 = bl;
    }

    @Override
    public boolean Method5928(double x, double y) {
        return this.Method5927(x, y) && y <= ((Number)this.Field7616.Method5264()).doubleValue() + (double)this.Field7618.Method3978();
    }

    public final boolean Method12544(double mouseX, double mouseY) {
        for (ClickGui$Window$Module module : this.Field7611) {
            Object object = module.Method11340().Method5264();
            Intrinsics.Method6561(object, "module.y.value");
            if (!module.Method11364(mouseX, mouseY - ((Number)object).doubleValue())) continue;
            this.Field7612 = module;
            this.Field7613 = module.Method11350();
            return true;
        }
        this.Field7612 = null;
        this.Field7613 = false;
        return false;
    }

    public final void Method12545(double mouseX, double mouseY) {
        if (this.Field7612 != null) {
            GlStateManager.pushMatrix();
            Object object = this.Field7615.Method5264();
            Intrinsics.Method6561(object, "x.value");
            double d = ((Number)object).doubleValue();
            double d2 = ((Number)this.Field7616.Method5264()).doubleValue();
            ClickGui$Window$Module clickGui$Window$Module = this.Field7612;
            if (clickGui$Window$Module == null) {
                Intrinsics.Method6551();
            }
            Object object2 = clickGui$Window$Module.Method11340().Method5264();
            Intrinsics.Method6561(object2, "capturingModule!!.y.value");
            GlStateManager.translate((double)d, (double)(d2 + ((Number)object2).doubleValue()), (double)0.0);
            ClickGui$Window$Module clickGui$Window$Module2 = this.Field7612;
            if (clickGui$Window$Module2 == null) {
                Intrinsics.Method6551();
            }
            ClickGui$Window$Module clickGui$Window$Module3 = this.Field7612;
            if (clickGui$Window$Module3 == null) {
                Intrinsics.Method6551();
            }
            Object object3 = clickGui$Window$Module3.Method11340().Method5264();
            Intrinsics.Method6561(object3, "capturingModule!!.y.value");
            clickGui$Window$Module2.Method11354(mouseX, mouseY - ((Number)object3).doubleValue());
            GlStateManager.popMatrix();
        }
    }

    @Override
    public double Method5929(int width) {
        Object object = this.Field7615.Method5264();
        Intrinsics.Method6561(object, "x.value");
        return ((Number)object).doubleValue();
    }

    @Override
    public double Method5930(int height) {
        Object object = this.Field7616.Method5264();
        Intrinsics.Method6561(object, "y.value");
        return ((Number)object).doubleValue();
    }

    @Override
    public void Method5931(double x, double y) {
        this.Field7615.Method5266((Object)x);
        this.Field7616.Method5266((Object)y);
    }

    public final int Method12546() {
        Object object = this.Field7617.Method5264();
        Intrinsics.Method6561(object, "expanded.value");
        return (Boolean)object != false ? this.Field7610 + 1 : this.Field7618.Method3978();
    }

    public final boolean Method12547(double x, double y) {
        return this.Field7618.Method4001((((Number)this.Field7615.Method5264()).doubleValue() + x) * ClickGui.Field2428.Method8965(), (((Number)this.Field7616.Method5264()).doubleValue() + y) * ClickGui.Field2428.Method8965()) == this;
    }

    @Override
    public void Method5934(char typedChar, int keyCode) {
        for (ClickGui$Window$Module module : this.Field7611) {
            module.Method11352(typedChar, keyCode);
        }
    }

    @Override
    public void Method5935(double mouseX, double mouseY) {
        int n = ClickGui.Method4004(this.Field7618).getStringWidth(this.Field7614);
        ClickGui.Field2428.Method8969();
        this.Field7618.Method4003(n + f0H.Field5476 * 2);
        GlStateManager.pushMatrix();
        Object object = this.Field7615.Method5264();
        Intrinsics.Method6561(object, "x.value");
        double d = ((Number)object).doubleValue();
        Object object2 = this.Field7616.Method5264();
        Intrinsics.Method6561(object2, "y.value");
        GlStateManager.translate((double)d, (double)((Number)object2).doubleValue(), (double)0.0);
        f0J.Method7778(0, 0, this.Field7618.Method3988(), this.Method12546() + 1, ClickGui.Field2428.Method8969().Method7704(), ClickGui.Field2428.Method8969().Method7719(), 1);
        FontRenderer fontRenderer = ClickGui.Method4004(this.Field7618);
        Intrinsics.Method6561((Object)fontRenderer, "fontRenderer");
        int n2 = this.Field7618.Method3988();
        int n3 = this.Field7618.Method3978();
        ClickGui.Field2428.Method8969();
        ClickGui.Field2428.Method8969();
        f0J.Method7775(f0J.Field5485, fontRenderer, this.Field7614, 0, 0, n2, n3, f0H.Field5477, f0H.Field5476, ClickGui.Field2428.Method8969().Method7708(), false, 512, null);
        Object object3 = this.Field7617.Method5264();
        Intrinsics.Method6561(object3, "expanded.value");
        if (((Boolean)object3).booleanValue()) {
            Gui.drawRect((int)0, (int)this.Field7618.Method3978(), (int)this.Field7618.Method3988(), (int)(this.Field7618.Method3978() + 1), (int)ClickGui.Field2428.Method8969().Method7719());
            for (ClickGui$Window$Module module : this.Field7611) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((double)0.0, (double)((Number)module.Method11340().Method5264()).intValue(), (double)0.0);
                Object object4 = module.Method11340().Method5264();
                Intrinsics.Method6561(object4, "module.y.value");
                module.Method11353(mouseX, mouseY - ((Number)object4).doubleValue());
                GlStateManager.popMatrix();
            }
        }
        GlStateManager.popMatrix();
    }

    public final void Method12548(@Nullable String module, boolean enabled, @NotNull List controls, @NotNull Consumer handler, @NotNull Class57 hotkey, @NotNull Class57 expanded, @NotNull Class57 y) {
        Intrinsics.Method6567(controls, "controls");
        Intrinsics.Method6567(handler, "handler");
        Intrinsics.Method6567(hotkey, "hotkey");
        Intrinsics.Method6567(expanded, "expanded");
        Intrinsics.Method6567(y, "y");
        String string = module;
        if (string == null) {
            Intrinsics.Method6551();
        }
        ClickGui$Window$Module module1 = new ClickGui$Window$Module(this, string, controls, handler, hotkey, expanded, y);
        module1.Method11335(enabled);
        this.Field7611.add(module1);
        this.Method12549();
    }

    public final void Method12549() {
        this.Field7610 = this.Field7618.Method3978();
        for (ClickGui$Window$Module module : this.Field7611) {
            module.Method11340().Method5266(this.Field7610 + 1);
            this.Field7610 += module.Method11360();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean Method5927(double x, double y) {
        Object object = this.Field7615.Method5264();
        Intrinsics.Method6561(object, "this.x.value");
        if (!(x >= ((Number)object).doubleValue())) return false;
        Object object2 = this.Field7616.Method5264();
        Intrinsics.Method6561(object2, "this.y.value");
        if (!(y >= ((Number)object2).doubleValue())) return false;
        if (!(x <= ((Number)this.Field7615.Method5264()).doubleValue() + (double)this.Field7618.Method3988())) return false;
        if (!(y <= ((Number)this.Field7616.Method5264()).doubleValue() + (double)this.Method12546())) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void Method5932(@NotNull f17 event) {
        block25: {
            block26: {
                block23: {
                    block24: {
                        Intrinsics.Method6567(event, "event");
                        if (!(event instanceof f16)) break block23;
                        if (!(((f16)event).Method7879() > (double)this.Field7618.Method3978())) return;
                        v0 = this.Field7617.Method5264();
                        Intrinsics.Method6561(v0, "expanded.value");
                        if (!((Boolean)v0).booleanValue()) break block24;
                        if (this.Field7612 == null || !this.Field7613) ** GOTO lbl-1000
                        v1 = this.Field7612;
                        if (v1 == null) {
                            Intrinsics.Method6551();
                        }
                        v2 = ((f16)event).Method7875();
                        v3 = ((f16)event).Method7879();
                        v4 = this.Field7612;
                        if (v4 == null) {
                            Intrinsics.Method6551();
                        }
                        v5 = v4.Method11340().Method5264();
                        Intrinsics.Method6561(v5, "capturingModule!!.y.value");
                        if (v1.Method11364(v2, v3 - ((Number)v5).doubleValue())) {
                            v6 = this.Field7612;
                            if (v6 == null) {
                                Intrinsics.Method6551();
                            }
                            v7 = this.Field7612;
                            if (v7 == null) {
                                Intrinsics.Method6551();
                            }
                            v6.Method11355(event.Method7865(0.0, ((Number)v7.Method11340().Method5264()).intValue()));
                        } else lbl-1000:
                        // 3 sources

                        {
                            for (ClickGui$Window$Module module : this.Field7611) {
                                if (!module.Method11361(((f16)event).Method7879())) continue;
                                module.Method11355(event.Method7865(0.0, ((Number)module.Method11340().Method5264()).intValue()));
                                return;
                            }
                        }
                        this.Method12549();
                    }
                    var3_2 = this.Field7611.iterator();
                    while (var3_2.hasNext() != false) {
                        module = var3_2.next();
                        module.Method11363();
                    }
                    return;
                }
                if (!(event instanceof f15)) break block25;
                if (!(((f15)event).Method7875() > (double)this.Field7618.Method3978())) return;
                v8 = this.Field7617.Method5264();
                Intrinsics.Method6561(v8, "expanded.value");
                if (!((Boolean)v8).booleanValue()) break block26;
                if (this.Field7612 == null || !this.Field7613) ** GOTO lbl-1000
                v9 = this.Field7612;
                if (v9 == null) {
                    Intrinsics.Method6551();
                }
                v10 = ((f15)event).Method7881();
                v11 = ((f15)event).Method7875();
                v12 = this.Field7612;
                if (v12 == null) {
                    Intrinsics.Method6551();
                }
                v13 = v12.Method11340().Method5264();
                Intrinsics.Method6561(v13, "capturingModule!!.y.value");
                if (v9.Method11364(v10, v11 - ((Number)v13).doubleValue())) {
                    v14 = this.Field7612;
                    if (v14 == null) {
                        Intrinsics.Method6551();
                    }
                    v15 = this.Field7612;
                    if (v15 == null) {
                        Intrinsics.Method6551();
                    }
                    v14.Method11355(event.Method7865(0.0, ((Number)v15.Method11340().Method5264()).intValue()));
                } else lbl-1000:
                // 3 sources

                {
                    for (ClickGui$Window$Module module : this.Field7611) {
                        if (!module.Method11361(((f15)event).Method7875())) continue;
                        module.Method11355(event.Method7865(0.0, ((Number)module.Method11340().Method5264()).intValue()));
                        return;
                    }
                }
                this.Method12549();
            }
            var3_3 = this.Field7611.iterator();
            while (var3_3.hasNext() != false) {
                module = var3_3.next();
                module.Method11363();
            }
            return;
        }
        if (event.Method7896() <= (double)this.Field7618.Method3978()) {
            if (event.Method7895() != 1) return;
            if (event instanceof f14 == false) return;
            this.Field7617.Method5266((Object)((Boolean)this.Field7617.Method5264() == false));
            return;
        }
        v16 = this.Field7617.Method5264();
        Intrinsics.Method6561(v16, "expanded.value");
        if ((Boolean)v16 == false) return;
        if (this.Field7612 != null && this.Field7613) {
            v17 = this.Field7612;
            if (v17 == null) {
                Intrinsics.Method6551();
            }
            v18 = this.Field7612;
            if (v18 == null) {
                Intrinsics.Method6551();
            }
            v17.Method11355(event.Method7865(0.0, ((Number)v18.Method11340().Method5264()).intValue()));
            return;
        }
        var3_4 = this.Field7611.iterator();
        while (true) {
            if (!var3_4.hasNext()) {
                this.Method12549();
                return;
            }
            module = var3_4.next();
            if (module.Method11361(event.Method7896())) {
                module.Method11355(event.Method7865(0.0, ((Number)module.Method11340().Method5264()).intValue()));
                return;
            }
            module.Method11363();
        }
    }

    @Override
    public void Method5933() {
        for (ClickGui$Window$Module module : this.Field7611) {
            module.Method11363();
        }
    }

    @NotNull
    protected final String Method12550() {
        return this.Field7614;
    }

    protected final void Method12551(@NotNull String string) {
        Intrinsics.Method6567(string, "<set-?>");
        this.Field7614 = string;
    }

    @NotNull
    public final Class57 Method12552() {
        return this.Field7615;
    }

    public final void Method12553(@NotNull Class57 class57) {
        Intrinsics.Method6567(class57, "<set-?>");
        this.Field7615 = class57;
    }

    @NotNull
    public final Class57 Method12554() {
        return this.Field7616;
    }

    public final void Method12555(@NotNull Class57 class57) {
        Intrinsics.Method6567(class57, "<set-?>");
        this.Field7616 = class57;
    }

    @NotNull
    protected final Class57 Method12556() {
        return this.Field7617;
    }

    protected final void Method12557(@NotNull Class57 class57) {
        Intrinsics.Method6567(class57, "<set-?>");
        this.Field7617 = class57;
    }

    public ClickGui$Window(@NotNull ClickGui $outer, @NotNull String name, @NotNull Class57 x, @NotNull Class57 y, Class57 expanded) {
        Intrinsics.Method6567(name, "name");
        Intrinsics.Method6567(x, "x");
        Intrinsics.Method6567(y, "y");
        Intrinsics.Method6567(expanded, "expanded");
        this.Field7618 = $outer;
        super($outer);
        this.Field7614 = name;
        this.Field7615 = x;
        this.Field7616 = y;
        this.Field7617 = expanded;
        this.Field7610 = $outer.Method3978();
        this.Field7611 = new ArrayList();
    }
}

