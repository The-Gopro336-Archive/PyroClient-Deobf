/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.crash.ICrashReportDetail
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class60;
import net.minecraft.crash.ICrashReportDetail;

public class Class42
implements ICrashReportDetail {
    public Class60 Field4627;

    public Object call() {
        return this.Method6417();
    }

    public String Method6417() {
        return Class60.Method6530(this.Field4627).size() + " total; " + Class60.Method6530(this.Field4627);
    }

    public Class42(Class60 class60) {
        this.Field4627 = class60;
    }
}

