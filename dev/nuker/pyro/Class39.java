/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.crash.ICrashReportDetail
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class60;
import net.minecraft.crash.ICrashReportDetail;

public class Class39
implements ICrashReportDetail {
    public Class60 Field4587;

    public Object call() {
        return this.Method6417();
    }

    public Class39(Class60 class60) {
        this.Field4587 = class60;
    }

    public String Method6417() {
        return Class60.Method6522(this.Field4587).size() + " total; " + Class60.Method6522(this.Field4587);
    }
}

