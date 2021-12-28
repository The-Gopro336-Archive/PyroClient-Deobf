/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro.gui;

import kotlin.Metadata;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Ldev/nuker/pyro/gui/ClickGui$OpenMode;", "", "(Ljava/lang/String;I)V", "MODULES", "OVERLAYS", "pyroclient"})
public final class ClickGui$OpenMode
extends Enum {
    public static final /* enum */ ClickGui$OpenMode MODULES;
    public static final /* enum */ ClickGui$OpenMode OVERLAYS;
    private static final /* synthetic */ ClickGui$OpenMode[] Field4118;

    static {
        ClickGui$OpenMode[] arrclickGui$OpenMode = new ClickGui$OpenMode[2];
        ClickGui$OpenMode[] arrclickGui$OpenMode2 = arrclickGui$OpenMode;
        arrclickGui$OpenMode[0] = MODULES = new ClickGui$OpenMode("MODULES", 0);
        arrclickGui$OpenMode[1] = OVERLAYS = new ClickGui$OpenMode("OVERLAYS", 1);
        Field4118 = arrclickGui$OpenMode;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ClickGui$OpenMode() {
        void $enum_name_or_ordinal$1;
        void $enum_name_or_ordinal$0;
    }

    public static ClickGui$OpenMode[] Method5756() {
        return (ClickGui$OpenMode[])Field4118.clone();
    }

    public static ClickGui$OpenMode Method5757(String string) {
        return Enum.valueOf(ClickGui$OpenMode.class, string);
    }
}

