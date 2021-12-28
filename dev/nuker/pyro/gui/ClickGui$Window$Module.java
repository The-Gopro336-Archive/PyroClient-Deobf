/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.Tuple
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro.gui;

import dev.nuker.pyro.Class57;
import dev.nuker.pyro.f0F;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f0S;
import dev.nuker.pyro.f13;
import dev.nuker.pyro.f14;
import dev.nuker.pyro.f15;
import dev.nuker.pyro.f16;
import dev.nuker.pyro.f17;
import dev.nuker.pyro.gui.ClickGui;
import dev.nuker.pyro.gui.ClickGui$Window;
import dev.nuker.pyro.gui.ClickGui$Window$Module$buildContexts$1;
import dev.nuker.pyro.gui.ClickGui$Window$Module$buildContexts$2;
import dev.nuker.pyro.gui.ClickGui$Window$Module$buildContexts$3;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.Tuple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\u000fJ\b\u00109\u001a\u00020:H\u0004J\u0011\u0010;\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020<H\u0086\u0002J>\u0010=\u001a \u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001b0>\u0012\u0004\u0012\u00020\f\u0018\u00010>2\u0006\u0010?\u001a\u00020<2\u0006\u0010\u000e\u001a\u00020<2\u0006\u0010@\u001a\u00020\tH\u0004J\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020\u0006J\u0016\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020<J\u0016\u0010G\u001a\u00020\t2\u0006\u0010?\u001a\u00020<2\u0006\u0010\u000e\u001a\u00020<J\u0016\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\fJ\u000e\u0010L\u001a\u00020:2\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020:J\u0016\u0010P\u001a\u00020:2\u0006\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020<J\u0016\u0010Q\u001a\u00020:2\u0006\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020<J\b\u0010R\u001a\u00020:H\u0004R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)\u00a8\u0006S"}, d2={"Ldev/nuker/pyro/gui/ClickGui$Window$Module;", "", "name", "", "controls", "", "Ldev/nuker/pyro/api/ui/control/UiControl;", "handler", "Ljava/util/function/Consumer;", "", "hotkey", "Ldev/nuker/pyro/api/AbstractHandledValue;", "", "expanded", "y", "(Ldev/nuker/pyro/gui/ClickGui$Window;Ljava/lang/String;Ljava/util/List;Ljava/util/function/Consumer;Ldev/nuker/pyro/api/AbstractHandledValue;Ldev/nuker/pyro/api/AbstractHandledValue;Ldev/nuker/pyro/api/AbstractHandledValue;)V", "captureEvents", "getCaptureEvents", "()Z", "setCaptureEvents", "(Z)V", "capturingControl", "getCapturingControl", "()Ldev/nuker/pyro/api/ui/control/UiControl;", "setCapturingControl", "(Ldev/nuker/pyro/api/ui/control/UiControl;)V", "contexts", "Ldev/nuker/pyro/api/ui/GuiContext;", "getContexts", "()Ljava/util/List;", "setContexts", "(Ljava/util/List;)V", "", "getControls", "setControls", "enabled", "getEnabled", "setEnabled", "getExpanded", "()Ldev/nuker/pyro/api/AbstractHandledValue;", "setExpanded", "(Ldev/nuker/pyro/api/AbstractHandledValue;)V", "getHandler", "()Ljava/util/function/Consumer;", "setHandler", "(Ljava/util/function/Consumer;)V", "height_", "getHeight_", "()I", "setHeight_", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getY", "setY", "buildContexts", "", "contains", "", "getControlAt", "Lnet/minecraft/util/Tuple;", "x", "captureCounts", "getHeight", "getYOfControl", "control", "isCapturing", "mouseX", "mouseY", "isOnTop", "keyTyped", "typedChar", "", "keyCode", "mouseEvent", "event", "Ldev/nuker/pyro/api/ui/mouse/MouseEvent;", "onClickedElsewhere", "render", "renderCapture", "updateControlSizes", "pyroclient"})
public final class ClickGui$Window$Module {
    private boolean Field6961;
    @NotNull
    private Class57<Boolean> Field6962;
    private int Field6963;
    @NotNull
    private Class57<Integer> Field6964;
    @NotNull
    private List<? extends f13> Field6965;
    @NotNull
    private List<f0F> Field6966;
    @NotNull
    private Consumer<Boolean> Field6967;
    @Nullable
    private f13 Field6968;
    private boolean Field6969;
    @NotNull
    private String Field6970;
    final /* synthetic */ ClickGui$Window Field6971;

