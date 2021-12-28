/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.crash.ICrashReportDetail
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class60;
import net.minecraft.crash.ICrashReportDetail;

public class Class59
implements ICrashReportDetail {
    public Class60 Field4480;

    public String Method6417() {
        return Class60.Method6520(this.Field4480).getIntegratedServer() == null ? "Non-integrated multiplayer server" : "Integrated singleplayer server";
    }

    public Class59(Class60 class60) {
        this.Field4480 = class60;
    }

    public Object call() {
        return this.Method6417();
    }
}

