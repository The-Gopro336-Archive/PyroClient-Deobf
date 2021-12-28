/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  baritone.api.BaritoneAPI
 *  net.minecraft.client.gui.GuiScreen
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro;

import baritone.api.BaritoneAPI;
import dev.nuker.pyro.Class13;
import dev.nuker.pyro.Class29;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f03;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f45;
import dev.nuker.pyro.f46;
import dev.nuker.pyro.f4O;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.JvmField;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Class14
extends fdZ {
    public boolean Field3026 = true;
    @Nullable
    public f4O Field3027;
    @JvmField
    @NotNull
    public static Class14 Field3028;
    public static Class13 Field3029;

    @f0g
    @LauncherEventHide
    public void Method4916(@NotNull f46 f462) {
        if (f462.Method5604()) {
            Class34.Field4599.Method6752(Mouse.getEventButton());
        }
    }

    @Nullable
    public f4O Method4917() {
        return this.Field3027;
    }

    public void Method455() {
        Pyro.Method8978().Method7915(this);
    }

    @f0g
    @LauncherEventHide
    public void Method4918(@NotNull f45 f452) {
        if (f452.Method5600() && fdZ.Field313.currentScreen == null) {
            int n = Keyboard.getEventKey();
            if (n == Pyro.Field6180.getKeyCode()) {
                if (this.Field3027 == null) {
                    this.Field3027 = new f4O();
                }
                fdZ.Field313.displayGuiScreen((GuiScreen)this.Field3027);
            } else {
                Class29.Field3216.Method7300().Method2680(n);
                Class34.Field4599.Method6757(n);
            }
            if (n == fdZ.Field313.gameSettings.keyBindSneak.getKeyCode()) {
                if (PyroStatic.Field6425.Method4876() && ((Boolean)PyroStatic.Field6425.Method276().Method7979()).booleanValue()) {
                    if (BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing() && !((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue()) {
                        BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
                    }
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    @f0g
    @LauncherEventHide
    public void Method493(@NotNull f4e var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 63[UNCONDITIONALDOLOOP]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public void Method4919(@Nullable f4O f4O2) {
        this.Field3027 = f4O2;
    }

    static {
        Field3029 = new Class13(null);
        Field3028 = new Class14();
    }

    @f0g
    @LauncherEventHide
    public void Method840(@NotNull f43 f432) {
        if (fdZ.Field313.getCurrentServerData() == null) {
            if (fdZ.Field313.getIntegratedServer() == null) {
                this.Field3026 = true;
            }
        }
        f0b.Field5568.Method7905();
        if (f432.Method5619() == f41.Pre) {
            f03.Field5394.Method7612();
        }
    }
}