    public final boolean Method11334() {
        return this.Field6961;
    }

    public final void Method11335(boolean bl) {
        this.Field6961 = bl;
    }

    @NotNull
    public final Class57 Method11336() {
        return this.Field6962;
    }

    public final void Method11337(@NotNull Class57 class57) {
        Intrinsics.Method6567(class57, "<set-?>");
        this.Field6962 = class57;
    }

    public final int Method11338() {
        return this.Field6963;
    }

    public final void Method11339(int n) {
        this.Field6963 = n;
    }

    @NotNull
    public final Class57 Method11340() {
        return this.Field6964;
    }

    public final void Method11341(@NotNull Class57 class57) {
        Intrinsics.Method6567(class57, "<set-?>");
        this.Field6964 = class57;
    }

    @NotNull
    public final List Method11342() {
        return this.Field6965;
    }

    public final void Method11343(@NotNull List list) {
        Intrinsics.Method6567(list, "<set-?>");
        this.Field6965 = list;
    }

    @NotNull
    protected final List Method11344() {
        return this.Field6966;
    }

    protected final void Method11345(@NotNull List list) {
        Intrinsics.Method6567(list, "<set-?>");
        this.Field6966 = list;
    }

    @NotNull
    protected final Consumer Method11346() {
        return this.Field6967;
    }

    protected final void Method11347(@NotNull Consumer consumer) {
        Intrinsics.Method6567(consumer, "<set-?>");
        this.Field6967 = consumer;
    }

    @Nullable
    protected final f13 Method11348() {
        return this.Field6968;
    }

    protected final void Method11349(@Nullable f13 f132) {
        this.Field6968 = f132;
    }

    public final boolean Method11350() {
        return this.Field6969;
    }

    public final void Method11351(boolean bl) {
        this.Field6969 = bl;
    }

