/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.crash.ICrashReportDetail
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class60;
import net.minecraft.crash.ICrashReportDetail;

public class Class40
implements ICrashReportDetail {
    public Class60 Field4654;

    public String Method6417() {
        return Class60.Method6520((Class60)this.Field4654).player.getServerBrand();
    }

    public Object call() {
        return this.Method6417();
    }

    public Class40(Class60 class60) {
        this.Field4654 = class60;
    }
}