    public final void Method11352(char typedChar, int keyCode) {
        for (f13 f132 : this.Field6965) {
            f132.Method7840(typedChar, keyCode);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void Method11353(double mouseX, double mouseY) {
        int n = ClickGui.Method4004(this.Field6971.Field7618).getStringWidth(this.Field6970);
        ClickGui.Field2428.Method8969();
        this.Field6971.Field7618.Method4003(n + f0H.Field5476 * 2);
        FontRenderer fontRenderer = ClickGui.Method4004(this.Field6971.Field7618);
        Intrinsics.Method6561((Object)fontRenderer, "fontRenderer");
        int n2 = this.Field6971.Field7618.Method3988() - 4;
        int n3 = this.Field6971.Field7618.Method3978();
        ClickGui.Field2428.Method8969();
        ClickGui.Field2428.Method8969();
        f0J.Method7775(f0J.Field5485, fontRenderer, this.Field6970, 0, 0, n2, n3, f0H.Field5477, f0H.Field5476, this.Field6961 ? ClickGui.Field2428.Method8969().Method7719() : ClickGui.Field2428.Method8969().Method7708(), false, 512, null);
        if (this.Method11362(mouseX, mouseY) && mouseY <= (double)this.Field6971.Field7618.Method3978() && mouseY >= 0.0) {
            Gui.drawRect((int)(this.Field6971.Field7618.Method3988() - 3), (int)1, (int)(this.Field6971.Field7618.Method3988() - 1), (int)(this.Field6971.Field7618.Method3978() - 1), (int)(this.Field6961 ? ClickGui.Field2428.Method8969().Method7702() : new Color(209, 35, 0).getRGB()));
        }
        Object object = this.Field6962.Method5264();
        Intrinsics.Method6561(object, "expanded.value");
        if (((Boolean)object).booleanValue()) {
            int y = this.Field6971.Field7618.Method3978();
            int n4 = 0;
            int n5 = ((Collection)this.Field6965).size();
            while (n4 < n5) {
                void i;
                f13 control = this.Field6965.get((int)i);
                f0F context = this.Field6966.get((int)i);
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)1.0f, (float)y, (float)0.0f);
                control.Method7819(context, mouseX, mouseY - (double)y, ClickGui.Field2428.Method8969());
                GlStateManager.popMatrix();
                y += context.Method7815();
                ++i;
            }
            Gui.drawRect((int)1, (int)this.Field6971.Field7618.Method3978(), (int)2, (int)y, (int)ClickGui.Field2428.Method8969().Method7719());
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void Method11354(double mouseX, double mouseY) {
        if (this.Field6968 != null) {
            int y = this.Field6971.Field7618.Method3978();
            int n = 0;
            int n2 = ((Collection)this.Field6965).size();
            while (n < n2) {
                void i;
                f13 control = this.Field6965.get((int)i);
                f0F context = this.Field6966.get((int)i);
                if (control == this.Field6968) {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((float)1.0f, (float)y, (float)0.0f);
                    control.Method7839(context, mouseX, mouseY - (double)y, ClickGui.Field2428.Method8969());
                    GlStateManager.popMatrix();
                    break;
                }
                y = y + context.Method7815();
                ++i;
            }
        }
    }

    public final void Method11355(@NotNull f17 event) {
        Intrinsics.Method6567(event, "event");
        if (event instanceof f16) {
            Tuple control;
            if (((f16)event).Method7879() > (double)this.Field6971.Field7618.Method3978() && (control = this.Method11356(((f16)event).Method7879(), ((f16)event).Method7879(), false)) != null) {
                if (this.Field6969) {
                    Object object = control.getFirst();
                    Intrinsics.Method6561(object, "control.first");
                    Object object2 = ((Tuple)object).getFirst();
                    if (object2 == null) {
                        Intrinsics.Method6551();
                    }
                    f13 f132 = (f13)object2;
                    Object object3 = control.getFirst();
                    Intrinsics.Method6561(object3, "control.first");
                    Object object4 = ((Tuple)object3).getSecond();
                    if (object4 == null) {
                        Intrinsics.Method6551();
                    }
                    f132.Method7842((f0F)object4, ClickGui.Field2428.Method8969(), event.Method7865(1.0, ((Number)control.getSecond()).intValue()));
                } else {
                    Object object = control.getFirst();
                    Intrinsics.Method6561(object, "control.first");
                    Object object5 = ((Tuple)object).getFirst();
                    if (object5 == null) {
                        Intrinsics.Method6551();
                    }
                    f13 f133 = (f13)object5;
                    Object object6 = control.getFirst();
                    Intrinsics.Method6561(object6, "control.first");
                    Object object7 = ((Tuple)object6).getSecond();
                    if (object7 == null) {
                        Intrinsics.Method6551();
                    }
                    f133.Method7818((f0F)object7, ClickGui.Field2428.Method8969(), event.Method7865(1.0, ((Number)control.getSecond()).intValue()));
                }
            }
        } else if (event instanceof f15) {
            Tuple control;
            if (((f15)event).Method7875() > (double)this.Field6971.Field7618.Method3978() && (control = this.Method11356(((f15)event).Method7881(), ((f15)event).Method7875(), false)) != null) {
                if (this.Field6969) {
                    Object object = control.getFirst();
                    Intrinsics.Method6561(object, "control.first");
                    Object object8 = ((Tuple)object).getFirst();
                    if (object8 == null) {
                        Intrinsics.Method6551();
                    }
                    f13 f134 = (f13)object8;
                    Object object9 = control.getFirst();
                    Intrinsics.Method6561(object9, "control.first");
                    Object object10 = ((Tuple)object9).getSecond();
                    if (object10 == null) {
                        Intrinsics.Method6551();
                    }
                    f134.Method7842((f0F)object10, ClickGui.Field2428.Method8969(), event.Method7865(1.0, ((Number)control.getSecond()).intValue()));
                } else {
                    Object object = control.getFirst();
                    Intrinsics.Method6561(object, "control.first");
                    Object object11 = ((Tuple)object).getFirst();
                    if (object11 == null) {
                        Intrinsics.Method6551();
                    }
                    f13 f135 = (f13)object11;
                    Object object12 = control.getFirst();
                    Intrinsics.Method6561(object12, "control.first");
                    Object object13 = ((Tuple)object12).getSecond();
                    if (object13 == null) {
                        Intrinsics.Method6551();
                    }
                    f135.Method7818((f0F)object13, ClickGui.Field2428.Method8969(), event.Method7865(1.0, ((Number)control.getSecond()).intValue()));
                }
            }
        } else if (event.Method7896() > 0.0 && event.Method7896() <= (double)this.Field6971.Field7618.Method3978()) {
            if (event instanceof f14) {
                if (event.Method7895() == 0) {
                    this.Field6961 = !this.Field6961;
                    this.Field6967.accept(this.Field6961);
                } else if (event.Method7895() == 1) {
                    this.Field6962.Method5266((Object)((Boolean)this.Field6962.Method5264() == false ? 1 : 0));
                    this.Method11359();
                }
            }
        } else {
            Tuple control = this.Method11356(0.0, event.Method7896(), true);
            if (control != null) {
                if (this.Field6969) {
                    Object object = control.getFirst();
                    Intrinsics.Method6561(object, "control.first");
                    Object object14 = ((Tuple)object).getFirst();
                    if (object14 == null) {
                        Intrinsics.Method6551();
                    }
                    f13 f136 = (f13)object14;
                    Object object15 = control.getFirst();
                    Intrinsics.Method6561(object15, "control.first");
                    Object object16 = ((Tuple)object15).getSecond();
                    if (object16 == null) {
                        Intrinsics.Method6551();
                    }
                    f136.Method7842((f0F)object16, ClickGui.Field2428.Method8969(), event.Method7865(1.0, ((Number)control.getSecond()).intValue()));
                } else {
                    Object object = control.getFirst();
                    Intrinsics.Method6561(object, "control.first");
                    Object object17 = ((Tuple)object).getFirst();
                    if (object17 == null) {
                        Intrinsics.Method6551();
                    }
                    f13 f137 = (f13)object17;
                    Object object18 = control.getFirst();
                    Intrinsics.Method6561(object18, "control.first");
                    Object object19 = ((Tuple)object18).getSecond();
                    if (object19 == null) {
                        Intrinsics.Method6551();
                    }
                    f137.Method7818((f0F)object19, ClickGui.Field2428.Method8969(), event.Method7865(1.0, ((Number)control.getSecond()).intValue()));
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    protected final Tuple Method11356(double x, double y, boolean captureCounts) {
        int n;
        int cy;
        block7: {
            if (this.Field6968 == null || !this.Field6969) break block7;
            cy = this.Field6971.Field7618.Method3978();
            f0F context = null;
            n = 0;
            int n2 = ((Collection)this.Field6965).size();
            while (n < n2) {
                void i;
                block8: {
                    block9: {
                        cy += this.Field6966.get((int)i).Method7815();
                        context = this.Field6966.get((int)i);
                        if (this.Field6965.get((int)i) != this.Field6968) break block8;
                        if (captureCounts) break block9;
                        f13 f132 = this.Field6968;
                        if (f132 == null) {
                            Intrinsics.Method6551();
                        }
                        if (!f132.Method7841(context, x, (double)cy - y, ClickGui.Field2428.Method8969())) break block8;
                    }
                    return new Tuple((Object)new Tuple((Object)this.Field6968, (Object)context), (Object)(cy - context.Method7815()));
                }
                ++i;
            }
        }
        cy = this.Field6971.Field7618.Method3978();
        int context = 0;
        n = ((Collection)this.Field6965).size();
        while (context < n) {
            void i;
            f0F context2 = this.Field6966.get((int)i);
            if (y <= (double)(cy += context2.Method7815())) {
                return new Tuple((Object)new Tuple((Object)this.Field6965.get((int)i), (Object)context2), (Object)(cy - context2.Method7815()));
            }
            ++i;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public final double Method11357(@NotNull f13 control) {
        Intrinsics.Method6567(control, "control");
        int y = this.Field6971.Field7618.Method3978();
        int n = 0;
        int n2 = ((Collection)this.Field6965).size();
        while (n < n2) {
            void i;
            if (this.Field6965.get((int)i) == control) {
                return y;
            }
            ++i;
        }
        return 0.0;
    }

    /*
     * WARNING - void declaration
     */
    protected final void Method11358() {
        this.Field6966.clear();
        int n = 0;
        int n2 = ((Collection)this.Field6965).size();
        while (n < n2) {
            void i;
            Supplier supplier = new ClickGui$Window$Module$buildContexts$1(this);
            Runnable runnable = new ClickGui$Window$Module$buildContexts$2(this);
            BiFunction biFunction = new ClickGui$Window$Module$buildContexts$3(this, (int)i);
            FontRenderer fontRenderer = ClickGui.Method4004(this.Field6971.Field7618);
            Intrinsics.Method6561((Object)fontRenderer, "fontRenderer");
            this.Field6966.add(new f0F(supplier, runnable, 0, biFunction, fontRenderer));
            ++i;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected final void Method11359() {
        this.Field6963 = this.Field6971.Field7618.Method3978();
        int n = 0;
        int n2 = ((Collection)this.Field6965).size();
        while (n < n2) {
            void i;
            f13 control = this.Field6965.get((int)i);
            f0F context = this.Field6966.get((int)i);
            int controlHeight = control.Method7817(context, ClickGui.Field2428.Method8969());
            context.Method7810(controlHeight);
            int controlWidth = control.Method7820(context, ClickGui.Field2428.Method8969());
            if (controlWidth > this.Field6971.Field7618.Method3988()) {
                this.Field6971.Field7618.Method3989(controlWidth);
            }
            this.Field6963 += controlHeight;
            ++i;
        }
        this.Field6971.Method12549();
    }

    public final int Method11360() {
        Object object = this.Field6962.Method5264();
        Intrinsics.Method6561(object, "expanded.value");
        return (Boolean)object != false ? this.Field6963 : this.Field6971.Field7618.Method3978();
    }

    public final boolean Method11361(double y) {
        Object object = this.Field6964.Method5264();
        Intrinsics.Method6561(object, "this.y.value");
        return Double.compare(y, ((Number)object).doubleValue()) >= 0 && y <= (double)(((Number)this.Field6964.Method5264()).intValue() + this.Method11360());
    }

    public final boolean Method11362(double x, double y) {
        return this.Field6971.Method12547(x, ((Number)this.Field6964.Method5264()).doubleValue() + y);
    }

    public final void Method11363() {
        for (f13 f132 : this.Field6965) {
            f132.Method7837();
        }
    }

    /*
     * WARNING - void declaration
     */
    public final boolean Method11364(double mouseX, double mouseY) {
        int y = this.Field6971.Field7618.Method3978();
        int n = 0;
        int n2 = ((Collection)this.Field6965).size();
        while (n < n2) {
            f0F context;
            void i;
            f13 control = this.Field6965.get((int)i);
            if (control.Method7838(context = this.Field6966.get((int)i), mouseX, mouseY - (double)y, ClickGui.Field2428.Method8969())) {
                this.Field6968 = control;
                this.Field6969 = control.Method7841(context, mouseX, mouseY - (double)y, ClickGui.Field2428.Method8969());
                return true;
            }
            y += context.Method7815();
            ++i;
        }
        this.Field6968 = null;
        this.Field6969 = false;
        return false;
    }

    @NotNull
    public final String Method11365() {
        return this.Field6970;
    }

    public final void Method11366(@NotNull String string) {
        Intrinsics.Method6567(string, "<set-?>");
        this.Field6970 = string;
    }

    public ClickGui$Window$Module(@NotNull ClickGui$Window $outer, @NotNull String name, @NotNull List controls, @NotNull Consumer handler, @NotNull Class57 hotkey, @NotNull Class57 expanded, Class57 y) {
        Intrinsics.Method6567(name, "name");
        Intrinsics.Method6567(controls, "controls");
        Intrinsics.Method6567(handler, "handler");
        Intrinsics.Method6567(hotkey, "hotkey");
        Intrinsics.Method6567(expanded, "expanded");
        Intrinsics.Method6567(y, "y");
        this.Field6971 = $outer;
        this.Field6970 = name;
        this.Field6963 = $outer.Field7618.Method3978();
        this.Field6965 = controls;
        this.Field6966 = new ArrayList();
        this.Field6967 = handler;
        this.Field6962 = expanded;
        this.Field6964 = y;
        controls.add(new f0S("Key", hotkey));
        this.Method11358();
        int n = ClickGui.Method4004($outer.Field7618).getStringWidth(this.Field6970);
        ClickGui.Field2428.Method8969();
        if (n + f0H.Field5476 * 2 > $outer.Field7618.Method3988()) {
            int n2 = ClickGui.Method4004($outer.Field7618).getStringWidth(this.Field6970);
            ClickGui.Field2428.Method8969();
            $outer.Field7618.Method3989(n2 + f0H.Field5476 * 2);
        }
        this.Method11359();
    }
}

